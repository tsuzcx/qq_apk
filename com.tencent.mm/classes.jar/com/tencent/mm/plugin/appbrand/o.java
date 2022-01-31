package com.tencent.mm.plugin.appbrand;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ci;
import com.tencent.mm.g.b.a.ci.a;
import com.tencent.mm.g.b.a.cx;
import com.tencent.mm.g.b.a.cx.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.HttpSetting;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.a.c;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.2;
import com.tencent.mm.plugin.appbrand.jsapi.file.an;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.1;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.permission.k;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.d.a;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.t.p;
import com.tencent.mm.plugin.appbrand.t.q.a;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.a;
import com.tencent.mm.plugin.appbrand.task.e.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;
import com.tencent.mm.plugin.appbrand.w.a.c.a;
import com.tencent.mm.plugin.appbrand.widget.b.f.1;
import com.tencent.mm.plugin.appbrand.widget.b.f.10;
import com.tencent.mm.plugin.appbrand.widget.b.f.5;
import com.tencent.mm.plugin.appbrand.widget.b.f.6;
import com.tencent.mm.plugin.appbrand.widget.b.f.7;
import com.tencent.mm.plugin.appbrand.widget.b.f.8;
import com.tencent.mm.plugin.appbrand.widget.b.f.9;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class o
  extends com.tencent.luggage.sdk.d.b
  implements com.tencent.mm.plugin.appbrand.launching.j
{
  public final boolean gRj;
  private volatile com.tencent.mm.plugin.appbrand.permission.e gRk;
  protected AppBrandRemoteTaskController gRl;
  private com.tencent.mm.plugin.appbrand.report.model.m gRm;
  public m gRn;
  public boolean gRo;
  private int gRp;
  private boolean gRq;
  private ap gRr;
  private j gRs;
  private Configuration gRt;
  private final com.tencent.mm.plugin.appbrand.task.f gRu;
  
  static
  {
    AppMethodBeat.i(129062);
    com.tencent.mm.plugin.appbrand.k.e.b.irV = new ModularizingPkgRetrieverWC.1();
    u.eC(((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVr, true));
    AppMethodBeat.o(129062);
  }
  
  public o(Context paramContext, ad paramad)
  {
    super(paramContext, paramad);
    AppMethodBeat.i(143035);
    if ((bp.dud()) || (DebuggerShell.ayQ())) {}
    for (boolean bool = true;; bool = false)
    {
      this.gRj = bool;
      this.gRp = 0;
      this.gRr = null;
      this.gRu = new o.9(this);
      this.gRn = new m();
      this.gPS = this.gRj;
      a(paramad);
      AppMethodBeat.o(143035);
      return;
    }
  }
  
  private void atN()
  {
    AppMethodBeat.i(143037);
    if (!this.gRj)
    {
      AppMethodBeat.o(143037);
      return;
    }
    try
    {
      String str = this.mAppId + ":" + ((AppBrandInitConfigWC)super.wS()).cqQ;
      this.gPC.setContentDescription(str);
      AppMethodBeat.o(143037);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(143037);
    }
  }
  
  private void nf(int paramInt)
  {
    AppMethodBeat.i(129039);
    int i = 369;
    if (vY()) {
      i = 777;
    }
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(i, paramInt, 1L, false);
    AppMethodBeat.o(129039);
  }
  
  public final void a(ad paramad)
  {
    AppMethodBeat.i(143036);
    super.a(paramad);
    if (paramad == null)
    {
      AppMethodBeat.o(143036);
      return;
    }
    Configuration localConfiguration = new Configuration(AppBrandUI.t(paramad.atK().getContext()));
    if ((this.gRt != null) && (AppBrandUI.a(this.gRt, localConfiguration)))
    {
      ab.i("MicroMsg.AppBrandRuntimeWC", "%s update activity configuration, maybe folded or unfolded, set will restart", new Object[] { this });
      aty();
    }
    this.gRt = localConfiguration;
    this.gRl = new AppBrandRemoteTaskController();
    this.gRl.a(paramad.atK(), this.gRu);
    AppMethodBeat.o(143036);
  }
  
  public final void a(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(129034);
    super.a(paramAppBrandInitConfig);
    ab.i("MicroMsg.AppBrandRuntimeWC", "updateConfig %s, willRestart[%b], willRelaunch[%b], finished[%b], scene[%d]", new Object[] { this.mAppId, Boolean.valueOf(this.gPN), Boolean.valueOf(this.gPO), Boolean.valueOf(this.mFinished), Integer.valueOf(wS().bDh.scene) });
    if ((!this.gPN) && (!this.mFinished))
    {
      com.tencent.mm.plugin.appbrand.report.quality.f.a(this, true);
      if ((com.tencent.mm.plugin.appbrand.page.s)super.atj() != null)
      {
        paramAppBrandInitConfig = (com.tencent.mm.plugin.appbrand.page.s)super.atj();
        paramAppBrandInitConfig.getReporter().resetSession();
        paramAppBrandInitConfig.iwK = false;
        paramAppBrandInitConfig.iwL = false;
      }
      paramAppBrandInitConfig = (AppBrandInitConfigWC)super.wS();
      AppBrandSysConfigWC localAppBrandSysConfigWC = atR();
      AppBrandStatObject localAppBrandStatObject = wS().bDh;
      ab.i("MicroMsg.AppBrandTaskUsageRecorder", "updateUsage, appId %s, type %d", new Object[] { paramAppBrandInitConfig.appId, Integer.valueOf(paramAppBrandInitConfig.gXd) });
      String str = paramAppBrandInitConfig.vZ();
      AppBrandMainProcessService.a(new AppBrandTaskUsageRecorder.UpdateTask(new AppBrandTaskUsageRecorder.LaunchCheckParams(paramAppBrandInitConfig, localAppBrandStatObject, localAppBrandSysConfigWC.hiX.gXf, WxaCommLibRuntimeReader.avI().gXf, str, paramAppBrandInitConfig.hiI)));
    }
    atN();
    AppMethodBeat.o(129034);
  }
  
  protected final void atB()
  {
    AppMethodBeat.i(129008);
    if (com.tencent.mm.plugin.appbrand.ui.j.I(this))
    {
      AppMethodBeat.o(129008);
      return;
    }
    super.atB();
    AppMethodBeat.o(129008);
  }
  
  public final boolean atC()
  {
    AppMethodBeat.i(154313);
    if ((!isInBackStack()) && (!a.a(this))) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.AppBrandRuntimeWC", "[wxa_reload]recycleRuntime %s, recycle[%b]", new Object[] { toString(), Boolean.valueOf(bool) });
      if (bool) {
        finish();
      }
      AppMethodBeat.o(154313);
      return bool;
    }
  }
  
  public final boolean atM()
  {
    AppMethodBeat.i(129006);
    boolean bool = ((AppBrandInitConfigWC)super.wS()).hiD;
    AppMethodBeat.o(129006);
    return bool;
  }
  
  protected final void atO()
  {
    AppMethodBeat.i(129014);
    b(com.tencent.mm.plugin.appbrand.networking.a.class, com.tencent.mm.plugin.appbrand.networking.f.itR);
    b(com.tencent.mm.plugin.appbrand.permission.f.class, new com.tencent.mm.plugin.appbrand.permission.i(this));
    b(com.tencent.mm.plugin.appbrand.permission.g.class, k.iCh);
    b(com.tencent.mm.plugin.appbrand.jsapi.media.d.class, com.tencent.mm.plugin.appbrand.jsapi.media.l.hSz);
    this.gPI.F(com.tencent.mm.plugin.appbrand.networking.b.class);
    b(com.tencent.mm.plugin.appbrand.networking.b.class, new com.tencent.mm.plugin.appbrand.networking.e(this));
    b(com.tencent.mm.plugin.appbrand.widget.h.class, com.tencent.mm.plugin.appbrand.widget.i.jaC);
    AppMethodBeat.o(129014);
  }
  
  protected final void atP()
  {
    AppMethodBeat.i(129016);
    o localo = a.xL(this.mAppId);
    if ((localo != null) && (this != localo)) {
      localo.atX();
    }
    this.gRl.ER(this.mAppId);
    AppMethodBeat.o(129016);
  }
  
  public final void atQ()
  {
    AppMethodBeat.i(143039);
    this.gRl.EQ(this.mAppId);
    AppMethodBeat.o(143039);
  }
  
  public final AppBrandSysConfigWC atR()
  {
    AppMethodBeat.i(129027);
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)d(AppBrandSysConfigWC.class, false);
    AppMethodBeat.o(129027);
    return localAppBrandSysConfigWC;
  }
  
  public final AppBrandInitConfigWC atS()
  {
    AppMethodBeat.i(156889);
    AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.wS();
    AppMethodBeat.o(156889);
    return localAppBrandInitConfigWC;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.s atT()
  {
    AppMethodBeat.i(156890);
    com.tencent.mm.plugin.appbrand.page.s locals = (com.tencent.mm.plugin.appbrand.page.s)super.atj();
    AppMethodBeat.o(156890);
    return locals;
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c atU()
  {
    AppMethodBeat.i(156891);
    com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)super.ws();
    AppMethodBeat.o(156891);
    return localc;
  }
  
  public final MMActivity atV()
  {
    AppMethodBeat.i(156893);
    MMActivity localMMActivity = (MMActivity)super.getContext();
    AppMethodBeat.o(156893);
    return localMMActivity;
  }
  
  public final void atW()
  {
    int k = 0;
    AppMethodBeat.i(129041);
    Object localObject3 = this.gPG;
    Object localObject4 = wS();
    AppBrandSysConfigLU localAppBrandSysConfigLU = wR();
    Object localObject1 = getAppConfig();
    com.tencent.mm.plugin.appbrand.m.a locala = new com.tencent.mm.plugin.appbrand.m.a();
    int i;
    label91:
    label113:
    Object localObject2;
    if ((((AppBrandInitConfigLU)localObject4).bCX) || (((AppBrandInitConfigLU)localObject4).vY()))
    {
      m = 1;
      locala.isl = m;
      if ((localAppBrandSysConfigLU.hiX.gXe != 1) && (localAppBrandSysConfigLU.hiX.gXe != 2)) {
        break label951;
      }
      i = 1;
      if (!localAppBrandSysConfigLU.bCW) {
        break label961;
      }
      if ((i != 0) && (localAppBrandSysConfigLU.bDm)) {
        break label956;
      }
      m = 1;
      locala.ism = m;
      i = com.tencent.mm.plugin.appbrand.config.d.p(new int[] { localAppBrandSysConfigLU.bDI.hhI.hil, ((com.tencent.mm.plugin.appbrand.config.a)localObject1).hgP.cMs });
      if (i > 0) {
        locala.isn = i;
      }
      i = com.tencent.mm.plugin.appbrand.config.d.p(new int[] { localAppBrandSysConfigLU.bDI.hhI.hii, ((com.tencent.mm.plugin.appbrand.config.a)localObject1).hgP.hhc });
      if (i > 0) {
        locala.iso = i;
      }
      i = com.tencent.mm.plugin.appbrand.config.d.p(new int[] { localAppBrandSysConfigLU.bDI.hhI.hij, ((com.tencent.mm.plugin.appbrand.config.a)localObject1).hgP.hhd });
      if (i > 0) {
        locala.isp = i;
      }
      i = com.tencent.mm.plugin.appbrand.config.d.p(new int[] { localAppBrandSysConfigLU.bDI.hhI.hik, ((com.tencent.mm.plugin.appbrand.config.a)localObject1).hgP.hhe });
      if (i > 0) {
        locala.isq = i;
      }
      locala.bDq = localAppBrandSysConfigLU.bDq;
      locala.isr = localAppBrandSysConfigLU.bDt;
      locala.bDr = localAppBrandSysConfigLU.bDr;
      locala.bDs = localAppBrandSysConfigLU.bDs;
      locala.bDz = localAppBrandSysConfigLU.bDz;
      locala.bDA = localAppBrandSysConfigLU.bDA;
      locala.bDB = localAppBrandSysConfigLU.bDB;
      locala.bDC = localAppBrandSysConfigLU.bDC;
      locala.bDD = localAppBrandSysConfigLU.bDD;
      if (localAppBrandSysConfigLU.bDI.hhI.mode != 1) {
        break label983;
      }
      if (localAppBrandSysConfigLU.bDI.hhI.hig != null) {
        locala.iss = localAppBrandSysConfigLU.bDI.hhI.hig;
      }
      label422:
      locala.mode = localAppBrandSysConfigLU.bDI.hhI.mode;
      locala.isu = com.tencent.mm.plugin.appbrand.config.d.s(this);
      if (!((AppBrandInitConfigLU)localObject4).vY()) {
        break label1031;
      }
      i = localAppBrandSysConfigLU.bDI.hhT;
      label464:
      locala.hhD = i;
      locala.bDv = localAppBrandSysConfigLU.bDv;
      locala.bDw = localAppBrandSysConfigLU.bDw;
      locala.isv = com.tencent.mm.plugin.appbrand.config.d.ayp();
      localObject2 = "";
      localObject1 = localObject2;
      if (localAppBrandSysConfigLU.bDI != null)
      {
        localObject1 = localObject2;
        if (localAppBrandSysConfigLU.bDI.hhI != null) {
          localObject1 = localAppBrandSysConfigLU.bDI.hhI.him;
        }
      }
      localObject2 = localObject1;
      if (bo.isNullOrNil((String)localObject1)) {
        localObject2 = "servicewechat.com";
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(localAppBrandSysConfigLU.appId);
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(localAppBrandSysConfigLU.hiX.gXf);
      ((StringBuilder)localObject1).append("/page-frame.html");
      locala.referer = ((StringBuilder)localObject1).toString();
      locala.bCW = ((AppBrandInitConfigLU)localObject4).bCW;
      locala.isw = localAppBrandSysConfigLU.hiX.gXe;
      ((Collection)localObject3).add(locala);
      this.gPG.add(com.tencent.mm.plugin.appbrand.config.d.a(atR()));
      localObject1 = this.gPG;
      localObject2 = atR();
      localObject3 = new q.a();
      ((q.a)localObject3).hhQ = ((AppBrandSysConfigLU)localObject2).bDI.hhQ;
      ((Collection)localObject1).add(localObject3);
      localObject1 = this.gPG;
      localObject2 = wR();
      localObject3 = getAppConfig();
      localObject4 = new com.tencent.mm.plugin.appbrand.b.a();
      if (!j.a.kQ(((com.tencent.mm.plugin.appbrand.config.h)localObject2).hiX.gXe)) {
        break label1043;
      }
      ((com.tencent.mm.plugin.appbrand.b.a)localObject4).gYd = ((com.tencent.mm.plugin.appbrand.config.a)localObject3).hgU.contains("audio");
      label801:
      ((Collection)localObject1).add(localObject4);
      localObject1 = atR();
      localObject2 = new com.tencent.mm.plugin.appbrand.performance.a();
      if ((!((AppBrandSysConfigLU)localObject1).bDk) || (((com.tencent.mm.plugin.appbrand.config.h)localObject1).hiX.gXe != 1)) {
        break label1056;
      }
      m = 1;
      label848:
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject2).iAE = m;
      if (((com.tencent.mm.plugin.appbrand.config.h)localObject1).hiX.gXe == 0) {
        break label1061;
      }
    }
    label1031:
    label1043:
    label1056:
    label1061:
    for (int m = 1;; m = 0)
    {
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject2).iAF = m;
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject2).iAG = ((AppBrandSysConfigLU)localObject1).bDj;
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject2).iAE |= DebuggerShell.ayQ();
      m = ((com.tencent.mm.plugin.appbrand.performance.a)localObject2).iAF;
      if (!com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED)
      {
        i = k;
        if (!bp.dud()) {}
      }
      else
      {
        i = 1;
      }
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject2).iAF = (m | i);
      this.gPG.add(localObject2);
      AppMethodBeat.o(129041);
      return;
      m = 0;
      break;
      label951:
      int j = 0;
      break label91;
      label956:
      m = 0;
      break label113;
      label961:
      if ((j == 0) || (!localAppBrandSysConfigLU.bDj))
      {
        m = 1;
        break label113;
      }
      m = 0;
      break label113;
      label983:
      if ((localAppBrandSysConfigLU.bDI.hhI.mode != 2) || (localAppBrandSysConfigLU.bDI.hhI.hih == null)) {
        break label422;
      }
      locala.ist = localAppBrandSysConfigLU.bDI.hhI.hih;
      break label422;
      j = localAppBrandSysConfigLU.bDI.hhD;
      break label464;
      ((com.tencent.mm.plugin.appbrand.b.a)localObject4).gYd = ((AppBrandSysConfigLU)localObject2).hiS;
      break label801;
      m = 0;
      break label848;
    }
  }
  
  public final void atX()
  {
    AppMethodBeat.i(129043);
    this.gPR = false;
    if (this.gPw != null) {
      this.gPw.l(this);
    }
    finish();
    if ((this.gPw instanceof l)) {
      ((l)this.gPw).wN();
    }
    AppMethodBeat.o(129043);
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.r atm()
  {
    int j = 1;
    AppMethodBeat.i(129037);
    Object localObject;
    if (vY())
    {
      localObject = com.tencent.mm.plugin.appbrand.game.preload.e.aAT();
      if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lTz, false) == true)
      {
        i = 1;
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).huq = i;
        ab.i("MicroMsg.WAGamePreloadStatisManager", "misPreload:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).huq) });
        AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.wS();
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).hul = localAppBrandInitConfigWC.appId;
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).hum = localAppBrandInitConfigWC.bDc;
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).hun = localAppBrandInitConfigWC.gXd;
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).huo = (localAppBrandInitConfigWC.bCV + 1000);
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).hup = localAppBrandInitConfigWC.hiI.ikX;
      }
    }
    else
    {
      switch (((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).hun)
      {
      default: 
        label160:
        if (wS().bDh != null) {
          ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).mScene = wS().bDh.scene;
        }
        if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lWc, false) == true)
        {
          i = 1;
          label207:
          ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).hus = i;
          ab.i("MicroMsg.WAGamePreloadStatisManager", "mHasSplashScreen:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).hus) });
          localObject = com.tencent.mm.plugin.appbrand.ui.e.a((MMActivity)super.getContext(), this);
          ((com.tencent.mm.plugin.appbrand.ui.r)localObject).cD(((AppBrandInitConfigWC)super.wS()).iconUrl, ((AppBrandInitConfigWC)super.wS()).cqQ);
          if (wS().bDh.scene != 1023) {
            break label343;
          }
        }
        break;
      }
    }
    label343:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        ((com.tencent.mm.plugin.appbrand.ui.r)localObject).aHB();
      }
      AppMethodBeat.o(129037);
      return localObject;
      i = 0;
      break;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).hun = 1;
      break label160;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).hun = 2;
      break label160;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).hun = 3;
      break label160;
      i = 0;
      break label207;
    }
  }
  
  protected final void atq()
  {
    AppMethodBeat.i(129019);
    super.atq();
    nf(11);
    AppMethodBeat.o(129019);
  }
  
  protected final void atr()
  {
    AppMethodBeat.i(129017);
    super.atr();
    AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.wS();
    this.gRn.C(0, System.currentTimeMillis() - localAppBrandInitConfigWC.startTime);
    nf(1);
    com.tencent.mm.plugin.appbrand.performance.c.a(this.mAppId, "ActivityCreate", ((AppBrandInitConfigWC)super.wS()).startTime, System.currentTimeMillis());
    MMToClientEvent.a(this.mAppId, new o.16(this));
    com.tencent.mm.plugin.appbrand.d.a.u(this);
    new d.a(this, (byte)0);
    this.gRn.C(8, System.currentTimeMillis() - ((AppBrandInitConfigWC)super.wS()).startTime);
    nf(2);
    com.tencent.mm.plugin.appbrand.jsapi.v.a.c.a((com.tencent.mm.plugin.appbrand.e.b)E(com.tencent.mm.plugin.appbrand.e.b.class), (com.tencent.mm.plugin.appbrand.e.a)E(com.tencent.mm.plugin.appbrand.e.a.class), (com.tencent.mm.plugin.appbrand.service.c)super.ws());
    AppMethodBeat.o(129017);
  }
  
  protected r ats()
  {
    AppMethodBeat.i(129011);
    com.tencent.mm.plugin.appbrand.service.c localc;
    if (super.wV()) {
      if (vY())
      {
        localc = com.tencent.mm.plugin.appbrand.task.e.a(this.mAppId, com.tencent.mm.plugin.appbrand.task.g.eM(true));
        localObject = localc;
        if (localc == null) {
          localObject = new com.tencent.mm.plugin.appbrand.game.b();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(129011);
      return localObject;
      localObject = new com.tencent.mm.plugin.appbrand.service.c(com.tencent.luggage.sdk.b.a.c.g.bEQ);
      continue;
      localc = com.tencent.mm.plugin.appbrand.task.e.a(this.mAppId, com.tencent.mm.plugin.appbrand.task.g.eM(vY()));
      if (localc != null) {
        break;
      }
      if (vY()) {}
      for (localObject = "WAGame";; localObject = "WAService")
      {
        ab.i("MicroMsg.AppBrandRuntimeWC", "[%s] [applaunch] [preload] createService got no preloaded", new Object[] { localObject });
        if (((!com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.f.DEBUG) && (!DebuggerShell.ayQ())) || (!com.tencent.mm.plugin.appbrand.task.b.aLC())) {
          break;
        }
        localObject = new IllegalStateException("[ForcePreload] enabled, but not preload");
        AppMethodBeat.o(129011);
        throw ((Throwable)localObject);
      }
      if (vY()) {
        localObject = new com.tencent.mm.plugin.appbrand.game.b();
      } else {
        localObject = new com.tencent.mm.plugin.appbrand.service.c();
      }
    }
    if (vY()) {}
    for (Object localObject = "WAGame";; localObject = "WAService")
    {
      ab.i("MicroMsg.AppBrandRuntimeWC", "[%s] [applaunch] [preload] createService preloaded", new Object[] { localObject });
      localObject = localc;
      break;
    }
  }
  
  protected com.tencent.mm.plugin.appbrand.page.r att()
  {
    AppMethodBeat.i(129012);
    try
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.EM(this.mAppId).iIR = bo.aoy();
      label19:
      if (vY()) {}
      for (Object localObject = new com.tencent.mm.plugin.appbrand.game.f.b((MMActivity)super.getContext(), this);; localObject = new com.tencent.mm.plugin.appbrand.page.s((MMActivity)super.getContext(), this))
      {
        ((com.tencent.mm.plugin.appbrand.page.s)localObject).setDecorWidgetFactory(new com.tencent.mm.plugin.appbrand.page.e());
        AppMethodBeat.o(129012);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      break label19;
    }
  }
  
  public final boolean atu()
  {
    AppMethodBeat.i(129024);
    if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lWc, false))
    {
      boolean bool = getAppConfig().hgX;
      ab.w("MicroMsg.AppBrandRuntimeWC", "manualHideSplash:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(129024);
      return bool;
    }
    AppMethodBeat.o(129024);
    return false;
  }
  
  protected final void atx()
  {
    AppMethodBeat.i(129023);
    this.gRl.a(this.mAppId, ((AppBrandInitConfigWC)super.wS()).gXd, com.tencent.mm.plugin.appbrand.task.g.c((AppBrandInitConfigWC)super.wS()));
    AppMethodBeat.o(129023);
  }
  
  public final boolean b(AppBrandInitConfig paramAppBrandInitConfig)
  {
    boolean bool = false;
    AppMethodBeat.i(143043);
    paramAppBrandInitConfig = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    AppBrandStatObject localAppBrandStatObject = paramAppBrandInitConfig.bDh;
    if ((this.gRq) || (localAppBrandStatObject.scene == 1099))
    {
      ab.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] mShouldRelaunchCausedByFunctionalPageOpen[%b] newScene[%d]", new Object[] { this.mAppId, Boolean.valueOf(this.gRq), Integer.valueOf(localAppBrandStatObject.scene) });
      if (localAppBrandStatObject.scene == 1099) {
        bool = true;
      }
      this.gRq = bool;
      AppMethodBeat.o(143043);
      return true;
    }
    if (!TextUtils.isEmpty(paramAppBrandInitConfig.hiw))
    {
      ab.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] enterPath[%s]", new Object[] { this.mAppId, paramAppBrandInitConfig.hiw });
      AppMethodBeat.o(143043);
      return true;
    }
    if ((atM()) && (wS().bDh.scene == localAppBrandStatObject.scene))
    {
      ab.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. special for fakeNative appId[%s], newScene[%d]", new Object[] { this.mAppId, Integer.valueOf(localAppBrandStatObject.scene) });
      AppMethodBeat.o(143043);
      return false;
    }
    int i = localAppBrandStatObject.scene;
    if (org.apache.commons.b.a.contains(new int[] { 1001, 1003, 1023, 1038, 1056, 1080, 1083, 1089, 1090, 1103, 1104, 1113, 1114, 1117, 1131 }, i))
    {
      ab.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. keepNoRelaunch appId[%s] newScene[%d]", new Object[] { this.mAppId, Integer.valueOf(localAppBrandStatObject.scene) });
      AppMethodBeat.o(143043);
      return false;
    }
    ab.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] fallback logic", new Object[] { this.mAppId });
    AppMethodBeat.o(143043);
    return true;
  }
  
  public final void close()
  {
    AppMethodBeat.i(129009);
    OpenBusinessViewUtil.z(this);
    if (atM())
    {
      super.close();
      AppMethodBeat.o(129009);
      return;
    }
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128975);
        o.g(o.this);
        AppMethodBeat.o(128975);
      }
    };
    com.tencent.mm.plugin.appbrand.widget.b.f localf = new com.tencent.mm.plugin.appbrand.widget.b.f();
    Object localObject1 = new o.10(this, local1);
    if ((atR() == null) || ((MMActivity)super.getContext() == null))
    {
      ab.w("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "invalid close state");
      i = 0;
    }
    AppBrandSysConfigWC localAppBrandSysConfigWC;
    for (;;)
    {
      if (i == 0) {
        local1.run();
      }
      AppMethodBeat.o(129009);
      return;
      localAppBrandSysConfigWC = atR();
      if (!localAppBrandSysConfigWC.hjb)
      {
        ab.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "can not show evaluate dialog");
        i = 0;
      }
      else
      {
        long l1 = com.tencent.mm.modelappbrand.b.aci() / 1000L;
        long l2 = System.currentTimeMillis() / 1000L;
        ab.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "app time start:%s, close:%s, least:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(localAppBrandSysConfigWC.hjc) });
        if (l2 - l1 < localAppBrandSysConfigWC.hjc)
        {
          ab.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "time not enough to show evaluate dialog");
          i = 0;
        }
        else
        {
          localObject3 = (AppBrandInitConfigWC)super.wS();
          localf.userName = ((AppBrandInitConfigWC)localObject3).username;
          if (!bo.isNullOrNil(localf.userName)) {
            break;
          }
          ab.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "username is null, can not show evaluate dialog");
          i = 0;
        }
      }
    }
    Object localObject2 = (MMActivity)super.getContext();
    Object localObject3 = ((AppBrandInitConfigWC)localObject3).cqQ;
    localf.dialog = new com.tencent.mm.plugin.crashfix.b.a((Context)localObject2, 2131493041);
    localf.dialog.setCancelable(true);
    localf.dialog.setCanceledOnTouchOutside(true);
    Object localObject4 = localf.dialog.getWindow();
    if (localObject4 != null)
    {
      ((Window)localObject4).getDecorView().setPadding(0, 0, 0, 0);
      localObject5 = ((Window)localObject4).getAttributes();
      ((WindowManager.LayoutParams)localObject5).gravity = 81;
      ((WindowManager.LayoutParams)localObject5).height = -2;
      ((WindowManager.LayoutParams)localObject5).width = -1;
      ((Window)localObject4).setAttributes((WindowManager.LayoutParams)localObject5);
      ((Window)localObject4).setWindowAnimations(2131493040);
    }
    localObject4 = (LinearLayout)LayoutInflater.from(localf.dialog.getContext()).inflate(2130968683, null, false);
    localf.dialog.setContentView((View)localObject4);
    Object localObject5 = af.hQ(localf.dialog.getContext());
    int i = Math.min(((Point)localObject5).x, ((Point)localObject5).y);
    localObject5 = new FrameLayout.LayoutParams(i, -2);
    ((FrameLayout.LayoutParams)localObject5).gravity = 1;
    ((LinearLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
    ab.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "createEvaluateDialog, dialog width:%d", new Object[] { Integer.valueOf(i) });
    localf.jjy = ((TextView)localf.dialog.findViewById(2131821205));
    localf.jjA = ((LinearLayout)localf.dialog.findViewById(2131821208));
    localf.jjz = ((FrameLayout)localf.dialog.findViewById(2131821206));
    ((TextView)localf.dialog.findViewById(2131821207)).setOnClickListener(new f.6(localf, (Context)localObject2));
    localf.jjx = ((RatingBar)localf.dialog.findViewById(2131821204));
    localf.jjx.setOnRatingBarChangeListener(new f.7(localf));
    localf.jjw = ((TextView)localf.dialog.findViewById(2131821203));
    if (!bo.isNullOrNil((String)localObject3))
    {
      localf.jjw.setVisibility(0);
      localf.jjw.setText(((Context)localObject2).getString(2131296634, new Object[] { localObject3 }));
      label669:
      ((ImageView)localf.dialog.findViewById(2131821202)).setOnClickListener(new f.8(localf));
      localObject2 = (ViewGroup)((LinearLayout)localObject4).getParent();
      if (localObject2 != null)
      {
        ((ViewGroup)localObject2).setOnClickListener(new f.9(localf));
        ((LinearLayout)localObject4).setOnClickListener(new f.10(localf));
      }
      localf.dialog = localf.dialog;
      localf.dialog.setOnCancelListener(new f.1(localf));
      localf.dialog.setOnDismissListener(new f.5(localf, (Runnable)localObject1));
      localf.jju = false;
      localAppBrandSysConfigWC.hjb = false;
      if (this != null) {
        break label871;
      }
      localObject1 = null;
      label803:
      localf.appId = ((String)localObject1);
      if (!bo.isNullOrNil(localf.appId)) {
        break label880;
      }
      ab.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "saveEvaluateReport, no app id");
    }
    for (;;)
    {
      localf.du(1, 1);
      if (localf.dialog != null) {
        localf.dialog.show();
      }
      i = 1;
      break;
      localf.jjw.setVisibility(8);
      break label669;
      label871:
      localObject1 = this.mAppId;
      break label803;
      label880:
      localObject1 = (AppBrandInitConfigWC)super.wS();
      localf.cpW = "";
      if (localObject1 != null) {
        localf.cpW = ((AppBrandInitConfigWC)localObject1).vZ();
      }
      localf.scene = 1000;
      if ((localObject1 != null) && (((AppBrandInitConfigLU)localObject1).bDh != null)) {
        localf.scene = ((AppBrandInitConfigLU)localObject1).bDh.scene;
      }
      localf.cmG = "";
      if (((com.tencent.mm.plugin.appbrand.service.c)super.ws() != null) && (((com.tencent.mm.plugin.appbrand.service.c)super.ws()).aLy() != null)) {
        localf.cmG = ((com.tencent.mm.plugin.appbrand.service.c)super.ws()).aLy().hzM;
      }
    }
  }
  
  protected final void f(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(138113);
    if (paramAppBrandInitConfig == null) {
      ((AppBrandInitConfigWC)super.wS()).resetSession();
    }
    super.f(paramAppBrandInitConfig);
    AppMethodBeat.o(138113);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(143038);
    if (g.e(this))
    {
      k(new o.11(this), 0L);
      AppMethodBeat.o(143038);
      return;
    }
    super.finish();
    AppMethodBeat.o(143038);
  }
  
  public final void ng(int paramInt)
  {
    AppMethodBeat.i(129042);
    com.tencent.mm.plugin.appbrand.ui.r localr = this.gPD;
    if ((localr instanceof com.tencent.mm.plugin.appbrand.launching.j)) {
      ((com.tencent.mm.plugin.appbrand.launching.j)localr).ng(paramInt);
    }
    AppMethodBeat.o(129042);
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(129013);
    com.tencent.mm.plugin.appbrand.jsapi.q.h.a(paramConfiguration, this.mAppId);
    this.gRt = new Configuration(paramConfiguration);
    AppMethodBeat.o(129013);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(129015);
    atP();
    a.c(this);
    atN();
    boolean bool = WXHardCoderJNI.hcMiniProgramLaunchEnable;
    int j = WXHardCoderJNI.hcMiniProgramLaunchDelay;
    int k = WXHardCoderJNI.hcMiniProgramLaunchCPU;
    int m = WXHardCoderJNI.hcMiniProgramLaunchIO;
    if (WXHardCoderJNI.hcMiniProgramLaunchThr) {}
    for (int i = com.tencent.mm.kernel.g.RO().dtc();; i = 0)
    {
      this.gRp = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMiniProgramLaunchTimeout, 801, WXHardCoderJNI.hcMiniProgramLaunchAction, "MicroMsg.AppBrandRuntimeWC");
      ab.i("MicroMsg.AppBrandRuntimeWC", "hardcoder miniprogram launch launchStartPerformance [%d]", new Object[] { Integer.valueOf(this.gRp) });
      super.onCreate();
      atO();
      com.tencent.mm.plugin.appbrand.report.quality.a.q(this);
      com.tencent.mm.plugin.appbrand.report.quality.f.a(this, false);
      Object localObject = com.tencent.luggage.game.f.a.vN();
      String str = this.mAppId;
      bool = vY();
      ((com.tencent.luggage.game.f.a)localObject).appId = str;
      ab.i("MicroMsg.MBNiReporter", "hy: appId:%s,isGame:%s", new Object[] { str, Boolean.valueOf(bool) });
      if (bool) {
        e.a(str, ((com.tencent.luggage.game.f.a)localObject).bCv);
      }
      a(new o.12(this));
      a(new i.c()
      {
        public final void prepare()
        {
          AppMethodBeat.i(128999);
          o.a(o.this, this);
          AppMethodBeat.o(128999);
        }
      });
      a(new o.14(this));
      a(new o.15(this));
      localObject = new j(this);
      this.gRs = ((j)localObject);
      a((i.c)localObject);
      this.gRl.a(this.mAppId, ((AppBrandInitConfigWC)super.wS()).gXd, com.tencent.mm.plugin.appbrand.task.g.c((AppBrandInitConfigWC)super.wS()));
      com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
      com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.o(this);
      com.tencent.mm.plugin.appbrand.backgroundfetch.i.o(this);
      ab.i("MicroMsg.SameLayer.AppBrandXWebVideoStrategy", "setup VideoMediaPlayerFactory, runtime:%s", new Object[] { this });
      a(c.a.aSB());
      localObject = wZ().hiz;
      if ((localObject != null) && (!bo.isNullOrNil(((AppBrandLaunchReferrer)localObject).businessType)))
      {
        str = this.mAppId;
        n.yd(str).gRf = ((AppBrandLaunchReferrer)localObject).hiK;
        n.yd(str).gRe = ((AppBrandLaunchReferrer)localObject).businessType;
        n.yd(str).gRg = false;
        n.yd(str).gRi = false;
        n.yd(str).gRh = false;
        e.a(str, new OpenBusinessViewUtil.2(str));
      }
      this.gRm = new com.tencent.mm.plugin.appbrand.report.model.m(this);
      this.gRm.iHI = bo.yB();
      com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.i.a(this.mAppId, ato(), wS().bDh);
      AppMethodBeat.o(129015);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(129022);
    super.onDestroy();
    com.tencent.mm.plugin.appbrand.d.a.v(this);
    if (this.gRp != 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.gRp);
      this.gRp = 0;
    }
    if (DebuggerShell.ayQ())
    {
      if (this.gRr != null) {
        this.gRr.stopTimer();
      }
      com.tencent.mm.sdk.g.d.ysm.execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128976);
          AppBrandPerformanceManager.g(o.this);
          AppMethodBeat.o(128976);
        }
      });
      com.tencent.mm.plugin.appbrand.performance.b.Eu(this.mAppId);
    }
    AppBrandStickyBannerLogic.a.release(this.mAppId);
    Object localObject1 = AppBrandMusicClientService.ioY;
    ((AppBrandMusicClientService)localObject1).ioX.clear();
    ((AppBrandMusicClientService)localObject1).ioZ = "";
    n.remove(this.mAppId);
    com.tencent.mm.plugin.appbrand.media.record.c.onDestroy();
    atQ();
    localObject1 = wP();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (com.tencent.mm.plugin.appbrand.appstorage.l)((com.tencent.mm.plugin.appbrand.appstorage.s)localObject1).Y(com.tencent.mm.plugin.appbrand.appstorage.l.class);
      if (localObject2 != null) {
        com.tencent.mm.vfs.e.deleteFile(((com.tencent.mm.plugin.appbrand.appstorage.l)localObject2).gZQ + "/dir.lock");
      }
      ((com.tencent.mm.plugin.appbrand.appstorage.s)localObject1).release();
    }
    a.b(this);
    if (this.gRm != null) {
      localObject1 = this.gRm;
    }
    for (;;)
    {
      try
      {
        localObject2 = n.yc(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).htX.mAppId);
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).iHg = com.tencent.mm.plugin.appbrand.report.e.cZ(ah.getContext());
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).appId = ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).htX.mAppId;
        if (((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).htX.atR() != null) {
          continue;
        }
        i = ((AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).htX.wS()).bDc;
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).bDc = i;
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).cmE = (((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).htX.gPz.gXd + 1);
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).scene = ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).htX.wS().bDh.scene;
        if (!((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).iHJ) {
          continue;
        }
        i = 1;
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).iHK = i;
        if (!((n)localObject2).gQX.get()) {
          continue;
        }
        i = 1;
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).iHL = i;
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).iHM = bo.av(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).iHI);
        ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).iHN = bo.aoy();
        ab.i("MicroMsg.AppBrand.Report.kv_14576", "report|" + ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).toString());
        com.tencent.mm.plugin.report.e.qrI.e(14576, new Object[] { ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).iHg, ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).appId, Integer.valueOf(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).bDc), Integer.valueOf(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).cmE), Integer.valueOf(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).scene), ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).cpW, Integer.valueOf(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).iHK), Integer.valueOf(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).iHL), Long.valueOf(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).iHM), Long.valueOf(((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).iHN) });
      }
      catch (Exception localException)
      {
        int i;
        ab.e("MicroMsg.AppBrand.Report.kv_14576", "report exp %s", new Object[] { localException });
        continue;
      }
      com.tencent.mm.plugin.appbrand.ui.recommend.e.s(this);
      this.gRm = null;
      this.gRs = null;
      com.tencent.mm.plugin.appbrand.jsapi.v.a.c.release();
      AppMethodBeat.o(129022);
      return;
      i = ((com.tencent.mm.plugin.appbrand.report.model.m)localObject1).htX.atR().hiX.gXf;
      continue;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(129021);
    AppBrandRemoteTaskController localAppBrandRemoteTaskController = this.gRl;
    localAppBrandRemoteTaskController.iKw = AppBrandRemoteTaskController.a.iKQ;
    AppBrandMainProcessService.a(localAppBrandRemoteTaskController);
    AppMethodBeat.o(129021);
  }
  
  public void onReady()
  {
    AppMethodBeat.i(129018);
    super.onReady();
    if (this.gRp != 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.gRp);
      this.gRp = 0;
    }
    long l1 = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.wS()).startTime;
    com.tencent.mm.plugin.appbrand.report.e.a(l1, this.gRo, vY());
    Object localObject1;
    boolean bool1;
    Object localObject2;
    int i;
    label244:
    Object localObject3;
    label259:
    label305:
    Object localObject4;
    cx localcx;
    if ((AppBrandInitConfigWC)super.wS() != null)
    {
      localObject1 = ((AppBrandInitConfigWC)super.wS()).cqQ;
      ab.i("MicroMsg.AppBrandRuntimeWC", "onHideSplash: %s, cost: %dms, download : %b", new Object[] { localObject1, Long.valueOf(l1), Boolean.valueOf(this.gRo) });
      l1 = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.wS()).startTime;
      this.gRn.C(5, l1);
      localObject1 = this.gRn;
      bool1 = this.gRo;
      boolean bool2 = ((AppBrandInitConfigWC)super.wS()).bDg;
      boolean bool3 = ((AppStartupPerformanceReportBundle)U(AppStartupPerformanceReportBundle.class)).ila;
      localObject2 = this.mAppId;
      ((m)localObject1).cO = 0;
      ((m)localObject1).mType = 0;
      if (atR() != null)
      {
        ((m)localObject1).cO = atR().hiX.gXf;
        ((m)localObject1).mType = (atR().hiX.gXe + 1);
      }
      if (!bool1) {
        break label1184;
      }
      i = 1;
      ((m)localObject1).gQP = i;
      if (!vY()) {
        break label1189;
      }
      i = 1;
      ((m)localObject1).gQT = i;
      ((m)localObject1).mScene = wS().bDh.scene;
      ((m)localObject1).gQR = bool2;
      ((m)localObject1).gQS = bool3;
      localObject3 = new StringBuilder();
      i = 0;
      if (i >= ((m)localObject1).gQO.length) {
        break label1223;
      }
      if (localObject1.gQO[i] >= 0L) {
        break label1194;
      }
      ab.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: abort, illegal value: %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(localObject1.gQO[i]) });
      AppBrandPerformanceManager.a(this, 202, l1);
      com.tencent.mm.plugin.appbrand.performance.c.hE(((AppBrandInitConfigWC)super.wS()).startTime);
      localObject1 = String.format("{ \"appMd5\": \"%s\" }", new Object[] { atR().hiX.cqq });
      com.tencent.mm.plugin.appbrand.performance.c.a(this.mAppId, "Native", "startupDone", ((AppBrandInitConfigWC)super.wS()).startTime, System.currentTimeMillis(), (String)localObject1);
      com.tencent.mm.plugin.appbrand.report.quality.a.a(this.mAppId, this);
      if ((DebuggerShell.ayQ()) && (this.gRr == null))
      {
        this.gRr = new ap(com.tencent.mm.plugin.appbrand.s.m.aNS().oNc.getLooper(), new o.8(this), true);
        this.gRr.ag(1000L, 1000L);
      }
      if (vY())
      {
        localObject1 = com.tencent.mm.plugin.appbrand.game.preload.d.aAQ();
        l1 = bo.aoy();
        long l2 = ((AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).htX.wS()).startTime;
        com.tencent.mm.plugin.appbrand.game.preload.e.aAT().de(2001, (int)(l1 - l2));
      }
      com.tencent.mm.plugin.appbrand.ui.recommend.e.t(this);
      localObject1 = this.gRl;
      if (!AppBrandRemoteTaskController.iKC)
      {
        ((AppBrandRemoteTaskController)localObject1).iKw = AppBrandRemoteTaskController.a.iKP;
        AppBrandMainProcessService.a((MainProcessTask)localObject1);
        AppBrandRemoteTaskController.iKC = true;
      }
      if (wP() != null)
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.appstorage.l)wP().Y(com.tencent.mm.plugin.appbrand.appstorage.l.class);
        com.tencent.mm.vfs.e.b(((com.tencent.mm.plugin.appbrand.appstorage.l)localObject1).gZQ + "/dir.lock", new byte[1], 1);
      }
      localObject4 = com.tencent.mm.plugin.appbrand.report.quality.a.EM(this.mAppId);
      if ((localObject4 != null) && (!vY()))
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.aLt();
        a.f.b.j.q(this, "runtime");
        localcx = new cx();
        localObject3 = com.tencent.mm.plugin.appbrand.report.quality.a.EM(this.mAppId);
        if (localObject3 == null) {
          break label1538;
        }
        localcx.jdMethod_if(((QualitySessionRuntime)localObject3).ikX);
        localcx.ig(((QualitySessionRuntime)localObject3).appId);
        localcx.cZB = ((QualitySessionRuntime)localObject3).iIG;
        localcx.ddJ = cx.a.hl(((QualitySessionRuntime)localObject3).iIF);
        localcx.cZD = ((QualitySessionRuntime)localObject3).apptype;
        localcx.cRG = ((QualitySessionRuntime)localObject3).scene;
        localObject1 = (com.tencent.mm.plugin.appbrand.page.s)super.atj();
        a.f.b.j.p(localObject1, "runtime.pageContainer");
        localObject1 = ((com.tencent.mm.plugin.appbrand.page.s)localObject1).getCurrentPage();
        if (localObject1 == null) {
          break label1501;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.page.o)localObject1).getCurrentPageView();
        if (localObject1 == null) {
          break label1501;
        }
        localObject1 = ((v)localObject1).iuy;
        label801:
        localObject2 = localObject1;
        if (!(localObject1 instanceof com.tencent.mm.plugin.appbrand.page.ad)) {
          localObject2 = null;
        }
        localObject1 = (com.tencent.mm.plugin.appbrand.page.ad)localObject2;
        if (localObject1 == null) {
          break label1533;
        }
        if (!((com.tencent.mm.plugin.appbrand.page.ad)localObject1).isSysKernel()) {
          break label1507;
        }
        i = 4;
        label838:
        localcx.cYC = i;
        localObject1 = localObject3;
        label849:
        com.tencent.mm.plugin.appbrand.report.quality.c.a((QualitySessionRuntime)localObject1, "Null session with " + this.mAppId);
        if (!((com.tencent.mm.plugin.appbrand.page.s)super.atj()).getCurrentPage().getCurrentPageView().aJw()) {
          break label1553;
        }
        if (!((QualitySessionRuntime)localObject4).iIQ) {
          break label1544;
        }
        localcx.daa = 2L;
        label909:
        localcx.ake();
      }
      if (localObject4 != null)
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.aLt();
        a.f.b.j.q(this, "runtime");
        localObject3 = new ci();
        localObject2 = com.tencent.mm.plugin.appbrand.report.quality.a.EM(this.mAppId);
        if (localObject2 == null) {
          break label1599;
        }
        ((ci)localObject3).ho(((QualitySessionRuntime)localObject2).ikX);
        ((ci)localObject3).hp(((QualitySessionRuntime)localObject2).appId);
        ((ci)localObject3).cZB = ((QualitySessionRuntime)localObject2).iIG;
        ((ci)localObject3).dbc = ci.a.gV(((QualitySessionRuntime)localObject2).iIF);
        ((ci)localObject3).cZD = ((QualitySessionRuntime)localObject2).apptype;
        ((ci)localObject3).cRG = ((QualitySessionRuntime)localObject2).scene;
        localObject1 = (com.tencent.mm.plugin.appbrand.service.c)super.ws();
        if (localObject1 == null) {
          break label1562;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.service.c)localObject1).aAO();
        label1043:
        localObject1 = com.tencent.mm.plugin.appbrand.report.c.g((com.tencent.mm.plugin.appbrand.i.i)localObject1);
        switch (com.tencent.mm.plugin.appbrand.report.quality.d.bLo[localObject1.ordinal()])
        {
        default: 
          i = -1;
          label1098:
          ((ci)localObject3).cYC = i;
          localObject1 = localObject2;
          label1109:
          com.tencent.mm.plugin.appbrand.report.quality.c.a((QualitySessionRuntime)localObject1, "Null session with " + this.mAppId);
          if (((com.tencent.mm.plugin.appbrand.service.c)super.ws()).gRF) {
            if (((QualitySessionRuntime)localObject4).iIQ) {
              ((ci)localObject3).daa = 2L;
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      ((ci)localObject3).ake();
      AppMethodBeat.o(129018);
      return;
      localObject1 = "";
      break;
      label1184:
      i = 0;
      break label244;
      label1189:
      i = 0;
      break label259;
      label1194:
      ((StringBuilder)localObject3).append(localObject1.gQO[i]);
      ((StringBuilder)localObject3).append(",");
      i += 1;
      break label305;
      label1223:
      localObject4 = (AppBrandInitConfigWC)super.wS();
      if (localObject4 != null) {
        i = ((AppBrandInitConfigWC)localObject4).bCV;
      }
      for (;;)
      {
        i += 1000;
        ab.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: %s, %s, Download: %s, Preload: %s, appServiceType: %s", new Object[] { localObject2, ((StringBuilder)localObject3).toString(), Boolean.valueOf(bool1), Boolean.valueOf(com.tencent.mm.plugin.appbrand.task.e.aul()), Integer.valueOf(i) });
        ((m)localObject1).f((String)localObject2, 1, 0, i);
        ((m)localObject1).f((String)localObject2, 2, 1, i);
        ((m)localObject1).f((String)localObject2, 3, 2, i);
        ((m)localObject1).f((String)localObject2, 4, 3, i);
        ((m)localObject1).f((String)localObject2, 6, 4, i);
        ((m)localObject1).f((String)localObject2, 7, 5, i);
        ((m)localObject1).f((String)localObject2, 23, 6, i);
        ((m)localObject1).f((String)localObject2, 24, 7, i);
        ((m)localObject1).f((String)localObject2, 25, 8, i);
        ((m)localObject1).f((String)localObject2, 26, 9, i);
        ((m)localObject1).f((String)localObject2, 27, 10, i);
        ((m)localObject1).f((String)localObject2, 28, 11, i);
        ((m)localObject1).f((String)localObject2, 29, 12, i);
        ((m)localObject1).f((String)localObject2, 30, 13, i);
        ((m)localObject1).f((String)localObject2, 31, 14, i);
        break;
        i = com.tencent.mm.plugin.appbrand.report.f.EE((String)localObject2);
        ab.i("MicroMsg.AppBrandRuntimeStartupReporter", "getServiceTypeForReport null = initConfig! appServiceType:%s", new Object[] { Integer.valueOf(i) });
      }
      label1501:
      localObject1 = null;
      break label801;
      label1507:
      if (((com.tencent.mm.plugin.appbrand.page.ad)localObject1).getIsX5Kernel())
      {
        i = 2;
        break label838;
      }
      if (((com.tencent.mm.plugin.appbrand.page.ad)localObject1).isXWalkKernel())
      {
        i = 3;
        break label838;
      }
      label1533:
      i = -1;
      break label838;
      label1538:
      localObject1 = null;
      break label849;
      label1544:
      localcx.daa = 1L;
      break label909;
      label1553:
      localcx.daa = 0L;
      break label909;
      label1562:
      localObject1 = null;
      break label1043;
      i = 1;
      break label1098;
      i = 2;
      break label1098;
      i = 3;
      break label1098;
      i = 4;
      break label1098;
      i = 5;
      break label1098;
      i = 6;
      break label1098;
      label1599:
      localObject1 = null;
      break label1109;
      ((ci)localObject3).daa = 1L;
      continue;
      ((ci)localObject3).daa = 0L;
    }
  }
  
  protected final void onResume()
  {
    AppMethodBeat.i(129020);
    super.onResume();
    com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.i.a(this.mAppId, ato(), wS().bDh);
    a.c(this);
    com.tencent.mm.plugin.appbrand.d.a.u(this);
    Object localObject = this.gRl;
    String str = this.mAppId;
    int i = ((AppBrandInitConfigWC)super.wS()).gXd;
    ((AppBrandRemoteTaskController)localObject).iKw = AppBrandRemoteTaskController.a.iKH;
    ((AppBrandRemoteTaskController)localObject).mAppId = str;
    ((AppBrandRemoteTaskController)localObject).ikk = i;
    AppBrandMainProcessService.a((MainProcessTask)localObject);
    if (this.gPO) {
      ((com.tencent.mm.plugin.appbrand.page.s)super.atj()).getReporter().aHH();
    }
    com.tencent.mm.plugin.appbrand.task.e.EO(this.mAppId);
    localObject = this.mAppId;
    i = wS().bDh.scene;
    AppBrandIDKeyBatchReport.aKS().iFn = 1;
    AppBrandIDKeyBatchReport.aKS().iFp = ((String)localObject);
    AppBrandIDKeyBatchReport.aKS().iFq = i;
    AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.aKS());
    localObject = p.M(new o.17(this));
    keep((com.tencent.mm.vending.e.a)localObject);
    com.tencent.mm.sdk.g.d.ysm.b((Runnable)localObject, "getCopyPathMenuExpireTime");
    AppBrandMainProcessService.a(new AppBrandMainProcessPrepareTask());
    AppMethodBeat.o(129020);
  }
  
  public String toString()
  {
    AppMethodBeat.i(154312);
    Locale localLocale = Locale.ENGLISH;
    String str2 = this.mAppId;
    if ((AppBrandInitConfigWC)super.wS() == null) {}
    for (String str1 = "NULL";; str1 = ((AppBrandInitConfigWC)super.wS()).cqQ)
    {
      str1 = String.format(localLocale, "[AppBrandRuntimeWC::%s::%s::%d::@%d]", new Object[] { str2, str1, Integer.valueOf(this.gPz.gXd), Integer.valueOf(hashCode()) });
      AppMethodBeat.o(154312);
      return str1;
    }
  }
  
  public final boolean vY()
  {
    AppMethodBeat.i(129005);
    boolean bool = ((AppBrandInitConfigWC)super.wS()).vY();
    AppMethodBeat.o(129005);
    return bool;
  }
  
  public com.tencent.mm.plugin.appbrand.permission.e wO()
  {
    return this.gRk;
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.l wU()
  {
    AppMethodBeat.i(129040);
    com.tencent.mm.plugin.appbrand.performance.b.p(this);
    Object localObject = ((AppStartupPerformanceReportBundle)U(AppStartupPerformanceReportBundle.class)).ikZ;
    if (!bo.es((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      for (long l = 0L; ((Iterator)localObject).hasNext(); l = Math.max(l, ((kv_14609)((Iterator)localObject).next()).iHO)) {}
      com.tencent.mm.plugin.appbrand.performance.b.a(this, l);
    }
    if (DebuggerShell.ayQ())
    {
      AppMethodBeat.o(129040);
      return null;
    }
    localObject = super.wU();
    AppMethodBeat.o(129040);
    return localObject;
  }
  
  public final boolean wV()
  {
    AppMethodBeat.i(156892);
    boolean bool = super.wV();
    AppMethodBeat.o(156892);
    return bool;
  }
  
  public com.tencent.mm.plugin.appbrand.k.a wW()
  {
    AppMethodBeat.i(129031);
    com.tencent.mm.plugin.appbrand.k.a locala = super.wW();
    AppMethodBeat.o(129031);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o
 * JD-Core Version:    0.7.0.1
 */