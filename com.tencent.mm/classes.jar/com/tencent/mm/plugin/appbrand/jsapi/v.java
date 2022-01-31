package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONObject;

public final class v
  extends a
{
  public static final int CTRL_INDEX = 435;
  public static final String NAME = "adDataReport";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppBrandStatObject localAppBrandStatObject = com.tencent.mm.plugin.appbrand.a.qp(paramc.getAppId());
    if (localAppBrandStatObject != null) {}
    for (paramJSONObject = localAppBrandStatObject.scene + "," + localAppBrandStatObject.bFv + "," + localAppBrandStatObject.caB + "," + localAppBrandStatObject.caC + "," + paramJSONObject.optString("adInfo");; paramJSONObject = paramJSONObject.optString("adInfo"))
    {
      AdReportCgiHelper.a(15175, paramJSONObject + "," + bk.fP(ae.getContext()), new v.1(this, paramc, paramInt));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v
 * JD-Core Version:    0.7.0.1
 */