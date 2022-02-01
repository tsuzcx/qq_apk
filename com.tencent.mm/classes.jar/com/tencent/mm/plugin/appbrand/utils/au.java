package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.y.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/WxaReferrerHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerHelper;", "()V", "defaultReferrerPolicy", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "getDefaultReferrerPolicy", "()Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "parseReferrerPolicy", "referrerPolicyStr", "", "parseReferrerPolicyFallback", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "parseReferrerPolicyOrFallback", "data", "Lorg/json/JSONObject;", "parseReferrerPolicyStr", "provideReferrer", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class au
  implements com.tencent.mm.plugin.appbrand.jsapi.y.a
{
  public static final au urR;
  private static final c urS;
  
  static
  {
    AppMethodBeat.i(317447);
    urR = new au();
    urS = c.srt;
    AppMethodBeat.o(317447);
  }
  
  public final c C(f paramf)
  {
    AppMethodBeat.i(317469);
    s.u(paramf, "component");
    paramf = (com.tencent.mm.plugin.appbrand.t.a)paramf.aN(com.tencent.mm.plugin.appbrand.t.a.class);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.WxaReferrerHelper", "parseReferrerPolicyFallback, networkConfig is null");
      AppMethodBeat.o(317469);
      return null;
    }
    paramf = paramf.tni;
    AppMethodBeat.o(317469);
    return paramf;
  }
  
  public final String D(f paramf)
  {
    AppMethodBeat.i(317479);
    s.u(paramf, "component");
    paramf = (com.tencent.mm.plugin.appbrand.t.a)paramf.aN(com.tencent.mm.plugin.appbrand.t.a.class);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.WxaReferrerHelper", "provideReferrer, networkConfig is null");
      AppMethodBeat.o(317479);
      return null;
    }
    paramf = paramf.referer;
    s.s(paramf, "referrer");
    if (((CharSequence)paramf).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.WxaReferrerHelper", "provideReferrer, referrer is empty");
      AppMethodBeat.o(317479);
      return null;
    }
    Log.i("MicroMsg.AppBrand.WxaReferrerHelper", s.X("provide, referrer: ", paramf));
    AppMethodBeat.o(317479);
    return paramf;
  }
  
  public final c a(JSONObject paramJSONObject, f paramf)
  {
    AppMethodBeat.i(317475);
    s.u(paramJSONObject, "data");
    s.u(paramf, "component");
    paramJSONObject = at(paramJSONObject);
    if (paramJSONObject == null)
    {
      Log.i("MicroMsg.AppBrand.WxaReferrerHelper", "parseReferrerPolicyOrFallback, referrerPolicyStr is null");
      paramJSONObject = C(paramf);
      AppMethodBeat.o(317475);
      return paramJSONObject;
    }
    paramJSONObject = abv(paramJSONObject);
    if (paramJSONObject == null)
    {
      paramJSONObject = C(paramf);
      AppMethodBeat.o(317475);
      return paramJSONObject;
    }
    AppMethodBeat.o(317475);
    return paramJSONObject;
  }
  
  public final c abv(String paramString)
  {
    AppMethodBeat.i(317461);
    s.u(paramString, "referrerPolicyStr");
    if (s.p(paramString, "origin")) {
      paramString = c.srs;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrand.WxaReferrerHelper", s.X("parseReferrerPolicy, referrerPolicy: ", paramString));
      AppMethodBeat.o(317461);
      return paramString;
      if (s.p(paramString, "no-referrer")) {
        paramString = c.srt;
      } else {
        paramString = null;
      }
    }
  }
  
  public final String at(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(317457);
    s.u(paramJSONObject, "data");
    if (!paramJSONObject.has("referrerPolicy"))
    {
      Log.i("MicroMsg.AppBrand.WxaReferrerHelper", "parseReferrerPolicyStr, referrerPolicy does not exist");
      AppMethodBeat.o(317457);
      return null;
    }
    paramJSONObject = paramJSONObject.optString("referrerPolicy");
    s.s(paramJSONObject, "referrerPolicyStr");
    if (((CharSequence)paramJSONObject).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.WxaReferrerHelper", "parseReferrerPolicyStr, referrerPolicyStr is empty");
      AppMethodBeat.o(317457);
      return null;
    }
    AppMethodBeat.o(317457);
    return paramJSONObject;
  }
  
  public final c cuq()
  {
    return urS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.au
 * JD-Core Version:    0.7.0.1
 */