package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.u.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/utils/WeChatReferrerHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerHelper;", "()V", "defaultReferrerPolicy", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "getDefaultReferrerPolicy", "()Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "parseReferrerPolicy", "referrerPolicyStr", "", "parseReferrerPolicyFallback", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "parseReferrerPolicyOrFallback", "data", "Lorg/json/JSONObject;", "parseReferrerPolicyStr", "provideReferrer", "plugin-appbrand-integration_release"})
public final class ak
  implements com.tencent.mm.plugin.appbrand.jsapi.u.a
{
  private static final c ohJ;
  public static final ak ohK;
  
  static
  {
    AppMethodBeat.i(229615);
    ohK = new ak();
    ohJ = c.mou;
    AppMethodBeat.o(229615);
  }
  
  public final c a(JSONObject paramJSONObject, f paramf)
  {
    AppMethodBeat.i(229613);
    p.h(paramJSONObject, "data");
    p.h(paramf, "component");
    paramJSONObject = af(paramJSONObject);
    if (paramJSONObject == null)
    {
      Log.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyOrFallback, referrerPolicyStr is null");
      paramJSONObject = x(paramf);
      AppMethodBeat.o(229613);
      return paramJSONObject;
    }
    c localc = aaF(paramJSONObject);
    paramJSONObject = localc;
    if (localc == null) {
      paramJSONObject = x(paramf);
    }
    AppMethodBeat.o(229613);
    return paramJSONObject;
  }
  
  public final c aaF(String paramString)
  {
    AppMethodBeat.i(229611);
    p.h(paramString, "referrerPolicyStr");
    switch (paramString.hashCode())
    {
    default: 
      paramString = null;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicy, referrerPolicy: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(229611);
      return paramString;
      if (!paramString.equals("origin")) {
        break;
      }
      paramString = c.mot;
      continue;
      if (!paramString.equals("no-referrer")) {
        break;
      }
      paramString = c.mou;
    }
  }
  
  public final String af(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(229610);
    p.h(paramJSONObject, "data");
    if (!paramJSONObject.has("referrerPolicy"))
    {
      Log.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyStr, referrerPolicy does not exist");
      AppMethodBeat.o(229610);
      return null;
    }
    paramJSONObject = paramJSONObject.optString("referrerPolicy");
    p.g(paramJSONObject, "referrerPolicyStr");
    if (((CharSequence)paramJSONObject).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyStr, referrerPolicyStr is empty");
      AppMethodBeat.o(229610);
      return null;
    }
    AppMethodBeat.o(229610);
    return paramJSONObject;
  }
  
  public final c bIw()
  {
    return ohJ;
  }
  
  public final c x(f paramf)
  {
    AppMethodBeat.i(229612);
    p.h(paramf, "component");
    paramf = (com.tencent.mm.plugin.appbrand.s.a)paramf.av(com.tencent.mm.plugin.appbrand.s.a.class);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyFallback, networkConfig is null");
      AppMethodBeat.o(229612);
      return null;
    }
    paramf = paramf.nhN;
    AppMethodBeat.o(229612);
    return paramf;
  }
  
  public final String y(f paramf)
  {
    AppMethodBeat.i(229614);
    p.h(paramf, "component");
    paramf = (com.tencent.mm.plugin.appbrand.s.a)paramf.av(com.tencent.mm.plugin.appbrand.s.a.class);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.WeChatReferrerHelper", "provideReferrer, networkConfig is null");
      AppMethodBeat.o(229614);
      return null;
    }
    paramf = paramf.referer;
    p.g(paramf, "referrer");
    if (((CharSequence)paramf).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.WeChatReferrerHelper", "provideReferrer, referrer is empty");
      AppMethodBeat.o(229614);
      return null;
    }
    Log.i("MicroMsg.AppBrand.WeChatReferrerHelper", "provide, referrer: ".concat(String.valueOf(paramf)));
    AppMethodBeat.o(229614);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ak
 * JD-Core Version:    0.7.0.1
 */