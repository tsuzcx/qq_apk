package com.tencent.luggage.game.e.a.a;

import com.tencent.luggage.game.a.c.a;
import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.debugger.u;
import com.tencent.mm.plugin.appbrand.i.q;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.t.o;
import com.tencent.mm.plugin.appbrand.t.o.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class a<Service extends com.tencent.luggage.sdk.b.a.c.c>
  extends com.tencent.luggage.sdk.b.a.c.e<Service>
  implements b
{
  private volatile boolean bBd;
  private volatile boolean bBe;
  private boolean bBf;
  private com.tencent.mm.plugin.appbrand.debugger.n bBg;
  private boolean bBh;
  public com.tencent.luggage.game.a.b bBi;
  private com.tencent.luggage.sdk.b.a.a.c bBj;
  private com.tencent.luggage.sdk.b.a.a.a bBk;
  
  public a(Service paramService)
  {
    super(paramService);
    AppMethodBeat.i(140435);
    this.bBd = false;
    this.bBe = false;
    this.bBf = false;
    this.bBg = null;
    this.bBh = false;
    this.bBi = null;
    b(b.class, this);
    uP();
    AppMethodBeat.o(140435);
  }
  
  protected static void bQ(String paramString)
  {
    AppMethodBeat.i(140455);
    com.tencent.luggage.game.d.e.uJ().bQ(paramString);
    AppMethodBeat.o(140455);
  }
  
  private void uX()
  {
    AppMethodBeat.i(140442);
    try
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).aAO();
      if (localObject == null)
      {
        AppMethodBeat.o(140442);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.i.n)((com.tencent.mm.plugin.appbrand.i.i)localObject).v(com.tencent.mm.plugin.appbrand.i.n.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.i.n)localObject).setThreadPriority(-8);
      }
      AppMethodBeat.o(140442);
      return;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(140442);
    }
  }
  
  private void va()
  {
    boolean bool = true;
    AppMethodBeat.i(140446);
    if (this.bBi != null) {}
    for (;;)
    {
      ab.i("Luggage.AppBrandGameServiceLogicImp", "setup magicbrush. loaded?[%b]", new Object[] { Boolean.valueOf(bool) });
      if (this.bBi == null) {
        break;
      }
      AppMethodBeat.o(140446);
      return;
      bool = false;
    }
    this.bBh = uY();
    this.bBi = uZ();
    this.bBi.bzG = this.bBh;
    this.bBi.bzH = new a.b(this, (byte)0);
    ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).aBr();
    this.bBi.a(((com.tencent.luggage.sdk.b.a.c.c)this.bDN).aAO());
    AppMethodBeat.o(140446);
  }
  
  private void vd()
  {
    AppMethodBeat.i(140449);
    ab.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl mServiceReady = [%b], mRendererReady = [%b], isRunning[%b]", new Object[] { Boolean.valueOf(this.bBe), Boolean.valueOf(this.bBd), Boolean.valueOf(((com.tencent.luggage.sdk.b.a.c.c)this.bDN).isRunning()) });
    if ((!this.bBe) || (!this.bBd) || (!((com.tencent.luggage.sdk.b.a.c.c)this.bDN).isRunning()))
    {
      AppMethodBeat.o(140449);
      return;
    }
    ab.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl start");
    ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).wF();
    vh();
    ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).auf();
    AppMethodBeat.o(140449);
  }
  
  private void ve()
  {
    AppMethodBeat.i(140450);
    String str = com.tencent.mm.plugin.appbrand.s.d.Fj("wxa_library/android.js") + com.tencent.mm.plugin.appbrand.s.d.Fj("wxa_library/NativeGlobal-WAGame.js");
    if (this.bBh) {
      str = str + com.tencent.mm.plugin.appbrand.s.d.Fj("wxa_library/commandbuffer.js");
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.t.n.a(((com.tencent.luggage.sdk.b.a.c.c)this.bDN).aAO(), str, new a.2(this));
      AppMethodBeat.o(140450);
      return;
    }
  }
  
  private static void vg()
  {
    AppMethodBeat.i(140453);
    ((com.tencent.mm.plugin.appbrand.o.a)com.tencent.luggage.a.e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(778L, 13L, 1L, false);
    AppMethodBeat.o(140453);
  }
  
  private void vh()
  {
    AppMethodBeat.i(140454);
    if (this.bBf)
    {
      AppMethodBeat.o(140454);
      return;
    }
    this.bBf = true;
    ab.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame to MainContext");
    ve();
    String str1 = ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).asY().yl("WAGame.js");
    String str2 = "v" + ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).asY().ave().gXf;
    vg();
    long l = System.currentTimeMillis();
    boolean bool = ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).aud();
    if (str1 == null) {}
    a.3 local3;
    for (int i = 0;; i = str1.length())
    {
      local3 = new a.3(this, i, bool, l);
      if ((((com.tencent.luggage.sdk.b.a.c.c)this.bDN).wj() == null) || (!((com.tencent.luggage.sdk.b.a.c.c)this.bDN).wj().wV())) {
        break;
      }
      str1 = ";(function(global) { var protectedConsole = global.console; Object.defineProperty(global, 'console', { get() { return protectedConsole; }, set() { } }); })(this);".concat(String.valueOf(str1));
      o.a((r)this.bDN, ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).aAO(), "WAGame.js", str1, o.a.iXP, local3);
      AppMethodBeat.o(140454);
      return;
    }
    o.a((r)this.bDN, ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).aAO(), "WAGame.js", "WAGame.js", str2, str1, o.a.iXP, local3);
    AppMethodBeat.o(140454);
  }
  
  protected d a(Service paramService, q paramq)
  {
    AppMethodBeat.i(140438);
    paramService = new d(paramService, paramq);
    AppMethodBeat.o(140438);
    return paramService;
  }
  
  public void a(com.tencent.mm.plugin.appbrand.i parami)
  {
    AppMethodBeat.i(140443);
    va();
    if (this.bBi != null) {
      this.bBi.a(parami, true);
    }
    uX();
    AppMethodBeat.o(140443);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    AppMethodBeat.i(140451);
    ((com.tencent.mm.plugin.appbrand.o.a)com.tencent.luggage.a.e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(778L, 15L, 1L, false);
    AppMethodBeat.o(140451);
  }
  
  public final void bS(String paramString) {}
  
  public final void bT(String paramString)
  {
    AppMethodBeat.i(140458);
    ab.i("Luggage.AppBrandGameServiceLogicImp", "hy: do nothing in game service when called from modularizing helper");
    AppMethodBeat.o(140458);
  }
  
  public final void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(140434);
    AppBrandSysConfigLU localAppBrandSysConfigLU = ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).wj().wR();
    JSONObject localJSONObject = paramJSONObject.optJSONObject("wxAppInfo");
    if (localJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        int i = 0;
        if (i < localAppBrandSysConfigLU.bDI.hhU.length)
        {
          localJSONArray.put(localAppBrandSysConfigLU.bDI.hhU[i]);
          i += 1;
          continue;
        }
        ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).b(localJSONObject, "subContextImgDomain", localJSONArray);
      }
      catch (Exception localException)
      {
        continue;
      }
      ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).b(paramJSONObject, "wxAppInfo", localJSONObject);
      ab.i("Luggage.AppBrandGameServiceLogicImp", "dm.widthPixels %d, dm.heightPixels %d", new Object[] { Integer.valueOf(this.bBi.bzF.bzI.getSystemDisplayWidth()), Integer.valueOf(this.bBi.bzF.bzI.getSystemDisplayHeight()) });
      if (com.tencent.mm.plugin.appbrand.config.a.a.t(((com.tencent.luggage.sdk.b.a.c.c)this.bDN).wj()))
      {
        ab.i("Luggage.AppBrandGameServiceLogicImp", "screen in right orientation");
        ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).b(paramJSONObject, "screenWidth", Integer.valueOf(this.bBi.bzF.bzI.getSystemDisplayWidth()));
        ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).b(paramJSONObject, "screenHeight", Integer.valueOf(this.bBi.bzF.bzI.getSystemDisplayHeight()));
        ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).b(paramJSONObject, "devicePixelRatio", Float.valueOf(com.tencent.mm.cb.a.getDensity(((com.tencent.luggage.sdk.b.a.c.c)this.bDN).getContext())));
        AppMethodBeat.o(140434);
        return;
      }
      ab.w("Luggage.AppBrandGameServiceLogicImp", "screen in reverse orientation");
      ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).b(paramJSONObject, "screenWidth", Integer.valueOf(this.bBi.bzF.bzI.getSystemDisplayHeight()));
      ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).b(paramJSONObject, "screenHeight", Integer.valueOf(this.bBi.bzF.bzI.getSystemDisplayWidth()));
    }
  }
  
  public final MBRuntime getMBRuntime()
  {
    return this.bBi.bzF.bzI;
  }
  
  protected void onMainCanvasTypeDefined(int paramInt) {}
  
  public final void tW()
  {
    AppMethodBeat.i(140457);
    ab.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.init");
    this.bBe = true;
    vd();
    AppMethodBeat.o(140457);
  }
  
  public final String uO()
  {
    AppMethodBeat.i(140433);
    Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).wE();
    String str = ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).wj().getAppConfig().hgZ;
    localObject = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { ((JSONObject)localObject).toString(), str });
    AppMethodBeat.o(140433);
    return localObject;
  }
  
  protected void uP()
  {
    AppMethodBeat.i(140436);
    new com.tencent.luggage.game.c.d().uD();
    AppMethodBeat.o(140436);
  }
  
  public final boolean uQ()
  {
    return true;
  }
  
  public com.tencent.mm.plugin.appbrand.i.i uR()
  {
    AppMethodBeat.i(140437);
    ab.i("Luggage.AppBrandGameServiceLogicImp", "createJsRuntime");
    long l = System.currentTimeMillis();
    Object localObject2 = uV();
    if (uW()) {}
    for (Object localObject1 = com.tencent.mm.plugin.appbrand.s.d.Fk("wxa_library/v8_snapshot.bin");; localObject1 = null)
    {
      localObject1 = new com.tencent.mm.plugin.appbrand.i.b((String)localObject2, (byte[])localObject1);
      localObject2 = (q)((com.tencent.mm.plugin.appbrand.i.i)localObject1).v(q.class);
      localObject2 = a((com.tencent.luggage.sdk.b.a.c.c)this.bDN, (q)localObject2);
      ((com.tencent.mm.plugin.appbrand.i.i)localObject1).setJsExceptionHandler(new a.1(this));
      ((d)localObject2).bBr = this.bBh;
      ((com.tencent.mm.plugin.appbrand.i.i)localObject1).addJavascriptInterface(localObject2, "WeixinJSContext");
      com.tencent.mm.plugin.appbrand.t.n.a((com.tencent.mm.plugin.appbrand.i.i)localObject1, String.format(";(function(){let interface = %s;let alloc = interface.alloc;let allocNativeGlobal = interface.allocNativeGlobal;interface.alloc = function(injectNativeGlobal) {if(injectNativeGlobal){return allocNativeGlobal();}else{return alloc();}}})();", new Object[] { "WeixinJSContext" }), new d.1((d)localObject2));
      ((d)localObject2).vl();
      ab.i("Luggage.AppBrandGameServiceLogicImp", "[damonlei] createJsRuntime cost [%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(140437);
      return localObject1;
    }
  }
  
  public void uS()
  {
    AppMethodBeat.i(140439);
    super.uS();
    this.bBj = new com.tencent.luggage.sdk.b.a.a.c();
    this.bBj.d(((com.tencent.luggage.sdk.b.a.c.c)this.bDN).aAO());
    this.bBk = new com.tencent.luggage.sdk.b.a.a.a();
    this.bBk.b(((com.tencent.luggage.sdk.b.a.c.c)this.bDN).aAO());
    AppMethodBeat.o(140439);
  }
  
  public void uT()
  {
    AppMethodBeat.i(140440);
    super.uT();
    if (this.bBi != null) {
      this.bBi.cleanup();
    }
    if (this.bBj != null) {
      this.bBj.e(((com.tencent.luggage.sdk.b.a.c.c)this.bDN).aAO());
    }
    if (this.bBk != null) {
      this.bBk.c(((com.tencent.luggage.sdk.b.a.c.c)this.bDN).aAO());
    }
    AppMethodBeat.o(140440);
  }
  
  public final void uU()
  {
    AppMethodBeat.i(140441);
    super.uU();
    if (this.bBi != null)
    {
      com.tencent.luggage.game.a.c localc = this.bBi.bzF;
      com.tencent.luggage.g.d.i("MicroMsg.MBRuntimeSimple", "awaitDestroyDone");
      localc.bzP.await();
    }
    if (this.bBg != null) {
      this.bBg.destroy();
    }
    AppMethodBeat.o(140441);
  }
  
  protected String uV()
  {
    return null;
  }
  
  protected boolean uW()
  {
    return true;
  }
  
  protected boolean uY()
  {
    AppMethodBeat.i(140444);
    if (((com.tencent.luggage.sdk.b.a.c.c)this.bDN).wj() != null)
    {
      com.tencent.mm.plugin.appbrand.config.a locala = ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).wj().getAppConfig();
      if (locala.hgT)
      {
        boolean bool = locala.hgS;
        AppMethodBeat.o(140444);
        return bool;
      }
    }
    AppMethodBeat.o(140444);
    return false;
  }
  
  protected com.tencent.luggage.game.a.b uZ()
  {
    AppMethodBeat.i(140445);
    com.tencent.luggage.game.a.b localb = new com.tencent.luggage.game.a.b(((com.tencent.luggage.sdk.b.a.c.c)this.bDN).getContext());
    AppMethodBeat.o(140445);
    return localb;
  }
  
  public final void vb()
  {
    AppMethodBeat.i(140447);
    ab.i("Luggage.AppBrandGameServiceLogicImp", "onRuntimeResume");
    super.vb();
    uX();
    if (this.bBg != null) {
      this.bBg.hlR.bringToFront();
    }
    AppMethodBeat.o(140447);
  }
  
  public final void vc()
  {
    AppMethodBeat.i(140448);
    super.vc();
    try
    {
      Object localObject = ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).aAO();
      if (localObject == null)
      {
        AppMethodBeat.o(140448);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.i.n)((com.tencent.mm.plugin.appbrand.i.i)localObject).v(com.tencent.mm.plugin.appbrand.i.n.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.i.n)localObject).setThreadPriority(10);
      }
      AppMethodBeat.o(140448);
      return;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(140448);
    }
  }
  
  protected void vf()
  {
    AppMethodBeat.i(140452);
    ((com.tencent.mm.plugin.appbrand.o.a)com.tencent.luggage.a.e.r(com.tencent.mm.plugin.appbrand.o.a.class)).idkeyStat(778L, 14L, 1L, false);
    AppMethodBeat.o(140452);
  }
  
  public final void vi()
  {
    AppMethodBeat.i(140456);
    super.vi();
    Object localObject;
    if ((((com.tencent.luggage.sdk.b.a.c.c)this.bDN).wj() != null) && (((com.tencent.luggage.sdk.b.a.c.c)this.bDN).wj().wV()))
    {
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(140426);
          a.a(a.this, new com.tencent.mm.plugin.appbrand.debugger.n());
          com.tencent.mm.plugin.appbrand.debugger.l locall = new com.tencent.mm.plugin.appbrand.debugger.l();
          locall.a((com.tencent.luggage.sdk.b.a.c.c)a.b(a.this), ((com.tencent.luggage.sdk.b.a.c.c)a.c(a.this)).wj().wS().extInfo);
          a.d(a.this).a(locall);
          AppMethodBeat.o(140426);
        }
      });
      localObject = (com.tencent.mm.plugin.appbrand.i.l)((com.tencent.luggage.sdk.b.a.c.c)this.bDN).aAO().v(com.tencent.mm.plugin.appbrand.i.l.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.i.l)localObject).Di("xdebug");
      }
      if (((com.tencent.luggage.sdk.b.a.c.c)this.bDN).gRF) {
        localObject = ((com.tencent.luggage.sdk.b.a.c.c)this.bDN).aAO();
      }
    }
    try
    {
      URL localURL = new URL("https://usr/" + "break.js");
      ((com.tencent.mm.plugin.appbrand.i.i)localObject).a(localURL, "breakprogram();", null);
      AppMethodBeat.o(140456);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      AppMethodBeat.o(140456);
    }
  }
  
  public final void vj()
  {
    AppMethodBeat.i(140459);
    ab.i("Luggage.AppBrandGameServiceLogicImp", "start preload");
    va();
    vh();
    ab.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppService preloaded.");
    AppMethodBeat.o(140459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.e.a.a.a
 * JD-Core Version:    0.7.0.1
 */