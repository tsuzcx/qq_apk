package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.kernel.b.h.6;
import com.tencent.mm.model.av;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.splash.e;
import com.tencent.mm.splash.m.a;
import com.tencent.mm.splash.o.a;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.n;
import com.tencent.mm.vending.h.d;

public class WeChatSplashStartup
  implements m.a
{
  private Application app;
  com.tencent.mm.kernel.b.h profile;
  private String thisProcess;
  
  private void b(final o.a parama)
  {
    AppMethodBeat.i(137974);
    com.tencent.mm.f.a.bg(this.app);
    com.tencent.mm.blink.a.id(2);
    if (parama == null) {}
    for (boolean bool = true;; bool = false)
    {
      this.profile.onCreate();
      g localg = new g();
      this.profile.eHJ.a(localg);
      if (!bool)
      {
        com.tencent.mm.splash.h.dvt();
        new com.tencent.mm.sdk.b.c() {}.alive();
        new com.tencent.mm.sdk.b.c() {}.alive();
      }
      com.tencent.mm.kernel.g.RM().a(bq(bool));
      com.tencent.mm.splash.h.a(new e()
      {
        n bZs;
        
        public final boolean a(Activity paramAnonymousActivity, int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
        {
          AppMethodBeat.i(137952);
          boolean bool = this.bZs.a(paramAnonymousActivity, paramAnonymousInt, paramAnonymousArrayOfString, paramAnonymousArrayOfInt);
          AppMethodBeat.o(137952);
          return bool;
        }
        
        public final boolean a(Activity paramAnonymousActivity, Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(137950);
          com.tencent.mm.kernel.g.RJ();
          boolean bool = com.tencent.mm.kernel.a.QT();
          String str = av.flM.Y("login_user_name", "");
          if ((!bool) && (str.equals(""))) {}
          for (int i = 1; i == 0; i = 0)
          {
            AppMethodBeat.o(137950);
            return false;
          }
          if (com.tencent.mm.sdk.platformtools.g.ymN)
          {
            bool = MMAppMgr.a(paramAnonymousActivity, new WeChatSplashStartup.3.1(this, paramAnonymousRunnable));
            AppMethodBeat.o(137950);
            return bool;
          }
          AppMethodBeat.o(137950);
          return false;
        }
        
        public final boolean b(Activity paramAnonymousActivity, Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(137951);
          boolean bool = this.bZs.c(paramAnonymousActivity, paramAnonymousRunnable);
          AppMethodBeat.o(137951);
          return bool;
        }
        
        public final boolean n(Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(137949);
          if ((paramAnonymousIntent != null) && (w.a(paramAnonymousIntent, "absolutely_exit_pid", 0) == Process.myPid()))
          {
            ab.i("MicroMsg.WeChatSplashStartup", "handle exit intent.");
            MMAppMgr.qr(w.a(paramAnonymousIntent, "kill_service", true));
            AppMethodBeat.o(137949);
            return true;
          }
          AppMethodBeat.o(137949);
          return false;
        }
      });
      com.tencent.mm.splash.h.a(q.bYM);
      com.tencent.mm.kernel.g.RM().a(new WeChatSplashStartup.4(this, bool, parama));
      com.tencent.mm.kernel.g.RM().a(new WeChatSplashStartup.5(this));
      com.tencent.mm.kernel.g.RM().a(new WeChatSplashStartup.6(this));
      AppMethodBeat.o(137974);
      return;
    }
  }
  
  private d bq(boolean paramBoolean)
  {
    AppMethodBeat.i(137975);
    if (!paramBoolean)
    {
      Object localObject = k.Bj();
      ((k)localObject).Bk();
      com.tencent.mm.kernel.g.RM().a(new WeChatSplashStartup.7(this, (k)localObject));
      com.tencent.mm.kernel.a.c.RX().d(((k)localObject).bYd.getLooper());
      localObject = ((k)localObject).bYe;
      AppMethodBeat.o(137975);
      return localObject;
    }
    AppMethodBeat.o(137975);
    return null;
  }
  
  public final void BM()
  {
    AppMethodBeat.i(137973);
    b(null);
    AppMethodBeat.o(137973);
  }
  
  public final void a(o.a parama)
  {
    AppMethodBeat.i(137972);
    b(parama);
    AppMethodBeat.o(137972);
  }
  
  public final void b(Application paramApplication, String paramString)
  {
    AppMethodBeat.i(137971);
    this.app = paramApplication;
    this.thisProcess = paramString;
    this.profile = z.bZn;
    com.tencent.mm.kernel.g.a(this.profile);
    paramApplication = this.profile;
    paramString = this.app;
    paramApplication.eKH.a(new h.6(paramApplication, paramString));
    AppMethodBeat.o(137971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup
 * JD-Core Version:    0.7.0.1
 */