package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  public static final int CTRL_INDEX = 277;
  public static final String NAME = "startSoterAuthentication";
  private Class<?> lKz;
  private int scene;
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(159051);
    Log.i("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: JsApiStartSoterAuthentication");
    Activity localActivity = (Activity)paramf.getContext();
    if (localActivity == null)
    {
      Log.e("MicroMsg.JsApiLuggageStartSoterAuthentication", "JsApiStartSoterAuthentication context is null, appId is %s", new Object[] { paramf.getAppId() });
      paramf.i(paramInt, h("fail", null));
      AppMethodBeat.o(159051);
      return;
    }
    if (this.lKz == null)
    {
      Log.e("MicroMsg.JsApiLuggageStartSoterAuthentication", "JsApiStartSoterAuthentication ui is null!");
      paramf.i(paramInt, h("fail:JsApiStartSoterAuthentication UI is null!", null));
      AppMethodBeat.o(159051);
      return;
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray("requestAuthModes");
    String str1 = paramJSONObject.optString("challenge");
    String str2 = paramJSONObject.optString("authContent");
    Intent localIntent = new Intent(localActivity, this.lKz);
    localIntent.putExtra("auth_mode", d.o(localJSONArray));
    localIntent.putExtra("challenge", str1);
    localIntent.putExtra("auth_content", str2);
    localIntent.putExtra("key_soter_fp_luggage_fromscene", 1);
    try
    {
      this.scene = paramJSONObject.getInt("scene");
      localIntent.putExtra("key_soter_fp_luggage_scene", this.scene);
      localIntent.putExtra("Soter_Result_Receiver", new JsApiLuggageStartSoterAuthentication.1(this, new Handler(Looper.getMainLooper()), paramf, paramInt));
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(localActivity, paramf.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/bio/soter/JsApiLuggageStartSoterAuthentication", "invoke", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localActivity.startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/plugin/appbrand/jsapi/bio/soter/JsApiLuggageStartSoterAuthentication", "invoke", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(159051);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        Log.i("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter authentication scene null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.b
 * JD-Core Version:    0.7.0.1
 */