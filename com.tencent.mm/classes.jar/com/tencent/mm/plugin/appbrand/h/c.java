package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public abstract class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public int V(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return -1;
    }
    return paramJSONObject.optInt("viewId", -1);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    Object localObject2 = null;
    if (paramf == null) {
      Log.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "component is null");
    }
    for (;;)
    {
      return;
      int i = V(paramJSONObject);
      if (i == -1)
      {
        Log.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "no viewId in data");
        paramf.callback(paramInt, ZP("fail:no viewId in data"));
        return;
      }
      Object localObject1;
      if ((paramf instanceof ad)) {
        localObject1 = paramf.getJsRuntime();
      }
      while (!b(paramf, paramJSONObject, paramInt))
      {
        if (localObject1 == null) {}
        for (localObject1 = localObject2;; localObject1 = (com.tencent.luggage.xweb_ext.extendplugin.b)((i)localObject1).Z(com.tencent.luggage.xweb_ext.extendplugin.b.class))
        {
          if (localObject1 != null) {
            break label157;
          }
          Log.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "invalid js runtime");
          paramf.callback(paramInt, ZP("fail:invalid runtime"));
          return;
          if (!(paramf instanceof y)) {
            break label220;
          }
          localObject1 = ((y)paramf).getCurrentPageView();
          if (localObject1 == null) {
            break label220;
          }
          localObject1 = ((ad)localObject1).getJsRuntime();
          break;
        }
        label157:
        localObject1 = ((com.tencent.luggage.xweb_ext.extendplugin.b)localObject1).getWebViewPluginClientProxy();
        if (localObject1 == null)
        {
          Log.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "webview has no plugin client");
          paramf.callback(paramInt, ZP("fail:webview has no plugin client"));
          return;
        }
        paramf = new b(paramInt, paramJSONObject, paramf, this);
        ((com.tencent.luggage.xweb_ext.extendplugin.b.c)localObject1).a(cog(), i, paramf);
        return;
        label220:
        localObject1 = null;
      }
    }
  }
  
  protected boolean b(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    return false;
  }
  
  public abstract String cog();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.c
 * JD-Core Version:    0.7.0.1
 */