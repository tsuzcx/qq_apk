package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.MBCanvasHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.page.bh;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.ui.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class af$1
  implements Runnable
{
  public af$1(o paramo, AppBrandInitConfigWC paramAppBrandInitConfigWC) {}
  
  public final void run()
  {
    AppMethodBeat.i(129149);
    ab.i("MicroMsg.AppBrand.RuntimeRestartHelper", "performRestart OnUiThread appId[%s]", new Object[] { this.gOJ.mAppId });
    for (;;)
    {
      try
      {
        localObject = this.gOJ;
        if (!p.m((i)localObject)) {
          continue;
        }
        localObject = (com.tencent.luggage.game.e.a.a.b)((com.tencent.mm.plugin.appbrand.service.c)((i)localObject).ws()).x(com.tencent.luggage.game.e.a.a.b.class);
        if (localObject == null) {
          continue;
        }
        localObject = ((com.tencent.luggage.game.e.a.a.b)localObject).getMBRuntime().getCanvasHandler().a(null, false);
        e.a(this.gOJ, (Bitmap)localObject);
      }
      catch (Exception localException)
      {
        Object localObject;
        ab.e("MicroMsg.AppBrand.RuntimeRestartHelper", "performRestart  takeSnapshot appId[%s], e[%s]", new Object[] { this.gOJ.mAppId, localException });
        continue;
      }
      this.gSh.bDh = this.gOJ.wS().bDh;
      this.gSh.resetSession();
      this.gOJ.f(this.gSh);
      AppMethodBeat.o(129149);
      return;
      ab.printErrStackTrace("MicroMsg.AppBrand.RuntimeRestartHelper", new com.tencent.luggage.game.e.a.a.c(), "hy: not game service", new Object[0]);
      localObject = null;
      continue;
      localObject = bh.cu(((i)localObject).atj().getCurrentPage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.1
 * JD-Core Version:    0.7.0.1
 */