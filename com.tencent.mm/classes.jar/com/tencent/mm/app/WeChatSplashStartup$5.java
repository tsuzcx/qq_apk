package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class WeChatSplashStartup$5
  implements com.tencent.mm.kernel.api.g
{
  WeChatSplashStartup$5(WeChatSplashStartup paramWeChatSplashStartup) {}
  
  public final void BN()
  {
    AppMethodBeat.i(137957);
    com.tencent.mm.kernel.g.RM().b(this);
    com.tencent.mm.blink.a.BK();
    WeChatSplashStartup.a(this.bZo);
    if (this.bZo.profile.SD()) {}
    try
    {
      ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putInt("launch_last_status", 2).commit();
      if (this.bZo.profile.SD())
      {
        com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.RJ();
        ab.i("MMKernel.CoreAccount", "summerhardcoder hasInitialized[%b] mHardCoderStartPerformance[%d] stack[%s]", new Object[] { Boolean.valueOf(locala.QU()), Integer.valueOf(locala.eGX), bo.dtY() });
        if ((locala.QU()) && (locala.eGX != 0))
        {
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBootEnable, locala.eGX);
          ab.i("MMKernel.CoreAccount", "summerhardcoder stopPerformance[%s] stack[%s]", new Object[] { Integer.valueOf(locala.eGX), bo.dtY() });
          locala.eGX = 0;
        }
      }
      AppMethodBeat.o(137957);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WeChatSplashStartup", localException, "%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void br(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup.5
 * JD-Core Version:    0.7.0.1
 */