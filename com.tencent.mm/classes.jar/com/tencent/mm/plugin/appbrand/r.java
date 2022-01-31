package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a;
import com.tencent.mm.plugin.appbrand.i.c;
import com.tencent.mm.plugin.appbrand.i.k;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public class r
  extends d
{
  public volatile boolean gRF;
  private volatile i gRG;
  public w gRH;
  protected LinkedList<com.tencent.mm.plugin.appbrand.jsapi.v> gRI;
  private volatile boolean mDestroyed;
  private volatile boolean mInitialized;
  
  public r()
  {
    AppMethodBeat.i(86747);
    this.mDestroyed = false;
    this.mInitialized = false;
    this.gRF = false;
    this.gRI = new LinkedList();
    AppMethodBeat.o(86747);
  }
  
  private void aue()
  {
    AppMethodBeat.i(86753);
    if (this.gRH == null) {
      this.gRH = wK();
    }
    AppMethodBeat.o(86753);
  }
  
  public final void Do()
  {
    AppMethodBeat.i(86748);
    aBr();
    aue();
    com.tencent.mm.plugin.appbrand.jsapi.i.a(this, auh());
    this.gRF = true;
    vj();
    if (aAO().v(com.tencent.mm.plugin.appbrand.i.o.class) != null) {
      ((com.tencent.mm.plugin.appbrand.i.o)aAO().v(com.tencent.mm.plugin.appbrand.i.o.class)).setJsRuntimeTitle("https://servicewechat.com/preload/js-engine");
    }
    AppMethodBeat.o(86748);
  }
  
  public final <T extends com.tencent.mm.plugin.appbrand.page.v> T W(Class<T> paramClass)
  {
    AppMethodBeat.i(86763);
    if (this.gRG == null)
    {
      AppMethodBeat.o(86763);
      return null;
    }
    Object localObject = this.gRG.atj().getCurrentPage();
    if (localObject == null)
    {
      AppMethodBeat.o(86763);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.page.o)localObject).getCurrentPageView();
    if (paramClass.isInstance(localObject))
    {
      AppMethodBeat.o(86763);
      return localObject;
    }
    AppMethodBeat.o(86763);
    return null;
  }
  
  public final <T extends Activity> T X(Class<T> paramClass)
  {
    AppMethodBeat.i(86765);
    if (getCurrentPageView() == null) {}
    for (Context localContext = getContext(); paramClass.isInstance(localContext); localContext = getCurrentPageView().getContext())
    {
      paramClass = (Activity)localContext;
      AppMethodBeat.o(86765);
      return paramClass;
    }
    AppMethodBeat.o(86765);
    return null;
  }
  
  public final boolean aud()
  {
    AppMethodBeat.i(86749);
    if ((getRuntime() == null) && (!this.mDestroyed))
    {
      AppMethodBeat.o(86749);
      return true;
    }
    AppMethodBeat.o(86749);
    return false;
  }
  
  public final void auf()
  {
    try
    {
      AppMethodBeat.i(86757);
      Iterator localIterator = this.gRI.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.v localv = (com.tencent.mm.plugin.appbrand.jsapi.v)localIterator.next();
        super.c(localv.cnC, localv.data, localv.src);
      }
      this.gRI = null;
    }
    finally {}
    AppMethodBeat.o(86757);
  }
  
  public final String aug()
  {
    return "AppBrandService";
  }
  
  public final JSONObject auh()
  {
    AppMethodBeat.i(86771);
    JSONObject localJSONObject = super.auh();
    AppMethodBeat.o(86771);
    return localJSONObject;
  }
  
  public void b(i parami)
  {
    AppMethodBeat.i(86750);
    this.gRG = parami;
    s.a.gRL.c(this);
    AppMethodBeat.o(86750);
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(86760);
    if (!isRunning())
    {
      AppMethodBeat.o(86760);
      return;
    }
    this.gRG.atj().c(paramString1, paramString2, paramArrayOfInt);
    AppMethodBeat.o(86760);
  }
  
  protected void be(boolean paramBoolean)
  {
    AppMethodBeat.i(86752);
    if (!isRunning())
    {
      ab.w("MicroMsg.AppBrandService", "onRuntimeResume but not running, appId %s, willRelaunch %b", new Object[] { getAppId(), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(86752);
      return;
    }
    new j().b(this.gRG, paramBoolean);
    AppMethodBeat.o(86752);
  }
  
  @Deprecated
  public final void br(String paramString1, String paramString2)
  {
    AppMethodBeat.i(86758);
    super.c(paramString1, paramString2, 0);
    AppMethodBeat.o(86758);
  }
  
  public void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(86759);
    try
    {
      if (this.gRI != null)
      {
        this.gRI.add(new com.tencent.mm.plugin.appbrand.jsapi.v(paramString1, paramString2, paramInt));
        return;
      }
      super.c(paramString1, paramString2, paramInt);
      AppMethodBeat.o(86759);
      return;
    }
    finally
    {
      AppMethodBeat.o(86759);
    }
  }
  
  public String ce(String paramString)
  {
    return "";
  }
  
  public void cleanup()
  {
    AppMethodBeat.i(86768);
    super.cleanup();
    this.gRG = null;
    this.mInitialized = false;
    this.mDestroyed = true;
    AppMethodBeat.o(86768);
  }
  
  public void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(86772);
    super.e(paramJSONObject);
    if (aAO() != null) {
      if (aAO().v(k.class) == null) {
        break label51;
      }
    }
    label51:
    for (boolean bool = true;; bool = false)
    {
      b(paramJSONObject, "nativeBufferEnabled", Boolean.valueOf(bool));
      AppMethodBeat.o(86772);
      return;
    }
  }
  
  public com.tencent.mm.plugin.appbrand.page.v getCurrentPageView()
  {
    AppMethodBeat.i(86762);
    com.tencent.mm.plugin.appbrand.page.v localv = W(com.tencent.mm.plugin.appbrand.page.v.class);
    AppMethodBeat.o(86762);
    return localv;
  }
  
  public i getRuntime()
  {
    return this.gRG;
  }
  
  public final void init()
  {
    AppMethodBeat.i(86755);
    super.init();
    aue();
    this.mInitialized = true;
    c(this.gRG.gPG);
    tW();
    if (aAO().v(com.tencent.mm.plugin.appbrand.i.o.class) != null) {
      ((com.tencent.mm.plugin.appbrand.i.o)aAO().v(com.tencent.mm.plugin.appbrand.i.o.class)).setJsRuntimeTitle(String.format("https://servicewechat.com/%s/js-engine", new Object[] { getAppId() }));
    }
    AppMethodBeat.o(86755);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(86761);
    if ((this.mInitialized) && (super.isRunning()))
    {
      AppMethodBeat.o(86761);
      return true;
    }
    AppMethodBeat.o(86761);
    return false;
  }
  
  protected void tW()
  {
    AppMethodBeat.i(86756);
    wF();
    auf();
    AppMethodBeat.o(86756);
  }
  
  protected void vc()
  {
    AppMethodBeat.i(86751);
    if (!isRunning())
    {
      ab.w("MicroMsg.AppBrandService", "onRuntimePause but not running appId %s", new Object[] { getAppId() });
      AppMethodBeat.o(86751);
      return;
    }
    new com.tencent.mm.plugin.appbrand.page.i().F(this.gRG);
    AppMethodBeat.o(86751);
  }
  
  protected void vj() {}
  
  public com.tencent.mm.plugin.appbrand.i.i wB()
  {
    AppMethodBeat.i(86766);
    c localc = new c(null, null);
    AppMethodBeat.o(86766);
    return localc;
  }
  
  public Map<String, m> wC()
  {
    AppMethodBeat.i(86767);
    Map localMap = Collections.emptyMap();
    AppMethodBeat.o(86767);
    return localMap;
  }
  
  public JSONObject wE()
  {
    AppMethodBeat.i(86770);
    JSONObject localJSONObject = super.wE();
    Object localObject1 = this.gRG.wY();
    Object localObject2 = this.gRG.getAppConfig();
    if ((localObject1 == null) || (localObject2 == null))
    {
      localJSONObject = new JSONObject();
      AppMethodBeat.o(86770);
      return localJSONObject;
    }
    localObject1 = ((a)localObject2).hgY;
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
        ab.e("MicroMsg.AppBrandService", localException.getMessage());
      }
    }
    b(localJSONObject, "env", new JSONObject());
    AppMethodBeat.o(86770);
    return localJSONObject;
  }
  
  protected void wF()
  {
    AppMethodBeat.i(86769);
    JSONObject localJSONObject = wE();
    String str = this.gRG.getAppConfig().hgZ;
    aAO().evaluateJavascript(String.format(";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);var __wxIndexPage = \"%s\";", new Object[] { localJSONObject.toString(), str }), null);
    AppMethodBeat.o(86769);
  }
  
  public String wG()
  {
    return "";
  }
  
  public String wH()
  {
    return "";
  }
  
  protected w wK()
  {
    AppMethodBeat.i(86754);
    w localw = new w(this);
    AppMethodBeat.o(86754);
    return localw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r
 * JD-Core Version:    0.7.0.1
 */