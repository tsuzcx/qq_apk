package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ar$1
  implements MMActivity.a
{
  ar$1(ar paramar, o paramo, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      if (paramIntent == null) {
        break label128;
      }
    }
    label128:
    for (paramIntent = paramIntent.getStringExtra("key_app_authorize_state");; paramIntent = "") {
      try
      {
        paramIntent = new JSONArray(paramIntent);
        localJSONObject = new JSONObject();
      }
      catch (JSONException paramIntent)
      {
        try
        {
          JSONObject localJSONObject;
          localJSONObject.put("errMsg", this.ggN.getName() + ":ok");
          localJSONObject.put("authSetting", paramIntent);
          this.ggL.C(this.ggM, localJSONObject.toString());
          return;
          paramIntent = paramIntent;
          paramIntent = new JSONArray();
        }
        catch (JSONException paramIntent)
        {
          for (;;)
          {
            y.e("MicroMsg.JsApiOpenSetting", "set json error!");
            y.printErrStackTrace("MicroMsg.JsApiOpenSetting", paramIntent, "", new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ar.1
 * JD-Core Version:    0.7.0.1
 */