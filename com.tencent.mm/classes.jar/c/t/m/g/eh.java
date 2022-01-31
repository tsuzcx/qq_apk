package c.t.m.g;

import org.json.JSONException;
import org.json.JSONObject;

final class eh
{
  public String a;
  public String b;
  public int c;
  
  eh() {}
  
  public eh(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.getString("bid");
      this.b = paramJSONObject.getString("floor");
      this.c = paramJSONObject.getInt("type");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      j.a("TencentJson", "json error", paramJSONObject);
      throw paramJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     c.t.m.g.eh
 * JD-Core Version:    0.7.0.1
 */