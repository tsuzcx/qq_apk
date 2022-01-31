package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.u.i;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class JsApiCheckBioEnrollment
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 344;
  public static final String NAME = "checkIsSoterEnrolledInDevice";
  private JsApiCheckBioEnrollment.GetIsEnrolledTask glm = null;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.i("MicroMsg.JsApiCheckBioEnrollment", "hy: subapp start do check is enrolled");
    this.glm = new JsApiCheckBioEnrollment.GetIsEnrolledTask(paramc, paramInt, a.tU(paramJSONObject.optString("checkAuthMode")), this);
    i.aU(this.glm);
    AppBrandMainProcessService.a(this.glm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment
 * JD-Core Version:    0.7.0.1
 */