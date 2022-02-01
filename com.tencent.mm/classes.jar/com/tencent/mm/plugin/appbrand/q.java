package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
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
import com.tencent.mm.g.b.a.ma;
import com.tencent.mm.g.b.a.ma.a;
import com.tencent.mm.g.b.a.nb;
import com.tencent.mm.g.b.a.nb.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.a.d.a;
import com.tencent.mm.plugin.appbrand.api.ParcelableMultiTaskData;
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
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.b.e;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.floatball.c.2;
import com.tencent.mm.plugin.appbrand.floatball.c.3;
import com.tencent.mm.plugin.appbrand.game.preload.d.2;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.EventLocationBackgroundStateChanged;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy;
import com.tencent.mm.plugin.appbrand.launching.g.b;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.launching.v.a;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper.GetCopyPathMenuExpireTimeTask;
import com.tencent.mm.plugin.appbrand.message.WxaAppMsgChannel;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.ba;
import com.tencent.mm.plugin.appbrand.page.bs;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.g.a;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.d.b;
import com.tencent.mm.plugin.appbrand.report.x.a;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.appbrand.ui.v;
import com.tencent.mm.plugin.appbrand.utils.u;
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
import com.tencent.mm.protocal.protobuf.fdn;
import com.tencent.mm.protocal.protobuf.ffc;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ao;
import com.tencent.xweb.WebView;
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

public class q
  extends com.tencent.luggage.sdk.d.d
  implements com.tencent.luggage.sdk.g.c.a, com.tencent.mm.plugin.appbrand.launching.q
{
  public static final boolean kDg;
  private final com.tencent.mm.plugin.appbrand.task.f kDA;
  private final Queue<Runnable> kDB;
  private com.tencent.mm.plugin.appbrand.platform.window.f kDC;
  public final com.tencent.mm.plugin.appbrand.jsapi.w.a kDh;
  protected AppBrandRemoteTaskController kDi;
  private volatile com.tencent.mm.plugin.appbrand.report.model.n kDj;
  public o kDk;
  public boolean kDl;
  private int kDm;
  private boolean kDn;
  private final List<aj> kDo;
  private MTimerHandler kDp;
  volatile m kDq;
  private Configuration kDr;
  private com.tencent.mm.plugin.appbrand.floatball.c kDs;
  private com.tencent.mm.plugin.appbrand.q.c kDt;
  public com.tencent.mm.plugin.appbrand.ad.h kDu;
  private com.tencent.luggage.sdk.d.f<AppBrandInitConfigWC> kDv;
  private com.tencent.mm.plugin.appbrand.report.p kDw;
  private com.tencent.mm.plugin.appbrand.page.e kDx;
  com.tencent.mm.plugin.appbrand.report.model.r kDy;
  private com.tencent.mm.plugin.appbrand.k.b kDz;
  
  static
  {
    AppMethodBeat.i(43955);
    if ((WeChatEnvironment.hasDebugger()) || (DebuggerShell.bAx()) || (com.tencent.mm.protocal.d.KyR) || (com.tencent.mm.protocal.d.KyS)) {}
    for (boolean bool = true;; bool = false)
    {
      kDg = bool;
      AppMethodBeat.o(43955);
      return;
    }
  }
  
  public q(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    super(paramAppBrandRuntimeContainerWC);
    AppMethodBeat.i(174681);
    this.kDh = new com.tencent.mm.plugin.appbrand.jsapi.w.a();
    this.kDm = 0;
    this.kDo = new LinkedList();
    this.kDp = null;
    this.kDA = new com.tencent.mm.plugin.appbrand.task.f()
    {
      private boolean aL(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(226199);
        if (q.this.kDi == null)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeController checkTokenOk with reason[%s], get NULL mRemoteController from runtime", new Object[] { paramAnonymousString });
          AppMethodBeat.o(226199);
          return true;
        }
        if (paramAnonymousInt == q.this.kDi.hashCode())
        {
          AppMethodBeat.o(226199);
          return true;
        }
        AppMethodBeat.o(226199);
        return false;
      }
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(226202);
        if (aL("onNetworkChange", paramAnonymousInt))
        {
          com.tencent.mm.plugin.appbrand.networking.d locald = (com.tencent.mm.plugin.appbrand.networking.d)q.this.af(com.tencent.mm.plugin.appbrand.networking.d.class);
          if ((locald instanceof com.tencent.mm.plugin.appbrand.networking.g)) {
            ((com.tencent.mm.plugin.appbrand.networking.g)locald).bPO();
          }
        }
        AppMethodBeat.o(226202);
      }
      
      public final void vA(int paramAnonymousInt)
      {
        AppMethodBeat.i(226200);
        if (aL("finish", paramAnonymousInt)) {
          q.this.finish();
        }
        AppMethodBeat.o(226200);
      }
      
      public final void vB(int paramAnonymousInt)
      {
        AppMethodBeat.i(226201);
        if ((aL("close", paramAnonymousInt)) && (q.this.mResumed)) {
          q.this.close();
        }
        AppMethodBeat.o(226201);
      }
    };
    this.kDB = new LinkedBlockingQueue();
    a(paramAppBrandRuntimeContainerWC);
    bso();
    AppMethodBeat.o(174681);
  }
  
  public q(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(226211);
    this.kDh = new com.tencent.mm.plugin.appbrand.jsapi.w.a();
    this.kDm = 0;
    this.kDo = new LinkedList();
    this.kDp = null;
    this.kDA = new com.tencent.mm.plugin.appbrand.task.f()
    {
      private boolean aL(String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(226199);
        if (q.this.kDi == null)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeController checkTokenOk with reason[%s], get NULL mRemoteController from runtime", new Object[] { paramAnonymousString });
          AppMethodBeat.o(226199);
          return true;
        }
        if (paramAnonymousInt == q.this.kDi.hashCode())
        {
          AppMethodBeat.o(226199);
          return true;
        }
        AppMethodBeat.o(226199);
        return false;
      }
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(226202);
        if (aL("onNetworkChange", paramAnonymousInt))
        {
          com.tencent.mm.plugin.appbrand.networking.d locald = (com.tencent.mm.plugin.appbrand.networking.d)q.this.af(com.tencent.mm.plugin.appbrand.networking.d.class);
          if ((locald instanceof com.tencent.mm.plugin.appbrand.networking.g)) {
            ((com.tencent.mm.plugin.appbrand.networking.g)locald).bPO();
          }
        }
        AppMethodBeat.o(226202);
      }
      
      public final void vA(int paramAnonymousInt)
      {
        AppMethodBeat.i(226200);
        if (aL("finish", paramAnonymousInt)) {
          q.this.finish();
        }
        AppMethodBeat.o(226200);
      }
      
      public final void vB(int paramAnonymousInt)
      {
        AppMethodBeat.i(226201);
        if ((aL("close", paramAnonymousInt)) && (q.this.mResumed)) {
          q.this.close();
        }
        AppMethodBeat.o(226201);
      }
    };
    this.kDB = new LinkedBlockingQueue();
    a(null);
    bso();
    AppMethodBeat.o(226211);
  }
  
  private void bsF()
  {
    AppMethodBeat.i(226229);
    if ((((AppBrandInitConfigWC)super.ON()).leg) && (AndroidContextUtil.castActivityOrNull(this.mContext) != null))
    {
      this.kDv = new com.tencent.mm.plugin.appbrand.o.a(this, AndroidContextUtil.castActivityOrNull(this.mContext), super.getWindowAndroid());
      if ((com.tencent.mm.plugin.appbrand.service.c)super.NY() != null) {
        ((com.tencent.mm.plugin.appbrand.service.c)super.NY()).b(getWindowAndroid());
      }
      com.tencent.mm.plugin.appbrand.page.ag localag = bsz();
      if (localag != null) {
        localag.b(getWindowAndroid());
      }
    }
    AppMethodBeat.o(226229);
  }
  
  public static int bsK()
  {
    AppMethodBeat.i(226233);
    int i = com.tencent.mm.plugin.appbrand.ad.b.btI();
    AppMethodBeat.o(226233);
    return i;
  }
  
  public static int bsL()
  {
    AppMethodBeat.i(226234);
    int i = com.tencent.mm.plugin.appbrand.ad.b.btI();
    AppMethodBeat.o(226234);
    return i;
  }
  
  private void bso()
  {
    AppMethodBeat.i(226212);
    Assert.assertTrue("AppBrandRuntimeWC's initial context should be AppBrandRuntimePersistentContextWrapper", this.mContext instanceof com.tencent.mm.plugin.appbrand.ui.n);
    this.kDk = new o();
    this.kDw = new com.tencent.mm.plugin.appbrand.report.p();
    this.kAU = kDg;
    AppMethodBeat.o(226212);
  }
  
  private void bst()
  {
    AppMethodBeat.i(43896);
    if (!kDg)
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
      localObject = this.mAppId + ":" + ((AppBrandInitConfigWC)super.ON()).brandName;
      this.kAt.setContentDescription((CharSequence)localObject);
      AppMethodBeat.o(43896);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(43896);
    }
  }
  
  private void bsw()
  {
    AppMethodBeat.i(226218);
    if ((bsr()) || (bb.r(this)))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "initFloatBallHelper appId[%s], skip fakeNative", new Object[] { this.mAppId });
      AppMethodBeat.o(226218);
      return;
    }
    if (this.kDs != null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "initFloatBallHelper, destroy");
      this.kDs.w(this);
    }
    this.kDs = new com.tencent.mm.plugin.appbrand.floatball.c();
    this.kDs.v(this);
    AppMethodBeat.o(226218);
  }
  
  private void bsx()
  {
    AppMethodBeat.i(226219);
    if ((bsr()) || (bb.r(this)))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "initMultiTaskHelper appId[%s], skip fakeNative", new Object[] { this.mAppId });
      AppMethodBeat.o(226219);
      return;
    }
    if (this.kDt != null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "initMultiTaskHelper, destroy");
      com.tencent.mm.plugin.appbrand.q.c.w(this);
    }
    this.kDt = new com.tencent.mm.plugin.appbrand.q.c();
    this.kDt.v(this);
    AppMethodBeat.o(226219);
  }
  
  private ICommLibReader gt(boolean paramBoolean)
  {
    AppMethodBeat.i(43890);
    Object localObject = (ICommLibReader)super.af(ICommLibReader.class);
    if ((localObject == null) && (paramBoolean))
    {
      localObject = new ICommLibReader.a();
      AppMethodBeat.o(43890);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(43890);
    return localObject;
  }
  
  private void gu(boolean paramBoolean)
  {
    AppMethodBeat.i(226214);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "createRemoteController(force:%b), appId:%s, mRemoteController:%s", new Object[] { Boolean.valueOf(paramBoolean), this.mAppId, this.kDi });
    if ((this.kDi == null) || (paramBoolean))
    {
      if (this.kDi != null) {
        this.kDi.bDK();
      }
      if (((getWindowAndroid() instanceof com.tencent.mm.plugin.appbrand.platform.window.b.a)) || (this.kAl == null))
      {
        this.kDi = new AppBrandRemoteTaskController();
        this.kDi.a(this.kDA);
        AppMethodBeat.o(226214);
        return;
      }
      this.kDi = new AppBrandRemoteTaskController();
      AppBrandRuntimeContainerWC localAppBrandRuntimeContainerWC = (AppBrandRuntimeContainerWC)Objects.requireNonNull((AppBrandRuntimeContainerWC)this.kAl);
      this.kDi.a(localAppBrandRuntimeContainerWC.kCd, this.kDA);
    }
    AppMethodBeat.o(226214);
  }
  
  private void gv(boolean paramBoolean)
  {
    AppMethodBeat.i(226223);
    if (this.kDi != null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "notifyRemovedToMMTaskManager(isForDestroy:%b), appId:%s", new Object[] { Boolean.valueOf(paramBoolean), this.mAppId });
      this.kDi.aeZ(this.mAppId);
      if (paramBoolean)
      {
        this.kDi.bDK();
        this.kDi = null;
        AppMethodBeat.o(226223);
      }
    }
    else
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntimeWC", "notifyRemovedToMMTaskManager(isForDestroy:%b), appId:%s, mRemoteController==NULL", new Object[] { Boolean.valueOf(paramBoolean), this.mAppId });
    }
    AppMethodBeat.o(226223);
  }
  
  private void vx(int paramInt)
  {
    AppMethodBeat.i(43929);
    o.a(paramInt, (AppBrandInitConfigWC)super.ON());
    AppMethodBeat.o(43929);
  }
  
  protected final boolean N(Runnable paramRunnable)
  {
    AppMethodBeat.i(226224);
    if ((super.brK() instanceof aa))
    {
      i(paramRunnable, 3000L);
      AppMethodBeat.o(226224);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rZF, false))
    {
      boolean bool = getAppConfig().lbV;
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "manualHideSplash:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(226224);
      return bool;
    }
    AppMethodBeat.o(226224);
    return false;
  }
  
  public final boolean NA()
  {
    AppMethodBeat.i(258355);
    boolean bool = ((AppBrandInitConfigWC)super.ON()).NA();
    AppMethodBeat.o(258355);
    return bool;
  }
  
  public final void OO()
  {
    AppMethodBeat.i(43934);
    super.OO();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] onInitBeforeComponentsInstalled, appId[%s] mPendingPermissionUpdateTasks.size=%d", new Object[] { this.mAppId, Integer.valueOf(this.kDB.size()) });
    while (!this.kDB.isEmpty()) {
      ((Runnable)this.kDB.remove()).run();
    }
    com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepPrepareRuntime);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup_Game);
    AppMethodBeat.o(43934);
  }
  
  public final v OP()
  {
    AppMethodBeat.i(43930);
    com.tencent.mm.plugin.appbrand.performance.b.E(this);
    Object localObject = ((AppStartupPerformanceReportBundle)av(AppStartupPerformanceReportBundle.class)).mSx;
    if (!Util.isNullOrNil((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      for (long l = 0L; ((Iterator)localObject).hasNext(); l = Math.max(l, ((kv_14609)((Iterator)localObject).next()).nJF)) {}
      com.tencent.mm.plugin.appbrand.performance.b.a(this, l);
    }
    if (DebuggerShell.bAx())
    {
      AppMethodBeat.o(43930);
      return null;
    }
    localObject = super.OP();
    AppMethodBeat.o(43930);
    return localObject;
  }
  
  public final boolean OQ()
  {
    AppMethodBeat.i(258359);
    boolean bool = super.OQ();
    AppMethodBeat.o(258359);
    return bool;
  }
  
  public com.tencent.mm.plugin.appbrand.p.a OR()
  {
    AppMethodBeat.i(43922);
    com.tencent.mm.plugin.appbrand.p.a locala = super.OR();
    AppMethodBeat.o(43922);
    return locala;
  }
  
  public final String Pb()
  {
    AppMethodBeat.i(43885);
    String str = "AppBrandRuntimeWC@" + hashCode();
    AppMethodBeat.o(43885);
    return str;
  }
  
  public final void R(final Runnable paramRunnable)
  {
    AppMethodBeat.i(226216);
    this.kAH.a(new com.tencent.mm.plugin.appbrand.a.c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
      {
        AppMethodBeat.i(43875);
        if (com.tencent.mm.plugin.appbrand.a.b.kQK == paramAnonymousb) {
          paramRunnable.run();
        }
        AppMethodBeat.o(43875);
      }
    });
    finish();
    AppMethodBeat.o(226216);
  }
  
  public final void S(final Runnable paramRunnable)
  {
    AppMethodBeat.i(43923);
    i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174672);
        if (q.this.isDestroyed())
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "startPrepareOrientation, finished appId[%s]", new Object[] { q.this.mAppId });
          AppMethodBeat.o(174672);
          return;
        }
        q.a(q.this, new e.a()
        {
          public final void a(com.tencent.mm.plugin.appbrand.platform.window.e.b paramAnonymous2b, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(226195);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "startPrepareOrientation, onOrientationChanged appId[%s], orientation[%s] success[%b]", new Object[] { q.this.mAppId, paramAnonymous2b, Boolean.valueOf(paramAnonymous2Boolean) });
            if (q.11.this.kDM != null) {
              q.11.this.kDM.run();
            }
            AppMethodBeat.o(226195);
          }
        }, q.o(q.this));
        AppMethodBeat.o(174672);
      }
    }, 0L);
    AppMethodBeat.o(43923);
  }
  
  public final void T(final Runnable paramRunnable)
  {
    AppMethodBeat.i(43935);
    paramRunnable = new a(paramRunnable);
    this.kDB.add(paramRunnable);
    super.O(paramRunnable);
    AppMethodBeat.o(43935);
  }
  
  public final void a(ak paramak)
  {
    AppMethodBeat.i(43891);
    paramak = (AppBrandRuntimeContainerWC)paramak;
    super.a(paramak);
    if (paramak == null)
    {
      this.kAM = null;
      this.mContext = com.tencent.mm.plugin.appbrand.ui.n.eo(MMApplicationContext.getContext());
      if ((com.tencent.mm.plugin.appbrand.service.c)super.NY() != null) {
        ((com.tencent.mm.plugin.appbrand.service.c)super.NY()).b(null);
      }
      if ((com.tencent.mm.plugin.appbrand.page.x)super.brh() != null) {
        y.c((com.tencent.mm.plugin.appbrand.page.x)super.brh());
      }
      if (this.kAx != null) {
        this.kAx.ek(MMApplicationContext.getContext());
      }
      this.kDv = new com.tencent.luggage.sdk.d.e();
      gu(true);
      if (((AppBrandInitConfigWC)super.ON() != null) && (!isDestroyed())) {
        this.kDi.M(this);
      }
      AppMethodBeat.o(43891);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.ui.n)this.mContext).setBaseContext(AndroidContextUtil.castActivityOrNull(paramak.mContext));
    if (this.kAx != null) {
      this.kAx.ek((Context)Objects.requireNonNull(AndroidContextUtil.castActivityOrNull(paramak.mContext)));
    }
    if (getWindowAndroid().bsj()) {}
    for (this.kDv = new com.tencent.mm.plugin.appbrand.ui.d(this, AndroidContextUtil.castActivityOrNull(this.mContext), getWindowAndroid().getOrientationHandler(), super.getWindowAndroid());; this.kDv = new com.tencent.luggage.sdk.d.e())
    {
      if ((com.tencent.mm.plugin.appbrand.service.c)super.NY() != null) {
        ((com.tencent.mm.plugin.appbrand.service.c)super.NY()).b(getWindowAndroid());
      }
      com.tencent.mm.plugin.appbrand.page.ag localag = bsz();
      if (localag != null)
      {
        localag.b(getWindowAndroid());
        ((com.tencent.mm.plugin.appbrand.page.x)super.brh()).j(localag);
      }
      this.kDr = new Configuration(AppBrandUI.H(paramak.kCd.getActivity()));
      gu(true);
      if ((this.kDs == null) && (this.mInitialized))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "setRuntimeContainer != NULL, appId:%s, retry initFloatBallHelper", new Object[] { this.mAppId });
        bsw();
      }
      if ((this.kDt == null) && (this.mInitialized))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "setRuntimeContainer != NULL, appId:%s, retry initMultiTaskHelper", new Object[] { this.mAppId });
        bsx();
      }
      AppMethodBeat.o(43891);
      return;
    }
  }
  
  public final void a(ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(43888);
    if (gt(false) != null)
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
    Object localObject = (AppBrandInitConfigWC)super.ON();
    AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    if ((localObject != paramAppBrandInitConfig) && (localAppBrandInitConfigWC.cyA.scene == 1038)) {
      localAppBrandInitConfigWC.ldS = null;
    }
    if (((AppBrandInitConfigWC)localObject).leg) {
      localAppBrandInitConfigWC.leg = true;
    }
    super.a(paramAppBrandInitConfig);
    int i;
    if ((((AppBrandInitConfigWC)super.ON()).launchMode != ((AppBrandInitConfigWC)localObject).launchMode) && ((((AppBrandInitConfigWC)super.ON()).launchMode == 1) || (((AppBrandInitConfigWC)localObject).launchMode == 1)))
    {
      i = 1;
      if (i != 0) {
        brC();
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "updateConfig %s, willRestart[%b], willRelaunch[%b], destroyed[%b], scene[%d], lastLaunchMode[%d], currentLaunchMode[%d], instanceId[%s], sessionId[%s]", new Object[] { this, Boolean.valueOf(this.kAJ), Boolean.valueOf(this.kAK), Boolean.valueOf(isDestroyed()), Integer.valueOf(ON().cyA.scene), Integer.valueOf(((AppBrandInitConfigWC)localObject).launchMode), Integer.valueOf(((AppBrandInitConfigWC)super.ON()).launchMode), ((AppBrandInitConfigWC)paramAppBrandInitConfig).cyn, ((AppBrandInitConfigWC)paramAppBrandInitConfig).cym });
      OpenBusinessViewUtil.z(this);
      if ((this.kAJ) || (isDestroyed())) {
        break label749;
      }
      if (!org.apache.commons.b.g.equals(localAppBrandInitConfigWC.cyn, ((AppBrandInitConfigLU)localObject).cyn))
      {
        if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED)) {
          break label377;
        }
        Assert.fail("updateConfig instanceId should not have been changed");
      }
    }
    for (;;)
    {
      ((QualitySessionRuntime)Objects.requireNonNull(com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId))).nLm = false;
      com.tencent.mm.plugin.appbrand.report.quality.g.a(this, true, com.tencent.mm.plugin.appbrand.utils.b.afF(((AppBrandInitConfigWC)super.ON()).ldT));
      com.tencent.mm.plugin.s.a.b(this.mAppId, ((AppBrandInitConfigWC)super.ON()).ldQ);
      paramAppBrandInitConfig = this.kDo.iterator();
      while (paramAppBrandInitConfig.hasNext()) {
        ((aj)paramAppBrandInitConfig.next()).c((AppBrandInitConfigWC)super.ON());
      }
      i = 0;
      break;
      label377:
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntimeWC", "updateConfig %s, newConfig.instanceId changed, reset [%s]->[%s]", new Object[] { this, localAppBrandInitConfigWC.cyn, ((AppBrandInitConfigLU)localObject).cyn });
      localAppBrandInitConfigWC.dC(((AppBrandInitConfigLU)localObject).cyn);
    }
    if ((com.tencent.mm.plugin.appbrand.page.x)super.brh() != null)
    {
      paramAppBrandInitConfig = (com.tencent.mm.plugin.appbrand.page.x)super.brh();
      paramAppBrandInitConfig.getReporter().resetSession();
      paramAppBrandInitConfig.nqb = false;
      paramAppBrandInitConfig.nqc = false;
      paramAppBrandInitConfig.nqd = false;
      paramAppBrandInitConfig.nqi = null;
    }
    paramAppBrandInitConfig = (AppBrandInitConfigWC)super.ON();
    localObject = bsB();
    AppBrandStatObject localAppBrandStatObject = ON().cyA;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskUsageRecorder", "updateUsage, appId %s, type %d", new Object[] { paramAppBrandInitConfig.appId, Integer.valueOf(paramAppBrandInitConfig.eix) });
    String str = paramAppBrandInitConfig.cym;
    AppBrandMainProcessService.a(new AppBrandTaskUsageRecorder.UpdateTask(new AppBrandTaskUsageRecorder.LaunchCheckParams(paramAppBrandInitConfig, localAppBrandStatObject, ((AppBrandSysConfigWC)localObject).leE.pkgVersion, gt(false).bvd(), str, paramAppBrandInitConfig.ldW)));
    bst();
    bsF();
    paramAppBrandInitConfig = (AppBrandInitConfigWC)super.ON();
    if (paramAppBrandInitConfig != null) {
      this.kDv.b(paramAppBrandInitConfig);
    }
    paramAppBrandInitConfig = this.kDw;
    kotlin.g.b.p.h(localAppBrandInitConfigWC, "newConfig");
    if (localAppBrandInitConfigWC.kHL.isEnable())
    {
      com.tencent.mm.plugin.appbrand.report.p.pl(1);
      if (localAppBrandInitConfigWC.cyz != com.tencent.luggage.sdk.launching.b.cBC)
      {
        com.tencent.mm.plugin.appbrand.report.p.pl(6);
        if (paramAppBrandInitConfig.nHI) {
          com.tencent.mm.plugin.appbrand.report.p.pl(8);
        }
        if (!paramAppBrandInitConfig.nHK)
        {
          com.tencent.mm.plugin.appbrand.report.p.pl(7);
          if (paramAppBrandInitConfig.nHI) {
            com.tencent.mm.plugin.appbrand.report.p.pl(9);
          }
          paramAppBrandInitConfig.nHK = true;
        }
      }
    }
    if (i != 0) {
      com.tencent.mm.plugin.appbrand.report.p.pl(4);
    }
    if ((paramAppBrandInitConfig.nHJ != localAppBrandInitConfigWC.kHL.isEnable()) && (localAppBrandInitConfigWC.cyz != com.tencent.luggage.sdk.launching.b.cBC))
    {
      if (!localAppBrandInitConfigWC.kHL.isEnable()) {
        break label756;
      }
      com.tencent.mm.plugin.appbrand.report.p.pl(3);
    }
    for (;;)
    {
      if (localAppBrandInitConfigWC.cyz != com.tencent.luggage.sdk.launching.b.cBC) {
        paramAppBrandInitConfig.nHJ = localAppBrandInitConfigWC.kHL.isEnable();
      }
      label749:
      AppMethodBeat.o(43924);
      return;
      label756:
      com.tencent.mm.plugin.appbrand.report.p.pl(2);
    }
  }
  
  public final void a(AppBrandInitConfig paramAppBrandInitConfig, String paramString)
  {
    AppMethodBeat.i(226217);
    if (paramAppBrandInitConfig == null)
    {
      ((AppBrandInitConfigWC)super.ON()).resetSession();
      ((AppBrandInitConfigWC)super.ON()).startTime = Util.nowMilliSecond();
      ((AppBrandInitConfigWC)super.ON()).lef = new AppBrandRuntimeReloadReportBundle(((AppBrandInitConfigWC)super.ON()).ldW.kEY, paramString);
      ((AppBrandInitConfigWC)super.ON()).ldW = new QualitySession(com.tencent.mm.plugin.appbrand.utils.b.zF(((AppBrandInitConfigWC)super.ON()).uin), (AppBrandInitConfigWC)super.ON(), ON().cyA);
      ((AppBrandInitConfigWC)super.ON()).dC(((AppBrandInitConfigWC)super.ON()).ldW.kEY);
    }
    super.ag(ICommLibReader.class);
    super.a(paramAppBrandInitConfig, paramString);
    AppMethodBeat.o(226217);
  }
  
  public final boolean b(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(43925);
    paramAppBrandInitConfig = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    AppBrandStatObject localAppBrandStatObject = paramAppBrandInitConfig.cyA;
    boolean bool;
    if ((this.kDn) || (localAppBrandStatObject.scene == 1099))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] mShouldRelaunchCausedByFunctionalPageOpen[%b] newScene[%d]", new Object[] { this.mAppId, Boolean.valueOf(this.kDn), Integer.valueOf(localAppBrandStatObject.scene) });
      if (localAppBrandStatObject.scene == 1099) {}
      for (bool = true;; bool = false)
      {
        this.kDn = bool;
        AppMethodBeat.o(43925);
        return true;
      }
    }
    if ((TextUtils.isEmpty(paramAppBrandInitConfig.kHw)) && (af.p(this)))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] enterPath[%s], old is gameFunctionalPage", new Object[] { this.mAppId, paramAppBrandInitConfig.kHw });
      AppMethodBeat.o(43925);
      return true;
    }
    if (1038 == localAppBrandStatObject.scene)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. appId[%s], reason=1038 back from other MiniProgram", new Object[] { this.mAppId });
      AppMethodBeat.o(43925);
      return false;
    }
    Iterator localIterator = this.kDo.iterator();
    while (localIterator.hasNext())
    {
      Boolean localBoolean = ((aj)localIterator.next()).b(paramAppBrandInitConfig);
      if (localBoolean != null)
      {
        bool = localBoolean.booleanValue();
        AppMethodBeat.o(43925);
        return bool;
      }
    }
    if (!TextUtils.isEmpty(paramAppBrandInitConfig.kHw))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] enterPath[%s]", new Object[] { this.mAppId, paramAppBrandInitConfig.kHw });
      AppMethodBeat.o(43925);
      return true;
    }
    if (((AppBrandInitConfigWC)super.ON()).kHL.isEnable() != paramAppBrandInitConfig.kHL.isEnable())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] halfScreenConfig enable change to:%b", new Object[] { this.mAppId, Boolean.valueOf(paramAppBrandInitConfig.kHL.isEnable()) });
      AppMethodBeat.o(43925);
      return true;
    }
    int i = localAppBrandStatObject.scene;
    if (org.apache.commons.b.a.contains(new int[] { 1001, 1003, 1023, 1038, 1056, 1080, 1083, 1089, 1090, 1103, 1104, 1113, 1114, 1117, 1131, 1019, 1112, 1127, 1134, 1187 }, i))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. keepNoRelaunch appId[%s] newScene[%d]", new Object[] { this.mAppId, Integer.valueOf(localAppBrandStatObject.scene) });
      AppMethodBeat.o(43925);
      return false;
    }
    if ((1030 == localAppBrandStatObject.scene) && (TextUtils.isEmpty(paramAppBrandInitConfig.kHw)))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. special for monkey test appId[%s]", new Object[] { this.mAppId });
      AppMethodBeat.o(43925);
      return false;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] fallback logic", new Object[] { this.mAppId });
    AppMethodBeat.o(43925);
    return true;
  }
  
  public final ICommLibReader bqZ()
  {
    AppMethodBeat.i(258354);
    ICommLibReader localICommLibReader = gt(false);
    AppMethodBeat.o(258354);
    return localICommLibReader;
  }
  
  protected final void brB()
  {
    AppMethodBeat.i(43916);
    MMToClientEvent.e((com.tencent.mm.plugin.appbrand.service.c)super.NY());
    MMToClientEvent.YY("Common_IPC_appid");
    this.kDi.N(this);
    AppMethodBeat.o(43916);
  }
  
  public final void brI()
  {
    AppMethodBeat.i(174684);
    if (com.tencent.mm.plugin.appbrand.ui.r.am(this))
    {
      AppMethodBeat.o(174684);
      return;
    }
    super.brI();
    AppMethodBeat.o(174684);
  }
  
  public final boolean brJ()
  {
    AppMethodBeat.i(43913);
    if ((!isInBackStack()) && (!a.a(this))) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "[wxa_reload]recycleRuntime %s, recycle[%b]", new Object[] { toString(), Boolean.valueOf(bool) });
      if (bool) {
        finish();
      }
      AppMethodBeat.o(43913);
      return bool;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.ab brK()
  {
    AppMethodBeat.i(226221);
    com.tencent.mm.plugin.appbrand.ui.ab localab = super.brK();
    AppMethodBeat.o(226221);
    return localab;
  }
  
  protected final void bre()
  {
    AppMethodBeat.i(226232);
    bsF();
    Object localObject1 = (AppBrandInitConfigWC)super.ON();
    if (localObject1 != null) {
      this.kDv.a((AppBrandInitConfigLU)localObject1);
    }
    this.kDu = new com.tencent.mm.plugin.appbrand.ad.h(this);
    localObject1 = this.kDu;
    if (((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGW.brL())
    {
      ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGX = com.tencent.mm.plugin.appbrand.task.e.j(com.tencent.mm.plugin.appbrand.task.g.iD(((AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGW.ON()).NA()));
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, may show ad, preloadedService:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGW.mAppId, ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGX });
      if (((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGX != null)
      {
        Object localObject2;
        if (((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGW.NA())
        {
          localObject2 = (AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGW.ON();
          if (localObject2 == null) {
            break label364;
          }
          localObject2 = com.tencent.mm.plugin.appbrand.platform.window.e.b.aeE(((AppBrandInitConfigWC)localObject2).cBG);
          if ((localObject2 != com.tencent.mm.plugin.appbrand.platform.window.e.b.nEn) && (localObject2 != com.tencent.mm.plugin.appbrand.platform.window.e.b.nEp) && (localObject2 != com.tencent.mm.plugin.appbrand.platform.window.e.b.nEq)) {
            break label364;
          }
        }
        label364:
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, landscape game, add check show ad prepare process", new Object[] { ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGW.mAppId });
            ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kHb = new com.tencent.mm.plugin.appbrand.ad.i();
            ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGW.a(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kHb);
          }
          ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).btT();
          ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGX.kEc = ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGW;
          ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGX.kEa = true;
          localObject2 = new com.tencent.mm.plugin.appbrand.ad.a.f();
          ((com.tencent.mm.plugin.appbrand.ad.a.f)localObject2).source = "launch";
          ((com.tencent.mm.plugin.appbrand.ad.a.f)localObject2).a(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGX, null);
          ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGY = 8;
          com.tencent.mm.plugin.appbrand.ad.e.a(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGW, com.tencent.mm.plugin.appbrand.task.e.m(com.tencent.mm.plugin.appbrand.task.g.iD(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGW.NA())), true);
          localObject1 = this.kDw;
          localObject2 = (AppBrandInitConfigWC)super.ON();
          kotlin.g.b.p.h(localObject2, "initConfig");
          if (((AppBrandInitConfigWC)localObject2).kHL.isEnable())
          {
            com.tencent.mm.plugin.appbrand.report.p.pl(0);
            if (((AppBrandInitConfigWC)localObject2).cyz != com.tencent.luggage.sdk.launching.b.cBC) {
              com.tencent.mm.plugin.appbrand.report.p.pl(5);
            }
          }
          ((com.tencent.mm.plugin.appbrand.report.p)localObject1).nHJ = ((AppBrandInitConfigWC)localObject2).kHL.isEnable();
          AppMethodBeat.o(226232);
          return;
        }
      }
      com.tencent.mm.plugin.appbrand.ad.e.a(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGW, com.tencent.mm.plugin.appbrand.task.e.m(com.tencent.mm.plugin.appbrand.task.g.iD(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGW.NA())), false);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).btT();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, can not show ad", new Object[] { ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGW.mAppId });
      ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGY = 0;
      break;
      com.tencent.mm.plugin.appbrand.ad.e.a(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGW, com.tencent.mm.plugin.appbrand.task.e.m(com.tencent.mm.plugin.appbrand.task.g.iD(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).kGW.NA())), false);
    }
  }
  
  public final void brk()
  {
    AppMethodBeat.i(226225);
    com.tencent.mm.plugin.appbrand.config.b localb = getAppConfig();
    Object localObject2 = bg.d(this, "/app-config.json");
    Object localObject1 = localObject2;
    Object localObject3;
    if (Util.isNullOrNil((String)localObject2))
    {
      localObject3 = bsB().leE.kNZ.iterator();
      localObject1 = localObject2;
      if (((Iterator)localObject3).hasNext())
      {
        ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)((Iterator)localObject3).next();
        if (!localModulePkgInfo.independent) {
          break label747;
        }
        localObject2 = new StringBuilder().append(localModulePkgInfo.name);
        if (localModulePkgInfo.name.endsWith("/"))
        {
          localObject1 = "";
          label118:
          localObject2 = bg.d(this, (String)localObject1 + "app-config.json");
          localObject1 = localObject2;
          if (!Util.isNullOrNil((String)localObject2)) {
            break label167;
          }
          localObject1 = localObject2;
        }
      }
    }
    label167:
    label747:
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
      localObject1 = com.tencent.mm.plugin.appbrand.config.b.b(this.mAppId, (String)localObject1, (String)localObject2, Boolean.parseBoolean(gt(true).UN("pruneWxConfigByPage")), NA());
      if (!NA())
      {
        ((com.tencent.mm.plugin.appbrand.config.b)localObject1).lbP.cBG = ((AppBrandInitConfigWC)super.ON()).cBG;
        ((com.tencent.mm.plugin.appbrand.config.b)localObject1).lbP.lcd = true;
      }
      for (;;)
      {
        if (bb.r(this)) {
          ((com.tencent.mm.plugin.appbrand.config.b)localObject1).lbP.cBG = "portrait";
        }
        b((com.tencent.mm.plugin.appbrand.config.b)localObject1);
        bsG();
        if (NA())
        {
          localObject1 = com.tencent.mm.plugin.appbrand.game.preload.d.bDu();
          if (((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).hasInit)
          {
            localObject2 = ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ltU;
            localObject3 = ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kGW.kAA;
            ((com.tencent.mm.plugin.appbrand.game.preload.c)localObject2).ltP.addAll((Collection)localObject3);
            ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ltS = ((com.tencent.mm.plugin.appbrand.s.a)((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kGW.av(com.tencent.mm.plugin.appbrand.s.a.class));
            ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ltT = ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kGW.OK();
            localObject1 = ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ltR;
            localObject2 = (com.tencent.mm.plugin.appbrand.s.a)((com.tencent.mm.plugin.appbrand.s.m)localObject1).lqg.av(com.tencent.mm.plugin.appbrand.s.a.class);
            ((com.tencent.mm.plugin.appbrand.s.m)localObject1).nhP = ((com.tencent.mm.plugin.appbrand.s.a)localObject2).cyM;
            ((com.tencent.mm.plugin.appbrand.s.m)localObject1).mGo = ((com.tencent.mm.plugin.appbrand.s.a)localObject2).nhM;
            ((com.tencent.mm.plugin.appbrand.s.m)localObject1).nhR = com.tencent.mm.plugin.appbrand.s.j.a((com.tencent.mm.plugin.appbrand.s.a)localObject2);
          }
          Q(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(162152);
              try
              {
                com.tencent.mm.plugin.appbrand.game.preload.d locald = com.tencent.mm.plugin.appbrand.game.preload.d.bDu();
                if (!locald.ltW) {
                  break label373;
                }
                if (!locald.hasInit)
                {
                  com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WAGamePreloadManager", "hasn't init!");
                  AppMethodBeat.o(162152);
                  return;
                }
                if (locald.kGW == null) {
                  break label373;
                }
                if (locald.kGW.getAppConfig() != null) {
                  break label90;
                }
                com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WAGamePreloadManager", "downloadPreloadFiles getAppConfig null!");
                AppMethodBeat.o(162152);
                return;
              }
              catch (NullPointerException localNullPointerException)
              {
                if (!q.this.isDestroyed()) {
                  break label379;
                }
              }
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntimeWC", "runtime has finished - downloadPreloadFiles!");
              AppMethodBeat.o(162152);
              return;
              label90:
              JSONArray localJSONArray = localNullPointerException.kGW.getAppConfig().lbT;
              int i;
              if (localJSONArray != null)
              {
                com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(3000, localJSONArray.length());
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
                    if ((Util.isNullOrNil((String)localObject2)) || (Util.isNullOrNil((String)localObject3))) {
                      break label386;
                    }
                    if (localNullPointerException.ltT.Vj((String)localObject3) == com.tencent.mm.plugin.appbrand.appstorage.m.kSu)
                    {
                      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WAGamePreloadManager", "predownload path %s has exists!", new Object[] { localObject3 });
                    }
                    else
                    {
                      localNullPointerException.ltV.add(localObject2);
                      localObject2 = new d.2(localNullPointerException, (String)localObject2, (String)localObject3);
                      if (localNullPointerException.ltS.cyM <= 0) {
                        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WAGamePreloadManager", "maxDownloadConcurrent <= 0 ");
                      }
                    }
                  }
                }
                catch (JSONException localJSONException)
                {
                  com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.WAGamePreloadManager", localJSONException, "", new Object[0]);
                }
                Object localObject1 = localNullPointerException.kGW.getAppConfig();
                if (localObject1 == null)
                {
                  com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WAGamePreloadManager", "downloadPreloadFiles config null！");
                  AppMethodBeat.o(162152);
                  return;
                  localObject3 = new HashMap();
                  int j = localNullPointerException.ltS.lcM;
                  localNullPointerException.ltR.a(localJSONObject, 60000, (Map)localObject3, null, j, (com.tencent.mm.plugin.appbrand.s.b.a)localObject2, com.tencent.mm.plugin.appbrand.game.preload.d.bjl(), "test");
                }
                else
                {
                  localObject1 = ((com.tencent.mm.plugin.appbrand.config.b)localObject1).lbU;
                  if (localObject1 != null) {
                    com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(4000, ((ArrayList)localObject1).size());
                  }
                  localNullPointerException.bDv();
                  label373:
                  AppMethodBeat.o(162152);
                  return;
                  label379:
                  AppMethodBeat.o(162152);
                  throw localNullPointerException;
                }
                label386:
                i += 1;
              }
            }
          });
        }
        if ((!Util.isNullOrNil(this.mAppId)) && (getAppConfig() != null)) {
          break;
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandBackgroundConfigStorage", "updateBackgroundConfigs, runtime or appId or appConfig is null");
        if ((localb != null) && ((com.tencent.mm.plugin.appbrand.service.c)super.NY() != null)) {
          new com.tencent.mm.plugin.appbrand.jsapi.c.a().Zh(((com.tencent.mm.plugin.appbrand.service.c)super.NY()).Or().toString()).h(NY()).bEo();
        }
        AppMethodBeat.o(226225);
        return;
        if (!((com.tencent.mm.plugin.appbrand.config.b)localObject1).lbR.booleanValue()) {
          ((com.tencent.mm.plugin.appbrand.config.b)localObject1).lbP.cBG = ((AppBrandInitConfigWC)super.ON()).cyv.lgT;
        }
      }
      localObject1 = this.mAppId;
      localObject2 = getAppConfig();
      boolean bool2 = j.a.sE(bsB().leE.kNW);
      boolean bool3 = ((com.tencent.mm.plugin.appbrand.config.b)localObject2).lbS.contains("location");
      MultiProcessMMKV.getMMKV("appbrand_background_config").encode(String.format("%s_location_background_required", new Object[] { localObject1 }), bool3);
      localObject2 = ((com.tencent.mm.plugin.appbrand.config.b)localObject2).WW("scope.userLocation");
      if ((localObject2 != null) && (!Util.isNullOrNil(((b.e)localObject2).desc))) {
        MultiProcessMMKV.getMMKV("appbrand_background_config").encode(String.format("%s_permission_location_desc", new Object[] { localObject1 }), ((b.e)localObject2).desc);
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandBackgroundConfigStorage", "updateBackgroundConfigs, appId:%s, isDebug:%s, isLocationBackgroundRequired:%s, hasPermissionLocationDesc:%s", new Object[] { localObject1, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        break;
        MultiProcessMMKV.getMMKV("appbrand_background_config").remove(String.format("%s_permission_location_desc", new Object[] { localObject1 }));
      }
    }
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.ab bro()
  {
    AppMethodBeat.i(43928);
    Object localObject;
    int i;
    if (NA())
    {
      localObject = com.tencent.mm.plugin.appbrand.game.preload.e.bDw();
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rRh, false) == true)
      {
        i = 1;
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).luk = i;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WAGamePreloadStatisManager", "misPreload:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).luk) });
        AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.ON();
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).luf = localAppBrandInitConfigWC.appId;
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).lug = localAppBrandInitConfigWC.appVersion;
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).luh = localAppBrandInitConfigWC.eix;
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).lui = (localAppBrandInitConfigWC.cyo + 1000);
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).luj = localAppBrandInitConfigWC.ldW.kEY;
      }
    }
    else
    {
      switch (((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).luh)
      {
      default: 
        label156:
        if (ON().cyA != null) {
          ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).mScene = ON().cyA.scene;
        }
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rZF, false) == true)
        {
          i = 1;
          label204:
          ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).lum = i;
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WAGamePreloadStatisManager", "mHasSplashScreen:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).lum) });
          localObject = com.tencent.mm.plugin.appbrand.ui.k.a(AndroidContextUtil.castActivityOrNull(this.mContext), this);
          ((com.tencent.mm.plugin.appbrand.ui.ab)localObject).eo(((AppBrandInitConfigWC)super.ON()).iconUrl, ((AppBrandInitConfigWC)super.ON()).brandName);
          if ((localObject instanceof com.tencent.mm.plugin.appbrand.ui.ae)) {
            ((com.tencent.mm.plugin.appbrand.ui.ae)localObject).setCanShowHideAnimation(false);
          }
          if ((localObject instanceof com.tencent.mm.plugin.appbrand.ui.m))
          {
            if (!TextUtils.isEmpty(((AppBrandInitConfigWC)super.ON()).ldT)) {
              break label360;
            }
            ((com.tencent.mm.plugin.appbrand.ui.m)localObject).setLoadingIconVisibility(false);
          }
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(43928);
      return localObject;
      i = 0;
      break;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).luh = 1;
      break label156;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).luh = 2;
      break label156;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).luh = 3;
      break label156;
      i = 0;
      break label204;
      label360:
      ((com.tencent.mm.plugin.appbrand.ui.m)localObject).setLoadingIconVisibility(true);
    }
  }
  
  protected final void brq()
  {
    AppMethodBeat.i(226222);
    super.brq();
    com.tencent.mm.plugin.appbrand.report.quality.b.I(this);
    AppMethodBeat.o(226222);
  }
  
  protected final void bru()
  {
    AppMethodBeat.i(43910);
    super.bru();
    String str = toString();
    Object localObject = this.kAW;
    if ((localObject != null) && (((Collection)localObject).size() > 0)) {
      localObject = ((Collection)localObject).iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, process[%s]", new Object[] { str, ((AppBrandRuntime.b)((Iterator)localObject).next()).toString() });
      continue;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntime", "%s onResourcePrepareTimeout, no pending processes", new Object[] { str });
    }
    vx(11);
    com.tencent.mm.plugin.appbrand.keylogger.c.c(this.mAppId, KSProcessWeAppLaunch.stepPrepareResourceTimeout);
    AppMethodBeat.o(43910);
  }
  
  protected final void brv()
  {
    AppMethodBeat.i(43908);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] onPostInit appId[%s]", new Object[] { this.mAppId });
    MMToClientEvent.e((com.tencent.mm.plugin.appbrand.service.c)super.NY());
    MMToClientEvent.YY("Common_IPC_appid");
    x.a.bUB().ce(this.mAppId, ON().cyA.scene);
    if (((com.tencent.mm.plugin.appbrand.service.c)super.NY()).bqZ().compareTo(gt(false)) != 0)
    {
      localObject = new IllegalStateException(String.format(Locale.ENGLISH, "onPostInit appId[%s] mismatch libReader, self[%s] service[%s]", new Object[] { this.mAppId, gt(false).bvb(), ((com.tencent.mm.plugin.appbrand.service.c)super.NY()).bqZ().bvb() }));
      AppMethodBeat.o(43908);
      throw ((Throwable)localObject);
    }
    super.brv();
    Object localObject = (AppBrandInitConfigWC)super.ON();
    this.kDk.I(0, System.currentTimeMillis() - ((AppBrandInitConfigWC)localObject).startTime);
    com.tencent.mm.plugin.appbrand.performance.c.b(this.mAppId, "ActivityCreate", ((AppBrandInitConfigWC)super.ON()).startTime, System.currentTimeMillis());
    com.tencent.mm.plugin.appbrand.report.p localp = this.kDw;
    kotlin.g.b.p.h(localObject, "initConfig");
    if ((!localp.nHI) && (((AppBrandInitConfigWC)localObject).cyz == com.tencent.luggage.sdk.launching.b.cBC)) {
      localp.nHI = true;
    }
    MMToClientEvent.a(this.mAppId, new MMToClientEvent.c()
    {
      public final void cq(Object paramAnonymousObject)
      {
        AppMethodBeat.i(226179);
        if ((paramAnonymousObject instanceof AppBrandAuthorizeUI.AuthStateChangedByUserEvent))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], AuthStateChangedByUserEvent", new Object[] { q.this.mAppId });
          com.tencent.mm.plugin.appbrand.permission.a.a.aer(q.this.mAppId);
          AppBrandBackgroundRunningMonitor.a(q.this, (AppBrandAuthorizeUI.AuthStateChangedByUserEvent)paramAnonymousObject);
        }
        AppMethodBeat.o(226179);
      }
    });
    MMToClientEvent.a("Common_IPC_appid", new MMToClientEvent.c()
    {
      public final void cq(Object paramAnonymousObject)
      {
        AppMethodBeat.i(226180);
        if ((paramAnonymousObject instanceof GetOnLineInfoInfoResult))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], GetOnLineInfoInfoResult", new Object[] { q.this.mAppId });
          p.Un(q.this.mAppId).jjN = ((GetOnLineInfoInfoResult)paramAnonymousObject).jjN;
          p.Un(q.this.mAppId).jjS = ((GetOnLineInfoInfoResult)paramAnonymousObject).jjS;
          p.Un(q.this.mAppId).kDf = ((GetOnLineInfoInfoResult)paramAnonymousObject).kDf;
        }
        AppMethodBeat.o(226180);
      }
    });
    MMToClientEvent.a(this.mAppId, new MMToClientEvent.c()
    {
      public final void cq(Object paramAnonymousObject)
      {
        AppMethodBeat.i(226181);
        if ((paramAnonymousObject instanceof EventLocationBackgroundStateChanged))
        {
          if (!((EventLocationBackgroundStateChanged)paramAnonymousObject).kYn)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "locationBackgroundStateChanged, not listening, appId[%s]", new Object[] { q.this.mAppId });
            q.this.kAH.kQM.a(d.a.kRo);
          }
          AppMethodBeat.o(226181);
          return;
        }
        if ((paramAnonymousObject instanceof WxaAppMsgChannel))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], WxaAppMsgChannel msg", new Object[] { q.this.mAppId });
          com.tencent.mm.plugin.appbrand.jsapi.m.a locala = new com.tencent.mm.plugin.appbrand.jsapi.m.a();
          com.tencent.mm.plugin.appbrand.service.c localc = q.this.bsE();
          paramAnonymousObject = (WxaAppMsgChannel)paramAnonymousObject;
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.onReceiveMsgChannelJsApiEvent", "dispatch msg channel to web ， msgContent:%s", new Object[] { paramAnonymousObject.dWG });
          HashMap localHashMap = new HashMap();
          localHashMap.put("msgId", paramAnonymousObject.msgId);
          localHashMap.put("sendTime", Long.valueOf(paramAnonymousObject.lhG));
          localHashMap.put("msgType", Integer.valueOf(paramAnonymousObject.msgType));
          localHashMap.put("msgContent", paramAnonymousObject.dWG);
          locala.g(localc);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.onReceiveMsgChannelJsApiEvent", "dispatch wxa msg channel");
          locala.K(localHashMap).bEo();
          AppMethodBeat.o(226181);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandVoIP1v1FloatBallEvent))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], AppBrandVoIP1v1FloatBallEvent msg", new Object[] { q.this.mAppId });
          if (((AppBrandVoIP1v1FloatBallEvent)paramAnonymousObject).dRq == 1) {
            com.tencent.mm.plugin.appbrand.jsapi.openvoice.q.bIi();
          }
        }
        AppMethodBeat.o(226181);
      }
    });
    new g.a(this, (byte)0);
    this.kDk.I(8, System.currentTimeMillis() - ((AppBrandInitConfigWC)localObject).startTime);
    vx(2);
    localObject = this.kAQ;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.appbrand.pip.f)localObject).nDw = com.tencent.mm.plugin.appbrand.pip.k.nDP;
      ((com.tencent.mm.plugin.appbrand.pip.f)localObject).bTG();
      ((com.tencent.mm.plugin.appbrand.pip.f)localObject).nDy = com.tencent.mm.plugin.appbrand.pip.g.nDK;
    }
    ((com.tencent.mm.plugin.appbrand.service.c)super.NY()).b(getWindowAndroid());
    localObject = bsz();
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.page.ag)localObject).b(getWindowAndroid());
    }
    AppMethodBeat.o(43908);
  }
  
  protected s brw()
  {
    AppMethodBeat.i(43901);
    Object localObject2;
    Object localObject1;
    if (super.OQ()) {
      if (NA())
      {
        localObject2 = com.tencent.mm.plugin.appbrand.task.e.h(com.tencent.mm.plugin.appbrand.task.g.iD(true));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (this.kDq != null) {
            localObject1 = this.kDq.brT();
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
      com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId).nLz = com.tencent.mm.plugin.appbrand.report.quality.j.nKS;
      continue;
      localObject1 = new com.tencent.mm.plugin.appbrand.service.c(com.tencent.luggage.sdk.b.a.c.j.cBs);
      continue;
      if (this.kDq != null)
      {
        localObject1 = this.kDq.brT();
        if (localObject1 != null)
        {
          String str = this.mAppId;
          if (!NA()) {
            break label260;
          }
          localObject2 = "WAGame";
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "[%s][%s] [applaunch] [preload] createService preloaded, reason=%s", new Object[] { str, localObject2, com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId).nLz.name() });
        }
        if (localObject1 != null) {
          break label303;
        }
        localObject2 = this.mAppId;
        if (!NA()) {
          break label267;
        }
      }
      for (localObject1 = "WAGame";; localObject1 = "WAService")
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "[%s][%s] [applaunch] [preload] createService got no preloaded", new Object[] { localObject2, localObject1 });
        if (((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG) && (!DebuggerShell.bAx())) || (!com.tencent.mm.plugin.appbrand.task.b.bVE())) {
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
      if (NA()) {
        localObject1 = new com.tencent.mm.plugin.appbrand.game.c();
      } else {
        localObject1 = new com.tencent.mm.plugin.appbrand.service.c();
      }
    }
  }
  
  protected w brx()
  {
    AppMethodBeat.i(43902);
    Object localObject1 = this.mContext;
    try
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId).nLB = Util.nowMilliSecond();
      label24:
      if (NA()) {}
      com.tencent.mm.plugin.appbrand.page.ag localag;
      for (localObject1 = new com.tencent.mm.plugin.appbrand.game.f.c((Context)localObject1, this);; localObject1 = new com.tencent.mm.plugin.appbrand.page.x((Context)localObject1, this))
      {
        ((com.tencent.mm.plugin.appbrand.page.x)localObject1).setDecorWidgetFactory(bsn());
        if (!NA()) {
          ((com.tencent.mm.plugin.appbrand.page.x)localObject1).a(com.tencent.mm.plugin.appbrand.page.b.i.nvW, new com.tencent.mm.plugin.appbrand.page.b.a());
        }
        ((com.tencent.mm.plugin.appbrand.page.x)localObject1).a(com.tencent.mm.plugin.appbrand.page.b.i.nvV, new com.tencent.mm.plugin.appbrand.page.b.b());
        if (this.kDq == null) {
          break label248;
        }
        localag = this.kDq.brU();
        if (localag == null) {
          break label248;
        }
        if ((localag == null) || (((com.tencent.mm.plugin.appbrand.page.x)localObject1).getRuntime() == null)) {
          break label230;
        }
        if (localag.bqZ().compareTo(((com.tencent.mm.plugin.appbrand.page.x)localObject1).getRuntime().gt(false)) == 0) {
          break;
        }
        localObject1 = new IllegalStateException(String.format(Locale.ENGLISH, "stashPreloadedPageView appId[%s] mismatch libReader, runtime[%s] page[%s]", new Object[] { ((com.tencent.mm.plugin.appbrand.page.x)localObject1).getAppId(), ((com.tencent.mm.plugin.appbrand.page.x)localObject1).getRuntime().gt(false).bvb(), localag.bqZ().bvb() }));
        AppMethodBeat.o(43902);
        throw ((Throwable)localObject1);
      }
      synchronized (((com.tencent.mm.plugin.appbrand.page.x)localObject1).nqk)
      {
        ((com.tencent.mm.plugin.appbrand.page.x)localObject1).nqk.addLast(localag);
        label230:
        if ((localag instanceof bs)) {
          ((com.tencent.mm.plugin.appbrand.page.x)localObject1).setWAAutoWebViewJs(((bs)localag).nuB);
        }
        label248:
        AppMethodBeat.o(43902);
        return localObject1;
      }
    }
    catch (Throwable localThrowable)
    {
      break label24;
    }
  }
  
  public final boolean bry()
  {
    AppMethodBeat.i(43904);
    if (NA())
    {
      AppMethodBeat.o(43904);
      return false;
    }
    if (com.tencent.mm.protocal.d.KyO <= 654314239)
    {
      AppMethodBeat.o(43904);
      return false;
    }
    if ((!com.tencent.mm.protocal.d.KyP) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rUI, false)))
    {
      AppMethodBeat.o(43904);
      return true;
    }
    AppMethodBeat.o(43904);
    return false;
  }
  
  final void bsA()
  {
    AppMethodBeat.i(43915);
    gv(false);
    AppMethodBeat.o(43915);
  }
  
  public final AppBrandSysConfigWC bsB()
  {
    AppMethodBeat.i(43918);
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)d(AppBrandSysConfigWC.class, false);
    AppMethodBeat.o(43918);
    return localAppBrandSysConfigWC;
  }
  
  public final AppBrandInitConfigWC bsC()
  {
    AppMethodBeat.i(258356);
    AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.ON();
    AppMethodBeat.o(258356);
    return localAppBrandInitConfigWC;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.x bsD()
  {
    AppMethodBeat.i(258357);
    com.tencent.mm.plugin.appbrand.page.x localx = (com.tencent.mm.plugin.appbrand.page.x)super.brh();
    AppMethodBeat.o(258357);
    return localx;
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c bsE()
  {
    AppMethodBeat.i(258358);
    com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)super.NY();
    AppMethodBeat.o(258358);
    return localc;
  }
  
  public final void bsG()
  {
    AppMethodBeat.i(43931);
    Object localObject = bsB();
    com.tencent.mm.plugin.appbrand.config.n.bw(this.mAppId, ((AppBrandSysConfigWC)localObject).cza);
    com.tencent.mm.plugin.appbrand.config.n.bx(this.mAppId, ((AppBrandSysConfigWC)localObject).czb);
    this.kAA.add(com.tencent.mm.plugin.appbrand.config.f.a(this));
    this.kAA.add(com.tencent.mm.plugin.appbrand.config.f.a((AppBrandSysConfigLU)localObject));
    this.kAA.add(com.tencent.mm.plugin.appbrand.config.f.b((AppBrandSysConfigLU)localObject));
    this.kAA.add(com.tencent.mm.plugin.appbrand.config.f.b(this));
    localObject = com.tencent.mm.plugin.appbrand.config.f.c((AppBrandSysConfigLU)localObject);
    ((com.tencent.mm.plugin.appbrand.performance.a)localObject).nwy |= DebuggerShell.bAx();
    boolean bool2 = ((com.tencent.mm.plugin.appbrand.performance.a)localObject).nwz;
    if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject).nwz = (bool1 | bool2);
      this.kAA.add(localObject);
      AppMethodBeat.o(43931);
      return;
    }
  }
  
  public final void bsH()
  {
    AppMethodBeat.i(43933);
    this.kAO = false;
    if (this.kAl != null) {
      this.kAl.A(this);
    }
    finish();
    if ((this.kAl instanceof AppBrandRuntimeContainerWC)) {
      ((AppBrandRuntimeContainerWC)this.kAl).OH();
    }
    AppMethodBeat.o(43933);
  }
  
  public final boolean bsI()
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    com.tencent.mm.plugin.appbrand.ad.h localh;
    if (this.kDu != null)
    {
      localh = this.kDu;
      if (localh.kHb == null) {
        break label44;
      }
    }
    label44:
    for (boolean bool1 = localh.kHb.chu;; bool1 = false)
    {
      bool2 = bool3;
      if (bool1) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public final int bsJ()
  {
    if (this.kDu != null) {
      return this.kDu.kGY;
    }
    return 9;
  }
  
  public final int bsM()
  {
    AppMethodBeat.i(163908);
    if ((AppBrandInitConfigWC)super.ON() != null)
    {
      int i = ((AppBrandInitConfigWC)super.ON()).ldZ;
      AppMethodBeat.o(163908);
      return i;
    }
    AppMethodBeat.o(163908);
    return -1;
  }
  
  public final boolean bsN()
  {
    AppMethodBeat.i(226236);
    boolean bool = ((AppBrandInitConfigWC)super.ON()).kHL.isEnable();
    AppMethodBeat.o(226236);
    return bool;
  }
  
  public final boolean bsO()
  {
    AppMethodBeat.i(226237);
    boolean bool = ((AppBrandInitConfigWC)super.ON()).kHL.lfm;
    AppMethodBeat.o(226237);
    return bool;
  }
  
  public final String bsm()
  {
    AppMethodBeat.i(226209);
    if ((AppBrandInitConfigWC)super.ON() == null)
    {
      AppMethodBeat.o(226209);
      return "NULL";
    }
    String str = ((AppBrandInitConfigWC)super.ON()).brandName;
    AppMethodBeat.o(226209);
    return str;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.e bsn()
  {
    AppMethodBeat.i(226210);
    if (this.kDx == null)
    {
      localObject = com.tencent.mm.plugin.appbrand.page.g.nnK;
      this.kDx = com.tencent.mm.plugin.appbrand.page.g.b(com.tencent.mm.plugin.appbrand.task.g.iD(((AppBrandInitConfigWC)super.ON()).NA()));
    }
    Object localObject = this.kDx;
    AppMethodBeat.o(226210);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.q.b bsp()
  {
    if (this.kDt != null) {
      return this.kDt.nhs;
    }
    return null;
  }
  
  public com.tencent.mm.plugin.appbrand.k.b bsq()
  {
    AppMethodBeat.i(174683);
    if ((this.kDz == null) && (!isDestroyed())) {
      this.kDz = new q.1(this);
    }
    com.tencent.mm.plugin.appbrand.k.b localb = this.kDz;
    AppMethodBeat.o(174683);
    return localb;
  }
  
  public final boolean bsr()
  {
    AppMethodBeat.i(43893);
    boolean bool = ((AppBrandInitConfigWC)super.ON()).ldN;
    AppMethodBeat.o(43893);
    return bool;
  }
  
  public final boolean bss()
  {
    AppMethodBeat.i(43894);
    boolean bool = ((AppBrandInitConfigWC)super.ON()).ldK;
    AppMethodBeat.o(43894);
    return bool;
  }
  
  public final void bsu()
  {
    AppMethodBeat.i(43898);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "callSuperClose appId:%s", new Object[] { this.mAppId });
    super.close();
    AppMethodBeat.o(43898);
  }
  
  protected final void bsv()
  {
    AppMethodBeat.i(43905);
    b(com.tencent.mm.plugin.appbrand.networking.c.class, com.tencent.mm.plugin.appbrand.networking.h.njF);
    b(com.tencent.mm.plugin.appbrand.permission.j.class, new com.tencent.mm.plugin.appbrand.permission.m(this));
    b(com.tencent.mm.plugin.appbrand.permission.k.class, com.tencent.mm.plugin.appbrand.permission.o.nxJ);
    b(com.tencent.mm.plugin.appbrand.jsapi.media.e.class, com.tencent.mm.plugin.appbrand.jsapi.media.p.meq);
    ag(com.tencent.mm.plugin.appbrand.networking.d.class);
    b(com.tencent.mm.plugin.appbrand.networking.d.class, new com.tencent.mm.plugin.appbrand.networking.g(this));
    b(com.tencent.mm.plugin.appbrand.jsapi.base.g.class, new ab());
    b(com.tencent.mm.plugin.appbrand.widget.g.class, com.tencent.mm.plugin.appbrand.widget.h.ols);
    b(com.tencent.mm.plugin.appbrand.jsapi.z.b.class, com.tencent.mm.plugin.appbrand.luggage.b.c.nac);
    b(com.tencent.luggage.sdk.f.a.class, com.tencent.mm.plugin.appbrand.app.g.kIF);
    b(ba.class, new ah(this));
    b(com.tencent.mm.plugin.appbrand.jsapi.media.a.a.class, new com.tencent.mm.plugin.appbrand.jsapi.media.a.a()
    {
      public final void a(final Context paramAnonymousContext, final Runnable paramAnonymousRunnable1, final Runnable paramAnonymousRunnable2)
      {
        AppMethodBeat.i(226203);
        if (!com.tencent.mm.plugin.appbrand.utils.ag.LB())
        {
          q.this.i(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(174677);
              com.tencent.mm.platformtools.p.a(paramAnonymousContext, paramAnonymousRunnable1, paramAnonymousRunnable2);
              AppMethodBeat.o(174677);
            }
          }, 0L);
          AppMethodBeat.o(226203);
          return;
        }
        com.tencent.mm.platformtools.p.a(paramAnonymousContext, paramAnonymousRunnable1, paramAnonymousRunnable2);
        AppMethodBeat.o(226203);
      }
    });
    p.Uj(this.mAppId);
    AppMethodBeat.o(43905);
  }
  
  protected final void bsy()
  {
    AppMethodBeat.i(43907);
    com.tencent.luggage.sdk.g.c.a("clearDuplicatedInstanceOnAppCreate", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174656);
        Object localObject = a.TQ(q.this.mAppId);
        if ((localObject != null) && (q.this != localObject))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "clearDuplicatedInstanceOnAppCreate duplicated[%d] this[%d]", new Object[] { Integer.valueOf(localObject.hashCode()), Integer.valueOf(hashCode()) });
          ((q)localObject).bsH();
        }
        localObject = q.this.kDi;
        String str = q.this.mAppId;
        ((AppBrandRemoteTaskController)localObject).nPd = AppBrandRemoteTaskController.a.nPy;
        ((AppBrandRemoteTaskController)localObject).mAppId = str;
        AppBrandMainProcessService.a((MainProcessTask)localObject);
        AppMethodBeat.o(174656);
      }
    });
    AppMethodBeat.o(43907);
  }
  
  public com.tencent.mm.plugin.appbrand.page.ag bsz()
  {
    AppMethodBeat.i(226220);
    if ((com.tencent.mm.plugin.appbrand.page.x)super.brh() == null)
    {
      AppMethodBeat.o(226220);
      return null;
    }
    if (((com.tencent.mm.plugin.appbrand.page.x)super.brh()).getCurrentPage() == null)
    {
      AppMethodBeat.o(226220);
      return null;
    }
    com.tencent.mm.plugin.appbrand.page.ag localag = (com.tencent.mm.plugin.appbrand.page.ag)((com.tencent.mm.plugin.appbrand.page.x)super.brh()).getCurrentPage().getCurrentPageView();
    AppMethodBeat.o(226220);
    return localag;
  }
  
  protected final void c(s params)
  {
    AppMethodBeat.i(226231);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onServiceProvidedBeforeRealInit, appId:%s, preloadedService:%s", new Object[] { this.mAppId, params });
    AppMethodBeat.o(226231);
  }
  
  public final void close()
  {
    AppMethodBeat.i(43897);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "close() appId:%s, stack:%s", new Object[] { this.mAppId, android.util.Log.getStackTraceString(new Throwable()) });
    Runnable local16;
    com.tencent.mm.plugin.appbrand.widget.dialog.f localf;
    int j;
    int i;
    for (;;)
    {
      try
      {
        if (h.Uc(this.mAppId) == h.d.kzP)
        {
          localObject1 = (com.tencent.mm.plugin.appbrand.game.f.a)((com.tencent.mm.plugin.appbrand.page.x)super.brh()).getPageView().S(com.tencent.mm.plugin.appbrand.game.f.a.class);
          if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.game.f.a)localObject1).bDj() != null))
          {
            localObject1 = ((com.tencent.mm.plugin.appbrand.game.f.a)localObject1).bDj();
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: triggerMakeCanvasBitmap");
            if ((((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).lsZ != null) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).bDl() != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).lsZ.Nzf)) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).lsZ.NyX) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).ltb != null)) {
              continue;
            }
            com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: should not do make canvas bitmap!");
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandRuntimeWC", localException, "hy: triggerMakeCanvasBitmap error!", new Object[0]);
        continue;
        local16 = new Runnable()
        {
          public final void run()
          {
            boolean bool3 = true;
            AppMethodBeat.i(174674);
            Object localObject;
            q localq;
            int i;
            boolean bool1;
            if (q.g(q.this) != null)
            {
              localObject = q.g(q.this);
              localq = q.this;
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "close, runtime:%s", new Object[] { localq.mAppId });
              i = com.tencent.mm.plugin.appbrand.floatball.b.b(h.Uc(localq.mAppId));
              if ((((com.tencent.mm.plugin.appbrand.q.c)localObject).nhs != null) && (((com.tencent.mm.plugin.appbrand.q.c)localObject).nhs.O(i, true))) {}
              for (bool1 = true;; bool1 = false)
              {
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "close, result:%s", new Object[] { Boolean.valueOf(bool1) });
                if (!bool1) {
                  break;
                }
                AppMethodBeat.o(174674);
                return;
              }
            }
            if (q.h(q.this) != null)
            {
              localObject = q.h(q.this);
              localq = q.this;
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFloatBallLogic", "close, runtime:%s", new Object[] { localq.mAppId });
              i = com.tencent.mm.plugin.appbrand.floatball.b.b(h.Uc(localq.mAppId));
              boolean bool2;
              if ((((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqy != null) && (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqy.bCL()))
              {
                bool1 = true;
                if ((((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqz == null) || (!((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqz.bCL())) {
                  break label291;
                }
                bool2 = true;
                label218:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFloatBallLogic", "close, voip:%s, voip1v1:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                if (!bool1) {
                  break label296;
                }
                ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqy.a(AndroidContextUtil.castActivityOrNull(localq.mContext), new c.2((com.tencent.mm.plugin.appbrand.floatball.c)localObject, i));
                bool1 = bool3;
              }
              for (;;)
              {
                if (!bool1) {
                  break label360;
                }
                AppMethodBeat.o(174674);
                return;
                bool1 = false;
                break;
                label291:
                bool2 = false;
                break label218;
                label296:
                if (bool2)
                {
                  ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqz.a(AndroidContextUtil.castActivityOrNull(localq.mContext), new c.3((com.tencent.mm.plugin.appbrand.floatball.c)localObject, i));
                  bool1 = bool3;
                }
                else
                {
                  bool1 = ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).ww(i);
                  com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFloatBallLogic", "close, result:%s", new Object[] { Boolean.valueOf(bool1) });
                }
              }
            }
            label360:
            q.this.bsu();
            AppMethodBeat.o(174674);
          }
        };
        localf = new com.tencent.mm.plugin.appbrand.widget.dialog.f((com.tencent.mm.plugin.appbrand.service.c)super.NY());
        if (localf.lrj != null) {
          break;
        }
      }
      OpenBusinessViewUtil.A(this);
      if (((AppBrandInitConfigWC)super.ON()).leh != null) {
        this.kAH.a(new com.tencent.mm.plugin.appbrand.a.c.a()
        {
          public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
          {
            AppMethodBeat.i(226196);
            if (com.tencent.mm.plugin.appbrand.a.b.kQI == paramAnonymousb)
            {
              q.this.kAH.b(this);
              paramAnonymousString = q.this.bsC().leh;
              if ((AndroidContextUtil.castActivityOrNull(q.this.mContext) == null) || (!AndroidContextUtil.castActivityOrNull(q.this.mContext).isFinishing())) {
                break label76;
              }
            }
            label76:
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousString.hY(bool);
              AppMethodBeat.o(226196);
              return;
            }
          }
        });
      }
      if ((bsr()) || (af.p(this)))
      {
        super.close();
        AppMethodBeat.o(43897);
        return;
        if (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).bDm()) {
          ((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).bDl().MR();
        }
      }
      else
      {
        j = 0;
        if ((this != null) && (bsB() != null) && (AndroidContextUtil.castActivityOrNull(this.mContext) != null)) {
          break label510;
        }
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "invalid close state");
        i = 0;
        label328:
        if (i == 0) {
          break label1379;
        }
        if (j != 0)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: WA dialog first");
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1237L, 2L, 1L, false);
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        local16.run();
      }
      AppMethodBeat.o(43897);
      return;
      Object localObject2 = localf.lrj.nGg;
      if ((localObject2 == null) || (((ffc)localObject2).NAv == null) || (((ffc)localObject2).NAv.size() < 3))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: no config");
        j = 0;
        break;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1237L, 0L, 1L, false);
      long l1 = p.Um(this.mAppId).lastResumeTime;
      localf.mEO = ((int)(System.currentTimeMillis() - l1));
      if (localf.mEO < ((ffc)localObject2).NAx * 1000)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: time limit");
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1237L, 1L, 1L, false);
        j = 0;
        break;
      }
      j = 1;
      break;
      label510:
      localObject2 = bsB();
      if (!((AppBrandSysConfigWC)localObject2).leI)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "can not show evaluate dialog");
        i = 0;
        break label328;
      }
      l1 = p.Um(this.mAppId).lastResumeTime;
      long l2 = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "app time lastResumeTime:%s, closeTime:%s, leastTime:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(((AppBrandSysConfigWC)localObject2).leK) });
      if ((l2 - l1) / 1000L < ((AppBrandSysConfigWC)localObject2).leK)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "time not enough to show evaluate dialog");
        i = 0;
        break label328;
      }
      Object localObject5 = (AppBrandInitConfigWC)super.ON();
      localf.userName = ((AppBrandInitConfigWC)localObject5).username;
      if (Util.isNullOrNil(localf.userName))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "username is null, can not show evaluate dialog");
        i = 0;
        break label328;
      }
      Object localObject3 = AndroidContextUtil.castActivityOrNull(this.mContext);
      Object localObject4 = ((AppBrandInitConfigWC)localObject5).appId;
      Object localObject6 = ((AppBrandInitConfigWC)localObject5).brandName;
      boolean bool = ((AppBrandSysConfigWC)localObject2).leJ;
      localf.dialog = com.tencent.mm.plugin.appbrand.widget.dialog.f.z((Context)localObject3, true);
      localObject5 = (LinearLayout)LayoutInflater.from(localf.dialog.getContext()).inflate(2131493029, null, false);
      localf.dialog.setContentView((View)localObject5);
      Object localObject7 = ao.az(localf.dialog.getContext());
      i = Math.min(((Point)localObject7).x, ((Point)localObject7).y);
      localObject7 = new FrameLayout.LayoutParams(i, -2);
      ((FrameLayout.LayoutParams)localObject7).gravity = 1;
      ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject7);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "createEvaluateDialog, dialog width:%d", new Object[] { Integer.valueOf(i) });
      localf.Iaa = ((TextView)localf.dialog.findViewById(2131300175));
      localf.Iab = ((LinearLayout)localf.dialog.findViewById(2131300176));
      localf.Iac = ((LinearLayout)localf.dialog.findViewById(2131300173));
      localObject7 = (TextView)localf.dialog.findViewById(2131300172);
      if (bool)
      {
        ((TextView)localObject7).setVisibility(0);
        ((TextView)localObject7).setOnClickListener(new f.15(localf, (Context)localObject3, (String)localObject4, (String)localObject6));
        label920:
        ((TextView)localf.dialog.findViewById(2131300179)).setOnClickListener(new f.16(localf, (Context)localObject3));
        localf.HZZ = ((RatingBar)localf.dialog.findViewById(2131300177));
        localf.HZZ.setOnRatingBarChangeListener(new f.17(localf));
        localf.oqv = ((TextView)localf.dialog.findViewById(2131300174));
        if (Util.isNullOrNil((String)localObject6)) {
          break label1239;
        }
        localf.oqv.setVisibility(0);
        localf.oqv.setText(((Context)localObject3).getString(2131755445, new Object[] { localObject6 }));
        label1045:
        ((ImageView)localf.dialog.findViewById(2131300171)).setOnClickListener(new f.18(localf));
        localObject3 = (ViewGroup)((LinearLayout)localObject5).getParent();
        if (localObject3 != null)
        {
          ((ViewGroup)localObject3).setOnClickListener(new f.19(localf));
          ((LinearLayout)localObject5).setOnClickListener(new f.20(localf));
        }
        localf.dialog = localf.dialog;
        localf.dialog.setOnCancelListener(new f.1(localf));
        localf.dialog.setOnDismissListener(new f.12(localf, local16));
        localf.GfH = false;
        ((AppBrandSysConfigWC)localObject2).leI = false;
        if (this != null) {
          break label1252;
        }
        localObject2 = null;
        label1179:
        localf.appId = ((String)localObject2);
        if (!Util.isNullOrNil(localf.appId)) {
          break label1261;
        }
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "saveEvaluateReport, no app id");
      }
      for (;;)
      {
        localf.eI(1, 1);
        localf.show();
        i = 1;
        break;
        ((TextView)localObject7).setVisibility(8);
        ((TextView)localObject7).setOnClickListener(null);
        break label920;
        label1239:
        localf.oqv.setVisibility(8);
        break label1045;
        label1252:
        localObject2 = this.mAppId;
        break label1179;
        label1261:
        localObject2 = (AppBrandInitConfigWC)super.ON();
        localf.sessionId = "";
        if (localObject2 != null) {
          localf.sessionId = ((AppBrandInitConfigLU)localObject2).cym;
        }
        localf.scene = 1000;
        if ((localObject2 != null) && (((AppBrandInitConfigLU)localObject2).cyA != null)) {
          localf.scene = ((AppBrandInitConfigLU)localObject2).cyA.scene;
        }
        localf.dCx = "";
        if (((com.tencent.mm.plugin.appbrand.service.c)super.NY() != null) && (((com.tencent.mm.plugin.appbrand.service.c)super.NY()).bsz() != null)) {
          localf.dCx = ((com.tencent.mm.plugin.appbrand.service.c)super.NY()).bsz().lBI;
        }
      }
      label1379:
      if (j != 0)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "need show game evaluate dialog");
        localObject2 = localf.lrj.nGg;
        localf.lrj.nGg = null;
        localf.dialog = com.tencent.mm.plugin.appbrand.widget.dialog.f.z(AndroidContextUtil.castActivityOrNull(this.mContext), false);
        localObject3 = (LinearLayout)LayoutInflater.from(localf.dialog.getContext()).inflate(2131493034, null, false);
        localf.dialog.setContentView((View)localObject3);
        localObject4 = ao.az(localf.dialog.getContext());
        localObject4 = new FrameLayout.LayoutParams(Math.min(((Point)localObject4).x, ((Point)localObject4).y), ((LinearLayout)localObject3).getLayoutParams().height);
        ((FrameLayout.LayoutParams)localObject4).gravity = 1;
        ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        localObject5 = (TextView)((LinearLayout)localObject3).findViewById(2131309195);
        ((TextView)localObject5).setText(((ffc)localObject2).Title);
        localObject6 = (TextView)((LinearLayout)localObject3).findViewById(2131300174);
        ((TextView)localObject6).setText(((ffc)localObject2).NAu);
        localObject4 = (ImageView)((LinearLayout)localObject3).findViewById(2131300171);
        localObject5 = new f.21(localf, (TextView)localObject5, (TextView)localObject6, (ImageView)localObject4, (LinearLayout)localObject3, this, local16, (ffc)localObject2);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(2131305643)).a(0, (ffc)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(2131305644)).a(1, (ffc)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(2131305645)).a(2, (ffc)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        localf.dialog.setOnCancelListener(new f.2(localf, this, (ffc)localObject2, local16));
        ((ImageView)localObject4).setOnClickListener(new f.3(localf, this, (ffc)localObject2, local16));
        localf.dialog = localf.dialog;
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1237L, 4L, 1L, false);
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
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "finish appId[%s] type[%d] hash[%d] stacktrace=%s", new Object[] { this.mAppId, Integer.valueOf(this.kAq.eix), Integer.valueOf(hashCode()), android.util.Log.getStackTraceString(new Throwable()) });
    if ((k.e(this)) || (this.kAl == null))
    {
      i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(43877);
          q.this.dispatchDestroy();
          AppMethodBeat.o(43877);
        }
      }, 0L);
      AppMethodBeat.o(43899);
      return;
    }
    super.finish();
    if (this.kDs != null) {
      this.kDs.w(this);
    }
    if (this.kDt != null) {
      com.tencent.mm.plugin.appbrand.q.c.w(this);
    }
    AppMethodBeat.o(43899);
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid()
  {
    AppMethodBeat.i(226235);
    if (this.kAl != null)
    {
      localObject = this.kAl.getWindowAndroid();
      if (localObject != null)
      {
        if ((this.kDv != null) && ((this.kDv instanceof com.tencent.mm.plugin.appbrand.platform.window.g)) && ((((com.tencent.mm.plugin.appbrand.platform.window.g)this.kDv).OD()) || ((this.kDv instanceof com.tencent.mm.plugin.appbrand.o.a))))
        {
          if ((this.kDC == null) || (this.kDC.nEu != localObject) || (this.kDC.nEv != this.kDv)) {
            this.kDC = new com.tencent.mm.plugin.appbrand.platform.window.f((com.tencent.mm.plugin.appbrand.platform.window.c)localObject, (com.tencent.mm.plugin.appbrand.platform.window.g)this.kDv);
          }
          localObject = this.kDC;
          AppMethodBeat.o(226235);
          return localObject;
        }
        AppMethodBeat.o(226235);
        return localObject;
      }
    }
    Object localObject = super.getWindowAndroid();
    AppMethodBeat.o(226235);
    return localObject;
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(43903);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.plugin.appbrand.jsapi.y.h.a(paramConfiguration, this.mAppId);
    this.kDr = new Configuration(paramConfiguration);
    this.kDv.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(43903);
  }
  
  protected void onCreate()
  {
    AppMethodBeat.i(43906);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepPrepareRuntime);
    gu(false);
    bsy();
    com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
    Object localObject1 = (AppBrandInitConfigWC)super.ON();
    Object localObject2;
    boolean bool;
    int i;
    if (localObject1 != null)
    {
      localObject2 = ((AppBrandInitConfigWC)localObject1).ldW;
      if (localObject2 != null) {}
    }
    else
    {
      a.setRuntime(this);
      com.tencent.mm.plugin.appbrand.e.a.Q(this);
      bst();
      bool = WXHardCoderJNI.hcMiniProgramLaunchEnable;
      int j = WXHardCoderJNI.hcMiniProgramLaunchDelay;
      int k = WXHardCoderJNI.hcMiniProgramLaunchCPU;
      int m = WXHardCoderJNI.hcMiniProgramLaunchIO;
      if (!WXHardCoderJNI.hcMiniProgramLaunchThr) {
        break label1180;
      }
      i = Process.myTid();
      label95:
      this.kDm = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMiniProgramLaunchTimeout, 801, WXHardCoderJNI.hcMiniProgramLaunchAction, "MicroMsg.AppBrandRuntimeWC");
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onCreate %s, scene:%d, instanceId:%s, sessionId:%s", new Object[] { this, Integer.valueOf(ON().cyA.scene), ((AppBrandInitConfigWC)super.ON()).cyn, ((AppBrandInitConfigWC)super.ON()).cym });
      super.onCreate();
      bsv();
      if (!NA()) {
        break label1185;
      }
      localObject1 = com.tencent.luggage.sdk.d.g.cCq;
      localObject1 = v.a.mTH;
      com.tencent.luggage.sdk.d.g.OW();
      localObject1 = com.tencent.mm.plugin.appbrand.game.preload.d.bDu();
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kGW = this;
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ltU = new com.tencent.mm.plugin.appbrand.game.preload.c(this);
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).hasInit = true;
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ltW = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rRh, false);
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ltX = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rUT, false);
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ltR = new com.tencent.mm.plugin.appbrand.s.m(((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ltU, ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ltX);
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ltY = new AtomicInteger(0);
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ltZ = new AtomicInteger(0);
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).lua = new AtomicInteger(0);
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).lub = new AtomicInteger(0);
      com.tencent.mm.plugin.appbrand.game.preload.d.bDu().bu(((AppBrandInitConfigWC)super.ON()).kHK);
      label372:
      com.tencent.mm.plugin.appbrand.report.quality.b.H(this);
      localObject1 = com.tencent.mm.plugin.appbrand.report.quality.o.nMe;
      com.tencent.mm.plugin.appbrand.report.quality.o.eI(this.mAppId, com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId).kEY);
      com.tencent.mm.plugin.appbrand.report.quality.g.a(this, false, com.tencent.mm.plugin.appbrand.utils.b.afF(((AppBrandInitConfigWC)super.ON()).ldT));
      localObject1 = com.tencent.luggage.game.e.a.Nn();
      localObject2 = this.mAppId;
      bool = NA();
      ((com.tencent.luggage.game.e.a)localObject1).appId = ((String)localObject2);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MBNiReporter", "hy: appId:%s,isGame:%s", new Object[] { localObject2, Boolean.valueOf(bool) });
      if (bool) {
        h.a((String)localObject2, ((com.tencent.luggage.game.e.a)localObject1).cxI);
      }
      ((com.tencent.luggage.game.e.a)localObject1).cxA = new ArrayList();
      if (!bool) {
        break label1201;
      }
      ((com.tencent.luggage.game.e.a)localObject1).cxE = 1004;
      label506:
      com.tencent.mm.plugin.s.a.a(this.mAppId, ((AppBrandInitConfigWC)super.ON()).ldQ);
      a(new AppBrandRuntime.b()
      {
        private volatile g.b kDS;
        
        public final void interrupt()
        {
          AppMethodBeat.i(226206);
          if (this.kDS != null) {
            this.kDS.interrupt();
          }
          AppMethodBeat.o(226206);
        }
        
        public final void prepare()
        {
          AppMethodBeat.i(226205);
          com.tencent.mm.plugin.appbrand.keylogger.c.a(q.this.mAppId, KSProcessWeAppLaunch.stepWaitForCommLibConfirm);
          this.kDS = com.tencent.mm.plugin.appbrand.launching.g.a(q.this, new kotlin.g.a.b() {});
          AppMethodBeat.o(226205);
        }
      });
      a(new AppBrandRuntime.b()
      {
        public final void prepare()
        {
          AppMethodBeat.i(226207);
          q.a(q.this, this);
          AppMethodBeat.o(226207);
        }
      });
      a(new b((byte)0));
      localObject1 = new m(this);
      this.kDq = ((m)localObject1);
      a((AppBrandRuntime.b)localObject1);
      this.kDi.N(this);
      com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
      com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.s(this);
      com.tencent.mm.plugin.appbrand.backgroundfetch.i.s(this);
      com.tencent.mm.plugin.appbrand.utils.g.S(this);
      OpenBusinessViewUtil.z(this);
      AppBrandBackgroundRunningMonitor.t(this);
      this.kDj = new com.tencent.mm.plugin.appbrand.report.model.n();
      this.kDj.nJu = Util.currentTicks();
      this.kDy = new com.tencent.mm.plugin.appbrand.report.model.r();
      localObject1 = this.kDy;
      localObject2 = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId).kEY;
      String str = this.mAppId;
      long l = ((AppBrandInitConfigWC)super.ON()).cyo + 1000;
      kotlin.g.b.p.h(localObject2, "instanceId");
      kotlin.g.b.p.h(str, "appId");
      ((com.tencent.mm.plugin.appbrand.report.model.r)localObject1).nKk = Long.valueOf(System.currentTimeMillis());
      ((com.tencent.mm.plugin.appbrand.report.model.r)localObject1).sessionId = ((String)localObject2);
      ((com.tencent.mm.plugin.appbrand.report.model.r)localObject1).appId = str;
      ((com.tencent.mm.plugin.appbrand.report.model.r)localObject1).nKj = Long.valueOf(l);
      com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k.a(this.mAppId, brs(), ON().cyA);
      if (ON().cyA.scene != 1099) {
        break label1212;
      }
      bool = true;
      label774:
      this.kDn = bool;
      if (bsr()) {
        this.kDo.add(new ae((AppBrandInitConfigWC)super.ON()));
      }
      this.kDo.add(new ar((AppBrandInitConfigWC)super.ON(), this));
      this.kAH.a(new com.tencent.mm.plugin.appbrand.a.c.a()
      {
        public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
        {
          AppMethodBeat.i(226208);
          if (com.tencent.mm.plugin.appbrand.a.b.kQJ == paramAnonymousb)
          {
            q.this.kDh.moZ.mpa.clear();
            com.tencent.mm.plugin.appbrand.report.quality.k.cj(paramAnonymousString, 4);
          }
          AppMethodBeat.o(226208);
        }
      });
      if (this.kAl == null) {
        break label1218;
      }
      bsw();
      label862:
      if (this.kAl == null) {
        break label1240;
      }
      bsx();
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId);
      if (localObject1 != null) {
        ((QualitySession)localObject1).nLl = (Util.nowMilliSecond() - ((AppBrandInitConfigWC)super.ON()).startTime);
      }
      if (j.a.vP(this.kAq.eix))
      {
        localObject1 = this.mAppId;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "invoke appId:%s", new Object[] { localObject1 });
        if (BuildInfo.IS_FLAVOR_BLUE)
        {
          localObject2 = com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_appbrand_check_demoinfo_default", "1", true, true);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "xSwitch xSwitchStr:%s", new Object[] { localObject2 });
          if (TextUtils.equals((CharSequence)localObject2, "1")) {
            XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString((String)localObject1), com.tencent.mm.plugin.appbrand.task.a.a.a.class, new com.tencent.mm.plugin.appbrand.task.a.a.1((String)localObject1));
          }
        }
      }
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.snu, false))
      {
        localObject1 = this.mAppId;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppBrandCheckOnlineStatusTask", "invoke appId:%s", new Object[] { localObject1 });
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(""), com.tencent.mm.plugin.appbrand.task.a.a.class, new com.tencent.mm.plugin.appbrand.task.a.1((String)localObject1));
      }
      MultiProcessMMKV.getMMKV(this.mAppId + "_wxa_voip").putBoolean("isCameraStart", false);
      com.tencent.mm.plugin.cloudvoip.cloudvoice.d.m.czc();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "reset appId:%s isCameraStart false", new Object[] { this.mAppId });
      AppMethodBeat.o(43906);
      return;
      com.tencent.mm.ac.d.i((kotlin.g.a.a)new d.b(a.bqV(), (QualitySession)localObject2, (AppBrandInitConfigWC)localObject1));
      break;
      label1180:
      i = 0;
      break label95;
      label1185:
      localObject1 = com.tencent.luggage.sdk.d.g.cCq;
      localObject1 = v.a.mTH;
      com.tencent.luggage.sdk.d.g.OV();
      break label372;
      label1201:
      ((com.tencent.luggage.game.e.a)localObject1).cxE = 1000;
      break label506;
      label1212:
      bool = false;
      break label774;
      label1218:
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "onCreate appId:%s, skip initFloatBallHelper(), maybe under preRender mode", new Object[] { this.mAppId });
      break label862;
      label1240:
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "onCreate appId:%s, skip initMultiTaskHelper(), maybe under preRender mode", new Object[] { this.mAppId });
    }
  }
  
  public final void onDestroy()
  {
    int j = 1;
    AppMethodBeat.i(43914);
    if (((AppBrandInitConfigWC)super.ON()).leh != null)
    {
      ??? = ((AppBrandInitConfigWC)super.ON()).leh;
      if ((AndroidContextUtil.castActivityOrNull(this.mContext) == null) || (!AndroidContextUtil.castActivityOrNull(this.mContext).isFinishing())) {
        break label269;
      }
    }
    int i;
    Object localObject2;
    label269:
    for (boolean bool = true;; bool = false)
    {
      ((WeAppOpenUICallbackIPCProxy)???).hY(bool);
      super.onDestroy();
      MMToClientEvent.f((com.tencent.mm.plugin.appbrand.service.c)super.NY());
      MMToClientEvent.YZ("Common_IPC_appid");
      com.tencent.mm.plugin.appbrand.e.a.R(this);
      com.tencent.mm.plugin.appbrand.report.quality.b.J(this);
      if (this.kDm != 0)
      {
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.kDm);
        this.kDm = 0;
      }
      if (!DebuggerShell.bAx()) {
        break;
      }
      if (this.kDp != null) {
        this.kDp.stopTimer();
      }
      com.tencent.f.h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(160525);
          AppBrandPerformanceManager.h(q.this);
          AppMethodBeat.o(160525);
        }
      });
      com.tencent.mm.plugin.appbrand.performance.b.aei(this.mAppId);
      ??? = this.mAppId;
      i = 0;
      while (i < 2)
      {
        localObject2 = new String[] { "Needjs", "Needwebviewjs" }[i];
        localObject2 = (String)??? + "-" + (String)localObject2;
        String str = MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.ForceOpenAppNotify.TestInjectJsPath", 2).getString((String)localObject2, null);
        if (!TextUtils.isEmpty(str)) {
          com.tencent.mm.vfs.s.deleteFile(str);
        }
        MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.ForceOpenAppNotify.TestInjectJsPath", 2).remove((String)localObject2);
        i += 1;
      }
    }
    if (NA()) {
      com.tencent.mm.plugin.appbrand.game.preload.d.x(this);
    }
    ??? = AppBrandMusicClientService.ncV;
    ((AppBrandMusicClientService)???).ncU.clear();
    ((AppBrandMusicClientService)???).ncW = "";
    p.remove(this.mAppId);
    com.tencent.mm.plugin.appbrand.media.record.c.onDestroy();
    gv(true);
    if (this.kDx != null) {
      this.kDx.nnF.clear();
    }
    a.b(this);
    ??? = this.kDj;
    if (??? != null)
    {
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).sessionId = ((AppBrandInitConfigWC)super.ON()).cym;
      p.Um(this.mAppId);
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).networkType = com.tencent.mm.plugin.appbrand.report.i.getNetworkType(MMApplicationContext.getContext());
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).appId = this.mAppId;
      if (bsB() != null) {
        break label685;
      }
      i = ((AppBrandInitConfigWC)super.ON()).appVersion;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).appVersion = i;
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).dCv = (this.kAq.eix + 1);
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).scene = ON().cyA.scene;
      if (((com.tencent.mm.plugin.appbrand.report.model.n)???).nJv)
      {
        i = 1;
        label459:
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).nJw = i;
        if (!WebView.isX5()) {
          break label704;
        }
        i = j;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).nJx = i;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).nJy = Util.ticksToNow(((com.tencent.mm.plugin.appbrand.report.model.n)???).nJu);
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).nJz = Util.nowMilliSecond();
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).username = ((AppBrandInitConfigWC)super.ON()).username;
        localObject2 = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId);
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).nJA = ((QualitySessionRuntime)localObject2).apptype;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).kEY = ((QualitySessionRuntime)localObject2).kEY;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).report();
        com.tencent.mm.plugin.appbrand.ui.recommend.e.P(this);
        this.kDj = null;
        this.kDl = false;
        this.kDq = null;
        if (this.kDu != null)
        {
          ??? = this.kDu;
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "onDestroy");
          ((com.tencent.mm.plugin.appbrand.ad.h)???).UD("onDestroy");
          ((com.tencent.mm.plugin.appbrand.ad.h)???).kHb = null;
          this.kDu = null;
        }
        this.kDB.clear();
        this.kDo.clear();
        ??? = this.kDh;
        ((com.tencent.mm.plugin.appbrand.jsapi.w.a)???).moZ.mpa.clear();
      }
      synchronized (((com.tencent.mm.plugin.appbrand.jsapi.w.a)???).moY)
      {
        ((SparseArray)???).clear();
        localObject2 = kotlin.x.SXb;
        com.tencent.mm.plugin.appbrand.jsapi.ag.b.d.release();
        k.Ue(this.mAppId);
        AppMethodBeat.o(43914);
        return;
        label685:
        i = bsB().leE.pkgVersion;
        continue;
        i = 0;
        break label459;
        label704:
        i = 0;
      }
    }
  }
  
  public final void onEnterAnimationComplete()
  {
    AppMethodBeat.i(174690);
    if ((isDestroyed()) || (this.SO))
    {
      AppMethodBeat.o(174690);
      return;
    }
    Object localObject = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId);
    if (localObject != null) {
      ((QualitySessionRuntime)localObject).nLs = Util.nowMilliSecond();
    }
    localObject = super.brK();
    if ((localObject instanceof com.tencent.mm.plugin.appbrand.ui.ae)) {
      ((com.tencent.mm.plugin.appbrand.ui.ae)localObject).setCanShowHideAnimation(true);
    }
    if ((localObject instanceof com.tencent.mm.plugin.appbrand.ui.m)) {
      ((com.tencent.mm.plugin.appbrand.ui.m)localObject).setLoadingIconVisibility(true);
    }
    if (AndroidContextUtil.castActivityOrNull(this.mContext) != null) {
      com.tencent.mm.ui.statusbar.c.bt(AndroidContextUtil.castActivityOrNull(this.mContext)).requestApplyInsets();
    }
    if (((AppBrandInitConfigWC)super.ON()).leh != null) {
      ((AppBrandInitConfigWC)super.ON()).leh.mXx.b((Parcelable)new IPCVoid());
    }
    AppMethodBeat.o(174690);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(43912);
    super.onPause();
    Object localObject = this.kDi;
    ((AppBrandRemoteTaskController)localObject).nPd = AppBrandRemoteTaskController.a.nPA;
    AppBrandMainProcessService.a((MainProcessTask)localObject);
    if (this.kDs != null)
    {
      localObject = this.kDs;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFloatBallLogic", "pause, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqw != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqw.aGj();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqx != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqx.aGj();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqy != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqy.aGj();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqA != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqA.aGj();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqz != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqz.aGj();
      }
    }
    if (this.kDt != null)
    {
      localObject = this.kDt;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "pause, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.q.c)localObject).nhs != null) {
        ((com.tencent.mm.plugin.appbrand.q.c)localObject).nhs.aGj();
      }
    }
    bsq().bsP();
    AppMethodBeat.o(43912);
  }
  
  public void onReady()
  {
    AppMethodBeat.i(43909);
    super.onReady();
    p.Un(this.mAppId).lastResumeTime = System.currentTimeMillis();
    if (this.kDm != 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.kDm);
      this.kDm = 0;
    }
    long l1 = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.ON()).startTime;
    com.tencent.mm.plugin.appbrand.report.i.a(l1, this.kDl, NA());
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onReady reportStartupTime: appId:%s, nickname:%s, cost:%dms, download:%b, isGame:%b", new Object[] { this.mAppId, ((AppBrandInitConfigWC)super.ON()).brandName, Long.valueOf(l1), Boolean.valueOf(this.kDl), Boolean.valueOf(NA()) });
    l1 = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.ON()).startTime;
    this.kDk.I(5, l1);
    Object localObject1 = this.kDk;
    boolean bool1 = this.kDl;
    boolean bool2 = ((AppBrandInitConfigWC)super.ON()).cyy;
    boolean bool3 = ((AppStartupPerformanceReportBundle)av(AppStartupPerformanceReportBundle.class)).mSG;
    Object localObject2 = this.mAppId;
    ((o)localObject1).cR = 0;
    ((o)localObject1).mType = 0;
    if (bsB() != null)
    {
      ((o)localObject1).cR = bsB().leE.pkgVersion;
      ((o)localObject1).mType = (bsB().leE.kNW + 1);
    }
    int i;
    label274:
    Object localObject3;
    label320:
    Object localObject4;
    if (bool1)
    {
      i = 1;
      ((o)localObject1).kCH = i;
      if (!NA()) {
        break label1135;
      }
      i = 1;
      ((o)localObject1).kCM = i;
      ((o)localObject1).mScene = ON().cyA.scene;
      ((o)localObject1).kCK = bool2;
      ((o)localObject1).kCL = bool3;
      localObject3 = new StringBuilder();
      i = 0;
      if (i >= ((o)localObject1).kCG.length) {
        break label1169;
      }
      if (localObject1.kCG[i] >= 0L) {
        break label1140;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: abort, illegal value: %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(localObject1.kCG[i]) });
      AppBrandPerformanceManager.a(this, 202, l1);
      com.tencent.mm.plugin.appbrand.performance.c.Bo(((AppBrandInitConfigWC)super.ON()).startTime);
      com.tencent.mm.plugin.appbrand.report.quality.b.a(this.mAppId, this);
      if ((DebuggerShell.bAx()) && (this.kDp == null))
      {
        this.kDp = new MTimerHandler(com.tencent.mm.plugin.appbrand.performance.b.a.nwM.bSR().getLooper(), new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(226198);
            com.tencent.mm.plugin.appbrand.performance.b.h(q.this);
            AppMethodBeat.o(226198);
            return true;
          }
        }, true);
        this.kDp.startTimer(1000L);
      }
      if (NA())
      {
        localObject1 = com.tencent.mm.plugin.appbrand.game.preload.d.bDu();
        l1 = Util.nowMilliSecond();
        long l2 = ((AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).kGW.ON()).startTime;
        com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(2001, (int)(l1 - l2));
      }
      com.tencent.mm.plugin.appbrand.ui.recommend.e.Q(this);
      if (((AppBrandInitConfigWC)super.ON()).cyz != com.tencent.luggage.sdk.launching.b.cBC) {
        this.kDi.iC(false);
      }
      if (OK() != null)
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.appstorage.o)OK().az(com.tencent.mm.plugin.appbrand.appstorage.o.class);
        com.tencent.mm.vfs.s.f(((com.tencent.mm.plugin.appbrand.appstorage.o)localObject1).kSr + "/dir.lock", new byte[1], 1);
      }
      localObject4 = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId);
      if ((localObject4 != null) && (!NA()))
      {
        com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
        kotlin.g.b.p.h(this, "runtime");
        nb localnb = new nb();
        localObject3 = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId);
        if (localObject3 == null) {
          break label1522;
        }
        localnb.eWb = localnb.x("InstanceId", ((QualitySessionRuntime)localObject3).kEY, true);
        localnb.eJx = localnb.x("AppId", ((QualitySessionRuntime)localObject3).appId, true);
        localnb.eXc = ((QualitySessionRuntime)localObject3).nLk;
        localnb.ffU = nb.a.mN(((QualitySessionRuntime)localObject3).nJE);
        localnb.eYW = ((QualitySessionRuntime)localObject3).apptype;
        localnb.erW = ((QualitySessionRuntime)localObject3).scene;
        localObject1 = (com.tencent.mm.plugin.appbrand.page.x)super.brh();
        kotlin.g.b.p.g(localObject1, "runtime.pageContainer");
        localObject1 = ((com.tencent.mm.plugin.appbrand.page.x)localObject1).getCurrentPage();
        if (localObject1 == null) {
          break label1516;
        }
        localObject1 = ((t)localObject1).getCurrentPageView();
        label759:
        localObject2 = localObject1;
        if (!(localObject1 instanceof com.tencent.mm.plugin.appbrand.page.ag)) {
          localObject2 = null;
        }
        localnb.evl = com.tencent.mm.plugin.appbrand.report.quality.d.z((com.tencent.mm.plugin.appbrand.page.ag)localObject2);
        localObject1 = localObject3;
        label791:
        com.tencent.mm.plugin.appbrand.report.quality.d.a((QualitySessionRuntime)localObject1, "Null session with " + this.mAppId);
        localnb.eZK = ((QualitySessionRuntime)localObject4).bVg();
        localnb.bfK();
      }
      if (localObject4 != null)
      {
        com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
        kotlin.g.b.p.h(this, "runtime");
        localObject3 = new ma();
        localObject2 = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(this.mAppId);
        if (localObject2 == null) {
          break label1565;
        }
        ((ma)localObject3).eWb = ((ma)localObject3).x("InstanceId", ((QualitySessionRuntime)localObject2).kEY, true);
        ((ma)localObject3).eJx = ((ma)localObject3).x("AppId", ((QualitySessionRuntime)localObject2).appId, true);
        ((ma)localObject3).eXc = ((QualitySessionRuntime)localObject2).nLk;
        ((ma)localObject3).faN = ma.a.mm(((QualitySessionRuntime)localObject2).nJE);
        ((ma)localObject3).eYW = ((QualitySessionRuntime)localObject2).apptype;
        ((ma)localObject3).erW = ((QualitySessionRuntime)localObject2).scene;
        localObject1 = (com.tencent.mm.plugin.appbrand.service.c)super.NY();
        if (localObject1 == null) {
          break label1528;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.service.c)localObject1).getJsRuntime();
        label976:
        localObject1 = com.tencent.mm.plugin.appbrand.report.e.d((com.tencent.mm.plugin.appbrand.m.i)localObject1);
        switch (com.tencent.mm.plugin.appbrand.report.quality.e.$EnumSwitchMapping$0[localObject1.ordinal()])
        {
        default: 
          i = -1;
          label1034:
          ((ma)localObject3).evl = i;
        }
      }
    }
    label1169:
    label1565:
    for (localObject1 = localObject2;; localObject1 = null)
    {
      com.tencent.mm.plugin.appbrand.report.quality.d.a((QualitySessionRuntime)localObject1, "Null session with " + this.mAppId);
      ((ma)localObject3).eZK = ((QualitySessionRuntime)localObject4).bVg();
      ((ma)localObject3).bfK();
      com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup);
      com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup_Game);
      com.tencent.mm.plugin.appbrand.keylogger.c.f(KSProcessWeAppLaunch.class, this.mAppId);
      com.tencent.mm.plugin.appbrand.report.quality.k.cj(this.mAppId, 1);
      AppMethodBeat.o(43909);
      return;
      i = 0;
      break;
      label1135:
      i = 0;
      break label274;
      label1140:
      ((StringBuilder)localObject3).append(localObject1.kCG[i]);
      ((StringBuilder)localObject3).append(",");
      i += 1;
      break label320;
      localObject4 = (AppBrandInitConfigWC)super.ON();
      if (localObject4 != null)
      {
        i = ((AppBrandInitConfigWC)localObject4).cyo;
        label1189:
        i += 1000;
        bool2 = com.tencent.mm.plugin.appbrand.task.e.k(com.tencent.mm.plugin.appbrand.task.g.iD(NA()));
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: %s, %s, Download: %s, Preload: %s, appServiceType: %s", new Object[] { localObject2, ((StringBuilder)localObject3).toString(), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(i) });
        ((o)localObject1).g((String)localObject2, 1, 0, i);
        ((o)localObject1).g((String)localObject2, 2, 1, i);
        ((o)localObject1).g((String)localObject2, 3, 2, i);
        ((o)localObject1).g((String)localObject2, 4, 3, i);
        ((o)localObject1).g((String)localObject2, 6, 4, i);
        ((o)localObject1).g((String)localObject2, 7, 5, i);
        ((o)localObject1).g((String)localObject2, 23, 6, i);
        ((o)localObject1).g((String)localObject2, 24, 7, i);
        ((o)localObject1).g((String)localObject2, 25, 8, i);
        ((o)localObject1).g((String)localObject2, 26, 9, i);
        ((o)localObject1).g((String)localObject2, 27, 10, i);
        ((o)localObject1).g((String)localObject2, 28, 11, i);
        ((o)localObject1).g((String)localObject2, 29, 12, i);
        ((o)localObject1).g((String)localObject2, 30, 13, i);
        ((o)localObject1).g((String)localObject2, 31, 14, i);
        if (((o)localObject1).kCM != 1) {
          break label1507;
        }
      }
      label1507:
      for (i = ((o)localObject1).kCJ;; i = ((o)localObject1).kCI)
      {
        com.tencent.mm.appbrand.v8.x.a(4, localObject1.kCG[5], i, (String)localObject2, ((o)localObject1).kCH, ((o)localObject1).kCM, gt(false).bvd());
        break;
        i = com.tencent.mm.plugin.appbrand.report.j.aeJ((String)localObject2);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeStartupReporter", "getServiceTypeForReport null = initConfig! appServiceType:%s", new Object[] { Integer.valueOf(i) });
        break label1189;
      }
      label1516:
      localObject1 = null;
      break label759;
      label1522:
      localObject1 = null;
      break label791;
      label1528:
      localObject1 = null;
      break label976;
      i = 1;
      break label1034;
      i = 2;
      break label1034;
      i = 3;
      break label1034;
      i = 4;
      break label1034;
      i = 5;
      break label1034;
      i = 6;
      break label1034;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(43911);
    super.onResume();
    p.Un(this.mAppId).lastResumeTime = System.currentTimeMillis();
    Object localObject;
    if (this.kDs != null)
    {
      localObject = this.kDs;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFloatBallLogic", "resume, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqw != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqw.bCA();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqx != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqx.bCA();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqy != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqy.bCA();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqA != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqA.bCA();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqz != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).lqz.bCA();
      }
    }
    if (this.kDt != null)
    {
      localObject = this.kDt;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "resume, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.q.c)localObject).nhs != null)
      {
        ((com.tencent.mm.plugin.appbrand.q.c)localObject).nhs.bCA();
        if (((AppBrandInitConfigWC)super.ON()).kHP == null) {
          break label355;
        }
        ((com.tencent.mm.plugin.appbrand.q.c)localObject).nhs.a(((AppBrandInitConfigWC)super.ON()).kHP.kHu);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "setMultiTaskCommonInfo not null");
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k.a(this.mAppId, brs(), ON().cyA);
      a.setRuntime(this);
      com.tencent.mm.plugin.appbrand.e.a.Q(this);
      this.kDi.O(this);
      if (this.kAK) {
        ((com.tencent.mm.plugin.appbrand.page.x)super.brh()).getReporter().bOD();
      }
      x.a.bUB().ce(this.mAppId, ON().cyA.scene);
      localObject = u.a(this, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(43870);
          AppBrandSysConfigWC localAppBrandSysConfigWC = q.this.bsB();
          WxaMenuHelper.GetCopyPathMenuExpireTimeTask localGetCopyPathMenuExpireTimeTask = new WxaMenuHelper.GetCopyPathMenuExpireTimeTask(q.this.mAppId);
          AppBrandMainProcessService.b(localGetCopyPathMenuExpireTimeTask);
          localAppBrandSysConfigWC.czc = WxaMenuHelper.GetCopyPathMenuExpireTimeTask.a(localGetCopyPathMenuExpireTimeTask);
          AppMethodBeat.o(43870);
        }
      });
      keep((com.tencent.mm.vending.e.a)localObject);
      com.tencent.f.h.RTc.b((Runnable)localObject, "getCopyPathMenuExpireTime");
      com.tencent.mm.plugin.appbrand.ipc.b.connect();
      if (bsz() == null) {
        break;
      }
      bsq().Uo(bsz().lBI);
      AppMethodBeat.o(43911);
      return;
      label355:
      ((com.tencent.mm.plugin.appbrand.q.c)localObject).nhs.a(null);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "setMultiTaskCommonInfo null enter scene:%d", new Object[] { Integer.valueOf(ON().cyA.scene) });
      if ((ON().cyA.scene == 1089) || (ON().cyA.scene == 1104)) {
        ((com.tencent.mm.plugin.appbrand.q.c)localObject).nhs.AbJ = Boolean.TRUE;
      } else {
        ((com.tencent.mm.plugin.appbrand.q.c)localObject).nhs.AbJ = Boolean.FALSE;
      }
    }
    com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "onResume, try upsertHandOff but get NULL PageView, appId:%s", new Object[] { this.mAppId });
    AppMethodBeat.o(43911);
  }
  
  public String toString()
  {
    AppMethodBeat.i(43886);
    String str = String.format(Locale.ENGLISH, "[AppBrandRuntimeWC::%s::%s::%d::@%d]", new Object[] { this.mAppId, bsm(), Integer.valueOf(this.kAq.eix), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(43886);
    return str;
  }
  
  public final void vy(int paramInt)
  {
    AppMethodBeat.i(43932);
    com.tencent.mm.plugin.appbrand.ui.ab localab = super.brK();
    if ((localab instanceof com.tencent.mm.plugin.appbrand.launching.q)) {
      ((com.tencent.mm.plugin.appbrand.launching.q)localab).vy(paramInt);
    }
    AppMethodBeat.o(43932);
  }
  
  final class a
    implements Runnable
  {
    private final AtomicBoolean kDO;
    
    a()
    {
      AppMethodBeat.i(43871);
      this.kDO = new AtomicBoolean(false);
      AppMethodBeat.o(43871);
    }
    
    public final void run()
    {
      AppMethodBeat.i(43872);
      if (!this.kDO.getAndSet(true))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] addPendingPermissionUpdateTask run()");
        paramRunnable.run();
      }
      AppMethodBeat.o(43872);
    }
  }
  
  final class b
    extends AppBrandRuntime.b
  {
    volatile AppBrandPrepareTask kDV;
    volatile boolean kDW = false;
    
    private b() {}
    
    public final void interrupt()
    {
      AppMethodBeat.i(43884);
      this.kDW = true;
      AppBrandPrepareTask localAppBrandPrepareTask = this.kDV;
      if (localAppBrandPrepareTask != null) {
        localAppBrandPrepareTask.interrupt();
      }
      AppMethodBeat.o(43884);
    }
    
    public final void prepare()
    {
      AppMethodBeat.i(43883);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| ResourcePrepareProcess.prepare() appId:%s", new Object[] { q.this.mAppId });
      com.tencent.mm.plugin.appbrand.launching.g.a(q.this, new kotlin.g.a.b()
      {
        private kotlin.x bsT()
        {
          AppMethodBeat.i(162153);
          if (!q.b.this.kDW) {}
          try
          {
            q.b.this.kDV = q.b(q.this, q.b.this);
            kotlin.x localx = kotlin.x.SXb;
            AppMethodBeat.o(162153);
            return localx;
          }
          catch (NullPointerException localNullPointerException)
          {
            while (q.this.isDestroyed()) {}
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q
 * JD-Core Version:    0.7.0.1
 */