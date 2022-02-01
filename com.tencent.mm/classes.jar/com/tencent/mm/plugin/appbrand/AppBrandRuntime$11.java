package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.plugin.appbrand.r.a.c.b;

final class AppBrandRuntime$11
  implements Runnable
{
  AppBrandRuntime$11(AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void run()
  {
    AppMethodBeat.i(197171);
    final c localc = this.jxm.getWindowAndroid();
    if (localc == null)
    {
      AppMethodBeat.o(197171);
      return;
    }
    Object localObject = this.jxm.getAppConfig();
    if (localObject == null) {}
    int i;
    for (localObject = new c.b(this.jxm.Fi().doD);; localObject = new c.b(this.jxm.Fi().doD, null, i))
    {
      localc.setWindowDescription((c.b)localObject);
      b.aDV().a(new b.c()
      {
        public final void E(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(197170);
          localc.setWindowDescription(new c.b(this.jxr.label, paramAnonymousBitmap, this.jxr.colorPrimary));
          AppMethodBeat.o(197170);
        }
      }, this.jxm.Fi().iconUrl, com.tencent.mm.modelappbrand.a.g.hLC);
      AppMethodBeat.o(197171);
      return;
      i = com.tencent.mm.plugin.appbrand.z.g.cg(((a)localObject).bdJ().jVR, -16777216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.11
 * JD-Core Version:    0.7.0.1
 */