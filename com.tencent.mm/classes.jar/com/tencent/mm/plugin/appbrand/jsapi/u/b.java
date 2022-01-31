package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.mm.plugin.appbrand.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public abstract class b
  extends s
{
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    if (paramc == null)
    {
      y.w("MicroMsg.AppBrand.SameLayer.AppBrandPluginSyncJsApi", "component is null");
      return h("fail:component is null", null);
    }
    if ((paramJSONObject == null) || (!paramJSONObject.has("viewId")))
    {
      y.w("MicroMsg.AppBrand.SameLayer.AppBrandPluginSyncJsApi", "no viewId in data");
      return h("fail:no viewId in data", null);
    }
    Object localObject;
    if ((paramc instanceof q)) {
      localObject = paramc.ahK();
    }
    for (;;)
    {
      if ((localObject == null) || (!(localObject instanceof w)))
      {
        y.w("MicroMsg.AppBrand.SameLayer.AppBrandPluginSyncJsApi", "js runtime not appbrand webview");
        return h("fail:invalid runtime", null);
        if ((paramc instanceof o)) {
          localObject = ((o)paramc).E(q.class).ahK();
        }
      }
      else
      {
        localObject = ((w)localObject).getWebViewPluginClientProxy();
        if (localObject == null)
        {
          y.w("MicroMsg.AppBrand.SameLayer.AppBrandPluginSyncJsApi", "webview has no plugin client");
          return h("fail:webview has no plugin client", null);
        }
        int i = paramJSONObject.optInt("viewId");
        return ((f)localObject).a(alr(), i, paramc, paramJSONObject, this);
      }
      localObject = null;
    }
  }
  
  public abstract String alr();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.b
 * JD-Core Version:    0.7.0.1
 */