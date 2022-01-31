package com.tencent.c.a.a;

import org.json.JSONException;
import org.json.JSONObject;

final class a
{
  public static String bta = "ts";
  public static String btb = "times";
  public static String btc = "mfreq";
  public static String btd = "mdays";
  long bsW = 0L;
  int bsX = 0;
  int bsY = 100;
  int bsZ = 3;
  
  a() {}
  
  a(String paramString)
  {
    if (!s.bF(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.isNull(bta)) {
          this.bsW = paramString.getLong(bta);
        }
        if (!paramString.isNull(btc)) {
          this.bsY = paramString.getInt(btc);
        }
        if (!paramString.isNull(btb)) {
          this.bsX = paramString.getInt(btb);
        }
        if (!paramString.isNull(btd))
        {
          this.bsZ = paramString.getInt(btd);
          return;
        }
      }
      catch (JSONException paramString) {}
    }
  }
  
  public final String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(bta, this.bsW);
      localJSONObject.put(btb, this.bsX);
      localJSONObject.put(btc, this.bsY);
      localJSONObject.put(btd, this.bsZ);
      label56:
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      break label56;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */