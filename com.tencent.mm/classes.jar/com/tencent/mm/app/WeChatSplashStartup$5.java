package com.tencent.mm.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.splash.e;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.r;

final class WeChatSplashStartup$5
  implements e
{
  r hjo;
  
  WeChatSplashStartup$5(WeChatSplashStartup paramWeChatSplashStartup)
  {
    AppMethodBeat.i(160064);
    this.hjo = new r();
    AppMethodBeat.o(160064);
  }
  
  public final boolean a(Activity paramActivity, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(160068);
    boolean bool = this.hjo.a(paramActivity, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(160068);
    return bool;
  }
  
  public final boolean a(Activity paramActivity, final Runnable paramRunnable)
  {
    AppMethodBeat.i(160066);
    h.baC();
    boolean bool = b.aZM();
    String str = bg.okT.aM("login_user_name", "");
    if ((!bool) && (str.equals(""))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(160066);
      return false;
    }
    if (ChannelUtil.shouldShowGprsAlert)
    {
      bool = MMAppMgr.a(paramActivity, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(160107);
          paramRunnable.run();
          AppMethodBeat.o(160107);
        }
      });
      AppMethodBeat.o(160066);
      return bool;
    }
    AppMethodBeat.o(160066);
    return false;
  }
  
  public final boolean aDw()
  {
    AppMethodBeat.i(169426);
    boolean bool = r.jjv();
    AppMethodBeat.o(169426);
    return bool;
  }
  
  public final boolean q(Intent paramIntent)
  {
    AppMethodBeat.i(160065);
    if ((paramIntent != null) && (IntentUtil.getIntExtra(paramIntent, "absolutely_exit_pid", 0) == Process.myPid()))
    {
      Log.i("MicroMsg.WeChatSplashStartup", "handle exit intent.");
      MMAppMgr.Lj(IntentUtil.getBooleanExtra(paramIntent, "kill_service", true));
      AppMethodBeat.o(160065);
      return true;
    }
    AppMethodBeat.o(160065);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup.5
 * JD-Core Version:    0.7.0.1
 */