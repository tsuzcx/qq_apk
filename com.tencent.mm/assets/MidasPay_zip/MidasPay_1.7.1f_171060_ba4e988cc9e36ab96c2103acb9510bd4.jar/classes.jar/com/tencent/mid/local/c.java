package com.tencent.mid.local;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

class c
{
  String a = null;
  String b = null;
  String c = "0";
  long d = 0L;
  
  static c a(String paramString)
  {
    c localc = new c();
    if (i.b(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.isNull("ui")) {
          localc.a = paramString.getString("ui");
        }
        if (!paramString.isNull("mc")) {
          localc.b = paramString.getString("mc");
        }
        if (!paramString.isNull("mid")) {
          localc.c = paramString.getString("mid");
        }
        if (!paramString.isNull("ts"))
        {
          localc.d = paramString.getLong("ts");
          return localc;
        }
      }
      catch (JSONException paramString)
      {
        Log.w("MID", "", paramString);
      }
    }
    return localc;
  }
  
  boolean a()
  {
    return i.c(this.c);
  }
  
  JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      i.a(localJSONObject, "ui", this.a);
      i.a(localJSONObject, "mc", this.b);
      i.a(localJSONObject, "mid", this.c);
      localJSONObject.put("ts", this.d);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      i.a(localJSONException);
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    return b().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.tencent.mid.local.c
 * JD-Core Version:    0.7.0.1
 */