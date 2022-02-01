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
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.s;
import com.tencent.mm.am.y.a;
import com.tencent.mm.app.plugin.ext.SubCoreExtAgent.ExtAgentLifeEventListener;
import com.tencent.mm.autogen.a.aaz;
import com.tencent.mm.autogen.a.acb;
import com.tencent.mm.autogen.a.ah;
import com.tencent.mm.autogen.a.dm;
import com.tencent.mm.autogen.a.mv;
import com.tencent.mm.autogen.a.nd;
import com.tencent.mm.autogen.a.ny;
import com.tencent.mm.autogen.a.ny.a;
import com.tencent.mm.autogen.a.qe;
import com.tencent.mm.autogen.a.qt;
import com.tencent.mm.autogen.a.ro;
import com.tencent.mm.autogen.a.vb;
import com.tencent.mm.autogen.a.vg;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.autogen.a.xc;
import com.tencent.mm.autogen.a.zw;
import com.tencent.mm.console.CommandLine;
import com.tencent.mm.console.Shell;
import com.tencent.mm.contact.d.a;
import com.tencent.mm.d.a.a;
import com.tencent.mm.kiss.layout.InflateViewRecycler.2;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.model.f.a;
import com.tencent.mm.model.m;
import com.tencent.mm.model.z;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.modelmulti.t;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.d;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.p.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.bind.ui.NeedVerifyQQEventListener;
import com.tencent.mm.plugin.report.service.IKVReportNotify;
import com.tencent.mm.plugin.report.service.j;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.csb;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.event.MvvmEventCenter;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.by.b;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bc;
import com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI;
import com.tencent.mm.ui.tools.NewTaskUI;
import com.tencent.xweb.ao;
import java.io.File;
import java.util.Locale;
import java.util.Map;

public final class WorkerProfile
  extends com.tencent.mm.compatible.loader.c
  implements com.tencent.mm.am.h, y.a, p, ax, f.a, IKVReportNotify
{
  public static final String PROCESS_NAME;
  private static WorkerProfile hjE;
  private static int hjW;
  private final Shell hjC;
  private final CommandLine hjD;
  private com.tencent.mm.model.ay hjF;
  private by.b hjG;
  private ap hjH;
  public boolean hjI;
  @Deprecated
  public boolean hjJ;
  public boolean hjK;
  private final int hjL;
  private final int hjM;
  private final int hjN;
  private int hjO;
  private final int hjP;
  private StringBuilder hjQ;
  private com.tencent.mm.booter.notification.a.g hjR;
  private boolean hjS;
  private com.tencent.mm.broadcast.b hjT;
  public final ar hjU;
  public final aq hjV;
  protected Locale locale;
  
  static
  {
    AppMethodBeat.i(19603);
    PROCESS_NAME = MMApplicationContext.getPackageName();
    hjW = -1;
    AppMethodBeat.o(19603);
  }
  
  public WorkerProfile()
  {
    AppMethodBeat.i(19592);
    this.hjC = new Shell();
    this.hjD = new CommandLine();
    this.hjI = false;
    this.hjL = 0;
    this.hjM = 1;
    this.hjN = 2;
    this.hjP = 2130706432;
    this.hjQ = new StringBuilder();
    this.hjS = true;
    this.hjU = new ar();
    this.hjV = new aq();
    hjE = this;
    AppMethodBeat.o(19592);
  }
  
  public static WorkerProfile aDF()
  {
    return hjE;
  }
  
  public static void aDG()
  {
    AppMethodBeat.i(369574);
    nL(-1);
    AppMethodBeat.o(369574);
  }
  
  public static void nL(int paramInt)
  {
    AppMethodBeat.i(239181);
    com.tencent.mm.protocal.d.YwZ = 2;
    int i = paramInt;
    if (paramInt == -1) {
      i = z.bAZ();
    }
    if (com.tencent.mm.br.c.iPe())
    {
      localStringBuilder = new StringBuilder("android-lite-");
      if (Util.isNullOrNil(ChannelUtil.profileDeviceType))
      {
        localObject = Integer.valueOf(Build.VERSION.SDK_INT);
        com.tencent.mm.protocal.d.nsC = localObject;
      }
    }
    do
    {
      if (!Util.isNullOrNil(CrashReportFactory.getDebugerApiLevel())) {
        com.tencent.mm.protocal.d.nsC = "android-" + CrashReportFactory.getDebugerApiLevel();
      }
      MMProtocalJni.setDeviceTypeId(com.tencent.mm.protocal.d.YwZ);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "initDeviceType:%s %s %s", new Object[] { com.tencent.mm.protocal.d.nsC, Integer.valueOf(com.tencent.mm.protocal.d.YwZ), Util.getStack() });
      AppMethodBeat.o(239181);
      return;
      localObject = ChannelUtil.profileDeviceType;
      break;
      if (!aw.ato()) {
        break label165;
      }
      localObject = com.tencent.mm.plugin.account.model.d.pWz;
    } while ((i == 1) || (i == -1));
    label165:
    if ((aw.jkP()) || (aw.ato()))
    {
      localObject = com.tencent.mm.plugin.account.model.d.pWz;
      localStringBuilder = new StringBuilder("pad-android-");
      if (Util.isNullOrNil(ChannelUtil.profileDeviceType)) {}
      for (localObject = Integer.valueOf(Build.VERSION.SDK_INT);; localObject = ChannelUtil.profileDeviceType)
      {
        com.tencent.mm.protocal.d.nsC = localObject;
        com.tencent.mm.protocal.d.YwZ = 28;
        break;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder("android-");
    if (Util.isNullOrNil(ChannelUtil.profileDeviceType)) {}
    for (Object localObject = Integer.valueOf(Build.VERSION.SDK_INT);; localObject = ChannelUtil.profileDeviceType)
    {
      com.tencent.mm.protocal.d.nsC = localObject;
      break;
    }
  }
  
  public final void aCr()
  {
    this.hjS = true;
  }
  
  public final void aCs()
  {
    this.hjS = false;
  }
  
  public final by.b aDH()
  {
    AppMethodBeat.i(19597);
    if (this.hjG == null) {
      this.hjG = new by.b()
      {
        public final String a(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2, Context paramAnonymousContext)
        {
          AppMethodBeat.i(239064);
          paramAnonymousString1 = com.tencent.mm.booter.notification.a.h.a(paramAnonymousInt1, paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, paramAnonymousContext);
          AppMethodBeat.o(239064);
          return paramAnonymousString1;
        }
        
        public final void a(cc paramAnonymouscc, PString paramAnonymousPString1, PString paramAnonymousPString2, PInt paramAnonymousPInt, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(239059);
          com.tencent.mm.booter.notification.a.h.b(paramAnonymouscc, paramAnonymousPString1, paramAnonymousPString2, paramAnonymousPInt, paramAnonymousBoolean);
          AppMethodBeat.o(239059);
        }
      };
    }
    by.b localb = this.hjG;
    AppMethodBeat.o(19597);
    return localb;
  }
  
  public final ap aDI()
  {
    AppMethodBeat.i(19598);
    if (this.hjH == null) {
      this.hjH = com.tencent.mm.booter.a.aKj();
    }
    ap localap = this.hjH;
    AppMethodBeat.o(19598);
    return localap;
  }
  
  public final com.tencent.mm.model.ay getNotification()
  {
    AppMethodBeat.i(19596);
    if (this.hjF == null) {
      this.hjF = new com.tencent.mm.booter.notification.c(this.app);
    }
    com.tencent.mm.model.ay localay = this.hjF;
    AppMethodBeat.o(19596);
    return localay;
  }
  
  public final void iD(String paramString)
  {
    AppMethodBeat.i(19601);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "summerdiz onOldDisaster errStr[%s]", new Object[] { paramString });
    com.tencent.mm.autogen.a.ay localay = new com.tencent.mm.autogen.a.ay();
    localay.hAK.type = 4;
    localay.hAK.event = paramString;
    localay.publish();
    AppMethodBeat.o(19601);
  }
  
  public final void iE(String paramString)
  {
    AppMethodBeat.i(19602);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "summerdiz onReMoveNoticeId:%s", new Object[] { paramString });
    com.tencent.mm.autogen.a.ay localay = new com.tencent.mm.autogen.a.ay();
    localay.hAK.type = 1;
    localay.hAK.event = paramString;
    localay.publish();
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
      if ((paramConfiguration != null) && (this.locale != null) && (!paramConfiguration.equals(this.locale)) && (!bh.baz())) {}
    }
    try
    {
      paramConfiguration = bh.aZW().oun;
      if (paramConfiguration != null)
      {
        paramConfiguration = paramConfiguration.bGg();
        if (paramConfiguration != null)
        {
          bh.bCz();
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
    com.tencent.mm.bv.a.lJ(MMApplicationContext.getContext());
    paramConfiguration = com.tencent.mm.hellhoundlib.b.c.a(-1, new com.tencent.mm.hellhoundlib.b.a());
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramConfiguration.aYi(), "com/tencent/mm/app/WorkerProfile", "initLanguage", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)paramConfiguration.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/app/WorkerProfile", "initLanguage", "(Landroid/content/res/Configuration;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    AppMethodBeat.o(19595);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(239174);
    long l2 = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.WorkerProfile", "workerProfile onCreate, step 1");
    com.tencent.mm.plugin.hp.tinker.i.fQh();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "start time check onCreate proc:%s pid:%d" + PROCESS_NAME + Process.myPid());
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "appOnCreate start getAccStg %b, thread name %s", new Object[] { Boolean.TRUE, Thread.currentThread().getName() });
    l1 = System.currentTimeMillis();
    com.tencent.mm.model.c.a.bEw();
    bh.aZW().a(-1, this);
    com.tencent.mm.am.y.a(this);
    bh.bCB().oiQ = this;
    ((com.tencent.mm.plugin.auth.a.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.b()
    {
      public final void onAuthResponse(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(239103);
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.WorkerProfile", "initDeviceType after auth");
        WorkerProfile.aDG();
        AppMethodBeat.o(239103);
      }
      
      public final void onRegResponse(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
    });
    bh.a(new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(239114);
        if ((paramAnonymousInt != 4) && (paramAnonymousInt != 6))
        {
          AppMethodBeat.o(239114);
          return;
        }
        if ((bh.baz()) && (com.tencent.mm.kernel.h.baC().mBZ) && (!bh.aZG()))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "dkmsg Network connected , try send msg.");
          t.a(t.d.oNc).bKW().aXz();
          AppMethodBeat.o(239114);
          return;
        }
        AppMethodBeat.o(239114);
      }
    });
    bh.getSysCmdMsgExtension().a("getkvidkeystg", new cl.a()
    {
      public final void a(g.a paramAnonymousa)
      {
        AppMethodBeat.i(239070);
        j.aUp(w.a(paramAnonymousa.mpN.YFG));
        AppMethodBeat.o(239070);
      }
      
      public final void a(g.c paramAnonymousc) {}
    }, true);
    Object localObject4 = this.app;
    ChannelUtil.setupChannelId((Context)localObject4);
    ChannelUtil.loadProfile((Context)localObject4);
    Object localObject1 = ((Context)localObject4).getPackageManager();
    for (;;)
    {
      try
      {
        localObject1 = ((PackageManager)localObject1).getPackageInfo(((Context)localObject4).getPackageName(), 0).applicationInfo.sourceDir;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "initChannelUtil sourceFile = %s", new Object[] { localObject1 });
        i = ((Context)localObject4).getApplicationInfo().targetSdkVersion;
        if (i > 29) {}
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WorkerProfile", "initChannelUtil NameNotFoundException");
        continue;
        if (localException2.heo + 8 - 8 < 0) {
          continue;
        }
        com.tencent.mm.d.b localb = new com.tencent.mm.d.b();
        localb.parseFrom(com.tencent.mm.vfs.y.bi(localNameNotFoundException, i - (localException2.heo + 8 - 8) - 8, localException2.heo + 8 - 8));
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
          continue;
        }
        finally {}
        continue;
        l1 = 6L;
        continue;
        int i = 5002;
        continue;
      }
      try
      {
        i = (int)com.tencent.mm.vfs.y.bEl((String)localObject1);
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
      localObject1 = com.tencent.mm.d.a.hY((String)localObject1);
      if ((localObject1 == null) || (((com.tencent.mm.d.a)localObject1).hem == null)) {
        continue;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "apk external info not null");
      if (((com.tencent.mm.d.a)localObject1).hem.channelId != 0)
      {
        ChannelUtil.channelId = ((com.tencent.mm.d.a)localObject1).hem.channelId;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "read channelId from apk external");
      }
      if (((com.tencent.mm.d.a)localObject1).hem.updateMode != 0)
      {
        ChannelUtil.updateMode = ((com.tencent.mm.d.a)localObject1).hem.updateMode;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "ext.updateMode = %s", new Object[] { Integer.valueOf(ChannelUtil.updateMode) });
      }
      if (((com.tencent.mm.d.a)localObject1).hem.hep != null) {
        ChannelUtil.buildRev = Util.getInt(((com.tencent.mm.d.a)localObject1).hem.hep, 0);
      }
      if (((com.tencent.mm.d.a)localObject1).hem.heq != null) {
        ChannelUtil.marketURL = ((com.tencent.mm.d.a)localObject1).hem.heq;
      }
      if (((com.tencent.mm.d.a)localObject1).hem.profileDeviceType != null) {
        ChannelUtil.profileDeviceType = ((com.tencent.mm.d.a)localObject1).hem.profileDeviceType;
      }
      if (((com.tencent.mm.d.a)localObject1).hem.hes)
      {
        ChannelUtil.isNokiaAol = ((com.tencent.mm.d.a)localObject1).hem.hes;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "ext.isNokiaol = %s", new Object[] { Boolean.valueOf(ChannelUtil.isNokiaAol) });
      }
      if (((com.tencent.mm.d.a)localObject1).hem.autoAddAccount != 0)
      {
        ChannelUtil.autoAddAccount = ((com.tencent.mm.d.a)localObject1).hem.autoAddAccount;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "ext.autoAddAccount = %s", new Object[] { Integer.valueOf(ChannelUtil.autoAddAccount) });
      }
      if (((com.tencent.mm.d.a)localObject1).hem.her)
      {
        ChannelUtil.shouldShowGprsAlert = ((com.tencent.mm.d.a)localObject1).hem.her;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "ext.shouldShowGprsAlert = %s", new Object[] { Boolean.valueOf(ChannelUtil.shouldShowGprsAlert) });
      }
      h.aCk();
      localObject1 = com.tencent.mm.booter.d.cO(this.app);
      if ((localObject1 != null) && (((com.tencent.mm.booter.d)localObject1).lrt != -1)) {
        ChannelUtil.channelId = ((com.tencent.mm.booter.d)localObject1).lrt;
      }
      localObject1 = this.app.getApplicationContext();
      i = ChannelUtil.channelId;
      j = com.tencent.mm.protocal.d.Yxh;
      if ((localObject1 != null) && (i >= 0) && (j >= 637534208)) {
        continue;
      }
      if (ChannelUtil.buildRev > 0) {
        ChannelUtil.fullVersionInfo = true;
      }
      nL(-1);
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.WorkerProfile", "appOnCreate() called with: isFoldableDevice = [%s] authFlag:%s deviceType:%s deviceTypeId:%s", new Object[] { Boolean.valueOf(aw.ato()), Integer.valueOf(z.bBa()), com.tencent.mm.protocal.d.nsC, Integer.valueOf(com.tencent.mm.protocal.d.YwZ) });
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "set device type :%s  %s", new Object[] { com.tencent.mm.protocal.d.nsC, CrashReportFactory.getDebugerApiLevel() });
      this.locale = MMActivity.initLanguage(this.app.getBaseContext());
      this.hjC.init(MMApplicationContext.getContext());
      this.hjD.alive();
      a.b.a(new com.tencent.mm.pluginsdk.ui.b(new g()));
      com.tencent.mm.pluginsdk.platformtools.c.XUP = new com.tencent.mm.pluginsdk.platformtools.c.a()
      {
        public final boolean aDL()
        {
          return false;
        }
        
        public final void cF(Context paramAnonymousContext)
        {
          AppMethodBeat.i(239053);
          MMAppMgr.o(paramAnonymousContext, true);
          AppMethodBeat.o(239053);
        }
        
        public final void cG(Context paramAnonymousContext)
        {
          AppMethodBeat.i(239066);
          ag.bRr().edit().putBoolean("is_in_notify_mode", true).commit();
          MMEntryLock.unlock("welcome_page_show");
          ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().s(-1, null);
          ah localah = new ah();
          localah.hAc.hAd = false;
          localah.publish();
          com.tencent.mm.plugin.setting.c.pFo.aDA();
          ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().aKV();
          MMAppMgr.o(paramAnonymousContext, false);
          AppMethodBeat.o(239066);
        }
        
        public final void o(Context paramAnonymousContext, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(239063);
          MMAppMgr.o(paramAnonymousContext, paramAnonymousBoolean);
          AppMethodBeat.o(239063);
        }
      };
      com.tencent.mm.kernel.h.a(com.tencent.mm.am.k.class, new com.tencent.mm.kernel.c.e(this.hjV));
      com.tencent.mm.kernel.h.a(com.tencent.mm.api.n.class, new com.tencent.mm.kernel.c.e(this.hjV));
      com.tencent.mm.kernel.h.b(com.tencent.mm.api.q.class, new m());
      com.tencent.mm.kernel.h.a(com.tencent.mm.pluginsdk.k.class, new com.tencent.mm.kernel.c.e(this.hjV));
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.brandservice.api.b.class, new com.tencent.mm.plugin.bbom.d());
      com.tencent.mm.kernel.h.b(com.tencent.mm.pluginsdk.p.class, new com.tencent.mm.app.plugin.e());
      com.tencent.mm.kernel.h.b(com.tencent.mm.choosemsgfile.compat.b.class, new com.tencent.mm.ui.chatting.b.a());
      com.tencent.mm.kernel.h.b(com.tencent.mm.ui.chatting.c.c.class, new com.tencent.mm.ui.chatting.c.b());
      com.tencent.mm.kernel.h.b(p.class, this);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.appbrand.service.f.class, new com.tencent.mm.ui.appbrand.a());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.appbrand.service.i.class, new com.tencent.mm.ui.appbrand.c());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.appbrand.service.n.class, new com.tencent.mm.ui.e.a());
      new SubCoreExtAgent.ExtAgentLifeEventListener().alive();
      if (this.hjF == null) {
        this.hjF = new com.tencent.mm.booter.notification.c(this.app);
      }
      this.hjT = new com.tencent.mm.broadcast.b();
      localObject1 = this.hjT;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.BroadcastController", "summerdiz init");
      ((com.tencent.mm.broadcast.b)localObject1).lvt.alive();
      new InflateViewRecycler.2(com.tencent.mm.kiss.layout.b.bbG(), f.hfK).alive();
      new NeedVerifyQQEventListener(f.hfK).alive();
      new IListener(f.hfK)
      {
        private static boolean a(ny paramAnonymousny)
        {
          int j = 1;
          AppMethodBeat.i(239122);
          if ((paramAnonymousny.hQx.reason != 2) && (paramAnonymousny.hQx.status == 0)) {
            com.tencent.mm.xwebutil.c.bFh("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE");
          }
          try
          {
            ao.OU(true);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "clearAllWebViewCache");
            if (bh.baz()) {
              if (paramAnonymousny.hQx.reason == 3)
              {
                i = 1;
                if (paramAnonymousny.hQx.reason != 1) {
                  break label122;
                }
                if (i == 0) {
                  break label127;
                }
                bg.okT.bc("login_user_name", "");
                com.tencent.mm.kernel.b.aZw();
                AppMethodBeat.o(239122);
                return false;
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "clear cookie failed : %s", new Object[] { localException });
              continue;
              i = 0;
              continue;
              label122:
              j = 0;
            }
            label127:
            if (j != 0)
            {
              com.tencent.mm.kernel.b.aZw();
              MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
            }
            paramAnonymousny = bg.okT;
            bh.bCz();
            String str = (String)com.tencent.mm.model.c.ban().d(6, null);
            bh.bCz();
            int i = com.tencent.mm.model.c.ban().getInt(9, 0);
            bh.bCz();
            paramAnonymousny.k(str, i, (String)com.tencent.mm.model.c.ban().d(5, null));
            AppMethodBeat.o(239122);
          }
          return false;
        }
      }.alive();
      new IListener(f.hfK) {}.alive();
      new IListener(f.hfK) {}.alive();
      new IListener(f.hfK) {}.alive();
      new IListener(f.hfK) {}.alive();
      new WorkerProfile.10(this, f.hfK).alive();
      new IListener(f.hfK) {}.alive();
      new IListener(f.hfK) {}.alive();
      new IListener(f.hfK) {}.alive();
      new IListener(f.hfK) {}.alive();
      new IListener(f.hfK) {}.alive();
      new WorkerProfile.16(this, f.hfK).alive();
      new WorkerProfile.17(this, f.hfK).alive();
      new WorkerProfile.18(this, f.hfK).alive();
      new IListener(f.hfK) {}.alive();
      new WorkerProfile.20(this, f.hfK).alive();
      new WorkerProfile.21(this, f.hfK).alive();
      new WorkerProfile.22(this, f.hfK).alive();
      new WorkerProfile.23(this, f.hfK).alive();
      new WorkerProfile.24(this, f.hfK).alive();
      new WorkerProfile.25(this, f.hfK).alive();
      new WorkerProfile.26(this, f.hfK).alive();
      new IListener(f.hfK)
      {
        private boolean aDJ()
        {
          AppMethodBeat.i(239208);
          bh.aZW().a(1145, new com.tencent.mm.am.h()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.am.p paramAnonymous2p)
            {
              AppMethodBeat.i(239198);
              bh.aZW().b(1145, this);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "onSceneEnd(GetServiceNotifyOptions), errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                AppMethodBeat.o(239198);
                return;
              }
              if (paramAnonymous2p.getType() != 1145)
              {
                AppMethodBeat.o(239198);
                return;
              }
              paramAnonymous2String = (r)paramAnonymous2p;
              if ((((csb)c.b.b(paramAnonymous2String.opY.otB)).aayr & 0x1) == 0)
              {
                AppMethodBeat.o(239198);
                return;
              }
              boolean bool = paramAnonymous2String.bEQ().YNn;
              bh.bCz();
              if (bool != com.tencent.mm.model.c.ban().getBoolean(at.a.acOa, true))
              {
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "service notify message notice switch changed(to : %b)", new Object[] { Boolean.valueOf(bool) });
                bh.bCz();
                com.tencent.mm.model.c.ban().set(at.a.acOa, Boolean.valueOf(bool));
                ((com.tencent.mm.u.b)MvvmEventCenter.getEvent(com.tencent.mm.u.b.class)).publish();
              }
              bool = paramAnonymous2String.bEQ().aays;
              bh.bCz();
              if (bool != com.tencent.mm.model.c.ban().getBoolean(at.a.acOb, true))
              {
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "wxa custom session notify message notice switch changed(to : %b)", new Object[] { Boolean.valueOf(bool) });
                bh.bCz();
                com.tencent.mm.model.c.ban().set(at.a.acOb, Boolean.valueOf(bool));
                ((com.tencent.mm.u.b)MvvmEventCenter.getEvent(com.tencent.mm.u.b.class)).publish();
              }
              AppMethodBeat.o(239198);
            }
          });
          bh.aZW().a(new r(5), 0);
          AppMethodBeat.o(239208);
          return true;
        }
      }.alive();
      new WorkerProfile.28(this, f.hfK).alive();
      new IListener(f.hfK) {}.alive();
      new MediaLeakReporter(2, 12).alive();
      localObject1 = new ak();
      ((ak)localObject1).alive();
      ((ak)localObject1).hil = (com.tencent.mm.plugin.expt.model.a.dMQ().a(com.tencent.mm.plugin.expt.b.c.a.yGb, 30) * 1000L);
      new WorkerProfile.30(this, f.hfK).alive();
      com.tencent.mm.plugin.messenger.a.g.KPJ = new com.tencent.mm.ui.transmit.f();
      com.tencent.mm.pluginsdk.r.a.XNV = new com.tencent.mm.app.plugin.b();
      com.tencent.mm.pluginsdk.ui.span.d.a.YnY = com.tencent.mm.app.plugin.f.aDP();
      if (!bh.aZG()) {
        bh.bCz();
      }
      new dm().publish();
      this.hjI = true;
      com.tencent.mm.opensdk.utils.Log.setLogImpl(new WorkerProfile.4(this));
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.WorkerProfile", "start time check WorkerProfile appOnCreate use time " + (System.currentTimeMillis() - l1));
      localObject1 = new WorkerProfile.32(MMApplicationContext.getContext());
      ((WorkerProfile.32)localObject1).map.put("qqmail", Integer.valueOf(R.l.hardcode_plugin_qqmail_nick));
      ((WorkerProfile.32)localObject1).map.put("fmessage", Integer.valueOf(R.l.hardcode_plugin_fmessage_nick));
      ((WorkerProfile.32)localObject1).map.put("floatbottle", Integer.valueOf(R.l.hardcode_plugin_bottle_nick));
      ((WorkerProfile.32)localObject1).map.put("lbsapp", Integer.valueOf(R.l.hardcode_plugin_lbs_nick));
      ((WorkerProfile.32)localObject1).map.put("shakeapp", Integer.valueOf(R.l.hardcode_plugin_shake_nick));
      ((WorkerProfile.32)localObject1).map.put("medianote", Integer.valueOf(R.l.hardcode_plugin_medianote_nick));
      ((WorkerProfile.32)localObject1).map.put("qqfriend", Integer.valueOf(R.l.hardcode_plugin_qqfriend_nick_title));
      ((WorkerProfile.32)localObject1).map.put("newsapp", Integer.valueOf(R.l.hardcode_plugin_readerappnews_nick));
      ((WorkerProfile.32)localObject1).map.put("facebookapp", Integer.valueOf(R.l.hardcode_plugin_facebookapp_nick));
      ((WorkerProfile.32)localObject1).map.put("masssendapp", Integer.valueOf(R.l.hardcode_plugin_masssend_nick));
      ((WorkerProfile.32)localObject1).map.put("meishiapp", Integer.valueOf(R.l.gJr));
      ((WorkerProfile.32)localObject1).map.put("feedsapp", Integer.valueOf(R.l.hardcode_plugin_feedsapp_nick));
      ((WorkerProfile.32)localObject1).map.put("voipapp", Integer.valueOf(R.l.hardcode_plugin_voip_nick));
      ((WorkerProfile.32)localObject1).map.put("weixin", Integer.valueOf(R.l.gQU));
      ((WorkerProfile.32)localObject1).map.put("filehelper", Integer.valueOf(R.l.gJq));
      ((WorkerProfile.32)localObject1).map.put("cardpackage", Integer.valueOf(R.l.hardcode_plugin_card_package_nick));
      ((WorkerProfile.32)localObject1).map.put("officialaccounts", Integer.valueOf(R.l.hardcode_plugin_official_accounts_nick));
      ((WorkerProfile.32)localObject1).map.put("voicevoipapp", Integer.valueOf(R.l.hardcode_plugin_voipaudio_nick));
      ((WorkerProfile.32)localObject1).map.put("helper_entry", Integer.valueOf(R.l.hardcode_plugin_helper_entry_nick));
      ((WorkerProfile.32)localObject1).map.put("voiceinputapp", Integer.valueOf(R.l.hardcode_plugin_voiceinput_nick));
      ((WorkerProfile.32)localObject1).map.put("linkedinplugin", Integer.valueOf(R.l.hardcode_plugin_linkedin_nick));
      ((WorkerProfile.32)localObject1).map.put("notifymessage", Integer.valueOf(R.l.hardcode_plugin_notify_message_nick));
      ((WorkerProfile.32)localObject1).map.put("gh_f0a92aa7146c", Integer.valueOf(R.l.gJv));
      ((WorkerProfile.32)localObject1).map.put("gh_e087bb5b95e6", Integer.valueOf(R.l.gJu));
      ((WorkerProfile.32)localObject1).map.put("appbrandcustomerservicemsg", Integer.valueOf(R.l.hardcode_plugin_app_brand_customer_service_message_nick));
      ((WorkerProfile.32)localObject1).map.put("appbrand_notify_message", Integer.valueOf(R.l.hardcode_plugin_app_brand_notify_message_nick));
      ((WorkerProfile.32)localObject1).map.put("opencustomerservicemsg", Integer.valueOf(R.l.hardcode_plugin_open_im_kefu_message_nick));
      ((WorkerProfile.32)localObject1).map.put("conversationboxservice", Integer.valueOf(R.l.hardcode_plugin_conv_box_message_nick));
      if (1 == com.tencent.mm.plugin.expt.model.a.dMQ().a(com.tencent.mm.plugin.expt.b.c.a.ztC, 1))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "hardcode mini shop nickname");
        ((WorkerProfile.32)localObject1).map.put("gh_579db1f2cf89", Integer.valueOf(R.l.hardcode_plugin_mini_shop_helper_nick));
      }
      ((WorkerProfile.32)localObject1).map.put("gh_b4af18eac3d5", Integer.valueOf(R.l.gJt));
      ((WorkerProfile.32)localObject1).map.put("gh_3dfda90e39d6", Integer.valueOf(R.l.gJs));
      ((WorkerProfile.32)localObject1).hkc.put("weixin", Integer.valueOf(R.l.gQT));
      com.tencent.mm.contact.d.a((d.a)localObject1);
      bc.a(new WorkerProfile.1(this));
      if (!com.tencent.mm.compatible.util.e.aPU())
      {
        localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
        if (!com.tencent.mm.compatible.util.d.rb(19)) {
          continue;
        }
        l1 = 5L;
        ((com.tencent.mm.plugin.report.service.h)localObject1).idkeyStat(340L, l1, 1L, false);
        localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
        if (!com.tencent.mm.compatible.util.d.rb(19)) {
          continue;
        }
        i = 5001;
        ((com.tencent.mm.plugin.report.service.h)localObject1).b(11098, new Object[] { Integer.valueOf(i), String.format("%s;%s;%s", new Object[] { com.tencent.mm.loader.i.b.bmt(), Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.mm.compatible.util.g.aPZ().getAbsolutePath() }) });
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), Boolean.valueOf(this.hjJ), Integer.valueOf(ChannelUtil.channelId), Integer.valueOf(com.tencent.mm.protocal.d.Yxh), Util.getTopActivityName2(MMApplicationContext.getContext()) });
      AppMethodBeat.o(239174);
      return;
      localObject4 = a.a.ab(com.tencent.mm.vfs.y.bi((String)localObject1, i - 8, 8));
      if (localObject4 != null) {
        continue;
      }
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WorkerProfile", "checkApkExternal, header null");
    }
  }
  
  public final void onReportKVDataReady(byte[] paramArrayOfByte1, final byte[] paramArrayOfByte2, final int paramInt)
  {
    AppMethodBeat.i(19600);
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239057);
        if (bh.bCs())
        {
          AppMethodBeat.o(239057);
          return;
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "summeranrt onReportKVDataReady channel:" + paramInt);
        com.tencent.mm.plugin.report.b.e locale = new com.tencent.mm.plugin.report.b.e(paramArrayOfByte2, paramInt);
        bh.aZW().a(locale, 0);
        AppMethodBeat.o(239057);
      }
    });
    AppMethodBeat.o(19600);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(19599);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "onSceneEnd dkwt type:%d [%d,%d,%s]", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
      paramp = paramString;
      if (paramString.startsWith("autoauth_errmsg_")) {
        paramp = paramString.substring(16);
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WorkerProfile", "summerdiz MM_ERR_IDCDISASTER -3002 errStr:%s", new Object[] { paramp });
      paramString = new com.tencent.mm.autogen.a.ay();
      paramString.hAK.type = 4;
      paramString.hAK.event = paramp;
      paramString.publish();
      AppMethodBeat.o(19599);
      return;
    }
    if ((bh.baz()) && (paramInt1 == 4) && ((paramInt2 == -6) || (paramInt2 == -310) || (paramInt2 == -311)) && (paramString != null) && (paramString.startsWith("autoauth_errmsg_")))
    {
      if (NewTaskUI.jDi() != null)
      {
        AppMethodBeat.o(19599);
        return;
      }
      paramp = new Intent();
      paramp.setClass(MMApplicationContext.getContext(), NewTaskUI.class).addFlags(268435456);
      paramString = MMApplicationContext.getContext();
      paramp = new com.tencent.mm.hellhoundlib.b.a().cG(paramp);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, paramp.aYi(), "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)paramp.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(19599);
      return;
    }
    if ((paramp.getType() == 701) || (paramp.getType() == 702) || (paramp.getType() == 126) || (paramp.getType() == 252) || (paramp.getType() == 763) || (paramp.getType() == 138))
    {
      if ((paramInt1 == 4) && (paramInt2 == -213))
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.aZz();
        paramp = new ny();
        paramp.hQx.status = 0;
        paramp.hQx.reason = 3;
        paramp.publish();
        if (AccountDeletedAlphaAlertUI.jCI() != null)
        {
          AppMethodBeat.o(19599);
          return;
        }
        paramp = new Intent();
        paramp.setClass(MMApplicationContext.getContext(), AccountDeletedAlphaAlertUI.class).addFlags(268435456);
        paramp.putExtra("errmsg", paramString);
        paramString = MMApplicationContext.getContext();
        paramp = new com.tencent.mm.hellhoundlib.b.a().cG(paramp);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, paramp.aYi(), "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)paramp.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/app/WorkerProfile", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19599);
        return;
      }
      if ((paramInt1 == 4) && ((paramInt2 == -100) || (paramInt2 == -2023)))
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.aZz();
        paramString = new ny();
        paramString.hQx.status = 0;
        paramString.hQx.reason = 1;
        paramString.publish();
        AppMethodBeat.o(19599);
      }
    }
    else
    {
      if ((paramInt1 == 4) && (paramInt2 == -213))
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.aZz();
        paramString = new ro();
        paramString.hUF.status = 0;
        paramString.hUF.reason = 3;
        paramString.publish();
      }
      if ((paramInt1 == 4) && ((paramInt2 == -100) || (paramInt2 == -2023)))
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.aZz();
        paramString = new ro();
        paramString.hUF.status = 0;
        paramString.hUF.reason = 1;
        paramString.publish();
      }
    }
    AppMethodBeat.o(19599);
  }
  
  public final void onTerminate()
  {
    AppMethodBeat.i(19594);
    super.onTerminate();
    com.tencent.mm.broadcast.b localb = this.hjT;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.BroadcastController", "summerdiz release oldNoticeInfo[%s], newDisasterNoticeInfoMap[%d]", new Object[] { localb.lvq, Integer.valueOf(localb.lvs.size()) });
    localb.lvt.dead();
    localb.lvq = null;
    localb.lvr.clear();
    localb.lvs.clear();
    this.hjT = null;
    AppMethodBeat.o(19594);
  }
  
  public final String toString()
  {
    return PROCESS_NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile
 * JD-Core Version:    0.7.0.1
 */