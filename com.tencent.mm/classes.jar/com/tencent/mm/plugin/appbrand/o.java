package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.i.h;
import com.tencent.mm.plugin.appbrand.page.e;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public class o
  extends d
{
  private volatile boolean dNk = false;
  private i fzT;
  public s fzU;
  protected LinkedList<o.a> fzV = new LinkedList();
  public String mAppId;
  
  public static void a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    try
    {
      paramJSONObject.put(paramString, paramObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      y.e("MicroMsg.AppBrandService", paramJSONObject.getMessage());
    }
  }
  
  private void aaq()
  {
    if (this.fzU == null) {
      this.fzU = aar();
    }
  }
  
  public final <T extends q> T E(Class<T> paramClass)
  {
    if (this.fzT == null) {}
    Object localObject;
    do
    {
      do
      {
        return null;
        localObject = this.fzT.Zz().getCurrentPage();
      } while (localObject == null);
      localObject = ((com.tencent.mm.plugin.appbrand.page.k)localObject).getCurrentPageView();
    } while (!paramClass.isInstance(localObject));
    return localObject;
  }
  
  public final void EV()
  {
    ahM();
    aaq();
    y.d("MicroMsg.AppBrandService", "preInjectConfig");
    JSONObject localJSONObject = aax();
    ahK().evaluateJavascript(String.format("var __wxConfig = %s;", new Object[] { localJSONObject.toString() }), null);
    aao();
    if (ahK().I(com.tencent.mm.plugin.appbrand.i.k.class) != null) {
      ((com.tencent.mm.plugin.appbrand.i.k)ahK().I(com.tencent.mm.plugin.appbrand.i.k.class)).setJsRuntimeTitle("https://servicewechat.com/preload/js-engine");
    }
  }
  
  public final <T extends Activity> T F(Class<T> paramClass)
  {
    if (E(q.class) == null) {}
    for (Context localContext = getContext(); paramClass.isInstance(localContext); localContext = E(q.class).mContext) {
      return (Activity)localContext;
    }
    return null;
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    this.fzT.Zz().c(paramString1, paramString2, paramArrayOfInt);
  }
  
  @Deprecated
  protected final void aX(String paramString1, String paramString2)
  {
    super.i(paramString1, paramString2, 0);
  }
  
  public final boolean aan()
  {
    return getRuntime() == null;
  }
  
  public void aao() {}
  
  protected void aap()
  {
    new e().u(this.fzT);
  }
  
  protected s aar()
  {
    return new s(this);
  }
  
  public final void aas()
  {
    try
    {
      Iterator localIterator = this.fzV.iterator();
      while (localIterator.hasNext())
      {
        o.a locala = (o.a)localIterator.next();
        super.i(locala.bGt, locala.data, locala.src);
      }
      this.fzV = null;
    }
    finally {}
  }
  
  public com.tencent.mm.plugin.appbrand.i.f aat()
  {
    return new com.tencent.mm.plugin.appbrand.i.a();
  }
  
  public Map<String, com.tencent.mm.plugin.appbrand.jsapi.i> aau()
  {
    return new HashMap();
  }
  
  public void aav()
  {
    JSONObject localJSONObject = aaw();
    String str = this.fzT.getAppConfig().fNJ;
    ahK().evaluateJavascript(String.format(";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);var __wxIndexPage = \"%s\";", new Object[] { localJSONObject.toString(), str }), null);
  }
  
  public JSONObject aaw()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = this.fzT.ZB();
    Object localObject2 = this.fzT.getAppConfig();
    if ((localObject1 == null) || (localObject2 == null)) {
      return new JSONObject();
    }
    localObject1 = ((com.tencent.mm.plugin.appbrand.config.a)localObject2).fNI;
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
        y.e("MicroMsg.AppBrandService", localException.getMessage());
      }
    }
    i(localJSONObject);
    a(localJSONObject, "appType", Integer.valueOf(this.fzT.ZA().bFB));
    a(localJSONObject, "debug", Boolean.valueOf(this.fzT.ZB().fPN));
    a(localJSONObject, "env", new JSONObject());
    h(localJSONObject);
    return localJSONObject;
  }
  
  public final JSONObject aax()
  {
    JSONObject localJSONObject = new JSONObject();
    a(localJSONObject, "preload", Boolean.valueOf(true));
    i(localJSONObject);
    return localJSONObject;
  }
  
  public String aay()
  {
    return "";
  }
  
  public String aaz()
  {
    return "";
  }
  
  public void cE(boolean paramBoolean)
  {
    new com.tencent.mm.plugin.appbrand.page.f().a(this.fzT, paramBoolean);
  }
  
  public void cleanup()
  {
    super.cleanup();
    this.dNk = false;
  }
  
  public void g(i parami)
  {
    this.fzT = parami;
    this.mAppId = parami.mAppId;
  }
  
  public final String getAppId()
  {
    return this.mAppId;
  }
  
  public final Context getContext()
  {
    if (this.fzT == null) {
      return ae.getContext();
    }
    return this.fzT.getContext();
  }
  
  public i getRuntime()
  {
    return this.fzT;
  }
  
  public void h(JSONObject paramJSONObject) {}
  
  public void i(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      if (this.fzV != null)
      {
        this.fzV.add(new o.a(paramString1, paramString2, paramInt));
        return;
      }
      super.i(paramString1, paramString2, paramInt);
      return;
    }
    finally {}
  }
  
  public void i(JSONObject paramJSONObject)
  {
    a(paramJSONObject, "platform", "android");
    if (ahK() != null) {
      if (ahK().I(h.class) == null) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      a(paramJSONObject, "nativeBufferEnabled", Boolean.valueOf(bool));
      a(paramJSONObject, "system", "Android " + Build.VERSION.RELEASE);
      return;
    }
  }
  
  public final void init()
  {
    super.init();
    aaq();
    this.dNk = true;
    c(this.fzT.fyu);
    pT();
    if (ahK().I(com.tencent.mm.plugin.appbrand.i.k.class) != null) {
      ((com.tencent.mm.plugin.appbrand.i.k)ahK().I(com.tencent.mm.plugin.appbrand.i.k.class)).setJsRuntimeTitle(String.format("https://servicewechat.com/%s/js-engine", new Object[] { this.mAppId }));
    }
  }
  
  public final boolean isRunning()
  {
    return (this.dNk) && (getRuntime() != null) && (!getRuntime().mFinished);
  }
  
  public void pT()
  {
    aav();
    aas();
  }
  
  public void qJ(String paramString) {}
  
  public String qK(String paramString)
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o
 * JD-Core Version:    0.7.0.1
 */