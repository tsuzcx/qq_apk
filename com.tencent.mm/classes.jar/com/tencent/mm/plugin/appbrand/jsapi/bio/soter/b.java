package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 277;
  public static final String NAME = "startSoterAuthentication";
  private Class<?> jHr;
  private int scene;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(159051);
    ad.i("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: JsApiStartSoterAuthentication");
    Activity localActivity = (Activity)paramc.getContext();
    if (localActivity == null)
    {
      ad.e("MicroMsg.JsApiLuggageStartSoterAuthentication", "JsApiStartSoterAuthentication context is null, appId is %s", new Object[] { paramc.getAppId() });
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(159051);
      return;
    }
    if (this.jHr == null)
    {
      ad.e("MicroMsg.JsApiLuggageStartSoterAuthentication", "JsApiStartSoterAuthentication ui is null!");
      paramc.h(paramInt, e("fail:JsApiStartSoterAuthentication UI is null!", null));
      AppMethodBeat.o(159051);
      return;
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray("requestAuthModes");
    String str1 = paramJSONObject.optString("challenge");
    String str2 = paramJSONObject.optString("authContent");
    Intent localIntent = new Intent(localActivity, this.jHr);
    localIntent.putExtra("auth_mode", d.n(localJSONArray));
    localIntent.putExtra("challenge", str1);
    localIntent.putExtra("auth_content", str2);
    localIntent.putExtra("key_soter_fp_luggage_fromscene", 1);
    try
    {
      this.scene = paramJSONObject.getInt("scene");
      localIntent.putExtra("key_soter_fp_luggage_scene", this.scene);
      localIntent.putExtra("Soter_Result_Receiver", new JsApiLuggageStartSoterAuthentication.1(this, new Handler(Looper.getMainLooper()), paramc, paramInt));
      paramc = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(localActivity, paramc.adn(), "com/tencent/mm/plugin/appbrand/jsapi/bio/soter/JsApiLuggageStartSoterAuthentication", "invoke", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localActivity.startActivity((Intent)paramc.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/plugin/appbrand/jsapi/bio/soter/JsApiLuggageStartSoterAuthentication", "invoke", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(159051);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ad.i("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter authentication scene null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.b
 * JD-Core Version:    0.7.0.1
 */