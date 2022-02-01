package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.backgroundrunning.MMBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/WCBluetoothBackgroundSupportClient;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "appRunningStateChangeListener", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningStateController$OnRunningStateChangedListener;", "authStateListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothAuthorizeStateListener;", "backgroundRunningOpListener", "Lcom/tencent/mm/plugin/appbrand/backgroundrunning/IAppBrandBackgroundRunningManagerService$OnBackgroundRunningOperationReceivedListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBackgroundRunningOpListener;", "connectedDevices", "", "", "kotlin.jvm.PlatformType", "", "debugName", "getDebugName", "()Ljava/lang/String;", "debugName$1", "disconnectCausedDisableFuture", "Ljava/util/concurrent/Future;", "<set-?>", "Lcom/tencent/mm/plugin/appbrand/floatball/AppBrandBluetoothFloatBallHelper;", "floatBallHelper", "getFloatBallHelper", "()Lcom/tencent/mm/plugin/appbrand/floatball/AppBrandBluetoothFloatBallHelper;", "isCallEnabled", "", "isNeedKeepAlive", "()Z", "isRealEnabled", "lifeCycleListener", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "listeners", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient$IListener;", "mBluetoothStateChangeListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/BluetoothStateChangeListener;", "myTag", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "weChatForegroundListener", "Lcom/tencent/mm/app/IAppForegroundListener;", "wechatBackgroundCausedDisableFuture", "addListener", "", "listener", "checkCanIEnable", "closeAllConnection", "consumeDelayDisableOnResume", "createFloatBallHelperIfNeed", "destroyFloatBallHelperIfNeed", "disable", "closeConnection", "dispatchStateChange", "doRealDisable", "doRealEnable", "enable", "isBanned", "isReachMaxCount", "record", "registerAppRunningStateChangeListenerIfNeed", "registerAuthStateListenerIfNeed", "registerBackgroundRunningOpListenerIfNeed", "registerBluetoothStateChangeListenerIfNeed", "registerLifeCycleListenerIfNeed", "registerWeChatForegroundListenerIfNeed", "releaseHostKeepMeAlive", "removeListener", "requireHostKeepMeAlive", "unregisterAppRunningStateChangeListenerIfNeed", "unregisterAuthStateListenerIfNeed", "unregisterBackgroundRunningOpListenerIfNeed", "unregisterBluetoothStateChangeListenerIfNeed", "unregisterLifeCycleListenerIfNeed", "unregisterWeChatForegroundListenerIfNeed", "FACTORY", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  implements l
{
  public static final a rKG;
  private static final kotlin.j<com.tencent.mm.plugin.appbrand.backgroundrunning.f> rKQ;
  private static final String roK;
  private final String djQ;
  private volatile k.c eok;
  private final List<l.b> listeners;
  final AppBrandRuntime qzz;
  private volatile g rKH;
  private volatile c.a rKI;
  private volatile j rKJ;
  private volatile f.a rKK;
  volatile com.tencent.mm.plugin.appbrand.floatball.b rKL;
  private volatile boolean rKM;
  private volatile boolean rKN;
  private final Set<String> rKO;
  private volatile Future<?> rKP;
  private final String rKr;
  
  static
  {
    AppMethodBeat.i(329694);
    rKG = new a((byte)0);
    rKQ = kotlin.k.cm((kotlin.g.a.a)t.b.rKR);
    roK = "WCBluetoothBackgroundSupportClientFactory";
    AppMethodBeat.o(329694);
  }
  
  public t(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(329585);
    this.qzz = paramAppBrandRuntime;
    paramAppBrandRuntime = e.rKk;
    this.djQ = kotlin.g.b.s.X("MicroMsg.AppBrand.WCBluetoothBackgroundSupports#", e.a.ah(this.qzz));
    paramAppBrandRuntime = e.rKk;
    this.rKr = kotlin.g.b.s.X("WCBluetoothBackgroundSupportClient#", e.a.ah(this.qzz));
    this.listeners = ((List)new CopyOnWriteArrayList());
    this.rKO = Collections.newSetFromMap((Map)new ConcurrentHashMap());
    AppMethodBeat.o(329585);
  }
  
  private static final void a(Bundle paramBundle, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(329654);
    if (paramBundle == null)
    {
      Log.w("MicroMsg.AppBrand.WCBluetoothBackgroundSupports", "record#MainProcess, data is null");
      AppMethodBeat.o(329654);
      return;
    }
    paramBundle.setClassLoader(WCBluetoothBackgroundApp.class.getClassLoader());
    boolean bool = paramBundle.getBoolean("enable");
    paramBundle = (WCBluetoothBackgroundApp)paramBundle.getParcelable("app");
    if (paramBundle == null)
    {
      Log.w("MicroMsg.AppBrand.WCBluetoothBackgroundSupports", "record#MainProcess, app is null");
      AppMethodBeat.o(329654);
      return;
    }
    Log.d("MicroMsg.AppBrand.WCBluetoothBackgroundSupports", "record#MainProcess, enable: " + bool + ", app: " + paramBundle);
    if (bool)
    {
      s.rKD.a(paramBundle);
      AppMethodBeat.o(329654);
      return;
    }
    s.rKD.b(paramBundle);
    AppMethodBeat.o(329654);
  }
  
  private static final void a(t paramt, MMBackgroundRunningOperationParcel paramMMBackgroundRunningOperationParcel)
  {
    AppMethodBeat.i(329658);
    kotlin.g.b.s.u(paramt, "this$0");
    kotlin.g.b.s.u(paramMMBackgroundRunningOperationParcel, "opParcel");
    Log.i(paramt.djQ, kotlin.g.b.s.X("onBackgroundRunningOperationReceived, opParcel: ", paramMMBackgroundRunningOperationParcel));
    if ((kotlin.g.b.s.p(paramMMBackgroundRunningOperationParcel.appId, paramt.qzz.mAppId)) && (com.tencent.mm.plugin.appbrand.backgroundrunning.c.fh(paramMMBackgroundRunningOperationParcel.cIi, com.tencent.mm.plugin.appbrand.backgroundrunning.c.qSq.cIi)) && (paramMMBackgroundRunningOperationParcel.hAf == 2)) {
      ((l)paramt).cqI();
    }
    AppMethodBeat.o(329658);
  }
  
  private static final void a(t paramt, String paramString, com.tencent.mm.plugin.appbrand.b.b paramb)
  {
    AppMethodBeat.i(329656);
    kotlin.g.b.s.u(paramt, "this$0");
    if ((com.tencent.mm.plugin.appbrand.b.b.qKx == paramb) && (paramt.rKO.isEmpty()))
    {
      Log.i(paramt.djQ, "onRunningStateChanged, disable");
      ((l)paramt).cqI();
    }
    AppMethodBeat.o(329656);
  }
  
  private static final IPCBoolean aa(Bundle paramBundle)
  {
    AppMethodBeat.i(329650);
    if (paramBundle == null)
    {
      Log.w("MicroMsg.AppBrand.WCBluetoothBackgroundSupports", "isReachMaxCount#MainProcess, data is null");
      paramBundle = new IPCBoolean(false);
      AppMethodBeat.o(329650);
      return paramBundle;
    }
    paramBundle.setClassLoader(WCBluetoothBackgroundApp.class.getClassLoader());
    WCBluetoothBackgroundApp localWCBluetoothBackgroundApp = (WCBluetoothBackgroundApp)paramBundle.getParcelable("app");
    if (localWCBluetoothBackgroundApp == null)
    {
      Log.w("MicroMsg.AppBrand.WCBluetoothBackgroundSupports", "isReachMaxCount#MainProcess, app is null");
      paramBundle = new IPCBoolean(false);
      AppMethodBeat.o(329650);
      return paramBundle;
    }
    int i = paramBundle.getInt("maxCount");
    paramBundle = s.rKD;
    paramBundle = new IPCBoolean(s.a(localWCBluetoothBackgroundApp, i));
    AppMethodBeat.o(329650);
    return paramBundle;
  }
  
  public static final com.tencent.mm.plugin.appbrand.floatball.b ak(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(329661);
    kotlin.g.b.s.u(paramAppBrandRuntime, "runtime");
    paramAppBrandRuntime = e.rKk.af(paramAppBrandRuntime);
    if ((paramAppBrandRuntime instanceof t)) {}
    for (paramAppBrandRuntime = (t)paramAppBrandRuntime; paramAppBrandRuntime == null; paramAppBrandRuntime = null)
    {
      AppMethodBeat.o(329661);
      return null;
    }
    paramAppBrandRuntime = paramAppBrandRuntime.rKL;
    AppMethodBeat.o(329661);
    return paramAppBrandRuntime;
  }
  
  private final void cqK()
  {
    AppMethodBeat.i(329596);
    Log.i(this.djQ, "doRealDisable");
    if (!this.rKN)
    {
      Log.i(this.djQ, "doRealDisable, already disabled");
      AppMethodBeat.o(329596);
      return;
    }
    this.rKN = false;
    cqN();
    this.qzz.qsB.chA();
    cqQ();
    cqP();
    cqO();
    cqM();
    cqL();
    AppMethodBeat.o(329596);
  }
  
  private final void cqL()
  {
    AppMethodBeat.i(329617);
    j localj = this.rKJ;
    if (localj != null)
    {
      Log.i(this.djQ, "unregisterAuthStateListenerIfNeed, remove");
      d locald = d.rKi;
      d.b(this.qzz.mAppId, localj);
      this.rKJ = null;
    }
    AppMethodBeat.o(329617);
  }
  
  private final void cqM()
  {
    AppMethodBeat.i(329625);
    k.c localc = this.eok;
    if (localc != null)
    {
      Log.i(this.djQ, "unregisterLifeCycleListenerIfNeed, remove");
      com.tencent.mm.plugin.appbrand.k.b(this.qzz.mAppId, localc);
      this.eok = null;
    }
    AppMethodBeat.o(329625);
  }
  
  private final void cqN()
  {
    AppMethodBeat.i(329634);
    Log.i(this.djQ, "releaseHostKeepMeAlive");
    y localy = this.qzz.ari();
    if (localy == null)
    {
      Log.w(this.djQ, "releaseHostKeepMeAlive, service is null");
      AppMethodBeat.o(329634);
      return;
    }
    AppBrandBackgroundRunningMonitor.a(localy, 2, com.tencent.mm.plugin.appbrand.backgroundrunning.c.qSq.cIi);
    AppMethodBeat.o(329634);
  }
  
  private final void cqO()
  {
    AppMethodBeat.i(329640);
    f.a locala = this.rKK;
    if (locala != null)
    {
      Log.i(this.djQ, "unregisterBackgroundRunningOpListenerIfNeed, remove");
      com.tencent.mm.plugin.appbrand.backgroundrunning.f localf = a.cqS();
      if (localf != null) {
        localf.b(locala);
      }
      this.rKK = null;
    }
    AppMethodBeat.o(329640);
  }
  
  private final void cqP()
  {
    AppMethodBeat.i(329645);
    com.tencent.mm.plugin.appbrand.floatball.b localb = this.rKL;
    if (localb != null)
    {
      Log.i(this.djQ, "destroyFloatBallHelperIfNeed, destroy");
      localb.onDestroy();
      this.rKL = null;
    }
    AppMethodBeat.o(329645);
  }
  
  private final void cqQ()
  {
    AppMethodBeat.i(329647);
    boolean bool = this.rKN;
    Log.i(this.djQ, kotlin.g.b.s.X("dispatchStateChange, isEnabled: ", Boolean.valueOf(bool)));
    Iterator localIterator = ((Iterable)this.listeners).iterator();
    while (localIterator.hasNext()) {
      ((l.b)localIterator.next()).iQ(bool);
    }
    AppMethodBeat.o(329647);
  }
  
  private final void je(boolean paramBoolean)
  {
    AppMethodBeat.i(329608);
    Log.d("MicroMsg.AppBrand.WCBluetoothBackgroundSupports", kotlin.g.b.s.X("record, enable: ", Boolean.valueOf(paramBoolean)));
    String str = this.qzz.mAppId;
    if (str == null)
    {
      Log.w("MicroMsg.AppBrand.WCBluetoothBackgroundSupports", "record, appId is null");
      AppMethodBeat.o(329608);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(WCBluetoothBackgroundApp.class.getClassLoader());
    localBundle.putBoolean("enable", paramBoolean);
    localBundle.putParcelable("app", (Parcelable)new WCBluetoothBackgroundApp(str, this.qzz.qsh.eul));
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(localBundle, t..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(329608);
  }
  
  public final void a(l.b paramb)
  {
    AppMethodBeat.i(329728);
    kotlin.g.b.s.u(paramb, "listener");
    Log.i(this.djQ, kotlin.g.b.s.X("addListener, listener: ", paramb.com()));
    this.listeners.add(paramb);
    AppMethodBeat.o(329728);
  }
  
  public final void b(l.b paramb)
  {
    AppMethodBeat.i(329731);
    kotlin.g.b.s.u(paramb, "listener");
    Log.i(this.djQ, kotlin.g.b.s.X("removeListener, listener: ", paramb.com()));
    this.listeners.remove(paramb);
    AppMethodBeat.o(329731);
  }
  
  public final boolean cjR()
  {
    return this.rKN;
  }
  
  public final String com()
  {
    return this.rKr;
  }
  
  public final void cqH()
  {
    AppMethodBeat.i(329714);
    Log.i(this.djQ, "checkCanIEnable");
    if (this.rKM)
    {
      AppMethodBeat.o(329714);
      return;
    }
    Object localObject = this.qzz.mAppId;
    int i;
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.WCBluetoothBackgroundSupports", "isReachMaxCount, appId is null");
      i = 0;
      label52:
      if (i != 0)
      {
        Log.i(this.djQ, "checkCanIEnable, reach max count");
        localObject = a.c.rVr;
        kotlin.g.b.s.s(localObject, "BLUETOOTH_BACKGROUND_MODE_APP_REACH_MAX_COUNT");
        localObject = new f((a.d)localObject, (byte)0);
        AppMethodBeat.o(329714);
        throw ((Throwable)localObject);
      }
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.setClassLoader(WCBluetoothBackgroundApp.class.getClassLoader());
      localBundle.putParcelable("app", (Parcelable)new WCBluetoothBackgroundApp((String)localObject, this.qzz.qsh.eul));
      localBundle.putInt("maxCount", AppBrandGlobalSystemConfig.ckD().qXr);
      localObject = (IPCBoolean)com.tencent.mm.ipcinvoker.wx_extension.b.a.a(localBundle, t..ExternalSyntheticLambda1.INSTANCE);
      if (localObject == null) {}
      for (boolean bool = false;; bool = ((IPCBoolean)localObject).value)
      {
        Log.i("MicroMsg.AppBrand.WCBluetoothBackgroundSupports", kotlin.g.b.s.X("isReachMaxCount, canIEnableBackgroundSupport: ", Boolean.valueOf(bool)));
        if (bool) {
          break;
        }
        i = 1;
        break label52;
      }
    }
    AppMethodBeat.o(329714);
  }
  
  public final void cqI()
  {
    AppMethodBeat.i(329723);
    Log.i(this.djQ, kotlin.g.b.s.X("disable, closeConnection: ", Boolean.FALSE));
    if (!this.rKM)
    {
      Log.i(this.djQ, "disable, not enabled");
      AppMethodBeat.o(329723);
      return;
    }
    this.rKM = false;
    je(false);
    Object localObject1 = this.rKI;
    if (localObject1 != null)
    {
      Log.i(this.djQ, "unregisterAppRunningStateChangeListenerIfNeed, disable");
      localObject2 = this.qzz.qsB;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.appbrand.b.c)localObject2).b((c.a)localObject1);
      }
      this.rKI = null;
    }
    Object localObject2 = this.rKH;
    if (localObject2 != null)
    {
      Log.i(this.djQ, "unregisterBluetoothStateChangeListenerIfNeed, disable");
      this.rKO.clear();
      Log.i(((g)localObject2).djQ, "disable");
      if (((g)localObject2).rKp) {
        break label168;
      }
      Log.i(((g)localObject2).djQ, "disable, already disabled");
    }
    for (;;)
    {
      this.rKH = null;
      cqK();
      AppMethodBeat.o(329723);
      return;
      label168:
      ((g)localObject2).rKp = false;
      localObject1 = a.aan(((g)localObject2).qzz.mAppId);
      if (localObject1 == null)
      {
        Log.i(((g)localObject2).djQ, "disable, bleWorker is null");
      }
      else
      {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i locali = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i)localObject2;
        ((b)localObject1).rKb.remove(locali);
        localObject2 = (b.a)localObject2;
        ((b)localObject1).rKa.remove(localObject2);
      }
    }
  }
  
  public final void enable()
  {
    AppMethodBeat.i(329717);
    Log.i(this.djQ, "enable");
    if (this.rKM)
    {
      Log.i(this.djQ, "enable, already enabled");
      AppMethodBeat.o(329717);
      return;
    }
    Object localObject1 = e.rKk;
    if ((e.a.ai(this.qzz)) && (!com.tencent.mm.compatible.e.b.dh(this.qzz.mContext)))
    {
      Log.i(this.djQ, "enable, in background, float window permission is not allowed");
      localObject1 = a.e.rVw;
      kotlin.g.b.s.s(localObject1, "SYSTEM_PERMISSION_DENIED");
      localObject1 = new f((a.d)localObject1, (byte)0);
      AppMethodBeat.o(329717);
      throw ((Throwable)localObject1);
    }
    this.rKM = true;
    je(true);
    Object localObject2;
    if (this.rKH == null)
    {
      Log.i(this.djQ, "registerBluetoothStateChangeListenerIfNeed, create and enable");
      localObject1 = (g)new d(this, this.qzz);
      localObject2 = (d)localObject1;
      Log.i(((g)localObject2).djQ, "enable");
      if (!((g)localObject2).rKp) {
        break label241;
      }
      Log.i(((g)localObject2).djQ, "enable, already enabled");
    }
    for (;;)
    {
      this.rKH = ((g)localObject1);
      if (this.rKI == null)
      {
        Log.i(this.djQ, "registerAppRunningStateChangeListenerIfNeed, create and enable");
        localObject1 = new t..ExternalSyntheticLambda2(this);
        localObject2 = this.qzz.qsB;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.appbrand.b.c)localObject2).a((c.a)localObject1);
        }
        this.rKI = ((c.a)localObject1);
      }
      AppMethodBeat.o(329717);
      return;
      label241:
      ((g)localObject2).rKp = true;
      b localb = a.aan(((g)localObject2).qzz.mAppId);
      if (localb == null)
      {
        Log.i(((g)localObject2).djQ, "enable, bleWorker is null");
      }
      else
      {
        localb.a((b.a)localObject2);
        Object localObject3 = localb.jd(true);
        if (localObject3 != null)
        {
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            String str = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d)((Iterator)localObject3).next()).hEl;
            if (str == null) {
              Log.w(((g)localObject2).djQ, "enable, deviceId is null");
            } else {
              ((g)localObject2).onConnectStateChange(str, true);
            }
          }
        }
        localb.a((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i)localObject2);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/WCBluetoothBackgroundSupportClient$FACTORY;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient$IFactory;", "()V", "BUNDLE_KEY_APP", "", "BUNDLE_KEY_ENABLE", "BUNDLE_KEY_MAX_COUNT", "backgroundRunningService", "Lcom/tencent/mm/plugin/appbrand/backgroundrunning/IAppBrandBackgroundRunningManagerService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBackgroundRunningService;", "getBackgroundRunningService", "()Lcom/tencent/mm/plugin/appbrand/backgroundrunning/IAppBrandBackgroundRunningManagerService;", "backgroundRunningService$delegate", "Lkotlin/Lazy;", "debugName", "getDebugName", "()Ljava/lang/String;", "disableAfterDisconnectDelayMills", "", "getDisableAfterDisconnectDelayMills", "()J", "disableAfterWechatBackgroundDelayMills", "maxBluetoothBackgroundAppCount", "", "getMaxBluetoothBackgroundAppCount", "()I", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/WCBluetoothBackgroundSupportClient;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "getFloatBallHelper", "Lcom/tencent/mm/plugin/appbrand/floatball/AppBrandBluetoothFloatBallHelper;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements l.a
  {
    static com.tencent.mm.plugin.appbrand.backgroundrunning.f cqS()
    {
      AppMethodBeat.i(329577);
      com.tencent.mm.plugin.appbrand.backgroundrunning.f localf = (com.tencent.mm.plugin.appbrand.backgroundrunning.f)t.cqR().getValue();
      AppMethodBeat.o(329577);
      return localf;
    }
    
    public final String com()
    {
      AppMethodBeat.i(329589);
      String str = t.cqJ();
      AppMethodBeat.o(329589);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/WCBluetoothBackgroundSupportClient$registerAuthStateListenerIfNeed$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothAuthorizeStateListener;", "onAuthorizeStateChange", "", "newState", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/BluetoothAuthorizeState;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements j
  {
    c(t paramt) {}
    
    public final void a(c paramc)
    {
      AppMethodBeat.i(329581);
      kotlin.g.b.s.u(paramc, "newState");
      Log.i(t.a(this.rKS), kotlin.g.b.s.X("onAuthorizeStateChange, newState: ", paramc));
      if (c.rKg != paramc) {
        ((l)this.rKS).cqI();
      }
      AppMethodBeat.o(329581);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/WCBluetoothBackgroundSupportClient$registerBluetoothStateChangeListenerIfNeed$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/BluetoothStateChangeListener;", "onBluetoothStateChange", "", "isOn", "", "onConnectStateChange", "deviceId", "", "connected", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends g
  {
    d(t paramt, AppBrandRuntime paramAppBrandRuntime)
    {
      super();
    }
    
    private static final void h(t paramt)
    {
      AppMethodBeat.i(329586);
      kotlin.g.b.s.u(paramt, "this$0");
      Log.i(t.a(paramt), "run#onConnectStateChange, do disable");
      ((l)paramt).cqI();
      AppMethodBeat.o(329586);
    }
    
    public final void onBluetoothStateChange(boolean paramBoolean)
    {
      AppMethodBeat.i(329597);
      Log.i(t.a(this.rKS), kotlin.g.b.s.X("onBluetoothStateChange, isOn: ", Boolean.valueOf(paramBoolean)));
      if (!paramBoolean)
      {
        Log.i(t.a(this.rKS), "onBluetoothStateChange, do disable");
        ((l)this.rKS).cqI();
      }
      AppMethodBeat.o(329597);
    }
    
    public final void onConnectStateChange(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(329606);
      kotlin.g.b.s.u(paramString, "deviceId");
      Log.i(t.a(this.rKS), "onConnectStateChange, deviceId: " + paramString + ", connected: " + paramBoolean);
      boolean bool = t.b(this.rKS).isEmpty();
      if (paramBoolean)
      {
        t.b(this.rKS).add(paramString);
        if ((bool) && (t.c(this.rKS)))
        {
          Log.i(t.a(this.rKS), "onConnectStateChange, origin not connected and enable() called");
          t.d(this.rKS);
          AppMethodBeat.o(329606);
        }
      }
      else
      {
        t.b(this.rKS).remove(paramString);
        if (t.b(this.rKS).isEmpty())
        {
          Log.i(t.a(this.rKS), "onConnectStateChange, all device disconnect");
          if (this.rKS.qzz.mResumed)
          {
            Log.i(t.a(this.rKS), "onConnectStateChange, do real disable");
            t.e(this.rKS);
            AppMethodBeat.o(329606);
            return;
          }
          paramString = t.f(this.rKS);
          if (paramString != null) {
            paramString.cancel(false);
          }
          paramString = this.rKS;
          com.tencent.threadpool.i locali = h.ahAA;
          t.d..ExternalSyntheticLambda0 localExternalSyntheticLambda0 = new t.d..ExternalSyntheticLambda0(this.rKS);
          t.a locala = t.rKG;
          t.a(paramString, (Future)locali.q(localExternalSyntheticLambda0, 1000L * AppBrandGlobalSystemConfig.ckD().qXq));
        }
      }
      AppMethodBeat.o(329606);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/WCBluetoothBackgroundSupportClient$registerLifeCycleListenerIfNeed$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "onDestroy", "", "onResume", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends k.c
  {
    e(t paramt) {}
    
    public final void onDestroy()
    {
      AppMethodBeat.i(329584);
      Log.i(t.a(this.rKS), "onDestroy");
      ((l)this.rKS).cqI();
      AppMethodBeat.o(329584);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(329576);
      Log.i(t.a(this.rKS), "onResume");
      t.g(this.rKS);
      AppMethodBeat.o(329576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.t
 * JD-Core Version:    0.7.0.1
 */