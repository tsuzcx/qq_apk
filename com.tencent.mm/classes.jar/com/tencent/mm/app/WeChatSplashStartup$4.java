package com.tencent.mm.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WeChatSplashStartup$4
  implements com.tencent.mm.kernel.api.g
{
  WeChatSplashStartup$4(WeChatSplashStartup paramWeChatSplashStartup) {}
  
  public final void aP(boolean paramBoolean) {}
  
  public final void tj()
  {
    com.tencent.mm.kernel.g.DQ().b(this);
    com.tencent.mm.blink.a.tg();
    WeChatSplashStartup.a(this.bxp);
    if (this.bxp.profile.Ex()) {}
    try
    {
      ae.getContext().getSharedPreferences("system_config_prefs", 0).edit().putInt("launch_last_status", 2).commit();
      if (this.bxp.profile.Ex())
      {
        com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.DN();
        y.i("MMKernel.CoreAccount", "summerhardcoder hasInitialized[%b] mHardCoderStartPerformance[%d] stack[%s]", new Object[] { Boolean.valueOf(locala.Dc()), Integer.valueOf(locala.dJy), bk.csb() });
        if ((locala.Dc()) && (locala.dJy != 0))
        {
          WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcBootEnable, locala.dJy);
          y.i("MMKernel.CoreAccount", "summerhardcoder stopPerformace[%s] stack[%s]", new Object[] { Integer.valueOf(locala.dJy), bk.csb() });
          locala.dJy = 0;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.WeChatSplashStartup", localException, "%s", new Object[] { localException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup.4
 * JD-Core Version:    0.7.0.1
 */