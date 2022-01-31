package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class bd$1
  implements MMActivity.a
{
  bd$1(bd parambd, r paramr, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(130518);
    if (paramInt1 == 1) {
      if (paramIntent == null) {
        break label138;
      }
    }
    label138:
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
          localJSONObject.put("errMsg", this.hzi.getName() + ":ok");
          localJSONObject.put("authSetting", paramIntent);
          this.hzg.h(this.hzh, localJSONObject.toString());
          AppMethodBeat.o(130518);
          return;
          paramIntent = paramIntent;
          paramIntent = new JSONArray();
        }
        catch (JSONException paramIntent)
        {
          for (;;)
          {
            ab.e("MicroMsg.JsApiOpenSetting", "set json error!");
            ab.printErrStackTrace("MicroMsg.JsApiOpenSetting", paramIntent, "", new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bd.1
 * JD-Core Version:    0.7.0.1
 */