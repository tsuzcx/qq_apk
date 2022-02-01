package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Locale;

final class i$1
  implements Runnable
{
  i$1(i parami, ac paramac, int paramInt1, h paramh, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(136291);
    Object localObject1 = j.a.cbp();
    ac localac = this.lIf;
    int i = this.lWD;
    Object localObject2 = this.lWO;
    localObject1 = com.tencent.mm.plugin.appbrand.widget.input.e.a(localac, new j.1((j)localObject1, i));
    if ((localObject1 instanceof c))
    {
      localObject1 = (c)localObject1;
      if (localObject1 == null) {
        break label201;
      }
      if (((h)localObject2).oxJ != null) {
        ((c)localObject1).afY(((h)localObject2).oxJ);
      }
      ((c)localObject1).a((h)localObject2);
      localObject2 = ((c)localObject1).caS();
      if (localObject2 != null)
      {
        localac = (ac)((c)localObject1).orG.get();
        if ((localac != null) && (localac.nmX != null)) {
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
      this.lIf.i(this.cvP, this.lWP.h("ok", null));
      AppMethodBeat.o(136291);
      return;
      localObject1 = null;
      break;
      g localg = (g)localac.bRe();
      if (localg == null) {
        break label112;
      }
      localObject1 = ((c)localObject1).caT();
      localg.c(localac.nmX, (View)localObject2, ((Rect)localObject1).width(), ((Rect)localObject1).height(), ((Rect)localObject1).left, ((Rect)localObject1).top);
      break label112;
    }
    label150:
    label201:
    label206:
    localObject1 = o.a(this.lIf, this.lWD);
    if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.widget.input.i))
    {
      localObject1 = (com.tencent.mm.plugin.appbrand.widget.input.i)localObject1;
      localObject2 = this.lWO;
      if ((((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).OrW == null) || (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).OrY == null)) {}
      do
      {
        this.lIf.i(this.cvP, this.lWP.h("ok", null));
        AppMethodBeat.o(136291);
        return;
        ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).OrW.a((f)localObject2);
      } while ((!((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).OrW.oxH) && ((((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).OrW.oxL == null) || (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).OrW.oxL.intValue() <= 0)));
      ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).OrY.setWillNotDraw(true);
      ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).cbh();
      if (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).OrW.oxJ != null) {
        ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).OrY.G(Util.nullAsNil(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).OrW.oxJ));
      }
      if (!aj.i(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).OrW.oyc)) {
        ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).b(((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).OrY, ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).OrW);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).OrY.setWillNotDraw(false);
        ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).OrY.invalidate();
        break;
        localObject2 = new com.tencent.mm.plugin.appbrand.widget.input.i.1((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1);
        if (((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).OrY.getLayout() == null) {
          ((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1).OrY.post((Runnable)localObject2);
        } else {
          ((Runnable)localObject2).run();
        }
      }
    }
    Log.e("MicroMsg.AppBrand.JsApiUpdateInput", String.format(Locale.US, "AppBrandInputInvokeHandler with inputID(%d) 404", new Object[] { Integer.valueOf(this.lWD) }));
    this.lIf.i(this.cvP, this.lWP.h(String.format(Locale.US, "fail found no input with %d", new Object[] { Integer.valueOf(this.lWD) }), null));
    AppMethodBeat.o(136291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h.i.1
 * JD-Core Version:    0.7.0.1
 */