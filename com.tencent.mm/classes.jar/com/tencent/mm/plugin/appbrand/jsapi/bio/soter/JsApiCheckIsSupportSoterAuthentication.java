package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class JsApiCheckIsSupportSoterAuthentication
  extends a
{
  public static final int CTRL_INDEX = 276;
  public static final String NAME = "checkIsSupportSoterAuthentication";
  private JsApiCheckIsSupportSoterAuthentication.GetIsSupportSoterTask hFg = null;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(3223);
    ab.i("MicroMsg.JsApiCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
    this.hFg = new JsApiCheckIsSupportSoterAuthentication.GetIsSupportSoterTask(paramc, paramInt, this);
    h.bq(this.hFg);
    AppBrandMainProcessService.a(this.hFg);
    AppMethodBeat.o(3223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication
 * JD-Core Version:    0.7.0.1
 */