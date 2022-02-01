package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/utils/WeChatReferrerHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerHelper;", "()V", "defaultReferrerPolicy", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "getDefaultReferrerPolicy", "()Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "parseReferrerPolicy", "referrerPolicyStr", "", "parseReferrerPolicyFallback", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "parseReferrerPolicyOrFallback", "data", "Lorg/json/JSONObject;", "parseReferrerPolicyStr", "provideReferrer", "plugin-appbrand-integration_release"})
public final class ad
  implements com.tencent.mm.plugin.appbrand.jsapi.q.a
{
  private static final com.tencent.mm.plugin.appbrand.jsapi.q.c lMU;
  public static final ad lMV;
  
  static
  {
    AppMethodBeat.i(196495);
    lMV = new ad();
    lMU = com.tencent.mm.plugin.appbrand.jsapi.q.c.khR;
    AppMethodBeat.o(196495);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.q.c IU(String paramString)
  {
    AppMethodBeat.i(196491);
    k.h(paramString, "referrerPolicyStr");
    switch (paramString.hashCode())
    {
    default: 
      paramString = null;
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicy, referrerPolicy: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(196491);
      return paramString;
      if (!paramString.equals("origin")) {
        break;
      }
      paramString = com.tencent.mm.plugin.appbrand.jsapi.q.c.khQ;
      continue;
      if (!paramString.equals("no-referrer")) {
        break;
      }
      paramString = com.tencent.mm.plugin.appbrand.jsapi.q.c.khR;
    }
  }
  
  public final String U(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(196490);
    k.h(paramJSONObject, "data");
    if (!paramJSONObject.has("referrerPolicy"))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyStr, referrerPolicy does not exist");
      AppMethodBeat.o(196490);
      return null;
    }
    paramJSONObject = paramJSONObject.optString("referrerPolicy");
    k.g(paramJSONObject, "referrerPolicyStr");
    if (((CharSequence)paramJSONObject).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyStr, referrerPolicyStr is empty");
      AppMethodBeat.o(196490);
      return null;
    }
    AppMethodBeat.o(196490);
    return paramJSONObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.q.c a(JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(196493);
    k.h(paramJSONObject, "data");
    k.h(paramc, "component");
    paramJSONObject = U(paramJSONObject);
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyOrFallback, referrerPolicyStr is null");
      paramJSONObject = x(paramc);
      AppMethodBeat.o(196493);
      return paramJSONObject;
    }
    com.tencent.mm.plugin.appbrand.jsapi.q.c localc = IU(paramJSONObject);
    paramJSONObject = localc;
    if (localc == null) {
      paramJSONObject = x(paramc);
    }
    AppMethodBeat.o(196493);
    return paramJSONObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.q.c bbJ()
  {
    return lMU;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.q.c x(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(196492);
    k.h(paramc, "component");
    paramc = (com.tencent.mm.plugin.appbrand.q.a)paramc.ar(com.tencent.mm.plugin.appbrand.q.a.class);
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyFallback, networkConfig is null");
      AppMethodBeat.o(196492);
      return null;
    }
    paramc = paramc.kUy;
    AppMethodBeat.o(196492);
    return paramc;
  }
  
  public final String y(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(196494);
    k.h(paramc, "component");
    paramc = (com.tencent.mm.plugin.appbrand.q.a)paramc.ar(com.tencent.mm.plugin.appbrand.q.a.class);
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.WeChatReferrerHelper", "provideReferrer, networkConfig is null");
      AppMethodBeat.o(196494);
      return null;
    }
    paramc = paramc.referer;
    k.g(paramc, "referrer");
    if (((CharSequence)paramc).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.WeChatReferrerHelper", "provideReferrer, referrer is empty");
      AppMethodBeat.o(196494);
      return null;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.WeChatReferrerHelper", "provide, referrer: ".concat(String.valueOf(paramc)));
    AppMethodBeat.o(196494);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ad
 * JD-Core Version:    0.7.0.1
 */