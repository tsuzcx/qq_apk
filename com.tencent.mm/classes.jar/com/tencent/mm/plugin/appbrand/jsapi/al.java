package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper;
import com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper.a;
import org.json.JSONObject;

public final class al
  extends d
{
  public static final int CTRL_INDEX = 435;
  public static final String NAME = "adDataReport";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(45432);
    AppBrandStatObject localAppBrandStatObject = a.TS(paramf.getAppId());
    if (localAppBrandStatObject != null) {}
    for (paramJSONObject = localAppBrandStatObject.scene + "," + localAppBrandStatObject.dCw + "," + localAppBrandStatObject.ecU + "," + localAppBrandStatObject.ecV + "," + paramJSONObject.optString("adInfo");; paramJSONObject = paramJSONObject.optString("adInfo"))
    {
      AdReportCgiHelper.a(15175, paramJSONObject + "," + q.dr(false), new AdReportCgiHelper.a()
      {
        public final void onDone()
        {
          AppMethodBeat.i(45431);
          paramf.i(paramInt, al.this.h("ok", null));
          AppMethodBeat.o(45431);
        }
      });
      AppMethodBeat.o(45432);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al
 * JD-Core Version:    0.7.0.1
 */