package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
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
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fi;
import com.tencent.mm.g.b.a.fi.a;
import com.tencent.mm.g.b.a.gh;
import com.tencent.mm.g.b.a.gh.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader.a;
import com.tencent.mm.plugin.appbrand.b.d.a;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.HttpSetting;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.a.b;
import com.tencent.mm.plugin.appbrand.config.a.c;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.floatball.d.1;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.EventLocationBackgroundStateChanged;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareParams;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.launching.w.a;
import com.tencent.mm.plugin.appbrand.launching.w.a.a;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.page.ak;
import com.tencent.mm.plugin.appbrand.page.bc;
import com.tencent.mm.plugin.appbrand.page.d.b;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.c.b;
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.utils.v.a;
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
import com.tencent.mm.protocal.protobuf.dvj;
import com.tencent.mm.protocal.protobuf.dwv;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTextureManager;
import com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePlugin;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class o
  extends com.tencent.luggage.sdk.d.c
  implements com.tencent.luggage.sdk.g.c.a, com.tencent.mm.plugin.appbrand.launching.q
{
  public final boolean iGa;
  public final com.tencent.mm.plugin.appbrand.jsapi.s.a iGb;
  protected AppBrandRemoteTaskController iGc;
  private volatile com.tencent.mm.plugin.appbrand.report.model.n iGd;
  public m iGe;
  public boolean iGf;
  private int iGg;
  private boolean iGh;
  private final List<ah> iGi;
  private av iGj;
  private volatile k iGk;
  private Configuration iGl;
  private com.tencent.mm.plugin.appbrand.floatball.d iGm;
  q iGn;
  public int iGo;
  volatile long iGp;
  volatile long iGq;
  private volatile boolean iGr;
  av iGs;
  private HandlerThread iGt;
  private b iGu;
  public final com.tencent.mm.plugin.appbrand.page.d iGv;
  private com.tencent.mm.plugin.appbrand.l.b iGw;
  private final com.tencent.mm.plugin.appbrand.task.d iGx;
  private final Queue<Runnable> iGy;
  
  public o(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    super(paramAppBrandRuntimeContainerWC);
    AppMethodBeat.i(174681);
    if ((bu.eGT()) || (DebuggerShell.aTY()) || (com.tencent.mm.protocal.d.CpN) || (com.tencent.mm.protocal.d.CpO)) {}
    for (boolean bool = true;; bool = false)
    {
      this.iGa = bool;
      this.iGb = new com.tencent.mm.plugin.appbrand.jsapi.s.a();
      this.iGg = 0;
      this.iGi = new LinkedList();
      this.iGj = null;
      this.iGo = 9;
      this.iGr = false;
      this.iGv = com.tencent.mm.plugin.appbrand.page.d.biW();
      this.iGx = new com.tencent.mm.plugin.appbrand.task.d()
      {
        private boolean az(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(195543);
          if (o.this.iGc == null)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeController checkTokenOk with reason[%s], get NULL mRemoteController from runtime", new Object[] { paramAnonymousString });
            AppMethodBeat.o(195543);
            return true;
          }
          if (paramAnonymousInt == o.this.iGc.hashCode())
          {
            AppMethodBeat.o(195543);
            return true;
          }
          AppMethodBeat.o(195543);
          return false;
        }
        
        public final void onNetworkChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(195545);
          if (az("onNetworkChange", paramAnonymousInt))
          {
            com.tencent.mm.plugin.appbrand.networking.b localb = (com.tencent.mm.plugin.appbrand.networking.b)o.this.ab(com.tencent.mm.plugin.appbrand.networking.b.class);
            if ((localb instanceof com.tencent.mm.plugin.appbrand.networking.e)) {
              ((com.tencent.mm.plugin.appbrand.networking.e)localb).biD();
            }
          }
          AppMethodBeat.o(195545);
        }
        
        public final void qr(int paramAnonymousInt)
        {
          AppMethodBeat.i(195544);
          if (az("finish", paramAnonymousInt)) {
            o.this.finish();
          }
          AppMethodBeat.o(195544);
        }
      };
      this.iGy = new LinkedBlockingQueue();
      Assert.assertTrue("AppBrandRuntimeWC's initial context should be AppBrandRuntimePersistentContextWrapper", this.mContext instanceof com.tencent.mm.plugin.appbrand.ui.j);
      this.iGe = new m();
      this.iDV = this.iGa;
      a(paramAppBrandRuntimeContainerWC);
      AppMethodBeat.o(174681);
      return;
    }
  }
  
  private void aMV()
  {
    AppMethodBeat.i(43896);
    if (!this.iGa)
    {
      AppMethodBeat.o(43896);
      return;
    }
    try
    {
      String str = this.mAppId + ":" + ((AppBrandInitConfigWC)super.DZ()).dfM;
      this.iDA.setContentDescription(str);
      AppMethodBeat.o(43896);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(43896);
    }
  }
  
  private q aNi()
  {
    AppMethodBeat.i(160535);
    if (this.iGn != null)
    {
      localObject = this.iGn;
      AppMethodBeat.o(160535);
      return localObject;
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.service.c)super.Du();
    AppMethodBeat.o(160535);
    return localObject;
  }
  
  private void aNj()
  {
    AppMethodBeat.i(160537);
    this.iGq = bt.eGO();
    this.iGt = new HandlerThread("checkShowAdThread");
    this.iGt.start();
    this.iGs = new av(this.iGt.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(195546);
        if (o.p(o.this))
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandRuntimeWC", "checkShowAd, timeOut, already stop timer");
          AppMethodBeat.o(195546);
          return false;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "checkShowAd, timeOut, realTime:%s", new Object[] { Long.valueOf(bt.eGO() - o.q(o.this)) });
        o.r(o.this);
        o.s(o.this);
        o.t(o.this);
        AppMethodBeat.o(195546);
        return false;
      }
    }, false);
    int i = aMp();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "checkShowAd, startTimer, time:%s, threshold:%s", new Object[] { Long.valueOf(this.iGq), Integer.valueOf(i) });
    this.iGr = false;
    av localav = this.iGs;
    long l = i;
    localav.av(l, l);
    AppMethodBeat.o(160537);
  }
  
  private void aNk()
  {
    AppMethodBeat.i(163907);
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195548);
        o.this.aMn();
        o.this.aLP();
        AppMethodBeat.o(195548);
      }
    }, 0L);
    AppMethodBeat.o(163907);
  }
  
  private void aNl()
  {
    AppMethodBeat.i(160539);
    if (this.iGu != null) {
      O(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195549);
          if (o.u(o.this) != null) {
            o.u(o.this).AH();
          }
          AppMethodBeat.o(195549);
        }
      });
    }
    AppMethodBeat.o(160539);
  }
  
  private void aNn()
  {
    AppMethodBeat.i(160541);
    if (this.iGt != null)
    {
      this.iGt.quitSafely();
      this.iGt = null;
    }
    AppMethodBeat.o(160541);
  }
  
  private ICommLibReader fc(boolean paramBoolean)
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
  
  private void qo(int paramInt)
  {
    AppMethodBeat.i(43929);
    m.a(paramInt, (AppBrandInitConfigWC)super.DZ());
    AppMethodBeat.o(43929);
  }
  
  public final boolean CZ()
  {
    AppMethodBeat.i(43892);
    boolean bool = ((AppBrandInitConfigWC)super.DZ()).CZ();
    AppMethodBeat.o(43892);
    return bool;
  }
  
  protected final void Df(String paramString)
  {
    AppMethodBeat.i(43938);
    super.Df(paramString);
    if ("launch".equalsIgnoreCase(paramString))
    {
      Object localObject = new com.tencent.mm.plugin.appbrand.ad.a.d();
      ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).source = paramString;
      ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).c((com.tencent.mm.plugin.appbrand.service.c)super.Du());
      localObject = new com.tencent.mm.plugin.appbrand.ad.a.c();
      ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).source = paramString;
      ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).c((com.tencent.mm.plugin.appbrand.service.c)super.Du());
      if (!this.iDE) {
        break label116;
      }
      super.aMq();
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.N(this);
      aNl();
      try
      {
        this.iDt.getActiveRuntime().aLK().getPageView().bjI().brk();
        AppMethodBeat.o(43938);
        return;
      }
      catch (NullPointerException paramString)
      {
        label116:
        AppMethodBeat.o(43938);
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientationAndHideSplashIfNeed, reset orientation");
      super.b(null);
    }
  }
  
  public final void Dg(String paramString)
  {
    AppMethodBeat.i(195559);
    Object localObject2 = getAppConfig();
    com.tencent.mm.plugin.appbrand.s.a.c localc = getWindowAndroid();
    boolean bool1;
    if (localc != null)
    {
      bool1 = ((AppBrandInitConfigWC)super.DZ()).cfl.jbu;
      if (localObject2 == null) {
        break label233;
      }
      boolean bool2 = getAppConfig().jbu;
      if (bool1 == bool2) {
        break label233;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandRuntimeWC", "setResizableToWindow: redundancy field check fail, please call complexzeng to fix, fromAttr = [%b], fromAppJson = [%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool2) });
      bool1 = bool2;
    }
    label233:
    for (;;)
    {
      Object localObject1 = "portrait";
      if (localObject2 != null)
      {
        localObject2 = getAppConfig().aTm().jcb;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = getAppConfig().jbo.jbC;
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
      localc.setSoftOrientation((String)localObject1);
      if ((aMT()) || (CZ())) {
        bool1 = true;
      }
      localc.setResizeable(bool1);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "setResizableToWindow: stage[%s] resizable = [%b], appId = [%s]", new Object[] { paramString, Boolean.valueOf(bool1), this.mAppId });
      AppMethodBeat.o(195559);
      return;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrandRuntimeWC", "setResizableToWindow: window should not be null");
      AppMethodBeat.o(195559);
      return;
    }
  }
  
  final void Dq(String paramString)
  {
    AppMethodBeat.i(195569);
    if (this.iGs != null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "checkShowAd, stopTimer, appId:%s, reason:%s, realTime:%s", new Object[] { this.mAppId, paramString, Long.valueOf(bt.eGO() - this.iGq) });
      this.iGr = true;
      this.iGs.stopTimer();
    }
    aNn();
    AppMethodBeat.o(195569);
  }
  
  public final void Ea()
  {
    AppMethodBeat.i(43934);
    super.Ea();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] onInitBeforeComponentsInstalled, appId[%s] mPendingPermissionUpdateTasks.size=%d", new Object[] { this.mAppId, Integer.valueOf(this.iGy.size()) });
    while (!this.iGy.isEmpty()) {
      ((Runnable)this.iGy.remove()).run();
    }
    com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepPrepareRuntime);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup);
    AppMethodBeat.o(43934);
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.o Eb()
  {
    AppMethodBeat.i(43930);
    com.tencent.mm.plugin.appbrand.performance.b.I(this);
    Object localObject = ((AppStartupPerformanceReportBundle)ar(AppStartupPerformanceReportBundle.class)).kHF;
    if (!bt.gL((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      for (long l = 0L; ((Iterator)localObject).hasNext(); l = Math.max(l, ((kv_14609)((Iterator)localObject).next()).lrX)) {}
      com.tencent.mm.plugin.appbrand.performance.b.a(this, l);
    }
    if (DebuggerShell.aTY())
    {
      AppMethodBeat.o(43930);
      return null;
    }
    localObject = super.Eb();
    AppMethodBeat.o(43930);
    return localObject;
  }
  
  public final boolean Ec()
  {
    AppMethodBeat.i(205034);
    boolean bool = super.Ec();
    AppMethodBeat.o(205034);
    return bool;
  }
  
  public com.tencent.mm.plugin.appbrand.o.a Ed()
  {
    AppMethodBeat.i(43922);
    com.tencent.mm.plugin.appbrand.o.a locala = super.Ed();
    AppMethodBeat.o(43922);
    return locala;
  }
  
  public final String El()
  {
    AppMethodBeat.i(43885);
    String str = "AppBrandRuntimeWC@" + hashCode();
    AppMethodBeat.o(43885);
    return str;
  }
  
  protected final boolean J(Runnable paramRunnable)
  {
    AppMethodBeat.i(195564);
    if ((super.aMi() instanceof com.tencent.mm.plugin.appbrand.ui.u))
    {
      i(paramRunnable, 3000L);
      AppMethodBeat.o(195564);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pqS, false))
    {
      boolean bool = getAppConfig().jbt;
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandRuntimeWC", "manualHideSplash:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(195564);
      return bool;
    }
    AppMethodBeat.o(195564);
    return false;
  }
  
  public final void N(final Runnable paramRunnable)
  {
    AppMethodBeat.i(195560);
    this.iDK.a(new com.tencent.mm.plugin.appbrand.b.c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        AppMethodBeat.i(195550);
        if (com.tencent.mm.plugin.appbrand.b.b.iQN == paramAnonymousb) {
          paramRunnable.run();
        }
        AppMethodBeat.o(195550);
      }
    });
    finish();
    AppMethodBeat.o(195560);
  }
  
  public final void O(final Runnable paramRunnable)
  {
    AppMethodBeat.i(43923);
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(160526);
        if (o.this.isDestroyed())
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "startPrepareOrientation, finished appId[%s]", new Object[] { o.this.mAppId });
          AppMethodBeat.o(160526);
          return;
        }
        o.a(o.this, new com.tencent.mm.plugin.appbrand.s.a.e.a()
        {
          public final void a(e.b paramAnonymous2b, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(195540);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "startPrepareOrientation, onOrientationChanged appId[%s], orientation[%s] success[%b]", new Object[] { o.this.mAppId, paramAnonymous2b, Boolean.valueOf(paramAnonymous2Boolean) });
            if (o.8.this.iGG != null) {
              o.8.this.iGG.run();
            }
            AppMethodBeat.o(195540);
          }
        }, o.n(o.this));
        AppMethodBeat.o(160526);
      }
    }, 0L);
    AppMethodBeat.o(43923);
  }
  
  public final void P(final Runnable paramRunnable)
  {
    AppMethodBeat.i(43935);
    paramRunnable = new a(paramRunnable);
    this.iGy.add(paramRunnable);
    super.K(paramRunnable);
    AppMethodBeat.o(43935);
  }
  
  public final void a(ai paramai)
  {
    AppMethodBeat.i(43891);
    paramai = (AppBrandRuntimeContainerWC)paramai;
    super.a(paramai);
    if (paramai == null)
    {
      this.iDP = null;
      ((com.tencent.mm.plugin.appbrand.ui.j)this.mContext).setBaseContext(com.tencent.mm.sdk.platformtools.aj.getContext());
      if ((com.tencent.mm.plugin.appbrand.service.c)super.Du() != null) {
        ((com.tencent.mm.plugin.appbrand.service.c)super.Du()).a(null);
      }
      if ((com.tencent.mm.plugin.appbrand.page.u)super.aLK() != null) {
        com.tencent.mm.plugin.appbrand.page.v.c((com.tencent.mm.plugin.appbrand.page.u)super.aLK());
      }
      AppMethodBeat.o(43891);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.ui.j)this.mContext).setBaseContext(com.tencent.mm.sdk.f.a.iV(paramai.mContext));
    if ((com.tencent.mm.plugin.appbrand.service.c)super.Du() != null) {
      ((com.tencent.mm.plugin.appbrand.service.c)super.Du()).a(paramai);
    }
    com.tencent.mm.plugin.appbrand.page.ae localae = aMZ();
    if (localae != null) {
      localae.a(paramai);
    }
    this.iGl = new Configuration(AppBrandUI.G(paramai.iFa.getActivity()));
    this.iGc = new AppBrandRemoteTaskController();
    this.iGc.a(paramai.iFa, this.iGx);
    AppMethodBeat.o(43891);
  }
  
  public final void a(ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(43888);
    if (fc(false) != null)
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
    Object localObject = (AppBrandInitConfigWC)super.DZ();
    super.a(paramAppBrandInitConfig);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "load launchMode change need reload , before:%d load:%d", new Object[] { Integer.valueOf(((AppBrandInitConfigWC)localObject).launchMode), Integer.valueOf(((AppBrandInitConfigWC)super.DZ()).launchMode) });
    if (((AppBrandInitConfigWC)super.DZ()).launchMode != ((AppBrandInitConfigWC)localObject).launchMode) {
      aMc();
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "updateConfig %s, willRestart[%b], willRelaunch[%b], destroyed[%b], scene[%d]", new Object[] { this.mAppId, Boolean.valueOf(this.iDM), Boolean.valueOf(this.iDN), Boolean.valueOf(isDestroyed()), Integer.valueOf(DZ().cfo.scene) });
    OpenBusinessViewUtil.D(this);
    if ((!this.iDM) && (!isDestroyed()))
    {
      com.tencent.mm.plugin.appbrand.report.quality.f.a(this, true, com.tencent.mm.plugin.appbrand.utils.a.Nj(((AppBrandInitConfigWC)super.DZ()).jdr));
      com.tencent.mm.plugin.t.a.b(this.mAppId, ((AppBrandInitConfigWC)super.DZ()).jdo);
      paramAppBrandInitConfig = this.iGi.iterator();
      while (paramAppBrandInitConfig.hasNext()) {
        ((ah)paramAppBrandInitConfig.next()).c((AppBrandInitConfigWC)super.DZ());
      }
      if ((com.tencent.mm.plugin.appbrand.page.u)super.aLK() != null)
      {
        paramAppBrandInitConfig = (com.tencent.mm.plugin.appbrand.page.u)super.aLK();
        paramAppBrandInitConfig.getReporter().resetSession();
        paramAppBrandInitConfig.kZZ = false;
        paramAppBrandInitConfig.laa = false;
        paramAppBrandInitConfig.lab = false;
      }
      paramAppBrandInitConfig = (AppBrandInitConfigWC)super.DZ();
      localObject = aNb();
      AppBrandStatObject localAppBrandStatObject = DZ().cfo;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandTaskUsageRecorder", "updateUsage, appId %s, type %d", new Object[] { paramAppBrandInitConfig.appId, Integer.valueOf(paramAppBrandInitConfig.iOP) });
      String str = paramAppBrandInitConfig.Da();
      AppBrandMainProcessService.a(new AppBrandTaskUsageRecorder.UpdateTask(new AppBrandTaskUsageRecorder.LaunchCheckParams(paramAppBrandInitConfig, localAppBrandStatObject, ((AppBrandSysConfigWC)localObject).jdS.pkgVersion, fc(false).aPc(), str, paramAppBrandInitConfig.jdu)));
    }
    aMV();
    AppMethodBeat.o(43924);
  }
  
  public final ICommLibReader aLC()
  {
    AppMethodBeat.i(205030);
    ICommLibReader localICommLibReader = fc(false);
    AppMethodBeat.o(205030);
    return localICommLibReader;
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.v aLO()
  {
    AppMethodBeat.i(43928);
    Object localObject;
    if (CZ())
    {
      localObject = com.tencent.mm.plugin.appbrand.game.preload.e.aWX();
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pkV, false) != true) {
        break label295;
      }
      i = 1;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jsE = i;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WAGamePreloadStatisManager", "misPreload:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jsE) });
      AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.DZ();
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jsz = localAppBrandInitConfigWC.appId;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jsA = localAppBrandInitConfigWC.aAS;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jsB = localAppBrandInitConfigWC.iOP;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jsC = (localAppBrandInitConfigWC.cfd + 1000);
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jsD = localAppBrandInitConfigWC.jdu.kGa;
      switch (((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jsB)
      {
      default: 
        label156:
        if (DZ().cfo != null) {
          ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).mScene = DZ().cfo.scene;
        }
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pqS, false) != true) {
          break;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jsG = i;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WAGamePreloadStatisManager", "mHasSplashScreen:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jsG) });
      localObject = com.tencent.mm.plugin.appbrand.ui.g.a(com.tencent.mm.sdk.f.a.iV(this.mContext), this);
      ((com.tencent.mm.plugin.appbrand.ui.v)localObject).dB(((AppBrandInitConfigWC)super.DZ()).iconUrl, ((AppBrandInitConfigWC)super.DZ()).dfM);
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.ui.x)) {
        ((com.tencent.mm.plugin.appbrand.ui.x)localObject).setCanShowHideAnimation(false);
      }
      AppMethodBeat.o(43928);
      return localObject;
      label295:
      i = 0;
      break;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jsB = 1;
      break label156;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jsB = 2;
      break label156;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jsB = 3;
      break label156;
    }
  }
  
  protected final void aLQ()
  {
    AppMethodBeat.i(195563);
    super.aLQ();
    com.tencent.mm.plugin.appbrand.report.quality.a.L(this);
    AppMethodBeat.o(195563);
  }
  
  protected final void aLU()
  {
    AppMethodBeat.i(43910);
    super.aLU();
    String str = toString();
    Object localObject = this.iDX;
    if ((localObject != null) && (((Collection)localObject).size() > 0)) {
      localObject = ((Collection)localObject).iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, process[%s]", new Object[] { str, ((AppBrandRuntime.b)((Iterator)localObject).next()).toString() });
      continue;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, no pending processes", new Object[] { str });
    }
    qo(11);
    com.tencent.mm.plugin.appbrand.keylogger.c.c(this.mAppId, KSProcessWeAppLaunch.stepPrepareResourceTimeout);
    AppMethodBeat.o(43910);
  }
  
  protected final void aLV()
  {
    AppMethodBeat.i(43908);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] onPostInit appId[%s]", new Object[] { this.mAppId });
    MMToClientEvent.e((com.tencent.mm.plugin.appbrand.service.c)super.Du());
    if (((com.tencent.mm.plugin.appbrand.service.c)super.Du()).aLC().compareTo(fc(false)) != 0)
    {
      localObject = new IllegalStateException(String.format(Locale.ENGLISH, "onPostInit appId[%s] mismatch libReader, self[%s] service[%s]", new Object[] { this.mAppId, fc(false).aPa(), ((com.tencent.mm.plugin.appbrand.service.c)super.Du()).aLC().aPa() }));
      AppMethodBeat.o(43908);
      throw ((Throwable)localObject);
    }
    super.aLV();
    Object localObject = (AppBrandInitConfigWC)super.DZ();
    this.iGe.F(0, System.currentTimeMillis() - ((AppBrandInitConfigWC)localObject).startTime);
    com.tencent.mm.plugin.appbrand.performance.c.b(this.mAppId, "ActivityCreate", ((AppBrandInitConfigWC)super.DZ()).startTime, System.currentTimeMillis());
    MMToClientEvent.a(this.mAppId, new MMToClientEvent.c()
    {
      public final void ch(Object paramAnonymousObject)
      {
        AppMethodBeat.i(195557);
        if ((paramAnonymousObject instanceof AppBrandAuthorizeUI.AuthStateChangedByUserEvent))
        {
          com.tencent.mm.plugin.appbrand.permission.d.Mf(o.this.mAppId);
          AppBrandBackgroundRunningMonitor.a(o.this, (AppBrandAuthorizeUI.AuthStateChangedByUserEvent)paramAnonymousObject);
        }
        AppMethodBeat.o(195557);
      }
    });
    MMToClientEvent.a(this.mAppId, new MMToClientEvent.c()
    {
      public final void ch(Object paramAnonymousObject)
      {
        AppMethodBeat.i(195527);
        if (((paramAnonymousObject instanceof EventLocationBackgroundStateChanged)) && (!((EventLocationBackgroundStateChanged)paramAnonymousObject).iXN))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "locationBackgroundStateChanged, not listening, appId[%s]", new Object[] { o.this.mAppId });
          o.this.iDK.iQP.a(d.a.iRr);
        }
        AppMethodBeat.o(195527);
      }
    });
    new com.tencent.mm.plugin.appbrand.report.e.a(this, (byte)0);
    this.iGe.F(8, System.currentTimeMillis() - ((AppBrandInitConfigWC)super.DZ()).startTime);
    qo(2);
    com.tencent.mm.plugin.appbrand.jsapi.aa.b.c.a((com.tencent.mm.plugin.appbrand.g.b)ab(com.tencent.mm.plugin.appbrand.g.b.class), (com.tencent.mm.plugin.appbrand.g.a)ab(com.tencent.mm.plugin.appbrand.g.a.class), (com.tencent.mm.plugin.appbrand.service.c)super.Du());
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.VideoCanvas.XWebVideoCanvasLogic", "init");
    localObject = com.tencent.mm.plugin.appbrand.j.a.aVW();
    SkiaCanvasExternalTextureManager.getInstance().registerPlugin((SkiaCanvasExternalTexturePlugin)localObject);
    localObject = this.iDT;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.page.aj)localObject).ldk = com.tencent.mm.plugin.appbrand.report.g.lpr;
    }
    AppMethodBeat.o(43908);
  }
  
  protected q aLW()
  {
    AppMethodBeat.i(43901);
    Object localObject2;
    Object localObject1;
    if (super.Ec()) {
      if (CZ())
      {
        localObject2 = com.tencent.mm.plugin.appbrand.task.c.c(com.tencent.mm.plugin.appbrand.task.e.gW(true));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (this.iGk != null) {
            localObject1 = this.iGk.aMv();
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
      com.tencent.mm.plugin.appbrand.report.quality.a.ME(this.mAppId).ltN = com.tencent.mm.plugin.appbrand.report.quality.i.ltg;
      continue;
      localObject1 = new com.tencent.mm.plugin.appbrand.service.c(com.tencent.luggage.sdk.b.a.c.h.chL);
      continue;
      if (this.iGk != null)
      {
        localObject1 = this.iGk.aMv();
        if (localObject1 != null)
        {
          String str = this.mAppId;
          if (!CZ()) {
            break label260;
          }
          localObject2 = "WAGame";
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "[%s][%s] [applaunch] [preload] createService preloaded, reason=%s", new Object[] { str, localObject2, com.tencent.mm.plugin.appbrand.report.quality.a.ME(this.mAppId).ltN.name() });
        }
        if (localObject1 != null) {
          break label303;
        }
        localObject2 = this.mAppId;
        if (!CZ()) {
          break label267;
        }
      }
      for (localObject1 = "WAGame";; localObject1 = "WAService")
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "[%s][%s] [applaunch] [preload] createService got no preloaded", new Object[] { localObject2, localObject1 });
        if (((!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.DEBUG) && (!DebuggerShell.aTY())) || (!com.tencent.mm.plugin.appbrand.task.a.bnl())) {
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
      if (CZ()) {
        localObject1 = new com.tencent.mm.plugin.appbrand.game.c();
      } else {
        localObject1 = new com.tencent.mm.plugin.appbrand.service.c();
      }
    }
  }
  
  protected com.tencent.mm.plugin.appbrand.page.t aLX()
  {
    AppMethodBeat.i(43902);
    try
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.ME(this.mAppId).ltP = bt.eGO();
      label19:
      if (CZ()) {}
      com.tencent.mm.plugin.appbrand.page.ae localae;
      for (Object localObject1 = new com.tencent.mm.plugin.appbrand.game.f.c(com.tencent.mm.sdk.f.a.iV(this.mContext), this);; localObject1 = new com.tencent.mm.plugin.appbrand.page.u(com.tencent.mm.sdk.f.a.iV(this.mContext), this))
      {
        ((com.tencent.mm.plugin.appbrand.page.u)localObject1).setDecorWidgetFactory(this.iGv);
        if (!CZ()) {
          ((com.tencent.mm.plugin.appbrand.page.u)localObject1).setNavigateInterceptor(new com.tencent.mm.plugin.appbrand.page.c.b());
        }
        if (this.iGk == null) {
          break label220;
        }
        localae = this.iGk.aMw();
        if ((localae == null) || (localae == null) || (((com.tencent.mm.plugin.appbrand.page.u)localObject1).getRuntime() == null)) {
          break label220;
        }
        if (localae.aLC().compareTo(((com.tencent.mm.plugin.appbrand.page.u)localObject1).getRuntime().fc(false)) == 0) {
          break;
        }
        localObject1 = new IllegalStateException(String.format(Locale.ENGLISH, "stashPreloadedPageView appId[%s] mismatch libReader, runtime[%s] page[%s]", new Object[] { ((com.tencent.mm.plugin.appbrand.page.u)localObject1).getAppId(), ((com.tencent.mm.plugin.appbrand.page.u)localObject1).getRuntime().fc(false).aPa(), localae.aLC().aPa() }));
        AppMethodBeat.o(43902);
        throw ((Throwable)localObject1);
      }
      synchronized (((com.tencent.mm.plugin.appbrand.page.u)localObject1).lah)
      {
        ((com.tencent.mm.plugin.appbrand.page.u)localObject1).lah.addLast(localae);
        label220:
        AppMethodBeat.o(43902);
        return localObject1;
      }
    }
    catch (Throwable localThrowable)
    {
      break label19;
    }
  }
  
  public final boolean aLY()
  {
    AppMethodBeat.i(43904);
    if (CZ())
    {
      AppMethodBeat.o(43904);
      return false;
    }
    if (com.tencent.mm.protocal.d.CpK <= 654314239)
    {
      AppMethodBeat.o(43904);
      return false;
    }
    if ((!com.tencent.mm.protocal.d.CpL) || (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.png, false)))
    {
      AppMethodBeat.o(43904);
      return true;
    }
    AppMethodBeat.o(43904);
    return false;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.d aMQ()
  {
    return this.iGv;
  }
  
  public final com.tencent.mm.plugin.appbrand.floatball.c aMR()
  {
    if (this.iGm != null) {
      return this.iGm.jpd;
    }
    return null;
  }
  
  public com.tencent.mm.plugin.appbrand.l.b aMS()
  {
    AppMethodBeat.i(174683);
    if ((this.iGw == null) && (!isDestroyed())) {
      this.iGw = new o.1(this);
    }
    com.tencent.mm.plugin.appbrand.l.b localb = this.iGw;
    AppMethodBeat.o(174683);
    return localb;
  }
  
  public final boolean aMT()
  {
    AppMethodBeat.i(43893);
    boolean bool = ((AppBrandInitConfigWC)super.DZ()).jdl;
    AppMethodBeat.o(43893);
    return bool;
  }
  
  public final boolean aMU()
  {
    AppMethodBeat.i(43894);
    boolean bool = ((AppBrandInitConfigWC)super.DZ()).jdi;
    AppMethodBeat.o(43894);
    return bool;
  }
  
  public final void aMW()
  {
    AppMethodBeat.i(43898);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "callSuperClose appId:%s", new Object[] { this.mAppId });
    super.close();
    AppMethodBeat.o(43898);
  }
  
  protected final void aMX()
  {
    AppMethodBeat.i(43905);
    b(com.tencent.mm.plugin.appbrand.networking.a.class, com.tencent.mm.plugin.appbrand.networking.f.kWl);
    b(com.tencent.mm.plugin.appbrand.permission.g.class, new com.tencent.mm.plugin.appbrand.permission.j(this));
    b(com.tencent.mm.plugin.appbrand.permission.h.class, com.tencent.mm.plugin.appbrand.permission.l.ljg);
    b(com.tencent.mm.plugin.appbrand.jsapi.media.d.class, com.tencent.mm.plugin.appbrand.jsapi.media.o.jYz);
    ac(com.tencent.mm.plugin.appbrand.networking.b.class);
    b(com.tencent.mm.plugin.appbrand.networking.b.class, new com.tencent.mm.plugin.appbrand.networking.e(this));
    b(com.tencent.mm.plugin.appbrand.jsapi.base.f.class, new aa());
    b(com.tencent.mm.plugin.appbrand.widget.h.class, com.tencent.mm.plugin.appbrand.widget.i.lQw);
    b(com.tencent.mm.plugin.appbrand.jsapi.v.b.class, com.tencent.mm.plugin.appbrand.luggage.b.c.kPe);
    b(com.tencent.luggage.sdk.f.a.class, com.tencent.mm.plugin.appbrand.app.e.iJN);
    b(bc.class, new ak(this));
    b(com.tencent.mm.plugin.appbrand.jsapi.media.a.a.class, new com.tencent.mm.plugin.appbrand.jsapi.media.a.a()
    {
      public final void a(Context paramAnonymousContext, Runnable paramAnonymousRunnable1, Runnable paramAnonymousRunnable2)
      {
        AppMethodBeat.i(195552);
        if (!com.tencent.mm.plugin.appbrand.utils.aa.Be())
        {
          o.this.i(new o.19.1(this, paramAnonymousContext, paramAnonymousRunnable1, paramAnonymousRunnable2), 0L);
          AppMethodBeat.o(195552);
          return;
        }
        com.tencent.mm.platformtools.p.a(paramAnonymousContext, paramAnonymousRunnable1, paramAnonymousRunnable2);
        AppMethodBeat.o(195552);
      }
    });
    n.Dl(this.mAppId);
    AppMethodBeat.o(43905);
  }
  
  protected final void aMY()
  {
    AppMethodBeat.i(43907);
    o localo = a.CR(this.mAppId);
    if ((localo != null) && (this != localo))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "clearDuplicatedInstanceOnAppCreate duplicated[%d] this[%d]", new Object[] { Integer.valueOf(localo.hashCode()), Integer.valueOf(hashCode()) });
      localo.aNg();
    }
    this.iGc.MH(this.mAppId);
    AppMethodBeat.o(43907);
  }
  
  public com.tencent.mm.plugin.appbrand.page.ae aMZ()
  {
    AppMethodBeat.i(195561);
    if ((com.tencent.mm.plugin.appbrand.page.u)super.aLK() == null)
    {
      AppMethodBeat.o(195561);
      return null;
    }
    if (((com.tencent.mm.plugin.appbrand.page.u)super.aLK()).getCurrentPage() == null)
    {
      AppMethodBeat.o(195561);
      return null;
    }
    com.tencent.mm.plugin.appbrand.page.ae localae = (com.tencent.mm.plugin.appbrand.page.ae)((com.tencent.mm.plugin.appbrand.page.u)super.aLK()).getCurrentPage().getCurrentPageView();
    AppMethodBeat.o(195561);
    return localae;
  }
  
  protected final void aMb()
  {
    AppMethodBeat.i(43916);
    MMToClientEvent.e((com.tencent.mm.plugin.appbrand.service.c)super.Du());
    this.iGc.a(this.mAppId, ((AppBrandInitConfigWC)super.DZ()).iOP, com.tencent.mm.plugin.appbrand.task.e.i((AppBrandInitConfigWC)super.DZ()));
    AppMethodBeat.o(43916);
  }
  
  public final void aMg()
  {
    AppMethodBeat.i(174684);
    if (com.tencent.mm.plugin.appbrand.ui.m.ar(this))
    {
      AppMethodBeat.o(174684);
      return;
    }
    super.aMg();
    AppMethodBeat.o(174684);
  }
  
  public final boolean aMh()
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
  
  public final com.tencent.mm.plugin.appbrand.ui.v aMi()
  {
    AppMethodBeat.i(195562);
    com.tencent.mm.plugin.appbrand.ui.v localv = super.aMi();
    AppMethodBeat.o(195562);
    return localv;
  }
  
  protected final void aMj()
  {
    AppMethodBeat.i(160542);
    super.aMj();
    com.tencent.mm.plugin.appbrand.ad.a.b localb = new com.tencent.mm.plugin.appbrand.ad.a.b();
    localb.source = "launch";
    localb.type = "close";
    localb.c(aNi());
    if (aMm() != null) {
      aMm().h(true, "launch");
    }
    AppMethodBeat.o(160542);
  }
  
  public final void aNa()
  {
    AppMethodBeat.i(43915);
    this.iGc.MG(this.mAppId);
    AppMethodBeat.o(43915);
  }
  
  public final AppBrandSysConfigWC aNb()
  {
    AppMethodBeat.i(43918);
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)c(AppBrandSysConfigWC.class, false);
    AppMethodBeat.o(43918);
    return localAppBrandSysConfigWC;
  }
  
  public final AppBrandInitConfigWC aNc()
  {
    AppMethodBeat.i(205031);
    AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.DZ();
    AppMethodBeat.o(205031);
    return localAppBrandInitConfigWC;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.u aNd()
  {
    AppMethodBeat.i(205032);
    com.tencent.mm.plugin.appbrand.page.u localu = (com.tencent.mm.plugin.appbrand.page.u)super.aLK();
    AppMethodBeat.o(205032);
    return localu;
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c aNe()
  {
    AppMethodBeat.i(205033);
    com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)super.Du();
    AppMethodBeat.o(205033);
    return localc;
  }
  
  public final void aNf()
  {
    int k = 0;
    AppMethodBeat.i(43931);
    AppBrandSysConfigWC localAppBrandSysConfigWC = aNb();
    com.tencent.mm.plugin.appbrand.config.m.bi(this.mAppId, localAppBrandSysConfigWC.cfO);
    com.tencent.mm.plugin.appbrand.config.m.bj(this.mAppId, localAppBrandSysConfigWC.cfP);
    Object localObject3 = this.iDG;
    Object localObject4 = DZ();
    AppBrandSysConfigLU localAppBrandSysConfigLU = DY();
    Object localObject1 = getAppConfig();
    com.tencent.mm.plugin.appbrand.q.a locala = new com.tencent.mm.plugin.appbrand.q.a();
    int i;
    label121:
    Object localObject2;
    if ((((AppBrandInitConfigLU)localObject4).CW()) || (((AppBrandInitConfigLU)localObject4).CZ()))
    {
      m = 1;
      locala.kUn = m;
      if ((localAppBrandSysConfigLU.jdS.iOQ != 1) && (localAppBrandSysConfigLU.jdS.iOQ != 2)) {
        break label1071;
      }
      i = 1;
      if (!localAppBrandSysConfigLU.cfe) {
        break label1081;
      }
      if ((i != 0) && (localAppBrandSysConfigLU.cft)) {
        break label1076;
      }
      m = 1;
      label143:
      locala.kUo = m;
      i = com.tencent.mm.plugin.appbrand.config.e.r(new int[] { localAppBrandSysConfigLU.cfR.jcr.jcX, ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jbn.dDq });
      if (i > 0) {
        locala.kUp = i;
      }
      i = com.tencent.mm.plugin.appbrand.config.e.r(new int[] { localAppBrandSysConfigLU.cfR.jcr.jcU, ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jbn.jbE });
      if (i > 0) {
        locala.kUq = i;
      }
      i = com.tencent.mm.plugin.appbrand.config.e.r(new int[] { localAppBrandSysConfigLU.cfR.jcr.jcV, ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jbn.jbF });
      if (i > 0) {
        locala.kUr = i;
      }
      i = com.tencent.mm.plugin.appbrand.config.e.r(new int[] { localAppBrandSysConfigLU.cfR.jcr.jcW, ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jbn.jbG });
      if (i > 0) {
        locala.kUs = i;
      }
      locala.cfy = localAppBrandSysConfigLU.cfy;
      locala.kUt = localAppBrandSysConfigLU.cfB;
      locala.cfz = localAppBrandSysConfigLU.cfz;
      locala.cfA = localAppBrandSysConfigLU.cfA;
      locala.cfH = localAppBrandSysConfigLU.cfH;
      locala.cfI = localAppBrandSysConfigLU.cfI;
      locala.cfJ = localAppBrandSysConfigLU.cfJ;
      locala.cfK = localAppBrandSysConfigLU.cfK;
      locala.cfL = localAppBrandSysConfigLU.cfL;
      if (localAppBrandSysConfigLU.cfR.jcr.mode != 1) {
        break label1103;
      }
      if (localAppBrandSysConfigLU.cfR.jcr.jcS != null) {
        locala.kUu = localAppBrandSysConfigLU.cfR.jcr.jcS;
      }
      label452:
      locala.mode = localAppBrandSysConfigLU.cfR.jcr.mode;
      locala.kUw = com.tencent.mm.plugin.appbrand.config.e.W(this);
      if (!((AppBrandInitConfigLU)localObject4).CZ()) {
        break label1151;
      }
      i = localAppBrandSysConfigLU.cfR.jcD;
      label494:
      locala.jcl = i;
      locala.cfD = localAppBrandSysConfigLU.cfD;
      locala.cfE = localAppBrandSysConfigLU.cfE;
      localObject2 = com.tencent.mm.plugin.appbrand.config.i.aTB();
      locala.kUx = com.tencent.mm.plugin.appbrand.aa.o.a(com.tencent.mm.sdk.platformtools.aj.getContext(), (String)localObject2, (com.tencent.mm.plugin.appbrand.aa.o.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.aa.o.a.class));
      com.tencent.mm.sdk.platformtools.ad.i("Luggage.FULL.AppBrandConfigAdapter", "runtime(%s).getNetworkConfig.userAgentString = [ %s ]", new Object[] { this.mAppId, locala.kUx });
      localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.q.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.q.a.class);
      if (localObject2 == null) {
        break label1163;
      }
      locala.kUy = ((com.tencent.mm.plugin.appbrand.jsapi.q.a)localObject2).IU(((com.tencent.mm.plugin.appbrand.config.a)localObject1).gSZ);
      label608:
      localObject2 = "";
      localObject1 = localObject2;
      if (localAppBrandSysConfigLU.cfR != null)
      {
        localObject1 = localObject2;
        if (localAppBrandSysConfigLU.cfR.jcr != null) {
          localObject1 = localAppBrandSysConfigLU.cfR.jcr.jcY;
        }
      }
      localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1)) {
        localObject2 = "servicewechat.com";
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(localAppBrandSysConfigLU.appId);
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(localAppBrandSysConfigLU.jdS.pkgVersion);
      ((StringBuilder)localObject1).append("/page-frame.html");
      locala.referer = ((StringBuilder)localObject1).toString();
      locala.cfe = ((AppBrandInitConfigLU)localObject4).cfe;
      locala.kUz = j.a.nz(localAppBrandSysConfigLU.jdS.iOQ);
      if ((locala.kUz) || (!bt.gL(locala.kUw))) {
        com.tencent.mm.plugin.appbrand.q.j.b(locala);
      }
      ((Collection)localObject3).add(locala);
      this.iDG.add(com.tencent.mm.plugin.appbrand.config.e.a(localAppBrandSysConfigWC));
      localObject1 = this.iDG;
      localObject2 = new v.a();
      ((v.a)localObject2).jcA = localAppBrandSysConfigWC.cfR.jcA;
      ((Collection)localObject1).add(localObject2);
      localObject1 = this.iDG;
      localObject2 = DY();
      localObject3 = getAppConfig();
      localObject4 = new com.tencent.mm.plugin.appbrand.b.a();
      if ((localObject2 != null) && (localObject3 != null)) {
        break label1175;
      }
      label909:
      ((Collection)localObject1).add(localObject4);
      localObject1 = new com.tencent.mm.plugin.appbrand.performance.a();
      if ((!localAppBrandSysConfigWC.cfr) || ((localAppBrandSysConfigWC.jdS.iOQ != 1) && (localAppBrandSysConfigWC.jdS.iOQ != 2) && (!bu.eGT()))) {
        break label1251;
      }
      m = 1;
      label968:
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject1).lhw = m;
      if (localAppBrandSysConfigWC.jdS.iOQ == 0) {
        break label1256;
      }
    }
    label1071:
    label1076:
    label1081:
    label1103:
    label1251:
    label1256:
    for (int m = 1;; m = 0)
    {
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject1).lhx = m;
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject1).lhy = localAppBrandSysConfigWC.cfq;
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject1).lhw |= DebuggerShell.aTY();
      m = ((com.tencent.mm.plugin.appbrand.performance.a)localObject1).lhx;
      if (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)
      {
        i = k;
        if (!bu.eGT()) {}
      }
      else
      {
        i = 1;
      }
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject1).lhx = (m | i);
      this.iDG.add(localObject1);
      AppMethodBeat.o(43931);
      return;
      m = 0;
      break;
      int j = 0;
      break label121;
      m = 0;
      break label143;
      if ((j == 0) || (!localAppBrandSysConfigLU.cfq))
      {
        m = 1;
        break label143;
      }
      m = 0;
      break label143;
      if ((localAppBrandSysConfigLU.cfR.jcr.mode != 2) || (localAppBrandSysConfigLU.cfR.jcr.jcT == null)) {
        break label452;
      }
      locala.kUv = localAppBrandSysConfigLU.cfR.jcr.jcT;
      break label452;
      label1151:
      j = localAppBrandSysConfigLU.cfR.jcl;
      break label494;
      com.tencent.mm.sdk.platformtools.ad.w("", "getNetworkConfig, referrerHelper is null");
      break label608;
      if (j.a.nz(((com.tencent.mm.plugin.appbrand.config.k)localObject2).jdS.iOQ))
      {
        ((com.tencent.mm.plugin.appbrand.b.a)localObject4).iQI = ((com.tencent.mm.plugin.appbrand.config.a)localObject3).jbq.contains("audio");
        ((com.tencent.mm.plugin.appbrand.b.a)localObject4).iQJ = ((com.tencent.mm.plugin.appbrand.config.a)localObject3).jbq.contains("location");
        break label909;
      }
      ((com.tencent.mm.plugin.appbrand.b.a)localObject4).iQI = ((AppBrandSysConfigLU)localObject2).jdM;
      ((com.tencent.mm.plugin.appbrand.b.a)localObject4).iQJ = ((AppBrandSysConfigLU)localObject2).jdN;
      break label909;
      m = 0;
      break label968;
    }
  }
  
  public final void aNg()
  {
    AppMethodBeat.i(43933);
    this.iDR = false;
    if (this.iDt != null) {
      this.iDt.F(this);
    }
    finish();
    if ((this.iDt instanceof AppBrandRuntimeContainerWC)) {
      ((AppBrandRuntimeContainerWC)this.iDt).DT();
    }
    AppMethodBeat.o(43933);
  }
  
  protected void aNh()
  {
    AppMethodBeat.i(174689);
    k localk = this.iGk;
    if (localk != null)
    {
      if (localk.iEH == null)
      {
        localk.aMt();
        AppMethodBeat.o(174689);
        return;
      }
      localk.iEH.a(com.tencent.mm.vending.h.d.HQM, new k.5(localk)).a(com.tencent.mm.vending.h.d.HQM, new k.4(localk));
    }
    AppMethodBeat.o(174689);
  }
  
  public final boolean aNm()
  {
    if (this.iGu != null) {
      return this.iGu.bOR;
    }
    return false;
  }
  
  public final int aNo()
  {
    AppMethodBeat.i(163908);
    if ((AppBrandInitConfigWC)super.DZ() != null)
    {
      int i = ((AppBrandInitConfigWC)super.DZ()).jdx;
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
    AppBrandStatObject localAppBrandStatObject = paramAppBrandInitConfig.cfo;
    boolean bool;
    if ((this.iGh) || (localAppBrandStatObject.scene == 1099))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] mShouldRelaunchCausedByFunctionalPageOpen[%b] newScene[%d]", new Object[] { this.mAppId, Boolean.valueOf(this.iGh), Integer.valueOf(localAppBrandStatObject.scene) });
      if (localAppBrandStatObject.scene == 1099) {}
      for (bool = true;; bool = false)
      {
        this.iGh = bool;
        AppMethodBeat.o(43925);
        return true;
      }
    }
    if ((TextUtils.isEmpty(paramAppBrandInitConfig.iJb)) && (ae.v(this)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] enterPath[%s], old is gameFunctionalPage", new Object[] { this.mAppId, paramAppBrandInitConfig.iJb });
      AppMethodBeat.o(43925);
      return true;
    }
    if (1038 == localAppBrandStatObject.scene)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. appId[%s], reason=1038 back from other MiniProgram", new Object[] { this.mAppId });
      AppMethodBeat.o(43925);
      return false;
    }
    Iterator localIterator = this.iGi.iterator();
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
    if (!TextUtils.isEmpty(paramAppBrandInitConfig.iJb))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] enterPath[%s]", new Object[] { this.mAppId, paramAppBrandInitConfig.iJb });
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
    if ((1030 == localAppBrandStatObject.scene) && (TextUtils.isEmpty(paramAppBrandInitConfig.iJb)))
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
    Runnable local12;
    com.tencent.mm.plugin.appbrand.widget.dialog.f localf;
    int j;
    int i;
    for (;;)
    {
      try
      {
        if (g.Dd(this.mAppId) == g.d.iDc)
        {
          localObject1 = (com.tencent.mm.plugin.appbrand.game.f.a)((com.tencent.mm.plugin.appbrand.page.u)super.aLK()).getPageView().Q(com.tencent.mm.plugin.appbrand.game.f.a.class);
          if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.game.f.a)localObject1).aWK() != null))
          {
            localObject1 = ((com.tencent.mm.plugin.appbrand.game.f.a)localObject1).aWK();
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: triggerMakeCanvasBitmap");
            if ((((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).jru != null) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).aWM() != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).jru.EJw)) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).jru.EJo) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).jrw != null)) {
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
        local12 = new Runnable()
        {
          public final void run()
          {
            boolean bool = true;
            AppMethodBeat.i(43873);
            if (o.f(o.this) != null)
            {
              com.tencent.mm.plugin.appbrand.floatball.d locald = o.f(o.this);
              o localo = o.this;
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandFloatBallLogic", "close, runtime:%s", new Object[] { localo.mAppId });
              int i = com.tencent.mm.plugin.appbrand.floatball.c.b(g.Dd(localo.mAppId));
              if (locald.jpf != null) {
                if (locald.jpf.aWn()) {
                  locald.jpf.a(com.tencent.mm.sdk.f.a.iV(localo.mContext), new com.tencent.mm.plugin.appbrand.floatball.d.2(locald, i));
                }
              }
              while (bool)
              {
                AppMethodBeat.o(43873);
                return;
                bool = locald.ri(i);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandFloatBallLogic", "close, not show voip tip, result:%s", new Object[] { Boolean.valueOf(bool) });
                continue;
                bool = locald.ri(i);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandFloatBallLogic", "close, result:%s", new Object[] { Boolean.valueOf(bool) });
              }
            }
            o.this.aMW();
            AppMethodBeat.o(43873);
          }
        };
        localf = new com.tencent.mm.plugin.appbrand.widget.dialog.f((com.tencent.mm.plugin.appbrand.service.c)super.Du());
        if (localf.jpK != null) {
          break;
        }
      }
      OpenBusinessViewUtil.E(this);
      if ((aMT()) || (ae.v(this)))
      {
        super.close();
        AppMethodBeat.o(43897);
        return;
        if (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).aWN()) {
          ((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).aWM().Co();
        }
      }
      else
      {
        j = 0;
        if ((this != null) && (aNb() != null) && (com.tencent.mm.sdk.f.a.iV(this.mContext) != null)) {
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
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1237L, 2L, 1L, false);
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
      Object localObject2 = localf.jpK.loE;
      if ((localObject2 == null) || (((dwv)localObject2).EKM == null) || (((dwv)localObject2).EKM.size() < 3))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: no config");
        j = 0;
        break;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1237L, 0L, 1L, false);
      long l1 = n.Do(this.mAppId).lastResumeTime;
      localf.kve = ((int)(System.currentTimeMillis() - l1));
      if (localf.kve < ((dwv)localObject2).EKO * 1000)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: time limit");
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1237L, 1L, 1L, false);
        j = 0;
        break;
      }
      j = 1;
      break;
      label482:
      localObject2 = aNb();
      if (!((AppBrandSysConfigWC)localObject2).jdW)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "can not show evaluate dialog");
        i = 0;
        break label300;
      }
      l1 = n.Do(this.mAppId).lastResumeTime;
      long l2 = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "app time lastResumeTime:%s, closeTime:%s, leastTime:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(((AppBrandSysConfigWC)localObject2).jdY) });
      if ((l2 - l1) / 1000L < ((AppBrandSysConfigWC)localObject2).jdY)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "time not enough to show evaluate dialog");
        i = 0;
        break label300;
      }
      Object localObject5 = (AppBrandInitConfigWC)super.DZ();
      localf.userName = ((AppBrandInitConfigWC)localObject5).username;
      if (bt.isNullOrNil(localf.userName))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "username is null, can not show evaluate dialog");
        i = 0;
        break label300;
      }
      Object localObject3 = com.tencent.mm.sdk.f.a.iV(this.mContext);
      Object localObject4 = ((AppBrandInitConfigWC)localObject5).appId;
      Object localObject6 = ((AppBrandInitConfigWC)localObject5).dfM;
      boolean bool = ((AppBrandSysConfigWC)localObject2).jdX;
      localf.dialog = com.tencent.mm.plugin.appbrand.widget.dialog.f.u((Context)localObject3, true);
      localObject5 = (LinearLayout)LayoutInflater.from(localf.dialog.getContext()).inflate(2131492994, null, false);
      localf.dialog.setContentView((View)localObject5);
      Object localObject7 = com.tencent.mm.ui.ai.cf(localf.dialog.getContext());
      i = Math.min(((Point)localObject7).x, ((Point)localObject7).y);
      localObject7 = new FrameLayout.LayoutParams(i, -2);
      ((FrameLayout.LayoutParams)localObject7).gravity = 1;
      ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject7);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "createEvaluateDialog, dialog width:%d", new Object[] { Integer.valueOf(i) });
      localf.KCZ = ((TextView)localf.dialog.findViewById(2131299532));
      localf.KDa = ((LinearLayout)localf.dialog.findViewById(2131299533));
      localf.KDb = ((LinearLayout)localf.dialog.findViewById(2131299530));
      localObject7 = (TextView)localf.dialog.findViewById(2131299529);
      if (bool)
      {
        ((TextView)localObject7).setVisibility(0);
        ((TextView)localObject7).setOnClickListener(new f.15(localf, (Context)localObject3, (String)localObject4, (String)localObject6));
        label892:
        ((TextView)localf.dialog.findViewById(2131299536)).setOnClickListener(new f.16(localf, (Context)localObject3));
        localf.KCY = ((RatingBar)localf.dialog.findViewById(2131299534));
        localf.KCY.setOnRatingBarChangeListener(new f.17(localf));
        localf.KCX = ((TextView)localf.dialog.findViewById(2131299531));
        if (bt.isNullOrNil((String)localObject6)) {
          break label1211;
        }
        localf.KCX.setVisibility(0);
        localf.KCX.setText(((Context)localObject3).getString(2131755406, new Object[] { localObject6 }));
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
        localf.KCV = false;
        ((AppBrandSysConfigWC)localObject2).jdW = false;
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
        localf.es(1, 1);
        localf.show();
        i = 1;
        break;
        ((TextView)localObject7).setVisibility(8);
        ((TextView)localObject7).setOnClickListener(null);
        break label892;
        label1211:
        localf.KCX.setVisibility(8);
        break label1017;
        label1224:
        localObject2 = this.mAppId;
        break label1151;
        label1233:
        localObject2 = (AppBrandInitConfigWC)super.DZ();
        localf.sessionId = "";
        if (localObject2 != null) {
          localf.sessionId = ((AppBrandInitConfigWC)localObject2).Da();
        }
        localf.scene = 1000;
        if ((localObject2 != null) && (((AppBrandInitConfigLU)localObject2).cfo != null)) {
          localf.scene = ((AppBrandInitConfigLU)localObject2).cfo.scene;
        }
        localf.dbu = "";
        if (((com.tencent.mm.plugin.appbrand.service.c)super.Du() != null) && (((com.tencent.mm.plugin.appbrand.service.c)super.Du()).aMZ() != null)) {
          localf.dbu = ((com.tencent.mm.plugin.appbrand.service.c)super.Du()).aMZ().jzm;
        }
      }
      label1351:
      if (j != 0)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "need show game evaluate dialog");
        localObject2 = localf.jpK.loE;
        localf.jpK.loE = null;
        localf.dialog = com.tencent.mm.plugin.appbrand.widget.dialog.f.u(com.tencent.mm.sdk.f.a.iV(this.mContext), false);
        localObject3 = (LinearLayout)LayoutInflater.from(localf.dialog.getContext()).inflate(2131492996, null, false);
        localf.dialog.setContentView((View)localObject3);
        localObject4 = com.tencent.mm.ui.ai.cf(localf.dialog.getContext());
        localObject4 = new FrameLayout.LayoutParams(Math.min(((Point)localObject4).x, ((Point)localObject4).y), ((LinearLayout)localObject3).getLayoutParams().height);
        ((FrameLayout.LayoutParams)localObject4).gravity = 1;
        ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        localObject5 = (TextView)((LinearLayout)localObject3).findViewById(2131305902);
        ((TextView)localObject5).setText(((dwv)localObject2).Title);
        localObject6 = (TextView)((LinearLayout)localObject3).findViewById(2131299531);
        ((TextView)localObject6).setText(((dwv)localObject2).EKL);
        localObject4 = (ImageView)((LinearLayout)localObject3).findViewById(2131299528);
        localObject5 = new f.21(localf, (TextView)localObject5, (TextView)localObject6, (ImageView)localObject4, (LinearLayout)localObject3, this, local12, (dwv)localObject2);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(2131303040)).a(0, (dwv)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(2131303041)).a(1, (dwv)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(2131303042)).a(2, (dwv)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        localf.dialog.setOnCancelListener(new f.2(localf, this, (dwv)localObject2, local12));
        ((ImageView)localObject4).setOnClickListener(new f.3(localf, this, (dwv)localObject2, local12));
        localf.dialog = localf.dialog;
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1237L, 4L, 1L, false);
        localf.show();
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  protected final void e(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(43900);
    if (paramAppBrandInitConfig == null)
    {
      ((AppBrandInitConfigWC)super.DZ()).resetSession();
      ((AppBrandInitConfigWC)super.DZ()).startTime = bt.eGO();
      ((AppBrandInitConfigWC)super.DZ()).jdu = new QualitySession(com.tencent.mm.plugin.appbrand.utils.a.un(((AppBrandInitConfigWC)super.DZ()).uin), (AppBrandInitConfigWC)super.DZ(), DZ().cfo);
    }
    super.ac(ICommLibReader.class);
    super.e(paramAppBrandInitConfig);
    AppMethodBeat.o(43900);
  }
  
  public final boolean fd(boolean paramBoolean)
  {
    AppMethodBeat.i(160536);
    long l = bt.eGO();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "showLaunchAdCallback, shouldShowToShow costTime:%s", new Object[] { Long.valueOf(l - this.iGp) });
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "showLaunchAdCallback, startTimerToShow costTime:%s", new Object[] { Long.valueOf(l - this.iGq) });
    if ((this.iGs != null) && (this.iGs.eFX())) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "showLaunchAdCallback, check time out");
      this.iGo = 3;
      com.tencent.mm.plugin.appbrand.report.quality.a.N(this);
      AppMethodBeat.o(160536);
      return false;
    }
    Dq("showLaunchAdCallback(" + paramBoolean + ")");
    if (paramBoolean)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "showLaunchAdCallback, show launch ad");
      this.iGo = 1;
      aMm().show();
      com.tencent.mm.plugin.appbrand.ad.a.e locale = new com.tencent.mm.plugin.appbrand.ad.a.e();
      locale.source = "launch";
      locale.c(aNi());
      i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195547);
          o.this.aLP();
          AppMethodBeat.o(195547);
        }
      }, 0L);
    }
    for (;;)
    {
      AppMethodBeat.o(160536);
      return true;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "showLaunchAdCallback, not show launch ad");
      this.iGo = 2;
      com.tencent.mm.plugin.appbrand.report.quality.a.N(this);
      aNl();
      aNk();
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(43899);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "finish appId[%s] type[%d] hash[%d] stacktrace=%s", new Object[] { this.mAppId, Integer.valueOf(this.iDx.iOP), Integer.valueOf(hashCode()), Log.getStackTraceString(new Throwable()) });
    if ((i.d(this)) || (this.iDt == null))
    {
      i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195551);
          o.this.dispatchDestroy();
          AppMethodBeat.o(195551);
        }
      }, 0L);
      AppMethodBeat.o(43899);
      return;
    }
    super.finish();
    if (this.iGm != null) {
      this.iGm.A(this);
    }
    AppMethodBeat.o(43899);
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(43903);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.plugin.appbrand.jsapi.u.h.a(paramConfiguration, this.mAppId);
    this.iGl = new Configuration(paramConfiguration);
    AppMethodBeat.o(43903);
  }
  
  protected void onCreate()
  {
    AppMethodBeat.i(43906);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepPrepareRuntime);
    aMY();
    com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
    Object localObject1 = (AppBrandInitConfigWC)super.DZ();
    Object localObject2;
    boolean bool;
    int i;
    if (localObject1 != null)
    {
      localObject2 = ((AppBrandInitConfigWC)localObject1).jdu;
      if (localObject2 != null) {}
    }
    else
    {
      a.setRuntime(this);
      com.tencent.mm.plugin.appbrand.f.a.X(this);
      aMV();
      bool = WXHardCoderJNI.hcMiniProgramLaunchEnable;
      int j = WXHardCoderJNI.hcMiniProgramLaunchDelay;
      int k = WXHardCoderJNI.hcMiniProgramLaunchCPU;
      int m = WXHardCoderJNI.hcMiniProgramLaunchIO;
      if (!WXHardCoderJNI.hcMiniProgramLaunchThr) {
        break label746;
      }
      i = Process.myTid();
      label90:
      this.iGg = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMiniProgramLaunchTimeout, 801, WXHardCoderJNI.hcMiniProgramLaunchAction, "MicroMsg.AppBrandRuntimeWC");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "hardcoder miniprogram launch launchStartPerformance [%d]", new Object[] { Integer.valueOf(this.iGg) });
      super.onCreate();
      aMX();
      if (!CZ()) {
        break label751;
      }
      localObject1 = com.tencent.luggage.sdk.d.d.cii;
      localObject1 = w.a.kIS;
      com.tencent.luggage.sdk.d.d.bA(w.a.a.gu(true));
      label169:
      com.tencent.mm.plugin.appbrand.report.quality.a.K(this);
      localObject1 = com.tencent.mm.plugin.appbrand.report.quality.n.lut;
      com.tencent.mm.plugin.appbrand.report.quality.n.dQ(this.mAppId, com.tencent.mm.plugin.appbrand.report.quality.a.ME(this.mAppId).kGa);
      com.tencent.mm.plugin.appbrand.report.quality.f.a(this, false, com.tencent.mm.plugin.appbrand.utils.a.Nj(((AppBrandInitConfigWC)super.DZ()).jdr));
      localObject1 = com.tencent.luggage.game.e.a.CL();
      localObject2 = this.mAppId;
      bool = CZ();
      ((com.tencent.luggage.game.e.a)localObject1).appId = ((String)localObject2);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MBNiReporter", "hy: appId:%s,isGame:%s", new Object[] { localObject2, Boolean.valueOf(bool) });
      if (bool) {
        g.a((String)localObject2, ((com.tencent.luggage.game.e.a)localObject1).cex);
      }
      ((com.tencent.luggage.game.e.a)localObject1).cep = new ArrayList();
      if (!bool) {
        break label771;
      }
      ((com.tencent.luggage.game.e.a)localObject1).cet = 1004;
      label303:
      com.tencent.mm.plugin.t.a.a(this.mAppId, ((AppBrandInitConfigWC)super.DZ()).jdo);
      if (this.iDD)
      {
        if (!CZ()) {
          break label787;
        }
        localObject1 = (AppBrandInitConfigWC)super.DZ();
        if (localObject1 == null) {
          break label782;
        }
        localObject1 = e.b.Mq(((AppBrandInitConfigWC)localObject1).jbC);
        if ((localObject1 != e.b.lmQ) && (localObject1 != e.b.lmS) && (localObject1 != e.b.lmT)) {
          break label782;
        }
        i = 1;
        label384:
        if (i == 0) {
          break label787;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "onCreate, may show ad && landscape-game, add check show ad prepare process");
        localObject1 = new b((byte)0);
        this.iGu = ((b)localObject1);
        a((AppBrandRuntime.b)localObject1);
      }
      label419:
      a(new AppBrandRuntime.b()
      {
        public final void prepare()
        {
          AppMethodBeat.i(195554);
          com.tencent.mm.plugin.appbrand.keylogger.c.a(o.this.mAppId, KSProcessWeAppLaunch.stepWaitForCommLibConfirm);
          com.tencent.mm.plugin.appbrand.launching.g.a(o.this, new d.g.a.b() {});
          AppMethodBeat.o(195554);
        }
      });
      a(new AppBrandRuntime.b()
      {
        public final void prepare()
        {
          AppMethodBeat.i(195555);
          o.a(o.this, this);
          AppMethodBeat.o(195555);
        }
      });
      a(new c((byte)0));
      localObject1 = new k(this);
      this.iGk = ((k)localObject1);
      a((AppBrandRuntime.b)localObject1);
      this.iGc.a(this.mAppId, ((AppBrandInitConfigWC)super.DZ()).iOP, com.tencent.mm.plugin.appbrand.task.e.i((AppBrandInitConfigWC)super.DZ()));
      com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
      com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.x(this);
      com.tencent.mm.plugin.appbrand.backgroundfetch.i.x(this);
      com.tencent.mm.plugin.appbrand.xweb_ext.a.a.S(this);
      OpenBusinessViewUtil.D(this);
      AppBrandBackgroundRunningMonitor.y(this);
      this.iGd = new com.tencent.mm.plugin.appbrand.report.model.n();
      this.iGd.lrM = bt.GC();
      com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j.a(this.mAppId, aLS(), DZ().cfo);
      if (DZ().cfo.scene != 1099) {
        break label802;
      }
      bool = true;
      label590:
      this.iGh = bool;
      if (aMT()) {
        this.iGi.add(new ad((AppBrandInitConfigWC)super.DZ()));
      }
      this.iDK.a(new com.tencent.mm.plugin.appbrand.b.c.a()
      {
        public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
        {
          AppMethodBeat.i(195556);
          if (com.tencent.mm.plugin.appbrand.b.b.iQM == paramAnonymousb)
          {
            o.this.iGb.khX.khY.clear();
            com.tencent.mm.plugin.appbrand.report.quality.j.bO(paramAnonymousString, 4);
          }
          AppMethodBeat.o(195556);
        }
      });
      if ((!aMT()) && (!ao.w(this))) {
        break label808;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandRuntimeWC", "initFloatBallHelper appId[%s], skip fakeNative", new Object[] { this.mAppId });
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.appbrand.report.quality.a.ME(this.mAppId);
      if (localObject1 != null) {
        ((QualitySession)localObject1).ltz = (bt.eGO() - ((AppBrandInitConfigWC)super.DZ()).startTime);
      }
      Dg("onCreate");
      AppMethodBeat.o(43906);
      return;
      com.tencent.mm.ad.c.b(null, (d.g.a.a)new c.b(a.aLw(), (QualitySession)localObject2, (AppBrandInitConfigWC)localObject1));
      break;
      label746:
      i = 0;
      break label90;
      label751:
      localObject1 = com.tencent.luggage.sdk.d.d.cii;
      localObject1 = w.a.kIS;
      com.tencent.luggage.sdk.d.d.bz(w.a.a.gu(false));
      break label169;
      label771:
      ((com.tencent.luggage.game.e.a)localObject1).cet = 1000;
      break label303;
      label782:
      i = 0;
      break label384;
      label787:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "onCreate, may show ad && non-landscape-game, just start check show ad timer");
      aNj();
      break label419;
      label802:
      bool = false;
      break label590;
      label808:
      this.iGm = new com.tencent.mm.plugin.appbrand.floatball.d();
      localObject1 = this.iGm;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandFloatBallLogic", "init, runtime:%s", new Object[] { this.mAppId });
      com.tencent.e.h.Iye.f(new d.1((com.tencent.mm.plugin.appbrand.floatball.d)localObject1, this), "FloatBallHelperThread");
    }
  }
  
  public final void onDestroy()
  {
    int j = 1;
    AppMethodBeat.i(43914);
    super.onDestroy();
    MMToClientEvent.f((com.tencent.mm.plugin.appbrand.service.c)super.Du());
    com.tencent.mm.plugin.appbrand.f.a.Y(this);
    com.tencent.mm.plugin.appbrand.report.quality.a.M(this);
    if (this.iGg != 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.iGg);
      this.iGg = 0;
    }
    if (DebuggerShell.aTY())
    {
      if (this.iGj != null) {
        this.iGj.stopTimer();
      }
      com.tencent.e.h.Iye.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195528);
          AppBrandPerformanceManager.g(o.this);
          AppMethodBeat.o(195528);
        }
      });
      com.tencent.mm.plugin.appbrand.performance.b.Ma(this.mAppId);
    }
    if (CZ()) {
      com.tencent.mm.plugin.appbrand.game.preload.d.B(this);
    }
    ??? = AppBrandMusicClientService.kQj;
    ((AppBrandMusicClientService)???).kQi.clear();
    ((AppBrandMusicClientService)???).kQk = "";
    n.remove(this.mAppId);
    com.tencent.mm.plugin.appbrand.media.record.c.onDestroy();
    aNa();
    ??? = DW();
    Object localObject2;
    if (??? != null)
    {
      localObject2 = (com.tencent.mm.plugin.appbrand.appstorage.n)((com.tencent.mm.plugin.appbrand.appstorage.t)???).av(com.tencent.mm.plugin.appbrand.appstorage.n.class);
      if (localObject2 != null) {
        com.tencent.mm.vfs.i.deleteFile(((com.tencent.mm.plugin.appbrand.appstorage.n)localObject2).iSI + "/dir.lock");
      }
      ((com.tencent.mm.plugin.appbrand.appstorage.t)???).release();
    }
    this.iGv.kXM.clear();
    a.b(this);
    ??? = this.iGd;
    int i;
    if (??? != null)
    {
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).sessionId = ((AppBrandInitConfigWC)super.DZ()).Da();
      localObject2 = n.Do(this.mAppId);
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).lrk = com.tencent.mm.plugin.appbrand.report.h.getNetworkType(com.tencent.mm.sdk.platformtools.aj.getContext());
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).appId = this.mAppId;
      if (aNb() != null) {
        break label500;
      }
      i = ((AppBrandInitConfigWC)super.DZ()).aAS;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).aAS = i;
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).dbs = (this.iDx.iOP + 1);
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).scene = DZ().cfo.scene;
      if (((com.tencent.mm.plugin.appbrand.report.model.n)???).lrN)
      {
        i = 1;
        label321:
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).lrO = i;
        if (!((n)localObject2).iFN.get()) {
          break label519;
        }
        i = j;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).lrP = i;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).lrQ = bt.aS(((com.tencent.mm.plugin.appbrand.report.model.n)???).lrM);
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).lrR = bt.eGO();
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).username = ((AppBrandInitConfigWC)super.DZ()).username;
        localObject2 = com.tencent.mm.plugin.appbrand.report.quality.a.ME(this.mAppId);
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).lrS = ((QualitySessionRuntime)localObject2).apptype;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).kGa = ((QualitySessionRuntime)localObject2).kGa;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).report();
        com.tencent.mm.plugin.appbrand.ui.recommend.e.P(this);
        this.iGd = null;
        this.iGf = false;
        this.iGk = null;
        Dq("onDestroy");
        this.iGu = null;
        this.iGy.clear();
        this.iGi.clear();
        ??? = this.iGb;
        ((com.tencent.mm.plugin.appbrand.jsapi.s.a)???).khX.khY.clear();
      }
      synchronized (((com.tencent.mm.plugin.appbrand.jsapi.s.a)???).khW)
      {
        ((SparseArray)???).clear();
        localObject2 = y.JfV;
        com.tencent.mm.plugin.appbrand.jsapi.aa.b.c.release();
        AppMethodBeat.o(43914);
        return;
        label500:
        i = aNb().jdS.pkgVersion;
        continue;
        i = 0;
        break label321;
        label519:
        i = 0;
      }
    }
  }
  
  public final void onEnterAnimationComplete()
  {
    AppMethodBeat.i(174690);
    if ((isDestroyed()) || (this.PR))
    {
      AppMethodBeat.o(174690);
      return;
    }
    Object localObject = com.tencent.mm.plugin.appbrand.report.quality.a.ME(this.mAppId);
    if (localObject != null) {
      ((QualitySessionRuntime)localObject).ltG = bt.eGO();
    }
    localObject = super.aMi();
    if ((localObject instanceof com.tencent.mm.plugin.appbrand.ui.x)) {
      ((com.tencent.mm.plugin.appbrand.ui.x)localObject).setCanShowHideAnimation(true);
    }
    AppMethodBeat.o(174690);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(43912);
    super.onPause();
    Object localObject = this.iGc;
    ((AppBrandRemoteTaskController)localObject).lwa = AppBrandRemoteTaskController.a.lwv;
    AppBrandMainProcessService.a((MainProcessTask)localObject);
    if (this.iGm != null)
    {
      localObject = this.iGm;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandFloatBallLogic", "pause, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jpd != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jpd.aWa();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jpe != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jpe.aWa();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jpf != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jpf.aWa();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jpg != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jpg.aWa();
      }
    }
    aMS().aNp();
    AppMethodBeat.o(43912);
  }
  
  public void onReady()
  {
    AppMethodBeat.i(43909);
    super.onReady();
    n.Dp(this.mAppId).lastResumeTime = System.currentTimeMillis();
    if (this.iGg != 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.iGg);
      this.iGg = 0;
    }
    long l1 = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.DZ()).startTime;
    com.tencent.mm.plugin.appbrand.report.h.c(l1, this.iGf, CZ());
    boolean bool1;
    Object localObject2;
    int i;
    label256:
    label271:
    Object localObject3;
    label317:
    Object localObject4;
    if ((AppBrandInitConfigWC)super.DZ() != null)
    {
      localObject1 = ((AppBrandInitConfigWC)super.DZ()).dfM;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "onReady reportStartupTime: %s, cost: %dms, download : %b", new Object[] { localObject1, Long.valueOf(l1), Boolean.valueOf(this.iGf) });
      l1 = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.DZ()).startTime;
      this.iGe.F(5, l1);
      localObject1 = this.iGe;
      bool1 = this.iGf;
      boolean bool2 = ((AppBrandInitConfigWC)super.DZ()).cfn;
      boolean bool3 = ((AppStartupPerformanceReportBundle)ar(AppStartupPerformanceReportBundle.class)).kHN;
      localObject2 = this.mAppId;
      ((m)localObject1).cR = 0;
      ((m)localObject1).mType = 0;
      if (aNb() != null)
      {
        ((m)localObject1).cR = aNb().jdS.pkgVersion;
        ((m)localObject1).mType = (aNb().jdS.iOQ + 1);
      }
      if (!bool1) {
        break label1104;
      }
      i = 1;
      ((m)localObject1).iFE = i;
      if (!CZ()) {
        break label1109;
      }
      i = 1;
      ((m)localObject1).iFI = i;
      ((m)localObject1).mScene = DZ().cfo.scene;
      ((m)localObject1).iFG = bool2;
      ((m)localObject1).iFH = bool3;
      localObject3 = new StringBuilder();
      i = 0;
      if (i >= ((m)localObject1).iFD.length) {
        break label1143;
      }
      if (localObject1.iFD[i] >= 0L) {
        break label1114;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: abort, illegal value: %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(localObject1.iFD[i]) });
      AppBrandPerformanceManager.a(this, 202, l1);
      com.tencent.mm.plugin.appbrand.performance.c.nl(((AppBrandInitConfigWC)super.DZ()).startTime);
      com.tencent.mm.plugin.appbrand.report.quality.a.a(this.mAppId, this);
      if ((DebuggerShell.aTY()) && (this.iGj == null))
      {
        this.iGj = new av("AppBrandRuntimeWC.mDumpTracerTimer", new av.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(195542);
            com.tencent.mm.plugin.appbrand.performance.b.g(o.this);
            AppMethodBeat.o(195542);
            return true;
          }
        }, true);
        this.iGj.av(1000L, 1000L);
      }
      if (CZ())
      {
        localObject1 = com.tencent.mm.plugin.appbrand.game.preload.d.aWV();
        l1 = bt.eGO();
        long l2 = ((AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).joZ.DZ()).startTime;
        com.tencent.mm.plugin.appbrand.game.preload.e.aWX().dK(2001, (int)(l1 - l2));
      }
      com.tencent.mm.plugin.appbrand.ui.recommend.e.Q(this);
      this.iGc.gV(false);
      if (DW() != null)
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.appstorage.n)DW().av(com.tencent.mm.plugin.appbrand.appstorage.n.class);
        com.tencent.mm.vfs.i.f(((com.tencent.mm.plugin.appbrand.appstorage.n)localObject1).iSI + "/dir.lock", new byte[1], 1);
      }
      localObject4 = com.tencent.mm.plugin.appbrand.report.quality.a.ME(this.mAppId);
      if ((localObject4 != null) && (!CZ()))
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
        d.g.b.k.h(this, "runtime");
        gh localgh = new gh();
        localObject3 = com.tencent.mm.plugin.appbrand.report.quality.a.ME(this.mAppId);
        if (localObject3 == null) {
          break label1465;
        }
        localgh.dYa = localgh.t("InstanceId", ((QualitySessionRuntime)localObject3).kGa, true);
        localgh.eag = localgh.t("AppId", ((QualitySessionRuntime)localObject3).appId, true);
        localgh.dYT = ((QualitySessionRuntime)localObject3).lty;
        localgh.egI = gh.a.jo(((QualitySessionRuntime)localObject3).lrW);
        localgh.eai = ((QualitySessionRuntime)localObject3).apptype;
        localgh.dKe = ((QualitySessionRuntime)localObject3).scene;
        localObject1 = (com.tencent.mm.plugin.appbrand.page.u)super.aLK();
        d.g.b.k.g(localObject1, "runtime.pageContainer");
        localObject1 = ((com.tencent.mm.plugin.appbrand.page.u)localObject1).getCurrentPage();
        if (localObject1 == null) {
          break label1459;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.page.q)localObject1).getCurrentPageView();
        label737:
        localObject2 = localObject1;
        if (!(localObject1 instanceof com.tencent.mm.plugin.appbrand.page.ae)) {
          localObject2 = null;
        }
        localgh.dZg = com.tencent.mm.plugin.appbrand.report.quality.c.x((com.tencent.mm.plugin.appbrand.page.ae)localObject2);
        localObject1 = localObject3;
        label769:
        com.tencent.mm.plugin.appbrand.report.quality.c.a((QualitySessionRuntime)localObject1, "Null session with " + this.mAppId);
        localgh.eaX = ((QualitySessionRuntime)localObject4).bmT();
        localgh.aBj();
      }
      if (localObject4 != null)
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
        d.g.b.k.h(this, "runtime");
        localObject3 = new fi();
        localObject2 = com.tencent.mm.plugin.appbrand.report.quality.a.ME(this.mAppId);
        if (localObject2 == null) {
          break label1508;
        }
        ((fi)localObject3).dYa = ((fi)localObject3).t("InstanceId", ((QualitySessionRuntime)localObject2).kGa, true);
        ((fi)localObject3).eag = ((fi)localObject3).t("AppId", ((QualitySessionRuntime)localObject2).appId, true);
        ((fi)localObject3).dYT = ((QualitySessionRuntime)localObject2).lty;
        ((fi)localObject3).ebZ = fi.a.iR(((QualitySessionRuntime)localObject2).lrW);
        ((fi)localObject3).eai = ((QualitySessionRuntime)localObject2).apptype;
        ((fi)localObject3).dKe = ((QualitySessionRuntime)localObject2).scene;
        localObject1 = (com.tencent.mm.plugin.appbrand.service.c)super.Du();
        if (localObject1 == null) {
          break label1471;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.service.c)localObject1).aOf();
        label954:
        localObject1 = com.tencent.mm.plugin.appbrand.report.c.d((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject1);
        switch (com.tencent.mm.plugin.appbrand.report.quality.d.ciE[localObject1.ordinal()])
        {
        default: 
          i = -1;
          label1010:
          ((fi)localObject3).dZg = i;
        }
      }
    }
    label1104:
    label1109:
    label1114:
    label1508:
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      com.tencent.mm.plugin.appbrand.report.quality.c.a((QualitySessionRuntime)localObject1, "Null session with " + this.mAppId);
      ((fi)localObject3).eaX = ((QualitySessionRuntime)localObject4).bmT();
      ((fi)localObject3).aBj();
      com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup);
      com.tencent.mm.plugin.appbrand.keylogger.c.b(KSProcessWeAppLaunch.class, this.mAppId);
      com.tencent.mm.plugin.appbrand.report.quality.j.bO(this.mAppId, 1);
      AppMethodBeat.o(43909);
      return;
      localObject1 = "";
      break;
      i = 0;
      break label256;
      i = 0;
      break label271;
      ((StringBuilder)localObject3).append(localObject1.iFD[i]);
      ((StringBuilder)localObject3).append(",");
      i += 1;
      break label317;
      label1143:
      localObject4 = (AppBrandInitConfigWC)super.DZ();
      if (localObject4 != null) {
        i = ((AppBrandInitConfigWC)localObject4).cfd;
      }
      for (;;)
      {
        i += 1000;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: %s, %s, Download: %s, Preload: %s, appServiceType: %s", new Object[] { localObject2, ((StringBuilder)localObject3).toString(), Boolean.valueOf(bool1), Boolean.valueOf(com.tencent.mm.plugin.appbrand.task.c.aNI()), Integer.valueOf(i) });
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
        com.tencent.mm.appbrand.v8.x.a(4, localObject1.iFD[5], ((m)localObject1).iFF, (String)localObject2, ((m)localObject1).iFE, ((m)localObject1).iFI, fc(false).aPc());
        break;
        i = com.tencent.mm.plugin.appbrand.report.i.Mu((String)localObject2);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeStartupReporter", "getServiceTypeForReport null = initConfig! appServiceType:%s", new Object[] { Integer.valueOf(i) });
      }
      localObject1 = null;
      break label737;
      localObject1 = null;
      break label769;
      localObject1 = null;
      break label954;
      i = 1;
      break label1010;
      i = 2;
      break label1010;
      i = 3;
      break label1010;
      i = 4;
      break label1010;
      i = 5;
      break label1010;
      i = 6;
      break label1010;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(43911);
    super.onResume();
    n.Dp(this.mAppId).lastResumeTime = System.currentTimeMillis();
    if (this.iGm != null)
    {
      localObject = this.iGm;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandFloatBallLogic", "resume, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jpd != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jpd.aVZ();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jpe != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jpe.aVZ();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jpf != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jpf.aVZ();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jpg != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jpg.aVZ();
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j.a(this.mAppId, aLS(), DZ().cfo);
    a.setRuntime(this);
    com.tencent.mm.plugin.appbrand.f.a.X(this);
    AppBrandRemoteTaskController localAppBrandRemoteTaskController = this.iGc;
    Object localObject = this.mAppId;
    int i = ((AppBrandInitConfigWC)super.DZ()).iOP;
    localAppBrandRemoteTaskController.lwa = AppBrandRemoteTaskController.a.lwm;
    localAppBrandRemoteTaskController.mAppId = ((String)localObject);
    localAppBrandRemoteTaskController.mDebugType = i;
    localAppBrandRemoteTaskController.lwf = com.tencent.mm.plugin.appbrand.report.quality.a.ME((String)localObject).kGa;
    localObject = a.CR((String)localObject);
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label350;
      }
    }
    label350:
    for (i = -1;; i = ((ICommLibReader)localObject).aPc())
    {
      localAppBrandRemoteTaskController.lvY = i;
      AppBrandMainProcessService.a(localAppBrandRemoteTaskController);
      if (this.iDN) {
        ((com.tencent.mm.plugin.appbrand.page.u)super.aLK()).getReporter().bhC();
      }
      localObject = this.mAppId;
      i = DZ().cfo.scene;
      AppBrandIDKeyBatchReport.bma().loK = 1;
      AppBrandIDKeyBatchReport.bma().loM = ((String)localObject);
      AppBrandIDKeyBatchReport.bma().loN = i;
      AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.bma());
      localObject = s.a(this, new o.3(this));
      keep((com.tencent.mm.vending.e.a)localObject);
      com.tencent.e.h.Iye.f((Runnable)localObject, "getCopyPathMenuExpireTime");
      com.tencent.mm.plugin.appbrand.ipc.b.connect();
      if (aMZ() == null) {
        break label360;
      }
      aMS().Dr(aMZ().jzm);
      AppMethodBeat.o(43911);
      return;
      localObject = ((o)localObject).fc(false);
      break;
    }
    label360:
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrandRuntimeWC", "onResume, try upsertHandOff but get NULL PageView, appId:%s", new Object[] { this.mAppId });
    AppMethodBeat.o(43911);
  }
  
  public final void qp(int paramInt)
  {
    AppMethodBeat.i(43932);
    com.tencent.mm.plugin.appbrand.ui.v localv = super.aMi();
    if ((localv instanceof com.tencent.mm.plugin.appbrand.launching.q)) {
      ((com.tencent.mm.plugin.appbrand.launching.q)localv).qp(paramInt);
    }
    AppMethodBeat.o(43932);
  }
  
  public String toString()
  {
    AppMethodBeat.i(43886);
    Locale localLocale = Locale.ENGLISH;
    String str2 = this.mAppId;
    if ((AppBrandInitConfigWC)super.DZ() == null) {}
    for (String str1 = "NULL";; str1 = ((AppBrandInitConfigWC)super.DZ()).dfM)
    {
      str1 = String.format(localLocale, "[AppBrandRuntimeWC::%s::%s::%d::@%d]", new Object[] { str2, str1, Integer.valueOf(this.iDx.iOP), Integer.valueOf(hashCode()) });
      AppMethodBeat.o(43886);
      return str1;
    }
  }
  
  final class a
    implements Runnable
  {
    private final AtomicBoolean iGI;
    
    a()
    {
      AppMethodBeat.i(43871);
      this.iGI = new AtomicBoolean(false);
      AppMethodBeat.o(43871);
    }
    
    public final void run()
    {
      AppMethodBeat.i(43872);
      if (!this.iGI.getAndSet(true))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] addPendingPermissionUpdateTask run()");
        paramRunnable.run();
      }
      AppMethodBeat.o(43872);
    }
  }
  
  final class b
    extends AppBrandRuntime.b
  {
    boolean bOR = false;
    
    private b() {}
    
    public final void AH()
    {
      AppMethodBeat.i(160528);
      super.AH();
      this.bOR = true;
      AppMethodBeat.o(160528);
    }
    
    public final void prepare()
    {
      AppMethodBeat.i(160527);
      this.bOR = false;
      o.o(o.this);
      AppMethodBeat.o(160527);
    }
  }
  
  final class c
    extends AppBrandRuntime.b
  {
    volatile AppBrandPrepareTask iGO;
    volatile boolean iGP = false;
    
    private c() {}
    
    public final void interrupt()
    {
      AppMethodBeat.i(43884);
      this.iGP = true;
      AppBrandPrepareTask localAppBrandPrepareTask = this.iGO;
      Object localObject;
      if (localAppBrandPrepareTask != null)
      {
        if (localAppBrandPrepareTask.kGd != null) {
          break label83;
        }
        localObject = null;
        if (localAppBrandPrepareTask.kGd != null) {
          break label94;
        }
      }
      label83:
      label94:
      for (int i = -1;; i = AppBrandPrepareTask.PrepareParams.a(localAppBrandPrepareTask.kGd))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandPrepareTask", "interrupt() appId[%s] type[%d]", new Object[] { localObject, Integer.valueOf(i) });
        localAppBrandPrepareTask.iGP = true;
        localObject = localAppBrandPrepareTask.kGe;
        if (localObject != null) {
          ((com.tencent.mm.plugin.appbrand.launching.ar)localObject).dead();
        }
        AppMethodBeat.o(43884);
        return;
        localObject = localAppBrandPrepareTask.kGd.mAppId;
        break;
      }
    }
    
    public final void prepare()
    {
      AppMethodBeat.i(43883);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| ResourcePrepareProcess.prepare() appId:%s", new Object[] { o.this.mAppId });
      com.tencent.mm.plugin.appbrand.launching.g.a(o.this, new d.g.a.b()
      {
        private y aNs()
        {
          AppMethodBeat.i(162153);
          if (!o.c.this.iGP) {}
          try
          {
            o.c.this.iGO = o.b(o.this, o.c.this);
            y localy = y.JfV;
            AppMethodBeat.o(162153);
            return localy;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o
 * JD-Core Version:    0.7.0.1
 */