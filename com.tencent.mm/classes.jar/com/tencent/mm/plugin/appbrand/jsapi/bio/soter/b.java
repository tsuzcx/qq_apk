package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.soter.ui.SoterAuthenticationUIWC;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 277;
  public static final String NAME = "startSoterAuthentication";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.i("MicroMsg.JsApiStartSoterAuthentication", "hy: JsApiStartSoterAuthentication");
    if ((paramc.getContext() instanceof MMActivity)) {}
    for (MMActivity localMMActivity = (MMActivity)paramc.getContext(); localMMActivity == null; localMMActivity = null)
    {
      y.e("MicroMsg.JsApiStartSoterAuthentication", "JsApiStartSoterAuthentication context is null, appId is %s", new Object[] { paramc.getAppId() });
      paramc.C(paramInt, h("fail", null));
      return;
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray("requestAuthModes");
    String str = paramJSONObject.optString("challenge");
    paramJSONObject = paramJSONObject.optString("authContent");
    Intent localIntent = new Intent(localMMActivity, SoterAuthenticationUIWC.class);
    localIntent.putExtra("auth_mode", a.k(localJSONArray));
    localIntent.putExtra("challenge", str);
    localIntent.putExtra("auth_content", paramJSONObject);
    localIntent.putExtra("key_soter_fp_mp_scene", 0);
    localMMActivity.gJb = new b.1(this, paramc, paramInt);
    localMMActivity.startActivityForResult(localIntent, 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.b
 * JD-Core Version:    0.7.0.1
 */