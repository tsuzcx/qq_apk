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
import com.tencent.mm.R.l;
import com.tencent.mm.an.l;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.an.z;
import com.tencent.mm.an.z.a;
import com.tencent.mm.console.Shell;
import com.tencent.mm.contact.d.a;
import com.tencent.mm.f.a.aaf;
import com.tencent.mm.f.a.at;
import com.tencent.mm.f.a.dc;
import com.tencent.mm.f.a.lq;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.f.a.qb;
import com.tencent.mm.f.a.tr;
import com.tencent.mm.f.a.zf;
import com.tencent.mm.kiss.a.b.2;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.f.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.IKVReportNotify;
import com.tencent.mm.pluginsdk.j.c.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bw.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.av.a;
import com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI;
import com.tencent.mm.ui.tools.NewTaskUI;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.util.Locale;
import java.util.Map;

public final class WorkerProfile
  extends com.tencent.mm.compatible.loader.c
  implements com.tencent.mm.an.i, z.a, n, ax, f.a, IKVReportNotify
{
  public static final String PROCESS_NAME;
  private static int ffM;
  private static WorkerProfile ffv;
  @Deprecated
  public boolean ffA;
  public boolean ffB;
  private final int ffC;
  private final int ffD;
  private int ffE;
  private final int ffF;
  private StringBuilder ffG;
  private com.tencent.mm.booter.notification.a.g ffH;
  private boolean ffI;
  private com.tencent.mm.h.b ffJ;
  public final an ffK;
  public final am ffL;
  private final Shell fft;
  private final com.tencent.mm.console.a ffu;
  private ay ffw;
  private bw.b ffx;
  private ao ffy;
  public boolean ffz;
  protected Locale locale;
  
  static
  {
    AppMethodBeat.i(19603);
    PROCESS_NAME = MMApplicationContext.getPackageName();
    ffM = -1;
    AppMethodBeat.o(19603);
  }
  
  public WorkerProfile()
  {
    AppMethodBeat.i(19592);
    this.fft = new Shell();
    this.ffu = new com.tencent.mm.console.a();
    this.ffz = false;
    this.ffC = 0;
    this.ffD = 1;
    this.ffF = 2130706432;
    this.ffG = new StringBuilder();
    this.ffI = true;
    this.ffK = new an();
    this.ffL = new am();
    ffv = this;
    AppMethodBeat.o(19592);
  }
  
  public static WorkerProfile abJ()
  {
    return ffv;
  }
  
  public final void aaL()
  {
    this.ffI = true;
  }
  
  public final void aaM()
  {
    this.ffI = false;
  }
  
  public final bw.b abK()
  {
    AppMethodBeat.i(19597);
    if (this.ffx == null) {
      this.ffx = new WorkerProfile.27(this);
    }
    bw.b localb = this.ffx;
    AppMethodBeat.o(19597);
    return localb;
  }
  
  public final ao abL()
  {
    AppMethodBeat.i(19598);
    if (this.ffy == null) {
      this.ffy = com.tencent.mm.booter.a.aql();
    }
    ao localao = this.ffy;
    AppMethodBeat.o(19598);
    return localao;
  }
  
  public final ay getNotification()
  {
    AppMethodBeat.i(19596);
    if (this.ffw == null) {
      this.ffw = new com.tencent.mm.booter.notification.c(this.app);
    }
    ay localay = this.ffw;
    AppMethodBeat.o(19596);
    return localay;
  }
  
  public final void hc(String paramString)
  {
    AppMethodBeat.i(19601);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "summerdiz onOldDisaster errStr[%s]", new Object[] { paramString });
    at localat = new at();
    localat.fwm.type = 4;
    localat.fwm.event = paramString;
    EventCenter.instance.publish(localat);
    AppMethodBeat.o(19601);
  }
  
  public final void hd(String paramString)
  {
    AppMethodBeat.i(19602);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "summerdiz onReMoveNoticeId:%s", new Object[] { paramString });
    at localat = new at();
    localat.fwm.type = 1;
    localat.fwm.event = paramString;
    EventCenter.instance.publish(localat);
    AppMethodBeat.o(19602);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(19595);
    if ("language_default".equals(LocaleUtil.loadApplicationLanguageSettings(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext())))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "config locale %s", new Object[] { LocaleUtil.transLocaleToLanguage(paramConfiguration.locale) });
      paramConfiguration = MMActivity.initLanguage(this.app.getBaseContext(), LocaleUtil.transLocaleToLanguage(paramConfiguration.locale));
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "onConfigurationChanged, locale = %s, n = %s", new Object[] { this.locale, paramConfiguration });
      if ((paramConfiguration != null) && (this.locale != null) && (!paramConfiguration.equals(this.locale)) && (!bh.aHB())) {}
    }
    try
    {
      paramConfiguration = bh.aGY().lCD;
      if (paramConfiguration != null)
      {
        paramConfiguration = paramConfiguration.biw();
        if (paramConfiguration != null)
        {
          bh.beI();
          int i = com.tencent.mm.model.c.getUin();
          paramConfiguration.a(new byte[0], new byte[0], new byte[0], i);
        }
      }
    }
    catch (Exception paramConfiguration)
    {
      for (;;)
      {
        Object localObject;
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.WorkerProfile", paramConfiguration, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.WorkerProfile", paramConfiguration, "what the f$!k", new Object[0]);
      }
    }
    com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.WorkerProfile", "language changed, restart process");
    com.tencent.mm.cc.a.jK(MMApplicationContext.getContext());
    paramConfiguration = com.tencent.mm.hellhoundlib.b.c.a(-1, new com.tencent.mm.hellhoundlib.b.a());
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramConfiguration.aFh(), "com/tencent/mm/app/WorkerProfile", "initLanguage", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)paramConfiguration.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/app/WorkerProfile", "initLanguage", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    AppMethodBeat.o(19595);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(19593);
    long l2 = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.WorkerProfile", "workerProfile onCreate, step 1");
    com.tencent.mm.plugin.hp.tinker.i.eIo();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "start time check onCreate proc:%s pid:%d" + PROCESS_NAME + Process.myPid());
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "appOnCreate start getAccStg %b, thread name %s", new Object[] { Boolean.TRUE, Thread.currentThread().getName() });
    l1 = System.currentTimeMillis();
    com.tencent.mm.model.d.a.bgE();
    bh.aGY().a(-1, this);
    z.a(this);
    bh.beK().lrp = this;
    bh.a(new WorkerProfile.12(this));
    bh.getSysCmdMsgExtension().a("getkvidkeystg", new WorkerProfile.23(this), true);
    Object localObject1 = this.app;
    ChannelUtil.setupChannelId((Context)localObject1);
    ChannelUtil.loadProfile((Context)localObject1);
    Object localObject4 = ((Context)localObject1).getPackageManager();
    for (;;)
    {
      try
      {
        localObject1 = ((PackageManager)localObject4).getPackageInfo(((Context)localObject1).getPackageName(), 0).applicationInfo.sourceDir;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "initChannelUtil sourceFile = %s", new Object[] { localObject1 });
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WorkerProfile", "initChannelUtil NameNotFoundException");
        continue;
        if (localException2.faO + 8 - 8 < 0) {
          continue;
        }
        com.tencent.mm.d.b localb = new com.tencent.mm.d.b();
        localb.parseFrom(u.aY(localNameNotFoundException, i - (localException2.faO + 8 - 8) - 8, localException2.faO + 8 - 8));
        new com.tencent.mm.d.a(localb);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "checkApkExternal, check ok");
        continue;
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WorkerProfile", "checkApkExternal header wrong");
        continue;
        if (localNameNotFoundException != null) {
          continue;
        }
        bool = true;
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WorkerProfile", "initChannelUtil something null %s", new Object[] { Boolean.valueOf(bool) });
        continue;
      }
      catch (Exception localException1)
      {
        int j;
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WorkerProfile", "Exception in initChannel, %s", new Object[] { localException1.getMessage() });
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
        Object localObject3 = ChannelUtil.profileDeviceType;
        continue;
        StringBuilder localStringBuilder = new StringBuilder("android-");
        if (!Util.isNullOrNil(ChannelUtil.profileDeviceType)) {
          continue;
        }
        localObject3 = Integer.valueOf(Build.VERSION.SDK_INT);
        com.tencent.mm.protocal.d.kQZ = localObject3;
        continue;
        localObject3 = ChannelUtil.profileDeviceType;
        continue;
        l1 = 6L;
        continue;
        int i = 5002;
        continue;
      }
      try
      {
        i = (int)u.bBQ((String)localObject1);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "checkApkExternal, fileSize = %s", new Object[] { Integer.valueOf(i) });
        if (i >= 8) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.WorkerProfile", localException2, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WorkerProfile", "Exception in checkApkExternal, %s", new Object[] { localException2.getMessage() });
        continue;
      }
      localObject1 = com.tencent.mm.d.a.gy((String)localObject1);
      if ((localObject1 == null) || (((com.tencent.mm.d.a)localObject1).faM == null)) {
        continue;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "apk external info not null");
      if (((com.tencent.mm.d.a)localObject1).faM.channelId != 0)
      {
        ChannelUtil.channelId = ((com.tencent.mm.d.a)localObject1).faM.channelId;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "read channelId from apk external");
      }
      if (((com.tencent.mm.d.a)localObject1).faM.updateMode != 0)
      {
        ChannelUtil.updateMode = ((com.tencent.mm.d.a)localObject1).faM.updateMode;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "ext.updateMode = %s", new Object[] { Integer.valueOf(ChannelUtil.updateMode) });
      }
      if (((com.tencent.mm.d.a)localObject1).faM.faP != null) {
        ChannelUtil.buildRev = Util.getInt(((com.tencent.mm.d.a)localObject1).faM.faP, 0);
      }
      if (((com.tencent.mm.d.a)localObject1).faM.faQ != null) {
        ChannelUtil.marketURL = ((com.tencent.mm.d.a)localObject1).faM.faQ;
      }
      if (((com.tencent.mm.d.a)localObject1).faM.profileDeviceType != null) {
        ChannelUtil.profileDeviceType = ((com.tencent.mm.d.a)localObject1).faM.profileDeviceType;
      }
      if (((com.tencent.mm.d.a)localObject1).faM.faS)
      {
        ChannelUtil.isNokiaAol = ((com.tencent.mm.d.a)localObject1).faM.faS;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "ext.isNokiaol = %s", new Object[] { Boolean.valueOf(ChannelUtil.isNokiaAol) });
      }
      if (((com.tencent.mm.d.a)localObject1).faM.autoAddAccount != 0)
      {
        ChannelUtil.autoAddAccount = ((com.tencent.mm.d.a)localObject1).faM.autoAddAccount;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "ext.autoAddAccount = %s", new Object[] { Integer.valueOf(ChannelUtil.autoAddAccount) });
      }
      if (((com.tencent.mm.d.a)localObject1).faM.faR)
      {
        ChannelUtil.shouldShowGprsAlert = ((com.tencent.mm.d.a)localObject1).faM.faR;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "ext.shouldShowGprsAlert = %s", new Object[] { Boolean.valueOf(ChannelUtil.shouldShowGprsAlert) });
      }
      f.aaD();
      localObject1 = com.tencent.mm.booter.d.cc(this.app);
      if ((localObject1 != null) && (((com.tencent.mm.booter.d)localObject1).iPy != -1)) {
        ChannelUtil.channelId = ((com.tencent.mm.booter.d)localObject1).iPy;
      }
      localObject1 = this.app.getApplicationContext();
      i = ChannelUtil.channelId;
      j = com.tencent.mm.protocal.d.RAD;
      if ((localObject1 != null) && (i >= 0) && (j >= 637534208)) {
        continue;
      }
      if (ChannelUtil.buildRev > 0) {
        ChannelUtil.fullVersionInfo = true;
      }
      com.tencent.mm.by.c.hok();
      if ((!ar.hIE()) || (ar.hIM())) {
        continue;
      }
      localObject1 = com.tencent.mm.plugin.account.model.d.mZQ;
      localObject4 = new StringBuilder("pad-android-");
      if (!Util.isNullOrNil(ChannelUtil.profileDeviceType)) {
        continue;
      }
      localObject1 = Integer.valueOf(Build.VERSION.SDK_INT);
      com.tencent.mm.protocal.d.kQZ = localObject1;
      com.tencent.mm.protocal.d.RAv = 28;
      if (!Util.isNullOrNil(CrashReportFactory.getDebugerApiLevel())) {
        com.tencent.mm.protocal.d.kQZ = "android-" + CrashReportFactory.getDebugerApiLevel();
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "set device type :%s  %s", new Object[] { com.tencent.mm.protocal.d.kQZ, CrashReportFactory.getDebugerApiLevel() });
      MMProtocalJni.setDeviceTypeId(com.tencent.mm.protocal.d.RAv);
      this.locale = MMActivity.initLanguage(this.app.getBaseContext());
      this.fft.init(MMApplicationContext.getContext());
      localObject1 = this.ffu;
      EventCenter.instance.addListener((IListener)localObject1);
      a.b.a(new com.tencent.mm.pluginsdk.ui.b(new e()));
      com.tencent.mm.pluginsdk.j.c.QYP = new c.a()
      {
        public final boolean abN()
        {
          AppMethodBeat.i(163173);
          boolean bool = MMAppMgr.abN();
          AppMethodBeat.o(163173);
          return bool;
        }
        
        public final void bT(Context paramAnonymousContext)
        {
          AppMethodBeat.i(19576);
          MMAppMgr.bT(paramAnonymousContext);
          AppMethodBeat.o(19576);
        }
        
        public final void bU(Context paramAnonymousContext)
        {
          AppMethodBeat.i(19578);
          MMAppMgr.bU(paramAnonymousContext);
          AppMethodBeat.o(19578);
        }
        
        public final void o(Context paramAnonymousContext, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(19577);
          MMAppMgr.o(paramAnonymousContext, paramAnonymousBoolean);
          AppMethodBeat.o(19577);
        }
      };
      com.tencent.mm.kernel.h.a(l.class, new com.tencent.mm.kernel.c.e(this.ffL));
      com.tencent.mm.kernel.h.a(com.tencent.mm.api.m.class, new com.tencent.mm.kernel.c.e(this.ffL));
      com.tencent.mm.kernel.h.b(com.tencent.mm.api.p.class, new com.tencent.mm.model.m());
      com.tencent.mm.kernel.h.a(k.class, new com.tencent.mm.kernel.c.e(this.ffL));
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.brandservice.a.b.class, new com.tencent.mm.plugin.bbom.d());
      com.tencent.mm.kernel.h.b(com.tencent.mm.pluginsdk.p.class, new com.tencent.mm.app.plugin.e());
      com.tencent.mm.kernel.h.b(com.tencent.mm.choosemsgfile.compat.b.class, new com.tencent.mm.ui.chatting.b.a());
      com.tencent.mm.kernel.h.b(com.tencent.mm.ui.chatting.c.c.class, new com.tencent.mm.ui.chatting.c.b());
      com.tencent.mm.kernel.h.b(n.class, this);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.appbrand.service.e.class, new com.tencent.mm.ui.appbrand.a());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.appbrand.service.h.class, new com.tencent.mm.ui.appbrand.c());
      EventCenter.instance.addListener(new com.tencent.mm.app.plugin.b.a.a());
      if (this.ffw == null) {
        this.ffw = new com.tencent.mm.booter.notification.c(this.app);
      }
      this.ffJ = new com.tencent.mm.h.b();
      localObject1 = this.ffJ;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.BroadcastController", "summerdiz init");
      EventCenter.instance.addListener(((com.tencent.mm.h.b)localObject1).iTo);
      localObject1 = com.tencent.mm.kiss.a.b.aIK();
      EventCenter.instance.addListener(new b.2((com.tencent.mm.kiss.a.b)localObject1));
      EventCenter.instance.addListener(new com.tencent.mm.plugin.account.bind.ui.e());
      EventCenter.instance.addListener(new IListener() {});
      EventCenter.instance.addListener(new IListener() {});
      EventCenter.instance.addListener(new IListener() {});
      EventCenter.instance.addListener(new IListener() {});
      EventCenter.instance.addListener(new WorkerProfile.33(this));
      EventCenter.instance.addListener(new WorkerProfile.34(this));
      EventCenter.instance.addListener(new WorkerProfile.2(this));
      EventCenter.instance.addListener(new IListener() {});
      EventCenter.instance.addListener(new WorkerProfile.4(this));
      EventCenter.instance.addListener(new WorkerProfile.5(this));
      EventCenter.instance.addListener(new WorkerProfile.6(this));
      EventCenter.instance.addListener(new WorkerProfile.7(this));
      EventCenter.instance.addListener(new WorkerProfile.8(this));
      EventCenter.instance.addListener(new WorkerProfile.9(this));
      EventCenter.instance.addListener(new WorkerProfile.10(this));
      EventCenter.instance.addListener(new WorkerProfile.11(this));
      EventCenter.instance.addListener(new WorkerProfile.13(this));
      EventCenter.instance.addListener(new WorkerProfile.14(this));
      EventCenter.instance.addListener(new WorkerProfile.15(this));
      EventCenter.instance.addListener(new WorkerProfile.16(this));
      EventCenter.instance.addListener(new WorkerProfile.17(this));
      EventCenter.instance.addListener(new WorkerProfile.18(this));
      EventCenter.instance.addListener(new WorkerProfile.19(this));
      EventCenter.instance.addListener(new WorkerProfile.20(this));
      EventCenter.instance.addListener(new IListener() {});
      EventCenter.instance.addListener(new v(2, 12));
      new ag().alive();
      EventCenter.instance.add(new WorkerProfile.22(this));
      com.tencent.mm.plugin.messenger.a.g.EUL = new com.tencent.mm.ui.transmit.f();
      com.tencent.mm.pluginsdk.q.a.QSe = new com.tencent.mm.app.plugin.b();
      com.tencent.mm.pluginsdk.ui.span.d.a.RrK = com.tencent.mm.app.plugin.f.abQ();
      if (!bh.aGE()) {
        bh.beI();
      }
      localObject1 = new dc();
      EventCenter.instance.publish((IEvent)localObject1);
      this.ffz = true;
      com.tencent.mm.opensdk.utils.Log.setLogImpl(new WorkerProfile.24(this));
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.WorkerProfile", "start time check WorkerProfile appOnCreate use time " + (System.currentTimeMillis() - l1));
      localObject1 = new WorkerProfile.26(MMApplicationContext.getContext());
      ((WorkerProfile.26)localObject1).map.put("qqmail", Integer.valueOf(R.l.eHt));
      ((WorkerProfile.26)localObject1).map.put("fmessage", Integer.valueOf(R.l.eGP));
      ((WorkerProfile.26)localObject1).map.put("floatbottle", Integer.valueOf(R.l.eGC));
      ((WorkerProfile.26)localObject1).map.put("lbsapp", Integer.valueOf(R.l.eGV));
      ((WorkerProfile.26)localObject1).map.put("shakeapp", Integer.valueOf(R.l.eHC));
      ((WorkerProfile.26)localObject1).map.put("medianote", Integer.valueOf(R.l.eHe));
      ((WorkerProfile.26)localObject1).map.put("qqfriend", Integer.valueOf(R.l.hardcode_plugin_qqfriend_nick));
      ((WorkerProfile.26)localObject1).map.put("newsapp", Integer.valueOf(R.l.eHz));
      ((WorkerProfile.26)localObject1).map.put("facebookapp", Integer.valueOf(R.l.hardcode_plugin_facebookapp_nick));
      ((WorkerProfile.26)localObject1).map.put("masssendapp", Integer.valueOf(R.l.eHb));
      ((WorkerProfile.26)localObject1).map.put("meishiapp", Integer.valueOf(R.l.eHh));
      ((WorkerProfile.26)localObject1).map.put("feedsapp", Integer.valueOf(R.l.hardcode_plugin_feedsapp_nick));
      ((WorkerProfile.26)localObject1).map.put("voipapp", Integer.valueOf(R.l.eHI));
      ((WorkerProfile.26)localObject1).map.put("weixin", Integer.valueOf(R.l.eOG));
      ((WorkerProfile.26)localObject1).map.put("filehelper", Integer.valueOf(R.l.eGv));
      ((WorkerProfile.26)localObject1).map.put("cardpackage", Integer.valueOf(R.l.eGF));
      ((WorkerProfile.26)localObject1).map.put("officialaccounts", Integer.valueOf(R.l.eHl));
      ((WorkerProfile.26)localObject1).map.put("voicevoipapp", Integer.valueOf(R.l.eHL));
      ((WorkerProfile.26)localObject1).map.put("helper_entry", Integer.valueOf(R.l.eGS));
      ((WorkerProfile.26)localObject1).map.put("voiceinputapp", Integer.valueOf(R.l.eHF));
      ((WorkerProfile.26)localObject1).map.put("linkedinplugin", Integer.valueOf(R.l.eGY));
      ((WorkerProfile.26)localObject1).map.put("notifymessage", Integer.valueOf(R.l.eHi));
      ((WorkerProfile.26)localObject1).map.put("gh_f0a92aa7146c", Integer.valueOf(R.l.eHP));
      ((WorkerProfile.26)localObject1).map.put("appbrandcustomerservicemsg", Integer.valueOf(R.l.eGw));
      ((WorkerProfile.26)localObject1).map.put("appbrand_notify_message", Integer.valueOf(R.l.eGz));
      if (1 == com.tencent.mm.plugin.expt.f.a.dgf().a(b.a.waa, 0))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "hardcode mini shop nickname");
        ((WorkerProfile.26)localObject1).map.put("gh_579db1f2cf89", Integer.valueOf(R.l.hardcode_plugin_mini_shop_helper_nick));
      }
      ((WorkerProfile.26)localObject1).map.put("gh_b4af18eac3d5", Integer.valueOf(R.l.eHO));
      ((WorkerProfile.26)localObject1).ffS.put("weixin", Integer.valueOf(R.l.eOF));
      com.tencent.mm.contact.d.a((d.a)localObject1);
      av.a(new av.a()
      {
        public final void d(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(19539);
          com.tencent.mm.sdk.platformtools.Log.d(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(19539);
        }
        
        public final void e(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(19542);
          com.tencent.mm.sdk.platformtools.Log.e(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(19542);
        }
        
        public final void i(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(19540);
          com.tencent.mm.sdk.platformtools.Log.i(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(19540);
        }
        
        public final void v(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(19538);
          com.tencent.mm.sdk.platformtools.Log.v(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(19538);
        }
        
        public final void w(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(19541);
          com.tencent.mm.sdk.platformtools.Log.w(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(19541);
        }
      });
      if (!com.tencent.mm.compatible.util.e.avA())
      {
        localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
        if (!com.tencent.mm.compatible.util.d.qV(19)) {
          continue;
        }
        l1 = 5L;
        ((com.tencent.mm.plugin.report.service.h)localObject1).idkeyStat(340L, l1, 1L, false);
        localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
        if (!com.tencent.mm.compatible.util.d.qV(19)) {
          continue;
        }
        i = 5001;
        ((com.tencent.mm.plugin.report.service.h)localObject1).a(11098, new Object[] { Integer.valueOf(i), String.format("%s;%s;%s", new Object[] { com.tencent.mm.loader.j.b.aSF(), Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.mm.compatible.util.g.avF().getAbsolutePath() }) });
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), Boolean.valueOf(this.ffA), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(com.tencent.mm.protocal.d.RAD), Util.getTopActivityName2(MMApplicationContext.getContext()) });
      AppMethodBeat.o(19593);
      return;
      localObject4 = com.tencent.mm.d.a.a.ab(u.aY((String)localObject1, i - 8, 8));
      if (localObject4 != null) {
        continue;
      }
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WorkerProfile", "checkApkExternal, header null");
    }
  }
  
  public final void onReportKVDataReady(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    AppMethodBeat.i(19600);
    bh.aHJ().postToWorker(new WorkerProfile.28(this, paramInt, paramArrayOfByte2));
    AppMethodBeat.o(19600);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(19599);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "onSceneEnd dkwt type:%d [%d,%d,%s]", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 3) && (paramInt2 == -1)) {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "getStack([ %s ]), ThreadID: %s", new Object[] { Util.getStack(), Long.valueOf(Thread.currentThread().getId()) });
    }
    if ((paramInt1 == 4) && (paramInt2 == -3002))
    {
      if (Util.isNullOrNil(paramString))
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WorkerProfile", "summerdiz -3002 but errMsg is null");
        AppMethodBeat.o(19599);
        return;
      }
      paramq = paramString;
      if (paramString.startsWith("autoauth_errmsg_")) {
        paramq = paramString.substring(16);
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "summerdiz MM_ERR_IDCDISASTER -3002 errStr:%s", new Object[] { paramq });
      paramString = new at();
      paramString.fwm.type = 4;
      paramString.fwm.event = paramq;
      EventCenter.instance.publish(paramString);
      AppMethodBeat.o(19599);
      return;
    }
    if ((bh.aHB()) && (paramInt1 == 4) && ((paramInt2 == -6) || (paramInt2 == -310) || (paramInt2 == -311)) && (paramString != null) && (paramString.startsWith("autoauth_errmsg_")))
    {
      if (NewTaskUI.hYz() != null)
      {
        AppMethodBeat.o(19599);
        return;
      }
      paramq = new Intent();
      paramq.setClass(MMApplicationContext.getContext(), NewTaskUI.class).addFlags(268435456);
      paramString = MMApplicationContext.getContext();
      paramq = new com.tencent.mm.hellhoundlib.b.a().bm(paramq);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, paramq.aFh(), "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)paramq.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(19599);
      return;
    }
    if ((paramq.getType() == 701) || (paramq.getType() == 702) || (paramq.getType() == 126) || (paramq.getType() == 252) || (paramq.getType() == 763) || (paramq.getType() == 138))
    {
      if ((paramInt1 == 4) && (paramInt2 == -213))
      {
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aGx();
        paramq = new mr();
        paramq.fKQ.status = 0;
        paramq.fKQ.bnA = 3;
        EventCenter.instance.publish(paramq);
        if (AccountDeletedAlphaAlertUI.hXY() != null)
        {
          AppMethodBeat.o(19599);
          return;
        }
        paramq = new Intent();
        paramq.setClass(MMApplicationContext.getContext(), AccountDeletedAlphaAlertUI.class).addFlags(268435456);
        paramq.putExtra("errmsg", paramString);
        paramString = MMApplicationContext.getContext();
        paramq = new com.tencent.mm.hellhoundlib.b.a().bm(paramq);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, paramq.aFh(), "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramq.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19599);
        return;
      }
      if ((paramInt1 == 4) && ((paramInt2 == -100) || (paramInt2 == -2023)))
      {
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aGx();
        paramString = new mr();
        paramString.fKQ.status = 0;
        paramString.fKQ.bnA = 1;
        EventCenter.instance.publish(paramString);
        AppMethodBeat.o(19599);
      }
    }
    else
    {
      if ((paramInt1 == 4) && (paramInt2 == -213))
      {
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aGx();
        paramString = new qb();
        paramString.fOM.status = 0;
        paramString.fOM.bnA = 3;
        EventCenter.instance.publish(paramString);
      }
      if ((paramInt1 == 4) && ((paramInt2 == -100) || (paramInt2 == -2023)))
      {
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aGx();
        paramString = new qb();
        paramString.fOM.status = 0;
        paramString.fOM.bnA = 1;
        EventCenter.instance.publish(paramString);
      }
    }
    AppMethodBeat.o(19599);
  }
  
  public final void onTerminate()
  {
    AppMethodBeat.i(19594);
    super.onTerminate();
    com.tencent.mm.h.b localb = this.ffJ;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.BroadcastController", "summerdiz release oldNoticeInfo[%s], newDisasterNoticeInfoMap[%d]", new Object[] { localb.iTl, Integer.valueOf(localb.iTn.size()) });
    EventCenter.instance.removeListener(localb.iTo);
    localb.iTl = null;
    localb.iTm.clear();
    localb.iTn.clear();
    this.ffJ = null;
    AppMethodBeat.o(19594);
  }
  
  public final String toString()
  {
    return PROCESS_NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile
 * JD-Core Version:    0.7.0.1
 */