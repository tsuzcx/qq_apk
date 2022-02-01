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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.v;

final class WeChatSplashStartup$6
  implements com.tencent.mm.kernel.api.g
{
  WeChatSplashStartup$6(WeChatSplashStartup paramWeChatSplashStartup) {}
  
  public final void ML()
  {
    AppMethodBeat.i(160075);
    com.tencent.mm.kernel.g.ajS().b(this);
    com.tencent.mm.blink.a.MH();
    WeChatSplashStartup.a(this.cWm);
    v.byD();
    ExtStorageMigrateMonitor.fmY();
    b.fnv();
    ExtStorageMigrateRoutine.triggerMediaRescanOnDemand();
    if (this.cWm.profile.akL()) {}
    try
    {
      ak.getContext().getSharedPreferences("system_config_prefs", 0).edit().putInt("launch_last_status", 2).commit();
      if (this.cWm.profile.akL())
      {
        com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.ajP();
        ae.i("MMKernel.CoreAccount", "summerhardcoder hasInitialized[%b] mHardCoderStartPerformance[%d] stack[%s]", new Object[] { Boolean.valueOf(locala.aiZ()), Integer.valueOf(locala.gDb), bu.fpN() });
        if ((locala.aiZ()) && (locala.gDb != 0))
        {
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBootEnable, locala.gDb);
          ae.i("MMKernel.CoreAccount", "summerhardcoder stopPerformance[%s] stack[%s]", new Object[] { Integer.valueOf(locala.gDb), bu.fpN() });
          locala.gDb = 0;
        }
      }
      AppMethodBeat.o(160075);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.WeChatSplashStartup", localException, "%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void ch(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup.6
 * JD-Core Version:    0.7.0.1
 */