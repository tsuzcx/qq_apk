package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.aa;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.Locale;

final class i$1
  implements Runnable
{
  i$1(i parami, aa paramaa, int paramInt1, h paramh, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(136291);
    Object localObject1 = j.a.bEj();
    aa localaa = this.kAq;
    int i = this.kNZ;
    Object localObject2 = this.kOk;
    localObject1 = com.tencent.mm.plugin.appbrand.widget.input.e.a(localaa, new j.1((j)localObject1, i));
    if ((localObject1 instanceof c))
    {
      localObject1 = (c)localObject1;
      if (localObject1 == null) {
        break label201;
      }
      if (((h)localObject2).niV != null) {
        ((c)localObject1).Vq(((h)localObject2).niV);
      }
      ((c)localObject1).a((h)localObject2);
      localObject2 = ((c)localObject1).bDM();
      if (localObject2 != null)
      {
        localaa = (aa)((c)localObject1).ncQ.get();
        if ((localaa != null) && (localaa.lYc != null)) {
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
      this.kAq.h(this.cjQ, this.kOl.e("ok", null));
      AppMethodBeat.o(136291);
      return;
      localObject1 = null;
      break;
      g localg = (g)localaa.but();
      if (localg == null) {
        break label112;
      }
      localObject1 = ((c)localObject1).bDN();
      localg.c(localaa.lYc, (View)localObject2, ((Rect)localObject1).width(), ((Rect)localObject1).height(), ((Rect)localObject1).left, ((Rect)localObject1).top);
      break label112;
    }
    label150:
    label201:
    label206:
    localObject1 = o.a(this.kAq, this.kNZ);
    if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.widget.input.i))
    {
      localObject1 = (com.tencent.mm.plugin.appbrand.widget.input.i)localObject1;
      localObject2 = this.kOk;
      if ((((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).taa == null) || (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).tac == null)) {}
      do
      {
        this.kAq.h(this.cjQ, this.kOl.e("ok", null));
        AppMethodBeat.o(136291);
        return;
        ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).taa.a((f)localObject2);
      } while ((!((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).taa.niT) && ((((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).taa.niX == null) || (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).taa.niX.intValue() <= 0)));
      ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).tac.setWillNotDraw(true);
      ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).bbo();
      if (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).taa.niV != null) {
        ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).tac.D(bt.nullAsNil(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).taa.niV));
      }
      if (!aj.i(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).taa.njo)) {
        ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).b(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).tac, ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).taa);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).tac.setWillNotDraw(false);
        ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).tac.invalidate();
        break;
        localObject2 = new com.tencent.mm.plugin.appbrand.widget.input.i.1((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1);
        if (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).tac.getLayout() == null) {
          ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).tac.post((Runnable)localObject2);
        } else {
          ((Runnable)localObject2).run();
        }
      }
    }
    ad.e("MicroMsg.AppBrand.JsApiUpdateInput", String.format(Locale.US, "AppBrandInputInvokeHandler with inputID(%d) 404", new Object[] { Integer.valueOf(this.kNZ) }));
    this.kAq.h(this.cjQ, this.kOl.e(String.format(Locale.US, "fail found no input with %d", new Object[] { Integer.valueOf(this.kNZ) }), null));
    AppMethodBeat.o(136291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.i.1
 * JD-Core Version:    0.7.0.1
 */