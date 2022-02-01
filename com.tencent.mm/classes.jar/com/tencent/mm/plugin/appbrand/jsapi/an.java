package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper;
import com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper.a;
import org.json.JSONObject;

public final class an
  extends c
{
  public static final int CTRL_INDEX = 435;
  public static final String NAME = "adDataReport";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(45432);
    AppBrandStatObject localAppBrandStatObject = d.Ue(paramf.getAppId());
    if (localAppBrandStatObject != null) {}
    for (paramJSONObject = localAppBrandStatObject.scene + "," + localAppBrandStatObject.hzx + "," + localAppBrandStatObject.icZ + "," + localAppBrandStatObject.ida + "," + paramJSONObject.optString("adInfo");; paramJSONObject = paramJSONObject.optString("adInfo"))
    {
      AdReportCgiHelper.a(15175, paramJSONObject + "," + q.eD(false), new AdReportCgiHelper.a()
      {
        public final void onDone()
        {
          AppMethodBeat.i(45431);
          paramf.callback(paramInt, an.this.ZP("ok"));
          AppMethodBeat.o(45431);
        }
      });
      AppMethodBeat.o(45432);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.an
 * JD-Core Version:    0.7.0.1
 */