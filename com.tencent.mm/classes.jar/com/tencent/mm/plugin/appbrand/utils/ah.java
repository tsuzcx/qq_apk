package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/utils/WeChatReferrerHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerHelper;", "()V", "defaultReferrerPolicy", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "getDefaultReferrerPolicy", "()Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "parseReferrerPolicy", "referrerPolicyStr", "", "parseReferrerPolicyFallback", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "parseReferrerPolicyOrFallback", "data", "Lorg/json/JSONObject;", "parseReferrerPolicyStr", "provideReferrer", "plugin-appbrand-integration_release"})
public final class ah
  implements com.tencent.mm.plugin.appbrand.jsapi.s.a
{
  public static final ah mPA;
  private static final com.tencent.mm.plugin.appbrand.jsapi.s.c mPz;
  
  static
  {
    AppMethodBeat.i(189685);
    mPA = new ah();
    mPz = com.tencent.mm.plugin.appbrand.jsapi.s.c.lfc;
    AppMethodBeat.o(189685);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.s.c Qu(String paramString)
  {
    AppMethodBeat.i(189681);
    p.h(paramString, "referrerPolicyStr");
    switch (paramString.hashCode())
    {
    default: 
      paramString = null;
    }
    for (;;)
    {
      ad.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicy, referrerPolicy: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(189681);
      return paramString;
      if (!paramString.equals("origin")) {
        break;
      }
      paramString = com.tencent.mm.plugin.appbrand.jsapi.s.c.lfb;
      continue;
      if (!paramString.equals("no-referrer")) {
        break;
      }
      paramString = com.tencent.mm.plugin.appbrand.jsapi.s.c.lfc;
    }
  }
  
  public final String W(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(189680);
    p.h(paramJSONObject, "data");
    if (!paramJSONObject.has("referrerPolicy"))
    {
      ad.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyStr, referrerPolicy does not exist");
      AppMethodBeat.o(189680);
      return null;
    }
    paramJSONObject = paramJSONObject.optString("referrerPolicy");
    p.g(paramJSONObject, "referrerPolicyStr");
    if (((CharSequence)paramJSONObject).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.w("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyStr, referrerPolicyStr is empty");
      AppMethodBeat.o(189680);
      return null;
    }
    AppMethodBeat.o(189680);
    return paramJSONObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.s.c a(JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(189683);
    p.h(paramJSONObject, "data");
    p.h(paramc, "component");
    paramJSONObject = W(paramJSONObject);
    if (paramJSONObject == null)
    {
      ad.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyOrFallback, referrerPolicyStr is null");
      paramJSONObject = x(paramc);
      AppMethodBeat.o(189683);
      return paramJSONObject;
    }
    com.tencent.mm.plugin.appbrand.jsapi.s.c localc = Qu(paramJSONObject);
    paramJSONObject = localc;
    if (localc == null) {
      paramJSONObject = x(paramc);
    }
    AppMethodBeat.o(189683);
    return paramJSONObject;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.s.c bmo()
  {
    return mPz;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.s.c x(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(189682);
    p.h(paramc, "component");
    paramc = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
    if (paramc == null)
    {
      ad.w("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyFallback, networkConfig is null");
      AppMethodBeat.o(189682);
      return null;
    }
    paramc = paramc.lVv;
    AppMethodBeat.o(189682);
    return paramc;
  }
  
  public final String y(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(189684);
    p.h(paramc, "component");
    paramc = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
    if (paramc == null)
    {
      ad.w("MicroMsg.AppBrand.WeChatReferrerHelper", "provideReferrer, networkConfig is null");
      AppMethodBeat.o(189684);
      return null;
    }
    paramc = paramc.referer;
    p.g(paramc, "referrer");
    if (((CharSequence)paramc).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.w("MicroMsg.AppBrand.WeChatReferrerHelper", "provideReferrer, referrer is empty");
      AppMethodBeat.o(189684);
      return null;
    }
    ad.i("MicroMsg.AppBrand.WeChatReferrerHelper", "provide, referrer: ".concat(String.valueOf(paramc)));
    AppMethodBeat.o(189684);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ah
 * JD-Core Version:    0.7.0.1
 */