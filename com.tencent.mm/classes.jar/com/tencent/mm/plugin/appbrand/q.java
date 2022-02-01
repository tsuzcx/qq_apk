package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.webkit.ValueCallback;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.ad.f;
import com.tencent.mm.plugin.appbrand.ad.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsruntime.n;
import com.tencent.mm.plugin.appbrand.jsruntime.n.a;
import com.tencent.mm.plugin.appbrand.jsruntime.n.b;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.s.a.a.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Collection;
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
  private volatile boolean iGS;
  public volatile boolean iGT;
  public com.tencent.mm.plugin.appbrand.s.a.c iGU;
  volatile AppBrandRuntime iGV;
  private final Object iGW;
  private volatile w iGX;
  private final Object iGY;
  private volatile LinkedList<com.tencent.mm.plugin.appbrand.jsapi.aa> iGZ;
  f iHa;
  private volatile boolean mDestroyed;
  private volatile boolean mInitialized;
  
  public q()
  {
    AppMethodBeat.i(134576);
    this.mDestroyed = false;
    this.mInitialized = false;
    this.iGS = false;
    this.iGT = false;
    this.iGU = new o();
    this.iGW = new byte[0];
    this.iGY = new byte[0];
    synchronized (this.iGY)
    {
      this.iGZ = new LinkedList();
      AppMethodBeat.o(134576);
      return;
    }
  }
  
  private void aNy()
  {
    AppMethodBeat.i(134582);
    synchronized (this.iGW)
    {
      if (this.iGX == null) {
        this.iGX = DR();
      }
      AppMethodBeat.o(134582);
      return;
    }
  }
  
  protected void BV()
  {
    AppMethodBeat.i(134580);
    if (!isRunning())
    {
      ad.w("MicroMsg.AppBrandService", "onRuntimePause but not running appId %s", new Object[] { getAppId() });
      AppMethodBeat.o(134580);
      return;
    }
    new com.tencent.mm.plugin.appbrand.page.k().ak(this.iGV);
    AppMethodBeat.o(134580);
  }
  
  protected void Ca()
  {
    AppMethodBeat.i(134585);
    DM();
    aNz();
    AppMethodBeat.o(134585);
  }
  
  protected void Cb() {}
  
  public com.tencent.mm.plugin.appbrand.jsruntime.i DI()
  {
    AppMethodBeat.i(134594);
    com.tencent.mm.plugin.appbrand.jsruntime.c localc = new com.tencent.mm.plugin.appbrand.jsruntime.c((byte)0);
    AppMethodBeat.o(134594);
    return localc;
  }
  
  public Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> DJ()
  {
    return null;
  }
  
  public JSONObject DL()
  {
    AppMethodBeat.i(134597);
    JSONObject localJSONObject = new JSONObject();
    d(localJSONObject);
    Object localObject1 = this.iGV.Ef();
    Object localObject2 = this.iGV.getAppConfig();
    if ((localObject1 == null) || (localObject2 == null))
    {
      localObject1 = new JSONObject();
      AppMethodBeat.o(134597);
      return localObject1;
    }
    if ((a.Eq()) && (((a)localObject2).jbw != null) && (((a)localObject2).jbw.length() != 0)) {}
    for (localObject1 = ((a)localObject2).jbw;; localObject1 = ((a)localObject2).jbv)
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
  
  protected void DM()
  {
    AppMethodBeat.i(134596);
    Object localObject = DL();
    final String str = this.iGV.getAppConfig().jbB;
    if (aOf().P(n.class) != null)
    {
      str = ((JSONObject)localObject).toString();
      ((n)aOf().P(n.class)).a("__native_custom_event__wxConfig_inject", str, 0, "", new n.a()
      {
        public final void a(n.b paramAnonymousb)
        {
          AppMethodBeat.i(176536);
          q.this.a(str, paramAnonymousb.cPX, paramAnonymousb.cPY, null);
          AppMethodBeat.o(176536);
        }
      });
      AppMethodBeat.o(134596);
      return;
    }
    final long l = bt.eGO();
    localObject = ((JSONObject)localObject).toString();
    str = String.format(Locale.ENGLISH, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);var __wxIndexPage = \"%s\";", new Object[] { localObject, str });
    if (aOf().P(com.tencent.mm.plugin.appbrand.jsruntime.v.class) != null)
    {
      ((com.tencent.mm.plugin.appbrand.jsruntime.v)aOf().P(com.tencent.mm.plugin.appbrand.jsruntime.v.class)).a(null, null, null, 0, str, new m.b()
      {
        public final void a(String paramAnonymousString, m.c paramAnonymousc)
        {
          AppMethodBeat.i(176537);
          q.this.a(this.iHb, l, bt.eGO(), paramAnonymousc);
          AppMethodBeat.o(176537);
        }
      });
      AppMethodBeat.o(134596);
      return;
    }
    aOf().evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(134596);
  }
  
  public String DN()
  {
    return "";
  }
  
  public String DO()
  {
    return "";
  }
  
  protected w DR()
  {
    AppMethodBeat.i(134583);
    w localw = new w(this);
    AppMethodBeat.o(134583);
    return localw;
  }
  
  public final void MX()
  {
    AppMethodBeat.i(134577);
    aXB();
    aNy();
    com.tencent.mm.plugin.appbrand.jsapi.i.a(this, aNC());
    this.iGS = true;
    Cb();
    if (aOf().P(com.tencent.mm.plugin.appbrand.jsruntime.r.class) != null) {
      aOf().P(com.tencent.mm.plugin.appbrand.jsruntime.r.class);
    }
    AppMethodBeat.o(134577);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.s.a.c paramc)
  {
    this.iGU = paramc;
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final String aNA()
  {
    return "AppBrandService";
  }
  
  public final w aNB()
  {
    synchronized (this.iGW)
    {
      w localw = this.iGX;
      return localw;
    }
  }
  
  public final JSONObject aNC()
  {
    AppMethodBeat.i(134598);
    JSONObject localJSONObject = super.aNC();
    AppMethodBeat.o(134598);
    return localJSONObject;
  }
  
  public final boolean aNu()
  {
    return this.iGT;
  }
  
  public final boolean aNv()
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
  
  public final boolean aNw()
  {
    return this.iGS;
  }
  
  protected l aNx()
  {
    AppMethodBeat.i(176539);
    l locall = new l();
    AppMethodBeat.o(176539);
    return locall;
  }
  
  protected final void aNz()
  {
    Object localObject1 = null;
    AppMethodBeat.i(134586);
    synchronized (this.iGY)
    {
      if (this.iGZ != null) {
        localObject1 = new LinkedList(this.iGZ);
      }
      this.iGZ = null;
      if (localObject1 != null)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          ??? = (com.tencent.mm.plugin.appbrand.jsapi.aa)((Iterator)localObject1).next();
          super.c(((com.tencent.mm.plugin.appbrand.jsapi.aa)???).dcx, ((com.tencent.mm.plugin.appbrand.jsapi.aa)???).data, ((com.tencent.mm.plugin.appbrand.jsapi.aa)???).src);
        }
      }
    }
    AppMethodBeat.o(134586);
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.page.aa> T at(Class<T> paramClass)
  {
    AppMethodBeat.i(134592);
    if (this.iGV == null)
    {
      AppMethodBeat.o(134592);
      return null;
    }
    if (this.iGV.aLK() == null)
    {
      AppMethodBeat.o(134592);
      return null;
    }
    if (this.iGV.aLK() == null)
    {
      ad.w("MicroMsg.AppBrandService", "getCurrentPageView NULL PageContainer, appId=%s", new Object[] { getAppId() });
      if (!this.iGV.aLY())
      {
        paramClass = new IllegalStateException("getCurrentPageView NULL PageContainer");
        AppMethodBeat.o(134592);
        throw paramClass;
      }
      AppMethodBeat.o(134592);
      return null;
    }
    Object localObject = this.iGV.aLK().getCurrentPage();
    if (localObject == null)
    {
      ad.w("MicroMsg.AppBrandService", "getCurrentPageView NULL Page, appId=%s", new Object[] { getAppId() });
      AppMethodBeat.o(134592);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.page.q)localObject).getCurrentPageView();
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
    this.iGV.aLK().c(paramString1, paramString2, paramArrayOfInt);
    AppMethodBeat.o(134589);
  }
  
  @Deprecated
  public final void bN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134587);
    super.c(paramString1, paramString2, 0);
    AppMethodBeat.o(134587);
  }
  
  protected void bx(boolean paramBoolean)
  {
    AppMethodBeat.i(134581);
    if (!isRunning())
    {
      ad.w("MicroMsg.AppBrandService", "onRuntimeResume but not running, appId %s, willRelaunch %b", new Object[] { getAppId(), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(134581);
      return;
    }
    l locall = aNx();
    AppBrandRuntime localAppBrandRuntime = this.iGV;
    HashMap localHashMap = new HashMap();
    Object localObject = localAppBrandRuntime.Eg().Dd();
    if (localObject != null) {
      localHashMap.put("referrerInfo", localObject);
    }
    localHashMap.put("relaunch", Boolean.valueOf(paramBoolean));
    localHashMap.put("reLaunch", Boolean.valueOf(paramBoolean));
    if (paramBoolean) {}
    for (localObject = localAppBrandRuntime.aLS();; localObject = localAppBrandRuntime.aLK().getCurrentUrl())
    {
      localHashMap.put("rawPath", localObject);
      localHashMap.put("path", com.tencent.luggage.h.k.cA((String)localObject));
      localHashMap.put("query", com.tencent.luggage.h.k.cB((String)localObject));
      ad.i("MicroMsg.AppBrandOnAppEnterForegroundEvent", "path: %s, query: %s, relaunch: %s, url: %s", new Object[] { localHashMap.get("path"), localHashMap.get("query"), localHashMap.get("relaunch"), localObject });
      com.tencent.luggage.h.d.e(localHashMap);
      localObject = new JSONObject(localHashMap);
      locall.a(localAppBrandRuntime, paramBoolean, (JSONObject)localObject);
      locall.HJ(((JSONObject)localObject).toString()).g(localAppBrandRuntime.Du()).aXQ();
      AppMethodBeat.o(134581);
      return;
    }
  }
  
  public void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(134588);
    if ((this.iGT) && (e.K(g.class) != null) && (((g)e.K(g.class)).Dy(paramString1)))
    {
      ad.i("MicroMsg.AppBrandService", "dispatch, ad related event:%s", new Object[] { paramString1 });
      super.c(paramString1, paramString2, paramInt);
      AppMethodBeat.o(134588);
      return;
    }
    if (this.iGZ != null) {}
    synchronized (this.iGY)
    {
      if (this.iGZ != null)
      {
        this.iGZ.add(new com.tencent.mm.plugin.appbrand.jsapi.aa(paramString1, paramString2, paramInt));
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
    this.iGV = null;
    super.cleanup();
    synchronized (this.iGW)
    {
      if (this.iGX == null) {
        break label110;
      }
      w localw = this.iGX;
      Iterator localIterator = localw.iHy.cQM.values().iterator();
      if (localIterator.hasNext()) {
        ((com.tencent.mm.appbrand.v8.m)localIterator.next()).cPC.quit();
      }
    }
    localObject2.iDy = null;
    this.iGX = null;
    label110:
    AppMethodBeat.o(134595);
  }
  
  public String cv(String paramString)
  {
    return "";
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134579);
    this.iGV = paramAppBrandRuntime;
    a(paramAppBrandRuntime.getWindowAndroid());
    paramAppBrandRuntime = r.a.iHf;
    int i = aOd();
    ad.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      List localList = (List)paramAppBrandRuntime.iHd.get(i);
      if (localList == null)
      {
        ad.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify listenerList empty");
        paramAppBrandRuntime.iHe.put(i, 1);
        return;
      }
      i = 0;
      while (i < localList.size())
      {
        ((r.b)localList.get(i)).aND();
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
    if (aOf() != null) {
      if (aOf().P(com.tencent.mm.plugin.appbrand.jsruntime.k.class) == null) {
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
  
  public com.tencent.mm.plugin.appbrand.page.aa getCurrentPageView()
  {
    AppMethodBeat.i(134591);
    com.tencent.mm.plugin.appbrand.page.aa localaa = at(com.tencent.mm.plugin.appbrand.page.aa.class);
    AppMethodBeat.o(134591);
    return localaa;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.iGV;
  }
  
  public final com.tencent.mm.plugin.appbrand.s.a.c getWindowAndroid()
  {
    return this.iGU;
  }
  
  public final void init()
  {
    AppMethodBeat.i(134584);
    super.init();
    aNy();
    this.mInitialized = true;
    f(this.iGV.iDG);
    Ca();
    this.iGT = false;
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