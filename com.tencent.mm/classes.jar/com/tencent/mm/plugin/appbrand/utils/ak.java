package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/utils/WeChatReferrerHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerHelper;", "()V", "defaultReferrerPolicy", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "getDefaultReferrerPolicy", "()Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "parseReferrerPolicy", "referrerPolicyStr", "", "parseReferrerPolicyFallback", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "parseReferrerPolicyOrFallback", "data", "Lorg/json/JSONObject;", "parseReferrerPolicyStr", "provideReferrer", "plugin-appbrand-integration_release"})
public final class ak
  implements com.tencent.mm.plugin.appbrand.jsapi.s.a
{
  private static final com.tencent.mm.plugin.appbrand.jsapi.s.c mUJ;
  public static final ak mUK;
  
  static
  {
    AppMethodBeat.i(223957);
    mUK = new ak();
    mUJ = com.tencent.mm.plugin.appbrand.jsapi.s.c.liO;
    AppMethodBeat.o(223957);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.s.c Rd(String paramString)
  {
    AppMethodBeat.i(223953);
    p.h(paramString, "referrerPolicyStr");
    switch (paramString.hashCode())
    {
    default: 
      paramString = null;
    }
    for (;;)
    {
      ae.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicy, referrerPolicy: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(223953);
      return paramString;
      if (!paramString.equals("origin")) {
        break;
      }
      paramString = com.tencent.mm.plugin.appbrand.jsapi.s.c.liN;
      continue;
      if (!paramString.equals("no-referrer")) {
        break;
      }
      paramString = com.tencent.mm.plugin.appbrand.jsapi.s.c.liO;
    }
  }
  
  public final String W(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(223952);
    p.h(paramJSONObject, "data");
    if (!paramJSONObject.has("referrerPolicy"))
    {
      ae.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyStr, referrerPolicy does not exist");
      AppMethodBeat.o(223952);
      return null;
    }
    paramJSONObject = paramJSONObject.optString("referrerPolicy");
    p.g(paramJSONObject, "referrerPolicyStr");
    if (((CharSequence)paramJSONObject).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.w("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyStr, referrerPolicyStr is empty");
      AppMethodBeat.o(223952);
      return null;
    }
    AppMethodBeat.o(223952);
    return paramJSONObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.s.c a(JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(223955);
    p.h(paramJSONObject, "data");
    p.h(paramc, "component");
    paramJSONObject = W(paramJSONObject);
    if (paramJSONObject == null)
    {
      ae.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyOrFallback, referrerPolicyStr is null");
      paramJSONObject = x(paramc);
      AppMethodBeat.o(223955);
      return paramJSONObject;
    }
    com.tencent.mm.plugin.appbrand.jsapi.s.c localc = Rd(paramJSONObject);
    paramJSONObject = localc;
    if (localc == null) {
      paramJSONObject = x(paramc);
    }
    AppMethodBeat.o(223955);
    return paramJSONObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.s.c bmX()
  {
    return mUJ;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.s.c x(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(223954);
    p.h(paramc, "component");
    paramc = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
    if (paramc == null)
    {
      ae.w("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyFallback, networkConfig is null");
      AppMethodBeat.o(223954);
      return null;
    }
    paramc = paramc.lZY;
    AppMethodBeat.o(223954);
    return paramc;
  }
  
  public final String y(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(223956);
    p.h(paramc, "component");
    paramc = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
    if (paramc == null)
    {
      ae.w("MicroMsg.AppBrand.WeChatReferrerHelper", "provideReferrer, networkConfig is null");
      AppMethodBeat.o(223956);
      return null;
    }
    paramc = paramc.referer;
    p.g(paramc, "referrer");
    if (((CharSequence)paramc).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.w("MicroMsg.AppBrand.WeChatReferrerHelper", "provideReferrer, referrer is empty");
      AppMethodBeat.o(223956);
      return null;
    }
    ae.i("MicroMsg.AppBrand.WeChatReferrerHelper", "provide, referrer: ".concat(String.valueOf(paramc)));
    AppMethodBeat.o(223956);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ak
 * JD-Core Version:    0.7.0.1
 */