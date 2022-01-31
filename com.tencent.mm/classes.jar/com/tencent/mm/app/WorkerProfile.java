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
import com.tencent.mm.ai.i;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.ai.v.a;
import com.tencent.mm.console.Shell;
import com.tencent.mm.console.Shell.Receiver;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.g.a.le;
import com.tencent.mm.kiss.a.b.2;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.am;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.d.a.1;
import com.tencent.mm.model.d.a.2;
import com.tencent.mm.model.f.a;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.plugin.report.service.IKVReportNotify;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI;
import com.tencent.mm.ui.tools.NewTaskUI;
import java.io.File;
import java.util.Locale;
import java.util.Map;

public final class WorkerProfile
  extends com.tencent.mm.compatible.loader.e
  implements com.tencent.mm.ai.f, v.a, am, f.a, IKVReportNotify
{
  public static final String bXW;
  private static int bZO;
  private static WorkerProfile bZz;
  private final int ID;
  private an bZA;
  private be.b bZB;
  private ae bZC;
  public boolean bZD;
  @Deprecated
  public boolean bZE;
  public boolean bZF;
  private final int bZG;
  private final int bZH;
  private int bZI;
  private StringBuilder bZJ;
  private com.tencent.mm.booter.notification.a.g bZK;
  private com.tencent.mm.h.b bZL;
  public final ab bZM;
  public final aa bZN;
  private final Shell bZx;
  private final com.tencent.mm.console.a bZy;
  protected Locale locale;
  
  static
  {
    AppMethodBeat.i(15558);
    bXW = ah.getPackageName();
    bZO = -1;
    AppMethodBeat.o(15558);
  }
  
  public WorkerProfile()
  {
    AppMethodBeat.i(15547);
    this.bZx = new Shell();
    this.bZy = new com.tencent.mm.console.a();
    this.bZD = false;
    this.bZG = 0;
    this.bZH = 1;
    this.ID = 2130706432;
    this.bZJ = new StringBuilder();
    this.bZM = new ab();
    this.bZN = new aa();
    bZz = this;
    AppMethodBeat.o(15547);
  }
  
  public static WorkerProfile BW()
  {
    return bZz;
  }
  
  public final be.b BX()
  {
    AppMethodBeat.i(15552);
    if (this.bZB == null) {
      this.bZB = new WorkerProfile.28(this);
    }
    be.b localb = this.bZB;
    AppMethodBeat.o(15552);
    return localb;
  }
  
  public final ae BY()
  {
    AppMethodBeat.i(15553);
    if (this.bZC == null) {
      this.bZC = com.tencent.mm.booter.a.Ia();
    }
    ae localae = this.bZC;
    AppMethodBeat.o(15553);
    return localae;
  }
  
  public final void dI(String paramString)
  {
    AppMethodBeat.i(15556);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "summerdiz onOldDisaster errStr[%s]", new Object[] { paramString });
    com.tencent.mm.g.a.ak localak = new com.tencent.mm.g.a.ak();
    localak.cnA.type = 4;
    localak.cnA.cnC = paramString;
    com.tencent.mm.sdk.b.a.ymk.l(localak);
    AppMethodBeat.o(15556);
  }
  
  public final void dJ(String paramString)
  {
    AppMethodBeat.i(15557);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "summerdiz onReMoveNoticeId:%s", new Object[] { paramString });
    com.tencent.mm.g.a.ak localak = new com.tencent.mm.g.a.ak();
    localak.cnA.type = 1;
    localak.cnA.cnC = paramString;
    com.tencent.mm.sdk.b.a.ymk.l(localak);
    AppMethodBeat.o(15557);
  }
  
  public final an getNotification()
  {
    AppMethodBeat.i(15551);
    if (this.bZA == null) {
      this.bZA = new com.tencent.mm.booter.notification.b(this.app);
    }
    an localan = this.bZA;
    AppMethodBeat.o(15551);
    return localan;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(15550);
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences(ah.dsP(), 0);
    ah.getContext();
    if ("language_default".equals(com.tencent.mm.sdk.platformtools.aa.g(localSharedPreferences)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "config locale %s", new Object[] { com.tencent.mm.sdk.platformtools.aa.c(paramConfiguration.locale) });
      paramConfiguration = MMActivity.initLanguage(this.app.getBaseContext(), com.tencent.mm.sdk.platformtools.aa.c(paramConfiguration.locale));
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "onConfigurationChanged, locale = %s, n = %s", new Object[] { this.locale, paramConfiguration });
      if ((paramConfiguration != null) && (this.locale != null) && (!paramConfiguration.equals(this.locale)) && (!aw.RG())) {}
    }
    try
    {
      paramConfiguration = aw.Rc().ftA;
      if (paramConfiguration != null)
      {
        paramConfiguration = paramConfiguration.adI();
        if (paramConfiguration != null)
        {
          aw.aaz();
          int i = com.tencent.mm.model.c.getUin();
          paramConfiguration.a(new byte[0], new byte[0], new byte[0], i);
        }
      }
    }
    catch (Exception paramConfiguration)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.WorkerProfile", paramConfiguration, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.WorkerProfile", paramConfiguration, "what the f$!k", new Object[0]);
      }
    }
    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WorkerProfile", "language changed, restart process");
    com.tencent.mm.bu.a.ge(ah.getContext());
    System.exit(-1);
    AppMethodBeat.o(15550);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(15548);
    long l2 = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.WorkerProfile", "workerProfile onCreate, step 1");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "start time check onCreate proc:%s pid:%d" + bXW + Process.myPid());
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "appOnCreate start getAccStg %b, thread name %s", new Object[] { Boolean.TRUE, Thread.currentThread().getName() });
    l1 = System.currentTimeMillis();
    Object localObject1 = com.tencent.mm.model.d.a.abX();
    com.tencent.mm.model.d.a.bYw = bXW;
    if (ah.ynK) {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.HandlerTraceManager", "trace setup delete old file ret: ".concat(String.valueOf(com.tencent.mm.a.e.deleteFile(com.tencent.mm.model.d.a.fpb))));
    }
    ((com.tencent.mm.model.d.a)localObject1).fpq = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.ak.setLogCallback(new a.1((com.tencent.mm.model.d.a)localObject1));
    ao.a("NetsceneQueue forbid in ", new a.2((com.tencent.mm.model.d.a)localObject1));
    aw.Rc().a(-1, this);
    com.tencent.mm.ai.v.a(this);
    aw.aaC().fkM = this;
    aw.a(new WorkerProfile.12(this));
    aw.getSysCmdMsgExtension().a("getkvidkeystg", new WorkerProfile.23(this), true);
    localObject1 = this.app;
    com.tencent.mm.sdk.platformtools.g.gC((Context)localObject1);
    com.tencent.mm.sdk.platformtools.g.gD((Context)localObject1);
    Object localObject3 = ((Context)localObject1).getPackageManager();
    for (;;)
    {
      try
      {
        localObject1 = ((PackageManager)localObject3).getPackageInfo(((Context)localObject1).getPackageName(), 0).applicationInfo.sourceDir;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "initChannelUtil sourceFile = %s", new Object[] { localObject1 });
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WorkerProfile", "initChannelUtil NameNotFoundException");
        continue;
        if (localException2.bWt + 8 - 8 < 0) {
          continue;
        }
        com.tencent.mm.c.b localb = new com.tencent.mm.c.b();
        localb.parseFrom(com.tencent.mm.a.e.j(localNameNotFoundException, i - (localException2.bWt + 8 - 8) - 8, localException2.bWt + 8 - 8));
        new com.tencent.mm.c.a(localb);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "checkApkExternal, check ok");
        continue;
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WorkerProfile", "checkApkExternal header wrong");
        continue;
        if (localNameNotFoundException != null) {
          continue;
        }
        bool = true;
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WorkerProfile", "initChannelUtil something null %s", new Object[] { Boolean.valueOf(bool) });
        continue;
      }
      catch (Exception localException1)
      {
        int j;
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WorkerProfile", "Exception in initChannel, %s", new Object[] { localException1.getMessage() });
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
        String str = com.tencent.mm.sdk.platformtools.g.bWv;
        continue;
        l1 = 6L;
        continue;
        int i = 5002;
        continue;
      }
      try
      {
        i = com.tencent.mm.a.e.cM((String)localObject1);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "checkApkExternal, fileSize = %s", new Object[] { Integer.valueOf(i) });
        if (i >= 8) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.WorkerProfile", localException2, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WorkerProfile", "Exception in checkApkExternal, %s", new Object[] { localException2.getMessage() });
        continue;
      }
      localObject1 = com.tencent.mm.c.a.dn((String)localObject1);
      if ((localObject1 == null) || (((com.tencent.mm.c.a)localObject1).bWr == null)) {
        continue;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "apk external info not null");
      if (((com.tencent.mm.c.a)localObject1).bWr.bWu != 0)
      {
        com.tencent.mm.sdk.platformtools.g.bWu = ((com.tencent.mm.c.a)localObject1).bWr.bWu;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "read channelId from apk external");
      }
      if (((com.tencent.mm.c.a)localObject1).bWr.bWw != 0)
      {
        com.tencent.mm.sdk.platformtools.g.bWw = ((com.tencent.mm.c.a)localObject1).bWr.bWw;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "ext.updateMode = %s", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.g.bWw) });
      }
      if (((com.tencent.mm.c.a)localObject1).bWr.bWx != null) {
        com.tencent.mm.sdk.platformtools.g.ymJ = bo.getInt(((com.tencent.mm.c.a)localObject1).bWr.bWx, 0);
      }
      if (((com.tencent.mm.c.a)localObject1).bWr.bWy != null) {
        com.tencent.mm.sdk.platformtools.g.ymK = ((com.tencent.mm.c.a)localObject1).bWr.bWy;
      }
      if (((com.tencent.mm.c.a)localObject1).bWr.bWv != null) {
        com.tencent.mm.sdk.platformtools.g.bWv = ((com.tencent.mm.c.a)localObject1).bWr.bWv;
      }
      if (((com.tencent.mm.c.a)localObject1).bWr.bWB)
      {
        com.tencent.mm.sdk.platformtools.g.ymO = ((com.tencent.mm.c.a)localObject1).bWr.bWB;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "ext.isNokiaol = %s", new Object[] { Boolean.valueOf(com.tencent.mm.sdk.platformtools.g.ymO) });
      }
      if (((com.tencent.mm.c.a)localObject1).bWr.bWA != 0)
      {
        com.tencent.mm.sdk.platformtools.g.bWA = ((com.tencent.mm.c.a)localObject1).bWr.bWA;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "ext.autoAddAccount = %s", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.g.bWA) });
      }
      if (((com.tencent.mm.c.a)localObject1).bWr.bWz)
      {
        com.tencent.mm.sdk.platformtools.g.ymN = ((com.tencent.mm.c.a)localObject1).bWr.bWz;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "ext.shouldShowGprsAlert = %s", new Object[] { Boolean.valueOf(com.tencent.mm.sdk.platformtools.g.ymN) });
      }
      d.AZ();
      localObject1 = com.tencent.mm.booter.d.bt(this.app);
      if ((localObject1 != null) && (((com.tencent.mm.booter.d)localObject1).dYP != -1)) {
        com.tencent.mm.sdk.platformtools.g.bWu = ((com.tencent.mm.booter.d)localObject1).dYP;
      }
      localObject1 = this.app.getApplicationContext();
      i = com.tencent.mm.sdk.platformtools.g.bWu;
      j = com.tencent.mm.protocal.d.whH;
      if ((localObject1 != null) && (i >= 0) && (j >= 637534208)) {
        continue;
      }
      if (com.tencent.mm.sdk.platformtools.g.ymJ > 0) {
        com.tencent.mm.sdk.platformtools.g.ymL = true;
      }
      com.tencent.mm.bq.d.dpU();
      localObject3 = new StringBuilder("android-");
      if (!bo.isNullOrNil(com.tencent.mm.sdk.platformtools.g.bWv)) {
        continue;
      }
      localObject1 = Integer.valueOf(Build.VERSION.SDK_INT);
      com.tencent.mm.protocal.d.eQs = localObject1;
      if (!bo.isNullOrNil(com.tencent.mm.sdk.a.b.dsg())) {
        com.tencent.mm.protocal.d.eQs = "android-" + com.tencent.mm.sdk.a.b.dsg();
      }
      com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.WorkerProfile", "set device type :%s  %s", new Object[] { com.tencent.mm.protocal.d.eQs, com.tencent.mm.sdk.a.b.dsg() });
      this.locale = MMActivity.initLanguage(this.app.getBaseContext());
      if (com.tencent.mm.sdk.a.b.dsf())
      {
        localObject1 = this.bZx;
        localObject3 = ah.getContext();
        if (((Shell)localObject1).euk == null)
        {
          ((Shell)localObject1).euk = new Shell.Receiver();
          ((Context)localObject3).registerReceiver(((Shell)localObject1).euk, Shell.eum);
        }
      }
      localObject1 = this.bZy;
      com.tencent.mm.sdk.b.a.ymk.c((com.tencent.mm.sdk.b.c)localObject1);
      localObject1 = new c();
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.AvatarDrawable", "setLoader".concat(String.valueOf(localObject1)));
      com.tencent.mm.pluginsdk.ui.a.b.pFL = (i.a)localObject1;
      com.tencent.mm.pluginsdk.f.e.vMF = new WorkerProfile.26(this);
      com.tencent.mm.kernel.g.a(i.class, new com.tencent.mm.kernel.c.e(this.bZN));
      com.tencent.mm.kernel.g.a(com.tencent.mm.pluginsdk.h.class, new com.tencent.mm.kernel.c.e(this.bZN));
      com.tencent.mm.kernel.g.a(j.class, new com.tencent.mm.kernel.c.e(this.bZN));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.brandservice.a.a.class, new com.tencent.mm.plugin.bbom.d());
      com.tencent.mm.kernel.g.b(q.class, new com.tencent.mm.app.plugin.d());
      com.tencent.mm.kernel.g.b(com.tencent.mm.choosemsgfile.compat.b.class, new com.tencent.mm.ui.chatting.b.a());
      com.tencent.mm.sdk.b.a.ymk.c(new com.tencent.mm.app.plugin.b.a.a());
      if (this.bZA == null) {
        this.bZA = new com.tencent.mm.booter.notification.b(this.app);
      }
      this.bZL = new com.tencent.mm.h.b();
      localObject1 = this.bZL;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BroadcastController", "summerdiz init");
      com.tencent.mm.sdk.b.a.ymk.c(((com.tencent.mm.h.b)localObject1).ebY);
      localObject1 = com.tencent.mm.kiss.a.b.SH();
      com.tencent.mm.sdk.b.a.ymk.c(new b.2((com.tencent.mm.kiss.a.b)localObject1));
      com.tencent.mm.sdk.b.a.ymk.c(new com.tencent.mm.plugin.account.bind.ui.e());
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.30(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.31(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.32(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.33(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.34(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.35(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.2(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.3(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.4(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.5(this));
      com.tencent.mm.sdk.b.a.ymk.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.7(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.8(this));
      com.tencent.mm.sdk.b.a.ymk.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.10(this));
      com.tencent.mm.sdk.b.a.ymk.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.13(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.14(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.15(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.16(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.17(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.18(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.19(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.20(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.21(this));
      com.tencent.mm.sdk.b.a.ymk.c(new WorkerProfile.22(this));
      com.tencent.mm.sdk.b.a.ymk.c(new o(2, 12));
      new v().alive();
      com.tencent.mm.sdk.b.a.ymk.b(new WorkerProfile.24(this));
      com.tencent.mm.plugin.messenger.a.g.oCX = new com.tencent.mm.ui.transmit.d();
      com.tencent.mm.pluginsdk.r.a.vJD = new com.tencent.mm.app.plugin.a();
      com.tencent.mm.pluginsdk.ui.d.b.a.wbT = com.tencent.mm.app.plugin.e.Ce();
      if (!aw.QP()) {
        aw.aaz();
      }
      localObject1 = new cl();
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      this.bZD = true;
      Log.setLogImpl(new WorkerProfile.25(this));
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WorkerProfile", "start time check WorkerProfile appOnCreate use time " + (System.currentTimeMillis() - l1));
      localObject1 = new WorkerProfile.27(ah.getContext());
      ((WorkerProfile.27)localObject1).map.put("qqmail", Integer.valueOf(2131300606));
      ((WorkerProfile.27)localObject1).map.put("fmessage", Integer.valueOf(2131300575));
      ((WorkerProfile.27)localObject1).map.put("floatbottle", Integer.valueOf(2131300560));
      ((WorkerProfile.27)localObject1).map.put("lbsapp", Integer.valueOf(2131300583));
      ((WorkerProfile.27)localObject1).map.put("shakeapp", Integer.valueOf(2131300618));
      ((WorkerProfile.27)localObject1).map.put("medianote", Integer.valueOf(2131300592));
      ((WorkerProfile.27)localObject1).map.put("qqfriend", Integer.valueOf(2131300603));
      ((WorkerProfile.27)localObject1).map.put("newsapp", Integer.valueOf(2131300614));
      ((WorkerProfile.27)localObject1).map.put("facebookapp", Integer.valueOf(2131300569));
      ((WorkerProfile.27)localObject1).map.put("masssendapp", Integer.valueOf(2131300589));
      ((WorkerProfile.27)localObject1).map.put("meishiapp", Integer.valueOf(2131300595));
      ((WorkerProfile.27)localObject1).map.put("feedsapp", Integer.valueOf(2131300572));
      ((WorkerProfile.27)localObject1).map.put("voipapp", Integer.valueOf(2131300628));
      ((WorkerProfile.27)localObject1).map.put("weixin", Integer.valueOf(2131301995));
      ((WorkerProfile.27)localObject1).map.put("filehelper", Integer.valueOf(2131300556));
      ((WorkerProfile.27)localObject1).map.put("cardpackage", Integer.valueOf(2131300563));
      ((WorkerProfile.27)localObject1).map.put("officialaccounts", Integer.valueOf(2131300599));
      ((WorkerProfile.27)localObject1).map.put("voicevoipapp", Integer.valueOf(2131300631));
      ((WorkerProfile.27)localObject1).map.put("helper_entry", Integer.valueOf(2131300580));
      ((WorkerProfile.27)localObject1).map.put("voiceinputapp", Integer.valueOf(2131300625));
      ((WorkerProfile.27)localObject1).map.put("linkedinplugin", Integer.valueOf(2131300586));
      ((WorkerProfile.27)localObject1).map.put("notifymessage", Integer.valueOf(2131300596));
      ((WorkerProfile.27)localObject1).map.put("gh_43f2581f6fd6", Integer.valueOf(2131300621));
      ((WorkerProfile.27)localObject1).map.put("appbrandcustomerservicemsg", Integer.valueOf(2131300557));
      ((WorkerProfile.27)localObject1).bZU.put("weixin", Integer.valueOf(2131301994));
      com.tencent.mm.n.a.a((com.tencent.mm.n.a.a)localObject1);
      com.tencent.mm.ui.ak.a(new WorkerProfile.1(this));
      if (!com.tencent.mm.compatible.util.f.Mi())
      {
        localObject1 = com.tencent.mm.plugin.report.service.h.qsU;
        if (!com.tencent.mm.compatible.util.d.fv(19)) {
          continue;
        }
        l1 = 5L;
        ((com.tencent.mm.plugin.report.service.h)localObject1).idkeyStat(340L, l1, 1L, false);
        localObject1 = com.tencent.mm.plugin.report.service.h.qsU;
        if (!com.tencent.mm.compatible.util.d.fv(19)) {
          continue;
        }
        i = 5001;
        ((com.tencent.mm.plugin.report.service.h)localObject1).e(11098, new Object[] { Integer.valueOf(i), String.format("%s;%s;%s", new Object[] { com.tencent.mm.compatible.util.e.eQx, Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath() }) });
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), Boolean.valueOf(this.bZE), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.bWu), Integer.valueOf(com.tencent.mm.protocal.d.whH), bo.ho(ah.getContext()) });
      AppMethodBeat.o(15548);
      return;
      localObject3 = com.tencent.mm.c.a.a.B(com.tencent.mm.a.e.j((String)localObject1, i - 8, 8));
      if (localObject3 != null) {
        continue;
      }
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WorkerProfile", "checkApkExternal, header null");
    }
  }
  
  public final void onReportKVDataReady(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    AppMethodBeat.i(15555);
    aw.RO().ac(new WorkerProfile.29(this, paramInt, paramArrayOfByte2));
    AppMethodBeat.o(15555);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(15554);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "onSceneEnd dkwt type:%d [%d,%d,%s]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 3) && (paramInt2 == -1)) {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "getStack([ %s ]), ThreadID: %s", new Object[] { bo.dtY(), Long.valueOf(Thread.currentThread().getId()) });
    }
    if ((paramInt1 == 4) && (paramInt2 == -3002))
    {
      if (bo.isNullOrNil(paramString))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WorkerProfile", "summerdiz -3002 but errMsg is null");
        AppMethodBeat.o(15554);
        return;
      }
      paramm = paramString;
      if (paramString.startsWith("autoauth_errmsg_")) {
        paramm = paramString.substring(16);
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WorkerProfile", "summerdiz MM_ERR_IDCDISASTER -3002 errStr:%s", new Object[] { paramm });
      paramString = new com.tencent.mm.g.a.ak();
      paramString.cnA.type = 4;
      paramString.cnA.cnC = paramm;
      com.tencent.mm.sdk.b.a.ymk.l(paramString);
      AppMethodBeat.o(15554);
      return;
    }
    if ((aw.RG()) && (paramInt1 == 4) && ((paramInt2 == -6) || (paramInt2 == -310) || (paramInt2 == -311)) && (paramString != null) && (paramString.startsWith("autoauth_errmsg_")))
    {
      if (NewTaskUI.dNU() != null)
      {
        AppMethodBeat.o(15554);
        return;
      }
      paramString = new Intent();
      paramString.setClass(ah.getContext(), NewTaskUI.class).addFlags(268435456);
      ah.getContext().startActivity(paramString);
      AppMethodBeat.o(15554);
      return;
    }
    if ((paramm.getType() == 701) || (paramm.getType() == 702) || (paramm.getType() == 126) || (paramm.getType() == 252) || (paramm.getType() == 763) || (paramm.getType() == 138))
    {
      if ((paramInt1 == 4) && (paramInt2 == -213))
      {
        paramm = new jo();
        paramm.cze.status = 0;
        paramm.cze.aXG = 3;
        com.tencent.mm.sdk.b.a.ymk.l(paramm);
        if (AccountDeletedAlphaAlertUI.dNv() != null)
        {
          AppMethodBeat.o(15554);
          return;
        }
        paramm = new Intent();
        paramm.setClass(ah.getContext(), AccountDeletedAlphaAlertUI.class).addFlags(268435456);
        paramm.putExtra("errmsg", paramString);
        ah.getContext().startActivity(paramm);
        AppMethodBeat.o(15554);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 == -100))
      {
        paramString = new jo();
        paramString.cze.status = 0;
        paramString.cze.aXG = 1;
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
      }
    }
    AppMethodBeat.o(15554);
  }
  
  public final void onTerminate()
  {
    AppMethodBeat.i(15549);
    super.onTerminate();
    com.tencent.mm.h.b localb = this.bZL;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BroadcastController", "summerdiz release oldNoticeInfo[%s], newDisasterNoticeInfoMap[%d]", new Object[] { localb.ebV, Integer.valueOf(localb.ebX.size()) });
    com.tencent.mm.sdk.b.a.ymk.d(localb.ebY);
    localb.ebV = null;
    localb.ebW.clear();
    localb.ebX.clear();
    this.bZL = null;
    AppMethodBeat.o(15549);
  }
  
  public final String toString()
  {
    return bXW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile
 * JD-Core Version:    0.7.0.1
 */