package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"REFERRER_HEADER_NAME", "", "TAG", "buildHeaders", "", "referrer", "updateReferrers", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "referrerPolicyContainer", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerPolicyContainer;", "data", "Lorg/json/JSONObject;", "luggage-commons_release"})
public final class d
{
  public static final String a(f paramf, b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(221366);
    p.h(paramb, "referrerPolicyContainer");
    p.h(paramJSONObject, "data");
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.Referrers", "updateReferrers, component is null");
      AppMethodBeat.o(221366);
      return null;
    }
    a locala = (a)e.M(a.class);
    if (locala == null)
    {
      Log.w("MicroMsg.AppBrand.Referrers", "updateReferrers, referrerHelper is null");
      AppMethodBeat.o(221366);
      return null;
    }
    if (paramb.getReferrerPolicy() == null) {
      paramb.setReferrerPolicy(locala.bIw());
    }
    paramJSONObject = locala.a(paramJSONObject, paramf);
    if (paramJSONObject != null) {
      paramb.setReferrerPolicy(paramJSONObject);
    }
    Log.i("MicroMsg.AppBrand.Referrers", "updateReferrers, referrerPolicy: " + paramb.getReferrerPolicy());
    if (c.mou == paramb.getReferrerPolicy())
    {
      AppMethodBeat.o(221366);
      return null;
    }
    paramf = locala.y(paramf);
    Log.i("MicroMsg.AppBrand.Referrers", "updateReferrers, mReferrer: ".concat(String.valueOf(paramf)));
    AppMethodBeat.o(221366);
    return paramf;
  }
  
  public static final Map<String, String> aaG(String paramString)
  {
    AppMethodBeat.i(221367);
    Map localMap = null;
    if (paramString != null) {
      localMap = Collections.singletonMap("Referer", paramString);
    }
    AppMethodBeat.o(221367);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.d
 * JD-Core Version:    0.7.0.1
 */