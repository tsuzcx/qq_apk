package com.tencent.luggage.bridge;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONObject;

public final class d
  extends e
{
  public d(String paramString, JSONObject paramJSONObject)
  {
    super(b.bhp);
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("event name can not be null or empty");
    }
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    paramJSONObject = new HashMap();
    paramJSONObject.put("event", paramString);
    paramJSONObject.put("data", localJSONObject);
    c(new JSONObject(paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.bridge.d
 * JD-Core Version:    0.7.0.1
 */