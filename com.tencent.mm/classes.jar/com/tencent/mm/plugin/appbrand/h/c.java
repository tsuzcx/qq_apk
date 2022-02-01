package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public abstract class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public int K(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return -1;
    }
    return paramJSONObject.optInt("viewId", -1);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    if (parame == null) {
      Log.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "component is null");
    }
    for (;;)
    {
      return;
      int i = K(paramJSONObject);
      if (i == -1)
      {
        Log.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "no viewId in data");
        parame.j(paramInt, h("fail:no viewId in data", null));
        return;
      }
      Object localObject;
      if ((parame instanceof ad)) {
        localObject = parame.getJsRuntime();
      }
      while (!b(parame, paramJSONObject, paramInt))
      {
        if (localObject == null) {}
        for (localObject = null;; localObject = (com.tencent.luggage.xweb_ext.extendplugin.b)((i)localObject).Q(com.tencent.luggage.xweb_ext.extendplugin.b.class))
        {
          if (localObject != null) {
            break label155;
          }
          Log.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "invalid js runtime");
          parame.j(paramInt, h("fail:invalid runtime", null));
          return;
          if (!(parame instanceof v)) {
            break label219;
          }
          localObject = ((v)parame).getCurrentPageView();
          if (localObject == null) {
            break label219;
          }
          localObject = ((ad)localObject).getJsRuntime();
          break;
        }
        label155:
        localObject = ((com.tencent.luggage.xweb_ext.extendplugin.b)localObject).getWebViewPluginClientProxy();
        if (localObject == null)
        {
          Log.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "webview has no plugin client");
          parame.j(paramInt, h("fail:webview has no plugin client", null));
          return;
        }
        parame = new b(paramInt, paramJSONObject, parame, this);
        ((com.tencent.luggage.xweb_ext.extendplugin.b.c)localObject).a(bNT(), i, parame);
        return;
        label219:
        localObject = null;
      }
    }
  }
  
  protected boolean b(e parame, JSONObject paramJSONObject, int paramInt)
  {
    return false;
  }
  
  public abstract String bNT();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.c
 * JD-Core Version:    0.7.0.1
 */