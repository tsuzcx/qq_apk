package com.tencent.mm.plugin.appbrand.e;

import android.graphics.SurfaceTexture;
import com.tencent.luggage.m.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

public final class a
  implements f
{
  private com.tencent.luggage.m.a.d<g> fYm;
  private ConcurrentHashMap<String, g> fYn = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentLinkedQueue<com.tencent.mm.plugin.appbrand.jsapi.u.a>> fYo = new ConcurrentHashMap();
  private e fYp;
  
  private void a(String paramString, int paramInt, i parami, c paramc, JSONObject paramJSONObject)
  {
    String str = d.aK(paramString, paramInt);
    ConcurrentLinkedQueue localConcurrentLinkedQueue = (ConcurrentLinkedQueue)this.fYo.get(str);
    paramString = localConcurrentLinkedQueue;
    if (localConcurrentLinkedQueue == null)
    {
      paramString = new ConcurrentLinkedQueue();
      this.fYo.put(str, paramString);
    }
    paramString.add(new com.tencent.mm.plugin.appbrand.jsapi.u.a(paramJSONObject, parami, paramc));
  }
  
  private void a(String paramString, g paramg)
  {
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", ">>>>>> flushPendingJsApis start");
    Object localObject = (ConcurrentLinkedQueue)this.fYo.get(paramString);
    if ((localObject != null) && (!((ConcurrentLinkedQueue)localObject).isEmpty()))
    {
      localObject = ((ConcurrentLinkedQueue)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.u.a locala = (com.tencent.mm.plugin.appbrand.jsapi.u.a)((Iterator)localObject).next();
        paramg.a(locala.geu, locala.fVN, locala.gfh);
      }
    }
    this.fYo.remove(paramString);
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "<<<<<< flushPendingJsApis end");
  }
  
  public final String a(String paramString, int paramInt, c paramc, JSONObject paramJSONObject, i parami)
  {
    String str = d.aK(paramString, paramInt);
    g localg = (g)this.fYn.get(str);
    if (localg == null)
    {
      y.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "handleJsApi(%s), key(%s), handler is null", new Object[] { parami.getName(), str });
      a(paramString, paramInt, parami, paramc, paramJSONObject);
      return parami.h("ok", null);
    }
    if (localg.aly())
    {
      y.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "handleJsApi(%s), key(%s), handler exists, and is ready", new Object[] { parami.getName(), str });
      return localg.a(paramc, paramJSONObject, parami);
    }
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "handleJsApi(%s), key(%s), handler exists, but not ready", new Object[] { parami.getName(), str });
    a(paramString, paramInt, parami, paramc, paramJSONObject);
    return parami.h("ok", null);
  }
  
  public final void a(com.tencent.luggage.m.a.d<g> paramd)
  {
    this.fYm = paramd;
  }
  
  public final void a(e parame)
  {
    this.fYp = parame;
  }
  
  public final void a(af paramaf)
  {
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onWebViewForeground:webview#%s", new Object[] { Integer.valueOf(paramaf.hashCode()) });
    if ((this.fYn != null) && (!this.fYn.isEmpty()))
    {
      paramaf = this.fYn.values().iterator();
      while (paramaf.hasNext()) {
        ((g)paramaf.next()).qC();
      }
    }
  }
  
  public final void b(af paramaf)
  {
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onWebViewBackground:webview#%s", new Object[] { Integer.valueOf(paramaf.hashCode()) });
    if ((this.fYn != null) && (!this.fYn.isEmpty()))
    {
      paramaf = this.fYn.values().iterator();
      while (paramaf.hasNext()) {
        ((g)paramaf.next()).qD();
      }
    }
  }
  
  public final void c(af paramaf)
  {
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onWebViewDestroyed:webview#%s", new Object[] { Integer.valueOf(paramaf.hashCode()) });
    if ((this.fYn != null) && (!this.fYn.isEmpty()))
    {
      paramaf = this.fYn.values().iterator();
      while (paramaf.hasNext()) {
        ((g)paramaf.next()).qB();
      }
    }
  }
  
  public final void onPluginDestroy(String paramString, int paramInt)
  {
    paramString = d.aK(paramString, paramInt);
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginDestroy, key:%s", new Object[] { paramString });
    if (!this.fYn.containsKey(paramString))
    {
      y.w("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginDestroy, do you forget to call ready before?");
      return;
    }
    ((g)this.fYn.get(paramString)).qB();
  }
  
  public final void onPluginReady(String paramString, int paramInt, SurfaceTexture paramSurfaceTexture)
  {
    String str = d.aK(paramString, paramInt);
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginReady, key:%s", new Object[] { str });
    if (this.fYn.containsKey(str))
    {
      y.w("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginReady, handle plugin ready again");
      paramString = (g)this.fYn.get(str);
      if (paramString != null)
      {
        paramString.d(paramSurfaceTexture);
        a(str, paramString);
      }
    }
    while (this.fYm == null) {
      return;
    }
    g localg = (g)this.fYm.bk(paramString);
    if (localg != null)
    {
      y.w("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginReady, create new handle plugin");
      localg.setId(paramInt);
      localg.setType(paramString);
      localg.a(this);
      this.fYn.put(str, localg);
      localg.d(paramSurfaceTexture);
      a(str, localg);
      return;
    }
    y.e("MicroMsg.AppBrand.SameLayer.AppBrandExtendPluginClientProxy", "onPluginReady, no handler for this view?");
  }
  
  public final e qz()
  {
    return this.fYp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e.a
 * JD-Core Version:    0.7.0.1
 */