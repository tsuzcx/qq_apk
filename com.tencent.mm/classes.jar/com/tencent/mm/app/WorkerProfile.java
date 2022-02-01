package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.w;
import com.tencent.mm.ak.w.a;
import com.tencent.mm.console.Shell;
import com.tencent.mm.contact.c.a;
import com.tencent.mm.g.a.ab;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.g.a.kq;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.g.a.ru;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.a.wh;
import com.tencent.mm.g.a.wx;
import com.tencent.mm.g.a.xw;
import com.tencent.mm.kiss.a.b.2;
import com.tencent.mm.model.as;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.model.m;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.network.n.a;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.IKVReportNotify;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.br.b;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI;
import com.tencent.mm.ui.tools.NewTaskUI;
import java.io.File;
import java.util.Locale;
import java.util.Map;

public final class WorkerProfile
  extends com.tencent.mm.compatible.loader.d
  implements com.tencent.mm.ak.f, w.a, n, as, com.tencent.mm.model.f.a, IKVReportNotify
{
  public static final String cUu;
  private static WorkerProfile cWH;
  private static int cWX;
  private final int ID;
  private final Shell cWF;
  private final com.tencent.mm.console.a cWG;
  private at cWI;
  private br.b cWJ;
  private com.tencent.mm.model.aj cWK;
  public boolean cWL;
  @Deprecated
  public boolean cWM;
  public boolean cWN;
  private final int cWO;
  private final int cWP;
  private int cWQ;
  private StringBuilder cWR;
  private com.tencent.mm.booter.notification.a.g cWS;
  private boolean cWT;
  private com.tencent.mm.h.b cWU;
  public final ak cWV;
  public final aj cWW;
  protected Locale locale;
  
  static
  {
    AppMethodBeat.i(19603);
    cUu = com.tencent.mm.sdk.platformtools.ak.getPackageName();
    cWX = -1;
    AppMethodBeat.o(19603);
  }
  
  public WorkerProfile()
  {
    AppMethodBeat.i(19592);
    this.cWF = new Shell();
    this.cWG = new com.tencent.mm.console.a();
    this.cWL = false;
    this.cWO = 0;
    this.cWP = 1;
    this.ID = 2130706432;
    this.cWR = new StringBuilder();
    this.cWT = true;
    this.cWV = new ak();
    this.cWW = new aj();
    cWH = this;
    AppMethodBeat.o(19592);
  }
  
  public static WorkerProfile MU()
  {
    return cWH;
  }
  
  public final br.b MV()
  {
    AppMethodBeat.i(19597);
    if (this.cWJ == null) {
      this.cWJ = new br.b()
      {
        public final String a(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, Context paramAnonymousContext)
        {
          AppMethodBeat.i(19583);
          paramAnonymousString1 = com.tencent.mm.booter.notification.a.h.a(paramAnonymousInt1, paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousContext);
          AppMethodBeat.o(19583);
          return paramAnonymousString1;
        }
        
        public final void a(bv paramAnonymousbv, PString paramAnonymousPString1, PString paramAnonymousPString2, PInt paramAnonymousPInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(19582);
          com.tencent.mm.booter.notification.a.h.b(paramAnonymousbv, paramAnonymousPString1, paramAnonymousPString2, paramAnonymousPInt, paramAnonymousBoolean);
          AppMethodBeat.o(19582);
        }
      };
    }
    br.b localb = this.cWJ;
    AppMethodBeat.o(19597);
    return localb;
  }
  
  public final com.tencent.mm.model.aj MW()
  {
    AppMethodBeat.i(19598);
    if (this.cWK == null) {
      this.cWK = com.tencent.mm.booter.a.WB();
    }
    com.tencent.mm.model.aj localaj = this.cWK;
    AppMethodBeat.o(19598);
    return localaj;
  }
  
  public final void Me()
  {
    this.cWT = true;
  }
  
  public final void Mf()
  {
    this.cWT = false;
  }
  
  public final void fG(String paramString)
  {
    AppMethodBeat.i(19601);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "summerdiz onOldDisaster errStr[%s]", new Object[] { paramString });
    com.tencent.mm.g.a.ap localap = new com.tencent.mm.g.a.ap();
    localap.dmn.type = 4;
    localap.dmn.dmp = paramString;
    com.tencent.mm.sdk.b.a.IvT.l(localap);
    AppMethodBeat.o(19601);
  }
  
  public final void fH(String paramString)
  {
    AppMethodBeat.i(19602);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "summerdiz onReMoveNoticeId:%s", new Object[] { paramString });
    com.tencent.mm.g.a.ap localap = new com.tencent.mm.g.a.ap();
    localap.dmn.type = 1;
    localap.dmn.dmp = paramString;
    com.tencent.mm.sdk.b.a.IvT.l(localap);
    AppMethodBeat.o(19602);
  }
  
  public final at getNotification()
  {
    AppMethodBeat.i(19596);
    if (this.cWI == null) {
      this.cWI = new com.tencent.mm.booter.notification.c(this.app);
    }
    at localat = this.cWI;
    AppMethodBeat.o(19596);
    return localat;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(19595);
    Object localObject = com.tencent.mm.sdk.platformtools.ak.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ak.fow(), 0);
    com.tencent.mm.sdk.platformtools.ak.getContext();
    if ("language_default".equals(com.tencent.mm.sdk.platformtools.ad.g((SharedPreferences)localObject)))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "config locale %s", new Object[] { com.tencent.mm.sdk.platformtools.ad.d(paramConfiguration.locale) });
      paramConfiguration = MMActivity.initLanguage(this.app.getBaseContext(), com.tencent.mm.sdk.platformtools.ad.d(paramConfiguration.locale));
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "onConfigurationChanged, locale = %s, n = %s", new Object[] { this.locale, paramConfiguration });
      if ((paramConfiguration != null) && (this.locale != null) && (!paramConfiguration.equals(this.locale)) && (!bc.ajM())) {}
    }
    try
    {
      paramConfiguration = bc.ajj().hRo;
      if (paramConfiguration != null)
      {
        paramConfiguration = paramConfiguration.aFs();
        if (paramConfiguration != null)
        {
          bc.aCg();
          int i = com.tencent.mm.model.c.getUin();
          paramConfiguration.a(new byte[0], new byte[0], new byte[0], i);
        }
      }
    }
    catch (Exception paramConfiguration)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.WorkerProfile", paramConfiguration, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.WorkerProfile", paramConfiguration, "what the f$!k", new Object[0]);
      }
    }
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.WorkerProfile", "language changed, restart process");
    com.tencent.mm.bv.a.hN(com.tencent.mm.sdk.platformtools.ak.getContext());
    paramConfiguration = com.tencent.mm.hellhoundlib.b.c.a(-1, new com.tencent.mm.hellhoundlib.b.a());
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramConfiguration.ahE(), "com/tencent/mm/app/WorkerProfile", "initLanguage", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)paramConfiguration.mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/app/WorkerProfile", "initLanguage", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    AppMethodBeat.o(19595);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(19593);
    long l2 = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WorkerProfile", "workerProfile onCreate, step 1");
    com.tencent.mm.plugin.hp.tinker.i.dfx();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "start time check onCreate proc:%s pid:%d" + cUu + Process.myPid());
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "appOnCreate start getAccStg %b, thread name %s", new Object[] { Boolean.TRUE, Thread.currentThread().getName() });
    l1 = System.currentTimeMillis();
    com.tencent.mm.model.d.a.aDL();
    bc.ajj().a(-1, this);
    w.a(this);
    bc.aCi().hHA = this;
    bc.a(new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(19556);
        if ((paramAnonymousInt != 4) && (paramAnonymousInt != 6))
        {
          AppMethodBeat.o(19556);
          return;
        }
        if ((bc.ajM()) && (com.tencent.mm.kernel.g.ajP().gDk) && (!bc.aiT()))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "dkmsg Network connected , try send msg.");
          com.tencent.mm.modelmulti.o.a(o.d.iiP).aJO().execute();
          AppMethodBeat.o(19556);
          return;
        }
        AppMethodBeat.o(19556);
      }
    });
    bc.getSysCmdMsgExtension().a("getkvidkeystg", new cf.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(19570);
        com.tencent.mm.plugin.report.service.i.axS(z.a(paramAnonymousa.gte.FNI));
        AppMethodBeat.o(19570);
      }
      
      public final void a(e.c paramAnonymousc) {}
    }, true);
    Object localObject1 = this.app;
    com.tencent.mm.sdk.platformtools.k.iE((Context)localObject1);
    com.tencent.mm.sdk.platformtools.k.iF((Context)localObject1);
    Object localObject3 = ((Context)localObject1).getPackageManager();
    for (;;)
    {
      try
      {
        localObject1 = ((PackageManager)localObject3).getPackageInfo(((Context)localObject1).getPackageName(), 0).applicationInfo.sourceDir;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "initChannelUtil sourceFile = %s", new Object[] { localObject1 });
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WorkerProfile", "initChannelUtil NameNotFoundException");
        continue;
        if (localException2.cSL + 8 - 8 < 0) {
          continue;
        }
        com.tencent.mm.d.b localb = new com.tencent.mm.d.b();
        localb.parseFrom(com.tencent.mm.vfs.o.bb(localNameNotFoundException, i - (localException2.cSL + 8 - 8) - 8, localException2.cSL + 8 - 8));
        new com.tencent.mm.d.a(localb);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "checkApkExternal, check ok");
        continue;
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WorkerProfile", "checkApkExternal header wrong");
        continue;
        if (localNameNotFoundException != null) {
          continue;
        }
        bool = true;
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WorkerProfile", "initChannelUtil something null %s", new Object[] { Boolean.valueOf(bool) });
        continue;
      }
      catch (Exception localException1)
      {
        int j;
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WorkerProfile", "Exception in initChannel, %s", new Object[] { localException1.getMessage() });
        continue;
        boolean bool = false;
        continue;
        try
        {
          Object localObject2 = localException1.getSharedPreferences("crash_status_file", 4);
          int k = ((SharedPreferences)localObject2).getInt("channel", -1);
          int m = ((SharedPreferences)localObject2).getInt("version", 0);
          if ((k == i) && (m == j)) {
            continue;
          }
          localObject2 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject2).putInt("channel", i);
          ((SharedPreferences.Editor)localObject2).putInt("version", j);
          ((SharedPreferences.Editor)localObject2).commit();
        }
        catch (Throwable localThrowable) {}
        continue;
        String str = com.tencent.mm.sdk.platformtools.k.cSN;
        continue;
        l1 = 6L;
        continue;
        int i = 5002;
        continue;
      }
      try
      {
        i = (int)com.tencent.mm.vfs.o.aZR((String)localObject1);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "checkApkExternal, fileSize = %s", new Object[] { Integer.valueOf(i) });
        if (i >= 8) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.WorkerProfile", localException2, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WorkerProfile", "Exception in checkApkExternal, %s", new Object[] { localException2.getMessage() });
        continue;
      }
      localObject1 = com.tencent.mm.d.a.fa((String)localObject1);
      if ((localObject1 == null) || (((com.tencent.mm.d.a)localObject1).cSJ == null)) {
        continue;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "apk external info not null");
      if (((com.tencent.mm.d.a)localObject1).cSJ.cSM != 0)
      {
        com.tencent.mm.sdk.platformtools.k.cSM = ((com.tencent.mm.d.a)localObject1).cSJ.cSM;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "read channelId from apk external");
      }
      if (((com.tencent.mm.d.a)localObject1).cSJ.cSO != 0)
      {
        com.tencent.mm.sdk.platformtools.k.cSO = ((com.tencent.mm.d.a)localObject1).cSJ.cSO;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "ext.updateMode = %s", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.k.cSO) });
      }
      if (((com.tencent.mm.d.a)localObject1).cSJ.cSP != null) {
        com.tencent.mm.sdk.platformtools.k.IwG = bu.getInt(((com.tencent.mm.d.a)localObject1).cSJ.cSP, 0);
      }
      if (((com.tencent.mm.d.a)localObject1).cSJ.cSQ != null) {
        com.tencent.mm.sdk.platformtools.k.IwH = ((com.tencent.mm.d.a)localObject1).cSJ.cSQ;
      }
      if (((com.tencent.mm.d.a)localObject1).cSJ.cSN != null) {
        com.tencent.mm.sdk.platformtools.k.cSN = ((com.tencent.mm.d.a)localObject1).cSJ.cSN;
      }
      if (((com.tencent.mm.d.a)localObject1).cSJ.cST)
      {
        com.tencent.mm.sdk.platformtools.k.IwL = ((com.tencent.mm.d.a)localObject1).cSJ.cST;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "ext.isNokiaol = %s", new Object[] { Boolean.valueOf(com.tencent.mm.sdk.platformtools.k.IwL) });
      }
      if (((com.tencent.mm.d.a)localObject1).cSJ.cSS != 0)
      {
        com.tencent.mm.sdk.platformtools.k.cSS = ((com.tencent.mm.d.a)localObject1).cSJ.cSS;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "ext.autoAddAccount = %s", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.k.cSS) });
      }
      if (((com.tencent.mm.d.a)localObject1).cSJ.cSR)
      {
        com.tencent.mm.sdk.platformtools.k.IwK = ((com.tencent.mm.d.a)localObject1).cSJ.cSR;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "ext.shouldShowGprsAlert = %s", new Object[] { Boolean.valueOf(com.tencent.mm.sdk.platformtools.k.IwK) });
      }
      f.LU();
      localObject1 = com.tencent.mm.booter.d.bL(this.app);
      if ((localObject1 != null) && (((com.tencent.mm.booter.d)localObject1).fGh != -1)) {
        com.tencent.mm.sdk.platformtools.k.cSM = ((com.tencent.mm.booter.d)localObject1).fGh;
      }
      localObject1 = this.app.getApplicationContext();
      i = com.tencent.mm.sdk.platformtools.k.cSM;
      j = com.tencent.mm.protocal.d.FFH;
      if ((localObject1 != null) && (i >= 0) && (j >= 637534208)) {
        continue;
      }
      if (com.tencent.mm.sdk.platformtools.k.IwG > 0) {
        com.tencent.mm.sdk.platformtools.k.IwI = true;
      }
      com.tencent.mm.br.d.fjx();
      localObject3 = new StringBuilder("android-");
      if (!bu.isNullOrNil(com.tencent.mm.sdk.platformtools.k.cSN)) {
        continue;
      }
      localObject1 = Integer.valueOf(Build.VERSION.SDK_INT);
      com.tencent.mm.protocal.d.hjv = localObject1;
      if (!bu.isNullOrNil(com.tencent.mm.sdk.a.b.fnG())) {
        com.tencent.mm.protocal.d.hjv = "android-" + com.tencent.mm.sdk.a.b.fnG();
      }
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.WorkerProfile", "set device type :%s  %s", new Object[] { com.tencent.mm.protocal.d.hjv, com.tencent.mm.sdk.a.b.fnG() });
      this.locale = MMActivity.initLanguage(this.app.getBaseContext());
      this.cWF.init(com.tencent.mm.sdk.platformtools.ak.getContext());
      localObject1 = this.cWG;
      com.tencent.mm.sdk.b.a.IvT.c((com.tencent.mm.sdk.b.c)localObject1);
      localObject1 = new com.tencent.mm.pluginsdk.ui.b(new e());
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AvatarDrawable", "setLoader".concat(String.valueOf(localObject1)));
      com.tencent.mm.pluginsdk.ui.a.b.xnS = (j.a)localObject1;
      com.tencent.mm.pluginsdk.i.f.Fhu = new com.tencent.mm.pluginsdk.i.f.a()
      {
        public final boolean MZ()
        {
          AppMethodBeat.i(163173);
          com.tencent.mm.plugin.finder.view.whatnews.a locala = com.tencent.mm.plugin.finder.view.whatnews.a.tke;
          boolean bool = ((Boolean)com.tencent.mm.plugin.finder.view.whatnews.a.tkd.getValue()).booleanValue();
          AppMethodBeat.o(163173);
          return bool;
        }
        
        public final void bA(Context paramAnonymousContext)
        {
          AppMethodBeat.i(19576);
          MMAppMgr.m(paramAnonymousContext, true);
          AppMethodBeat.o(19576);
        }
        
        public final void bB(Context paramAnonymousContext)
        {
          AppMethodBeat.i(19578);
          com.tencent.mm.network.ad.aPD().edit().putBoolean("is_in_notify_mode", true).commit();
          ao.aRS("welcome_page_show");
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().p(-1, null);
          ab localab = new ab();
          localab.dlL.dlM = false;
          com.tencent.mm.sdk.b.a.IvT.l(localab);
          com.tencent.mm.plugin.setting.c.iUA.MP();
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().Xo();
          MMAppMgr.m(paramAnonymousContext, false);
          AppMethodBeat.o(19578);
        }
        
        public final void m(Context paramAnonymousContext, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(19577);
          MMAppMgr.m(paramAnonymousContext, paramAnonymousBoolean);
          AppMethodBeat.o(19577);
        }
      };
      com.tencent.mm.kernel.g.a(com.tencent.mm.ak.i.class, new com.tencent.mm.kernel.c.e(this.cWW));
      com.tencent.mm.kernel.g.a(com.tencent.mm.api.l.class, new com.tencent.mm.kernel.c.e(this.cWW));
      com.tencent.mm.kernel.g.b(com.tencent.mm.api.o.class, new m());
      com.tencent.mm.kernel.g.a(com.tencent.mm.pluginsdk.k.class, new com.tencent.mm.kernel.c.e(this.cWW));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.brandservice.a.a.class, new com.tencent.mm.plugin.bbom.d());
      com.tencent.mm.kernel.g.b(com.tencent.mm.pluginsdk.p.class, new com.tencent.mm.app.plugin.d());
      com.tencent.mm.kernel.g.b(com.tencent.mm.choosemsgfile.compat.b.class, new com.tencent.mm.ui.chatting.b.a());
      com.tencent.mm.kernel.g.b(com.tencent.mm.ui.chatting.c.c.class, new com.tencent.mm.ui.chatting.c.b());
      com.tencent.mm.kernel.g.b(n.class, this);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.appbrand.service.e.class, new com.tencent.mm.ui.appbrand.a());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.appbrand.service.h.class, new com.tencent.mm.ui.appbrand.c());
      com.tencent.mm.sdk.b.a.IvT.c(new com.tencent.mm.app.plugin.b.a.a());
      if (this.cWI == null) {
        this.cWI = new com.tencent.mm.booter.notification.c(this.app);
      }
      this.cWU = new com.tencent.mm.h.b();
      localObject1 = this.cWU;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BroadcastController", "summerdiz init");
      com.tencent.mm.sdk.b.a.IvT.c(((com.tencent.mm.h.b)localObject1).fJQ);
      localObject1 = com.tencent.mm.kiss.a.b.akR();
      com.tencent.mm.sdk.b.a.IvT.c(new b.2((com.tencent.mm.kiss.a.b)localObject1));
      com.tencent.mm.sdk.b.a.IvT.c(new com.tencent.mm.plugin.account.bind.ui.e());
      com.tencent.mm.sdk.b.a.IvT.c(new WorkerProfile.29(this));
      com.tencent.mm.sdk.b.a.IvT.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IvT.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IvT.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IvT.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IvT.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IvT.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IvT.c(new WorkerProfile.3(this));
      com.tencent.mm.sdk.b.a.IvT.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IvT.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IvT.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IvT.c(new WorkerProfile.7(this));
      com.tencent.mm.sdk.b.a.IvT.c(new WorkerProfile.8(this));
      com.tencent.mm.sdk.b.a.IvT.c(new WorkerProfile.9(this));
      com.tencent.mm.sdk.b.a.IvT.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IvT.c(new WorkerProfile.11(this));
      com.tencent.mm.sdk.b.a.IvT.c(new WorkerProfile.13(this));
      com.tencent.mm.sdk.b.a.IvT.c(new WorkerProfile.14(this));
      com.tencent.mm.sdk.b.a.IvT.c(new WorkerProfile.15(this));
      com.tencent.mm.sdk.b.a.IvT.c(new WorkerProfile.16(this));
      com.tencent.mm.sdk.b.a.IvT.c(new WorkerProfile.17(this));
      com.tencent.mm.sdk.b.a.IvT.c(new WorkerProfile.18(this));
      com.tencent.mm.sdk.b.a.IvT.c(new WorkerProfile.19(this));
      com.tencent.mm.sdk.b.a.IvT.c(new WorkerProfile.20(this));
      com.tencent.mm.sdk.b.a.IvT.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IvT.c(new v(2, 12));
      new ae().alive();
      com.tencent.mm.sdk.b.a.IvT.b(new com.tencent.mm.sdk.b.c()
      {
        private static boolean MY()
        {
          AppMethodBeat.i(19568);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
          MMAppMgr.fBa();
          com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/app/WorkerProfile$29", "callback", "(Lcom/tencent/mm/autogen/events/SwitchAccountKillProcessEvent;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)locala.mt(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/app/WorkerProfile$29", "callback", "(Lcom/tencent/mm/autogen/events/SwitchAccountKillProcessEvent;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
          AppMethodBeat.o(19568);
          return true;
        }
      });
      com.tencent.mm.plugin.messenger.a.g.vVj = new com.tencent.mm.ui.transmit.d();
      com.tencent.mm.pluginsdk.q.a.Fca = new com.tencent.mm.app.plugin.a();
      com.tencent.mm.pluginsdk.ui.span.c.a.FzB = com.tencent.mm.app.plugin.e.Nc();
      if (!bc.aiT()) {
        bc.aCg();
      }
      localObject1 = new com.tencent.mm.g.a.cv();
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      this.cWL = true;
      Log.setLogImpl(new WorkerProfile.24(this));
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WorkerProfile", "start time check WorkerProfile appOnCreate use time " + (System.currentTimeMillis() - l1));
      localObject1 = new WorkerProfile.26(com.tencent.mm.sdk.platformtools.ak.getContext());
      ((WorkerProfile.26)localObject1).map.put("qqmail", Integer.valueOf(2131760200));
      ((WorkerProfile.26)localObject1).map.put("fmessage", Integer.valueOf(2131760169));
      ((WorkerProfile.26)localObject1).map.put("floatbottle", Integer.valueOf(2131760154));
      ((WorkerProfile.26)localObject1).map.put("lbsapp", Integer.valueOf(2131760177));
      ((WorkerProfile.26)localObject1).map.put("shakeapp", Integer.valueOf(2131760212));
      ((WorkerProfile.26)localObject1).map.put("medianote", Integer.valueOf(2131760186));
      ((WorkerProfile.26)localObject1).map.put("qqfriend", Integer.valueOf(2131760197));
      ((WorkerProfile.26)localObject1).map.put("newsapp", Integer.valueOf(2131760208));
      ((WorkerProfile.26)localObject1).map.put("facebookapp", Integer.valueOf(2131760163));
      ((WorkerProfile.26)localObject1).map.put("masssendapp", Integer.valueOf(2131760183));
      ((WorkerProfile.26)localObject1).map.put("meishiapp", Integer.valueOf(2131760189));
      ((WorkerProfile.26)localObject1).map.put("feedsapp", Integer.valueOf(2131760166));
      ((WorkerProfile.26)localObject1).map.put("voipapp", Integer.valueOf(2131760222));
      ((WorkerProfile.26)localObject1).map.put("weixin", Integer.valueOf(2131761779));
      ((WorkerProfile.26)localObject1).map.put("filehelper", Integer.valueOf(2131760147));
      ((WorkerProfile.26)localObject1).map.put("cardpackage", Integer.valueOf(2131760157));
      ((WorkerProfile.26)localObject1).map.put("officialaccounts", Integer.valueOf(2131760193));
      ((WorkerProfile.26)localObject1).map.put("voicevoipapp", Integer.valueOf(2131760225));
      ((WorkerProfile.26)localObject1).map.put("helper_entry", Integer.valueOf(2131760174));
      ((WorkerProfile.26)localObject1).map.put("voiceinputapp", Integer.valueOf(2131760219));
      ((WorkerProfile.26)localObject1).map.put("linkedinplugin", Integer.valueOf(2131760180));
      ((WorkerProfile.26)localObject1).map.put("notifymessage", Integer.valueOf(2131760190));
      ((WorkerProfile.26)localObject1).map.put("gh_f0a92aa7146c", Integer.valueOf(2131760228));
      ((WorkerProfile.26)localObject1).map.put("appbrandcustomerservicemsg", Integer.valueOf(2131760148));
      ((WorkerProfile.26)localObject1).map.put("appbrand_notify_message", Integer.valueOf(2131760151));
      ((WorkerProfile.26)localObject1).cXd.put("weixin", Integer.valueOf(2131761778));
      com.tencent.mm.contact.c.a((c.a)localObject1);
      com.tencent.mm.ui.ap.a(new WorkerProfile.1(this));
      if (!com.tencent.mm.compatible.util.e.abo())
      {
        localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
        if (!com.tencent.mm.compatible.util.d.lA(19)) {
          continue;
        }
        l1 = 5L;
        ((com.tencent.mm.plugin.report.service.g)localObject1).idkeyStat(340L, l1, 1L, false);
        localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
        if (!com.tencent.mm.compatible.util.d.lA(19)) {
          continue;
        }
        i = 5001;
        ((com.tencent.mm.plugin.report.service.g)localObject1).f(11098, new Object[] { Integer.valueOf(i), String.format("%s;%s;%s", new Object[] { com.tencent.mm.loader.j.b.asd(), Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.mm.compatible.util.g.getExternalStorageDirectory().getAbsolutePath() }) });
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), Boolean.valueOf(this.cWM), Integer.valueOf(com.tencent.mm.sdk.platformtools.k.cSM), Integer.valueOf(com.tencent.mm.protocal.d.FFH), bu.jt(com.tencent.mm.sdk.platformtools.ak.getContext()) });
      AppMethodBeat.o(19593);
      return;
      localObject3 = com.tencent.mm.d.a.a.G(com.tencent.mm.vfs.o.bb((String)localObject1, i - 8, 8));
      if (localObject3 != null) {
        continue;
      }
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WorkerProfile", "checkApkExternal, header null");
    }
  }
  
  public final void onReportKVDataReady(byte[] paramArrayOfByte1, final byte[] paramArrayOfByte2, final int paramInt)
  {
    AppMethodBeat.i(19600);
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19584);
        if (bc.aBZ())
        {
          AppMethodBeat.o(19584);
          return;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "summeranrt onReportKVDataReady channel:" + paramInt);
        com.tencent.mm.plugin.report.b.e locale = new com.tencent.mm.plugin.report.b.e(paramArrayOfByte2, paramInt);
        bc.ajj().a(locale, 0);
        AppMethodBeat.o(19584);
      }
    });
    AppMethodBeat.o(19600);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(19599);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "onSceneEnd dkwt type:%d [%d,%d,%s]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 3) && (paramInt2 == -1)) {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "getStack([ %s ]), ThreadID: %s", new Object[] { bu.fpN(), Long.valueOf(Thread.currentThread().getId()) });
    }
    if ((paramInt1 == 4) && (paramInt2 == -3002))
    {
      if (bu.isNullOrNil(paramString))
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WorkerProfile", "summerdiz -3002 but errMsg is null");
        AppMethodBeat.o(19599);
        return;
      }
      paramn = paramString;
      if (paramString.startsWith("autoauth_errmsg_")) {
        paramn = paramString.substring(16);
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WorkerProfile", "summerdiz MM_ERR_IDCDISASTER -3002 errStr:%s", new Object[] { paramn });
      paramString = new com.tencent.mm.g.a.ap();
      paramString.dmn.type = 4;
      paramString.dmn.dmp = paramn;
      com.tencent.mm.sdk.b.a.IvT.l(paramString);
      AppMethodBeat.o(19599);
      return;
    }
    if ((bc.ajM()) && (paramInt1 == 4) && ((paramInt2 == -6) || (paramInt2 == -310) || (paramInt2 == -311)) && (paramString != null) && (paramString.startsWith("autoauth_errmsg_")))
    {
      if (NewTaskUI.fOU() != null)
      {
        AppMethodBeat.o(19599);
        return;
      }
      paramn = new Intent();
      paramn.setClass(com.tencent.mm.sdk.platformtools.ak.getContext(), NewTaskUI.class).addFlags(268435456);
      paramString = com.tencent.mm.sdk.platformtools.ak.getContext();
      paramn = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.ahE(), "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)paramn.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(19599);
      return;
    }
    if ((paramn.getType() == 701) || (paramn.getType() == 702) || (paramn.getType() == 126) || (paramn.getType() == 252) || (paramn.getType() == 763) || (paramn.getType() == 138))
    {
      if ((paramInt1 == 4) && (paramInt2 == -213))
      {
        paramn = new lk();
        paramn.dzN.status = 0;
        paramn.dzN.reason = 3;
        com.tencent.mm.sdk.b.a.IvT.l(paramn);
        if (AccountDeletedAlphaAlertUI.fOt() != null)
        {
          AppMethodBeat.o(19599);
          return;
        }
        paramn = new Intent();
        paramn.setClass(com.tencent.mm.sdk.platformtools.ak.getContext(), AccountDeletedAlphaAlertUI.class).addFlags(268435456);
        paramn.putExtra("errmsg", paramString);
        paramString = com.tencent.mm.sdk.platformtools.ak.getContext();
        paramn = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.ahE(), "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramn.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19599);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 == -100))
      {
        paramString = new lk();
        paramString.dzN.status = 0;
        paramString.dzN.reason = 1;
        com.tencent.mm.sdk.b.a.IvT.l(paramString);
      }
    }
    AppMethodBeat.o(19599);
  }
  
  public final void onTerminate()
  {
    AppMethodBeat.i(19594);
    super.onTerminate();
    com.tencent.mm.h.b localb = this.cWU;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BroadcastController", "summerdiz release oldNoticeInfo[%s], newDisasterNoticeInfoMap[%d]", new Object[] { localb.fJN, Integer.valueOf(localb.fJP.size()) });
    com.tencent.mm.sdk.b.a.IvT.d(localb.fJQ);
    localb.fJN = null;
    localb.fJO.clear();
    localb.fJP.clear();
    this.cWU = null;
    AppMethodBeat.o(19594);
  }
  
  public final String toString()
  {
    return cUu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile
 * JD-Core Version:    0.7.0.1
 */