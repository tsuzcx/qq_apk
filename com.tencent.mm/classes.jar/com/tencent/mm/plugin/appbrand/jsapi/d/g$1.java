package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.plugin.appbrand.widget.input.e;
import com.tencent.mm.plugin.appbrand.widget.input.i.1;
import com.tencent.mm.plugin.appbrand.widget.input.i.a;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import java.lang.ref.WeakReference;
import java.util.Locale;

final class g$1
  implements Runnable
{
  g$1(g paramg, q paramq, int paramInt1, h paramh, int paramInt2) {}
  
  public final void run()
  {
    Object localObject1 = i.a.arN();
    q localq = this.gkf;
    int i = this.grq;
    Object localObject2 = this.gry;
    localObject1 = e.a(localq, new i.1((com.tencent.mm.plugin.appbrand.widget.input.i)localObject1, i));
    if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.widget.input.c))
    {
      localObject1 = (com.tencent.mm.plugin.appbrand.widget.input.c)localObject1;
      if (localObject1 == null) {
        break label191;
      }
      if (((h)localObject2).hyx != null) {
        ((com.tencent.mm.plugin.appbrand.widget.input.c)localObject1).xa(((h)localObject2).hyx);
      }
      ((com.tencent.mm.plugin.appbrand.widget.input.c)localObject1).a((h)localObject2);
      localObject2 = ((com.tencent.mm.plugin.appbrand.widget.input.c)localObject1).arH();
      if (localObject2 != null)
      {
        localq = (q)((com.tencent.mm.plugin.appbrand.widget.input.c)localObject1).hsZ.get();
        if ((localq != null) && (localq.gTF != null)) {
          break label140;
        }
      }
    }
    label107:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label196;
      }
      this.gkf.C(this.dIS, this.grz.h("ok", null));
      return;
      localObject1 = null;
      break;
      com.tencent.mm.plugin.appbrand.widget.input.g localg = (com.tencent.mm.plugin.appbrand.widget.input.g)localq.agO();
      if (localg == null) {
        break label107;
      }
      localObject1 = ((com.tencent.mm.plugin.appbrand.widget.input.c)localObject1).arI();
      localg.b(localq.gTF, (View)localObject2, ((Rect)localObject1).width(), ((Rect)localObject1).height(), ((Rect)localObject1).left, ((Rect)localObject1).top);
      break label107;
    }
    label140:
    label191:
    label196:
    localObject1 = n.a(this.gkf, this.grq);
    if ((localObject1 instanceof AppBrandInputInvokeHandler))
    {
      ((AppBrandInputInvokeHandler)localObject1).updateInput(this.gry);
      this.gkf.C(this.dIS, this.grz.h("ok", null));
      return;
    }
    com.tencent.luggage.j.c.e("MicroMsg.AppBrand.JsApiUpdateInput", String.format(Locale.US, "AppBrandInputInvokeHandler with inputID(%d) 404", new Object[] { Integer.valueOf(this.grq) }));
    this.gkf.C(this.dIS, this.grz.h(String.format(Locale.US, "fail found no input with %d", new Object[] { Integer.valueOf(this.grq) }), null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.g.1
 * JD-Core Version:    0.7.0.1
 */