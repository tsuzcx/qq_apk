package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.s.a.c;
import com.tencent.mm.plugin.appbrand.s.a.c.b;

final class AppBrandRuntime$13
  implements Runnable
{
  AppBrandRuntime$13(AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void run()
  {
    AppMethodBeat.i(134455);
    final c localc = this.iEc.getWindowAndroid();
    if (localc == null)
    {
      AppMethodBeat.o(134455);
      return;
    }
    Object localObject = this.iEc.getAppConfig();
    if (localObject == null) {}
    int i;
    for (localObject = new c.b(this.iEc.Eg().dfM);; localObject = new c.b(this.iEc.Eg().dfM, null, i))
    {
      localc.setWindowDescription((c.b)localObject);
      b.aub().a(new b.c()
      {
        public final void E(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(176496);
          localc.setWindowDescription(new c.b(this.iEi.label, paramAnonymousBitmap, this.iEi.colorPrimary));
          AppMethodBeat.o(176496);
        }
      }, this.iEc.Eg().iconUrl, com.tencent.mm.modelappbrand.a.g.gSK);
      AppMethodBeat.o(134455);
      return;
      i = com.tencent.mm.plugin.appbrand.aa.g.bY(((a)localObject).aTm().jbU, -16777216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.13
 * JD-Core Version:    0.7.0.1
 */