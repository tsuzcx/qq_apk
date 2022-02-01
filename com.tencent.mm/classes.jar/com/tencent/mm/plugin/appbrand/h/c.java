package com.tencent.mm.plugin.appbrand.h;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public abstract class c
  extends a
{
  public int A(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return -1;
    }
    return paramJSONObject.optInt("viewId", -1);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramc == null) {
      ae.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "component is null");
    }
    for (;;)
    {
      return;
      int i = A(paramJSONObject);
      if (i == -1)
      {
        ae.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "no viewId in data");
        paramc.h(paramInt, e("fail:no viewId in data", null));
        return;
      }
      Object localObject;
      if ((paramc instanceof z)) {
        localObject = paramc.aYB();
      }
      while (!b(paramc, paramJSONObject, paramInt))
      {
        if (localObject == null) {}
        for (localObject = null;; localObject = (com.tencent.luggage.xweb_ext.extendplugin.b)((i)localObject).P(com.tencent.luggage.xweb_ext.extendplugin.b.class))
        {
          if (localObject != null) {
            break label155;
          }
          ae.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "invalid js runtime");
          paramc.h(paramInt, e("fail:invalid runtime", null));
          return;
          if (!(paramc instanceof r)) {
            break label219;
          }
          localObject = ((r)paramc).getCurrentPageView();
          if (localObject == null) {
            break label219;
          }
          localObject = ((z)localObject).aYB();
          break;
        }
        label155:
        localObject = ((com.tencent.luggage.xweb_ext.extendplugin.b)localObject).getWebViewPluginClientProxy();
        if (localObject == null)
        {
          ae.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "webview has no plugin client");
          paramc.h(paramInt, e("fail:webview has no plugin client", null));
          return;
        }
        paramc = new b(paramInt, paramJSONObject, paramc, this);
        ((com.tencent.luggage.xweb_ext.extendplugin.b.c)localObject).a(bhf(), i, paramc);
        return;
        label219:
        localObject = null;
      }
    }
  }
  
  protected boolean b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    return false;
  }
  
  public abstract String bhf();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.c
 * JD-Core Version:    0.7.0.1
 */