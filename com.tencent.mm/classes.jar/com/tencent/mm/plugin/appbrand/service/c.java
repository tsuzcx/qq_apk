package com.tencent.mm.plugin.appbrand.service;

import com.tencent.luggage.g.h;
import com.tencent.luggage.sdk.b.a.c.e;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.i.t;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.t.n;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import org.json.JSONObject;

public class c
  extends com.tencent.luggage.sdk.b.a.c.c
  implements com.tencent.mm.plugin.appbrand.k.f
{
  protected o gQn;
  
  public c()
  {
    this(new com.tencent.luggage.sdk.b.a.c.b.a());
    AppMethodBeat.i(143552);
    AppMethodBeat.o(143552);
  }
  
  public c(com.tencent.luggage.sdk.b.a.b.a parama)
  {
    super(parama);
    AppMethodBeat.i(143553);
    if ((bp.dud()) || (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      this.gPS = bool;
      AppMethodBeat.o(143553);
      return;
    }
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Object localObject = null;
    AppMethodBeat.i(143562);
    com.tencent.mm.plugin.appbrand.report.g localg = com.tencent.mm.plugin.appbrand.report.g.iFU;
    com.tencent.mm.plugin.appbrand.report.g.a(this, paramString1, paramString2, paramBoolean, paramLong1);
    if ("WAService.js".equals(paramString1))
    {
      paramString1 = localObject;
      if (isRunning())
      {
        paramString1 = localObject;
        if (AppBrandPerformanceManager.d(getRuntime())) {
          paramString1 = WxaCommLibRuntimeReader.yt("WAPerf.js");
        }
      }
      if (!bo.isNullOrNil(paramString1)) {
        n.a(aAO(), paramString1, new c.4(this));
      }
    }
    AppMethodBeat.o(143562);
  }
  
  public MBRuntime aAr()
  {
    Object localObject = this.bEO;
    if ((localObject instanceof b))
    {
      localObject = (b)localObject;
      if (((b)localObject).iJo == null) {
        return null;
      }
      return ((b)localObject).iJo.bzI;
    }
    return null;
  }
  
  public final z aLy()
  {
    AppMethodBeat.i(143554);
    z localz = (z)super.W(z.class);
    AppMethodBeat.o(143554);
    return localz;
  }
  
  public final void b(i parami)
  {
    AppMethodBeat.i(143556);
    this.gQn = ((o)parami);
    aBr();
    super.b(parami);
    AppMethodBeat.o(143556);
  }
  
  public final void be(boolean paramBoolean)
  {
    AppMethodBeat.i(143559);
    ab.i("MicroMsg.AppBrandService", "dl:onRuntimeResume, dispatch AppBrandOnAppEnterForegroundEvent");
    if (getRuntime() == null)
    {
      ab.w("MicroMsg.AppBrandService", "onRuntimeResume, getRuntime == NULL");
      AppMethodBeat.o(143559);
      return;
    }
    new c.3(this, paramBoolean).b(getRuntime(), paramBoolean);
    this.bEO.vb();
    AppMethodBeat.o(143559);
  }
  
  public final void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143560);
    super.e(paramJSONObject);
    b(paramJSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.whH));
    b(paramJSONObject, "JSEngineName", t.f(aAO()));
    com.tencent.mm.plugin.appbrand.f.a.a(com.tencent.mm.plugin.appbrand.w.b.aSv(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.f.a.d(com.tencent.mm.plugin.appbrand.w.b.aSy(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.f.a.b(com.tencent.mm.plugin.appbrand.w.b.aSx(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.f.a.c(com.tencent.mm.plugin.appbrand.w.b.aSw(), paramJSONObject);
    com.tencent.mm.plugin.appbrand.f.a.e(com.tencent.mm.plugin.appbrand.w.b.aSA(), paramJSONObject);
    AppMethodBeat.o(143560);
  }
  
  public final void f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143561);
    b(paramJSONObject, "debug", Boolean.valueOf(this.gQn.atR().bDj));
    JSONObject localJSONObject1 = new JSONObject();
    b(localJSONObject1, "scene", Integer.valueOf(this.gQn.wS().bDh.scene));
    Object localObject = this.gQn.ato();
    b(localJSONObject1, "path", h.cg((String)localObject));
    b(localJSONObject1, "query", new JSONObject(h.ch((String)localObject)));
    b(localJSONObject1, "referrerInfo", this.gQn.atS().hiz.ayx());
    b(localJSONObject1, "shareInfo", this.gQn.atS().wa());
    com.tencent.mm.plugin.appbrand.report.model.d.a(this.gQn, localJSONObject1);
    AppBrandSysConfigWC localAppBrandSysConfigWC = this.gQn.atR();
    JSONObject localJSONObject2 = new JSONObject();
    b(localJSONObject2, "maxRequestConcurrent", Integer.valueOf(localAppBrandSysConfigWC.bDq));
    b(localJSONObject2, "maxUploadConcurrent", Integer.valueOf(localAppBrandSysConfigWC.bDr));
    b(localJSONObject2, "maxDownloadConcurrent", Integer.valueOf(localAppBrandSysConfigWC.bDs));
    b(localJSONObject2, "maxWebsocketConnect", Integer.valueOf(localAppBrandSysConfigWC.bDt));
    b(localJSONObject2, "maxWorkerConcurrent", Integer.valueOf(localAppBrandSysConfigWC.bDu));
    try
    {
      localObject = paramJSONObject.optJSONObject("env");
      if (localObject != null) {
        break label568;
      }
      localObject = new JSONObject();
      paramJSONObject.put("env", localObject);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        int i;
      }
    }
    ((JSONObject)localObject).put("USER_DATA_PATH", "wxfile://usr");
    ((JSONObject)localObject).put("OPEN_DATA_PATH", "wxfile://opendata");
    ((JSONObject)localObject).put("CLIENT_DATA_PATH", "wxfile://clientdata");
    if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lWc, false) == true) {
      i = 1;
    }
    for (;;)
    {
      ((JSONObject)localObject).put("HAS_SPLASHSCREEN", i);
      b(paramJSONObject, "appLaunchInfo", localJSONObject1);
      b(paramJSONObject, "wxAppInfo", localJSONObject2);
      b(paramJSONObject, "isPluginMiniProgram", Boolean.valueOf(getRuntime().atM()));
      b(paramJSONObject, "envVersion", com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b.oh(this.gQn.atS().gXd).name().toLowerCase());
      localObject = new JSONObject();
      for (;;)
      {
        try
        {
          localJSONObject1 = new JSONObject(this.gQn.atS().bDb);
          localObject = localJSONObject1;
        }
        catch (Exception localException3)
        {
          continue;
        }
        try
        {
          if (!bo.isNullOrNil(localAppBrandSysConfigWC.bDo))
          {
            localJSONObject1 = new JSONObject();
            localJSONObject1.put("jsonInfo", new JSONObject(localAppBrandSysConfigWC.bDo));
            b((JSONObject)localObject, "operationInfo", localJSONObject1);
          }
          b(paramJSONObject, "appContactInfo", localObject);
          b(paramJSONObject, "accountInfo", this.gQn.atS().wb());
          super.f(paramJSONObject);
          AppMethodBeat.o(143561);
          return;
          i = 0;
        }
        catch (Exception localException2)
        {
          ab.e("MicroMsg.AppBrandService", "postProcessConfig, put operationInfo to appContactInfo fail", new Object[] { localException2 });
        }
      }
    }
  }
  
  public o getRuntime()
  {
    AppMethodBeat.i(143563);
    o localo = (o)super.wj();
    AppMethodBeat.o(143563);
    return localo;
  }
  
  public final void vc()
  {
    AppMethodBeat.i(143558);
    ab.i("MicroMsg.AppBrandService", "dl: onRuntimePause, dispatch AppBrandOnAppEnterBackgroundEvent ");
    new c.2(this).F(getRuntime());
    this.bEO.vc();
    AppMethodBeat.o(143558);
  }
  
  public final com.tencent.mm.plugin.appbrand.v.a wI()
  {
    AppMethodBeat.i(143555);
    c.1 local1 = new c.1(this, this);
    AppMethodBeat.o(143555);
    return local1;
  }
  
  public final c.b wJ()
  {
    AppMethodBeat.i(143557);
    com.tencent.mm.plugin.appbrand.permission.a locala = new com.tencent.mm.plugin.appbrand.permission.a(getRuntime(), this);
    AppMethodBeat.o(143557);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.c
 * JD-Core Version:    0.7.0.1
 */