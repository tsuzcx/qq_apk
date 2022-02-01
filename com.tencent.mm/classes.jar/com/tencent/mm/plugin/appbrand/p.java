package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.g.b.a.if;
import com.tencent.mm.g.b.a.if.a;
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.g.b.a.jf.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.a.d.a;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader.a;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.a.e;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.floatball.d.1;
import com.tencent.mm.plugin.appbrand.game.preload.d.2;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.EventLocationBackgroundStateChanged;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.launching.w.a;
import com.tencent.mm.plugin.appbrand.launching.w.a.a;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper.GetCopyPathMenuExpireTimeTask;
import com.tencent.mm.plugin.appbrand.message.WxaAppMsgChannel;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.f.a;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.a;
import com.tencent.mm.plugin.appbrand.task.a.a.1;
import com.tencent.mm.plugin.appbrand.task.k.1;
import com.tencent.mm.plugin.appbrand.task.k.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.w;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.plugin.appbrand.widget.dialog.AppBrandGameEvaluateOptionView;
import com.tencent.mm.plugin.appbrand.widget.dialog.AppBrandGameEvaluateOptionView.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.f.1;
import com.tencent.mm.plugin.appbrand.widget.dialog.f.12;
import com.tencent.mm.plugin.appbrand.widget.dialog.f.15;
import com.tencent.mm.plugin.appbrand.widget.dialog.f.16;
import com.tencent.mm.plugin.appbrand.widget.dialog.f.17;
import com.tencent.mm.plugin.appbrand.widget.dialog.f.18;
import com.tencent.mm.plugin.appbrand.widget.dialog.f.19;
import com.tencent.mm.plugin.appbrand.widget.dialog.f.2;
import com.tencent.mm.plugin.appbrand.widget.dialog.f.20;
import com.tencent.mm.plugin.appbrand.widget.dialog.f.21;
import com.tencent.mm.plugin.appbrand.widget.dialog.f.3;
import com.tencent.mm.protocal.protobuf.eiv;
import com.tencent.mm.protocal.protobuf.ekj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class p
  extends com.tencent.luggage.sdk.d.d
  implements com.tencent.luggage.sdk.g.c.a, com.tencent.mm.plugin.appbrand.launching.q
{
  private final com.tencent.mm.plugin.appbrand.task.d jCA;
  private final Queue<Runnable> jCB;
  private com.tencent.mm.plugin.appbrand.platform.window.f jCC;
  public final boolean jCj;
  public final com.tencent.mm.plugin.appbrand.jsapi.u.a jCk;
  protected AppBrandRemoteTaskController jCl;
  private volatile com.tencent.mm.plugin.appbrand.report.model.n jCm;
  public n jCn;
  public boolean jCo;
  private int jCp;
  private boolean jCq;
  private final List<ah> jCr;
  private com.tencent.mm.sdk.platformtools.aw jCs;
  private volatile l jCt;
  private Configuration jCu;
  private com.tencent.mm.plugin.appbrand.floatball.d jCv;
  public com.tencent.mm.plugin.appbrand.ad.h jCw;
  private com.tencent.luggage.sdk.d.f<AppBrandInitConfigWC> jCx;
  public final com.tencent.mm.plugin.appbrand.page.c jCy;
  private com.tencent.mm.plugin.appbrand.k.b jCz;
  
  public p(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    super(paramAppBrandRuntimeContainerWC);
    AppMethodBeat.i(174681);
    if ((bv.fpT()) || (DebuggerShell.bfe()) || (com.tencent.mm.protocal.d.FFK) || (com.tencent.mm.protocal.d.FFL)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jCj = bool;
      this.jCk = new com.tencent.mm.plugin.appbrand.jsapi.u.a();
      this.jCp = 0;
      this.jCr = new LinkedList();
      this.jCs = null;
      this.jCx = new com.tencent.luggage.sdk.d.e();
      this.jCy = com.tencent.mm.plugin.appbrand.page.c.buz();
      this.jCA = new p.21(this);
      this.jCB = new LinkedBlockingQueue();
      if (getWindowAndroid().aXi()) {
        this.jCx = new com.tencent.mm.plugin.appbrand.ui.d(this, com.tencent.mm.sdk.f.a.jw(this.mContext), getWindowAndroid().getOrientationHandler());
      }
      Assert.assertTrue("AppBrandRuntimeWC's initial context should be AppBrandRuntimePersistentContextWrapper", this.mContext instanceof com.tencent.mm.plugin.appbrand.ui.l);
      this.jCn = new n();
      this.jAe = this.jCj;
      a(paramAppBrandRuntimeContainerWC);
      AppMethodBeat.o(174681);
      return;
    }
  }
  
  public static int aXF()
  {
    AppMethodBeat.i(222035);
    int i = com.tencent.mm.plugin.appbrand.ad.b.aYu();
    AppMethodBeat.o(222035);
    return i;
  }
  
  public static int aXG()
  {
    AppMethodBeat.i(222036);
    int i = com.tencent.mm.plugin.appbrand.ad.b.aYu();
    AppMethodBeat.o(222036);
    return i;
  }
  
  private void aXq()
  {
    AppMethodBeat.i(43896);
    if (!this.jCj)
    {
      AppMethodBeat.o(43896);
      return;
    }
    try
    {
      Object localObject = (AccessibilityManager)android.support.v4.content.b.a(this.mContext, AccessibilityManager.class);
      if (localObject != null)
      {
        boolean bool = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(43896);
        return;
      }
      localObject = this.mAppId + ":" + ((AppBrandInitConfigWC)super.Fg()).dpI;
      this.jzF.setContentDescription((CharSequence)localObject);
      AppMethodBeat.o(43896);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(43896);
    }
  }
  
  private void fA(boolean paramBoolean)
  {
    AppMethodBeat.i(222022);
    if ((this.jCl == null) || (paramBoolean))
    {
      this.jCl = new AppBrandRemoteTaskController();
      AppBrandRuntimeContainerWC localAppBrandRuntimeContainerWC = (AppBrandRuntimeContainerWC)Objects.requireNonNull((AppBrandRuntimeContainerWC)this.jzy);
      this.jCl.a(localAppBrandRuntimeContainerWC.jBk, this.jCA);
    }
    AppMethodBeat.o(222022);
  }
  
  private ICommLibReader fz(boolean paramBoolean)
  {
    AppMethodBeat.i(43890);
    Object localObject = (ICommLibReader)super.ab(ICommLibReader.class);
    if ((localObject == null) && (paramBoolean))
    {
      localObject = new ICommLibReader.a();
      AppMethodBeat.o(43890);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(43890);
    return localObject;
  }
  
  private void rE(int paramInt)
  {
    AppMethodBeat.i(43929);
    n.a(paramInt, (AppBrandInitConfigWC)super.Fg());
    AppMethodBeat.o(43929);
  }
  
  public final boolean Ee()
  {
    AppMethodBeat.i(43892);
    boolean bool = ((AppBrandInitConfigWC)super.Fg()).Ee();
    AppMethodBeat.o(43892);
    return bool;
  }
  
  public final void Fh()
  {
    AppMethodBeat.i(43934);
    super.Fh();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] onInitBeforeComponentsInstalled, appId[%s] mPendingPermissionUpdateTasks.size=%d", new Object[] { this.mAppId, Integer.valueOf(this.jCB.size()) });
    while (!this.jCB.isEmpty()) {
      ((Runnable)this.jCB.remove()).run();
    }
    com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepPrepareRuntime);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup);
    AppMethodBeat.o(43934);
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.q Fi()
  {
    AppMethodBeat.i(43930);
    com.tencent.mm.plugin.appbrand.performance.b.A(this);
    Object localObject = ((AppStartupPerformanceReportBundle)ar(AppStartupPerformanceReportBundle.class)).lKF;
    if (!bu.ht((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      for (long l = 0L; ((Iterator)localObject).hasNext(); l = Math.max(l, ((kv_14609)((Iterator)localObject).next()).myE)) {}
      com.tencent.mm.plugin.appbrand.performance.b.a(this, l);
    }
    if (DebuggerShell.bfe())
    {
      AppMethodBeat.o(43930);
      return null;
    }
    localObject = super.Fi();
    AppMethodBeat.o(43930);
    return localObject;
  }
  
  public final boolean Fj()
  {
    AppMethodBeat.i(224360);
    boolean bool = super.Fj();
    AppMethodBeat.o(224360);
    return bool;
  }
  
  public com.tencent.mm.plugin.appbrand.m.a Fk()
  {
    AppMethodBeat.i(43922);
    com.tencent.mm.plugin.appbrand.m.a locala = super.Fk();
    AppMethodBeat.o(43922);
    return locala;
  }
  
  public final String Fs()
  {
    AppMethodBeat.i(43885);
    String str = "AppBrandRuntimeWC@" + hashCode();
    AppMethodBeat.o(43885);
    return str;
  }
  
  protected final boolean I(Runnable paramRunnable)
  {
    AppMethodBeat.i(222028);
    if ((super.aWN() instanceof com.tencent.mm.plugin.appbrand.ui.v))
    {
      j(paramRunnable, 3000L);
      AppMethodBeat.o(222028);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGr, false))
    {
      boolean bool = getAppConfig().jYT;
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.AppBrandRuntimeWC", "manualHideSplash:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(222028);
      return bool;
    }
    AppMethodBeat.o(222028);
    return false;
  }
  
  public final void M(final Runnable paramRunnable)
  {
    AppMethodBeat.i(222023);
    this.jzQ.a(new com.tencent.mm.plugin.appbrand.a.c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(222013);
        if (com.tencent.mm.plugin.appbrand.a.b.jOd == paramAnonymousb) {
          paramRunnable.run();
        }
        AppMethodBeat.o(222013);
      }
    });
    finish();
    AppMethodBeat.o(222023);
  }
  
  public final void N(Runnable paramRunnable)
  {
    AppMethodBeat.i(43923);
    j(new p.10(this, paramRunnable), 0L);
    AppMethodBeat.o(43923);
  }
  
  public final void O(final Runnable paramRunnable)
  {
    AppMethodBeat.i(43935);
    paramRunnable = new a(paramRunnable);
    this.jCB.add(paramRunnable);
    super.J(paramRunnable);
    AppMethodBeat.o(43935);
  }
  
  public final void a(ai paramai)
  {
    AppMethodBeat.i(43891);
    paramai = (AppBrandRuntimeContainerWC)paramai;
    super.a(paramai);
    if (paramai == null)
    {
      this.jzV = null;
      ((com.tencent.mm.plugin.appbrand.ui.l)this.mContext).setBaseContext(ak.getContext());
      if ((com.tencent.mm.plugin.appbrand.service.c)super.Ey() != null) {
        ((com.tencent.mm.plugin.appbrand.service.c)super.Ey()).a(null);
      }
      if ((com.tencent.mm.plugin.appbrand.page.u)super.aWm() != null) {
        com.tencent.mm.plugin.appbrand.page.v.c((com.tencent.mm.plugin.appbrand.page.u)super.aWm());
      }
      AppMethodBeat.o(43891);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.ui.l)this.mContext).setBaseContext(com.tencent.mm.sdk.f.a.jw(paramai.mContext));
    if ((com.tencent.mm.plugin.appbrand.service.c)super.Ey() != null) {
      ((com.tencent.mm.plugin.appbrand.service.c)super.Ey()).a(getWindowAndroid());
    }
    com.tencent.mm.plugin.appbrand.page.ad localad = aXu();
    if (localad != null) {
      localad.a(getWindowAndroid());
    }
    this.jCu = new Configuration(AppBrandUI.H(paramai.jBk.getActivity()));
    fA(true);
    AppMethodBeat.o(43891);
  }
  
  public final void a(ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(43888);
    if (fz(false) != null)
    {
      paramICommLibReader = new IllegalStateException("Duplicated call!!");
      AppMethodBeat.o(43888);
      throw paramICommLibReader;
    }
    if (paramICommLibReader == null)
    {
      paramICommLibReader = new NullPointerException();
      AppMethodBeat.o(43888);
      throw paramICommLibReader;
    }
    super.b(ICommLibReader.class, paramICommLibReader);
    AppMethodBeat.o(43888);
  }
  
  public final void a(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(43924);
    Object localObject1 = (AppBrandInitConfigWC)super.Fg();
    Object localObject2 = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    if ((localObject1 != paramAppBrandInitConfig) && (((AppBrandInitConfigLU)localObject2).cmE.scene == 1038)) {
      ((AppBrandInitConfigWC)localObject2).kaO = null;
    }
    super.a(paramAppBrandInitConfig);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "load launchMode change need reload , before:%d load:%d", new Object[] { Integer.valueOf(((AppBrandInitConfigWC)localObject1).launchMode), Integer.valueOf(((AppBrandInitConfigWC)super.Fg()).launchMode) });
    if (((AppBrandInitConfigWC)super.Fg()).launchMode != ((AppBrandInitConfigWC)localObject1).launchMode) {
      aWH();
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "updateConfig %s, willRestart[%b], willRelaunch[%b], destroyed[%b], scene[%d]", new Object[] { this.mAppId, Boolean.valueOf(this.jzS), Boolean.valueOf(this.jzT), Boolean.valueOf(isDestroyed()), Integer.valueOf(Fg().cmE.scene) });
    OpenBusinessViewUtil.v(this);
    if ((!this.jzS) && (!isDestroyed()))
    {
      ((QualitySessionRuntime)Objects.requireNonNull(com.tencent.mm.plugin.appbrand.report.quality.a.Ve(this.mAppId))).mAh = false;
      com.tencent.mm.plugin.appbrand.report.quality.f.a(this, true, com.tencent.mm.plugin.appbrand.utils.b.VJ(((AppBrandInitConfigWC)super.Fg()).kaP));
      com.tencent.mm.plugin.t.a.b(this.mAppId, ((AppBrandInitConfigWC)super.Fg()).kaM);
      paramAppBrandInitConfig = this.jCr.iterator();
      while (paramAppBrandInitConfig.hasNext()) {
        ((ah)paramAppBrandInitConfig.next()).c((AppBrandInitConfigWC)super.Fg());
      }
      if ((com.tencent.mm.plugin.appbrand.page.u)super.aWm() != null)
      {
        paramAppBrandInitConfig = (com.tencent.mm.plugin.appbrand.page.u)super.aWm();
        paramAppBrandInitConfig.getReporter().resetSession();
        paramAppBrandInitConfig.mfD = false;
        paramAppBrandInitConfig.mfE = false;
        paramAppBrandInitConfig.mfF = false;
        paramAppBrandInitConfig.mfK = null;
      }
      paramAppBrandInitConfig = (AppBrandInitConfigWC)super.Fg();
      localObject1 = aXw();
      localObject2 = Fg().cmE;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandTaskUsageRecorder", "updateUsage, appId %s, type %d", new Object[] { paramAppBrandInitConfig.appId, Integer.valueOf(paramAppBrandInitConfig.dQv) });
      String str = paramAppBrandInitConfig.Ef();
      AppBrandMainProcessService.a(new AppBrandTaskUsageRecorder.UpdateTask(new AppBrandTaskUsageRecorder.LaunchCheckParams(paramAppBrandInitConfig, (AppBrandStatObject)localObject2, ((AppBrandSysConfigWC)localObject1).kbw.pkgVersion, fz(false).aZM(), str, paramAppBrandInitConfig.kaS)));
    }
    aXq();
    paramAppBrandInitConfig = (AppBrandInitConfigWC)super.Fg();
    if (paramAppBrandInitConfig != null) {
      this.jCx.b(paramAppBrandInitConfig);
    }
    AppMethodBeat.o(43924);
  }
  
  public final void a(AppBrandInitConfig paramAppBrandInitConfig, String paramString)
  {
    AppMethodBeat.i(222024);
    if (paramAppBrandInitConfig == null)
    {
      ((AppBrandInitConfigWC)super.Fg()).resetSession();
      ((AppBrandInitConfigWC)super.Fg()).startTime = bu.fpO();
      ((AppBrandInitConfigWC)super.Fg()).kbb = new AppBrandRuntimeReloadReportBundle(((AppBrandInitConfigWC)super.Fg()).kaS.lIU, paramString);
      ((AppBrandInitConfigWC)super.Fg()).kaS = new QualitySession(com.tencent.mm.plugin.appbrand.utils.b.vQ(((AppBrandInitConfigWC)super.Fg()).uin), (AppBrandInitConfigWC)super.Fg(), Fg().cmE);
      ((AppBrandInitConfigWC)super.Fg()).cms = ((AppBrandInitConfigWC)super.Fg()).kaS.lIU;
    }
    super.ac(ICommLibReader.class);
    super.a(paramAppBrandInitConfig, paramString);
    AppMethodBeat.o(222024);
  }
  
  protected final void aWA()
  {
    AppMethodBeat.i(43908);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] onPostInit appId[%s]", new Object[] { this.mAppId });
    MMToClientEvent.e((com.tencent.mm.plugin.appbrand.service.c)super.Ey());
    MMToClientEvent.PJ("Common_IPC_appid");
    if (((com.tencent.mm.plugin.appbrand.service.c)super.Ey()).aWe().compareTo(fz(false)) != 0)
    {
      localObject = new IllegalStateException(String.format(Locale.ENGLISH, "onPostInit appId[%s] mismatch libReader, self[%s] service[%s]", new Object[] { this.mAppId, fz(false).aZK(), ((com.tencent.mm.plugin.appbrand.service.c)super.Ey()).aWe().aZK() }));
      AppMethodBeat.o(43908);
      throw ((Throwable)localObject);
    }
    super.aWA();
    Object localObject = (AppBrandInitConfigWC)super.Fg();
    this.jCn.F(0, System.currentTimeMillis() - ((AppBrandInitConfigWC)localObject).startTime);
    com.tencent.mm.plugin.appbrand.performance.c.b(this.mAppId, "ActivityCreate", ((AppBrandInitConfigWC)super.Fg()).startTime, System.currentTimeMillis());
    MMToClientEvent.a(this.mAppId, new MMToClientEvent.c()
    {
      public final void ch(Object paramAnonymousObject)
      {
        AppMethodBeat.i(221991);
        if ((paramAnonymousObject instanceof AppBrandAuthorizeUI.AuthStateChangedByUserEvent))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], AuthStateChangedByUserEvent", new Object[] { p.this.mAppId });
          com.tencent.mm.plugin.appbrand.permission.a.a.UD(p.this.mAppId);
          AppBrandBackgroundRunningMonitor.a(p.this, (AppBrandAuthorizeUI.AuthStateChangedByUserEvent)paramAnonymousObject);
        }
        AppMethodBeat.o(221991);
      }
    });
    MMToClientEvent.a("Common_IPC_appid", new MMToClientEvent.c()
    {
      public final void ch(Object paramAnonymousObject)
      {
        AppMethodBeat.i(221992);
        if ((paramAnonymousObject instanceof GetOnLineInfoInfoResult))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], GetOnLineInfoInfoResult", new Object[] { p.this.mAppId });
          o.Le(p.this.mAppId).ioG = ((GetOnLineInfoInfoResult)paramAnonymousObject).ioG;
          o.Le(p.this.mAppId).ioL = ((GetOnLineInfoInfoResult)paramAnonymousObject).ioL;
          o.Le(p.this.mAppId).kRc = ((GetOnLineInfoInfoResult)paramAnonymousObject).kRc;
        }
        AppMethodBeat.o(221992);
      }
    });
    MMToClientEvent.a(this.mAppId, new MMToClientEvent.c()
    {
      public final void ch(Object paramAnonymousObject)
      {
        AppMethodBeat.i(224336);
        if ((paramAnonymousObject instanceof EventLocationBackgroundStateChanged))
        {
          if (!((EventLocationBackgroundStateChanged)paramAnonymousObject).jVr)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "locationBackgroundStateChanged, not listening, appId[%s]", new Object[] { p.this.mAppId });
            p.this.jzQ.jOf.a(d.a.jOH);
          }
          AppMethodBeat.o(224336);
          return;
        }
        if ((paramAnonymousObject instanceof WxaAppMsgChannel))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], WxaAppMsgChannel msg", new Object[] { p.this.mAppId });
          com.tencent.mm.plugin.appbrand.jsapi.k.a locala = new com.tencent.mm.plugin.appbrand.jsapi.k.a();
          com.tencent.mm.plugin.appbrand.service.c localc = p.this.aXz();
          paramAnonymousObject = (WxaAppMsgChannel)paramAnonymousObject;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.onReceiveMsgChannelJsApiEvent", "dispatch msg channel to web ， msgContent:%s", new Object[] { paramAnonymousObject.dEU });
          HashMap localHashMap = new HashMap();
          localHashMap.put("msgId", paramAnonymousObject.msgId);
          localHashMap.put("sendTime", Long.valueOf(paramAnonymousObject.kdZ));
          localHashMap.put("msgType", Integer.valueOf(paramAnonymousObject.msgType));
          localHashMap.put("msgContent", paramAnonymousObject.dEU);
          locala.g(localc);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.onReceiveMsgChannelJsApiEvent", "dispatch wxa msg channel");
          locala.H(localHashMap).bja();
          AppMethodBeat.o(224336);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandVoIP1v1FloatBallEvent))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], AppBrandVoIP1v1FloatBallEvent msg", new Object[] { p.this.mAppId });
          if (((AppBrandVoIP1v1FloatBallEvent)paramAnonymousObject).dzC == 1) {
            com.tencent.mm.plugin.appbrand.jsapi.openvoice.q.bmJ();
          }
        }
        AppMethodBeat.o(224336);
      }
    });
    new f.a(this, (byte)0);
    this.jCn.F(8, System.currentTimeMillis() - ((AppBrandInitConfigWC)super.Fg()).startTime);
    rE(2);
    localObject = this.jzZ;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.appbrand.pip.f)localObject).msN = com.tencent.mm.plugin.appbrand.pip.k.mth;
      ((com.tencent.mm.plugin.appbrand.pip.f)localObject).bxw();
      ((com.tencent.mm.plugin.appbrand.pip.f)localObject).msP = com.tencent.mm.plugin.appbrand.pip.g.mtc;
    }
    ((com.tencent.mm.plugin.appbrand.service.c)super.Ey()).a(getWindowAndroid());
    localObject = aXu();
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.page.ad)localObject).a(getWindowAndroid());
    }
    AppMethodBeat.o(43908);
  }
  
  protected r aWB()
  {
    AppMethodBeat.i(43901);
    Object localObject2;
    Object localObject1;
    if (super.Fj()) {
      if (Ee())
      {
        localObject2 = com.tencent.mm.plugin.appbrand.task.c.d(com.tencent.mm.plugin.appbrand.task.e.hB(true));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (this.jCt != null) {
            localObject1 = this.jCt.aWV();
          }
        }
        if (localObject1 == null) {
          localObject1 = new com.tencent.mm.plugin.appbrand.game.c();
        }
      }
    }
    label136:
    label269:
    label276:
    label305:
    for (;;)
    {
      AppMethodBeat.o(43901);
      return localObject1;
      com.tencent.mm.plugin.appbrand.report.quality.a.Ve(this.mAppId).mAu = com.tencent.mm.plugin.appbrand.report.quality.i.mzN;
      continue;
      localObject1 = new com.tencent.mm.plugin.appbrand.service.c(com.tencent.luggage.sdk.b.a.c.i.cpb);
      continue;
      if (this.jCt != null)
      {
        localObject1 = this.jCt.aWV();
        if (localObject1 != null)
        {
          String str = this.mAppId;
          if (!Ee()) {
            break label262;
          }
          localObject2 = "WAGame";
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "[%s][%s] [applaunch] [preload] createService preloaded, reason=%s", new Object[] { str, localObject2, com.tencent.mm.plugin.appbrand.report.quality.a.Ve(this.mAppId).mAu.name() });
        }
        if (localObject1 != null) {
          break label305;
        }
        localObject2 = this.mAppId;
        if (!Ee()) {
          break label269;
        }
      }
      for (localObject1 = "WAGame";; localObject1 = "WAService")
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "[%s][%s] [applaunch] [preload] createService got no preloaded", new Object[] { localObject2, localObject1 });
        if (((!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.j.DEBUG) && (!DebuggerShell.bfe())) || (!com.tencent.mm.plugin.appbrand.task.a.bzf())) {
          break label276;
        }
        localObject1 = new IllegalStateException("[ForcePreload] enabled, but not preload");
        AppMethodBeat.o(43901);
        throw ((Throwable)localObject1);
        localObject1 = null;
        break;
        localObject2 = "WAService";
        break label136;
      }
      if (Ee()) {
        localObject1 = new com.tencent.mm.plugin.appbrand.game.c();
      } else {
        localObject1 = new com.tencent.mm.plugin.appbrand.service.c();
      }
    }
  }
  
  protected t aWC()
  {
    AppMethodBeat.i(43902);
    try
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.Ve(this.mAppId).mAw = bu.fpO();
      label19:
      if (Ee()) {}
      com.tencent.mm.plugin.appbrand.page.ad localad;
      for (Object localObject1 = new com.tencent.mm.plugin.appbrand.game.f.c(com.tencent.mm.sdk.f.a.jw(this.mContext), this);; localObject1 = new com.tencent.mm.plugin.appbrand.page.u(com.tencent.mm.sdk.f.a.jw(this.mContext), this))
      {
        ((com.tencent.mm.plugin.appbrand.page.u)localObject1).setDecorWidgetFactory(this.jCy);
        if (!Ee()) {
          ((com.tencent.mm.plugin.appbrand.page.u)localObject1).a(com.tencent.mm.plugin.appbrand.page.b.i.mly, new com.tencent.mm.plugin.appbrand.page.b.a());
        }
        ((com.tencent.mm.plugin.appbrand.page.u)localObject1).a(com.tencent.mm.plugin.appbrand.page.b.i.mlx, new com.tencent.mm.plugin.appbrand.page.b.b());
        if (this.jCt == null) {
          break label237;
        }
        localad = this.jCt.aWW();
        if ((localad == null) || (localad == null) || (((com.tencent.mm.plugin.appbrand.page.u)localObject1).getRuntime() == null)) {
          break label237;
        }
        if (localad.aWe().compareTo(((com.tencent.mm.plugin.appbrand.page.u)localObject1).getRuntime().fz(false)) == 0) {
          break;
        }
        localObject1 = new IllegalStateException(String.format(Locale.ENGLISH, "stashPreloadedPageView appId[%s] mismatch libReader, runtime[%s] page[%s]", new Object[] { ((com.tencent.mm.plugin.appbrand.page.u)localObject1).getAppId(), ((com.tencent.mm.plugin.appbrand.page.u)localObject1).getRuntime().fz(false).aZK(), localad.aWe().aZK() }));
        AppMethodBeat.o(43902);
        throw ((Throwable)localObject1);
      }
      synchronized (((com.tencent.mm.plugin.appbrand.page.u)localObject1).mfM)
      {
        ((com.tencent.mm.plugin.appbrand.page.u)localObject1).mfM.addLast(localad);
        label237:
        AppMethodBeat.o(43902);
        return localObject1;
      }
    }
    catch (Throwable localThrowable)
    {
      break label19;
    }
  }
  
  public final boolean aWD()
  {
    AppMethodBeat.i(43904);
    if (Ee())
    {
      AppMethodBeat.o(43904);
      return false;
    }
    if (com.tencent.mm.protocal.d.FFH <= 654314239)
    {
      AppMethodBeat.o(43904);
      return false;
    }
    if ((!com.tencent.mm.protocal.d.FFI) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qBV, false)))
    {
      AppMethodBeat.o(43904);
      return true;
    }
    AppMethodBeat.o(43904);
    return false;
  }
  
  protected final void aWG()
  {
    AppMethodBeat.i(43916);
    MMToClientEvent.e((com.tencent.mm.plugin.appbrand.service.c)super.Ey());
    MMToClientEvent.PJ("Common_IPC_appid");
    this.jCl.a(this.mAppId, ((AppBrandInitConfigWC)super.Fg()).dQv, com.tencent.mm.plugin.appbrand.task.e.h((AppBrandInitConfigWC)super.Fg()));
    AppMethodBeat.o(43916);
  }
  
  public final void aWL()
  {
    AppMethodBeat.i(174684);
    if (com.tencent.mm.plugin.appbrand.ui.o.al(this))
    {
      AppMethodBeat.o(174684);
      return;
    }
    super.aWL();
    AppMethodBeat.o(174684);
  }
  
  public final boolean aWM()
  {
    AppMethodBeat.i(43913);
    if ((!isInBackStack()) && (!a.a(this))) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "[wxa_reload]recycleRuntime %s, recycle[%b]", new Object[] { toString(), Boolean.valueOf(bool) });
      if (bool) {
        finish();
      }
      AppMethodBeat.o(43913);
      return bool;
    }
  }
  
  public final w aWN()
  {
    AppMethodBeat.i(222026);
    w localw = super.aWN();
    AppMethodBeat.o(222026);
    return localw;
  }
  
  public final ICommLibReader aWe()
  {
    AppMethodBeat.i(224356);
    ICommLibReader localICommLibReader = fz(false);
    AppMethodBeat.o(224356);
    return localICommLibReader;
  }
  
  protected final void aWj()
  {
    AppMethodBeat.i(222034);
    Object localObject1 = (AppBrandInitConfigWC)super.Fg();
    if (localObject1 != null) {
      this.jCx.a((AppBrandInitConfigLU)localObject1);
    }
    this.jCw = new com.tencent.mm.plugin.appbrand.ad.h(this);
    localObject1 = this.jCw;
    if (((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFm.aWO())
    {
      ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFn = com.tencent.mm.plugin.appbrand.task.c.c(com.tencent.mm.plugin.appbrand.task.e.hB(((AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFm.Fg()).Ee()));
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, may show ad, preloadedService:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFm.mAppId, ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFn });
      if (((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFn != null)
      {
        Object localObject2;
        if (((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFm.Ee())
        {
          localObject2 = (AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFm.Fg();
          if (localObject2 == null) {
            break label291;
          }
          localObject2 = e.b.UP(((AppBrandInitConfigWC)localObject2).cpm);
          if ((localObject2 != e.b.mtF) && (localObject2 != e.b.mtH) && (localObject2 != e.b.mtI)) {
            break label291;
          }
        }
        label291:
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, landscape game, add check show ad prepare process", new Object[] { ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFm.mAppId });
            ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFr = new com.tencent.mm.plugin.appbrand.ad.i();
            ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFm.a(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFr);
          }
          ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).aYH();
          ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFn.jDb = ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFm;
          ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFn.jCZ = true;
          localObject2 = new com.tencent.mm.plugin.appbrand.ad.a.f();
          ((com.tencent.mm.plugin.appbrand.ad.a.f)localObject2).source = "launch";
          ((com.tencent.mm.plugin.appbrand.ad.a.f)localObject2).a(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFn, null);
          ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFo = 8;
          com.tencent.mm.plugin.appbrand.ad.e.a(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFm, com.tencent.mm.plugin.appbrand.task.c.bzt(), true);
          AppMethodBeat.o(222034);
          return;
        }
      }
      com.tencent.mm.plugin.appbrand.ad.e.a(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFm, com.tencent.mm.plugin.appbrand.task.c.bzt(), false);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).aYH();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, can not show ad", new Object[] { ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFm.mAppId });
      ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFo = 0;
      AppMethodBeat.o(222034);
      return;
      com.tencent.mm.plugin.appbrand.ad.e.a(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).jFm, com.tencent.mm.plugin.appbrand.task.c.bzt(), false);
    }
  }
  
  public final void aWp()
  {
    AppMethodBeat.i(222029);
    com.tencent.mm.plugin.appbrand.config.a locala = getAppConfig();
    Object localObject2 = bg.d(this, "/app-config.json");
    Object localObject1 = localObject2;
    Object localObject3;
    if (bu.isNullOrNil((String)localObject2))
    {
      localObject3 = aXw().kbw.jLY.iterator();
      localObject1 = localObject2;
      if (((Iterator)localObject3).hasNext())
      {
        ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)((Iterator)localObject3).next();
        if (!localModulePkgInfo.independent) {
          break label817;
        }
        localObject2 = new StringBuilder().append(localModulePkgInfo.name);
        if (localModulePkgInfo.name.endsWith("/"))
        {
          localObject1 = "";
          label118:
          localObject2 = bg.d(this, (String)localObject1 + "app-config.json");
          localObject1 = localObject2;
          if (!bu.isNullOrNil((String)localObject2)) {
            break label167;
          }
          localObject1 = localObject2;
        }
      }
    }
    label167:
    label817:
    for (;;)
    {
      break;
      localObject1 = "/";
      break label118;
      localObject3 = bg.d(this, "/app-config-darkmode.json");
      localObject2 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = "{}";
      }
      localObject1 = com.tencent.mm.plugin.appbrand.config.a.a(this.mAppId, (String)localObject1, (String)localObject2, Boolean.parseBoolean(fz(true).LE("pruneWxConfigByPage")), Ee());
      if (!Ee())
      {
        ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jYN.cpm = ((AppBrandInitConfigWC)super.Fg()).cpm;
        ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jYN.jZb = true;
      }
      for (;;)
      {
        if (aq.o(this)) {
          ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jYN.cpm = "portrait";
        }
        b((com.tencent.mm.plugin.appbrand.config.a)localObject1);
        aXA();
        if (Ee())
        {
          localObject1 = com.tencent.mm.plugin.appbrand.game.preload.d.bif();
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).jFm = this;
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kqk = ((com.tencent.mm.plugin.appbrand.o.a)ar(com.tencent.mm.plugin.appbrand.o.a.class));
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kql = Fd();
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kqm = new com.tencent.mm.plugin.appbrand.game.preload.c(this);
          localObject2 = ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kqm;
          localObject3 = this.jzM;
          ((com.tencent.mm.plugin.appbrand.game.preload.c)localObject2).kqh.addAll((Collection)localObject3);
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).hasInit = true;
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kqo = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qza, false);
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kqp = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qCf, false);
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kqj = new com.tencent.mm.plugin.appbrand.o.m(((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kqm, ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kqp);
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kqq = new AtomicInteger(0);
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kqr = new AtomicInteger(0);
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kqs = new AtomicInteger(0);
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kqt = new AtomicInteger(0);
          L(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(160526);
              try
              {
                com.tencent.mm.plugin.appbrand.game.preload.d locald = com.tencent.mm.plugin.appbrand.game.preload.d.bif();
                if (!locald.kqo) {
                  break label373;
                }
                if (!locald.hasInit)
                {
                  com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WAGamePreloadManager", "hasn't init!");
                  AppMethodBeat.o(160526);
                  return;
                }
                if (locald.jFm == null) {
                  break label373;
                }
                if (locald.jFm.getAppConfig() != null) {
                  break label90;
                }
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WAGamePreloadManager", "downloadPreloadFiles getAppConfig null!");
                AppMethodBeat.o(160526);
                return;
              }
              catch (NullPointerException localNullPointerException)
              {
                if (!p.this.isDestroyed()) {
                  break label379;
                }
              }
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.AppBrandRuntimeWC", "runtime has finished - downloadPreloadFiles!");
              AppMethodBeat.o(160526);
              return;
              label90:
              JSONArray localJSONArray = localNullPointerException.jFm.getAppConfig().jYR;
              int i;
              if (localJSONArray != null)
              {
                com.tencent.mm.plugin.appbrand.game.preload.e.bih().dM(3000, localJSONArray.length());
                i = 0;
              }
              for (;;)
              {
                JSONObject localJSONObject;
                Object localObject2;
                Object localObject3;
                try
                {
                  if (i < localJSONArray.length())
                  {
                    localJSONObject = localJSONArray.getJSONObject(i);
                    if (localJSONObject == null) {
                      break label386;
                    }
                    localObject2 = localJSONObject.optString("url");
                    localObject3 = localJSONObject.optString("path");
                    if ((bu.isNullOrNil((String)localObject2)) || (bu.isNullOrNil((String)localObject3))) {
                      break label386;
                    }
                    if (localNullPointerException.kql.Ma((String)localObject3) == com.tencent.mm.plugin.appbrand.appstorage.m.jPM)
                    {
                      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WAGamePreloadManager", "predownload path %s has exists!", new Object[] { localObject3 });
                    }
                    else
                    {
                      localNullPointerException.kqn.add(localObject2);
                      localObject2 = new d.2(localNullPointerException, (String)localObject2, (String)localObject3);
                      if (localNullPointerException.kqk.cmQ <= 0) {
                        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WAGamePreloadManager", "maxDownloadConcurrent <= 0 ");
                      }
                    }
                  }
                }
                catch (JSONException localJSONException)
                {
                  com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.WAGamePreloadManager", localJSONException, "", new Object[0]);
                }
                Object localObject1 = localNullPointerException.jFm.getAppConfig();
                if (localObject1 == null)
                {
                  com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WAGamePreloadManager", "downloadPreloadFiles config null！");
                  AppMethodBeat.o(160526);
                  return;
                  localObject3 = new HashMap();
                  int j = localNullPointerException.kqk.jZJ;
                  localNullPointerException.kqj.a(localJSONObject, 60000, (Map)localObject3, null, j, (com.tencent.mm.plugin.appbrand.o.b.a)localObject2, com.tencent.mm.plugin.appbrand.game.preload.d.aOZ(), "test");
                }
                else
                {
                  localObject1 = ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jYS;
                  if (localObject1 != null) {
                    com.tencent.mm.plugin.appbrand.game.preload.e.bih().dM(4000, ((ArrayList)localObject1).size());
                  }
                  localNullPointerException.big();
                  label373:
                  AppMethodBeat.o(160526);
                  return;
                  label379:
                  AppMethodBeat.o(160526);
                  throw localNullPointerException;
                }
                label386:
                i += 1;
              }
            }
          });
        }
        if ((!bu.isNullOrNil(this.mAppId)) && (getAppConfig() != null)) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandBackgroundConfigStorage", "updateBackgroundConfigs, runtime or appId or appConfig is null");
        if ((locala != null) && ((com.tencent.mm.plugin.appbrand.service.c)super.Ey() != null)) {
          new com.tencent.mm.plugin.appbrand.jsapi.b.a().PQ(((com.tencent.mm.plugin.appbrand.service.c)super.Ey()).EP().toString()).h(Ey()).bja();
        }
        AppMethodBeat.o(222029);
        return;
        if (!((com.tencent.mm.plugin.appbrand.config.a)localObject1).jYP.booleanValue()) {
          ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jYN.cpm = ((AppBrandInitConfigWC)super.Fg()).cmA.kdo;
        }
      }
      localObject1 = this.mAppId;
      localObject2 = getAppConfig();
      boolean bool2 = j.a.oQ(aXw().kbw.jLV);
      boolean bool3 = ((com.tencent.mm.plugin.appbrand.config.a)localObject2).jYQ.contains("location");
      ay.aRW("appbrand_background_config").encode(String.format("%s_location_background_required", new Object[] { localObject1 }), bool3);
      localObject2 = ((com.tencent.mm.plugin.appbrand.config.a)localObject2).NO("scope.userLocation");
      if ((localObject2 != null) && (!bu.isNullOrNil(((a.e)localObject2).desc))) {
        ay.aRW("appbrand_background_config").encode(String.format("%s_permission_location_desc", new Object[] { localObject1 }), ((a.e)localObject2).desc);
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandBackgroundConfigStorage", "updateBackgroundConfigs, appId:%s, isDebug:%s, isLocationBackgroundRequired:%s, hasPermissionLocationDesc:%s", new Object[] { localObject1, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        break;
        ay.aRW("appbrand_background_config").remove(String.format("%s_permission_location_desc", new Object[] { localObject1 }));
      }
    }
  }
  
  protected w aWt()
  {
    AppMethodBeat.i(43928);
    Object localObject;
    if (Ee())
    {
      localObject = com.tencent.mm.plugin.appbrand.game.preload.e.bih();
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qza, false) != true) {
        break label295;
      }
      i = 1;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).kqC = i;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WAGamePreloadStatisManager", "misPreload:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).kqC) });
      AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.Fg();
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).kqx = localAppBrandInitConfigWC.appId;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).kqy = localAppBrandInitConfigWC.aDD;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).kqz = localAppBrandInitConfigWC.dQv;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).kqA = (localAppBrandInitConfigWC.cmt + 1000);
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).kqB = localAppBrandInitConfigWC.kaS.lIU;
      switch (((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).kqz)
      {
      default: 
        label156:
        if (Fg().cmE != null) {
          ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).mScene = Fg().cmE.scene;
        }
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGr, false) != true) {
          break;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).kqE = i;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WAGamePreloadStatisManager", "mHasSplashScreen:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).kqE) });
      localObject = com.tencent.mm.plugin.appbrand.ui.i.a(com.tencent.mm.sdk.f.a.jw(this.mContext), this);
      ((w)localObject).dX(((AppBrandInitConfigWC)super.Fg()).iconUrl, ((AppBrandInitConfigWC)super.Fg()).dpI);
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.ui.z)) {
        ((com.tencent.mm.plugin.appbrand.ui.z)localObject).setCanShowHideAnimation(false);
      }
      AppMethodBeat.o(43928);
      return localObject;
      label295:
      i = 0;
      break;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).kqz = 1;
      break label156;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).kqz = 2;
      break label156;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).kqz = 3;
      break label156;
    }
  }
  
  protected final void aWv()
  {
    AppMethodBeat.i(222027);
    super.aWv();
    com.tencent.mm.plugin.appbrand.report.quality.a.D(this);
    AppMethodBeat.o(222027);
  }
  
  protected final void aWz()
  {
    AppMethodBeat.i(43910);
    super.aWz();
    String str = toString();
    Object localObject = this.jAg;
    if ((localObject != null) && (((Collection)localObject).size() > 0)) {
      localObject = ((Collection)localObject).iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, process[%s]", new Object[] { str, ((AppBrandRuntime.b)((Iterator)localObject).next()).toString() });
      continue;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, no pending processes", new Object[] { str });
    }
    rE(11);
    com.tencent.mm.plugin.appbrand.keylogger.c.c(this.mAppId, KSProcessWeAppLaunch.stepPrepareResourceTimeout);
    AppMethodBeat.o(43910);
  }
  
  public final void aXA()
  {
    AppMethodBeat.i(43931);
    Object localObject = aXw();
    com.tencent.mm.plugin.appbrand.config.m.br(this.mAppId, ((AppBrandSysConfigWC)localObject).cne);
    com.tencent.mm.plugin.appbrand.config.m.bs(this.mAppId, ((AppBrandSysConfigWC)localObject).cnf);
    this.jzM.add(com.tencent.mm.plugin.appbrand.config.e.a(this));
    this.jzM.add(com.tencent.mm.plugin.appbrand.config.e.a((AppBrandSysConfigLU)localObject));
    this.jzM.add(com.tencent.mm.plugin.appbrand.config.e.b((AppBrandSysConfigLU)localObject));
    this.jzM.add(com.tencent.mm.plugin.appbrand.config.e.b(this));
    localObject = com.tencent.mm.plugin.appbrand.config.e.c((AppBrandSysConfigLU)localObject);
    ((com.tencent.mm.plugin.appbrand.performance.a)localObject).mma |= DebuggerShell.bfe();
    boolean bool2 = ((com.tencent.mm.plugin.appbrand.performance.a)localObject).mmb;
    if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (bv.fpT())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject).mmb = (bool1 | bool2);
      this.jzM.add(localObject);
      AppMethodBeat.o(43931);
      return;
    }
  }
  
  public final void aXB()
  {
    AppMethodBeat.i(43933);
    this.jzX = false;
    if (this.jzy != null) {
      this.jzy.C(this);
    }
    finish();
    if ((this.jzy instanceof AppBrandRuntimeContainerWC)) {
      ((AppBrandRuntimeContainerWC)this.jzy).Fa();
    }
    AppMethodBeat.o(43933);
  }
  
  protected void aXC()
  {
    AppMethodBeat.i(174689);
    l locall = this.jCt;
    if (locall != null)
    {
      if (locall.jAP == null)
      {
        locall.aWT();
        AppMethodBeat.o(174689);
        return;
      }
      locall.jAP.a(com.tencent.mm.vending.h.d.LFo, new l.5(locall)).a(com.tencent.mm.vending.h.d.LFo, new l.4(locall));
    }
    AppMethodBeat.o(174689);
  }
  
  public final boolean aXD()
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    com.tencent.mm.plugin.appbrand.ad.h localh;
    if (this.jCw != null)
    {
      localh = this.jCw;
      if (localh.jFr == null) {
        break label44;
      }
    }
    label44:
    for (boolean bool1 = localh.jFr.bWM;; bool1 = false)
    {
      bool2 = bool3;
      if (bool1) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public final int aXE()
  {
    if (this.jCw != null) {
      return this.jCw.jFo;
    }
    return 9;
  }
  
  public final int aXH()
  {
    AppMethodBeat.i(163908);
    if ((AppBrandInitConfigWC)super.Fg() != null)
    {
      int i = ((AppBrandInitConfigWC)super.Fg()).kaV;
      AppMethodBeat.o(163908);
      return i;
    }
    AppMethodBeat.o(163908);
    return -1;
  }
  
  public final String aXk()
  {
    AppMethodBeat.i(222020);
    if ((AppBrandInitConfigWC)super.Fg() == null)
    {
      AppMethodBeat.o(222020);
      return "NULL";
    }
    String str = ((AppBrandInitConfigWC)super.Fg()).dpI;
    AppMethodBeat.o(222020);
    return str;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.c aXl()
  {
    return this.jCy;
  }
  
  public final com.tencent.mm.plugin.appbrand.floatball.c aXm()
  {
    if (this.jCv != null) {
      return this.jCv.kmP;
    }
    return null;
  }
  
  public com.tencent.mm.plugin.appbrand.k.b aXn()
  {
    AppMethodBeat.i(174683);
    if ((this.jCz == null) && (!isDestroyed())) {
      this.jCz = new p.1(this);
    }
    com.tencent.mm.plugin.appbrand.k.b localb = this.jCz;
    AppMethodBeat.o(174683);
    return localb;
  }
  
  public final boolean aXo()
  {
    AppMethodBeat.i(43893);
    boolean bool = ((AppBrandInitConfigWC)super.Fg()).kaJ;
    AppMethodBeat.o(43893);
    return bool;
  }
  
  public final boolean aXp()
  {
    AppMethodBeat.i(43894);
    boolean bool = ((AppBrandInitConfigWC)super.Fg()).kaG;
    AppMethodBeat.o(43894);
    return bool;
  }
  
  public final void aXr()
  {
    AppMethodBeat.i(43898);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "callSuperClose appId:%s", new Object[] { this.mAppId });
    super.close();
    AppMethodBeat.o(43898);
  }
  
  protected final void aXs()
  {
    AppMethodBeat.i(43905);
    b(com.tencent.mm.plugin.appbrand.networking.c.class, com.tencent.mm.plugin.appbrand.networking.h.mbU);
    b(com.tencent.mm.plugin.appbrand.permission.j.class, new com.tencent.mm.plugin.appbrand.permission.m(this));
    b(com.tencent.mm.plugin.appbrand.permission.k.class, com.tencent.mm.plugin.appbrand.permission.o.mnj);
    b(com.tencent.mm.plugin.appbrand.jsapi.media.e.class, com.tencent.mm.plugin.appbrand.jsapi.media.p.kZd);
    ac(com.tencent.mm.plugin.appbrand.networking.d.class);
    b(com.tencent.mm.plugin.appbrand.networking.d.class, new com.tencent.mm.plugin.appbrand.networking.g(this));
    b(com.tencent.mm.plugin.appbrand.jsapi.base.g.class, new aa());
    b(com.tencent.mm.plugin.appbrand.widget.h.class, com.tencent.mm.plugin.appbrand.widget.i.mYn);
    b(com.tencent.mm.plugin.appbrand.jsapi.x.b.class, com.tencent.mm.plugin.appbrand.luggage.b.c.lSC);
    b(com.tencent.luggage.sdk.f.a.class, com.tencent.mm.plugin.appbrand.app.e.jGH);
    b(com.tencent.mm.plugin.appbrand.page.aw.class, new com.tencent.mm.plugin.appbrand.page.ae(this));
    b(com.tencent.mm.plugin.appbrand.jsapi.media.a.a.class, new com.tencent.mm.plugin.appbrand.jsapi.media.a.a()
    {
      public final void a(final Context paramAnonymousContext, final Runnable paramAnonymousRunnable1, final Runnable paramAnonymousRunnable2)
      {
        AppMethodBeat.i(222015);
        if (!ag.Ck())
        {
          p.this.j(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(43876);
              com.tencent.mm.platformtools.p.a(paramAnonymousContext, paramAnonymousRunnable1, paramAnonymousRunnable2);
              AppMethodBeat.o(43876);
            }
          }, 0L);
          AppMethodBeat.o(222015);
          return;
        }
        com.tencent.mm.platformtools.p.a(paramAnonymousContext, paramAnonymousRunnable1, paramAnonymousRunnable2);
        AppMethodBeat.o(222015);
      }
    });
    o.La(this.mAppId);
    AppMethodBeat.o(43905);
  }
  
  protected final void aXt()
  {
    AppMethodBeat.i(43907);
    com.tencent.luggage.sdk.g.c.a("clearDuplicatedInstanceOnAppCreate", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(43881);
        Object localObject = a.KI(p.this.mAppId);
        if ((localObject != null) && (p.this != localObject))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "clearDuplicatedInstanceOnAppCreate duplicated[%d] this[%d]", new Object[] { Integer.valueOf(localObject.hashCode()), Integer.valueOf(hashCode()) });
          ((p)localObject).aXB();
        }
        localObject = p.this.jCl;
        String str = p.this.mAppId;
        ((AppBrandRemoteTaskController)localObject).mCG = AppBrandRemoteTaskController.a.mCZ;
        ((AppBrandRemoteTaskController)localObject).mAppId = str;
        AppBrandMainProcessService.a((MainProcessTask)localObject);
        AppMethodBeat.o(43881);
      }
    });
    AppMethodBeat.o(43907);
  }
  
  public com.tencent.mm.plugin.appbrand.page.ad aXu()
  {
    AppMethodBeat.i(222025);
    if ((com.tencent.mm.plugin.appbrand.page.u)super.aWm() == null)
    {
      AppMethodBeat.o(222025);
      return null;
    }
    if (((com.tencent.mm.plugin.appbrand.page.u)super.aWm()).getCurrentPage() == null)
    {
      AppMethodBeat.o(222025);
      return null;
    }
    com.tencent.mm.plugin.appbrand.page.ad localad = (com.tencent.mm.plugin.appbrand.page.ad)((com.tencent.mm.plugin.appbrand.page.u)super.aWm()).getCurrentPage().getCurrentPageView();
    AppMethodBeat.o(222025);
    return localad;
  }
  
  public final void aXv()
  {
    AppMethodBeat.i(43915);
    this.jCl.Vh(this.mAppId);
    AppMethodBeat.o(43915);
  }
  
  public final AppBrandSysConfigWC aXw()
  {
    AppMethodBeat.i(43918);
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)c(AppBrandSysConfigWC.class, false);
    AppMethodBeat.o(43918);
    return localAppBrandSysConfigWC;
  }
  
  public final AppBrandInitConfigWC aXx()
  {
    AppMethodBeat.i(224357);
    AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.Fg();
    AppMethodBeat.o(224357);
    return localAppBrandInitConfigWC;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.u aXy()
  {
    AppMethodBeat.i(224358);
    com.tencent.mm.plugin.appbrand.page.u localu = (com.tencent.mm.plugin.appbrand.page.u)super.aWm();
    AppMethodBeat.o(224358);
    return localu;
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c aXz()
  {
    AppMethodBeat.i(224359);
    com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)super.Ey();
    AppMethodBeat.o(224359);
    return localc;
  }
  
  public final boolean b(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(43925);
    paramAppBrandInitConfig = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    AppBrandStatObject localAppBrandStatObject = paramAppBrandInitConfig.cmE;
    boolean bool;
    if ((this.jCq) || (localAppBrandStatObject.scene == 1099))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] mShouldRelaunchCausedByFunctionalPageOpen[%b] newScene[%d]", new Object[] { this.mAppId, Boolean.valueOf(this.jCq), Integer.valueOf(localAppBrandStatObject.scene) });
      if (localAppBrandStatObject.scene == 1099) {}
      for (bool = true;; bool = false)
      {
        this.jCq = bool;
        AppMethodBeat.o(43925);
        return true;
      }
    }
    if ((TextUtils.isEmpty(paramAppBrandInitConfig.jFL)) && (ae.n(this)))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] enterPath[%s], old is gameFunctionalPage", new Object[] { this.mAppId, paramAppBrandInitConfig.jFL });
      AppMethodBeat.o(43925);
      return true;
    }
    if (1038 == localAppBrandStatObject.scene)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. appId[%s], reason=1038 back from other MiniProgram", new Object[] { this.mAppId });
      AppMethodBeat.o(43925);
      return false;
    }
    Iterator localIterator = this.jCr.iterator();
    while (localIterator.hasNext())
    {
      Boolean localBoolean = ((ah)localIterator.next()).b(paramAppBrandInitConfig);
      if (localBoolean != null)
      {
        bool = localBoolean.booleanValue();
        AppMethodBeat.o(43925);
        return bool;
      }
    }
    if (!TextUtils.isEmpty(paramAppBrandInitConfig.jFL))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] enterPath[%s]", new Object[] { this.mAppId, paramAppBrandInitConfig.jFL });
      AppMethodBeat.o(43925);
      return true;
    }
    int i = localAppBrandStatObject.scene;
    if (org.apache.commons.b.a.contains(new int[] { 1001, 1003, 1023, 1038, 1056, 1080, 1083, 1089, 1090, 1103, 1104, 1113, 1114, 1117, 1131, 1019, 1112, 1127, 1134 }, i))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. keepNoRelaunch appId[%s] newScene[%d]", new Object[] { this.mAppId, Integer.valueOf(localAppBrandStatObject.scene) });
      AppMethodBeat.o(43925);
      return false;
    }
    if ((1030 == localAppBrandStatObject.scene) && (TextUtils.isEmpty(paramAppBrandInitConfig.jFL)))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. special for monkey test appId[%s]", new Object[] { this.mAppId });
      AppMethodBeat.o(43925);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] fallback logic", new Object[] { this.mAppId });
    AppMethodBeat.o(43925);
    return true;
  }
  
  public final void close()
  {
    AppMethodBeat.i(43897);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "close() appId:%s, stack:%s", new Object[] { this.mAppId, Log.getStackTraceString(new Throwable()) });
    p.12 local12;
    com.tencent.mm.plugin.appbrand.widget.dialog.f localf;
    int j;
    int i;
    for (;;)
    {
      try
      {
        if (h.KU(this.mAppId) == h.d.jzh)
        {
          localObject1 = (com.tencent.mm.plugin.appbrand.game.f.a)((com.tencent.mm.plugin.appbrand.page.u)super.aWm()).getPageView().Q(com.tencent.mm.plugin.appbrand.game.f.a.class);
          if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.game.f.a)localObject1).bhU() != null))
          {
            localObject1 = ((com.tencent.mm.plugin.appbrand.game.f.a)localObject1).bhU();
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: triggerMakeCanvasBitmap");
            if ((((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).kpq != null) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).bhW() != null) && (!bu.isNullOrNil(((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).kpq.Imc)) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).kpq.IlU) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).kps != null)) {
              continue;
            }
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: should not do make canvas bitmap!");
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.AppBrandRuntimeWC", localException, "hy: triggerMakeCanvasBitmap error!", new Object[0]);
        continue;
        local12 = new p.12(this);
        localf = new com.tencent.mm.plugin.appbrand.widget.dialog.f((com.tencent.mm.plugin.appbrand.service.c)super.Ey());
        if (localf.knB != null) {
          break;
        }
      }
      OpenBusinessViewUtil.w(this);
      if ((aXo()) || (ae.n(this)))
      {
        super.close();
        AppMethodBeat.o(43897);
        return;
        if (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).bhX()) {
          ((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).bhW().Du();
        }
      }
      else
      {
        j = 0;
        if ((this != null) && (aXw() != null) && (com.tencent.mm.sdk.f.a.jw(this.mContext) != null)) {
          break label484;
        }
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "invalid close state");
        i = 0;
        label302:
        if (i == 0) {
          break label1353;
        }
        if (j != 0)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: WA dialog first");
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1237L, 2L, 1L, false);
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        local12.run();
      }
      AppMethodBeat.o(43897);
      return;
      Object localObject2 = localf.knB.mvs;
      if ((localObject2 == null) || (((ekj)localObject2).Int == null) || (((ekj)localObject2).Int.size() < 3))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: no config");
        j = 0;
        break;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1237L, 0L, 1L, false);
      long l1 = o.Ld(this.mAppId).lastResumeTime;
      localf.lxQ = ((int)(System.currentTimeMillis() - l1));
      if (localf.lxQ < ((ekj)localObject2).Inv * 1000)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: time limit");
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1237L, 1L, 1L, false);
        j = 0;
        break;
      }
      j = 1;
      break;
      label484:
      localObject2 = aXw();
      if (!((AppBrandSysConfigWC)localObject2).kbA)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "can not show evaluate dialog");
        i = 0;
        break label302;
      }
      l1 = o.Ld(this.mAppId).lastResumeTime;
      long l2 = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "app time lastResumeTime:%s, closeTime:%s, leastTime:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(((AppBrandSysConfigWC)localObject2).kbC) });
      if ((l2 - l1) / 1000L < ((AppBrandSysConfigWC)localObject2).kbC)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "time not enough to show evaluate dialog");
        i = 0;
        break label302;
      }
      Object localObject5 = (AppBrandInitConfigWC)super.Fg();
      localf.userName = ((AppBrandInitConfigWC)localObject5).username;
      if (bu.isNullOrNil(localf.userName))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "username is null, can not show evaluate dialog");
        i = 0;
        break label302;
      }
      Object localObject3 = com.tencent.mm.sdk.f.a.jw(this.mContext);
      Object localObject4 = ((AppBrandInitConfigWC)localObject5).appId;
      Object localObject6 = ((AppBrandInitConfigWC)localObject5).dpI;
      boolean bool = ((AppBrandSysConfigWC)localObject2).kbB;
      localf.dialog = com.tencent.mm.plugin.appbrand.widget.dialog.f.w((Context)localObject3, true);
      localObject5 = (LinearLayout)LayoutInflater.from(localf.dialog.getContext()).inflate(2131492994, null, false);
      localf.dialog.setContentView((View)localObject5);
      Object localObject7 = al.ck(localf.dialog.getContext());
      i = Math.min(((Point)localObject7).x, ((Point)localObject7).y);
      localObject7 = new FrameLayout.LayoutParams(i, -2);
      ((FrameLayout.LayoutParams)localObject7).gravity = 1;
      ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject7);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "createEvaluateDialog, dialog width:%d", new Object[] { Integer.valueOf(i) });
      localf.ngV = ((TextView)localf.dialog.findViewById(2131299532));
      localf.ngW = ((LinearLayout)localf.dialog.findViewById(2131299533));
      localf.ngX = ((LinearLayout)localf.dialog.findViewById(2131299530));
      localObject7 = (TextView)localf.dialog.findViewById(2131299529);
      if (bool)
      {
        ((TextView)localObject7).setVisibility(0);
        ((TextView)localObject7).setOnClickListener(new f.15(localf, (Context)localObject3, (String)localObject4, (String)localObject6));
        label894:
        ((TextView)localf.dialog.findViewById(2131299536)).setOnClickListener(new f.16(localf, (Context)localObject3));
        localf.ngU = ((RatingBar)localf.dialog.findViewById(2131299534));
        localf.ngU.setOnRatingBarChangeListener(new f.17(localf));
        localf.ngP = ((TextView)localf.dialog.findViewById(2131299531));
        if (bu.isNullOrNil((String)localObject6)) {
          break label1213;
        }
        localf.ngP.setVisibility(0);
        localf.ngP.setText(((Context)localObject3).getString(2131755406, new Object[] { localObject6 }));
        label1019:
        ((ImageView)localf.dialog.findViewById(2131299528)).setOnClickListener(new f.18(localf));
        localObject3 = (ViewGroup)((LinearLayout)localObject5).getParent();
        if (localObject3 != null)
        {
          ((ViewGroup)localObject3).setOnClickListener(new f.19(localf));
          ((LinearLayout)localObject5).setOnClickListener(new f.20(localf));
        }
        localf.dialog = localf.dialog;
        localf.dialog.setOnCancelListener(new f.1(localf));
        localf.dialog.setOnDismissListener(new f.12(localf, local12));
        localf.ngM = false;
        ((AppBrandSysConfigWC)localObject2).kbA = false;
        if (this != null) {
          break label1226;
        }
        localObject2 = null;
        label1153:
        localf.appId = ((String)localObject2);
        if (!bu.isNullOrNil(localf.appId)) {
          break label1235;
        }
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "saveEvaluateReport, no app id");
      }
      for (;;)
      {
        localf.eu(1, 1);
        localf.show();
        i = 1;
        break;
        ((TextView)localObject7).setVisibility(8);
        ((TextView)localObject7).setOnClickListener(null);
        break label894;
        label1213:
        localf.ngP.setVisibility(8);
        break label1019;
        label1226:
        localObject2 = this.mAppId;
        break label1153;
        label1235:
        localObject2 = (AppBrandInitConfigWC)super.Fg();
        localf.sessionId = "";
        if (localObject2 != null) {
          localf.sessionId = ((AppBrandInitConfigWC)localObject2).Ef();
        }
        localf.scene = 1000;
        if ((localObject2 != null) && (((AppBrandInitConfigLU)localObject2).cmE != null)) {
          localf.scene = ((AppBrandInitConfigLU)localObject2).cmE.scene;
        }
        localf.dlk = "";
        if (((com.tencent.mm.plugin.appbrand.service.c)super.Ey() != null) && (((com.tencent.mm.plugin.appbrand.service.c)super.Ey()).aXu() != null)) {
          localf.dlk = ((com.tencent.mm.plugin.appbrand.service.c)super.Ey()).aXu().kxv;
        }
      }
      label1353:
      if (j != 0)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "need show game evaluate dialog");
        localObject2 = localf.knB.mvs;
        localf.knB.mvs = null;
        localf.dialog = com.tencent.mm.plugin.appbrand.widget.dialog.f.w(com.tencent.mm.sdk.f.a.jw(this.mContext), false);
        localObject3 = (LinearLayout)LayoutInflater.from(localf.dialog.getContext()).inflate(2131492996, null, false);
        localf.dialog.setContentView((View)localObject3);
        localObject4 = al.ck(localf.dialog.getContext());
        localObject4 = new FrameLayout.LayoutParams(Math.min(((Point)localObject4).x, ((Point)localObject4).y), ((LinearLayout)localObject3).getLayoutParams().height);
        ((FrameLayout.LayoutParams)localObject4).gravity = 1;
        ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        localObject5 = (TextView)((LinearLayout)localObject3).findViewById(2131305902);
        ((TextView)localObject5).setText(((ekj)localObject2).Title);
        localObject6 = (TextView)((LinearLayout)localObject3).findViewById(2131299531);
        ((TextView)localObject6).setText(((ekj)localObject2).Ins);
        localObject4 = (ImageView)((LinearLayout)localObject3).findViewById(2131299528);
        localObject5 = new f.21(localf, (TextView)localObject5, (TextView)localObject6, (ImageView)localObject4, (LinearLayout)localObject3, this, local12, (ekj)localObject2);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(2131303040)).a(0, (ekj)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(2131303041)).a(1, (ekj)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(2131303042)).a(2, (ekj)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        localf.dialog.setOnCancelListener(new f.2(localf, this, (ekj)localObject2, local12));
        ((ImageView)localObject4).setOnClickListener(new f.3(localf, this, (ekj)localObject2, local12));
        localf.dialog = localf.dialog;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1237L, 4L, 1L, false);
        localf.show();
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(43899);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "finish appId[%s] type[%d] hash[%d] stacktrace=%s", new Object[] { this.mAppId, Integer.valueOf(this.jzC.dQv), Integer.valueOf(hashCode()), Log.getStackTraceString(new Throwable()) });
    if ((j.d(this)) || (this.jzy == null))
    {
      j(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(222014);
          p.this.dispatchDestroy();
          AppMethodBeat.o(222014);
        }
      }, 0L);
      AppMethodBeat.o(43899);
      return;
    }
    super.finish();
    if (this.jCv != null) {
      this.jCv.s(this);
    }
    AppMethodBeat.o(43899);
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid()
  {
    AppMethodBeat.i(222037);
    if (this.jzy != null)
    {
      localObject = this.jzy.getWindowAndroid();
      if (localObject != null)
      {
        if ((this.jCx != null) && ((this.jCx instanceof com.tencent.mm.plugin.appbrand.platform.window.g)) && (((com.tencent.mm.plugin.appbrand.platform.window.g)this.jCx).EX()))
        {
          if ((this.jCC == null) || (this.jCC.mtM != localObject) || (this.jCC.mtN != this.jCx)) {
            this.jCC = new com.tencent.mm.plugin.appbrand.platform.window.f((com.tencent.mm.plugin.appbrand.platform.window.c)localObject, (com.tencent.mm.plugin.appbrand.platform.window.g)this.jCx);
          }
          localObject = this.jCC;
          AppMethodBeat.o(222037);
          return localObject;
        }
        AppMethodBeat.o(222037);
        return localObject;
      }
    }
    Object localObject = super.getWindowAndroid();
    AppMethodBeat.o(222037);
    return localObject;
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(43903);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.plugin.appbrand.jsapi.w.h.a(paramConfiguration, this.mAppId);
    this.jCu = new Configuration(paramConfiguration);
    this.jCx.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(43903);
  }
  
  protected void onCreate()
  {
    AppMethodBeat.i(43906);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepPrepareRuntime);
    fA(false);
    aXt();
    com.tencent.mm.plugin.appbrand.report.quality.a.byG();
    Object localObject1 = (AppBrandInitConfigWC)super.Fg();
    Object localObject2;
    boolean bool;
    int i;
    if (localObject1 != null)
    {
      localObject2 = ((AppBrandInitConfigWC)localObject1).kaS;
      if (localObject2 != null) {}
    }
    else
    {
      a.setRuntime(this);
      com.tencent.mm.plugin.appbrand.e.a.P(this);
      aXq();
      bool = WXHardCoderJNI.hcMiniProgramLaunchEnable;
      int j = WXHardCoderJNI.hcMiniProgramLaunchDelay;
      int k = WXHardCoderJNI.hcMiniProgramLaunchCPU;
      int m = WXHardCoderJNI.hcMiniProgramLaunchIO;
      if (!WXHardCoderJNI.hcMiniProgramLaunchThr) {
        break label890;
      }
      i = Process.myTid();
      label95:
      this.jCp = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMiniProgramLaunchTimeout, 801, WXHardCoderJNI.hcMiniProgramLaunchAction, "MicroMsg.AppBrandRuntimeWC");
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "hardcoder miniprogram launch launchStartPerformance [%d]", new Object[] { Integer.valueOf(this.jCp) });
      super.onCreate();
      aXs();
      if (!Ee()) {
        break label895;
      }
      localObject1 = com.tencent.luggage.sdk.d.g.cpX;
      localObject1 = w.a.lLW;
      com.tencent.luggage.sdk.d.g.bz(w.a.a.gY(true));
      label176:
      com.tencent.mm.plugin.appbrand.report.quality.a.C(this);
      localObject1 = com.tencent.mm.plugin.appbrand.report.quality.n.mAZ;
      com.tencent.mm.plugin.appbrand.report.quality.n.ep(this.mAppId, com.tencent.mm.plugin.appbrand.report.quality.a.Ve(this.mAppId).lIU);
      com.tencent.mm.plugin.appbrand.report.quality.f.a(this, false, com.tencent.mm.plugin.appbrand.utils.b.VJ(((AppBrandInitConfigWC)super.Fg()).kaP));
      localObject1 = com.tencent.luggage.game.e.a.DR();
      localObject2 = this.mAppId;
      bool = Ee();
      ((com.tencent.luggage.game.e.a)localObject1).appId = ((String)localObject2);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MBNiReporter", "hy: appId:%s,isGame:%s", new Object[] { localObject2, Boolean.valueOf(bool) });
      if (bool) {
        h.a((String)localObject2, ((com.tencent.luggage.game.e.a)localObject1).clN);
      }
      ((com.tencent.luggage.game.e.a)localObject1).clF = new ArrayList();
      if (!bool) {
        break label915;
      }
      ((com.tencent.luggage.game.e.a)localObject1).clJ = 1004;
      label310:
      com.tencent.mm.plugin.t.a.a(this.mAppId, ((AppBrandInitConfigWC)super.Fg()).kaM);
      a(new AppBrandRuntime.b()
      {
        public final void prepare()
        {
          AppMethodBeat.i(222017);
          com.tencent.mm.plugin.appbrand.keylogger.c.a(p.this.mAppId, KSProcessWeAppLaunch.stepWaitForCommLibConfirm);
          com.tencent.mm.plugin.appbrand.launching.g.a(p.this, new d.g.a.b() {});
          AppMethodBeat.o(222017);
        }
      });
      a(new AppBrandRuntime.b()
      {
        public final void prepare()
        {
          AppMethodBeat.i(222018);
          p.a(p.this, this);
          AppMethodBeat.o(222018);
        }
      });
      a(new b((byte)0));
      localObject1 = new l(this);
      this.jCt = ((l)localObject1);
      a((AppBrandRuntime.b)localObject1);
      this.jCl.a(this.mAppId, ((AppBrandInitConfigWC)super.Fg()).dQv, com.tencent.mm.plugin.appbrand.task.e.h((AppBrandInitConfigWC)super.Fg()));
      com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
      com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.p(this);
      com.tencent.mm.plugin.appbrand.backgroundfetch.i.p(this);
      com.tencent.mm.plugin.appbrand.utils.g.K(this);
      OpenBusinessViewUtil.v(this);
      AppBrandBackgroundRunningMonitor.q(this);
      this.jCm = new com.tencent.mm.plugin.appbrand.report.model.n();
      this.jCm.myt = bu.HQ();
      com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j.a(this.mAppId, aWx(), Fg().cmE);
      if (Fg().cmE.scene != 1099) {
        break label926;
      }
      bool = true;
      label498:
      this.jCq = bool;
      if (aXo()) {
        this.jCr.add(new ad((AppBrandInitConfigWC)super.Fg()));
      }
      this.jzQ.a(new com.tencent.mm.plugin.appbrand.a.c.a()
      {
        public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
        {
          AppMethodBeat.i(222019);
          if (com.tencent.mm.plugin.appbrand.a.b.jOc == paramAnonymousb)
          {
            p.this.jCk.lju.ljv.clear();
            com.tencent.mm.plugin.appbrand.report.quality.j.bZ(paramAnonymousString, 4);
          }
          AppMethodBeat.o(222019);
        }
      });
      if ((!aXo()) && (!aq.o(this))) {
        break label932;
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.AppBrandRuntimeWC", "initFloatBallHelper appId[%s], skip fakeNative", new Object[] { this.mAppId });
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(this.mAppId);
      if (localObject1 != null) {
        ((QualitySession)localObject1).mAg = (bu.fpO() - ((AppBrandInitConfigWC)super.Fg()).startTime);
      }
      if (j.a.rT(this.jzC.dQv))
      {
        localObject1 = this.mAppId;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "invoke appId:%s", new Object[] { localObject1 });
        if (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_BLUE)
        {
          localObject2 = com.tencent.mm.plugin.expt.h.d.ctr().b("clicfg_appbrand_check_demoinfo_default", "1", true, true);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "xSwitch xSwitchStr:%s", new Object[] { localObject2 });
          if (TextUtils.equals((CharSequence)localObject2, "1")) {
            XIPCInvoker.a("com.tencent.mm", new IPCString((String)localObject1), com.tencent.mm.plugin.appbrand.task.a.a.a.class, new a.1((String)localObject1));
          }
        }
      }
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vVN, false))
      {
        localObject1 = this.mAppId;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrand.AppBrandCheckOnlineStatusTask", "invoke appId:%s", new Object[] { localObject1 });
        XIPCInvoker.a("com.tencent.mm", new IPCString(""), k.a.class, new k.1((String)localObject1));
      }
      ay.aRW(this.mAppId + "_wxa_voip").putBoolean("isCameraStart", false);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "reset appId:%s isCameraStart false", new Object[] { this.mAppId });
      AppMethodBeat.o(43906);
      return;
      com.tencent.mm.ac.c.b(null, (d.g.a.a)new com.tencent.mm.plugin.appbrand.report.quality.c.b(a.aVY(), (QualitySession)localObject2, (AppBrandInitConfigWC)localObject1));
      break;
      label890:
      i = 0;
      break label95;
      label895:
      localObject1 = com.tencent.luggage.sdk.d.g.cpX;
      localObject1 = w.a.lLW;
      com.tencent.luggage.sdk.d.g.by(w.a.a.gY(false));
      break label176;
      label915:
      ((com.tencent.luggage.game.e.a)localObject1).clJ = 1000;
      break label310;
      label926:
      bool = false;
      break label498;
      label932:
      if (this.jCv != null)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "initFloatBallHelper, destroy");
        this.jCv.s(this);
      }
      this.jCv = new com.tencent.mm.plugin.appbrand.floatball.d();
      localObject1 = this.jCv;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandFloatBallLogic", "init, runtime:%s", new Object[] { this.mAppId });
      com.tencent.e.h.MqF.f(new d.1((com.tencent.mm.plugin.appbrand.floatball.d)localObject1, this), "FloatBallHelperThread");
    }
  }
  
  public final void onDestroy()
  {
    int j = 1;
    AppMethodBeat.i(43914);
    super.onDestroy();
    MMToClientEvent.f((com.tencent.mm.plugin.appbrand.service.c)super.Ey());
    MMToClientEvent.YS("Common_IPC_appid");
    com.tencent.mm.plugin.appbrand.e.a.Q(this);
    com.tencent.mm.plugin.appbrand.report.quality.a.E(this);
    if (this.jCp != 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.jCp);
      this.jCp = 0;
    }
    if (DebuggerShell.bfe())
    {
      if (this.jCs != null) {
        this.jCs.stopTimer();
      }
      com.tencent.e.h.MqF.aO(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(43870);
          AppBrandPerformanceManager.h(p.this);
          AppMethodBeat.o(43870);
        }
      });
      com.tencent.mm.plugin.appbrand.performance.b.Uu(this.mAppId);
    }
    if (Ee()) {
      com.tencent.mm.plugin.appbrand.game.preload.d.t(this);
    }
    ??? = AppBrandMusicClientService.lVt;
    ((AppBrandMusicClientService)???).lVs.clear();
    ((AppBrandMusicClientService)???).lVu = "";
    o.remove(this.mAppId);
    com.tencent.mm.plugin.appbrand.media.record.c.onDestroy();
    aXv();
    this.jCl = null;
    ??? = this.jCy.mdn;
    Object localObject2 = ((com.tencent.mm.plugin.appbrand.page.c.b)???).dz.values();
    d.g.b.p.g(localObject2, "mMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)((Iterator)localObject2).next()).clear();
    }
    ((com.tencent.mm.plugin.appbrand.page.c.b)???).dz.clear();
    a.b(this);
    ??? = this.jCm;
    int i;
    if (??? != null)
    {
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).sessionId = ((AppBrandInitConfigWC)super.Fg()).Ef();
      localObject2 = o.Ld(this.mAppId);
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).mxS = com.tencent.mm.plugin.appbrand.report.h.getNetworkType(ak.getContext());
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).appId = this.mAppId;
      if (aXw() != null) {
        break label539;
      }
      i = ((AppBrandInitConfigWC)super.Fg()).aDD;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).aDD = i;
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).dli = (this.jzC.dQv + 1);
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).scene = Fg().cmE.scene;
      if (((com.tencent.mm.plugin.appbrand.report.model.n)???).myu)
      {
        i = 1;
        label334:
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).myv = i;
        if (!((o)localObject2).jBV.get()) {
          break label558;
        }
        i = j;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).myw = i;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).myx = bu.aO(((com.tencent.mm.plugin.appbrand.report.model.n)???).myt);
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).myy = bu.fpO();
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).username = ((AppBrandInitConfigWC)super.Fg()).username;
        localObject2 = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(this.mAppId);
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).myz = ((QualitySessionRuntime)localObject2).apptype;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).lIU = ((QualitySessionRuntime)localObject2).lIU;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).report();
        com.tencent.mm.plugin.appbrand.ui.recommend.e.H(this);
        this.jCm = null;
        this.jCo = false;
        this.jCt = null;
        if (this.jCw != null)
        {
          ??? = this.jCw;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "onDestroy");
          ((com.tencent.mm.plugin.appbrand.ad.h)???).Lu("onDestroy");
          ((com.tencent.mm.plugin.appbrand.ad.h)???).jFr = null;
          this.jCw = null;
        }
        this.jCB.clear();
        this.jCr.clear();
        ??? = this.jCk;
        ((com.tencent.mm.plugin.appbrand.jsapi.u.a)???).lju.ljv.clear();
      }
      synchronized (((com.tencent.mm.plugin.appbrand.jsapi.u.a)???).ljt)
      {
        ((SparseArray)???).clear();
        localObject2 = d.z.Nhr;
        com.tencent.mm.plugin.appbrand.jsapi.ad.b.c.release();
        AppMethodBeat.o(43914);
        return;
        label539:
        i = aXw().kbw.pkgVersion;
        continue;
        i = 0;
        break label334;
        label558:
        i = 0;
      }
    }
  }
  
  public final void onEnterAnimationComplete()
  {
    AppMethodBeat.i(174690);
    if ((isDestroyed()) || (this.SB))
    {
      AppMethodBeat.o(174690);
      return;
    }
    Object localObject = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(this.mAppId);
    if (localObject != null) {
      ((QualitySessionRuntime)localObject).mAn = bu.fpO();
    }
    localObject = super.aWN();
    if ((localObject instanceof com.tencent.mm.plugin.appbrand.ui.z)) {
      ((com.tencent.mm.plugin.appbrand.ui.z)localObject).setCanShowHideAnimation(true);
    }
    AppMethodBeat.o(174690);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(43912);
    super.onPause();
    Object localObject = this.jCl;
    ((AppBrandRemoteTaskController)localObject).mCG = AppBrandRemoteTaskController.a.mDc;
    AppBrandMainProcessService.a((MainProcessTask)localObject);
    if (this.jCv != null)
    {
      localObject = this.jCv;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandFloatBallLogic", "pause, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmP != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmP.bhk();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmQ != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmQ.bhk();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmR != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmR.bhk();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmT != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmT.bhk();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmS != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmS.bhk();
      }
    }
    aXn().aXI();
    AppMethodBeat.o(43912);
  }
  
  public void onReady()
  {
    AppMethodBeat.i(43909);
    super.onReady();
    o.Le(this.mAppId).lastResumeTime = System.currentTimeMillis();
    if (this.jCp != 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.jCp);
      this.jCp = 0;
    }
    long l1 = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.Fg()).startTime;
    com.tencent.mm.plugin.appbrand.report.h.a(l1, this.jCo, Ee());
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "onReady reportStartupTime: appId:%s, nickname:%s, cost:%dms, download:%b, isGame:%b", new Object[] { this.mAppId, ((AppBrandInitConfigWC)super.Fg()).dpI, Long.valueOf(l1), Boolean.valueOf(this.jCo), Boolean.valueOf(Ee()) });
    l1 = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.Fg()).startTime;
    this.jCn.F(5, l1);
    Object localObject1 = this.jCn;
    boolean bool1 = this.jCo;
    boolean bool2 = ((AppBrandInitConfigWC)super.Fg()).cmD;
    boolean bool3 = ((AppStartupPerformanceReportBundle)ar(AppStartupPerformanceReportBundle.class)).lKO;
    Object localObject2 = this.mAppId;
    ((n)localObject1).cR = 0;
    ((n)localObject1).mType = 0;
    if (aXw() != null)
    {
      ((n)localObject1).cR = aXw().kbw.pkgVersion;
      ((n)localObject1).mType = (aXw().kbw.jLV + 1);
    }
    int i;
    label275:
    Object localObject3;
    label321:
    Object localObject4;
    if (bool1)
    {
      i = 1;
      ((n)localObject1).jBM = i;
      if (!Ee()) {
        break label1105;
      }
      i = 1;
      ((n)localObject1).jBQ = i;
      ((n)localObject1).mScene = Fg().cmE.scene;
      ((n)localObject1).jBO = bool2;
      ((n)localObject1).jBP = bool3;
      localObject3 = new StringBuilder();
      i = 0;
      if (i >= ((n)localObject1).jBL.length) {
        break label1139;
      }
      if (localObject1.jBL[i] >= 0L) {
        break label1110;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: abort, illegal value: %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(localObject1.jBL[i]) });
      AppBrandPerformanceManager.a(this, 202, l1);
      com.tencent.mm.plugin.appbrand.performance.c.tj(((AppBrandInitConfigWC)super.Fg()).startTime);
      com.tencent.mm.plugin.appbrand.report.quality.a.a(this.mAppId, this);
      if ((DebuggerShell.bfe()) && (this.jCs == null))
      {
        this.jCs = new com.tencent.mm.sdk.platformtools.aw("AppBrandRuntimeWC.mDumpTracerTimer", new aw.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(224352);
            com.tencent.mm.plugin.appbrand.performance.b.h(p.this);
            AppMethodBeat.o(224352);
            return true;
          }
        }, true);
        this.jCs.ay(1000L, 1000L);
      }
      if (Ee())
      {
        localObject1 = com.tencent.mm.plugin.appbrand.game.preload.d.bif();
        l1 = bu.fpO();
        long l2 = ((AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).jFm.Fg()).startTime;
        com.tencent.mm.plugin.appbrand.game.preload.e.bih().dM(2001, (int)(l1 - l2));
      }
      com.tencent.mm.plugin.appbrand.ui.recommend.e.I(this);
      this.jCl.hA(false);
      if (Fd() != null)
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.appstorage.o)Fd().av(com.tencent.mm.plugin.appbrand.appstorage.o.class);
        com.tencent.mm.vfs.o.f(((com.tencent.mm.plugin.appbrand.appstorage.o)localObject1).jPJ + "/dir.lock", new byte[1], 1);
      }
      localObject4 = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(this.mAppId);
      if ((localObject4 != null) && (!Ee()))
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.byG();
        d.g.b.p.h(this, "runtime");
        jf localjf = new jf();
        localObject3 = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(this.mAppId);
        if (localObject3 == null) {
          break label1461;
        }
        localjf.esa = localjf.t("InstanceId", ((QualitySessionRuntime)localObject3).lIU, true);
        localjf.euy = localjf.t("AppId", ((QualitySessionRuntime)localObject3).appId, true);
        localjf.etb = ((QualitySessionRuntime)localObject3).mAf;
        localjf.eBx = jf.a.jL(((QualitySessionRuntime)localObject3).myD);
        localjf.euA = ((QualitySessionRuntime)localObject3).apptype;
        localjf.dWt = ((QualitySessionRuntime)localObject3).scene;
        localObject1 = (com.tencent.mm.plugin.appbrand.page.u)super.aWm();
        d.g.b.p.g(localObject1, "runtime.pageContainer");
        localObject1 = ((com.tencent.mm.plugin.appbrand.page.u)localObject1).getCurrentPage();
        if (localObject1 == null) {
          break label1455;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.page.q)localObject1).getCurrentPageView();
        label741:
        localObject2 = localObject1;
        if (!(localObject1 instanceof com.tencent.mm.plugin.appbrand.page.ad)) {
          localObject2 = null;
        }
        localjf.ebQ = com.tencent.mm.plugin.appbrand.report.quality.c.z((com.tencent.mm.plugin.appbrand.page.ad)localObject2);
        localObject1 = localObject3;
        label773:
        com.tencent.mm.plugin.appbrand.report.quality.c.a((QualitySessionRuntime)localObject1, "Null session with " + this.mAppId);
        localjf.evp = ((QualitySessionRuntime)localObject4).byN();
        localjf.aLH();
      }
      if (localObject4 != null)
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.byG();
        d.g.b.p.h(this, "runtime");
        localObject3 = new if();
        localObject2 = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(this.mAppId);
        if (localObject2 == null) {
          break label1504;
        }
        ((if)localObject3).esa = ((if)localObject3).t("InstanceId", ((QualitySessionRuntime)localObject2).lIU, true);
        ((if)localObject3).euy = ((if)localObject3).t("AppId", ((QualitySessionRuntime)localObject2).appId, true);
        ((if)localObject3).etb = ((QualitySessionRuntime)localObject2).mAf;
        ((if)localObject3).ews = if.a.jk(((QualitySessionRuntime)localObject2).myD);
        ((if)localObject3).euA = ((QualitySessionRuntime)localObject2).apptype;
        ((if)localObject3).dWt = ((QualitySessionRuntime)localObject2).scene;
        localObject1 = (com.tencent.mm.plugin.appbrand.service.c)super.Ey();
        if (localObject1 == null) {
          break label1467;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.service.c)localObject1).aYB();
        label958:
        localObject1 = com.tencent.mm.plugin.appbrand.report.d.d((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject1);
        switch (com.tencent.mm.plugin.appbrand.report.quality.d.cqt[localObject1.ordinal()])
        {
        default: 
          i = -1;
          label1014:
          ((if)localObject3).ebQ = i;
        }
      }
    }
    label1105:
    label1110:
    label1504:
    for (localObject1 = localObject2;; localObject1 = null)
    {
      com.tencent.mm.plugin.appbrand.report.quality.c.a((QualitySessionRuntime)localObject1, "Null session with " + this.mAppId);
      ((if)localObject3).evp = ((QualitySessionRuntime)localObject4).byN();
      ((if)localObject3).aLH();
      com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup);
      com.tencent.mm.plugin.appbrand.keylogger.c.b(KSProcessWeAppLaunch.class, this.mAppId);
      com.tencent.mm.plugin.appbrand.report.quality.j.bZ(this.mAppId, 1);
      AppMethodBeat.o(43909);
      return;
      i = 0;
      break;
      i = 0;
      break label275;
      ((StringBuilder)localObject3).append(localObject1.jBL[i]);
      ((StringBuilder)localObject3).append(",");
      i += 1;
      break label321;
      label1139:
      localObject4 = (AppBrandInitConfigWC)super.Fg();
      if (localObject4 != null) {
        i = ((AppBrandInitConfigWC)localObject4).cmt;
      }
      for (;;)
      {
        i += 1000;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: %s, %s, Download: %s, Preload: %s, appServiceType: %s", new Object[] { localObject2, ((StringBuilder)localObject3).toString(), Boolean.valueOf(bool1), Boolean.valueOf(com.tencent.mm.plugin.appbrand.task.c.aYd()), Integer.valueOf(i) });
        ((n)localObject1).g((String)localObject2, 1, 0, i);
        ((n)localObject1).g((String)localObject2, 2, 1, i);
        ((n)localObject1).g((String)localObject2, 3, 2, i);
        ((n)localObject1).g((String)localObject2, 4, 3, i);
        ((n)localObject1).g((String)localObject2, 6, 4, i);
        ((n)localObject1).g((String)localObject2, 7, 5, i);
        ((n)localObject1).g((String)localObject2, 23, 6, i);
        ((n)localObject1).g((String)localObject2, 24, 7, i);
        ((n)localObject1).g((String)localObject2, 25, 8, i);
        ((n)localObject1).g((String)localObject2, 26, 9, i);
        ((n)localObject1).g((String)localObject2, 27, 10, i);
        ((n)localObject1).g((String)localObject2, 28, 11, i);
        ((n)localObject1).g((String)localObject2, 29, 12, i);
        ((n)localObject1).g((String)localObject2, 30, 13, i);
        ((n)localObject1).g((String)localObject2, 31, 14, i);
        x.a(4, localObject1.jBL[5], ((n)localObject1).jBN, (String)localObject2, ((n)localObject1).jBM, ((n)localObject1).jBQ, fz(false).aZM());
        break;
        i = com.tencent.mm.plugin.appbrand.report.i.UU((String)localObject2);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeStartupReporter", "getServiceTypeForReport null = initConfig! appServiceType:%s", new Object[] { Integer.valueOf(i) });
      }
      localObject1 = null;
      break label741;
      localObject1 = null;
      break label773;
      localObject1 = null;
      break label958;
      i = 1;
      break label1014;
      i = 2;
      break label1014;
      i = 3;
      break label1014;
      i = 4;
      break label1014;
      i = 5;
      break label1014;
      i = 6;
      break label1014;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(43911);
    super.onResume();
    o.Le(this.mAppId).lastResumeTime = System.currentTimeMillis();
    if (this.jCv != null)
    {
      localObject = this.jCv;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandFloatBallLogic", "resume, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmP != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmP.bhj();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmQ != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmQ.bhj();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmR != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmR.bhj();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmT != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmT.bhj();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmS != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kmS.bhj();
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j.a(this.mAppId, aWx(), Fg().cmE);
    a.setRuntime(this);
    com.tencent.mm.plugin.appbrand.e.a.P(this);
    this.jCl.ca(this.mAppId, ((AppBrandInitConfigWC)super.Fg()).dQv);
    if (this.jzT) {
      ((com.tencent.mm.plugin.appbrand.page.u)super.aWm()).getReporter().bsZ();
    }
    Object localObject = this.mAppId;
    int i = Fg().cmE.scene;
    AppBrandIDKeyBatchReport.bxU().mvy = 1;
    AppBrandIDKeyBatchReport.bxU().mvA = ((String)localObject);
    AppBrandIDKeyBatchReport.bxU().mvB = i;
    AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.bxU());
    localObject = com.tencent.mm.plugin.appbrand.utils.u.a(this, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174666);
        AppBrandSysConfigWC localAppBrandSysConfigWC = p.this.aXw();
        WxaMenuHelper.GetCopyPathMenuExpireTimeTask localGetCopyPathMenuExpireTimeTask = new WxaMenuHelper.GetCopyPathMenuExpireTimeTask(p.this.mAppId);
        AppBrandMainProcessService.b(localGetCopyPathMenuExpireTimeTask);
        localAppBrandSysConfigWC.cng = WxaMenuHelper.GetCopyPathMenuExpireTimeTask.a(localGetCopyPathMenuExpireTimeTask);
        AppMethodBeat.o(174666);
      }
    });
    keep((com.tencent.mm.vending.e.a)localObject);
    com.tencent.e.h.MqF.f((Runnable)localObject, "getCopyPathMenuExpireTime");
    com.tencent.mm.plugin.appbrand.ipc.b.connect();
    if (aXu() != null)
    {
      aXn().Lf(aXu().kxv);
      AppMethodBeat.o(43911);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.AppBrandRuntimeWC", "onResume, try upsertHandOff but get NULL PageView, appId:%s", new Object[] { this.mAppId });
    AppMethodBeat.o(43911);
  }
  
  public final void rF(int paramInt)
  {
    AppMethodBeat.i(43932);
    w localw = super.aWN();
    if ((localw instanceof com.tencent.mm.plugin.appbrand.launching.q)) {
      ((com.tencent.mm.plugin.appbrand.launching.q)localw).rF(paramInt);
    }
    AppMethodBeat.o(43932);
  }
  
  public String toString()
  {
    AppMethodBeat.i(43886);
    String str = String.format(Locale.ENGLISH, "[AppBrandRuntimeWC::%s::%s::%d::@%d]", new Object[] { this.mAppId, aXk(), Integer.valueOf(this.jzC.dQv), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(43886);
    return str;
  }
  
  final class a
    implements Runnable
  {
    private final AtomicBoolean jCO;
    
    a()
    {
      AppMethodBeat.i(43871);
      this.jCO = new AtomicBoolean(false);
      AppMethodBeat.o(43871);
    }
    
    public final void run()
    {
      AppMethodBeat.i(43872);
      if (!this.jCO.getAndSet(true))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] addPendingPermissionUpdateTask run()");
        paramRunnable.run();
      }
      AppMethodBeat.o(43872);
    }
  }
  
  final class b
    extends AppBrandRuntime.b
  {
    volatile AppBrandPrepareTask jCU;
    volatile boolean jCV = false;
    
    private b() {}
    
    public final void interrupt()
    {
      AppMethodBeat.i(43884);
      this.jCV = true;
      AppBrandPrepareTask localAppBrandPrepareTask = this.jCU;
      if (localAppBrandPrepareTask != null) {
        localAppBrandPrepareTask.interrupt();
      }
      AppMethodBeat.o(43884);
    }
    
    public final void prepare()
    {
      AppMethodBeat.i(43883);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| ResourcePrepareProcess.prepare() appId:%s", new Object[] { p.this.mAppId });
      com.tencent.mm.plugin.appbrand.launching.g.a(p.this, new d.g.a.b()
      {
        private d.z aXM()
        {
          AppMethodBeat.i(162153);
          if (!p.b.this.jCV) {}
          try
          {
            p.b.this.jCU = p.b(p.this, p.b.this);
            d.z localz = d.z.Nhr;
            AppMethodBeat.o(162153);
            return localz;
          }
          catch (NullPointerException localNullPointerException)
          {
            while (p.this.isDestroyed()) {}
            AppMethodBeat.o(162153);
            throw localNullPointerException;
          }
        }
      });
      AppMethodBeat.o(43883);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p
 * JD-Core Version:    0.7.0.1
 */