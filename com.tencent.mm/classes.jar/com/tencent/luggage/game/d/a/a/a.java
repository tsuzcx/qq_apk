package com.tencent.luggage.game.d.a.a;

import android.content.Context;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.luggage.game.a.f.a;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.magicbrush.d.b;
import com.tencent.magicbrush.d.d;
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
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.debugger.w;
import com.tencent.mm.plugin.appbrand.jsapi.cj;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.l;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.plugin.appbrand.utils.s.b;
import com.tencent.mm.plugin.appbrand.utils.t.1;
import com.tencent.mm.plugin.appbrand.utils.t.a;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.protocal.protobuf.ebb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
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
  private volatile boolean cjX;
  private boolean cjY;
  private com.tencent.mm.plugin.appbrand.debugger.o cjZ;
  private boolean cka;
  private boolean ckb;
  private int ckc;
  public com.tencent.luggage.game.a.d ckd;
  private com.tencent.luggage.sdk.b.a.a.c cke;
  private com.tencent.luggage.sdk.b.a.a.a ckf;
  private com.tencent.luggage.sdk.b.a.a.d ckg;
  private com.tencent.luggage.game.c.e ckh;
  private com.tencent.mm.plugin.appbrand.debugger.m cki;
  
  public a(Service paramService)
  {
    super(paramService);
    AppMethodBeat.i(130561);
    this.cjX = false;
    this.cjY = false;
    this.cjZ = null;
    this.cka = false;
    this.ckb = false;
    this.ckc = 0;
    this.ckd = null;
    this.ckh = null;
    this.cki = null;
    b(b.class, this);
    CM();
    AppMethodBeat.o(130561);
  }
  
  private void CU()
  {
    AppMethodBeat.i(130569);
    try
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB();
      if (localObject == null)
      {
        AppMethodBeat.o(130569);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.jsruntime.q)((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject).P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject).setThreadPriority(-8);
      }
      AppMethodBeat.o(130569);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(130569);
    }
  }
  
  private void CZ()
  {
    boolean bool = true;
    AppMethodBeat.i(130573);
    if (this.ckd != null) {}
    for (;;)
    {
      ae.i("Luggage.AppBrandGameServiceLogicImp", "setup magicbrush. loaded?[%b]", new Object[] { Boolean.valueOf(bool) });
      if (this.ckd == null) {
        break;
      }
      AppMethodBeat.o(130573);
      return;
      bool = false;
    }
    ((com.tencent.luggage.sdk.b.a.c.c)Eo()).biL();
    this.cka = CV();
    this.ckb = CW();
    this.ckc = CX();
    this.ckd = a(this.cka, this.ckb, this.ckc, CY());
    this.ckd.Cy();
    com.tencent.luggage.game.a.a.a(this.ckd.getMagicBrush(), ((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB());
    c localc = new c((byte)0);
    this.ckd.getMagicBrush().cxq.add(localc);
    this.ckd.getMagicBrush().cxp.add(localc);
    this.ckd.getMagicBrush().cxr.addListener(new MBViewManager.a()
    {
      public final void a(MagicBrushView paramAnonymousMagicBrushView) {}
      
      public final void b(MagicBrushView paramAnonymousMagicBrushView)
      {
        AppMethodBeat.i(220718);
        a.e locale = new a.e(a.this, (byte)0);
        d.g.b.p.h(locale, "l");
        paramAnonymousMagicBrushView.cAO.add(locale);
        paramAnonymousMagicBrushView.a(new a.d(a.this, (byte)0));
        AppMethodBeat.o(220718);
      }
    });
    this.ckd.getMagicBrush().cwY = new com.tencent.magicbrush.handler.b()
    {
      public final String a(final String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(220719);
        if (a.this.Eo() == null)
        {
          AppMethodBeat.o(220719);
          return "";
        }
        try
        {
          paramAnonymousString1 = ((com.tencent.luggage.sdk.b.a.c.c)a.this.Eo()).b(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousBoolean);
          AppMethodBeat.o(220719);
          return paramAnonymousString1;
        }
        catch (Throwable paramAnonymousString1)
        {
          ae.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", paramAnonymousString1, "IMBInvokeHandler.invoke", new Object[0]);
          com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
          {
            public final void run()
            {
              throw paramAnonymousString1;
            }
          });
          AppMethodBeat.o(220719);
        }
        return "";
      }
      
      public final String[] getAsyncableJsApis()
      {
        AppMethodBeat.i(220720);
        if (a.this.Eo() == null)
        {
          AppMethodBeat.o(220720);
          return null;
        }
        String[] arrayOfString = ((com.tencent.luggage.sdk.b.a.c.c)a.this.Eo()).getAsyncableJsApis();
        AppMethodBeat.o(220720);
        return arrayOfString;
      }
      
      public final ByteBuffer readWeAppFile(String paramAnonymousString)
      {
        AppMethodBeat.i(220721);
        if (a.this.Eo() == null)
        {
          AppMethodBeat.o(220721);
          return null;
        }
        com.tencent.mm.plugin.appbrand.y.i locali = new com.tencent.mm.plugin.appbrand.y.i();
        com.tencent.mm.plugin.appbrand.appstorage.m localm = ((com.tencent.luggage.sdk.b.a.c.c)a.this.Eo()).Fl().b(paramAnonymousString, locali);
        if (localm == com.tencent.mm.plugin.appbrand.appstorage.m.jPM)
        {
          paramAnonymousString = x.q((ByteBuffer)locali.value);
          AppMethodBeat.o(220721);
          return paramAnonymousString;
        }
        ae.e("Luggage.AppBrandGameServiceLogicImp", "readFile %s failed: %s", new Object[] { paramAnonymousString, localm });
        AppMethodBeat.o(220721);
        return null;
      }
    };
    AppMethodBeat.o(130573);
  }
  
  private void De()
  {
    AppMethodBeat.i(130578);
    if (this.cjY)
    {
      AppMethodBeat.o(130578);
      return;
    }
    this.cjY = true;
    ae.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame to MainContext");
    Object localObject1 = Dc();
    s.a(((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB(), (String)localObject1, new s.a()
    {
      public final void cV(String paramAnonymousString)
      {
        AppMethodBeat.i(220723);
        ae.e("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script Failed: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(220723);
      }
      
      public final void onSuccess(String paramAnonymousString)
      {
        AppMethodBeat.i(220722);
        ae.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script suc: %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(220722);
      }
    });
    Object localObject2 = ((com.tencent.luggage.sdk.b.a.c.c)Eo()).aWe().LD("WAGame.js");
    Object localObject3 = "v" + ((com.tencent.luggage.sdk.b.a.c.c)Eo()).aWe().aZM();
    com.tencent.mm.plugin.appbrand.ar.a((com.tencent.mm.plugin.appbrand.d)Eo(), ((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB());
    ((com.tencent.mm.plugin.appbrand.s.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.s.a.class)).idkeyStat(778L, 13L, 1L, false);
    final long l = System.currentTimeMillis();
    final boolean bool = ((com.tencent.luggage.sdk.b.a.c.c)Eo()).aXP();
    if (localObject2 == null) {}
    String str;
    for (int i = 0;; i = ((String)localObject2).length())
    {
      localObject1 = new a("WAGame.js", (String)localObject2, l, i, bool);
      if ((((com.tencent.luggage.sdk.b.a.c.c)Eo()).Eq() == null) || (!((com.tencent.luggage.sdk.b.a.c.c)Eo()).Eq().Fj())) {
        break label428;
      }
      str = ";(function(global) { var protectedConsole = global.console; Object.defineProperty(global, 'console', { get() { return protectedConsole; }, set() { } }); })(this);".concat(String.valueOf(localObject2));
      localObject2 = (com.tencent.mm.plugin.appbrand.r)Eo();
      localObject4 = ((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB();
      localObject3 = t.a.mUb;
      if (!bu.isNullOrNil(str)) {
        break;
      }
      ((s.a)localObject1).cV("isNullOrNil script");
      AppMethodBeat.o(130578);
      return;
    }
    Object localObject4 = (l)((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject4).P(l.class);
    if (localObject4 != null) {
      str = str + String.format(Locale.ENGLISH, ";(function(){return %d;})();", new Object[] { Integer.valueOf(11111) });
    }
    try
    {
      localObject2 = new URL(com.tencent.mm.plugin.appbrand.utils.t.a((com.tencent.mm.plugin.appbrand.r)localObject2, (t.a)localObject3) + "WAGame.js");
      ((l)localObject4).a(str, ((URL)localObject2).toString(), new t.1((s.a)localObject1));
      AppMethodBeat.o(130578);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      AppMethodBeat.o(130578);
      return;
    }
    label428:
    com.tencent.mm.plugin.appbrand.utils.t.a((com.tencent.mm.plugin.appbrand.r)Eo(), ((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB(), "WAGame.js", "WAGame.js", (String)localObject3, Dd(), (String)localObject2, t.a.mUb, localMalformedURLException);
    AppMethodBeat.o(130578);
  }
  
  public final com.tencent.luggage.game.c.e CK()
  {
    AppMethodBeat.i(130558);
    if (this.ckh == null) {}
    try
    {
      if (this.ckh == null) {
        this.ckh = new com.tencent.luggage.game.c.e();
      }
      com.tencent.luggage.game.c.e locale = this.ckh;
      AppMethodBeat.o(130558);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(130558);
    }
  }
  
  public final String CL()
  {
    AppMethodBeat.i(130559);
    Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)Eo()).EP();
    String str = ((com.tencent.luggage.sdk.b.a.c.c)Eo()).Eq().getAppConfig().jZa;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(130559);
    return localObject;
  }
  
  protected void CM()
  {
    AppMethodBeat.i(130562);
    new com.tencent.luggage.game.b.d().CA();
    AppMethodBeat.o(130562);
  }
  
  public final boolean CN()
  {
    return true;
  }
  
  public com.tencent.mm.plugin.appbrand.jsruntime.i CO()
  {
    AppMethodBeat.i(130563);
    ae.i("Luggage.AppBrandGameServiceLogicImp", "createJsRuntime");
    long l = System.currentTimeMillis();
    Object localObject2 = CS();
    Object localObject1 = null;
    if (CT()) {
      if (!com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) {
        break label189;
      }
    }
    label189:
    for (localObject1 = com.tencent.mm.plugin.appbrand.y.d.VF("wxa_library/v8_snapshot64.bin");; localObject1 = com.tencent.mm.plugin.appbrand.y.d.VF("wxa_library/v8_snapshot.bin"))
    {
      localObject1 = d((String)localObject2, (byte[])localObject1);
      localObject2 = (com.tencent.mm.plugin.appbrand.jsruntime.t)((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject1).P(com.tencent.mm.plugin.appbrand.jsruntime.t.class);
      localObject2 = a((com.tencent.luggage.sdk.b.a.c.c)Eo(), (com.tencent.mm.plugin.appbrand.jsruntime.t)localObject2);
      ((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject1).setJsExceptionHandler(new h()
      {
        public final void u(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(130540);
          Object localObject = (com.tencent.luggage.sdk.b.a.c.c)a.this.Eo();
          if (localObject == null) {}
          for (localObject = null; localObject == null; localObject = ((com.tencent.luggage.sdk.b.a.c.c)localObject).aYB())
          {
            AppMethodBeat.o(130540);
            return;
          }
          ae.e("Luggage.AppBrandGameServiceLogicImp", "[WAGameJsException] hy: wxa main context exception %s %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          cj.a((com.tencent.mm.plugin.appbrand.jsruntime.o)localObject, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.utils.r.VN(paramAnonymousString1), com.tencent.mm.plugin.appbrand.utils.r.VN(paramAnonymousString2) }), 0);
          com.tencent.mm.plugin.appbrand.w.b.a.bze();
          com.tencent.mm.plugin.appbrand.w.b.L("WeAppLaunch", paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(130540);
        }
      });
      ((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject1).addJavascriptInterface(localObject2, "WeixinJSContext");
      s.a((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject1, com.tencent.luggage.sdk.b.a.c.g.coZ, new d.1((d)localObject2));
      s.a((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject1, String.format(";(function(){let interface = %s;let alloc = interface.alloc;let allocNativeGlobal = interface.allocNativeGlobal;interface.alloc = function(injectNativeGlobal) {if(injectNativeGlobal){return allocNativeGlobal();}else{return alloc();}}})();", new Object[] { "WeixinJSContext" }), new d.2((d)localObject2));
      ((d)localObject2).Dn();
      ae.i("Luggage.AppBrandGameServiceLogicImp", "[damonlei] createJsRuntime cost [%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(130563);
      return localObject1;
    }
  }
  
  public void CP()
  {
    AppMethodBeat.i(130566);
    super.CP();
    this.cke = new com.tencent.luggage.sdk.b.a.a.c();
    this.cke.a(((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB(), Eo());
    this.ckf = new com.tencent.luggage.sdk.b.a.a.a();
    com.tencent.luggage.sdk.b.a.a.a locala = this.ckf;
    com.tencent.mm.plugin.appbrand.jsruntime.i locali = ((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB();
    Object localObject = Eo();
    ae.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding");
    if (locali == null) {
      ae.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsruntime is null");
    }
    for (;;)
    {
      this.ckg = new com.tencent.luggage.sdk.b.a.a.d();
      this.ckg.a(((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB(), Eo(), 1);
      AppMethodBeat.o(130566);
      return;
      locala.cnA = "1004";
      com.tencent.mm.game.a.a.loadLibraries();
      com.tencent.mm.plugin.appbrand.jsruntime.q localq = (com.tencent.mm.plugin.appbrand.jsruntime.q)locali.P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localq == null)
      {
        ae.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsThreadHandler is null");
      }
      else
      {
        localObject = (com.tencent.luggage.sdk.b.a.a.b)((com.tencent.mm.plugin.appbrand.jsapi.c)localObject).K(com.tencent.luggage.sdk.b.a.a.b.class);
        if (localObject != null)
        {
          locala.cnB = ((com.tencent.luggage.sdk.b.a.a.b)localObject).EA();
          ae.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(locala.cnB) });
        }
        localq.post(new com.tencent.luggage.sdk.b.a.a.a.3(locala, locali, new com.tencent.luggage.sdk.b.a.a.a.1(locala, new WeakReference(localq)), new com.tencent.luggage.sdk.b.a.a.a.2(locala)));
      }
    }
  }
  
  public void CQ()
  {
    AppMethodBeat.i(130567);
    super.CQ();
    if (this.ckd != null) {
      this.ckd.destroy();
    }
    if (this.cke != null) {
      this.cke.a(((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB());
    }
    com.tencent.luggage.sdk.b.a.a.a locala;
    com.tencent.mm.plugin.appbrand.jsruntime.i locali;
    if (this.ckf != null)
    {
      locala = this.ckf;
      locali = ((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB();
      ae.i("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding");
      if (locali != null) {
        break label124;
      }
      ae.e("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding jsruntime is null");
    }
    for (;;)
    {
      if (this.ckg != null) {
        this.ckg.b(((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB());
      }
      AppMethodBeat.o(130567);
      return;
      label124:
      ((com.tencent.mm.plugin.appbrand.jsruntime.m)locali.P(com.tencent.mm.plugin.appbrand.jsruntime.m.class)).a(locala.cnC);
    }
  }
  
  public void CR()
  {
    AppMethodBeat.i(130568);
    super.CR();
    if (this.ckd != null)
    {
      if (this.ckd.cip != null) {
        this.ckd.getMagicBrush().cwY = null;
      }
      Object localObject = this.ckd;
      ae.i("MicroMsg.MagicBrush", "awaitDestroyDone");
      if ((!((com.tencent.luggage.game.a.f)localObject).cir.aN(5000L)) && (com.tencent.mm.sdk.platformtools.j.DEBUG))
      {
        localObject = (Throwable)new IllegalStateException("WAGame destroy timeout");
        AppMethodBeat.o(130568);
        throw ((Throwable)localObject);
      }
    }
    if (this.cjZ != null) {
      this.cjZ.destroy();
    }
    AppMethodBeat.o(130568);
  }
  
  protected String CS()
  {
    return null;
  }
  
  protected boolean CT()
  {
    return true;
  }
  
  protected boolean CV()
  {
    AppMethodBeat.i(130571);
    if (((com.tencent.luggage.sdk.b.a.c.c)Eo()).Eq() != null)
    {
      com.tencent.mm.plugin.appbrand.config.a locala = ((com.tencent.luggage.sdk.b.a.c.c)Eo()).Eq().getAppConfig();
      if (locala.jYO != null)
      {
        boolean bool = locala.jYO.booleanValue();
        AppMethodBeat.o(130571);
        return bool;
      }
    }
    AppMethodBeat.o(130571);
    return true;
  }
  
  protected boolean CW()
  {
    return true;
  }
  
  protected int CX()
  {
    return 1;
  }
  
  protected boolean CY()
  {
    return false;
  }
  
  public final void Da()
  {
    AppMethodBeat.i(130574);
    ae.i("Luggage.AppBrandGameServiceLogicImp", "onRuntimeResume");
    super.Da();
    CU();
    if (this.cjZ != null) {
      this.cjZ.keO.bringToFront();
    }
    AppMethodBeat.o(130574);
  }
  
  public final void Db()
  {
    AppMethodBeat.i(130575);
    super.Db();
    try
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB();
      if (localObject == null)
      {
        AppMethodBeat.o(130575);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.jsruntime.q)((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject).P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject).setThreadPriority(10);
      }
      AppMethodBeat.o(130575);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(130575);
    }
  }
  
  protected String Dc()
  {
    AppMethodBeat.i(130577);
    String str = com.tencent.mm.plugin.appbrand.y.d.VE("wxa_library/android.js") + com.tencent.mm.plugin.appbrand.y.d.VE("wxa_library/shared_buffer.js") + com.tencent.mm.plugin.appbrand.y.d.VE("wxa_library/NativeGlobal-WAGame.js");
    AppMethodBeat.o(130577);
    return str;
  }
  
  protected int Dd()
  {
    return 0;
  }
  
  public final void Df()
  {
    AppMethodBeat.i(130579);
    super.Df();
    Object localObject;
    if ((((com.tencent.luggage.sdk.b.a.c.c)Eo()).Eq() != null) && (((com.tencent.luggage.sdk.b.a.c.c)Eo()).Eq().Fj()))
    {
      com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220724);
          a.a(a.this, new com.tencent.mm.plugin.appbrand.debugger.o());
          a.a(a.this, new com.tencent.mm.plugin.appbrand.debugger.m());
          a.b(a.this).a((com.tencent.luggage.sdk.b.a.c.c)a.this.Eo(), ((com.tencent.luggage.sdk.b.a.c.c)a.this.Eo()).Eq().Fg().extInfo);
          a.c(a.this).a(a.b(a.this));
          AppMethodBeat.o(220724);
        }
      });
      localObject = (l)((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB().P(l.class);
      if (localObject != null) {
        ((l)localObject).Sk("xdebug");
      }
      if (((com.tencent.luggage.sdk.b.a.c.c)Eo()).aXQ()) {
        localObject = ((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB();
      }
    }
    try
    {
      URL localURL = new URL("https://usr/" + "break.js");
      ((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject).a(localURL, "breakprogram();", null);
      AppMethodBeat.o(130579);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      AppMethodBeat.o(130579);
    }
  }
  
  public final void Dg()
  {
    AppMethodBeat.i(130580);
    ae.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.init");
    this.cjX = true;
    ae.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl mServiceReady = [%b], isRunning[%b]", new Object[] { Boolean.valueOf(this.cjX), Boolean.valueOf(((com.tencent.luggage.sdk.b.a.c.c)Eo()).isRunning()) });
    if ((!this.cjX) || (!((com.tencent.luggage.sdk.b.a.c.c)Eo()).isRunning()))
    {
      AppMethodBeat.o(130580);
      return;
    }
    try
    {
      ae.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl start");
      if (!this.cjY) {
        ((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB().evaluateJavascript(com.tencent.mm.plugin.appbrand.y.d.VE("wxa_library/android.js"), null);
      }
      ((com.tencent.luggage.sdk.b.a.c.c)Eo()).EQ();
      De();
      ((com.tencent.luggage.sdk.b.a.c.c)Eo()).K(new Runnable()
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
      if (((com.tencent.luggage.sdk.b.a.c.c)Eo()).isRunning())
      {
        AppMethodBeat.o(130580);
        throw localNullPointerException;
      }
      AppMethodBeat.o(130580);
    }
  }
  
  public final void Dh()
  {
    AppMethodBeat.i(130582);
    ae.i("Luggage.AppBrandGameServiceLogicImp", "start preload");
    CZ();
    De();
    ((com.tencent.luggage.sdk.b.a.c.c)Eo()).biM();
    ae.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppService preloaded.");
    AppMethodBeat.o(130582);
  }
  
  protected com.tencent.luggage.game.a.d a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(220725);
    com.tencent.luggage.game.a.d local3 = new com.tencent.luggage.game.a.d(((com.tencent.luggage.sdk.b.a.c.c)Eo()).getContext(), ((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB(), paramBoolean1, paramBoolean2, paramInt, paramBoolean3)
    {
      public final void a(com.tencent.magicbrush.e paramAnonymouse)
      {
        AppMethodBeat.i(220717);
        super.a(paramAnonymouse);
        paramAnonymouse.b(com.tencent.magicbrush.ui.a.b.cAu);
        paramAnonymouse.bR(false);
        AppMethodBeat.o(220717);
      }
    };
    AppMethodBeat.o(220725);
    return local3;
  }
  
  protected d a(Service paramService, com.tencent.mm.plugin.appbrand.jsruntime.t paramt)
  {
    AppMethodBeat.i(130565);
    paramService = new d(paramService, paramt);
    AppMethodBeat.o(130565);
    return paramService;
  }
  
  public void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130570);
    CZ();
    if (this.ckd != null) {
      this.ckd.b(paramAppBrandRuntime);
    }
    if (this.ckg != null) {
      this.ckg.b(((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB(), Eo());
    }
    com.tencent.luggage.sdk.b.a.a.a locala;
    Object localObject;
    com.tencent.mm.plugin.appbrand.jsapi.c localc;
    if (this.ckf != null)
    {
      locala = this.ckf;
      localObject = ((com.tencent.luggage.sdk.b.a.c.c)Eo()).aYB();
      localc = Eo();
      ae.i("Luggage.LockStepNativeInstallHelper", "initConfigLockStep");
      if (localObject != null) {
        break label158;
      }
      ae.e("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsruntime is null");
    }
    for (;;)
    {
      CU();
      paramAppBrandRuntime.b(aa.class, new com.tencent.luggage.game.f.a(com.tencent.mm.sdk.f.a.jw(paramAppBrandRuntime.mContext)));
      this.ckd.getMagicBrush().cxr.addSurfaceListenerForAllViews(new MagicBrushView.d()
      {
        public final void aB(Object paramAnonymousObject)
        {
          AppMethodBeat.i(162096);
          paramAnonymousObject = a.this.Eq();
          if ((paramAnonymousObject != null) && (paramAnonymousObject.jzQ != null))
          {
            paramAnonymousObject.jzQ.fO(true);
            Object localObject = paramAnonymousObject.jzQ.jOf;
            paramAnonymousObject = new LinkedList(((com.tencent.mm.plugin.appbrand.a.d)localObject).jOt);
            ((com.tencent.mm.plugin.appbrand.a.d)localObject).jOt.clear();
            while (!paramAnonymousObject.isEmpty())
            {
              localObject = (com.tencent.mm.plugin.appbrand.a.j)paramAnonymousObject.poll();
              aq localaq = ((com.tencent.mm.plugin.appbrand.a.j)localObject).mHandler;
              if (localaq != null)
              {
                ((com.tencent.mm.plugin.appbrand.a.j)localObject).mHandler.removeCallbacks(((com.tencent.mm.plugin.appbrand.a.j)localObject).cBs);
                if (Looper.myLooper() == localaq.getLooper()) {
                  ((com.tencent.mm.plugin.appbrand.a.j)localObject).cBs.run();
                } else {
                  ((com.tencent.mm.plugin.appbrand.a.j)localObject).aG(((com.tencent.mm.plugin.appbrand.a.j)localObject).result);
                }
              }
            }
          }
          AppMethodBeat.o(162096);
        }
        
        public final void b(Object paramAnonymousObject, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(220716);
          paramAnonymousObject = a.this.Eq();
          if ((paramAnonymousObject != null) && (paramAnonymousObject.jzQ != null)) {
            paramAnonymousObject.jzQ.fO(false);
          }
          AppMethodBeat.o(220716);
        }
      });
      AppMethodBeat.o(130570);
      return;
      label158:
      localObject = (com.tencent.mm.plugin.appbrand.jsruntime.q)((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject).P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localObject == null) {
        ae.e("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsThreadHandler is null");
      } else {
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject).post(new com.tencent.luggage.sdk.b.a.a.a.4(locala, localc));
      }
    }
  }
  
  public void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(130560);
    AppBrandSysConfigLU localAppBrandSysConfigLU = ((com.tencent.luggage.sdk.b.a.c.c)Eo()).Eq().Ff();
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
        if (i < localAppBrandSysConfigLU.cnh.kac.length)
        {
          localJSONArray.put(localAppBrandSysConfigLU.cnh.kac[i]);
          i += 1;
          continue;
        }
        ((com.tencent.luggage.sdk.b.a.c.c)Eo()).c((JSONObject)localObject, "subContextImgDomain", localJSONArray);
      }
      catch (Exception localException)
      {
        int i;
        boolean bool2;
        boolean bool1;
        continue;
      }
      ((com.tencent.luggage.sdk.b.a.c.c)Eo()).c(paramJSONObject, "wxAppInfo", localObject);
      ae.i("Luggage.AppBrandGameServiceLogicImp", "dm.widthPixels %d, dm.heightPixels %d", new Object[] { Integer.valueOf(this.ckd.getMagicBrush().cxn.Hv()), Integer.valueOf(this.ckd.getMagicBrush().cxn.Hw()) });
      localObject = ((com.tencent.luggage.sdk.b.a.c.c)Eo()).Eq();
      if ((((AppBrandRuntime)localObject).getWindowAndroid() instanceof com.tencent.mm.plugin.appbrand.platform.window.a.o))
      {
        i = ((com.tencent.mm.plugin.appbrand.platform.window.a.o)((AppBrandRuntime)localObject).getWindowAndroid()).bxM().getDefaultDisplay().getRotation();
        bool2 = org.apache.commons.b.a.contains(new int[] { 0, 1 }, i);
        if (e.b.UP(((AppBrandRuntime)localObject).getAppConfig().jYN.cpm) == e.b.mtD)
        {
          bool1 = true;
          if (bool2 != bool1)
          {
            i = 0;
            if (i == 0)
            {
              ae.e("Luggage.AppBrandGameServiceLogicImp", "hy: orientation judge failed! maybe because onConfigurationChange judgement and surface degree judgement not match");
              ((com.tencent.mm.plugin.appbrand.s.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.s.a.class)).idkeyStat(808L, 4L, 1L, false);
              ((com.tencent.mm.plugin.appbrand.s.b)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.s.b.class)).f(18284, new Object[] { Integer.valueOf(1) });
            }
            ((com.tencent.luggage.sdk.b.a.c.c)Eo()).c(paramJSONObject, "screenWidth", Integer.valueOf(this.ckd.getMagicBrush().cxn.Hv()));
            ((com.tencent.luggage.sdk.b.a.c.c)Eo()).c(paramJSONObject, "screenHeight", Integer.valueOf(this.ckd.getMagicBrush().cxn.Hw()));
            ((com.tencent.luggage.sdk.b.a.c.c)Eo()).c(paramJSONObject, "devicePixelRatio", Float.valueOf(this.ckd.getMagicBrush().cxn.getDevicePixelRatio()));
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
  
  public final void cT(String paramString)
  {
    AppMethodBeat.i(178033);
    ae.d("Luggage.AppBrandGameServiceLogicImp", "RemoteDebugInfo %s", new Object[] { paramString });
    ebb localebb = new ebb();
    localebb.IgP = ((com.tencent.luggage.sdk.b.a.c.c)Eo()).EO().aXX();
    localebb.IgO = paramString;
    paramString = v.a(localebb, this.cki, "domEvent");
    this.cjZ.a(paramString);
    AppMethodBeat.o(178033);
  }
  
  public final boolean cU(String paramString)
  {
    AppMethodBeat.i(220727);
    ae.i("Luggage.AppBrandGameServiceLogicImp", "hy: do nothing in game service when called from modularizing helper");
    AppMethodBeat.o(220727);
    return false;
  }
  
  protected com.tencent.mm.plugin.appbrand.jsruntime.i d(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130564);
    paramString = new IJSRuntime.Config(paramString, paramArrayOfByte);
    paramString.cYI = true;
    paramString.cYH = "1";
    paramString.cYK = true;
    paramString.cYN = new WeakReference(Eo());
    paramString = new com.tencent.mm.plugin.appbrand.jsruntime.b(paramString);
    AppMethodBeat.o(130564);
    return paramString;
  }
  
  public final com.tencent.magicbrush.d getMagicBrush()
  {
    AppMethodBeat.i(224434);
    com.tencent.magicbrush.d locald = this.ckd.getMagicBrush();
    AppMethodBeat.o(224434);
    return locald;
  }
  
  protected void gt(int paramInt) {}
  
  final class a
    implements s.b
  {
    private final String ckk;
    private final String ckl;
    private final long ckm;
    private boolean ckn;
    private m.c cko;
    private final AtomicInteger ckp;
    
    a(String paramString)
    {
      AppMethodBeat.i(130541);
      this.ckm = l;
      this.ckn = false;
      this.cko = null;
      this.ckp = new AtomicInteger(2);
      this.ckk = paramString;
      Object localObject1;
      this.ckl = localObject1;
      AppMethodBeat.o(130541);
    }
    
    private void Dk()
    {
      AppMethodBeat.i(130545);
      long l1;
      if (this.ckp.decrementAndGet() == 0)
      {
        if (this.cko != null) {
          break label111;
        }
        l1 = this.ckm;
        if (this.cko != null) {
          break label122;
        }
      }
      label111:
      label122:
      for (long l2 = System.currentTimeMillis();; l2 = this.cko.cZH)
      {
        d.a locala = new d.a();
        locala.scriptName = this.ckk;
        locala.cnx = this.ckl;
        locala.cny = bu.nullAsNil(this.ckl).length();
        ((com.tencent.luggage.sdk.b.a.c.c)a.this.Eo()).a(locala, this.ckn, l1, l2, this.cko);
        AppMethodBeat.o(130545);
        return;
        l1 = this.cko.cZG;
        break;
      }
    }
    
    public final void a(m.c paramc)
    {
      AppMethodBeat.i(130542);
      this.cko = paramc;
      Dk();
      AppMethodBeat.o(130542);
    }
    
    public final void cV(String paramString)
    {
      AppMethodBeat.i(130544);
      ae.e("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script Failed: %s", new Object[] { paramString });
      a.Dj();
      this.ckn = false;
      Dk();
      AppMethodBeat.o(130544);
    }
    
    public final void onSuccess(String paramString)
    {
      AppMethodBeat.i(130543);
      ae.i("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script suc: %s, filelen: %d", new Object[] { paramString, Integer.valueOf(bool) });
      a.Di();
      this.ckn = true;
      Dk();
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
      ae.i("Luggage.AppBrandGameServiceLogicImp", "[WAGame][CONSOLE] output = [%s]", new Object[] { paramString });
      com.tencent.luggage.sdk.d.d locald = ((com.tencent.luggage.sdk.b.a.c.c)a.this.Eo()).Eq();
      if ((locald == null) || (locald.Ff() == null) || (locald.Ff().cmG)) {
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
      ae.e("Luggage.AppBrandGameServiceLogicImp", "[WAGame][AppBrand] message = [%s] stackTrace = [%s]", new Object[] { paramString1, paramString2 });
      Object localObject = (com.tencent.mm.plugin.appbrand.jsruntime.t)((com.tencent.luggage.sdk.b.a.c.c)a.this.Eo()).aYB().P(com.tencent.mm.plugin.appbrand.jsruntime.t.class);
      if (paramInt == ((com.tencent.mm.plugin.appbrand.jsruntime.t)localObject).bqR().bqQ())
      {
        cj.a(((com.tencent.luggage.sdk.b.a.c.c)a.this.Eo()).aYB(), "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.utils.r.VN(paramString1), com.tencent.mm.plugin.appbrand.utils.r.VN(paramString2) }), 0);
        AppMethodBeat.o(130554);
        return;
      }
      localObject = ((com.tencent.mm.plugin.appbrand.jsruntime.t)localObject).tY(paramInt);
      if (localObject == null)
      {
        paramString1 = new IllegalStateException("j2v8 not follow the pattern");
        AppMethodBeat.o(130554);
        throw paramString1;
      }
      ck.a((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject, "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.utils.r.VN(paramString1), com.tencent.mm.plugin.appbrand.utils.r.VN(paramString2) }));
      AppMethodBeat.o(130554);
    }
  }
  
  final class d
    implements MagicBrushView.c
  {
    private boolean firstTime = true;
    
    private d() {}
    
    private void Dl()
    {
      AppMethodBeat.i(177433);
      com.tencent.luggage.sdk.b.a.c.c localc = (com.tencent.luggage.sdk.b.a.c.c)a.this.Eo();
      if (localc != null)
      {
        ae.i("Luggage.AppBrandGameServiceLogicImp", "hy: on resizeWindow");
        localc.a(new com.tencent.mm.plugin.appbrand.page.p());
      }
      AppMethodBeat.o(177433);
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(130556);
      Dl();
      AppMethodBeat.o(130556);
    }
    
    public final void a(Object paramObject, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(178032);
      if (this.firstTime)
      {
        this.firstTime = false;
        AppMethodBeat.o(178032);
        return;
      }
      Dl();
      AppMethodBeat.o(178032);
    }
    
    public final void b(Object paramObject, boolean paramBoolean) {}
  }
  
  final class e
    implements MagicBrushView.g
  {
    private e() {}
    
    public final void gu(int paramInt)
    {
      AppMethodBeat.i(130557);
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("onMainCanvasTypeDefined received invalid input [" + paramInt + "]");
        AppMethodBeat.o(130557);
        throw localIllegalStateException;
      }
      if ((!((com.tencent.luggage.sdk.b.a.c.c)a.this.Eo()).aXP()) && (!((com.tencent.luggage.sdk.b.a.c.c)a.this.Eo()).isRunning()))
      {
        AppMethodBeat.o(130557);
        return;
      }
      a.this.gt(paramInt);
      AppMethodBeat.o(130557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */