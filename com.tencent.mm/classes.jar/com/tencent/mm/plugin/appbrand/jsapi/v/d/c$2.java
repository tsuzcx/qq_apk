package com.tencent.mm.plugin.appbrand.jsapi.v.d;

import android.app.Activity;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;

final class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(117373);
    Object localObject;
    if (this.iiU.iiC != null)
    {
      localObject = this.iiU.iiC.hrA;
      if (localObject != null)
      {
        if (!(localObject instanceof r)) {
          break label74;
        }
        localObject = ((r)localObject).X(Activity.class);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "startKeepScreenOn");
        ((Activity)localObject).getWindow().addFlags(128);
      }
      AppMethodBeat.o(117373);
      return;
      label74:
      if (((localObject instanceof v)) && ((((com.tencent.mm.plugin.appbrand.jsapi.c)localObject).getContext() instanceof Activity))) {
        localObject = (Activity)((com.tencent.mm.plugin.appbrand.jsapi.c)localObject).getContext();
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.d.c.2
 * JD-Core Version:    0.7.0.1
 */