package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.ad.f;
import com.tencent.mm.plugin.appbrand.ad.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.jsapi.ae;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.n.a;
import com.tencent.mm.plugin.appbrand.m.n.b;
import com.tencent.mm.plugin.appbrand.m.r;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ao;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class s
  extends d
{
  private volatile boolean kDZ;
  public volatile boolean kEa;
  public com.tencent.mm.plugin.appbrand.platform.window.c kEb;
  public volatile AppBrandRuntime kEc;
  private final Object kEd;
  private volatile x kEe;
  private final Object kEf;
  private volatile LinkedList<ae> kEg;
  a kEh;
  g kEi;
  private volatile boolean mDestroyed;
  private volatile boolean mInitialized;
  
  public s()
  {
    AppMethodBeat.i(134576);
    this.mDestroyed = false;
    this.mInitialized = false;
    this.kDZ = false;
    this.kEa = false;
    this.kEb = new com.tencent.mm.plugin.appbrand.platform.window.a.o();
    this.kEd = new byte[0];
    this.kEf = new byte[0];
    synchronized (this.kEf)
    {
      this.kEg = new LinkedList();
      AppMethodBeat.o(134576);
      return;
    }
  }
  
  private void bsZ()
  {
    AppMethodBeat.i(134582);
    synchronized (this.kEd)
    {
      if (this.kEe == null) {
        this.kEe = Ox();
      }
      AppMethodBeat.o(134582);
      return;
    }
  }
  
  protected void MC()
  {
    AppMethodBeat.i(134585);
    Os();
    bta();
    AppMethodBeat.o(134585);
  }
  
  protected void MD() {}
  
  protected void Mx()
  {
    AppMethodBeat.i(134580);
    if (!isRunning())
    {
      Log.w("MicroMsg.AppBrandService", "onRuntimePause but not running appId %s", new Object[] { getAppId() });
      AppMethodBeat.o(134580);
      return;
    }
    new com.tencent.mm.plugin.appbrand.page.n().ae(this.kEc);
    AppMethodBeat.o(134580);
  }
  
  public i Oo()
  {
    AppMethodBeat.i(134594);
    com.tencent.mm.plugin.appbrand.m.c localc = new com.tencent.mm.plugin.appbrand.m.c((byte)0);
    AppMethodBeat.o(134594);
    return localc;
  }
  
  public Map<String, p> Op()
  {
    return null;
  }
  
  public JSONObject Or()
  {
    AppMethodBeat.i(134597);
    JSONObject localJSONObject = new JSONObject();
    d(localJSONObject);
    Object localObject1 = this.kEc.OT();
    Object localObject2 = this.kEc.getAppConfig();
    if ((localObject1 == null) || (localObject2 == null))
    {
      localObject1 = new JSONObject();
      AppMethodBeat.o(134597);
      return localObject1;
    }
    if ((b.isDarkMode()) && (((b)localObject2).lbX != null) && (((b)localObject2).lbX.length() != 0)) {}
    for (localObject1 = ((b)localObject2).lbX;; localObject1 = ((b)localObject2).lbW)
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
    c(localJSONObject, "env", new JSONObject());
    localObject1 = new JSONObject();
    c((JSONObject)localObject1, "zIndex", Integer.valueOf(1000));
    c((JSONObject)localObject1, "viewId", Integer.valueOf(1));
    c(localJSONObject, "menuButtonInfo", localObject1);
    AppMethodBeat.o(134597);
    return localJSONObject;
  }
  
  protected void Os()
  {
    AppMethodBeat.i(134596);
    Object localObject = Or();
    final String str = this.kEc.getAppConfig().lcc;
    Log.i("MicroMsg.AppBrandService", "injectConfig start, hash=%d", new Object[] { Integer.valueOf(getComponentId()) });
    if (getJsRuntime().R(com.tencent.mm.plugin.appbrand.m.n.class) != null)
    {
      str = ((JSONObject)localObject).toString();
      ((com.tencent.mm.plugin.appbrand.m.n)getJsRuntime().R(com.tencent.mm.plugin.appbrand.m.n.class)).a("__native_custom_event__wxConfig_inject", str, 0, "", new n.a()
      {
        public final void a(n.b paramAnonymousb)
        {
          AppMethodBeat.i(176536);
          Log.i("MicroMsg.AppBrandService", "injectConfig end by AddonDirectEvaluation, cost=%dms, hash=%d", new Object[] { Long.valueOf(paramAnonymousb.dql - paramAnonymousb.dqk), Integer.valueOf(s.this.getComponentId()) });
          s.this.kEh = new s.a((byte)0);
          s.this.kEh.kEm = str;
          s.this.kEh.kEn = paramAnonymousb.dqk;
          s.this.kEh.kEo = paramAnonymousb.dql;
          s.this.kEh.iMa = paramAnonymousb;
          AppMethodBeat.o(176536);
        }
      });
      AppMethodBeat.o(134596);
      return;
    }
    final long l = Util.nowMilliSecond();
    localObject = ((JSONObject)localObject).toString();
    str = String.format(Locale.ENGLISH, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);var __wxIndexPage = \"%s\";", new Object[] { localObject, str });
    if (getJsRuntime().R(com.tencent.mm.plugin.appbrand.m.v.class) != null)
    {
      ((com.tencent.mm.plugin.appbrand.m.v)getJsRuntime().R(com.tencent.mm.plugin.appbrand.m.v.class)).a(null, null, null, 0, str, new m.b()
      {
        public final void a(String paramAnonymousString, m.c paramAnonymousc)
        {
          AppMethodBeat.i(176537);
          Log.i("MicroMsg.AppBrandService", "injectConfig end by AddonV8, cost=%dms, hash=%d", new Object[] { Long.valueOf(paramAnonymousc.dql - paramAnonymousc.dqk), Integer.valueOf(s.this.getComponentId()) });
          s.this.kEh = new s.a((byte)0);
          s.this.kEh.kEm = this.kEj;
          s.this.kEh.kEn = paramAnonymousc.dqk;
          s.this.kEh.kEo = paramAnonymousc.dql;
          s.this.kEh.iMa = paramAnonymousc;
          AppMethodBeat.o(176537);
        }
      });
      AppMethodBeat.o(134596);
      return;
    }
    getJsRuntime().evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(134596);
  }
  
  public String Ot()
  {
    return "";
  }
  
  public String Ou()
  {
    return "";
  }
  
  protected x Ox()
  {
    AppMethodBeat.i(134583);
    x localx = new x(this);
    AppMethodBeat.o(134583);
    return localx;
  }
  
  public final void YU()
  {
    AppMethodBeat.i(134577);
    bEb();
    bsZ();
    com.tencent.mm.plugin.appbrand.jsapi.l.a(this, bte());
    this.kDZ = true;
    MD();
    if (getJsRuntime().R(r.class) != null) {
      getJsRuntime().R(r.class);
    }
    AppMethodBeat.o(134577);
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final <T extends ac> T ax(Class<T> paramClass)
  {
    AppMethodBeat.i(134592);
    if (this.kEc == null)
    {
      AppMethodBeat.o(134592);
      return null;
    }
    if (this.kEc.brh() == null)
    {
      AppMethodBeat.o(134592);
      return null;
    }
    if (this.kEc.brh() == null)
    {
      Log.w("MicroMsg.AppBrandService", "getCurrentPageView NULL PageContainer, appId=%s", new Object[] { getAppId() });
      if (!this.kEc.bry())
      {
        paramClass = new IllegalStateException("getCurrentPageView NULL PageContainer");
        AppMethodBeat.o(134592);
        throw paramClass;
      }
      AppMethodBeat.o(134592);
      return null;
    }
    Object localObject = this.kEc.brh().getCurrentPage();
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrandService", "getCurrentPageView NULL Page, appId=%s", new Object[] { getAppId() });
      AppMethodBeat.o(134592);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.page.t)localObject).getCurrentPageView();
    if (paramClass.isInstance(localObject))
    {
      AppMethodBeat.o(134592);
      return localObject;
    }
    AppMethodBeat.o(134592);
    return null;
  }
  
  public final <T extends Activity> T ay(Class<T> paramClass)
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
  
  public void b(com.tencent.mm.plugin.appbrand.platform.window.c paramc)
  {
    this.kEb = paramc;
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134589);
    if (!isRunning())
    {
      AppMethodBeat.o(134589);
      return;
    }
    this.kEc.brh().c(paramString1, paramString2, paramArrayOfInt);
    AppMethodBeat.o(134589);
  }
  
  protected void bX(boolean paramBoolean)
  {
    AppMethodBeat.i(134581);
    if (!isRunning())
    {
      Log.w("MicroMsg.AppBrandService", "onRuntimeResume but not running, appId %s, willRelaunch %b", new Object[] { getAppId(), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(134581);
      return;
    }
    com.tencent.mm.plugin.appbrand.page.o localo = bsY();
    AppBrandRuntime localAppBrandRuntime = this.kEc;
    HashMap localHashMap = new HashMap();
    Object localObject = localAppBrandRuntime.OU().NF();
    if (localObject != null) {
      localHashMap.put("referrerInfo", localObject);
    }
    localHashMap.put("relaunch", Boolean.valueOf(paramBoolean));
    localHashMap.put("reLaunch", Boolean.valueOf(paramBoolean));
    if (paramBoolean) {}
    for (localObject = localAppBrandRuntime.brs();; localObject = localAppBrandRuntime.brh().getCurrentUrl())
    {
      localHashMap.put("rawPath", localObject);
      localHashMap.put("path", com.tencent.luggage.h.l.dM((String)localObject));
      localHashMap.put("query", com.tencent.luggage.h.l.dN((String)localObject));
      Log.i("MicroMsg.AppBrandOnAppEnterForegroundEvent", "path: %s, query: %s, relaunch: %s, url: %s", new Object[] { localHashMap.get("path"), localHashMap.get("query"), localHashMap.get("relaunch"), localObject });
      com.tencent.luggage.h.e.m(localHashMap);
      localObject = new JSONObject(localHashMap);
      localo.a(localAppBrandRuntime, paramBoolean, (JSONObject)localObject);
      localo.Zg(((JSONObject)localObject).toString()).g(localAppBrandRuntime.NY()).bEo();
      AppMethodBeat.o(134581);
      return;
    }
  }
  
  public final boolean bsV()
  {
    return this.kEa;
  }
  
  public final boolean bsW()
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
  
  public final boolean bsX()
  {
    return this.kDZ;
  }
  
  protected com.tencent.mm.plugin.appbrand.page.o bsY()
  {
    AppMethodBeat.i(176539);
    com.tencent.mm.plugin.appbrand.page.o localo = new com.tencent.mm.plugin.appbrand.page.o();
    AppMethodBeat.o(176539);
    return localo;
  }
  
  protected final void bta()
  {
    Object localObject1 = null;
    AppMethodBeat.i(134586);
    synchronized (this.kEf)
    {
      if (this.kEg != null) {
        localObject1 = new LinkedList(this.kEg);
      }
      this.kEg = null;
      if (localObject1 != null)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          ??? = (ae)((Iterator)localObject1).next();
          super.c(((ae)???).event, ((ae)???).data, ((ae)???).src);
        }
      }
    }
    AppMethodBeat.o(134586);
  }
  
  public final Activity btb()
  {
    AppMethodBeat.i(258639);
    Activity localActivity = ay(Activity.class);
    AppMethodBeat.o(258639);
    return localActivity;
  }
  
  public final String btc()
  {
    return "AppBrandService";
  }
  
  public final x btd()
  {
    synchronized (this.kEd)
    {
      x localx = this.kEe;
      return localx;
    }
  }
  
  public final JSONObject bte()
  {
    AppMethodBeat.i(134598);
    JSONObject localJSONObject = super.bte();
    AppMethodBeat.o(134598);
    return localJSONObject;
  }
  
  public final void btf()
  {
    AppMethodBeat.i(219270);
    if (this.kEi != null)
    {
      g localg = this.kEi;
      Log.i("MicroMsg.AppBrandServiceAdComponentView[AppBrandSplashAd]", "destroy view containers");
      if (localg.kGU != null)
      {
        localg.kGU.clear();
        localg.kGU = null;
      }
      if (localg.kGV != null)
      {
        localg.kGV.removeAllViews();
        localg.kGV = null;
      }
      this.kEi = null;
    }
    AppMethodBeat.o(219270);
  }
  
  public void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(134588);
    if ((this.kEa) && (com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.ad.k.class) != null) && (((com.tencent.mm.plugin.appbrand.ad.k)com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.ad.k.class)).Ux(paramString1)))
    {
      Log.i("MicroMsg.AppBrandService", "dispatch, ad related event:%s", new Object[] { paramString1 });
      super.c(paramString1, paramString2, paramInt);
      AppMethodBeat.o(134588);
      return;
    }
    if (this.kEg != null) {}
    synchronized (this.kEf)
    {
      if (this.kEg != null)
      {
        this.kEg.add(new ae(paramString1, paramString2, paramInt));
        AppMethodBeat.o(134588);
        return;
      }
      super.c(paramString1, paramString2, paramInt);
      AppMethodBeat.o(134588);
      return;
    }
  }
  
  @Deprecated
  public final void ck(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134587);
    super.c(paramString1, paramString2, 0);
    AppMethodBeat.o(134587);
  }
  
  public void cleanup()
  {
    AppMethodBeat.i(134595);
    this.mInitialized = false;
    this.mDestroyed = true;
    this.kEc = null;
    super.cleanup();
    synchronized (this.kEd)
    {
      if (this.kEe == null) {
        break label110;
      }
      x localx = this.kEe;
      Iterator localIterator = localx.kEz.dqZ.values().iterator();
      if (localIterator.hasNext()) {
        ((m)localIterator.next()).dpQ.quit();
      }
    }
    localObject2.kAr = null;
    this.kEe = null;
    label110:
    AppMethodBeat.o(134595);
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134579);
    this.kEc = paramAppBrandRuntime;
    b(paramAppBrandRuntime.getWindowAndroid());
    paramAppBrandRuntime = t.a.kEr;
    int i = getComponentId();
    Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      List localList = (List)paramAppBrandRuntime.kEp.get(i);
      if (localList == null)
      {
        Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify listenerList empty");
        paramAppBrandRuntime.kEq.put(i, 1);
        return;
      }
      i = 0;
      while (i < localList.size())
      {
        ((t.b)localList.get(i)).btg();
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
    if (getJsRuntime() != null) {
      if (getJsRuntime().R(com.tencent.mm.plugin.appbrand.m.k.class) == null) {
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
  
  public String dG(String paramString)
  {
    return "";
  }
  
  public final int getComponentId()
  {
    AppMethodBeat.i(219269);
    int i = super.getComponentId();
    AppMethodBeat.o(219269);
    return i;
  }
  
  public ac getCurrentPageView()
  {
    AppMethodBeat.i(134591);
    ac localac = ax(ac.class);
    AppMethodBeat.o(134591);
    return localac;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.kEc;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid()
  {
    return this.kEb;
  }
  
  public final void init()
  {
    AppMethodBeat.i(134584);
    super.init();
    bsZ();
    this.mInitialized = true;
    f(this.kEc.kAA);
    MC();
    this.kEa = false;
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
    Object iMa;
    String kEm;
    long kEn;
    long kEo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s
 * JD-Core Version:    0.7.0.1
 */