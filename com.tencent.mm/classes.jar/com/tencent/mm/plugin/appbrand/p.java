package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.luggage.j.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.model.e;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.v.k;
import com.tencent.mm.plugin.appbrand.v.l.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public class p
  extends o
  implements com.tencent.mm.plugin.appbrand.jsapi.f
{
  private volatile boolean fAa = false;
  private final LinkedList<Runnable> fAb = new LinkedList();
  private n fzW;
  public boolean fzX = false;
  private volatile boolean fzY = false;
  private volatile boolean fzZ = false;
  
  private void aaA()
  {
    String str;
    int i;
    if (!this.fAa)
    {
      ahK().setJsExceptionHandler(new p.3(this));
      str = com.tencent.mm.plugin.appbrand.u.d.wB("wxa_library/android.js");
      k.a(ahK(), str, new p.4(this));
      str = WxaCommLibRuntimeReader.qX("WAService.js");
      long l = System.currentTimeMillis();
      boolean bool = aan();
      if (str == null)
      {
        i = 0;
        com.tencent.mm.plugin.appbrand.v.l.a(this, ahK(), "WAService.js", "", "", str, l.a.hlv, new p.5(this, bool, l, i));
        h.nFQ.a(370L, 5L, 1L, false);
        this.fAa = true;
      }
    }
    else
    {
      if (this.fzW == null) {
        break label181;
      }
      if (!AppBrandPerformanceManager.vS(this.mAppId)) {
        break label187;
      }
      str = WxaCommLibRuntimeReader.qX("WAPerf.js");
    }
    for (;;)
    {
      if (!bk.bl(str)) {
        k.a(ahK(), str, new p.6(this));
      }
      return;
      i = str.length();
      break;
      label181:
      str = null;
      continue;
      label187:
      str = null;
    }
  }
  
  private void aaB()
  {
    if (this.fzY) {}
    String str;
    do
    {
      do
      {
        return;
      } while (this.fzZ);
      com.tencent.mm.plugin.appbrand.v.p.a((n)super.getRuntime(), ahK());
      str = aq.a((n)super.getRuntime(), "app-service.js");
    } while (bk.bl(str));
    h.nFQ.a(370L, 9L, 1L, false);
    long l = System.currentTimeMillis();
    com.tencent.mm.plugin.appbrand.v.l.a((n)super.getRuntime(), ahK(), "app-service.js", str, l.a.hlw, new p.7(this, str, l));
    this.fzZ = true;
  }
  
  public boolean aaC()
  {
    return this.fzY;
  }
  
  public void aao()
  {
    this.fzX = true;
    aaA();
  }
  
  protected final void aap()
  {
    new p.1(this).u((n)super.getRuntime());
  }
  
  protected final s aar()
  {
    return new t(this);
  }
  
  public com.tencent.mm.plugin.appbrand.i.f aat()
  {
    long l = System.currentTimeMillis();
    Object localObject2 = getContext();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ae.getContext();
    }
    localObject1 = com.tencent.mm.plugin.appbrand.i.n.m((Context)localObject1, x.aaF());
    localObject2 = (com.tencent.mm.plugin.appbrand.i.l)((com.tencent.mm.plugin.appbrand.i.f)localObject1).I(com.tencent.mm.plugin.appbrand.i.l.class);
    if ((localObject2 != null) && (x.aaF()))
    {
      localObject2 = new f(this, (com.tencent.mm.plugin.appbrand.i.l)localObject2);
      ((com.tencent.mm.plugin.appbrand.i.f)localObject1).addJavascriptInterface(localObject2, "WeixinJSContext");
      ((f)localObject2).Zn();
      this.fzY = true;
    }
    com.tencent.mm.plugin.appbrand.report.quality.a.aov();
    b.a(aan(), this.mAppId, l, com.tencent.mm.plugin.appbrand.report.a.a((com.tencent.mm.plugin.appbrand.i.f)localObject1));
    return localObject1;
  }
  
  public Map<String, com.tencent.mm.plugin.appbrand.jsapi.i> aau()
  {
    return m.ahO();
  }
  
  public void aav()
  {
    super.aav();
    com.tencent.mm.plugin.appbrand.v.p.a(this.fzW, ahK());
    if (this.fzX) {
      super.aX("onWxConfigReady", "");
    }
  }
  
  public final JSONObject aaw()
  {
    return super.aaw();
  }
  
  public final String aay()
  {
    return "https://lib/";
  }
  
  public final String aaz()
  {
    return "https://usr/";
  }
  
  public void cE(boolean paramBoolean)
  {
    new p.2(this, paramBoolean).a((n)super.getRuntime(), paramBoolean);
  }
  
  public void cleanup()
  {
    super.cleanup();
    this.fzW = null;
  }
  
  public void g(i parami)
  {
    this.fzW = ((n)parami);
    super.g(parami);
    aq.a((n)super.getRuntime(), WxaCommLibRuntimeReader.abP());
    this.geK = new c(this.fzW, this);
  }
  
  public final n getRuntime()
  {
    return (n)super.getRuntime();
  }
  
  public void h(JSONObject paramJSONObject)
  {
    super.h(paramJSONObject);
    JSONObject localJSONObject2 = new JSONObject();
    a(localJSONObject2, "scene", Integer.valueOf(this.fzW.aag()));
    Object localObject = this.fzW.ZF();
    a(localJSONObject2, "path", g.bi((String)localObject));
    a(localJSONObject2, "query", new JSONObject(g.bj((String)localObject)));
    a(localJSONObject2, "referrerInfo", this.fzW.aac().fPr.aei());
    a(localJSONObject2, "shareInfo", this.fzW.aac().aef());
    e.a(this.fzW, localJSONObject2);
    AppBrandSysConfigWC localAppBrandSysConfigWC = this.fzW.aaa();
    JSONObject localJSONObject3 = new JSONObject();
    a(localJSONObject3, "maxRequestConcurrent", Integer.valueOf(localAppBrandSysConfigWC.fPZ));
    a(localJSONObject3, "maxUploadConcurrent", Integer.valueOf(localAppBrandSysConfigWC.fQa));
    a(localJSONObject3, "maxDownloadConcurrent", Integer.valueOf(localAppBrandSysConfigWC.fQb));
    a(localJSONObject3, "maxWebsocketConnect", Integer.valueOf(localAppBrandSysConfigWC.fQc));
    a(localJSONObject3, "maxWorkerConcurrent", Integer.valueOf(localAppBrandSysConfigWC.fQd));
    try
    {
      localJSONObject1 = paramJSONObject.optJSONObject("env");
      localObject = localJSONObject1;
      if (localJSONObject1 == null)
      {
        localObject = new JSONObject();
        paramJSONObject.put("env", localObject);
      }
      ((JSONObject)localObject).put("USER_DATA_PATH", "wxfile://usr");
    }
    catch (Exception localException1)
    {
      JSONObject localJSONObject1;
      label259:
      break label259;
    }
    a(paramJSONObject, "appLaunchInfo", localJSONObject2);
    a(paramJSONObject, "wxAppInfo", localJSONObject3);
    a(paramJSONObject, "isPluginMiniProgram", Boolean.valueOf(((n)super.getRuntime()).ZG()));
    a(paramJSONObject, "envVersion", com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.a.lx(this.fzW.aac().fEL).name().toLowerCase());
    localObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject1 = new JSONObject(this.fzW.aac().fPA);
        localObject = localJSONObject1;
      }
      catch (Exception localException3)
      {
        continue;
      }
      try
      {
        if (!bk.bl(localAppBrandSysConfigWC.fPX))
        {
          localJSONObject1 = new JSONObject();
          localJSONObject1.put("jsonInfo", new JSONObject(localAppBrandSysConfigWC.fPX));
          a((JSONObject)localObject, "operationInfo", localJSONObject1);
        }
        a(paramJSONObject, "appContactInfo", localObject);
        a(paramJSONObject, "accountInfo", this.fzW.aac().aeg());
        return;
      }
      catch (Exception localException2)
      {
        y.e("MicroMsg.AppBrandService", "postProcessConfig, put operationInfo to appContactInfo fail", new Object[] { localException2 });
      }
    }
  }
  
  public void i(JSONObject paramJSONObject)
  {
    super.i(paramJSONObject);
    a(paramJSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.spa));
    if (getClass() == p.class) {
      a(paramJSONObject, "isIsolateContext", Boolean.valueOf(this.fzY));
    }
    com.tencent.mm.plugin.appbrand.e.d.o(paramJSONObject);
  }
  
  public void pT()
  {
    aav();
    aaA();
    aaB();
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.fAb)
    {
      localLinkedList.addAll(this.fAb);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((Runnable)((Iterator)???).next()).run();
      }
    }
    aas();
  }
  
  public void qJ(String arg1)
  {
    p.8 local8 = new p.8(this, ???);
    if (isRunning())
    {
      local8.run();
      return;
    }
    synchronized (this.fAb)
    {
      this.fAb.add(local8);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p
 * JD-Core Version:    0.7.0.1
 */