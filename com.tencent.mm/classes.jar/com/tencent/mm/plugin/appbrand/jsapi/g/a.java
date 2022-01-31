package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.luggage.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.g;
import org.json.JSONObject;

public abstract class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  protected final void a(c paramc, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramc.h(paramInt, paramString);
    com.tencent.mm.plugin.appbrand.jsapi.g.a.e.d(getName(), paramBoolean1, paramBoolean2);
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.mm.plugin.appbrand.jsapi.g.a.e.Cj(getName());
  }
  
  protected final b f(c paramc, JSONObject paramJSONObject)
  {
    if ((paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.e)) {
      return g.cl(paramc.getAppId(), com.tencent.mm.plugin.appbrand.jsapi.g.a.f.g(paramc, paramJSONObject));
    }
    if (paramc.q(com.tencent.mm.plugin.appbrand.jsapi.base.f.class) == null)
    {
      d.e("MicroMsg.BaseMapJsApi", "name:%s IComponentConverter is null, return", new Object[] { getName() });
      return null;
    }
    paramc = ((com.tencent.mm.plugin.appbrand.jsapi.base.f)paramc.q(com.tencent.mm.plugin.appbrand.jsapi.base.f.class)).d(paramc);
    if (paramc == null)
    {
      d.e("MicroMsg.BaseMapJsApi", "name:%s is not componentView", new Object[] { getName() });
      return null;
    }
    return g.cl(paramc.getAppId(), com.tencent.mm.plugin.appbrand.jsapi.g.a.f.g(paramc, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a
 * JD-Core Version:    0.7.0.1
 */