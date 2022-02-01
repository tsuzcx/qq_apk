package com.tencent.luggage.game.d.a.a;

import android.content.Context;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.magicbrush.e.d;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MBViewManager.a;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.c;
import com.tencent.magicbrush.ui.MagicBrushView.d;
import com.tencent.magicbrush.ui.MagicBrushView.g;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mars.cdn.CronetLogic.CronetTaskNetworkStateCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.bk;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.debugger.x;
import com.tencent.mm.plugin.appbrand.jsapi.di;
import com.tencent.mm.plugin.appbrand.jsapi.dj;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.m;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.am;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.plugin.appbrand.utils.aa.a;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.plugin.appbrand.utils.z.b;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.gcg;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

public class a<Service extends com.tencent.luggage.sdk.b.a.d.d>
  extends com.tencent.luggage.sdk.b.a.d.f<Service>
  implements b
{
  private volatile boolean emd;
  private boolean eme;
  private com.tencent.mm.plugin.appbrand.debugger.q emf;
  private com.tencent.luggage.sdk.b.a.d.j emg;
  private boolean emh;
  private com.tencent.mm.plugin.appbrand.debugger.o emi;
  private boolean emj;
  private int emk;
  public com.tencent.luggage.game.a.b eml;
  private com.tencent.luggage.sdk.b.a.b.d emm;
  private com.tencent.luggage.sdk.b.a.b.c emn;
  private com.tencent.luggage.sdk.b.a.b.a emo;
  private com.tencent.luggage.sdk.b.a.b.e emp;
  protected com.tencent.luggage.sdk.b.a.e.b emq;
  private com.tencent.luggage.game.c.e emr;
  private CronetLogic.CronetTaskNetworkStateCallback ems;
  
  public a(Service paramService)
  {
    super(paramService);
    AppMethodBeat.i(130561);
    this.emd = false;
    this.eme = false;
    this.emf = null;
    this.emh = false;
    this.emi = null;
    this.emj = false;
    this.emk = 0;
    this.eml = null;
    this.emr = null;
    this.ems = null;
    b(b.class, this);
    api();
    AppMethodBeat.o(130561);
  }
  
  private void apA()
  {
    AppMethodBeat.i(130578);
    if (this.eme)
    {
      AppMethodBeat.o(130578);
      return;
    }
    this.eme = true;
    Log.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame to MainContext");
    Object localObject = apy();
    z.a(((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime(), (String)localObject, new a.7(this));
    String str1 = ((com.tencent.luggage.sdk.b.a.d.d)aqX()).cbl().UW("WAGame.js");
    String str2 = "v" + ((com.tencent.luggage.sdk.b.a.d.d)aqX()).cbl().cfG();
    bk.a((com.tencent.mm.plugin.appbrand.g)aqX(), ((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime());
    ((com.tencent.mm.plugin.appbrand.x.a)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(778L, 13L, 1L, false);
    final long l = System.currentTimeMillis();
    final boolean bool = ((com.tencent.luggage.sdk.b.a.d.d)aqX()).cdi();
    if (str1 == null) {}
    for (int i = 0;; i = str1.length())
    {
      localObject = new a("WAGame.js", str1, l, i, bool);
      if ((((com.tencent.luggage.sdk.b.a.d.d)aqX()).aqZ() == null) || (!((com.tencent.luggage.sdk.b.a.d.d)aqX()).aqZ().arD())) {
        break;
      }
      str1 = ";(function(global) { var protectedConsole = global.console; Object.defineProperty(global, 'console', { get() { return protectedConsole; }, set() { } }); })(this);".concat(String.valueOf(str1));
      aa.a((com.tencent.mm.plugin.appbrand.y)aqX(), ((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime(), "WAGame.js", str1, aa.a.urb, (z.a)localObject);
      AppMethodBeat.o(130578);
      return;
    }
    aa.a((com.tencent.mm.plugin.appbrand.y)aqX(), ((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime(), "WAGame.js", "WAGame.js", str2, apz(), str1, aa.a.urb, (z.a)localObject);
    AppMethodBeat.o(130578);
  }
  
  private void apq()
  {
    AppMethodBeat.i(130569);
    try
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime();
      if (localObject == null)
      {
        AppMethodBeat.o(130569);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.n.q)((i)localObject).Z(com.tencent.mm.plugin.appbrand.n.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.n.q)localObject).nM(-8);
      }
      AppMethodBeat.o(130569);
      return;
    }
    finally
    {
      Log.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(130569);
    }
  }
  
  private void apv()
  {
    AppMethodBeat.i(130573);
    if (this.eml != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Luggage.AppBrandGameServiceLogicImp", "setup magicbrush. loaded?[%b]", new Object[] { Boolean.valueOf(bool) });
      if (this.eml == null) {
        break;
      }
      localObject = Boolean.valueOf(apr());
      if (((Boolean)localObject).booleanValue() != this.emh)
      {
        Log.i("Luggage.AppBrandGameServiceLogicImp", "update useCommandBuffer before %b now %b", new Object[] { Boolean.valueOf(this.emh), localObject });
        this.eml.getMagicBrush().dh(((Boolean)localObject).booleanValue());
        this.emh = ((Boolean)localObject).booleanValue();
      }
      AppMethodBeat.o(130573);
      return;
    }
    ((com.tencent.luggage.sdk.b.a.d.d)aqX()).cpF();
    this.emh = apr();
    this.emj = aps();
    this.emk = apt();
    this.eml = a(this.emh, this.emj, this.emk, apu());
    this.eml.aoP();
    Object localObject = new c((byte)0);
    this.eml.getMagicBrush().eHC.add(localObject);
    this.eml.getMagicBrush().eHB.add(localObject);
    this.eml.getMagicBrush().eHD.addListener(new MBViewManager.a()
    {
      public final void a(MagicBrushView paramAnonymousMagicBrushView) {}
      
      public final void b(MagicBrushView paramAnonymousMagicBrushView)
      {
        AppMethodBeat.i(220180);
        a.e locale = new a.e(a.this, (byte)0);
        s.t(locale, "l");
        paramAnonymousMagicBrushView.eKN.add(locale);
        paramAnonymousMagicBrushView.a(new a.d(a.this, (byte)0));
        AppMethodBeat.o(220180);
      }
    });
    AppMethodBeat.o(130573);
  }
  
  protected com.tencent.luggage.game.a.b a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(220266);
    com.tencent.luggage.game.a.b local4 = new com.tencent.luggage.game.a.b(((com.tencent.luggage.sdk.b.a.d.d)aqX()).getContext(), ((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime(), paramBoolean1, paramBoolean2, paramInt, paramBoolean3)
    {
      public final void a(com.tencent.magicbrush.f paramAnonymousf)
      {
        AppMethodBeat.i(220171);
        super.a(paramAnonymousf);
        paramAnonymousf.b(com.tencent.magicbrush.ui.a.b.eKu);
        paramAnonymousf.dm(true);
        paramAnonymousf.jdMethod_do(true);
        paramAnonymousf.dy(a.this.arN().esf.getNativeHandle());
        AppMethodBeat.o(220171);
      }
    };
    AppMethodBeat.o(220266);
    return local4;
  }
  
  protected e a(Service paramService, com.tencent.mm.plugin.appbrand.n.t paramt)
  {
    AppMethodBeat.i(130565);
    paramService = new e(paramService, paramt);
    AppMethodBeat.o(130565);
    return paramService;
  }
  
  public final void apB()
  {
    AppMethodBeat.i(130579);
    super.apB();
    if ((((com.tencent.luggage.sdk.b.a.d.d)aqX()).aqZ() != null) && (((com.tencent.luggage.sdk.b.a.d.d)aqX()).aqZ().arD()))
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220170);
          a.a(a.this, new com.tencent.mm.plugin.appbrand.debugger.q());
          a.a(a.this, new com.tencent.mm.plugin.appbrand.debugger.o());
          a.b(a.this).a((com.tencent.luggage.sdk.b.a.d.d)a.this.aqX(), ((com.tencent.luggage.sdk.b.a.d.d)a.this.aqX()).aqZ().asA().extInfo);
          a.b(a.this).eoY = ((com.tencent.luggage.sdk.b.a.d.d)a.this.aqX()).aqZ().asA().eoY;
          a.c(a.this).a(a.b(a.this));
          if (a.d(a.this) != null) {
            a.d(a.this).esW = a.c(a.this);
          }
          AppMethodBeat.o(220170);
        }
      });
      aa.a(((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime(), "xdebug");
      if (((com.tencent.luggage.sdk.b.a.d.d)aqX()).asZ())
      {
        i locali = ((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime();
        aqX();
        aa.b(locali, "https://usr/");
      }
    }
    AppMethodBeat.o(130579);
  }
  
  public final void apC()
  {
    AppMethodBeat.i(130580);
    Log.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.init");
    this.emd = true;
    Log.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl mServiceReady = [%b], isRunning[%b]", new Object[] { Boolean.valueOf(this.emd), Boolean.valueOf(((com.tencent.luggage.sdk.b.a.d.d)aqX()).isRunning()) });
    if ((!this.emd) || (!((com.tencent.luggage.sdk.b.a.d.d)aqX()).isRunning()))
    {
      AppMethodBeat.o(130580);
      return;
    }
    try
    {
      Log.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl start");
      if (!this.eme) {
        ((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime().evaluateJavascript(com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/android.js"), null);
      }
      ((com.tencent.luggage.sdk.b.a.d.d)aqX()).arE();
      apA();
      ((com.tencent.luggage.sdk.b.a.d.d)aqX()).V(new a.6(this));
      AppMethodBeat.o(130580);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      if (((com.tencent.luggage.sdk.b.a.d.d)aqX()).isRunning())
      {
        AppMethodBeat.o(130580);
        throw localNullPointerException;
      }
      AppMethodBeat.o(130580);
    }
  }
  
  public final void apD()
  {
    AppMethodBeat.i(130582);
    Log.i("Luggage.AppBrandGameServiceLogicImp", "start preload");
    apv();
    apA();
    ((com.tencent.luggage.sdk.b.a.d.d)aqX()).cpG();
    Log.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppService preloaded.");
    AppMethodBeat.o(130582);
  }
  
  public final com.tencent.luggage.game.c.e apg()
  {
    AppMethodBeat.i(130558);
    if (this.emr == null) {}
    try
    {
      if (this.emr == null) {
        this.emr = new com.tencent.luggage.game.c.e();
      }
      com.tencent.luggage.game.c.e locale = this.emr;
      AppMethodBeat.o(130558);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(130558);
    }
  }
  
  public final String aph()
  {
    AppMethodBeat.i(130559);
    Object localObject = ((com.tencent.luggage.sdk.b.a.d.d)aqX()).arC();
    String str = ((com.tencent.luggage.sdk.b.a.d.d)aqX()).aqZ().getAppConfig().qVW;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(130559);
    return localObject;
  }
  
  protected void api()
  {
    AppMethodBeat.i(130562);
    new com.tencent.luggage.game.b.e().aoW();
    AppMethodBeat.o(130562);
  }
  
  public final boolean apj()
  {
    return true;
  }
  
  public i apk()
  {
    AppMethodBeat.i(130563);
    Log.i("Luggage.AppBrandGameServiceLogicImp", "createJsRuntime");
    long l = System.currentTimeMillis();
    Object localObject2 = apo();
    Object localObject1 = null;
    if (app()) {
      if (!com.tencent.mm.compatible.deviceinfo.q.awm()) {
        break label189;
      }
    }
    label189:
    for (localObject1 = com.tencent.mm.plugin.appbrand.af.d.agt("wxa_library/v8_snapshot64.bin");; localObject1 = com.tencent.mm.plugin.appbrand.af.d.agt("wxa_library/v8_snapshot.bin"))
    {
      localObject1 = e((String)localObject2, (byte[])localObject1);
      localObject2 = (com.tencent.mm.plugin.appbrand.n.t)((i)localObject1).Z(com.tencent.mm.plugin.appbrand.n.t.class);
      localObject2 = a((com.tencent.luggage.sdk.b.a.d.d)aqX(), (com.tencent.mm.plugin.appbrand.n.t)localObject2);
      ((i)localObject1).setJsExceptionHandler(new com.tencent.mm.plugin.appbrand.n.h()
      {
        public final void handleException(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(130540);
          Object localObject = (com.tencent.luggage.sdk.b.a.d.d)a.this.aqX();
          if (localObject == null) {}
          for (localObject = null; localObject == null; localObject = ((com.tencent.luggage.sdk.b.a.d.d)localObject).getJsRuntime())
          {
            AppMethodBeat.o(130540);
            return;
          }
          Log.e("Luggage.AppBrandGameServiceLogicImp", "[WAGameJsException] hy: wxa main context exception %s %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          di.a((com.tencent.mm.plugin.appbrand.n.o)localObject, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.utils.y.agF(paramAnonymousString1), com.tencent.mm.plugin.appbrand.utils.y.agF(paramAnonymousString2) }), 0);
          com.tencent.mm.plugin.appbrand.ac.b.a.cJD();
          com.tencent.mm.plugin.appbrand.ac.b.R("WeAppLaunch", paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(130540);
        }
      });
      ((i)localObject1).addJavascriptInterface(localObject2, "WeixinJSContext");
      z.a((i)localObject1, com.tencent.luggage.sdk.b.a.d.h.esV, new e.1((e)localObject2));
      z.a((i)localObject1, String.format(";(function(){let interface = %s;let alloc = interface.alloc;let allocNativeGlobal = interface.allocNativeGlobal;interface.alloc = function(injectNativeGlobal) {if(injectNativeGlobal){return allocNativeGlobal();}else{return alloc();}}})();", new Object[] { "WeixinJSContext" }), new e.2((e)localObject2));
      ((e)localObject2).apJ();
      Log.i("Luggage.AppBrandGameServiceLogicImp", "[damonlei] createJsRuntime cost [%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(130563);
      return localObject1;
    }
  }
  
  public void apl()
  {
    AppMethodBeat.i(130566);
    super.apl();
    this.emm = new com.tencent.luggage.sdk.b.a.b.d();
    this.emm.b(((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime(), aqX());
    this.emn = new com.tencent.luggage.sdk.b.a.b.c();
    this.emn.a(((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime(), aqX());
    this.emo = new com.tencent.luggage.sdk.b.a.b.a();
    Object localObject1 = this.emo;
    i locali = ((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime();
    Object localObject2 = aqX();
    Log.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding");
    if (locali == null) {
      Log.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsruntime is null");
    }
    for (;;)
    {
      this.emp = new com.tencent.luggage.sdk.b.a.b.e();
      this.emp.a(((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime(), aqX(), 1);
      this.emq = new com.tencent.luggage.sdk.b.a.e.b();
      this.emq.c(((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime(), aqX());
      if ((aqZ() != null) && (aqZ().arD()))
      {
        Log.i("Luggage.AppBrandGameServiceLogicImp", "add MPRemoteDebugJSContextInterface");
        localObject1 = ((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime();
        aqX();
        this.emg = new com.tencent.luggage.sdk.b.a.d.j();
        ((i)localObject1).addJavascriptInterface(this.emg, "DebuggerConnection");
        if (this.emf != null) {
          this.emg.esW = this.emf;
        }
      }
      AppMethodBeat.o(130566);
      return;
      ((com.tencent.luggage.sdk.b.a.b.a)localObject1).eqY = "1004";
      com.tencent.mm.game.b.a.loadLibraries();
      com.tencent.mm.plugin.appbrand.n.q localq = (com.tencent.mm.plugin.appbrand.n.q)locali.Z(com.tencent.mm.plugin.appbrand.n.q.class);
      if (localq == null)
      {
        Log.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsThreadHandler is null");
      }
      else
      {
        localObject2 = (com.tencent.luggage.sdk.b.a.b.b)((com.tencent.mm.plugin.appbrand.jsapi.f)localObject2).T(com.tencent.luggage.sdk.b.a.b.b.class);
        if (localObject2 != null)
        {
          ((com.tencent.luggage.sdk.b.a.b.a)localObject1).eqZ = ((com.tencent.luggage.sdk.b.a.b.b)localObject2).aro();
          Log.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(((com.tencent.luggage.sdk.b.a.b.a)localObject1).eqZ) });
        }
        localq.post(new com.tencent.luggage.sdk.b.a.b.a.3((com.tencent.luggage.sdk.b.a.b.a)localObject1, locali, new com.tencent.luggage.sdk.b.a.b.a.1((com.tencent.luggage.sdk.b.a.b.a)localObject1, new WeakReference(localq)), new com.tencent.luggage.sdk.b.a.b.a.2((com.tencent.luggage.sdk.b.a.b.a)localObject1)));
      }
    }
  }
  
  public void apm()
  {
    AppMethodBeat.i(130567);
    super.apm();
    if (this.eml != null) {
      this.eml.destroy();
    }
    if (this.emm != null) {
      this.emm.b(((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime());
    }
    if (this.emn != null) {
      this.emn.a(((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime());
    }
    com.tencent.luggage.sdk.b.a.b.a locala;
    i locali;
    if (this.emo != null)
    {
      locala = this.emo;
      locali = ((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime();
      Log.i("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding");
      if (locali != null) {
        break label186;
      }
      Log.e("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding jsruntime is null");
    }
    for (;;)
    {
      if (this.emp != null) {
        this.emp.c(((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime());
      }
      if (this.emq != null) {
        this.emq.d(((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime());
      }
      if (this.ems != null) {
        CronetLogic.removeCronetTaskNetworkStateCallback(this.ems);
      }
      AppMethodBeat.o(130567);
      return;
      label186:
      ((m)locali.Z(m.class)).a(locala.era);
    }
  }
  
  public void apn()
  {
    AppMethodBeat.i(130568);
    super.apn();
    if (this.eml != null)
    {
      Object localObject = this.eml;
      Log.i("MicroMsg.MagicBrush", "awaitDestroyDone");
      if ((!((com.tencent.luggage.game.a.d)localObject).ekm.dA(5000L)) && (BuildInfo.DEBUG))
      {
        localObject = new IllegalStateException("WAGame destroy timeout");
        AppMethodBeat.o(130568);
        throw ((Throwable)localObject);
      }
    }
    if (this.emf != null) {
      this.emf.destroy();
    }
    AppMethodBeat.o(130568);
  }
  
  protected String apo()
  {
    return null;
  }
  
  protected boolean app()
  {
    return true;
  }
  
  protected boolean apr()
  {
    AppMethodBeat.i(130571);
    if (((com.tencent.luggage.sdk.b.a.d.d)aqX()).aqZ() != null)
    {
      com.tencent.mm.plugin.appbrand.config.b localb = ((com.tencent.luggage.sdk.b.a.d.d)aqX()).aqZ().getAppConfig();
      if (localb.qVJ != null)
      {
        boolean bool = localb.qVJ.booleanValue();
        AppMethodBeat.o(130571);
        return bool;
      }
    }
    AppMethodBeat.o(130571);
    return true;
  }
  
  protected boolean aps()
  {
    return true;
  }
  
  protected int apt()
  {
    return 1;
  }
  
  protected boolean apu()
  {
    return false;
  }
  
  public void apw()
  {
    AppMethodBeat.i(130574);
    Log.i("Luggage.AppBrandGameServiceLogicImp", "onRuntimeResume");
    super.apw();
    apq();
    if (this.emf != null) {
      this.emf.rdV.bringToFront();
    }
    AppMethodBeat.o(130574);
  }
  
  public final void apx()
  {
    AppMethodBeat.i(130575);
    super.apx();
    try
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime();
      if (localObject == null)
      {
        AppMethodBeat.o(130575);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.n.q)((i)localObject).Z(com.tencent.mm.plugin.appbrand.n.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.n.q)localObject).nM(10);
      }
      AppMethodBeat.o(130575);
      return;
    }
    finally
    {
      Log.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(130575);
    }
  }
  
  protected String apy()
  {
    AppMethodBeat.i(130577);
    String str = com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/android.js") + com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/shared_buffer.js") + com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/lazy_load.js") + com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/puppet_wrapper.js") + com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/NativeGlobal-WAGame.js");
    AppMethodBeat.o(130577);
    return str;
  }
  
  protected int apz()
  {
    return 0;
  }
  
  public void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130570);
    super.c(paramAppBrandRuntime);
    apv();
    if (this.eml != null) {
      this.eml.b(paramAppBrandRuntime);
    }
    if (this.emp != null) {
      this.emp.a(((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime(), (k)aqX());
    }
    com.tencent.luggage.sdk.b.a.b.a locala;
    Object localObject;
    com.tencent.mm.plugin.appbrand.jsapi.f localf;
    if (this.emo != null)
    {
      locala = this.emo;
      localObject = ((com.tencent.luggage.sdk.b.a.d.d)aqX()).getJsRuntime();
      localf = aqX();
      Log.i("Luggage.LockStepNativeInstallHelper", "initConfigLockStep");
      if (localObject != null) {
        break label213;
      }
      Log.e("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsruntime is null");
    }
    for (;;)
    {
      apq();
      paramAppBrandRuntime.b(am.class, new com.tencent.luggage.game.f.a(paramAppBrandRuntime));
      this.eml.getMagicBrush().eHD.addSurfaceListenerForAllViews(new MagicBrushView.d()
      {
        public final void c(Object paramAnonymousObject, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(220181);
          paramAnonymousObject = a.this.aqZ();
          if ((paramAnonymousObject != null) && (paramAnonymousObject.qsB != null)) {
            paramAnonymousObject.qsB.im(false);
          }
          AppMethodBeat.o(220181);
        }
        
        public final void cd(Object paramAnonymousObject)
        {
          AppMethodBeat.i(162096);
          paramAnonymousObject = a.this.aqZ();
          if ((paramAnonymousObject != null) && (paramAnonymousObject.qsB != null))
          {
            paramAnonymousObject.qsB.im(true);
            Object localObject = paramAnonymousObject.qsB.qKC;
            paramAnonymousObject = new LinkedList(((com.tencent.mm.plugin.appbrand.b.d)localObject).qKR);
            ((com.tencent.mm.plugin.appbrand.b.d)localObject).qKR.clear();
            while (!paramAnonymousObject.isEmpty())
            {
              localObject = (com.tencent.mm.plugin.appbrand.b.j)paramAnonymousObject.poll();
              MMHandler localMMHandler = ((com.tencent.mm.plugin.appbrand.b.j)localObject).mHandler;
              if (localMMHandler != null)
              {
                ((com.tencent.mm.plugin.appbrand.b.j)localObject).mHandler.removeCallbacks(((com.tencent.mm.plugin.appbrand.b.j)localObject).task);
                if (Looper.myLooper() == localMMHandler.getLooper()) {
                  ((com.tencent.mm.plugin.appbrand.b.j)localObject).task.run();
                } else {
                  ((com.tencent.mm.plugin.appbrand.b.j)localObject).setResultFinish(((com.tencent.mm.plugin.appbrand.b.j)localObject).result);
                }
              }
            }
          }
          AppMethodBeat.o(162096);
        }
      });
      this.emq.c(aqX());
      this.ems = new CronetLogic.CronetTaskNetworkStateCallback()
      {
        public final void onNetWeakChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(220176);
          com.tencent.mm.plugin.appbrand.jsapi.ae.b.a(a.this.aqX(), paramAnonymousBoolean);
          AppMethodBeat.o(220176);
        }
      };
      CronetLogic.addCronetTaskNetworkStateCallback(this.ems);
      CronetLogic.setGoodNetNotifyInterval(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpQ, 5000));
      AppMethodBeat.o(130570);
      return;
      label213:
      localObject = (com.tencent.mm.plugin.appbrand.n.q)((i)localObject).Z(com.tencent.mm.plugin.appbrand.n.q.class);
      if (localObject == null) {
        Log.e("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsThreadHandler is null");
      } else {
        ((com.tencent.mm.plugin.appbrand.n.q)localObject).post(new com.tencent.luggage.sdk.b.a.b.a.4(locala, localf));
      }
    }
  }
  
  public final boolean c(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220229);
    if ("Image".equals(paramString))
    {
      AppMethodBeat.o(220229);
      return true;
    }
    if ("OffscreenCanvas".equals(paramString))
    {
      AppMethodBeat.o(220229);
      return true;
    }
    if ("MediaToolKit".equals(paramString))
    {
      AppMethodBeat.o(220229);
      return true;
    }
    if ("CpuProfiler".equals(paramString))
    {
      AppMethodBeat.o(220229);
      return true;
    }
    if ("HeapProfiler".equals(paramString))
    {
      AppMethodBeat.o(220229);
      return true;
    }
    if ("Profiler".equals(paramString))
    {
      AppMethodBeat.o(220229);
      return true;
    }
    if ("Box2D".equals(paramString))
    {
      this.eml.getMagicBrush().fV("mmbox2d");
      AppMethodBeat.o(220229);
      return true;
    }
    if ("Phys3D".equals(paramString))
    {
      this.eml.getMagicBrush().fV("mmphysx");
      AppMethodBeat.o(220229);
      return true;
    }
    boolean bool = super.c(paramString, paramJSONObject);
    AppMethodBeat.o(220229);
    return bool;
  }
  
  protected i e(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130564);
    paramString = new IJSRuntime.Config(paramString, paramArrayOfByte);
    paramString.hme = true;
    paramString.hmd = "1";
    paramString.hmg = true;
    paramString.hml = new WeakReference((com.tencent.mm.plugin.appbrand.jsapi.g)aqX());
    paramString = new com.tencent.mm.plugin.appbrand.n.b(paramString);
    AppMethodBeat.o(130564);
    return paramString;
  }
  
  public void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(130560);
    AppBrandSysConfigLU localAppBrandSysConfigLU = ((com.tencent.luggage.sdk.b.a.d.d)aqX()).aqZ().asz();
    Object localObject = paramJSONObject.optJSONObject("wxAppInfo");
    if (localObject == null) {
      localObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        i = 0;
        if (i < localAppBrandSysConfigLU.eqf.qXe.length)
        {
          localJSONArray.put(localAppBrandSysConfigLU.eqf.qXe[i]);
          i += 1;
          continue;
        }
        ((com.tencent.luggage.sdk.b.a.d.d)aqX()).d((JSONObject)localObject, "subContextImgDomain", localJSONArray);
      }
      catch (Exception localException)
      {
        int i;
        boolean bool2;
        boolean bool1;
        continue;
      }
      ((com.tencent.luggage.sdk.b.a.d.d)aqX()).d(paramJSONObject, "wxAppInfo", localObject);
      Log.i("Luggage.AppBrandGameServiceLogicImp", "dm.widthPixels %d, dm.heightPixels %d", new Object[] { Integer.valueOf(this.eml.getMagicBrush().eHA.avA()), Integer.valueOf(this.eml.getMagicBrush().eHA.avB()) });
      localObject = ((com.tencent.luggage.sdk.b.a.d.d)aqX()).aqZ();
      if ((((AppBrandRuntime)localObject).getWindowAndroid() instanceof com.tencent.mm.plugin.appbrand.platform.window.a.o))
      {
        i = ((com.tencent.mm.plugin.appbrand.platform.window.a.o)((AppBrandRuntime)localObject).getWindowAndroid()).cIa().getDefaultDisplay().getRotation();
        bool2 = org.apache.commons.c.a.contains(new int[] { 0, 1 }, i);
        if (com.tencent.mm.plugin.appbrand.platform.window.e.b.afK(((AppBrandRuntime)localObject).getAppConfig().qVI.euP) == com.tencent.mm.plugin.appbrand.platform.window.e.b.tLh)
        {
          bool1 = true;
          if (bool2 != bool1)
          {
            i = 0;
            if (i == 0)
            {
              Log.e("Luggage.AppBrandGameServiceLogicImp", "hy: orientation judge failed! maybe because onConfigurationChange judgement and surface degree judgement not match");
              ((com.tencent.mm.plugin.appbrand.x.a)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(808L, 4L, 1L, false);
              ((com.tencent.mm.plugin.appbrand.x.b)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.b.class)).b(18284, new Object[] { Integer.valueOf(1) });
            }
            ((com.tencent.luggage.sdk.b.a.d.d)aqX()).d(paramJSONObject, "screenWidth", Integer.valueOf(this.eml.getMagicBrush().eHA.avA()));
            ((com.tencent.luggage.sdk.b.a.d.d)aqX()).d(paramJSONObject, "screenHeight", Integer.valueOf(this.eml.getMagicBrush().eHA.avB()));
            ((com.tencent.luggage.sdk.b.a.d.d)aqX()).d(paramJSONObject, "devicePixelRatio", Float.valueOf(this.eml.getMagicBrush().eHA.getDevicePixelRatio()));
            ((com.tencent.luggage.sdk.b.a.d.d)aqX()).d(paramJSONObject, "supportInvokeWithAppId", Boolean.valueOf(((com.tencent.luggage.sdk.b.a.d.d)aqX()).aqZ().evw.tEy));
            AppMethodBeat.o(130560);
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
      }
      i = 1;
    }
  }
  
  public final void eU(String paramString)
  {
    AppMethodBeat.i(178033);
    Log.d("Luggage.AppBrandGameServiceLogicImp", "RemoteDebugInfo %s", new Object[] { paramString });
    gcg localgcg = new gcg();
    localgcg.acau = ((com.tencent.luggage.sdk.b.a.d.d)aqX()).arB().getComponentId();
    localgcg.rRQ = paramString;
    paramString = x.a(localgcg, this.emi, "domEvent");
    this.emf.a(paramString);
    AppMethodBeat.o(178033);
  }
  
  public final boolean eV(String paramString)
  {
    AppMethodBeat.i(220291);
    Log.i("Luggage.AppBrandGameServiceLogicImp", "hy: do nothing in game service when called from modularizing helper");
    AppMethodBeat.o(220291);
    return false;
  }
  
  public final com.tencent.magicbrush.e getMagicBrush()
  {
    AppMethodBeat.i(369540);
    com.tencent.magicbrush.e locale = this.eml.getMagicBrush();
    AppMethodBeat.o(369540);
    return locale;
  }
  
  protected void ml(int paramInt) {}
  
  final class a
    implements z.b
  {
    private final String emu;
    private final String emv;
    private final long emw;
    private boolean emx;
    private m.c emy;
    private final AtomicInteger emz;
    
    a(String paramString)
    {
      AppMethodBeat.i(130541);
      this.emw = l;
      this.emx = false;
      this.emy = null;
      this.emz = new AtomicInteger(2);
      this.emu = paramString;
      Object localObject1;
      this.emv = localObject1;
      AppMethodBeat.o(130541);
    }
    
    private void apG()
    {
      AppMethodBeat.i(130545);
      long l1;
      if (this.emz.decrementAndGet() == 0)
      {
        if (this.emy != null) {
          break label111;
        }
        l1 = this.emw;
        if (this.emy != null) {
          break label122;
        }
      }
      label111:
      label122:
      for (long l2 = System.currentTimeMillis();; l2 = this.emy.hnf)
      {
        com.tencent.luggage.sdk.b.a.d.a locala = new com.tencent.luggage.sdk.b.a.d.a();
        locala.scriptName = this.emu;
        locala.eqP = this.emv;
        locala.eqQ = Util.nullAsNil(this.emv).length();
        ((com.tencent.luggage.sdk.b.a.d.d)a.this.aqX()).a(locala, this.emx, l1, l2, this.emy);
        AppMethodBeat.o(130545);
        return;
        l1 = this.emy.hne;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(130542);
      this.emy = paramc;
      apG();
      AppMethodBeat.o(130542);
    }
    
    public final void eW(String paramString)
    {
      AppMethodBeat.i(130544);
      Log.e("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script Failed: %s", new Object[] { paramString });
      a.apF();
      this.emx = false;
      apG();
      AppMethodBeat.o(130544);
    }
    
    public final void onSuccess(String paramString)
    {
      AppMethodBeat.i(130543);
      Log.i("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script suc: %s, filelen: %d", new Object[] { paramString, Integer.valueOf(bool) });
      a.apE();
      this.emx = true;
      apG();
      AppMethodBeat.o(130543);
    }
  }
  
  public static final class b
    implements com.tencent.luggage.sdk.b.a.b.a
  {}
  
  final class c
    implements com.tencent.magicbrush.e.b, e.d
  {
    private c() {}
    
    public final void onConsole(String paramString)
    {
      AppMethodBeat.i(130552);
      Log.i("Luggage.AppBrandGameServiceLogicImp", "[WAGame][CONSOLE] output = [%s]", new Object[] { paramString });
      com.tencent.luggage.sdk.e.d locald = ((com.tencent.luggage.sdk.b.a.d.d)a.this.aqX()).aqZ();
      if ((locald == null) || (locald.asz() == null) || (locald.asz().epz)) {
        a.a(a.this, paramString);
      }
      AppMethodBeat.o(130552);
    }
    
    public final void onFirstFrame()
    {
      AppMethodBeat.i(130553);
      a.e(a.this);
      AppMethodBeat.o(130553);
    }
    
    public final void onJSError(String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(130554);
      Log.e("Luggage.AppBrandGameServiceLogicImp", "[WAGame][AppBrand] message = [%s] stackTrace = [%s]", new Object[] { paramString1, paramString2 });
      Object localObject = (com.tencent.mm.plugin.appbrand.n.t)((com.tencent.luggage.sdk.b.a.d.d)a.this.aqX()).getJsRuntime().Z(com.tencent.mm.plugin.appbrand.n.t.class);
      if (paramInt == ((com.tencent.mm.plugin.appbrand.n.t)localObject).czi().czh())
      {
        di.a(((com.tencent.luggage.sdk.b.a.d.d)a.this.aqX()).getJsRuntime(), "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.utils.y.agF(paramString1), com.tencent.mm.plugin.appbrand.utils.y.agF(paramString2) }), 0);
        AppMethodBeat.o(130554);
        return;
      }
      localObject = ((com.tencent.mm.plugin.appbrand.n.t)localObject).BK(paramInt);
      if (localObject == null)
      {
        paramString1 = new IllegalStateException("j2v8 not follow the pattern");
        AppMethodBeat.o(130554);
        throw paramString1;
      }
      dj.a((i)localObject, "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.utils.y.agF(paramString1), com.tencent.mm.plugin.appbrand.utils.y.agF(paramString2) }));
      AppMethodBeat.o(130554);
    }
  }
  
  final class d
    implements MagicBrushView.c
  {
    private boolean firstTime = true;
    
    private d() {}
    
    private void apH()
    {
      AppMethodBeat.i(177433);
      com.tencent.luggage.sdk.b.a.d.d locald = (com.tencent.luggage.sdk.b.a.d.d)a.this.aqX();
      if (locald != null)
      {
        Log.i("Luggage.AppBrandGameServiceLogicImp", "hy: on resizeWindow");
        locald.a(new com.tencent.mm.plugin.appbrand.page.t());
      }
      AppMethodBeat.o(177433);
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(178032);
      if (this.firstTime)
      {
        this.firstTime = false;
        com.tencent.mm.plugin.appbrand.keylogger.c.b(a.this.getAppId(), KSProcessWeAppLaunch.stepSurfaceAvailable);
        AppMethodBeat.o(178032);
        return;
      }
      apH();
      AppMethodBeat.o(178032);
    }
    
    public final void c(Object paramObject, boolean paramBoolean) {}
    
    public final void e(Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(130556);
      apH();
      AppMethodBeat.o(130556);
    }
  }
  
  final class e
    implements MagicBrushView.g
  {
    private e() {}
    
    public final void mm(int paramInt)
    {
      AppMethodBeat.i(130557);
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("onMainCanvasTypeDefined received invalid input [" + paramInt + "]");
        AppMethodBeat.o(130557);
        throw localIllegalStateException;
      }
      if ((!((com.tencent.luggage.sdk.b.a.d.d)a.this.aqX()).cdi()) && (!((com.tencent.luggage.sdk.b.a.d.d)a.this.aqX()).isRunning()))
      {
        AppMethodBeat.o(130557);
        return;
      }
      a.this.ml(paramInt);
      AppMethodBeat.o(130557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */