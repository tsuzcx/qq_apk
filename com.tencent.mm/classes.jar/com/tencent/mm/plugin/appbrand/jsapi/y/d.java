package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"REFERRER_HEADER_NAME", "", "TAG", "buildHeaders", "", "referrer", "updateReferrers", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "referrerPolicyContainer", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerPolicyContainer;", "data", "Lorg/json/JSONObject;", "luggage-commons_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final String a(f paramf, b paramb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(325701);
    s.u(paramb, "referrerPolicyContainer");
    s.u(paramJSONObject, "data");
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.Referrers", "updateReferrers, component is null");
      AppMethodBeat.o(325701);
      return null;
    }
    a locala = (a)e.T(a.class);
    if (locala == null)
    {
      Log.w("MicroMsg.AppBrand.Referrers", "updateReferrers, referrerHelper is null");
      AppMethodBeat.o(325701);
      return null;
    }
    if (paramb.getReferrerPolicy() == null) {
      paramb.setReferrerPolicy(locala.cuq());
    }
    paramJSONObject = locala.a(paramJSONObject, paramf);
    if (paramJSONObject != null) {
      paramb.setReferrerPolicy(paramJSONObject);
    }
    Log.i("MicroMsg.AppBrand.Referrers", s.X("updateReferrers, referrerPolicy: ", paramb.getReferrerPolicy()));
    if (c.srt == paramb.getReferrerPolicy())
    {
      AppMethodBeat.o(325701);
      return null;
    }
    paramf = locala.D(paramf);
    Log.i("MicroMsg.AppBrand.Referrers", s.X("updateReferrers, mReferrer: ", paramf));
    AppMethodBeat.o(325701);
    return paramf;
  }
  
  public static final Map<String, String> abw(String paramString)
  {
    AppMethodBeat.i(325704);
    Map localMap = null;
    if (paramString != null) {
      localMap = Collections.singletonMap("Referer", paramString);
    }
    AppMethodBeat.o(325704);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.d
 * JD-Core Version:    0.7.0.1
 */