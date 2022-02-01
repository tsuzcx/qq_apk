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
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.w;
import com.tencent.mm.ak.w.a;
import com.tencent.mm.api.l;
import com.tencent.mm.console.Shell;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.g.a.st;
import com.tencent.mm.g.a.va;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.g.a.wa;
import com.tencent.mm.g.a.wz;
import com.tencent.mm.kiss.a.b.2;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.n.b.a;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.IKVReportNotify;
import com.tencent.mm.pluginsdk.g.e.a;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bdw;
import com.tencent.mm.protocal.protobuf.bdx;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bk.b;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI;
import com.tencent.mm.ui.tools.NewTaskUI;
import java.io.File;
import java.util.Locale;
import java.util.Map;

public final class WorkerProfile
  extends com.tencent.mm.compatible.loader.d
  implements com.tencent.mm.ak.g, w.a, m, com.tencent.mm.model.ap, com.tencent.mm.model.f.a, IKVReportNotify
{
  public static final String cIB;
  private static int cKN;
  private static WorkerProfile cKx;
  private final int ID;
  private ah cKA;
  public boolean cKB;
  @Deprecated
  public boolean cKC;
  public boolean cKD;
  private final int cKE;
  private final int cKF;
  private int cKG;
  private StringBuilder cKH;
  private com.tencent.mm.booter.notification.a.g cKI;
  private boolean cKJ;
  private com.tencent.mm.h.b cKK;
  public final ak cKL;
  public final aj cKM;
  private final Shell cKv;
  private final com.tencent.mm.console.a cKw;
  private aq cKy;
  private bk.b cKz;
  protected Locale locale;
  
  static
  {
    AppMethodBeat.i(19603);
    cIB = ai.getPackageName();
    cKN = -1;
    AppMethodBeat.o(19603);
  }
  
  public WorkerProfile()
  {
    AppMethodBeat.i(19592);
    this.cKv = new Shell();
    this.cKw = new com.tencent.mm.console.a();
    this.cKB = false;
    this.cKE = 0;
    this.cKF = 1;
    this.ID = 2130706432;
    this.cKH = new StringBuilder();
    this.cKJ = true;
    this.cKL = new ak();
    this.cKM = new aj();
    cKx = this;
    AppMethodBeat.o(19592);
  }
  
  public static WorkerProfile Lr()
  {
    return cKx;
  }
  
  public final void Kt()
  {
    this.cKJ = true;
  }
  
  public final void Ku()
  {
    this.cKJ = false;
  }
  
  public final bk.b Ls()
  {
    AppMethodBeat.i(19597);
    if (this.cKz == null) {
      this.cKz = new bk.b()
      {
        public final String a(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, Context paramAnonymousContext)
        {
          AppMethodBeat.i(19583);
          paramAnonymousString1 = com.tencent.mm.booter.notification.a.h.a(paramAnonymousInt1, paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousContext);
          AppMethodBeat.o(19583);
          return paramAnonymousString1;
        }
        
        public final void a(bo paramAnonymousbo, PString paramAnonymousPString1, PString paramAnonymousPString2, PInt paramAnonymousPInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(19582);
          com.tencent.mm.booter.notification.a.h.b(paramAnonymousbo, paramAnonymousPString1, paramAnonymousPString2, paramAnonymousPInt, paramAnonymousBoolean);
          AppMethodBeat.o(19582);
        }
      };
    }
    bk.b localb = this.cKz;
    AppMethodBeat.o(19597);
    return localb;
  }
  
  public final ah Lt()
  {
    AppMethodBeat.i(19598);
    if (this.cKA == null) {
      this.cKA = com.tencent.mm.booter.a.Uc();
    }
    ah localah = this.cKA;
    AppMethodBeat.o(19598);
    return localah;
  }
  
  public final void eF(String paramString)
  {
    AppMethodBeat.i(19601);
    ac.i("MicroMsg.WorkerProfile", "summerdiz onOldDisaster errStr[%s]", new Object[] { paramString });
    com.tencent.mm.g.a.ap localap = new com.tencent.mm.g.a.ap();
    localap.cZT.type = 4;
    localap.cZT.cZV = paramString;
    com.tencent.mm.sdk.b.a.GpY.l(localap);
    AppMethodBeat.o(19601);
  }
  
  public final void eG(String paramString)
  {
    AppMethodBeat.i(19602);
    ac.i("MicroMsg.WorkerProfile", "summerdiz onReMoveNoticeId:%s", new Object[] { paramString });
    com.tencent.mm.g.a.ap localap = new com.tencent.mm.g.a.ap();
    localap.cZT.type = 1;
    localap.cZT.cZV = paramString;
    com.tencent.mm.sdk.b.a.GpY.l(localap);
    AppMethodBeat.o(19602);
  }
  
  public final aq getNotification()
  {
    AppMethodBeat.i(19596);
    if (this.cKy == null) {
      this.cKy = new com.tencent.mm.booter.notification.b(this.app);
    }
    aq localaq = this.cKy;
    AppMethodBeat.o(19596);
    return localaq;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(19595);
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences(ai.eUX(), 0);
    ai.getContext();
    if ("language_default".equals(ab.g(localSharedPreferences)))
    {
      ac.i("MicroMsg.WorkerProfile", "config locale %s", new Object[] { ab.d(paramConfiguration.locale) });
      paramConfiguration = MMActivity.initLanguage(this.app.getBaseContext(), ab.d(paramConfiguration.locale));
      ac.i("MicroMsg.WorkerProfile", "onConfigurationChanged, locale = %s, n = %s", new Object[] { this.locale, paramConfiguration });
      if ((paramConfiguration != null) && (this.locale != null) && (!paramConfiguration.equals(this.locale)) && (!az.agM())) {}
    }
    try
    {
      paramConfiguration = az.agi().hwg;
      if (paramConfiguration != null)
      {
        paramConfiguration = paramConfiguration.aBZ();
        if (paramConfiguration != null)
        {
          az.ayM();
          int i = com.tencent.mm.model.c.getUin();
          paramConfiguration.a(new byte[0], new byte[0], new byte[0], i);
        }
      }
    }
    catch (Exception paramConfiguration)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.WorkerProfile", paramConfiguration, "", new Object[0]);
        ac.printErrStackTrace("MicroMsg.WorkerProfile", paramConfiguration, "what the f$!k", new Object[0]);
      }
    }
    ac.w("MicroMsg.WorkerProfile", "language changed, restart process");
    com.tencent.mm.bv.a.hC(ai.getContext());
    System.exit(-1);
    AppMethodBeat.o(19595);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(19593);
    long l2 = System.currentTimeMillis();
    ac.v("MicroMsg.WorkerProfile", "workerProfile onCreate, step 1");
    com.tencent.mm.plugin.hp.tinker.i.cTv();
    ac.i("MicroMsg.WorkerProfile", "start time check onCreate proc:%s pid:%d" + cIB + Process.myPid());
    ac.i("MicroMsg.WorkerProfile", "appOnCreate start getAccStg %b, thread name %s", new Object[] { Boolean.TRUE, Thread.currentThread().getName() });
    l1 = System.currentTimeMillis();
    com.tencent.mm.model.d.a.aAs();
    az.agi().a(-1, this);
    w.a(this);
    az.ayO().hmv = this;
    az.a(new WorkerProfile.12(this));
    az.getSysCmdMsgExtension().a("getkvidkeystg", new cc.a()
    {
      public final void a(com.tencent.mm.ak.f.a paramAnonymousa)
      {
        AppMethodBeat.i(19570);
        com.tencent.mm.plugin.report.service.j.arD(z.a(paramAnonymousa.fXi.DPV));
        AppMethodBeat.o(19570);
      }
      
      public final void a(f.c paramAnonymousc) {}
    }, true);
    Object localObject1 = this.app;
    com.tencent.mm.sdk.platformtools.i.ip((Context)localObject1);
    com.tencent.mm.sdk.platformtools.i.iq((Context)localObject1);
    Object localObject3 = ((Context)localObject1).getPackageManager();
    for (;;)
    {
      try
      {
        localObject1 = ((PackageManager)localObject3).getPackageInfo(((Context)localObject1).getPackageName(), 0).applicationInfo.sourceDir;
        ac.i("MicroMsg.WorkerProfile", "initChannelUtil sourceFile = %s", new Object[] { localObject1 });
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        ac.e("MicroMsg.WorkerProfile", "initChannelUtil NameNotFoundException");
        continue;
        if (localException2.cGX + 8 - 8 < 0) {
          continue;
        }
        com.tencent.mm.d.b localb = new com.tencent.mm.d.b();
        localb.parseFrom(com.tencent.mm.vfs.i.aU(localNameNotFoundException, i - (localException2.cGX + 8 - 8) - 8, localException2.cGX + 8 - 8));
        new com.tencent.mm.d.a(localb);
        ac.i("MicroMsg.WorkerProfile", "checkApkExternal, check ok");
        continue;
        ac.e("MicroMsg.WorkerProfile", "checkApkExternal header wrong");
        continue;
        if (localNameNotFoundException != null) {
          continue;
        }
        bool = true;
        ac.e("MicroMsg.WorkerProfile", "initChannelUtil something null %s", new Object[] { Boolean.valueOf(bool) });
        continue;
      }
      catch (Exception localException1)
      {
        int j;
        ac.e("MicroMsg.WorkerProfile", "Exception in initChannel, %s", new Object[] { localException1.getMessage() });
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
        String str = com.tencent.mm.sdk.platformtools.i.cGZ;
        continue;
        l1 = 6L;
        continue;
        int i = 5002;
        continue;
      }
      try
      {
        i = (int)com.tencent.mm.vfs.i.aSp((String)localObject1);
        ac.i("MicroMsg.WorkerProfile", "checkApkExternal, fileSize = %s", new Object[] { Integer.valueOf(i) });
        if (i >= 8) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        ac.printErrStackTrace("MicroMsg.WorkerProfile", localException2, "", new Object[0]);
        ac.e("MicroMsg.WorkerProfile", "Exception in checkApkExternal, %s", new Object[] { localException2.getMessage() });
        continue;
      }
      localObject1 = com.tencent.mm.d.a.ea((String)localObject1);
      if ((localObject1 == null) || (((com.tencent.mm.d.a)localObject1).cGV == null)) {
        continue;
      }
      ac.i("MicroMsg.WorkerProfile", "apk external info not null");
      if (((com.tencent.mm.d.a)localObject1).cGV.cGY != 0)
      {
        com.tencent.mm.sdk.platformtools.i.cGY = ((com.tencent.mm.d.a)localObject1).cGV.cGY;
        ac.i("MicroMsg.WorkerProfile", "read channelId from apk external");
      }
      if (((com.tencent.mm.d.a)localObject1).cGV.cHa != 0)
      {
        com.tencent.mm.sdk.platformtools.i.cHa = ((com.tencent.mm.d.a)localObject1).cGV.cHa;
        ac.i("MicroMsg.WorkerProfile", "ext.updateMode = %s", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.i.cHa) });
      }
      if (((com.tencent.mm.d.a)localObject1).cGV.cHb != null) {
        com.tencent.mm.sdk.platformtools.i.GqH = bs.getInt(((com.tencent.mm.d.a)localObject1).cGV.cHb, 0);
      }
      if (((com.tencent.mm.d.a)localObject1).cGV.cHc != null) {
        com.tencent.mm.sdk.platformtools.i.GqI = ((com.tencent.mm.d.a)localObject1).cGV.cHc;
      }
      if (((com.tencent.mm.d.a)localObject1).cGV.cGZ != null) {
        com.tencent.mm.sdk.platformtools.i.cGZ = ((com.tencent.mm.d.a)localObject1).cGV.cGZ;
      }
      if (((com.tencent.mm.d.a)localObject1).cGV.cHf)
      {
        com.tencent.mm.sdk.platformtools.i.GqM = ((com.tencent.mm.d.a)localObject1).cGV.cHf;
        ac.i("MicroMsg.WorkerProfile", "ext.isNokiaol = %s", new Object[] { Boolean.valueOf(com.tencent.mm.sdk.platformtools.i.GqM) });
      }
      if (((com.tencent.mm.d.a)localObject1).cGV.cHe != 0)
      {
        com.tencent.mm.sdk.platformtools.i.cHe = ((com.tencent.mm.d.a)localObject1).cGV.cHe;
        ac.i("MicroMsg.WorkerProfile", "ext.autoAddAccount = %s", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.i.cHe) });
      }
      if (((com.tencent.mm.d.a)localObject1).cGV.cHd)
      {
        com.tencent.mm.sdk.platformtools.i.GqL = ((com.tencent.mm.d.a)localObject1).cGV.cHd;
        ac.i("MicroMsg.WorkerProfile", "ext.shouldShowGprsAlert = %s", new Object[] { Boolean.valueOf(com.tencent.mm.sdk.platformtools.i.GqL) });
      }
      f.Kk();
      localObject1 = com.tencent.mm.booter.d.bK(this.app);
      if ((localObject1 != null) && (((com.tencent.mm.booter.d)localObject1).flW != -1)) {
        com.tencent.mm.sdk.platformtools.i.cGY = ((com.tencent.mm.booter.d)localObject1).flW;
      }
      localObject1 = this.app.getApplicationContext();
      i = com.tencent.mm.sdk.platformtools.i.cGY;
      j = com.tencent.mm.protocal.d.DIc;
      if ((localObject1 != null) && (i >= 0) && (j >= 637534208)) {
        continue;
      }
      if (com.tencent.mm.sdk.platformtools.i.GqH > 0) {
        com.tencent.mm.sdk.platformtools.i.GqJ = true;
      }
      com.tencent.mm.br.d.eQD();
      localObject3 = new StringBuilder("android-");
      if (!bs.isNullOrNil(com.tencent.mm.sdk.platformtools.i.cGZ)) {
        continue;
      }
      localObject1 = Integer.valueOf(Build.VERSION.SDK_INT);
      com.tencent.mm.protocal.d.gMK = localObject1;
      if (!bs.isNullOrNil(com.tencent.mm.sdk.a.b.eUl())) {
        com.tencent.mm.protocal.d.gMK = "android-" + com.tencent.mm.sdk.a.b.eUl();
      }
      ac.v("MicroMsg.WorkerProfile", "set device type :%s  %s", new Object[] { com.tencent.mm.protocal.d.gMK, com.tencent.mm.sdk.a.b.eUl() });
      this.locale = MMActivity.initLanguage(this.app.getBaseContext());
      if (com.tencent.mm.sdk.a.b.eUk()) {
        this.cKv.init(ai.getContext());
      }
      localObject1 = this.cKw;
      com.tencent.mm.sdk.b.a.GpY.c((com.tencent.mm.sdk.b.c)localObject1);
      localObject1 = new e();
      ac.d("MicroMsg.AvatarDrawable", "setLoader".concat(String.valueOf(localObject1)));
      com.tencent.mm.pluginsdk.ui.a.b.vQR = (i.a)localObject1;
      com.tencent.mm.pluginsdk.g.e.DjW = new e.a()
      {
        public final boolean Lw()
        {
          AppMethodBeat.i(163173);
          com.tencent.mm.plugin.finder.view.whatnews.a locala = com.tencent.mm.plugin.finder.view.whatnews.a.sbA;
          boolean bool = ((Boolean)com.tencent.mm.plugin.finder.view.whatnews.a.sbz.getValue()).booleanValue();
          AppMethodBeat.o(163173);
          return bool;
        }
        
        public final void bA(Context paramAnonymousContext)
        {
          AppMethodBeat.i(19578);
          MMAppMgr.bA(paramAnonymousContext);
          AppMethodBeat.o(19578);
        }
        
        public final void bz(Context paramAnonymousContext)
        {
          AppMethodBeat.i(19576);
          MMAppMgr.m(paramAnonymousContext, true);
          AppMethodBeat.o(19576);
        }
        
        public final void m(Context paramAnonymousContext, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(19577);
          MMAppMgr.m(paramAnonymousContext, paramAnonymousBoolean);
          AppMethodBeat.o(19577);
        }
      };
      com.tencent.mm.kernel.g.a(com.tencent.mm.ak.j.class, new com.tencent.mm.kernel.c.e(this.cKM));
      com.tencent.mm.kernel.g.a(l.class, new com.tencent.mm.kernel.c.e(this.cKM));
      com.tencent.mm.kernel.g.b(com.tencent.mm.api.o.class, new com.tencent.mm.model.m());
      com.tencent.mm.kernel.g.a(com.tencent.mm.pluginsdk.j.class, new com.tencent.mm.kernel.c.e(this.cKM));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.brandservice.a.a.class, new com.tencent.mm.plugin.bbom.d());
      com.tencent.mm.kernel.g.b(com.tencent.mm.pluginsdk.o.class, new com.tencent.mm.app.plugin.d());
      com.tencent.mm.kernel.g.b(com.tencent.mm.choosemsgfile.compat.b.class, new com.tencent.mm.ui.chatting.b.a());
      com.tencent.mm.kernel.g.b(m.class, this);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.appbrand.service.e.class, new com.tencent.mm.ui.appbrand.a());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.appbrand.service.h.class, new com.tencent.mm.ui.appbrand.c());
      com.tencent.mm.sdk.b.a.GpY.c(new com.tencent.mm.app.plugin.b.a.a());
      if (this.cKy == null) {
        this.cKy = new com.tencent.mm.booter.notification.b(this.app);
      }
      this.cKK = new com.tencent.mm.h.b();
      localObject1 = this.cKK;
      ac.i("MicroMsg.BroadcastController", "summerdiz init");
      com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.h.b)localObject1).fpF);
      localObject1 = com.tencent.mm.kiss.a.b.ahR();
      com.tencent.mm.sdk.b.a.GpY.c(new b.2((com.tencent.mm.kiss.a.b)localObject1));
      com.tencent.mm.sdk.b.a.GpY.c(new com.tencent.mm.plugin.account.bind.ui.e());
      com.tencent.mm.sdk.b.a.GpY.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.GpY.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.GpY.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.GpY.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.GpY.c(new WorkerProfile.33(this));
      com.tencent.mm.sdk.b.a.GpY.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.GpY.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.GpY.c(new WorkerProfile.3(this));
      com.tencent.mm.sdk.b.a.GpY.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.GpY.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.GpY.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.GpY.c(new WorkerProfile.7(this));
      com.tencent.mm.sdk.b.a.GpY.c(new WorkerProfile.8(this));
      com.tencent.mm.sdk.b.a.GpY.c(new WorkerProfile.9(this));
      com.tencent.mm.sdk.b.a.GpY.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.GpY.c(new WorkerProfile.11(this));
      com.tencent.mm.sdk.b.a.GpY.c(new WorkerProfile.13(this));
      com.tencent.mm.sdk.b.a.GpY.c(new WorkerProfile.14(this));
      com.tencent.mm.sdk.b.a.GpY.c(new WorkerProfile.15(this));
      com.tencent.mm.sdk.b.a.GpY.c(new WorkerProfile.16(this));
      com.tencent.mm.sdk.b.a.GpY.c(new WorkerProfile.17(this));
      com.tencent.mm.sdk.b.a.GpY.c(new WorkerProfile.18(this));
      com.tencent.mm.sdk.b.a.GpY.c(new com.tencent.mm.sdk.b.c()
      {
        private boolean Lu()
        {
          AppMethodBeat.i(19564);
          az.agi().a(1145, new com.tencent.mm.ak.g()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.n paramAnonymous2n)
            {
              AppMethodBeat.i(19563);
              az.agi().b(1145, this);
              ac.i("MicroMsg.WorkerProfile", "onSceneEnd(GetServiceNotifyOptions), errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                AppMethodBeat.o(19563);
                return;
              }
              if (paramAnonymous2n.getType() != 1145)
              {
                AppMethodBeat.o(19563);
                return;
              }
              paramAnonymous2String = (r)paramAnonymous2n;
              if ((((bdw)paramAnonymous2String.hse.hvr.hvw).ETI & 0x1) == 0)
              {
                AppMethodBeat.o(19563);
                return;
              }
              boolean bool = paramAnonymous2String.aAK().DXz;
              az.ayM();
              if (bool != com.tencent.mm.model.c.agA().getBoolean(ah.a.GJO, true))
              {
                ac.i("MicroMsg.WorkerProfile", "service notify message notice switch changed(to : %b)", new Object[] { Boolean.valueOf(bool) });
                az.ayM();
                com.tencent.mm.model.c.agA().set(ah.a.GJO, Boolean.valueOf(bool));
                com.tencent.mm.sdk.b.a.GpY.l(new qc());
              }
              bool = paramAnonymous2String.aAK().ETJ;
              az.ayM();
              if (bool != com.tencent.mm.model.c.agA().getBoolean(ah.a.GJP, true))
              {
                ac.i("MicroMsg.WorkerProfile", "wxa custom session notify message notice switch changed(to : %b)", new Object[] { Boolean.valueOf(bool) });
                az.ayM();
                com.tencent.mm.model.c.agA().set(ah.a.GJP, Boolean.valueOf(bool));
                com.tencent.mm.sdk.b.a.GpY.l(new qc());
              }
              AppMethodBeat.o(19563);
            }
          });
          az.agi().a(new r(5), 0);
          AppMethodBeat.o(19564);
          return true;
        }
      });
      com.tencent.mm.sdk.b.a.GpY.c(new WorkerProfile.20(this));
      com.tencent.mm.sdk.b.a.GpY.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.GpY.c(new u(2, 12));
      new ae().alive();
      com.tencent.mm.sdk.b.a.GpY.b(new com.tencent.mm.sdk.b.c()
      {
        private static boolean Lv()
        {
          AppMethodBeat.i(19568);
          ac.i("MicroMsg.WorkerProfile", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
          MMAppMgr.fgM();
          Process.killProcess(Process.myPid());
          AppMethodBeat.o(19568);
          return true;
        }
      });
      com.tencent.mm.plugin.messenger.a.j.uGj = new com.tencent.mm.ui.transmit.d();
      com.tencent.mm.pluginsdk.p.a.DfG = new com.tencent.mm.app.plugin.a();
      com.tencent.mm.pluginsdk.ui.span.c.a.DBW = com.tencent.mm.app.plugin.e.Lz();
      if (!az.afS()) {
        az.ayM();
      }
      localObject1 = new cr();
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      this.cKB = true;
      Log.setLogImpl(new WorkerProfile.24(this));
      ac.d("MicroMsg.WorkerProfile", "start time check WorkerProfile appOnCreate use time " + (System.currentTimeMillis() - l1));
      localObject1 = new WorkerProfile.26(ai.getContext());
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
      ((WorkerProfile.26)localObject1).cKT.put("weixin", Integer.valueOf(2131761778));
      com.tencent.mm.n.b.a((b.a)localObject1);
      an.a(new WorkerProfile.1(this));
      if (!com.tencent.mm.compatible.util.e.YD())
      {
        localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
        if (!com.tencent.mm.compatible.util.d.kZ(19)) {
          continue;
        }
        l1 = 5L;
        ((com.tencent.mm.plugin.report.service.h)localObject1).idkeyStat(340L, l1, 1L, false);
        localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
        if (!com.tencent.mm.compatible.util.d.kZ(19)) {
          continue;
        }
        i = 5001;
        ((com.tencent.mm.plugin.report.service.h)localObject1).f(11098, new Object[] { Integer.valueOf(i), String.format("%s;%s;%s", new Object[] { com.tencent.mm.loader.j.b.apb(), Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.mm.compatible.util.g.getExternalStorageDirectory().getAbsolutePath() }) });
      }
      ac.i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), Boolean.valueOf(this.cKC), Integer.valueOf(com.tencent.mm.sdk.platformtools.i.cGY), Integer.valueOf(com.tencent.mm.protocal.d.DIc), bs.jd(ai.getContext()) });
      AppMethodBeat.o(19593);
      return;
      localObject3 = com.tencent.mm.d.a.a.G(com.tencent.mm.vfs.i.aU((String)localObject1, i - 8, 8));
      if (localObject3 != null) {
        continue;
      }
      ac.e("MicroMsg.WorkerProfile", "checkApkExternal, header null");
    }
  }
  
  public final void onReportKVDataReady(byte[] paramArrayOfByte1, final byte[] paramArrayOfByte2, final int paramInt)
  {
    AppMethodBeat.i(19600);
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19584);
        if (az.ayF())
        {
          AppMethodBeat.o(19584);
          return;
        }
        ac.i("MicroMsg.WorkerProfile", "summeranrt onReportKVDataReady channel:" + paramInt);
        com.tencent.mm.plugin.report.c.e locale = new com.tencent.mm.plugin.report.c.e(paramArrayOfByte2, paramInt);
        az.agi().a(locale, 0);
        AppMethodBeat.o(19584);
      }
    });
    AppMethodBeat.o(19600);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(19599);
    ac.i("MicroMsg.WorkerProfile", "onSceneEnd dkwt type:%d [%d,%d,%s]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 3) && (paramInt2 == -1)) {
      ac.i("MicroMsg.WorkerProfile", "getStack([ %s ]), ThreadID: %s", new Object[] { bs.eWi(), Long.valueOf(Thread.currentThread().getId()) });
    }
    if ((paramInt1 == 4) && (paramInt2 == -3002))
    {
      if (bs.isNullOrNil(paramString))
      {
        ac.e("MicroMsg.WorkerProfile", "summerdiz -3002 but errMsg is null");
        AppMethodBeat.o(19599);
        return;
      }
      paramn = paramString;
      if (paramString.startsWith("autoauth_errmsg_")) {
        paramn = paramString.substring(16);
      }
      ac.i("MicroMsg.WorkerProfile", "summerdiz MM_ERR_IDCDISASTER -3002 errStr:%s", new Object[] { paramn });
      paramString = new com.tencent.mm.g.a.ap();
      paramString.cZT.type = 4;
      paramString.cZT.cZV = paramn;
      com.tencent.mm.sdk.b.a.GpY.l(paramString);
      AppMethodBeat.o(19599);
      return;
    }
    if ((az.agM()) && (paramInt1 == 4) && ((paramInt2 == -6) || (paramInt2 == -310) || (paramInt2 == -311)) && (paramString != null) && (paramString.startsWith("autoauth_errmsg_")))
    {
      if (NewTaskUI.ftQ() != null)
      {
        AppMethodBeat.o(19599);
        return;
      }
      paramn = new Intent();
      paramn.setClass(ai.getContext(), NewTaskUI.class).addFlags(268435456);
      paramString = ai.getContext();
      paramn = new com.tencent.mm.hellhoundlib.b.a().ba(paramn);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.aeD(), "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)paramn.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(19599);
      return;
    }
    if ((paramn.getType() == 701) || (paramn.getType() == 702) || (paramn.getType() == 126) || (paramn.getType() == 252) || (paramn.getType() == 763) || (paramn.getType() == 138))
    {
      if ((paramInt1 == 4) && (paramInt2 == -213))
      {
        paramn = new la();
        paramn.dmU.status = 0;
        paramn.dmU.reason = 3;
        com.tencent.mm.sdk.b.a.GpY.l(paramn);
        if (AccountDeletedAlphaAlertUI.fto() != null)
        {
          AppMethodBeat.o(19599);
          return;
        }
        paramn = new Intent();
        paramn.setClass(ai.getContext(), AccountDeletedAlphaAlertUI.class).addFlags(268435456);
        paramn.putExtra("errmsg", paramString);
        paramString = ai.getContext();
        paramn = new com.tencent.mm.hellhoundlib.b.a().ba(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.aeD(), "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramn.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19599);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 == -100))
      {
        paramString = new la();
        paramString.dmU.status = 0;
        paramString.dmU.reason = 1;
        com.tencent.mm.sdk.b.a.GpY.l(paramString);
      }
    }
    AppMethodBeat.o(19599);
  }
  
  public final void onTerminate()
  {
    AppMethodBeat.i(19594);
    super.onTerminate();
    com.tencent.mm.h.b localb = this.cKK;
    ac.i("MicroMsg.BroadcastController", "summerdiz release oldNoticeInfo[%s], newDisasterNoticeInfoMap[%d]", new Object[] { localb.fpC, Integer.valueOf(localb.fpE.size()) });
    com.tencent.mm.sdk.b.a.GpY.d(localb.fpF);
    localb.fpC = null;
    localb.fpD.clear();
    localb.fpE.clear();
    this.cKK = null;
    AppMethodBeat.o(19594);
  }
  
  public final String toString()
  {
    return cIB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile
 * JD-Core Version:    0.7.0.1
 */