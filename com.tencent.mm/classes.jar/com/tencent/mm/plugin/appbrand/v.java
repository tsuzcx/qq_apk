package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.webkit.ValueCallback;
import com.tencent.luggage.k.e;
import com.tencent.luggage.k.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.jsapi.ae;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.plugin.appbrand.m.n;
import com.tencent.mm.plugin.appbrand.m.n.a;
import com.tencent.mm.plugin.appbrand.m.n.b;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.p;
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

public class v
  extends g
{
  private volatile boolean mDestroyed;
  private volatile boolean mInitialized;
  private volatile boolean nxp;
  private volatile boolean nxq;
  public com.tencent.mm.plugin.appbrand.platform.window.c nxr;
  public volatile AppBrandRuntime nxs;
  private final Object nxt;
  private volatile ab nxu;
  private final Object nxv;
  private volatile LinkedList<ae> nxw;
  private final LinkedList<b> nxx;
  private a nxy;
  
  public v()
  {
    AppMethodBeat.i(134576);
    this.mDestroyed = false;
    this.mInitialized = false;
    this.nxp = false;
    this.nxq = false;
    this.nxr = new com.tencent.mm.plugin.appbrand.platform.window.a.o();
    this.nxt = new byte[0];
    this.nxv = new byte[0];
    this.nxx = new LinkedList();
    synchronized (this.nxv)
    {
      this.nxw = new LinkedList();
      AppMethodBeat.o(134576);
      return;
    }
  }
  
  private void bDX()
  {
    AppMethodBeat.i(134582);
    if (!Rt())
    {
      AppMethodBeat.o(134582);
      return;
    }
    synchronized (this.nxt)
    {
      if (this.nxu == null) {
        this.nxu = Rw();
      }
      synchronized (this.nxx)
      {
        Object localObject3 = new LinkedList(this.nxx);
        this.nxx.clear();
        localObject3 = ((LinkedList)localObject3).iterator();
        if (((Iterator)localObject3).hasNext()) {
          ((b)((Iterator)localObject3).next()).a(this.nxu);
        }
      }
    }
    AppMethodBeat.o(134582);
  }
  
  protected void Pp()
  {
    AppMethodBeat.i(134580);
    if (!isRunning())
    {
      Log.w("MicroMsg.AppBrandService", "onRuntimePause but not running appId %s", new Object[] { getAppId() });
      AppMethodBeat.o(134580);
      return;
    }
    new com.tencent.mm.plugin.appbrand.page.o().ae(this.nxs);
    AppMethodBeat.o(134580);
  }
  
  protected void Pu()
  {
    AppMethodBeat.i(134585);
    Rq();
    bDY();
    AppMethodBeat.o(134585);
  }
  
  protected void Pv() {}
  
  public i Rl()
  {
    AppMethodBeat.i(134594);
    com.tencent.mm.plugin.appbrand.m.c localc = new com.tencent.mm.plugin.appbrand.m.c((byte)0);
    AppMethodBeat.o(134594);
    return localc;
  }
  
  public Map<String, com.tencent.mm.plugin.appbrand.jsapi.o> Rm()
  {
    return null;
  }
  
  public JSONObject Ro()
  {
    AppMethodBeat.i(134597);
    JSONObject localJSONObject = new JSONObject();
    g(localJSONObject);
    Object localObject1 = this.nxs.Sp();
    Object localObject2 = this.nxs.getAppConfig();
    if ((localObject1 == null) || (localObject2 == null))
    {
      localObject1 = new JSONObject();
      AppMethodBeat.o(134597);
      return localObject1;
    }
    if ((((b)localObject2).isDarkMode()) && (((b)localObject2).nWg != null) && (((b)localObject2).nWg.length() != 0)) {}
    for (localObject1 = ((b)localObject2).nWg;; localObject1 = ((b)localObject2).nWf)
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
  
  public boolean Rp()
  {
    return false;
  }
  
  protected void Rq()
  {
    AppMethodBeat.i(134596);
    Object localObject = Ro();
    final String str = this.nxs.getAppConfig().nWl;
    Log.i("MicroMsg.AppBrandService", "injectConfig start, hash=%d", new Object[] { Integer.valueOf(getComponentId()) });
    if (getJsRuntime().Q(n.class) != null)
    {
      str = ((JSONObject)localObject).toString();
      ((n)getJsRuntime().Q(n.class)).a("__native_custom_event__wxConfig_inject", str, 0, "", new n.a()
      {
        public final void a(n.b paramAnonymousb)
        {
          AppMethodBeat.i(176536);
          Log.i("MicroMsg.AppBrandService", "injectConfig end by AddonDirectEvaluation, cost=%dms, hash=%d", new Object[] { Long.valueOf(paramAnonymousb.fiS - paramAnonymousb.fiR), Integer.valueOf(v.this.getComponentId()) });
          v.a(v.this, new v.a((byte)0));
          v.d(v.this).nxC = str;
          v.d(v.this).nxD = paramAnonymousb.fiR;
          v.d(v.this).nxE = paramAnonymousb.fiS;
          v.d(v.this).lCh = paramAnonymousb;
          AppMethodBeat.o(176536);
        }
      });
      AppMethodBeat.o(134596);
      return;
    }
    final long l = Util.nowMilliSecond();
    localObject = ((JSONObject)localObject).toString();
    str = String.format(Locale.ENGLISH, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);var __wxIndexPage = \"%s\";", new Object[] { localObject, str });
    if (getJsRuntime().Q(com.tencent.mm.plugin.appbrand.m.v.class) != null)
    {
      ((com.tencent.mm.plugin.appbrand.m.v)getJsRuntime().Q(com.tencent.mm.plugin.appbrand.m.v.class)).a(null, null, null, 0, str, new m.b()
      {
        public final void a(String paramAnonymousString, m.c paramAnonymousc)
        {
          AppMethodBeat.i(176537);
          Log.i("MicroMsg.AppBrandService", "injectConfig end by AddonV8, cost=%dms, hash=%d", new Object[] { Long.valueOf(paramAnonymousc.fiS - paramAnonymousc.fiR), Integer.valueOf(v.this.getComponentId()) });
          v.a(v.this, new v.a((byte)0));
          v.d(v.this).nxC = this.nxz;
          v.d(v.this).nxD = paramAnonymousc.fiR;
          v.d(v.this).nxE = paramAnonymousc.fiS;
          v.d(v.this).lCh = paramAnonymousc;
          AppMethodBeat.o(176537);
        }
      });
      AppMethodBeat.o(134596);
      return;
    }
    getJsRuntime().evaluateJavascript(str, new ValueCallback() {});
    AppMethodBeat.o(134596);
  }
  
  public String Rr()
  {
    return "";
  }
  
  public String Rs()
  {
    return "";
  }
  
  protected boolean Rt()
  {
    return true;
  }
  
  protected ab Rw()
  {
    AppMethodBeat.i(134583);
    ab localab = new ab(this);
    AppMethodBeat.o(134583);
    return localab;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(245417);
    synchronized (this.nxt)
    {
      if (this.nxu != null)
      {
        paramb.a(this.nxu);
        AppMethodBeat.o(245417);
        return;
      }
    }
    synchronized (this.nxx)
    {
      this.nxx.add(paramb);
      AppMethodBeat.o(245417);
      return;
      paramb = finally;
      AppMethodBeat.o(245417);
      throw paramb;
    }
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final void adD()
  {
    AppMethodBeat.i(134577);
    bPz();
    bDX();
    N(bEc());
    this.nxp = true;
    Pv();
    if (getJsRuntime().Q(com.tencent.mm.plugin.appbrand.m.r.class) != null) {
      getJsRuntime().Q(com.tencent.mm.plugin.appbrand.m.r.class);
    }
    AppMethodBeat.o(134577);
  }
  
  public final <T extends ad> T aw(Class<T> paramClass)
  {
    AppMethodBeat.i(134592);
    if (this.nxs == null)
    {
      AppMethodBeat.o(134592);
      return null;
    }
    if (this.nxs.bBX() == null)
    {
      AppMethodBeat.o(134592);
      return null;
    }
    if (this.nxs.bBX() == null)
    {
      Log.w("MicroMsg.AppBrandService", "getCurrentPageView NULL PageContainer, appId=%s", new Object[] { getAppId() });
      if (!this.nxs.bCo())
      {
        paramClass = new IllegalStateException("getCurrentPageView NULL PageContainer");
        AppMethodBeat.o(134592);
        throw paramClass;
      }
      AppMethodBeat.o(134592);
      return null;
    }
    Object localObject = this.nxs.bBX().getCurrentPage();
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
  
  public final <T extends Activity> T ax(Class<T> paramClass)
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
    this.nxr = paramc;
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(134589);
    if (!isRunning())
    {
      AppMethodBeat.o(134589);
      return;
    }
    this.nxs.bBX().c(paramString1, paramString2, paramArrayOfInt);
    AppMethodBeat.o(134589);
  }
  
  public final boolean bDU()
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
  
  public final boolean bDV()
  {
    return this.nxp;
  }
  
  protected p bDW()
  {
    AppMethodBeat.i(176539);
    p localp = new p();
    AppMethodBeat.o(176539);
    return localp;
  }
  
  protected final void bDY()
  {
    Object localObject1 = null;
    AppMethodBeat.i(134586);
    synchronized (this.nxv)
    {
      if (this.nxw != null) {
        localObject1 = new LinkedList(this.nxw);
      }
      this.nxw = null;
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
  
  public final Activity bDZ()
  {
    AppMethodBeat.i(292949);
    Activity localActivity = ax(Activity.class);
    AppMethodBeat.o(292949);
    return localActivity;
  }
  
  public final String bEa()
  {
    return "AppBrandService";
  }
  
  public final ab bEb()
  {
    AppMethodBeat.i(245437);
    if (!Rt())
    {
      AppMethodBeat.o(245437);
      return null;
    }
    synchronized (this.nxt)
    {
      ab localab = this.nxu;
      AppMethodBeat.o(245437);
      return localab;
    }
  }
  
  public final JSONObject bEc()
  {
    AppMethodBeat.i(134598);
    JSONObject localJSONObject = super.bEc();
    AppMethodBeat.o(134598);
    return localJSONObject;
  }
  
  public void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(134588);
    if (this.nxw != null) {}
    synchronized (this.nxv)
    {
      if (this.nxw != null)
      {
        this.nxw.add(new ae(paramString1, paramString2, paramInt));
        AppMethodBeat.o(134588);
        return;
      }
      super.c(paramString1, paramString2, paramInt);
      AppMethodBeat.o(134588);
      return;
    }
  }
  
  protected void ci(boolean paramBoolean)
  {
    AppMethodBeat.i(134581);
    if (!isRunning())
    {
      Log.w("MicroMsg.AppBrandService", "onRuntimeResume but not running, appId %s, willRelaunch %b", new Object[] { getAppId(), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(134581);
      return;
    }
    p localp = bDW();
    AppBrandRuntime localAppBrandRuntime = this.nxs;
    HashMap localHashMap = new HashMap();
    Object localObject = localAppBrandRuntime.Sq().QA();
    if (localObject != null) {
      localHashMap.put("referrerInfo", localObject);
    }
    localHashMap.put("relaunch", Boolean.valueOf(paramBoolean));
    localHashMap.put("reLaunch", Boolean.valueOf(paramBoolean));
    if (paramBoolean) {}
    for (localObject = localAppBrandRuntime.bCi();; localObject = localAppBrandRuntime.bBX().getCurrentUrl())
    {
      localHashMap.put("rawPath", localObject);
      localHashMap.put("path", l.eo((String)localObject));
      localHashMap.put("query", l.ep((String)localObject));
      Log.i("MicroMsg.AppBrandOnAppEnterForegroundEvent", "path: %s, query: %s, relaunch: %s, url: %s", new Object[] { localHashMap.get("path"), localHashMap.get("query"), localHashMap.get("relaunch"), localObject });
      e.e(localHashMap);
      localObject = new JSONObject(localHashMap);
      localp.a(localAppBrandRuntime, paramBoolean, (JSONObject)localObject);
      localp.agT(((JSONObject)localObject).toString()).i(localAppBrandRuntime.QW()).bPO();
      AppMethodBeat.o(134581);
      return;
    }
  }
  
  public void cleanup()
  {
    AppMethodBeat.i(134595);
    this.mInitialized = false;
    this.mDestroyed = true;
    this.nxs = null;
    super.cleanup();
    synchronized (this.nxt)
    {
      if (this.nxu != null)
      {
        ab localab = this.nxu;
        localab.nxS.exit();
        localab.ntA = null;
        localab.nxV.clear();
        this.nxu = null;
      }
      AppMethodBeat.o(134595);
      return;
    }
  }
  
  @Deprecated
  public final void cp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134587);
    super.c(paramString1, paramString2, 0);
    AppMethodBeat.o(134587);
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134579);
    this.nxs = paramAppBrandRuntime;
    b(paramAppBrandRuntime.getWindowAndroid());
    if (Rt())
    {
      bDX();
      if (!Rp())
      {
        paramAppBrandRuntime = bEb();
        paramAppBrandRuntime.nxX.set(true);
        Log.i("MicroMsg.AppBrandWorkerContainer", "onRuntimeReady");
        paramAppBrandRuntime.nxS.acr();
        paramAppBrandRuntime.bEf();
      }
    }
    paramAppBrandRuntime = w.a.nxH;
    int i = getComponentId();
    Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      List localList = (List)paramAppBrandRuntime.nxF.get(i);
      if (localList == null)
      {
        Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify listenerList empty");
        paramAppBrandRuntime.nxG.put(i, 1);
        return;
      }
      i = 0;
      while (i < localList.size())
      {
        ((w.b)localList.get(i)).acr();
        i += 1;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(134579);
    }
  }
  
  public String ea(String paramString)
  {
    return "";
  }
  
  public void g(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(134599);
    super.g(paramJSONObject);
    if (getJsRuntime() != null) {
      if (getJsRuntime().Q(k.class) == null) {
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
  
  public final int getComponentId()
  {
    AppMethodBeat.i(245438);
    int i = super.getComponentId();
    AppMethodBeat.o(245438);
    return i;
  }
  
  public ad getCurrentPageView()
  {
    AppMethodBeat.i(134591);
    ad localad = aw(ad.class);
    AppMethodBeat.o(134591);
    return localad;
  }
  
  public AppBrandRuntime getRuntime()
  {
    return this.nxs;
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.c getWindowAndroid()
  {
    return this.nxr;
  }
  
  public final void init()
  {
    AppMethodBeat.i(134584);
    super.init();
    bDX();
    this.mInitialized = true;
    f(this.nxs.ntK);
    Pu();
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
    Object lCh;
    String nxC;
    long nxD;
    long nxE;
  }
  
  static abstract interface b
  {
    public abstract void a(ab paramab);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v
 * JD-Core Version:    0.7.0.1
 */