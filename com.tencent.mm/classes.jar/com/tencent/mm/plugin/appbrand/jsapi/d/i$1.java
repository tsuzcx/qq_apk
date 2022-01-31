package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.graphics.Rect;
import android.view.View;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.input.aj;
import com.tencent.mm.plugin.appbrand.widget.input.c;
import com.tencent.mm.plugin.appbrand.widget.input.d.f;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.plugin.appbrand.widget.input.g;
import com.tencent.mm.plugin.appbrand.widget.input.j;
import com.tencent.mm.plugin.appbrand.widget.input.j.1;
import com.tencent.mm.plugin.appbrand.widget.input.j.a;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import com.tencent.mm.plugin.appbrand.widget.input.y;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.Locale;

final class i$1
  implements Runnable
{
  i$1(i parami, v paramv, int paramInt1, h paramh, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(123561);
    Object localObject1 = j.a.aQR();
    v localv = this.hEe;
    int i = this.hMH;
    Object localObject2 = this.hMR;
    localObject1 = com.tencent.mm.plugin.appbrand.widget.input.e.a(localv, new j.1((j)localObject1, i));
    if ((localObject1 instanceof c))
    {
      localObject1 = (c)localObject1;
      if (localObject1 == null) {
        break label201;
      }
      if (((h)localObject2).jqH != null) {
        ((c)localObject1).FN(((h)localObject2).jqH);
      }
      ((c)localObject1).a((h)localObject2);
      localObject2 = ((c)localObject1).aQt();
      if (localObject2 != null)
      {
        localv = (v)((c)localObject1).jkD.get();
        if ((localv != null) && (localv.iuy != null)) {
          break label150;
        }
      }
    }
    label112:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label206;
      }
      this.hEe.h(this.bAX, this.hMS.j("ok", null));
      AppMethodBeat.o(123561);
      return;
      localObject1 = null;
      break;
      g localg = (g)localv.aJk();
      if (localg == null) {
        break label112;
      }
      localObject1 = ((c)localObject1).aQu();
      localg.c(localv.iuy, (View)localObject2, ((Rect)localObject1).width(), ((Rect)localObject1).height(), ((Rect)localObject1).left, ((Rect)localObject1).top);
      break label112;
    }
    label150:
    label201:
    label206:
    localObject1 = o.a(this.hEe, this.hMH);
    if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.widget.input.i))
    {
      localObject1 = (com.tencent.mm.plugin.appbrand.widget.input.i)localObject1;
      localObject2 = this.hMR;
      if ((((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).jli == null) || (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).jll == null)) {}
      do
      {
        this.hEe.h(this.bAX, this.hMS.j("ok", null));
        AppMethodBeat.o(123561);
        return;
        ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).jli.a((f)localObject2);
      } while ((!((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).jli.jqF) && ((((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).jli.jqJ == null) || (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).jli.jqJ.intValue() <= 0)));
      ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).jll.setWillNotDraw(true);
      ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).aQJ();
      if (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).jli.jqH != null) {
        ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).jll.z(bo.nullAsNil(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).jli.jqH));
      }
      if (!aj.g(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).jli.jra)) {
        ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).b(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).jll, ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).jli);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).jll.setWillNotDraw(false);
        ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).jll.invalidate();
        break;
        localObject2 = new com.tencent.mm.plugin.appbrand.widget.input.i.1((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1);
        if (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).jll.getLayout() == null) {
          ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).jll.post((Runnable)localObject2);
        } else {
          ((Runnable)localObject2).run();
        }
      }
    }
    d.e("MicroMsg.AppBrand.JsApiUpdateInput", String.format(Locale.US, "AppBrandInputInvokeHandler with inputID(%d) 404", new Object[] { Integer.valueOf(this.hMH) }));
    this.hEe.h(this.bAX, this.hMS.j(String.format(Locale.US, "fail found no input with %d", new Object[] { Integer.valueOf(this.hMH) }), null));
    AppMethodBeat.o(123561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.i.1
 * JD-Core Version:    0.7.0.1
 */