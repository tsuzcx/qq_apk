package com.tencent.luggage.game.d.a.a;

import android.content.Context;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.magicbrush.d.b;
import com.tencent.magicbrush.d.d;
import com.tencent.magicbrush.f;
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
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.b.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.debugger.n;
import com.tencent.mm.plugin.appbrand.debugger.u;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.jsapi.cg;
import com.tencent.mm.plugin.appbrand.jsapi.ch;
import com.tencent.mm.plugin.appbrand.jsruntime.g;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m;
import com.tencent.mm.plugin.appbrand.jsruntime.t;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.plugin.appbrand.ui.x;
import com.tencent.mm.plugin.appbrand.utils.p;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.plugin.appbrand.utils.q.b;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.plugin.appbrand.utils.r.1;
import com.tencent.mm.plugin.appbrand.utils.r.a;
import com.tencent.mm.protocal.protobuf.dtq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class a<Service extends com.tencent.luggage.sdk.b.a.c.c>
  extends com.tencent.luggage.sdk.b.a.c.e<Service>
  implements b
{
  private volatile boolean bZD;
  private boolean bZE;
  private n bZF;
  private boolean bZG;
  private boolean bZH;
  private int bZI;
  public com.tencent.luggage.game.a.b bZJ;
  private com.tencent.luggage.sdk.b.a.a.d bZK;
  private com.tencent.luggage.sdk.b.a.a.a bZL;
  private com.tencent.luggage.sdk.b.a.a.e bZM;
  private com.tencent.luggage.game.c.e bZN;
  private com.tencent.mm.plugin.appbrand.debugger.l bZO;
  
  public a(Service paramService)
  {
    super(paramService);
    AppMethodBeat.i(130561);
    this.bZD = false;
    this.bZE = false;
    this.bZF = null;
    this.bZG = false;
    this.bZH = false;
    this.bZI = 0;
    this.bZJ = null;
    this.bZN = null;
    this.bZO = null;
    b(b.class, this);
    Bk();
    AppMethodBeat.o(130561);
  }
  
  private void BC()
  {
    AppMethodBeat.i(130578);
    if (this.bZE)
    {
      AppMethodBeat.o(130578);
      return;
    }
    this.bZE = true;
    ac.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame to MainContext");
    Object localObject1 = BA();
    com.tencent.mm.plugin.appbrand.utils.q.a(((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV(), (String)localObject1, new q.a()
    {
      public final void bZ(String paramAnonymousString)
      {
        AppMethodBeat.i(206101);
        ac.e("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script Failed: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(206101);
      }
      
      public final void onSuccess(String paramAnonymousString)
      {
        AppMethodBeat.i(206100);
        ac.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script suc: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(206100);
      }
    });
    Object localObject2 = ((com.tencent.luggage.sdk.b.a.c.c)CM()).aSt().HL("WAGame.js");
    Object localObject3 = "v" + ((com.tencent.luggage.sdk.b.a.c.c)CM()).aSt().aVU();
    com.tencent.mm.plugin.appbrand.ap.a((com.tencent.mm.plugin.appbrand.d)CM(), ((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV());
    ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(778L, 13L, 1L, false);
    final long l = System.currentTimeMillis();
    final boolean bool = ((com.tencent.luggage.sdk.b.a.c.c)CM()).aUl();
    if (localObject2 == null) {}
    String str;
    for (int i = 0;; i = ((String)localObject2).length())
    {
      localObject1 = new a("WAGame.js", (String)localObject2, l, i, bool);
      if ((((com.tencent.luggage.sdk.b.a.c.c)CM()).CO() == null) || (!((com.tencent.luggage.sdk.b.a.c.c)CM()).CO().DF())) {
        break label423;
      }
      str = ";(function(global) { var protectedConsole = global.console; Object.defineProperty(global, 'console', { get() { return protectedConsole; }, set() { } }); })(this);".concat(String.valueOf(localObject2));
      localObject2 = (com.tencent.mm.plugin.appbrand.q)CM();
      localObject4 = ((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV();
      localObject3 = r.a.mou;
      if (!bs.isNullOrNil(str)) {
        break;
      }
      ((q.a)localObject1).bZ("isNullOrNil script");
      AppMethodBeat.o(130578);
      return;
    }
    Object localObject4 = (com.tencent.mm.plugin.appbrand.jsruntime.l)((i)localObject4).P(com.tencent.mm.plugin.appbrand.jsruntime.l.class);
    if (localObject4 != null) {
      str = str + String.format(Locale.ENGLISH, ";(function(){return %d;})();", new Object[] { Integer.valueOf(11111) });
    }
    try
    {
      localObject2 = new URL(r.a((com.tencent.mm.plugin.appbrand.q)localObject2, (r.a)localObject3) + "WAGame.js");
      ((com.tencent.mm.plugin.appbrand.jsruntime.l)localObject4).a(str, ((URL)localObject2).toString(), new r.1((q.a)localObject1));
      AppMethodBeat.o(130578);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      AppMethodBeat.o(130578);
      return;
    }
    label423:
    r.a((com.tencent.mm.plugin.appbrand.q)CM(), ((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV(), "WAGame.js", "WAGame.js", (String)localObject3, BB(), (String)localObject2, r.a.mou, localMalformedURLException);
    AppMethodBeat.o(130578);
  }
  
  private void Bs()
  {
    AppMethodBeat.i(130569);
    try
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV();
      if (localObject == null)
      {
        AppMethodBeat.o(130569);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.jsruntime.q)((i)localObject).P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject).setThreadPriority(-8);
      }
      AppMethodBeat.o(130569);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(130569);
    }
  }
  
  private void Bx()
  {
    boolean bool = true;
    AppMethodBeat.i(130573);
    if (this.bZJ != null) {}
    for (;;)
    {
      ac.i("Luggage.AppBrandGameServiceLogicImp", "setup magicbrush. loaded?[%b]", new Object[] { Boolean.valueOf(bool) });
      if (this.bZJ == null) {
        break;
      }
      AppMethodBeat.o(130573);
      return;
      bool = false;
    }
    ((com.tencent.luggage.sdk.b.a.c.c)CM()).bey();
    this.bZG = Bt();
    this.bZH = Bu();
    this.bZI = Bv();
    this.bZJ = a(this.bZG, this.bZH, this.bZI, Bw());
    this.bZJ.AW();
    c localc = new c((byte)0);
    this.bZJ.getMagicBrush().cmj.add(localc);
    this.bZJ.getMagicBrush().cmi.add(localc);
    this.bZJ.getMagicBrush().cmk.addListener(new MBViewManager.a()
    {
      public final void a(MagicBrushView paramAnonymousMagicBrushView) {}
      
      public final void b(MagicBrushView paramAnonymousMagicBrushView)
      {
        AppMethodBeat.i(206097);
        a.e locale = new a.e(a.this, (byte)0);
        k.h(locale, "l");
        paramAnonymousMagicBrushView.cpq.add(locale);
        paramAnonymousMagicBrushView.a(new a.d(a.this, (byte)0));
        AppMethodBeat.o(206097);
      }
    });
    this.bZJ.getMagicBrush().clS = new com.tencent.magicbrush.handler.b()
    {
      public final String a(final String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(206098);
        if (a.this.CM() == null)
        {
          AppMethodBeat.o(206098);
          return "";
        }
        try
        {
          paramAnonymousString1 = ((com.tencent.luggage.sdk.b.a.c.c)a.this.CM()).b(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousBoolean);
          AppMethodBeat.o(206098);
          return paramAnonymousString1;
        }
        catch (Throwable paramAnonymousString1)
        {
          ac.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", paramAnonymousString1, "IMBInvokeHandler.invoke", new Object[0]);
          com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
          {
            public final void run()
            {
              throw paramAnonymousString1;
            }
          });
          AppMethodBeat.o(206098);
        }
        return "";
      }
      
      public final String[] getAsyncableJsApis()
      {
        AppMethodBeat.i(206099);
        if (a.this.CM() == null)
        {
          AppMethodBeat.o(206099);
          return null;
        }
        String[] arrayOfString = ((com.tencent.luggage.sdk.b.a.c.c)a.this.CM()).getAsyncableJsApis();
        AppMethodBeat.o(206099);
        return arrayOfString;
      }
    };
    AppMethodBeat.o(130573);
  }
  
  protected String BA()
  {
    AppMethodBeat.i(130577);
    String str = com.tencent.mm.plugin.appbrand.z.d.Rn("wxa_library/android.js") + com.tencent.mm.plugin.appbrand.z.d.Rn("wxa_library/shared_buffer.js") + com.tencent.mm.plugin.appbrand.z.d.Rn("wxa_library/NativeGlobal-WAGame.js");
    AppMethodBeat.o(130577);
    return str;
  }
  
  protected int BB()
  {
    return 0;
  }
  
  public final void BD()
  {
    AppMethodBeat.i(130579);
    super.BD();
    Object localObject;
    if ((((com.tencent.luggage.sdk.b.a.c.c)CM()).CO() != null) && (((com.tencent.luggage.sdk.b.a.c.c)CM()).CO().DF()))
    {
      com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206102);
          a.a(a.this, new n());
          a.a(a.this, new com.tencent.mm.plugin.appbrand.debugger.l());
          a.b(a.this).a((com.tencent.luggage.sdk.b.a.c.c)a.this.CM(), ((com.tencent.luggage.sdk.b.a.c.c)a.this.CM()).CO().DC().extInfo);
          a.c(a.this).a(a.b(a.this));
          AppMethodBeat.o(206102);
        }
      });
      localObject = (com.tencent.mm.plugin.appbrand.jsruntime.l)((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV().P(com.tencent.mm.plugin.appbrand.jsruntime.l.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsruntime.l)localObject).Od("xdebug");
      }
      if (((com.tencent.luggage.sdk.b.a.c.c)CM()).aUm()) {
        localObject = ((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV();
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
  
  public final void BE()
  {
    AppMethodBeat.i(130580);
    ac.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.init");
    this.bZD = true;
    ac.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl mServiceReady = [%b], isRunning[%b]", new Object[] { Boolean.valueOf(this.bZD), Boolean.valueOf(((com.tencent.luggage.sdk.b.a.c.c)CM()).isRunning()) });
    if ((!this.bZD) || (!((com.tencent.luggage.sdk.b.a.c.c)CM()).isRunning()))
    {
      AppMethodBeat.o(130580);
      return;
    }
    try
    {
      ac.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl start");
      if (!this.bZE) {
        ((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV().evaluateJavascript(com.tencent.mm.plugin.appbrand.z.d.Rn("wxa_library/android.js"), null);
      }
      ((com.tencent.luggage.sdk.b.a.c.c)CM()).Dp();
      BC();
      ((com.tencent.luggage.sdk.b.a.c.c)CM()).N(new Runnable()
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
      if (((com.tencent.luggage.sdk.b.a.c.c)CM()).isRunning())
      {
        AppMethodBeat.o(130580);
        throw localNullPointerException;
      }
      AppMethodBeat.o(130580);
    }
  }
  
  public final void BF()
  {
    AppMethodBeat.i(130582);
    ac.i("Luggage.AppBrandGameServiceLogicImp", "start preload");
    Bx();
    BC();
    ((com.tencent.luggage.sdk.b.a.c.c)CM()).bez();
    ac.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppService preloaded.");
    AppMethodBeat.o(130582);
  }
  
  public final com.tencent.luggage.game.c.e Bi()
  {
    AppMethodBeat.i(130558);
    if (this.bZN == null) {}
    try
    {
      if (this.bZN == null) {
        this.bZN = new com.tencent.luggage.game.c.e();
      }
      com.tencent.luggage.game.c.e locale = this.bZN;
      AppMethodBeat.o(130558);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(130558);
    }
  }
  
  public final String Bj()
  {
    AppMethodBeat.i(130559);
    Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)CM()).Do();
    String str = ((com.tencent.luggage.sdk.b.a.c.c)CM()).CO().getAppConfig().jBO;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(130559);
    return localObject;
  }
  
  protected void Bk()
  {
    AppMethodBeat.i(130562);
    new com.tencent.luggage.game.b.d().AY();
    AppMethodBeat.o(130562);
  }
  
  public final boolean Bl()
  {
    return true;
  }
  
  public i Bm()
  {
    AppMethodBeat.i(130563);
    ac.i("Luggage.AppBrandGameServiceLogicImp", "createJsRuntime");
    long l = System.currentTimeMillis();
    Object localObject2 = Bq();
    Object localObject1 = null;
    if (Br()) {
      if (!com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) {
        break label173;
      }
    }
    label173:
    for (localObject1 = com.tencent.mm.plugin.appbrand.z.d.Ro("wxa_library/v8_snapshot64.bin");; localObject1 = com.tencent.mm.plugin.appbrand.z.d.Ro("wxa_library/v8_snapshot.bin"))
    {
      localObject1 = d((String)localObject2, (byte[])localObject1);
      localObject2 = (t)((i)localObject1).P(t.class);
      localObject2 = a((com.tencent.luggage.sdk.b.a.c.c)CM(), (t)localObject2);
      ((i)localObject1).setJsExceptionHandler(new com.tencent.mm.plugin.appbrand.jsruntime.h()
      {
        public final void u(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(130540);
          Object localObject = (com.tencent.luggage.sdk.b.a.c.c)a.this.CM();
          if (localObject == null) {}
          for (localObject = null; localObject == null; localObject = ((com.tencent.luggage.sdk.b.a.c.c)localObject).aUV())
          {
            AppMethodBeat.o(130540);
            return;
          }
          ac.e("Luggage.AppBrandGameServiceLogicImp", "[WAGameJsException] hy: wxa main context exception %s %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          cg.a((com.tencent.mm.plugin.appbrand.jsruntime.o)localObject, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { p.Rw(paramAnonymousString1), p.Rw(paramAnonymousString2) }), 0);
          com.tencent.mm.plugin.appbrand.x.b.a.bug();
          com.tencent.mm.plugin.appbrand.x.b.L("WeAppLaunch", paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(130540);
        }
      });
      ((i)localObject1).addJavascriptInterface(localObject2, "WeixinJSContext");
      com.tencent.mm.plugin.appbrand.utils.q.a((i)localObject1, String.format(";(function(){let interface = %s;let alloc = interface.alloc;let allocNativeGlobal = interface.allocNativeGlobal;interface.alloc = function(injectNativeGlobal) {if(injectNativeGlobal){return allocNativeGlobal();}else{return alloc();}}})();", new Object[] { "WeixinJSContext" }), new d.1((d)localObject2));
      ((d)localObject2).BL();
      ac.i("Luggage.AppBrandGameServiceLogicImp", "[damonlei] createJsRuntime cost [%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(130563);
      return localObject1;
    }
  }
  
  public void Bn()
  {
    AppMethodBeat.i(130566);
    super.Bn();
    this.bZK = new com.tencent.luggage.sdk.b.a.a.d();
    this.bZK.a(((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV(), CM());
    this.bZL = new com.tencent.luggage.sdk.b.a.a.a();
    com.tencent.luggage.sdk.b.a.a.a locala = this.bZL;
    i locali = ((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV();
    Object localObject = CM();
    ac.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding");
    if (locali == null) {
      ac.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsruntime is null");
    }
    for (;;)
    {
      this.bZM = new com.tencent.luggage.sdk.b.a.a.e();
      this.bZM.a(((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV(), CM(), 1);
      AppMethodBeat.o(130566);
      return;
      locala.cdh = "1004";
      com.tencent.mm.game.a.a.loadLibraries();
      com.tencent.mm.plugin.appbrand.jsruntime.q localq = (com.tencent.mm.plugin.appbrand.jsruntime.q)locali.P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localq == null)
      {
        ac.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsThreadHandler is null");
      }
      else
      {
        localObject = (com.tencent.luggage.sdk.b.a.a.b)((com.tencent.mm.plugin.appbrand.jsapi.c)localObject).K(com.tencent.luggage.sdk.b.a.a.b.class);
        if (localObject != null)
        {
          locala.cdi = ((com.tencent.luggage.sdk.b.a.a.b)localObject).CZ();
          ac.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(locala.cdi) });
        }
        localq.post(new com.tencent.luggage.sdk.b.a.a.a.3(locala, locali, new com.tencent.luggage.sdk.b.a.a.a.1(locala, new WeakReference(localq)), new com.tencent.luggage.sdk.b.a.a.a.2(locala)));
      }
    }
  }
  
  public void Bo()
  {
    AppMethodBeat.i(130567);
    super.Bo();
    if (this.bZJ != null) {
      this.bZJ.destroy();
    }
    if (this.bZK != null) {
      this.bZK.a(((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV());
    }
    com.tencent.luggage.sdk.b.a.a.a locala;
    i locali;
    if (this.bZL != null)
    {
      locala = this.bZL;
      locali = ((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV();
      ac.i("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding");
      if (locali != null) {
        break label124;
      }
      ac.e("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding jsruntime is null");
    }
    for (;;)
    {
      if (this.bZM != null) {
        this.bZM.b(((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV());
      }
      AppMethodBeat.o(130567);
      return;
      label124:
      ((m)locali.P(m.class)).a(locala.cdj);
    }
  }
  
  public void Bp()
  {
    AppMethodBeat.i(130568);
    super.Bp();
    if (this.bZJ != null)
    {
      if (this.bZJ.bXV != null) {
        this.bZJ.getMagicBrush().clS = null;
      }
      Object localObject = this.bZJ;
      ac.i("MicroMsg.MagicBrush", "awaitDestroyDone");
      if ((!((com.tencent.luggage.game.a.d)localObject).bXX.aN(5000L)) && (com.tencent.mm.sdk.platformtools.h.DEBUG))
      {
        localObject = (Throwable)new IllegalStateException("WAGame destroy timeout");
        AppMethodBeat.o(130568);
        throw ((Throwable)localObject);
      }
    }
    if (this.bZF != null) {
      this.bZF.destroy();
    }
    AppMethodBeat.o(130568);
  }
  
  protected String Bq()
  {
    return null;
  }
  
  protected boolean Br()
  {
    return true;
  }
  
  protected boolean Bt()
  {
    AppMethodBeat.i(130571);
    if (((com.tencent.luggage.sdk.b.a.c.c)CM()).CO() != null)
    {
      com.tencent.mm.plugin.appbrand.config.a locala = ((com.tencent.luggage.sdk.b.a.c.c)CM()).CO().getAppConfig();
      if (locala.jBC != null)
      {
        boolean bool = locala.jBC.booleanValue();
        AppMethodBeat.o(130571);
        return bool;
      }
    }
    AppMethodBeat.o(130571);
    return true;
  }
  
  protected boolean Bu()
  {
    return true;
  }
  
  protected int Bv()
  {
    return 1;
  }
  
  protected boolean Bw()
  {
    return false;
  }
  
  public final void By()
  {
    AppMethodBeat.i(130574);
    ac.i("Luggage.AppBrandGameServiceLogicImp", "onRuntimeResume");
    super.By();
    Bs();
    if (this.bZF != null) {
      this.bZF.jHl.bringToFront();
    }
    AppMethodBeat.o(130574);
  }
  
  public final void Bz()
  {
    AppMethodBeat.i(130575);
    super.Bz();
    try
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV();
      if (localObject == null)
      {
        AppMethodBeat.o(130575);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.jsruntime.q)((i)localObject).P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject).setThreadPriority(10);
      }
      AppMethodBeat.o(130575);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(130575);
    }
  }
  
  protected com.tencent.luggage.game.a.b a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(206103);
    com.tencent.luggage.game.a.b local3 = new com.tencent.luggage.game.a.b(((com.tencent.luggage.sdk.b.a.c.c)CM()).getContext(), ((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV(), paramBoolean1, paramBoolean2, paramInt, paramBoolean3)
    {
      public final void a(com.tencent.magicbrush.e paramAnonymouse)
      {
        AppMethodBeat.i(206096);
        super.a(paramAnonymouse);
        paramAnonymouse.b(com.tencent.magicbrush.ui.a.b.coW);
        paramAnonymouse.bR(false);
        AppMethodBeat.o(206096);
      }
    };
    AppMethodBeat.o(206103);
    return local3;
  }
  
  protected d a(Service paramService, t paramt)
  {
    AppMethodBeat.i(130565);
    paramService = new d(paramService, paramt);
    AppMethodBeat.o(130565);
    return paramService;
  }
  
  public final void bX(String paramString)
  {
    AppMethodBeat.i(178033);
    ac.d("Luggage.AppBrandGameServiceLogicImp", "RemoteDebugInfo %s", new Object[] { paramString });
    dtq localdtq = new dtq();
    localdtq.GbL = ((com.tencent.luggage.sdk.b.a.c.c)CM()).Dn().aUT();
    localdtq.GbK = paramString;
    paramString = u.a(localdtq, this.bZO, "domEvent");
    this.bZF.a(paramString);
    AppMethodBeat.o(178033);
  }
  
  public final void bY(String paramString)
  {
    AppMethodBeat.i(130581);
    ac.i("Luggage.AppBrandGameServiceLogicImp", "hy: do nothing in game service when called from modularizing helper");
    AppMethodBeat.o(130581);
  }
  
  public void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130570);
    Bx();
    if (this.bZJ != null) {
      this.bZJ.b(paramAppBrandRuntime);
    }
    if (this.bZM != null) {
      this.bZM.b(((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV(), CM());
    }
    com.tencent.luggage.sdk.b.a.a.a locala;
    Object localObject;
    com.tencent.mm.plugin.appbrand.jsapi.c localc;
    if (this.bZL != null)
    {
      locala = this.bZL;
      localObject = ((com.tencent.luggage.sdk.b.a.c.c)CM()).aUV();
      localc = CM();
      ac.i("Luggage.LockStepNativeInstallHelper", "initConfigLockStep");
      if (localObject != null) {
        break label158;
      }
      ac.e("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsruntime is null");
    }
    for (;;)
    {
      Bs();
      paramAppBrandRuntime.b(x.class, new com.tencent.luggage.game.f.a(com.tencent.mm.sdk.f.a.jg(paramAppBrandRuntime.mContext)));
      this.bZJ.getMagicBrush().cmk.addSurfaceListenerForAllViews(new MagicBrushView.d()
      {
        public final void az(Object paramAnonymousObject)
        {
          AppMethodBeat.i(162096);
          paramAnonymousObject = a.this.CO();
          if ((paramAnonymousObject != null) && (paramAnonymousObject.jdK != null))
          {
            paramAnonymousObject.jdK.fL(true);
            Object localObject = paramAnonymousObject.jdK.jqZ;
            paramAnonymousObject = new LinkedList(((com.tencent.mm.plugin.appbrand.b.d)localObject).jrn);
            ((com.tencent.mm.plugin.appbrand.b.d)localObject).jrn.clear();
            while (!paramAnonymousObject.isEmpty())
            {
              localObject = (j)paramAnonymousObject.poll();
              ao localao = ((j)localObject).mHandler;
              if (localao != null)
              {
                ((j)localObject).mHandler.removeCallbacks(((j)localObject).cpU);
                if (Looper.myLooper() == localao.getLooper()) {
                  ((j)localObject).cpU.run();
                } else {
                  ((j)localObject).aE(((j)localObject).result);
                }
              }
            }
          }
          AppMethodBeat.o(162096);
        }
        
        public final void b(Object paramAnonymousObject, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(206095);
          paramAnonymousObject = a.this.CO();
          if ((paramAnonymousObject != null) && (paramAnonymousObject.jdK != null)) {
            paramAnonymousObject.jdK.fL(false);
          }
          AppMethodBeat.o(206095);
        }
      });
      AppMethodBeat.o(130570);
      return;
      label158:
      localObject = (com.tencent.mm.plugin.appbrand.jsruntime.q)((i)localObject).P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localObject == null) {
        ac.e("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsThreadHandler is null");
      } else {
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject).post(new com.tencent.luggage.sdk.b.a.a.a.4(locala, localc));
      }
    }
  }
  
  public void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(130560);
    AppBrandSysConfigLU localAppBrandSysConfigLU = ((com.tencent.luggage.sdk.b.a.c.c)CM()).CO().DB();
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
        if (i < localAppBrandSysConfigLU.ccO.jCR.length)
        {
          localJSONArray.put(localAppBrandSysConfigLU.ccO.jCR[i]);
          i += 1;
          continue;
        }
        ((com.tencent.luggage.sdk.b.a.c.c)CM()).c((JSONObject)localObject, "subContextImgDomain", localJSONArray);
      }
      catch (Exception localException)
      {
        int i;
        boolean bool2;
        boolean bool1;
        continue;
      }
      ((com.tencent.luggage.sdk.b.a.c.c)CM()).c(paramJSONObject, "wxAppInfo", localObject);
      ac.i("Luggage.AppBrandGameServiceLogicImp", "dm.widthPixels %d, dm.heightPixels %d", new Object[] { Integer.valueOf(this.bZJ.getMagicBrush().cmh.FU()), Integer.valueOf(this.bZJ.getMagicBrush().cmh.FV()) });
      localObject = ((com.tencent.luggage.sdk.b.a.c.c)CM()).CO();
      if ((((AppBrandRuntime)localObject).getWindowAndroid() instanceof com.tencent.mm.plugin.appbrand.r.a.a.o))
      {
        i = ((com.tencent.mm.plugin.appbrand.r.a.a.o)((AppBrandRuntime)localObject).getWindowAndroid()).bsQ().getDefaultDisplay().getRotation();
        bool2 = org.apache.commons.b.a.contains(new int[] { 0, 1 }, i);
        if (e.b.Qz(((AppBrandRuntime)localObject).getAppConfig().jBB.jBP) == e.b.lOQ)
        {
          bool1 = true;
          if (bool2 != bool1)
          {
            i = 0;
            if (i == 0)
            {
              ac.e("Luggage.AppBrandGameServiceLogicImp", "hy: orientation judge failed! maybe because onConfigurationChange judgement and surface degree judgement not match");
              ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(808L, 4L, 1L, false);
              ((com.tencent.mm.plugin.appbrand.t.b)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.b.class)).f(18284, new Object[] { Integer.valueOf(1) });
            }
            ((com.tencent.luggage.sdk.b.a.c.c)CM()).c(paramJSONObject, "screenWidth", Integer.valueOf(this.bZJ.getMagicBrush().cmh.FU()));
            ((com.tencent.luggage.sdk.b.a.c.c)CM()).c(paramJSONObject, "screenHeight", Integer.valueOf(this.bZJ.getMagicBrush().cmh.FV()));
            ((com.tencent.luggage.sdk.b.a.c.c)CM()).c(paramJSONObject, "devicePixelRatio", Float.valueOf(this.bZJ.getMagicBrush().cmh.getDevicePixelRatio()));
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
    paramString.cMv = true;
    paramString.cMu = "1";
    paramString.cMx = true;
    paramString.cMz = new WeakReference(CM());
    paramString = new com.tencent.mm.plugin.appbrand.jsruntime.b(paramString);
    AppMethodBeat.o(130564);
    return paramString;
  }
  
  public final com.tencent.magicbrush.d getMagicBrush()
  {
    AppMethodBeat.i(210377);
    com.tencent.magicbrush.d locald = this.bZJ.getMagicBrush();
    AppMethodBeat.o(210377);
    return locald;
  }
  
  protected void gq(int paramInt) {}
  
  final class a
    implements q.b
  {
    private final String bZQ;
    private final String bZR;
    private final long bZS;
    private boolean bZT;
    private m.c bZU;
    private final AtomicInteger bZV;
    
    a(String paramString)
    {
      AppMethodBeat.i(130541);
      this.bZS = l;
      this.bZT = false;
      this.bZU = null;
      this.bZV = new AtomicInteger(2);
      this.bZQ = paramString;
      Object localObject1;
      this.bZR = localObject1;
      AppMethodBeat.o(130541);
    }
    
    private void BI()
    {
      AppMethodBeat.i(130545);
      long l1;
      if (this.bZV.decrementAndGet() == 0)
      {
        if (this.bZU != null) {
          break label111;
        }
        l1 = this.bZS;
        if (this.bZU != null) {
          break label122;
        }
      }
      label111:
      label122:
      for (long l2 = System.currentTimeMillis();; l2 = this.bZU.cNt)
      {
        com.tencent.luggage.sdk.b.a.d.a locala = new com.tencent.luggage.sdk.b.a.d.a();
        locala.scriptName = this.bZQ;
        locala.cde = this.bZR;
        locala.cdf = bs.nullAsNil(this.bZR).length();
        ((com.tencent.luggage.sdk.b.a.c.c)a.this.CM()).a(locala, this.bZT, l1, l2, this.bZU);
        AppMethodBeat.o(130545);
        return;
        l1 = this.bZU.cNs;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(130542);
      this.bZU = paramc;
      BI();
      AppMethodBeat.o(130542);
    }
    
    public final void bZ(String paramString)
    {
      AppMethodBeat.i(130544);
      ac.e("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script Failed: %s", new Object[] { paramString });
      a.BH();
      this.bZT = false;
      BI();
      AppMethodBeat.o(130544);
    }
    
    public final void onSuccess(String paramString)
    {
      AppMethodBeat.i(130543);
      ac.i("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script suc: %s, filelen: %d", new Object[] { paramString, Integer.valueOf(bool) });
      a.BG();
      this.bZT = true;
      BI();
      AppMethodBeat.o(130543);
    }
  }
  
  public static final class b
    implements com.tencent.luggage.sdk.b.a.b.a
  {}
  
  final class c
    implements d.b, d.d
  {
    private c() {}
    
    public final void onConsole(String paramString)
    {
      AppMethodBeat.i(130552);
      ac.i("Luggage.AppBrandGameServiceLogicImp", "[WAGame][CONSOLE] output = [%s]", new Object[] { paramString });
      com.tencent.luggage.sdk.d.c localc = ((com.tencent.luggage.sdk.b.a.c.c)a.this.CM()).CO();
      if ((localc == null) || (localc.DB() == null) || (localc.DB().ccn)) {
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
      ac.e("Luggage.AppBrandGameServiceLogicImp", "[WAGame][AppBrand] message = [%s] stackTrace = [%s]", new Object[] { paramString1, paramString2 });
      Object localObject = (t)((com.tencent.luggage.sdk.b.a.c.c)a.this.CM()).aUV().P(t.class);
      if (paramInt == ((t)localObject).bmx().bmw())
      {
        cg.a(((com.tencent.luggage.sdk.b.a.c.c)a.this.CM()).aUV(), "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", new Object[] { p.Rw(paramString1), p.Rw(paramString2) }), 0);
        AppMethodBeat.o(130554);
        return;
      }
      localObject = ((t)localObject).tp(paramInt);
      if (localObject == null)
      {
        paramString1 = new IllegalStateException("j2v8 not follow the pattern");
        AppMethodBeat.o(130554);
        throw paramString1;
      }
      ch.a((i)localObject, "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", new Object[] { p.Rw(paramString1), p.Rw(paramString2) }));
      AppMethodBeat.o(130554);
    }
  }
  
  final class d
    implements MagicBrushView.c
  {
    private boolean cab = true;
    
    private d() {}
    
    private void BJ()
    {
      AppMethodBeat.i(177433);
      com.tencent.luggage.sdk.b.a.c.c localc = (com.tencent.luggage.sdk.b.a.c.c)a.this.CM();
      if (localc != null)
      {
        ac.i("Luggage.AppBrandGameServiceLogicImp", "hy: on resizeWindow");
        localc.a(new com.tencent.mm.plugin.appbrand.page.q());
      }
      AppMethodBeat.o(177433);
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(130556);
      BJ();
      AppMethodBeat.o(130556);
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(178032);
      if (this.cab)
      {
        this.cab = false;
        AppMethodBeat.o(178032);
        return;
      }
      BJ();
      AppMethodBeat.o(178032);
    }
    
    public final void b(Object paramObject, boolean paramBoolean) {}
  }
  
  final class e
    implements MagicBrushView.g
  {
    private e() {}
    
    public final void gr(int paramInt)
    {
      AppMethodBeat.i(130557);
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("onMainCanvasTypeDefined received invalid input [" + paramInt + "]");
        AppMethodBeat.o(130557);
        throw localIllegalStateException;
      }
      if ((!((com.tencent.luggage.sdk.b.a.c.c)a.this.CM()).aUl()) && (!((com.tencent.luggage.sdk.b.a.c.c)a.this.CM()).isRunning()))
      {
        AppMethodBeat.o(130557);
        return;
      }
      a.this.gq(paramInt);
      AppMethodBeat.o(130557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */