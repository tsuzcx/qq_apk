package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.v.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/utils/WxaReferrerHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerHelper;", "()V", "defaultReferrerPolicy", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "getDefaultReferrerPolicy", "()Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "parseReferrerPolicy", "referrerPolicyStr", "", "parseReferrerPolicyFallback", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "parseReferrerPolicyOrFallback", "data", "Lorg/json/JSONObject;", "parseReferrerPolicyStr", "provideReferrer", "luggage-wechat-full-sdk_release"})
public final class an
  implements com.tencent.mm.plugin.appbrand.jsapi.v.a
{
  private static final c rjx;
  public static final an rjy;
  
  static
  {
    AppMethodBeat.i(243454);
    rjy = new an();
    rjx = c.pmz;
    AppMethodBeat.o(243454);
  }
  
  public final c A(e parame)
  {
    AppMethodBeat.i(243449);
    p.k(parame, "component");
    parame = (com.tencent.mm.plugin.appbrand.s.a)parame.au(com.tencent.mm.plugin.appbrand.s.a.class);
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.WxaReferrerHelper", "parseReferrerPolicyFallback, networkConfig is null");
      AppMethodBeat.o(243449);
      return null;
    }
    parame = parame.qiw;
    AppMethodBeat.o(243449);
    return parame;
  }
  
  public final String B(e parame)
  {
    AppMethodBeat.i(243452);
    p.k(parame, "component");
    parame = (com.tencent.mm.plugin.appbrand.s.a)parame.au(com.tencent.mm.plugin.appbrand.s.a.class);
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.WxaReferrerHelper", "provideReferrer, networkConfig is null");
      AppMethodBeat.o(243452);
      return null;
    }
    parame = parame.referer;
    p.j(parame, "referrer");
    if (((CharSequence)parame).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.WxaReferrerHelper", "provideReferrer, referrer is empty");
      AppMethodBeat.o(243452);
      return null;
    }
    Log.i("MicroMsg.AppBrand.WxaReferrerHelper", "provide, referrer: ".concat(String.valueOf(parame)));
    AppMethodBeat.o(243452);
    return parame;
  }
  
  public final c a(JSONObject paramJSONObject, e parame)
  {
    AppMethodBeat.i(243450);
    p.k(paramJSONObject, "data");
    p.k(parame, "component");
    paramJSONObject = aj(paramJSONObject);
    if (paramJSONObject == null)
    {
      Log.i("MicroMsg.AppBrand.WxaReferrerHelper", "parseReferrerPolicyOrFallback, referrerPolicyStr is null");
      paramJSONObject = A(parame);
      AppMethodBeat.o(243450);
      return paramJSONObject;
    }
    c localc = aix(paramJSONObject);
    paramJSONObject = localc;
    if (localc == null) {
      paramJSONObject = A(parame);
    }
    AppMethodBeat.o(243450);
    return paramJSONObject;
  }
  
  public final c aix(String paramString)
  {
    AppMethodBeat.i(243448);
    p.k(paramString, "referrerPolicyStr");
    switch (paramString.hashCode())
    {
    default: 
      paramString = null;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrand.WxaReferrerHelper", "parseReferrerPolicy, referrerPolicy: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(243448);
      return paramString;
      if (!paramString.equals("origin")) {
        break;
      }
      paramString = c.pmy;
      continue;
      if (!paramString.equals("no-referrer")) {
        break;
      }
      paramString = c.pmz;
    }
  }
  
  public final String aj(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(243447);
    p.k(paramJSONObject, "data");
    if (!paramJSONObject.has("referrerPolicy"))
    {
      Log.i("MicroMsg.AppBrand.WxaReferrerHelper", "parseReferrerPolicyStr, referrerPolicy does not exist");
      AppMethodBeat.o(243447);
      return null;
    }
    paramJSONObject = paramJSONObject.optString("referrerPolicy");
    p.j(paramJSONObject, "referrerPolicyStr");
    if (((CharSequence)paramJSONObject).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.WxaReferrerHelper", "parseReferrerPolicyStr, referrerPolicyStr is empty");
      AppMethodBeat.o(243447);
      return null;
    }
    AppMethodBeat.o(243447);
    return paramJSONObject;
  }
  
  public final c bUd()
  {
    return rjx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.an
 * JD-Core Version:    0.7.0.1
 */