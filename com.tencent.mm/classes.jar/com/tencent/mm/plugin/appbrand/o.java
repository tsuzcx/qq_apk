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
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.g.b.a.ha;
import com.tencent.mm.g.b.a.ha.a;
import com.tencent.mm.g.b.a.hz;
import com.tencent.mm.g.b.a.hz.a;
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
import com.tencent.mm.plugin.appbrand.floatball.d.3;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.EventLocationBackgroundStateChanged;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent;
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
import com.tencent.mm.plugin.appbrand.message.WxaAppMsgChannel;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.d.b;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.c.b;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.utils.ab;
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
import com.tencent.mm.protocal.protobuf.eba;
import com.tencent.mm.protocal.protobuf.ecm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.aj;
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
import java.util.Objects;
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
  private final Queue<Runnable> jgA;
  public final boolean jgc;
  public final com.tencent.mm.plugin.appbrand.jsapi.r.a jgd;
  protected AppBrandRemoteTaskController jge;
  private volatile com.tencent.mm.plugin.appbrand.report.model.n jgf;
  public m jgg;
  public boolean jgh;
  private int jgi;
  private boolean jgj;
  private final List<ah> jgk;
  private au jgl;
  private volatile k jgm;
  private Configuration jgn;
  private com.tencent.mm.plugin.appbrand.floatball.d jgo;
  q jgp;
  public int jgq;
  volatile long jgr;
  volatile long jgs;
  private volatile boolean jgt;
  au jgu;
  private HandlerThread jgv;
  private b jgw;
  public final com.tencent.mm.plugin.appbrand.page.d jgx;
  private com.tencent.mm.plugin.appbrand.l.b jgy;
  private final com.tencent.mm.plugin.appbrand.task.d jgz;
  
  public o(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    super(paramAppBrandRuntimeContainerWC);
    AppMethodBeat.i(174681);
    if ((bt.eWo()) || (DebuggerShell.baW()) || (com.tencent.mm.protocal.d.DIf) || (com.tencent.mm.protocal.d.DIg)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jgc = bool;
      this.jgd = new com.tencent.mm.plugin.appbrand.jsapi.r.a();
      this.jgi = 0;
      this.jgk = new LinkedList();
      this.jgl = null;
      this.jgq = 9;
      this.jgt = false;
      this.jgx = com.tencent.mm.plugin.appbrand.page.d.bpO();
      this.jgz = new com.tencent.mm.plugin.appbrand.task.d()
      {
        private boolean aD(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(186242);
          if (o.this.jge == null)
          {
            ac.e("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeController checkTokenOk with reason[%s], get NULL mRemoteController from runtime", new Object[] { paramAnonymousString });
            AppMethodBeat.o(186242);
            return true;
          }
          if (paramAnonymousInt == o.this.jge.hashCode())
          {
            AppMethodBeat.o(186242);
            return true;
          }
          AppMethodBeat.o(186242);
          return false;
        }
        
        public final void onNetworkChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(186244);
          if (aD("onNetworkChange", paramAnonymousInt))
          {
            com.tencent.mm.plugin.appbrand.networking.b localb = (com.tencent.mm.plugin.appbrand.networking.b)o.this.ab(com.tencent.mm.plugin.appbrand.networking.b.class);
            if ((localb instanceof com.tencent.mm.plugin.appbrand.networking.e)) {
              ((com.tencent.mm.plugin.appbrand.networking.e)localb).bpx();
            }
          }
          AppMethodBeat.o(186244);
        }
        
        public final void re(int paramAnonymousInt)
        {
          AppMethodBeat.i(186243);
          if (aD("finish", paramAnonymousInt)) {
            o.this.finish();
          }
          AppMethodBeat.o(186243);
        }
      };
      this.jgA = new LinkedBlockingQueue();
      Assert.assertTrue("AppBrandRuntimeWC's initial context should be AppBrandRuntimePersistentContextWrapper", this.mContext instanceof com.tencent.mm.plugin.appbrand.ui.j);
      this.jgg = new m();
      this.jdX = this.jgc;
      a(paramAppBrandRuntimeContainerWC);
      AppMethodBeat.o(174681);
      return;
    }
  }
  
  private void aTL()
  {
    AppMethodBeat.i(43896);
    if (!this.jgc)
    {
      AppMethodBeat.o(43896);
      return;
    }
    try
    {
      String str = this.mAppId + ":" + ((AppBrandInitConfigWC)super.DC()).ddh;
      this.jdA.setContentDescription(str);
      AppMethodBeat.o(43896);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(43896);
    }
  }
  
  private q aTY()
  {
    AppMethodBeat.i(160535);
    if (this.jgp != null)
    {
      localObject = this.jgp;
      AppMethodBeat.o(160535);
      return localObject;
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.service.c)super.CX();
    AppMethodBeat.o(160535);
    return localObject;
  }
  
  private void aTZ()
  {
    AppMethodBeat.i(160537);
    this.jgs = bs.eWj();
    this.jgv = new HandlerThread("checkShowAdThread");
    this.jgv.start();
    this.jgu = new au(this.jgv.getLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(186245);
        if (o.p(o.this))
        {
          ac.w("MicroMsg.AppBrandRuntimeWC", "checkShowAd, timeOut, already stop timer");
          AppMethodBeat.o(186245);
          return false;
        }
        ac.i("MicroMsg.AppBrandRuntimeWC", "checkShowAd, timeOut, realTime:%s", new Object[] { Long.valueOf(bs.eWj() - o.q(o.this)) });
        o.r(o.this);
        o.s(o.this);
        o.t(o.this);
        AppMethodBeat.o(186245);
        return false;
      }
    }, false);
    int i = aTf();
    ac.i("MicroMsg.AppBrandRuntimeWC", "checkShowAd, startTimer, time:%s, threshold:%s", new Object[] { Long.valueOf(this.jgs), Integer.valueOf(i) });
    this.jgt = false;
    au localau = this.jgu;
    long l = i;
    localau.au(l, l);
    AppMethodBeat.o(160537);
  }
  
  private void aUa()
  {
    AppMethodBeat.i(163907);
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186247);
        o.this.aTd();
        o.this.aSF();
        AppMethodBeat.o(186247);
      }
    }, 0L);
    AppMethodBeat.o(163907);
  }
  
  private void aUb()
  {
    AppMethodBeat.i(160539);
    if (this.jgw != null) {
      Q(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186248);
          if (o.u(o.this) != null) {
            o.u(o.this).Al();
          }
          AppMethodBeat.o(186248);
        }
      });
    }
    AppMethodBeat.o(160539);
  }
  
  private void aUd()
  {
    AppMethodBeat.i(160541);
    if (this.jgv != null)
    {
      this.jgv.quitSafely();
      this.jgv = null;
    }
    AppMethodBeat.o(160541);
  }
  
  private ICommLibReader fw(boolean paramBoolean)
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
  
  private void fx(boolean paramBoolean)
  {
    AppMethodBeat.i(186258);
    if ((this.jge == null) || (paramBoolean))
    {
      this.jge = new AppBrandRemoteTaskController();
      AppBrandRuntimeContainerWC localAppBrandRuntimeContainerWC = (AppBrandRuntimeContainerWC)Objects.requireNonNull((AppBrandRuntimeContainerWC)this.jdt);
      this.jge.a(localAppBrandRuntimeContainerWC.jfc, this.jgz);
    }
    AppMethodBeat.o(186258);
  }
  
  private void rb(int paramInt)
  {
    AppMethodBeat.i(43929);
    m.a(paramInt, (AppBrandInitConfigWC)super.DC());
    AppMethodBeat.o(43929);
  }
  
  public final boolean CC()
  {
    AppMethodBeat.i(43892);
    boolean bool = ((AppBrandInitConfigWC)super.DC()).CC();
    AppMethodBeat.o(43892);
    return bool;
  }
  
  public final void DD()
  {
    AppMethodBeat.i(43934);
    super.DD();
    ac.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] onInitBeforeComponentsInstalled, appId[%s] mPendingPermissionUpdateTasks.size=%d", new Object[] { this.mAppId, Integer.valueOf(this.jgA.size()) });
    while (!this.jgA.isEmpty()) {
      ((Runnable)this.jgA.remove()).run();
    }
    com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepPrepareRuntime);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup);
    AppMethodBeat.o(43934);
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.o DE()
  {
    AppMethodBeat.i(43930);
    com.tencent.mm.plugin.appbrand.performance.b.I(this);
    Object localObject = ((AppStartupPerformanceReportBundle)ar(AppStartupPerformanceReportBundle.class)).liZ;
    if (!bs.gY((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      for (long l = 0L; ((Iterator)localObject).hasNext(); l = Math.max(l, ((kv_14609)((Iterator)localObject).next()).lTS)) {}
      com.tencent.mm.plugin.appbrand.performance.b.a(this, l);
    }
    if (DebuggerShell.baW())
    {
      AppMethodBeat.o(43930);
      return null;
    }
    localObject = super.DE();
    AppMethodBeat.o(43930);
    return localObject;
  }
  
  public final boolean DF()
  {
    AppMethodBeat.i(210153);
    boolean bool = super.DF();
    AppMethodBeat.o(210153);
    return bool;
  }
  
  public com.tencent.mm.plugin.appbrand.n.a DG()
  {
    AppMethodBeat.i(43922);
    com.tencent.mm.plugin.appbrand.n.a locala = super.DG();
    AppMethodBeat.o(43922);
    return locala;
  }
  
  public final String DO()
  {
    AppMethodBeat.i(43885);
    String str = "AppBrandRuntimeWC@" + hashCode();
    AppMethodBeat.o(43885);
    return str;
  }
  
  protected final void Hi(String paramString)
  {
    AppMethodBeat.i(43938);
    super.Hi(paramString);
    if ("launch".equalsIgnoreCase(paramString))
    {
      Object localObject = new com.tencent.mm.plugin.appbrand.ad.a.d();
      ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).source = paramString;
      ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).c((com.tencent.mm.plugin.appbrand.service.c)super.CX());
      localObject = new com.tencent.mm.plugin.appbrand.ad.a.c();
      ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).source = paramString;
      ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).c((com.tencent.mm.plugin.appbrand.service.c)super.CX());
      if (!this.jdE) {
        break label116;
      }
      super.aTg();
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.N(this);
      aUb();
      try
      {
        this.jdt.getActiveRuntime().aSA().getPageView().bqz().byk();
        AppMethodBeat.o(43938);
        return;
      }
      catch (NullPointerException paramString)
      {
        label116:
        AppMethodBeat.o(43938);
      }
      ac.i("MicroMsg.AppBrandRuntime", "tryResetPageOrientationAndHideSplashIfNeed, reset orientation");
      super.b(null);
    }
  }
  
  public final void Hj(String paramString)
  {
    AppMethodBeat.i(186259);
    Object localObject2 = getAppConfig();
    com.tencent.mm.plugin.appbrand.r.a.c localc = getWindowAndroid();
    boolean bool1;
    if (localc != null)
    {
      bool1 = ((AppBrandInitConfigWC)super.DC()).cch.jBH;
      if (localObject2 == null) {
        break label233;
      }
      boolean bool2 = getAppConfig().jBH;
      if (bool1 == bool2) {
        break label233;
      }
      ac.w("MicroMsg.AppBrandRuntimeWC", "setResizableToWindow: redundancy field check fail, please call complexzeng to fix, fromAttr = [%b], fromAppJson = [%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool2) });
      bool1 = bool2;
    }
    label233:
    for (;;)
    {
      Object localObject1 = "portrait";
      if (localObject2 != null)
      {
        localObject2 = getAppConfig().bak().jCo;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = getAppConfig().jBB.jBP;
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
      if ((aTJ()) || (CC())) {
        bool1 = true;
      }
      localc.setResizeable(bool1);
      ac.i("MicroMsg.AppBrandRuntimeWC", "setResizableToWindow: stage[%s] resizable = [%b], appId = [%s]", new Object[] { paramString, Boolean.valueOf(bool1), this.mAppId });
      AppMethodBeat.o(186259);
      return;
      ac.e("MicroMsg.AppBrandRuntimeWC", "setResizableToWindow: window should not be null");
      AppMethodBeat.o(186259);
      return;
    }
  }
  
  final void Ht(String paramString)
  {
    AppMethodBeat.i(186269);
    if (this.jgu != null)
    {
      ac.i("MicroMsg.AppBrandRuntimeWC", "checkShowAd, stopTimer, appId:%s, reason:%s, realTime:%s", new Object[] { this.mAppId, paramString, Long.valueOf(bs.eWj() - this.jgs) });
      this.jgt = true;
      this.jgu.stopTimer();
    }
    aUd();
    AppMethodBeat.o(186269);
  }
  
  protected final boolean L(Runnable paramRunnable)
  {
    AppMethodBeat.i(186264);
    if ((super.aSY() instanceof com.tencent.mm.plugin.appbrand.ui.t))
    {
      i(paramRunnable, 3000L);
      AppMethodBeat.o(186264);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pUF, false))
    {
      boolean bool = getAppConfig().jBG;
      ac.w("MicroMsg.AppBrandRuntimeWC", "manualHideSplash:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(186264);
      return bool;
    }
    AppMethodBeat.o(186264);
    return false;
  }
  
  public final void P(final Runnable paramRunnable)
  {
    AppMethodBeat.i(186260);
    this.jdK.a(new com.tencent.mm.plugin.appbrand.b.c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        AppMethodBeat.i(186249);
        if (com.tencent.mm.plugin.appbrand.b.b.jqX == paramAnonymousb) {
          paramRunnable.run();
        }
        AppMethodBeat.o(186249);
      }
    });
    finish();
    AppMethodBeat.o(186260);
  }
  
  public final void Q(final Runnable paramRunnable)
  {
    AppMethodBeat.i(43923);
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(160526);
        if (o.this.isDestroyed())
        {
          ac.i("MicroMsg.AppBrandRuntimeWC", "startPrepareOrientation, finished appId[%s]", new Object[] { o.this.mAppId });
          AppMethodBeat.o(160526);
          return;
        }
        o.a(o.this, new com.tencent.mm.plugin.appbrand.r.a.e.a()
        {
          public final void a(e.b paramAnonymous2b, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(186239);
            ac.i("MicroMsg.AppBrandRuntimeWC", "startPrepareOrientation, onOrientationChanged appId[%s], orientation[%s] success[%b]", new Object[] { o.this.mAppId, paramAnonymous2b, Boolean.valueOf(paramAnonymous2Boolean) });
            if (o.8.this.jgJ != null) {
              o.8.this.jgJ.run();
            }
            AppMethodBeat.o(186239);
          }
        }, o.n(o.this));
        AppMethodBeat.o(160526);
      }
    }, 0L);
    AppMethodBeat.o(43923);
  }
  
  public final void R(final Runnable paramRunnable)
  {
    AppMethodBeat.i(43935);
    paramRunnable = new a(paramRunnable);
    this.jgA.add(paramRunnable);
    super.M(paramRunnable);
    AppMethodBeat.o(43935);
  }
  
  public final void a(ai paramai)
  {
    AppMethodBeat.i(43891);
    paramai = (AppBrandRuntimeContainerWC)paramai;
    super.a(paramai);
    if (paramai == null)
    {
      this.jdP = null;
      ((com.tencent.mm.plugin.appbrand.ui.j)this.mContext).setBaseContext(com.tencent.mm.sdk.platformtools.ai.getContext());
      if ((com.tencent.mm.plugin.appbrand.service.c)super.CX() != null) {
        ((com.tencent.mm.plugin.appbrand.service.c)super.CX()).a(null);
      }
      if ((v)super.aSA() != null) {
        com.tencent.mm.plugin.appbrand.page.w.c((v)super.aSA());
      }
      AppMethodBeat.o(43891);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.ui.j)this.mContext).setBaseContext(com.tencent.mm.sdk.f.a.jg(paramai.mContext));
    if ((com.tencent.mm.plugin.appbrand.service.c)super.CX() != null) {
      ((com.tencent.mm.plugin.appbrand.service.c)super.CX()).a(paramai);
    }
    com.tencent.mm.plugin.appbrand.page.ae localae = aTP();
    if (localae != null) {
      localae.a(paramai);
    }
    this.jgn = new Configuration(AppBrandUI.G(paramai.jfc.getActivity()));
    fx(true);
    AppMethodBeat.o(43891);
  }
  
  public final void a(ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(43888);
    if (fw(false) != null)
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
    Object localObject = (AppBrandInitConfigWC)super.DC();
    super.a(paramAppBrandInitConfig);
    ac.i("MicroMsg.AppBrandRuntimeWC", "load launchMode change need reload , before:%d load:%d", new Object[] { Integer.valueOf(((AppBrandInitConfigWC)localObject).launchMode), Integer.valueOf(((AppBrandInitConfigWC)super.DC()).launchMode) });
    if (((AppBrandInitConfigWC)super.DC()).launchMode != ((AppBrandInitConfigWC)localObject).launchMode) {
      aSS();
    }
    ac.i("MicroMsg.AppBrandRuntimeWC", "updateConfig %s, willRestart[%b], willRelaunch[%b], destroyed[%b], scene[%d]", new Object[] { this.mAppId, Boolean.valueOf(this.jdM), Boolean.valueOf(this.jdN), Boolean.valueOf(isDestroyed()), Integer.valueOf(DC().ccl.scene) });
    OpenBusinessViewUtil.D(this);
    if ((!this.jdM) && (!isDestroyed()))
    {
      com.tencent.mm.plugin.appbrand.report.quality.f.a(this, true, com.tencent.mm.plugin.appbrand.utils.a.Rs(((AppBrandInitConfigWC)super.DC()).jDE));
      com.tencent.mm.plugin.t.a.b(this.mAppId, ((AppBrandInitConfigWC)super.DC()).jDB);
      paramAppBrandInitConfig = this.jgk.iterator();
      while (paramAppBrandInitConfig.hasNext()) {
        ((ah)paramAppBrandInitConfig.next()).c((AppBrandInitConfigWC)super.DC());
      }
      if ((v)super.aSA() != null)
      {
        paramAppBrandInitConfig = (v)super.aSA();
        paramAppBrandInitConfig.getReporter().resetSession();
        paramAppBrandInitConfig.lBJ = false;
        paramAppBrandInitConfig.lBK = false;
        paramAppBrandInitConfig.lBL = false;
        paramAppBrandInitConfig.lBQ = null;
      }
      paramAppBrandInitConfig = (AppBrandInitConfigWC)super.DC();
      localObject = aTR();
      AppBrandStatObject localAppBrandStatObject = DC().ccl;
      ac.i("MicroMsg.AppBrandTaskUsageRecorder", "updateUsage, appId %s, type %d", new Object[] { paramAppBrandInitConfig.appId, Integer.valueOf(paramAppBrandInitConfig.joY) });
      String str = paramAppBrandInitConfig.CD();
      AppBrandMainProcessService.a(new AppBrandTaskUsageRecorder.UpdateTask(new AppBrandTaskUsageRecorder.LaunchCheckParams(paramAppBrandInitConfig, localAppBrandStatObject, ((AppBrandSysConfigWC)localObject).jEg.pkgVersion, fw(false).aVU(), str, paramAppBrandInitConfig.jDH)));
    }
    aTL();
    AppMethodBeat.o(43924);
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.u aSE()
  {
    AppMethodBeat.i(43928);
    Object localObject;
    if (CC())
    {
      localObject = com.tencent.mm.plugin.appbrand.game.preload.e.bdV();
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pOm, false) != true) {
        break label295;
      }
      i = 1;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jSY = i;
      ac.i("MicroMsg.WAGamePreloadStatisManager", "misPreload:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jSY) });
      AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.DC();
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jST = localAppBrandInitConfigWC.appId;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jSU = localAppBrandInitConfigWC.aBM;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jSV = localAppBrandInitConfigWC.joY;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jSW = (localAppBrandInitConfigWC.cca + 1000);
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jSX = localAppBrandInitConfigWC.jDH.lht;
      switch (((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jSV)
      {
      default: 
        label156:
        if (DC().ccl != null) {
          ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).mScene = DC().ccl.scene;
        }
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pUF, false) != true) {
          break;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jTa = i;
      ac.i("MicroMsg.WAGamePreloadStatisManager", "mHasSplashScreen:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jTa) });
      localObject = com.tencent.mm.plugin.appbrand.ui.g.a(com.tencent.mm.sdk.f.a.jg(this.mContext), this);
      ((com.tencent.mm.plugin.appbrand.ui.u)localObject).dN(((AppBrandInitConfigWC)super.DC()).iconUrl, ((AppBrandInitConfigWC)super.DC()).ddh);
      if ((localObject instanceof com.tencent.mm.plugin.appbrand.ui.w)) {
        ((com.tencent.mm.plugin.appbrand.ui.w)localObject).setCanShowHideAnimation(false);
      }
      AppMethodBeat.o(43928);
      return localObject;
      label295:
      i = 0;
      break;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jSV = 1;
      break label156;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jSV = 2;
      break label156;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).jSV = 3;
      break label156;
    }
  }
  
  protected final void aSG()
  {
    AppMethodBeat.i(186263);
    super.aSG();
    com.tencent.mm.plugin.appbrand.report.quality.a.L(this);
    AppMethodBeat.o(186263);
  }
  
  protected final void aSK()
  {
    AppMethodBeat.i(43910);
    super.aSK();
    String str = toString();
    Object localObject = this.jdZ;
    if ((localObject != null) && (((Collection)localObject).size() > 0)) {
      localObject = ((Collection)localObject).iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      ac.i("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, process[%s]", new Object[] { str, ((AppBrandRuntime.b)((Iterator)localObject).next()).toString() });
      continue;
      ac.i("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, no pending processes", new Object[] { str });
    }
    rb(11);
    com.tencent.mm.plugin.appbrand.keylogger.c.c(this.mAppId, KSProcessWeAppLaunch.stepPrepareResourceTimeout);
    AppMethodBeat.o(43910);
  }
  
  protected final void aSL()
  {
    AppMethodBeat.i(43908);
    ac.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] onPostInit appId[%s]", new Object[] { this.mAppId });
    MMToClientEvent.e((com.tencent.mm.plugin.appbrand.service.c)super.CX());
    if (((com.tencent.mm.plugin.appbrand.service.c)super.CX()).aSt().compareTo(fw(false)) != 0)
    {
      localObject = new IllegalStateException(String.format(Locale.ENGLISH, "onPostInit appId[%s] mismatch libReader, self[%s] service[%s]", new Object[] { this.mAppId, fw(false).aVS(), ((com.tencent.mm.plugin.appbrand.service.c)super.CX()).aSt().aVS() }));
      AppMethodBeat.o(43908);
      throw ((Throwable)localObject);
    }
    super.aSL();
    Object localObject = (AppBrandInitConfigWC)super.DC();
    this.jgg.E(0, System.currentTimeMillis() - ((AppBrandInitConfigWC)localObject).startTime);
    com.tencent.mm.plugin.appbrand.performance.c.b(this.mAppId, "ActivityCreate", ((AppBrandInitConfigWC)super.DC()).startTime, System.currentTimeMillis());
    MMToClientEvent.a(this.mAppId, new MMToClientEvent.c()
    {
      public final void cf(Object paramAnonymousObject)
      {
        AppMethodBeat.i(186256);
        if ((paramAnonymousObject instanceof AppBrandAuthorizeUI.AuthStateChangedByUserEvent))
        {
          ac.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], AuthStateChangedByUserEvent", new Object[] { o.this.mAppId });
          com.tencent.mm.plugin.appbrand.permission.d.Ql(o.this.mAppId);
          AppBrandBackgroundRunningMonitor.a(o.this, (AppBrandAuthorizeUI.AuthStateChangedByUserEvent)paramAnonymousObject);
        }
        AppMethodBeat.o(186256);
      }
    });
    MMToClientEvent.a(this.mAppId, new MMToClientEvent.c()
    {
      public final void cf(Object paramAnonymousObject)
      {
        AppMethodBeat.i(186226);
        if ((paramAnonymousObject instanceof EventLocationBackgroundStateChanged))
        {
          if (!((EventLocationBackgroundStateChanged)paramAnonymousObject).jyd)
          {
            ac.i("MicroMsg.AppBrandRuntimeWC", "locationBackgroundStateChanged, not listening, appId[%s]", new Object[] { o.this.mAppId });
            o.this.jdK.jqZ.a(d.a.jrB);
          }
          AppMethodBeat.o(186226);
          return;
        }
        if ((paramAnonymousObject instanceof WxaAppMsgChannel))
        {
          ac.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], WxaAppMsgChannel msg", new Object[] { o.this.mAppId });
          com.tencent.mm.plugin.appbrand.jsapi.h.a locala = new com.tencent.mm.plugin.appbrand.jsapi.h.a();
          com.tencent.mm.plugin.appbrand.service.c localc = o.this.aTU();
          paramAnonymousObject = (WxaAppMsgChannel)paramAnonymousObject;
          ac.i("MicroMsg.onReceiveMsgChannelJsApiEvent", "dispatch msg channel to web ， msgContent:%s", new Object[] { paramAnonymousObject.drV });
          HashMap localHashMap = new HashMap();
          localHashMap.put("msgId", paramAnonymousObject.dtG);
          localHashMap.put("sendTime", Long.valueOf(paramAnonymousObject.jGx));
          localHashMap.put("msgType", Integer.valueOf(paramAnonymousObject.msgType));
          localHashMap.put("msgContent", paramAnonymousObject.drV);
          locala.g(localc);
          ac.i("MicroMsg.onReceiveMsgChannelJsApiEvent", "dispatch wxa msg channel");
          locala.A(localHashMap).beN();
          AppMethodBeat.o(186226);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandVoIP1v1FloatBallEvent))
        {
          ac.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], AppBrandVoIP1v1FloatBallEvent msg", new Object[] { o.this.mAppId });
          if (((AppBrandVoIP1v1FloatBallEvent)paramAnonymousObject).dmJ == 1) {
            com.tencent.mm.plugin.appbrand.jsapi.openvoice.p.bip();
          }
        }
        AppMethodBeat.o(186226);
      }
    });
    new com.tencent.mm.plugin.appbrand.report.e.a(this, (byte)0);
    this.jgg.E(8, System.currentTimeMillis() - ((AppBrandInitConfigWC)super.DC()).startTime);
    rb(2);
    if (!CC()) {
      com.tencent.mm.plugin.appbrand.jsapi.z.b.c.a((com.tencent.mm.plugin.appbrand.g.b)ab(com.tencent.mm.plugin.appbrand.g.b.class), (com.tencent.mm.plugin.appbrand.g.a)ab(com.tencent.mm.plugin.appbrand.g.a.class), (com.tencent.mm.plugin.appbrand.service.c)super.CX());
    }
    ac.i("MicroMsg.AppBrand.VideoCanvas.XWebVideoCanvasLogic", "init");
    localObject = com.tencent.mm.plugin.appbrand.j.a.bcU();
    SkiaCanvasExternalTextureManager.getInstance().registerPlugin((SkiaCanvasExternalTexturePlugin)localObject);
    localObject = this.jdT;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.appbrand.pip.f)localObject).lNZ = com.tencent.mm.plugin.appbrand.pip.k.lOt;
      ((com.tencent.mm.plugin.appbrand.pip.f)localObject).bsA();
      ((com.tencent.mm.plugin.appbrand.pip.f)localObject).lOb = com.tencent.mm.plugin.appbrand.pip.g.lOo;
    }
    AppMethodBeat.o(43908);
  }
  
  protected q aSM()
  {
    AppMethodBeat.i(43901);
    Object localObject2;
    Object localObject1;
    if (super.DF()) {
      if (CC())
      {
        localObject2 = com.tencent.mm.plugin.appbrand.task.c.c(com.tencent.mm.plugin.appbrand.task.e.ht(true));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (this.jgm != null) {
            localObject1 = this.jgm.aTl();
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
      com.tencent.mm.plugin.appbrand.report.quality.a.QN(this.mAppId).lVH = com.tencent.mm.plugin.appbrand.report.quality.i.lVa;
      continue;
      localObject1 = new com.tencent.mm.plugin.appbrand.service.c(com.tencent.luggage.sdk.b.a.c.h.ceG);
      continue;
      if (this.jgm != null)
      {
        localObject1 = this.jgm.aTl();
        if (localObject1 != null)
        {
          String str = this.mAppId;
          if (!CC()) {
            break label260;
          }
          localObject2 = "WAGame";
          ac.i("MicroMsg.AppBrandRuntimeWC", "[%s][%s] [applaunch] [preload] createService preloaded, reason=%s", new Object[] { str, localObject2, com.tencent.mm.plugin.appbrand.report.quality.a.QN(this.mAppId).lVH.name() });
        }
        if (localObject1 != null) {
          break label303;
        }
        localObject2 = this.mAppId;
        if (!CC()) {
          break label267;
        }
      }
      for (localObject1 = "WAGame";; localObject1 = "WAService")
      {
        ac.i("MicroMsg.AppBrandRuntimeWC", "[%s][%s] [applaunch] [preload] createService got no preloaded", new Object[] { localObject2, localObject1 });
        if (((!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.h.DEBUG) && (!DebuggerShell.baW())) || (!com.tencent.mm.plugin.appbrand.task.a.buh())) {
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
      if (CC()) {
        localObject1 = new com.tencent.mm.plugin.appbrand.game.c();
      } else {
        localObject1 = new com.tencent.mm.plugin.appbrand.service.c();
      }
    }
  }
  
  protected com.tencent.mm.plugin.appbrand.page.u aSN()
  {
    AppMethodBeat.i(43902);
    try
    {
      com.tencent.mm.plugin.appbrand.report.quality.a.QN(this.mAppId).lVJ = bs.eWj();
      label19:
      if (CC()) {}
      com.tencent.mm.plugin.appbrand.page.ae localae;
      for (Object localObject1 = new com.tencent.mm.plugin.appbrand.game.f.c(com.tencent.mm.sdk.f.a.jg(this.mContext), this);; localObject1 = new v(com.tencent.mm.sdk.f.a.jg(this.mContext), this))
      {
        ((v)localObject1).setDecorWidgetFactory(this.jgx);
        if (!CC()) {
          ((v)localObject1).setNavigateInterceptor(new com.tencent.mm.plugin.appbrand.page.c.b());
        }
        if (this.jgm == null) {
          break label220;
        }
        localae = this.jgm.aTm();
        if ((localae == null) || (localae == null) || (((v)localObject1).getRuntime() == null)) {
          break label220;
        }
        if (localae.aSt().compareTo(((v)localObject1).getRuntime().fw(false)) == 0) {
          break;
        }
        localObject1 = new IllegalStateException(String.format(Locale.ENGLISH, "stashPreloadedPageView appId[%s] mismatch libReader, runtime[%s] page[%s]", new Object[] { ((v)localObject1).getAppId(), ((v)localObject1).getRuntime().fw(false).aVS(), localae.aSt().aVS() }));
        AppMethodBeat.o(43902);
        throw ((Throwable)localObject1);
      }
      synchronized (((v)localObject1).lBS)
      {
        ((v)localObject1).lBS.addLast(localae);
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
  
  public final boolean aSO()
  {
    AppMethodBeat.i(43904);
    if (CC())
    {
      AppMethodBeat.o(43904);
      return false;
    }
    if (com.tencent.mm.protocal.d.DIc <= 654314239)
    {
      AppMethodBeat.o(43904);
      return false;
    }
    if ((!com.tencent.mm.protocal.d.DId) || (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pQG, false)))
    {
      AppMethodBeat.o(43904);
      return true;
    }
    AppMethodBeat.o(43904);
    return false;
  }
  
  protected final void aSR()
  {
    AppMethodBeat.i(43916);
    MMToClientEvent.e((com.tencent.mm.plugin.appbrand.service.c)super.CX());
    this.jge.a(this.mAppId, ((AppBrandInitConfigWC)super.DC()).joY, com.tencent.mm.plugin.appbrand.task.e.i((AppBrandInitConfigWC)super.DC()));
    AppMethodBeat.o(43916);
  }
  
  public final void aSW()
  {
    AppMethodBeat.i(174684);
    if (com.tencent.mm.plugin.appbrand.ui.m.ar(this))
    {
      AppMethodBeat.o(174684);
      return;
    }
    super.aSW();
    AppMethodBeat.o(174684);
  }
  
  public final boolean aSX()
  {
    AppMethodBeat.i(43913);
    if ((!isInBackStack()) && (!a.a(this))) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.AppBrandRuntimeWC", "[wxa_reload]recycleRuntime %s, recycle[%b]", new Object[] { toString(), Boolean.valueOf(bool) });
      if (bool) {
        finish();
      }
      AppMethodBeat.o(43913);
      return bool;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.u aSY()
  {
    AppMethodBeat.i(186262);
    com.tencent.mm.plugin.appbrand.ui.u localu = super.aSY();
    AppMethodBeat.o(186262);
    return localu;
  }
  
  protected final void aSZ()
  {
    AppMethodBeat.i(160542);
    super.aSZ();
    com.tencent.mm.plugin.appbrand.ad.a.b localb = new com.tencent.mm.plugin.appbrand.ad.a.b();
    localb.source = "launch";
    localb.type = "close";
    localb.c(aTY());
    if (aTc() != null) {
      aTc().i(true, "launch");
    }
    AppMethodBeat.o(160542);
  }
  
  public final ICommLibReader aSt()
  {
    AppMethodBeat.i(210149);
    ICommLibReader localICommLibReader = fw(false);
    AppMethodBeat.o(210149);
    return localICommLibReader;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.d aTG()
  {
    return this.jgx;
  }
  
  public final com.tencent.mm.plugin.appbrand.floatball.c aTH()
  {
    if (this.jgo != null) {
      return this.jgo.jPp;
    }
    return null;
  }
  
  public com.tencent.mm.plugin.appbrand.l.b aTI()
  {
    AppMethodBeat.i(174683);
    if ((this.jgy == null) && (!isDestroyed())) {
      this.jgy = new o.1(this);
    }
    com.tencent.mm.plugin.appbrand.l.b localb = this.jgy;
    AppMethodBeat.o(174683);
    return localb;
  }
  
  public final boolean aTJ()
  {
    AppMethodBeat.i(43893);
    boolean bool = ((AppBrandInitConfigWC)super.DC()).jDy;
    AppMethodBeat.o(43893);
    return bool;
  }
  
  public final boolean aTK()
  {
    AppMethodBeat.i(43894);
    boolean bool = ((AppBrandInitConfigWC)super.DC()).jDv;
    AppMethodBeat.o(43894);
    return bool;
  }
  
  public final void aTM()
  {
    AppMethodBeat.i(43898);
    ac.i("MicroMsg.AppBrandRuntimeWC", "callSuperClose appId:%s", new Object[] { this.mAppId });
    super.close();
    AppMethodBeat.o(43898);
  }
  
  protected final void aTN()
  {
    AppMethodBeat.i(43905);
    b(com.tencent.mm.plugin.appbrand.networking.a.class, com.tencent.mm.plugin.appbrand.networking.f.lxV);
    b(com.tencent.mm.plugin.appbrand.permission.g.class, new com.tencent.mm.plugin.appbrand.permission.j(this));
    b(com.tencent.mm.plugin.appbrand.permission.h.class, com.tencent.mm.plugin.appbrand.permission.l.lIY);
    b(com.tencent.mm.plugin.appbrand.jsapi.media.d.class, com.tencent.mm.plugin.appbrand.jsapi.media.o.kzl);
    ac(com.tencent.mm.plugin.appbrand.networking.b.class);
    b(com.tencent.mm.plugin.appbrand.networking.b.class, new com.tencent.mm.plugin.appbrand.networking.e(this));
    b(com.tencent.mm.plugin.appbrand.jsapi.base.f.class, new aa());
    b(com.tencent.mm.plugin.appbrand.widget.h.class, com.tencent.mm.plugin.appbrand.widget.i.msz);
    b(com.tencent.mm.plugin.appbrand.jsapi.u.b.class, com.tencent.mm.plugin.appbrand.luggage.b.c.lqD);
    b(com.tencent.luggage.sdk.f.a.class, com.tencent.mm.plugin.appbrand.app.e.jjT);
    b(ax.class, new af(this));
    b(com.tencent.mm.plugin.appbrand.jsapi.media.a.a.class, new com.tencent.mm.plugin.appbrand.jsapi.media.a.a()
    {
      public final void a(final Context paramAnonymousContext, final Runnable paramAnonymousRunnable1, final Runnable paramAnonymousRunnable2)
      {
        AppMethodBeat.i(186251);
        if (!ab.AI())
        {
          o.this.i(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(43876);
              com.tencent.mm.platformtools.p.a(paramAnonymousContext, paramAnonymousRunnable1, paramAnonymousRunnable2);
              AppMethodBeat.o(43876);
            }
          }, 0L);
          AppMethodBeat.o(186251);
          return;
        }
        com.tencent.mm.platformtools.p.a(paramAnonymousContext, paramAnonymousRunnable1, paramAnonymousRunnable2);
        AppMethodBeat.o(186251);
      }
    });
    n.Ho(this.mAppId);
    AppMethodBeat.o(43905);
  }
  
  protected final void aTO()
  {
    AppMethodBeat.i(43907);
    o localo = a.GU(this.mAppId);
    if ((localo != null) && (this != localo))
    {
      ac.i("MicroMsg.AppBrandRuntimeWC", "clearDuplicatedInstanceOnAppCreate duplicated[%d] this[%d]", new Object[] { Integer.valueOf(localo.hashCode()), Integer.valueOf(hashCode()) });
      localo.aTW();
    }
    this.jge.QQ(this.mAppId);
    AppMethodBeat.o(43907);
  }
  
  public com.tencent.mm.plugin.appbrand.page.ae aTP()
  {
    AppMethodBeat.i(186261);
    if ((v)super.aSA() == null)
    {
      AppMethodBeat.o(186261);
      return null;
    }
    if (((v)super.aSA()).getCurrentPage() == null)
    {
      AppMethodBeat.o(186261);
      return null;
    }
    com.tencent.mm.plugin.appbrand.page.ae localae = (com.tencent.mm.plugin.appbrand.page.ae)((v)super.aSA()).getCurrentPage().getCurrentPageView();
    AppMethodBeat.o(186261);
    return localae;
  }
  
  public final void aTQ()
  {
    AppMethodBeat.i(43915);
    this.jge.QP(this.mAppId);
    AppMethodBeat.o(43915);
  }
  
  public final AppBrandSysConfigWC aTR()
  {
    AppMethodBeat.i(43918);
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)c(AppBrandSysConfigWC.class, false);
    AppMethodBeat.o(43918);
    return localAppBrandSysConfigWC;
  }
  
  public final AppBrandInitConfigWC aTS()
  {
    AppMethodBeat.i(210150);
    AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.DC();
    AppMethodBeat.o(210150);
    return localAppBrandInitConfigWC;
  }
  
  public final v aTT()
  {
    AppMethodBeat.i(210151);
    v localv = (v)super.aSA();
    AppMethodBeat.o(210151);
    return localv;
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c aTU()
  {
    AppMethodBeat.i(210152);
    com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)super.CX();
    AppMethodBeat.o(210152);
    return localc;
  }
  
  public final void aTV()
  {
    int k = 0;
    AppMethodBeat.i(43931);
    AppBrandSysConfigWC localAppBrandSysConfigWC = aTR();
    com.tencent.mm.plugin.appbrand.config.m.bm(this.mAppId, localAppBrandSysConfigWC.ccL);
    com.tencent.mm.plugin.appbrand.config.m.bn(this.mAppId, localAppBrandSysConfigWC.ccM);
    Object localObject3 = this.jdG;
    Object localObject4 = DC();
    AppBrandSysConfigLU localAppBrandSysConfigLU = DB();
    Object localObject1 = getAppConfig();
    com.tencent.mm.plugin.appbrand.p.a locala = new com.tencent.mm.plugin.appbrand.p.a();
    int i;
    label121:
    Object localObject2;
    if ((((AppBrandInitConfigLU)localObject4).Cz()) || (((AppBrandInitConfigLU)localObject4).CC()))
    {
      m = 1;
      locala.lvX = m;
      if ((localAppBrandSysConfigLU.jEg.jpa != 1) && (localAppBrandSysConfigLU.jEg.jpa != 2)) {
        break label1071;
      }
      i = 1;
      if (!localAppBrandSysConfigLU.ccb) {
        break label1081;
      }
      if ((i != 0) && (localAppBrandSysConfigLU.ccq)) {
        break label1076;
      }
      m = 1;
      label143:
      locala.lvY = m;
      i = com.tencent.mm.plugin.appbrand.config.e.s(new int[] { localAppBrandSysConfigLU.ccO.jCE.jDk, ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jBA.dBc });
      if (i > 0) {
        locala.lvZ = i;
      }
      i = com.tencent.mm.plugin.appbrand.config.e.s(new int[] { localAppBrandSysConfigLU.ccO.jCE.jDh, ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jBA.jBR });
      if (i > 0) {
        locala.lwa = i;
      }
      i = com.tencent.mm.plugin.appbrand.config.e.s(new int[] { localAppBrandSysConfigLU.ccO.jCE.jDi, ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jBA.jBS });
      if (i > 0) {
        locala.lwb = i;
      }
      i = com.tencent.mm.plugin.appbrand.config.e.s(new int[] { localAppBrandSysConfigLU.ccO.jCE.jDj, ((com.tencent.mm.plugin.appbrand.config.a)localObject1).jBA.jBT });
      if (i > 0) {
        locala.lwc = i;
      }
      locala.ccv = localAppBrandSysConfigLU.ccv;
      locala.lwd = localAppBrandSysConfigLU.ccy;
      locala.ccw = localAppBrandSysConfigLU.ccw;
      locala.ccx = localAppBrandSysConfigLU.ccx;
      locala.ccE = localAppBrandSysConfigLU.ccE;
      locala.ccF = localAppBrandSysConfigLU.ccF;
      locala.ccG = localAppBrandSysConfigLU.ccG;
      locala.ccH = localAppBrandSysConfigLU.ccH;
      locala.ccI = localAppBrandSysConfigLU.ccI;
      if (localAppBrandSysConfigLU.ccO.jCE.mode != 1) {
        break label1103;
      }
      if (localAppBrandSysConfigLU.ccO.jCE.jDf != null) {
        locala.lwe = localAppBrandSysConfigLU.ccO.jCE.jDf;
      }
      label452:
      locala.mode = localAppBrandSysConfigLU.ccO.jCE.mode;
      locala.lwg = com.tencent.mm.plugin.appbrand.config.e.W(this);
      if (!((AppBrandInitConfigLU)localObject4).CC()) {
        break label1151;
      }
      i = localAppBrandSysConfigLU.ccO.jCQ;
      label494:
      locala.jCy = i;
      locala.ccA = localAppBrandSysConfigLU.ccA;
      locala.ccB = localAppBrandSysConfigLU.ccB;
      localObject2 = com.tencent.mm.plugin.appbrand.config.i.baz();
      locala.lwh = com.tencent.mm.plugin.appbrand.z.o.a(com.tencent.mm.sdk.platformtools.ai.getContext(), (String)localObject2, (com.tencent.mm.plugin.appbrand.z.o.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.z.o.a.class));
      ac.i("Luggage.FULL.AppBrandConfigAdapter", "runtime(%s).getNetworkConfig.userAgentString = [ %s ]", new Object[] { this.mAppId, locala.lwh });
      localObject2 = (com.tencent.mm.plugin.appbrand.jsapi.p.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.p.a.class);
      if (localObject2 == null) {
        break label1163;
      }
      locala.lwi = ((com.tencent.mm.plugin.appbrand.jsapi.p.a)localObject2).MX(((com.tencent.mm.plugin.appbrand.config.a)localObject1).hty);
      label608:
      localObject2 = "";
      localObject1 = localObject2;
      if (localAppBrandSysConfigLU.ccO != null)
      {
        localObject1 = localObject2;
        if (localAppBrandSysConfigLU.ccO.jCE != null) {
          localObject1 = localAppBrandSysConfigLU.ccO.jCE.jDl;
        }
      }
      localObject2 = localObject1;
      if (bs.isNullOrNil((String)localObject1)) {
        localObject2 = "servicewechat.com";
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(localAppBrandSysConfigLU.appId);
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(localAppBrandSysConfigLU.jEg.pkgVersion);
      ((StringBuilder)localObject1).append("/page-frame.html");
      locala.referer = ((StringBuilder)localObject1).toString();
      locala.ccb = ((AppBrandInitConfigLU)localObject4).ccb;
      locala.lwj = j.a.on(localAppBrandSysConfigLU.jEg.jpa);
      if ((locala.lwj) || (!bs.gY(locala.lwg))) {
        com.tencent.mm.plugin.appbrand.p.j.b(locala);
      }
      ((Collection)localObject3).add(locala);
      this.jdG.add(com.tencent.mm.plugin.appbrand.config.e.a(localAppBrandSysConfigWC));
      localObject1 = this.jdG;
      localObject2 = new v.a();
      ((v.a)localObject2).jCN = localAppBrandSysConfigWC.ccO.jCN;
      ((Collection)localObject1).add(localObject2);
      localObject1 = this.jdG;
      localObject2 = DB();
      localObject3 = getAppConfig();
      localObject4 = new com.tencent.mm.plugin.appbrand.b.a();
      if ((localObject2 != null) && (localObject3 != null)) {
        break label1175;
      }
      label909:
      ((Collection)localObject1).add(localObject4);
      localObject1 = new com.tencent.mm.plugin.appbrand.performance.a();
      if ((!localAppBrandSysConfigWC.cco) || ((localAppBrandSysConfigWC.jEg.jpa != 1) && (localAppBrandSysConfigWC.jEg.jpa != 2) && (!bt.eWo()))) {
        break label1251;
      }
      m = 1;
      label968:
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject1).lHp = m;
      if (localAppBrandSysConfigWC.jEg.jpa == 0) {
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
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject1).lHq = m;
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject1).lHr = localAppBrandSysConfigWC.ccn;
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject1).lHp |= DebuggerShell.baW();
      m = ((com.tencent.mm.plugin.appbrand.performance.a)localObject1).lHq;
      if (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)
      {
        i = k;
        if (!bt.eWo()) {}
      }
      else
      {
        i = 1;
      }
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject1).lHq = (m | i);
      this.jdG.add(localObject1);
      AppMethodBeat.o(43931);
      return;
      m = 0;
      break;
      int j = 0;
      break label121;
      m = 0;
      break label143;
      if ((j == 0) || (!localAppBrandSysConfigLU.ccn))
      {
        m = 1;
        break label143;
      }
      m = 0;
      break label143;
      if ((localAppBrandSysConfigLU.ccO.jCE.mode != 2) || (localAppBrandSysConfigLU.ccO.jCE.jDg == null)) {
        break label452;
      }
      locala.lwf = localAppBrandSysConfigLU.ccO.jCE.jDg;
      break label452;
      label1151:
      j = localAppBrandSysConfigLU.ccO.jCy;
      break label494;
      ac.w("", "getNetworkConfig, referrerHelper is null");
      break label608;
      if (j.a.on(((com.tencent.mm.plugin.appbrand.config.k)localObject2).jEg.jpa))
      {
        ((com.tencent.mm.plugin.appbrand.b.a)localObject4).jqS = ((com.tencent.mm.plugin.appbrand.config.a)localObject3).jBD.contains("audio");
        ((com.tencent.mm.plugin.appbrand.b.a)localObject4).jqT = ((com.tencent.mm.plugin.appbrand.config.a)localObject3).jBD.contains("location");
        break label909;
      }
      ((com.tencent.mm.plugin.appbrand.b.a)localObject4).jqS = ((AppBrandSysConfigLU)localObject2).jEa;
      ((com.tencent.mm.plugin.appbrand.b.a)localObject4).jqT = ((AppBrandSysConfigLU)localObject2).jEb;
      break label909;
      m = 0;
      break label968;
    }
  }
  
  public final void aTW()
  {
    AppMethodBeat.i(43933);
    this.jdR = false;
    if (this.jdt != null) {
      this.jdt.F(this);
    }
    finish();
    if ((this.jdt instanceof AppBrandRuntimeContainerWC)) {
      ((AppBrandRuntimeContainerWC)this.jdt).Dw();
    }
    AppMethodBeat.o(43933);
  }
  
  protected void aTX()
  {
    AppMethodBeat.i(174689);
    k localk = this.jgm;
    if (localk != null)
    {
      if (localk.jeJ == null)
      {
        localk.aTj();
        AppMethodBeat.o(174689);
        return;
      }
      localk.jeJ.a(com.tencent.mm.vending.h.d.Jrh, new k.5(localk)).a(com.tencent.mm.vending.h.d.Jrh, new k.4(localk));
    }
    AppMethodBeat.o(174689);
  }
  
  public final boolean aUc()
  {
    if (this.jgw != null) {
      return this.jgw.bMz;
    }
    return false;
  }
  
  public final int aUe()
  {
    AppMethodBeat.i(163908);
    if ((AppBrandInitConfigWC)super.DC() != null)
    {
      int i = ((AppBrandInitConfigWC)super.DC()).jDK;
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
    AppBrandStatObject localAppBrandStatObject = paramAppBrandInitConfig.ccl;
    boolean bool;
    if ((this.jgj) || (localAppBrandStatObject.scene == 1099))
    {
      ac.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] mShouldRelaunchCausedByFunctionalPageOpen[%b] newScene[%d]", new Object[] { this.mAppId, Boolean.valueOf(this.jgj), Integer.valueOf(localAppBrandStatObject.scene) });
      if (localAppBrandStatObject.scene == 1099) {}
      for (bool = true;; bool = false)
      {
        this.jgj = bool;
        AppMethodBeat.o(43925);
        return true;
      }
    }
    if ((TextUtils.isEmpty(paramAppBrandInitConfig.jjf)) && (ae.v(this)))
    {
      ac.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] enterPath[%s], old is gameFunctionalPage", new Object[] { this.mAppId, paramAppBrandInitConfig.jjf });
      AppMethodBeat.o(43925);
      return true;
    }
    if (1038 == localAppBrandStatObject.scene)
    {
      ac.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. appId[%s], reason=1038 back from other MiniProgram", new Object[] { this.mAppId });
      AppMethodBeat.o(43925);
      return false;
    }
    Iterator localIterator = this.jgk.iterator();
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
    if (!TextUtils.isEmpty(paramAppBrandInitConfig.jjf))
    {
      ac.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] enterPath[%s]", new Object[] { this.mAppId, paramAppBrandInitConfig.jjf });
      AppMethodBeat.o(43925);
      return true;
    }
    int i = localAppBrandStatObject.scene;
    if (org.apache.commons.b.a.contains(new int[] { 1001, 1003, 1023, 1038, 1056, 1080, 1083, 1089, 1090, 1103, 1104, 1113, 1114, 1117, 1131, 1019, 1112, 1127, 1134 }, i))
    {
      ac.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. keepNoRelaunch appId[%s] newScene[%d]", new Object[] { this.mAppId, Integer.valueOf(localAppBrandStatObject.scene) });
      AppMethodBeat.o(43925);
      return false;
    }
    if ((1030 == localAppBrandStatObject.scene) && (TextUtils.isEmpty(paramAppBrandInitConfig.jjf)))
    {
      ac.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. special for monkey test appId[%s]", new Object[] { this.mAppId });
      AppMethodBeat.o(43925);
      return false;
    }
    ac.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] fallback logic", new Object[] { this.mAppId });
    AppMethodBeat.o(43925);
    return true;
  }
  
  public final void close()
  {
    AppMethodBeat.i(43897);
    ac.i("MicroMsg.AppBrandRuntimeWC", "close() appId:%s, stack:%s", new Object[] { this.mAppId, Log.getStackTraceString(new Throwable()) });
    Runnable local12;
    com.tencent.mm.plugin.appbrand.widget.dialog.f localf;
    int j;
    int i;
    for (;;)
    {
      try
      {
        if (g.Hg(this.mAppId) == g.d.jdc)
        {
          localObject1 = (com.tencent.mm.plugin.appbrand.game.f.a)((v)super.aSA()).getPageView().Q(com.tencent.mm.plugin.appbrand.game.f.a.class);
          if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.game.f.a)localObject1).bdI() != null))
          {
            localObject1 = ((com.tencent.mm.plugin.appbrand.game.f.a)localObject1).bdI();
            ac.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: triggerMakeCanvasBitmap");
            if ((((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).jRM != null) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).bdK() != null) && (!bs.isNullOrNil(((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).jRM.GgI)) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).jRM.GgA) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).jRO != null)) {
              continue;
            }
            ac.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: should not do make canvas bitmap!");
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        ac.printErrStackTrace("MicroMsg.AppBrandRuntimeWC", localException, "hy: triggerMakeCanvasBitmap error!", new Object[0]);
        continue;
        local12 = new Runnable()
        {
          public final void run()
          {
            boolean bool3 = true;
            AppMethodBeat.i(43873);
            if (o.f(o.this) != null)
            {
              com.tencent.mm.plugin.appbrand.floatball.d locald = o.f(o.this);
              o localo = o.this;
              ac.i("MicroMsg.AppBrandFloatBallLogic", "close, runtime:%s", new Object[] { localo.mAppId });
              int i = com.tencent.mm.plugin.appbrand.floatball.c.b(g.Hg(localo.mAppId));
              boolean bool1;
              boolean bool2;
              if ((locald.jPr != null) && (locald.jPr.bdl()))
              {
                bool1 = true;
                if ((locald.jPs == null) || (!locald.jPs.bdl())) {
                  break label179;
                }
                bool2 = true;
                label106:
                ac.i("MicroMsg.AppBrandFloatBallLogic", "close, voip:%s, voip1v1:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                if (!bool1) {
                  break label184;
                }
                locald.jPr.a(com.tencent.mm.sdk.f.a.jg(localo.mContext), new com.tencent.mm.plugin.appbrand.floatball.d.2(locald, i));
                bool1 = bool3;
              }
              for (;;)
              {
                if (!bool1) {
                  break label248;
                }
                AppMethodBeat.o(43873);
                return;
                bool1 = false;
                break;
                label179:
                bool2 = false;
                break label106;
                label184:
                if (bool2)
                {
                  locald.jPs.a(com.tencent.mm.sdk.f.a.jg(localo.mContext), new d.3(locald, i));
                  bool1 = bool3;
                }
                else
                {
                  bool1 = locald.rV(i);
                  ac.i("MicroMsg.AppBrandFloatBallLogic", "close, result:%s", new Object[] { Boolean.valueOf(bool1) });
                }
              }
            }
            label248:
            o.this.aTM();
            AppMethodBeat.o(43873);
          }
        };
        localf = new com.tencent.mm.plugin.appbrand.widget.dialog.f((com.tencent.mm.plugin.appbrand.service.c)super.CX());
        if (localf.jPZ != null) {
          break;
        }
      }
      OpenBusinessViewUtil.E(this);
      if ((aTJ()) || (ae.v(this)))
      {
        super.close();
        AppMethodBeat.o(43897);
        return;
        if (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).bdL()) {
          ((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).bdK().BS();
        }
      }
      else
      {
        j = 0;
        if ((this != null) && (aTR() != null) && (com.tencent.mm.sdk.f.a.jg(this.mContext) != null)) {
          break label482;
        }
        ac.w("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "invalid close state");
        i = 0;
        label300:
        if (i == 0) {
          break label1351;
        }
        if (j != 0)
        {
          ac.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: WA dialog first");
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1237L, 2L, 1L, false);
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
      Object localObject2 = localf.jPZ.lQE;
      if ((localObject2 == null) || (((ecm)localObject2).GhY == null) || (((ecm)localObject2).GhY.size() < 3))
      {
        ac.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: no config");
        j = 0;
        break;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1237L, 0L, 1L, false);
      long l1 = n.Hr(this.mAppId).lastResumeTime;
      localf.kWs = ((int)(System.currentTimeMillis() - l1));
      if (localf.kWs < ((ecm)localObject2).Gia * 1000)
      {
        ac.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: time limit");
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1237L, 1L, 1L, false);
        j = 0;
        break;
      }
      j = 1;
      break;
      label482:
      localObject2 = aTR();
      if (!((AppBrandSysConfigWC)localObject2).jEk)
      {
        ac.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "can not show evaluate dialog");
        i = 0;
        break label300;
      }
      l1 = n.Hr(this.mAppId).lastResumeTime;
      long l2 = System.currentTimeMillis();
      ac.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "app time lastResumeTime:%s, closeTime:%s, leastTime:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(((AppBrandSysConfigWC)localObject2).jEm) });
      if ((l2 - l1) / 1000L < ((AppBrandSysConfigWC)localObject2).jEm)
      {
        ac.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "time not enough to show evaluate dialog");
        i = 0;
        break label300;
      }
      Object localObject5 = (AppBrandInitConfigWC)super.DC();
      localf.userName = ((AppBrandInitConfigWC)localObject5).username;
      if (bs.isNullOrNil(localf.userName))
      {
        ac.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "username is null, can not show evaluate dialog");
        i = 0;
        break label300;
      }
      Object localObject3 = com.tencent.mm.sdk.f.a.jg(this.mContext);
      Object localObject4 = ((AppBrandInitConfigWC)localObject5).appId;
      Object localObject6 = ((AppBrandInitConfigWC)localObject5).ddh;
      boolean bool = ((AppBrandSysConfigWC)localObject2).jEl;
      localf.dialog = com.tencent.mm.plugin.appbrand.widget.dialog.f.u((Context)localObject3, true);
      localObject5 = (LinearLayout)LayoutInflater.from(localf.dialog.getContext()).inflate(2131492994, null, false);
      localf.dialog.setContentView((View)localObject5);
      Object localObject7 = aj.cl(localf.dialog.getContext());
      i = Math.min(((Point)localObject7).x, ((Point)localObject7).y);
      localObject7 = new FrameLayout.LayoutParams(i, -2);
      ((FrameLayout.LayoutParams)localObject7).gravity = 1;
      ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject7);
      ac.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "createEvaluateDialog, dialog width:%d", new Object[] { Integer.valueOf(i) });
      localf.mAV = ((TextView)localf.dialog.findViewById(2131299532));
      localf.mAW = ((LinearLayout)localf.dialog.findViewById(2131299533));
      localf.mAY = ((LinearLayout)localf.dialog.findViewById(2131299530));
      localObject7 = (TextView)localf.dialog.findViewById(2131299529);
      if (bool)
      {
        ((TextView)localObject7).setVisibility(0);
        ((TextView)localObject7).setOnClickListener(new f.15(localf, (Context)localObject3, (String)localObject4, (String)localObject6));
        label892:
        ((TextView)localf.dialog.findViewById(2131299536)).setOnClickListener(new f.16(localf, (Context)localObject3));
        localf.mAU = ((RatingBar)localf.dialog.findViewById(2131299534));
        localf.mAU.setOnRatingBarChangeListener(new f.17(localf));
        localf.mAT = ((TextView)localf.dialog.findViewById(2131299531));
        if (bs.isNullOrNil((String)localObject6)) {
          break label1211;
        }
        localf.mAT.setVisibility(0);
        localf.mAT.setText(((Context)localObject3).getString(2131755406, new Object[] { localObject6 }));
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
        localf.mAR = false;
        ((AppBrandSysConfigWC)localObject2).jEk = false;
        if (this != null) {
          break label1224;
        }
        localObject2 = null;
        label1151:
        localf.appId = ((String)localObject2);
        if (!bs.isNullOrNil(localf.appId)) {
          break label1233;
        }
        ac.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "saveEvaluateReport, no app id");
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
        localf.mAT.setVisibility(8);
        break label1017;
        label1224:
        localObject2 = this.mAppId;
        break label1151;
        label1233:
        localObject2 = (AppBrandInitConfigWC)super.DC();
        localf.sessionId = "";
        if (localObject2 != null) {
          localf.sessionId = ((AppBrandInitConfigWC)localObject2).CD();
        }
        localf.scene = 1000;
        if ((localObject2 != null) && (((AppBrandInitConfigLU)localObject2).ccl != null)) {
          localf.scene = ((AppBrandInitConfigLU)localObject2).ccl.scene;
        }
        localf.cYQ = "";
        if (((com.tencent.mm.plugin.appbrand.service.c)super.CX() != null) && (((com.tencent.mm.plugin.appbrand.service.c)super.CX()).aTP() != null)) {
          localf.cYQ = ((com.tencent.mm.plugin.appbrand.service.c)super.CX()).aTP().jZJ;
        }
      }
      label1351:
      if (j != 0)
      {
        ac.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "need show game evaluate dialog");
        localObject2 = localf.jPZ.lQE;
        localf.jPZ.lQE = null;
        localf.dialog = com.tencent.mm.plugin.appbrand.widget.dialog.f.u(com.tencent.mm.sdk.f.a.jg(this.mContext), false);
        localObject3 = (LinearLayout)LayoutInflater.from(localf.dialog.getContext()).inflate(2131492996, null, false);
        localf.dialog.setContentView((View)localObject3);
        localObject4 = aj.cl(localf.dialog.getContext());
        localObject4 = new FrameLayout.LayoutParams(Math.min(((Point)localObject4).x, ((Point)localObject4).y), ((LinearLayout)localObject3).getLayoutParams().height);
        ((FrameLayout.LayoutParams)localObject4).gravity = 1;
        ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        localObject5 = (TextView)((LinearLayout)localObject3).findViewById(2131305902);
        ((TextView)localObject5).setText(((ecm)localObject2).Title);
        localObject6 = (TextView)((LinearLayout)localObject3).findViewById(2131299531);
        ((TextView)localObject6).setText(((ecm)localObject2).GhX);
        localObject4 = (ImageView)((LinearLayout)localObject3).findViewById(2131299528);
        localObject5 = new f.21(localf, (TextView)localObject5, (TextView)localObject6, (ImageView)localObject4, (LinearLayout)localObject3, this, local12, (ecm)localObject2);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(2131303040)).a(0, (ecm)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(2131303041)).a(1, (ecm)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(2131303042)).a(2, (ecm)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        localf.dialog.setOnCancelListener(new f.2(localf, this, (ecm)localObject2, local12));
        ((ImageView)localObject4).setOnClickListener(new f.3(localf, this, (ecm)localObject2, local12));
        localf.dialog = localf.dialog;
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1237L, 4L, 1L, false);
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
      ((AppBrandInitConfigWC)super.DC()).resetSession();
      ((AppBrandInitConfigWC)super.DC()).startTime = bs.eWj();
      ((AppBrandInitConfigWC)super.DC()).jDH = new QualitySession(com.tencent.mm.plugin.appbrand.utils.a.vf(((AppBrandInitConfigWC)super.DC()).uin), (AppBrandInitConfigWC)super.DC(), DC().ccl);
    }
    super.ac(ICommLibReader.class);
    super.e(paramAppBrandInitConfig);
    AppMethodBeat.o(43900);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(43899);
    ac.i("MicroMsg.AppBrandRuntimeWC", "finish appId[%s] type[%d] hash[%d] stacktrace=%s", new Object[] { this.mAppId, Integer.valueOf(this.jdx.joY), Integer.valueOf(hashCode()), Log.getStackTraceString(new Throwable()) });
    if ((i.d(this)) || (this.jdt == null))
    {
      i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186250);
          o.this.dispatchDestroy();
          AppMethodBeat.o(186250);
        }
      }, 0L);
      AppMethodBeat.o(43899);
      return;
    }
    super.finish();
    if (this.jgo != null) {
      this.jgo.A(this);
    }
    AppMethodBeat.o(43899);
  }
  
  public final boolean fy(boolean paramBoolean)
  {
    AppMethodBeat.i(160536);
    long l = bs.eWj();
    ac.i("MicroMsg.AppBrandRuntimeWC", "showLaunchAdCallback, shouldShowToShow costTime:%s", new Object[] { Long.valueOf(l - this.jgr) });
    ac.i("MicroMsg.AppBrandRuntimeWC", "showLaunchAdCallback, startTimerToShow costTime:%s", new Object[] { Long.valueOf(l - this.jgs) });
    if ((this.jgu != null) && (this.jgu.eVs())) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.i("MicroMsg.AppBrandRuntimeWC", "showLaunchAdCallback, check time out");
      this.jgq = 3;
      com.tencent.mm.plugin.appbrand.report.quality.a.N(this);
      AppMethodBeat.o(160536);
      return false;
    }
    Ht("showLaunchAdCallback(" + paramBoolean + ")");
    if (paramBoolean)
    {
      ac.i("MicroMsg.AppBrandRuntimeWC", "showLaunchAdCallback, show launch ad");
      this.jgq = 1;
      aTc().show();
      com.tencent.mm.plugin.appbrand.ad.a.e locale = new com.tencent.mm.plugin.appbrand.ad.a.e();
      locale.source = "launch";
      locale.c(aTY());
      i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186246);
          o.this.aSF();
          AppMethodBeat.o(186246);
        }
      }, 0L);
    }
    for (;;)
    {
      AppMethodBeat.o(160536);
      return true;
      ac.i("MicroMsg.AppBrandRuntimeWC", "showLaunchAdCallback, not show launch ad");
      this.jgq = 2;
      com.tencent.mm.plugin.appbrand.report.quality.a.N(this);
      aUb();
      aUa();
    }
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(43903);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.plugin.appbrand.jsapi.t.h.a(paramConfiguration, this.mAppId);
    this.jgn = new Configuration(paramConfiguration);
    AppMethodBeat.o(43903);
  }
  
  protected void onCreate()
  {
    AppMethodBeat.i(43906);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepPrepareRuntime);
    fx(false);
    aTO();
    com.tencent.mm.plugin.appbrand.report.quality.a.btI();
    Object localObject1 = (AppBrandInitConfigWC)super.DC();
    Object localObject2;
    boolean bool;
    int i;
    if (localObject1 != null)
    {
      localObject2 = ((AppBrandInitConfigWC)localObject1).jDH;
      if (localObject2 != null) {}
    }
    else
    {
      a.setRuntime(this);
      com.tencent.mm.plugin.appbrand.f.a.X(this);
      aTL();
      bool = WXHardCoderJNI.hcMiniProgramLaunchEnable;
      int j = WXHardCoderJNI.hcMiniProgramLaunchDelay;
      int k = WXHardCoderJNI.hcMiniProgramLaunchCPU;
      int m = WXHardCoderJNI.hcMiniProgramLaunchIO;
      if (!WXHardCoderJNI.hcMiniProgramLaunchThr) {
        break label804;
      }
      i = Process.myTid();
      label95:
      this.jgi = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMiniProgramLaunchTimeout, 801, WXHardCoderJNI.hcMiniProgramLaunchAction, "MicroMsg.AppBrandRuntimeWC");
      ac.i("MicroMsg.AppBrandRuntimeWC", "hardcoder miniprogram launch launchStartPerformance [%d]", new Object[] { Integer.valueOf(this.jgi) });
      super.onCreate();
      aTN();
      if (!CC()) {
        break label809;
      }
      localObject1 = com.tencent.luggage.sdk.d.d.cfd;
      localObject1 = w.a.lko;
      com.tencent.luggage.sdk.d.d.bz(w.a.a.gR(true));
      label174:
      com.tencent.mm.plugin.appbrand.report.quality.a.K(this);
      localObject1 = com.tencent.mm.plugin.appbrand.report.quality.n.lWn;
      com.tencent.mm.plugin.appbrand.report.quality.n.ec(this.mAppId, com.tencent.mm.plugin.appbrand.report.quality.a.QN(this.mAppId).lht);
      com.tencent.mm.plugin.appbrand.report.quality.f.a(this, false, com.tencent.mm.plugin.appbrand.utils.a.Rs(((AppBrandInitConfigWC)super.DC()).jDE));
      localObject1 = com.tencent.luggage.game.e.a.Cp();
      localObject2 = this.mAppId;
      bool = CC();
      ((com.tencent.luggage.game.e.a)localObject1).appId = ((String)localObject2);
      ac.i("MicroMsg.MBNiReporter", "hy: appId:%s,isGame:%s", new Object[] { localObject2, Boolean.valueOf(bool) });
      if (bool) {
        g.a((String)localObject2, ((com.tencent.luggage.game.e.a)localObject1).cbu);
      }
      ((com.tencent.luggage.game.e.a)localObject1).cbm = new ArrayList();
      if (!bool) {
        break label829;
      }
      ((com.tencent.luggage.game.e.a)localObject1).cbq = 1004;
      label308:
      com.tencent.mm.plugin.t.a.a(this.mAppId, ((AppBrandInitConfigWC)super.DC()).jDB);
      if (this.jdD)
      {
        if (!CC()) {
          break label845;
        }
        localObject1 = (AppBrandInitConfigWC)super.DC();
        if (localObject1 == null) {
          break label840;
        }
        localObject1 = e.b.Qz(((AppBrandInitConfigWC)localObject1).jBP);
        if ((localObject1 != e.b.lOS) && (localObject1 != e.b.lOU) && (localObject1 != e.b.lOV)) {
          break label840;
        }
        i = 1;
        label389:
        if (i == 0) {
          break label845;
        }
        ac.i("MicroMsg.AppBrandRuntimeWC", "onCreate, may show ad && landscape-game, add check show ad prepare process");
        localObject1 = new b((byte)0);
        this.jgw = ((b)localObject1);
        a((AppBrandRuntime.b)localObject1);
      }
      label424:
      a(new AppBrandRuntime.b()
      {
        public final void prepare()
        {
          AppMethodBeat.i(186253);
          com.tencent.mm.plugin.appbrand.keylogger.c.a(o.this.mAppId, KSProcessWeAppLaunch.stepWaitForCommLibConfirm);
          com.tencent.mm.plugin.appbrand.launching.g.a(o.this, new d.g.a.b() {});
          AppMethodBeat.o(186253);
        }
      });
      a(new AppBrandRuntime.b()
      {
        public final void prepare()
        {
          AppMethodBeat.i(186254);
          o.a(o.this, this);
          AppMethodBeat.o(186254);
        }
      });
      a(new c((byte)0));
      localObject1 = new k(this);
      this.jgm = ((k)localObject1);
      a((AppBrandRuntime.b)localObject1);
      this.jge.a(this.mAppId, ((AppBrandInitConfigWC)super.DC()).joY, com.tencent.mm.plugin.appbrand.task.e.i((AppBrandInitConfigWC)super.DC()));
      com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
      com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.x(this);
      com.tencent.mm.plugin.appbrand.backgroundfetch.i.x(this);
      com.tencent.mm.plugin.appbrand.utils.f.S(this);
      OpenBusinessViewUtil.D(this);
      AppBrandBackgroundRunningMonitor.y(this);
      this.jgf = new com.tencent.mm.plugin.appbrand.report.model.n();
      this.jgf.lTH = bs.Gn();
      com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j.a(this.mAppId, aSI(), DC().ccl);
      if (DC().ccl.scene != 1099) {
        break label860;
      }
      bool = true;
      label595:
      this.jgj = bool;
      if (aTJ()) {
        this.jgk.add(new ad((AppBrandInitConfigWC)super.DC()));
      }
      this.jdK.a(new com.tencent.mm.plugin.appbrand.b.c.a()
      {
        public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
        {
          AppMethodBeat.i(186255);
          if (com.tencent.mm.plugin.appbrand.b.b.jqW == paramAnonymousb)
          {
            o.this.jgd.kJo.kJp.clear();
            com.tencent.mm.plugin.appbrand.report.quality.j.bS(paramAnonymousString, 4);
          }
          AppMethodBeat.o(186255);
        }
      });
      if ((!aTJ()) && (!ao.w(this))) {
        break label866;
      }
      ac.w("MicroMsg.AppBrandRuntimeWC", "initFloatBallHelper appId[%s], skip fakeNative", new Object[] { this.mAppId });
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.appbrand.report.quality.a.QN(this.mAppId);
      if (localObject1 != null) {
        ((QualitySession)localObject1).lVt = (bs.eWj() - ((AppBrandInitConfigWC)super.DC()).startTime);
      }
      Hj("onCreate");
      aw.aKT(this.mAppId + "_wxa_voip").putBoolean("isCameraStart", false);
      ac.i("MicroMsg.AppBrandRuntimeWC", "reset appId:%s isCameraStart false", new Object[] { this.mAppId });
      AppMethodBeat.o(43906);
      return;
      com.tencent.mm.ac.c.b(null, (d.g.a.a)new c.b(a.aSn(), (QualitySession)localObject2, (AppBrandInitConfigWC)localObject1));
      break;
      label804:
      i = 0;
      break label95;
      label809:
      localObject1 = com.tencent.luggage.sdk.d.d.cfd;
      localObject1 = w.a.lko;
      com.tencent.luggage.sdk.d.d.by(w.a.a.gR(false));
      break label174;
      label829:
      ((com.tencent.luggage.game.e.a)localObject1).cbq = 1000;
      break label308;
      label840:
      i = 0;
      break label389;
      label845:
      ac.i("MicroMsg.AppBrandRuntimeWC", "onCreate, may show ad && non-landscape-game, just start check show ad timer");
      aTZ();
      break label424;
      label860:
      bool = false;
      break label595;
      label866:
      this.jgo = new com.tencent.mm.plugin.appbrand.floatball.d();
      localObject1 = this.jgo;
      ac.i("MicroMsg.AppBrandFloatBallLogic", "init, runtime:%s", new Object[] { this.mAppId });
      com.tencent.e.h.JZN.f(new d.1((com.tencent.mm.plugin.appbrand.floatball.d)localObject1, this), "FloatBallHelperThread");
    }
  }
  
  public final void onDestroy()
  {
    int j = 1;
    AppMethodBeat.i(43914);
    super.onDestroy();
    MMToClientEvent.f((com.tencent.mm.plugin.appbrand.service.c)super.CX());
    com.tencent.mm.plugin.appbrand.f.a.Y(this);
    com.tencent.mm.plugin.appbrand.report.quality.a.M(this);
    if (this.jgi != 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.jgi);
      this.jgi = 0;
    }
    if (DebuggerShell.baW())
    {
      if (this.jgl != null) {
        this.jgl.stopTimer();
      }
      com.tencent.e.h.JZN.aS(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186227);
          AppBrandPerformanceManager.g(o.this);
          AppMethodBeat.o(186227);
        }
      });
      com.tencent.mm.plugin.appbrand.performance.b.Qg(this.mAppId);
    }
    if (CC()) {
      com.tencent.mm.plugin.appbrand.game.preload.d.B(this);
    }
    ??? = AppBrandMusicClientService.lrI;
    ((AppBrandMusicClientService)???).lrH.clear();
    ((AppBrandMusicClientService)???).lrJ = "";
    n.remove(this.mAppId);
    com.tencent.mm.plugin.appbrand.media.record.c.onDestroy();
    aTQ();
    this.jge = null;
    ??? = Dz();
    Object localObject2;
    if (??? != null)
    {
      localObject2 = (com.tencent.mm.plugin.appbrand.appstorage.n)((com.tencent.mm.plugin.appbrand.appstorage.t)???).av(com.tencent.mm.plugin.appbrand.appstorage.n.class);
      if (localObject2 != null) {
        com.tencent.mm.vfs.i.deleteFile(((com.tencent.mm.plugin.appbrand.appstorage.n)localObject2).jsT + "/dir.lock");
      }
      ((com.tencent.mm.plugin.appbrand.appstorage.t)???).release();
    }
    this.jgx.lzw.clear();
    a.b(this);
    ??? = this.jgf;
    int i;
    if (??? != null)
    {
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).sessionId = ((AppBrandInitConfigWC)super.DC()).CD();
      localObject2 = n.Hr(this.mAppId);
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).lTf = com.tencent.mm.plugin.appbrand.report.g.getNetworkType(com.tencent.mm.sdk.platformtools.ai.getContext());
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).appId = this.mAppId;
      if (aTR() != null) {
        break label505;
      }
      i = ((AppBrandInitConfigWC)super.DC()).aBM;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).aBM = i;
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).cYO = (this.jdx.joY + 1);
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).scene = DC().ccl.scene;
      if (((com.tencent.mm.plugin.appbrand.report.model.n)???).lTI)
      {
        i = 1;
        label326:
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).lTJ = i;
        if (!((n)localObject2).jfP.get()) {
          break label524;
        }
        i = j;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).lTK = i;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).lTL = bs.aO(((com.tencent.mm.plugin.appbrand.report.model.n)???).lTH);
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).lTM = bs.eWj();
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).username = ((AppBrandInitConfigWC)super.DC()).username;
        localObject2 = com.tencent.mm.plugin.appbrand.report.quality.a.QN(this.mAppId);
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).lTN = ((QualitySessionRuntime)localObject2).apptype;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).lht = ((QualitySessionRuntime)localObject2).lht;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).report();
        com.tencent.mm.plugin.appbrand.ui.recommend.e.P(this);
        this.jgf = null;
        this.jgh = false;
        this.jgm = null;
        Ht("onDestroy");
        this.jgw = null;
        this.jgA.clear();
        this.jgk.clear();
        ??? = this.jgd;
        ((com.tencent.mm.plugin.appbrand.jsapi.r.a)???).kJo.kJp.clear();
      }
      synchronized (((com.tencent.mm.plugin.appbrand.jsapi.r.a)???).kJn)
      {
        ((SparseArray)???).clear();
        localObject2 = y.KTp;
        com.tencent.mm.plugin.appbrand.jsapi.z.b.c.release();
        AppMethodBeat.o(43914);
        return;
        label505:
        i = aTR().jEg.pkgVersion;
        continue;
        i = 0;
        break label326;
        label524:
        i = 0;
      }
    }
  }
  
  public final void onEnterAnimationComplete()
  {
    AppMethodBeat.i(174690);
    if ((isDestroyed()) || (this.QM))
    {
      AppMethodBeat.o(174690);
      return;
    }
    Object localObject = com.tencent.mm.plugin.appbrand.report.quality.a.QN(this.mAppId);
    if (localObject != null) {
      ((QualitySessionRuntime)localObject).lVA = bs.eWj();
    }
    localObject = super.aSY();
    if ((localObject instanceof com.tencent.mm.plugin.appbrand.ui.w)) {
      ((com.tencent.mm.plugin.appbrand.ui.w)localObject).setCanShowHideAnimation(true);
    }
    AppMethodBeat.o(174690);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(43912);
    super.onPause();
    Object localObject = this.jge;
    ((AppBrandRemoteTaskController)localObject).lXU = AppBrandRemoteTaskController.a.lYp;
    AppBrandMainProcessService.a((MainProcessTask)localObject);
    if (this.jgo != null)
    {
      localObject = this.jgo;
      ac.i("MicroMsg.AppBrandFloatBallLogic", "pause, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPp != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPp.bcY();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPq != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPq.bcY();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPr != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPr.bcY();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPt != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPt.bcY();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPs != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPs.bcY();
      }
    }
    aTI().aUf();
    AppMethodBeat.o(43912);
  }
  
  public void onReady()
  {
    AppMethodBeat.i(43909);
    super.onReady();
    n.Hs(this.mAppId).lastResumeTime = System.currentTimeMillis();
    if (this.jgi != 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.jgi);
      this.jgi = 0;
    }
    long l1 = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.DC()).startTime;
    com.tencent.mm.plugin.appbrand.report.g.a(l1, this.jgh, CC());
    boolean bool1;
    Object localObject2;
    int i;
    label256:
    label271:
    Object localObject3;
    label317:
    Object localObject4;
    if ((AppBrandInitConfigWC)super.DC() != null)
    {
      localObject1 = ((AppBrandInitConfigWC)super.DC()).ddh;
      ac.i("MicroMsg.AppBrandRuntimeWC", "onReady reportStartupTime: %s, cost: %dms, download : %b", new Object[] { localObject1, Long.valueOf(l1), Boolean.valueOf(this.jgh) });
      l1 = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.DC()).startTime;
      this.jgg.E(5, l1);
      localObject1 = this.jgg;
      bool1 = this.jgh;
      boolean bool2 = ((AppBrandInitConfigWC)super.DC()).cck;
      boolean bool3 = ((AppStartupPerformanceReportBundle)ar(AppStartupPerformanceReportBundle.class)).ljh;
      localObject2 = this.mAppId;
      ((m)localObject1).cR = 0;
      ((m)localObject1).mType = 0;
      if (aTR() != null)
      {
        ((m)localObject1).cR = aTR().jEg.pkgVersion;
        ((m)localObject1).mType = (aTR().jEg.jpa + 1);
      }
      if (!bool1) {
        break label1104;
      }
      i = 1;
      ((m)localObject1).jfG = i;
      if (!CC()) {
        break label1109;
      }
      i = 1;
      ((m)localObject1).jfK = i;
      ((m)localObject1).mScene = DC().ccl.scene;
      ((m)localObject1).jfI = bool2;
      ((m)localObject1).jfJ = bool3;
      localObject3 = new StringBuilder();
      i = 0;
      if (i >= ((m)localObject1).jfF.length) {
        break label1143;
      }
      if (localObject1.jfF[i] >= 0L) {
        break label1114;
      }
      ac.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: abort, illegal value: %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(localObject1.jfF[i]) });
      AppBrandPerformanceManager.a(this, 202, l1);
      com.tencent.mm.plugin.appbrand.performance.c.qX(((AppBrandInitConfigWC)super.DC()).startTime);
      com.tencent.mm.plugin.appbrand.report.quality.a.a(this.mAppId, this);
      if ((DebuggerShell.baW()) && (this.jgl == null))
      {
        this.jgl = new au("AppBrandRuntimeWC.mDumpTracerTimer", new au.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(186241);
            com.tencent.mm.plugin.appbrand.performance.b.g(o.this);
            AppMethodBeat.o(186241);
            return true;
          }
        }, true);
        this.jgl.au(1000L, 1000L);
      }
      if (CC())
      {
        localObject1 = com.tencent.mm.plugin.appbrand.game.preload.d.bdT();
        l1 = bs.eWj();
        long l2 = ((AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).jPl.DC()).startTime;
        com.tencent.mm.plugin.appbrand.game.preload.e.bdV().dK(2001, (int)(l1 - l2));
      }
      com.tencent.mm.plugin.appbrand.ui.recommend.e.Q(this);
      this.jge.hs(false);
      if (Dz() != null)
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.appstorage.n)Dz().av(com.tencent.mm.plugin.appbrand.appstorage.n.class);
        com.tencent.mm.vfs.i.f(((com.tencent.mm.plugin.appbrand.appstorage.n)localObject1).jsT + "/dir.lock", new byte[1], 1);
      }
      localObject4 = com.tencent.mm.plugin.appbrand.report.quality.a.QN(this.mAppId);
      if ((localObject4 != null) && (!CC()))
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.btI();
        d.g.b.k.h(this, "runtime");
        hz localhz = new hz();
        localObject3 = com.tencent.mm.plugin.appbrand.report.quality.a.QN(this.mAppId);
        if (localObject3 == null) {
          break label1465;
        }
        localhz.dZT = localhz.t("InstanceId", ((QualitySessionRuntime)localObject3).lht, true);
        localhz.ecm = localhz.t("AppId", ((QualitySessionRuntime)localObject3).appId, true);
        localhz.eaM = ((QualitySessionRuntime)localObject3).lVs;
        localhz.eiO = hz.a.jm(((QualitySessionRuntime)localObject3).lTR);
        localhz.eco = ((QualitySessionRuntime)localObject3).apptype;
        localhz.dHY = ((QualitySessionRuntime)localObject3).scene;
        localObject1 = (v)super.aSA();
        d.g.b.k.g(localObject1, "runtime.pageContainer");
        localObject1 = ((v)localObject1).getCurrentPage();
        if (localObject1 == null) {
          break label1459;
        }
        localObject1 = ((r)localObject1).getCurrentPageView();
        label737:
        localObject2 = localObject1;
        if (!(localObject1 instanceof com.tencent.mm.plugin.appbrand.page.ae)) {
          localObject2 = null;
        }
        localhz.eaY = com.tencent.mm.plugin.appbrand.report.quality.c.x((com.tencent.mm.plugin.appbrand.page.ae)localObject2);
        localObject1 = localObject3;
        label769:
        com.tencent.mm.plugin.appbrand.report.quality.c.a((QualitySessionRuntime)localObject1, "Null session with " + this.mAppId);
        localhz.edd = ((QualitySessionRuntime)localObject4).btP();
        localhz.aHZ();
      }
      if (localObject4 != null)
      {
        com.tencent.mm.plugin.appbrand.report.quality.a.btI();
        d.g.b.k.h(this, "runtime");
        localObject3 = new ha();
        localObject2 = com.tencent.mm.plugin.appbrand.report.quality.a.QN(this.mAppId);
        if (localObject2 == null) {
          break label1508;
        }
        ((ha)localObject3).dZT = ((ha)localObject3).t("InstanceId", ((QualitySessionRuntime)localObject2).lht, true);
        ((ha)localObject3).ecm = ((ha)localObject3).t("AppId", ((QualitySessionRuntime)localObject2).appId, true);
        ((ha)localObject3).eaM = ((QualitySessionRuntime)localObject2).lVs;
        ((ha)localObject3).eef = ha.a.iP(((QualitySessionRuntime)localObject2).lTR);
        ((ha)localObject3).eco = ((QualitySessionRuntime)localObject2).apptype;
        ((ha)localObject3).dHY = ((QualitySessionRuntime)localObject2).scene;
        localObject1 = (com.tencent.mm.plugin.appbrand.service.c)super.CX();
        if (localObject1 == null) {
          break label1471;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.service.c)localObject1).aUV();
        label954:
        localObject1 = com.tencent.mm.plugin.appbrand.report.c.d((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject1);
        switch (com.tencent.mm.plugin.appbrand.report.quality.d.cfA[localObject1.ordinal()])
        {
        default: 
          i = -1;
          label1010:
          ((ha)localObject3).eaY = i;
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
      ((ha)localObject3).edd = ((QualitySessionRuntime)localObject4).btP();
      ((ha)localObject3).aHZ();
      com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup);
      com.tencent.mm.plugin.appbrand.keylogger.c.b(KSProcessWeAppLaunch.class, this.mAppId);
      com.tencent.mm.plugin.appbrand.report.quality.j.bS(this.mAppId, 1);
      AppMethodBeat.o(43909);
      return;
      localObject1 = "";
      break;
      i = 0;
      break label256;
      i = 0;
      break label271;
      ((StringBuilder)localObject3).append(localObject1.jfF[i]);
      ((StringBuilder)localObject3).append(",");
      i += 1;
      break label317;
      label1143:
      localObject4 = (AppBrandInitConfigWC)super.DC();
      if (localObject4 != null) {
        i = ((AppBrandInitConfigWC)localObject4).cca;
      }
      for (;;)
      {
        i += 1000;
        ac.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: %s, %s, Download: %s, Preload: %s, appServiceType: %s", new Object[] { localObject2, ((StringBuilder)localObject3).toString(), Boolean.valueOf(bool1), Boolean.valueOf(com.tencent.mm.plugin.appbrand.task.c.aUy()), Integer.valueOf(i) });
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
        x.a(4, localObject1.jfF[5], ((m)localObject1).jfH, (String)localObject2, ((m)localObject1).jfG, ((m)localObject1).jfK, fw(false).aVU());
        break;
        i = com.tencent.mm.plugin.appbrand.report.h.QD((String)localObject2);
        ac.i("MicroMsg.AppBrandRuntimeStartupReporter", "getServiceTypeForReport null = initConfig! appServiceType:%s", new Object[] { Integer.valueOf(i) });
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
    n.Hs(this.mAppId).lastResumeTime = System.currentTimeMillis();
    if (this.jgo != null)
    {
      localObject = this.jgo;
      ac.i("MicroMsg.AppBrandFloatBallLogic", "resume, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPp != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPp.bcX();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPq != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPq.bcX();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPr != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPr.bcX();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPt != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPt.bcX();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPs != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).jPs.bcX();
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j.a(this.mAppId, aSI(), DC().ccl);
    a.setRuntime(this);
    com.tencent.mm.plugin.appbrand.f.a.X(this);
    this.jge.bT(this.mAppId, ((AppBrandInitConfigWC)super.DC()).joY);
    if (this.jdN) {
      ((v)super.aSA()).getReporter().bow();
    }
    Object localObject = this.mAppId;
    int i = DC().ccl.scene;
    AppBrandIDKeyBatchReport.bsW().lQK = 1;
    AppBrandIDKeyBatchReport.bsW().lQM = ((String)localObject);
    AppBrandIDKeyBatchReport.bsW().lQN = i;
    AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.bsW());
    localObject = s.a(this, new o.3(this));
    keep((com.tencent.mm.vending.e.a)localObject);
    com.tencent.e.h.JZN.f((Runnable)localObject, "getCopyPathMenuExpireTime");
    com.tencent.mm.plugin.appbrand.ipc.b.connect();
    if (aTP() != null)
    {
      aTI().Hu(aTP().jZJ);
      AppMethodBeat.o(43911);
      return;
    }
    ac.w("MicroMsg.AppBrandRuntimeWC", "onResume, try upsertHandOff but get NULL PageView, appId:%s", new Object[] { this.mAppId });
    AppMethodBeat.o(43911);
  }
  
  public final void rc(int paramInt)
  {
    AppMethodBeat.i(43932);
    com.tencent.mm.plugin.appbrand.ui.u localu = super.aSY();
    if ((localu instanceof com.tencent.mm.plugin.appbrand.launching.q)) {
      ((com.tencent.mm.plugin.appbrand.launching.q)localu).rc(paramInt);
    }
    AppMethodBeat.o(43932);
  }
  
  public String toString()
  {
    AppMethodBeat.i(43886);
    Locale localLocale = Locale.ENGLISH;
    String str2 = this.mAppId;
    if ((AppBrandInitConfigWC)super.DC() == null) {}
    for (String str1 = "NULL";; str1 = ((AppBrandInitConfigWC)super.DC()).ddh)
    {
      str1 = String.format(localLocale, "[AppBrandRuntimeWC::%s::%s::%d::@%d]", new Object[] { str2, str1, Integer.valueOf(this.jdx.joY), Integer.valueOf(hashCode()) });
      AppMethodBeat.o(43886);
      return str1;
    }
  }
  
  final class a
    implements Runnable
  {
    private final AtomicBoolean jgL;
    
    a()
    {
      AppMethodBeat.i(43871);
      this.jgL = new AtomicBoolean(false);
      AppMethodBeat.o(43871);
    }
    
    public final void run()
    {
      AppMethodBeat.i(43872);
      if (!this.jgL.getAndSet(true))
      {
        ac.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] addPendingPermissionUpdateTask run()");
        paramRunnable.run();
      }
      AppMethodBeat.o(43872);
    }
  }
  
  final class b
    extends AppBrandRuntime.b
  {
    boolean bMz = false;
    
    private b() {}
    
    public final void Al()
    {
      AppMethodBeat.i(160528);
      super.Al();
      this.bMz = true;
      AppMethodBeat.o(160528);
    }
    
    public final void prepare()
    {
      AppMethodBeat.i(160527);
      this.bMz = false;
      o.o(o.this);
      AppMethodBeat.o(160527);
    }
  }
  
  final class c
    extends AppBrandRuntime.b
  {
    volatile AppBrandPrepareTask jgR;
    volatile boolean jgS = false;
    
    private c() {}
    
    public final void interrupt()
    {
      AppMethodBeat.i(43884);
      this.jgS = true;
      AppBrandPrepareTask localAppBrandPrepareTask = this.jgR;
      Object localObject;
      if (localAppBrandPrepareTask != null)
      {
        if (localAppBrandPrepareTask.lhw != null) {
          break label83;
        }
        localObject = null;
        if (localAppBrandPrepareTask.lhw != null) {
          break label94;
        }
      }
      label83:
      label94:
      for (int i = -1;; i = AppBrandPrepareTask.PrepareParams.a(localAppBrandPrepareTask.lhw))
      {
        ac.i("MicroMsg.AppBrandPrepareTask", "interrupt() appId[%s] type[%d]", new Object[] { localObject, Integer.valueOf(i) });
        localAppBrandPrepareTask.jgS = true;
        localObject = localAppBrandPrepareTask.lhx;
        if (localObject != null) {
          ((com.tencent.mm.plugin.appbrand.launching.ar)localObject).dead();
        }
        AppMethodBeat.o(43884);
        return;
        localObject = localAppBrandPrepareTask.lhw.mAppId;
        break;
      }
    }
    
    public final void prepare()
    {
      AppMethodBeat.i(43883);
      ac.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| ResourcePrepareProcess.prepare() appId:%s", new Object[] { o.this.mAppId });
      com.tencent.mm.plugin.appbrand.launching.g.a(o.this, new d.g.a.b()
      {
        private y aUi()
        {
          AppMethodBeat.i(162153);
          if (!o.c.this.jgS) {}
          try
          {
            o.c.this.jgR = o.b(o.this, o.c.this);
            y localy = y.KTp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o
 * JD-Core Version:    0.7.0.1
 */