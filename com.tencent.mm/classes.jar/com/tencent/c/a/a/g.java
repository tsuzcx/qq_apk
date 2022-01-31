package com.tencent.c.a.a;

import org.json.JSONException;
import org.json.JSONObject;

final class g
{
  String aYO = null;
  String btt = null;
  String btu = "0";
  long btv = 0L;
  
  static g bE(String paramString)
  {
    g localg = new g();
    if (s.bF(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.isNull("ui")) {
        localg.aYO = paramString.getString("ui");
      }
      if (!paramString.isNull("mc")) {
        localg.btt = paramString.getString("mc");
      }
      if (!paramString.isNull("mid")) {
        localg.btu = paramString.getString("mid");
      }
      if (!paramString.isNull("ts")) {
        localg.btv = paramString.getLong("ts");
      }
      return localg;
    }
    catch (JSONException paramString) {}
    return localg;
  }
  
  private JSONObject rx()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      s.a(localJSONObject, "ui", this.aYO);
      s.a(localJSONObject, "mc", this.btt);
      s.a(localJSONObject, "mid", this.btu);
      localJSONObject.put("ts", this.btv);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  final int a(g paramg)
  {
    if (paramg == null) {}
    do
    {
      do
      {
        return 1;
        if ((!s.bG(this.btu)) || (!s.bG(paramg.btu))) {
          break;
        }
        if (this.btu.equals(paramg.btu)) {
          return 0;
        }
      } while (this.btv >= paramg.btv);
      return -1;
    } while (s.bG(this.btu));
    return -1;
  }
  
  public final String toString()
  {
    return rx().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.c.a.a.g
 * JD-Core Version:    0.7.0.1
 */