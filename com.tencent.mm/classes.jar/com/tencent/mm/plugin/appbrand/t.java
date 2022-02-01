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
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.luggage.sdk.processes.main.LuggageClearDuplicatedTask;
import com.tencent.luggage.sdk.processes.main.LuggageRemoveTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.oy;
import com.tencent.mm.f.b.a.oy.a;
import com.tencent.mm.f.b.a.qa;
import com.tencent.mm.f.b.a.qa.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.ad.h.1;
import com.tencent.mm.plugin.appbrand.api.ParcelableMultiTaskData;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.NotifyWxaCommLibUpdatedEvent;
import com.tencent.mm.plugin.appbrand.appcache.NotifyWxaCommLibUpdatedEvent.UpdateResult.Succeed;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bl;
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
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.floatball.c.2;
import com.tencent.mm.plugin.appbrand.floatball.c.3;
import com.tencent.mm.plugin.appbrand.game.preload.d.2;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.EventLocationBackgroundStateChanged;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.file.av;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy;
import com.tencent.mm.plugin.appbrand.launching.f.b;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.launching.u.a;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper.GetCopyPathMenuExpireTimeTask;
import com.tencent.mm.plugin.appbrand.message.WxaAppMsgChannel;
import com.tencent.mm.plugin.appbrand.page.bc;
import com.tencent.mm.plugin.appbrand.page.bv;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.g.a;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.d.b;
import com.tencent.mm.plugin.appbrand.report.y.a;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.ipc.AppBrandNotifyPauseTask;
import com.tencent.mm.plugin.appbrand.task.ipc.AppBrandRegisterTask;
import com.tencent.mm.plugin.appbrand.task.ipc.AppBrandRuntimePreloadNextInvoke;
import com.tencent.mm.plugin.appbrand.task.ipc.AppBrandUpdateTask;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.appbrand.utils.w;
import com.tencent.mm.plugin.appbrand.widget.dialog.AppBrandGameEvaluateOptionView;
import com.tencent.mm.plugin.appbrand.widget.dialog.AppBrandGameEvaluateOptionView.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.e.1;
import com.tencent.mm.plugin.appbrand.widget.dialog.e.12;
import com.tencent.mm.plugin.appbrand.widget.dialog.e.15;
import com.tencent.mm.plugin.appbrand.widget.dialog.e.16;
import com.tencent.mm.plugin.appbrand.widget.dialog.e.17;
import com.tencent.mm.plugin.appbrand.widget.dialog.e.18;
import com.tencent.mm.plugin.appbrand.widget.dialog.e.19;
import com.tencent.mm.plugin.appbrand.widget.dialog.e.2;
import com.tencent.mm.plugin.appbrand.widget.dialog.e.20;
import com.tencent.mm.plugin.appbrand.widget.dialog.e.21;
import com.tencent.mm.plugin.appbrand.widget.dialog.e.3;
import com.tencent.mm.protocal.protobuf.foo;
import com.tencent.mm.protocal.protobuf.fqd;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ar;
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

public class t
  extends com.tencent.luggage.sdk.e.d
  implements com.tencent.luggage.sdk.h.d.a, com.tencent.mm.plugin.appbrand.launching.p
{
  public static final boolean nwr;
  volatile p nwA;
  private Configuration nwB;
  private com.tencent.mm.plugin.appbrand.floatball.c nwC;
  private com.tencent.mm.plugin.appbrand.q.c nwD;
  public com.tencent.mm.plugin.appbrand.ad.h nwE;
  public b nwF;
  private com.tencent.luggage.sdk.e.f<AppBrandInitConfigWC> nwG;
  private final com.tencent.mm.plugin.appbrand.report.q nwH;
  public com.tencent.mm.plugin.appbrand.widget.c.e nwI;
  private com.tencent.mm.plugin.appbrand.page.e nwJ;
  com.tencent.mm.plugin.appbrand.report.model.r nwK;
  public IListener<NotifyWxaCommLibUpdatedEvent> nwL;
  private com.tencent.mm.plugin.appbrand.k.b nwM;
  private final com.tencent.mm.plugin.appbrand.task.m nwN;
  private final Queue<Runnable> nwO;
  private com.tencent.mm.plugin.appbrand.platform.window.f nwP;
  public final com.tencent.mm.plugin.appbrand.jsapi.x.a nws;
  private volatile com.tencent.mm.plugin.appbrand.report.model.n nwt;
  public final r nwu;
  public boolean nwv;
  private int nww;
  private boolean nwx;
  private final List<aj> nwy;
  private MTimerHandler nwz;
  
  static
  {
    AppMethodBeat.i(43955);
    if ((WeChatEnvironment.hasDebugger()) || (DebuggerShell.bLS()) || (com.tencent.mm.protocal.d.RAG) || (com.tencent.mm.protocal.d.RAH)) {}
    for (boolean bool = true;; bool = false)
    {
      nwr = bool;
      AppMethodBeat.o(43955);
      return;
    }
  }
  
  public t(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    super(paramAppBrandRuntimeContainerWC);
    AppMethodBeat.i(174681);
    this.nws = new com.tencent.mm.plugin.appbrand.jsapi.x.a();
    this.nww = 0;
    this.nwy = new LinkedList();
    this.nwz = null;
    this.nwI = new com.tencent.mm.plugin.appbrand.widget.c.e(this);
    Assert.assertTrue("AppBrandRuntimeWC's initial context should be AppBrandRuntimePersistentContextWrapper", this.mContext instanceof com.tencent.mm.plugin.appbrand.ui.l);
    this.nwu = new r();
    this.nwH = new com.tencent.mm.plugin.appbrand.report.q();
    this.nug = nwr;
    this.nwN = new com.tencent.mm.plugin.appbrand.task.m()
    {
      public final void close()
      {
        AppMethodBeat.i(244631);
        if (t.this.mResumed) {
          t.this.close();
        }
        AppMethodBeat.o(244631);
      }
      
      public final void onNetworkChange()
      {
        AppMethodBeat.i(244633);
        com.tencent.mm.plugin.appbrand.networking.d locald = (com.tencent.mm.plugin.appbrand.networking.d)t.this.ae(com.tencent.mm.plugin.appbrand.networking.d.class);
        if ((locald instanceof com.tencent.mm.plugin.appbrand.networking.g)) {
          ((com.tencent.mm.plugin.appbrand.networking.g)locald).ccw();
        }
        AppMethodBeat.o(244633);
      }
    };
    this.nwO = new LinkedBlockingQueue();
    a(paramAppBrandRuntimeContainerWC);
    AppMethodBeat.o(174681);
  }
  
  public t(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(280812);
    this.nws = new com.tencent.mm.plugin.appbrand.jsapi.x.a();
    this.nww = 0;
    this.nwy = new LinkedList();
    this.nwz = null;
    this.nwI = new com.tencent.mm.plugin.appbrand.widget.c.e(this);
    Assert.assertTrue("AppBrandRuntimeWC's initial context should be AppBrandRuntimePersistentContextWrapper", this.mContext instanceof com.tencent.mm.plugin.appbrand.ui.l);
    this.nwu = new r();
    this.nwH = new com.tencent.mm.plugin.appbrand.report.q();
    this.nug = nwr;
    this.nwN = new com.tencent.mm.plugin.appbrand.task.m()
    {
      public final void close()
      {
        AppMethodBeat.i(244631);
        if (t.this.mResumed) {
          t.this.close();
        }
        AppMethodBeat.o(244631);
      }
      
      public final void onNetworkChange()
      {
        AppMethodBeat.i(244633);
        com.tencent.mm.plugin.appbrand.networking.d locald = (com.tencent.mm.plugin.appbrand.networking.d)t.this.ae(com.tencent.mm.plugin.appbrand.networking.d.class);
        if ((locald instanceof com.tencent.mm.plugin.appbrand.networking.g)) {
          ((com.tencent.mm.plugin.appbrand.networking.g)locald).ccw();
        }
        AppMethodBeat.o(244633);
      }
    };
    this.nwO = new LinkedBlockingQueue();
    a(null);
    AppMethodBeat.o(280812);
  }
  
  private void bDB()
  {
    AppMethodBeat.i(280850);
    if ((((AppBrandInitConfigWC)super.Sk()).nYu) && (AndroidContextUtil.castActivityOrNull(this.mContext) != null))
    {
      this.nwG = new com.tencent.mm.plugin.appbrand.widget.c.a(this, AndroidContextUtil.castActivityOrNull(this.mContext), super.getWindowAndroid());
      if ((com.tencent.mm.plugin.appbrand.service.c)super.QW() != null) {
        ((com.tencent.mm.plugin.appbrand.service.c)super.QW()).b(getWindowAndroid());
      }
      com.tencent.mm.plugin.appbrand.page.ah localah = bDv();
      if (localah != null) {
        localah.b(getWindowAndroid());
      }
    }
    AppMethodBeat.o(280850);
  }
  
  public static int bDH()
  {
    AppMethodBeat.i(280863);
    int i = com.tencent.mm.plugin.appbrand.ad.b.bEG();
    AppMethodBeat.o(280863);
    return i;
  }
  
  public static int bDI()
  {
    AppMethodBeat.i(280865);
    int i = com.tencent.mm.plugin.appbrand.ad.b.bEG();
    AppMethodBeat.o(280865);
    return i;
  }
  
  private void bDi()
  {
    AppMethodBeat.i(280818);
    boolean bool = Util.nullAs((Boolean)com.tencent.luggage.sdk.h.d.a("AppBrandRuntimeProfile|isHWFolder", new kotlin.g.a.a() {}), false);
    if ((getWindowAndroid().Sd()) || (bool))
    {
      this.nwG = new com.tencent.mm.plugin.appbrand.ui.b(this, (Context)Objects.requireNonNull(AndroidContextUtil.castActivityOrNull(this.mContext)), getWindowAndroid().getOrientationHandler(), super.getWindowAndroid());
      AppMethodBeat.o(280818);
      return;
    }
    this.nwG = new com.tencent.luggage.sdk.e.e();
    AppMethodBeat.o(280818);
  }
  
  private void bDn()
  {
    AppMethodBeat.i(43896);
    if (!nwr)
    {
      AppMethodBeat.o(43896);
      return;
    }
    try
    {
      Object localObject = (AccessibilityManager)androidx.core.content.a.a(this.mContext, AccessibilityManager.class);
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
      localObject = this.mAppId + ":" + ((AppBrandInitConfigWC)super.Sk()).fzM;
      this.ntC.setContentDescription((CharSequence)localObject);
      AppMethodBeat.o(43896);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(43896);
    }
  }
  
  private int bDq()
  {
    AppMethodBeat.i(280832);
    int i = -1;
    ICommLibReader localICommLibReader = hf(false);
    if (localICommLibReader != null) {
      i = localICommLibReader.bGi();
    }
    AppMethodBeat.o(280832);
    return i;
  }
  
  private void bDr()
  {
    AppMethodBeat.i(280833);
    new AppBrandUpdateTask(this, bDq()).bsM();
    AppMethodBeat.o(280833);
  }
  
  private void bDs()
  {
    AppMethodBeat.i(280834);
    if ((bDl()) || (bd.s(this)))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "initFloatBallHelper appId[%s], skip fakeNative", new Object[] { this.mAppId });
      AppMethodBeat.o(280834);
      return;
    }
    if (this.nwC != null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "initFloatBallHelper, destroy");
      this.nwC.x(this);
    }
    this.nwC = new com.tencent.mm.plugin.appbrand.floatball.c();
    this.nwC.w(this);
    AppMethodBeat.o(280834);
  }
  
  private void bDt()
  {
    AppMethodBeat.i(280836);
    if ((bDl()) || (bd.s(this)))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "initMultiTaskHelper appId[%s], skip fakeNative", new Object[] { this.mAppId });
      AppMethodBeat.o(280836);
      return;
    }
    if (this.nwD != null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "initMultiTaskHelper, destroy");
      com.tencent.mm.plugin.appbrand.q.c.x(this);
    }
    this.nwD = new com.tencent.mm.plugin.appbrand.q.c();
    this.nwD.w(this);
    AppMethodBeat.o(280836);
  }
  
  private ICommLibReader hf(boolean paramBoolean)
  {
    AppMethodBeat.i(43890);
    Object localObject = (ICommLibReader)super.ae(ICommLibReader.class);
    if ((localObject == null) && (paramBoolean))
    {
      localObject = new ICommLibReader.a();
      AppMethodBeat.o(43890);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(43890);
    return localObject;
  }
  
  private void yK(int paramInt)
  {
    AppMethodBeat.i(43929);
    r.a(paramInt, (AppBrandInitConfigWC)super.Sk());
    AppMethodBeat.o(43929);
  }
  
  protected final boolean N(Runnable paramRunnable)
  {
    AppMethodBeat.i(280843);
    if ((super.bCz() instanceof com.tencent.mm.plugin.appbrand.ui.z))
    {
      h(paramRunnable, 3000L);
      AppMethodBeat.o(280843);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vGF, false))
    {
      boolean bool = getAppConfig().nWe;
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "manualHideSplash:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(280843);
      return bool;
    }
    AppMethodBeat.o(280843);
    return false;
  }
  
  public void NR()
  {
    AppMethodBeat.i(43909);
    super.NR();
    s.abW(this.mAppId).lastResumeTime = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| onReady appId:%s", new Object[] { this.mAppId });
    if (this.nww != 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.nww);
      this.nww = 0;
    }
    long l1 = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.Sk()).startTime;
    com.tencent.mm.plugin.appbrand.report.j.a(l1, this.nwv, Qv());
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onReady reportStartupTime: appId:%s, nickname:%s, cost:%dms, download:%b, isGame:%b", new Object[] { this.mAppId, ((AppBrandInitConfigWC)super.Sk()).fzM, Long.valueOf(l1), Boolean.valueOf(this.nwv), Boolean.valueOf(Qv()) });
    l1 = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.Sk()).startTime;
    this.nwu.I(5, l1);
    Object localObject1 = this.nwu;
    boolean bool1 = this.nwv;
    boolean bool2 = ((AppBrandInitConfigWC)super.Sk()).cxd;
    boolean bool3 = ((AppStartupPerformanceReportBundle)au(AppStartupPerformanceReportBundle.class)).pTC;
    Object localObject2 = this.mAppId;
    ((r)localObject1).aan = 0;
    ((r)localObject1).mType = 0;
    if (bDx() != null)
    {
      ((r)localObject1).aan = bDx().nYR.pkgVersion;
      ((r)localObject1).mType = (bDx().nYR.nHY + 1);
    }
    int i;
    label295:
    Object localObject3;
    label341:
    Object localObject4;
    if (bool1)
    {
      i = 1;
      ((r)localObject1).nvR = i;
      if (!Qv()) {
        break label1163;
      }
      i = 1;
      ((r)localObject1).nvW = i;
      ((r)localObject1).mScene = Sk().cxf.scene;
      ((r)localObject1).nvU = bool2;
      ((r)localObject1).nvV = bool3;
      localObject3 = new StringBuilder();
      i = 0;
      if (i >= ((r)localObject1).nvQ.length) {
        break label1197;
      }
      if (localObject1.nvQ[i] >= 0L) {
        break label1168;
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: abort, illegal value: %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(localObject1.nvQ[i]) });
      AppBrandPerformanceManager.a(this, 202, l1);
      com.tencent.mm.plugin.appbrand.performance.c.HC(((AppBrandInitConfigWC)super.Sk()).startTime);
      com.tencent.mm.plugin.appbrand.report.quality.b.a(this.mAppId, this);
      if ((DebuggerShell.bLS()) && (this.nwz == null))
      {
        this.nwz = new MTimerHandler(com.tencent.mm.plugin.appbrand.performance.b.a.qyO.cfU().getLooper(), new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(281294);
            com.tencent.mm.plugin.appbrand.performance.b.n(t.this);
            AppMethodBeat.o(281294);
            return true;
          }
        }, true);
        this.nwz.startTimer(1000L);
      }
      if (Qv())
      {
        localObject1 = com.tencent.mm.plugin.appbrand.game.preload.d.bOS();
        l1 = Util.nowMilliSecond();
        long l2 = ((AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).nAH.Sk()).startTime;
        com.tencent.mm.plugin.appbrand.game.preload.e.bOU().ew(2001, (int)(l1 - l2));
      }
      com.tencent.mm.plugin.appbrand.ui.recommend.e.Q(this);
      if (((AppBrandInitConfigWC)super.Sk()).cxe != com.tencent.luggage.sdk.launching.b.cBf) {
        new AppBrandRuntimePreloadNextInvoke(LuggageServiceType.cj(Qv())).bsM();
      }
      if (Sh() != null)
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.appstorage.p)Sh().ay(com.tencent.mm.plugin.appbrand.appstorage.p.class);
        com.tencent.mm.vfs.u.H(((com.tencent.mm.plugin.appbrand.appstorage.p)localObject1).nMO + "/dir.lock", new byte[1]);
      }
      localObject4 = com.tencent.mm.plugin.appbrand.report.quality.b.amO(this.mAppId);
      if ((localObject4 != null) && (!Qv()))
      {
        com.tencent.mm.plugin.appbrand.report.quality.b.cik();
        kotlin.g.b.p.k(this, "runtime");
        qa localqa = new qa();
        localObject3 = com.tencent.mm.plugin.appbrand.report.quality.b.amO(this.mAppId);
        if (localObject3 == null) {
          break label1550;
        }
        localqa.gfn = localqa.z("InstanceId", ((QualitySessionRuntime)localObject3).cBH, true);
        localqa.gmF = localqa.z("AppId", ((QualitySessionRuntime)localObject3).appId, true);
        localqa.gYL = ((QualitySessionRuntime)localObject3).qNx;
        localqa.hiZ = qa.a.oY(((QualitySessionRuntime)localObject3).qLQ);
        localqa.gYN = ((QualitySessionRuntime)localObject3).apptype;
        localqa.gnP = ((QualitySessionRuntime)localObject3).scene;
        localObject1 = (com.tencent.mm.plugin.appbrand.page.y)super.bBX();
        kotlin.g.b.p.j(localObject1, "runtime.pageContainer");
        localObject1 = ((com.tencent.mm.plugin.appbrand.page.y)localObject1).getCurrentPage();
        if (localObject1 == null) {
          break label1544;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.page.u)localObject1).getCurrentPageView();
        label788:
        localObject2 = localObject1;
        if (!(localObject1 instanceof com.tencent.mm.plugin.appbrand.page.ah)) {
          localObject2 = null;
        }
        localqa.grp = com.tencent.mm.plugin.appbrand.report.quality.d.x((com.tencent.mm.plugin.appbrand.page.ah)localObject2);
        localObject1 = localObject3;
        label820:
        com.tencent.mm.plugin.appbrand.report.quality.d.a((QualitySessionRuntime)localObject1, "Null session with " + this.mAppId);
        localqa.hcB = ((QualitySessionRuntime)localObject4).cir();
        localqa.bpa();
      }
      if (localObject4 != null)
      {
        com.tencent.mm.plugin.appbrand.report.quality.b.cik();
        kotlin.g.b.p.k(this, "runtime");
        localObject3 = new oy();
        localObject2 = com.tencent.mm.plugin.appbrand.report.quality.b.amO(this.mAppId);
        if (localObject2 == null) {
          break label1593;
        }
        ((oy)localObject3).gfn = ((oy)localObject3).z("InstanceId", ((QualitySessionRuntime)localObject2).cBH, true);
        ((oy)localObject3).gmF = ((oy)localObject3).z("AppId", ((QualitySessionRuntime)localObject2).appId, true);
        ((oy)localObject3).gYL = ((QualitySessionRuntime)localObject2).qNx;
        ((oy)localObject3).hdF = oy.a.ox(((QualitySessionRuntime)localObject2).qLQ);
        ((oy)localObject3).gYN = ((QualitySessionRuntime)localObject2).apptype;
        ((oy)localObject3).gnP = ((QualitySessionRuntime)localObject2).scene;
        localObject1 = (com.tencent.mm.plugin.appbrand.service.c)super.QW();
        if (localObject1 == null) {
          break label1556;
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.service.c)localObject1).getJsRuntime();
        label1005:
        localObject1 = com.tencent.mm.plugin.appbrand.report.e.f((com.tencent.mm.plugin.appbrand.m.i)localObject1);
        switch (com.tencent.mm.plugin.appbrand.report.quality.e.$EnumSwitchMapping$0[localObject1.ordinal()])
        {
        default: 
          i = -1;
          label1062:
          ((oy)localObject3).grp = i;
        }
      }
    }
    label1163:
    label1168:
    label1197:
    label1593:
    for (localObject1 = localObject2;; localObject1 = null)
    {
      com.tencent.mm.plugin.appbrand.report.quality.d.a((QualitySessionRuntime)localObject1, "Null session with " + this.mAppId);
      ((oy)localObject3).hcB = ((QualitySessionRuntime)localObject4).cir();
      ((oy)localObject3).bpa();
      com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup);
      com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup_Game);
      com.tencent.mm.plugin.appbrand.keylogger.c.e(KSProcessWeAppLaunch.class, this.mAppId);
      com.tencent.mm.plugin.appbrand.report.quality.k.cI(this.mAppId, 1);
      AppMethodBeat.o(43909);
      return;
      i = 0;
      break;
      i = 0;
      break label295;
      ((StringBuilder)localObject3).append(localObject1.nvQ[i]);
      ((StringBuilder)localObject3).append(",");
      i += 1;
      break label341;
      localObject4 = (AppBrandInitConfigWC)super.Sk();
      if (localObject4 != null)
      {
        i = ((AppBrandInitConfigWC)localObject4).cwR;
        label1217:
        i += 1000;
        bool2 = com.tencent.mm.plugin.appbrand.task.h.j(com.tencent.mm.plugin.appbrand.task.n.jA(Qv()));
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: %s, %s, Download: %s, Preload: %s, appServiceType: %s", new Object[] { localObject2, ((StringBuilder)localObject3).toString(), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(i) });
        ((r)localObject1).h((String)localObject2, 1, 0, i);
        ((r)localObject1).h((String)localObject2, 2, 1, i);
        ((r)localObject1).h((String)localObject2, 3, 2, i);
        ((r)localObject1).h((String)localObject2, 4, 3, i);
        ((r)localObject1).h((String)localObject2, 6, 4, i);
        ((r)localObject1).h((String)localObject2, 7, 5, i);
        ((r)localObject1).h((String)localObject2, 23, 6, i);
        ((r)localObject1).h((String)localObject2, 24, 7, i);
        ((r)localObject1).h((String)localObject2, 25, 8, i);
        ((r)localObject1).h((String)localObject2, 26, 9, i);
        ((r)localObject1).h((String)localObject2, 27, 10, i);
        ((r)localObject1).h((String)localObject2, 28, 11, i);
        ((r)localObject1).h((String)localObject2, 29, 12, i);
        ((r)localObject1).h((String)localObject2, 30, 13, i);
        ((r)localObject1).h((String)localObject2, 31, 14, i);
        if (((r)localObject1).nvW != 1) {
          break label1535;
        }
      }
      label1535:
      for (i = ((r)localObject1).nvT;; i = ((r)localObject1).nvS)
      {
        com.tencent.mm.appbrand.v8.x.a(4, localObject1.nvQ[5], i, (String)localObject2, ((r)localObject1).nvR, ((r)localObject1).nvW, hf(false).bGi());
        break;
        i = com.tencent.mm.plugin.appbrand.report.k.amD((String)localObject2);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeStartupReporter", "getServiceTypeForReport null = initConfig! appServiceType:%s", new Object[] { Integer.valueOf(i) });
        break label1217;
      }
      localObject1 = null;
      break label788;
      localObject1 = null;
      break label820;
      localObject1 = null;
      break label1005;
      i = 1;
      break label1062;
      i = 2;
      break label1062;
      i = 3;
      break label1062;
      i = 4;
      break label1062;
      i = 5;
      break label1062;
      i = 6;
      break label1062;
    }
  }
  
  public final boolean Qv()
  {
    AppMethodBeat.i(293301);
    boolean bool = ((AppBrandInitConfigWC)super.Sk()).Qv();
    AppMethodBeat.o(293301);
    return bool;
  }
  
  public final boolean Rp()
  {
    AppMethodBeat.i(293307);
    boolean bool = super.Rp();
    AppMethodBeat.o(293307);
    return bool;
  }
  
  public final void S(Runnable paramRunnable)
  {
    AppMethodBeat.i(280826);
    if (paramRunnable != null) {
      this.ntR.a(new t.22(this, paramRunnable));
    }
    finish();
    AppMethodBeat.o(280826);
  }
  
  public final String SA()
  {
    AppMethodBeat.i(43885);
    String str = "AppBrandRuntimeWC@" + hashCode();
    AppMethodBeat.o(43885);
    return str;
  }
  
  public final void Sl()
  {
    AppMethodBeat.i(43934);
    super.Sl();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] onInitBeforeComponentsInstalled, appId[%s] mPendingPermissionUpdateTasks.size=%d", new Object[] { this.mAppId, Integer.valueOf(this.nwO.size()) });
    while (!this.nwO.isEmpty()) {
      ((Runnable)this.nwO.remove()).run();
    }
    com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepPrepareRuntime);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup_Game);
    AppMethodBeat.o(43934);
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.u Sm()
  {
    AppMethodBeat.i(43930);
    com.tencent.mm.plugin.appbrand.performance.b.F(this);
    Object localObject = ((AppStartupPerformanceReportBundle)au(AppStartupPerformanceReportBundle.class)).pTr;
    if (!Util.isNullOrNil((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      for (long l = 0L; ((Iterator)localObject).hasNext(); l = Math.max(l, ((kv_14609)((Iterator)localObject).next()).qLS)) {}
      com.tencent.mm.plugin.appbrand.performance.b.a(this, l);
    }
    if (DebuggerShell.bLS())
    {
      AppMethodBeat.o(43930);
      return null;
    }
    localObject = super.Sm();
    AppMethodBeat.o(43930);
    return localObject;
  }
  
  public com.tencent.mm.plugin.appbrand.p.a Sn()
  {
    AppMethodBeat.i(43922);
    com.tencent.mm.plugin.appbrand.p.a locala = super.Sn();
    AppMethodBeat.o(43922);
    return locala;
  }
  
  public final void T(final Runnable paramRunnable)
  {
    AppMethodBeat.i(43923);
    P(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174673);
        if (t.this.ntU.get())
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "startPrepareOrientation, finished appId[%s]", new Object[] { t.this.mAppId });
          AppMethodBeat.o(174673);
          return;
        }
        t.a(t.this, new e.a()
        {
          public final void a(com.tencent.mm.plugin.appbrand.platform.window.e.b paramAnonymous2b, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(277647);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "startPrepareOrientation, onOrientationChanged appId[%s], orientation[%s] success[%b]", new Object[] { t.this.mAppId, paramAnonymous2b, Boolean.valueOf(paramAnonymous2Boolean) });
            if (t.13.this.nxa != null) {
              t.13.this.nxa.run();
            }
            AppMethodBeat.o(277647);
          }
        }, t.o(t.this));
        AppMethodBeat.o(174673);
      }
    });
    AppMethodBeat.o(43923);
  }
  
  public final void U(Runnable paramRunnable)
  {
    AppMethodBeat.i(43935);
    paramRunnable = new t.a(this, paramRunnable);
    this.nwO.add(paramRunnable);
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
      this.ntY = null;
      this.mContext = com.tencent.mm.plugin.appbrand.ui.l.en(MMApplicationContext.getContext());
      if ((com.tencent.mm.plugin.appbrand.service.c)super.QW() != null) {
        ((com.tencent.mm.plugin.appbrand.service.c)super.QW()).b(null);
      }
      if ((com.tencent.mm.plugin.appbrand.page.y)super.bBX() != null) {
        com.tencent.mm.plugin.appbrand.page.z.c((com.tencent.mm.plugin.appbrand.page.y)super.bBX());
      }
      if (this.nuc != null) {
        com.tencent.mm.plugin.appbrand.pip.r.a(this.nuc, null);
      }
      if (this.ntG != null) {
        this.ntG.ej(MMApplicationContext.getContext());
      }
      this.nwG = new com.tencent.luggage.sdk.e.e();
      AppMethodBeat.o(43891);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.ui.l)this.mContext).setBaseContext(AndroidContextUtil.castActivityOrNull(paramak.mContext));
    if (this.ntG != null) {
      this.ntG.ej((Context)Objects.requireNonNull(AndroidContextUtil.castActivityOrNull(paramak.mContext)));
    }
    bDi();
    if ((com.tencent.mm.plugin.appbrand.service.c)super.QW() != null) {
      ((com.tencent.mm.plugin.appbrand.service.c)super.QW()).b(getWindowAndroid());
    }
    com.tencent.mm.plugin.appbrand.page.ah localah = bDv();
    if (localah != null)
    {
      localah.b(getWindowAndroid());
      ((com.tencent.mm.plugin.appbrand.page.y)super.bBX()).j(localah);
    }
    if (this.nuc != null) {
      com.tencent.mm.plugin.appbrand.pip.r.a(this.nuc, getWindowAndroid());
    }
    this.nwB = new Configuration(AppBrandUI.G(paramak.nvr.getActivity()));
    if ((this.nwC == null) && (this.mInitialized))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "setRuntimeContainer != NULL, appId:%s, retry initFloatBallHelper", new Object[] { this.mAppId });
      bDs();
    }
    if ((this.nwD == null) && (this.mInitialized))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "setRuntimeContainer != NULL, appId:%s, retry initMultiTaskHelper", new Object[] { this.mAppId });
      bDt();
    }
    AppMethodBeat.o(43891);
  }
  
  public final void a(ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(43888);
    if (hf(false) != null)
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
    Object localObject = (AppBrandInitConfigWC)super.Sk();
    AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    if ((localObject != paramAppBrandInitConfig) && (localAppBrandInitConfigWC.cxf.scene == 1038)) {
      localAppBrandInitConfigWC.nYg = null;
    }
    if (((AppBrandInitConfigWC)localObject).nYu) {
      localAppBrandInitConfigWC.nYu = true;
    }
    super.a(paramAppBrandInitConfig);
    int i;
    if ((((AppBrandInitConfigWC)super.Sk()).launchMode != ((AppBrandInitConfigWC)localObject).launchMode) && ((((AppBrandInitConfigWC)super.Sk()).launchMode == 1) || (((AppBrandInitConfigWC)localObject).launchMode == 1)))
    {
      i = 1;
      if (i != 0) {
        bCs();
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "updateConfig %s, willRestart[%b], willRelaunch[%b], destroyed[%b], scene[%d], lastLaunchMode[%d], currentLaunchMode[%d], instanceId[%s], sessionId[%s]", new Object[] { this, Boolean.valueOf(bCt()), Boolean.valueOf(this.ntW), Boolean.valueOf(this.ntU.get()), Integer.valueOf(Sk().cxf.scene), Integer.valueOf(((AppBrandInitConfigWC)localObject).launchMode), Integer.valueOf(((AppBrandInitConfigWC)super.Sk()).launchMode), ((AppBrandInitConfigWC)paramAppBrandInitConfig).cwQ, ((AppBrandInitConfigWC)paramAppBrandInitConfig).cwP });
      OpenBusinessViewUtil.A(this);
      if ((bCt()) || (this.ntU.get())) {
        break label783;
      }
      if (!org.apache.commons.b.g.oC(localAppBrandInitConfigWC.cwQ, ((AppBrandInitConfigLU)localObject).cwQ))
      {
        if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED)) {
          break label410;
        }
        Assert.fail(String.format("updateConfig %s instanceId should not have been changed[%s]->[%s]", new Object[] { this, ((AppBrandInitConfigLU)localObject).cwQ, localAppBrandInitConfigWC.cwQ }));
      }
    }
    for (;;)
    {
      ((QualitySessionRuntime)Objects.requireNonNull(com.tencent.mm.plugin.appbrand.report.quality.b.amO(this.mAppId))).qNz = false;
      com.tencent.mm.plugin.appbrand.report.quality.g.a(this, true, com.tencent.mm.plugin.appbrand.utils.d.anh(((AppBrandInitConfigWC)super.Sk()).nYh));
      com.tencent.mm.plugin.ac.a.b(this.mAppId, ((AppBrandInitConfigWC)super.Sk()).nYe);
      paramAppBrandInitConfig = this.nwy.iterator();
      while (paramAppBrandInitConfig.hasNext()) {
        ((aj)paramAppBrandInitConfig.next()).c((AppBrandInitConfigWC)super.Sk());
      }
      i = 0;
      break;
      label410:
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntimeWC", "updateConfig %s, newConfig.instanceId changed, reset [%s]->[%s]", new Object[] { this, localAppBrandInitConfigWC.cwQ, ((AppBrandInitConfigLU)localObject).cwQ });
      localAppBrandInitConfigWC.dW(((AppBrandInitConfigLU)localObject).cwQ);
    }
    if ((com.tencent.mm.plugin.appbrand.page.y)super.bBX() != null)
    {
      paramAppBrandInitConfig = (com.tencent.mm.plugin.appbrand.page.y)super.bBX();
      paramAppBrandInitConfig.getReporter().resetSession();
      paramAppBrandInitConfig.qrN = false;
      paramAppBrandInitConfig.qrO = false;
      paramAppBrandInitConfig.qrP = false;
      paramAppBrandInitConfig.qrU = null;
    }
    paramAppBrandInitConfig = (AppBrandInitConfigWC)super.Sk();
    localObject = bDx();
    AppBrandStatObject localAppBrandStatObject = Sk().cxf;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskUsageRecorder", "updateUsage, appId %s, type %d", new Object[] { paramAppBrandInitConfig.appId, Integer.valueOf(paramAppBrandInitConfig.cBI) });
    String str = paramAppBrandInitConfig.cwP;
    new AppBrandTaskUsageRecorder.UpdateTask(new AppBrandTaskUsageRecorder.LaunchCheckParams(paramAppBrandInitConfig, localAppBrandStatObject, ((AppBrandSysConfigWC)localObject).nYR.pkgVersion, hf(false).bGi(), str, paramAppBrandInitConfig.nYk)).bsM();
    bDn();
    bDB();
    paramAppBrandInitConfig = (AppBrandInitConfigWC)super.Sk();
    if (paramAppBrandInitConfig != null) {
      this.nwG.b(paramAppBrandInitConfig);
    }
    paramAppBrandInitConfig = this.nwH;
    kotlin.g.b.p.k(localAppBrandInitConfigWC, "newConfig");
    if (localAppBrandInitConfigWC.nBE.isEnable())
    {
      com.tencent.mm.plugin.appbrand.report.q.rE(1);
      if (localAppBrandInitConfigWC.cxe != com.tencent.luggage.sdk.launching.b.cBf)
      {
        com.tencent.mm.plugin.appbrand.report.q.rE(6);
        if (paramAppBrandInitConfig.qJU) {
          com.tencent.mm.plugin.appbrand.report.q.rE(8);
        }
        if (!paramAppBrandInitConfig.qJW)
        {
          com.tencent.mm.plugin.appbrand.report.q.rE(7);
          if (paramAppBrandInitConfig.qJU) {
            com.tencent.mm.plugin.appbrand.report.q.rE(9);
          }
          paramAppBrandInitConfig.qJW = true;
        }
      }
    }
    if (i != 0) {
      com.tencent.mm.plugin.appbrand.report.q.rE(4);
    }
    if ((paramAppBrandInitConfig.qJV != localAppBrandInitConfigWC.nBE.isEnable()) && (localAppBrandInitConfigWC.cxe != com.tencent.luggage.sdk.launching.b.cBf))
    {
      if (!localAppBrandInitConfigWC.nBE.isEnable()) {
        break label790;
      }
      com.tencent.mm.plugin.appbrand.report.q.rE(3);
    }
    for (;;)
    {
      if (localAppBrandInitConfigWC.cxe != com.tencent.luggage.sdk.launching.b.cBf) {
        paramAppBrandInitConfig.qJV = localAppBrandInitConfigWC.nBE.isEnable();
      }
      label783:
      AppMethodBeat.o(43924);
      return;
      label790:
      com.tencent.mm.plugin.appbrand.report.q.rE(2);
    }
  }
  
  public final void a(AppBrandInitConfig paramAppBrandInitConfig, String paramString)
  {
    AppMethodBeat.i(280830);
    if (paramAppBrandInitConfig == null)
    {
      ((AppBrandInitConfigWC)super.Sk()).resetSession();
      ((AppBrandInitConfigWC)super.Sk()).startTime = Util.nowMilliSecond();
      ((AppBrandInitConfigWC)super.Sk()).nYt = new AppBrandRuntimeReloadReportBundle(((AppBrandInitConfigWC)super.Sk()).nYk.cBH, paramString);
      ((AppBrandInitConfigWC)super.Sk()).nYk = new QualitySession(com.tencent.mm.plugin.appbrand.utils.d.Do(((AppBrandInitConfigWC)super.Sk()).uin), (AppBrandInitConfigWC)super.Sk(), Sk().cxf);
      ((AppBrandInitConfigWC)super.Sk()).dW(((AppBrandInitConfigWC)super.Sk()).nYk.cBH);
    }
    super.af(ICommLibReader.class);
    super.a(paramAppBrandInitConfig, paramString);
    AppMethodBeat.o(280830);
  }
  
  public final boolean b(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(43925);
    paramAppBrandInitConfig = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    AppBrandStatObject localAppBrandStatObject = paramAppBrandInitConfig.cxf;
    boolean bool;
    if ((this.nwx) || (localAppBrandStatObject.scene == 1099))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] mShouldRelaunchCausedByFunctionalPageOpen[%b] newScene[%d]", new Object[] { this.mAppId, Boolean.valueOf(this.nwx), Integer.valueOf(localAppBrandStatObject.scene) });
      if (localAppBrandStatObject.scene == 1099) {}
      for (bool = true;; bool = false)
      {
        this.nwx = bool;
        AppMethodBeat.o(43925);
        return true;
      }
    }
    if ((TextUtils.isEmpty(paramAppBrandInitConfig.nBq)) && (ai.q(this)))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] enterPath[%s], old is gameFunctionalPage", new Object[] { this.mAppId, paramAppBrandInitConfig.nBq });
      AppMethodBeat.o(43925);
      return true;
    }
    if (1038 == localAppBrandStatObject.scene)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. appId[%s], reason=1038 back from other MiniProgram", new Object[] { this.mAppId });
      AppMethodBeat.o(43925);
      return false;
    }
    Iterator localIterator = this.nwy.iterator();
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
    if (!TextUtils.isEmpty(paramAppBrandInitConfig.nBq))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] enterPath[%s]", new Object[] { this.mAppId, paramAppBrandInitConfig.nBq });
      AppMethodBeat.o(43925);
      return true;
    }
    if (((AppBrandInitConfigWC)super.Sk()).nBE.isEnable() != paramAppBrandInitConfig.nBE.isEnable())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] halfScreenConfig enable change to:%b", new Object[] { this.mAppId, Boolean.valueOf(paramAppBrandInitConfig.nBE.isEnable()) });
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
    if ((1030 == localAppBrandStatObject.scene) && (TextUtils.isEmpty(paramAppBrandInitConfig.nBq)))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. special for monkey test appId[%s]", new Object[] { this.mAppId });
      AppMethodBeat.o(43925);
      return false;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] fallback logic", new Object[] { this.mAppId });
    AppMethodBeat.o(43925);
    return true;
  }
  
  public final ICommLibReader bBP()
  {
    AppMethodBeat.i(293300);
    ICommLibReader localICommLibReader = hf(false);
    AppMethodBeat.o(293300);
    return localICommLibReader;
  }
  
  protected final void bBU()
  {
    AppMethodBeat.i(280862);
    bDB();
    Object localObject1 = (AppBrandInitConfigWC)super.Sk();
    if (localObject1 != null) {
      this.nwG.a((AppBrandInitConfigLU)localObject1);
    }
    this.nwF = new b();
    this.nwE = new com.tencent.mm.plugin.appbrand.ad.h(this, this.nwF);
    Object localObject2 = this.nwE;
    com.tencent.mm.f.b.a.r localr;
    int i;
    label330:
    boolean bool;
    if (((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAH.bCA())
    {
      ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAI = com.tencent.mm.plugin.appbrand.task.h.i(com.tencent.mm.plugin.appbrand.task.n.jA(((AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAH.Sk()).Qv()));
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, may show ad, preloadedService:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAH.mAppId, ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAI });
      localr = new com.tencent.mm.f.b.a.r();
      localr.gfo = Util.nowMilliSecond();
      localr.gfm = localr.z("Appid", ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAH.mAppId, true);
      localObject1 = com.tencent.mm.plugin.appbrand.task.h.l(com.tencent.mm.plugin.appbrand.task.n.jA(((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAH.Qv()));
      switch (com.tencent.mm.plugin.appbrand.ad.h.6.nAr[localObject1.ordinal()])
      {
      default: 
        i = -1;
        localr.gfr = i;
        s.abW(((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAH.mAppId).nvZ = localr;
        if (((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAI != null)
        {
          if (((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAH.Qv())
          {
            localObject1 = (AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAH.Sk();
            if (localObject1 == null) {
              break;
            }
            localObject1 = com.tencent.mm.plugin.appbrand.platform.window.e.b.amy(((AppBrandInitConfigWC)localObject1).cCi);
            if ((localObject1 != com.tencent.mm.plugin.appbrand.platform.window.e.b.qGx) && (localObject1 != com.tencent.mm.plugin.appbrand.platform.window.e.b.qGz) && (localObject1 != com.tencent.mm.plugin.appbrand.platform.window.e.b.qGA)) {
              break;
            }
            i = 1;
            if (i != 0)
            {
              com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, landscape game, add check show ad prepare process", new Object[] { ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAH.mAppId });
              ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAM = new com.tencent.mm.plugin.appbrand.ad.i();
              ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAH.a(((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAM);
            }
          }
          localObject1 = ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAI.bEb();
          if (((ab)localObject1).nxU.nsn == null)
          {
            localObject1 = null;
            label407:
            if (localObject1 != null) {
              ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nwF.a((com.tencent.mm.plugin.appbrand.ah.b)localObject1);
            }
            StringBuilder localStringBuilder = new StringBuilder("sendShouldShowAdWhenLaunchIfNeed, obtainWorkerAsync when preloaded launch adWorker isnull=");
            if (localObject1 != null) {
              break label617;
            }
            bool = true;
            label441:
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", bool);
            if (localObject1 != null) {
              break label622;
            }
            long l = Util.nowMilliSecond();
            ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nwF.a(new h.1((com.tencent.mm.plugin.appbrand.ad.h)localObject2, localr, l));
            ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).bES();
            label491:
            com.tencent.mm.plugin.appbrand.ad.e.a(((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAH, com.tencent.mm.plugin.appbrand.task.h.l(com.tencent.mm.plugin.appbrand.task.n.jA(((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAH.Qv())), true);
          }
        }
        break;
      }
    }
    for (;;)
    {
      localObject1 = this.nwH;
      localObject2 = (AppBrandInitConfigWC)super.Sk();
      kotlin.g.b.p.k(localObject2, "initConfig");
      if (((AppBrandInitConfigWC)localObject2).nBE.isEnable())
      {
        com.tencent.mm.plugin.appbrand.report.q.rE(0);
        if (((AppBrandInitConfigWC)localObject2).cxe != com.tencent.luggage.sdk.launching.b.cBf) {
          com.tencent.mm.plugin.appbrand.report.q.rE(5);
        }
      }
      ((com.tencent.mm.plugin.appbrand.report.q)localObject1).qJV = ((AppBrandInitConfigWC)localObject2).nBE.isEnable();
      AppMethodBeat.o(280862);
      return;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 0;
      break label330;
      localObject1 = ((ab)localObject1).nxU;
      break label407;
      label617:
      bool = false;
      break label441;
      label622:
      ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).bES();
      ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).a(a.b(((com.tencent.mm.plugin.appbrand.ah.b)localObject1).nsn), ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAI, ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAH);
      com.tencent.mm.plugin.appbrand.ad.h.a(((com.tencent.mm.plugin.appbrand.ah.b)localObject1).rGX, localr, 1, 0L, null);
      break label491;
      com.tencent.mm.plugin.appbrand.ad.h.a(new kotlin.o(Long.valueOf(-1L), Long.valueOf(-1L)), localr, -1, -1L, null);
      com.tencent.mm.plugin.appbrand.ad.e.a(((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAH, com.tencent.mm.plugin.appbrand.task.h.l(com.tencent.mm.plugin.appbrand.task.n.jA(((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAH.Qv())), false);
      ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).bES();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, can not show ad", new Object[] { ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAH.mAppId });
      ((com.tencent.mm.plugin.appbrand.ad.h)localObject2).nAJ = 0;
    }
  }
  
  public final void bCa()
  {
    AppMethodBeat.i(280844);
    com.tencent.mm.plugin.appbrand.config.b localb = getAppConfig();
    Object localObject2 = bl.d(this, "/app-config.json");
    Object localObject1 = localObject2;
    Object localObject3;
    if (Util.isNullOrNil((String)localObject2))
    {
      localObject3 = bDx().nYR.nIb.iterator();
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
          localObject2 = bl.d(this, (String)localObject1 + "app-config.json");
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
      localObject3 = bl.d(this, "/app-config-darkmode.json");
      localObject2 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = "{}";
      }
      localObject1 = com.tencent.mm.plugin.appbrand.config.b.b(this.mAppId, (String)localObject1, (String)localObject2, Boolean.parseBoolean(hf(true).acx("pruneWxConfigByPage")), Qv());
      if (!Qv())
      {
        ((com.tencent.mm.plugin.appbrand.config.b)localObject1).nVY.cCi = ((AppBrandInitConfigWC)super.Sk()).cCi;
        ((com.tencent.mm.plugin.appbrand.config.b)localObject1).nVY.nWm = true;
      }
      for (;;)
      {
        if (bd.s(this)) {
          ((com.tencent.mm.plugin.appbrand.config.b)localObject1).nVY.cCi = "portrait";
        }
        b((com.tencent.mm.plugin.appbrand.config.b)localObject1);
        bDD();
        if (Qv())
        {
          localObject1 = com.tencent.mm.plugin.appbrand.game.preload.d.bOS();
          if (((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).hasInit)
          {
            localObject2 = ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ooU;
            localObject3 = ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).nAH.ntK;
            ((com.tencent.mm.plugin.appbrand.game.preload.c)localObject2).ooP.addAll((Collection)localObject3);
            ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ooS = ((com.tencent.mm.plugin.appbrand.s.a)((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).nAH.au(com.tencent.mm.plugin.appbrand.s.a.class));
            ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ooT = ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).nAH.Sh();
            localObject1 = ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ooR;
            localObject2 = (com.tencent.mm.plugin.appbrand.s.a)((com.tencent.mm.plugin.appbrand.s.m)localObject1).okQ.au(com.tencent.mm.plugin.appbrand.s.a.class);
            ((com.tencent.mm.plugin.appbrand.s.m)localObject1).qiy = ((com.tencent.mm.plugin.appbrand.s.a)localObject2).cxr;
            ((com.tencent.mm.plugin.appbrand.s.m)localObject1).pFt = ((com.tencent.mm.plugin.appbrand.s.a)localObject2).qiv;
            ((com.tencent.mm.plugin.appbrand.s.m)localObject1).qiA = com.tencent.mm.plugin.appbrand.s.j.a((com.tencent.mm.plugin.appbrand.s.a)localObject2);
          }
          Q(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(163900);
              try
              {
                com.tencent.mm.plugin.appbrand.game.preload.d locald = com.tencent.mm.plugin.appbrand.game.preload.d.bOS();
                if (!locald.ooW) {
                  break label385;
                }
                if (!locald.hasInit)
                {
                  com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WAGamePreloadManager", "hasn't init!");
                  AppMethodBeat.o(163900);
                  return;
                }
                if (locald.nAH == null) {
                  break label385;
                }
                if (locald.nAH.getAppConfig() != null) {
                  break label93;
                }
                com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WAGamePreloadManager", "downloadPreloadFiles getAppConfig null!");
                AppMethodBeat.o(163900);
                return;
              }
              catch (NullPointerException localNullPointerException)
              {
                if (!t.this.ntU.get()) {
                  break label391;
                }
              }
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntimeWC", "runtime has finished - downloadPreloadFiles!");
              AppMethodBeat.o(163900);
              return;
              label93:
              JSONArray localJSONArray = localNullPointerException.nAH.getAppConfig().nWc;
              int i;
              if (localJSONArray != null)
              {
                com.tencent.mm.plugin.appbrand.game.preload.e.bOU().ew(3000, localJSONArray.length());
                i = 0;
              }
              for (;;)
              {
                Object localObject2;
                Object localObject3;
                Object localObject4;
                try
                {
                  if (i < localJSONArray.length())
                  {
                    localObject2 = localJSONArray.getJSONObject(i);
                    if (localObject2 == null) {
                      break label398;
                    }
                    localObject3 = ((JSONObject)localObject2).optString("url");
                    localObject4 = ((JSONObject)localObject2).optString("path");
                    if ((Util.isNullOrNil((String)localObject3)) || (Util.isNullOrNil((String)localObject4))) {
                      break label398;
                    }
                    if (localNullPointerException.ooT.acT((String)localObject4) == com.tencent.mm.plugin.appbrand.appstorage.m.nMR)
                    {
                      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WAGamePreloadManager", "predownload path %s has exists!", new Object[] { localObject4 });
                    }
                    else
                    {
                      localNullPointerException.ooV.add(localObject3);
                      localObject3 = new d.2(localNullPointerException, (String)localObject3, (String)localObject4);
                      if (localNullPointerException.ooS.cxr <= 0) {
                        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WAGamePreloadManager", "maxDownloadConcurrent <= 0 ");
                      }
                    }
                  }
                }
                catch (JSONException localJSONException)
                {
                  com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.WAGamePreloadManager", localJSONException, "", new Object[0]);
                }
                Object localObject1 = localNullPointerException.nAH.getAppConfig();
                if (localObject1 == null)
                {
                  com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WAGamePreloadManager", "downloadPreloadFiles config null！");
                  AppMethodBeat.o(163900);
                  return;
                  localObject4 = new HashMap();
                  int j = localNullPointerException.ooS.nWV;
                  localNullPointerException.ooR.a((JSONObject)localObject2, 60000, (Map)localObject4, null, j, (com.tencent.mm.plugin.appbrand.s.b.a)localObject3, com.tencent.mm.plugin.appbrand.game.preload.d.bsL(), "test");
                }
                else
                {
                  localObject2 = localNullPointerException.nAH.mAppId;
                  localObject1 = ((com.tencent.mm.plugin.appbrand.config.b)localObject1).nWd;
                  if (localObject1 != null) {
                    com.tencent.mm.plugin.appbrand.game.preload.e.bOU().ew(4000, ((ArrayList)localObject1).size());
                  }
                  localNullPointerException.bOT();
                  label385:
                  AppMethodBeat.o(163900);
                  return;
                  label391:
                  AppMethodBeat.o(163900);
                  throw localNullPointerException;
                }
                label398:
                i += 1;
              }
            }
          });
        }
        if ((!Util.isNullOrNil(this.mAppId)) && (getAppConfig() != null)) {
          break;
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandBackgroundConfigStorage", "updateBackgroundConfigs, runtime or appId or appConfig is null");
        if ((localb != null) && ((com.tencent.mm.plugin.appbrand.service.c)super.QW() != null)) {
          new com.tencent.mm.plugin.appbrand.jsapi.c.a().agU(((com.tencent.mm.plugin.appbrand.service.c)super.QW()).Ro().toString()).j(QW()).bPO();
        }
        AppMethodBeat.o(280844);
        return;
        if (!((com.tencent.mm.plugin.appbrand.config.b)localObject1).nWa.booleanValue()) {
          ((com.tencent.mm.plugin.appbrand.config.b)localObject1).nVY.cCi = ((AppBrandInitConfigWC)super.Sk()).cwY.obz;
        }
      }
      localObject1 = this.mAppId;
      localObject2 = getAppConfig();
      boolean bool2 = j.a.vB(bDx().nYR.nHY);
      boolean bool3 = ((com.tencent.mm.plugin.appbrand.config.b)localObject2).nWb.contains("location");
      MultiProcessMMKV.getMMKV("appbrand_background_config").encode(String.format("%s_location_background_required", new Object[] { localObject1 }), bool3);
      localObject2 = ((com.tencent.mm.plugin.appbrand.config.b)localObject2).aeJ("scope.userLocation");
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
  
  protected aa bCe()
  {
    AppMethodBeat.i(43928);
    Object localObject;
    int i;
    if (Qv())
    {
      localObject = com.tencent.mm.plugin.appbrand.game.preload.e.bOU();
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vxC, false) == true)
      {
        i = 1;
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).opj = i;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WAGamePreloadStatisManager", "misPreload:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).opj) });
        AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.Sk();
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).ope = localAppBrandInitConfigWC.appId;
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).opf = localAppBrandInitConfigWC.appVersion;
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).opg = localAppBrandInitConfigWC.cBI;
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).oph = (localAppBrandInitConfigWC.cwR + 1000);
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).opi = localAppBrandInitConfigWC.nYk.cBH;
      }
    }
    else
    {
      switch (((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).opg)
      {
      default: 
        label156:
        if (Sk().cxf != null) {
          ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).mScene = Sk().cxf.scene;
        }
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vGF, false) == true)
        {
          i = 1;
          label204:
          ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).opl = i;
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WAGamePreloadStatisManager", "mHasSplashScreen:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).opl) });
          localObject = com.tencent.mm.plugin.appbrand.ui.i.a(AndroidContextUtil.castActivityOrNull(this.mContext), this);
          ((aa)localObject).eC(((AppBrandInitConfigWC)super.Sk()).iconUrl, ((AppBrandInitConfigWC)super.Sk()).fzM);
          if ((localObject instanceof com.tencent.mm.plugin.appbrand.ui.ad)) {
            ((com.tencent.mm.plugin.appbrand.ui.ad)localObject).setCanShowHideAnimation(false);
          }
          if ((localObject instanceof com.tencent.mm.plugin.appbrand.ui.k))
          {
            if (!TextUtils.isEmpty(((AppBrandInitConfigWC)super.Sk()).nYh)) {
              break label360;
            }
            ((com.tencent.mm.plugin.appbrand.ui.k)localObject).setLoadingIconVisibility(false);
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
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).opg = 1;
      break label156;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).opg = 2;
      break label156;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).opg = 3;
      break label156;
      i = 0;
      break label204;
      label360:
      ((com.tencent.mm.plugin.appbrand.ui.k)localObject).setLoadingIconVisibility(true);
    }
  }
  
  protected final void bCg()
  {
    AppMethodBeat.i(280839);
    super.bCg();
    com.tencent.mm.plugin.appbrand.report.quality.b.J(this);
    AppMethodBeat.o(280839);
  }
  
  protected final void bCk()
  {
    AppMethodBeat.i(43910);
    super.bCk();
    super.abO(toString());
    yK(11);
    com.tencent.mm.plugin.appbrand.keylogger.c.c(this.mAppId, KSProcessWeAppLaunch.stepPrepareResourceTimeout);
    AppMethodBeat.o(43910);
  }
  
  protected final void bCl()
  {
    AppMethodBeat.i(43908);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] onPostInit appId[%s]", new Object[] { this.mAppId });
    MMToClientEvent.g((com.tencent.mm.plugin.appbrand.service.c)super.QW());
    MMToClientEvent.agK("Common_IPC_appid");
    y.a.chL().cD(this.mAppId, Sk().cxf.scene);
    if (((com.tencent.mm.plugin.appbrand.service.c)super.QW()).bBP().compareTo(hf(false)) != 0)
    {
      localObject = new IllegalStateException(String.format(Locale.ENGLISH, "onPostInit appId[%s] mismatch libReader, self[%s] service[%s]", new Object[] { this.mAppId, hf(false).bGg(), ((com.tencent.mm.plugin.appbrand.service.c)super.QW()).bBP().bGg() }));
      AppMethodBeat.o(43908);
      throw ((Throwable)localObject);
    }
    super.bCl();
    Object localObject = (AppBrandInitConfigWC)super.Sk();
    this.nwu.I(0, System.currentTimeMillis() - ((AppBrandInitConfigWC)localObject).startTime);
    com.tencent.mm.plugin.appbrand.performance.c.b(this.mAppId, "ActivityCreate", ((AppBrandInitConfigWC)super.Sk()).startTime, System.currentTimeMillis());
    com.tencent.mm.plugin.appbrand.report.q localq = this.nwH;
    kotlin.g.b.p.k(localObject, "initConfig");
    if ((!localq.qJU) && (((AppBrandInitConfigWC)localObject).cxe == com.tencent.luggage.sdk.launching.b.cBf)) {
      localq.qJU = true;
    }
    MMToClientEvent.a(this.mAppId, new MMToClientEvent.c()
    {
      public final void cq(Object paramAnonymousObject)
      {
        AppMethodBeat.i(273277);
        if ((paramAnonymousObject instanceof AppBrandAuthorizeUI.AuthStateChangedByUserEvent))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], AuthStateChangedByUserEvent", new Object[] { t.this.mAppId });
          com.tencent.mm.plugin.appbrand.permission.a.a.aml(t.this.mAppId);
          AppBrandBackgroundRunningMonitor.a(t.this, (AppBrandAuthorizeUI.AuthStateChangedByUserEvent)paramAnonymousObject);
        }
        AppMethodBeat.o(273277);
      }
    });
    MMToClientEvent.a("Common_IPC_appid", new MMToClientEvent.c()
    {
      public final void cq(Object paramAnonymousObject)
      {
        AppMethodBeat.i(282855);
        if ((paramAnonymousObject instanceof GetOnLineInfoInfoResult))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], GetOnLineInfoInfoResult", new Object[] { t.this.mAppId });
          s.abW(t.this.mAppId).lZJ = ((GetOnLineInfoInfoResult)paramAnonymousObject).lZJ;
          s.abW(t.this.mAppId).lZO = ((GetOnLineInfoInfoResult)paramAnonymousObject).lZO;
          s.abW(t.this.mAppId).nwq = ((GetOnLineInfoInfoResult)paramAnonymousObject).nwq;
        }
        AppMethodBeat.o(282855);
      }
    });
    MMToClientEvent.a(this.mAppId, new MMToClientEvent.c()
    {
      public final void cq(Object paramAnonymousObject)
      {
        AppMethodBeat.i(246569);
        if ((paramAnonymousObject instanceof EventLocationBackgroundStateChanged))
        {
          if (!((EventLocationBackgroundStateChanged)paramAnonymousObject).nSz)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "locationBackgroundStateChanged, not listening, appId[%s]", new Object[] { t.this.mAppId });
            t.this.ntR.nKU.a(com.tencent.mm.plugin.appbrand.a.d.a.nLw);
          }
          AppMethodBeat.o(246569);
          return;
        }
        if ((paramAnonymousObject instanceof WxaAppMsgChannel))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], WxaAppMsgChannel msg", new Object[] { t.this.mAppId });
          com.tencent.mm.plugin.appbrand.jsapi.n.a locala = new com.tencent.mm.plugin.appbrand.jsapi.n.a();
          com.tencent.mm.plugin.appbrand.service.c localc = t.this.bDA();
          paramAnonymousObject = (WxaAppMsgChannel)paramAnonymousObject;
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.onReceiveMsgChannelJsApiEvent", "dispatch msg channel to web ， msgContent:%s", new Object[] { paramAnonymousObject.fQs });
          HashMap localHashMap = new HashMap();
          localHashMap.put("msgId", paramAnonymousObject.msgId);
          localHashMap.put("sendTime", Long.valueOf(paramAnonymousObject.oco));
          localHashMap.put("msgType", Integer.valueOf(paramAnonymousObject.msgType));
          localHashMap.put("msgContent", paramAnonymousObject.fQs);
          locala.i(localc);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.onReceiveMsgChannelJsApiEvent", "dispatch wxa msg channel");
          locala.D(localHashMap).bPO();
          AppMethodBeat.o(246569);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandVoIP1v1FloatBallEvent))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], AppBrandVoIP1v1FloatBallEvent msg", new Object[] { t.this.mAppId });
          if (((AppBrandVoIP1v1FloatBallEvent)paramAnonymousObject).fKG == 1) {
            com.tencent.mm.plugin.appbrand.jsapi.openvoice.r.bTR();
          }
        }
        AppMethodBeat.o(246569);
      }
    });
    new g.a(this, (byte)0);
    this.nwu.I(8, System.currentTimeMillis() - ((AppBrandInitConfigWC)localObject).startTime);
    yK(2);
    localObject = this.nuc;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.appbrand.pip.f)localObject).qFH = com.tencent.mm.plugin.appbrand.pip.k.qGa;
      ((com.tencent.mm.plugin.appbrand.pip.f)localObject).cgL();
      ((com.tencent.mm.plugin.appbrand.pip.f)localObject).qFJ = com.tencent.mm.plugin.appbrand.pip.g.qFV;
    }
    ((com.tencent.mm.plugin.appbrand.service.c)super.QW()).b(getWindowAndroid());
    localObject = bDv();
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.page.ah)localObject).b(getWindowAndroid());
    }
    AppMethodBeat.o(43908);
  }
  
  protected v bCm()
  {
    AppMethodBeat.i(43901);
    Object localObject;
    if (super.Rp()) {
      if (Qv())
      {
        localObject = this.nwA.bCJ();
        if (localObject == null) {
          localObject = new com.tencent.mm.plugin.appbrand.game.c();
        }
      }
    }
    label140:
    label273:
    label280:
    label309:
    for (;;)
    {
      AppMethodBeat.o(43901);
      return localObject;
      com.tencent.mm.plugin.appbrand.report.quality.b.amO(this.mAppId).qNM = com.tencent.mm.plugin.appbrand.report.quality.j.qNe;
      continue;
      if (com.tencent.mm.plugin.appbrand.debugger.x.afN(((AppBrandInitConfigWC)super.Sk()).extInfo))
      {
        localObject = new com.tencent.mm.plugin.appbrand.service.c();
      }
      else
      {
        localObject = new com.tencent.mm.plugin.appbrand.service.c(com.tencent.luggage.sdk.b.a.c.k.cAC);
        continue;
        String str1;
        if (this.nwA != null)
        {
          localObject = this.nwA.bCJ();
          if (localObject != null)
          {
            String str2 = this.mAppId;
            if (!Qv()) {
              break label266;
            }
            str1 = "WAGame";
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "[%s][%s] [applaunch] [preload] createService preloaded, reason=%s", new Object[] { str2, str1, com.tencent.mm.plugin.appbrand.report.quality.b.amO(this.mAppId).qNM.name() });
          }
          if (localObject != null) {
            break label309;
          }
          str1 = this.mAppId;
          if (!Qv()) {
            break label273;
          }
        }
        for (localObject = "WAGame";; localObject = "WAService")
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "[%s][%s] [applaunch] [preload] createService got no preloaded", new Object[] { str1, localObject });
          if (((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG) && (!DebuggerShell.bLS())) || (!com.tencent.mm.plugin.appbrand.task.b.ciL())) {
            break label280;
          }
          localObject = new IllegalStateException("[ForcePreload] enabled, but not preload");
          AppMethodBeat.o(43901);
          throw ((Throwable)localObject);
          localObject = null;
          break;
          str1 = "WAService";
          break label140;
        }
        if (Qv()) {
          localObject = new com.tencent.mm.plugin.appbrand.game.c();
        } else {
          localObject = new com.tencent.mm.plugin.appbrand.service.c();
        }
      }
    }
  }
  
  protected com.tencent.mm.plugin.appbrand.page.x bCn()
  {
    AppMethodBeat.i(43902);
    Object localObject1 = this.mContext;
    try
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.amO(this.mAppId).qNO = Util.nowMilliSecond();
      label24:
      if (Qv()) {}
      com.tencent.mm.plugin.appbrand.page.ah localah;
      for (localObject1 = new com.tencent.mm.plugin.appbrand.game.f.c((Context)localObject1, this);; localObject1 = new com.tencent.mm.plugin.appbrand.page.y((Context)localObject1, this))
      {
        ((com.tencent.mm.plugin.appbrand.page.y)localObject1).setDecorWidgetFactory(bDh());
        if (!Qv()) {
          ((com.tencent.mm.plugin.appbrand.page.y)localObject1).a(com.tencent.mm.plugin.appbrand.page.b.i.qxY, new com.tencent.mm.plugin.appbrand.page.b.a());
        }
        ((com.tencent.mm.plugin.appbrand.page.y)localObject1).a(com.tencent.mm.plugin.appbrand.page.b.i.qxX, new com.tencent.mm.plugin.appbrand.page.b.b());
        if (this.nwA == null) {
          break label248;
        }
        localah = this.nwA.bCK();
        if (localah == null) {
          break label248;
        }
        if ((localah == null) || (((com.tencent.mm.plugin.appbrand.page.y)localObject1).getRuntime() == null)) {
          break label230;
        }
        if (localah.bBP().compareTo(((com.tencent.mm.plugin.appbrand.page.y)localObject1).getRuntime().hf(false)) == 0) {
          break;
        }
        localObject1 = new IllegalStateException(String.format(Locale.ENGLISH, "stashPreloadedPageView appId[%s] mismatch libReader, runtime[%s] page[%s]", new Object[] { ((com.tencent.mm.plugin.appbrand.page.y)localObject1).getAppId(), ((com.tencent.mm.plugin.appbrand.page.y)localObject1).getRuntime().hf(false).bGg(), localah.bBP().bGg() }));
        AppMethodBeat.o(43902);
        throw ((Throwable)localObject1);
      }
      synchronized (((com.tencent.mm.plugin.appbrand.page.y)localObject1).qrW)
      {
        ((com.tencent.mm.plugin.appbrand.page.y)localObject1).qrW.addLast(localah);
        label230:
        if ((localah instanceof bv)) {
          ((com.tencent.mm.plugin.appbrand.page.y)localObject1).setWAAutoWebViewJs(((bv)localah).qwv);
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
  
  public final boolean bCo()
  {
    AppMethodBeat.i(43904);
    if (!Qv())
    {
      AppMethodBeat.o(43904);
      return true;
    }
    AppMethodBeat.o(43904);
    return false;
  }
  
  protected final void bCr()
  {
    AppMethodBeat.i(43916);
    MMToClientEvent.g((com.tencent.mm.plugin.appbrand.service.c)super.QW());
    MMToClientEvent.agK("Common_IPC_appid");
    new AppBrandRegisterTask(this, bDq()).bsM();
    AppMethodBeat.o(43916);
  }
  
  public final void bCx()
  {
    AppMethodBeat.i(174684);
    if (com.tencent.mm.plugin.appbrand.ui.p.an(this))
    {
      AppMethodBeat.o(174684);
      return;
    }
    super.bCx();
    AppMethodBeat.o(174684);
  }
  
  public final boolean bCy()
  {
    AppMethodBeat.i(43913);
    if ((!isInBackStack()) && (!d.a(this))) {}
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
  
  public final aa bCz()
  {
    AppMethodBeat.i(280838);
    aa localaa = super.bCz();
    AppMethodBeat.o(280838);
    return localaa;
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c bDA()
  {
    AppMethodBeat.i(293305);
    com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)super.QW();
    AppMethodBeat.o(293305);
    return localc;
  }
  
  public final int bDC()
  {
    AppMethodBeat.i(293306);
    int i = Sk().cxf.scene;
    AppMethodBeat.o(293306);
    return i;
  }
  
  public final void bDD()
  {
    AppMethodBeat.i(43931);
    Object localObject = bDx();
    com.tencent.mm.plugin.appbrand.config.n.bP(this.mAppId, ((AppBrandSysConfigWC)localObject).cxI);
    com.tencent.mm.plugin.appbrand.config.n.bQ(this.mAppId, ((AppBrandSysConfigWC)localObject).cxJ);
    this.ntK.add(com.tencent.mm.plugin.appbrand.config.f.g(this));
    this.ntK.add(com.tencent.mm.plugin.appbrand.config.f.a((AppBrandSysConfigLU)localObject));
    this.ntK.add(com.tencent.mm.plugin.appbrand.config.f.b((AppBrandSysConfigLU)localObject));
    this.ntK.add(com.tencent.mm.plugin.appbrand.config.f.h(this));
    localObject = com.tencent.mm.plugin.appbrand.config.f.c((AppBrandSysConfigLU)localObject);
    ((com.tencent.mm.plugin.appbrand.performance.a)localObject).qyB |= DebuggerShell.bLS();
    boolean bool2 = ((com.tencent.mm.plugin.appbrand.performance.a)localObject).qyC;
    if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject).qyC = (bool1 | bool2);
      this.ntK.add(localObject);
      AppMethodBeat.o(43931);
      return;
    }
  }
  
  public final void bDE()
  {
    AppMethodBeat.i(43933);
    this.nua = false;
    if (this.ntu != null) {
      this.ntu.C(this);
    }
    finish();
    if ((this.ntu instanceof AppBrandRuntimeContainerWC)) {
      ((AppBrandRuntimeContainerWC)this.ntu).Se();
    }
    AppMethodBeat.o(43933);
  }
  
  public final boolean bDF()
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    com.tencent.mm.plugin.appbrand.ad.h localh;
    if (this.nwE != null)
    {
      localh = this.nwE;
      if (localh.nAM == null) {
        break label44;
      }
    }
    label44:
    for (boolean bool1 = localh.nAM.nAV;; bool1 = false)
    {
      bool2 = bool3;
      if (bool1) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public final int bDG()
  {
    if (this.nwE != null) {
      return this.nwE.nAJ;
    }
    return 9;
  }
  
  public final int bDJ()
  {
    AppMethodBeat.i(163908);
    if ((AppBrandInitConfigWC)super.Sk() != null)
    {
      int i = ((AppBrandInitConfigWC)super.Sk()).nYn;
      AppMethodBeat.o(163908);
      return i;
    }
    AppMethodBeat.o(163908);
    return -1;
  }
  
  public final boolean bDK()
  {
    AppMethodBeat.i(280870);
    boolean bool = ((AppBrandInitConfigWC)super.Sk()).nBE.isEnable();
    AppMethodBeat.o(280870);
    return bool;
  }
  
  public final com.tencent.mm.plugin.appbrand.task.m bDL()
  {
    return this.nwN;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.c.e bDM()
  {
    return this.nwI;
  }
  
  public final String bDg()
  {
    AppMethodBeat.i(280807);
    if ((AppBrandInitConfigWC)super.Sk() == null)
    {
      AppMethodBeat.o(280807);
      return "NULL";
    }
    String str = ((AppBrandInitConfigWC)super.Sk()).fzM;
    AppMethodBeat.o(280807);
    return str;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.e bDh()
  {
    AppMethodBeat.i(280809);
    if (this.nwJ == null)
    {
      localObject = com.tencent.mm.plugin.appbrand.page.g.qpr;
      this.nwJ = com.tencent.mm.plugin.appbrand.page.g.b(com.tencent.mm.plugin.appbrand.task.n.jA(((AppBrandInitConfigWC)super.Sk()).Qv()));
    }
    Object localObject = this.nwJ;
    AppMethodBeat.o(280809);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.q.b bDj()
  {
    if (this.nwD != null) {
      return this.nwD.qib;
    }
    return null;
  }
  
  public com.tencent.mm.plugin.appbrand.k.b bDk()
  {
    AppMethodBeat.i(174683);
    if ((this.nwM == null) && (!this.ntU.get())) {
      this.nwM = new t.12(this);
    }
    com.tencent.mm.plugin.appbrand.k.b localb = this.nwM;
    AppMethodBeat.o(174683);
    return localb;
  }
  
  public final boolean bDl()
  {
    AppMethodBeat.i(43893);
    boolean bool = ((AppBrandInitConfigWC)super.Sk()).nYb;
    AppMethodBeat.o(43893);
    return bool;
  }
  
  public final boolean bDm()
  {
    AppMethodBeat.i(43894);
    boolean bool = ((AppBrandInitConfigWC)super.Sk()).nXY;
    AppMethodBeat.o(43894);
    return bool;
  }
  
  public final void bDo()
  {
    AppMethodBeat.i(43898);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "callSuperClose appId:%s", new Object[] { this.mAppId });
    super.close();
    AppMethodBeat.o(43898);
  }
  
  protected final void bDp()
  {
    AppMethodBeat.i(43905);
    b(com.tencent.mm.plugin.appbrand.networking.c.class, com.tencent.mm.plugin.appbrand.networking.h.qld);
    b(com.tencent.mm.plugin.appbrand.permission.j.class, new com.tencent.mm.plugin.appbrand.permission.m(this));
    b(com.tencent.mm.plugin.appbrand.permission.k.class, com.tencent.mm.plugin.appbrand.permission.o.qzN);
    b(com.tencent.mm.plugin.appbrand.jsapi.media.e.class, com.tencent.mm.plugin.appbrand.jsapi.media.p.pci);
    af(com.tencent.mm.plugin.appbrand.networking.d.class);
    b(com.tencent.mm.plugin.appbrand.networking.d.class, new com.tencent.mm.plugin.appbrand.networking.g(this));
    b(com.tencent.mm.plugin.appbrand.jsapi.base.g.class, new af());
    b(com.tencent.mm.plugin.appbrand.widget.j.class, com.tencent.mm.plugin.appbrand.widget.k.rnP);
    b(com.tencent.mm.plugin.appbrand.jsapi.ab.c.class, com.tencent.mm.plugin.appbrand.luggage.b.c.qar);
    b(com.tencent.luggage.sdk.g.a.class, com.tencent.mm.plugin.appbrand.app.g.nCu);
    b(bc.class, new com.tencent.mm.plugin.appbrand.page.ai(this));
    b(com.tencent.mm.plugin.appbrand.jsapi.media.a.a.class, new com.tencent.mm.plugin.appbrand.jsapi.media.a.a()
    {
      public final void a(final Context paramAnonymousContext, final Runnable paramAnonymousRunnable1, final Runnable paramAnonymousRunnable2)
      {
        AppMethodBeat.i(270003);
        if (!com.tencent.mm.plugin.appbrand.utils.ai.Or())
        {
          t.this.h(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(271455);
              com.tencent.mm.platformtools.p.a(paramAnonymousContext, paramAnonymousRunnable1, paramAnonymousRunnable2);
              AppMethodBeat.o(271455);
            }
          }, 0L);
          AppMethodBeat.o(270003);
          return;
        }
        com.tencent.mm.platformtools.p.a(paramAnonymousContext, paramAnonymousRunnable1, paramAnonymousRunnable2);
        AppMethodBeat.o(270003);
      }
    });
    s.abS(this.mAppId);
    AppMethodBeat.o(43905);
  }
  
  protected final void bDu()
  {
    AppMethodBeat.i(43907);
    com.tencent.luggage.sdk.h.d.a("clearDuplicatedInstanceOnAppCreate", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(43865);
        t localt = d.abA(t.this.mAppId);
        if ((localt != null) && (t.this != localt))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "clearDuplicatedInstanceOnAppCreate duplicated[%d] this[%d]", new Object[] { Integer.valueOf(localt.hashCode()), Integer.valueOf(hashCode()) });
          localt.bDE();
        }
        new LuggageClearDuplicatedTask(t.this).bsM();
        AppMethodBeat.o(43865);
      }
    });
    AppMethodBeat.o(43907);
  }
  
  public com.tencent.mm.plugin.appbrand.page.ah bDv()
  {
    AppMethodBeat.i(280837);
    if ((com.tencent.mm.plugin.appbrand.page.y)super.bBX() == null)
    {
      AppMethodBeat.o(280837);
      return null;
    }
    if (((com.tencent.mm.plugin.appbrand.page.y)super.bBX()).getCurrentPage() == null)
    {
      AppMethodBeat.o(280837);
      return null;
    }
    com.tencent.mm.plugin.appbrand.page.ah localah = (com.tencent.mm.plugin.appbrand.page.ah)((com.tencent.mm.plugin.appbrand.page.y)super.bBX()).getCurrentPage().getCurrentPageView();
    AppMethodBeat.o(280837);
    return localah;
  }
  
  final void bDw()
  {
    AppMethodBeat.i(293302);
    hg(false);
    AppMethodBeat.o(293302);
  }
  
  public final AppBrandSysConfigWC bDx()
  {
    AppMethodBeat.i(43918);
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)d(AppBrandSysConfigWC.class, false);
    AppMethodBeat.o(43918);
    return localAppBrandSysConfigWC;
  }
  
  public final AppBrandInitConfigWC bDy()
  {
    AppMethodBeat.i(293303);
    AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.Sk();
    AppMethodBeat.o(293303);
    return localAppBrandInitConfigWC;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.y bDz()
  {
    AppMethodBeat.i(293304);
    com.tencent.mm.plugin.appbrand.page.y localy = (com.tencent.mm.plugin.appbrand.page.y)super.bBX();
    AppMethodBeat.o(293304);
    return localy;
  }
  
  protected final void c(v paramv)
  {
    AppMethodBeat.i(280861);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onServiceProvidedBeforeRealInit, appId:%s, preloadedService:%s", new Object[] { this.mAppId, paramv });
    paramv.a(new v.b()
    {
      public final void a(ab paramAnonymousab)
      {
        AppMethodBeat.i(281402);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "WorkerContainer had installed. watchAdWorkerCreate");
        ab.a locala = (ab.a)t.p(t.this);
        if (locala != null) {
          synchronized (paramAnonymousab.nxV)
          {
            if (paramAnonymousab.nxU.nsn != null)
            {
              locala.b(paramAnonymousab.nxU);
              AppMethodBeat.o(281402);
              return;
            }
            paramAnonymousab.nxV.add(locala);
            AppMethodBeat.o(281402);
            return;
          }
        }
        AppMethodBeat.o(281402);
      }
    });
    AppMethodBeat.o(280861);
  }
  
  public final void close()
  {
    AppMethodBeat.i(43897);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "close() appId:%s, stack:%s", new Object[] { this.mAppId, android.util.Log.getStackTraceString(new Throwable()) });
    Runnable local21;
    com.tencent.mm.plugin.appbrand.widget.dialog.e locale;
    int j;
    int i;
    for (;;)
    {
      try
      {
        if (k.abM(this.mAppId) == k.d.ntb)
        {
          localObject1 = (com.tencent.mm.plugin.appbrand.game.f.a)((com.tencent.mm.plugin.appbrand.page.y)super.bBX()).getPageView().R(com.tencent.mm.plugin.appbrand.game.f.a.class);
          if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.game.f.a)localObject1).bOG() != null))
          {
            localObject1 = ((com.tencent.mm.plugin.appbrand.game.f.a)localObject1).bOG();
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: triggerMakeCanvasBitmap");
            if ((((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).onW != null) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).bOI() != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).onW.UMJ)) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).onW.UMB) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).onY != null)) {
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
        local21 = new Runnable()
        {
          public final void run()
          {
            boolean bool3 = true;
            AppMethodBeat.i(281116);
            Object localObject;
            t localt;
            int i;
            boolean bool1;
            if (t.f(t.this) != null)
            {
              localObject = t.f(t.this);
              localt = t.this;
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "close, runtime:%s", new Object[] { localt.mAppId });
              i = com.tencent.mm.plugin.appbrand.floatball.b.b(k.abM(localt.mAppId));
              if ((((com.tencent.mm.plugin.appbrand.q.c)localObject).qib != null) && (((com.tencent.mm.plugin.appbrand.q.c)localObject).qib.Q(i, true))) {}
              for (bool1 = true;; bool1 = false)
              {
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "close, result:%s", new Object[] { Boolean.valueOf(bool1) });
                if (!bool1) {
                  break;
                }
                AppMethodBeat.o(281116);
                return;
              }
            }
            if (t.g(t.this) != null)
            {
              localObject = t.g(t.this);
              localt = t.this;
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFloatBallLogic", "close, runtime:%s", new Object[] { localt.mAppId });
              i = com.tencent.mm.plugin.appbrand.floatball.b.b(k.abM(localt.mAppId));
              boolean bool2;
              if ((((com.tencent.mm.plugin.appbrand.floatball.c)localObject).oli != null) && (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).oli.bOg()))
              {
                bool1 = true;
                if ((((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olj == null) || (!((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olj.bOg())) {
                  break label291;
                }
                bool2 = true;
                label218:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFloatBallLogic", "close, voip:%s, voip1v1:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                if (!bool1) {
                  break label296;
                }
                ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).oli.a(AndroidContextUtil.castActivityOrNull(localt.mContext), new c.2((com.tencent.mm.plugin.appbrand.floatball.c)localObject, i));
                bool1 = bool3;
              }
              for (;;)
              {
                if (!bool1) {
                  break label360;
                }
                AppMethodBeat.o(281116);
                return;
                bool1 = false;
                break;
                label291:
                bool2 = false;
                break label218;
                label296:
                if (bool2)
                {
                  ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olj.a(AndroidContextUtil.castActivityOrNull(localt.mContext), new c.3((com.tencent.mm.plugin.appbrand.floatball.c)localObject, i));
                  bool1 = bool3;
                }
                else
                {
                  bool1 = ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).zJ(i);
                  com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFloatBallLogic", "close, result:%s", new Object[] { Boolean.valueOf(bool1) });
                }
              }
            }
            label360:
            t.this.bDo();
            AppMethodBeat.o(281116);
          }
        };
        if (!((com.tencent.mm.plugin.gamelive.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.gamelive.e.class)).isGameLiving(this.mAppId, ((AppBrandInitConfigWC)super.Sk()).cBI).booleanValue()) {
          continue;
        }
        ((com.tencent.mm.plugin.gamelive.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelive.c.class)).a(AndroidContextUtil.castActivityOrNull(this.mContext), this.mAppId, this.ntz.cBI, local21);
        AppMethodBeat.o(43897);
        return;
        locale = new com.tencent.mm.plugin.appbrand.widget.dialog.e((com.tencent.mm.plugin.appbrand.service.c)super.QW());
        if (locale.olT != null) {
          break;
        }
      }
      OpenBusinessViewUtil.B(this);
      if (((AppBrandInitConfigWC)super.Sk()).nYv != null) {
        this.ntR.a(new c.a()
        {
          public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
          {
            AppMethodBeat.i(275972);
            if (com.tencent.mm.plugin.appbrand.a.b.nKQ == paramAnonymousb)
            {
              t.this.ntR.b(this);
              paramAnonymousString = t.this.bDy().nYv;
              if ((AndroidContextUtil.castActivityOrNull(t.this.mContext) == null) || (!AndroidContextUtil.castActivityOrNull(t.this.mContext).isFinishing())) {
                break label76;
              }
            }
            label76:
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousString.iT(bool);
              AppMethodBeat.o(275972);
              return;
            }
          }
        });
      }
      if ((bDl()) || (ai.q(this)))
      {
        super.close();
        AppMethodBeat.o(43897);
        return;
        if (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).bOJ()) {
          ((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).bOI().PJ();
        }
      }
      else
      {
        j = 0;
        if ((this != null) && (bDx() != null) && (AndroidContextUtil.castActivityOrNull(this.mContext) != null)) {
          break label587;
        }
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "invalid close state");
        i = 0;
        label405:
        if (i == 0) {
          break label1456;
        }
        if (j != 0)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: WA dialog first");
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1237L, 2L, 1L, false);
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        local21.run();
      }
      AppMethodBeat.o(43897);
      return;
      Object localObject2 = locale.olT.qIs;
      if ((localObject2 == null) || (((fqd)localObject2).UNX == null) || (((fqd)localObject2).UNX.size() < 3))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: no config");
        j = 0;
        break;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1237L, 0L, 1L, false);
      long l1 = s.abV(this.mAppId).lastResumeTime;
      locale.pEa = ((int)(System.currentTimeMillis() - l1));
      if (locale.pEa < ((fqd)localObject2).UNZ * 1000)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: time limit");
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1237L, 1L, 1L, false);
        j = 0;
        break;
      }
      j = 1;
      break;
      label587:
      localObject2 = bDx();
      if (!((AppBrandSysConfigWC)localObject2).nYV)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "can not show evaluate dialog");
        i = 0;
        break label405;
      }
      l1 = s.abV(this.mAppId).lastResumeTime;
      long l2 = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "app time lastResumeTime:%s, closeTime:%s, leastTime:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(((AppBrandSysConfigWC)localObject2).nYX) });
      if ((l2 - l1) / 1000L < ((AppBrandSysConfigWC)localObject2).nYX)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "time not enough to show evaluate dialog");
        i = 0;
        break label405;
      }
      Object localObject5 = (AppBrandInitConfigWC)super.Sk();
      locale.userName = ((AppBrandInitConfigWC)localObject5).username;
      if (Util.isNullOrNil(locale.userName))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "username is null, can not show evaluate dialog");
        i = 0;
        break label405;
      }
      Object localObject3 = AndroidContextUtil.castActivityOrNull(this.mContext);
      Object localObject4 = ((AppBrandInitConfigWC)localObject5).appId;
      Object localObject6 = ((AppBrandInitConfigWC)localObject5).fzM;
      boolean bool = ((AppBrandSysConfigWC)localObject2).nYW;
      locale.dialog = com.tencent.mm.plugin.appbrand.widget.dialog.e.C((Context)localObject3, true);
      localObject5 = (LinearLayout)LayoutInflater.from(locale.dialog.getContext()).inflate(au.g.app_brand_evaluate_dialog, null, false);
      locale.dialog.setContentView((View)localObject5);
      Object localObject7 = ar.au(locale.dialog.getContext());
      i = Math.min(((Point)localObject7).x, ((Point)localObject7).y);
      localObject7 = new FrameLayout.LayoutParams(i, -2);
      ((FrameLayout.LayoutParams)localObject7).gravity = 1;
      ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject7);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "createEvaluateDialog, dialog width:%d", new Object[] { Integer.valueOf(i) });
      locale.rtR = ((TextView)locale.dialog.findViewById(au.f.evaluate_hint));
      locale.rtS = ((LinearLayout)locale.dialog.findViewById(au.f.evaluate_logo_layout));
      locale.rtT = ((LinearLayout)locale.dialog.findViewById(au.f.evaluate_comment_submit_layout));
      localObject7 = (TextView)locale.dialog.findViewById(au.f.evaluate_comment);
      if (bool)
      {
        ((TextView)localObject7).setVisibility(0);
        ((TextView)localObject7).setOnClickListener(new e.15(locale, (Context)localObject3, (String)localObject4, (String)localObject6));
        label997:
        ((TextView)locale.dialog.findViewById(au.f.evaluate_submit)).setOnClickListener(new e.16(locale, (Context)localObject3));
        locale.rtQ = ((RatingBar)locale.dialog.findViewById(au.f.evaluate_ratingbar));
        locale.rtQ.setOnRatingBarChangeListener(new e.17(locale));
        locale.rrS = ((TextView)locale.dialog.findViewById(au.f.evaluate_desc));
        if (Util.isNullOrNil((String)localObject6)) {
          break label1316;
        }
        locale.rrS.setVisibility(0);
        locale.rrS.setText(((Context)localObject3).getString(au.i.app_brand_evaluate_dialog_desc, new Object[] { localObject6 }));
        label1122:
        ((ImageView)locale.dialog.findViewById(au.f.evaluate_close)).setOnClickListener(new e.18(locale));
        localObject3 = (ViewGroup)((LinearLayout)localObject5).getParent();
        if (localObject3 != null)
        {
          ((ViewGroup)localObject3).setOnClickListener(new e.19(locale));
          ((LinearLayout)localObject5).setOnClickListener(new e.20(locale));
        }
        locale.dialog = locale.dialog;
        locale.dialog.setOnCancelListener(new e.1(locale));
        locale.dialog.setOnDismissListener(new e.12(locale, local21));
        locale.rtM = false;
        ((AppBrandSysConfigWC)localObject2).nYV = false;
        if (this != null) {
          break label1329;
        }
        localObject2 = null;
        label1256:
        locale.appId = ((String)localObject2);
        if (!Util.isNullOrNil(locale.appId)) {
          break label1338;
        }
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "saveEvaluateReport, no app id");
      }
      for (;;)
      {
        locale.fg(1, 1);
        locale.show();
        i = 1;
        break;
        ((TextView)localObject7).setVisibility(8);
        ((TextView)localObject7).setOnClickListener(null);
        break label997;
        label1316:
        locale.rrS.setVisibility(8);
        break label1122;
        label1329:
        localObject2 = this.mAppId;
        break label1256;
        label1338:
        localObject2 = (AppBrandInitConfigWC)super.Sk();
        locale.sessionId = "";
        if (localObject2 != null) {
          locale.sessionId = ((AppBrandInitConfigLU)localObject2).cwP;
        }
        locale.scene = 1000;
        if ((localObject2 != null) && (((AppBrandInitConfigLU)localObject2).cxf != null)) {
          locale.scene = ((AppBrandInitConfigLU)localObject2).cxf.scene;
        }
        locale.fve = "";
        if (((com.tencent.mm.plugin.appbrand.service.c)super.QW() != null) && (((com.tencent.mm.plugin.appbrand.service.c)super.QW()).bDv() != null)) {
          locale.fve = ((com.tencent.mm.plugin.appbrand.service.c)super.QW()).bDv().oxe;
        }
      }
      label1456:
      if (j != 0)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "need show game evaluate dialog");
        localObject2 = locale.olT.qIs;
        locale.olT.qIs = null;
        locale.dialog = com.tencent.mm.plugin.appbrand.widget.dialog.e.C(AndroidContextUtil.castActivityOrNull(this.mContext), false);
        localObject3 = (LinearLayout)LayoutInflater.from(locale.dialog.getContext()).inflate(au.g.app_brand_game_evaluate_dialog, null, false);
        locale.dialog.setContentView((View)localObject3);
        localObject4 = ar.au(locale.dialog.getContext());
        localObject4 = new FrameLayout.LayoutParams(Math.min(((Point)localObject4).x, ((Point)localObject4).y), ((LinearLayout)localObject3).getLayoutParams().height);
        ((FrameLayout.LayoutParams)localObject4).gravity = 1;
        ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        localObject5 = (TextView)((LinearLayout)localObject3).findViewById(au.f.title);
        ((TextView)localObject5).setText(((fqd)localObject2).fwr);
        localObject6 = (TextView)((LinearLayout)localObject3).findViewById(au.f.evaluate_desc);
        ((TextView)localObject6).setText(((fqd)localObject2).UNW);
        localObject4 = (ImageView)((LinearLayout)localObject3).findViewById(au.f.evaluate_close);
        localObject5 = new e.21(locale, (TextView)localObject5, (TextView)localObject6, (ImageView)localObject4, (LinearLayout)localObject3, this, local21, (fqd)localObject2);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(au.f.option_1)).a(0, (fqd)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(au.f.option_2)).a(1, (fqd)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(au.f.option_3)).a(2, (fqd)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        locale.dialog.setOnCancelListener(new e.2(locale, this, (fqd)localObject2, local21));
        ((ImageView)localObject4).setOnClickListener(new e.3(locale, this, (fqd)localObject2, local21));
        locale.dialog = locale.dialog;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1237L, 4L, 1L, false);
        locale.show();
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  protected final com.tencent.mm.plugin.appbrand.widget.d dC(Context paramContext)
  {
    AppMethodBeat.i(280853);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vEy, 1) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramContext = super.dC(paramContext);
      AppMethodBeat.o(280853);
      return paramContext;
    }
    paramContext = new com.tencent.mm.plugin.appbrand.widget.d(paramContext);
    AppMethodBeat.o(280853);
    return paramContext;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(43899);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "finish appId[%s] type[%d] hash[%d] stacktrace=%s", new Object[] { this.mAppId, Integer.valueOf(this.ntz.cBI), Integer.valueOf(hashCode()), android.util.Log.getStackTraceString(new Throwable()) });
    if ((n.e(this)) || (this.ntu == null))
    {
      P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174678);
          t.this.dispatchDestroy();
          AppMethodBeat.o(174678);
        }
      });
      AppMethodBeat.o(43899);
      return;
    }
    super.finish();
    if (this.nwC != null)
    {
      this.nwC.x(this);
      this.nwC = null;
    }
    if (this.nwD != null) {
      com.tencent.mm.plugin.appbrand.q.c.x(this);
    }
    AppMethodBeat.o(43899);
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid()
  {
    AppMethodBeat.i(280869);
    if (this.ntu != null)
    {
      localObject = this.ntu.getWindowAndroid();
      if (localObject != null)
      {
        if ((this.nwG != null) && ((this.nwG instanceof com.tencent.mm.plugin.appbrand.platform.window.g)) && ((((com.tencent.mm.plugin.appbrand.platform.window.g)this.nwG).RZ()) || ((this.nwG instanceof com.tencent.mm.plugin.appbrand.widget.c.a))))
        {
          if ((this.nwP == null) || (this.nwP.qGE != localObject) || (this.nwP.qGF != this.nwG)) {
            this.nwP = new com.tencent.mm.plugin.appbrand.platform.window.f((com.tencent.mm.plugin.appbrand.platform.window.c)localObject, (com.tencent.mm.plugin.appbrand.platform.window.g)this.nwG);
          }
          localObject = this.nwP;
          AppMethodBeat.o(280869);
          return localObject;
        }
        AppMethodBeat.o(280869);
        return localObject;
      }
    }
    Object localObject = super.getWindowAndroid();
    AppMethodBeat.o(280869);
    return localObject;
  }
  
  final void hg(boolean paramBoolean)
  {
    AppMethodBeat.i(280842);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "notifyRemovedToMMTaskManager(isForDestroy:%b), appId:%s", new Object[] { Boolean.valueOf(paramBoolean), this.mAppId });
    if ((paramBoolean) || (!this.ntU.get())) {
      new LuggageRemoveTask(this).bsM();
    }
    AppMethodBeat.o(280842);
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(43903);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.plugin.appbrand.jsapi.aa.h.a(paramConfiguration, this.mAppId);
    this.nwB = new Configuration(paramConfiguration);
    this.nwG.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(43903);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(43906);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepPrepareRuntime);
    bDu();
    com.tencent.mm.plugin.appbrand.report.quality.b.cik();
    Object localObject1 = (AppBrandInitConfigWC)super.Sk();
    Object localObject2;
    boolean bool;
    int i;
    if (localObject1 != null)
    {
      localObject2 = ((AppBrandInitConfigWC)localObject1).nYk;
      if (localObject2 != null) {}
    }
    else
    {
      d.setRuntime(this);
      com.tencent.mm.plugin.appbrand.e.a.R(this);
      bDn();
      bool = WXHardCoderJNI.hcMiniProgramLaunchEnable;
      int j = WXHardCoderJNI.hcMiniProgramLaunchDelay;
      int k = WXHardCoderJNI.hcMiniProgramLaunchCPU;
      int m = WXHardCoderJNI.hcMiniProgramLaunchIO;
      if (!WXHardCoderJNI.hcMiniProgramLaunchThr) {
        break label1154;
      }
      i = Process.myTid();
      label90:
      this.nww = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMiniProgramLaunchTimeout, 801, WXHardCoderJNI.hcMiniProgramLaunchAction, "MicroMsg.AppBrandRuntimeWC");
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onCreate %s, scene:%d, instanceId:%s, sessionId:%s", new Object[] { this, Integer.valueOf(Sk().cxf.scene), ((AppBrandInitConfigWC)super.Sk()).cwQ, ((AppBrandInitConfigWC)super.Sk()).cwP });
      super.onCreate();
      bDp();
      if (!Qv()) {
        break label1159;
      }
      localObject1 = com.tencent.luggage.sdk.e.g.cCT;
      localObject1 = u.a.pUI;
      com.tencent.luggage.sdk.e.g.Ss();
      localObject1 = com.tencent.mm.plugin.appbrand.game.preload.d.bOS();
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).nAH = this;
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ooU = new com.tencent.mm.plugin.appbrand.game.preload.c(this);
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).hasInit = true;
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ooW = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vxC, false);
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ooR = new com.tencent.mm.plugin.appbrand.s.m(((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ooU);
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ooX = new AtomicInteger(0);
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ooY = new AtomicInteger(0);
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).ooZ = new AtomicInteger(0);
      ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).opa = new AtomicInteger(0);
      com.tencent.mm.plugin.appbrand.game.preload.d.bOS().bs(((AppBrandInitConfigWC)super.Sk()).nBD);
      label341:
      com.tencent.mm.plugin.appbrand.report.quality.b.I(this);
      localObject1 = com.tencent.mm.plugin.appbrand.report.quality.o.qOt;
      com.tencent.mm.plugin.appbrand.report.quality.o.eW(this.mAppId, com.tencent.mm.plugin.appbrand.report.quality.b.amO(this.mAppId).cBH);
      com.tencent.mm.plugin.appbrand.report.quality.g.a(this, false, com.tencent.mm.plugin.appbrand.utils.d.anh(((AppBrandInitConfigWC)super.Sk()).nYh));
      localObject1 = com.tencent.luggage.game.e.a.Qf();
      localObject2 = this.mAppId;
      bool = Qv();
      ((com.tencent.luggage.game.e.a)localObject1).appId = ((String)localObject2);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MBNiReporter", "hy: appId:%s,isGame:%s", new Object[] { localObject2, Boolean.valueOf(bool) });
      if (bool) {
        k.a((String)localObject2, ((com.tencent.luggage.game.e.a)localObject1).cwl);
      }
      ((com.tencent.luggage.game.e.a)localObject1).csC = new ArrayList();
      if (!bool) {
        break label1175;
      }
      ((com.tencent.luggage.game.e.a)localObject1).csG = 1004;
      label475:
      com.tencent.mm.plugin.ac.a.a(this.mAppId, ((AppBrandInitConfigWC)super.Sk()).nYe);
      a(new AppBrandRuntime.b()
      {
        private volatile f.b nxi;
        
        public final void interrupt()
        {
          AppMethodBeat.i(277028);
          if (this.nxi != null) {
            this.nxi.interrupt();
          }
          AppMethodBeat.o(277028);
        }
        
        public final void prepare()
        {
          AppMethodBeat.i(277027);
          com.tencent.mm.plugin.appbrand.keylogger.c.a(t.this.mAppId, KSProcessWeAppLaunch.stepWaitForCommLibConfirm);
          this.nxi = com.tencent.mm.plugin.appbrand.launching.f.a(t.this, new kotlin.g.a.b() {});
          AppMethodBeat.o(277027);
        }
      });
      a(new AppBrandRuntime.b()
      {
        public final void prepare()
        {
          AppMethodBeat.i(271329);
          t.a(t.this, this);
          AppMethodBeat.o(271329);
        }
      });
      a(new b((byte)0));
      localObject1 = new p(this);
      this.nwA = ((p)localObject1);
      a((AppBrandRuntime.b)localObject1);
      new AppBrandRegisterTask(this, bDq()).bsM();
      com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
      com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.t(this);
      com.tencent.mm.plugin.appbrand.backgroundfetch.i.t(this);
      com.tencent.mm.plugin.appbrand.utils.i.S(this);
      OpenBusinessViewUtil.A(this);
      AppBrandBackgroundRunningMonitor.u(this);
      this.nwt = new com.tencent.mm.plugin.appbrand.report.model.n();
      this.nwt.qLH = Util.currentTicks();
      this.nwK = new com.tencent.mm.plugin.appbrand.report.model.r();
      localObject1 = this.nwK;
      localObject2 = com.tencent.mm.plugin.appbrand.report.quality.b.amO(this.mAppId).cBH;
      String str = this.mAppId;
      long l = ((AppBrandInitConfigWC)super.Sk()).cwR + 1000;
      kotlin.g.b.p.k(localObject2, "instanceId");
      kotlin.g.b.p.k(str, "appId");
      ((com.tencent.mm.plugin.appbrand.report.model.r)localObject1).qMw = Long.valueOf(System.currentTimeMillis());
      ((com.tencent.mm.plugin.appbrand.report.model.r)localObject1).sessionId = ((String)localObject2);
      ((com.tencent.mm.plugin.appbrand.report.model.r)localObject1).appId = str;
      ((com.tencent.mm.plugin.appbrand.report.model.r)localObject1).qMv = Long.valueOf(l);
      com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k.a(this.mAppId, bCi(), Sk().cxf);
      if (Sk().cxf.scene != 1099) {
        break label1186;
      }
      bool = true;
      label750:
      this.nwx = bool;
      if (bDl()) {
        this.nwy.add(new ah((AppBrandInitConfigWC)super.Sk()));
      }
      this.nwy.add(new as((AppBrandInitConfigWC)super.Sk(), this));
      this.ntR.a(new c.a()
      {
        public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.a.b paramAnonymousb)
        {
          AppMethodBeat.i(269370);
          if (com.tencent.mm.plugin.appbrand.a.b.nKR == paramAnonymousb)
          {
            t.this.nws.pne.pnf.clear();
            com.tencent.mm.plugin.appbrand.report.quality.k.cI(paramAnonymousString, 4);
          }
          AppMethodBeat.o(269370);
        }
      });
      if (this.ntu == null) {
        break label1192;
      }
      bDs();
      label838:
      if (this.ntu == null) {
        break label1215;
      }
      bDt();
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.appbrand.report.quality.b.amO(this.mAppId);
      if (localObject1 != null) {
        ((QualitySession)localObject1).qNy = (Util.nowMilliSecond() - ((AppBrandInitConfigWC)super.Sk()).startTime);
      }
      if (j.a.za(this.ntz.cBI))
      {
        localObject1 = this.mAppId;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "invoke appId:%s", new Object[] { localObject1 });
        if (BuildInfo.IS_FLAVOR_BLUE)
        {
          localObject2 = com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_appbrand_check_demoinfo_default", "1", true, true);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "xSwitch xSwitchStr:%s", new Object[] { localObject2 });
          if (TextUtils.equals((CharSequence)localObject2, "1")) {
            XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString((String)localObject1), com.tencent.mm.plugin.appbrand.task.a.a.a.class, new com.tencent.mm.plugin.appbrand.task.a.a.1((String)localObject1));
          }
        }
      }
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vYG, false))
      {
        localObject1 = this.mAppId;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppBrandCheckOnlineStatusTask", "invoke appId:%s", new Object[] { localObject1 });
        XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString(""), com.tencent.mm.plugin.appbrand.task.a.a.class, new com.tencent.mm.plugin.appbrand.task.a.1((String)localObject1));
      }
      MultiProcessMMKV.getMMKV(this.mAppId + "_wxa_voip").putBoolean("isCameraStart", false);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "reset appId:%s isCameraStart false", new Object[] { this.mAppId });
      AppMethodBeat.o(43906);
      return;
      com.tencent.mm.ae.d.h((kotlin.g.a.a)new d.b(d.bBL(), (QualitySession)localObject2, (AppBrandInitConfigWC)localObject1));
      break;
      label1154:
      i = 0;
      break label90;
      label1159:
      localObject1 = com.tencent.luggage.sdk.e.g.cCT;
      localObject1 = u.a.pUI;
      com.tencent.luggage.sdk.e.g.Sr();
      break label341;
      label1175:
      ((com.tencent.luggage.game.e.a)localObject1).csG = 1000;
      break label475;
      label1186:
      bool = false;
      break label750;
      label1192:
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "onCreate appId:%s, skip initFloatBallHelper(), maybe under preRender mode", new Object[] { this.mAppId });
      break label838;
      label1215:
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "onCreate appId:%s, skip initMultiTaskHelper(), maybe under preRender mode", new Object[] { this.mAppId });
    }
  }
  
  public final void onDestroy()
  {
    int j = 1;
    AppMethodBeat.i(43914);
    if (((AppBrandInitConfigWC)super.Sk()).nYv != null)
    {
      ??? = ((AppBrandInitConfigWC)super.Sk()).nYv;
      if ((AndroidContextUtil.castActivityOrNull(this.mContext) == null) || (!AndroidContextUtil.castActivityOrNull(this.mContext).isFinishing())) {
        break label269;
      }
    }
    int i;
    Object localObject2;
    Object localObject5;
    label269:
    for (boolean bool = true;; bool = false)
    {
      ((WeAppOpenUICallbackIPCProxy)???).iT(bool);
      super.onDestroy();
      MMToClientEvent.h((com.tencent.mm.plugin.appbrand.service.c)super.QW());
      MMToClientEvent.agL("Common_IPC_appid");
      com.tencent.mm.plugin.appbrand.e.a.S(this);
      com.tencent.mm.plugin.appbrand.report.quality.b.K(this);
      if (this.nww != 0)
      {
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.nww);
        this.nww = 0;
      }
      if (!DebuggerShell.bLS()) {
        break;
      }
      if (this.nwz != null) {
        this.nwz.stopTimer();
      }
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(160526);
          AppBrandPerformanceManager.n(t.this);
          AppMethodBeat.o(160526);
        }
      });
      com.tencent.mm.plugin.appbrand.performance.b.amc(this.mAppId);
      ??? = this.mAppId;
      i = 0;
      while (i < 2)
      {
        localObject2 = new String[] { "Needjs", "Needwebviewjs" }[i];
        localObject2 = (String)??? + "-" + (String)localObject2;
        localObject5 = MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.ForceOpenAppNotify.TestInjectJsPath", 2).getString((String)localObject2, null);
        if (!TextUtils.isEmpty((CharSequence)localObject5)) {
          com.tencent.mm.vfs.u.deleteFile((String)localObject5);
        }
        MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.ForceOpenAppNotify.TestInjectJsPath", 2).remove((String)localObject2);
        i += 1;
      }
    }
    if (Qv()) {
      com.tencent.mm.plugin.appbrand.game.preload.d.y(this);
    }
    ??? = AppBrandMusicClientService.qdk;
    ((AppBrandMusicClientService)???).qdj.clear();
    ((AppBrandMusicClientService)???).qdl = "";
    s.remove(this.mAppId);
    com.tencent.mm.plugin.appbrand.media.record.c.onDestroy();
    hg(true);
    if (this.nwJ != null) {
      this.nwJ.qpm.clear();
    }
    d.b(this);
    ??? = this.nwt;
    if (??? != null)
    {
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).sessionId = ((AppBrandInitConfigWC)super.Sk()).cwP;
      s.abV(this.mAppId);
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).networkType = com.tencent.mm.plugin.appbrand.report.j.getNetworkType(MMApplicationContext.getContext());
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).appId = this.mAppId;
      if (bDx() != null) {
        break label861;
      }
      i = ((AppBrandInitConfigWC)super.Sk()).appVersion;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).appVersion = i;
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).fvc = (this.ntz.cBI + 1);
      ((com.tencent.mm.plugin.appbrand.report.model.n)???).scene = Sk().cxf.scene;
      if (((com.tencent.mm.plugin.appbrand.report.model.n)???).qLI)
      {
        i = 1;
        label459:
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).qLJ = i;
        if (!WebView.isX5()) {
          break label880;
        }
        i = j;
        label473:
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).qLK = i;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).qLL = Util.ticksToNow(((com.tencent.mm.plugin.appbrand.report.model.n)???).qLH);
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).qLM = Util.nowMilliSecond();
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).username = ((AppBrandInitConfigWC)super.Sk()).username;
        localObject2 = com.tencent.mm.plugin.appbrand.report.quality.b.amO(this.mAppId);
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).nMB = ((QualitySessionRuntime)localObject2).apptype;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).cBH = ((QualitySessionRuntime)localObject2).cBH;
        ((com.tencent.mm.plugin.appbrand.report.model.n)???).report();
        com.tencent.mm.plugin.appbrand.ui.recommend.e.P(this);
        this.nwt = null;
        this.nwv = false;
        this.nwA = null;
        if (this.nwE != null)
        {
          ??? = this.nwE;
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "onDestroy");
          ((com.tencent.mm.plugin.appbrand.ad.h)???).acn("onDestroy");
          ((com.tencent.mm.plugin.appbrand.ad.h)???).nAM = null;
          this.nwE = null;
        }
        this.nwO.clear();
        this.nwy.clear();
        if (this.nwL != null)
        {
          this.nwL.dead();
          this.nwL = null;
        }
        if (this.nwC != null)
        {
          this.nwC.x(this);
          this.nwC = null;
        }
        ??? = this.nws;
        ((com.tencent.mm.plugin.appbrand.jsapi.x.a)???).pne.pnf.clear();
        synchronized (((com.tencent.mm.plugin.appbrand.jsapi.x.a)???).pnd)
        {
          ((SparseArray)???).clear();
          localObject2 = kotlin.x.aazN;
          com.tencent.mm.plugin.appbrand.jsapi.ai.b.d.release();
          n.f(this);
          ??? = this.nwF;
          if (??? == null) {
            break label920;
          }
          kotlin.g.b.p.k(this, "runtime");
          localObject2 = ((b)???).nsn;
          if (localObject2 != null) {
            ((com.tencent.mm.appbrand.v8.m)localObject2).destroy();
          }
          ((b)???).nsn = null;
          ((b)???).nsm.clear();
          ((b)???).nsp = new kotlin.o(Long.valueOf(-1L), Long.valueOf(-1L));
          ((b)???).nso = null;
          localObject2 = QW();
          if (localObject2 == null) {
            break label920;
          }
          localObject2 = ((v)localObject2).bEb();
          if (localObject2 == null) {
            break label920;
          }
          localObject5 = (ab.a)???;
          if (localObject5 == null) {
            break;
          }
        }
      }
      synchronized (((ab)localObject2).nxV)
      {
        ((ab)localObject2).nxV.remove(localObject5);
        AppMethodBeat.o(43914);
        return;
        label861:
        i = bDx().nYR.pkgVersion;
        continue;
        i = 0;
        break label459;
        label880:
        i = 0;
        break label473;
        localObject3 = finally;
        AppMethodBeat.o(43914);
        throw localObject3;
      }
    }
    AppMethodBeat.o(43914);
    return;
    label920:
    AppMethodBeat.o(43914);
  }
  
  public final void onEnterAnimationComplete()
  {
    AppMethodBeat.i(174690);
    if ((this.ntU.get()) || (this.aol))
    {
      AppMethodBeat.o(174690);
      return;
    }
    O(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(272629);
        ((QualitySessionRuntime)Objects.requireNonNull(com.tencent.mm.plugin.appbrand.report.quality.b.amO(t.this.mAppId))).qNF = this.nxc;
        AppMethodBeat.o(272629);
      }
    });
    aa localaa = super.bCz();
    if ((localaa instanceof com.tencent.mm.plugin.appbrand.ui.ad)) {
      ((com.tencent.mm.plugin.appbrand.ui.ad)localaa).setCanShowHideAnimation(true);
    }
    if ((localaa instanceof com.tencent.mm.plugin.appbrand.ui.k)) {
      ((com.tencent.mm.plugin.appbrand.ui.k)localaa).setLoadingIconVisibility(true);
    }
    if (AndroidContextUtil.castActivityOrNull(this.mContext) != null) {
      com.tencent.mm.ui.statusbar.c.bA(AndroidContextUtil.castActivityOrNull(this.mContext)).hXX();
    }
    if (((AppBrandInitConfigWC)super.Sk()).nYv != null) {
      ((AppBrandInitConfigWC)super.Sk()).nYv.pXR.b((Parcelable)new IPCVoid());
    }
    AppMethodBeat.o(174690);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(43912);
    super.onPause();
    new AppBrandNotifyPauseTask(com.tencent.luggage.sdk.processes.main.a.d(this)).bsM();
    Object localObject;
    if (this.nwC != null)
    {
      localObject = this.nwC;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFloatBallLogic", "pause, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olg != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olg.aOj();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olh != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olh.aOj();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).oli != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).oli.aOj();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olk != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olk.aOj();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olj != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olj.aOj();
      }
    }
    if (this.nwD != null)
    {
      localObject = this.nwD;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "pause, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.q.c)localObject).qib != null) {
        ((com.tencent.mm.plugin.appbrand.q.c)localObject).qib.aOj();
      }
    }
    bDk().bDR();
    AppMethodBeat.o(43912);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(43911);
    super.onResume();
    s.abW(this.mAppId).lastResumeTime = System.currentTimeMillis();
    Object localObject;
    if (this.nwC != null)
    {
      localObject = this.nwC;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFloatBallLogic", "resume, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olg != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olg.bNV();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olh != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olh.bNV();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).oli != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).oli.bNV();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olk != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olk.bNV();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olj != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.c)localObject).olj.bNV();
      }
    }
    if (this.nwD != null)
    {
      localObject = this.nwD;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "resume, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.q.c)localObject).qib != null)
      {
        ((com.tencent.mm.plugin.appbrand.q.c)localObject).qib.bNV();
        if (((AppBrandInitConfigWC)super.Sk()).nBI == null) {
          break label351;
        }
        ((com.tencent.mm.plugin.appbrand.q.c)localObject).qib.b(((AppBrandInitConfigWC)super.Sk()).nBI.nBo);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "setMultiTaskCommonInfo not null");
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k.a(this.mAppId, bCi(), Sk().cxf);
      d.setRuntime(this);
      com.tencent.mm.plugin.appbrand.e.a.R(this);
      bDr();
      if (this.ntW) {
        ((com.tencent.mm.plugin.appbrand.page.y)super.bBX()).getReporter().caU();
      }
      y.a.chL().cD(this.mAppId, Sk().cxf.scene);
      localObject = w.a(this, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(160525);
          AppBrandSysConfigWC localAppBrandSysConfigWC = t.this.bDx();
          WxaMenuHelper.GetCopyPathMenuExpireTimeTask localGetCopyPathMenuExpireTimeTask = new WxaMenuHelper.GetCopyPathMenuExpireTimeTask(t.this.mAppId);
          localGetCopyPathMenuExpireTimeTask.bPu();
          localAppBrandSysConfigWC.cxK = WxaMenuHelper.GetCopyPathMenuExpireTimeTask.a(localGetCopyPathMenuExpireTimeTask);
          AppMethodBeat.o(160525);
        }
      });
      keep((com.tencent.mm.vending.e.a)localObject);
      com.tencent.e.h.ZvG.d((Runnable)localObject, "getCopyPathMenuExpireTime");
      com.tencent.mm.plugin.appbrand.ipc.c.connect();
      if (bDv() == null) {
        break;
      }
      bDk().abX(bDv().oxe);
      AppMethodBeat.o(43911);
      return;
      label351:
      ((com.tencent.mm.plugin.appbrand.q.c)localObject).qib.b(null);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "setMultiTaskCommonInfo null enter scene:%d", new Object[] { Integer.valueOf(Sk().cxf.scene) });
      if ((Sk().cxf.scene == 1089) || (Sk().cxf.scene == 1104)) {
        ((com.tencent.mm.plugin.appbrand.q.c)localObject).qib.FHw = Boolean.TRUE;
      } else {
        ((com.tencent.mm.plugin.appbrand.q.c)localObject).qib.FHw = Boolean.FALSE;
      }
    }
    com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "onResume, try upsertHandOff but get NULL PageView, appId:%s", new Object[] { this.mAppId });
    AppMethodBeat.o(43911);
  }
  
  public String toString()
  {
    AppMethodBeat.i(43886);
    String str = String.format(Locale.ENGLISH, "[AppBrandRuntimeWC::%s::%s::%d::@%d]", new Object[] { this.mAppId, bDg(), Integer.valueOf(this.ntz.cBI), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(43886);
    return str;
  }
  
  public final void yL(int paramInt)
  {
    AppMethodBeat.i(43932);
    aa localaa = super.bCz();
    if ((localaa instanceof com.tencent.mm.plugin.appbrand.launching.p)) {
      ((com.tencent.mm.plugin.appbrand.launching.p)localaa).yL(paramInt);
    }
    AppMethodBeat.o(43932);
  }
  
  final class b
    extends AppBrandRuntime.b
  {
    volatile AppBrandPrepareTask nxl;
    volatile boolean nxm = false;
    
    private b() {}
    
    public final void interrupt()
    {
      AppMethodBeat.i(43884);
      this.nxm = true;
      AppBrandPrepareTask localAppBrandPrepareTask = this.nxl;
      if (localAppBrandPrepareTask != null) {
        localAppBrandPrepareTask.interrupt();
      }
      AppMethodBeat.o(43884);
    }
    
    public final void prepare()
    {
      AppMethodBeat.i(43883);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| ResourcePrepareProcess.prepare() appId:%s", new Object[] { t.this.mAppId });
      com.tencent.mm.plugin.appbrand.launching.f.a(t.this, new kotlin.g.a.b()
      {
        private kotlin.x bDS()
        {
          AppMethodBeat.i(162153);
          if (!t.b.this.nxm) {}
          try
          {
            t.b.this.nxl = t.b(t.this, t.b.this);
            kotlin.x localx = kotlin.x.aazN;
            AppMethodBeat.o(162153);
            return localx;
          }
          catch (NullPointerException localNullPointerException)
          {
            while (t.this.ntU.get()) {}
            AppMethodBeat.o(162153);
            throw localNullPointerException;
          }
        }
      });
      AppMethodBeat.o(43883);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t
 * JD-Core Version:    0.7.0.1
 */