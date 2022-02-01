package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"REFERRER_HEADER_NAME", "", "TAG", "buildHeaders", "", "referrer", "updateReferrers", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "referrerPolicyContainer", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerPolicyContainer;", "data", "Lorg/json/JSONObject;", "luggage-commons_release"})
public final class d
{
  public static final Map<String, String> MY(String paramString)
  {
    AppMethodBeat.i(201075);
    Map localMap = null;
    if (paramString != null) {
      localMap = Collections.singletonMap("Referer", paramString);
    }
    AppMethodBeat.o(201075);
    return localMap;
  }
  
  public static final String a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(201074);
    k.h(paramb, "referrerPolicyContainer");
    k.h(paramJSONObject, "data");
    if (paramc == null)
    {
      ac.w("MicroMsg.AppBrand.Referrers", "updateReferrers, component is null");
      AppMethodBeat.o(201074);
      return null;
    }
    a locala = (a)e.K(a.class);
    if (locala == null)
    {
      ac.w("MicroMsg.AppBrand.Referrers", "updateReferrers, referrerHelper is null");
      AppMethodBeat.o(201074);
      return null;
    }
    if (paramb.getReferrerPolicy() == null) {
      paramb.setReferrerPolicy(locala.biC());
    }
    paramJSONObject = locala.a(paramJSONObject, paramc);
    if (paramJSONObject != null) {
      paramb.setReferrerPolicy(paramJSONObject);
    }
    ac.i("MicroMsg.AppBrand.Referrers", "updateReferrers, referrerPolicy: " + paramb.getReferrerPolicy());
    if (c.kIJ == paramb.getReferrerPolicy())
    {
      AppMethodBeat.o(201074);
      return null;
    }
    paramc = locala.y(paramc);
    ac.i("MicroMsg.AppBrand.Referrers", "updateReferrers, mReferrer: ".concat(String.valueOf(paramc)));
    AppMethodBeat.o(201074);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.d
 * JD-Core Version:    0.7.0.1
 */