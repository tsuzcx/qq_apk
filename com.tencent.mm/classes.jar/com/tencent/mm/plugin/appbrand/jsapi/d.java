package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.luggage.b.b;
import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.b;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.plugin.appbrand.v.n;
import com.tencent.mm.plugin.appbrand.v.n.a;
import com.tencent.mm.plugin.appbrand.v.n.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;
import org.json.JSONObject;

public abstract class d
  implements c
{
  static Map<Class<? extends b>, b> geM;
  static Map<Class<? extends com.tencent.luggage.b.d>, com.tencent.luggage.b.d> geN;
  Handler bhG;
  private final AtomicInteger bhR = new AtomicInteger(0);
  private k fyt = new com.tencent.mm.plugin.appbrand.appstorage.e();
  private final LinkedHashSet<Object> fyv;
  private f geH;
  private final h geI;
  private final Map<String, i> geJ = new HashMap();
  public c.b geK;
  private final LinkedHashSet<g> geL;
  private final SparseArray<d.a> geO = new SparseArray();
  private com.tencent.mm.plugin.appbrand.widget.b.i geP = new d.5(this);
  
  public d()
  {
    Object localObject = new HandlerThread("AppBrandAsyncJSThread");
    ((HandlerThread)localObject).start();
    this.bhG = new Handler(((HandlerThread)localObject).getLooper());
    this.geL = new LinkedHashSet();
    this.fyv = new LinkedHashSet();
    geM = new ConcurrentHashMap();
    geN = new ConcurrentHashMap();
    this.geI = new h(this);
    localObject = new d.1(this);
    if (com.tencent.luggage.bridge.a.a.bhU != null) {
      com.tencent.luggage.bridge.a.a.bhU.a((a.a)localObject);
    }
  }
  
  private static String K(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errMsg", paramString1 + ":" + paramString2);
    return new JSONObject(localHashMap).toString();
  }
  
  private String a(i parami, String paramString, int paramInt, boolean paramBoolean)
  {
    if (!isRunning())
    {
      parami = K(parami.getName(), "fail:interrupted");
      return parami;
    }
    if (this.geK == null) {}
    for (Object localObject = null;; localObject = this.geK.a(parami, paramString, paramInt, new d.4(this, parami, paramString, paramInt, paramBoolean)))
    {
      if (localObject == null) {
        break label95;
      }
      parami = (i)localObject;
      if (paramBoolean) {
        break;
      }
      parami = (i)localObject;
      if ("".equals(localObject)) {
        break;
      }
      C(paramInt, (String)localObject);
      return localObject;
    }
    label95:
    paramString = tJ(paramString);
    if (paramString == null) {}
    for (paramString = parami.h("fail:invalid data", null);; paramString = a(parami, paramString, paramInt, paramBoolean))
    {
      if (this.geK != null) {
        this.geK.a(parami, paramInt, paramString);
      }
      if (!paramBoolean) {
        break label161;
      }
      parami = paramString;
      if (!bk.bl(paramString)) {
        break;
      }
      return "{}";
    }
    label161:
    if (paramString != null) {
      C(paramInt, paramString);
    }
    return "";
  }
  
  private String a(i parami, JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      return ((s)parami).a(this, paramJSONObject);
    }
    catch (ClassCastException paramJSONObject) {}
    if (n.a(ahK(), paramJSONObject, (n.a)D(n.a.class)) == n.b.hlG) {}
    for (String str = parami.h("fail:convert native buffer parameter fail. native buffer exceed size limit.", null);; str = null)
    {
      if (str == null) {
        ((a)parami).a(this, paramJSONObject, paramInt);
      }
      return str;
    }
    return parami.h("fail:internal error invalid js component", null);
  }
  
  private d.a le(int paramInt)
  {
    synchronized (this.geO)
    {
      d.a locala = (d.a)this.geO.get(paramInt);
      return locala;
    }
  }
  
  private static JSONObject tJ(String paramString)
  {
    String str = paramString;
    try
    {
      if (bk.bl(paramString)) {
        str = "{}";
      }
      paramString = new JSONObject(str);
      return paramString;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.AppBrandComponent", paramString.getMessage());
    }
    return null;
  }
  
  public void C(int paramInt, String paramString)
  {
    if (!isRunning()) {
      y.e("MicroMsg.AppBrandComponent", "callback but destroyed, callbackId %d", new Object[] { Integer.valueOf(paramInt) });
    }
    String str;
    do
    {
      return;
      str = paramString;
      if (bk.bl(paramString)) {
        str = "{}";
      }
      y.d("MicroMsg.AppBrandComponent", "callbackId: %d, data size: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(str.length()) });
      paramString = le(paramInt);
      if (paramString == null)
      {
        y.e("MicroMsg.AppBrandComponent", "callbackid = [%d] This is a Sync Api, No callback runtime stored.", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      paramString.geX.evaluateJavascript(String.format("typeof WeixinJSCoreAndroid !== 'undefined' && WeixinJSCoreAndroid.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramString.id), str }), null);
    } while (this.geK == null);
    this.geK.x(paramInt, str);
  }
  
  public <T extends g> T D(Class<T> paramClass)
  {
    Object localObject2 = null;
    Iterator localIterator = this.geL.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (g)localIterator.next();
    } while (!paramClass.isInstance(localObject1));
    localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = (g)paramClass.newInstance();
      if (localObject2 != null)
      {
        bool = true;
        Assert.assertTrue(bool);
        this.geL.add(localObject2);
        return localObject2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrandComponent", "Make sure %s has default constructor", new Object[] { paramClass.getName() });
        Object localObject3 = localObject1;
        continue;
        boolean bool = false;
      }
    }
  }
  
  public k Zl()
  {
    return this.fyt;
  }
  
  public com.tencent.mm.plugin.appbrand.widget.b.i Zm()
  {
    return this.geP;
  }
  
  public int a(f paramf, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    int i = this.bhR.incrementAndGet();
    synchronized (this.geO)
    {
      this.geO.put(i, new d.a(paramf, paramInt));
      return i;
    }
  }
  
  public void a(ac paramac)
  {
    if (this.geK == null)
    {
      i(paramac.getName(), paramac.getData(), paramac.gfT);
      return;
    }
    this.geK.a(paramac, new d.2(this, paramac));
  }
  
  public void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    i(paramString1, paramString2, 0);
  }
  
  public abstract f aat();
  
  public abstract Map<String, i> aau();
  
  public final int ahJ()
  {
    return hashCode();
  }
  
  public final f ahK()
  {
    synchronized (this.geI)
    {
      f localf = this.geH;
      return localf;
    }
  }
  
  public final Handler ahL()
  {
    return this.bhG;
  }
  
  public final void ahM()
  {
    synchronized (this.geI)
    {
      if (this.geH == null)
      {
        this.geH = aat();
        this.geH.addJavascriptInterface(this.geI, "WeixinJSCore");
      }
      return;
    }
  }
  
  public final void b(ac paramac)
  {
    a(paramac.getName(), paramac.getData(), null);
  }
  
  public final void bw(String paramString1, String paramString2)
  {
    i(paramString1, paramString2, 0);
  }
  
  public final void c(Collection<g> paramCollection)
  {
    this.geL.addAll(paramCollection);
  }
  
  public void cleanup()
  {
    synchronized (this.geO)
    {
      this.geO.clear();
      this.bhG.getLooper().quit();
      this.geI.gfa.clear();
    }
    synchronized (this.geI)
    {
      f localf = this.geH;
      if (localf != null) {
        localf.destroy();
      }
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public abstract Context getContext();
  
  public final <T extends b> T i(Class<T> paramClass)
  {
    Object localObject2 = (b)geM.get(paramClass);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = com.tencent.luggage.b.e.i(paramClass);
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (paramClass.isAssignableFrom(localObject1.getClass())) {}
    }
    else
    {
      localObject2 = null;
    }
    return localObject2;
  }
  
  public void i(String paramString1, String paramString2, int paramInt)
  {
    if (!isRunning()) {
      return;
    }
    bc.a(ahK(), paramString1, paramString2, paramInt);
  }
  
  public void init()
  {
    ahM();
    this.geJ.putAll(aau());
  }
  
  public abstract boolean isRunning();
  
  public final String n(String paramString1, String paramString2, int paramInt)
  {
    paramInt = a(this.geH, paramInt);
    i locali = (i)this.geJ.get(paramString1);
    if (locali == null)
    {
      C(paramInt, K(paramString1, "fail:not supported"));
      return "fail:not supported";
    }
    System.currentTimeMillis();
    if ((locali instanceof s)) {
      return a(locali, paramString2, paramInt, true);
    }
    this.bhG.post(new d.3(this, locali, paramString2, paramInt));
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d
 * JD-Core Version:    0.7.0.1
 */