package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
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
import com.tencent.luggage.sdk.config.LaunchWxaAppInfoParcelized;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.luggage.sdk.processes.main.LuggageClearDuplicatedTask;
import com.tencent.luggage.sdk.processes.main.LuggageRemoveTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.sr;
import com.tencent.mm.autogen.mmdata.rpt.sr.a;
import com.tencent.mm.autogen.mmdata.rpt.tt;
import com.tencent.mm.autogen.mmdata.rpt.tt.a;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.ad.h.1;
import com.tencent.mm.plugin.appbrand.ad.h.2;
import com.tencent.mm.plugin.appbrand.api.ParcelableMultiTaskData;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.NotifyWxaCommLibUpdatedEvent;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader.a;
import com.tencent.mm.plugin.appbrand.appstorage.ag.a;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.b.e;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.floatball.d.3;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.EventLocationBackgroundStateChanged;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.jsapi.file.ax;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent;
import com.tencent.mm.plugin.appbrand.launching.AppBrandCgiPrefetchApi;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy;
import com.tencent.mm.plugin.appbrand.launching.h.b;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.message.WxaAppMsgChannel;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ai;
import com.tencent.mm.plugin.appbrand.page.bv;
import com.tencent.mm.plugin.appbrand.page.ch;
import com.tencent.mm.plugin.appbrand.page.f.b;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.g.a;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.d.c;
import com.tencent.mm.plugin.appbrand.report.z.a;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.ipc.AppBrandNotifyPauseTask;
import com.tencent.mm.plugin.appbrand.task.ipc.AppBrandRegisterTask;
import com.tencent.mm.plugin.appbrand.task.ipc.AppBrandRuntimePreloadNextInvoke;
import com.tencent.mm.plugin.appbrand.task.ipc.AppBrandUpdateTask;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.appbrand.ui.ag;
import com.tencent.mm.plugin.appbrand.ui.ak;
import com.tencent.mm.plugin.appbrand.utils.ab;
import com.tencent.mm.plugin.appbrand.widget.AppBrandGlobalNativeWidgetContainerView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandGlobalNativeWidgetContainerView.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.AppBrandGameEvaluateOptionView;
import com.tencent.mm.plugin.appbrand.widget.dialog.AppBrandGameEvaluateOptionView.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.1;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.12;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.15;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.16;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.17;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.18;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.19;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.2;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.20;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.21;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.3;
import com.tencent.mm.protocal.protobuf.glo;
import com.tencent.mm.protocal.protobuf.gnm;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.aw;
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

public class w
  extends com.tencent.luggage.sdk.e.d
  implements com.tencent.luggage.sdk.h.d.a, com.tencent.mm.plugin.appbrand.launching.q
{
  public static final boolean qvw;
  public boolean qvA;
  private int qvB;
  private boolean qvC;
  private final List<ao> qvD;
  private MTimerHandler qvE;
  volatile p qvF;
  private Configuration qvG;
  private com.tencent.mm.plugin.appbrand.floatball.d qvH;
  private com.tencent.mm.plugin.appbrand.r.c qvI;
  public com.tencent.mm.plugin.appbrand.ad.h qvJ;
  public b qvK;
  private com.tencent.luggage.sdk.e.f<AppBrandInitConfigWC> qvL;
  private final com.tencent.mm.plugin.appbrand.report.r qvM;
  public com.tencent.mm.plugin.appbrand.widget.d.d qvN;
  public final com.tencent.mm.plugin.appbrand.widget.d qvO;
  public final al qvP;
  private com.tencent.mm.plugin.appbrand.page.f qvQ;
  com.tencent.mm.plugin.appbrand.report.model.u qvR;
  public IListener<NotifyWxaCommLibUpdatedEvent> qvS;
  private v qvT;
  private com.tencent.mm.plugin.appbrand.l.b qvU;
  public final com.tencent.mm.plugin.appbrand.task.k qvV;
  private final Queue<Runnable> qvW;
  private com.tencent.mm.plugin.appbrand.platform.window.f qvX;
  public final AppBrandCgiPrefetchApi qvv;
  public final com.tencent.mm.plugin.appbrand.jsapi.aa.a qvx;
  private volatile com.tencent.mm.plugin.appbrand.report.model.q qvy;
  public final r qvz;
  
  static
  {
    AppMethodBeat.i(43955);
    if ((BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()) || (DebuggerShell.cls()) || (com.tencent.mm.protocal.d.Yxk) || (com.tencent.mm.protocal.d.Yxl)) {}
    for (boolean bool = true;; bool = false)
    {
      qvw = bool;
      AppMethodBeat.o(43955);
      return;
    }
  }
  
  public w(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    super(paramAppBrandRuntimeContainerWC);
    AppMethodBeat.i(174681);
    this.qvv = new AppBrandCgiPrefetchApi();
    this.qvx = new com.tencent.mm.plugin.appbrand.jsapi.aa.a();
    this.qvB = 0;
    this.qvD = new LinkedList();
    this.qvE = null;
    this.qvN = new com.tencent.mm.plugin.appbrand.widget.d.d(this);
    this.qvO = new com.tencent.mm.plugin.appbrand.widget.d(this);
    this.qvP = new al(this);
    Assert.assertTrue("AppBrandRuntimeWC's initial context should be AppBrandRuntimePersistentContextWrapper", this.mContext instanceof com.tencent.mm.plugin.appbrand.ui.o);
    this.qvz = new r();
    this.qvM = new com.tencent.mm.plugin.appbrand.report.r();
    this.qsQ = qvw;
    this.qvV = new com.tencent.mm.plugin.appbrand.task.k()
    {
      public final void close()
      {
        AppMethodBeat.i(316657);
        if (w.this.mResumed) {
          w.this.close();
        }
        AppMethodBeat.o(316657);
      }
      
      public final void onNetworkChange()
      {
        AppMethodBeat.i(316662);
        com.tencent.mm.plugin.appbrand.networking.d locald = (com.tencent.mm.plugin.appbrand.networking.d)w.this.ax(com.tencent.mm.plugin.appbrand.networking.d.class);
        if ((locald instanceof com.tencent.mm.plugin.appbrand.networking.g)) {
          ((com.tencent.mm.plugin.appbrand.networking.g)locald).cCS();
        }
        AppMethodBeat.o(316662);
      }
    };
    this.qvW = new LinkedBlockingQueue();
    a(paramAppBrandRuntimeContainerWC);
    AppMethodBeat.o(174681);
  }
  
  public w(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(316679);
    this.qvv = new AppBrandCgiPrefetchApi();
    this.qvx = new com.tencent.mm.plugin.appbrand.jsapi.aa.a();
    this.qvB = 0;
    this.qvD = new LinkedList();
    this.qvE = null;
    this.qvN = new com.tencent.mm.plugin.appbrand.widget.d.d(this);
    this.qvO = new com.tencent.mm.plugin.appbrand.widget.d(this);
    this.qvP = new al(this);
    Assert.assertTrue("AppBrandRuntimeWC's initial context should be AppBrandRuntimePersistentContextWrapper", this.mContext instanceof com.tencent.mm.plugin.appbrand.ui.o);
    this.qvz = new r();
    this.qvM = new com.tencent.mm.plugin.appbrand.report.r();
    this.qsQ = qvw;
    this.qvV = new com.tencent.mm.plugin.appbrand.task.k()
    {
      public final void close()
      {
        AppMethodBeat.i(316657);
        if (w.this.mResumed) {
          w.this.close();
        }
        AppMethodBeat.o(316657);
      }
      
      public final void onNetworkChange()
      {
        AppMethodBeat.i(316662);
        com.tencent.mm.plugin.appbrand.networking.d locald = (com.tencent.mm.plugin.appbrand.networking.d)w.this.ax(com.tencent.mm.plugin.appbrand.networking.d.class);
        if ((locald instanceof com.tencent.mm.plugin.appbrand.networking.g)) {
          ((com.tencent.mm.plugin.appbrand.networking.g)locald).cCS();
        }
        AppMethodBeat.o(316662);
      }
    };
    this.qvW = new LinkedBlockingQueue();
    a(null);
    AppMethodBeat.o(316679);
  }
  
  private static void b(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(316732);
    try
    {
      com.tencent.luggage.sdk.launching.d.a(paramAppBrandInitConfigWC.eph);
      com.tencent.luggage.sdk.launching.d.a(paramAppBrandInitConfigWC.epg);
      if (paramAppBrandInitConfigWC.qYw != null) {
        paramAppBrandInitConfigWC.qYw.cAB();
      }
      return;
    }
    finally
    {
      paramAppBrandInitConfigWC.eph = null;
      paramAppBrandInitConfigWC.epg = null;
      paramAppBrandInitConfigWC.qYw = null;
      AppMethodBeat.o(316732);
    }
  }
  
  private void ccC()
  {
    AppMethodBeat.i(43896);
    if (!qvw)
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
      localObject = this.mAppId + ":" + ((AppBrandInitConfigWC)super.asA()).hEy;
      this.qsk.setContentDescription((CharSequence)localObject);
      AppMethodBeat.o(43896);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(43896);
    }
  }
  
  private int ccF()
  {
    AppMethodBeat.i(316698);
    int i = -1;
    ICommLibReader localICommLibReader = hW(false);
    if (localICommLibReader != null) {
      i = localICommLibReader.cfG();
    }
    AppMethodBeat.o(316698);
    return i;
  }
  
  private void ccG()
  {
    AppMethodBeat.i(316702);
    new AppBrandUpdateTask(this, ccF()).bQt();
    AppMethodBeat.o(316702);
  }
  
  private void ccH()
  {
    AppMethodBeat.i(316709);
    if ((ccB()) || (bj.x(this)))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "initFloatBallHelper appId[%s], skip fakeNative", new Object[] { this.mAppId });
      AppMethodBeat.o(316709);
      return;
    }
    if (this.qvH != null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "initFloatBallHelper, destroy");
      this.qvH.D(this);
    }
    this.qvH = new com.tencent.mm.plugin.appbrand.floatball.d(this);
    this.qvH.C(this);
    AppMethodBeat.o(316709);
  }
  
  private void ccI()
  {
    AppMethodBeat.i(316712);
    if ((ccB()) || (bj.x(this)))
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "initMultiTaskHelper appId[%s], skip fakeNative", new Object[] { this.mAppId });
      AppMethodBeat.o(316712);
      return;
    }
    if (this.qvI != null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "initMultiTaskHelper, destroy");
      com.tencent.mm.plugin.appbrand.r.c.D(this);
    }
    this.qvI = new com.tencent.mm.plugin.appbrand.r.c();
    this.qvI.C(this);
    AppMethodBeat.o(316712);
  }
  
  private boolean ccL()
  {
    AppMethodBeat.i(316715);
    com.tencent.mm.plugin.appbrand.b.c localc = this.qsB;
    if (localc == null)
    {
      AppMethodBeat.o(316715);
      return false;
    }
    boolean bool = localc.qKC.chF();
    AppMethodBeat.o(316715);
    return bool;
  }
  
  private void ccP()
  {
    AppMethodBeat.i(316718);
    if ((((AppBrandInitConfigWC)super.asA()).qAT.isEnable()) || (((AppBrandInitConfigWC)super.asA()).qYv)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (AndroidContextUtil.castActivityOrNull(this.mContext) != null))
      {
        this.qvL = new com.tencent.mm.plugin.appbrand.widget.d.a(this, AndroidContextUtil.castActivityOrNull(this.mContext), super.getWindowAndroid());
        if ((com.tencent.mm.plugin.appbrand.service.c)super.ari() != null) {
          ((com.tencent.mm.plugin.appbrand.service.c)super.ari()).a(getWindowAndroid());
        }
        com.tencent.mm.plugin.appbrand.page.ah localah = ccK();
        if (localah != null) {
          localah.a(getWindowAndroid());
        }
      }
      AppMethodBeat.o(316718);
      return;
    }
  }
  
  public static int ccU()
  {
    AppMethodBeat.i(316725);
    int i = com.tencent.mm.plugin.appbrand.ad.b.cdR();
    AppMethodBeat.o(316725);
    return i;
  }
  
  public static int ccV()
  {
    AppMethodBeat.i(316727);
    int i = com.tencent.mm.plugin.appbrand.ad.b.cdR();
    AppMethodBeat.o(316727);
    return i;
  }
  
  private void ccy()
  {
    AppMethodBeat.i(316689);
    boolean bool = Util.nullAs((Boolean)com.tencent.luggage.sdk.h.d.b("AppBrandRuntimeProfile|isFoldableDevice", new kotlin.g.a.a() {}), false);
    if ((getWindowAndroid().asu()) || (bool))
    {
      this.qvL = new com.tencent.mm.plugin.appbrand.ui.b(this, (Context)Objects.requireNonNull(AndroidContextUtil.castActivityOrNull(this.mContext)), getWindowAndroid().getOrientationHandler(), super.getWindowAndroid());
      AppMethodBeat.o(316689);
      return;
    }
    this.qvL = new com.tencent.luggage.sdk.e.e();
    AppMethodBeat.o(316689);
  }
  
  private ICommLibReader hW(boolean paramBoolean)
  {
    AppMethodBeat.i(43890);
    Object localObject = (ICommLibReader)super.ax(ICommLibReader.class);
    if ((localObject == null) && (paramBoolean))
    {
      localObject = new ICommLibReader.a();
      AppMethodBeat.o(43890);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(43890);
    return localObject;
  }
  
  private void yT(int paramInt)
  {
    AppMethodBeat.i(43929);
    r.a(paramInt, (AppBrandInitConfigWC)super.asA());
    AppMethodBeat.o(43929);
  }
  
  protected final boolean S(Runnable paramRunnable)
  {
    AppMethodBeat.i(316956);
    if ((super.cbM() instanceof ag))
    {
      i(paramRunnable, 3000L);
      AppMethodBeat.o(316956);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yWA, false))
    {
      boolean bool = getAppConfig().qVO;
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "manualHideSplash:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(316956);
      return bool;
    }
    AppMethodBeat.o(316956);
    return false;
  }
  
  public final boolean T(Runnable paramRunnable)
  {
    AppMethodBeat.i(316939);
    if ((!isInBackStack()) && (!d.a(this)) && (!ccL())) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "[wxa_reload]recycleRuntime %s, recycle[%b]", new Object[] { toString(), Boolean.valueOf(bool) });
      if (bool) {
        Y(paramRunnable);
      }
      AppMethodBeat.o(316939);
      return bool;
    }
  }
  
  public final void Y(final Runnable paramRunnable)
  {
    AppMethodBeat.i(316832);
    if (paramRunnable != null) {
      this.qsB.a(new com.tencent.mm.plugin.appbrand.b.c.a()
      {
        public final void onRunningStateChanged(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
        {
          AppMethodBeat.i(174676);
          if (com.tencent.mm.plugin.appbrand.b.b.qKz == paramAnonymousb) {
            paramRunnable.run();
          }
          AppMethodBeat.o(174676);
        }
      });
    }
    finish();
    AppMethodBeat.o(316832);
  }
  
  public final void Z(final Runnable paramRunnable)
  {
    AppMethodBeat.i(43923);
    V(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174673);
        if (w.this.qsE.get())
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "startPrepareOrientation, finished appId[%s]", new Object[] { w.this.mAppId });
          AppMethodBeat.o(174673);
          return;
        }
        w.a(w.this, new e.a()
        {
          public final void onOrientationChanged(e.b paramAnonymous2b, boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(316807);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "startPrepareOrientation, onOrientationChanged appId[%s], orientation[%s] success[%b]", new Object[] { w.this.mAppId, paramAnonymous2b, Boolean.valueOf(paramAnonymous2Boolean) });
            if (w.13.this.qwh != null) {
              w.13.this.qwh.run();
            }
            AppMethodBeat.o(316807);
          }
        }, w.s(w.this));
        AppMethodBeat.o(174673);
      }
    });
    AppMethodBeat.o(43923);
  }
  
  public final void a(ap paramap)
  {
    AppMethodBeat.i(43891);
    paramap = (AppBrandRuntimeContainerWC)paramap;
    super.a(paramap);
    if (paramap == null)
    {
      this.qsI = null;
      this.mContext = com.tencent.mm.plugin.appbrand.ui.o.fj(MMApplicationContext.getContext());
      if ((com.tencent.mm.plugin.appbrand.service.c)super.ari() != null) {
        ((com.tencent.mm.plugin.appbrand.service.c)super.ari()).a(null);
      }
      if ((com.tencent.mm.plugin.appbrand.page.y)super.getPageContainer() != null) {
        com.tencent.mm.plugin.appbrand.page.z.c((com.tencent.mm.plugin.appbrand.page.y)super.getPageContainer());
      }
      if (this.qsM != null) {
        com.tencent.mm.plugin.appbrand.pip.e.a(this.qsM, null);
      }
      if (this.qsp != null) {
        this.qsp.ff(MMApplicationContext.getContext());
      }
      this.qvL = new com.tencent.luggage.sdk.e.e();
      AppMethodBeat.o(43891);
      return;
    }
    ((com.tencent.mm.plugin.appbrand.ui.o)this.mContext).setBaseContext(AndroidContextUtil.castActivityOrNull(paramap.mContext));
    if (this.qsp != null) {
      this.qsp.ff((Context)Objects.requireNonNull(AndroidContextUtil.castActivityOrNull(paramap.mContext)));
    }
    ccy();
    if ((com.tencent.mm.plugin.appbrand.service.c)super.ari() != null) {
      ((com.tencent.mm.plugin.appbrand.service.c)super.ari()).a(getWindowAndroid());
    }
    com.tencent.mm.plugin.appbrand.page.ah localah = ccK();
    if (localah != null)
    {
      localah.a(getWindowAndroid());
      ((com.tencent.mm.plugin.appbrand.page.y)super.getPageContainer()).k(localah);
    }
    if (this.qsM != null) {
      com.tencent.mm.plugin.appbrand.pip.e.a(this.qsM, getWindowAndroid());
    }
    this.qvG = new Configuration(AppBrandUI.M(paramap.qud.getActivity()));
    if ((this.qvH == null) && (this.mInitialized))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "setRuntimeContainer != NULL, appId:%s, retry initFloatBallHelper", new Object[] { this.mAppId });
      ccH();
    }
    if ((this.qvI == null) && (this.mInitialized))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "setRuntimeContainer != NULL, appId:%s, retry initMultiTaskHelper", new Object[] { this.mAppId });
      ccI();
    }
    AppMethodBeat.o(43891);
  }
  
  public final void a(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(43924);
    Object localObject = (AppBrandInitConfigWC)super.asA();
    AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    if ((localObject != paramAppBrandInitConfig) && (localAppBrandInitConfigWC.epn.scene == 1038)) {
      localAppBrandInitConfigWC.qYi = null;
    }
    if (((AppBrandInitConfigWC)localObject).qYv) {
      localAppBrandInitConfigWC.qYv = true;
    }
    super.a(paramAppBrandInitConfig);
    int i;
    if ((((AppBrandInitConfigWC)super.asA()).launchMode != ((AppBrandInitConfigWC)localObject).launchMode) && ((((AppBrandInitConfigWC)super.asA()).launchMode == 1) || (((AppBrandInitConfigWC)localObject).launchMode == 1)))
    {
      i = 1;
      if (i != 0) {
        cbJ();
      }
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "updateConfig %s, willRestart[%b], willRelaunch[%b], destroyed[%b], scene[%d], lastLaunchMode[%d], currentLaunchMode[%d], instanceId[%s], sessionId[%s]", new Object[] { this, Boolean.valueOf(this.qsF), Boolean.valueOf(this.qsG), Boolean.valueOf(this.qsE.get()), Integer.valueOf(asA().epn.scene), Integer.valueOf(((AppBrandInitConfigWC)localObject).launchMode), Integer.valueOf(((AppBrandInitConfigWC)super.asA()).launchMode), ((AppBrandInitConfigWC)paramAppBrandInitConfig).eoQ, ((AppBrandInitConfigWC)paramAppBrandInitConfig).eoP });
      OpenBusinessViewUtil.K(this);
      if ((this.qsF) || (this.qsE.get())) {
        break label894;
      }
      if (!org.apache.commons.c.i.qA(localAppBrandInitConfigWC.eoQ, ((AppBrandInitConfigLU)localObject).eoQ))
      {
        if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED)) {
          break label416;
        }
        Assert.fail(String.format("updateConfig %s instanceId should not have been changed[%s]->[%s]", new Object[] { this, ((AppBrandInitConfigLU)localObject).eoQ, localAppBrandInitConfigWC.eoQ }));
      }
    }
    for (;;)
    {
      ((QualitySessionRuntime)Objects.requireNonNull(com.tencent.mm.plugin.appbrand.report.quality.b.afZ(this.mAppId))).tSj = false;
      com.tencent.mm.plugin.appbrand.report.quality.f.a(this, true, com.tencent.mm.plugin.appbrand.utils.f.agB(((AppBrandInitConfigWC)super.asA()).qYj));
      com.tencent.mm.plugin.ad.a.b(this.mAppId, ((AppBrandInitConfigWC)super.asA()).qYg);
      paramAppBrandInitConfig = this.qvD.iterator();
      while (paramAppBrandInitConfig.hasNext()) {
        ((ao)paramAppBrandInitConfig.next()).e((AppBrandInitConfigWC)super.asA());
      }
      i = 0;
      break;
      label416:
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntimeWC", "updateConfig %s, newConfig.instanceId changed, reset [%s]->[%s]", new Object[] { this, localAppBrandInitConfigWC.eoQ, ((AppBrandInitConfigLU)localObject).eoQ });
      localAppBrandInitConfigWC.fk(((AppBrandInitConfigLU)localObject).eoQ);
    }
    if ((com.tencent.mm.plugin.appbrand.page.y)super.getPageContainer() != null)
    {
      paramAppBrandInitConfig = (com.tencent.mm.plugin.appbrand.page.y)super.getPageContainer();
      paramAppBrandInitConfig.getReporter().aqI();
      paramAppBrandInitConfig.tws = false;
      paramAppBrandInitConfig.twt = false;
      paramAppBrandInitConfig.twu = false;
      paramAppBrandInitConfig.twz = null;
    }
    paramAppBrandInitConfig = (AppBrandInitConfigWC)super.asA();
    localObject = ccM();
    AppBrandStatObject localAppBrandStatObject = asA().epn;
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandTaskUsageRecorder", "updateUsage, appId %s, type %d", new Object[] { paramAppBrandInitConfig.appId, Integer.valueOf(paramAppBrandInitConfig.eul) });
    String str = paramAppBrandInitConfig.eoP;
    new AppBrandTaskUsageRecorder.UpdateTask(new AppBrandTaskUsageRecorder.LaunchCheckParams(paramAppBrandInitConfig, localAppBrandStatObject, ((AppBrandSysConfigWC)localObject).qYY.pkgVersion, hW(false).cfG(), str, paramAppBrandInitConfig.qYm)).bQt();
    ccC();
    ccP();
    paramAppBrandInitConfig = (AppBrandInitConfigWC)super.asA();
    if (paramAppBrandInitConfig != null)
    {
      this.qvL.b(paramAppBrandInitConfig);
      localObject = this.qvO;
      kotlin.g.b.s.u(paramAppBrandInitConfig, "initConfig");
      ((com.tencent.mm.plugin.appbrand.widget.d)localObject).n(paramAppBrandInitConfig);
    }
    localObject = this.qvP;
    kotlin.g.b.s.u(paramAppBrandInitConfig, "initConfigWC");
    int j;
    if (((CharSequence)((al)localObject).qxD).length() > 0)
    {
      j = 1;
      if ((j != 0) && (!paramAppBrandInitConfig.qAT.isEnable()) && (1038 != paramAppBrandInitConfig.epn.scene))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.EmbedHalfScreenWxaManager", "[onInitConfigUpdated] mark should re-show embedded wxa");
        ((al)localObject).qxE.set(true);
      }
      paramAppBrandInitConfig = this.qvM;
      kotlin.g.b.s.u(localAppBrandInitConfigWC, "newConfig");
      if (localAppBrandInitConfigWC.qAT.isEnable())
      {
        com.tencent.mm.plugin.appbrand.report.r.rG(1);
        if (localAppBrandInitConfigWC.epm != com.tencent.luggage.sdk.launching.e.etJ)
        {
          com.tencent.mm.plugin.appbrand.report.r.rG(6);
          if (paramAppBrandInitConfig.tOB) {
            com.tencent.mm.plugin.appbrand.report.r.rG(8);
          }
          if (!paramAppBrandInitConfig.tOD)
          {
            com.tencent.mm.plugin.appbrand.report.r.rG(7);
            if (paramAppBrandInitConfig.tOB) {
              com.tencent.mm.plugin.appbrand.report.r.rG(9);
            }
            paramAppBrandInitConfig.tOD = true;
          }
        }
      }
      if (i != 0) {
        com.tencent.mm.plugin.appbrand.report.r.rG(4);
      }
      if ((paramAppBrandInitConfig.tOC != localAppBrandInitConfigWC.qAT.isEnable()) && (localAppBrandInitConfigWC.epm != com.tencent.luggage.sdk.launching.e.etJ))
      {
        if (!localAppBrandInitConfigWC.qAT.isEnable()) {
          break label906;
        }
        com.tencent.mm.plugin.appbrand.report.r.rG(3);
      }
    }
    for (;;)
    {
      if (localAppBrandInitConfigWC.epm != com.tencent.luggage.sdk.launching.e.etJ) {
        paramAppBrandInitConfig.tOC = localAppBrandInitConfigWC.qAT.isEnable();
      }
      label894:
      AppMethodBeat.o(43924);
      return;
      j = 0;
      break;
      label906:
      com.tencent.mm.plugin.appbrand.report.r.rG(2);
    }
  }
  
  public final void a(AppBrandInitConfig paramAppBrandInitConfig, String paramString)
  {
    AppMethodBeat.i(316840);
    if (paramAppBrandInitConfig == null)
    {
      ((AppBrandInitConfigWC)super.asA()).aqI();
      ((AppBrandInitConfigWC)super.asA()).startTime = Util.nowMilliSecond();
      ((AppBrandInitConfigWC)super.asA()).qYu = new AppBrandRuntimeReloadReportBundle(((AppBrandInitConfigWC)super.asA()).qYm.eup, paramString);
      ((AppBrandInitConfigWC)super.asA()).qYm = new QualitySession(com.tencent.mm.plugin.appbrand.utils.f.DI(((AppBrandInitConfigWC)super.asA()).uin), (AppBrandInitConfigWC)super.asA(), asA().epn);
      ((AppBrandInitConfigWC)super.asA()).fk(((AppBrandInitConfigWC)super.asA()).qYm.eup);
    }
    super.ay(ICommLibReader.class);
    super.a(paramAppBrandInitConfig, paramString);
    AppMethodBeat.o(316840);
  }
  
  final void a(w.b paramb)
  {
    AppMethodBeat.i(317103);
    final AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.asA();
    if (localAppBrandInitConfigWC == null)
    {
      AppMethodBeat.o(317103);
      return;
    }
    if (w.b.qww == paramb)
    {
      b(localAppBrandInitConfigWC);
      AppMethodBeat.o(317103);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(317238);
        w.c(localAppBrandInitConfigWC);
        AppMethodBeat.o(317238);
      }
    });
    AppMethodBeat.o(317103);
  }
  
  public final void aa(Runnable paramRunnable)
  {
    AppMethodBeat.i(43935);
    paramRunnable = new w.a(this, paramRunnable);
    this.qvW.add(paramRunnable);
    super.U(paramRunnable);
    AppMethodBeat.o(43935);
  }
  
  public final boolean aqJ()
  {
    AppMethodBeat.i(370000);
    boolean bool = ((AppBrandInitConfigWC)super.asA()).aqJ();
    AppMethodBeat.o(370000);
    return bool;
  }
  
  public final boolean arD()
  {
    AppMethodBeat.i(370004);
    boolean bool = super.arD();
    AppMethodBeat.o(370004);
    return bool;
  }
  
  public final void asB()
  {
    AppMethodBeat.i(43934);
    super.asB();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] onInitBeforeComponentsInstalled, appId[%s] mPendingPermissionUpdateTasks.size=%d", new Object[] { this.mAppId, Integer.valueOf(this.qvW.size()) });
    while (!this.qvW.isEmpty()) {
      ((Runnable)this.qvW.remove()).run();
    }
    if (ccM().epC.eqm) {
      ccZ();
    }
    com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepPrepareRuntime);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup_Game);
    AppMethodBeat.o(43934);
  }
  
  public final aa asC()
  {
    AppMethodBeat.i(43930);
    com.tencent.mm.plugin.appbrand.performance.b.P(this);
    Object localObject = ((AppStartupPerformanceReportBundle)aN(AppStartupPerformanceReportBundle.class)).sYv;
    if (!Util.isNullOrNil((List)localObject))
    {
      localObject = ((List)localObject).iterator();
      for (long l = 0L; ((Iterator)localObject).hasNext(); l = Math.max(l, ((kv_14609)((Iterator)localObject).next()).tQz)) {}
      com.tencent.mm.plugin.appbrand.performance.b.a(this, l);
    }
    if (DebuggerShell.cls())
    {
      AppMethodBeat.o(43930);
      return null;
    }
    localObject = super.asC();
    AppMethodBeat.o(43930);
    return localObject;
  }
  
  public com.tencent.mm.plugin.appbrand.q.a asD()
  {
    AppMethodBeat.i(43922);
    com.tencent.mm.plugin.appbrand.q.a locala = super.asD();
    AppMethodBeat.o(43922);
    return locala;
  }
  
  public final String asQ()
  {
    AppMethodBeat.i(43885);
    String str = "AppBrandRuntimeWC@" + hashCode();
    AppMethodBeat.o(43885);
    return str;
  }
  
  public final void b(ICommLibReader paramICommLibReader)
  {
    AppMethodBeat.i(43888);
    if (hW(false) != null)
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
  
  public final boolean b(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(43925);
    paramAppBrandInitConfig = (AppBrandInitConfigWC)paramAppBrandInitConfig;
    AppBrandStatObject localAppBrandStatObject = paramAppBrandInitConfig.epn;
    boolean bool;
    if ((this.qvC) || (localAppBrandStatObject.scene == 1099))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] mShouldRelaunchCausedByFunctionalPageOpen[%b] newScene[%d]", new Object[] { this.mAppId, Boolean.valueOf(this.qvC), Integer.valueOf(localAppBrandStatObject.scene) });
      if (localAppBrandStatObject.scene == 1099) {}
      for (bool = true;; bool = false)
      {
        this.qvC = bool;
        AppMethodBeat.o(43925);
        return true;
      }
    }
    if ((TextUtils.isEmpty(paramAppBrandInitConfig.qAF)) && (an.u(this)))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] enterPath[%s], old is gameFunctionalPage", new Object[] { this.mAppId, paramAppBrandInitConfig.qAF });
      AppMethodBeat.o(43925);
      return true;
    }
    if (1038 == localAppBrandStatObject.scene)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. appId[%s], reason=1038 back from other MiniProgram", new Object[] { this.mAppId });
      AppMethodBeat.o(43925);
      return false;
    }
    if ((paramAppBrandInitConfig.epf) && ((org.apache.commons.c.i.hm(paramAppBrandInitConfig.qAF)) || (org.apache.commons.c.i.qA(paramAppBrandInitConfig.qAF, ((com.tencent.mm.plugin.appbrand.page.y)super.getPageContainer()).getCurrentUrl()))))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. appId:%s, by forceIndexNoReLaunch, url:%s", new Object[] { this.mAppId, paramAppBrandInitConfig.qAF });
      AppMethodBeat.o(43925);
      return false;
    }
    Assert.assertNotSame(com.tencent.luggage.sdk.launching.e.etK, paramAppBrandInitConfig.epm);
    if (((com.tencent.mm.plugin.appbrand.page.y)super.getPageContainer() != null) && (((com.tencent.mm.plugin.appbrand.page.y)super.getPageContainer()).cEr()))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true, appId[%s], coldStartMode:%s, hasHeadlessPage:true", new Object[] { this.mAppId, paramAppBrandInitConfig.epm });
      AppMethodBeat.o(43925);
      return true;
    }
    Iterator localIterator = this.qvD.iterator();
    while (localIterator.hasNext())
    {
      Boolean localBoolean = ((ao)localIterator.next()).d(paramAppBrandInitConfig);
      if (localBoolean != null)
      {
        bool = localBoolean.booleanValue();
        AppMethodBeat.o(43925);
        return bool;
      }
    }
    if (!TextUtils.isEmpty(paramAppBrandInitConfig.qAF))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] enterPath[%s]", new Object[] { this.mAppId, paramAppBrandInitConfig.qAF });
      AppMethodBeat.o(43925);
      return true;
    }
    if (((AppBrandInitConfigWC)super.asA()).qAT.isEnable() != paramAppBrandInitConfig.qAT.isEnable())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] halfScreenConfig enable change to:%b", new Object[] { this.mAppId, Boolean.valueOf(paramAppBrandInitConfig.qAT.isEnable()) });
      AppMethodBeat.o(43925);
      return true;
    }
    int i = localAppBrandStatObject.scene;
    if (org.apache.commons.c.a.contains(new int[] { 1001, 1003, 1023, 1038, 1056, 1080, 1083, 1089, 1090, 1103, 1104, 1113, 1114, 1117, 1131, 1019, 1112, 1127, 1134, 1187 }, i))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. keepNoRelaunch appId[%s] newScene[%d]", new Object[] { this.mAppId, Integer.valueOf(localAppBrandStatObject.scene) });
      AppMethodBeat.o(43925);
      return false;
    }
    if ((1030 == localAppBrandStatObject.scene) && (TextUtils.isEmpty(paramAppBrandInitConfig.qAF)))
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return false. special for monkey test appId[%s]", new Object[] { this.mAppId });
      AppMethodBeat.o(43925);
      return false;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "shouldRelaunch return true. appId[%s] fallback logic", new Object[] { this.mAppId });
    AppMethodBeat.o(43925);
    return true;
  }
  
  protected final void cbA()
  {
    AppMethodBeat.i(43908);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "[ILaunchWxaAppInfoNotify] onPostInit appId[%s]", new Object[] { this.mAppId });
    MMToClientEvent.f((com.tencent.mm.plugin.appbrand.service.c)super.ari());
    MMToClientEvent.ZG("Common_IPC_appid");
    z.a.cIG().dd(this.mAppId, asA().epn.scene);
    if (((com.tencent.mm.plugin.appbrand.service.c)super.ari()).cbl().compareTo(hW(false)) != 0)
    {
      localObject1 = new IllegalStateException(String.format(Locale.ENGLISH, "onPostInit appId[%s] mismatch libReader, self[%s] service[%s]", new Object[] { this.mAppId, hW(false).cfD(), ((com.tencent.mm.plugin.appbrand.service.c)super.ari()).cbl().cfD() }));
      AppMethodBeat.o(43908);
      throw ((Throwable)localObject1);
    }
    super.cbA();
    Object localObject1 = (AppBrandInitConfigWC)super.asA();
    this.qvz.L(0, System.currentTimeMillis() - ((AppBrandInitConfigWC)localObject1).startTime);
    com.tencent.mm.plugin.appbrand.performance.c.b(this.mAppId, "ActivityCreate", ((AppBrandInitConfigWC)super.asA()).startTime, System.currentTimeMillis());
    Object localObject2 = this.qvM;
    kotlin.g.b.s.u(localObject1, "initConfig");
    if ((!((com.tencent.mm.plugin.appbrand.report.r)localObject2).tOB) && (((AppBrandInitConfigWC)localObject1).epm == com.tencent.luggage.sdk.launching.e.etJ)) {
      ((com.tencent.mm.plugin.appbrand.report.r)localObject2).tOB = true;
    }
    MMToClientEvent.a(this.mAppId, new MMToClientEvent.c()
    {
      public final void dL(Object paramAnonymousObject)
      {
        AppMethodBeat.i(316972);
        Object localObject;
        if ((paramAnonymousObject instanceof AppBrandAuthorizeUI.AuthStateChangedByUserEvent))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], AuthStateChangedByUserEvent", new Object[] { w.this.mAppId });
          com.tencent.mm.plugin.appbrand.permission.a.a.aft(w.this.mAppId);
          AppBrandBackgroundRunningMonitor.a(w.this, (AppBrandAuthorizeUI.AuthStateChangedByUserEvent)paramAnonymousObject);
          localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.d.rKi;
          localObject = w.this.mAppId;
          paramAnonymousObject = (AppBrandAuthorizeUI.AuthStateChangedByUserEvent)paramAnonymousObject;
          if ((paramAnonymousObject.tYK) || (paramAnonymousObject.tYL)) {
            break label100;
          }
          paramAnonymousObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rKe;
        }
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.d.a((String)localObject, paramAnonymousObject);
          AppMethodBeat.o(316972);
          return;
          label100:
          if ((paramAnonymousObject.tYK) && (!paramAnonymousObject.tYL)) {
            paramAnonymousObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rKf;
          } else if ((paramAnonymousObject.tYK) && (paramAnonymousObject.tYL)) {
            paramAnonymousObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.rKg;
          } else {
            paramAnonymousObject = null;
          }
        }
      }
    });
    MMToClientEvent.a("Common_IPC_appid", new MMToClientEvent.c()
    {
      public final void dL(Object paramAnonymousObject)
      {
        AppMethodBeat.i(316962);
        if ((paramAnonymousObject instanceof GetOnLineInfoInfoResult))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], GetOnLineInfoInfoResult", new Object[] { w.this.mAppId });
          u.Uy(w.this.mAppId).qvo = ((GetOnLineInfoInfoResult)paramAnonymousObject).qvo;
          u.Uy(w.this.mAppId).qvp = ((GetOnLineInfoInfoResult)paramAnonymousObject).qvp;
          u.Uy(w.this.mAppId).qvq = ((GetOnLineInfoInfoResult)paramAnonymousObject).qvq;
        }
        AppMethodBeat.o(316962);
      }
    });
    MMToClientEvent.a(this.mAppId, new MMToClientEvent.c()
    {
      public final void dL(Object paramAnonymousObject)
      {
        AppMethodBeat.i(316971);
        if ((paramAnonymousObject instanceof EventLocationBackgroundStateChanged))
        {
          if (!((EventLocationBackgroundStateChanged)paramAnonymousObject).qSk)
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "locationBackgroundStateChanged, not listening, appId[%s]", new Object[] { w.this.mAppId });
            w.this.qsB.qKC.a(com.tencent.mm.plugin.appbrand.b.d.a.qLh);
          }
          AppMethodBeat.o(316971);
          return;
        }
        if ((paramAnonymousObject instanceof WxaAppMsgChannel))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], WxaAppMsgChannel msg", new Object[] { w.this.mAppId });
          com.tencent.mm.plugin.appbrand.jsapi.q.a locala = new com.tencent.mm.plugin.appbrand.jsapi.q.a();
          com.tencent.mm.plugin.appbrand.service.c localc = w.this.ccO();
          paramAnonymousObject = (WxaAppMsgChannel)paramAnonymousObject;
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.onReceiveMsgChannelJsApiEvent", "dispatch msg channel to web ， msgContent:%s", new Object[] { paramAnonymousObject.hWn });
          HashMap localHashMap = new HashMap();
          localHashMap.put("msgId", paramAnonymousObject.msgId);
          localHashMap.put("sendTime", Long.valueOf(paramAnonymousObject.rdg));
          localHashMap.put("msgType", Integer.valueOf(paramAnonymousObject.msgType));
          localHashMap.put("msgContent", paramAnonymousObject.hWn);
          locala.h(localc);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.onReceiveMsgChannelJsApiEvent", "dispatch wxa msg channel");
          locala.K(localHashMap).cpV();
          AppMethodBeat.o(316971);
          return;
        }
        if ((paramAnonymousObject instanceof AppBrandVoIP1v1FloatBallEvent))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onCustomDataNotify, appId[%s], AppBrandVoIP1v1FloatBallEvent msg", new Object[] { w.this.mAppId });
          if (((AppBrandVoIP1v1FloatBallEvent)paramAnonymousObject).hQm == 1) {
            com.tencent.mm.plugin.appbrand.jsapi.openvoice.r.cue();
          }
        }
        AppMethodBeat.o(316971);
      }
    });
    new g.a(this, (byte)0);
    this.qvz.L(8, System.currentTimeMillis() - ((AppBrandInitConfigWC)localObject1).startTime);
    yT(2);
    localObject2 = this.qsM;
    if (localObject2 != null)
    {
      ((com.tencent.mm.plugin.appbrand.pip.g)localObject2).tKx = com.tencent.mm.plugin.appbrand.pip.l.tKP;
      ((com.tencent.mm.plugin.appbrand.pip.g)localObject2).cHJ();
      ((com.tencent.mm.plugin.appbrand.pip.g)localObject2).tKz = com.tencent.mm.plugin.appbrand.pip.h.tKL;
    }
    ((com.tencent.mm.plugin.appbrand.service.c)super.ari()).a(getWindowAndroid());
    localObject2 = ccK();
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.appbrand.page.ah)localObject2).a(getWindowAndroid());
    }
    localObject2 = this.qvO;
    kotlin.g.b.s.u(localObject1, "initConfig");
    ((com.tencent.mm.plugin.appbrand.widget.d)localObject2).n((AppBrandInitConfigWC)localObject1);
    AppMethodBeat.o(43908);
  }
  
  protected y cbB()
  {
    AppMethodBeat.i(43901);
    Object localObject;
    if (super.arD()) {
      if (aqJ())
      {
        localObject = this.qvF.cbW();
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
      com.tencent.mm.plugin.appbrand.report.quality.b.afZ(this.mAppId).tSw = com.tencent.mm.plugin.appbrand.report.quality.i.tRO;
      continue;
      if (com.tencent.mm.plugin.appbrand.debugger.x.Ym(((AppBrandInitConfigWC)super.asA()).extInfo))
      {
        localObject = new com.tencent.mm.plugin.appbrand.service.c();
      }
      else
      {
        localObject = new com.tencent.mm.plugin.appbrand.service.c(com.tencent.mm.plugin.appbrand.debugger.v.class);
        continue;
        String str1;
        if (this.qvF != null)
        {
          localObject = this.qvF.cbW();
          if (localObject != null)
          {
            String str2 = this.mAppId;
            if (!aqJ()) {
              break label266;
            }
            str1 = "WAGame";
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "[%s][%s] [applaunch] [preload] createService preloaded, reason=%s", new Object[] { str2, str1, com.tencent.mm.plugin.appbrand.report.quality.b.afZ(this.mAppId).tSw.name() });
          }
          if (localObject != null) {
            break label309;
          }
          str1 = this.mAppId;
          if (!aqJ()) {
            break label273;
          }
        }
        for (localObject = "WAGame";; localObject = "WAService")
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "[%s][%s] [applaunch] [preload] createService got no preloaded", new Object[] { str1, localObject });
          if (((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG) && (!DebuggerShell.cls())) || (!com.tencent.mm.plugin.appbrand.task.b.cJE())) {
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
        if (aqJ()) {
          localObject = new com.tencent.mm.plugin.appbrand.game.c();
        } else {
          localObject = new com.tencent.mm.plugin.appbrand.service.c();
        }
      }
    }
  }
  
  protected com.tencent.mm.plugin.appbrand.page.x cbC()
  {
    AppMethodBeat.i(43902);
    Object localObject1 = this.mContext;
    try
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.afZ(this.mAppId).tSy = Util.nowMilliSecond();
      if (aqJ()) {}
      com.tencent.mm.plugin.appbrand.page.ah localah;
      for (localObject1 = new com.tencent.mm.plugin.appbrand.game.f.c((Context)localObject1, this);; localObject1 = new com.tencent.mm.plugin.appbrand.page.y((Context)localObject1, this))
      {
        ((com.tencent.mm.plugin.appbrand.page.y)localObject1).setDecorWidgetFactory(ccx());
        if (!aqJ()) {
          ((com.tencent.mm.plugin.appbrand.page.y)localObject1).a(com.tencent.mm.plugin.appbrand.page.b.i.tCY, new com.tencent.mm.plugin.appbrand.page.b.a());
        }
        ((com.tencent.mm.plugin.appbrand.page.y)localObject1).a(com.tencent.mm.plugin.appbrand.page.b.i.tCX, new com.tencent.mm.plugin.appbrand.page.b.b());
        if (this.qvF == null) {
          break label248;
        }
        localah = this.qvF.cbX();
        if (localah == null) {
          break label248;
        }
        if ((localah == null) || (((com.tencent.mm.plugin.appbrand.page.y)localObject1).getRuntime() == null)) {
          break label230;
        }
        if (localah.cbl().compareTo(((com.tencent.mm.plugin.appbrand.page.y)localObject1).getRuntime().hW(false)) == 0) {
          break;
        }
        localObject1 = new IllegalStateException(String.format(Locale.ENGLISH, "stashPreloadedPageView appId[%s] mismatch libReader, runtime[%s] page[%s]", new Object[] { ((com.tencent.mm.plugin.appbrand.page.y)localObject1).getAppId(), ((com.tencent.mm.plugin.appbrand.page.y)localObject1).getRuntime().hW(false).cfD(), localah.cbl().cfD() }));
        AppMethodBeat.o(43902);
        throw ((Throwable)localObject1);
      }
      synchronized (((com.tencent.mm.plugin.appbrand.page.y)localObject1).twB)
      {
        ((com.tencent.mm.plugin.appbrand.page.y)localObject1).twB.addLast(localah);
        label230:
        if ((localah instanceof bv)) {
          ((com.tencent.mm.plugin.appbrand.page.y)localObject1).setWAAutoWebViewJs(((bv)localah).tBk);
        }
        label248:
        AppMethodBeat.o(43902);
        return localObject1;
      }
    }
    finally {}
  }
  
  public final boolean cbD()
  {
    AppMethodBeat.i(43904);
    if (!aqJ())
    {
      AppMethodBeat.o(43904);
      return true;
    }
    AppMethodBeat.o(43904);
    return false;
  }
  
  protected final com.tencent.mm.plugin.appbrand.page.capsulebar.e cbG()
  {
    AppMethodBeat.i(317092);
    com.tencent.mm.plugin.appbrand.page.capsulebar.e locale = super.cbG();
    locale.tCe = new com.tencent.mm.plugin.appbrand.page.capsulebar.i()
    {
      private com.tencent.mm.plugin.appbrand.page.capsulebar.f qwn = null;
      
      public final com.tencent.mm.plugin.appbrand.page.capsulebar.a a(com.tencent.mm.plugin.appbrand.page.capsulebar.a paramAnonymousa)
      {
        AppMethodBeat.i(316660);
        if (com.tencent.mm.plugin.appbrand.k.a.a.I(w.this))
        {
          w localw = com.tencent.mm.plugin.appbrand.k.a.a.H(w.this);
          if (localw != null)
          {
            if ((this.qwn == null) || (this.qwn.tCr != localw.qsp.cGm()))
            {
              if (this.qwn != null)
              {
                paramAnonymousa = this.qwn;
                com.tencent.mm.plugin.appbrand.b.c localc = paramAnonymousa.qxC.qsB;
                if (localc != null) {
                  localc.b(paramAnonymousa.tCs);
                }
              }
              this.qwn = new com.tencent.mm.plugin.appbrand.page.capsulebar.f(w.this, localw.qsp.cGm());
            }
            paramAnonymousa = this.qwn;
            AppMethodBeat.o(316660);
            return paramAnonymousa;
          }
        }
        AppMethodBeat.o(316660);
        return paramAnonymousa;
      }
    };
    AppMethodBeat.o(317092);
    return locale;
  }
  
  protected final void cbI()
  {
    AppMethodBeat.i(43916);
    MMToClientEvent.f((com.tencent.mm.plugin.appbrand.service.c)super.ari());
    MMToClientEvent.ZG("Common_IPC_appid");
    new AppBrandRegisterTask(this, ccF()).bQt();
    AppMethodBeat.o(43916);
  }
  
  public final void cbL()
  {
    AppMethodBeat.i(174684);
    if (com.tencent.mm.plugin.appbrand.ui.t.aB(this))
    {
      AppMethodBeat.o(174684);
      return;
    }
    super.cbL();
    AppMethodBeat.o(174684);
  }
  
  public final com.tencent.mm.plugin.appbrand.ui.ah cbM()
  {
    AppMethodBeat.i(316884);
    com.tencent.mm.plugin.appbrand.ui.ah localah = super.cbM();
    AppMethodBeat.o(316884);
    return localah;
  }
  
  public final boolean cbR()
  {
    AppMethodBeat.i(316953);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yPj, 1) == 1)
    {
      AppMethodBeat.o(316953);
      return true;
    }
    AppMethodBeat.o(316953);
    return false;
  }
  
  public final ICommLibReader cbl()
  {
    AppMethodBeat.i(369999);
    ICommLibReader localICommLibReader = hW(false);
    AppMethodBeat.o(369999);
    return localICommLibReader;
  }
  
  protected final void cbr()
  {
    AppMethodBeat.i(317045);
    ccP();
    Object localObject1 = (AppBrandInitConfigWC)super.asA();
    if (localObject1 != null) {
      this.qvL.a((AppBrandInitConfigLU)localObject1);
    }
    this.qvK = new b();
    this.qvJ = new com.tencent.mm.plugin.appbrand.ad.h(this, this.qvK);
    localObject1 = this.qvJ;
    if (((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC.cbN())
    {
      ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qzM = com.tencent.mm.plugin.appbrand.task.h.i(com.tencent.mm.plugin.appbrand.task.l.kO(((AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC.asA()).aqJ()));
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, may show ad, preloadedService:%s", new Object[] { ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC.mAppId, ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qzM });
      Object localObject2 = new com.tencent.mm.autogen.mmdata.rpt.t();
      ((com.tencent.mm.autogen.mmdata.rpt.t)localObject2).ilN = Util.nowMilliSecond();
      ((com.tencent.mm.autogen.mmdata.rpt.t)localObject2).ilL = ((com.tencent.mm.autogen.mmdata.rpt.t)localObject2).F("Appid", ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC.mAppId, true);
      u.Uy(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC.mAppId).quW = ((com.tencent.mm.autogen.mmdata.rpt.t)localObject2);
      Object localObject3;
      int i;
      if (((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC.aqJ())
      {
        localObject3 = (AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC.asA();
        if (localObject3 == null) {
          break label548;
        }
        localObject3 = e.b.afK(((AppBrandInitConfigWC)localObject3).euP);
        if ((localObject3 != e.b.tLj) && (localObject3 != e.b.tLl) && (localObject3 != e.b.tLm)) {
          break label548;
        }
        i = 1;
        if (i != 0)
        {
          com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, landscape game, add check show ad prepare process", new Object[] { ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC.mAppId });
          ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qzQ = new com.tencent.mm.plugin.appbrand.ad.i();
          ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC.a(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qzQ);
        }
      }
      label382:
      long l;
      if (((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qzM != null)
      {
        u.Uy(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC.mAppId).quV.qzs = 2;
        localObject3 = ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qzM.cdn().cds();
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qvK.a((com.tencent.mm.plugin.appbrand.ai.b)localObject3);
        }
        StringBuilder localStringBuilder = new StringBuilder("sendShouldShowAdWhenLaunchIfNeed, obtainWorkerAsync when preloaded launch adWorker isnull=");
        boolean bool;
        if (localObject3 == null)
        {
          bool = true;
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", bool);
          if (localObject3 != null) {
            break label558;
          }
          l = Util.nowMilliSecond();
          ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qvK.a(new h.1((com.tencent.mm.plugin.appbrand.ad.h)localObject1, (com.tencent.mm.autogen.mmdata.rpt.t)localObject2, l));
          ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).cef();
        }
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.ad.e.a(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC, com.tencent.mm.plugin.appbrand.task.h.l(com.tencent.mm.plugin.appbrand.task.l.kO(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC.aqJ())), true);
          localObject1 = this.qvM;
          localObject2 = (AppBrandInitConfigWC)super.asA();
          kotlin.g.b.s.u(localObject2, "initConfig");
          if (((AppBrandInitConfigWC)localObject2).qAT.isEnable())
          {
            com.tencent.mm.plugin.appbrand.report.r.rG(0);
            if (((AppBrandInitConfigWC)localObject2).epm != com.tencent.luggage.sdk.launching.e.etJ) {
              com.tencent.mm.plugin.appbrand.report.r.rG(5);
            }
          }
          ((com.tencent.mm.plugin.appbrand.report.r)localObject1).tOC = ((AppBrandInitConfigWC)localObject2).qAT.isEnable();
          localObject1 = this.qvN;
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.HalfScreenManger", "[onRuntimeLaunch]");
          ((com.tencent.mm.plugin.appbrand.widget.d.d)localObject1).cQf();
          AppMethodBeat.o(317045);
          return;
          label548:
          i = 0;
          break;
          bool = false;
          break label382;
          label558:
          ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).cef();
          ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).a(a.g(((com.tencent.mm.plugin.appbrand.ai.b)localObject3).qqS), ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qzM, ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC);
          com.tencent.mm.plugin.appbrand.ad.h.a(((com.tencent.mm.plugin.appbrand.ai.b)localObject3).uSm, (com.tencent.mm.autogen.mmdata.rpt.t)localObject2, 1, 0L, null);
        }
      }
      if (((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qzL)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, [not preload] waiting ad worker ready");
        l = Util.nowMilliSecond();
        u.Uy(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC.mAppId).quV.qzs = 1;
        ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qvK.a(new h.2((com.tencent.mm.plugin.appbrand.ad.h)localObject1, (com.tencent.mm.autogen.mmdata.rpt.t)localObject2, l));
      }
      com.tencent.mm.plugin.appbrand.ad.e.a(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC, com.tencent.mm.plugin.appbrand.task.h.l(com.tencent.mm.plugin.appbrand.task.l.kO(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC.aqJ())), false);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).cef();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "sendShouldShowAdWhenLaunchIfNeed, appId:%s, can not show ad", new Object[] { ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC.mAppId });
      ((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qzN = 0;
      break;
      com.tencent.mm.plugin.appbrand.ad.e.a(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC, com.tencent.mm.plugin.appbrand.task.h.l(com.tencent.mm.plugin.appbrand.task.l.kO(((com.tencent.mm.plugin.appbrand.ad.h)localObject1).qxC.aqJ())), false);
    }
  }
  
  public final void cbt()
  {
    AppMethodBeat.i(316959);
    com.tencent.mm.plugin.appbrand.config.b localb = getAppConfig();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "%s provideAppConfig", new Object[] { this });
    Object localObject2 = bl.d(this, "/app-config.json");
    Object localObject1 = localObject2;
    Object localObject3;
    if (Util.isNullOrNil((String)localObject2))
    {
      localObject3 = ccM().qYY.qHR.iterator();
      localObject1 = localObject2;
      if (((Iterator)localObject3).hasNext())
      {
        ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)((Iterator)localObject3).next();
        if (!localModulePkgInfo.independent) {
          break label833;
        }
        localObject2 = new StringBuilder().append(localModulePkgInfo.name);
        if (localModulePkgInfo.name.endsWith("/"))
        {
          localObject1 = "";
          label135:
          localObject2 = bl.d(this, (String)localObject1 + "app-config.json");
          localObject1 = localObject2;
          if (!Util.isNullOrNil((String)localObject2)) {
            break label184;
          }
          localObject1 = localObject2;
        }
      }
    }
    label184:
    label833:
    for (;;)
    {
      break;
      localObject1 = "/";
      break label135;
      localObject3 = bl.d(this, "/app-config-darkmode.json");
      localObject2 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = "{}";
      }
      localObject1 = com.tencent.mm.plugin.appbrand.config.b.a(this.mAppId, (String)localObject1, (String)localObject2, Boolean.parseBoolean(hW(true).UX("pruneWxConfigByPage")), aqJ());
      localObject2 = (com.tencent.mm.plugin.appbrand.config.m)d(com.tencent.mm.plugin.appbrand.config.m.class, false);
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.appbrand.config.m)localObject2).a((com.tencent.mm.plugin.appbrand.config.b)localObject1, bl.R(this));
      }
      if (!aqJ())
      {
        ((com.tencent.mm.plugin.appbrand.config.b)localObject1).qVI.euP = ((AppBrandInitConfigWC)super.asA()).euP;
        ((com.tencent.mm.plugin.appbrand.config.b)localObject1).qVI.qVX = true;
      }
      for (;;)
      {
        if (bj.x(this)) {
          ((com.tencent.mm.plugin.appbrand.config.b)localObject1).qVI.euP = "portrait";
        }
        b((com.tencent.mm.plugin.appbrand.config.b)localObject1);
        ccQ();
        if (aqJ())
        {
          localObject1 = com.tencent.mm.plugin.appbrand.game.preload.d.cpg();
          if (((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).hasInit)
          {
            localObject2 = ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).rsC;
            localObject3 = ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).qxC.qst;
            ((com.tencent.mm.plugin.appbrand.game.preload.c)localObject2).rsx.addAll((Collection)localObject3);
            ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).rsA = ((com.tencent.mm.plugin.appbrand.t.a)((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).qxC.aN(com.tencent.mm.plugin.appbrand.t.a.class));
            ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).rsB = ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).qxC.asx();
            localObject1 = ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).rsz;
            localObject2 = (com.tencent.mm.plugin.appbrand.t.a)((com.tencent.mm.plugin.appbrand.t.l)localObject1).rot.aN(com.tencent.mm.plugin.appbrand.t.a.class);
            ((com.tencent.mm.plugin.appbrand.t.l)localObject1).tnk = ((com.tencent.mm.plugin.appbrand.t.a)localObject2).epJ;
            ((com.tencent.mm.plugin.appbrand.t.l)localObject1).sKB = ((com.tencent.mm.plugin.appbrand.t.a)localObject2).tnh;
            ((com.tencent.mm.plugin.appbrand.t.l)localObject1).tnm = com.tencent.mm.plugin.appbrand.t.i.a((com.tencent.mm.plugin.appbrand.t.a)localObject2);
          }
          W(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(163900);
              try
              {
                com.tencent.mm.plugin.appbrand.game.preload.d locald = com.tencent.mm.plugin.appbrand.game.preload.d.cpg();
                if (!locald.rsE) {
                  break label385;
                }
                if (!locald.hasInit)
                {
                  com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WAGamePreloadManager", "hasn't init!");
                  AppMethodBeat.o(163900);
                  return;
                }
                if (locald.qxC == null) {
                  break label385;
                }
                if (locald.qxC.getAppConfig() != null) {
                  break label93;
                }
                com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WAGamePreloadManager", "downloadPreloadFiles getAppConfig null!");
                AppMethodBeat.o(163900);
                return;
              }
              catch (NullPointerException localNullPointerException)
              {
                if (!w.this.qsE.get()) {
                  break label391;
                }
              }
              com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntimeWC", "runtime has finished - downloadPreloadFiles!");
              AppMethodBeat.o(163900);
              return;
              label93:
              JSONArray localJSONArray = localNullPointerException.qxC.getAppConfig().qVM;
              int i;
              if (localJSONArray != null)
              {
                com.tencent.mm.plugin.appbrand.game.preload.e.cpi().fp(3000, localJSONArray.length());
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
                    if (localNullPointerException.rsB.Vr((String)localObject4) == com.tencent.mm.plugin.appbrand.appstorage.r.qML)
                    {
                      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WAGamePreloadManager", "predownload path %s has exists!", new Object[] { localObject4 });
                    }
                    else
                    {
                      localNullPointerException.rsD.add(localObject3);
                      localObject3 = new com.tencent.mm.plugin.appbrand.game.preload.d.2(localNullPointerException, (String)localObject3, (String)localObject4);
                      if (localNullPointerException.rsA.epJ <= 0) {
                        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WAGamePreloadManager", "maxDownloadConcurrent <= 0 ");
                      }
                    }
                  }
                }
                catch (JSONException localJSONException)
                {
                  com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.WAGamePreloadManager", localJSONException, "", new Object[0]);
                }
                Object localObject1 = localNullPointerException.qxC.getAppConfig();
                if (localObject1 == null)
                {
                  com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WAGamePreloadManager", "downloadPreloadFiles config null！");
                  AppMethodBeat.o(163900);
                  return;
                  localObject4 = new HashMap();
                  int j = localNullPointerException.rsA.qWL;
                  localNullPointerException.rsz.a((JSONObject)localObject2, 60000, (Map)localObject4, null, j, (com.tencent.mm.plugin.appbrand.t.b.a)localObject3, com.tencent.mm.plugin.appbrand.game.preload.d.bQs(), "test");
                }
                else
                {
                  localObject2 = localNullPointerException.qxC.mAppId;
                  localObject1 = ((com.tencent.mm.plugin.appbrand.config.b)localObject1).qVN;
                  if (localObject1 != null) {
                    com.tencent.mm.plugin.appbrand.game.preload.e.cpi().fp(4000, ((ArrayList)localObject1).size());
                  }
                  localNullPointerException.cph();
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
        if ((localb != null) && ((com.tencent.mm.plugin.appbrand.service.c)super.ari() != null)) {
          new com.tencent.mm.plugin.appbrand.jsapi.d.a().ZR(((com.tencent.mm.plugin.appbrand.service.c)super.ari()).arC().toString()).i(ari()).cpV();
        }
        AppMethodBeat.o(316959);
        return;
        if (!((com.tencent.mm.plugin.appbrand.config.b)localObject1).qVK.booleanValue()) {
          ((com.tencent.mm.plugin.appbrand.config.b)localObject1).qVI.euP = ((AppBrandInitConfigWC)super.asA()).epa.rcm;
        }
      }
      localObject1 = this.mAppId;
      localObject2 = getAppConfig();
      boolean bool2 = k.a.vK(ccM().qYY.qHO);
      boolean bool3 = ((com.tencent.mm.plugin.appbrand.config.b)localObject2).qVL.contains("location");
      MultiProcessMMKV.getMMKV("appbrand_background_config").encode(String.format("%s_location_background_required", new Object[] { localObject1 }), bool3);
      boolean bool1 = ((com.tencent.mm.plugin.appbrand.config.b)localObject2).qVL.contains("bluetooth");
      MultiProcessMMKV.getMMKV("appbrand_background_config").encode(String.format("%s_bluetooth_background_required", new Object[] { localObject1 }), bool1);
      localObject2 = ((com.tencent.mm.plugin.appbrand.config.b)localObject2).Xl("scope.userLocation");
      if ((localObject2 != null) && (!Util.isNullOrNil(((b.e)localObject2).desc))) {
        MultiProcessMMKV.getMMKV("appbrand_background_config").encode(String.format("%s_permission_location_desc", new Object[] { localObject1 }), ((b.e)localObject2).desc);
      }
      for (bool1 = true;; bool1 = false)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandBackgroundConfigStorage", "updateBackgroundConfigs, appId:%s, isDebug:%s, isLocationBackgroundRequired:%s, hasPermissionLocationDesc:%s", new Object[] { localObject1, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        break;
        MultiProcessMMKV.getMMKV("appbrand_background_config").remove(String.format("%s_permission_location_desc", new Object[] { localObject1 }));
      }
    }
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.ah cbu()
  {
    AppMethodBeat.i(43928);
    Object localObject;
    int i;
    if (aqJ())
    {
      localObject = com.tencent.mm.plugin.appbrand.game.preload.e.cpi();
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yLe, false) == true)
      {
        i = 1;
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).rsR = i;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WAGamePreloadStatisManager", "misPreload:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).rsR) });
        AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.asA();
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).rsM = localAppBrandInitConfigWC.appId;
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).rsN = localAppBrandInitConfigWC.appVersion;
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).rsO = localAppBrandInitConfigWC.eul;
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).rsP = (localAppBrandInitConfigWC.appServiceType + 1000);
        ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).rsQ = localAppBrandInitConfigWC.qYm.eup;
      }
    }
    else
    {
      switch (((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).rsO)
      {
      default: 
        label156:
        if (asA().epn != null) {
          ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).mScene = asA().epn.scene;
        }
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yWA, false) == true)
        {
          i = 1;
          label204:
          ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).rsT = i;
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WAGamePreloadStatisManager", "mHasSplashScreen:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).rsT) });
          localObject = com.tencent.mm.plugin.appbrand.ui.h.a(AndroidContextUtil.castActivityOrNull(this.mContext), this);
          ((com.tencent.mm.plugin.appbrand.ui.ah)localObject).eT(((AppBrandInitConfigWC)super.asA()).iconUrl, ((AppBrandInitConfigWC)super.asA()).hEy);
          if ((localObject instanceof ak)) {
            ((ak)localObject).setCanShowHideAnimation(false);
          }
          if ((localObject instanceof com.tencent.mm.plugin.appbrand.ui.j))
          {
            if (!TextUtils.isEmpty(((AppBrandInitConfigWC)super.asA()).qYj)) {
              break label360;
            }
            ((com.tencent.mm.plugin.appbrand.ui.j)localObject).setLoadingIconVisibility(false);
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
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).rsO = 1;
      break label156;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).rsO = 2;
      break label156;
      ((com.tencent.mm.plugin.appbrand.game.preload.e)localObject).rsO = 3;
      break label156;
      i = 0;
      break label204;
      label360:
      ((com.tencent.mm.plugin.appbrand.ui.j)localObject).setLoadingIconVisibility(true);
    }
  }
  
  protected final void cbw()
  {
    AppMethodBeat.i(316886);
    super.cbw();
    com.tencent.mm.plugin.appbrand.report.quality.b.T(this);
    AppMethodBeat.o(316886);
  }
  
  protected final void cbz()
  {
    AppMethodBeat.i(43910);
    super.cbz();
    super.Uq(toString());
    yT(11);
    com.tencent.mm.plugin.appbrand.keylogger.c.c(this.mAppId, KSProcessWeAppLaunch.stepPrepareResourceTimeout);
    AppMethodBeat.o(43910);
  }
  
  public com.tencent.mm.plugin.appbrand.l.b ccA()
  {
    AppMethodBeat.i(174683);
    if ((this.qvU == null) && (!this.qsE.get())) {
      this.qvU = new w.12(this);
    }
    com.tencent.mm.plugin.appbrand.l.b localb = this.qvU;
    AppMethodBeat.o(174683);
    return localb;
  }
  
  public final boolean ccB()
  {
    AppMethodBeat.i(43893);
    boolean bool = ((AppBrandInitConfigWC)super.asA()).qYd;
    AppMethodBeat.o(43893);
    return bool;
  }
  
  public final void ccD()
  {
    AppMethodBeat.i(43898);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "callSuperClose appId:%s", new Object[] { this.mAppId });
    super.close();
    AppMethodBeat.o(43898);
  }
  
  protected final void ccE()
  {
    AppMethodBeat.i(43905);
    b(com.tencent.mm.plugin.appbrand.networking.c.class, com.tencent.mm.plugin.appbrand.networking.h.tpZ);
    b(com.tencent.mm.plugin.appbrand.permission.k.class, new com.tencent.mm.plugin.appbrand.permission.n(this));
    b(com.tencent.mm.plugin.appbrand.permission.l.class, com.tencent.mm.plugin.appbrand.permission.p.tEM);
    b(com.tencent.mm.plugin.appbrand.jsapi.media.e.class, com.tencent.mm.plugin.appbrand.jsapi.media.q.shw);
    ay(com.tencent.mm.plugin.appbrand.networking.d.class);
    b(com.tencent.mm.plugin.appbrand.networking.d.class, new com.tencent.mm.plugin.appbrand.networking.g(this));
    b(com.tencent.mm.plugin.appbrand.jsapi.base.g.class, new aj());
    b(com.tencent.mm.plugin.appbrand.widget.m.class, com.tencent.mm.plugin.appbrand.widget.n.uxK);
    b(com.tencent.mm.plugin.appbrand.jsapi.ae.f.class, com.tencent.mm.plugin.appbrand.luggage.b.c.tfv);
    b(com.tencent.luggage.sdk.g.a.class, com.tencent.mm.plugin.appbrand.app.g.qBP);
    b(com.tencent.mm.plugin.appbrand.page.bc.class, new ai(this));
    b(com.tencent.mm.plugin.appbrand.jsapi.media.a.a.class, new w.25(this));
    u.Uu(this.mAppId);
    b(com.tencent.mm.plugin.appbrand.a.a.b.class, new com.tencent.mm.plugin.appbrand.a.a.a(com.tencent.mm.b.p.getString(ag.a.qOa.WE(this.mAppId)), this.mAppId));
    b(com.tencent.mm.plugin.appbrand.a.a.class, new com.tencent.mm.plugin.appbrand.a.a());
    AppMethodBeat.o(43905);
  }
  
  protected final void ccJ()
  {
    AppMethodBeat.i(43907);
    com.tencent.luggage.sdk.h.d.a("clearDuplicatedInstanceOnAppCreate", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(43865);
        w localw = d.Uc(w.this.mAppId);
        if ((localw != null) && (w.this != localw))
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "clearDuplicatedInstanceOnAppCreate duplicated[%d] this[%d]", new Object[] { Integer.valueOf(localw.hashCode()), Integer.valueOf(hashCode()) });
          localw.ccR();
        }
        new LuggageClearDuplicatedTask(w.this).bQt();
        AppMethodBeat.o(43865);
      }
    });
    AppMethodBeat.o(43907);
  }
  
  public com.tencent.mm.plugin.appbrand.page.ah ccK()
  {
    AppMethodBeat.i(316871);
    if ((com.tencent.mm.plugin.appbrand.page.y)super.getPageContainer() == null)
    {
      AppMethodBeat.o(316871);
      return null;
    }
    if (((com.tencent.mm.plugin.appbrand.page.y)super.getPageContainer()).getCurrentPage() == null)
    {
      AppMethodBeat.o(316871);
      return null;
    }
    com.tencent.mm.plugin.appbrand.page.ah localah = (com.tencent.mm.plugin.appbrand.page.ah)((com.tencent.mm.plugin.appbrand.page.y)super.getPageContainer()).getCurrentPage().getCurrentPageView();
    AppMethodBeat.o(316871);
    return localah;
  }
  
  public final AppBrandSysConfigWC ccM()
  {
    AppMethodBeat.i(43918);
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)d(AppBrandSysConfigWC.class, false);
    AppMethodBeat.o(43918);
    return localAppBrandSysConfigWC;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.y ccN()
  {
    AppMethodBeat.i(370002);
    com.tencent.mm.plugin.appbrand.page.y localy = (com.tencent.mm.plugin.appbrand.page.y)super.getPageContainer();
    AppMethodBeat.o(370002);
    return localy;
  }
  
  public final com.tencent.mm.plugin.appbrand.service.c ccO()
  {
    AppMethodBeat.i(370003);
    com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)super.ari();
    AppMethodBeat.o(370003);
    return localc;
  }
  
  public final void ccQ()
  {
    AppMethodBeat.i(43931);
    Object localObject = ccM();
    com.tencent.mm.plugin.appbrand.config.p.ch(this.mAppId, ((AppBrandSysConfigWC)localObject).eqc);
    com.tencent.mm.plugin.appbrand.config.p.ci(this.mAppId, ((AppBrandSysConfigWC)localObject).eqd);
    this.qst.add(com.tencent.mm.plugin.appbrand.config.f.g(this));
    this.qst.add(com.tencent.mm.plugin.appbrand.config.f.a((AppBrandSysConfigLU)localObject));
    this.qst.add(com.tencent.mm.plugin.appbrand.config.f.b((AppBrandSysConfigLU)localObject));
    this.qst.add(com.tencent.mm.plugin.appbrand.config.f.h(this));
    localObject = com.tencent.mm.plugin.appbrand.config.f.c((AppBrandSysConfigLU)localObject);
    ((com.tencent.mm.plugin.appbrand.performance.a)localObject).tDw |= DebuggerShell.cls();
    boolean bool2 = ((com.tencent.mm.plugin.appbrand.performance.a)localObject).tDx;
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.mm.plugin.appbrand.performance.a)localObject).tDx = (bool1 | bool2);
      this.qst.add(localObject);
      AppMethodBeat.o(43931);
      return;
    }
  }
  
  public final void ccR()
  {
    AppMethodBeat.i(43933);
    this.qsK = false;
    if (this.qsc != null) {
      this.qsc.E(this);
    }
    finish();
    if ((this.qsc instanceof AppBrandRuntimeContainerWC)) {
      ((AppBrandRuntimeContainerWC)this.qsc).asv();
    }
    AppMethodBeat.o(43933);
  }
  
  public final boolean ccS()
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    com.tencent.mm.plugin.appbrand.ad.h localh;
    if (this.qvJ != null)
    {
      localh = this.qvJ;
      if (localh.qzQ == null) {
        break label44;
      }
    }
    label44:
    for (boolean bool1 = localh.qzQ.ewf;; bool1 = false)
    {
      bool2 = bool3;
      if (bool1) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public final int ccT()
  {
    if (this.qvJ != null) {
      return this.qvJ.qzN;
    }
    return 9;
  }
  
  public final int ccW()
  {
    AppMethodBeat.i(163908);
    if ((AppBrandInitConfigWC)super.asA() != null)
    {
      int i = ((AppBrandInitConfigWC)super.asA()).qYp;
      AppMethodBeat.o(163908);
      return i;
    }
    AppMethodBeat.o(163908);
    return -1;
  }
  
  public final boolean ccX()
  {
    AppMethodBeat.i(317067);
    boolean bool = ((AppBrandInitConfigWC)super.asA()).qAT.isEnable();
    AppMethodBeat.o(317067);
    return bool;
  }
  
  public final Bitmap ccY()
  {
    AppMethodBeat.i(317071);
    if (this.qsp != null)
    {
      this.qsp.cGj();
      this.qsp.cGl();
    }
    Bitmap localBitmap = ch.dD(this.qsk);
    if (this.qsp != null) {
      this.qsp.cGk();
    }
    AppMethodBeat.o(317071);
    return localBitmap;
  }
  
  public void ccZ()
  {
    AppMethodBeat.i(317078);
    if (k.a.zn(this.qsh.eul))
    {
      v localv = this.qvT;
      if ((!localv.qvs.getAndSet(true)) && (localv.qvt.get())) {
        localv.qvu.run();
      }
    }
    AppMethodBeat.o(317078);
  }
  
  public final String ccw()
  {
    AppMethodBeat.i(316784);
    if ((AppBrandInitConfigWC)super.asA() == null)
    {
      AppMethodBeat.o(316784);
      return "NULL";
    }
    String str = ((AppBrandInitConfigWC)super.asA()).hEy;
    AppMethodBeat.o(316784);
    return str;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.f ccx()
  {
    AppMethodBeat.i(316788);
    if (this.qvQ == null)
    {
      localObject = com.tencent.mm.plugin.appbrand.page.h.ttR;
      this.qvQ = com.tencent.mm.plugin.appbrand.page.h.b(com.tencent.mm.plugin.appbrand.task.l.kO(((AppBrandInitConfigWC)super.asA()).aqJ()));
    }
    Object localObject = this.qvQ;
    AppMethodBeat.o(316788);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.r.b ccz()
  {
    if (this.qvI != null) {
      return this.qvI.tmN;
    }
    return null;
  }
  
  public final void close()
  {
    AppMethodBeat.i(43897);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "close() appId:%s, stack:%s", new Object[] { this.mAppId, android.util.Log.getStackTraceString(new Throwable()) });
    Runnable local22;
    com.tencent.mm.plugin.appbrand.widget.dialog.i locali;
    int j;
    int i;
    for (;;)
    {
      try
      {
        if (k.Uo(this.mAppId) == k.d.qrG)
        {
          localObject1 = (com.tencent.mm.plugin.appbrand.game.f.a)((com.tencent.mm.plugin.appbrand.page.y)super.getPageContainer()).getPageView().aa(com.tencent.mm.plugin.appbrand.game.f.a.class);
          if ((localObject1 != null) && (((com.tencent.mm.plugin.appbrand.game.f.a)localObject1).coU() != null))
          {
            localObject1 = ((com.tencent.mm.plugin.appbrand.game.f.a)localObject1).coU();
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: triggerMakeCanvasBitmap");
            if ((((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).rrF != null) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).coW() != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).rrF.ache)) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).rrF.acgV) && (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).rrH != null)) {
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
        local22 = new Runnable()
        {
          public final void run()
          {
            boolean bool3 = true;
            AppMethodBeat.i(317251);
            Object localObject;
            w localw;
            int i;
            boolean bool1;
            if (w.i(w.this) != null)
            {
              localObject = w.i(w.this);
              localw = w.this;
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "close, runtime:%s", new Object[] { localw.mAppId });
              i = com.tencent.mm.plugin.appbrand.floatball.c.b(k.Uo(localw.mAppId));
              if ((((com.tencent.mm.plugin.appbrand.r.c)localObject).tmN != null) && (((com.tencent.mm.plugin.appbrand.r.c)localObject).tmN.af(i, true))) {}
              for (bool1 = true;; bool1 = false)
              {
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "close, result:%s", new Object[] { Boolean.valueOf(bool1) });
                if (!bool1) {
                  break;
                }
                AppMethodBeat.o(317251);
                return;
              }
            }
            if (w.j(w.this) != null)
            {
              localObject = w.j(w.this);
              localw = w.this;
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFloatBallLogic", "close, runtime:%s", new Object[] { localw.mAppId });
              i = com.tencent.mm.plugin.appbrand.floatball.c.b(k.Uo(localw.mAppId));
              boolean bool2;
              if ((((com.tencent.mm.plugin.appbrand.floatball.d)localObject).roR != null) && (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).roR.cot()))
              {
                bool1 = true;
                if ((((com.tencent.mm.plugin.appbrand.floatball.d)localObject).roS == null) || (!((com.tencent.mm.plugin.appbrand.floatball.d)localObject).roS.cot())) {
                  break label291;
                }
                bool2 = true;
                label218:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFloatBallLogic", "close, voip:%s, voip1v1:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                if (!bool1) {
                  break label296;
                }
                ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).roR.a(AndroidContextUtil.castActivityOrNull(localw.mContext), new com.tencent.mm.plugin.appbrand.floatball.d.2((com.tencent.mm.plugin.appbrand.floatball.d)localObject, i));
                bool1 = bool3;
              }
              for (;;)
              {
                if (!bool1) {
                  break label360;
                }
                AppMethodBeat.o(317251);
                return;
                bool1 = false;
                break;
                label291:
                bool2 = false;
                break label218;
                label296:
                if (bool2)
                {
                  ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).roS.a(AndroidContextUtil.castActivityOrNull(localw.mContext), new d.3((com.tencent.mm.plugin.appbrand.floatball.d)localObject, i));
                  bool1 = bool3;
                }
                else
                {
                  bool1 = ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).Aa(i);
                  com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFloatBallLogic", "close, result:%s", new Object[] { Boolean.valueOf(bool1) });
                }
              }
            }
            label360:
            w.this.ccD();
            AppMethodBeat.o(317251);
          }
        };
        if (!((com.tencent.mm.plugin.gamelive.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.gamelive.d.class)).isGameLiving(this.mAppId, ((AppBrandInitConfigWC)super.asA()).eul).booleanValue()) {
          continue;
        }
        ((com.tencent.mm.plugin.gamelive.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelive.b.class)).a(AndroidContextUtil.castActivityOrNull(this.mContext), this.mAppId, this.qsh.eul, local22);
        AppMethodBeat.o(43897);
        return;
        locali = new com.tencent.mm.plugin.appbrand.widget.dialog.i((com.tencent.mm.plugin.appbrand.service.c)super.ari());
        if (locali.rpC != null) {
          break;
        }
      }
      OpenBusinessViewUtil.L(this);
      if (((AppBrandInitConfigWC)super.asA()).qYw != null) {
        this.qsB.a(new com.tencent.mm.plugin.appbrand.b.c.a()
        {
          public final void onRunningStateChanged(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
          {
            AppMethodBeat.i(317236);
            if (com.tencent.mm.plugin.appbrand.b.b.qKx == paramAnonymousb)
            {
              w.this.qsB.b(this);
              if (w.this.getInitConfig().qYw != null)
              {
                paramAnonymousString = w.this.getInitConfig().qYw;
                if ((AndroidContextUtil.castActivityOrNull(w.this.mContext) == null) || (!AndroidContextUtil.castActivityOrNull(w.this.mContext).isFinishing())) {
                  break label89;
                }
              }
            }
            label89:
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousString.ka(bool);
              AppMethodBeat.o(317236);
              return;
            }
          }
        });
      }
      if ((ccB()) || (an.u(this)))
      {
        super.close();
        AppMethodBeat.o(43897);
        return;
        if (((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).coX()) {
          ((com.tencent.mm.plugin.appbrand.game.f.b)localObject1).coW().apT();
        }
      }
      else
      {
        j = 0;
        if ((this != null) && (ccM() != null) && (AndroidContextUtil.castActivityOrNull(this.mContext) != null)) {
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
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1237L, 2L, 1L, false);
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        local22.run();
      }
      AppMethodBeat.o(43897);
      return;
      Object localObject2 = locali.rpC.tMY;
      if ((localObject2 == null) || (((gnm)localObject2).aciz == null) || (((gnm)localObject2).aciz.size() < 3))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: no config");
        j = 0;
        break;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1237L, 0L, 1L, false);
      long l1 = u.Ux(this.mAppId).qvl;
      locali.sJm = ((int)(System.currentTimeMillis() - l1));
      if (locali.sJm < ((gnm)localObject2).aciB * 1000)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "no need show game evaluate dialog: time limit");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1237L, 1L, 1L, false);
        j = 0;
        break;
      }
      j = 1;
      break;
      label587:
      localObject2 = ccM();
      if (!((AppBrandSysConfigWC)localObject2).qZc)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "can not show evaluate dialog");
        i = 0;
        break label405;
      }
      l1 = u.Ux(this.mAppId).qvl;
      long l2 = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "app time lastResumeTime:%s, closeTime:%s, leastTime:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(((AppBrandSysConfigWC)localObject2).qZe) });
      if ((l2 - l1) / 1000L < ((AppBrandSysConfigWC)localObject2).qZe)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "time not enough to show evaluate dialog");
        i = 0;
        break label405;
      }
      Object localObject5 = (AppBrandInitConfigWC)super.asA();
      locali.userName = ((AppBrandInitConfigWC)localObject5).username;
      if (Util.isNullOrNil(locali.userName))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "username is null, can not show evaluate dialog");
        i = 0;
        break label405;
      }
      Object localObject3 = AndroidContextUtil.castActivityOrNull(this.mContext);
      Object localObject4 = ((AppBrandInitConfigWC)localObject5).appId;
      Object localObject6 = ((AppBrandInitConfigWC)localObject5).hEy;
      boolean bool = ((AppBrandSysConfigWC)localObject2).qZd;
      locali.uCz = com.tencent.mm.plugin.appbrand.widget.dialog.i.E((Context)localObject3, true);
      localObject5 = (LinearLayout)LayoutInflater.from(locali.uCz.getContext()).inflate(ba.g.app_brand_evaluate_dialog, null, false);
      locali.uCz.setContentView((View)localObject5);
      Object localObject7 = aw.bf(locali.uCz.getContext());
      i = Math.min(((Point)localObject7).x, ((Point)localObject7).y);
      localObject7 = new FrameLayout.LayoutParams(i, -2);
      ((FrameLayout.LayoutParams)localObject7).gravity = 1;
      ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject7);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "createEvaluateDialog, dialog width:%d", new Object[] { Integer.valueOf(i) });
      locali.uDc = ((TextView)locali.uCz.findViewById(ba.f.evaluate_hint));
      locali.uDd = ((LinearLayout)locali.uCz.findViewById(ba.f.evaluate_logo_layout));
      locali.uDk = ((LinearLayout)locali.uCz.findViewById(ba.f.evaluate_comment_submit_layout));
      localObject7 = (TextView)locali.uCz.findViewById(ba.f.evaluate_comment);
      if (bool)
      {
        ((TextView)localObject7).setVisibility(0);
        ((TextView)localObject7).setOnClickListener(new i.15(locali, (Context)localObject3, (String)localObject4, (String)localObject6));
        label997:
        ((TextView)locali.uCz.findViewById(ba.f.evaluate_submit)).setOnClickListener(new i.16(locali, (Context)localObject3));
        locali.uCS = ((RatingBar)locali.uCz.findViewById(ba.f.evaluate_ratingbar));
        locali.uCS.setOnRatingBarChangeListener(new i.17(locali));
        locali.uck = ((TextView)locali.uCz.findViewById(ba.f.evaluate_desc));
        if (Util.isNullOrNil((String)localObject6)) {
          break label1316;
        }
        locali.uck.setVisibility(0);
        locali.uck.setText(((Context)localObject3).getString(ba.i.app_brand_evaluate_dialog_desc, new Object[] { localObject6 }));
        label1122:
        ((ImageView)locali.uCz.findViewById(ba.f.evaluate_close)).setOnClickListener(new i.18(locali));
        localObject3 = (ViewGroup)((LinearLayout)localObject5).getParent();
        if (localObject3 != null)
        {
          ((ViewGroup)localObject3).setOnClickListener(new i.19(locali));
          ((LinearLayout)localObject5).setOnClickListener(new i.20(locali));
        }
        locali.uCz = locali.uCz;
        locali.uCz.setOnCancelListener(new i.1(locali));
        locali.uCz.setOnDismissListener(new i.12(locali, local22));
        locali.uCN = false;
        ((AppBrandSysConfigWC)localObject2).qZc = false;
        if (this != null) {
          break label1329;
        }
        localObject2 = null;
        label1256:
        locali.appId = ((String)localObject2);
        if (!Util.isNullOrNil(locali.appId)) {
          break label1338;
        }
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "saveEvaluateReport, no app id");
      }
      for (;;)
      {
        locali.fY(1, 1);
        locali.show();
        i = 1;
        break;
        ((TextView)localObject7).setVisibility(8);
        ((TextView)localObject7).setOnClickListener(null);
        break label997;
        label1316:
        locali.uck.setVisibility(8);
        break label1122;
        label1329:
        localObject2 = this.mAppId;
        break label1256;
        label1338:
        localObject2 = (AppBrandInitConfigWC)super.asA();
        locali.sessionId = "";
        if (localObject2 != null) {
          locali.sessionId = ((AppBrandInitConfigLU)localObject2).eoP;
        }
        locali.scene = 1000;
        if ((localObject2 != null) && (((AppBrandInitConfigLU)localObject2).epn != null)) {
          locali.scene = ((AppBrandInitConfigLU)localObject2).epn.scene;
        }
        locali.hzy = "";
        if (((com.tencent.mm.plugin.appbrand.service.c)super.ari() != null) && (((com.tencent.mm.plugin.appbrand.service.c)super.ari()).ccK() != null)) {
          locali.hzy = ((com.tencent.mm.plugin.appbrand.service.c)super.ari()).ccK().cgR();
        }
      }
      label1456:
      if (j != 0)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "need show game evaluate dialog");
        localObject2 = locali.rpC.tMY;
        locali.rpC.tMY = null;
        locali.uCz = com.tencent.mm.plugin.appbrand.widget.dialog.i.E(AndroidContextUtil.castActivityOrNull(this.mContext), false);
        localObject3 = (LinearLayout)LayoutInflater.from(locali.uCz.getContext()).inflate(ba.g.app_brand_game_evaluate_dialog, null, false);
        locali.uCz.setContentView((View)localObject3);
        localObject4 = aw.bf(locali.uCz.getContext());
        localObject4 = new FrameLayout.LayoutParams(Math.min(((Point)localObject4).x, ((Point)localObject4).y), ((LinearLayout)localObject3).getLayoutParams().height);
        ((FrameLayout.LayoutParams)localObject4).gravity = 1;
        ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        localObject5 = (TextView)((LinearLayout)localObject3).findViewById(ba.f.title);
        ((TextView)localObject5).setText(((gnm)localObject2).hAP);
        localObject6 = (TextView)((LinearLayout)localObject3).findViewById(ba.f.evaluate_desc);
        ((TextView)localObject6).setText(((gnm)localObject2).aciy);
        localObject4 = (ImageView)((LinearLayout)localObject3).findViewById(ba.f.evaluate_close);
        localObject5 = new i.21(locali, (TextView)localObject5, (TextView)localObject6, (ImageView)localObject4, (LinearLayout)localObject3, this, local22, (gnm)localObject2);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(ba.f.option_1)).a(0, (gnm)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(ba.f.option_2)).a(1, (gnm)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        ((AppBrandGameEvaluateOptionView)((LinearLayout)localObject3).findViewById(ba.f.option_3)).a(2, (gnm)localObject2, (AppBrandGameEvaluateOptionView.a)localObject5);
        locali.uCz.setOnCancelListener(new i.2(locali, this, (gnm)localObject2, local22));
        ((ImageView)localObject4).setOnClickListener(new i.3(locali, this, (gnm)localObject2, local22));
        locali.uCz = locali.uCz;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1237L, 4L, 1L, false);
        locali.show();
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  protected final void d(y paramy)
  {
    AppMethodBeat.i(317031);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onServiceProvidedBeforeRealInit, appId:%s, preloadedService:%s", new Object[] { this.mAppId, paramy });
    paramy.a(new y.b()
    {
      public final void a(af paramAnonymousaf)
      {
        AppMethodBeat.i(316664);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "WorkerContainer had installed. watchAdWorkerCreate");
        af.a locala = (af.a)w.t(w.this);
        if (locala != null) {}
        synchronized (paramAnonymousaf.qxj)
        {
          if (paramAnonymousaf.qxi.qqS != null) {
            locala.b(paramAnonymousaf.qxi);
          }
          paramAnonymousaf.qxj.add(locala);
          w.t(w.this).qqY = new bn()
          {
            public final boolean cbe()
            {
              AppMethodBeat.i(316817);
              com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "serviceInitType:" + com.tencent.mm.plugin.appbrand.report.quality.b.afZ(w.this.mAppId).tSw);
              if (com.tencent.mm.plugin.appbrand.report.quality.b.afZ(w.this.mAppId).tSw != com.tencent.mm.plugin.appbrand.report.quality.i.tRO)
              {
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "[createWXLibWorker]  not in preloading");
                if (!com.tencent.mm.plugin.appbrand.ad.e.M(w.this))
                {
                  com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "[createWXLibWorker]  not adcontact");
                  AppMethodBeat.o(316817);
                  return true;
                }
              }
              AppMethodBeat.o(316817);
              return false;
            }
          };
          AppMethodBeat.o(316664);
          return;
        }
      }
    });
    AppMethodBeat.o(317031);
  }
  
  protected final com.tencent.mm.plugin.appbrand.widget.e et(Context paramContext)
  {
    AppMethodBeat.i(316993);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yTN, 1) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramContext = super.et(paramContext);
      AppMethodBeat.o(316993);
      return paramContext;
    }
    paramContext = new com.tencent.mm.plugin.appbrand.widget.e(paramContext);
    AppMethodBeat.o(316993);
    return paramContext;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(43899);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "finish appId[%s] type[%d] hash[%d] stacktrace=%s", new Object[] { this.mAppId, Integer.valueOf(this.qsh.eul), Integer.valueOf(hashCode()), android.util.Log.getStackTraceString(new Throwable()) });
    if ((n.e(this)) || (this.qsc == null))
    {
      V(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174678);
          w.this.dispatchDestroy();
          AppMethodBeat.o(174678);
        }
      });
      AppMethodBeat.o(43899);
      return;
    }
    super.finish();
    if (this.qvH != null)
    {
      this.qvH.D(this);
      this.qvH = null;
    }
    if (this.qvI != null) {
      com.tencent.mm.plugin.appbrand.r.c.D(this);
    }
    AppMethodBeat.o(43899);
  }
  
  public final AppBrandInitConfigWC getInitConfig()
  {
    AppMethodBeat.i(370001);
    AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)super.asA();
    AppMethodBeat.o(370001);
    return localAppBrandInitConfigWC;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid()
  {
    AppMethodBeat.i(317064);
    if (this.qsc != null)
    {
      localObject = this.qsc.getWindowAndroid();
      if (localObject != null)
      {
        if ((this.qvL != null) && ((this.qvL instanceof com.tencent.mm.plugin.appbrand.platform.window.g)) && ((((com.tencent.mm.plugin.appbrand.platform.window.g)this.qvL).asq()) || ((this.qvL instanceof com.tencent.mm.plugin.appbrand.widget.d.a))))
        {
          if ((this.qvX == null) || (this.qvX.tLq != localObject) || (this.qvX.tLr != this.qvL)) {
            this.qvX = new com.tencent.mm.plugin.appbrand.platform.window.f((com.tencent.mm.plugin.appbrand.platform.window.c)localObject, (com.tencent.mm.plugin.appbrand.platform.window.g)this.qvL);
          }
          localObject = this.qvX;
          AppMethodBeat.o(317064);
          return localObject;
        }
        AppMethodBeat.o(317064);
        return localObject;
      }
    }
    Object localObject = super.getWindowAndroid();
    AppMethodBeat.o(317064);
    return localObject;
  }
  
  final void hX(boolean paramBoolean)
  {
    AppMethodBeat.i(316948);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "notifyRemovedToMMTaskManager(isForDestroy:%b), appId:%s", new Object[] { Boolean.valueOf(paramBoolean), this.mAppId });
    if ((paramBoolean) || (!this.qsE.get())) {
      new LuggageRemoveTask(this).bQt();
    }
    AppMethodBeat.o(316948);
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(43903);
    super.onConfigurationChanged(paramConfiguration);
    this.qvG = new Configuration(paramConfiguration);
    this.qvL.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(43903);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(43906);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.mAppId, KSProcessWeAppLaunch.stepPrepareRuntime);
    ccJ();
    com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
    Object localObject2 = (AppBrandInitConfigWC)super.asA();
    Object localObject1;
    boolean bool;
    int i;
    if (localObject2 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        com.tencent.mm.ae.d.B((kotlin.g.a.a)new d.c(d.cbh(), (QualitySession)localObject1, (AppBrandInitConfigWC)localObject2));
      }
      d.setRuntime(this);
      com.tencent.mm.plugin.appbrand.crash_report.a.V(this);
      com.tencent.mm.plugin.appbrand.crash_report.b.Z(this);
      ccC();
      bool = WXHardCoderJNI.hcMiniProgramLaunchEnable;
      int j = WXHardCoderJNI.hcMiniProgramLaunchDelay;
      int k = WXHardCoderJNI.hcMiniProgramLaunchCPU;
      int m = WXHardCoderJNI.hcMiniProgramLaunchIO;
      if (!WXHardCoderJNI.hcMiniProgramLaunchThr) {
        break label1164;
      }
      i = Process.myTid();
      label110:
      this.qvB = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcMiniProgramLaunchTimeout, 801, WXHardCoderJNI.hcMiniProgramLaunchAction, "MicroMsg.AppBrandRuntimeWC");
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onCreate %s, scene:%d, instanceId:%s, sessionId:%s", new Object[] { this, Integer.valueOf(asA().epn.scene), ((AppBrandInitConfigWC)super.asA()).eoQ, ((AppBrandInitConfigWC)super.asA()).eoP });
      super.onCreate();
      ccE();
      if (aqJ())
      {
        localObject1 = com.tencent.mm.plugin.appbrand.game.preload.d.cpg();
        ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).qxC = this;
        ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).rsC = new com.tencent.mm.plugin.appbrand.game.preload.c(this);
        ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).hasInit = true;
        ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).rsE = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yLe, false);
        ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).rsz = new com.tencent.mm.plugin.appbrand.t.l(((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).rsC);
        ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).rsF = new AtomicInteger(0);
        ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).rsG = new AtomicInteger(0);
        ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).rsH = new AtomicInteger(0);
        ((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).rsI = new AtomicInteger(0);
        com.tencent.mm.plugin.appbrand.game.preload.d.cpg().dd(((AppBrandInitConfigWC)super.asA()).qAS);
      }
      com.tencent.mm.plugin.appbrand.report.quality.b.S(this);
      localObject1 = com.tencent.mm.plugin.appbrand.report.quality.n.tTb;
      com.tencent.mm.plugin.appbrand.report.quality.n.fn(this.mAppId, com.tencent.mm.plugin.appbrand.report.quality.b.afZ(this.mAppId).eup);
      com.tencent.mm.plugin.appbrand.report.quality.f.a(this, false, com.tencent.mm.plugin.appbrand.utils.f.agB(((AppBrandInitConfigWC)super.asA()).qYj));
      localObject1 = com.tencent.luggage.game.e.a.aqp();
      localObject2 = this.mAppId;
      bool = aqJ();
      ((com.tencent.luggage.game.e.a)localObject1).appId = ((String)localObject2);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MBNiReporter", "hy: appId:%s,isGame:%s", new Object[] { localObject2, Boolean.valueOf(bool) });
      if (bool) {
        k.a((String)localObject2, ((com.tencent.luggage.game.e.a)localObject1).eok);
      }
      ((com.tencent.luggage.game.e.a)localObject1).ekw = new ArrayList();
      if (!bool) {
        break label1169;
      }
      ((com.tencent.luggage.game.e.a)localObject1).ekA = 1004;
      label482:
      com.tencent.mm.plugin.ad.a.a(this.mAppId, ((AppBrandInitConfigWC)super.asA()).qYg);
      t.g(this);
      a(new AppBrandRuntime.b()
      {
        private volatile h.b qwt;
        
        public final void interrupt()
        {
          AppMethodBeat.i(317223);
          if (this.qwt != null) {
            this.qwt.interrupt();
          }
          AppMethodBeat.o(317223);
        }
        
        public final void prepare()
        {
          AppMethodBeat.i(317222);
          com.tencent.mm.plugin.appbrand.keylogger.c.a(w.this.mAppId, KSProcessWeAppLaunch.stepWaitForCommLibConfirm);
          this.qwt = com.tencent.mm.plugin.appbrand.launching.h.a(w.this, new kotlin.g.a.b() {});
          AppMethodBeat.o(317222);
        }
      });
      a(new AppBrandRuntime.b()
      {
        public final void prepare()
        {
          AppMethodBeat.i(317232);
          w.a(w.this, this);
          AppMethodBeat.o(317232);
        }
      });
      a(new c((byte)0));
      localObject1 = new p(this);
      this.qvF = ((p)localObject1);
      a((AppBrandRuntime.b)localObject1);
      new AppBrandRegisterTask(this, ccF()).bQt();
      com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
      com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.z(this);
      com.tencent.mm.plugin.appbrand.backgroundfetch.i.z(this);
      com.tencent.mm.plugin.appbrand.utils.m.ab(this);
      OpenBusinessViewUtil.K(this);
      AppBrandBackgroundRunningMonitor.A(this);
      this.qvy = new com.tencent.mm.plugin.appbrand.report.model.q();
      this.qvy.tQo = Util.currentTicks();
      this.qvR = new com.tencent.mm.plugin.appbrand.report.model.u();
      localObject1 = this.qvR;
      localObject2 = com.tencent.mm.plugin.appbrand.report.quality.b.afZ(this.mAppId).eup;
      String str = this.mAppId;
      long l = ((AppBrandInitConfigWC)super.asA()).appServiceType + 1000;
      kotlin.g.b.s.u(localObject2, "instanceId");
      kotlin.g.b.s.u(str, "appId");
      ((com.tencent.mm.plugin.appbrand.report.model.u)localObject1).tRh = Long.valueOf(System.currentTimeMillis());
      ((com.tencent.mm.plugin.appbrand.report.model.u)localObject1).sessionId = ((String)localObject2);
      ((com.tencent.mm.plugin.appbrand.report.model.u)localObject1).appId = str;
      ((com.tencent.mm.plugin.appbrand.report.model.u)localObject1).tRg = Long.valueOf(l);
      com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k.a(this.mAppId, cby(), asA().epn);
      if (asA().epn.scene != 1099) {
        break label1180;
      }
      bool = true;
      label761:
      this.qvC = bool;
      if (ccB()) {
        this.qvD.add(new am((AppBrandInitConfigWC)super.asA()));
      }
      this.qvD.add(new ay((AppBrandInitConfigWC)super.asA(), this));
      this.qsB.a(new com.tencent.mm.plugin.appbrand.b.c.a()
      {
        public final void onRunningStateChanged(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
        {
          AppMethodBeat.i(316985);
          if (com.tencent.mm.plugin.appbrand.b.b.qKy == paramAnonymousb)
          {
            w.this.qvx.srU.srV.clear();
            com.tencent.mm.plugin.appbrand.report.quality.j.dh(paramAnonymousString, 4);
          }
          AppMethodBeat.o(316985);
        }
      });
      if (this.qsc == null) {
        break label1186;
      }
      ccH();
      label849:
      if (this.qsc == null) {
        break label1209;
      }
      ccI();
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.appbrand.report.quality.b.afZ(this.mAppId);
      if (localObject1 != null) {
        ((QualitySession)localObject1).tSi = (Util.nowMilliSecond() - ((AppBrandInitConfigWC)super.asA()).startTime);
      }
      if (k.a.zn(this.qsh.eul))
      {
        localObject1 = this.mAppId;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "invoke appId:%s", new Object[] { localObject1 });
        if (BuildInfo.IS_FLAVOR_BLUE)
        {
          localObject2 = com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_appbrand_check_demoinfo_default", "1", true, true);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppBrandCheckDemoIPCTask", "xSwitch xSwitchStr:%s", new Object[] { localObject2 });
          if (TextUtils.equals((CharSequence)localObject2, "1")) {
            XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString((String)localObject1), com.tencent.mm.plugin.appbrand.task.a.a.a.class, new com.tencent.mm.plugin.appbrand.task.a.a.1((String)localObject1));
          }
        }
      }
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zsa, false))
      {
        localObject1 = this.mAppId;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppBrandCheckOnlineStatusTask", "invoke appId:%s", new Object[] { localObject1 });
        XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString(""), com.tencent.mm.plugin.appbrand.task.a.a.class, new com.tencent.mm.plugin.appbrand.task.a.1((String)localObject1));
      }
      MultiProcessMMKV.getMMKV(this.mAppId + "_wxa_voip").putBoolean("isCameraStart", false);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "reset appId:%s isCameraStart false", new Object[] { this.mAppId });
      this.qvT = new v(this);
      AppMethodBeat.o(43906);
      return;
      localObject1 = ((AppBrandInitConfigWC)localObject2).qYm;
      break;
      label1164:
      i = 0;
      break label110;
      label1169:
      ((com.tencent.luggage.game.e.a)localObject1).ekA = 1000;
      break label482;
      label1180:
      bool = false;
      break label761;
      label1186:
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "onCreate appId:%s, skip initFloatBallHelper(), maybe under preRender mode", new Object[] { this.mAppId });
      break label849;
      label1209:
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "onCreate appId:%s, skip initMultiTaskHelper(), maybe under preRender mode", new Object[] { this.mAppId });
    }
  }
  
  public final void onDestroy()
  {
    int j = 1;
    AppMethodBeat.i(43914);
    if (((AppBrandInitConfigWC)super.asA()).qYw != null)
    {
      ??? = ((AppBrandInitConfigWC)super.asA()).qYw;
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
      ((WeAppOpenUICallbackIPCProxy)???).ka(bool);
      super.onDestroy();
      MMToClientEvent.g((com.tencent.mm.plugin.appbrand.service.c)super.ari());
      MMToClientEvent.ZH("Common_IPC_appid");
      com.tencent.mm.plugin.appbrand.crash_report.a.W(this);
      com.tencent.mm.plugin.appbrand.report.quality.b.U(this);
      if (this.qvB != 0)
      {
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.qvB);
        this.qvB = 0;
      }
      if (!DebuggerShell.cls()) {
        break;
      }
      if (this.qvE != null) {
        this.qvE.stopTimer();
      }
      com.tencent.threadpool.h.ahAA.bm(new w.8(this));
      com.tencent.mm.plugin.appbrand.performance.b.afk(this.mAppId);
      ??? = this.mAppId;
      i = 0;
      while (i < 2)
      {
        localObject2 = new String[] { "Needjs", "Needwebviewjs" }[i];
        localObject2 = (String)??? + "-" + (String)localObject2;
        localObject5 = MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.ForceOpenAppNotify.TestInjectJsPath", 2).getString((String)localObject2, null);
        if (!TextUtils.isEmpty((CharSequence)localObject5)) {
          com.tencent.mm.vfs.y.deleteFile((String)localObject5);
        }
        MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.ForceOpenAppNotify.TestInjectJsPath", 2).remove((String)localObject2);
        i += 1;
      }
    }
    if (aqJ()) {
      com.tencent.mm.plugin.appbrand.game.preload.d.E(this);
    }
    ??? = AppBrandMusicClientService.thY;
    ((AppBrandMusicClientService)???).thX.clear();
    ((AppBrandMusicClientService)???).thZ = "";
    u.remove(this.mAppId);
    com.tencent.mm.plugin.appbrand.media.record.c.onDestroy();
    hX(true);
    if (this.qvQ != null) {
      this.qvQ.ttQ.clear();
    }
    d.b(this);
    ??? = this.qvy;
    if (??? != null)
    {
      ((com.tencent.mm.plugin.appbrand.report.model.q)???).sessionId = ((AppBrandInitConfigWC)super.asA()).eoP;
      u.Ux(this.mAppId);
      ((com.tencent.mm.plugin.appbrand.report.model.q)???).networkType = com.tencent.mm.plugin.appbrand.report.j.getNetworkType(MMApplicationContext.getContext());
      ((com.tencent.mm.plugin.appbrand.report.model.q)???).appId = this.mAppId;
      if (ccM() != null) {
        break label953;
      }
      i = ((AppBrandInitConfigWC)super.asA()).appVersion;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.report.model.q)???).appVersion = i;
      ((com.tencent.mm.plugin.appbrand.report.model.q)???).hzw = (this.qsh.eul + 1);
      ((com.tencent.mm.plugin.appbrand.report.model.q)???).scene = asA().epn.scene;
      if (((com.tencent.mm.plugin.appbrand.report.model.q)???).tQp)
      {
        i = 1;
        label459:
        ((com.tencent.mm.plugin.appbrand.report.model.q)???).tQq = i;
        if (!com.tencent.xweb.ao.kgm()) {
          break label972;
        }
        i = j;
        label473:
        ((com.tencent.mm.plugin.appbrand.report.model.q)???).tQr = i;
        ((com.tencent.mm.plugin.appbrand.report.model.q)???).tQs = Util.ticksToNow(((com.tencent.mm.plugin.appbrand.report.model.q)???).tQo);
        ((com.tencent.mm.plugin.appbrand.report.model.q)???).tQt = Util.nowMilliSecond();
        ((com.tencent.mm.plugin.appbrand.report.model.q)???).username = ((AppBrandInitConfigWC)super.asA()).username;
        localObject2 = com.tencent.mm.plugin.appbrand.report.quality.b.afZ(this.mAppId);
        ((com.tencent.mm.plugin.appbrand.report.model.q)???).qMB = ((QualitySessionRuntime)localObject2).apptype;
        ((com.tencent.mm.plugin.appbrand.report.model.q)???).eup = ((QualitySessionRuntime)localObject2).eup;
        ((com.tencent.mm.plugin.appbrand.report.model.q)???).report();
        com.tencent.mm.plugin.appbrand.ui.recommend.e.Y(this);
        this.qvy = null;
        this.qvA = false;
        this.qvF = null;
        if (this.qvJ != null)
        {
          ??? = this.qvJ;
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "onDestroy");
          ((com.tencent.mm.plugin.appbrand.ad.h)???).UN("onDestroy");
          ((com.tencent.mm.plugin.appbrand.ad.h)???).qzQ = null;
          this.qvJ = null;
        }
        this.qvW.clear();
        this.qvD.clear();
        if (this.qvS != null)
        {
          this.qvS.dead();
          this.qvS = null;
        }
        if (this.qvH != null)
        {
          this.qvH.D(this);
          this.qvH = null;
        }
        ??? = this.qvx;
        ((com.tencent.mm.plugin.appbrand.jsapi.aa.a)???).srU.srV.clear();
        synchronized (((com.tencent.mm.plugin.appbrand.jsapi.aa.a)???).srT)
        {
          ((SparseArray)???).clear();
          localObject2 = kotlin.ah.aiuX;
          com.tencent.mm.plugin.appbrand.jsapi.al.b.d.release();
          n.f(this);
          ??? = this.qvK;
          if (??? != null)
          {
            kotlin.g.b.s.u(this, "runtime");
            localObject2 = ((b)???).qqS;
            if (localObject2 != null) {
              ((com.tencent.mm.appbrand.v8.m)localObject2).destroy();
            }
            ((b)???).qqS = null;
            ((b)???).qqQ.clear();
            ((b)???).qqU = new kotlin.r(Long.valueOf(-1L), Long.valueOf(-1L));
            ((b)???).qqT = null;
            localObject2 = ari();
            if (localObject2 != null)
            {
              localObject2 = ((y)localObject2).cdn();
              if (localObject2 != null)
              {
                localObject5 = (af.a)???;
                if (localObject5 == null) {}
              }
            }
          }
        }
      }
      synchronized (((af)localObject2).qxj)
      {
        ((af)localObject2).qxj.remove(localObject5);
        this.qvO.cOE();
        ??? = this.qvN;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.HalfScreenManger", "[onRuntimeDestroy] setCapsuleBarBackgroundRenderer null");
        ((com.tencent.mm.plugin.appbrand.widget.d.d)???).setCapsuleBarBackgroundRenderer(null);
        this.qvT = null;
        JsApiOperateWXData.clear(this.mAppId);
        ??? = (com.tencent.mm.plugin.appbrand.a.a)ax(com.tencent.mm.plugin.appbrand.a.a.class);
        if (??? != null) {
          ((com.tencent.mm.plugin.appbrand.a.a)???).releaseAll();
        }
        if (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.e.c.class) != null) {
          ((com.tencent.mm.plugin.appbrand.e.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.e.c.class)).ckq();
        }
        a(w.b.qww);
        AppMethodBeat.o(43914);
        return;
        label953:
        i = ccM().qYY.pkgVersion;
        continue;
        i = 0;
        break label459;
        label972:
        i = 0;
        break label473;
        localObject3 = finally;
        AppMethodBeat.o(43914);
        throw localObject3;
      }
    }
  }
  
  public final void onEnterAnimationComplete()
  {
    AppMethodBeat.i(174690);
    if ((this.qsE.get()) || (this.ccV))
    {
      AppMethodBeat.o(174690);
      return;
    }
    U(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(316663);
        QualitySessionRuntime localQualitySessionRuntime = (QualitySessionRuntime)Objects.requireNonNull(com.tencent.mm.plugin.appbrand.report.quality.b.afZ(w.this.mAppId));
        if (localQualitySessionRuntime.tSp <= 0L) {
          localQualitySessionRuntime.tSp = this.qwk;
        }
        AppMethodBeat.o(316663);
      }
    });
    com.tencent.mm.plugin.appbrand.ui.ah localah = super.cbM();
    if ((localah instanceof ak)) {
      ((ak)localah).setCanShowHideAnimation(true);
    }
    if ((localah instanceof com.tencent.mm.plugin.appbrand.ui.j)) {
      ((com.tencent.mm.plugin.appbrand.ui.j)localah).setLoadingIconVisibility(true);
    }
    if (AndroidContextUtil.castActivityOrNull(this.mContext) != null) {
      com.tencent.mm.ui.statusbar.c.ch(AndroidContextUtil.castActivityOrNull(this.mContext)).jCH();
    }
    if (((AppBrandInitConfigWC)super.asA()).qYw != null) {
      ((AppBrandInitConfigWC)super.asA()).qYw.tcI.onWXAppResult((Parcelable)new IPCVoid());
    }
    AppMethodBeat.o(174690);
  }
  
  protected final void onPause()
  {
    AppMethodBeat.i(43912);
    super.onPause();
    new AppBrandNotifyPauseTask(com.tencent.luggage.sdk.processes.main.a.d(this)).bQt();
    Object localObject;
    if (this.qvH != null)
    {
      localObject = this.qvH;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFloatBallLogic", "pause, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).roP != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).roP.bhW();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).roQ != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).roQ.bhW();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).roR != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).roR.bhW();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).roT != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).roT.bhW();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject).roS != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject).roS.bhW();
      }
      localObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.t.ak(((com.tencent.mm.plugin.appbrand.floatball.d)localObject).roO);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.b)localObject).bhW();
      }
    }
    if (this.qvI != null)
    {
      localObject = this.qvI;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "pause, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.r.c)localObject).tmN != null) {
        ((com.tencent.mm.plugin.appbrand.r.c)localObject).tmN.bhW();
      }
    }
    ccA().cdf();
    AppMethodBeat.o(43912);
  }
  
  public void onReady()
  {
    AppMethodBeat.i(43909);
    super.onReady();
    u.Uy(this.mAppId).qvl = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| onReady appId:%s", new Object[] { this.mAppId });
    if (this.qvB != 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcMiniProgramLaunchEnable, this.qvB);
      this.qvB = 0;
    }
    long l1 = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.asA()).startTime;
    com.tencent.mm.plugin.appbrand.report.j.a(l1, this.qvA, aqJ());
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "onReady reportStartupTime: appId:%s, nickname:%s, cost:%dms, download:%b, isGame:%b", new Object[] { this.mAppId, ((AppBrandInitConfigWC)super.asA()).hEy, Long.valueOf(l1), Boolean.valueOf(this.qvA), Boolean.valueOf(aqJ()) });
    l1 = System.currentTimeMillis() - ((AppBrandInitConfigWC)super.asA()).startTime;
    this.qvz.L(5, l1);
    Object localObject1 = this.qvz;
    boolean bool1 = this.qvA;
    boolean bool2 = ((AppBrandInitConfigWC)super.asA()).epl;
    boolean bool3 = ((AppStartupPerformanceReportBundle)aN(AppStartupPerformanceReportBundle.class)).sYG;
    Object localObject2 = this.mAppId;
    ((r)localObject1).bHI = 0;
    ((r)localObject1).mType = 0;
    if (ccM() != null)
    {
      ((r)localObject1).bHI = ccM().qYY.pkgVersion;
      ((r)localObject1).mType = (ccM().qYY.qHO + 1);
    }
    label295:
    Object localObject3;
    if (bool1)
    {
      i = 1;
      ((r)localObject1).quE = i;
      if (!aqJ()) {
        break label832;
      }
      i = 1;
      ((r)localObject1).quJ = i;
      ((r)localObject1).mScene = asA().epn.scene;
      ((r)localObject1).quH = bool2;
      ((r)localObject1).quI = bool3;
      localObject3 = new StringBuilder();
      i = 0;
    }
    for (;;)
    {
      if (i >= ((r)localObject1).quD.length) {
        break label866;
      }
      if (localObject1.quD[i] < 0L)
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeStartupReporter", "Report Startup Time: abort, illegal value: %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(localObject1.quD[i]) });
        AppBrandPerformanceManager.a(this, 202, l1);
        com.tencent.mm.plugin.appbrand.performance.c.jR(((AppBrandInitConfigWC)super.asA()).startTime);
        com.tencent.mm.plugin.appbrand.report.quality.b.a(this.mAppId, this);
        if ((DebuggerShell.cls()) && (this.qvE == null))
        {
          this.qvE = new MTimerHandler(com.tencent.mm.plugin.appbrand.performance.b.a.tDJ.cGG().getLooper(), new w.15(this), true);
          this.qvE.startTimer(1000L);
        }
        if (aqJ())
        {
          localObject1 = com.tencent.mm.plugin.appbrand.game.preload.d.cpg();
          l1 = Util.nowMilliSecond();
          long l2 = ((AppBrandInitConfigWC)((com.tencent.mm.plugin.appbrand.game.preload.d)localObject1).qxC.asA()).startTime;
          com.tencent.mm.plugin.appbrand.game.preload.e.cpi().fp(2001, (int)(l1 - l2));
        }
        com.tencent.mm.plugin.appbrand.ui.recommend.e.Z(this);
        if (!((AppBrandInitConfigWC)super.asA()).epm.arX()) {
          new AppBrandRuntimePreloadNextInvoke(LuggageServiceType.cQ(aqJ())).bQt();
        }
        if (asx() != null)
        {
          localObject1 = (com.tencent.mm.plugin.appbrand.appstorage.u)asx().aR(com.tencent.mm.plugin.appbrand.appstorage.u.class);
          com.tencent.mm.vfs.y.f(((com.tencent.mm.plugin.appbrand.appstorage.u)localObject1).qMI + "/dir.lock", new byte[1], 1);
        }
        localObject3 = com.tencent.mm.plugin.appbrand.report.quality.b.afZ(this.mAppId);
        if ((localObject3 != null) && (!aqJ()))
        {
          com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
          kotlin.g.b.s.u(this, "runtime");
          localObject4 = new tt();
          localObject2 = com.tencent.mm.plugin.appbrand.report.quality.b.afZ(this.mAppId);
          if (localObject2 != null) {
            break label1213;
          }
          localObject1 = null;
          com.tencent.mm.plugin.appbrand.report.quality.d.a((QualitySessionRuntime)localObject1, kotlin.g.b.s.X("Null session with ", this.mAppId));
          ((tt)localObject4).jyp = ((QualitySessionRuntime)localObject3).cJi();
          ((tt)localObject4).bMH();
        }
        if (localObject3 != null)
        {
          com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
          kotlin.g.b.s.u(this, "runtime");
          localObject4 = new sr();
          localObject2 = com.tencent.mm.plugin.appbrand.report.quality.b.afZ(this.mAppId);
          if (localObject2 != null) {
            break label1370;
          }
          localObject1 = null;
          com.tencent.mm.plugin.appbrand.report.quality.d.a((QualitySessionRuntime)localObject1, kotlin.g.b.s.X("Null session with ", this.mAppId));
          ((sr)localObject4).jyp = ((QualitySessionRuntime)localObject3).cJi();
          ((sr)localObject4).bMH();
        }
        com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup);
        com.tencent.mm.plugin.appbrand.keylogger.c.b(this.mAppId, KSProcessWeAppLaunch.stepInitRuntimeGroup_Game);
        com.tencent.mm.plugin.appbrand.keylogger.c.e(KSProcessWeAppLaunch.class, this.mAppId);
        com.tencent.mm.plugin.appbrand.report.quality.j.dh(this.mAppId, 1);
        this.qvN.cQa();
        AppMethodBeat.o(43909);
        return;
        i = 0;
        break;
        label832:
        i = 0;
        break label295;
      }
      ((StringBuilder)localObject3).append(localObject1.quD[i]);
      ((StringBuilder)localObject3).append(",");
      i += 1;
    }
    label866:
    Object localObject4 = (AppBrandInitConfigWC)super.asA();
    if (localObject4 != null)
    {
      i = ((AppBrandInitConfigWC)localObject4).appServiceType;
      label886:
      i += 1000;
      bool2 = com.tencent.mm.plugin.appbrand.task.h.j(com.tencent.mm.plugin.appbrand.task.l.kO(aqJ()));
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
      if (((r)localObject1).quJ != 1) {
        break label1204;
      }
    }
    label1204:
    for (int i = ((r)localObject1).quG;; i = ((r)localObject1).quF)
    {
      com.tencent.mm.appbrand.v8.x.a(4, localObject1.quD[5], i, (String)localObject2, ((r)localObject1).quE, ((r)localObject1).quJ, hW(false).cfG());
      break;
      i = com.tencent.mm.plugin.appbrand.report.k.afP((String)localObject2);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeStartupReporter", "getServiceTypeForReport null = initConfig! appServiceType:%s", new Object[] { Integer.valueOf(i) });
      break label886;
    }
    label1213:
    ((tt)localObject4).ilM = ((tt)localObject4).F("InstanceId", ((QualitySessionRuntime)localObject2).eup, true);
    ((tt)localObject4).imT = ((tt)localObject4).F("AppId", ((QualitySessionRuntime)localObject2).appId, true);
    ((tt)localObject4).ind = ((QualitySessionRuntime)localObject2).tSh;
    ((tt)localObject4).jES = tt.a.pj(((QualitySessionRuntime)localObject2).tQx);
    ((tt)localObject4).jax = ((QualitySessionRuntime)localObject2).apptype;
    ((tt)localObject4).iqr = ((QualitySessionRuntime)localObject2).scene;
    localObject1 = ((com.tencent.mm.plugin.appbrand.page.y)super.getPageContainer()).getCurrentPage();
    if (localObject1 == null)
    {
      localObject1 = null;
      label1317:
      if (!(localObject1 instanceof com.tencent.mm.plugin.appbrand.page.ah)) {
        break label1364;
      }
    }
    label1364:
    for (localObject1 = (com.tencent.mm.plugin.appbrand.page.ah)localObject1;; localObject1 = null)
    {
      ((tt)localObject4).ixD = com.tencent.mm.plugin.appbrand.report.quality.d.z((com.tencent.mm.plugin.appbrand.page.ah)localObject1);
      localObject1 = kotlin.ah.aiuX;
      localObject1 = localObject2;
      break;
      localObject1 = ((com.tencent.mm.plugin.appbrand.page.u)localObject1).getCurrentPageView();
      break label1317;
    }
    label1370:
    ((sr)localObject4).ilM = ((sr)localObject4).F("InstanceId", ((QualitySessionRuntime)localObject2).eup, true);
    ((sr)localObject4).imT = ((sr)localObject4).F("AppId", ((QualitySessionRuntime)localObject2).appId, true);
    ((sr)localObject4).ind = ((QualitySessionRuntime)localObject2).tSh;
    ((sr)localObject4).jzs = sr.a.oN(((QualitySessionRuntime)localObject2).tQx);
    ((sr)localObject4).jax = ((QualitySessionRuntime)localObject2).apptype;
    ((sr)localObject4).iqr = ((QualitySessionRuntime)localObject2).scene;
    localObject1 = (com.tencent.mm.plugin.appbrand.service.c)super.ari();
    if (localObject1 == null)
    {
      localObject1 = null;
      label1471:
      localObject1 = com.tencent.mm.plugin.appbrand.report.e.f((com.tencent.mm.plugin.appbrand.n.i)localObject1);
      switch (com.tencent.mm.plugin.appbrand.report.quality.d.b.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        i = -1;
      }
    }
    for (;;)
    {
      ((sr)localObject4).ixD = i;
      localObject1 = kotlin.ah.aiuX;
      localObject1 = localObject2;
      break;
      localObject1 = ((com.tencent.mm.plugin.appbrand.service.c)localObject1).getJsRuntime();
      break label1471;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(43911);
    super.onResume();
    u.Uy(this.mAppId).qvl = System.currentTimeMillis();
    if (this.qvH != null)
    {
      localObject1 = this.qvH;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandFloatBallLogic", "resume, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject1).roP != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject1).roP.coi();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject1).roQ != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject1).roQ.coi();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject1).roR != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject1).roR.coi();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject1).roT != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject1).roT.coi();
      }
      if (((com.tencent.mm.plugin.appbrand.floatball.d)localObject1).roS != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.d)localObject1).roS.coi();
      }
      localObject1 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.t.ak(((com.tencent.mm.plugin.appbrand.floatball.d)localObject1).roO);
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.appbrand.floatball.b)localObject1).coi();
      }
    }
    if (this.qvI != null)
    {
      localObject1 = this.qvI;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "resume, runtime:%s", new Object[] { this.mAppId });
      if (((com.tencent.mm.plugin.appbrand.r.c)localObject1).tmN != null)
      {
        ((com.tencent.mm.plugin.appbrand.r.c)localObject1).tmN.coi();
        if (((AppBrandInitConfigWC)super.asA()).qAW == null) {
          break label477;
        }
        ((com.tencent.mm.plugin.appbrand.r.c)localObject1).tmN.b(((AppBrandInitConfigWC)super.asA()).qAW.qAD);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "setMultiTaskCommonInfo not null");
      }
    }
    com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k.a(this.mAppId, cby(), asA().epn);
    d.setRuntime(this);
    com.tencent.mm.plugin.appbrand.crash_report.a.V(this);
    ccG();
    if (this.qsG) {
      ((com.tencent.mm.plugin.appbrand.page.y)super.getPageContainer()).getReporter().cBo();
    }
    z.a.cIG().dd(this.mAppId, asA().epn.scene);
    Object localObject1 = ab.a(this, new w.7(this));
    keep((com.tencent.mm.vending.e.a)localObject1);
    com.tencent.threadpool.h.ahAA.g((Runnable)localObject1, "getCopyPathMenuExpireTime");
    com.tencent.mm.plugin.appbrand.ipc.d.connect();
    label360:
    Object localObject2;
    int i;
    if (ccK() != null)
    {
      ccA().Uz(ccK().cgR());
      localObject1 = this.qvN;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.HalfScreenManger", "[onRuntimeResume]");
      localObject2 = com.tencent.mm.plugin.appbrand.k.a.a.ruh;
      if (!com.tencent.mm.plugin.appbrand.k.a.a.a.F(((com.tencent.mm.plugin.appbrand.widget.d.d)localObject1).qxC)) {
        ((com.tencent.mm.plugin.appbrand.widget.d.d)localObject1).qxC.setCapsuleBarBackgroundRenderer(null);
      }
      ((com.tencent.mm.plugin.appbrand.widget.d.d)localObject1).cQf();
      localObject1 = this.qvP;
      if (((CharSequence)((al)localObject1).qxD).length() <= 0) {
        break label595;
      }
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (((al)localObject1).qxE.getAndSet(false)))
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.EmbedHalfScreenWxaManager", "[onRuntimeResume]");
        localObject2 = ((al)localObject1).qxC.qsc;
        if (localObject2 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC");
          AppMethodBeat.o(43911);
          throw ((Throwable)localObject1);
          label477:
          ((com.tencent.mm.plugin.appbrand.r.c)localObject1).tmN.b(null);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandMultiTaskLogic", "setMultiTaskCommonInfo null enter scene:%d", new Object[] { Integer.valueOf(asA().epn.scene) });
          if ((asA().epn.scene == 1089) || (asA().epn.scene == 1104))
          {
            ((com.tencent.mm.plugin.appbrand.r.c)localObject1).tmN.LCW = Boolean.TRUE;
            break;
          }
          ((com.tencent.mm.plugin.appbrand.r.c)localObject1).tmN.LCW = Boolean.FALSE;
          break;
          com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandRuntimeWC", "onResume, try upsertHandOff but get NULL PageView, appId:%s", new Object[] { this.mAppId });
          break label360;
          label595:
          i = 0;
          continue;
        }
        localObject2 = (com.tencent.luggage.sdk.e.d)((AppBrandRuntimeContainerWC)localObject2).Us(((al)localObject1).qxD);
        if (localObject2 != null)
        {
          HalfScreenConfig localHalfScreenConfig = ((AppBrandInitConfigWC)((w)localObject2).asA()).qAT;
          kotlin.g.b.s.s(localHalfScreenConfig, "initConfig.halfScreenConfig");
          if ((localHalfScreenConfig.isEnable()) && (localHalfScreenConfig.rac == HalfScreenConfig.g.raA))
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.EmbedHalfScreenWxaManager", "[onRuntimeResume] re-show embedded wxa");
            ((al)localObject1).qxC.a((AppBrandInitConfigLU)((w)localObject2).asA(), ((AppBrandInitConfigWC)((w)localObject2).asA()).epn);
          }
        }
        ((al)localObject1).qxD = "";
      }
    }
    AppMethodBeat.o(43911);
  }
  
  public final void setCapsuleBarBackgroundRenderer(AppBrandGlobalNativeWidgetContainerView.a parama)
  {
    AppMethodBeat.i(317082);
    if (cbQ() != null) {
      cbQ().setCapsuleBarBackgroundRenderer(parama);
    }
    AppMethodBeat.o(317082);
  }
  
  public String toString()
  {
    AppMethodBeat.i(43886);
    String str = String.format(Locale.ENGLISH, "[AppBrandRuntimeWC::%s::%s::%d::@%d]", new Object[] { this.mAppId, ccw(), Integer.valueOf(this.qsh.eul), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(43886);
    return str;
  }
  
  public final void yU(int paramInt)
  {
    AppMethodBeat.i(43932);
    com.tencent.mm.plugin.appbrand.ui.ah localah = super.cbM();
    if ((localah instanceof com.tencent.mm.plugin.appbrand.launching.q)) {
      ((com.tencent.mm.plugin.appbrand.launching.q)localah).yU(paramInt);
    }
    AppMethodBeat.o(43932);
  }
  
  final class c
    extends AppBrandRuntime.b
  {
    volatile boolean qwA = false;
    volatile AppBrandPrepareTask qwz;
    
    private c() {}
    
    public final void interrupt()
    {
      AppMethodBeat.i(43884);
      this.qwA = true;
      AppBrandPrepareTask localAppBrandPrepareTask = this.qwz;
      if (localAppBrandPrepareTask != null) {
        localAppBrandPrepareTask.interrupt();
      }
      AppMethodBeat.o(43884);
    }
    
    public final void prepare()
    {
      AppMethodBeat.i(43883);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeProfile| ResourcePrepareProcess.prepare() appId:%s", new Object[] { w.this.mAppId });
      com.tencent.mm.plugin.appbrand.launching.h.a(w.this, new kotlin.g.a.b()
      {
        private kotlin.ah cdg()
        {
          AppMethodBeat.i(162153);
          if (!w.c.this.qwA) {}
          try
          {
            w.c.this.qwz = w.b(w.this, w.c.this);
            kotlin.ah localah = kotlin.ah.aiuX;
            AppMethodBeat.o(162153);
            return localah;
          }
          catch (NullPointerException localNullPointerException)
          {
            while (w.this.qsE.get()) {}
            AppMethodBeat.o(162153);
            throw localNullPointerException;
          }
        }
      });
      AppMethodBeat.o(43883);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w
 * JD-Core Version:    0.7.0.1
 */