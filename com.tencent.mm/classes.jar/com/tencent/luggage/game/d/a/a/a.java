package com.tencent.luggage.game.d.a.a;

import android.content.Context;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.magicbrush.e.d;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView.d;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mars.cdn.CronetLogic.CronetTaskNetworkStateCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.be;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.debugger.x;
import com.tencent.mm.plugin.appbrand.debugger.y;
import com.tencent.mm.plugin.appbrand.jsapi.cy;
import com.tencent.mm.plugin.appbrand.jsapi.cz;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.ui.af;
import com.tencent.mm.plugin.appbrand.utils.u;
import com.tencent.mm.plugin.appbrand.utils.u.a;
import com.tencent.mm.plugin.appbrand.utils.u.b;
import com.tencent.mm.plugin.appbrand.utils.v.a;
import com.tencent.mm.protocal.protobuf.ffu;
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
import org.json.JSONArray;
import org.json.JSONObject;

public class a<Service extends com.tencent.luggage.sdk.b.a.c.d>
  extends com.tencent.luggage.sdk.b.a.c.f<Service>
  implements b
{
  private CronetLogic.CronetTaskNetworkStateCallback cuA;
  private volatile boolean cuk;
  private boolean cul;
  private com.tencent.mm.plugin.appbrand.debugger.q cum;
  private com.tencent.luggage.sdk.b.a.c.j cun;
  private boolean cuo;
  private com.tencent.mm.plugin.appbrand.debugger.o cup;
  private boolean cuq;
  private int cus;
  public com.tencent.luggage.game.a.b cut;
  private com.tencent.luggage.sdk.b.a.a.d cuu;
  private com.tencent.luggage.sdk.b.a.a.c cuv;
  private com.tencent.luggage.sdk.b.a.a.a cuw;
  private com.tencent.luggage.sdk.b.a.a.e cux;
  protected com.tencent.luggage.sdk.b.a.d.b cuy;
  private com.tencent.luggage.game.c.e cuz;
  
  public a(Service paramService)
  {
    super(paramService);
    AppMethodBeat.i(130561);
    this.cuk = false;
    this.cul = false;
    this.cum = null;
    this.cuo = false;
    this.cup = null;
    this.cuq = false;
    this.cus = 0;
    this.cut = null;
    this.cuz = null;
    this.cuA = null;
    b(b.class, this);
    Pa();
    AppMethodBeat.o(130561);
  }
  
  private void Pi()
  {
    AppMethodBeat.i(130569);
    try
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime();
      if (localObject == null)
      {
        AppMethodBeat.o(130569);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.m.q)((i)localObject).Q(com.tencent.mm.plugin.appbrand.m.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.m.q)localObject).ke(-8);
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
  
  private void Pn()
  {
    AppMethodBeat.i(130573);
    if (this.cut != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Luggage.AppBrandGameServiceLogicImp", "setup magicbrush. loaded?[%b]", new Object[] { Boolean.valueOf(bool) });
      if (this.cut == null) {
        break;
      }
      localObject = Boolean.valueOf(Pj());
      if (((Boolean)localObject).booleanValue() != this.cuo)
      {
        Log.i("Luggage.AppBrandGameServiceLogicImp", "update useCommandBuffer before %b now %b", new Object[] { Boolean.valueOf(this.cuo), localObject });
        this.cut.getMagicBrush().cB(((Boolean)localObject).booleanValue());
        this.cuo = ((Boolean)localObject).booleanValue();
      }
      AppMethodBeat.o(130573);
      return;
    }
    ((com.tencent.luggage.sdk.b.a.c.d)QK()).bPz();
    this.cuo = Pj();
    this.cuq = Pk();
    this.cus = Pl();
    this.cut = a(this.cuo, this.cuq, this.cus, Pm());
    this.cut.OH();
    Object localObject = new c((byte)0);
    this.cut.getMagicBrush().cMi.add(localObject);
    this.cut.getMagicBrush().cMh.add(localObject);
    this.cut.getMagicBrush().cMj.addListener(new a.5(this));
    AppMethodBeat.o(130573);
  }
  
  private void Ps()
  {
    AppMethodBeat.i(130578);
    if (this.cul)
    {
      AppMethodBeat.o(130578);
      return;
    }
    this.cul = true;
    Log.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame to MainContext");
    Object localObject = Pq();
    u.a(((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime(), (String)localObject, new a.7(this));
    String str1 = ((com.tencent.luggage.sdk.b.a.c.d)QK()).bBP().acw("WAGame.js");
    String str2 = "v" + ((com.tencent.luggage.sdk.b.a.c.d)QK()).bBP().bGi();
    be.a((com.tencent.mm.plugin.appbrand.g)QK(), ((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime());
    ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(778L, 13L, 1L, false);
    final long l = System.currentTimeMillis();
    final boolean bool = ((com.tencent.luggage.sdk.b.a.c.d)QK()).bDU();
    if (str1 == null) {}
    for (int i = 0;; i = str1.length())
    {
      localObject = new a("WAGame.js", str1, l, i, bool);
      if ((((com.tencent.luggage.sdk.b.a.c.d)QK()).QM() == null) || (!((com.tencent.luggage.sdk.b.a.c.d)QK()).QM().Rp())) {
        break;
      }
      str1 = ";(function(global) { var protectedConsole = global.console; Object.defineProperty(global, 'console', { get() { return protectedConsole; }, set() { } }); })(this);".concat(String.valueOf(str1));
      com.tencent.mm.plugin.appbrand.utils.v.a((com.tencent.mm.plugin.appbrand.v)QK(), ((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime(), "WAGame.js", str1, v.a.riP, (u.a)localObject);
      AppMethodBeat.o(130578);
      return;
    }
    com.tencent.mm.plugin.appbrand.utils.v.a((com.tencent.mm.plugin.appbrand.v)QK(), ((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime(), "WAGame.js", "WAGame.js", str2, Pr(), str1, v.a.riP, (u.a)localObject);
    AppMethodBeat.o(130578);
  }
  
  public final com.tencent.luggage.game.c.e OY()
  {
    AppMethodBeat.i(130558);
    if (this.cuz == null) {}
    try
    {
      if (this.cuz == null) {
        this.cuz = new com.tencent.luggage.game.c.e();
      }
      com.tencent.luggage.game.c.e locale = this.cuz;
      AppMethodBeat.o(130558);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(130558);
    }
  }
  
  public final String OZ()
  {
    AppMethodBeat.i(130559);
    Object localObject = ((com.tencent.luggage.sdk.b.a.c.d)QK()).Ro();
    String str = ((com.tencent.luggage.sdk.b.a.c.d)QK()).QM().getAppConfig().nWl;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(130559);
    return localObject;
  }
  
  protected void Pa()
  {
    AppMethodBeat.i(130562);
    new com.tencent.luggage.game.b.e().OO();
    AppMethodBeat.o(130562);
  }
  
  public final boolean Pb()
  {
    return true;
  }
  
  public i Pc()
  {
    AppMethodBeat.i(130563);
    Log.i("Luggage.AppBrandGameServiceLogicImp", "createJsRuntime");
    long l = System.currentTimeMillis();
    Object localObject2 = Pg();
    Object localObject1 = null;
    if (Ph()) {
      if (!com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) {
        break label189;
      }
    }
    label189:
    for (localObject1 = com.tencent.mm.plugin.appbrand.ac.d.and("wxa_library/v8_snapshot64.bin");; localObject1 = com.tencent.mm.plugin.appbrand.ac.d.and("wxa_library/v8_snapshot.bin"))
    {
      localObject1 = d((String)localObject2, (byte[])localObject1);
      localObject2 = (com.tencent.mm.plugin.appbrand.m.t)((i)localObject1).Q(com.tencent.mm.plugin.appbrand.m.t.class);
      localObject2 = a((com.tencent.luggage.sdk.b.a.c.d)QK(), (com.tencent.mm.plugin.appbrand.m.t)localObject2);
      ((i)localObject1).setJsExceptionHandler(new com.tencent.mm.plugin.appbrand.m.h()
      {
        public final void A(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(130540);
          Object localObject = (com.tencent.luggage.sdk.b.a.c.d)a.this.QK();
          if (localObject == null) {}
          for (localObject = null; localObject == null; localObject = ((com.tencent.luggage.sdk.b.a.c.d)localObject).getJsRuntime())
          {
            AppMethodBeat.o(130540);
            return;
          }
          Log.e("Luggage.AppBrandGameServiceLogicImp", "[WAGameJsException] hy: wxa main context exception %s %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          cy.a((com.tencent.mm.plugin.appbrand.m.o)localObject, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.utils.t.anl(paramAnonymousString1), com.tencent.mm.plugin.appbrand.utils.t.anl(paramAnonymousString2) }), 0);
          com.tencent.mm.plugin.appbrand.aa.b.a.ciK();
          com.tencent.mm.plugin.appbrand.aa.b.M("WeAppLaunch", paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(130540);
        }
      });
      ((i)localObject1).addJavascriptInterface(localObject2, "WeixinJSContext");
      u.a((i)localObject1, com.tencent.luggage.sdk.b.a.c.h.cAz, new e.1((e)localObject2));
      u.a((i)localObject1, String.format(";(function(){let interface = %s;let alloc = interface.alloc;let allocNativeGlobal = interface.allocNativeGlobal;interface.alloc = function(injectNativeGlobal) {if(injectNativeGlobal){return allocNativeGlobal();}else{return alloc();}}})();", new Object[] { "WeixinJSContext" }), new e.2((e)localObject2));
      ((e)localObject2).PB();
      Log.i("Luggage.AppBrandGameServiceLogicImp", "[damonlei] createJsRuntime cost [%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(130563);
      return localObject1;
    }
  }
  
  public void Pd()
  {
    AppMethodBeat.i(130566);
    super.Pd();
    this.cuu = new com.tencent.luggage.sdk.b.a.a.d();
    this.cuu.b(((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime(), QK());
    this.cuv = new com.tencent.luggage.sdk.b.a.a.c();
    this.cuv.a(((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime(), QK());
    this.cuw = new com.tencent.luggage.sdk.b.a.a.a();
    Object localObject1 = this.cuw;
    i locali = ((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime();
    Object localObject2 = QK();
    Log.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding");
    if (locali == null) {
      Log.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsruntime is null");
    }
    for (;;)
    {
      this.cux = new com.tencent.luggage.sdk.b.a.a.e();
      this.cux.a(((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime(), QK(), 1);
      this.cuy = new com.tencent.luggage.sdk.b.a.d.b();
      this.cuy.c(((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime(), QK());
      if ((QM() != null) && (QM().Rp()))
      {
        Log.i("Luggage.AppBrandGameServiceLogicImp", "add MPRemoteDebugJSContextInterface");
        localObject1 = ((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime();
        QK();
        this.cun = new com.tencent.luggage.sdk.b.a.c.j();
        ((i)localObject1).addJavascriptInterface(this.cun, "DebuggerConnection");
        if (this.cum != null) {
          this.cun.cAB = this.cum;
        }
      }
      AppMethodBeat.o(130566);
      return;
      ((com.tencent.luggage.sdk.b.a.a.a)localObject1).cyy = "1004";
      com.tencent.mm.game.b.a.loadLibraries();
      com.tencent.mm.plugin.appbrand.m.q localq = (com.tencent.mm.plugin.appbrand.m.q)locali.Q(com.tencent.mm.plugin.appbrand.m.q.class);
      if (localq == null)
      {
        Log.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsThreadHandler is null");
      }
      else
      {
        localObject2 = (com.tencent.luggage.sdk.b.a.a.b)((com.tencent.mm.plugin.appbrand.jsapi.e)localObject2).K(com.tencent.luggage.sdk.b.a.a.b.class);
        if (localObject2 != null)
        {
          ((com.tencent.luggage.sdk.b.a.a.a)localObject1).cyz = ((com.tencent.luggage.sdk.b.a.a.b)localObject2).QY();
          Log.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(((com.tencent.luggage.sdk.b.a.a.a)localObject1).cyz) });
        }
        localq.post(new com.tencent.luggage.sdk.b.a.a.a.3((com.tencent.luggage.sdk.b.a.a.a)localObject1, locali, new com.tencent.luggage.sdk.b.a.a.a.1((com.tencent.luggage.sdk.b.a.a.a)localObject1, new WeakReference(localq)), new com.tencent.luggage.sdk.b.a.a.a.2((com.tencent.luggage.sdk.b.a.a.a)localObject1)));
      }
    }
  }
  
  public void Pe()
  {
    AppMethodBeat.i(130567);
    super.Pe();
    if (this.cut != null) {
      this.cut.destroy();
    }
    if (this.cuu != null) {
      this.cuu.b(((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime());
    }
    if (this.cuv != null) {
      this.cuv.a(((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime());
    }
    com.tencent.luggage.sdk.b.a.a.a locala;
    i locali;
    if (this.cuw != null)
    {
      locala = this.cuw;
      locali = ((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime();
      Log.i("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding");
      if (locali != null) {
        break label186;
      }
      Log.e("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding jsruntime is null");
    }
    for (;;)
    {
      if (this.cux != null) {
        this.cux.c(((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime());
      }
      if (this.cuy != null) {
        this.cuy.d(((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime());
      }
      if (this.cuA != null) {
        CronetLogic.removeCronetTaskNetworkStateCallback(this.cuA);
      }
      AppMethodBeat.o(130567);
      return;
      label186:
      ((m)locali.Q(m.class)).a(locala.cyA);
    }
  }
  
  public void Pf()
  {
    AppMethodBeat.i(130568);
    super.Pf();
    if (this.cut != null)
    {
      Object localObject = this.cut;
      Log.i("MicroMsg.MagicBrush", "awaitDestroyDone");
      if ((!((com.tencent.luggage.game.a.d)localObject).csp.bi(5000L)) && (BuildInfo.DEBUG))
      {
        localObject = (Throwable)new IllegalStateException("WAGame destroy timeout");
        AppMethodBeat.o(130568);
        throw ((Throwable)localObject);
      }
    }
    if (this.cum != null) {
      this.cum.destroy();
    }
    AppMethodBeat.o(130568);
  }
  
  protected String Pg()
  {
    return null;
  }
  
  protected boolean Ph()
  {
    return true;
  }
  
  protected boolean Pj()
  {
    AppMethodBeat.i(130571);
    if (((com.tencent.luggage.sdk.b.a.c.d)QK()).QM() != null)
    {
      com.tencent.mm.plugin.appbrand.config.b localb = ((com.tencent.luggage.sdk.b.a.c.d)QK()).QM().getAppConfig();
      if (localb.nVZ != null)
      {
        boolean bool = localb.nVZ.booleanValue();
        AppMethodBeat.o(130571);
        return bool;
      }
    }
    AppMethodBeat.o(130571);
    return true;
  }
  
  protected boolean Pk()
  {
    return true;
  }
  
  protected int Pl()
  {
    return 1;
  }
  
  protected boolean Pm()
  {
    return false;
  }
  
  public void Po()
  {
    AppMethodBeat.i(130574);
    Log.i("Luggage.AppBrandGameServiceLogicImp", "onRuntimeResume");
    super.Po();
    Pi();
    if (this.cum != null) {
      this.cum.odf.bringToFront();
    }
    AppMethodBeat.o(130574);
  }
  
  public final void Pp()
  {
    AppMethodBeat.i(130575);
    super.Pp();
    try
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime();
      if (localObject == null)
      {
        AppMethodBeat.o(130575);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.m.q)((i)localObject).Q(com.tencent.mm.plugin.appbrand.m.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.m.q)localObject).ke(10);
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
  
  protected String Pq()
  {
    AppMethodBeat.i(130577);
    String str = com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/android.js") + com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/shared_buffer.js") + com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/lazy_load.js") + com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/puppet_wrapper.js") + com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/NativeGlobal-WAGame.js");
    AppMethodBeat.o(130577);
    return str;
  }
  
  protected int Pr()
  {
    return 0;
  }
  
  public final void Pt()
  {
    AppMethodBeat.i(130579);
    super.Pt();
    if ((((com.tencent.luggage.sdk.b.a.c.d)QK()).QM() != null) && (((com.tencent.luggage.sdk.b.a.c.d)QK()).QM().Rp()))
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(246791);
          a.a(a.this, new com.tencent.mm.plugin.appbrand.debugger.q());
          a.a(a.this, new com.tencent.mm.plugin.appbrand.debugger.o());
          a.b(a.this).a((com.tencent.luggage.sdk.b.a.c.d)a.this.QK(), ((com.tencent.luggage.sdk.b.a.c.d)a.this.QK()).QM().Sk().extInfo);
          a.c(a.this).a(a.b(a.this));
          if (a.d(a.this) != null) {
            a.d(a.this).cAB = a.c(a.this);
          }
          AppMethodBeat.o(246791);
        }
      });
      com.tencent.mm.plugin.appbrand.utils.v.a(((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime(), "xdebug");
      if (((com.tencent.luggage.sdk.b.a.c.d)QK()).bDV())
      {
        i locali = ((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime();
        QK();
        com.tencent.mm.plugin.appbrand.utils.v.b(locali, "https://usr/");
      }
    }
    AppMethodBeat.o(130579);
  }
  
  public final void Pu()
  {
    AppMethodBeat.i(130580);
    Log.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.init");
    this.cuk = true;
    Log.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl mServiceReady = [%b], isRunning[%b]", new Object[] { Boolean.valueOf(this.cuk), Boolean.valueOf(((com.tencent.luggage.sdk.b.a.c.d)QK()).isRunning()) });
    if ((!this.cuk) || (!((com.tencent.luggage.sdk.b.a.c.d)QK()).isRunning()))
    {
      AppMethodBeat.o(130580);
      return;
    }
    try
    {
      Log.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl start");
      if (!this.cul) {
        ((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime().evaluateJavascript(com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/android.js"), null);
      }
      ((com.tencent.luggage.sdk.b.a.c.d)QK()).Rq();
      Ps();
      ((com.tencent.luggage.sdk.b.a.c.d)QK()).P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(130551);
          a.a(a.this);
          AppMethodBeat.o(130551);
        }
      });
      AppMethodBeat.o(130580);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      if (((com.tencent.luggage.sdk.b.a.c.d)QK()).isRunning())
      {
        AppMethodBeat.o(130580);
        throw localNullPointerException;
      }
      AppMethodBeat.o(130580);
    }
  }
  
  public final void Pv()
  {
    AppMethodBeat.i(130582);
    Log.i("Luggage.AppBrandGameServiceLogicImp", "start preload");
    Pn();
    Ps();
    ((com.tencent.luggage.sdk.b.a.c.d)QK()).bPA();
    Log.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppService preloaded.");
    AppMethodBeat.o(130582);
  }
  
  protected com.tencent.luggage.game.a.b a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(247286);
    com.tencent.luggage.game.a.b local4 = new com.tencent.luggage.game.a.b(((com.tencent.luggage.sdk.b.a.c.d)QK()).getContext(), ((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime(), paramBoolean1, paramBoolean2, paramInt, paramBoolean3)
    {
      public final void a(com.tencent.magicbrush.f paramAnonymousf)
      {
        AppMethodBeat.i(247237);
        super.a(paramAnonymousf);
        paramAnonymousf.b(com.tencent.magicbrush.ui.a.b.cPp);
        paramAnonymousf.cG(true);
        paramAnonymousf.cI(true);
        paramAnonymousf.bg(a.this.Rz().czK.getNativeHandle());
        AppMethodBeat.o(247237);
      }
    };
    AppMethodBeat.o(247286);
    return local4;
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
    Pn();
    if (this.cut != null) {
      this.cut.b(paramAppBrandRuntime);
    }
    if (this.cux != null) {
      this.cux.a(((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime(), (com.tencent.mm.plugin.appbrand.jsapi.j)QK());
    }
    com.tencent.luggage.sdk.b.a.a.a locala;
    Object localObject;
    com.tencent.mm.plugin.appbrand.jsapi.e locale;
    if (this.cuw != null)
    {
      locala = this.cuw;
      localObject = ((com.tencent.luggage.sdk.b.a.c.d)QK()).getJsRuntime();
      locale = QK();
      Log.i("Luggage.LockStepNativeInstallHelper", "initConfigLockStep");
      if (localObject != null) {
        break label213;
      }
      Log.e("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsruntime is null");
    }
    for (;;)
    {
      Pi();
      paramAppBrandRuntime.b(af.class, new com.tencent.luggage.game.f.a(paramAppBrandRuntime));
      this.cut.getMagicBrush().cMj.addSurfaceListenerForAllViews(new MagicBrushView.d()
      {
        public final void aG(Object paramAnonymousObject)
        {
          AppMethodBeat.i(162096);
          paramAnonymousObject = a.this.QM();
          if ((paramAnonymousObject != null) && (paramAnonymousObject.ntR != null))
          {
            paramAnonymousObject.ntR.hv(true);
            Object localObject = paramAnonymousObject.ntR.nKU;
            paramAnonymousObject = new LinkedList(((com.tencent.mm.plugin.appbrand.a.d)localObject).nLi);
            ((com.tencent.mm.plugin.appbrand.a.d)localObject).nLi.clear();
            while (!paramAnonymousObject.isEmpty())
            {
              localObject = (com.tencent.mm.plugin.appbrand.a.j)paramAnonymousObject.poll();
              MMHandler localMMHandler = ((com.tencent.mm.plugin.appbrand.a.j)localObject).mHandler;
              if (localMMHandler != null)
              {
                ((com.tencent.mm.plugin.appbrand.a.j)localObject).mHandler.removeCallbacks(((com.tencent.mm.plugin.appbrand.a.j)localObject).task);
                if (Looper.myLooper() == localMMHandler.getLooper()) {
                  ((com.tencent.mm.plugin.appbrand.a.j)localObject).task.run();
                } else {
                  ((com.tencent.mm.plugin.appbrand.a.j)localObject).setResultFinish(((com.tencent.mm.plugin.appbrand.a.j)localObject).result);
                }
              }
            }
          }
          AppMethodBeat.o(162096);
        }
        
        public final void b(Object paramAnonymousObject, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(247581);
          paramAnonymousObject = a.this.QM();
          if ((paramAnonymousObject != null) && (paramAnonymousObject.ntR != null)) {
            paramAnonymousObject.ntR.hv(false);
          }
          AppMethodBeat.o(247581);
        }
      });
      this.cuy.c(QK());
      this.cuA = new CronetLogic.CronetTaskNetworkStateCallback()
      {
        public final void onNetWeakChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(247533);
          com.tencent.mm.plugin.appbrand.jsapi.ab.b.a(a.this.QK(), paramAnonymousBoolean);
          AppMethodBeat.o(247533);
        }
      };
      CronetLogic.addCronetTaskNetworkStateCallback(this.cuA);
      CronetLogic.setGoodNetNotifyInterval(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vXl, 5000));
      AppMethodBeat.o(130570);
      return;
      label213:
      localObject = (com.tencent.mm.plugin.appbrand.m.q)((i)localObject).Q(com.tencent.mm.plugin.appbrand.m.q.class);
      if (localObject == null) {
        Log.e("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsThreadHandler is null");
      } else {
        ((com.tencent.mm.plugin.appbrand.m.q)localObject).post(new com.tencent.luggage.sdk.b.a.a.a.4(locala, locale));
      }
    }
  }
  
  public final boolean c(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(247273);
    if ("Image".equals(paramString))
    {
      AppMethodBeat.o(247273);
      return true;
    }
    if ("OffscreenCanvas".equals(paramString))
    {
      AppMethodBeat.o(247273);
      return true;
    }
    if ("MediaToolKit".equals(paramString))
    {
      AppMethodBeat.o(247273);
      return true;
    }
    if ("CpuProfiler".equals(paramString))
    {
      AppMethodBeat.o(247273);
      return true;
    }
    if ("HeapProfiler".equals(paramString))
    {
      AppMethodBeat.o(247273);
      return true;
    }
    if ("Profiler".equals(paramString))
    {
      AppMethodBeat.o(247273);
      return true;
    }
    if ("Box2D".equals(paramString))
    {
      this.cut.getMagicBrush().ey("mmbox2d");
      AppMethodBeat.o(247273);
      return true;
    }
    if ("Phys3D".equals(paramString))
    {
      this.cut.getMagicBrush().ey("mmphysx");
      AppMethodBeat.o(247273);
      return true;
    }
    boolean bool = super.c(paramString, paramJSONObject);
    AppMethodBeat.o(247273);
    return bool;
  }
  
  protected i d(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130564);
    paramString = new IJSRuntime.Config(paramString, paramArrayOfByte);
    paramString.fhS = true;
    paramString.fhR = "1";
    paramString.fhU = true;
    paramString.fhY = new WeakReference(QK());
    paramString = new com.tencent.mm.plugin.appbrand.m.b(paramString);
    AppMethodBeat.o(130564);
    return paramString;
  }
  
  public final void dJ(String paramString)
  {
    AppMethodBeat.i(178033);
    Log.d("Luggage.AppBrandGameServiceLogicImp", "RemoteDebugInfo %s", new Object[] { paramString });
    ffu localffu = new ffu();
    localffu.UGl = ((com.tencent.luggage.sdk.b.a.c.d)QK()).Rn().getComponentId();
    localffu.UGk = paramString;
    paramString = x.a(localffu, this.cup, "domEvent");
    this.cum.a(paramString);
    AppMethodBeat.o(178033);
  }
  
  public final boolean dK(String paramString)
  {
    AppMethodBeat.i(247294);
    Log.i("Luggage.AppBrandGameServiceLogicImp", "hy: do nothing in game service when called from modularizing helper");
    AppMethodBeat.o(247294);
    return false;
  }
  
  public void f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(130560);
    AppBrandSysConfigLU localAppBrandSysConfigLU = ((com.tencent.luggage.sdk.b.a.c.d)QK()).QM().Sj();
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
        if (i < localAppBrandSysConfigLU.cxL.nXo.length)
        {
          localJSONArray.put(localAppBrandSysConfigLU.cxL.nXo[i]);
          i += 1;
          continue;
        }
        ((com.tencent.luggage.sdk.b.a.c.d)QK()).c((JSONObject)localObject, "subContextImgDomain", localJSONArray);
      }
      catch (Exception localException)
      {
        int i;
        boolean bool2;
        boolean bool1;
        continue;
      }
      ((com.tencent.luggage.sdk.b.a.c.d)QK()).c(paramJSONObject, "wxAppInfo", localObject);
      Log.i("Luggage.AppBrandGameServiceLogicImp", "dm.widthPixels %d, dm.heightPixels %d", new Object[] { Integer.valueOf(this.cut.getMagicBrush().cMg.UX()), Integer.valueOf(this.cut.getMagicBrush().cMg.UY()) });
      localObject = ((com.tencent.luggage.sdk.b.a.c.d)QK()).QM();
      if ((((AppBrandRuntime)localObject).getWindowAndroid() instanceof com.tencent.mm.plugin.appbrand.platform.window.a.o))
      {
        i = ((com.tencent.mm.plugin.appbrand.platform.window.a.o)((AppBrandRuntime)localObject).getWindowAndroid()).chd().getDefaultDisplay().getRotation();
        bool2 = org.apache.commons.b.a.contains(new int[] { 0, 1 }, i);
        if (com.tencent.mm.plugin.appbrand.platform.window.e.b.amy(((AppBrandRuntime)localObject).getAppConfig().nVY.cCi) == com.tencent.mm.plugin.appbrand.platform.window.e.b.qGv)
        {
          bool1 = true;
          if (bool2 != bool1)
          {
            i = 0;
            if (i == 0)
            {
              Log.e("Luggage.AppBrandGameServiceLogicImp", "hy: orientation judge failed! maybe because onConfigurationChange judgement and surface degree judgement not match");
              ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(808L, 4L, 1L, false);
              ((com.tencent.mm.plugin.appbrand.w.b)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.b.class)).a(18284, new Object[] { Integer.valueOf(1) });
            }
            ((com.tencent.luggage.sdk.b.a.c.d)QK()).c(paramJSONObject, "screenWidth", Integer.valueOf(this.cut.getMagicBrush().cMg.UX()));
            ((com.tencent.luggage.sdk.b.a.c.d)QK()).c(paramJSONObject, "screenHeight", Integer.valueOf(this.cut.getMagicBrush().cMg.UY()));
            ((com.tencent.luggage.sdk.b.a.c.d)QK()).c(paramJSONObject, "devicePixelRatio", Float.valueOf(this.cut.getMagicBrush().cMg.getDevicePixelRatio()));
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
  
  public final com.tencent.magicbrush.e getMagicBrush()
  {
    AppMethodBeat.i(292965);
    com.tencent.magicbrush.e locale = this.cut.getMagicBrush();
    AppMethodBeat.o(292965);
    return locale;
  }
  
  protected void iH(int paramInt) {}
  
  final class a
    implements u.b
  {
    private final String cuC;
    private final String cuD;
    private final long cuE;
    private boolean cuF;
    private m.c cuG;
    private final AtomicInteger cuH;
    
    a(String paramString)
    {
      AppMethodBeat.i(130541);
      this.cuE = l;
      this.cuF = false;
      this.cuG = null;
      this.cuH = new AtomicInteger(2);
      this.cuC = paramString;
      Object localObject1;
      this.cuD = localObject1;
      AppMethodBeat.o(130541);
    }
    
    private void Py()
    {
      AppMethodBeat.i(130545);
      long l1;
      if (this.cuH.decrementAndGet() == 0)
      {
        if (this.cuG != null) {
          break label111;
        }
        l1 = this.cuE;
        if (this.cuG != null) {
          break label122;
        }
      }
      label111:
      label122:
      for (long l2 = System.currentTimeMillis();; l2 = this.cuG.fiS)
      {
        com.tencent.luggage.sdk.b.a.d.a locala = new com.tencent.luggage.sdk.b.a.d.a();
        locala.scriptName = this.cuC;
        locala.cyv = this.cuD;
        locala.cyw = Util.nullAsNil(this.cuD).length();
        ((com.tencent.luggage.sdk.b.a.c.d)a.this.QK()).a(locala, this.cuF, l1, l2, this.cuG);
        AppMethodBeat.o(130545);
        return;
        l1 = this.cuG.fiR;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(130542);
      this.cuG = paramc;
      Py();
      AppMethodBeat.o(130542);
    }
    
    public final void dL(String paramString)
    {
      AppMethodBeat.i(130544);
      Log.e("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script Failed: %s", new Object[] { paramString });
      a.Px();
      this.cuF = false;
      Py();
      AppMethodBeat.o(130544);
    }
    
    public final void onSuccess(String paramString)
    {
      AppMethodBeat.i(130543);
      Log.i("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script suc: %s, filelen: %d", new Object[] { paramString, Integer.valueOf(bool) });
      a.Pw();
      this.cuF = true;
      Py();
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
      com.tencent.luggage.sdk.e.d locald = ((com.tencent.luggage.sdk.b.a.c.d)a.this.QK()).QM();
      if ((locald == null) || (locald.Sj() == null) || (locald.Sj().cxh)) {
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
      Object localObject = (com.tencent.mm.plugin.appbrand.m.t)((com.tencent.luggage.sdk.b.a.c.d)a.this.QK()).getJsRuntime().Q(com.tencent.mm.plugin.appbrand.m.t.class);
      if (paramInt == ((com.tencent.mm.plugin.appbrand.m.t)localObject).bYU().bYT())
      {
        cy.a(((com.tencent.luggage.sdk.b.a.c.d)a.this.QK()).getJsRuntime(), "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.utils.t.anl(paramString1), com.tencent.mm.plugin.appbrand.utils.t.anl(paramString2) }), 0);
        AppMethodBeat.o(130554);
        return;
      }
      localObject = ((com.tencent.mm.plugin.appbrand.m.t)localObject).Bx(paramInt);
      if (localObject == null)
      {
        paramString1 = new IllegalStateException("j2v8 not follow the pattern");
        AppMethodBeat.o(130554);
        throw paramString1;
      }
      cz.a((i)localObject, "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.utils.t.anl(paramString1), com.tencent.mm.plugin.appbrand.utils.t.anl(paramString2) }));
      AppMethodBeat.o(130554);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */