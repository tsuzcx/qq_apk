package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"REFERRER_HEADER_NAME", "", "TAG", "buildHeaders", "", "referrer", "updateReferrers", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "referrerPolicyContainer", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerPolicyContainer;", "data", "Lorg/json/JSONObject;", "luggage-commons_release"})
public final class d
{
  public static final Map<String, String> IV(String paramString)
  {
    AppMethodBeat.i(194920);
    Map localMap = null;
    if (paramString != null) {
      localMap = Collections.singletonMap("Referer", paramString);
    }
    AppMethodBeat.o(194920);
    return localMap;
  }
  
  public static final String a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(194919);
    k.h(paramb, "referrerPolicyContainer");
    k.h(paramJSONObject, "data");
    if (paramc == null)
    {
      ad.w("MicroMsg.AppBrand.Referrers", "updateReferrers, component is null");
      AppMethodBeat.o(194919);
      return null;
    }
    a locala = (a)e.K(a.class);
    if (locala == null)
    {
      ad.w("MicroMsg.AppBrand.Referrers", "updateReferrers, referrerHelper is null");
      AppMethodBeat.o(194919);
      return null;
    }
    if (paramb.getReferrerPolicy() == null) {
      paramb.setReferrerPolicy(locala.bbJ());
    }
    paramJSONObject = locala.a(paramJSONObject, paramc);
    if (paramJSONObject != null) {
      paramb.setReferrerPolicy(paramJSONObject);
    }
    ad.i("MicroMsg.AppBrand.Referrers", "updateReferrers, referrerPolicy: " + paramb.getReferrerPolicy());
    if (c.khR == paramb.getReferrerPolicy())
    {
      AppMethodBeat.o(194919);
      return null;
    }
    paramc = locala.y(paramc);
    ad.i("MicroMsg.AppBrand.Referrers", "updateReferrers, mReferrer: ".concat(String.valueOf(paramc)));
    AppMethodBeat.o(194919);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.d
 * JD-Core Version:    0.7.0.1
 */