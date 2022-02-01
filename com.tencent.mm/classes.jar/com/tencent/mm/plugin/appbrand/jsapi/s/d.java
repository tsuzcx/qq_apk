package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"REFERRER_HEADER_NAME", "", "TAG", "buildHeaders", "", "referrer", "updateReferrers", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "referrerPolicyContainer", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerPolicyContainer;", "data", "Lorg/json/JSONObject;", "luggage-commons_release"})
public final class d
{
  public static final Map<String, String> Re(String paramString)
  {
    AppMethodBeat.i(201137);
    Map localMap = null;
    if (paramString != null) {
      localMap = Collections.singletonMap("Referer", paramString);
    }
    AppMethodBeat.o(201137);
    return localMap;
  }
  
  public static final String a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(201136);
    p.h(paramb, "referrerPolicyContainer");
    p.h(paramJSONObject, "data");
    if (paramc == null)
    {
      ae.w("MicroMsg.AppBrand.Referrers", "updateReferrers, component is null");
      AppMethodBeat.o(201136);
      return null;
    }
    a locala = (a)e.K(a.class);
    if (locala == null)
    {
      ae.w("MicroMsg.AppBrand.Referrers", "updateReferrers, referrerHelper is null");
      AppMethodBeat.o(201136);
      return null;
    }
    if (paramb.getReferrerPolicy() == null) {
      paramb.setReferrerPolicy(locala.bmX());
    }
    paramJSONObject = locala.a(paramJSONObject, paramc);
    if (paramJSONObject != null) {
      paramb.setReferrerPolicy(paramJSONObject);
    }
    ae.i("MicroMsg.AppBrand.Referrers", "updateReferrers, referrerPolicy: " + paramb.getReferrerPolicy());
    if (c.liO == paramb.getReferrerPolicy())
    {
      AppMethodBeat.o(201136);
      return null;
    }
    paramc = locala.y(paramc);
    ae.i("MicroMsg.AppBrand.Referrers", "updateReferrers, mReferrer: ".concat(String.valueOf(paramc)));
    AppMethodBeat.o(201136);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.d
 * JD-Core Version:    0.7.0.1
 */