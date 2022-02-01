package com.tencent.mm.plugin.appbrand;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.HandlerThread;
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
import com.tencent.mm.g.b.a.id;
import com.tencent.mm.g.b.a.id.a;
import com.tencent.mm.g.b.a.jd;
import com.tencent.mm.g.b.a.jd.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.appbrand.a.d.a;
import com.tencent.mm.plugin.appbrand.ad.g.2;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader.a;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.config.a.e;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.floatball.d.1;
import com.tencent.mm.plugin.appbrand.game.preload.d.2;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.EventLocationBackgroundStateChanged;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.launching.w.a;
import com.tencent.mm.plugin.appbrand.launching.w.a.a;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.message.WxaAppMsgChannel;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.d.b;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.r.a.e.a;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.f.a;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.c.b;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.plugin.appbrand.utils.s;
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
import com.tencent.mm.protocal.protobuf.ehe;
import com.tencent.mm.protocal.protobuf.eis;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import d.z;
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

public class o
  extends com.tencent.luggage.sdk.d.c
  implements com.tencent.luggage.sdk.g.c.a, com.tencent.mm.plugin.appbrand.launching.q
{
  public final boolean jzi;
  public final com.tencent.mm.plugin.appbrand.jsapi.u.a jzj;
  protected AppBrandRemoteTaskController jzk;
  private volatile com.tencent.mm.plugin.appbrand.report.model.n jzl;
  public m jzm;
  public boolean jzn;
  private int jzo;
  private boolean jzp;
  private final List<ah> jzq;
  private av jzr;
  private volatile k jzs;
  private Configuration jzt;
  private com.tencent.mm.plugin.appbrand.floatball.d jzu;
  public com.tencent.mm.plugin.appbrand.ad.g jzv;
  public final com.tencent.mm.plugin.appbrand.page.d jzw;
  private com.tencent.mm.plugin.appbrand.k.b jzx;
  private final com.tencent.mm.plugin.appbrand.task.d jzy;
  private final Queue<Runnable> jzz;
  
  public o(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    super(paramAppBrandRuntimeContainerWC);
    AppMethodBeat.i(174681);
    if ((bu.flY()) || (DebuggerShell.bew()) || (com.tencent.mm.protocal.d.Fnm) || (com.tencent.mm.protocal.d.Fnn)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jzi = bool;
      this.jzj = new com.tencent.mm.plugin.appbrand.jsapi.u.a();
      this.jzo = 0;
      this.jzq = new LinkedList();
      this.jzr = null;
      this.jzw = com.tencent.mm.plugin.appbrand.page.d.btO();
      this.jzy = new com.tencent.mm.plugin.appbrand.task.d()
      {
        private boolean aF(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(187900);
          if (o.this.jzk == null)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeController checkTokenOk with reason[%s], get NULL mRemoteController from runtime", new Object[] { paramAnonymousString });
            AppMethodBeat.o(187900);
            return true;
          }
          if (paramAnonymousInt == o.this.jzk.hashCode())
          {
            AppMethodBeat.o(187900);
            return true;
          }
          AppMethodBeat.o(187900);
          return false;
        }
        
        public final void onNetworkChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(187902);
          if (aF("onNetworkChange", paramAnonymousInt))
          {
            com.tencent.mm.plugin.appbrand.networking.c localc = (com.tencent.mm.plugin.appbrand.networking.c)o.this.ab(com.tencent.mm.plugin.appbrand.networking.c.class);
            if ((localc instanceof com.tencent.mm.plugin.appbrand.networking.f)) {
              ((com.tencent.mm.plugin.appbrand.networking.f)localc).btw();
            }
          }
          AppMethodBeat.o(187902);
        }
        
        public final void rE(int paramAnonymousInt)
        {
          AppMethodBeat.i(187901);
          if (aF("finish", paramAnonymousInt)) {
            o.this.finish();
          }
          AppMethodBeat.o(187901);
        }
      };
      this.jzz = new LinkedBlockingQueue();
      Assert.assertTrue("AppBrandRuntimeWC's initial context should be AppBrandRuntimePersistentContextWrapper", this.mContext instanceof com.tencent.mm.plugin.appbrand.ui.k);
      this.jzm = new m();
      this.jxf = this.jzi;
      a(paramAppBrandRuntimeContainerWC);
      AppMethodBeat.o(174681);
      return;
    }
  }
  
  private void aWV()
  {
    AppMethodBeat.i(43896);
    if (!this.jzi)
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
      localObject = this.mAppId + ":" + ((AppBrandInitConfigWC)super.Fb()).doD;
      this.jwJ.setContentDescription((CharSequence)localObject);
      AppMethodBeat.o(43896);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(43896);
    }
  }
  
  public static int aXk()
  {
    AppMethodBeat.i(221274);
    int i = com.tencent.mm.plugin.appbrand.ad.a.aYa();
    AppMethodBeat.o(221274);
    return i;
  }
  
  public static int aXl()
  {
    AppMethodBeat.i(187927);
    int i = com.tencent.mm.plugin.appbrand.ad.a.aYa();
    AppMethodBeat.o(187927);
    return i;
  }
  
  private ICommLibReader fB(boolean paramBoolean)
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
  
  private void fC(boolean paramBoolean)
  {
    AppMethodBeat.i(187912);
    if ((this.jzk == null) || (paramBoolean))
    {
      this.jzk = new AppBrandRemoteTaskController();
      AppBrandRuntimeContainerWC localAppBrandRuntimeContainerWC = (AppBrandRuntimeContainerWC)Objects.requireNonNull((AppBrandRuntimeContainerWC)this.jwC);
      this.jzk.a(localAppBrandRuntimeContainerWC.jyj, this.jzy);
    }
    AppMethodBeat.o(187912);
  }
  
  private void rB(int paramInt)
  {
    AppMethodBeat.i(43929);
    m.a(paramInt, (AppBrandInitConfigWC)super.Fb());
    AppMethodBeat.o(43929);
  }
  
  public final boolean Eb()
  {
    AppMethodBeat.i(43892);
    boolean bool = ((AppBrandInitConfigWC)super.Fb()).Eb();
    AppMethodBeat.o(43892);
    return bool;
  }
  
  public final void Fc()
  {
    AppMethodBeat.i(43934);
    super.Fc();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] onInitBeforeComponentsInstalled, appId[%s] mPendingPermissionUpdateTasks.size=%d", new Object[] { this.mAppId, Integer.valueOf(this.jzz.size()) });
    while (!this.jzz.isEmpty()) {
      ((Runnable)this.jzz.remove()).run();
    }
    com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepPrepareRuntime);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup);
    AppMethodBeat.o(43934);
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.p Fd()
  {
    AppMethodBeat.i(43930);
    com.tencent.mm.plugin.appbrand.performance.b.z(this);
    Object localObject = ((AppStartupPerformanceReportBundle)ar(AppStartupPerformanceReportBundle.class)).lGf;
    if (!bt.hj((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      for (long l = 0L; ((Iterator)localObject).hasNext(); l = Math.max(l, ((kv_14609)((Iterator)localObject).next()).mtH)) {}
      com.tencent.mm.plugin.appbrand.performance.b.a(this, l);
    }
    if (DebuggerShell.bew())
    {
      AppMethodBeat.o(43930);
      return null;
    }
    localObject = super.Fd();
    AppMethodBeat.o(43930);
    return localObject;
  }
  
  public final boolean Fe()
  {
    AppMethodBeat.i(221273);
    boolean bool = super.Fe();
    AppMethodBeat.o(221273);
    return bool;
  }
  
  public com.tencent.mm.plugin.appbrand.m.a Ff()
  {
    AppMethodBeat.i(43922);
    com.tencent.mm.plugin.appbrand.m.a locala = super.Ff();
    AppMethodBeat.o(43922);
    return locala;
  }
  
  public final String Fn()
  {
    AppMethodBeat.i(43885);
    String str = "AppBrandRuntimeWC@" + hashCode();
    AppMethodBeat.o(43885);
    return str;
  }
  
  protected final boolean K(Runnable paramRunnable)
  {
    AppMethodBeat.i(187919);
    if ((super.aWm() instanceof com.tencent.mm.plugin.appbrand.ui.u))
    {
      j(paramRunnable, 3000L);
      AppMethodBeat.o(187919);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzl, false))
    {
      boolean bool = getAppConfig().jVC;
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandRuntimeWC", "manualHideSplash:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(187919);
      return bool;
    }
    AppMethodBeat.o(187919);
    return false;
  }
  
  public final void Kx(String paramString)
  {
    AppMethodBeat.i(187913);
    Object localObject2 = getAppConfig();
    com.tencent.mm.plugin.appbrand.r.a.c localc = getWindowAndroid();
    boolean bool1;
    if ((localc != null) && (localc.aWM()))
    {
      bool1 = ((AppBrandInitConfigWC)super.Fb()).cmy.jVD;
      if (localObject2 == null) {
        break label260;
      }
      boolean bool2 = getAppConfig().jVD;
      if (bool1 == bool2) {
        break label260;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandRuntimeWC", "setResizableToWindow: redundancy field check fail, please call complexzeng to fix, fromAttr = [%b], fromAppJson = [%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool2) });
      bool1 = bool2;
    }
    label260:
    for (;;)
    {
      Object localObject1 = "portrait";
      if (localObject2 != null)
      {
        localObject2 = getAppConfig().bdJ().jWk;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = getAppConfig().jVw.jVL;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!((String)localObject2).isEmpty()) {}
          }
          else
          {
            localObject1 = "portrait";
          }
        }
      }
      if ((aWT()) || (Eb())) {
        localc.fA(true);
      }
      for (;;)
      {
        localc.setSoftOrientation((String)localObject1);
        localc.setResizeable(bool1);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "setResizableToWindow: stage[%s] resizable = [%b], appId = [%s]", new Object[] { paramString, Boolean.valueOf(bool1), this.mAppId });
        AppMethodBeat.o(187913);
        return;
        localc.fA(false);
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandRuntimeWC", "setResizableToWindow: window should not be null");
      AppMethodBeat.o(187913);
      return;
    }
  }
  
  public final void O(Runnable paramRunnable)
  {
    AppMethodBeat.i(187914);
    this.jwS.a(new o.14(this, paramRunnable));
    finish();
    AppMethodBeat.o(187914);
  }
  
  public final void P(final Runnable paramRunnable)
  {
    AppMethodBeat.i(43923);
    j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(162152);
        if (o.this.isDestroyed())
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "startPrepareOrientation, finished appId[%s]", new Object[] { o.this.mAppId });
          AppMethodBeat.o(162152);
          return;
        }
        o.a(o.this, new e.a()
        {
          public final void a(e.b paramAnonymous2b, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(187897);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "startPrepareOrientation, onOrientationChanged appId[%s], orientation[%s] success[%b]", new Object[] { o.this.mAppId, paramAnonymous2b, Boolean.valueOf(paramAnonymous2Boolean) });
            if (o.9.this.jzJ != null) {
              o.9.this.jzJ.run();
            }
            AppMethodBeat.o(187897);
          }
        }, o.l(o.this));
        AppMethodBeat.o(162152);
      }
    }, 0L);
    AppMethodBeat.o(43923);
  }
  
  public final void Q(Runnable paramRunnable)
  {
    AppMethodBeat.i(43935);
    paramRunnable = new o.a(this, paramRunnable);
    this.jzz.add(paramRunnable);
    super.L(paramRunnable);
    AppMethodBeat.o(43935);
  }
  
  public final void a(ai paramai)
  {
    AppMethodBeat.i(43891);
    paramai = (AppBrandRuntimeContainerWC)paramai;
    super.a(paramai);
    if (paramai == null)
    {
      this.jwX = null;
      ((com.tencent.mm.plugin.appbrand.ui.k)this.mContext).setBaseContext(aj.getContext());
      if ((com.tencent.mm.plugin.appbrand.service.c)super.Ew() != null) {
        ((com.tencent.mm.plugin.appbrand.service.c)super.Ew()).a(null);
      }
      if ((com.tencent.mm.plugin.appbrand.page.v)super.aVN() != null) {
        w.c((com.tencent.mm.plugin.appbrand.page.v)super.aVN());
      }
      AppMethodBeat.o(43891);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.ui.k)this.mContext).setBaseContext(com.tencent.mm.sdk.f.a.jq(paramai.mContext));
    if ((com.tencent.mm.plugin.appbrand.service.c)super.Ew() != null) {
      ((com.tencent.mm.plugin.appbrand.service.c)super.Ew()).a(paramai);
    }
    com.tencent.mm.plugin.appbrand.page.ae localae = aWZ();
    if (localae != null) {
      localae.a(paramai);
    }
    this.jzt = new Configuration(AppBrandUI.G(paramai.jyj.getActivity()));
    fC(true);
    AppMethodBeat.o(43891);
  }
  
  public final void a(ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(43888);
    if (fB(false) != null)
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
    Object localObject1 = (AppBrandInitConfigWC)super.Fb();
    Object localObject2 = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    if ((localObject1 != paramAppBrandInitConfig) && (((AppBrandInitConfigLU)localObject2).cmC.scene == 1038)) {
      ((AppBrandInitConfigWC)localObject2).jXz = null;
    }
    super.a(paramAppBrandInitConfig);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "load launchMode change need reload , before:%d load:%d", new Object[] { Integer.valueOf(((AppBrandInitConfigWC)localObject1).launchMode), Integer.valueOf(((AppBrandInitConfigWC)super.Fb()).launchMode) });
    if (((AppBrandInitConfigWC)super.Fb()).launchMode != ((AppBrandInitConfigWC)localObject1).launchMode) {
      aWg();
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "updateConfig %s, willRestart[%b], willRelaunch[%b], destroyed[%b], scene[%d]", new Object[] { this.mAppId, Boolean.valueOf(this.jwU), Boolean.valueOf(this.jwV), Boolean.valueOf(isDestroyed()), Integer.valueOf(Fb().cmC.scene) });
    OpenBusinessViewUtil.u(this);
    if ((!this.jwU) && (!isDestroyed()))
    {
      com.tencent.mm.plugin.appbrand.report.quality.f.a(this, true, com.tencent.mm.plugin.appbrand.utils.a.UY(((AppBrandInitConfigWC)super.Fb()).jXA));
      com.tencent.mm.plugin.t.a.b(this.mAppId, ((AppBrandInitConfigWC)super.Fb()).jXx);
      paramAppBrandInitConfig = this.jzq.iterator();
      while (paramAppBrandInitConfig.hasNext()) {
        ((ah)paramAppBrandInitConfig.next()).c((AppBrandInitConfigWC)super.Fb());
      }
      if ((com.tencent.mm.plugin.appbrand.page.v)super.aVN() != null)
      {
        paramAppBrandInitConfig = (com.tencent.mm.plugin.appbrand.page.v)super.aVN();
        paramAppBrandInitConfig.getReporter().resetSession();
        paramAppBrandInitConfig.mbk = false;
        paramAppBrandInitConfig.mbl = false;
        paramAppBrandInitConfig.mbm = false;
        paramAppBrandInitConfig.mbr = null;
      }
      paramAppBrandInitConfig = (AppBrandInitConfigWC)super.Fb();
      localObject1 = aXb();
      localObject2 = Fb().cmC;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandTaskUsageRecorder", "updateUsage, appId %s, type %d", new Object[] { paramAppBrandInitConfig.appId, Integer.valueOf(paramAppBrandInitConfig.dPf) });
      String str = paramAppBrandInitConfig.Ec();
      AppBrandMainProcessService.a(new AppBrandTaskUsageRecorder.UpdateTask(new AppBrandTaskUsageRecorder.LaunchCheckParams(paramAppBrandInitConfig, (AppBrandStatObject)localObject2, ((AppBrandSysConfigWC)localObject1).jYh.pkgVersion, fB(false).aZp(), str, paramAppBrandInitConfig.jXD)));
    }
    aWV();
    AppMethodBeat.o(43924);
  }
  
  public final void a(AppBrandInitConfig paramAppBrandInitConfig, String paramString)
  {
    AppMethodBeat.i(187915);
    if (paramAppBrandInitConfig == null)
    {
      ((AppBrandInitConfigWC)super.Fb()).resetSession();
      ((AppBrandInitConfigWC)super.Fb()).startTime = bt.flT();
      ((AppBrandInitConfigWC)super.Fb()).jXM = new AppBrandRuntimeReloadReportBundle(((AppBrandInitConfigWC)super.Fb()).jXD.lEv, paramString);
      ((AppBrandInitConfigWC)super.Fb()).jXD = new QualitySession(com.tencent.mm.plugin.appbrand.utils.a.vL(((AppBrandInitConfigWC)super.Fb()).uin), (AppBrandInitConfigWC)super.Fb(), Fb().cmC);
      ((AppBrandInitConfigWC)super.Fb()).cmq = ((AppBrandInitConfigWC)super.Fb()).jXD.lEv;
    }
    super.ac(ICommLibReader.class);
    super.a(paramAppBrandInitConfig, paramString);
    AppMethodBeat.o(187915);
  }
  
  public final ICommLibReader aVF()
  {
    AppMethodBeat.i(221269);
    ICommLibReader localICommLibReader = fB(false);
    AppMethodBeat.o(221269);
    return localICommLibReader;
  }
  
  protected final void aVK()
  {
    AppMethodBeat.i(187925);
    this.jzv = new com.tencent.mm.plugin.appbrand.ad.g(this);
    com.tencent.mm.plugin.appbrand.ad.g localg = this.jzv;
    if (localg.jCo.aWn())
    {
      localg.jCp = com.tencent.mm.plugin.appbrand.task.c.c(com.tencent.mm.plugin.appbrand.task.e.hA(((AppBrandInitConfigWC)localg.jCo.Fb()).Eb()));
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, may show ad, preloadedService:%s", new Object[] { localg.jCo.mAppId, localg.jCp });
      if (localg.jCp != null)
      {
        Object localObject;
        if (localg.jCo.Eb())
        {
          localObject = (AppBrandInitConfigWC)localg.jCo.Fb();
          if (localObject == null) {
            break label390;
          }
          localObject = e.b.Uf(((AppBrandInitConfigWC)localObject).jVL);
          if ((localObject != e.b.moI) && (localObject != e.b.moK) && (localObject != e.b.moL)) {
            break label390;
          }
        }
        label390:
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, landscape game, add check show ad prepare process", new Object[] { localg.jCo.mAppId });
            localg.jCt = new com.tencent.mm.plugin.appbrand.ad.h();
            localg.jCo.a(localg.jCt);
          }
          localg.jCu = bt.flT();
          localg.jCs = new HandlerThread("checkShowAdThread");
          localg.jCs.start();
          localg.jCr = new av(localg.jCs.getLooper(), new g.2(localg), false);
          i = com.tencent.mm.plugin.appbrand.ad.a.aYa();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "checkShowAdTimer start, timeThreshold:%s", new Object[] { Integer.valueOf(i) });
          localg.jCv = false;
          localObject = localg.jCr;
          long l = i;
          ((av)localObject).az(l, l);
          localg.jCp.jzY = localg.jCo;
          localg.jCp.jzW = true;
          localObject = new com.tencent.mm.plugin.appbrand.ad.a.f();
          ((com.tencent.mm.plugin.appbrand.ad.a.f)localObject).source = "launch";
          ((com.tencent.mm.plugin.appbrand.ad.a.f)localObject).a(localg.jCp, null);
          localg.jCq = 8;
          AppMethodBeat.o(187925);
          return;
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, can not show ad", new Object[] { localg.jCo.mAppId });
    localg.jCq = 0;
    AppMethodBeat.o(187925);
  }
  
  public final void aVP()
  {
    AppMethodBeat.i(187920);
    com.tencent.mm.plugin.appbrand.config.a locala = getAppConfig();
    Object localObject2 = bf.d(this, "/app-config.json");
    Object localObject1 = localObject2;
    Object localObject3;
    if (bt.isNullOrNil((String)localObject2))
    {
      localObject3 = aXb().jYh.jIX.iterator();
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
          localObject2 = bf.d(this, (String)localObject1 + "app-config.json");
          localObject1 = localObject2;
          if (!bt.isNullOrNil((String)localObject2)) {
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
      localObject3 = bf.d(this, "/app-config-darkmode.json");
      localObject2 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = "{}";
      }
      localObject1 = com.tencent.mm.plugin.appbrand.config.a.a(this.mAppId, (String)localObject1, (String)localObject2, Boolean.parseBoolean(fB(true).Le("pruneWxConfigByPage")), Eb());
      if (!Eb())
      {
        ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jVw.jVL = ((AppBrandInitConfigWC)super.Fb()).jVL;
        ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jVw.jVM = true;
      }
      for (;;)
      {
        if (ap.n(this)) {
          ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jVw.jVL = "portrait";
        }
        a((com.tencent.mm.plugin.appbrand.config.a)localObject1);
        aXf();
        if (Eb())
        {
          localObject1 = com.tencent.mm.plugin.appbrand.game.preload.d.bhx();
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).jCo = this;
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kmU = ((com.tencent.mm.plugin.appbrand.o.a)ar(com.tencent.mm.plugin.appbrand.o.a.class));
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kmV = EY();
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kmW = new com.tencent.mm.plugin.appbrand.game.preload.c(this);
          localObject2 = ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kmW;
          localObject3 = this.jwO;
          ((com.tencent.mm.plugin.appbrand.game.preload.c)localObject2).kmR.addAll((Collection)localObject3);
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).hasInit = true;
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kmY = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qsl, false);
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kmZ = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qvh, false);
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kmT = new com.tencent.mm.plugin.appbrand.o.m(((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kmW, ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kmZ);
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kna = new AtomicInteger(0);
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).knb = new AtomicInteger(0);
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).knc = new AtomicInteger(0);
          ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).knd = new AtomicInteger(0);
          N(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(160525);
              try
              {
                com.tencent.mm.plugin.appbrand.game.preload.d locald = com.tencent.mm.plugin.appbrand.game.preload.d.bhx();
                if (!locald.kmY) {
                  break label373;
                }
                if (!locald.hasInit)
                {
                  com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WAGamePreloadManager", "hasn't init!");
                  AppMethodBeat.o(160525);
                  return;
                }
                if (locald.jCo == null) {
                  break label373;
                }
                if (locald.jCo.getAppConfig() != null) {
                  break label90;
                }
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WAGamePreloadManager", "downloadPreloadFiles getAppConfig null!");
                AppMethodBeat.o(160525);
                return;
              }
              catch (NullPointerException localNullPointerException)
              {
                if (!o.this.isDestroyed()) {
                  break label379;
                }
              }
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandRuntimeWC", "runtime has finished - downloadPreloadFiles!");
              AppMethodBeat.o(160525);
              return;
              label90:
              JSONArray localJSONArray = localNullPointerException.jCo.getAppConfig().jVA;
              int i;
              if (localJSONArray != null)
              {
                com.tencent.mm.plugin.appbrand.game.preload.e.bhz().dM(3000, localJSONArray.length());
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
                    if ((bt.isNullOrNil((String)localObject2)) || (bt.isNullOrNil((String)localObject3))) {
                      break label386;
                    }
                    if (localNullPointerException.kmV.Lx((String)localObject3) == l.jMv)
                    {
                      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WAGamePreloadManager", "predownload path %s has exists!", new Object[] { localObject3 });
                    }
                    else
                    {
                      localNullPointerException.kmX.add(localObject2);
                      localObject2 = new d.2(localNullPointerException, (String)localObject2, (String)localObject3);
                      if (localNullPointerException.kmU.cmO <= 0) {
                        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WAGamePreloadManager", "maxDownloadConcurrent <= 0 ");
                      }
                    }
                  }
                }
                catch (JSONException localJSONException)
                {
                  com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WAGamePreloadManager", localJSONException, "", new Object[0]);
                }
                Object localObject1 = localNullPointerException.jCo.getAppConfig();
                if (localObject1 == null)
                {
                  com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WAGamePreloadManager", "downloadPreloadFiles config null！");
                  AppMethodBeat.o(160525);
                  return;
                  localObject3 = new HashMap();
                  int j = localNullPointerException.kmU.jWu;
                  localNullPointerException.kmT.a(localJSONObject, 60000, (Map)localObject3, null, j, (com.tencent.mm.plugin.appbrand.o.b.a)localObject2, com.tencent.mm.plugin.appbrand.game.preload.d.aOC(), "test");
                }
                else
                {
                  localObject1 = ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jVB;
                  if (localObject1 != null) {
                    com.tencent.mm.plugin.appbrand.game.preload.e.bhz().dM(4000, ((ArrayList)localObject1).size());
                  }
                  localNullPointerException.bhy();
                  label373:
                  AppMethodBeat.o(160525);
                  return;
                  label379:
                  AppMethodBeat.o(160525);
                  throw localNullPointerException;
                }
                label386:
                i += 1;
              }
            }
          });
        }
        if ((!bt.isNullOrNil(this.mAppId)) && (getAppConfig() != null)) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandBackgroundConfigStorage", "updateBackgroundConfigs, runtime or appId or appConfig is null");
        if ((locala != null) && ((com.tencent.mm.plugin.appbrand.service.c)super.Ew() != null)) {
          new com.tencent.mm.plugin.appbrand.jsapi.b.a().Pi(((com.tencent.mm.plugin.appbrand.service.c)super.Ew()).EN().toString()).h(Ew()).bir();
        }
        AppMethodBeat.o(187920);
        return;
        if (!((com.tencent.mm.plugin.appbrand.config.a)localObject1).jVy.booleanValue()) {
          ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jVw.jVL = ((AppBrandInitConfigWC)super.Fb()).cmy.jZX;
        }
      }
      localObject1 = this.mAppId;
      localObject2 = getAppConfig();
      boolean bool2 = j.a.oN(aXb().jYh.jIU);
      boolean bool3 = ((com.tencent.mm.plugin.appbrand.config.a)localObject2).jVz.contains("location");
      com.tencent.mm.sdk.platformtools.ax.aQz("appbrand_background_config").encode(String.format("%s_location_background_required", new Object[] { localObject1 }), bool3);
      localObject2 = ((com.tencent.mm.plugin.appbrand.config.a)localObject2).Nh("scope.userLocation");
      if ((localObject2 != null) && (!bt.isNullOrNil(((a.e)localObject2).desc))) {
        com.tencent.mm.sdk.platformtools.ax.aQz("appbrand_background_config").encode(String.format("%s_permission_location_desc", new Object[] { localObject1 }), ((a.e)localObject2).desc);
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandBackgroundConfigStorage", "updateBackgroundConfigs, appId:%s, isDebug:%s, isLocationBackgroundRequired:%s, hasPermissionLocationDesc:%s", new Object[] { localObject1, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        break;
        com.tencent.mm.sdk.platformtools.ax.aQz("appbrand_background_config").remove(String.format("%s_permission_location_desc", new Object[] { localObject1 }));
      }
    }
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.v aVS()
  {
    AppMethodBeat.i(43928);
    Object localObject;
    if (Eb())
    {
      localObject = com.tencent.mm.plugin.appbrand.game.preload.e.bhz();
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qsl, false) != true) {
        break label295;
      }
      i = 1;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).knm = i;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WAGamePreloadStatisManager", "misPreload:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).knm) });
      AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.Fb();
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).knh = localAppBrandInitConfigWC.appId;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).kni = localAppBrandInitConfigWC.aDD;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).knj = localAppBrandInitConfigWC.dPf;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).knk = (localAppBrandInitConfigWC.cmr + 1000);
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).knl = localAppBrandInitConfigWC.jXD.lEv;
      switch (((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).knj)
      {
      default: 
        label156:
        if (Fb().cmC != null) {
          ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).mScene = Fb().cmC.scene;
        }
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzl, false) != true) {
          break;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).kno = i;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WAGamePreloadStatisManager", "mHasSplashScreen:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).kno) });
      localObject = com.tencent.mm.plugin.appbrand.ui.h.a(com.tencent.mm.sdk.f.a.jq(this.mContext), this);
      ((com.tencent.mm.plugin.appbrand.ui.v)localObject).dV(((AppBrandInitConfigWC)super.Fb()).iconUrl, ((AppBrandInitConfigWC)super.Fb()).doD);
      if ((localObject instanceof y)) {
        ((y)localObject).setCanShowHideAnimation(false);
      }
      AppMethodBeat.o(43928);
      return localObject;
      label295:
      i = 0;
      break;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).knj = 1;
      break label156;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).knj = 2;
      break label156;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).knj = 3;
      break label156;
    }
  }
  
  protected final void aVU()
  {
    AppMethodBeat.i(187918);
    super.aVU();
    com.tencent.mm.plugin.appbrand.report.quality.a.C(this);
    AppMethodBeat.o(187918);
  }
  
  protected final void aVY()
  {
    AppMethodBeat.i(43910);
    super.aVY();
    String str = toString();
    Object localObject = this.jxh;
    if ((localObject != null) && (((Collection)localObject).size() > 0)) {
      localObject = ((Collection)localObject).iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, process[%s]", new Object[] { str, ((AppBrandRuntime.b)((Iterator)localObject).next()).toString() });
      continue;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, no pending processes", new Object[] { str });
    }
    rB(11);
    com.tencent.mm.plugin.appbrand.keylogger.c.c(this.mAppId, KSProcessWeAppLaunch.stepPrepareResourceTimeout);
    AppMethodBeat.o(43910);
  }
  
  protected final void aVZ()
  {
    AppMethodBeat.i(43908);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] onPostInit appId[%s]", new Object[] { this.mAppId });
    MMToClientEvent.e((com.tencent.mm.plugin.appbrand.service.c)super.Ew());
    if (((com.tencent.mm.plugin.appbrand.service.c)super.Ew()).aVF().compareTo(fB(false)) != 0)
    {
      localObject = new IllegalStateException(String.format(Locale.ENGLISH, "onPostInit appId[%s] mismatch libReader, self[%s] service[%s]", new Object[] { this.mAppId, fB(false).aZn(), ((com.tencent.mm.plugin.appbrand.service.c)super.Ew()).aVF().aZn() }));
      AppMethodBeat.o(43908);
      throw ((Throwable)localObject);
    }
    super.aVZ();
    Object localObject = (AppBrandInitConfigWC)super.Fb();
    this.jzm.G(0, System.currentTimeMillis() - ((AppBrandInitConfigWC)localObject).startTime);
    com.tencent.mm.plugin.appbrand.performance.c.b(this.mAppId, "ActivityCreate", ((AppBrandInitConfigWC)super.Fb()).startTime, System.currentTimeMillis());
    MMToClientEvent.a(this.mAppId, new MMToClientEvent.c()
    {
      public final void ch(Object paramAnonymousObject)
      {
        AppMethodBeat.i(187882);
        if ((paramAnonymousObject instanceof AppBrandAuthorizeUI.AuthStateChangedByUserEvent))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], AuthStateChangedByUserEvent", new Object[] { o.this.mAppId });
          com.tencent.mm.plugin.appbrand.permission.a.a.TT(o.this.mAppId);
          AppBrandBackgroundRunningMonitor.a(o.this, (AppBrandAuthorizeUI.AuthStateChangedByUserEvent)paramAnonymousObject);
        }
        AppMethodBeat.o(187882);
      }
    });
    MMToClientEvent.a(this.mAppId, new MMToClientEvent.c()
    {
      public final void ch(Object paramAnonymousObject)
      {
        AppMethodBeat.i(187883);
        if ((paramAnonymousObject instanceof EventLocationBackgroundStateChanged))
        {
          if (!((EventLocationBackgroundStateChanged)paramAnonymousObject).jSa)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "locationBackgroundStateChanged, not listening, appId[%s]", new Object[] { o.this.mAppId });
            o.this.jwS.jKT.a(d.a.jLv);
          }
          AppMethodBeat.o(187883);
          return;
        }
        if ((paramAnonymousObject instanceof WxaAppMsgChannel))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], WxaAppMsgChannel msg", new Object[] { o.this.mAppId });
          com.tencent.mm.plugin.appbrand.jsapi.k.a locala = new com.tencent.mm.plugin.appbrand.jsapi.k.a();
          com.tencent.mm.plugin.appbrand.service.c localc = o.this.aXe();
          paramAnonymousObject = (WxaAppMsgChannel)paramAnonymousObject;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.onReceiveMsgChannelJsApiEvent", "dispatch msg channel to web ， msgContent:%s", new Object[] { paramAnonymousObject.dDP });
          HashMap localHashMap = new HashMap();
          localHashMap.put("msgId", paramAnonymousObject.msgId);
          localHashMap.put("sendTime", Long.valueOf(paramAnonymousObject.kaJ));
          localHashMap.put("msgType", Integer.valueOf(paramAnonymousObject.msgType));
          localHashMap.put("msgContent", paramAnonymousObject.dDP);
          locala.g(localc);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.onReceiveMsgChannelJsApiEvent", "dispatch wxa msg channel");
          locala.A(localHashMap).bir();
          AppMethodBeat.o(187883);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandVoIP1v1FloatBallEvent))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], AppBrandVoIP1v1FloatBallEvent msg", new Object[] { o.this.mAppId });
          if (((AppBrandVoIP1v1FloatBallEvent)paramAnonymousObject).dyx == 1) {
            com.tencent.mm.plugin.appbrand.jsapi.openvoice.q.bma();
          }
        }
        AppMethodBeat.o(187883);
      }
    });
    new f.a(this, (byte)0);
    this.jzm.G(8, System.currentTimeMillis() - ((AppBrandInitConfigWC)super.Fb()).startTime);
    rB(2);
    localObject = this.jxb;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.appbrand.pip.f)localObject).mnP = com.tencent.mm.plugin.appbrand.pip.k.moj;
      ((com.tencent.mm.plugin.appbrand.pip.f)localObject).bwF();
      ((com.tencent.mm.plugin.appbrand.pip.f)localObject).mnR = com.tencent.mm.plugin.appbrand.pip.g.moe;
    }
    AppMethodBeat.o(43908);
  }
  
  public final String aWP()
  {
    AppMethodBeat.i(187910);
    if ((AppBrandInitConfigWC)super.Fb() == null)
    {
      AppMethodBeat.o(187910);
      return "NULL";
    }
    String str = ((AppBrandInitConfigWC)super.Fb()).doD;
    AppMethodBeat.o(187910);
    return str;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.d aWQ()
  {
    return this.jzw;
  }
  
  public final com.tencent.mm.plugin.appbrand.floatball.c aWR()
  {
    if (this.jzu != null) {
      return this.jzu.kjz;
    }
    return null;
  }
  
  public com.tencent.mm.plugin.appbrand.k.b aWS()
  {
    AppMethodBeat.i(174683);
    if ((this.jzx == null) && (!isDestroyed())) {
      this.jzx = new o.1(this);
    }
    com.tencent.mm.plugin.appbrand.k.b localb = this.jzx;
    AppMethodBeat.o(174683);
    return localb;
  }
  
  public final boolean aWT()
  {
    AppMethodBeat.i(43893);
    boolean bool = ((AppBrandInitConfigWC)super.Fb()).jXu;
    AppMethodBeat.o(43893);
    return bool;
  }
  
  public final boolean aWU()
  {
    AppMethodBeat.i(43894);
    boolean bool = ((AppBrandInitConfigWC)super.Fb()).jXr;
    AppMethodBeat.o(43894);
    return bool;
  }
  
  public final void aWW()
  {
    AppMethodBeat.i(43898);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "callSuperClose appId:%s", new Object[] { this.mAppId });
    super.close();
    AppMethodBeat.o(43898);
  }
  
  protected final void aWX()
  {
    AppMethodBeat.i(43905);
    b(com.tencent.mm.plugin.appbrand.networking.b.class, com.tencent.mm.plugin.appbrand.networking.g.lXn);
    b(com.tencent.mm.plugin.appbrand.permission.h.class, new com.tencent.mm.plugin.appbrand.permission.k(this));
    b(com.tencent.mm.plugin.appbrand.permission.i.class, com.tencent.mm.plugin.appbrand.permission.m.mil);
    b(com.tencent.mm.plugin.appbrand.jsapi.media.e.class, com.tencent.mm.plugin.appbrand.jsapi.media.p.kVv);
    ac(com.tencent.mm.plugin.appbrand.networking.c.class);
    b(com.tencent.mm.plugin.appbrand.networking.c.class, new com.tencent.mm.plugin.appbrand.networking.f(this));
    b(com.tencent.mm.plugin.appbrand.jsapi.base.g.class, new aa());
    b(com.tencent.mm.plugin.appbrand.widget.h.class, com.tencent.mm.plugin.appbrand.widget.i.mTf);
    b(com.tencent.mm.plugin.appbrand.jsapi.x.b.class, com.tencent.mm.plugin.appbrand.luggage.b.c.lOb);
    b(com.tencent.luggage.sdk.f.a.class, com.tencent.mm.plugin.appbrand.app.e.jDJ);
    b(com.tencent.mm.plugin.appbrand.page.ax.class, new af(this));
    b(com.tencent.mm.plugin.appbrand.jsapi.media.a.a.class, new com.tencent.mm.plugin.appbrand.jsapi.media.a.a()
    {
      public final void a(final Context paramAnonymousContext, final Runnable paramAnonymousRunnable1, final Runnable paramAnonymousRunnable2)
      {
        AppMethodBeat.i(187905);
        if (!com.tencent.mm.plugin.appbrand.utils.ad.Ch())
        {
          o.this.j(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(43876);
              com.tencent.mm.platformtools.p.a(paramAnonymousContext, paramAnonymousRunnable1, paramAnonymousRunnable2);
              AppMethodBeat.o(43876);
            }
          }, 0L);
          AppMethodBeat.o(187905);
          return;
        }
        com.tencent.mm.platformtools.p.a(paramAnonymousContext, paramAnonymousRunnable1, paramAnonymousRunnable2);
        AppMethodBeat.o(187905);
      }
    });
    n.KB(this.mAppId);
    AppMethodBeat.o(43905);
  }
  
  protected final void aWY()
  {
    AppMethodBeat.i(43907);
    com.tencent.luggage.sdk.g.c.a("clearDuplicatedInstanceOnAppCreate", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(43881);
        Object localObject = a.Kj(o.this.mAppId);
        if ((localObject != null) && (o.this != localObject))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "clearDuplicatedInstanceOnAppCreate duplicated[%d] this[%d]", new Object[] { Integer.valueOf(localObject.hashCode()), Integer.valueOf(hashCode()) });
          ((o)localObject).aXg();
        }
        localObject = o.this.jzk;
        String str = o.this.mAppId;
        ((AppBrandRemoteTaskController)localObject).mxJ = AppBrandRemoteTaskController.a.myc;
        ((AppBrandRemoteTaskController)localObject).mAppId = str;
        AppBrandMainProcessService.a((MainProcessTask)localObject);
        AppMethodBeat.o(43881);
      }
    });
    AppMethodBeat.o(43907);
  }
  
  public com.tencent.mm.plugin.appbrand.page.ae aWZ()
  {
    AppMethodBeat.i(187916);
    if ((com.tencent.mm.plugin.appbrand.page.v)super.aVN() == null)
    {
      AppMethodBeat.o(187916);
      return null;
    }
    if (((com.tencent.mm.plugin.appbrand.page.v)super.aVN()).getCurrentPage() == null)
    {
      AppMethodBeat.o(187916);
      return null;
    }
    com.tencent.mm.plugin.appbrand.page.ae localae = (com.tencent.mm.plugin.appbrand.page.ae)((com.tencent.mm.plugin.appbrand.page.v)super.aVN()).getCurrentPage().getCurrentPageView();
    AppMethodBeat.o(187916);
    return localae;
  }
  
  protected q aWa()
  {
    AppMethodBeat.i(43901);
    Object localObject2;
    Object localObject1;
    if (super.Fe()) {
      if (Eb())
      {
        localObject2 = com.tencent.mm.plugin.appbrand.task.c.d(com.tencent.mm.plugin.appbrand.task.e.hA(true));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (this.jzs != null) {
            localObject1 = this.jzs.aWt();
          }
        }
        if (localObject1 == null) {
          localObject1 = new com.tencent.mm.plugin.appbrand.game.c();
        }
      }
    }
    label136:
    label267:
    label274:
    label303:
    for (;;)
    {
      AppMethodBeat.o(43901);
      return localObject1;
      com.tencent.mm.plugin.appbrand.report.quality.a.Ut(this.mAppId).mvx = com.tencent.mm.plugin.appbrand.report.quality.i.muQ;
      continue;
      localObject1 = new com.tencent.mm.plugin.appbrand.service.c(com.tencent.luggage.sdk.b.a.c.h.coX);
      continue;
      if (this.jzs != null)
      {
        localObject1 = this.jzs.aWt();
        if (localObject1 != null)
        {
          String str = this.mAppId;
          if (!Eb()) {
            break label260;
          }
          localObject2 = "WAGame";
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "[%s][%s] [applaunch] [preload] createService preloaded, reason=%s", new Object[] { str, localObject2, com.tencent.mm.plugin.appbrand.report.quality.a.Ut(this.mAppId).mvx.name() });
        }
        if (localObject1 != null) {
          break label303;
        }
        localObject2 = this.mAppId;
        if (!Eb()) {
          break label267;
        }
      }
      for (localObject1 = "WAGame";; localObject1 = "WAService")
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "[%s][%s] [applaunch] [preload] createService got no preloaded", new Object[] { localObject2, localObject1 });
        if (((!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.i.DEBUG) && (!DebuggerShell.bew())) || (!com.tencent.mm.plugin.appbrand.task.a.bym())) {
          break label274;
        }
        localObject1 = new IllegalStateException("[ForcePreload] enabled, but not preload");
        AppMethodBeat.o(43901);
        throw ((Throwable)localObject1);
        localObject1 = null;
        break;
        localObject2 = "WAService";
        break label136;
      }
      if (Eb()) {
        localObject1 = new com.tencent.mm.plugin.appbrand.game.c();
      } else {
        localObject1 = new com.tencent.mm.plugin.appbrand.service.c();
      }
    }
  }
  
  protected com.tencent.mm.plugin.appbrand.page.u aWb()
  {
    AppMethodBeat.i(43902);
    try
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.Ut(this.mAppId).mvz = bt.flT();
      label19:
      if (Eb()) {}
      com.tencent.mm.plugin.appbrand.page.ae localae;
      for (Object localObject1 = new com.tencent.mm.plugin.appbrand.game.f.c(com.tencent.mm.sdk.f.a.jq(this.mContext), this);; localObject1 = new com.tencent.mm.plugin.appbrand.page.v(com.tencent.mm.sdk.f.a.jq(this.mContext), this))
      {
        ((com.tencent.mm.plugin.appbrand.page.v)localObject1).setDecorWidgetFactory(this.jzw);
        if (!Eb()) {
          ((com.tencent.mm.plugin.appbrand.page.v)localObject1).a(com.tencent.mm.plugin.appbrand.page.c.h.mgz, new com.tencent.mm.plugin.appbrand.page.c.a());
        }
        ((com.tencent.mm.plugin.appbrand.page.v)localObject1).a(com.tencent.mm.plugin.appbrand.page.c.h.mgy, new com.tencent.mm.plugin.appbrand.page.c.b());
        if (this.jzs == null) {
          break label237;
        }
        localae = this.jzs.aWu();
        if ((localae == null) || (localae == null) || (((com.tencent.mm.plugin.appbrand.page.v)localObject1).getRuntime() == null)) {
          break label237;
        }
        if (localae.aVF().compareTo(((com.tencent.mm.plugin.appbrand.page.v)localObject1).getRuntime().fB(false)) == 0) {
          break;
        }
        localObject1 = new IllegalStateException(String.format(Locale.ENGLISH, "stashPreloadedPageView appId[%s] mismatch libReader, runtime[%s] page[%s]", new Object[] { ((com.tencent.mm.plugin.appbrand.page.v)localObject1).getAppId(), ((com.tencent.mm.plugin.appbrand.page.v)localObject1).getRuntime().fB(false).aZn(), localae.aVF().aZn() }));
        AppMethodBeat.o(43902);
        throw ((Throwable)localObject1);
      }
      synchronized (((com.tencent.mm.plugin.appbrand.page.v)localObject1).mbt)
      {
        ((com.tencent.mm.plugin.appbrand.page.v)localObject1).mbt.addLast(localae);
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
  
  public final boolean aWc()
  {
    AppMethodBeat.i(43904);
    if (Eb())
    {
      AppMethodBeat.o(43904);
      return false;
    }
    if (com.tencent.mm.protocal.d.Fnj <= 654314239)
    {
      AppMethodBeat.o(43904);
      return false;
    }
    if ((!com.tencent.mm.protocal.d.Fnk) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.quX, false)))
    {
      AppMethodBeat.o(43904);
      return true;
    }
    AppMethodBeat.o(43904);
    return false;
  }
  
  protected final void aWf()
  {
    AppMethodBeat.i(43916);
    MMToClientEvent.e((com.tencent.mm.plugin.appbrand.service.c)super.Ew());
    this.jzk.a(this.mAppId, ((AppBrandInitConfigWC)super.Fb()).dPf, com.tencent.mm.plugin.appbrand.task.e.h((AppBrandInitConfigWC)super.Fb()));
    AppMethodBeat.o(43916);
  }
  
  public final void aWk()
  {
    AppMethodBeat.i(174684);
    if (com.tencent.mm.plugin.appbrand.ui.n.al(this))
    {
      AppMethodBeat.o(174684);
      return;
    }
    super.aWk();
    AppMethodBeat.o(174684);
  }
  
  public final boolean aWl()
  {
    AppMethodBeat.i(43913);
    if ((!isInBackStack()) && (!a.a(this))) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "[wxa_reload]recycleRuntime %s, recycle[%b]", new Object[] { toString(), Boolean.valueOf(bool) });
      if (bool) {
        finish();
      }
      AppMethodBeat.o(43913);
      return bool;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.v aWm()
  {
    AppMethodBeat.i(187917);
    com.tencent.mm.plugin.appbrand.ui.v localv = super.aWm();
    AppMethodBeat.o(187917);
    return localv;
  }
  
  public final void aXa()
  {
    AppMethodBeat.i(43915);
    this.jzk.Uw(this.mAppId);
    AppMethodBeat.o(43915);
  }
  
  public final AppBrandSysConfigWC aXb()
  {
    AppMethodBeat.i(43918);
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)c(AppBrandSysConfigWC.class, false);
    AppMethodBeat.o(43918);
    return localAppBrandSysConfigWC;
  }
  
  public final AppBrandInitConfigWC aXc()
  {
    AppMethodBeat.i(221270);
    AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.Fb();
    AppMethodBeat.o(221270);
    return localAppBrandInitConfigWC;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.v aXd()
  {
    AppMethodBeat.i(221271);
    com.tencent.mm.plugin.appbrand.page.v localv = (com.tencent.mm.plugin.appbrand.page.v)super.aVN();
    AppMethodBeat.o(221271);
    return localv;
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c aXe()
  {
    AppMethodBeat.i(221272);
    com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)super.Ew();
    AppMethodBeat.o(221272);
    return localc;
  }
  
  public final void aXf()
  {
    AppMethodBeat.i(43931);
    Object localObject = aXb();
    com.tencent.mm.plugin.appbrand.config.m.bo(this.mAppId, ((AppBrandSysConfigWC)localObject).cnc);
    com.tencent.mm.plugin.appbrand.config.m.bp(this.mAppId, ((AppBrandSysConfigWC)localObject).cnd);
    this.jwO.add(com.tencent.mm.plugin.appbrand.config.e.a(this));
    this.jwO.add(com.tencent.mm.plugin.appbrand.config.e.a((AppBrandSysConfigLU)localObject));
    this.jwO.add(com.tencent.mm.plugin.appbrand.config.e.b((AppBrandSysConfigLU)localObject));
    this.jwO.add(com.tencent.mm.plugin.appbrand.config.e.b(this));
    localObject = com.tencent.mm.plugin.appbrand.config.e.c((AppBrandSysConfigLU)localObject);
    ((com.tencent.mm.plugin.appbrand.performance.a)localObject).mhb |= DebuggerShell.bew();
    boolean bool2 = ((com.tencent.mm.plugin.appbrand.performance.a)localObject).mhc;
    if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (bu.flY())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject).mhc = (bool1 | bool2);
      this.jwO.add(localObject);
      AppMethodBeat.o(43931);
      return;
    }
  }
  
  public final void aXg()
  {
    AppMethodBeat.i(43933);
    this.jwZ = false;
    if (this.jwC != null) {
      this.jwC.C(this);
    }
    finish();
    if ((this.jwC instanceof AppBrandRuntimeContainerWC)) {
      ((AppBrandRuntimeContainerWC)this.jwC).EV();
    }
    AppMethodBeat.o(43933);
  }
  
  protected void aXh()
  {
    AppMethodBeat.i(174689);
    k localk = this.jzs;
    if (localk != null)
    {
      if (localk.jxQ == null)
      {
        localk.aWr();
        AppMethodBeat.o(174689);
        return;
      }
      localk.jxQ.a(com.tencent.mm.vending.h.d.LiM, new k.5(localk)).a(com.tencent.mm.vending.h.d.LiM, new k.4(localk));
    }
    AppMethodBeat.o(174689);
  }
  
  public final boolean aXi()
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    com.tencent.mm.plugin.appbrand.ad.g localg;
    if (this.jzv != null)
    {
      localg = this.jzv;
      if (localg.jCt == null) {
        break label44;
      }
    }
    label44:
    for (boolean bool1 = localg.jCt.bWM;; bool1 = false)
    {
      bool2 = bool3;
      if (bool1) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public final int aXj()
  {
    if (this.jzv != null) {
      return this.jzv.jCq;
    }
    return 9;
  }
  
  public final int aXm()
  {
    AppMethodBeat.i(163908);
    if ((AppBrandInitConfigWC)super.Fb() != null)
    {
      int i = ((AppBrandInitConfigWC)super.Fb()).jXG;
      AppMethodBeat.o(163908);
      return i;
    }
    AppMethodBeat.o(163908);
    return -1;
  }
  
  public final boolean b(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(43925);
    paramAppBrandInitConfig = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    AppBrandStatObject localAppBrandStatObject = paramAppBrandInitConfig.cmC;
    boolean bool;
    if ((this.jzp) || (localAppBrandStatObject.scene == 1099))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] mShouldRelaunchCausedByFunctionalPageOpen[%b] newScene[%d]", new Object[] { this.mAppId, Boolean.valueOf(this.jzp), Integer.valueOf(localAppBrandStatObject.scene) });
      if (localAppBrandStatObject.scene == 1099) {}
      for (bool = true;; bool = false)
      {
        this.jzp = bool;
        AppMethodBeat.o(43925);
        return true;
      }
    }
    if ((TextUtils.isEmpty(paramAppBrandInitConfig.jCN)) && (ae.m(this)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] enterPath[%s], old is gameFunctionalPage", new Object[] { this.mAppId, paramAppBrandInitConfig.jCN });
      AppMethodBeat.o(43925);
      return true;
    }
    if (1038 == localAppBrandStatObject.scene)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. appId[%s], reason=1038 back from other MiniProgram", new Object[] { this.mAppId });
      AppMethodBeat.o(43925);
      return false;
    }
    Iterator localIterator = this.jzq.iterator();
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
    if (!TextUtils.isEmpty(paramAppBrandInitConfig.jCN))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] enterPath[%s]", new Object[] { this.mAppId, paramAppBrandInitConfig.jCN });
      AppMethodBeat.o(43925);
      return true;
    }
    int i = localAppBrandStatObject.scene;
    if (org.apache.commons.b.a.contains(new int[] { 1001, 1003, 1023, 1038, 1056, 1080, 1083, 1089, 1090, 1103, 1104, 1113, 1114, 1117, 1131, 1019, 1112, 1127, 1134 }, i))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. keepNoRelaunch appId[%s] newScene[%d]", new Object[] { this.mAppId, Integer.valueOf(localAppBrandStatObject.scene) });
      AppMethodBeat.o(43925);
      return false;
    }
    if ((1030 == localAppBrandStatObject.scene) && (TextUtils.isEmpty(paramAppBrandInitConfig.jCN)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. special for monkey test appId[%s]", new Object[] { this.mAppId });
      AppMethodBeat.o(43925);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] fallback logic", new Object[] { this.mAppId });
    AppMethodBeat.o(43925);
    return true;
  }
  
  public final void close()
  {
    AppMethodBeat.i(43897);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "close() appId:%s, stack:%s", new Object[] { this.mAppId, Log.getStackTraceString(new Throwable()) });
    o.12 local12;
    com.tencent.mm.plugin.appbrand.widget.dialog.f localf;
    int j;
    int i;
    for (;;)
    {
      try
      {
        if (g.Kv(this.mAppId) == g.d.jwl)
        {
          localObject1 = (com.tencent.mm.plugin.appbrand.game.f.a)((com.tencent.mm.plugin.appbrand.page.v)super.aVN()).getPageView().Q(com.tencent.mm.plugin.appbrand.game.f.a.class);
          if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.game.f.a)localObject1).bhm() != null))
          {
            localObject1 = ((com.tencent.mm.plugin.appbrand.game.f.a)localObject1).bhm();
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: triggerMakeCanvasBitmap");
            if ((((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).kma != null) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).bho() != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).kma.HRV)) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).kma.HRN) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).kmc != null)) {
              continue;
            }
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: should not do make canvas bitmap!");
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.AppBrandRuntimeWC", localException, "hy: triggerMakeCanvasBitmap error!", new Object[0]);
        continue;
        local12 = new o.12(this);
        localf = new com.tencent.mm.plugin.appbrand.widget.dialog.f((com.tencent.mm.plugin.appbrand.service.c)super.Ew());
        if (localf.kkl != null) {
          break;
        }
      }
      OpenBusinessViewUtil.v(this);
      if ((aWT()) || (ae.m(this)))
      {
        super.close();
        AppMethodBeat.o(43897);
        return;
        if (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).bhp()) {
          ((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).bho().Dr();
        }
      }
      else
      {
        j = 0;
        if ((this != null) && (aXb() != null) && (com.tencent.mm.sdk.f.a.jq(this.mContext) != null)) {
          break label482;
        }
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "invalid close state");
        i = 0;
        label300:
        if (i == 0) {
          break label1351;
        }
        if (j != 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: WA dialog first");
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1237L, 2L, 1L, false);
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
      Object localObject2 = localf.kkl.mqu;
      if ((localObject2 == null) || (((eis)localObject2).HTm == null) || (((eis)localObject2).HTm.size() < 3))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: no config");
        j = 0;
        break;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1237L, 0L, 1L, false);
      long l1 = n.KE(this.mAppId).lastResumeTime;
      localf.ltr = ((int)(System.currentTimeMillis() - l1));
      if (localf.ltr < ((eis)localObject2).HTo * 1000)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: time limit");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1237L, 1L, 1L, false);
        j = 0;
        break;
      }
      j = 1;
      break;
      label482:
      localObject2 = aXb();
      if (!((AppBrandSysConfigWC)localObject2).jYl)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "can not show evaluate dialog");
        i = 0;
        break label300;
      }
      l1 = n.KE(this.mAppId).lastResumeTime;
      long l2 = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "app time lastResumeTime:%s, closeTime:%s, leastTime:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(((AppBrandSysConfigWC)localObject2).jYn) });
      if ((l2 - l1) / 1000L < ((AppBrandSysConfigWC)localObject2).jYn)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "time not enough to show evaluate dialog");
        i = 0;
        break label300;
      }
      Object localObject5 = (AppBrandInitConfigWC)super.Fb();
      localf.userName = ((AppBrandInitConfigWC)localObject5).username;
      if (bt.isNullOrNil(localf.userName))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "username is null, can not show evaluate dialog");
        i = 0;
        break label300;
      }
      Object localObject3 = com.tencent.mm.sdk.f.a.jq(this.mContext);
      Object localObject4 = ((AppBrandInitConfigWC)localObject5).appId;
      Object localObject6 = ((AppBrandInitConfigWC)localObject5).doD;
      boolean bool = ((AppBrandSysConfigWC)localObject2).jYm;
      localf.dialog = com.tencent.mm.plugin.appbrand.widget.dialog.f.w((Context)localObject3, true);
      localObject5 = (LinearLayout)LayoutInflater.from(localf.dialog.getContext()).inflate(2131492994, null, false);
      localf.dialog.setContentView((View)localObject5);
      Object localObject7 = al.ci(localf.dialog.getContext());
      i = Math.min(((Point)localObject7).x, ((Point)localObject7).y);
      localObject7 = new FrameLayout.LayoutParams(i, -2);
      ((FrameLayout.LayoutParams)localObject7).gravity = 1;
      ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject7);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "createEvaluateDialog, dialog width:%d", new Object[] { Integer.valueOf(i) });
      localf.ndD = ((TextView)localf.dialog.findViewById(2131299532));
      localf.ndE = ((LinearLayout)localf.dialog.findViewById(2131299533));
      localf.ndF = ((LinearLayout)localf.dialog.findViewById(2131299530));
      localObject7 = (TextView)localf.dialog.findViewById(2131299529);
      if (bool)
      {
        ((TextView)localObject7).setVisibility(0);
        ((TextView)localObject7).setOnClickListener(new f.15(localf, (Context)localObject3, (String)localObject4, (String)localObject6));
        label892:
        ((TextView)localf.dialog.findViewById(2131299536)).setOnClickListener(new f.16(localf, (Context)localObject3));
        localf.ndC = ((RatingBar)localf.dialog.findViewById(2131299534));
        localf.ndC.setOnRatingBarChangeListener(new f.17(localf));
        localf.ndB = ((TextView)localf.dialog.findViewById(2131299531));
        if (bt.isNullOrNil((String)localObject6)) {
          break label1211;
        }
        localf.ndB.setVisibility(0);
        localf.ndB.setText(((Context)localObject3).getString(2131755406, new Object[] { localObject6 }));
        label1017:
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
        localf.ndz = false;
        ((AppBrandSysConfigWC)localObject2).jYl = false;
        if (this != null) {
          break label1224;
        }
        localObject2 = null;
        label1151:
        localf.appId = ((String)localObject2);
        if (!bt.isNullOrNil(localf.appId)) {
          break label1233;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "saveEvaluateReport, no app id");
      }
      for (;;)
      {
        localf.cf(1, 1);
        localf.show();
        i = 1;
        break;
        ((TextView)localObject7).setVisibility(8);
        ((TextView)localObject7).setOnClickListener(null);
        break label892;
        label1211:
        localf.ndB.setVisibility(8);
        break label1017;
        label1224:
        localObject2 = this.mAppId;
        break label1151;
        label1233:
        localObject2 = (AppBrandInitConfigWC)super.Fb();
        localf.sessionId = "";
        if (localObject2 != null) {
          localf.sessionId = ((AppBrandInitConfigWC)localObject2).Ec();
        }
        localf.scene = 1000;
        if ((localObject2 != null) && (((AppBrandInitConfigLU)localObject2).cmC != null)) {
          localf.scene = ((AppBrandInitConfigLU)localObject2).cmC.scene;
        }
        localf.dki = "";
        if (((com.tencent.mm.plugin.appbrand.service.c)super.Ew() != null) && (((com.tencent.mm.plugin.appbrand.service.c)super.Ew()).aWZ() != null)) {
          localf.dki = ((com.tencent.mm.plugin.appbrand.service.c)super.Ew()).aWZ().kuf;
        }
      }
      label1351:
      if (j != 0)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "need show game evaluate dialog");
        localObject2 = localf.kkl.mqu;
        localf.kkl.mqu = null;
        localf.dialog = com.tencent.mm.plugin.appbrand.widget.dialog.f.w(com.tencent.mm.sdk.f.a.jq(this.mContext), false);
        localObject3 = (LinearLayout)LayoutInflater.from(localf.dialog.getContext()).inflate(2131492996, null, false);
        localf.dialog.setContentView((View)localObject3);
        localObject4 = al.ci(localf.dialog.getContext());
        localObject4 = new FrameLayout.LayoutParams(Math.min(((Point)localObject4).x, ((Point)localObject4).y), ((LinearLayout)localObject3).getLayoutParams().height);
        ((FrameLayout.LayoutParams)localObject4).gravity = 1;
        ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        localObject5 = (TextView)((LinearLayout)localObject3).findViewById(2131305902);
        ((TextView)localObject5).setText(((eis)localObject2).Title);
        localObject6 = (TextView)((LinearLayout)localObject3).findViewById(2131299531);
        ((TextView)localObject6).setText(((eis)localObject2).HTl);
        localObject4 = (ImageView)((LinearLayout)localObject3).findViewById(2131299528);
        localObject5 = new f.21(localf, (TextView)localObject5, (TextView)localObject6, (ImageView)localObject4, (LinearLayout)localObject3, this, local12, (eis)localObject2);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(2131303040)).a(0, (eis)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(2131303041)).a(1, (eis)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(2131303042)).a(2, (eis)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        localf.dialog.setOnCancelListener(new f.2(localf, this, (eis)localObject2, local12));
        ((ImageView)localObject4).setOnClickListener(new f.3(localf, this, (eis)localObject2, local12));
        localf.dialog = localf.dialog;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1237L, 4L, 1L, false);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "finish appId[%s] type[%d] hash[%d] stacktrace=%s", new Object[] { this.mAppId, Integer.valueOf(this.jwG.dPf), Integer.valueOf(hashCode()), Log.getStackTraceString(new Throwable()) });
    if ((i.d(this)) || (this.jwC == null))
    {
      j(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187904);
          o.this.dispatchDestroy();
          AppMethodBeat.o(187904);
        }
      }, 0L);
      AppMethodBeat.o(43899);
      return;
    }
    super.finish();
    if (this.jzu != null) {
      this.jzu.r(this);
    }
    AppMethodBeat.o(43899);
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(43903);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.plugin.appbrand.jsapi.w.h.a(paramConfiguration, this.mAppId);
    this.jzt = new Configuration(paramConfiguration);
    AppMethodBeat.o(43903);
  }
  
  protected void onCreate()
  {
    AppMethodBeat.i(43906);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepPrepareRuntime);
    fC(false);
    aWY();
    com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
    Object localObject1 = (AppBrandInitConfigWC)super.Fb();
    Object localObject2;
    boolean bool;
    int i;
    if (localObject1 != null)
    {
      localObject2 = ((AppBrandInitConfigWC)localObject1).jXD;
      if (localObject2 != null) {}
    }
    else
    {
      a.setRuntime(this);
      com.tencent.mm.plugin.appbrand.e.a.R(this);
      aWV();
      bool = WXHardCoderJNI.hcMiniProgramLaunchEnable;
      int j = WXHardCoderJNI.hcMiniProgramLaunchDelay;
      int k = WXHardCoderJNI.hcMiniProgramLaunchCPU;
      int m = WXHardCoderJNI.hcMiniProgramLaunchIO;
      if (!WXHardCoderJNI.hcMiniProgramLaunchThr) {
        break label705;
      }
      i = Process.myTid();
      label95:
      this.jzo = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMiniProgramLaunchTimeout, 801, WXHardCoderJNI.hcMiniProgramLaunchAction, "MicroMsg.AppBrandRuntimeWC");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "hardcoder miniprogram launch launchStartPerformance [%d]", new Object[] { Integer.valueOf(this.jzo) });
      super.onCreate();
      aWX();
      if (!Eb()) {
        break label710;
      }
      localObject1 = com.tencent.luggage.sdk.d.d.cpu;
      localObject1 = w.a.lHw;
      com.tencent.luggage.sdk.d.d.bz(w.a.a.gY(true));
      label174:
      com.tencent.mm.plugin.appbrand.report.quality.a.B(this);
      localObject1 = com.tencent.mm.plugin.appbrand.report.quality.n.mwc;
      com.tencent.mm.plugin.appbrand.report.quality.n.em(this.mAppId, com.tencent.mm.plugin.appbrand.report.quality.a.Ut(this.mAppId).lEv);
      com.tencent.mm.plugin.appbrand.report.quality.f.a(this, false, com.tencent.mm.plugin.appbrand.utils.a.UY(((AppBrandInitConfigWC)super.Fb()).jXA));
      localObject1 = com.tencent.luggage.game.e.a.DO();
      localObject2 = this.mAppId;
      bool = Eb();
      ((com.tencent.luggage.game.e.a)localObject1).appId = ((String)localObject2);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MBNiReporter", "hy: appId:%s,isGame:%s", new Object[] { localObject2, Boolean.valueOf(bool) });
      if (bool) {
        g.a((String)localObject2, ((com.tencent.luggage.game.e.a)localObject1).clL);
      }
      ((com.tencent.luggage.game.e.a)localObject1).clD = new ArrayList();
      if (!bool) {
        break label730;
      }
      ((com.tencent.luggage.game.e.a)localObject1).clH = 1004;
      label308:
      com.tencent.mm.plugin.t.a.a(this.mAppId, ((AppBrandInitConfigWC)super.Fb()).jXx);
      a(new AppBrandRuntime.b()
      {
        public final void prepare()
        {
          AppMethodBeat.i(187907);
          com.tencent.mm.plugin.appbrand.keylogger.c.a(o.this.mAppId, KSProcessWeAppLaunch.stepWaitForCommLibConfirm);
          com.tencent.mm.plugin.appbrand.launching.g.a(o.this, new d.g.a.b() {});
          AppMethodBeat.o(187907);
        }
      });
      a(new AppBrandRuntime.b()
      {
        public final void prepare()
        {
          AppMethodBeat.i(187908);
          o.a(o.this, this);
          AppMethodBeat.o(187908);
        }
      });
      a(new b((byte)0));
      localObject1 = new k(this);
      this.jzs = ((k)localObject1);
      a((AppBrandRuntime.b)localObject1);
      this.jzk.a(this.mAppId, ((AppBrandInitConfigWC)super.Fb()).dPf, com.tencent.mm.plugin.appbrand.task.e.h((AppBrandInitConfigWC)super.Fb()));
      com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
      com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.o(this);
      com.tencent.mm.plugin.appbrand.backgroundfetch.i.o(this);
      com.tencent.mm.plugin.appbrand.utils.f.J(this);
      OpenBusinessViewUtil.u(this);
      AppBrandBackgroundRunningMonitor.p(this);
      this.jzl = new com.tencent.mm.plugin.appbrand.report.model.n();
      this.jzl.mtw = bt.HI();
      com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j.a(this.mAppId, aVW(), Fb().cmC);
      if (Fb().cmC.scene != 1099) {
        break label741;
      }
      bool = true;
      label496:
      this.jzp = bool;
      if (aWT()) {
        this.jzq.add(new ad((AppBrandInitConfigWC)super.Fb()));
      }
      this.jwS.a(new com.tencent.mm.plugin.appbrand.a.c.a()
      {
        public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
        {
          AppMethodBeat.i(187909);
          if (com.tencent.mm.plugin.appbrand.a.b.jKQ == paramAnonymousb)
          {
            o.this.jzj.lfI.lfJ.clear();
            com.tencent.mm.plugin.appbrand.report.quality.j.bV(paramAnonymousString, 4);
          }
          AppMethodBeat.o(187909);
        }
      });
      if ((!aWT()) && (!ap.n(this))) {
        break label747;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandRuntimeWC", "initFloatBallHelper appId[%s], skip fakeNative", new Object[] { this.mAppId });
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(this.mAppId);
      if (localObject1 != null) {
        ((QualitySession)localObject1).mvj = (bt.flT() - ((AppBrandInitConfigWC)super.Fb()).startTime);
      }
      Kx("onCreate");
      com.tencent.mm.sdk.platformtools.ax.aQz(this.mAppId + "_wxa_voip").putBoolean("isCameraStart", false);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "reset appId:%s isCameraStart false", new Object[] { this.mAppId });
      AppMethodBeat.o(43906);
      return;
      com.tencent.mm.ad.c.b(null, (d.g.a.a)new c.b(a.aVz(), (QualitySession)localObject2, (AppBrandInitConfigWC)localObject1));
      break;
      label705:
      i = 0;
      break label95;
      label710:
      localObject1 = com.tencent.luggage.sdk.d.d.cpu;
      localObject1 = w.a.lHw;
      com.tencent.luggage.sdk.d.d.by(w.a.a.gY(false));
      break label174;
      label730:
      ((com.tencent.luggage.game.e.a)localObject1).clH = 1000;
      break label308;
      label741:
      bool = false;
      break label496;
      label747:
      if (this.jzu != null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "initFloatBallHelper, destroy");
        this.jzu.r(this);
      }
      this.jzu = new com.tencent.mm.plugin.appbrand.floatball.d();
      localObject1 = this.jzu;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandFloatBallLogic", "init, runtime:%s", new Object[] { this.mAppId });
      com.tencent.e.h.LTJ.f(new d.1((com.tencent.mm.plugin.appbrand.floatball.d)localObject1, this), "FloatBallHelperThread");
    }
  }
  
  public final void onDestroy()
  {
    int j = 1;
    AppMethodBeat.i(43914);
    super.onDestroy();
    MMToClientEvent.f((com.tencent.mm.plugin.appbrand.service.c)super.Ew());
    com.tencent.mm.plugin.appbrand.e.a.S(this);
    com.tencent.mm.plugin.appbrand.report.quality.a.D(this);
    if (this.jzo != 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.jzo);
      this.jzo = 0;
    }
    if (DebuggerShell.bew())
    {
      if (this.jzr != null) {
        this.jzr.stopTimer();
      }
      com.tencent.e.h.LTJ.aR(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174666);
          AppBrandPerformanceManager.h(o.this);
          AppMethodBeat.o(174666);
        }
      });
      com.tencent.mm.plugin.appbrand.performance.b.TL(this.mAppId);
    }
    if (Eb()) {
      com.tencent.mm.plugin.appbrand.game.preload.d.s(this);
    }
    ??? = AppBrandMusicClientService.lQS;
    ((AppBrandMusicClientService)???).lQR.clear();
    ((AppBrandMusicClientService)???).lQT = "";
    n.remove(this.mAppId);
    com.tencent.mm.plugin.appbrand.media.record.c.onDestroy();
    aXa();
    this.jzk = null;
    ??? = EY();
    Object localObject2;
    if (??? != null)
    {
      localObject2 = (com.tencent.mm.plugin.appbrand.appstorage.n)((t)???).av(com.tencent.mm.plugin.appbrand.appstorage.n.class);
      if (localObject2 != null) {
        com.tencent.mm.vfs.i.deleteFile(((com.tencent.mm.plugin.appbrand.appstorage.n)localObject2).jMN + "/dir.lock");
      }
      ((t)???).release();
    }
    this.jzw.lYU.clear();
    a.b(this);
    ??? = this.jzl;
    int i;
    if (??? != null)
    {
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).sessionId = ((AppBrandInitConfigWC)super.Fb()).Ec();
      localObject2 = n.KE(this.mAppId);
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).msV = com.tencent.mm.plugin.appbrand.report.h.getNetworkType(aj.getContext());
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).appId = this.mAppId;
      if (aXb() != null) {
        break label531;
      }
      i = ((AppBrandInitConfigWC)super.Fb()).aDD;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).aDD = i;
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).dkg = (this.jwG.dPf + 1);
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).scene = Fb().cmC.scene;
      if (((com.tencent.mm.plugin.appbrand.report.model.n)???).mtx)
      {
        i = 1;
        label326:
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).mty = i;
        if (!((n)localObject2).jyV.get()) {
          break label550;
        }
        i = j;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).mtz = i;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).mtA = bt.aO(((com.tencent.mm.plugin.appbrand.report.model.n)???).mtw);
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).mtB = bt.flT();
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).username = ((AppBrandInitConfigWC)super.Fb()).username;
        localObject2 = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(this.mAppId);
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).mtC = ((QualitySessionRuntime)localObject2).apptype;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).lEv = ((QualitySessionRuntime)localObject2).lEv;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).report();
        com.tencent.mm.plugin.appbrand.ui.recommend.e.G(this);
        this.jzl = null;
        this.jzn = false;
        this.jzs = null;
        if (this.jzv != null)
        {
          ??? = this.jzv;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "onDestroy");
          ((com.tencent.mm.plugin.appbrand.ad.g)???).KU("onDestroy");
          ((com.tencent.mm.plugin.appbrand.ad.g)???).jCt = null;
          this.jzv = null;
        }
        this.jzz.clear();
        this.jzq.clear();
        ??? = this.jzj;
        ((com.tencent.mm.plugin.appbrand.jsapi.u.a)???).lfI.lfJ.clear();
      }
      synchronized (((com.tencent.mm.plugin.appbrand.jsapi.u.a)???).lfH)
      {
        ((SparseArray)???).clear();
        localObject2 = z.MKo;
        com.tencent.mm.plugin.appbrand.jsapi.ac.b.c.release();
        AppMethodBeat.o(43914);
        return;
        label531:
        i = aXb().jYh.pkgVersion;
        continue;
        i = 0;
        break label326;
        label550:
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
    Object localObject = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(this.mAppId);
    if (localObject != null) {
      ((QualitySessionRuntime)localObject).mvq = bt.flT();
    }
    localObject = super.aWm();
    if ((localObject instanceof y)) {
      ((y)localObject).setCanShowHideAnimation(true);
    }
    AppMethodBeat.o(174690);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(43912);
    super.onPause();
    Object localObject = this.jzk;
    ((AppBrandRemoteTaskController)localObject).mxJ = AppBrandRemoteTaskController.a.mye;
    AppBrandMainProcessService.a((MainProcessTask)localObject);
    if (this.jzu != null)
    {
      localObject = this.jzu;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandFloatBallLogic", "pause, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjz != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjz.bgC();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjA != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjA.bgC();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjB != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjB.bgC();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjD != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjD.bgC();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjC != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjC.bgC();
      }
    }
    aWS().aXn();
    AppMethodBeat.o(43912);
  }
  
  public void onReady()
  {
    AppMethodBeat.i(43909);
    super.onReady();
    n.KF(this.mAppId).lastResumeTime = System.currentTimeMillis();
    if (this.jzo != 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.jzo);
      this.jzo = 0;
    }
    long l1 = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.Fb()).startTime;
    com.tencent.mm.plugin.appbrand.report.h.a(l1, this.jzn, Eb());
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "onReady reportStartupTime: appId:%s, nickname:%s, cost:%dms, download:%b, isGame:%b", new Object[] { this.mAppId, ((AppBrandInitConfigWC)super.Fb()).doD, Long.valueOf(l1), Boolean.valueOf(this.jzn), Boolean.valueOf(Eb()) });
    l1 = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.Fb()).startTime;
    this.jzm.G(5, l1);
    Object localObject1 = this.jzm;
    boolean bool1 = this.jzn;
    boolean bool2 = ((AppBrandInitConfigWC)super.Fb()).cmB;
    boolean bool3 = ((AppStartupPerformanceReportBundle)ar(AppStartupPerformanceReportBundle.class)).lGo;
    Object localObject2 = this.mAppId;
    ((m)localObject1).cR = 0;
    ((m)localObject1).mType = 0;
    if (aXb() != null)
    {
      ((m)localObject1).cR = aXb().jYh.pkgVersion;
      ((m)localObject1).mType = (aXb().jYh.jIU + 1);
    }
    int i;
    label274:
    Object localObject3;
    label320:
    Object localObject4;
    if (bool1)
    {
      i = 1;
      ((m)localObject1).jyM = i;
      if (!Eb()) {
        break label1105;
      }
      i = 1;
      ((m)localObject1).jyQ = i;
      ((m)localObject1).mScene = Fb().cmC.scene;
      ((m)localObject1).jyO = bool2;
      ((m)localObject1).jyP = bool3;
      localObject3 = new StringBuilder();
      i = 0;
      if (i >= ((m)localObject1).jyL.length) {
        break label1139;
      }
      if (localObject1.jyL[i] >= 0L) {
        break label1110;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: abort, illegal value: %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(localObject1.jyL[i]) });
      AppBrandPerformanceManager.a(this, 202, l1);
      com.tencent.mm.plugin.appbrand.performance.c.sW(((AppBrandInitConfigWC)super.Fb()).startTime);
      com.tencent.mm.plugin.appbrand.report.quality.a.a(this.mAppId, this);
      if ((DebuggerShell.bew()) && (this.jzr == null))
      {
        this.jzr = new av("AppBrandRuntimeWC.mDumpTracerTimer", new av.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(187899);
            com.tencent.mm.plugin.appbrand.performance.b.h(o.this);
            AppMethodBeat.o(187899);
            return true;
          }
        }, true);
        this.jzr.az(1000L, 1000L);
      }
      if (Eb())
      {
        localObject1 = com.tencent.mm.plugin.appbrand.game.preload.d.bhx();
        l1 = bt.flT();
        long l2 = ((AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).jCo.Fb()).startTime;
        com.tencent.mm.plugin.appbrand.game.preload.e.bhz().dM(2001, (int)(l1 - l2));
      }
      com.tencent.mm.plugin.appbrand.ui.recommend.e.H(this);
      this.jzk.hz(false);
      if (EY() != null)
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.appstorage.n)EY().av(com.tencent.mm.plugin.appbrand.appstorage.n.class);
        com.tencent.mm.vfs.i.f(((com.tencent.mm.plugin.appbrand.appstorage.n)localObject1).jMN + "/dir.lock", new byte[1], 1);
      }
      localObject4 = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(this.mAppId);
      if ((localObject4 != null) && (!Eb()))
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
        d.g.b.p.h(this, "runtime");
        jd localjd = new jd();
        localObject3 = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(this.mAppId);
        if (localObject3 == null) {
          break label1461;
        }
        localjd.eqt = localjd.t("InstanceId", ((QualitySessionRuntime)localObject3).lEv, true);
        localjd.esR = localjd.t("AppId", ((QualitySessionRuntime)localObject3).appId, true);
        localjd.eru = ((QualitySessionRuntime)localObject3).mvi;
        localjd.ezO = jd.a.jJ(((QualitySessionRuntime)localObject3).mtG);
        localjd.esT = ((QualitySessionRuntime)localObject3).apptype;
        localjd.dVd = ((QualitySessionRuntime)localObject3).scene;
        localObject1 = (com.tencent.mm.plugin.appbrand.page.v)super.aVN();
        d.g.b.p.g(localObject1, "runtime.pageContainer");
        localObject1 = ((com.tencent.mm.plugin.appbrand.page.v)localObject1).getCurrentPage();
        if (localObject1 == null) {
          break label1455;
        }
        localObject1 = ((r)localObject1).getCurrentPageView();
        label740:
        localObject2 = localObject1;
        if (!(localObject1 instanceof com.tencent.mm.plugin.appbrand.page.ae)) {
          localObject2 = null;
        }
        localjd.eaw = com.tencent.mm.plugin.appbrand.report.quality.c.y((com.tencent.mm.plugin.appbrand.page.ae)localObject2);
        localObject1 = localObject3;
        label772:
        com.tencent.mm.plugin.appbrand.report.quality.c.a((QualitySessionRuntime)localObject1, "Null session with " + this.mAppId);
        localjd.etI = ((QualitySessionRuntime)localObject4).bxU();
        localjd.aLk();
      }
      if (localObject4 != null)
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
        d.g.b.p.h(this, "runtime");
        localObject3 = new id();
        localObject2 = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(this.mAppId);
        if (localObject2 == null) {
          break label1504;
        }
        ((id)localObject3).eqt = ((id)localObject3).t("InstanceId", ((QualitySessionRuntime)localObject2).lEv, true);
        ((id)localObject3).esR = ((id)localObject3).t("AppId", ((QualitySessionRuntime)localObject2).appId, true);
        ((id)localObject3).eru = ((QualitySessionRuntime)localObject2).mvi;
        ((id)localObject3).euL = id.a.ji(((QualitySessionRuntime)localObject2).mtG);
        ((id)localObject3).esT = ((QualitySessionRuntime)localObject2).apptype;
        ((id)localObject3).dVd = ((QualitySessionRuntime)localObject2).scene;
        localObject1 = (com.tencent.mm.plugin.appbrand.service.c)super.Ew();
        if (localObject1 == null) {
          break label1467;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.service.c)localObject1).aYh();
        label957:
        localObject1 = com.tencent.mm.plugin.appbrand.report.d.d((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject1);
        switch (com.tencent.mm.plugin.appbrand.report.quality.d.cpQ[localObject1.ordinal()])
        {
        default: 
          i = -1;
          label1014:
          ((id)localObject3).eaw = i;
        }
      }
    }
    label1105:
    label1110:
    label1504:
    for (localObject1 = localObject2;; localObject1 = null)
    {
      com.tencent.mm.plugin.appbrand.report.quality.c.a((QualitySessionRuntime)localObject1, "Null session with " + this.mAppId);
      ((id)localObject3).etI = ((QualitySessionRuntime)localObject4).bxU();
      ((id)localObject3).aLk();
      com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup);
      com.tencent.mm.plugin.appbrand.keylogger.c.b(KSProcessWeAppLaunch.class, this.mAppId);
      com.tencent.mm.plugin.appbrand.report.quality.j.bV(this.mAppId, 1);
      AppMethodBeat.o(43909);
      return;
      i = 0;
      break;
      i = 0;
      break label274;
      ((StringBuilder)localObject3).append(localObject1.jyL[i]);
      ((StringBuilder)localObject3).append(",");
      i += 1;
      break label320;
      label1139:
      localObject4 = (AppBrandInitConfigWC)super.Fb();
      if (localObject4 != null) {
        i = ((AppBrandInitConfigWC)localObject4).cmr;
      }
      for (;;)
      {
        i += 1000;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: %s, %s, Download: %s, Preload: %s, appServiceType: %s", new Object[] { localObject2, ((StringBuilder)localObject3).toString(), Boolean.valueOf(bool1), Boolean.valueOf(com.tencent.mm.plugin.appbrand.task.c.aXK()), Integer.valueOf(i) });
        ((m)localObject1).g((String)localObject2, 1, 0, i);
        ((m)localObject1).g((String)localObject2, 2, 1, i);
        ((m)localObject1).g((String)localObject2, 3, 2, i);
        ((m)localObject1).g((String)localObject2, 4, 3, i);
        ((m)localObject1).g((String)localObject2, 6, 4, i);
        ((m)localObject1).g((String)localObject2, 7, 5, i);
        ((m)localObject1).g((String)localObject2, 23, 6, i);
        ((m)localObject1).g((String)localObject2, 24, 7, i);
        ((m)localObject1).g((String)localObject2, 25, 8, i);
        ((m)localObject1).g((String)localObject2, 26, 9, i);
        ((m)localObject1).g((String)localObject2, 27, 10, i);
        ((m)localObject1).g((String)localObject2, 28, 11, i);
        ((m)localObject1).g((String)localObject2, 29, 12, i);
        ((m)localObject1).g((String)localObject2, 30, 13, i);
        ((m)localObject1).g((String)localObject2, 31, 14, i);
        x.a(4, localObject1.jyL[5], ((m)localObject1).jyN, (String)localObject2, ((m)localObject1).jyM, ((m)localObject1).jyQ, fB(false).aZp());
        break;
        i = com.tencent.mm.plugin.appbrand.report.i.Uj((String)localObject2);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeStartupReporter", "getServiceTypeForReport null = initConfig! appServiceType:%s", new Object[] { Integer.valueOf(i) });
      }
      localObject1 = null;
      break label740;
      localObject1 = null;
      break label772;
      localObject1 = null;
      break label957;
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
    n.KF(this.mAppId).lastResumeTime = System.currentTimeMillis();
    if (this.jzu != null)
    {
      localObject = this.jzu;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandFloatBallLogic", "resume, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjz != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjz.bgB();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjA != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjA.bgB();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjB != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjB.bgB();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjD != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjD.bgB();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjC != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).kjC.bgB();
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j.a(this.mAppId, aVW(), Fb().cmC);
    a.setRuntime(this);
    com.tencent.mm.plugin.appbrand.e.a.R(this);
    this.jzk.bW(this.mAppId, ((AppBrandInitConfigWC)super.Fb()).dPf);
    if (this.jwV) {
      ((com.tencent.mm.plugin.appbrand.page.v)super.aVN()).getReporter().bso();
    }
    Object localObject = this.mAppId;
    int i = Fb().cmC.scene;
    AppBrandIDKeyBatchReport.bxb().mqA = 1;
    AppBrandIDKeyBatchReport.bxb().mqC = ((String)localObject);
    AppBrandIDKeyBatchReport.bxb().mqD = i;
    AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.bxb());
    localObject = s.a(this, new o.4(this));
    keep((com.tencent.mm.vending.e.a)localObject);
    com.tencent.e.h.LTJ.f((Runnable)localObject, "getCopyPathMenuExpireTime");
    com.tencent.mm.plugin.appbrand.ipc.b.connect();
    if (aWZ() != null)
    {
      aWS().KG(aWZ().kuf);
      AppMethodBeat.o(43911);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandRuntimeWC", "onResume, try upsertHandOff but get NULL PageView, appId:%s", new Object[] { this.mAppId });
    AppMethodBeat.o(43911);
  }
  
  public final void rC(int paramInt)
  {
    AppMethodBeat.i(43932);
    com.tencent.mm.plugin.appbrand.ui.v localv = super.aWm();
    if ((localv instanceof com.tencent.mm.plugin.appbrand.launching.q)) {
      ((com.tencent.mm.plugin.appbrand.launching.q)localv).rC(paramInt);
    }
    AppMethodBeat.o(43932);
  }
  
  public String toString()
  {
    AppMethodBeat.i(43886);
    String str = String.format(Locale.ENGLISH, "[AppBrandRuntimeWC::%s::%s::%d::@%d]", new Object[] { this.mAppId, aWP(), Integer.valueOf(this.jwG.dPf), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(43886);
    return str;
  }
  
  final class b
    extends AppBrandRuntime.b
  {
    volatile AppBrandPrepareTask jzR;
    volatile boolean jzS = false;
    
    private b() {}
    
    public final void interrupt()
    {
      AppMethodBeat.i(43884);
      this.jzS = true;
      AppBrandPrepareTask localAppBrandPrepareTask = this.jzR;
      if (localAppBrandPrepareTask != null) {
        localAppBrandPrepareTask.interrupt();
      }
      AppMethodBeat.o(43884);
    }
    
    public final void prepare()
    {
      AppMethodBeat.i(43883);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| ResourcePrepareProcess.prepare() appId:%s", new Object[] { o.this.mAppId });
      com.tencent.mm.plugin.appbrand.launching.g.a(o.this, new d.g.a.b()
      {
        private z aXr()
        {
          AppMethodBeat.i(162153);
          if (!o.b.this.jzS) {}
          try
          {
            o.b.this.jzR = o.b(o.this, o.b.this);
            z localz = z.MKo;
            AppMethodBeat.o(162153);
            return localz;
          }
          catch (NullPointerException localNullPointerException)
          {
            while (o.this.isDestroyed()) {}
            AppMethodBeat.o(162153);
            throw localNullPointerException;
          }
        }
      });
      AppMethodBeat.o(43883);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o
 * JD-Core Version:    0.7.0.1
 */