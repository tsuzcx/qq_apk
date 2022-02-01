package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.plugin.appbrand.ad.f;
import com.tencent.mm.plugin.appbrand.ad.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsruntime.n;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.a.a.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class q
  extends d
{
  private volatile w jAa;
  private final Object jAb;
  private volatile LinkedList<com.tencent.mm.plugin.appbrand.jsapi.aa> jAc;
  q.a jAd;
  f jAe;
  private volatile boolean jzV;
  public volatile boolean jzW;
  public com.tencent.mm.plugin.appbrand.r.a.c jzX;
  public volatile AppBrandRuntime jzY;
  private final Object jzZ;
  private volatile boolean mDestroyed;
  private volatile boolean mInitialized;
  
  public q()
  {
    AppMethodBeat.i(134576);
    this.mDestroyed = false;
    this.mInitialized = false;
    this.jzV = false;
    this.jzW = false;
    this.jzX = new o();
    this.jzZ = new byte[0];
    this.jAb = new byte[0];
    synchronized (this.jAb)
    {
      this.jAc = new LinkedList();
      AppMethodBeat.o(134576);
      return;
    }
  }
  
  private void aXx()
  {
    AppMethodBeat.i(134582);
    synchronized (this.jzZ)
    {
      if (this.jAa == null) {
        this.jAa = ET();
      }
      AppMethodBeat.o(134582);
      return;
    }
  }
  
  protected void CY()
  {
    AppMethodBeat.i(134580);
    if (!isRunning())
    {
      ad.w("MicroMsg.AppBrandService", "onRuntimePause but not running appId %s", new Object[] { getAppId() });
      AppMethodBeat.o(134580);
      return;
    }
    new l().ae(this.jzY);
    AppMethodBeat.o(134580);
  }
  
  protected void Dd()
  {
    AppMethodBeat.i(134585);
    EO();
    aXy();
    AppMethodBeat.o(134585);
  }
  
  protected void De() {}
  
  public com.tencent.mm.plugin.appbrand.jsruntime.i EK()
  {
    AppMethodBeat.i(134594);
    com.tencent.mm.plugin.appbrand.jsruntime.c localc = new com.tencent.mm.plugin.appbrand.jsruntime.c((byte)0);
    AppMethodBeat.o(134594);
    return localc;
  }
  
  public Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> EL()
  {
    return null;
  }
  
  public JSONObject EN()
  {
    AppMethodBeat.i(134597);
    JSONObject localJSONObject = new JSONObject();
    d(localJSONObject);
    Object localObject1 = this.jzY.Fh();
    Object localObject2 = this.jzY.getAppConfig();
    if ((localObject1 == null) || (localObject2 == null))
    {
      localObject1 = new JSONObject();
      AppMethodBeat.o(134597);
      return localObject1;
    }
    if ((a.isDarkMode()) && (((a)localObject2).jVF != null) && (((a)localObject2).jVF.length() != 0)) {}
    for (localObject1 = ((a)localObject2).jVF;; localObject1 = ((a)localObject2).jVE)
    {
      localObject2 = ((JSONObject)localObject1).keys();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        Object localObject3 = ((JSONObject)localObject1).opt(str);
        try
        {
          localJSONObject.putOpt(str, localObject3);
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.AppBrandService", localException.getMessage());
        }
      }
    }
    c(localJSONObject, "env", new JSONObject());
    ad.i("MicroMsg.AppBrandService", "generateWxConfig :%s", new Object[] { localJSONObject.toString() });
    AppMethodBeat.o(134597);
    return localJSONObject;
  }
  
  protected void EO()
  {
    AppMethodBeat.i(134596);
    Object localObject = EN();
    String str = this.jzY.getAppConfig().jVK;
    ad.i("MicroMsg.AppBrandService", "injectConfig start, hash=%d", new Object[] { Integer.valueOf(super.aXC()) });
    if (aYh().P(n.class) != null)
    {
      str = ((JSONObject)localObject).toString();
      ((n)aYh().P(n.class)).a("__native_custom_event__wxConfig_inject", str, 0, "", new q.1(this, str));
      AppMethodBeat.o(134596);
      return;
    }
    long l = bt.flT();
    localObject = ((JSONObject)localObject).toString();
    str = String.format(Locale.ENGLISH, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);var __wxIndexPage = \"%s\";", new Object[] { localObject, str });
    if (aYh().P(com.tencent.mm.plugin.appbrand.jsruntime.v.class) != null)
    {
      ((com.tencent.mm.plugin.appbrand.jsruntime.v)aYh().P(com.tencent.mm.plugin.appbrand.jsruntime.v.class)).a(null, null, null, 0, str, new q.2(this, (String)localObject));
      AppMethodBeat.o(134596);
      return;
    }
    aYh().evaluateJavascript(str, new q.3(this, l, (String)localObject));
    AppMethodBeat.o(134596);
  }
  
  public String EP()
  {
    return "";
  }
  
  public String EQ()
  {
    return "";
  }
  
  protected w ET()
  {
    AppMethodBeat.i(134583);
    w localw = new w(this);
    AppMethodBeat.o(134583);
    return localw;
  }
  
  public final void OE()
  {
    AppMethodBeat.i(134577);
    bic();
    aXx();
    com.tencent.mm.plugin.appbrand.jsapi.i.a(this, aXD());
    this.jzV = true;
    De();
    if (aYh().P(com.tencent.mm.plugin.appbrand.jsruntime.r.class) != null) {
      aYh().P(com.tencent.mm.plugin.appbrand.jsruntime.r.class);
    }
    AppMethodBeat.o(134577);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.r.a.c paramc)
  {
    this.jzX = paramc;
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final String aXA()
  {
    return "AppBrandService";
  }
  
  public final w aXB()
  {
    synchronized (this.jzZ)
    {
      w localw = this.jAa;
      return localw;
    }
  }
  
  public final int aXC()
  {
    AppMethodBeat.i(221147);
    int i = super.aXC();
    AppMethodBeat.o(221147);
    return i;
  }
  
  public final JSONObject aXD()
  {
    AppMethodBeat.i(134598);
    JSONObject localJSONObject = super.aXD();
    AppMethodBeat.o(134598);
    return localJSONObject;
  }
  
  public final void aXE()
  {
    AppMethodBeat.i(197262);
    if (this.jAe != null)
    {
      f localf = this.jAe;
      ad.i("MicroMsg.AppBrandServiceAdComponentView[AppBrandSplashAd]", "destroy view containers");
      if (localf.jCm != null)
      {
        am localam = localf.jCm;
        ad.i("MicroMsg.AppBrandWebViewCustomViewContainer", "clear: ");
        localam.mdH.clear();
        localf.jCm = null;
      }
      if (localf.jCn != null)
      {
        localf.jCn.removeAllViews();
        localf.jCn = null;
      }
      this.jAe = null;
    }
    AppMethodBeat.o(197262);
  }
  
  public final boolean aXt()
  {
    return this.jzW;
  }
  
  public final boolean aXu()
  {
    AppMethodBeat.i(134578);
    if ((getRuntime() == null) && (!this.mDestroyed))
    {
      AppMethodBeat.o(134578);
      return true;
    }
    AppMethodBeat.o(134578);
    return false;
  }
  
  public final boolean aXv()
  {
    return this.jzV;
  }
  
  protected com.tencent.mm.plugin.appbrand.page.m aXw()
  {
    AppMethodBeat.i(176539);
    com.tencent.mm.plugin.appbrand.page.m localm = new com.tencent.mm.plugin.appbrand.page.m();
    AppMethodBeat.o(176539);
    return localm;
  }
  
  protected final void aXy()
  {
    Object localObject1 = null;
    AppMethodBeat.i(134586);
    synchronized (this.jAb)
    {
      if (this.jAc != null) {
        localObject1 = new LinkedList(this.jAc);
      }
      this.jAc = null;
      if (localObject1 != null)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          ??? = (com.tencent.mm.plugin.appbrand.jsapi.aa)((Iterator)localObject1).next();
          super.c(((com.tencent.mm.plugin.appbrand.jsapi.aa)???).dln, ((com.tencent.mm.plugin.appbrand.jsapi.aa)???).data, ((com.tencent.mm.plugin.appbrand.jsapi.aa)???).src);
        }
      }
    }
    AppMethodBeat.o(134586);
  }
  
  public final Activity aXz()
  {
    AppMethodBeat.i(221146);
    Activity localActivity = au(Activity.class);
    AppMethodBeat.o(221146);
    return localActivity;
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.page.aa> T at(Class<T> paramClass)
  {
    AppMethodBeat.i(134592);
    if (this.jzY == null)
    {
      AppMethodBeat.o(134592);
      return null;
    }
    if (this.jzY.aVN() == null)
    {
      AppMethodBeat.o(134592);
      return null;
    }
    if (this.jzY.aVN() == null)
    {
      ad.w("MicroMsg.AppBrandService", "getCurrentPageView NULL PageContainer, appId=%s", new Object[] { getAppId() });
      if (!this.jzY.aWc())
      {
        paramClass = new IllegalStateException("getCurrentPageView NULL PageContainer");
        AppMethodBeat.o(134592);
        throw paramClass;
      }
      AppMethodBeat.o(134592);
      return null;
    }
    Object localObject = this.jzY.aVN().getCurrentPage();
    if (localObject == null)
    {
      ad.w("MicroMsg.AppBrandService", "getCurrentPageView NULL Page, appId=%s", new Object[] { getAppId() });
      AppMethodBeat.o(134592);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.page.r)localObject).getCurrentPageView();
    if (paramClass.isInstance(localObject))
    {
      AppMethodBeat.o(134592);
      return localObject;
    }
    AppMethodBeat.o(134592);
    return null;
  }
  
  public final <T extends Activity> T au(Class<T> paramClass)
  {
    AppMethodBeat.i(134593);
    if (getCurrentPageView() == null) {}
    for (Context localContext = getContext(); paramClass.isInstance(localContext); localContext = getCurrentPageView().getContext())
    {
      paramClass = (Activity)localContext;
      AppMethodBeat.o(134593);
      return paramClass;
    }
    AppMethodBeat.o(134593);
    return null;
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134589);
    if (!isRunning())
    {
      AppMethodBeat.o(134589);
      return;
    }
    this.jzY.aVN().c(paramString1, paramString2, paramArrayOfInt);
    AppMethodBeat.o(134589);
  }
  
  @Deprecated
  public final void bX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134587);
    super.c(paramString1, paramString2, 0);
    AppMethodBeat.o(134587);
  }
  
  protected void bw(boolean paramBoolean)
  {
    AppMethodBeat.i(134581);
    if (!isRunning())
    {
      ad.w("MicroMsg.AppBrandService", "onRuntimeResume but not running, appId %s, willRelaunch %b", new Object[] { getAppId(), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(134581);
      return;
    }
    com.tencent.mm.plugin.appbrand.page.m localm = aXw();
    AppBrandRuntime localAppBrandRuntime = this.jzY;
    HashMap localHashMap = new HashMap();
    Object localObject = localAppBrandRuntime.Fi().Ef();
    if (localObject != null) {
      localHashMap.put("referrerInfo", localObject);
    }
    localHashMap.put("relaunch", Boolean.valueOf(paramBoolean));
    localHashMap.put("reLaunch", Boolean.valueOf(paramBoolean));
    if (paramBoolean) {}
    for (localObject = localAppBrandRuntime.aVW();; localObject = localAppBrandRuntime.aVN().getCurrentUrl())
    {
      localHashMap.put("rawPath", localObject);
      localHashMap.put("path", com.tencent.luggage.h.k.dr((String)localObject));
      localHashMap.put("query", com.tencent.luggage.h.k.ds((String)localObject));
      ad.i("MicroMsg.AppBrandOnAppEnterForegroundEvent", "path: %s, query: %s, relaunch: %s, url: %s", new Object[] { localHashMap.get("path"), localHashMap.get("query"), localHashMap.get("relaunch"), localObject });
      com.tencent.luggage.h.d.d(localHashMap);
      localObject = new JSONObject(localHashMap);
      localm.a(localAppBrandRuntime, paramBoolean, (JSONObject)localObject);
      localm.Ph(((JSONObject)localObject).toString()).g(localAppBrandRuntime.Ew()).bir();
      AppMethodBeat.o(134581);
      return;
    }
  }
  
  public void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(134588);
    if ((this.jzW) && (com.tencent.luggage.a.e.K(j.class) != null) && (((j)com.tencent.luggage.a.e.K(j.class)).KO(paramString1)))
    {
      ad.i("MicroMsg.AppBrandService", "dispatch, ad related event:%s", new Object[] { paramString1 });
      super.c(paramString1, paramString2, paramInt);
      AppMethodBeat.o(134588);
      return;
    }
    if (this.jAc != null) {}
    synchronized (this.jAb)
    {
      if (this.jAc != null)
      {
        this.jAc.add(new com.tencent.mm.plugin.appbrand.jsapi.aa(paramString1, paramString2, paramInt));
        AppMethodBeat.o(134588);
        return;
      }
      super.c(paramString1, paramString2, paramInt);
      AppMethodBeat.o(134588);
      return;
    }
  }
  
  public void cleanup()
  {
    AppMethodBeat.i(134595);
    this.mInitialized = false;
    this.mDestroyed = true;
    this.jzY = null;
    super.cleanup();
    synchronized (this.jzZ)
    {
      if (this.jAa == null) {
        break label110;
      }
      w localw = this.jAa;
      Iterator localIterator = localw.jAJ.cZx.values().iterator();
      if (localIterator.hasNext()) {
        ((com.tencent.mm.appbrand.v8.m)localIterator.next()).cYn.quit();
      }
    }
    localObject2.jwH = null;
    this.jAa = null;
    label110:
    AppMethodBeat.o(134595);
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134579);
    this.jzY = paramAppBrandRuntime;
    a(paramAppBrandRuntime.getWindowAndroid());
    paramAppBrandRuntime = r.a.jAn;
    int i = super.aXC();
    ad.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      List localList = (List)paramAppBrandRuntime.jAl.get(i);
      if (localList == null)
      {
        ad.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify listenerList empty");
        paramAppBrandRuntime.jAm.put(i, 1);
        return;
      }
      i = 0;
      while (i < localList.size())
      {
        ((r.b)localList.get(i)).aXF();
        i += 1;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(134579);
    }
  }
  
  public void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(134599);
    super.d(paramJSONObject);
    if (aYh() != null) {
      if (aYh().P(com.tencent.mm.plugin.appbrand.jsruntime.k.class) == null) {
        break label54;
      }
    }
    label54:
    for (boolean bool = true;; bool = false)
    {
      c(paramJSONObject, "nativeBufferEnabled", Boolean.valueOf(bool));
      AppMethodBeat.o(134599);
      return;
    }
  }
  
  public String dm(String paramString)
  {
    return "";
  }
  
  public com.tencent.mm.plugin.appbrand.page.aa getCurrentPageView()
  {
    AppMethodBeat.i(134591);
    com.tencent.mm.plugin.appbrand.page.aa localaa = at(com.tencent.mm.plugin.appbrand.page.aa.class);
    AppMethodBeat.o(134591);
    return localaa;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.jzY;
  }
  
  public final com.tencent.mm.plugin.appbrand.r.a.c getWindowAndroid()
  {
    return this.jzX;
  }
  
  public final void init()
  {
    AppMethodBeat.i(134584);
    super.init();
    aXx();
    this.mInitialized = true;
    f(this.jzY.jwO);
    Dd();
    this.jzW = false;
    AppMethodBeat.o(134584);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(134590);
    if ((this.mInitialized) && (!this.mDestroyed) && (super.isRunning()))
    {
      AppMethodBeat.o(134590);
      return true;
    }
    AppMethodBeat.o(134590);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q
 * JD-Core Version:    0.7.0.1
 */