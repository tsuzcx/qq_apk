package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper;
import com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper.a;
import org.json.JSONObject;

public final class ag
  extends a
{
  public static final int CTRL_INDEX = 435;
  public static final String NAME = "adDataReport";
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(45432);
    AppBrandStatObject localAppBrandStatObject = com.tencent.mm.plugin.appbrand.a.CT(paramc.getAppId());
    if (localAppBrandStatObject != null) {}
    for (paramJSONObject = localAppBrandStatObject.scene + "," + localAppBrandStatObject.dbt + "," + localAppBrandStatObject.dzS + "," + localAppBrandStatObject.dzT + "," + paramJSONObject.optString("adInfo");; paramJSONObject = paramJSONObject.optString("adInfo"))
    {
      AdReportCgiHelper.a(15175, paramJSONObject + "," + q.cG(false), new AdReportCgiHelper.a()
      {
        public final void onDone()
        {
          AppMethodBeat.i(45431);
          paramc.h(paramInt, ag.this.e("ok", null));
          AppMethodBeat.o(45431);
        }
      });
      AppMethodBeat.o(45432);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag
 * JD-Core Version:    0.7.0.1
 */