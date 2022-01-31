package com.tencent.mm.plugin.appbrand.jsapi.u.a;

import android.app.Activity;
import android.view.Window;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.y;

final class b$3
  implements Runnable
{
  b$3(b paramb) {}
  
  public final void run()
  {
    Object localObject2;
    Object localObject1;
    if (this.gHz.fLx != null)
    {
      localObject2 = null;
      if (!(this.gHz.fLx instanceof o)) {
        break label63;
      }
      localObject1 = ((o)this.gHz.fLx).F(Activity.class);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "stopKeepScreenOn");
        ((Activity)localObject1).getWindow().clearFlags(128);
      }
      return;
      label63:
      localObject1 = localObject2;
      if ((this.gHz.fLx instanceof q))
      {
        localObject1 = localObject2;
        if ((this.gHz.fLx.getContext() instanceof Activity)) {
          localObject1 = (Activity)this.gHz.fLx.getContext();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.b.3
 * JD-Core Version:    0.7.0.1
 */