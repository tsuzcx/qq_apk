package com.tencent.mm.plugin.appbrand.jsapi.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"REFERRER_HEADER_NAME", "", "TAG", "buildHeaders", "", "referrer", "updateReferrers", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "referrerPolicyContainer", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerPolicyContainer;", "data", "Lorg/json/JSONObject;", "luggage-commons_release"})
public final class d
{
  public static final String a(com.tencent.mm.plugin.appbrand.jsapi.e parame, b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(208656);
    p.k(paramb, "referrerPolicyContainer");
    p.k(paramJSONObject, "data");
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.Referrers", "updateReferrers, component is null");
      AppMethodBeat.o(208656);
      return null;
    }
    a locala = (a)com.tencent.luggage.a.e.K(a.class);
    if (locala == null)
    {
      Log.w("MicroMsg.AppBrand.Referrers", "updateReferrers, referrerHelper is null");
      AppMethodBeat.o(208656);
      return null;
    }
    if (paramb.getReferrerPolicy() == null) {
      paramb.setReferrerPolicy(locala.bUd());
    }
    paramJSONObject = locala.a(paramJSONObject, parame);
    if (paramJSONObject != null) {
      paramb.setReferrerPolicy(paramJSONObject);
    }
    Log.i("MicroMsg.AppBrand.Referrers", "updateReferrers, referrerPolicy: " + paramb.getReferrerPolicy());
    if (c.pmz == paramb.getReferrerPolicy())
    {
      AppMethodBeat.o(208656);
      return null;
    }
    parame = locala.B(parame);
    Log.i("MicroMsg.AppBrand.Referrers", "updateReferrers, mReferrer: ".concat(String.valueOf(parame)));
    AppMethodBeat.o(208656);
    return parame;
  }
  
  public static final Map<String, String> aiy(String paramString)
  {
    AppMethodBeat.i(208658);
    Map localMap = null;
    if (paramString != null) {
      localMap = Collections.singletonMap("Referer", paramString);
    }
    AppMethodBeat.o(208658);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.d
 * JD-Core Version:    0.7.0.1
 */