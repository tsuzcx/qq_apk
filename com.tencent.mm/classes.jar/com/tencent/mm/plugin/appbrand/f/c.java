package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public abstract class c
  extends a
{
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramc == null)
    {
      ab.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "component is null");
      return;
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("viewId")))
    {
      ab.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "no viewId in data");
      paramc.h(paramInt, j("fail:no viewId in data", null));
      return;
    }
    Object localObject;
    if ((paramc instanceof v)) {
      localObject = paramc.aAO();
    }
    for (;;)
    {
      if (localObject == null) {}
      for (localObject = null;; localObject = (com.tencent.luggage.xweb_ext.extendplugin.b)((i)localObject).v(com.tencent.luggage.xweb_ext.extendplugin.b.class))
      {
        if (localObject != null) {
          break label145;
        }
        ab.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "invalid js runtime");
        paramc.h(paramInt, j("fail:invalid runtime", null));
        return;
        if (!(paramc instanceof r)) {
          break label215;
        }
        localObject = ((r)paramc).getCurrentPageView();
        if (localObject == null) {
          break label215;
        }
        localObject = ((v)localObject).aAO();
        break;
      }
      label145:
      localObject = ((com.tencent.luggage.xweb_ext.extendplugin.b)localObject).getWebViewPluginClientProxy();
      if (localObject == null)
      {
        ab.w("MicroMsg.SameLayer.AppBrandPluginAsyncJsApi", "webview has no plugin client");
        paramc.h(paramInt, j("fail:webview has no plugin client", null));
        return;
      }
      int i = paramJSONObject.optInt("viewId");
      ((com.tencent.luggage.xweb_ext.extendplugin.b.c)localObject).a(aAm(), i, new b(paramInt, paramJSONObject, paramc, this));
      return;
      label215:
      localObject = null;
    }
  }
  
  public abstract String aAm();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.f.c
 * JD-Core Version:    0.7.0.1
 */