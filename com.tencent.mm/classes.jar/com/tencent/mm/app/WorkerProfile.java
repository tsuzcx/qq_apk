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
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.ah.v.a;
import com.tencent.mm.console.Shell;
import com.tencent.mm.console.Shell.Receiver;
import com.tencent.mm.h.a.aj;
import com.tencent.mm.h.a.ci;
import com.tencent.mm.h.a.iw;
import com.tencent.mm.h.a.jf;
import com.tencent.mm.h.a.ob;
import com.tencent.mm.h.a.pb;
import com.tencent.mm.kiss.a.b.2;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.d.a.1;
import com.tencent.mm.model.d.a.2;
import com.tencent.mm.model.f.a;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.plugin.report.service.IKVReportNotify;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI;
import com.tencent.mm.ui.tools.NewTaskUI;
import java.io.File;
import java.util.Locale;
import java.util.Map;

public final class WorkerProfile
  extends com.tencent.mm.compatible.loader.e
  implements com.tencent.mm.ah.f, v.a, ak, f.a, IKVReportNotify
{
  public static final String bwr = ae.getPackageName();
  private static WorkerProfile bxx;
  private ad bxA;
  public boolean bxB = false;
  @Deprecated
  public boolean bxC;
  public boolean bxD;
  private final int bxE = 0;
  private final int bxF = 1;
  private int bxG;
  private final int bxH = 2130706432;
  private StringBuilder bxI = new StringBuilder();
  private com.tencent.mm.booter.notification.a.g bxJ;
  private com.tencent.mm.i.b bxK;
  public final v bxL = new v();
  public final u bxM = new u();
  private final Shell bxc = new Shell();
  private final com.tencent.mm.console.a bxw = new com.tencent.mm.console.a();
  private com.tencent.mm.model.al bxy;
  private be.b bxz;
  protected Locale locale;
  
  public WorkerProfile()
  {
    bxx = this;
  }
  
  public static WorkerProfile ts()
  {
    return bxx;
  }
  
  public final void cv(String paramString)
  {
    y.i("MicroMsg.WorkerProfile", "summerdiz onOldDisaster errStr[%s]", new Object[] { paramString });
    aj localaj = new aj();
    localaj.bGr.type = 4;
    localaj.bGr.bGt = paramString;
    com.tencent.mm.sdk.b.a.udP.m(localaj);
  }
  
  public final void cw(String paramString)
  {
    y.i("MicroMsg.WorkerProfile", "summerdiz onReMoveNoticeId:%s", new Object[] { paramString });
    aj localaj = new aj();
    localaj.bGr.type = 1;
    localaj.bGr.bGt = paramString;
    com.tencent.mm.sdk.b.a.udP.m(localaj);
  }
  
  public final com.tencent.mm.model.al getNotification()
  {
    if (this.bxy == null) {
      this.bxy = new com.tencent.mm.booter.notification.b(this.app);
    }
    return this.bxy;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ("language_default".equals(x.e(ae.getContext().getSharedPreferences(ae.cqR(), 0))))
    {
      y.i("MicroMsg.WorkerProfile", "config locale %s", new Object[] { x.c(paramConfiguration.locale) });
      paramConfiguration = MMActivity.by(this.app.getBaseContext(), x.c(paramConfiguration.locale));
      y.i("MicroMsg.WorkerProfile", "onConfigurationChanged, locale = %s, n = %s", new Object[] { this.locale, paramConfiguration });
      if ((paramConfiguration != null) && (this.locale != null) && (!paramConfiguration.equals(this.locale)) && (!au.DK())) {}
    }
    try
    {
      paramConfiguration = au.Dk().edx;
      if (paramConfiguration != null)
      {
        paramConfiguration = paramConfiguration.KR();
        if (paramConfiguration != null)
        {
          au.Hx();
          int i = com.tencent.mm.model.c.CK();
          paramConfiguration.w(new byte[0], i);
        }
      }
    }
    catch (Exception paramConfiguration)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.WorkerProfile", paramConfiguration, "", new Object[0]);
        y.printErrStackTrace("MicroMsg.WorkerProfile", paramConfiguration, "what the f$!k", new Object[0]);
      }
    }
    y.w("MicroMsg.WorkerProfile", "language changed, restart process");
    System.exit(-1);
  }
  
  public final void onCreate()
  {
    long l2 = System.currentTimeMillis();
    a.cg(bwr);
    y.v("MicroMsg.WorkerProfile", "workerProfile onCreate, step 1");
    y.i("MicroMsg.WorkerProfile", "start time check onCreate proc:%s pid:%d" + bwr + Process.myPid());
    y.i("MicroMsg.WorkerProfile", "appOnCreate start getAccStg %b, thread name %s", new Object[] { Boolean.valueOf(true), Thread.currentThread().getName() });
    l1 = System.currentTimeMillis();
    Object localObject1 = com.tencent.mm.model.d.a.Ja();
    com.tencent.mm.model.d.a.bwM = bwr;
    if (ae.ufk)
    {
      bool = com.tencent.mm.a.e.deleteFile(com.tencent.mm.model.d.a.dYY);
      y.i("MicroMsg.HandlerTraceManager", "trace setup delete old file ret: " + bool);
    }
    ((com.tencent.mm.model.d.a)localObject1).dZn = System.currentTimeMillis();
    ah.setLogCallback(new a.1((com.tencent.mm.model.d.a)localObject1));
    com.tencent.mm.sdk.platformtools.al.a("NetsceneQueue forbid in ", new a.2((com.tencent.mm.model.d.a)localObject1));
    au.Dk().a(-1, this);
    com.tencent.mm.ah.v.a(this);
    au.HA().dUD = this;
    au.a(new WorkerProfile.1(this));
    au.getSysCmdMsgExtension().a("getkvidkeystg", new WorkerProfile.12(this), true);
    localObject1 = this.app;
    com.tencent.mm.sdk.platformtools.e.fp((Context)localObject1);
    com.tencent.mm.sdk.platformtools.e.fq((Context)localObject1);
    Object localObject3 = ((Context)localObject1).getPackageManager();
    for (;;)
    {
      try
      {
        localObject1 = ((PackageManager)localObject3).getPackageInfo(((Context)localObject1).getPackageName(), 0).applicationInfo.sourceDir;
        y.i("MicroMsg.WorkerProfile", "initChannelUtil sourceFile = %s", new Object[] { localObject1 });
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        y.e("MicroMsg.WorkerProfile", "initChannelUtil NameNotFoundException");
        continue;
        if (localException2.bvi + 8 - 8 < 0) {
          continue;
        }
        com.tencent.mm.c.b localb = new com.tencent.mm.c.b();
        localb.aH(com.tencent.mm.a.e.d(localNameNotFoundException, i - (localException2.bvi + 8 - 8) - 8, localException2.bvi + 8 - 8));
        new com.tencent.mm.c.a(localb);
        y.i("MicroMsg.WorkerProfile", "checkApkExternal, check ok");
        continue;
        y.e("MicroMsg.WorkerProfile", "checkApkExternal header wrong");
        continue;
        if (localNameNotFoundException != null) {
          continue;
        }
        bool = true;
        y.e("MicroMsg.WorkerProfile", "initChannelUtil something null %s", new Object[] { Boolean.valueOf(bool) });
        continue;
      }
      catch (Exception localException1)
      {
        int j;
        y.e("MicroMsg.WorkerProfile", "Exception in initChannel, %s", new Object[] { localException1.getMessage() });
        continue;
        bool = false;
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
        String str = com.tencent.mm.sdk.platformtools.e.bvk;
        continue;
        l1 = 6L;
        continue;
        int i = 5002;
        continue;
      }
      try
      {
        i = com.tencent.mm.a.e.bJ((String)localObject1);
        y.i("MicroMsg.WorkerProfile", "checkApkExternal, fileSize = %s", new Object[] { Integer.valueOf(i) });
        if (i >= 8) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        y.printErrStackTrace("MicroMsg.WorkerProfile", localException2, "", new Object[0]);
        y.e("MicroMsg.WorkerProfile", "Exception in checkApkExternal, %s", new Object[] { localException2.getMessage() });
        continue;
      }
      localObject1 = com.tencent.mm.c.a.cc((String)localObject1);
      if ((localObject1 == null) || (((com.tencent.mm.c.a)localObject1).bvg == null)) {
        continue;
      }
      y.i("MicroMsg.WorkerProfile", "apk external info not null");
      if (((com.tencent.mm.c.a)localObject1).bvg.bvj != 0)
      {
        com.tencent.mm.sdk.platformtools.e.bvj = ((com.tencent.mm.c.a)localObject1).bvg.bvj;
        y.i("MicroMsg.WorkerProfile", "read channelId from apk external");
      }
      if (((com.tencent.mm.c.a)localObject1).bvg.bvl != 0)
      {
        com.tencent.mm.sdk.platformtools.e.bvl = ((com.tencent.mm.c.a)localObject1).bvg.bvl;
        y.i("MicroMsg.WorkerProfile", "ext.updateMode = %s", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.e.bvl) });
      }
      if (((com.tencent.mm.c.a)localObject1).bvg.bvm != null) {
        com.tencent.mm.sdk.platformtools.e.uei = com.tencent.mm.sdk.platformtools.bk.getInt(((com.tencent.mm.c.a)localObject1).bvg.bvm, 0);
      }
      if (((com.tencent.mm.c.a)localObject1).bvg.bvn != null) {
        com.tencent.mm.sdk.platformtools.e.uej = ((com.tencent.mm.c.a)localObject1).bvg.bvn;
      }
      if (((com.tencent.mm.c.a)localObject1).bvg.bvk != null) {
        com.tencent.mm.sdk.platformtools.e.bvk = ((com.tencent.mm.c.a)localObject1).bvg.bvk;
      }
      if (((com.tencent.mm.c.a)localObject1).bvg.bvq)
      {
        com.tencent.mm.sdk.platformtools.e.uen = ((com.tencent.mm.c.a)localObject1).bvg.bvq;
        y.i("MicroMsg.WorkerProfile", "ext.isNokiaol = %s", new Object[] { Boolean.valueOf(com.tencent.mm.sdk.platformtools.e.uen) });
      }
      if (((com.tencent.mm.c.a)localObject1).bvg.bvp != 0)
      {
        com.tencent.mm.sdk.platformtools.e.bvp = ((com.tencent.mm.c.a)localObject1).bvg.bvp;
        y.i("MicroMsg.WorkerProfile", "ext.autoAddAccount = %s", new Object[] { Integer.valueOf(com.tencent.mm.sdk.platformtools.e.bvp) });
      }
      if (((com.tencent.mm.c.a)localObject1).bvg.bvo)
      {
        com.tencent.mm.sdk.platformtools.e.uem = ((com.tencent.mm.c.a)localObject1).bvg.bvo;
        y.i("MicroMsg.WorkerProfile", "ext.shouldShowGprsAlert = %s", new Object[] { Boolean.valueOf(com.tencent.mm.sdk.platformtools.e.uem) });
      }
      d.sH();
      localObject1 = com.tencent.mm.booter.c.aS(this.app);
      if ((localObject1 != null) && (((com.tencent.mm.booter.c)localObject1).dhC != -1)) {
        com.tencent.mm.sdk.platformtools.e.bvj = ((com.tencent.mm.booter.c)localObject1).dhC;
      }
      localObject1 = this.app.getApplicationContext();
      i = com.tencent.mm.sdk.platformtools.e.bvj;
      j = com.tencent.mm.protocal.d.spa;
      if ((localObject1 != null) && (i >= 0) && (j >= 637534208)) {
        continue;
      }
      if (com.tencent.mm.sdk.platformtools.e.uei > 0) {
        com.tencent.mm.sdk.platformtools.e.uek = true;
      }
      com.tencent.mm.br.d.coz();
      localObject3 = new StringBuilder("android-");
      if (!com.tencent.mm.sdk.platformtools.bk.bl(com.tencent.mm.sdk.platformtools.e.bvk)) {
        continue;
      }
      localObject1 = Integer.valueOf(Build.VERSION.SDK_INT);
      com.tencent.mm.protocal.d.dOM = localObject1;
      if (!com.tencent.mm.sdk.platformtools.bk.bl(com.tencent.mm.sdk.a.b.cql())) {
        com.tencent.mm.protocal.d.dOM = "android-" + com.tencent.mm.sdk.a.b.cql();
      }
      y.v("MicroMsg.WorkerProfile", "set device type :%s  %s", new Object[] { com.tencent.mm.protocal.d.dOM, com.tencent.mm.sdk.a.b.cql() });
      this.locale = MMActivity.initLanguage(this.app.getBaseContext());
      if (com.tencent.mm.sdk.a.b.cqk())
      {
        localObject1 = this.bxc;
        localObject3 = ae.getContext();
        if (((Shell)localObject1).dAJ == null)
        {
          ((Shell)localObject1).dAJ = new Shell.Receiver();
          ((Context)localObject3).registerReceiver(((Shell)localObject1).dAJ, Shell.dAL);
        }
      }
      localObject1 = this.bxw;
      com.tencent.mm.sdk.b.a.udP.c((com.tencent.mm.sdk.b.c)localObject1);
      localObject1 = new c();
      y.d("MicroMsg.AvatarDrawable", "setLoader" + localObject1);
      com.tencent.mm.pluginsdk.ui.a.b.nav = (i.a)localObject1;
      com.tencent.mm.pluginsdk.f.e.rVK = new WorkerProfile.22(this);
      com.tencent.mm.kernel.g.a(com.tencent.mm.ah.i.class, new com.tencent.mm.kernel.c.e(this.bxM));
      com.tencent.mm.kernel.g.a(com.tencent.mm.pluginsdk.g.class, new com.tencent.mm.kernel.c.e(this.bxM));
      com.tencent.mm.kernel.g.a(com.tencent.mm.pluginsdk.i.class, new com.tencent.mm.kernel.c.e(this.bxM));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.brandservice.a.c.class, new com.tencent.mm.plugin.bbom.d());
      com.tencent.mm.sdk.b.a.udP.c(new com.tencent.mm.app.plugin.b.a.a());
      if (this.bxy == null) {
        this.bxy = new com.tencent.mm.booter.notification.b(this.app);
      }
      this.bxK = new com.tencent.mm.i.b();
      localObject1 = this.bxK;
      y.i("MicroMsg.BroadcastController", "summerdiz init");
      com.tencent.mm.sdk.b.a.udP.c(((com.tencent.mm.i.b)localObject1).dkE);
      localObject1 = com.tencent.mm.kiss.a.b.ED();
      com.tencent.mm.sdk.b.a.udP.c(new b.2((com.tencent.mm.kiss.a.b)localObject1));
      com.tencent.mm.sdk.b.a.udP.c(new com.tencent.mm.plugin.account.bind.ui.e());
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.23(this));
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.27(this));
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.28(this));
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.29(this));
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.30(this));
      com.tencent.mm.sdk.b.a.udP.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.32(this));
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.2(this));
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.3(this));
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.4(this));
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.5(this));
      com.tencent.mm.sdk.b.a.udP.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.7(this));
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.8(this));
      com.tencent.mm.sdk.b.a.udP.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.10(this));
      com.tencent.mm.sdk.b.a.udP.c(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.13(this));
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.14(this));
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.15(this));
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.16(this));
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.17(this));
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.18(this));
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.19(this));
      com.tencent.mm.sdk.b.a.udP.c(new WorkerProfile.20(this));
      com.tencent.mm.sdk.b.a.udP.c(new l(2, 12));
      com.tencent.mm.plugin.messenger.a.g.mcv = new com.tencent.mm.ui.transmit.d();
      com.tencent.mm.pluginsdk.p.a.rSH = new com.tencent.mm.app.plugin.a();
      com.tencent.mm.pluginsdk.o.a.rSF = new com.tencent.mm.app.plugin.c();
      com.tencent.mm.pluginsdk.ui.d.b.a.sjn = com.tencent.mm.app.plugin.d.tz();
      if (!au.CW()) {
        au.Hx();
      }
      localObject1 = new ci();
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      this.bxB = true;
      Log.setLogImpl(new WorkerProfile.21(this));
      y.d("MicroMsg.WorkerProfile", "start time check WorkerProfile appOnCreate use time " + (System.currentTimeMillis() - l1));
      localObject1 = new WorkerProfile.24(ae.getContext());
      ((WorkerProfile.24)localObject1).map.put("qqmail", Integer.valueOf(R.l.hardcode_plugin_qqmail_nick));
      ((WorkerProfile.24)localObject1).map.put("fmessage", Integer.valueOf(R.l.hardcode_plugin_fmessage_nick));
      ((WorkerProfile.24)localObject1).map.put("floatbottle", Integer.valueOf(R.l.hardcode_plugin_bottle_nick));
      ((WorkerProfile.24)localObject1).map.put("lbsapp", Integer.valueOf(R.l.hardcode_plugin_lbs_nick));
      ((WorkerProfile.24)localObject1).map.put("shakeapp", Integer.valueOf(R.l.hardcode_plugin_shake_nick));
      ((WorkerProfile.24)localObject1).map.put("medianote", Integer.valueOf(R.l.hardcode_plugin_medianote_nick));
      ((WorkerProfile.24)localObject1).map.put("qqfriend", Integer.valueOf(R.l.hardcode_plugin_qqfriend_nick));
      ((WorkerProfile.24)localObject1).map.put("newsapp", Integer.valueOf(R.l.hardcode_plugin_readerappnews_nick));
      ((WorkerProfile.24)localObject1).map.put("facebookapp", Integer.valueOf(R.l.hardcode_plugin_facebookapp_nick));
      ((WorkerProfile.24)localObject1).map.put("masssendapp", Integer.valueOf(R.l.hardcode_plugin_masssend_nick));
      ((WorkerProfile.24)localObject1).map.put("meishiapp", Integer.valueOf(R.l.hardcode_plugin_meishiapp_nick));
      ((WorkerProfile.24)localObject1).map.put("feedsapp", Integer.valueOf(R.l.hardcode_plugin_feedsapp_nick));
      ((WorkerProfile.24)localObject1).map.put("voipapp", Integer.valueOf(R.l.hardcode_plugin_voip_nick));
      ((WorkerProfile.24)localObject1).map.put("weixin", Integer.valueOf(R.l.official_nick));
      ((WorkerProfile.24)localObject1).map.put("filehelper", Integer.valueOf(R.l.hardcode_file_helper_nick));
      ((WorkerProfile.24)localObject1).map.put("cardpackage", Integer.valueOf(R.l.hardcode_plugin_card_package_nick));
      ((WorkerProfile.24)localObject1).map.put("officialaccounts", Integer.valueOf(R.l.hardcode_plugin_official_accounts_nick));
      ((WorkerProfile.24)localObject1).map.put("voicevoipapp", Integer.valueOf(R.l.hardcode_plugin_voipaudio_nick));
      ((WorkerProfile.24)localObject1).map.put("helper_entry", Integer.valueOf(R.l.hardcode_plugin_helper_entry_nick));
      ((WorkerProfile.24)localObject1).map.put("voiceinputapp", Integer.valueOf(R.l.hardcode_plugin_voiceinput_nick));
      ((WorkerProfile.24)localObject1).map.put("linkedinplugin", Integer.valueOf(R.l.hardcode_plugin_linkedin_nick));
      ((WorkerProfile.24)localObject1).map.put("notifymessage", Integer.valueOf(R.l.hardcode_plugin_notify_message_nick));
      ((WorkerProfile.24)localObject1).map.put("gh_43f2581f6fd6", Integer.valueOf(R.l.hardcode_plugin_sport_nick));
      ((WorkerProfile.24)localObject1).map.put("appbrandcustomerservicemsg", Integer.valueOf(R.l.hardcode_plugin_app_brand_customer_service_message_nick));
      ((WorkerProfile.24)localObject1).bxS.put("weixin", Integer.valueOf(R.l.official_alias));
      com.tencent.mm.n.a.a((com.tencent.mm.n.a.a)localObject1);
      if (!com.tencent.mm.compatible.util.f.zF())
      {
        localObject1 = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!com.tencent.mm.compatible.util.d.gF(19)) {
          continue;
        }
        l1 = 5L;
        ((com.tencent.mm.plugin.report.service.h)localObject1).a(340L, l1, 1L, false);
        localObject1 = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!com.tencent.mm.compatible.util.d.gF(19)) {
          continue;
        }
        i = 5001;
        ((com.tencent.mm.plugin.report.service.h)localObject1).f(11098, new Object[] { Integer.valueOf(i), String.format("%s;%s;%s", new Object[] { com.tencent.mm.compatible.util.e.bkF, Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath() }) });
      }
      y.i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), Boolean.valueOf(this.bxC), Integer.valueOf(com.tencent.mm.sdk.platformtools.e.bvj), Integer.valueOf(com.tencent.mm.protocal.d.spa), com.tencent.mm.sdk.platformtools.bk.fY(ae.getContext()) });
      return;
      localObject3 = com.tencent.mm.c.a.a.s(com.tencent.mm.a.e.d((String)localObject1, i - 8, 8));
      if (localObject3 != null) {
        continue;
      }
      y.e("MicroMsg.WorkerProfile", "checkApkExternal, header null");
    }
  }
  
  public final void onReportKVDataReady(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    au.DS().O(new WorkerProfile.26(this, paramInt, paramArrayOfByte2));
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.WorkerProfile", "onSceneEnd dkwt type:%d [%d,%d,%s]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 3) && (paramInt2 == -1)) {
      y.i("MicroMsg.WorkerProfile", "getStack([ %s ]), ThreadID: %s", new Object[] { com.tencent.mm.sdk.platformtools.bk.csb(), Long.valueOf(Thread.currentThread().getId()) });
    }
    if ((paramInt1 == 4) && (paramInt2 == -3002)) {
      if (com.tencent.mm.sdk.platformtools.bk.bl(paramString)) {
        y.e("MicroMsg.WorkerProfile", "summerdiz -3002 but errMsg is null");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          paramm = paramString;
          if (paramString.startsWith("autoauth_errmsg_")) {
            paramm = paramString.substring(16);
          }
          y.i("MicroMsg.WorkerProfile", "summerdiz MM_ERR_IDCDISASTER -3002 errStr:%s", new Object[] { paramm });
          paramString = new aj();
          paramString.bGr.type = 4;
          paramString.bGr.bGt = paramm;
          com.tencent.mm.sdk.b.a.udP.m(paramString);
          return;
          if ((!au.DK()) || (paramInt1 != 4) || ((paramInt2 != -6) && (paramInt2 != -310) && (paramInt2 != -311)) || (paramString == null) || (!paramString.startsWith("autoauth_errmsg_"))) {
            break;
          }
        } while (NewTaskUI.cJf() != null);
        paramString = new Intent();
        paramString.setClass(ae.getContext(), NewTaskUI.class).addFlags(268435456);
        ae.getContext().startActivity(paramString);
        return;
      } while ((paramInt1 != 4) || (paramInt2 != -213));
      paramm = new jf();
      paramm.bRC.status = 0;
      paramm.bRC.aQw = 3;
      com.tencent.mm.sdk.b.a.udP.m(paramm);
    } while (AccountDeletedAlphaAlertUI.cIH() != null);
    paramm = new Intent();
    paramm.setClass(ae.getContext(), AccountDeletedAlphaAlertUI.class).addFlags(268435456);
    paramm.putExtra("errmsg", paramString);
    ae.getContext().startActivity(paramm);
  }
  
  public final void onTerminate()
  {
    super.onTerminate();
    com.tencent.mm.i.b localb = this.bxK;
    y.i("MicroMsg.BroadcastController", "summerdiz release oldNoticeInfo[%s], newDisasterNoticeInfoMap[%d]", new Object[] { localb.dkB, Integer.valueOf(localb.dkD.size()) });
    com.tencent.mm.sdk.b.a.udP.d(localb.dkE);
    localb.dkB = null;
    localb.dkC.clear();
    localb.dkD.clear();
    this.bxK = null;
  }
  
  public final String toString()
  {
    return bwr;
  }
  
  public final be.b tt()
  {
    if (this.bxz == null) {
      this.bxz = new WorkerProfile.25(this);
    }
    return this.bxz;
  }
  
  public final ad tu()
  {
    if (this.bxA == null) {
      this.bxA = com.tencent.mm.booter.a.vR();
    }
    return this.bxA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile
 * JD-Core Version:    0.7.0.1
 */