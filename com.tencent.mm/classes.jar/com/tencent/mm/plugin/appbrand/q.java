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
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.a.a.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private volatile boolean jgV;
  public volatile boolean jgW;
  public com.tencent.mm.plugin.appbrand.r.a.c jgX;
  volatile AppBrandRuntime jgY;
  private final Object jgZ;
  private volatile w jha;
  private final Object jhb;
  private volatile LinkedList<com.tencent.mm.plugin.appbrand.jsapi.aa> jhc;
  f jhd;
  private volatile boolean mDestroyed;
  private volatile boolean mInitialized;
  
  public q()
  {
    AppMethodBeat.i(134576);
    this.mDestroyed = false;
    this.mInitialized = false;
    this.jgV = false;
    this.jgW = false;
    this.jgX = new o();
    this.jgZ = new byte[0];
    this.jhb = new byte[0];
    synchronized (this.jhb)
    {
      this.jhc = new LinkedList();
      AppMethodBeat.o(134576);
      return;
    }
  }
  
  private void aUo()
  {
    AppMethodBeat.i(134582);
    synchronized (this.jgZ)
    {
      if (this.jha == null) {
        this.jha = Du();
      }
      AppMethodBeat.o(134582);
      return;
    }
  }
  
  protected void BE()
  {
    AppMethodBeat.i(134585);
    Dp();
    aUp();
    AppMethodBeat.o(134585);
  }
  
  protected void BF() {}
  
  protected void Bz()
  {
    AppMethodBeat.i(134580);
    if (!isRunning())
    {
      ac.w("MicroMsg.AppBrandService", "onRuntimePause but not running appId %s", new Object[] { getAppId() });
      AppMethodBeat.o(134580);
      return;
    }
    new l().ak(this.jgY);
    AppMethodBeat.o(134580);
  }
  
  public com.tencent.mm.plugin.appbrand.jsruntime.i Dl()
  {
    AppMethodBeat.i(134594);
    com.tencent.mm.plugin.appbrand.jsruntime.c localc = new com.tencent.mm.plugin.appbrand.jsruntime.c((byte)0);
    AppMethodBeat.o(134594);
    return localc;
  }
  
  public Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> Dm()
  {
    return null;
  }
  
  public JSONObject Do()
  {
    AppMethodBeat.i(134597);
    JSONObject localJSONObject = new JSONObject();
    d(localJSONObject);
    Object localObject1 = this.jgY.DI();
    Object localObject2 = this.jgY.getAppConfig();
    if ((localObject1 == null) || (localObject2 == null))
    {
      localObject1 = new JSONObject();
      AppMethodBeat.o(134597);
      return localObject1;
    }
    if ((a.DT()) && (((a)localObject2).jBJ != null) && (((a)localObject2).jBJ.length() != 0)) {}
    for (localObject1 = ((a)localObject2).jBJ;; localObject1 = ((a)localObject2).jBI)
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
          ac.e("MicroMsg.AppBrandService", localException.getMessage());
        }
      }
    }
    c(localJSONObject, "env", new JSONObject());
    ac.i("MicroMsg.AppBrandService", "generateWxConfig :%s", new Object[] { localJSONObject.toString() });
    AppMethodBeat.o(134597);
    return localJSONObject;
  }
  
  protected void Dp()
  {
    AppMethodBeat.i(134596);
    Object localObject = Do();
    final String str = this.jgY.getAppConfig().jBO;
    if (aUV().P(n.class) != null)
    {
      str = ((JSONObject)localObject).toString();
      ((n)aUV().P(n.class)).a("__native_custom_event__wxConfig_inject", str, 0, "", new n.a()
      {
        public final void a(n.b paramAnonymousb)
        {
          AppMethodBeat.i(176536);
          q.this.a(str, paramAnonymousb.cNs, paramAnonymousb.cNt, null);
          AppMethodBeat.o(176536);
        }
      });
      AppMethodBeat.o(134596);
      return;
    }
    final long l = bs.eWj();
    localObject = ((JSONObject)localObject).toString();
    str = String.format(Locale.ENGLISH, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);var __wxIndexPage = \"%s\";", new Object[] { localObject, str });
    if (aUV().P(com.tencent.mm.plugin.appbrand.jsruntime.v.class) != null)
    {
      ((com.tencent.mm.plugin.appbrand.jsruntime.v)aUV().P(com.tencent.mm.plugin.appbrand.jsruntime.v.class)).a(null, null, null, 0, str, new m.b()
      {
        public final void a(String paramAnonymousString, m.c paramAnonymousc)
        {
          AppMethodBeat.i(176537);
          q.this.a(this.jhe, l, bs.eWj(), paramAnonymousc);
          AppMethodBeat.o(176537);
        }
      });
      AppMethodBeat.o(134596);
      return;
    }
    aUV().evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(134596);
  }
  
  public String Dq()
  {
    return "";
  }
  
  public String Dr()
  {
    return "";
  }
  
  protected w Du()
  {
    AppMethodBeat.i(134583);
    w localw = new w(this);
    AppMethodBeat.o(134583);
    return localw;
  }
  
  public final void MV()
  {
    AppMethodBeat.i(134577);
    bey();
    aUo();
    com.tencent.mm.plugin.appbrand.jsapi.i.a(this, aUs());
    this.jgV = true;
    BF();
    if (aUV().P(com.tencent.mm.plugin.appbrand.jsruntime.r.class) != null) {
      aUV().P(com.tencent.mm.plugin.appbrand.jsruntime.r.class);
    }
    AppMethodBeat.o(134577);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.r.a.c paramc)
  {
    this.jgX = paramc;
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final boolean aUk()
  {
    return this.jgW;
  }
  
  public final boolean aUl()
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
  
  public final boolean aUm()
  {
    return this.jgV;
  }
  
  protected com.tencent.mm.plugin.appbrand.page.m aUn()
  {
    AppMethodBeat.i(176539);
    com.tencent.mm.plugin.appbrand.page.m localm = new com.tencent.mm.plugin.appbrand.page.m();
    AppMethodBeat.o(176539);
    return localm;
  }
  
  protected final void aUp()
  {
    Object localObject1 = null;
    AppMethodBeat.i(134586);
    synchronized (this.jhb)
    {
      if (this.jhc != null) {
        localObject1 = new LinkedList(this.jhc);
      }
      this.jhc = null;
      if (localObject1 != null)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          ??? = (com.tencent.mm.plugin.appbrand.jsapi.aa)((Iterator)localObject1).next();
          super.c(((com.tencent.mm.plugin.appbrand.jsapi.aa)???).cZV, ((com.tencent.mm.plugin.appbrand.jsapi.aa)???).data, ((com.tencent.mm.plugin.appbrand.jsapi.aa)???).src);
        }
      }
    }
    AppMethodBeat.o(134586);
  }
  
  public final String aUq()
  {
    return "AppBrandService";
  }
  
  public final w aUr()
  {
    synchronized (this.jgZ)
    {
      w localw = this.jha;
      return localw;
    }
  }
  
  public final JSONObject aUs()
  {
    AppMethodBeat.i(134598);
    JSONObject localJSONObject = super.aUs();
    AppMethodBeat.o(134598);
    return localJSONObject;
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.page.aa> T at(Class<T> paramClass)
  {
    AppMethodBeat.i(134592);
    if (this.jgY == null)
    {
      AppMethodBeat.o(134592);
      return null;
    }
    if (this.jgY.aSA() == null)
    {
      AppMethodBeat.o(134592);
      return null;
    }
    if (this.jgY.aSA() == null)
    {
      ac.w("MicroMsg.AppBrandService", "getCurrentPageView NULL PageContainer, appId=%s", new Object[] { getAppId() });
      if (!this.jgY.aSO())
      {
        paramClass = new IllegalStateException("getCurrentPageView NULL PageContainer");
        AppMethodBeat.o(134592);
        throw paramClass;
      }
      AppMethodBeat.o(134592);
      return null;
    }
    Object localObject = this.jgY.aSA().getCurrentPage();
    if (localObject == null)
    {
      ac.w("MicroMsg.AppBrandService", "getCurrentPageView NULL Page, appId=%s", new Object[] { getAppId() });
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
    this.jgY.aSA().c(paramString1, paramString2, paramArrayOfInt);
    AppMethodBeat.o(134589);
  }
  
  @Deprecated
  public final void bV(String paramString1, String paramString2)
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
      ac.w("MicroMsg.AppBrandService", "onRuntimeResume but not running, appId %s, willRelaunch %b", new Object[] { getAppId(), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(134581);
      return;
    }
    com.tencent.mm.plugin.appbrand.page.m localm = aUn();
    AppBrandRuntime localAppBrandRuntime = this.jgY;
    HashMap localHashMap = new HashMap();
    Object localObject = localAppBrandRuntime.DJ().CG();
    if (localObject != null) {
      localHashMap.put("referrerInfo", localObject);
    }
    localHashMap.put("relaunch", Boolean.valueOf(paramBoolean));
    localHashMap.put("reLaunch", Boolean.valueOf(paramBoolean));
    if (paramBoolean) {}
    for (localObject = localAppBrandRuntime.aSI();; localObject = localAppBrandRuntime.aSA().getCurrentUrl())
    {
      localHashMap.put("rawPath", localObject);
      localHashMap.put("path", com.tencent.luggage.h.k.cp((String)localObject));
      localHashMap.put("query", com.tencent.luggage.h.k.cq((String)localObject));
      ac.i("MicroMsg.AppBrandOnAppEnterForegroundEvent", "path: %s, query: %s, relaunch: %s, url: %s", new Object[] { localHashMap.get("path"), localHashMap.get("query"), localHashMap.get("relaunch"), localObject });
      com.tencent.luggage.h.d.d(localHashMap);
      localObject = new JSONObject(localHashMap);
      localm.a(localAppBrandRuntime, paramBoolean, (JSONObject)localObject);
      localm.LN(((JSONObject)localObject).toString()).g(localAppBrandRuntime.CX()).beN();
      AppMethodBeat.o(134581);
      return;
    }
  }
  
  public void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(134588);
    if ((this.jgW) && (e.K(g.class) != null) && (((g)e.K(g.class)).HB(paramString1)))
    {
      ac.i("MicroMsg.AppBrandService", "dispatch, ad related event:%s", new Object[] { paramString1 });
      super.c(paramString1, paramString2, paramInt);
      AppMethodBeat.o(134588);
      return;
    }
    if (this.jhc != null) {}
    synchronized (this.jhb)
    {
      if (this.jhc != null)
      {
        this.jhc.add(new com.tencent.mm.plugin.appbrand.jsapi.aa(paramString1, paramString2, paramInt));
        AppMethodBeat.o(134588);
        return;
      }
      super.c(paramString1, paramString2, paramInt);
      AppMethodBeat.o(134588);
      return;
    }
  }
  
  public String ck(String paramString)
  {
    return "";
  }
  
  public void cleanup()
  {
    AppMethodBeat.i(134595);
    this.mInitialized = false;
    this.mDestroyed = true;
    this.jgY = null;
    super.cleanup();
    synchronized (this.jgZ)
    {
      if (this.jha == null) {
        break label110;
      }
      w localw = this.jha;
      Iterator localIterator = localw.jhA.cOh.values().iterator();
      if (localIterator.hasNext()) {
        ((com.tencent.mm.appbrand.v8.m)localIterator.next()).cMX.quit();
      }
    }
    localObject2.jdy = null;
    this.jha = null;
    label110:
    AppMethodBeat.o(134595);
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134579);
    this.jgY = paramAppBrandRuntime;
    a(paramAppBrandRuntime.getWindowAndroid());
    paramAppBrandRuntime = r.a.jhi;
    int i = aUT();
    ac.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      List localList = (List)paramAppBrandRuntime.jhg.get(i);
      if (localList == null)
      {
        ac.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify listenerList empty");
        paramAppBrandRuntime.jhh.put(i, 1);
        return;
      }
      i = 0;
      while (i < localList.size())
      {
        ((r.b)localList.get(i)).aUt();
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
    if (aUV() != null) {
      if (aUV().P(com.tencent.mm.plugin.appbrand.jsruntime.k.class) == null) {
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
    return this.jgY;
  }
  
  public final com.tencent.mm.plugin.appbrand.r.a.c getWindowAndroid()
  {
    return this.jgX;
  }
  
  public final void init()
  {
    AppMethodBeat.i(134584);
    super.init();
    aUo();
    this.mInitialized = true;
    f(this.jgY.jdG);
    BE();
    this.jgW = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q
 * JD-Core Version:    0.7.0.1
 */