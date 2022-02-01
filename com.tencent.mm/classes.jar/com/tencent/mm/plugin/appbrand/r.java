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
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsruntime.n;
import com.tencent.mm.plugin.appbrand.jsruntime.n.a;
import com.tencent.mm.plugin.appbrand.jsruntime.n.b;
import com.tencent.mm.plugin.appbrand.page.al;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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

public class r
  extends d
{
  private volatile boolean jCY;
  public volatile boolean jCZ;
  public com.tencent.mm.plugin.appbrand.platform.window.c jDa;
  public volatile AppBrandRuntime jDb;
  private final Object jDc;
  private volatile w jDd;
  private final Object jDe;
  private volatile LinkedList<aa> jDf;
  a jDg;
  g jDh;
  private volatile boolean mDestroyed;
  private volatile boolean mInitialized;
  
  public r()
  {
    AppMethodBeat.i(134576);
    this.mDestroyed = false;
    this.mInitialized = false;
    this.jCY = false;
    this.jCZ = false;
    this.jDa = new o();
    this.jDc = new byte[0];
    this.jDe = new byte[0];
    synchronized (this.jDe)
    {
      this.jDf = new LinkedList();
      AppMethodBeat.o(134576);
      return;
    }
  }
  
  private void aXS()
  {
    AppMethodBeat.i(134582);
    synchronized (this.jDc)
    {
      if (this.jDd == null) {
        this.jDd = EV();
      }
      AppMethodBeat.o(134582);
      return;
    }
  }
  
  protected void Db()
  {
    AppMethodBeat.i(134580);
    if (!isRunning())
    {
      ae.w("MicroMsg.AppBrandService", "onRuntimePause but not running appId %s", new Object[] { getAppId() });
      AppMethodBeat.o(134580);
      return;
    }
    new com.tencent.mm.plugin.appbrand.page.k().ad(this.jDb);
    AppMethodBeat.o(134580);
  }
  
  protected void Dg()
  {
    AppMethodBeat.i(134585);
    EQ();
    aXT();
    AppMethodBeat.o(134585);
  }
  
  protected void Dh() {}
  
  public com.tencent.mm.plugin.appbrand.jsruntime.i EM()
  {
    AppMethodBeat.i(134594);
    com.tencent.mm.plugin.appbrand.jsruntime.c localc = new com.tencent.mm.plugin.appbrand.jsruntime.c((byte)0);
    AppMethodBeat.o(134594);
    return localc;
  }
  
  public Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> EN()
  {
    return null;
  }
  
  public JSONObject EP()
  {
    AppMethodBeat.i(134597);
    JSONObject localJSONObject = new JSONObject();
    d(localJSONObject);
    Object localObject1 = this.jDb.Fm();
    Object localObject2 = this.jDb.getAppConfig();
    if ((localObject1 == null) || (localObject2 == null))
    {
      localObject1 = new JSONObject();
      AppMethodBeat.o(134597);
      return localObject1;
    }
    if ((a.isDarkMode()) && (((a)localObject2).jYV != null) && (((a)localObject2).jYV.length() != 0)) {}
    for (localObject1 = ((a)localObject2).jYV;; localObject1 = ((a)localObject2).jYU)
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
          ae.e("MicroMsg.AppBrandService", localException.getMessage());
        }
      }
    }
    c(localJSONObject, "env", new JSONObject());
    localObject1 = new JSONObject();
    c((JSONObject)localObject1, "zIndex", Integer.valueOf(1000));
    c((JSONObject)localObject1, "viewId", Integer.valueOf(1));
    c(localJSONObject, "menuButtonInfo", localObject1);
    ae.i("MicroMsg.AppBrandService", "generateWxConfig(%s): %s", new Object[] { getAppId(), localJSONObject.toString() });
    AppMethodBeat.o(134597);
    return localJSONObject;
  }
  
  protected void EQ()
  {
    AppMethodBeat.i(134596);
    Object localObject = EP();
    final String str = this.jDb.getAppConfig().jZa;
    ae.i("MicroMsg.AppBrandService", "injectConfig start, hash=%d", new Object[] { Integer.valueOf(super.aXX()) });
    if (aYB().P(n.class) != null)
    {
      str = ((JSONObject)localObject).toString();
      ((n)aYB().P(n.class)).a("__native_custom_event__wxConfig_inject", str, 0, "", new n.a()
      {
        public final void a(n.b paramAnonymousb)
        {
          AppMethodBeat.i(176536);
          ae.i("MicroMsg.AppBrandService", "injectConfig end by AddonDirectEvaluation, cost=%dms, hash=%d", new Object[] { Long.valueOf(paramAnonymousb.cZH - paramAnonymousb.cZG), Integer.valueOf(r.this.aXX()) });
          r.this.jDg = new r.a((byte)0);
          r.this.jDg.jDl = str;
          r.this.jDg.jDm = paramAnonymousb.cZG;
          r.this.jDg.jDn = paramAnonymousb.cZH;
          r.this.jDg.hQS = paramAnonymousb;
          AppMethodBeat.o(176536);
        }
      });
      AppMethodBeat.o(134596);
      return;
    }
    final long l = bu.fpO();
    localObject = ((JSONObject)localObject).toString();
    str = String.format(Locale.ENGLISH, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);var __wxIndexPage = \"%s\";", new Object[] { localObject, str });
    if (aYB().P(com.tencent.mm.plugin.appbrand.jsruntime.v.class) != null)
    {
      ((com.tencent.mm.plugin.appbrand.jsruntime.v)aYB().P(com.tencent.mm.plugin.appbrand.jsruntime.v.class)).a(null, null, null, 0, str, new m.b()
      {
        public final void a(String paramAnonymousString, m.c paramAnonymousc)
        {
          AppMethodBeat.i(176537);
          ae.i("MicroMsg.AppBrandService", "injectConfig end by AddonV8, cost=%dms, hash=%d", new Object[] { Long.valueOf(paramAnonymousc.cZH - paramAnonymousc.cZG), Integer.valueOf(r.this.aXX()) });
          r.this.jDg = new r.a((byte)0);
          r.this.jDg.jDl = this.jDi;
          r.this.jDg.jDm = paramAnonymousc.cZG;
          r.this.jDg.jDn = paramAnonymousc.cZH;
          r.this.jDg.hQS = paramAnonymousc;
          AppMethodBeat.o(176537);
        }
      });
      AppMethodBeat.o(134596);
      return;
    }
    aYB().evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(134596);
  }
  
  public String ER()
  {
    return "";
  }
  
  public String ES()
  {
    return "";
  }
  
  protected w EV()
  {
    AppMethodBeat.i(134583);
    w localw = new w(this);
    AppMethodBeat.o(134583);
    return localw;
  }
  
  public final void OC()
  {
    AppMethodBeat.i(134577);
    biL();
    aXS();
    com.tencent.mm.plugin.appbrand.jsapi.i.a(this, aXY());
    this.jCY = true;
    Dh();
    if (aYB().P(com.tencent.mm.plugin.appbrand.jsruntime.r.class) != null) {
      aYB().P(com.tencent.mm.plugin.appbrand.jsruntime.r.class);
    }
    AppMethodBeat.o(134577);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    this.jDa = paramc;
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final boolean aXO()
  {
    return this.jCZ;
  }
  
  public final boolean aXP()
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
  
  public final boolean aXQ()
  {
    return this.jCY;
  }
  
  protected l aXR()
  {
    AppMethodBeat.i(176539);
    l locall = new l();
    AppMethodBeat.o(176539);
    return locall;
  }
  
  protected final void aXT()
  {
    Object localObject1 = null;
    AppMethodBeat.i(134586);
    synchronized (this.jDe)
    {
      if (this.jDf != null) {
        localObject1 = new LinkedList(this.jDf);
      }
      this.jDf = null;
      if (localObject1 != null)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          ??? = (aa)((Iterator)localObject1).next();
          super.c(((aa)???).dmp, ((aa)???).data, ((aa)???).src);
        }
      }
    }
    AppMethodBeat.o(134586);
  }
  
  public final Activity aXU()
  {
    AppMethodBeat.i(224483);
    Activity localActivity = au(Activity.class);
    AppMethodBeat.o(224483);
    return localActivity;
  }
  
  public final String aXV()
  {
    return "AppBrandService";
  }
  
  public final w aXW()
  {
    synchronized (this.jDc)
    {
      w localw = this.jDd;
      return localw;
    }
  }
  
  public final int aXX()
  {
    AppMethodBeat.i(224484);
    int i = super.aXX();
    AppMethodBeat.o(224484);
    return i;
  }
  
  public final JSONObject aXY()
  {
    AppMethodBeat.i(134598);
    JSONObject localJSONObject = super.aXY();
    AppMethodBeat.o(134598);
    return localJSONObject;
  }
  
  public final void aXZ()
  {
    AppMethodBeat.i(207737);
    if (this.jDh != null)
    {
      g localg = this.jDh;
      ae.i("MicroMsg.AppBrandServiceAdComponentView[AppBrandSplashAd]", "destroy view containers");
      if (localg.jFk != null)
      {
        al localal = localg.jFk;
        ae.i("MicroMsg.AppBrandWebViewCustomViewContainer", "clear: ");
        localal.mia.clear();
        localg.jFk = null;
      }
      if (localg.jFl != null)
      {
        localg.jFl.removeAllViews();
        localg.jFl = null;
      }
      this.jDh = null;
    }
    AppMethodBeat.o(207737);
  }
  
  public final <T extends z> T at(Class<T> paramClass)
  {
    AppMethodBeat.i(134592);
    if (this.jDb == null)
    {
      AppMethodBeat.o(134592);
      return null;
    }
    if (this.jDb.aWm() == null)
    {
      AppMethodBeat.o(134592);
      return null;
    }
    if (this.jDb.aWm() == null)
    {
      ae.w("MicroMsg.AppBrandService", "getCurrentPageView NULL PageContainer, appId=%s", new Object[] { getAppId() });
      if (!this.jDb.aWD())
      {
        paramClass = new IllegalStateException("getCurrentPageView NULL PageContainer");
        AppMethodBeat.o(134592);
        throw paramClass;
      }
      AppMethodBeat.o(134592);
      return null;
    }
    Object localObject = this.jDb.aWm().getCurrentPage();
    if (localObject == null)
    {
      ae.w("MicroMsg.AppBrandService", "getCurrentPageView NULL Page, appId=%s", new Object[] { getAppId() });
      AppMethodBeat.o(134592);
      return null;
    }
    localObject = ((q)localObject).getCurrentPageView();
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
    this.jDb.aWm().c(paramString1, paramString2, paramArrayOfInt);
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
      ae.w("MicroMsg.AppBrandService", "onRuntimeResume but not running, appId %s, willRelaunch %b", new Object[] { getAppId(), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(134581);
      return;
    }
    l locall = aXR();
    AppBrandRuntime localAppBrandRuntime = this.jDb;
    HashMap localHashMap = new HashMap();
    Object localObject = localAppBrandRuntime.Fn().Ei();
    if (localObject != null) {
      localHashMap.put("referrerInfo", localObject);
    }
    localHashMap.put("relaunch", Boolean.valueOf(paramBoolean));
    localHashMap.put("reLaunch", Boolean.valueOf(paramBoolean));
    if (paramBoolean) {}
    for (localObject = localAppBrandRuntime.aWx();; localObject = localAppBrandRuntime.aWm().getCurrentUrl())
    {
      localHashMap.put("rawPath", localObject);
      localHashMap.put("path", com.tencent.luggage.h.k.dt((String)localObject));
      localHashMap.put("query", com.tencent.luggage.h.k.du((String)localObject));
      ae.i("MicroMsg.AppBrandOnAppEnterForegroundEvent", "path: %s, query: %s, relaunch: %s, url: %s", new Object[] { localHashMap.get("path"), localHashMap.get("query"), localHashMap.get("relaunch"), localObject });
      com.tencent.luggage.h.d.k(localHashMap);
      localObject = new JSONObject(localHashMap);
      locall.a(localAppBrandRuntime, paramBoolean, (JSONObject)localObject);
      locall.PP(((JSONObject)localObject).toString()).g(localAppBrandRuntime.Ey()).bja();
      AppMethodBeat.o(134581);
      return;
    }
  }
  
  public void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(134588);
    if ((this.jCZ) && (e.K(com.tencent.mm.plugin.appbrand.ad.k.class) != null) && (((com.tencent.mm.plugin.appbrand.ad.k)e.K(com.tencent.mm.plugin.appbrand.ad.k.class)).Lo(paramString1)))
    {
      ae.i("MicroMsg.AppBrandService", "dispatch, ad related event:%s", new Object[] { paramString1 });
      super.c(paramString1, paramString2, paramInt);
      AppMethodBeat.o(134588);
      return;
    }
    if (this.jDf != null) {}
    synchronized (this.jDe)
    {
      if (this.jDf != null)
      {
        this.jDf.add(new aa(paramString1, paramString2, paramInt));
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
    this.jDb = null;
    super.cleanup();
    synchronized (this.jDc)
    {
      if (this.jDd == null) {
        break label110;
      }
      w localw = this.jDd;
      Iterator localIterator = localw.jDu.dav.values().iterator();
      if (localIterator.hasNext()) {
        ((com.tencent.mm.appbrand.v8.m)localIterator.next()).cZl.quit();
      }
    }
    localObject2.jzD = null;
    this.jDd = null;
    label110:
    AppMethodBeat.o(134595);
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134579);
    this.jDb = paramAppBrandRuntime;
    a(paramAppBrandRuntime.getWindowAndroid());
    paramAppBrandRuntime = s.a.jDq;
    int i = super.aXX();
    ae.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      List localList = (List)paramAppBrandRuntime.jDo.get(i);
      if (localList == null)
      {
        ae.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify listenerList empty");
        paramAppBrandRuntime.jDp.put(i, 1);
        return;
      }
      i = 0;
      while (i < localList.size())
      {
        ((s.b)localList.get(i)).aYa();
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
    if (aYB() != null) {
      if (aYB().P(com.tencent.mm.plugin.appbrand.jsruntime.k.class) == null) {
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
  
  public String jdMethod_do(String paramString)
  {
    return "";
  }
  
  public z getCurrentPageView()
  {
    AppMethodBeat.i(134591);
    z localz = at(z.class);
    AppMethodBeat.o(134591);
    return localz;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.jDb;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid()
  {
    return this.jDa;
  }
  
  public final void init()
  {
    AppMethodBeat.i(134584);
    super.init();
    aXS();
    this.mInitialized = true;
    f(this.jDb.jzM);
    Dg();
    this.jCZ = false;
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
    Object hQS;
    String jDl;
    long jDm;
    long jDn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r
 * JD-Core Version:    0.7.0.1
 */