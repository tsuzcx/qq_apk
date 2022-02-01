package midas.x;

import org.json.JSONObject;

public class bi
{
  public int a = -1;
  public int b = 0;
  public int c = 0;
  public int d = -1;
  public int e = -1;
  public int f = -1;
  public String g = null;
  public String h = null;
  public String i = null;
  public String j = null;
  public String k = null;
  
  public bi a(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.getInt("resultCode");
      this.c = paramJSONObject.getInt("realSaveNum");
      this.b = paramJSONObject.getInt("resultInerCode");
      this.d = paramJSONObject.getInt("payChannel");
      this.e = paramJSONObject.getInt("payState");
      this.f = paramJSONObject.getInt("provideState");
      this.g = paramJSONObject.getString("resultCode");
      this.h = paramJSONObject.getString("resultCode");
      this.i = paramJSONObject.getString("payReserve1");
      this.j = paramJSONObject.getString("payReserve1");
      this.k = paramJSONObject.getString("payReserve1");
      return this;
    }
    catch (Exception paramJSONObject) {}
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.bi
 * JD-Core Version:    0.7.0.1
 */