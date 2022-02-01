package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public abstract class c
  extends d
{
  public int H(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return -1;
    }
    return paramJSONObject.optInt("viewId", -1);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    if (paramf == null) {
      Log.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "component is null");
    }
    for (;;)
    {
      return;
      int i = H(paramJSONObject);
      if (i == -1)
      {
        Log.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "no viewId in data");
        paramf.i(paramInt, h("fail:no viewId in data", null));
        return;
      }
      Object localObject;
      if ((paramf instanceof ac)) {
        localObject = paramf.getJsRuntime();
      }
      while (!b(paramf, paramJSONObject, paramInt))
      {
        if (localObject == null) {}
        for (localObject = null;; localObject = (com.tencent.luggage.xweb_ext.extendplugin.b)((i)localObject).R(com.tencent.luggage.xweb_ext.extendplugin.b.class))
        {
          if (localObject != null) {
            break label155;
          }
          Log.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "invalid js runtime");
          paramf.i(paramInt, h("fail:invalid runtime", null));
          return;
          if (!(paramf instanceof s)) {
            break label219;
          }
          localObject = ((s)paramf).getCurrentPageView();
          if (localObject == null) {
            break label219;
          }
          localObject = ((ac)localObject).getJsRuntime();
          break;
        }
        label155:
        localObject = ((com.tencent.luggage.xweb_ext.extendplugin.b)localObject).getWebViewPluginClientProxy();
        if (localObject == null)
        {
          Log.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "webview has no plugin client");
          paramf.i(paramInt, h("fail:webview has no plugin client", null));
          return;
        }
        paramf = new b(paramInt, paramJSONObject, paramf, this);
        ((com.tencent.luggage.xweb_ext.extendplugin.b.c)localObject).a(bCy(), i, paramf);
        return;
        label219:
        localObject = null;
      }
    }
  }
  
  protected boolean b(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    return false;
  }
  
  public abstract String bCy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.c
 * JD-Core Version:    0.7.0.1
 */