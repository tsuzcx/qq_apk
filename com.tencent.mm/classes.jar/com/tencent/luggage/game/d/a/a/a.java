package com.tencent.luggage.game.d.a.a;

import android.view.Display;
import android.view.WindowManager;
import com.tencent.luggage.game.a.d.a;
import com.tencent.luggage.sdk.b.a.b.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.debugger.w;
import com.tencent.mm.plugin.appbrand.jsruntime.l;
import com.tencent.mm.plugin.appbrand.jsruntime.t;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.plugin.appbrand.ui.z;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.plugin.appbrand.utils.r.1;
import com.tencent.mm.plugin.appbrand.utils.r.a;
import com.tencent.mm.protocal.protobuf.dzk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class a<Service extends com.tencent.luggage.sdk.b.a.c.c>
  extends com.tencent.luggage.sdk.b.a.c.e<Service>
  implements b
{
  private volatile boolean cjV;
  private boolean cjW;
  private com.tencent.mm.plugin.appbrand.debugger.o cjX;
  private boolean cjY;
  private boolean cjZ;
  private int cka;
  public com.tencent.luggage.game.a.b ckb;
  private com.tencent.luggage.sdk.b.a.a.c ckc;
  private com.tencent.luggage.sdk.b.a.a.a ckd;
  private com.tencent.luggage.sdk.b.a.a.d cke;
  private com.tencent.luggage.game.c.e ckf;
  private com.tencent.mm.plugin.appbrand.debugger.m ckg;
  
  public a(Service paramService)
  {
    super(paramService);
    AppMethodBeat.i(130561);
    this.cjV = false;
    this.cjW = false;
    this.cjX = null;
    this.cjY = false;
    this.cjZ = false;
    this.cka = 0;
    this.ckb = null;
    this.ckf = null;
    this.ckg = null;
    b(b.class, this);
    CJ();
    AppMethodBeat.o(130561);
  }
  
  private void CR()
  {
    AppMethodBeat.i(130569);
    try
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)El()).aYh();
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
      ad.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(130569);
    }
  }
  
  private void CW()
  {
    boolean bool = true;
    AppMethodBeat.i(130573);
    if (this.ckb != null) {}
    for (;;)
    {
      ad.i("Luggage.AppBrandGameServiceLogicImp", "setup magicbrush. loaded?[%b]", new Object[] { Boolean.valueOf(bool) });
      if (this.ckb == null) {
        break;
      }
      AppMethodBeat.o(130573);
      return;
      bool = false;
    }
    ((com.tencent.luggage.sdk.b.a.c.c)El()).bic();
    this.cjY = CS();
    this.cjZ = CT();
    this.cka = CU();
    this.ckb = a(this.cjY, this.cjZ, this.cka, CV());
    this.ckb.Cv();
    a.c localc = new a.c(this, (byte)0);
    this.ckb.getMagicBrush().cwL.add(localc);
    this.ckb.getMagicBrush().cwK.add(localc);
    this.ckb.getMagicBrush().cwM.addListener(new a.4(this));
    this.ckb.getMagicBrush().cwu = new a.5(this);
    AppMethodBeat.o(130573);
  }
  
  private void Db()
  {
    AppMethodBeat.i(130578);
    if (this.cjW)
    {
      AppMethodBeat.o(130578);
      return;
    }
    this.cjW = true;
    ad.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame to MainContext");
    Object localObject1 = CZ();
    com.tencent.mm.plugin.appbrand.utils.q.a(((com.tencent.luggage.sdk.b.a.c.c)El()).aYh(), (String)localObject1, new a.7(this));
    Object localObject2 = ((com.tencent.luggage.sdk.b.a.c.c)El()).aVF().Ld("WAGame.js");
    Object localObject3 = "v" + ((com.tencent.luggage.sdk.b.a.c.c)El()).aVF().aZp();
    com.tencent.mm.plugin.appbrand.aq.a((com.tencent.mm.plugin.appbrand.d)El(), ((com.tencent.luggage.sdk.b.a.c.c)El()).aYh());
    ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(778L, 13L, 1L, false);
    long l = System.currentTimeMillis();
    boolean bool = ((com.tencent.luggage.sdk.b.a.c.c)El()).aXu();
    if (localObject2 == null) {}
    String str;
    for (int i = 0;; i = ((String)localObject2).length())
    {
      localObject1 = new a.a(this, "WAGame.js", (String)localObject2, l, i, bool);
      if ((((com.tencent.luggage.sdk.b.a.c.c)El()).En() == null) || (!((com.tencent.luggage.sdk.b.a.c.c)El()).En().Fe())) {
        break label427;
      }
      str = ";(function(global) { var protectedConsole = global.console; Object.defineProperty(global, 'console', { get() { return protectedConsole; }, set() { } }); })(this);".concat(String.valueOf(localObject2));
      localObject2 = (com.tencent.mm.plugin.appbrand.q)El();
      localObject4 = ((com.tencent.luggage.sdk.b.a.c.c)El()).aYh();
      localObject3 = r.a.mOW;
      if (!bt.isNullOrNil(str)) {
        break;
      }
      ((q.a)localObject1).cT("isNullOrNil script");
      AppMethodBeat.o(130578);
      return;
    }
    Object localObject4 = (l)((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject4).P(l.class);
    if (localObject4 != null) {
      str = str + String.format(Locale.ENGLISH, ";(function(){return %d;})();", new Object[] { Integer.valueOf(11111) });
    }
    try
    {
      localObject2 = new URL(r.a((com.tencent.mm.plugin.appbrand.q)localObject2, (r.a)localObject3) + "WAGame.js");
      ((l)localObject4).a(str, ((URL)localObject2).toString(), new r.1((q.a)localObject1));
      AppMethodBeat.o(130578);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      AppMethodBeat.o(130578);
      return;
    }
    label427:
    r.a((com.tencent.mm.plugin.appbrand.q)El(), ((com.tencent.luggage.sdk.b.a.c.c)El()).aYh(), "WAGame.js", "WAGame.js", (String)localObject3, Da(), (String)localObject2, r.a.mOW, localMalformedURLException);
    AppMethodBeat.o(130578);
  }
  
  public final com.tencent.luggage.game.c.e CH()
  {
    AppMethodBeat.i(130558);
    if (this.ckf == null) {}
    try
    {
      if (this.ckf == null) {
        this.ckf = new com.tencent.luggage.game.c.e();
      }
      com.tencent.luggage.game.c.e locale = this.ckf;
      AppMethodBeat.o(130558);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(130558);
    }
  }
  
  public final String CI()
  {
    AppMethodBeat.i(130559);
    Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)El()).EN();
    String str = ((com.tencent.luggage.sdk.b.a.c.c)El()).En().getAppConfig().jVK;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(130559);
    return localObject;
  }
  
  protected void CJ()
  {
    AppMethodBeat.i(130562);
    new com.tencent.luggage.game.b.d().Cx();
    AppMethodBeat.o(130562);
  }
  
  public final boolean CK()
  {
    return true;
  }
  
  public com.tencent.mm.plugin.appbrand.jsruntime.i CL()
  {
    AppMethodBeat.i(130563);
    ad.i("Luggage.AppBrandGameServiceLogicImp", "createJsRuntime");
    long l = System.currentTimeMillis();
    Object localObject2 = CP();
    Object localObject1 = null;
    if (CQ()) {
      if (!com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) {
        break label173;
      }
    }
    label173:
    for (localObject1 = com.tencent.mm.plugin.appbrand.z.d.UU("wxa_library/v8_snapshot64.bin");; localObject1 = com.tencent.mm.plugin.appbrand.z.d.UU("wxa_library/v8_snapshot.bin"))
    {
      localObject1 = d((String)localObject2, (byte[])localObject1);
      localObject2 = (t)((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject1).P(t.class);
      localObject2 = a((com.tencent.luggage.sdk.b.a.c.c)El(), (t)localObject2);
      ((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject1).setJsExceptionHandler(new a.1(this));
      ((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject1).addJavascriptInterface(localObject2, "WeixinJSContext");
      com.tencent.mm.plugin.appbrand.utils.q.a((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject1, String.format(";(function(){let interface = %s;let alloc = interface.alloc;let allocNativeGlobal = interface.allocNativeGlobal;interface.alloc = function(injectNativeGlobal) {if(injectNativeGlobal){return allocNativeGlobal();}else{return alloc();}}})();", new Object[] { "WeixinJSContext" }), new d.1((d)localObject2));
      ((d)localObject2).Dk();
      ad.i("Luggage.AppBrandGameServiceLogicImp", "[damonlei] createJsRuntime cost [%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(130563);
      return localObject1;
    }
  }
  
  public void CM()
  {
    AppMethodBeat.i(130566);
    super.CM();
    this.ckc = new com.tencent.luggage.sdk.b.a.a.c();
    this.ckc.a(((com.tencent.luggage.sdk.b.a.c.c)El()).aYh(), El());
    this.ckd = new com.tencent.luggage.sdk.b.a.a.a();
    com.tencent.luggage.sdk.b.a.a.a locala = this.ckd;
    com.tencent.mm.plugin.appbrand.jsruntime.i locali = ((com.tencent.luggage.sdk.b.a.c.c)El()).aYh();
    Object localObject = El();
    ad.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding");
    if (locali == null) {
      ad.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsruntime is null");
    }
    for (;;)
    {
      this.cke = new com.tencent.luggage.sdk.b.a.a.d();
      this.cke.a(((com.tencent.luggage.sdk.b.a.c.c)El()).aYh(), El(), 1);
      AppMethodBeat.o(130566);
      return;
      locala.cny = "1004";
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
          locala.cnz = ((com.tencent.luggage.sdk.b.a.a.b)localObject).Ey();
          ad.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(locala.cnz) });
        }
        localq.post(new com.tencent.luggage.sdk.b.a.a.a.3(locala, locali, new com.tencent.luggage.sdk.b.a.a.a.1(locala, new WeakReference(localq)), new com.tencent.luggage.sdk.b.a.a.a.2(locala)));
      }
    }
  }
  
  public void CN()
  {
    AppMethodBeat.i(130567);
    super.CN();
    if (this.ckb != null) {
      this.ckb.destroy();
    }
    if (this.ckc != null) {
      this.ckc.a(((com.tencent.luggage.sdk.b.a.c.c)El()).aYh());
    }
    com.tencent.luggage.sdk.b.a.a.a locala;
    com.tencent.mm.plugin.appbrand.jsruntime.i locali;
    if (this.ckd != null)
    {
      locala = this.ckd;
      locali = ((com.tencent.luggage.sdk.b.a.c.c)El()).aYh();
      ad.i("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding");
      if (locali != null) {
        break label124;
      }
      ad.e("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding jsruntime is null");
    }
    for (;;)
    {
      if (this.cke != null) {
        this.cke.b(((com.tencent.luggage.sdk.b.a.c.c)El()).aYh());
      }
      AppMethodBeat.o(130567);
      return;
      label124:
      ((com.tencent.mm.plugin.appbrand.jsruntime.m)locali.P(com.tencent.mm.plugin.appbrand.jsruntime.m.class)).a(locala.cnA);
    }
  }
  
  public void CO()
  {
    AppMethodBeat.i(130568);
    super.CO();
    if (this.ckb != null)
    {
      if (this.ckb.cin != null) {
        this.ckb.getMagicBrush().cwu = null;
      }
      Object localObject = this.ckb;
      ad.i("MicroMsg.MagicBrush", "awaitDestroyDone");
      if ((!((com.tencent.luggage.game.a.d)localObject).cip.aN(5000L)) && (com.tencent.mm.sdk.platformtools.i.DEBUG))
      {
        localObject = (Throwable)new IllegalStateException("WAGame destroy timeout");
        AppMethodBeat.o(130568);
        throw ((Throwable)localObject);
      }
    }
    if (this.cjX != null) {
      this.cjX.destroy();
    }
    AppMethodBeat.o(130568);
  }
  
  protected String CP()
  {
    return null;
  }
  
  protected boolean CQ()
  {
    return true;
  }
  
  protected boolean CS()
  {
    AppMethodBeat.i(130571);
    if (((com.tencent.luggage.sdk.b.a.c.c)El()).En() != null)
    {
      com.tencent.mm.plugin.appbrand.config.a locala = ((com.tencent.luggage.sdk.b.a.c.c)El()).En().getAppConfig();
      if (locala.jVx != null)
      {
        boolean bool = locala.jVx.booleanValue();
        AppMethodBeat.o(130571);
        return bool;
      }
    }
    AppMethodBeat.o(130571);
    return true;
  }
  
  protected boolean CT()
  {
    return true;
  }
  
  protected int CU()
  {
    return 1;
  }
  
  protected boolean CV()
  {
    return false;
  }
  
  public final void CX()
  {
    AppMethodBeat.i(130574);
    ad.i("Luggage.AppBrandGameServiceLogicImp", "onRuntimeResume");
    super.CX();
    CR();
    if (this.cjX != null) {
      this.cjX.kbx.bringToFront();
    }
    AppMethodBeat.o(130574);
  }
  
  public final void CY()
  {
    AppMethodBeat.i(130575);
    super.CY();
    try
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)El()).aYh();
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
      ad.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(130575);
    }
  }
  
  protected String CZ()
  {
    AppMethodBeat.i(130577);
    String str = com.tencent.mm.plugin.appbrand.z.d.UT("wxa_library/android.js") + com.tencent.mm.plugin.appbrand.z.d.UT("wxa_library/shared_buffer.js") + com.tencent.mm.plugin.appbrand.z.d.UT("wxa_library/NativeGlobal-WAGame.js");
    AppMethodBeat.o(130577);
    return str;
  }
  
  protected int Da()
  {
    return 0;
  }
  
  public final void Dc()
  {
    AppMethodBeat.i(130579);
    super.Dc();
    Object localObject;
    if ((((com.tencent.luggage.sdk.b.a.c.c)El()).En() != null) && (((com.tencent.luggage.sdk.b.a.c.c)El()).En().Fe()))
    {
      com.tencent.mm.sdk.platformtools.aq.f(new a.8(this));
      localObject = (l)((com.tencent.luggage.sdk.b.a.c.c)El()).aYh().P(l.class);
      if (localObject != null) {
        ((l)localObject).RB("xdebug");
      }
      if (((com.tencent.luggage.sdk.b.a.c.c)El()).aXv()) {
        localObject = ((com.tencent.luggage.sdk.b.a.c.c)El()).aYh();
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
  
  public final void Dd()
  {
    AppMethodBeat.i(130580);
    ad.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.init");
    this.cjV = true;
    ad.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl mServiceReady = [%b], isRunning[%b]", new Object[] { Boolean.valueOf(this.cjV), Boolean.valueOf(((com.tencent.luggage.sdk.b.a.c.c)El()).isRunning()) });
    if ((!this.cjV) || (!((com.tencent.luggage.sdk.b.a.c.c)El()).isRunning()))
    {
      AppMethodBeat.o(130580);
      return;
    }
    try
    {
      ad.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl start");
      if (!this.cjW) {
        ((com.tencent.luggage.sdk.b.a.c.c)El()).aYh().evaluateJavascript(com.tencent.mm.plugin.appbrand.z.d.UT("wxa_library/android.js"), null);
      }
      ((com.tencent.luggage.sdk.b.a.c.c)El()).EO();
      Db();
      ((com.tencent.luggage.sdk.b.a.c.c)El()).M(new a.6(this));
      AppMethodBeat.o(130580);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      if (((com.tencent.luggage.sdk.b.a.c.c)El()).isRunning())
      {
        AppMethodBeat.o(130580);
        throw localNullPointerException;
      }
      AppMethodBeat.o(130580);
    }
  }
  
  public final void De()
  {
    AppMethodBeat.i(130582);
    ad.i("Luggage.AppBrandGameServiceLogicImp", "start preload");
    CW();
    Db();
    ((com.tencent.luggage.sdk.b.a.c.c)El()).bid();
    ad.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppService preloaded.");
    AppMethodBeat.o(130582);
  }
  
  protected com.tencent.luggage.game.a.b a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(190410);
    a.3 local3 = new a.3(this, ((com.tencent.luggage.sdk.b.a.c.c)El()).getContext(), ((com.tencent.luggage.sdk.b.a.c.c)El()).aYh(), paramBoolean1, paramBoolean2, paramInt, paramBoolean3);
    AppMethodBeat.o(190410);
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
    CW();
    if (this.ckb != null) {
      this.ckb.b(paramAppBrandRuntime);
    }
    if (this.cke != null) {
      this.cke.b(((com.tencent.luggage.sdk.b.a.c.c)El()).aYh(), El());
    }
    com.tencent.luggage.sdk.b.a.a.a locala;
    Object localObject;
    com.tencent.mm.plugin.appbrand.jsapi.c localc;
    if (this.ckd != null)
    {
      locala = this.ckd;
      localObject = ((com.tencent.luggage.sdk.b.a.c.c)El()).aYh();
      localc = El();
      ad.i("Luggage.LockStepNativeInstallHelper", "initConfigLockStep");
      if (localObject != null) {
        break label158;
      }
      ad.e("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsruntime is null");
    }
    for (;;)
    {
      CR();
      paramAppBrandRuntime.b(z.class, new com.tencent.luggage.game.f.a(com.tencent.mm.sdk.f.a.jq(paramAppBrandRuntime.mContext)));
      this.ckb.getMagicBrush().cwM.addSurfaceListenerForAllViews(new a.2(this));
      AppMethodBeat.o(130570);
      return;
      label158:
      localObject = (com.tencent.mm.plugin.appbrand.jsruntime.q)((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject).P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
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
    AppBrandSysConfigLU localAppBrandSysConfigLU = ((com.tencent.luggage.sdk.b.a.c.c)El()).En().Fa();
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
        if (i < localAppBrandSysConfigLU.cnf.jWN.length)
        {
          localJSONArray.put(localAppBrandSysConfigLU.cnf.jWN[i]);
          i += 1;
          continue;
        }
        ((com.tencent.luggage.sdk.b.a.c.c)El()).c((JSONObject)localObject, "subContextImgDomain", localJSONArray);
      }
      catch (Exception localException)
      {
        int i;
        boolean bool2;
        boolean bool1;
        continue;
      }
      ((com.tencent.luggage.sdk.b.a.c.c)El()).c(paramJSONObject, "wxAppInfo", localObject);
      ad.i("Luggage.AppBrandGameServiceLogicImp", "dm.widthPixels %d, dm.heightPixels %d", new Object[] { Integer.valueOf(this.ckb.getMagicBrush().cwJ.Hp()), Integer.valueOf(this.ckb.getMagicBrush().cwJ.Hq()) });
      localObject = ((com.tencent.luggage.sdk.b.a.c.c)El()).En();
      if ((((AppBrandRuntime)localObject).getWindowAndroid() instanceof com.tencent.mm.plugin.appbrand.r.a.a.o))
      {
        i = ((com.tencent.mm.plugin.appbrand.r.a.a.o)((AppBrandRuntime)localObject).getWindowAndroid()).bwU().getDefaultDisplay().getRotation();
        bool2 = org.apache.commons.b.a.contains(new int[] { 0, 1 }, i);
        if (e.b.Uf(((AppBrandRuntime)localObject).getAppConfig().jVw.jVL) == e.b.moG)
        {
          bool1 = true;
          if (bool2 != bool1)
          {
            i = 0;
            if (i == 0)
            {
              ad.e("Luggage.AppBrandGameServiceLogicImp", "hy: orientation judge failed! maybe because onConfigurationChange judgement and surface degree judgement not match");
              ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(808L, 4L, 1L, false);
              ((com.tencent.mm.plugin.appbrand.t.b)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.b.class)).f(18284, new Object[] { Integer.valueOf(1) });
            }
            ((com.tencent.luggage.sdk.b.a.c.c)El()).c(paramJSONObject, "screenWidth", Integer.valueOf(this.ckb.getMagicBrush().cwJ.Hp()));
            ((com.tencent.luggage.sdk.b.a.c.c)El()).c(paramJSONObject, "screenHeight", Integer.valueOf(this.ckb.getMagicBrush().cwJ.Hq()));
            ((com.tencent.luggage.sdk.b.a.c.c)El()).c(paramJSONObject, "devicePixelRatio", Float.valueOf(this.ckb.getMagicBrush().cwJ.getDevicePixelRatio()));
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
  
  public final void cR(String paramString)
  {
    AppMethodBeat.i(178033);
    ad.d("Luggage.AppBrandGameServiceLogicImp", "RemoteDebugInfo %s", new Object[] { paramString });
    dzk localdzk = new dzk();
    localdzk.HMI = ((com.tencent.luggage.sdk.b.a.c.c)El()).EM().aXC();
    localdzk.HMH = paramString;
    paramString = v.a(localdzk, this.ckg, "domEvent");
    this.cjX.a(paramString);
    AppMethodBeat.o(178033);
  }
  
  public final boolean cS(String paramString)
  {
    AppMethodBeat.i(190412);
    ad.i("Luggage.AppBrandGameServiceLogicImp", "hy: do nothing in game service when called from modularizing helper");
    AppMethodBeat.o(190412);
    return false;
  }
  
  protected com.tencent.mm.plugin.appbrand.jsruntime.i d(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130564);
    paramString = new IJSRuntime.Config(paramString, paramArrayOfByte);
    paramString.cXK = true;
    paramString.cXJ = "1";
    paramString.cXM = true;
    paramString.cXP = new WeakReference(El());
    paramString = new com.tencent.mm.plugin.appbrand.jsruntime.b(paramString);
    AppMethodBeat.o(130564);
    return paramString;
  }
  
  public final com.tencent.magicbrush.d getMagicBrush()
  {
    AppMethodBeat.i(221360);
    com.tencent.magicbrush.d locald = this.ckb.getMagicBrush();
    AppMethodBeat.o(221360);
    return locald;
  }
  
  protected void gt(int paramInt) {}
  
  public static final class b
    implements b.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */