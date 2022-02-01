package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.webkit.ValueCallback;
import com.tencent.luggage.l.d;
import com.tencent.luggage.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.k;
import com.tencent.mm.plugin.appbrand.n.n;
import com.tencent.mm.plugin.appbrand.n.n.a;
import com.tencent.mm.plugin.appbrand.n.n.b;
import com.tencent.mm.plugin.appbrand.n.r;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class y
  extends g
{
  private volatile boolean mDestroyed;
  private volatile boolean mInitialized;
  private volatile boolean qwD;
  private volatile boolean qwE;
  public com.tencent.mm.plugin.appbrand.platform.window.c qwF;
  public volatile AppBrandRuntime qwG;
  private final Object qwH;
  private volatile af qwI;
  private final Object qwJ;
  private volatile LinkedList<ah> qwK;
  private final LinkedList<b> qwL;
  private a qwM;
  
  public y()
  {
    AppMethodBeat.i(134576);
    this.mDestroyed = false;
    this.mInitialized = false;
    this.qwD = false;
    this.qwE = false;
    this.qwF = new com.tencent.mm.plugin.appbrand.platform.window.a.o();
    this.qwH = new byte[0];
    this.qwJ = new byte[0];
    this.qwL = new LinkedList();
    synchronized (this.qwJ)
    {
      this.qwK = new LinkedList();
      AppMethodBeat.o(134576);
      return;
    }
  }
  
  private void cdk()
  {
    AppMethodBeat.i(134582);
    if (!arH())
    {
      AppMethodBeat.o(134582);
      return;
    }
    synchronized (this.qwH)
    {
      if (this.qwI == null) {
        this.qwI = arK();
      }
      synchronized (this.qwL)
      {
        Object localObject3 = new LinkedList(this.qwL);
        this.qwL.clear();
        localObject3 = ((LinkedList)localObject3).iterator();
        if (((Iterator)localObject3).hasNext()) {
          ((b)((Iterator)localObject3).next()).a(this.qwI);
        }
      }
    }
    AppMethodBeat.o(134582);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    this.qwF = paramc;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(316707);
    synchronized (this.qwH)
    {
      if (this.qwI != null)
      {
        paramb.a(this.qwI);
        AppMethodBeat.o(316707);
        return;
      }
    }
    synchronized (this.qwL)
    {
      this.qwL.add(paramb);
      AppMethodBeat.o(316707);
      return;
      paramb = finally;
      AppMethodBeat.o(316707);
      throw paramb;
    }
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final void aFB()
  {
    AppMethodBeat.i(134577);
    cpF();
    cdk();
    Y(cdo());
    this.qwD = true;
    apD();
    if (getJsRuntime().Z(r.class) != null) {
      getJsRuntime().Z(r.class);
    }
    AppMethodBeat.o(134577);
  }
  
  public final <T extends ad> T aP(Class<T> paramClass)
  {
    AppMethodBeat.i(134592);
    if (this.qwG == null)
    {
      AppMethodBeat.o(134592);
      return null;
    }
    if (this.qwG.getPageContainer() == null)
    {
      AppMethodBeat.o(134592);
      return null;
    }
    if (this.qwG.getPageContainer() == null)
    {
      Log.w("MicroMsg.AppBrandService", "getCurrentPageView NULL PageContainer, appId=%s", new Object[] { getAppId() });
      if (!this.qwG.cbD())
      {
        paramClass = new IllegalStateException("getCurrentPageView NULL PageContainer");
        AppMethodBeat.o(134592);
        throw paramClass;
      }
      AppMethodBeat.o(134592);
      return null;
    }
    Object localObject = this.qwG.getPageContainer().getCurrentPage();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrandService", "getCurrentPageView NULL Page, appId=%s", new Object[] { getAppId() });
      AppMethodBeat.o(134592);
      return null;
    }
    localObject = ((u)localObject).getCurrentPageView();
    if (paramClass.isInstance(localObject))
    {
      AppMethodBeat.o(134592);
      return localObject;
    }
    AppMethodBeat.o(134592);
    return null;
  }
  
  public final <T extends Activity> T aQ(Class<T> paramClass)
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
  
  protected void apC()
  {
    AppMethodBeat.i(134585);
    arE();
    cdl();
    AppMethodBeat.o(134585);
  }
  
  protected void apD() {}
  
  protected void apx()
  {
    AppMethodBeat.i(134580);
    if (!isRunning())
    {
      Log.w("MicroMsg.AppBrandService", "onRuntimePause but not running appId %s", new Object[] { getAppId() });
      AppMethodBeat.o(134580);
      return;
    }
    new com.tencent.mm.plugin.appbrand.page.o().as(this.qwG);
    AppMethodBeat.o(134580);
  }
  
  public Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> arA()
  {
    return null;
  }
  
  public JSONObject arC()
  {
    AppMethodBeat.i(134597);
    JSONObject localJSONObject = new JSONObject();
    f(localJSONObject);
    Object localObject1 = this.qwG.asG();
    Object localObject2 = this.qwG.getAppConfig();
    if ((localObject1 == null) || (localObject2 == null))
    {
      localObject1 = new JSONObject();
      AppMethodBeat.o(134597);
      return localObject1;
    }
    if ((((b)localObject2).isDarkMode()) && (((b)localObject2).qVR != null) && (((b)localObject2).qVR.length() != 0)) {}
    for (localObject1 = ((b)localObject2).qVR;; localObject1 = ((b)localObject2).qVQ)
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
          Log.e("MicroMsg.AppBrandService", localException.getMessage());
        }
      }
    }
    d(localJSONObject, "env", new JSONObject());
    localObject1 = new JSONObject();
    d((JSONObject)localObject1, "zIndex", Integer.valueOf(1000));
    d((JSONObject)localObject1, "viewId", Integer.valueOf(1));
    d(localJSONObject, "menuButtonInfo", localObject1);
    AppMethodBeat.o(134597);
    return localJSONObject;
  }
  
  public boolean arD()
  {
    return false;
  }
  
  protected void arE()
  {
    AppMethodBeat.i(134596);
    Object localObject = arC();
    Log.i("MicroMsg.AppBrandService", "injectConfig(%s): %s", new Object[] { getAppId(), ((JSONObject)localObject).toString() });
    final String str = this.qwG.getAppConfig().qVW;
    Log.i("MicroMsg.AppBrandService", "injectConfig start, hash=%d", new Object[] { Integer.valueOf(getComponentId()) });
    if (getJsRuntime().Z(n.class) != null)
    {
      str = ((JSONObject)localObject).toString();
      ((n)getJsRuntime().Z(n.class)).a("__native_custom_event__wxConfig_inject", str, 0, "", new n.a()
      {
        public final void a(n.b paramAnonymousb)
        {
          AppMethodBeat.i(176536);
          Log.i("MicroMsg.AppBrandService", "injectConfig end by AddonDirectEvaluation, cost=%dms, hash=%d", new Object[] { Long.valueOf(paramAnonymousb.hnf - paramAnonymousb.hne), Integer.valueOf(y.this.getComponentId()) });
          y.a(y.this, new y.a((byte)0));
          y.e(y.this).qwQ = str;
          y.e(y.this).qwR = paramAnonymousb.hne;
          y.e(y.this).qwS = paramAnonymousb.hnf;
          y.e(y.this).extra = paramAnonymousb;
          AppMethodBeat.o(176536);
        }
      });
      AppMethodBeat.o(134596);
      return;
    }
    final long l = Util.nowMilliSecond();
    localObject = ((JSONObject)localObject).toString();
    str = String.format(Locale.ENGLISH, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);var __wxIndexPage = \"%s\";", new Object[] { localObject, str });
    if (getJsRuntime().Z(com.tencent.mm.plugin.appbrand.n.v.class) != null)
    {
      ((com.tencent.mm.plugin.appbrand.n.v)getJsRuntime().Z(com.tencent.mm.plugin.appbrand.n.v.class)).a(null, null, null, 0, str, new m.b()
      {
        public final void onResult(String paramAnonymousString, m.c paramAnonymousc)
        {
          AppMethodBeat.i(176537);
          Log.i("MicroMsg.AppBrandService", "injectConfig end by AddonV8, cost=%dms, hash=%d", new Object[] { Long.valueOf(paramAnonymousc.hnf - paramAnonymousc.hne), Integer.valueOf(y.this.getComponentId()) });
          y.a(y.this, new y.a((byte)0));
          y.e(y.this).qwQ = this.qwN;
          y.e(y.this).qwR = paramAnonymousc.hne;
          y.e(y.this).qwS = paramAnonymousc.hnf;
          y.e(y.this).extra = paramAnonymousc;
          AppMethodBeat.o(176537);
        }
      });
      AppMethodBeat.o(134596);
      return;
    }
    getJsRuntime().evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(134596);
  }
  
  public String arF()
  {
    return "";
  }
  
  public String arG()
  {
    return "";
  }
  
  protected boolean arH()
  {
    return true;
  }
  
  protected af arK()
  {
    AppMethodBeat.i(134583);
    af localaf = new af(this);
    AppMethodBeat.o(134583);
    return localaf;
  }
  
  public i arz()
  {
    AppMethodBeat.i(134594);
    com.tencent.mm.plugin.appbrand.n.c localc = new com.tencent.mm.plugin.appbrand.n.c((byte)0);
    AppMethodBeat.o(134594);
    return localc;
  }
  
  public final boolean asZ()
  {
    return this.qwD;
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134589);
    if (!isRunning())
    {
      AppMethodBeat.o(134589);
      return;
    }
    this.qwG.getPageContainer().c(paramString1, paramString2, paramArrayOfInt);
    AppMethodBeat.o(134589);
  }
  
  @Deprecated
  public final void cF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134587);
    super.f(paramString1, paramString2, 0);
    AppMethodBeat.o(134587);
  }
  
  protected void cP(boolean paramBoolean)
  {
    AppMethodBeat.i(134581);
    if (!isRunning())
    {
      Log.w("MicroMsg.AppBrandService", "onRuntimeResume but not running, appId %s, willRelaunch %b", new Object[] { getAppId(), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(134581);
      return;
    }
    com.tencent.mm.plugin.appbrand.page.p localp = cdj();
    AppBrandRuntime localAppBrandRuntime = this.qwG;
    HashMap localHashMap = new HashMap();
    Object localObject = localAppBrandRuntime.asH().aqM();
    if (localObject != null) {
      localHashMap.put("referrerInfo", localObject);
    }
    localHashMap.put("relaunch", Boolean.valueOf(paramBoolean));
    localHashMap.put("reLaunch", Boolean.valueOf(paramBoolean));
    if (paramBoolean) {}
    for (localObject = localAppBrandRuntime.cby();; localObject = localAppBrandRuntime.getPageContainer().getCurrentUrl())
    {
      localHashMap.put("rawPath", localObject);
      localHashMap.put("path", m.fL((String)localObject));
      localHashMap.put("query", m.fM((String)localObject));
      Log.i("MicroMsg.AppBrandOnAppEnterForegroundEvent", "path: %s, query: %s, relaunch: %s, url: %s", new Object[] { localHashMap.get("path"), localHashMap.get("query"), localHashMap.get("relaunch"), localObject });
      d.k(localHashMap);
      localObject = new JSONObject(localHashMap);
      localp.a(localAppBrandRuntime, paramBoolean, (JSONObject)localObject);
      localp.ZQ(((JSONObject)localObject).toString()).h(localAppBrandRuntime.ari()).cpV();
      AppMethodBeat.o(134581);
      return;
    }
  }
  
  public final boolean cdi()
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
  
  protected com.tencent.mm.plugin.appbrand.page.p cdj()
  {
    AppMethodBeat.i(176539);
    com.tencent.mm.plugin.appbrand.page.p localp = new com.tencent.mm.plugin.appbrand.page.p();
    AppMethodBeat.o(176539);
    return localp;
  }
  
  protected final void cdl()
  {
    Object localObject1 = null;
    AppMethodBeat.i(134586);
    synchronized (this.qwJ)
    {
      if (this.qwK != null) {
        localObject1 = new LinkedList(this.qwK);
      }
      this.qwK = null;
      if (localObject1 != null)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          ??? = (ah)((Iterator)localObject1).next();
          super.f(((ah)???).event, ((ah)???).data, ((ah)???).src);
        }
      }
    }
    AppMethodBeat.o(134586);
  }
  
  public final String cdm()
  {
    return "AppBrandService";
  }
  
  public final af cdn()
  {
    AppMethodBeat.i(316757);
    if (!arH())
    {
      AppMethodBeat.o(316757);
      return null;
    }
    synchronized (this.qwH)
    {
      af localaf = this.qwI;
      AppMethodBeat.o(316757);
      return localaf;
    }
  }
  
  public final JSONObject cdo()
  {
    AppMethodBeat.i(134598);
    JSONObject localJSONObject = super.cdo();
    AppMethodBeat.o(134598);
    return localJSONObject;
  }
  
  public void cleanup()
  {
    AppMethodBeat.i(134595);
    this.mInitialized = false;
    this.mDestroyed = true;
    this.qwG = null;
    super.cleanup();
    synchronized (this.qwH)
    {
      if (this.qwI != null)
      {
        af localaf = this.qwI;
        localaf.qxg.exit();
        localaf.qsi = null;
        localaf.qxj.clear();
        this.qwI = null;
      }
      AppMethodBeat.o(134595);
      return;
    }
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134579);
    this.qwG = paramAppBrandRuntime;
    a(paramAppBrandRuntime.getWindowAndroid());
    if (arH())
    {
      cdk();
      if (!arD())
      {
        paramAppBrandRuntime = cdn();
        paramAppBrandRuntime.qxl.set(true);
        Log.i("MicroMsg.AppBrandWorkerContainer", "onRuntimeReady");
        paramAppBrandRuntime.qxg.aEr();
        paramAppBrandRuntime.cdr();
      }
    }
    paramAppBrandRuntime = z.a.qwV;
    int i = getComponentId();
    Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      List localList = (List)paramAppBrandRuntime.qwT.get(i);
      if (localList == null)
      {
        Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify listenerList empty");
        paramAppBrandRuntime.qwU.put(i, 1);
        return;
      }
      i = 0;
      while (i < localList.size())
      {
        ((z.b)localList.get(i)).aEr();
        i += 1;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(134579);
    }
  }
  
  public void f(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(134588);
    if (this.qwK != null) {}
    synchronized (this.qwJ)
    {
      if (this.qwK != null)
      {
        this.qwK.add(new ah(paramString1, paramString2, paramInt));
        AppMethodBeat.o(134588);
        return;
      }
      super.f(paramString1, paramString2, paramInt);
      AppMethodBeat.o(134588);
      return;
    }
  }
  
  public void f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(134599);
    super.f(paramJSONObject);
    if (getJsRuntime() != null) {
      if (getJsRuntime().Z(k.class) == null) {
        break label54;
      }
    }
    label54:
    for (boolean bool = true;; bool = false)
    {
      d(paramJSONObject, "nativeBufferEnabled", Boolean.valueOf(bool));
      AppMethodBeat.o(134599);
      return;
    }
  }
  
  public String ft(String paramString)
  {
    return "";
  }
  
  public final int getComponentId()
  {
    AppMethodBeat.i(316759);
    int i = super.getComponentId();
    AppMethodBeat.o(316759);
    return i;
  }
  
  public ad getCurrentPageView()
  {
    AppMethodBeat.i(134591);
    ad localad = aP(ad.class);
    AppMethodBeat.o(134591);
    return localad;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.qwG;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid()
  {
    return this.qwF;
  }
  
  public final void init()
  {
    AppMethodBeat.i(134584);
    super.init();
    cdk();
    this.mInitialized = true;
    u(this.qwG.qst);
    apC();
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
  
  static final class a
  {
    Object extra;
    String qwQ;
    long qwR;
    long qwS;
  }
  
  static abstract interface b
  {
    public abstract void a(af paramaf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.y
 * JD-Core Version:    0.7.0.1
 */