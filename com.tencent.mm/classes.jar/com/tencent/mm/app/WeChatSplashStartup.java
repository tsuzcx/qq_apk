package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.od;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.b.h.6;
import com.tencent.mm.model.ay;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateRoutine;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.splash.m.a;
import com.tencent.mm.splash.o.a;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.n;
import com.tencent.mm.vending.h.d;
import java.io.File;

public class WeChatSplashStartup
  implements m.a
{
  private Application app;
  com.tencent.mm.kernel.b.h profile;
  private String thisProcess;
  
  private void b(final o.a parama)
  {
    AppMethodBeat.i(160091);
    com.tencent.mm.f.a.bu(this.app);
    com.tencent.mm.blink.a.kp(2);
    final boolean bool;
    Object localObject;
    if (parama == null)
    {
      bool = true;
      this.profile.onCreate();
      if ((!this.profile.ra(":tools")) && (!this.profile.ra(":toolsmp"))) {
        break label202;
      }
      localObject = new ag();
    }
    for (;;)
    {
      this.profile.gcO.a((com.tencent.mm.kernel.a.b)localObject);
      if (!bool)
      {
        com.tencent.mm.splash.h.eIj();
        new com.tencent.mm.sdk.b.c() {}.alive();
        new com.tencent.mm.sdk.b.c() {}.alive();
      }
      com.tencent.mm.kernel.g.afC().a(cd(bool));
      com.tencent.mm.splash.h.a(new com.tencent.mm.splash.e()
      {
        n cMV;
        
        public final boolean Lj()
        {
          AppMethodBeat.i(169426);
          boolean bool = n.eQP();
          AppMethodBeat.o(169426);
          return bool;
        }
        
        public final boolean a(Activity paramAnonymousActivity, int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
        {
          AppMethodBeat.i(160068);
          boolean bool = this.cMV.a(paramAnonymousActivity, paramAnonymousInt, paramAnonymousArrayOfString, paramAnonymousArrayOfInt);
          AppMethodBeat.o(160068);
          return bool;
        }
        
        public final boolean a(Activity paramAnonymousActivity, final Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(160066);
          com.tencent.mm.kernel.g.afz();
          boolean bool = com.tencent.mm.kernel.a.aeH();
          String str = ay.gNa.ao("login_user_name", "");
          if ((!bool) && (str.equals(""))) {}
          for (int i = 1; i == 0; i = 0)
          {
            AppMethodBeat.o(160066);
            return false;
          }
          if (com.tencent.mm.sdk.platformtools.i.ETy)
          {
            bool = MMAppMgr.a(paramAnonymousActivity, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(160107);
                paramAnonymousRunnable.run();
                AppMethodBeat.o(160107);
              }
            });
            AppMethodBeat.o(160066);
            return bool;
          }
          AppMethodBeat.o(160066);
          return false;
        }
        
        public final boolean n(Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(160065);
          if ((paramAnonymousIntent != null) && (y.getIntExtra(paramAnonymousIntent, "absolutely_exit_pid", 0) == Process.myPid()))
          {
            ad.i("MicroMsg.WeChatSplashStartup", "handle exit intent.");
            MMAppMgr.vy(y.getBooleanExtra(paramAnonymousIntent, "kill_service", true));
            AppMethodBeat.o(160065);
            return true;
          }
          AppMethodBeat.o(160065);
          return false;
        }
      });
      com.tencent.mm.splash.h.a(x.cMp);
      com.tencent.mm.kernel.g.afC().a(new com.tencent.mm.kernel.api.g()
      {
        public final void Lk()
        {
          AppMethodBeat.i(160049);
          com.tencent.mm.kernel.g.afC().b(this);
          if (!bool)
          {
            parama.done();
            AppMethodBeat.o(160049);
            return;
          }
          com.tencent.mm.splash.h.b("MicroMsg.FigLeaf", "deleteRequest ", new Object[0]);
          Object localObject = com.tencent.mm.splash.a.eIb();
          if (!new com.tencent.mm.vfs.e((String)localObject).exists())
          {
            com.tencent.mm.splash.h.b("MicroMsg.FigLeaf", "deleteRequest dex opt dir not exists.", new Object[0]);
            AppMethodBeat.o(160049);
            return;
          }
          localObject = new com.tencent.mm.vfs.e((String)localObject + "/main-process-blocking");
          if (((com.tencent.mm.vfs.e)localObject).exists()) {
            com.tencent.mm.splash.h.b("MicroMsg.FigLeaf", "deleteRequest result %s.", new Object[] { Boolean.valueOf(((com.tencent.mm.vfs.e)localObject).delete()) });
          }
          AppMethodBeat.o(160049);
        }
        
        public final void ce(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.g.afC().a(new com.tencent.mm.kernel.api.g()
      {
        public final void Lk()
        {
          AppMethodBeat.i(160075);
          com.tencent.mm.kernel.g.afC().b(this);
          com.tencent.mm.blink.a.Lg();
          WeChatSplashStartup.a(WeChatSplashStartup.this);
          com.tencent.mm.vfs.p.bmJ();
          ExtStorageMigrateMonitor.eEj();
          com.tencent.mm.sdcard_migrate.b.eEG();
          ExtStorageMigrateRoutine.triggerMediaRescanOnDemand();
          if (WeChatSplashStartup.this.profile.agu()) {}
          try
          {
            aj.getContext().getSharedPreferences("system_config_prefs", 0).edit().putInt("launch_last_status", 2).commit();
            if (WeChatSplashStartup.this.profile.agu())
            {
              com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.afz();
              ad.i("MMKernel.CoreAccount", "summerhardcoder hasInitialized[%b] mHardCoderStartPerformance[%d] stack[%s]", new Object[] { Boolean.valueOf(locala.aeI()), Integer.valueOf(locala.gce), bt.eGN() });
              if ((locala.aeI()) && (locala.gce != 0))
              {
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcBootEnable, locala.gce);
                ad.i("MMKernel.CoreAccount", "summerhardcoder stopPerformance[%s] stack[%s]", new Object[] { Integer.valueOf(locala.gce), bt.eGN() });
                locala.gce = 0;
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
        
        public final void ce(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.g.afC().a(new com.tencent.mm.kernel.api.g()
      {
        public final void Lk()
        {
          AppMethodBeat.i(160071);
          if (!aj.eFI()) {
            af.a.cMK.KX();
          }
          if (aj.cbe()) {
            w.execute();
          }
          AppMethodBeat.o(160071);
        }
        
        public final void ce(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.g.afC().a(new com.tencent.mm.kernel.api.g()
      {
        public final void Lk()
        {
          AppMethodBeat.i(160117);
          b.c(WeChatSplashStartup.b(WeChatSplashStartup.this));
          AppMethodBeat.o(160117);
        }
        
        public final void ce(boolean paramAnonymousBoolean) {}
      });
      AppMethodBeat.o(160091);
      return;
      bool = false;
      break;
      label202:
      if ((this.profile.rb(":appbrand")) && (eK(com.tencent.mm.plugin.appbrand.a.a.iIZ))) {
        localObject = new c();
      } else {
        localObject = new i();
      }
    }
  }
  
  private d cd(boolean paramBoolean)
  {
    AppMethodBeat.i(160092);
    if (!paramBoolean)
    {
      Object localObject = p.KK();
      ((p)localObject).KL();
      com.tencent.mm.kernel.g.afC().a(new com.tencent.mm.kernel.api.g()
      {
        public final void Lk()
        {
          AppMethodBeat.i(160116);
          this.cMZ.cLz.quit();
          com.tencent.mm.kernel.g.afC().b(this);
          AppMethodBeat.o(160116);
        }
        
        public final void ce(boolean paramAnonymousBoolean) {}
      });
      com.tencent.mm.kernel.a.c.afO().f(((p)localObject).cLz.getLooper());
      localObject = ((p)localObject).cLA;
      AppMethodBeat.o(160092);
      return localObject;
    }
    AppMethodBeat.o(160092);
    return null;
  }
  
  private static boolean eK(String paramString)
  {
    AppMethodBeat.i(177509);
    if (paramString == null)
    {
      AppMethodBeat.o(177509);
      return false;
    }
    if (new File(paramString).exists())
    {
      AppMethodBeat.o(177509);
      return true;
    }
    AppMethodBeat.o(177509);
    return false;
  }
  
  public final void Li()
  {
    AppMethodBeat.i(160090);
    b(null);
    AppMethodBeat.o(160090);
  }
  
  public final void a(o.a parama)
  {
    AppMethodBeat.i(160089);
    b(parama);
    AppMethodBeat.o(160089);
  }
  
  public final void b(Application paramApplication, String paramString)
  {
    AppMethodBeat.i(160088);
    this.app = paramApplication;
    this.thisProcess = paramString;
    this.profile = ah.cMQ;
    com.tencent.mm.kernel.g.a(this.profile);
    paramApplication = this.profile;
    paramString = this.app;
    paramApplication.gfP.a(new h.6(paramApplication, paramString));
    AppMethodBeat.o(160088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.WeChatSplashStartup
 * JD-Core Version:    0.7.0.1
 */