package com.tencent.luggage.bridge;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.json.JSONObject;

final class d
  extends e
{
  d(String paramString, JSONObject paramJSONObject)
  {
    super(b.cqs);
    AppMethodBeat.i(140316);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("event name can not be null or empty");
      AppMethodBeat.o(140316);
      throw paramString;
    }
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    paramJSONObject = new HashMap();
    paramJSONObject.put("event", paramString);
    paramJSONObject.put("data", localJSONObject);
    d(new JSONObject(paramJSONObject));
    AppMethodBeat.o(140316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.d
 * JD-Core Version:    0.7.0.1
 */