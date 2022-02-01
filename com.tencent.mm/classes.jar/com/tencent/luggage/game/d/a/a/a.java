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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.j;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.bc;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.debugger.w;
import com.tencent.mm.plugin.appbrand.jsapi.cx;
import com.tencent.mm.plugin.appbrand.jsapi.cy;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.l;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.ag;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.plugin.appbrand.utils.s.b;
import com.tencent.mm.plugin.appbrand.utils.t.1;
import com.tencent.mm.plugin.appbrand.utils.t.a;
import com.tencent.mm.protocal.protobuf.evi;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import org.json.JSONArray;
import org.json.JSONObject;

public class a<Service extends com.tencent.luggage.sdk.b.a.c.d>
  extends com.tencent.luggage.sdk.b.a.c.f<Service>
  implements b
{
  private volatile boolean cvU;
  private boolean cvV;
  private com.tencent.mm.plugin.appbrand.debugger.o cvW;
  private boolean cvX;
  private boolean cvY;
  private int cvZ;
  public com.tencent.luggage.game.a.b cwa;
  private com.tencent.luggage.sdk.b.a.a.c cwb;
  private com.tencent.luggage.sdk.b.a.a.a cwc;
  private com.tencent.luggage.sdk.b.a.a.d cwd;
  private com.tencent.luggage.game.c.e cwe;
  private com.tencent.mm.plugin.appbrand.debugger.m cwf;
  
  public a(Service paramService)
  {
    super(paramService);
    AppMethodBeat.i(130561);
    this.cvU = false;
    this.cvV = false;
    this.cvW = null;
    this.cvX = false;
    this.cvY = false;
    this.cvZ = 0;
    this.cwa = null;
    this.cwe = null;
    this.cwf = null;
    b(b.class, this);
    Mi();
    AppMethodBeat.o(130561);
  }
  
  private void MA()
  {
    AppMethodBeat.i(130578);
    if (this.cvV)
    {
      AppMethodBeat.o(130578);
      return;
    }
    this.cvV = true;
    Log.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame to MainContext");
    Object localObject1 = My();
    com.tencent.mm.plugin.appbrand.utils.s.a(((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime(), (String)localObject1, new s.a()
    {
      public final void du(String paramAnonymousString)
      {
        AppMethodBeat.i(162102);
        Log.e("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script Failed: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(162102);
      }
      
      public final void onSuccess(String paramAnonymousString)
      {
        AppMethodBeat.i(162101);
        Log.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script suc: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(162101);
      }
    });
    Object localObject2 = ((com.tencent.luggage.sdk.b.a.c.d)NN()).bqZ().UM("WAGame.js");
    Object localObject3 = "v" + ((com.tencent.luggage.sdk.b.a.c.d)NN()).bqZ().bvd();
    bc.a((com.tencent.mm.plugin.appbrand.d)NN(), ((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime());
    ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(778L, 13L, 1L, false);
    final long l = System.currentTimeMillis();
    final boolean bool = ((com.tencent.luggage.sdk.b.a.c.d)NN()).bsW();
    if (localObject2 == null) {}
    String str;
    for (int i = 0;; i = ((String)localObject2).length())
    {
      localObject1 = new a("WAGame.js", (String)localObject2, l, i, bool);
      if ((((com.tencent.luggage.sdk.b.a.c.d)NN()).NP() == null) || (!((com.tencent.luggage.sdk.b.a.c.d)NN()).NP().OQ())) {
        break label423;
      }
      str = ";(function(global) { var protectedConsole = global.console; Object.defineProperty(global, 'console', { get() { return protectedConsole; }, set() { } }); })(this);".concat(String.valueOf(localObject2));
      localObject2 = (com.tencent.mm.plugin.appbrand.s)NN();
      localObject4 = ((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime();
      localObject3 = t.a.ohc;
      if (!Util.isNullOrNil(str)) {
        break;
      }
      ((s.a)localObject1).du("isNullOrNil script");
      AppMethodBeat.o(130578);
      return;
    }
    Object localObject4 = (l)((i)localObject4).R(l.class);
    if (localObject4 != null) {
      str = str + String.format(Locale.ENGLISH, ";(function(){return %d;})();", new Object[] { Integer.valueOf(11111) });
    }
    try
    {
      localObject2 = new URL(com.tencent.mm.plugin.appbrand.utils.t.a((com.tencent.mm.plugin.appbrand.s)localObject2, (t.a)localObject3) + "WAGame.js");
      ((l)localObject4).a(str, ((URL)localObject2).toString(), new t.1((s.a)localObject1));
      AppMethodBeat.o(130578);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      AppMethodBeat.o(130578);
      return;
    }
    label423:
    com.tencent.mm.plugin.appbrand.utils.t.a((com.tencent.mm.plugin.appbrand.s)NN(), ((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime(), "WAGame.js", "WAGame.js", (String)localObject3, Mz(), (String)localObject2, t.a.ohc, localMalformedURLException);
    AppMethodBeat.o(130578);
  }
  
  private void Mq()
  {
    AppMethodBeat.i(130569);
    try
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime();
      if (localObject == null)
      {
        AppMethodBeat.o(130569);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.m.q)((i)localObject).R(com.tencent.mm.plugin.appbrand.m.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.m.q)localObject).setThreadPriority(-8);
      }
      AppMethodBeat.o(130569);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(130569);
    }
  }
  
  private void Mv()
  {
    boolean bool = true;
    AppMethodBeat.i(130573);
    if (this.cwa != null) {}
    for (;;)
    {
      Log.i("Luggage.AppBrandGameServiceLogicImp", "setup magicbrush. loaded?[%b]", new Object[] { Boolean.valueOf(bool) });
      if (this.cwa == null) {
        break;
      }
      AppMethodBeat.o(130573);
      return;
      bool = false;
    }
    ((com.tencent.luggage.sdk.b.a.c.d)NN()).bEb();
    this.cvX = Mr();
    this.cvY = Ms();
    this.cvZ = Mt();
    this.cwa = a(this.cvX, this.cvY, this.cvZ, Mu());
    this.cwa.LQ();
    c localc = new c((byte)0);
    this.cwa.getMagicBrush().cLy.add(localc);
    this.cwa.getMagicBrush().cLx.add(localc);
    this.cwa.getMagicBrush().cLz.addListener(new MBViewManager.a()
    {
      public final void a(MagicBrushView paramAnonymousMagicBrushView) {}
      
      public final void b(MagicBrushView paramAnonymousMagicBrushView)
      {
        AppMethodBeat.i(222879);
        a.e locale = new a.e(a.this, (byte)0);
        p.h(locale, "l");
        paramAnonymousMagicBrushView.cOU.add(locale);
        paramAnonymousMagicBrushView.a(new a.d(a.this, (byte)0));
        AppMethodBeat.o(222879);
      }
    });
    AppMethodBeat.o(130573);
  }
  
  public final void MB()
  {
    AppMethodBeat.i(130579);
    super.MB();
    Object localObject;
    if ((((com.tencent.luggage.sdk.b.a.c.d)NN()).NP() != null) && (((com.tencent.luggage.sdk.b.a.c.d)NN()).NP().OQ()))
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(162103);
          a.a(a.this, new com.tencent.mm.plugin.appbrand.debugger.o());
          a.a(a.this, new com.tencent.mm.plugin.appbrand.debugger.m());
          a.b(a.this).a((com.tencent.luggage.sdk.b.a.c.d)a.this.NN(), ((com.tencent.luggage.sdk.b.a.c.d)a.this.NN()).NP().ON().extInfo);
          a.c(a.this).a(a.b(a.this));
          AppMethodBeat.o(162103);
        }
      });
      localObject = (l)((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime().R(l.class);
      if (localObject != null) {
        ((l)localObject).abQ("xdebug");
      }
      if (((com.tencent.luggage.sdk.b.a.c.d)NN()).bsX()) {
        localObject = ((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime();
      }
    }
    try
    {
      URL localURL = new URL("https://usr/" + "break.js");
      ((i)localObject).a(localURL, "breakprogram();", null);
      AppMethodBeat.o(130579);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      AppMethodBeat.o(130579);
    }
  }
  
  public final void MC()
  {
    AppMethodBeat.i(130580);
    Log.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.init");
    this.cvU = true;
    Log.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl mServiceReady = [%b], isRunning[%b]", new Object[] { Boolean.valueOf(this.cvU), Boolean.valueOf(((com.tencent.luggage.sdk.b.a.c.d)NN()).isRunning()) });
    if ((!this.cvU) || (!((com.tencent.luggage.sdk.b.a.c.d)NN()).isRunning()))
    {
      AppMethodBeat.o(130580);
      return;
    }
    try
    {
      Log.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl start");
      if (!this.cvV) {
        ((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime().evaluateJavascript(com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/android.js"), null);
      }
      ((com.tencent.luggage.sdk.b.a.c.d)NN()).Os();
      MA();
      ((com.tencent.luggage.sdk.b.a.c.d)NN()).P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(162100);
          a.a(a.this);
          AppMethodBeat.o(162100);
        }
      });
      AppMethodBeat.o(130580);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      if (((com.tencent.luggage.sdk.b.a.c.d)NN()).isRunning())
      {
        AppMethodBeat.o(130580);
        throw localNullPointerException;
      }
      AppMethodBeat.o(130580);
    }
  }
  
  public final void MD()
  {
    AppMethodBeat.i(130582);
    Log.i("Luggage.AppBrandGameServiceLogicImp", "start preload");
    Mv();
    MA();
    ((com.tencent.luggage.sdk.b.a.c.d)NN()).bEc();
    Log.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppService preloaded.");
    AppMethodBeat.o(130582);
  }
  
  public final com.tencent.luggage.game.c.e Mg()
  {
    AppMethodBeat.i(130558);
    if (this.cwe == null) {}
    try
    {
      if (this.cwe == null) {
        this.cwe = new com.tencent.luggage.game.c.e();
      }
      com.tencent.luggage.game.c.e locale = this.cwe;
      AppMethodBeat.o(130558);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(130558);
    }
  }
  
  public final String Mh()
  {
    AppMethodBeat.i(130559);
    Object localObject = ((com.tencent.luggage.sdk.b.a.c.d)NN()).Or();
    String str = ((com.tencent.luggage.sdk.b.a.c.d)NN()).NP().getAppConfig().lcc;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(130559);
    return localObject;
  }
  
  protected void Mi()
  {
    AppMethodBeat.i(130562);
    new com.tencent.luggage.game.b.d().LW();
    AppMethodBeat.o(130562);
  }
  
  public final boolean Mj()
  {
    return true;
  }
  
  public i Mk()
  {
    AppMethodBeat.i(130563);
    Log.i("Luggage.AppBrandGameServiceLogicImp", "createJsRuntime");
    long l = System.currentTimeMillis();
    Object localObject2 = Mo();
    Object localObject1 = null;
    if (Mp()) {
      if (!com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) {
        break label189;
      }
    }
    label189:
    for (localObject1 = com.tencent.mm.plugin.appbrand.ac.d.afB("wxa_library/v8_snapshot64.bin");; localObject1 = com.tencent.mm.plugin.appbrand.ac.d.afB("wxa_library/v8_snapshot.bin"))
    {
      localObject1 = d((String)localObject2, (byte[])localObject1);
      localObject2 = (com.tencent.mm.plugin.appbrand.m.t)((i)localObject1).R(com.tencent.mm.plugin.appbrand.m.t.class);
      localObject2 = a((com.tencent.luggage.sdk.b.a.c.d)NN(), (com.tencent.mm.plugin.appbrand.m.t)localObject2);
      ((i)localObject1).setJsExceptionHandler(new com.tencent.mm.plugin.appbrand.m.h()
      {
        public final void u(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(130540);
          Object localObject = (com.tencent.luggage.sdk.b.a.c.d)a.this.NN();
          if (localObject == null) {}
          for (localObject = null; localObject == null; localObject = ((com.tencent.luggage.sdk.b.a.c.d)localObject).getJsRuntime())
          {
            AppMethodBeat.o(130540);
            return;
          }
          Log.e("Luggage.AppBrandGameServiceLogicImp", "[WAGameJsException] hy: wxa main context exception %s %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          cx.a((com.tencent.mm.plugin.appbrand.m.o)localObject, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { r.afJ(paramAnonymousString1), r.afJ(paramAnonymousString2) }), 0);
          com.tencent.mm.plugin.appbrand.aa.b.a.bVD();
          com.tencent.mm.plugin.appbrand.aa.b.N("WeAppLaunch", paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(130540);
        }
      });
      ((i)localObject1).addJavascriptInterface(localObject2, "WeixinJSContext");
      com.tencent.mm.plugin.appbrand.utils.s.a((i)localObject1, com.tencent.luggage.sdk.b.a.c.h.cBq, new e.1((e)localObject2));
      com.tencent.mm.plugin.appbrand.utils.s.a((i)localObject1, String.format(";(function(){let interface = %s;let alloc = interface.alloc;let allocNativeGlobal = interface.allocNativeGlobal;interface.alloc = function(injectNativeGlobal) {if(injectNativeGlobal){return allocNativeGlobal();}else{return alloc();}}})();", new Object[] { "WeixinJSContext" }), new e.2((e)localObject2));
      ((e)localObject2).MJ();
      Log.i("Luggage.AppBrandGameServiceLogicImp", "[damonlei] createJsRuntime cost [%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(130563);
      return localObject1;
    }
  }
  
  public void Ml()
  {
    AppMethodBeat.i(130566);
    super.Ml();
    this.cwb = new com.tencent.luggage.sdk.b.a.a.c();
    this.cwb.a(((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime(), NN());
    this.cwc = new com.tencent.luggage.sdk.b.a.a.a();
    com.tencent.luggage.sdk.b.a.a.a locala = this.cwc;
    i locali = ((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime();
    Object localObject = NN();
    Log.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding");
    if (locali == null) {
      Log.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsruntime is null");
    }
    for (;;)
    {
      this.cwd = new com.tencent.luggage.sdk.b.a.a.d();
      this.cwd.a(((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime(), NN(), 1);
      AppMethodBeat.o(130566);
      return;
      locala.czC = "1004";
      com.tencent.mm.game.a.a.loadLibraries();
      com.tencent.mm.plugin.appbrand.m.q localq = (com.tencent.mm.plugin.appbrand.m.q)locali.R(com.tencent.mm.plugin.appbrand.m.q.class);
      if (localq == null)
      {
        Log.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsThreadHandler is null");
      }
      else
      {
        localObject = (com.tencent.luggage.sdk.b.a.a.b)((com.tencent.mm.plugin.appbrand.jsapi.f)localObject).M(com.tencent.luggage.sdk.b.a.a.b.class);
        if (localObject != null)
        {
          locala.czD = ((com.tencent.luggage.sdk.b.a.a.b)localObject).Oa();
          Log.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(locala.czD) });
        }
        localq.post(new com.tencent.luggage.sdk.b.a.a.a.3(locala, locali, new com.tencent.luggage.sdk.b.a.a.a.1(locala, new WeakReference(localq)), new com.tencent.luggage.sdk.b.a.a.a.2(locala)));
      }
    }
  }
  
  public void Mm()
  {
    AppMethodBeat.i(130567);
    super.Mm();
    if (this.cwa != null) {
      this.cwa.destroy();
    }
    if (this.cwb != null) {
      this.cwb.a(((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime());
    }
    com.tencent.luggage.sdk.b.a.a.a locala;
    i locali;
    if (this.cwc != null)
    {
      locala = this.cwc;
      locali = ((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime();
      Log.i("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding");
      if (locali != null) {
        break label124;
      }
      Log.e("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding jsruntime is null");
    }
    for (;;)
    {
      if (this.cwd != null) {
        this.cwd.b(((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime());
      }
      AppMethodBeat.o(130567);
      return;
      label124:
      ((com.tencent.mm.plugin.appbrand.m.m)locali.R(com.tencent.mm.plugin.appbrand.m.m.class)).a(locala.czE);
    }
  }
  
  public void Mn()
  {
    AppMethodBeat.i(130568);
    super.Mn();
    if (this.cwa != null)
    {
      Object localObject = this.cwa;
      Log.i("MicroMsg.MagicBrush", "awaitDestroyDone");
      if ((!((com.tencent.luggage.game.a.d)localObject).cuk.aZ(5000L)) && (BuildInfo.DEBUG))
      {
        localObject = (Throwable)new IllegalStateException("WAGame destroy timeout");
        AppMethodBeat.o(130568);
        throw ((Throwable)localObject);
      }
    }
    if (this.cvW != null) {
      this.cvW.destroy();
    }
    AppMethodBeat.o(130568);
  }
  
  protected String Mo()
  {
    return null;
  }
  
  protected boolean Mp()
  {
    return true;
  }
  
  protected boolean Mr()
  {
    AppMethodBeat.i(130571);
    if (((com.tencent.luggage.sdk.b.a.c.d)NN()).NP() != null)
    {
      com.tencent.mm.plugin.appbrand.config.b localb = ((com.tencent.luggage.sdk.b.a.c.d)NN()).NP().getAppConfig();
      if (localb.lbQ != null)
      {
        boolean bool = localb.lbQ.booleanValue();
        AppMethodBeat.o(130571);
        return bool;
      }
    }
    AppMethodBeat.o(130571);
    return true;
  }
  
  protected boolean Ms()
  {
    return true;
  }
  
  protected int Mt()
  {
    return 1;
  }
  
  protected boolean Mu()
  {
    return false;
  }
  
  public final void Mw()
  {
    AppMethodBeat.i(130574);
    Log.i("Luggage.AppBrandGameServiceLogicImp", "onRuntimeResume");
    super.Mw();
    Mq();
    if (this.cvW != null) {
      this.cvW.lix.bringToFront();
    }
    AppMethodBeat.o(130574);
  }
  
  public final void Mx()
  {
    AppMethodBeat.i(130575);
    super.Mx();
    try
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime();
      if (localObject == null)
      {
        AppMethodBeat.o(130575);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.m.q)((i)localObject).R(com.tencent.mm.plugin.appbrand.m.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.m.q)localObject).setThreadPriority(10);
      }
      AppMethodBeat.o(130575);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(130575);
    }
  }
  
  protected String My()
  {
    AppMethodBeat.i(130577);
    String str = com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/android.js") + com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/shared_buffer.js") + com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/lazy_load.js") + com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/NativeGlobal-WAGame.js");
    AppMethodBeat.o(130577);
    return str;
  }
  
  protected int Mz()
  {
    return 0;
  }
  
  protected com.tencent.luggage.game.a.b a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(222881);
    com.tencent.luggage.game.a.b local3 = new com.tencent.luggage.game.a.b(((com.tencent.luggage.sdk.b.a.c.d)NN()).getContext(), ((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime(), paramBoolean1, paramBoolean2, paramInt, paramBoolean3)
    {
      public final void a(com.tencent.magicbrush.f paramAnonymousf)
      {
        AppMethodBeat.i(222878);
        super.a(paramAnonymousf);
        paramAnonymousf.b(com.tencent.magicbrush.ui.a.b.cOA);
        paramAnonymousf.cs(true);
        paramAnonymousf.cu(true);
        AppMethodBeat.o(222878);
      }
    };
    AppMethodBeat.o(222881);
    return local3;
  }
  
  protected e a(Service paramService, com.tencent.mm.plugin.appbrand.m.t paramt)
  {
    AppMethodBeat.i(130565);
    paramService = new e(paramService, paramt);
    AppMethodBeat.o(130565);
    return paramService;
  }
  
  public void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130570);
    super.c(paramAppBrandRuntime);
    Mv();
    if (this.cwa != null) {
      this.cwa.b(paramAppBrandRuntime);
    }
    if (this.cwd != null) {
      this.cwd.a(((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime(), (k)NN());
    }
    com.tencent.luggage.sdk.b.a.a.a locala;
    Object localObject;
    com.tencent.mm.plugin.appbrand.jsapi.f localf;
    if (this.cwc != null)
    {
      locala = this.cwc;
      localObject = ((com.tencent.luggage.sdk.b.a.c.d)NN()).getJsRuntime();
      localf = NN();
      Log.i("Luggage.LockStepNativeInstallHelper", "initConfigLockStep");
      if (localObject != null) {
        break label160;
      }
      Log.e("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsruntime is null");
    }
    for (;;)
    {
      Mq();
      paramAppBrandRuntime.b(ag.class, new com.tencent.luggage.game.f.a(paramAppBrandRuntime));
      this.cwa.getMagicBrush().cLz.addSurfaceListenerForAllViews(new MagicBrushView.d()
      {
        public final void a(Object paramAnonymousObject, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(222877);
          paramAnonymousObject = a.this.NP();
          if ((paramAnonymousObject != null) && (paramAnonymousObject.kAH != null)) {
            paramAnonymousObject.kAH.gK(false);
          }
          AppMethodBeat.o(222877);
        }
        
        public final void aJ(Object paramAnonymousObject)
        {
          AppMethodBeat.i(162096);
          paramAnonymousObject = a.this.NP();
          if ((paramAnonymousObject != null) && (paramAnonymousObject.kAH != null))
          {
            paramAnonymousObject.kAH.gK(true);
            Object localObject = paramAnonymousObject.kAH.kQM;
            paramAnonymousObject = new LinkedList(((com.tencent.mm.plugin.appbrand.a.d)localObject).kRa);
            ((com.tencent.mm.plugin.appbrand.a.d)localObject).kRa.clear();
            while (!paramAnonymousObject.isEmpty())
            {
              localObject = (j)paramAnonymousObject.poll();
              MMHandler localMMHandler = ((j)localObject).mHandler;
              if (localMMHandler != null)
              {
                ((j)localObject).mHandler.removeCallbacks(((j)localObject).task);
                if (Looper.myLooper() == localMMHandler.getLooper()) {
                  ((j)localObject).task.run();
                } else {
                  ((j)localObject).setResultFinish(((j)localObject).result);
                }
              }
            }
          }
          AppMethodBeat.o(162096);
        }
      });
      AppMethodBeat.o(130570);
      return;
      label160:
      localObject = (com.tencent.mm.plugin.appbrand.m.q)((i)localObject).R(com.tencent.mm.plugin.appbrand.m.q.class);
      if (localObject == null) {
        Log.e("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsThreadHandler is null");
      } else {
        ((com.tencent.mm.plugin.appbrand.m.q)localObject).post(new com.tencent.luggage.sdk.b.a.a.a.4(locala, localf));
      }
    }
  }
  
  public void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(130560);
    AppBrandSysConfigLU localAppBrandSysConfigLU = ((com.tencent.luggage.sdk.b.a.c.d)NN()).NP().OM();
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
        if (i < localAppBrandSysConfigLU.czd.ldf.length)
        {
          localJSONArray.put(localAppBrandSysConfigLU.czd.ldf[i]);
          i += 1;
          continue;
        }
        ((com.tencent.luggage.sdk.b.a.c.d)NN()).c((JSONObject)localObject, "subContextImgDomain", localJSONArray);
      }
      catch (Exception localException)
      {
        int i;
        boolean bool2;
        boolean bool1;
        continue;
      }
      ((com.tencent.luggage.sdk.b.a.c.d)NN()).c(paramJSONObject, "wxAppInfo", localObject);
      Log.i("Luggage.AppBrandGameServiceLogicImp", "dm.widthPixels %d, dm.heightPixels %d", new Object[] { Integer.valueOf(this.cwa.getMagicBrush().cLw.Rn()), Integer.valueOf(this.cwa.getMagicBrush().cLw.Ro()) });
      localObject = ((com.tencent.luggage.sdk.b.a.c.d)NN()).NP();
      if ((((AppBrandRuntime)localObject).getWindowAndroid() instanceof com.tencent.mm.plugin.appbrand.platform.window.a.o))
      {
        i = ((com.tencent.mm.plugin.appbrand.platform.window.a.o)((AppBrandRuntime)localObject).getWindowAndroid()).bTX().getDefaultDisplay().getRotation();
        bool2 = org.apache.commons.b.a.contains(new int[] { 0, 1 }, i);
        if (com.tencent.mm.plugin.appbrand.platform.window.e.b.aeE(((AppBrandRuntime)localObject).getAppConfig().lbP.cBG) == com.tencent.mm.plugin.appbrand.platform.window.e.b.nEl)
        {
          bool1 = true;
          if (bool2 != bool1)
          {
            i = 0;
            if (i == 0)
            {
              Log.e("Luggage.AppBrandGameServiceLogicImp", "hy: orientation judge failed! maybe because onConfigurationChange judgement and surface degree judgement not match");
              ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(808L, 4L, 1L, false);
              ((com.tencent.mm.plugin.appbrand.w.b)com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.b.class)).a(18284, new Object[] { Integer.valueOf(1) });
            }
            ((com.tencent.luggage.sdk.b.a.c.d)NN()).c(paramJSONObject, "screenWidth", Integer.valueOf(this.cwa.getMagicBrush().cLw.Rn()));
            ((com.tencent.luggage.sdk.b.a.c.d)NN()).c(paramJSONObject, "screenHeight", Integer.valueOf(this.cwa.getMagicBrush().cLw.Ro()));
            ((com.tencent.luggage.sdk.b.a.c.d)NN()).c(paramJSONObject, "devicePixelRatio", Float.valueOf(this.cwa.getMagicBrush().cLw.getDevicePixelRatio()));
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
  
  protected i d(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130564);
    paramString = new IJSRuntime.Config(paramString, paramArrayOfByte);
    paramString.dpm = true;
    paramString.dpl = "1";
    paramString.dpo = true;
    paramString.dps = new WeakReference(NN());
    paramString = new com.tencent.mm.plugin.appbrand.m.b(paramString);
    AppMethodBeat.o(130564);
    return paramString;
  }
  
  public final boolean d(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222880);
    if ("Image".equals(paramString))
    {
      AppMethodBeat.o(222880);
      return true;
    }
    if ("OffscreenCanvas".equals(paramString))
    {
      AppMethodBeat.o(222880);
      return true;
    }
    if ("MediaToolKit".equals(paramString))
    {
      AppMethodBeat.o(222880);
      return true;
    }
    if ("CpuProfiler".equals(paramString))
    {
      AppMethodBeat.o(222880);
      return true;
    }
    if ("HeapProfiler".equals(paramString))
    {
      AppMethodBeat.o(222880);
      return true;
    }
    if ("Box2D".equals(paramString))
    {
      this.cwa.getMagicBrush().dX("mmbox2d");
      AppMethodBeat.o(222880);
      return true;
    }
    if ("Phys3D".equals(paramString))
    {
      this.cwa.getMagicBrush().dX("mmphysx");
      AppMethodBeat.o(222880);
      return true;
    }
    boolean bool = super.d(paramString, paramJSONObject);
    AppMethodBeat.o(222880);
    return bool;
  }
  
  public final void ds(String paramString)
  {
    AppMethodBeat.i(178033);
    Log.d("Luggage.AppBrandGameServiceLogicImp", "RemoteDebugInfo %s", new Object[] { paramString });
    evi localevi = new evi();
    localevi.Ntn = ((com.tencent.luggage.sdk.b.a.c.d)NN()).Oq().getComponentId();
    localevi.Ntm = paramString;
    paramString = v.a(localevi, this.cwf, "domEvent");
    this.cvW.a(paramString);
    AppMethodBeat.o(178033);
  }
  
  public final boolean dt(String paramString)
  {
    AppMethodBeat.i(222883);
    Log.i("Luggage.AppBrandGameServiceLogicImp", "hy: do nothing in game service when called from modularizing helper");
    AppMethodBeat.o(222883);
    return false;
  }
  
  public final com.tencent.magicbrush.e getMagicBrush()
  {
    AppMethodBeat.i(258491);
    com.tencent.magicbrush.e locale = this.cwa.getMagicBrush();
    AppMethodBeat.o(258491);
    return locale;
  }
  
  protected void hH(int paramInt) {}
  
  final class a
    implements s.b
  {
    private final String cwh;
    private final String cwi;
    private final long cwj;
    private boolean cwk;
    private m.c cwl;
    private final AtomicInteger cwm;
    
    a(String paramString)
    {
      AppMethodBeat.i(130541);
      this.cwj = l;
      this.cwk = false;
      this.cwl = null;
      this.cwm = new AtomicInteger(2);
      this.cwh = paramString;
      Object localObject1;
      this.cwi = localObject1;
      AppMethodBeat.o(130541);
    }
    
    private void MG()
    {
      AppMethodBeat.i(130545);
      long l1;
      if (this.cwm.decrementAndGet() == 0)
      {
        if (this.cwl != null) {
          break label111;
        }
        l1 = this.cwj;
        if (this.cwl != null) {
          break label122;
        }
      }
      label111:
      label122:
      for (long l2 = System.currentTimeMillis();; l2 = this.cwl.dql)
      {
        com.tencent.luggage.sdk.b.a.d.a locala = new com.tencent.luggage.sdk.b.a.d.a();
        locala.scriptName = this.cwh;
        locala.czz = this.cwi;
        locala.czA = Util.nullAsNil(this.cwi).length();
        ((com.tencent.luggage.sdk.b.a.c.d)a.this.NN()).a(locala, this.cwk, l1, l2, this.cwl);
        AppMethodBeat.o(130545);
        return;
        l1 = this.cwl.dqk;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(130542);
      this.cwl = paramc;
      MG();
      AppMethodBeat.o(130542);
    }
    
    public final void du(String paramString)
    {
      AppMethodBeat.i(130544);
      Log.e("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script Failed: %s", new Object[] { paramString });
      a.MF();
      this.cwk = false;
      MG();
      AppMethodBeat.o(130544);
    }
    
    public final void onSuccess(String paramString)
    {
      AppMethodBeat.i(130543);
      Log.i("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script suc: %s, filelen: %d", new Object[] { paramString, Integer.valueOf(bool) });
      a.ME();
      this.cwk = true;
      MG();
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
      com.tencent.luggage.sdk.d.d locald = ((com.tencent.luggage.sdk.b.a.c.d)a.this.NN()).NP();
      if ((locald == null) || (locald.OM() == null) || (locald.OM().cyC)) {
        a.a(a.this, paramString);
      }
      AppMethodBeat.o(130552);
    }
    
    public final void onFirstFrame()
    {
      AppMethodBeat.i(130553);
      a.d(a.this);
      AppMethodBeat.o(130553);
    }
    
    public final void onJSError(String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(130554);
      Log.e("Luggage.AppBrandGameServiceLogicImp", "[WAGame][AppBrand] message = [%s] stackTrace = [%s]", new Object[] { paramString1, paramString2 });
      Object localObject = (com.tencent.mm.plugin.appbrand.m.t)((com.tencent.luggage.sdk.b.a.c.d)a.this.NN()).getJsRuntime().R(com.tencent.mm.plugin.appbrand.m.t.class);
      if (paramInt == ((com.tencent.mm.plugin.appbrand.m.t)localObject).bMD().bMC())
      {
        cx.a(((com.tencent.luggage.sdk.b.a.c.d)a.this.NN()).getJsRuntime(), "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", new Object[] { r.afJ(paramString1), r.afJ(paramString2) }), 0);
        AppMethodBeat.o(130554);
        return;
      }
      localObject = ((com.tencent.mm.plugin.appbrand.m.t)localObject).xX(paramInt);
      if (localObject == null)
      {
        paramString1 = new IllegalStateException("j2v8 not follow the pattern");
        AppMethodBeat.o(130554);
        throw paramString1;
      }
      cy.a((i)localObject, "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", new Object[] { r.afJ(paramString1), r.afJ(paramString2) }));
      AppMethodBeat.o(130554);
    }
  }
  
  final class d
    implements MagicBrushView.c
  {
    private boolean firstTime = true;
    
    private d() {}
    
    private void MH()
    {
      AppMethodBeat.i(177433);
      com.tencent.luggage.sdk.b.a.c.d locald = (com.tencent.luggage.sdk.b.a.c.d)a.this.NN();
      if (locald != null)
      {
        Log.i("Luggage.AppBrandGameServiceLogicImp", "hy: on resizeWindow");
        locald.a(new com.tencent.mm.plugin.appbrand.page.s());
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
      MH();
      AppMethodBeat.o(178032);
    }
    
    public final void a(Object paramObject, boolean paramBoolean) {}
    
    public final void c(Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(130556);
      MH();
      AppMethodBeat.o(130556);
    }
  }
  
  final class e
    implements MagicBrushView.g
  {
    private e() {}
    
    public final void hI(int paramInt)
    {
      AppMethodBeat.i(130557);
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("onMainCanvasTypeDefined received invalid input [" + paramInt + "]");
        AppMethodBeat.o(130557);
        throw localIllegalStateException;
      }
      if ((!((com.tencent.luggage.sdk.b.a.c.d)a.this.NN()).bsW()) && (!((com.tencent.luggage.sdk.b.a.c.d)a.this.NN()).isRunning()))
      {
        AppMethodBeat.o(130557);
        return;
      }
      a.this.hH(paramInt);
      AppMethodBeat.o(130557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */