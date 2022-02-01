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
import com.tencent.magicbrush.ui.a.b;
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
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.plugin.appbrand.utils.q.b;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.plugin.appbrand.utils.r.1;
import com.tencent.mm.plugin.appbrand.utils.r.a;
import com.tencent.mm.plugin.appbrand.y.b.a;
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  private volatile boolean ccG;
  private boolean ccH;
  private n ccI;
  private boolean ccJ;
  private boolean ccK;
  private int ccL;
  public com.tencent.luggage.game.a.b ccM;
  private com.tencent.luggage.sdk.b.a.a.d ccN;
  private com.tencent.luggage.sdk.b.a.a.a ccO;
  private com.tencent.luggage.sdk.b.a.a.e ccP;
  private com.tencent.luggage.game.c.e ccQ;
  private com.tencent.mm.plugin.appbrand.debugger.l ccR;
  
  public a(Service paramService)
  {
    super(paramService);
    AppMethodBeat.i(130561);
    this.ccG = false;
    this.ccH = false;
    this.ccI = null;
    this.ccJ = false;
    this.ccK = false;
    this.ccL = 0;
    this.ccM = null;
    this.ccQ = null;
    this.ccR = null;
    b(b.class, this);
    BG();
    AppMethodBeat.o(130561);
  }
  
  private void BO()
  {
    AppMethodBeat.i(130569);
    try
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf();
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
      ad.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(130569);
    }
  }
  
  private void BT()
  {
    boolean bool = true;
    AppMethodBeat.i(130573);
    if (this.ccM != null) {}
    for (;;)
    {
      ad.i("Luggage.AppBrandGameServiceLogicImp", "setup magicbrush. loaded?[%b]", new Object[] { Boolean.valueOf(bool) });
      if (this.ccM == null) {
        break;
      }
      AppMethodBeat.o(130573);
      return;
      bool = false;
    }
    ((com.tencent.luggage.sdk.b.a.c.c)Dj()).aXB();
    this.ccJ = BP();
    this.ccK = BQ();
    this.ccL = BR();
    this.ccM = a(this.ccJ, this.ccK, this.ccL, BS());
    this.ccM.Bs();
    c localc = new c((byte)0);
    this.ccM.getMagicBrush().cpe.add(localc);
    this.ccM.getMagicBrush().cpd.add(localc);
    this.ccM.getMagicBrush().cpf.addListener(new MBViewManager.a()
    {
      public final void a(MagicBrushView paramAnonymousMagicBrushView) {}
      
      public final void b(MagicBrushView paramAnonymousMagicBrushView)
      {
        AppMethodBeat.i(194649);
        a.e locale = new a.e(a.this, (byte)0);
        k.h(locale, "l");
        paramAnonymousMagicBrushView.csj.add(locale);
        paramAnonymousMagicBrushView.a(new a.d(a.this, (byte)0));
        AppMethodBeat.o(194649);
      }
    });
    this.ccM.getMagicBrush().coN = new com.tencent.magicbrush.handler.b()
    {
      public final String a(final String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(194650);
        if (a.this.Dj() == null)
        {
          AppMethodBeat.o(194650);
          return "";
        }
        try
        {
          paramAnonymousString1 = ((com.tencent.luggage.sdk.b.a.c.c)a.this.Dj()).b(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousBoolean);
          AppMethodBeat.o(194650);
          return paramAnonymousString1;
        }
        catch (Throwable paramAnonymousString1)
        {
          ad.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", paramAnonymousString1, "IMBInvokeHandler.invoke", new Object[0]);
          aq.f(new Runnable()
          {
            public final void run()
            {
              throw paramAnonymousString1;
            }
          });
          AppMethodBeat.o(194650);
        }
        return "";
      }
      
      public final String[] getAsyncableJsApis()
      {
        AppMethodBeat.i(194651);
        if (a.this.Dj() == null)
        {
          AppMethodBeat.o(194651);
          return null;
        }
        String[] arrayOfString = ((com.tencent.luggage.sdk.b.a.c.c)a.this.Dj()).getAsyncableJsApis();
        AppMethodBeat.o(194651);
        return arrayOfString;
      }
    };
    AppMethodBeat.o(130573);
  }
  
  private void BY()
  {
    AppMethodBeat.i(130578);
    if (this.ccH)
    {
      AppMethodBeat.o(130578);
      return;
    }
    this.ccH = true;
    ad.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame to MainContext");
    Object localObject1 = BW();
    com.tencent.mm.plugin.appbrand.utils.q.a(((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf(), (String)localObject1, new q.a()
    {
      public final void cj(String paramAnonymousString)
      {
        AppMethodBeat.i(194653);
        ad.e("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script Failed: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(194653);
      }
      
      public final void onSuccess(String paramAnonymousString)
      {
        AppMethodBeat.i(194652);
        ad.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script suc: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(194652);
      }
    });
    Object localObject2 = ((com.tencent.luggage.sdk.b.a.c.c)Dj()).aLC().DH("WAGame.js");
    Object localObject3 = "v" + ((com.tencent.luggage.sdk.b.a.c.c)Dj()).aLC().aPc();
    com.tencent.mm.plugin.appbrand.ap.a((com.tencent.mm.plugin.appbrand.d)Dj(), ((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf());
    ((com.tencent.mm.plugin.appbrand.u.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(778L, 13L, 1L, false);
    final long l = System.currentTimeMillis();
    final boolean bool = ((com.tencent.luggage.sdk.b.a.c.c)Dj()).aNv();
    if (localObject2 == null) {}
    String str;
    for (int i = 0;; i = ((String)localObject2).length())
    {
      localObject1 = new a("WAGame.js", (String)localObject2, l, i, bool);
      if ((((com.tencent.luggage.sdk.b.a.c.c)Dj()).Dl() == null) || (!((com.tencent.luggage.sdk.b.a.c.c)Dj()).Dl().Ec())) {
        break label427;
      }
      str = ";(function(global) { var protectedConsole = global.console; Object.defineProperty(global, 'console', { get() { return protectedConsole; }, set() { } }); })(this);".concat(String.valueOf(localObject2));
      localObject2 = (com.tencent.mm.plugin.appbrand.q)Dj();
      localObject4 = ((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf();
      localObject3 = r.a.lMx;
      if (!bt.isNullOrNil(str)) {
        break;
      }
      ((q.a)localObject1).cj("isNullOrNil script");
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
    label427:
    r.a((com.tencent.mm.plugin.appbrand.q)Dj(), ((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf(), "WAGame.js", "WAGame.js", (String)localObject3, BX(), (String)localObject2, r.a.lMx, localMalformedURLException);
    AppMethodBeat.o(130578);
  }
  
  public final com.tencent.luggage.game.c.e BE()
  {
    AppMethodBeat.i(130558);
    if (this.ccQ == null) {}
    try
    {
      if (this.ccQ == null) {
        this.ccQ = new com.tencent.luggage.game.c.e();
      }
      com.tencent.luggage.game.c.e locale = this.ccQ;
      AppMethodBeat.o(130558);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(130558);
    }
  }
  
  public final String BF()
  {
    AppMethodBeat.i(130559);
    Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)Dj()).DL();
    String str = ((com.tencent.luggage.sdk.b.a.c.c)Dj()).Dl().getAppConfig().jbB;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(130559);
    return localObject;
  }
  
  protected void BG()
  {
    AppMethodBeat.i(130562);
    new com.tencent.luggage.game.b.d().Bu();
    AppMethodBeat.o(130562);
  }
  
  public final boolean BH()
  {
    return true;
  }
  
  public i BI()
  {
    AppMethodBeat.i(130563);
    ad.i("Luggage.AppBrandGameServiceLogicImp", "createJsRuntime");
    long l = System.currentTimeMillis();
    Object localObject2 = BM();
    Object localObject1 = null;
    if (BN()) {
      if (!com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) {
        break label173;
      }
    }
    label173:
    for (localObject1 = com.tencent.mm.plugin.appbrand.aa.d.Nf("wxa_library/v8_snapshot64.bin");; localObject1 = com.tencent.mm.plugin.appbrand.aa.d.Nf("wxa_library/v8_snapshot.bin"))
    {
      localObject1 = d((String)localObject2, (byte[])localObject1);
      localObject2 = (t)((i)localObject1).P(t.class);
      localObject2 = a((com.tencent.luggage.sdk.b.a.c.c)Dj(), (t)localObject2);
      ((i)localObject1).setJsExceptionHandler(new com.tencent.mm.plugin.appbrand.jsruntime.h()
      {
        public final void t(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(130540);
          Object localObject = (com.tencent.luggage.sdk.b.a.c.c)a.this.Dj();
          if (localObject == null) {}
          for (localObject = null; localObject == null; localObject = ((com.tencent.luggage.sdk.b.a.c.c)localObject).aOf())
          {
            AppMethodBeat.o(130540);
            return;
          }
          ad.e("Luggage.AppBrandGameServiceLogicImp", "[WAGameJsException] hy: wxa main context exception %s %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          cg.a((com.tencent.mm.plugin.appbrand.jsruntime.o)localObject, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.utils.p.Nn(paramAnonymousString1), com.tencent.mm.plugin.appbrand.utils.p.Nn(paramAnonymousString2) }), 0);
          b.a.bnk();
          com.tencent.mm.plugin.appbrand.y.b.L("WeAppLaunch", paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(130540);
        }
      });
      ((i)localObject1).addJavascriptInterface(localObject2, "WeixinJSContext");
      com.tencent.mm.plugin.appbrand.utils.q.a((i)localObject1, String.format(";(function(){let interface = %s;let alloc = interface.alloc;let allocNativeGlobal = interface.allocNativeGlobal;interface.alloc = function(injectNativeGlobal) {if(injectNativeGlobal){return allocNativeGlobal();}else{return alloc();}}})();", new Object[] { "WeixinJSContext" }), new d.1((d)localObject2));
      ((d)localObject2).Ch();
      ad.i("Luggage.AppBrandGameServiceLogicImp", "[damonlei] createJsRuntime cost [%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(130563);
      return localObject1;
    }
  }
  
  public void BJ()
  {
    AppMethodBeat.i(130566);
    super.BJ();
    this.ccN = new com.tencent.luggage.sdk.b.a.a.d();
    this.ccN.a(((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf(), Dj());
    this.ccO = new com.tencent.luggage.sdk.b.a.a.a();
    com.tencent.luggage.sdk.b.a.a.a locala = this.ccO;
    i locali = ((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf();
    Object localObject = Dj();
    ad.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding");
    if (locali == null) {
      ad.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsruntime is null");
    }
    for (;;)
    {
      this.ccP = new com.tencent.luggage.sdk.b.a.a.e();
      this.ccP.a(((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf(), Dj(), 1);
      AppMethodBeat.o(130566);
      return;
      locala.cgl = "1004";
      com.tencent.mm.game.a.a.loadLibraries();
      com.tencent.mm.plugin.appbrand.jsruntime.q localq = (com.tencent.mm.plugin.appbrand.jsruntime.q)locali.P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localq == null)
      {
        ad.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsThreadHandler is null");
      }
      else
      {
        localObject = (com.tencent.luggage.sdk.b.a.a.b)((com.tencent.mm.plugin.appbrand.jsapi.c)localObject).K(com.tencent.luggage.sdk.b.a.a.b.class);
        if (localObject != null)
        {
          locala.cgm = ((com.tencent.luggage.sdk.b.a.a.b)localObject).Dw();
          ad.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(locala.cgm) });
        }
        localq.post(new com.tencent.luggage.sdk.b.a.a.a.3(locala, locali, new com.tencent.luggage.sdk.b.a.a.a.1(locala, new WeakReference(localq)), new com.tencent.luggage.sdk.b.a.a.a.2(locala)));
      }
    }
  }
  
  public void BK()
  {
    AppMethodBeat.i(130567);
    super.BK();
    if (this.ccM != null) {
      this.ccM.destroy();
    }
    if (this.ccN != null) {
      this.ccN.a(((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf());
    }
    com.tencent.luggage.sdk.b.a.a.a locala;
    i locali;
    if (this.ccO != null)
    {
      locala = this.ccO;
      locali = ((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf();
      ad.i("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding");
      if (locali != null) {
        break label124;
      }
      ad.e("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding jsruntime is null");
    }
    for (;;)
    {
      if (this.ccP != null) {
        this.ccP.b(((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf());
      }
      AppMethodBeat.o(130567);
      return;
      label124:
      ((m)locali.P(m.class)).a(locala.cgn);
    }
  }
  
  public void BL()
  {
    AppMethodBeat.i(130568);
    super.BL();
    if (this.ccM != null)
    {
      if (this.ccM.caY != null) {
        this.ccM.getMagicBrush().coN = null;
      }
      Object localObject = this.ccM;
      ad.i("MicroMsg.MagicBrush", "awaitDestroyDone");
      if ((!((com.tencent.luggage.game.a.d)localObject).cba.aR(5000L)) && (com.tencent.mm.sdk.platformtools.h.DEBUG))
      {
        localObject = (Throwable)new IllegalStateException("WAGame destroy timeout");
        AppMethodBeat.o(130568);
        throw ((Throwable)localObject);
      }
    }
    if (this.ccI != null) {
      this.ccI.destroy();
    }
    AppMethodBeat.o(130568);
  }
  
  protected String BM()
  {
    return null;
  }
  
  protected boolean BN()
  {
    return true;
  }
  
  protected boolean BP()
  {
    AppMethodBeat.i(130571);
    if (((com.tencent.luggage.sdk.b.a.c.c)Dj()).Dl() != null)
    {
      com.tencent.mm.plugin.appbrand.config.a locala = ((com.tencent.luggage.sdk.b.a.c.c)Dj()).Dl().getAppConfig();
      if (locala.jbp != null)
      {
        boolean bool = locala.jbp.booleanValue();
        AppMethodBeat.o(130571);
        return bool;
      }
    }
    AppMethodBeat.o(130571);
    return true;
  }
  
  protected boolean BQ()
  {
    return true;
  }
  
  protected int BR()
  {
    return 1;
  }
  
  protected boolean BS()
  {
    return false;
  }
  
  public final void BU()
  {
    AppMethodBeat.i(130574);
    ad.i("Luggage.AppBrandGameServiceLogicImp", "onRuntimeResume");
    super.BU();
    BO();
    if (this.ccI != null) {
      this.ccI.jgW.bringToFront();
    }
    AppMethodBeat.o(130574);
  }
  
  public final void BV()
  {
    AppMethodBeat.i(130575);
    super.BV();
    try
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf();
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
      ad.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(130575);
    }
  }
  
  protected String BW()
  {
    AppMethodBeat.i(130577);
    String str = com.tencent.mm.plugin.appbrand.aa.d.Ne("wxa_library/android.js") + com.tencent.mm.plugin.appbrand.aa.d.Ne("wxa_library/shared_buffer.js") + com.tencent.mm.plugin.appbrand.aa.d.Ne("wxa_library/NativeGlobal-WAGame.js");
    AppMethodBeat.o(130577);
    return str;
  }
  
  protected int BX()
  {
    return 0;
  }
  
  public final void BZ()
  {
    AppMethodBeat.i(130579);
    super.BZ();
    Object localObject;
    if ((((com.tencent.luggage.sdk.b.a.c.c)Dj()).Dl() != null) && (((com.tencent.luggage.sdk.b.a.c.c)Dj()).Dl().Ec()))
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194654);
          a.a(a.this, new n());
          a.a(a.this, new com.tencent.mm.plugin.appbrand.debugger.l());
          a.b(a.this).a((com.tencent.luggage.sdk.b.a.c.c)a.this.Dj(), ((com.tencent.luggage.sdk.b.a.c.c)a.this.Dj()).Dl().DZ().extInfo);
          a.c(a.this).a(a.b(a.this));
          AppMethodBeat.o(194654);
        }
      });
      localObject = (com.tencent.mm.plugin.appbrand.jsruntime.l)((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf().P(com.tencent.mm.plugin.appbrand.jsruntime.l.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsruntime.l)localObject).JW("xdebug");
      }
      if (((com.tencent.luggage.sdk.b.a.c.c)Dj()).aNw()) {
        localObject = ((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf();
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
  
  public final void Ca()
  {
    AppMethodBeat.i(130580);
    ad.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.init");
    this.ccG = true;
    ad.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl mServiceReady = [%b], isRunning[%b]", new Object[] { Boolean.valueOf(this.ccG), Boolean.valueOf(((com.tencent.luggage.sdk.b.a.c.c)Dj()).isRunning()) });
    if ((!this.ccG) || (!((com.tencent.luggage.sdk.b.a.c.c)Dj()).isRunning()))
    {
      AppMethodBeat.o(130580);
      return;
    }
    try
    {
      ad.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl start");
      if (!this.ccH) {
        ((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf().evaluateJavascript(com.tencent.mm.plugin.appbrand.aa.d.Ne("wxa_library/android.js"), null);
      }
      ((com.tencent.luggage.sdk.b.a.c.c)Dj()).DM();
      BY();
      ((com.tencent.luggage.sdk.b.a.c.c)Dj()).L(new Runnable()
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
      if (((com.tencent.luggage.sdk.b.a.c.c)Dj()).isRunning())
      {
        AppMethodBeat.o(130580);
        throw localNullPointerException;
      }
      AppMethodBeat.o(130580);
    }
  }
  
  public final void Cb()
  {
    AppMethodBeat.i(130582);
    ad.i("Luggage.AppBrandGameServiceLogicImp", "start preload");
    BT();
    BY();
    ((com.tencent.luggage.sdk.b.a.c.c)Dj()).aXC();
    ad.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppService preloaded.");
    AppMethodBeat.o(130582);
  }
  
  protected com.tencent.luggage.game.a.b a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(194655);
    com.tencent.luggage.game.a.b local3 = new com.tencent.luggage.game.a.b(((com.tencent.luggage.sdk.b.a.c.c)Dj()).getContext(), ((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf(), paramBoolean1, paramBoolean2, paramInt, paramBoolean3)
    {
      public final void a(com.tencent.magicbrush.e paramAnonymouse)
      {
        AppMethodBeat.i(194648);
        super.a(paramAnonymouse);
        paramAnonymouse.b(a.b.crQ);
        paramAnonymouse.bQ(false);
        AppMethodBeat.o(194648);
      }
    };
    AppMethodBeat.o(194655);
    return local3;
  }
  
  protected d a(Service paramService, t paramt)
  {
    AppMethodBeat.i(130565);
    paramService = new d(paramService, paramt);
    AppMethodBeat.o(130565);
    return paramService;
  }
  
  public void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130570);
    BT();
    if (this.ccM != null) {
      this.ccM.b(paramAppBrandRuntime);
    }
    if (this.ccP != null) {
      this.ccP.b(((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf(), Dj());
    }
    com.tencent.luggage.sdk.b.a.a.a locala;
    Object localObject;
    com.tencent.mm.plugin.appbrand.jsapi.c localc;
    if (this.ccO != null)
    {
      locala = this.ccO;
      localObject = ((com.tencent.luggage.sdk.b.a.c.c)Dj()).aOf();
      localc = Dj();
      ad.i("Luggage.LockStepNativeInstallHelper", "initConfigLockStep");
      if (localObject != null) {
        break label158;
      }
      ad.e("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsruntime is null");
    }
    for (;;)
    {
      BO();
      paramAppBrandRuntime.b(y.class, new com.tencent.luggage.game.f.a(com.tencent.mm.sdk.f.a.iV(paramAppBrandRuntime.mContext)));
      this.ccM.getMagicBrush().cpf.addSurfaceListenerForAllViews(new MagicBrushView.d()
      {
        public final void aB(Object paramAnonymousObject)
        {
          AppMethodBeat.i(162096);
          paramAnonymousObject = a.this.Dl();
          if ((paramAnonymousObject != null) && (paramAnonymousObject.iDK != null))
          {
            paramAnonymousObject.iDK.fp(true);
            Object localObject = paramAnonymousObject.iDK.iQP;
            paramAnonymousObject = new LinkedList(((com.tencent.mm.plugin.appbrand.b.d)localObject).iRd);
            ((com.tencent.mm.plugin.appbrand.b.d)localObject).iRd.clear();
            while (!paramAnonymousObject.isEmpty())
            {
              localObject = (j)paramAnonymousObject.poll();
              com.tencent.mm.sdk.platformtools.ap localap = ((j)localObject).mHandler;
              if (localap != null)
              {
                ((j)localObject).mHandler.removeCallbacks(((j)localObject).csM);
                if (Looper.myLooper() == localap.getLooper()) {
                  ((j)localObject).csM.run();
                } else {
                  ((j)localObject).aH(((j)localObject).result);
                }
              }
            }
          }
          AppMethodBeat.o(162096);
        }
        
        public final void aC(Object paramAnonymousObject)
        {
          AppMethodBeat.i(162097);
          paramAnonymousObject = a.this.Dl();
          if ((paramAnonymousObject != null) && (paramAnonymousObject.iDK != null)) {
            paramAnonymousObject.iDK.fp(false);
          }
          AppMethodBeat.o(162097);
        }
      });
      AppMethodBeat.o(130570);
      return;
      label158:
      localObject = (com.tencent.mm.plugin.appbrand.jsruntime.q)((i)localObject).P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localObject == null) {
        ad.e("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsThreadHandler is null");
      } else {
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject).post(new com.tencent.luggage.sdk.b.a.a.a.4(locala, localc));
      }
    }
  }
  
  public void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(130560);
    AppBrandSysConfigLU localAppBrandSysConfigLU = ((com.tencent.luggage.sdk.b.a.c.c)Dj()).Dl().DY();
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
        if (i < localAppBrandSysConfigLU.cfR.jcE.length)
        {
          localJSONArray.put(localAppBrandSysConfigLU.cfR.jcE[i]);
          i += 1;
          continue;
        }
        ((com.tencent.luggage.sdk.b.a.c.c)Dj()).c((JSONObject)localObject, "subContextImgDomain", localJSONArray);
      }
      catch (Exception localException)
      {
        int i;
        boolean bool2;
        boolean bool1;
        continue;
      }
      ((com.tencent.luggage.sdk.b.a.c.c)Dj()).c(paramJSONObject, "wxAppInfo", localObject);
      ad.i("Luggage.AppBrandGameServiceLogicImp", "dm.widthPixels %d, dm.heightPixels %d", new Object[] { Integer.valueOf(this.ccM.getMagicBrush().cpc.Gi()), Integer.valueOf(this.ccM.getMagicBrush().cpc.Gj()) });
      localObject = ((com.tencent.luggage.sdk.b.a.c.c)Dj()).Dl();
      if ((((AppBrandRuntime)localObject).getWindowAndroid() instanceof com.tencent.mm.plugin.appbrand.s.a.a.o))
      {
        i = ((com.tencent.mm.plugin.appbrand.s.a.a.o)((AppBrandRuntime)localObject).getWindowAndroid()).blU().getDefaultDisplay().getRotation();
        bool2 = org.apache.commons.b.a.contains(new int[] { 0, 1 }, i);
        if (e.b.Mq(((AppBrandRuntime)localObject).getAppConfig().jbo.jbC) == e.b.lmO)
        {
          bool1 = true;
          if (bool2 != bool1)
          {
            i = 0;
            if (i == 0)
            {
              ad.e("Luggage.AppBrandGameServiceLogicImp", "hy: orientation judge failed! maybe because onConfigurationChange judgement and surface degree judgement not match");
              ((com.tencent.mm.plugin.appbrand.u.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(808L, 4L, 1L, false);
              ((com.tencent.mm.plugin.appbrand.u.b)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.u.b.class)).f(18284, new Object[] { Integer.valueOf(1) });
            }
            ((com.tencent.luggage.sdk.b.a.c.c)Dj()).c(paramJSONObject, "screenWidth", Integer.valueOf(this.ccM.getMagicBrush().cpc.Gi()));
            ((com.tencent.luggage.sdk.b.a.c.c)Dj()).c(paramJSONObject, "screenHeight", Integer.valueOf(this.ccM.getMagicBrush().cpc.Gj()));
            ((com.tencent.luggage.sdk.b.a.c.c)Dj()).c(paramJSONObject, "devicePixelRatio", Float.valueOf(this.ccM.getMagicBrush().cpc.getDevicePixelRatio()));
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
  
  public final void ch(String paramString)
  {
    AppMethodBeat.i(178033);
    ad.d("Luggage.AppBrandGameServiceLogicImp", "RemoteDebugInfo %s", new Object[] { paramString });
    dnz localdnz = new dnz();
    localdnz.EEy = ((com.tencent.luggage.sdk.b.a.c.c)Dj()).DK().aOd();
    localdnz.EEx = paramString;
    paramString = u.a(localdnz, this.ccR, "domEvent");
    this.ccI.a(paramString);
    AppMethodBeat.o(178033);
  }
  
  public final void ci(String paramString)
  {
    AppMethodBeat.i(130581);
    ad.i("Luggage.AppBrandGameServiceLogicImp", "hy: do nothing in game service when called from modularizing helper");
    AppMethodBeat.o(130581);
  }
  
  protected i d(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130564);
    paramString = new IJSRuntime.Config(paramString, paramArrayOfByte);
    paramString.cPa = true;
    paramString.cOZ = "1";
    paramString.cPc = true;
    paramString.cPe = new WeakReference(Dj());
    paramString = new com.tencent.mm.plugin.appbrand.jsruntime.b(paramString);
    AppMethodBeat.o(130564);
    return paramString;
  }
  
  protected void gG(int paramInt) {}
  
  public final com.tencent.magicbrush.d getMagicBrush()
  {
    AppMethodBeat.i(205068);
    com.tencent.magicbrush.d locald = this.ccM.getMagicBrush();
    AppMethodBeat.o(205068);
    return locald;
  }
  
  final class a
    implements q.b
  {
    private final String ccT;
    private final String ccU;
    private final long ccV;
    private boolean ccW;
    private m.c ccX;
    private final AtomicInteger ccY;
    
    a(String paramString)
    {
      AppMethodBeat.i(130541);
      this.ccV = l;
      this.ccW = false;
      this.ccX = null;
      this.ccY = new AtomicInteger(2);
      this.ccT = paramString;
      Object localObject1;
      this.ccU = localObject1;
      AppMethodBeat.o(130541);
    }
    
    private void Ce()
    {
      AppMethodBeat.i(130545);
      long l1;
      if (this.ccY.decrementAndGet() == 0)
      {
        if (this.ccX != null) {
          break label111;
        }
        l1 = this.ccV;
        if (this.ccX != null) {
          break label122;
        }
      }
      label111:
      label122:
      for (long l2 = System.currentTimeMillis();; l2 = this.ccX.cPY)
      {
        com.tencent.luggage.sdk.b.a.d.a locala = new com.tencent.luggage.sdk.b.a.d.a();
        locala.scriptName = this.ccT;
        locala.cgh = this.ccU;
        locala.cgj = bt.nullAsNil(this.ccU).length();
        ((com.tencent.luggage.sdk.b.a.c.c)a.this.Dj()).a(locala, this.ccW, l1, l2, this.ccX);
        AppMethodBeat.o(130545);
        return;
        l1 = this.ccX.cPX;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(130542);
      this.ccX = paramc;
      Ce();
      AppMethodBeat.o(130542);
    }
    
    public final void cj(String paramString)
    {
      AppMethodBeat.i(130544);
      ad.e("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script Failed: %s", new Object[] { paramString });
      a.Cd();
      this.ccW = false;
      Ce();
      AppMethodBeat.o(130544);
    }
    
    public final void onSuccess(String paramString)
    {
      AppMethodBeat.i(130543);
      ad.i("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script suc: %s, filelen: %d", new Object[] { paramString, Integer.valueOf(bool) });
      a.Cc();
      this.ccW = true;
      Ce();
      AppMethodBeat.o(130543);
    }
  }
  
  final class c
    implements d.b, d.d
  {
    private c() {}
    
    public final void onConsole(String paramString)
    {
      AppMethodBeat.i(130552);
      ad.i("Luggage.AppBrandGameServiceLogicImp", "[WAGame][CONSOLE] output = [%s]", new Object[] { paramString });
      com.tencent.luggage.sdk.d.c localc = ((com.tencent.luggage.sdk.b.a.c.c)a.this.Dj()).Dl();
      if ((localc == null) || (localc.DY() == null) || (localc.DY().cfq)) {
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
      ad.e("Luggage.AppBrandGameServiceLogicImp", "[WAGame][AppBrand] message = [%s] stackTrace = [%s]", new Object[] { paramString1, paramString2 });
      Object localObject = (t)((com.tencent.luggage.sdk.b.a.c.c)a.this.Dj()).aOf().P(t.class);
      if (paramInt == ((t)localObject).bfD().bfC())
      {
        cg.a(((com.tencent.luggage.sdk.b.a.c.c)a.this.Dj()).aOf(), "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.utils.p.Nn(paramString1), com.tencent.mm.plugin.appbrand.utils.p.Nn(paramString2) }), 0);
        AppMethodBeat.o(130554);
        return;
      }
      localObject = ((t)localObject).sy(paramInt);
      if (localObject == null)
      {
        paramString1 = new IllegalStateException("j2v8 not follow the pattern");
        AppMethodBeat.o(130554);
        throw paramString1;
      }
      ch.a((i)localObject, "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.utils.p.Nn(paramString1), com.tencent.mm.plugin.appbrand.utils.p.Nn(paramString2) }));
      AppMethodBeat.o(130554);
    }
  }
  
  final class d
    implements MagicBrushView.c
  {
    private boolean cde = true;
    
    private d() {}
    
    private void Cf()
    {
      AppMethodBeat.i(177433);
      com.tencent.luggage.sdk.b.a.c.c localc = (com.tencent.luggage.sdk.b.a.c.c)a.this.Dj();
      if (localc != null)
      {
        ad.i("Luggage.AppBrandGameServiceLogicImp", "hy: on resizeWindow");
        localc.a(new com.tencent.mm.plugin.appbrand.page.p());
      }
      AppMethodBeat.o(177433);
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(130556);
      Cf();
      AppMethodBeat.o(130556);
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(178032);
      if (this.cde)
      {
        this.cde = false;
        AppMethodBeat.o(178032);
        return;
      }
      Cf();
      AppMethodBeat.o(178032);
    }
    
    public final void aC(Object paramObject) {}
  }
  
  final class e
    implements MagicBrushView.g
  {
    private e() {}
    
    public final void gH(int paramInt)
    {
      AppMethodBeat.i(130557);
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("onMainCanvasTypeDefined received invalid input [" + paramInt + "]");
        AppMethodBeat.o(130557);
        throw localIllegalStateException;
      }
      if ((!((com.tencent.luggage.sdk.b.a.c.c)a.this.Dj()).aNv()) && (!((com.tencent.luggage.sdk.b.a.c.c)a.this.Dj()).isRunning()))
      {
        AppMethodBeat.o(130557);
        return;
      }
      a.this.gG(paramInt);
      AppMethodBeat.o(130557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */