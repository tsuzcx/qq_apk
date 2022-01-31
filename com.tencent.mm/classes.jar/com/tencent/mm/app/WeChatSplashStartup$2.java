package com.tencent.mm.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Process;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.p;

final class WeChatSplashStartup$2
  implements com.tencent.mm.splash.e
{
  p bxr = new p();
  
  WeChatSplashStartup$2(WeChatSplashStartup paramWeChatSplashStartup) {}
  
  public final boolean a(Activity paramActivity, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    return this.bxr.a(paramActivity, paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public final boolean a(Activity paramActivity, final Runnable paramRunnable)
  {
    g.DN();
    boolean bool = a.Db();
    String str = at.dVC.L("login_user_name", "");
    int i;
    if ((!bool) && (str.equals("")))
    {
      i = 1;
      if (i != 0) {
        break label49;
      }
    }
    label49:
    while (!com.tencent.mm.sdk.platformtools.e.uem)
    {
      return false;
      i = 0;
      break;
    }
    MMAppMgr.a(paramActivity, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramRunnable.run();
      }
    });
  }
  
  public final boolean b(Activity paramActivity, Runnable paramRunnable)
  {
    return this.bxr.c(paramActivity, paramRunnable);
  }
  
  public final boolean d(Intent paramIntent)
  {
    if ((paramIntent != null) && (t.a(paramIntent, "absolutely_exit_pid", 0) == Process.myPid()))
    {
      y.i("MicroMsg.WeChatSplashStartup", "handle exit intent.");
      MMAppMgr.mU(t.a(paramIntent, "kill_service", true));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup.2
 * JD-Core Version:    0.7.0.1
 */