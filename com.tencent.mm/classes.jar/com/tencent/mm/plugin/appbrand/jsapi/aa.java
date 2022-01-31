package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper;
import org.json.JSONObject;

public final class aa
  extends a
{
  public static final int CTRL_INDEX = 435;
  public static final String NAME = "adDataReport";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(130372);
    AppBrandStatObject localAppBrandStatObject = com.tencent.mm.plugin.appbrand.a.xN(paramc.getAppId());
    if (localAppBrandStatObject != null) {}
    for (paramJSONObject = localAppBrandStatObject.scene + "," + localAppBrandStatObject.cmF + "," + localAppBrandStatObject.cJb + "," + localAppBrandStatObject.cJc + "," + paramJSONObject.optString("adInfo");; paramJSONObject = paramJSONObject.optString("adInfo"))
    {
      AdReportCgiHelper.a(15175, paramJSONObject + "," + q.bP(false), new aa.1(this, paramc, paramInt));
      AppMethodBeat.o(130372);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa
 * JD-Core Version:    0.7.0.1
 */