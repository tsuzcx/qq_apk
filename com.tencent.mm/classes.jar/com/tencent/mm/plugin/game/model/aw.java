package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class aw
{
  public static JSONObject m(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(202454);
    Object localObject1 = paramJSONObject.optJSONObject("extInfo");
    String str;
    if (localObject1 == null)
    {
      str = paramJSONObject.optString("extInfo");
      if (str.length() <= 0) {}
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(str);
        localObject1 = localObject2;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new JSONObject();
        }
        if (paramString.compareTo("MSG_CENTER") == 0) {
          break;
        }
        AppMethodBeat.o(202454);
        return localObject2;
      }
      catch (JSONException localJSONException)
      {
        Log.i("MicroMsg.OpenGameJsapiProcessor", "extInfo parse error: %s", new Object[] { str });
      }
    }
    try
    {
      localJSONException.put("msgId", paramJSONObject.optString("msgId"));
      localJSONException.put("msgTabType", paramJSONObject.optString("msgTabType"));
      label120:
      AppMethodBeat.o(202454);
      return localJSONException;
    }
    catch (JSONException paramJSONObject)
    {
      break label120;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aw
 * JD-Core Version:    0.7.0.1
 */