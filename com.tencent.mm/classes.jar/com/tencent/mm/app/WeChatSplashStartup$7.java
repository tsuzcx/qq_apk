package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine;
import com.tencent.mm.sdcard_migrate.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.p;

final class WeChatSplashStartup$7
  implements com.tencent.mm.kernel.api.g
{
  WeChatSplashStartup$7(WeChatSplashStartup paramWeChatSplashStartup) {}
  
  public final void MP()
  {
    AppMethodBeat.i(160075);
    com.tencent.mm.kernel.g.ajD().b(this);
    com.tencent.mm.blink.a.MM();
    WeChatSplashStartup.a(this.cVp);
    p.bxK();
    ExtStorageMigrateMonitor.fjg();
    b.fjD();
    ExtStorageMigrateRoutine.triggerMediaRescanOnDemand();
    if (this.cVp.profile.akw()) {}
    try
    {
      aj.getContext().getSharedPreferences("system_config_prefs", 0).edit().putInt("launch_last_status", 2).commit();
      if (this.cVp.profile.akw())
      {
        com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.ajA();
        ad.i("MMKernel.CoreAccount", "summerhardcoder hasInitialized[%b] mHardCoderStartPerformance[%d] stack[%s]", new Object[] { Boolean.valueOf(locala.aiK()), Integer.valueOf(locala.gAu), bt.flS() });
        if ((locala.aiK()) && (locala.gAu != 0))
        {
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBootEnable, locala.gAu);
          ad.i("MMKernel.CoreAccount", "summerhardcoder stopPerformance[%s] stack[%s]", new Object[] { Integer.valueOf(locala.gAu), bt.flS() });
          locala.gAu = 0;
        }
      }
      AppMethodBeat.o(160075);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.WeChatSplashStartup", localException, "%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void cg(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup.7
 * JD-Core Version:    0.7.0.1
 */