package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.u.i;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class JsApiCheckIsSupportSoterAuthentication
  extends a
{
  public static final int CTRL_INDEX = 276;
  public static final String NAME = "checkIsSupportSoterAuthentication";
  private JsApiCheckIsSupportSoterAuthentication.GetIsSupportSoterTask glq = null;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.i("MicroMsg.JsApiCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
    this.glq = new JsApiCheckIsSupportSoterAuthentication.GetIsSupportSoterTask(paramc, paramInt, this);
    i.aU(this.glq);
    AppBrandMainProcessService.a(this.glq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication
 * JD-Core Version:    0.7.0.1
 */