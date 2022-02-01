package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/utils/WeChatReferrerHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerHelper;", "()V", "defaultReferrerPolicy", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "getDefaultReferrerPolicy", "()Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "parseReferrerPolicy", "referrerPolicyStr", "", "parseReferrerPolicyFallback", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "parseReferrerPolicyOrFallback", "data", "Lorg/json/JSONObject;", "parseReferrerPolicyStr", "provideReferrer", "plugin-appbrand-integration_release"})
public final class ae
  implements com.tencent.mm.plugin.appbrand.jsapi.p.a
{
  private static final com.tencent.mm.plugin.appbrand.jsapi.p.c moU;
  public static final ae moV;
  
  static
  {
    AppMethodBeat.i(187456);
    moV = new ae();
    moU = com.tencent.mm.plugin.appbrand.jsapi.p.c.kIJ;
    AppMethodBeat.o(187456);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.p.c MX(String paramString)
  {
    AppMethodBeat.i(187452);
    k.h(paramString, "referrerPolicyStr");
    switch (paramString.hashCode())
    {
    default: 
      paramString = null;
    }
    for (;;)
    {
      ac.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicy, referrerPolicy: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(187452);
      return paramString;
      if (!paramString.equals("origin")) {
        break;
      }
      paramString = com.tencent.mm.plugin.appbrand.jsapi.p.c.kII;
      continue;
      if (!paramString.equals("no-referrer")) {
        break;
      }
      paramString = com.tencent.mm.plugin.appbrand.jsapi.p.c.kIJ;
    }
  }
  
  public final String U(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(187451);
    k.h(paramJSONObject, "data");
    if (!paramJSONObject.has("referrerPolicy"))
    {
      ac.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyStr, referrerPolicy does not exist");
      AppMethodBeat.o(187451);
      return null;
    }
    paramJSONObject = paramJSONObject.optString("referrerPolicy");
    k.g(paramJSONObject, "referrerPolicyStr");
    if (((CharSequence)paramJSONObject).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.w("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyStr, referrerPolicyStr is empty");
      AppMethodBeat.o(187451);
      return null;
    }
    AppMethodBeat.o(187451);
    return paramJSONObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.p.c a(JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(187454);
    k.h(paramJSONObject, "data");
    k.h(paramc, "component");
    paramJSONObject = U(paramJSONObject);
    if (paramJSONObject == null)
    {
      ac.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyOrFallback, referrerPolicyStr is null");
      paramJSONObject = x(paramc);
      AppMethodBeat.o(187454);
      return paramJSONObject;
    }
    com.tencent.mm.plugin.appbrand.jsapi.p.c localc = MX(paramJSONObject);
    paramJSONObject = localc;
    if (localc == null) {
      paramJSONObject = x(paramc);
    }
    AppMethodBeat.o(187454);
    return paramJSONObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.p.c biC()
  {
    return moU;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.p.c x(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(187453);
    k.h(paramc, "component");
    paramc = (com.tencent.mm.plugin.appbrand.p.a)paramc.ar(com.tencent.mm.plugin.appbrand.p.a.class);
    if (paramc == null)
    {
      ac.w("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyFallback, networkConfig is null");
      AppMethodBeat.o(187453);
      return null;
    }
    paramc = paramc.lwi;
    AppMethodBeat.o(187453);
    return paramc;
  }
  
  public final String y(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(187455);
    k.h(paramc, "component");
    paramc = (com.tencent.mm.plugin.appbrand.p.a)paramc.ar(com.tencent.mm.plugin.appbrand.p.a.class);
    if (paramc == null)
    {
      ac.w("MicroMsg.AppBrand.WeChatReferrerHelper", "provideReferrer, networkConfig is null");
      AppMethodBeat.o(187455);
      return null;
    }
    paramc = paramc.referer;
    k.g(paramc, "referrer");
    if (((CharSequence)paramc).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.w("MicroMsg.AppBrand.WeChatReferrerHelper", "provideReferrer, referrer is empty");
      AppMethodBeat.o(187455);
      return null;
    }
    ac.i("MicroMsg.AppBrand.WeChatReferrerHelper", "provide, referrer: ".concat(String.valueOf(paramc)));
    AppMethodBeat.o(187455);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ae
 * JD-Core Version:    0.7.0.1
 */