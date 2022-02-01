package c.t.m.g;

import org.json.JSONException;
import org.json.JSONObject;

public final class cb
{
  private static final cb c = new cb(0.0D, 0.0D);
  public final double a;
  public final double b;
  
  private cb(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public static cb a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString).getJSONObject("location");
      ((JSONObject)localObject).optInt("info");
      localObject = new cb(((JSONObject)localObject).getDouble("latitude"), ((JSONObject)localObject).getDouble("longitude"));
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      cj.a("DeflectData", "json error " + paramString, localJSONException);
    }
    return c;
  }
  
  public final boolean a()
  {
    return c == this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.cb
 * JD-Core Version:    0.7.0.1
 */