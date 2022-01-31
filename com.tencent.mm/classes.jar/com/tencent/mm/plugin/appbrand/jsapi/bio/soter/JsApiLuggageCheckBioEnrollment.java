package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class JsApiLuggageCheckBioEnrollment
  extends a
{
  public static final int CTRL_INDEX = 344;
  public static final String NAME = "checkIsSoterEnrolledInDevice";
  private static Context hFk = null;
  private JsApiLuggageCheckBioEnrollment.GetIsEnrolledTask hFj = null;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(73783);
    hFk = paramc.getContext();
    ab.i("MicroMsg.JsApiLuggageCheckBioEnrollment", "hy: subapp start do check is enrolled");
    this.hFj = new JsApiLuggageCheckBioEnrollment.GetIsEnrolledTask(paramc, paramInt, d.BT(paramJSONObject.optString("checkAuthMode")), this);
    h.bq(this.hFj);
    AppBrandMainProcessService.a(this.hFj);
    AppMethodBeat.o(73783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageCheckBioEnrollment
 * JD-Core Version:    0.7.0.1
 */