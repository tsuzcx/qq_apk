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
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.ak.z.a;
import com.tencent.mm.console.Shell;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.cy;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.nx;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.g.a.wx;
import com.tencent.mm.g.a.xy;
import com.tencent.mm.g.a.yy;
import com.tencent.mm.kiss.a.b.2;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.model.f.a;
import com.tencent.mm.network.af;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.IKVReportNotify;
import com.tencent.mm.plugin.report.service.j;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bw.b;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI;
import com.tencent.mm.ui.tools.NewTaskUI;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.util.Locale;
import java.util.Map;

public final class WorkerProfile
  extends com.tencent.mm.compatible.loader.d
  implements com.tencent.mm.ak.i, z.a, n, aw, f.a, IKVReportNotify
{
  public static final String dkO;
  private static WorkerProfile dni;
  private static int dny;
  private final int ID;
  private final Shell dng;
  private final com.tencent.mm.console.a dnh;
  private ax dnj;
  private bw.b dnk;
  private an dnl;
  public boolean dnm;
  @Deprecated
  public boolean dnn;
  public boolean dno;
  private final int dnp;
  private final int dnq;
  private int dnr;
  private StringBuilder dns;
  private com.tencent.mm.booter.notification.a.g dnt;
  private boolean dnu;
  private com.tencent.mm.h.b dnv;
  public final al dnw;
  public final ak dnx;
  protected Locale locale;
  
  static
  {
    AppMethodBeat.i(19603);
    dkO = MMApplicationContext.getPackageName();
    dny = -1;
    AppMethodBeat.o(19603);
  }
  
  public WorkerProfile()
  {
    AppMethodBeat.i(19592);
    this.dng = new Shell();
    this.dnh = new com.tencent.mm.console.a();
    this.dnm = false;
    this.dnp = 0;
    this.dnq = 1;
    this.ID = 2130706432;
    this.dns = new StringBuilder();
    this.dnu = true;
    this.dnw = new al();
    this.dnx = new ak();
    dni = this;
    AppMethodBeat.o(19592);
  }
  
  public static WorkerProfile Xg()
  {
    return dni;
  }
  
  public final void Wq()
  {
    this.dnu = true;
  }
  
  public final void Wr()
  {
    this.dnu = false;
  }
  
  public final bw.b Xh()
  {
    AppMethodBeat.i(19597);
    if (this.dnk == null) {
      this.dnk = new bw.b()
      {
        public final String a(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, Context paramAnonymousContext)
        {
          AppMethodBeat.i(19583);
          paramAnonymousString1 = com.tencent.mm.booter.notification.a.h.a(paramAnonymousInt1, paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousContext);
          AppMethodBeat.o(19583);
          return paramAnonymousString1;
        }
        
        public final void a(ca paramAnonymousca, PString paramAnonymousPString1, PString paramAnonymousPString2, PInt paramAnonymousPInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(19582);
          com.tencent.mm.booter.notification.a.h.b(paramAnonymousca, paramAnonymousPString1, paramAnonymousPString2, paramAnonymousPInt, paramAnonymousBoolean);
          AppMethodBeat.o(19582);
        }
      };
    }
    bw.b localb = this.dnk;
    AppMethodBeat.o(19597);
    return localb;
  }
  
  public final an Xi()
  {
    AppMethodBeat.i(19598);
    if (this.dnl == null) {
      this.dnl = com.tencent.mm.booter.a.akp();
    }
    an localan = this.dnl;
    AppMethodBeat.o(19598);
    return localan;
  }
  
  public final ax getNotification()
  {
    AppMethodBeat.i(19596);
    if (this.dnj == null) {
      this.dnj = new com.tencent.mm.booter.notification.c(this.app);
    }
    ax localax = this.dnj;
    AppMethodBeat.o(19596);
    return localax;
  }
  
  public final void gs(String paramString)
  {
    AppMethodBeat.i(19601);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "summerdiz onOldDisaster errStr[%s]", new Object[] { paramString });
    ar localar = new ar();
    localar.dDD.type = 4;
    localar.dDD.event = paramString;
    EventCenter.instance.publish(localar);
    AppMethodBeat.o(19601);
  }
  
  public final void gt(String paramString)
  {
    AppMethodBeat.i(19602);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "summerdiz onReMoveNoticeId:%s", new Object[] { paramString });
    ar localar = new ar();
    localar.dDD.type = 1;
    localar.dDD.event = paramString;
    EventCenter.instance.publish(localar);
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
      if ((paramConfiguration != null) && (this.locale != null) && (!paramConfiguration.equals(this.locale)) && (!bg.aAc())) {}
    }
    try
    {
      paramConfiguration = bg.azz().iMw;
      if (paramConfiguration != null)
      {
        paramConfiguration = paramConfiguration.aZh();
        if (paramConfiguration != null)
        {
          bg.aVF();
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
    com.tencent.mm.bv.a.iH(MMApplicationContext.getContext());
    paramConfiguration = com.tencent.mm.hellhoundlib.b.c.a(-1, new com.tencent.mm.hellhoundlib.b.a());
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramConfiguration.axQ(), "com/tencent/mm/app/WorkerProfile", "initLanguage", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)paramConfiguration.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/app/WorkerProfile", "initLanguage", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    AppMethodBeat.o(19595);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(19593);
    long l2 = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.WorkerProfile", "workerProfile onCreate, step 1");
    com.tencent.mm.plugin.hp.tinker.i.dZr();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "start time check onCreate proc:%s pid:%d" + dkO + Process.myPid());
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "appOnCreate start getAccStg %b, thread name %s", new Object[] { Boolean.TRUE, Thread.currentThread().getName() });
    l1 = System.currentTimeMillis();
    com.tencent.mm.model.d.a.aXx();
    bg.azz().a(-1, this);
    com.tencent.mm.ak.z.a(this);
    bg.aVH().iBK = this;
    bg.a(new WorkerProfile.12(this));
    bg.getSysCmdMsgExtension().a("getkvidkeystg", new cj.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(19570);
        j.aMu(com.tencent.mm.platformtools.z.a(paramAnonymousa.heO.KHn));
        AppMethodBeat.o(19570);
      }
      
      public final void a(h.c paramAnonymousc) {}
    }, true);
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
        if (localException2.djh + 8 - 8 < 0) {
          continue;
        }
        com.tencent.mm.d.b localb = new com.tencent.mm.d.b();
        localb.parseFrom(s.aW(localNameNotFoundException, i - (localException2.djh + 8 - 8) - 8, localException2.djh + 8 - 8));
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
        com.tencent.mm.protocal.d.ics = localObject3;
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
        i = (int)s.boW((String)localObject1);
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
      localObject1 = com.tencent.mm.d.a.fO((String)localObject1);
      if ((localObject1 == null) || (((com.tencent.mm.d.a)localObject1).djf == null)) {
        continue;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "apk external info not null");
      if (((com.tencent.mm.d.a)localObject1).djf.channelId != 0)
      {
        ChannelUtil.channelId = ((com.tencent.mm.d.a)localObject1).djf.channelId;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "read channelId from apk external");
      }
      if (((com.tencent.mm.d.a)localObject1).djf.updateMode != 0)
      {
        ChannelUtil.updateMode = ((com.tencent.mm.d.a)localObject1).djf.updateMode;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "ext.updateMode = %s", new Object[] { Integer.valueOf(ChannelUtil.updateMode) });
      }
      if (((com.tencent.mm.d.a)localObject1).djf.dji != null) {
        ChannelUtil.buildRev = Util.getInt(((com.tencent.mm.d.a)localObject1).djf.dji, 0);
      }
      if (((com.tencent.mm.d.a)localObject1).djf.djj != null) {
        ChannelUtil.marketURL = ((com.tencent.mm.d.a)localObject1).djf.djj;
      }
      if (((com.tencent.mm.d.a)localObject1).djf.profileDeviceType != null) {
        ChannelUtil.profileDeviceType = ((com.tencent.mm.d.a)localObject1).djf.profileDeviceType;
      }
      if (((com.tencent.mm.d.a)localObject1).djf.djl)
      {
        ChannelUtil.isNokiaAol = ((com.tencent.mm.d.a)localObject1).djf.djl;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "ext.isNokiaol = %s", new Object[] { Boolean.valueOf(ChannelUtil.isNokiaAol) });
      }
      if (((com.tencent.mm.d.a)localObject1).djf.autoAddAccount != 0)
      {
        ChannelUtil.autoAddAccount = ((com.tencent.mm.d.a)localObject1).djf.autoAddAccount;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "ext.autoAddAccount = %s", new Object[] { Integer.valueOf(ChannelUtil.autoAddAccount) });
      }
      if (((com.tencent.mm.d.a)localObject1).djf.djk)
      {
        ChannelUtil.shouldShowGprsAlert = ((com.tencent.mm.d.a)localObject1).djf.djk;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "ext.shouldShowGprsAlert = %s", new Object[] { Boolean.valueOf(ChannelUtil.shouldShowGprsAlert) });
      }
      f.Wh();
      localObject1 = com.tencent.mm.booter.d.cg(this.app);
      if ((localObject1 != null) && (((com.tencent.mm.booter.d)localObject1).glq != -1)) {
        ChannelUtil.channelId = ((com.tencent.mm.booter.d)localObject1).glq;
      }
      localObject1 = this.app.getApplicationContext();
      i = ChannelUtil.channelId;
      j = com.tencent.mm.protocal.d.KyO;
      if ((localObject1 != null) && (i >= 0) && (j >= 637534208)) {
        continue;
      }
      if (ChannelUtil.buildRev > 0) {
        ChannelUtil.fullVersionInfo = true;
      }
      com.tencent.mm.br.c.gsX();
      if ((!ao.gJH()) || (ao.gJL())) {
        continue;
      }
      localObject1 = com.tencent.mm.plugin.account.model.d.kiq;
      localObject4 = new StringBuilder("pad-android-");
      if (!Util.isNullOrNil(ChannelUtil.profileDeviceType)) {
        continue;
      }
      localObject1 = Integer.valueOf(Build.VERSION.SDK_INT);
      com.tencent.mm.protocal.d.ics = localObject1;
      com.tencent.mm.protocal.d.KyH = 28;
      if (!Util.isNullOrNil(CrashReportFactory.getDebugerApiLevel())) {
        com.tencent.mm.protocal.d.ics = "android-" + CrashReportFactory.getDebugerApiLevel();
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "set device type :%s  %s", new Object[] { com.tencent.mm.protocal.d.ics, CrashReportFactory.getDebugerApiLevel() });
      MMProtocalJni.setDeviceTypeId(com.tencent.mm.protocal.d.KyH);
      this.locale = MMActivity.initLanguage(this.app.getBaseContext());
      this.dng.init(MMApplicationContext.getContext());
      localObject1 = this.dnh;
      EventCenter.instance.addListener((IListener)localObject1);
      localObject1 = new com.tencent.mm.pluginsdk.ui.b(new e());
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AvatarDrawable", "setLoader".concat(String.valueOf(localObject1)));
      com.tencent.mm.pluginsdk.ui.a.b.Boe = (j.a)localObject1;
      com.tencent.mm.pluginsdk.i.c.JYn = new com.tencent.mm.pluginsdk.i.c.a()
      {
        public final boolean Xl()
        {
          AppMethodBeat.i(163173);
          if ((1 != ChannelUtil.channelId) && (!com.tencent.mm.protocal.d.KyR) && (com.tencent.mm.br.c.bfW("whatsnew")) && (LocaleUtil.isSimplifiedChineseAppLang()))
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MMAppMgr", "[whatsnew] available.");
            AppMethodBeat.o(163173);
            return true;
          }
          AppMethodBeat.o(163173);
          return false;
        }
        
        public final void bV(Context paramAnonymousContext)
        {
          AppMethodBeat.i(19576);
          MMAppMgr.n(paramAnonymousContext, true);
          AppMethodBeat.o(19576);
        }
        
        public final void bW(Context paramAnonymousContext)
        {
          AppMethodBeat.i(19578);
          af.bke().edit().putBoolean("is_in_notify_mode", true).commit();
          MMEntryLock.unlock("welcome_page_show");
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().r(-1, null);
          ad localad = new ad();
          localad.dDb.dDc = false;
          EventCenter.instance.publish(localad);
          com.tencent.mm.plugin.setting.c.jRu.Xc();
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().alb();
          MMAppMgr.n(paramAnonymousContext, false);
          AppMethodBeat.o(19578);
        }
        
        public final void n(Context paramAnonymousContext, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(19577);
          MMAppMgr.n(paramAnonymousContext, paramAnonymousBoolean);
          AppMethodBeat.o(19577);
        }
      };
      com.tencent.mm.kernel.g.a(com.tencent.mm.ak.l.class, new com.tencent.mm.kernel.c.e(this.dnx));
      com.tencent.mm.kernel.g.a(com.tencent.mm.api.m.class, new com.tencent.mm.kernel.c.e(this.dnx));
      com.tencent.mm.kernel.g.b(com.tencent.mm.api.p.class, new com.tencent.mm.model.m());
      com.tencent.mm.kernel.g.a(k.class, new com.tencent.mm.kernel.c.e(this.dnx));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.brandservice.a.a.class, new com.tencent.mm.plugin.bbom.d());
      com.tencent.mm.kernel.g.b(com.tencent.mm.pluginsdk.p.class, new com.tencent.mm.app.plugin.d());
      com.tencent.mm.kernel.g.b(com.tencent.mm.choosemsgfile.compat.b.class, new com.tencent.mm.ui.chatting.b.a());
      com.tencent.mm.kernel.g.b(com.tencent.mm.ui.chatting.c.c.class, new com.tencent.mm.ui.chatting.c.b());
      com.tencent.mm.kernel.g.b(n.class, this);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.appbrand.service.e.class, new com.tencent.mm.ui.appbrand.a());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.appbrand.service.h.class, new com.tencent.mm.ui.appbrand.c());
      EventCenter.instance.addListener(new com.tencent.mm.app.plugin.b.a.a());
      if (this.dnj == null) {
        this.dnj = new com.tencent.mm.booter.notification.c(this.app);
      }
      this.dnv = new com.tencent.mm.h.b();
      localObject1 = this.dnv;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.BroadcastController", "summerdiz init");
      EventCenter.instance.addListener(((com.tencent.mm.h.b)localObject1).gpf);
      localObject1 = com.tencent.mm.kiss.a.b.aBh();
      EventCenter.instance.addListener(new b.2((com.tencent.mm.kiss.a.b)localObject1));
      EventCenter.instance.addListener(new com.tencent.mm.plugin.account.bind.ui.e());
      EventCenter.instance.addListener(new IListener() {});
      EventCenter.instance.addListener(new IListener() {});
      EventCenter.instance.addListener(new WorkerProfile.31(this));
      EventCenter.instance.addListener(new IListener() {});
      EventCenter.instance.addListener(new WorkerProfile.33(this));
      EventCenter.instance.addListener(new WorkerProfile.34(this));
      EventCenter.instance.addListener(new WorkerProfile.2(this));
      EventCenter.instance.addListener(new IListener() {});
      EventCenter.instance.addListener(new IListener() {});
      EventCenter.instance.addListener(new IListener() {});
      EventCenter.instance.addListener(new IListener() {});
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
      new ae().alive();
      EventCenter.instance.add(new WorkerProfile.22(this));
      com.tencent.mm.plugin.messenger.a.g.zpo = new com.tencent.mm.ui.transmit.f();
      com.tencent.mm.pluginsdk.q.a.JSZ = new com.tencent.mm.app.plugin.a();
      com.tencent.mm.pluginsdk.ui.span.d.a.KqD = com.tencent.mm.app.plugin.e.Xo();
      if (!bg.azj()) {
        bg.aVF();
      }
      localObject1 = new cy();
      EventCenter.instance.publish((IEvent)localObject1);
      this.dnm = true;
      com.tencent.mm.opensdk.utils.Log.setLogImpl(new WorkerProfile.24(this));
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.WorkerProfile", "start time check WorkerProfile appOnCreate use time " + (System.currentTimeMillis() - l1));
      localObject1 = new WorkerProfile.26(MMApplicationContext.getContext());
      ((WorkerProfile.26)localObject1).map.put("qqmail", Integer.valueOf(2131761586));
      ((WorkerProfile.26)localObject1).map.put("fmessage", Integer.valueOf(2131761551));
      ((WorkerProfile.26)localObject1).map.put("floatbottle", Integer.valueOf(2131761536));
      ((WorkerProfile.26)localObject1).map.put("lbsapp", Integer.valueOf(2131761559));
      ((WorkerProfile.26)localObject1).map.put("shakeapp", Integer.valueOf(2131761598));
      ((WorkerProfile.26)localObject1).map.put("medianote", Integer.valueOf(2131761568));
      ((WorkerProfile.26)localObject1).map.put("qqfriend", Integer.valueOf(2131761583));
      ((WorkerProfile.26)localObject1).map.put("newsapp", Integer.valueOf(2131761594));
      ((WorkerProfile.26)localObject1).map.put("facebookapp", Integer.valueOf(2131761545));
      ((WorkerProfile.26)localObject1).map.put("masssendapp", Integer.valueOf(2131761565));
      ((WorkerProfile.26)localObject1).map.put("meishiapp", Integer.valueOf(2131761571));
      ((WorkerProfile.26)localObject1).map.put("feedsapp", Integer.valueOf(2131761548));
      ((WorkerProfile.26)localObject1).map.put("voipapp", Integer.valueOf(2131761608));
      ((WorkerProfile.26)localObject1).map.put("weixin", Integer.valueOf(2131763750));
      ((WorkerProfile.26)localObject1).map.put("filehelper", Integer.valueOf(2131761528));
      ((WorkerProfile.26)localObject1).map.put("cardpackage", Integer.valueOf(2131761539));
      ((WorkerProfile.26)localObject1).map.put("officialaccounts", Integer.valueOf(2131761576));
      ((WorkerProfile.26)localObject1).map.put("voicevoipapp", Integer.valueOf(2131761611));
      ((WorkerProfile.26)localObject1).map.put("helper_entry", Integer.valueOf(2131761556));
      ((WorkerProfile.26)localObject1).map.put("voiceinputapp", Integer.valueOf(2131761605));
      ((WorkerProfile.26)localObject1).map.put("linkedinplugin", Integer.valueOf(2131761562));
      ((WorkerProfile.26)localObject1).map.put("notifymessage", Integer.valueOf(2131761573));
      ((WorkerProfile.26)localObject1).map.put("gh_f0a92aa7146c", Integer.valueOf(2131761614));
      ((WorkerProfile.26)localObject1).map.put("appbrandcustomerservicemsg", Integer.valueOf(2131761530));
      ((WorkerProfile.26)localObject1).map.put("appbrand_notify_message", Integer.valueOf(2131761533));
      if (1 == com.tencent.mm.plugin.expt.f.a.cRk().a(b.a.soA, 0))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "hardcode mini shop nickname");
        ((WorkerProfile.26)localObject1).map.put("gh_579db1f2cf89", Integer.valueOf(2131761572));
      }
      ((WorkerProfile.26)localObject1).dnE.put("weixin", Integer.valueOf(2131763749));
      com.tencent.mm.contact.c.a((com.tencent.mm.contact.c.a)localObject1);
      as.a(new WorkerProfile.1(this));
      if (!com.tencent.mm.compatible.util.e.apn())
      {
        localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
        if (!com.tencent.mm.compatible.util.d.oD(19)) {
          continue;
        }
        l1 = 5L;
        ((com.tencent.mm.plugin.report.service.h)localObject1).idkeyStat(340L, l1, 1L, false);
        localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
        if (!com.tencent.mm.compatible.util.d.oD(19)) {
          continue;
        }
        i = 5001;
        ((com.tencent.mm.plugin.report.service.h)localObject1).a(11098, new Object[] { Integer.valueOf(i), String.format("%s;%s;%s", new Object[] { com.tencent.mm.loader.j.b.aKD(), Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.mm.compatible.util.g.getExternalStorageDirectory().getAbsolutePath() }) });
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), Boolean.valueOf(this.dnn), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(com.tencent.mm.protocal.d.KyO), Util.getTopActivityName2(MMApplicationContext.getContext()) });
      AppMethodBeat.o(19593);
      return;
      localObject4 = com.tencent.mm.d.a.a.U(s.aW((String)localObject1, i - 8, 8));
      if (localObject4 != null) {
        continue;
      }
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WorkerProfile", "checkApkExternal, header null");
    }
  }
  
  public final void onReportKVDataReady(byte[] paramArrayOfByte1, final byte[] paramArrayOfByte2, final int paramInt)
  {
    AppMethodBeat.i(19600);
    bg.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19584);
        if (bg.aVy())
        {
          AppMethodBeat.o(19584);
          return;
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "summeranrt onReportKVDataReady channel:" + paramInt);
        com.tencent.mm.plugin.report.b.e locale = new com.tencent.mm.plugin.report.b.e(paramArrayOfByte2, paramInt);
        bg.azz().a(locale, 0);
        AppMethodBeat.o(19584);
      }
    });
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
      paramString = new ar();
      paramString.dDD.type = 4;
      paramString.dDD.event = paramq;
      EventCenter.instance.publish(paramString);
      AppMethodBeat.o(19599);
      return;
    }
    if ((bg.aAc()) && (paramInt1 == 4) && ((paramInt2 == -6) || (paramInt2 == -310) || (paramInt2 == -311)) && (paramString != null) && (paramString.startsWith("autoauth_errmsg_")))
    {
      if (NewTaskUI.gXN() != null)
      {
        AppMethodBeat.o(19599);
        return;
      }
      paramq = new Intent();
      paramq.setClass(MMApplicationContext.getContext(), NewTaskUI.class).addFlags(268435456);
      paramString = MMApplicationContext.getContext();
      paramq = new com.tencent.mm.hellhoundlib.b.a().bl(paramq);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, paramq.axQ(), "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)paramq.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(19599);
      return;
    }
    if ((paramq.getType() == 701) || (paramq.getType() == 702) || (paramq.getType() == 126) || (paramq.getType() == 252) || (paramq.getType() == 763) || (paramq.getType() == 138))
    {
      if ((paramInt1 == 4) && (paramInt2 == -213))
      {
        paramq = new ma();
        paramq.dRA.status = 0;
        paramq.dRA.bDZ = 3;
        EventCenter.instance.publish(paramq);
        if (AccountDeletedAlphaAlertUI.gXm() != null)
        {
          AppMethodBeat.o(19599);
          return;
        }
        paramq = new Intent();
        paramq.setClass(MMApplicationContext.getContext(), AccountDeletedAlphaAlertUI.class).addFlags(268435456);
        paramq.putExtra("errmsg", paramString);
        paramString = MMApplicationContext.getContext();
        paramq = new com.tencent.mm.hellhoundlib.b.a().bl(paramq);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, paramq.axQ(), "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramq.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19599);
        return;
      }
      if ((paramInt1 == 4) && ((paramInt2 == -100) || (paramInt2 == -2023)))
      {
        paramString = new ma();
        paramString.dRA.status = 0;
        paramString.dRA.bDZ = 1;
        EventCenter.instance.publish(paramString);
      }
    }
    AppMethodBeat.o(19599);
  }
  
  public final void onTerminate()
  {
    AppMethodBeat.i(19594);
    super.onTerminate();
    com.tencent.mm.h.b localb = this.dnv;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.BroadcastController", "summerdiz release oldNoticeInfo[%s], newDisasterNoticeInfoMap[%d]", new Object[] { localb.gpc, Integer.valueOf(localb.gpe.size()) });
    EventCenter.instance.removeListener(localb.gpf);
    localb.gpc = null;
    localb.gpd.clear();
    localb.gpe.clear();
    this.dnv = null;
    AppMethodBeat.o(19594);
  }
  
  public final String toString()
  {
    return dkO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile
 * JD-Core Version:    0.7.0.1
 */