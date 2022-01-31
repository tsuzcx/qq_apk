package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends a
{
  public static final int CTRL_INDEX = 277;
  public static final String NAME = "startSoterAuthentication";
  private String hFp = "";
  private Class<?> hFq;
  private int scene = -1;
  
  public b(Class<?> paramClass)
  {
    this.hFq = paramClass;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(73793);
    ab.i("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: JsApiStartSoterAuthentication");
    Activity localActivity = (Activity)paramc.getContext();
    if (localActivity == null)
    {
      ab.e("MicroMsg.JsApiLuggageStartSoterAuthentication", "JsApiStartSoterAuthentication context is null, appId is %s", new Object[] { paramc.getAppId() });
      paramc.h(paramInt, j("fail", null));
      AppMethodBeat.o(73793);
      return;
    }
    if (this.hFq == null)
    {
      ab.e("MicroMsg.JsApiLuggageStartSoterAuthentication", "JsApiStartSoterAuthentication ui is null!");
      paramc.h(paramInt, j("fail:JsApiStartSoterAuthentication UI is null!", null));
      AppMethodBeat.o(73793);
      return;
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray("requestAuthModes");
    String str1 = paramJSONObject.optString("challenge");
    String str2 = paramJSONObject.optString("authContent");
    Intent localIntent = new Intent(localActivity, this.hFq);
    localIntent.putExtra("auth_mode", d.n(localJSONArray));
    localIntent.putExtra("challenge", str1);
    localIntent.putExtra("auth_content", str2);
    localIntent.putExtra("key_soter_fp_luggage_fromscene", 1);
    try
    {
      this.scene = paramJSONObject.getInt("scene");
      localIntent.putExtra("key_soter_fp_luggage_scene", this.scene);
      localIntent.putExtra("Soter_Result_Receiver", new JsApiLuggageStartSoterAuthentication.1(this, new Handler(Looper.getMainLooper()), paramc, paramInt));
      localActivity.startActivity(localIntent);
      AppMethodBeat.o(73793);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ab.i("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter authentication scene null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bio.soter.b
 * JD-Core Version:    0.7.0.1
 */