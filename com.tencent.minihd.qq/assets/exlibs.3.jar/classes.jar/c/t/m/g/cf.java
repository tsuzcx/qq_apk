package c.t.m.g;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

public final class cf
{
  public static final cf a = new cf();
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public final Bundle k = new Bundle();
  private String l;
  
  private cf() {}
  
  private cf(cf paramcf)
  {
    if (paramcf.k.size() > 0)
    {
      this.k.putAll(paramcf.k);
      return;
    }
    this.b = paramcf.b;
    this.l = paramcf.l;
    this.c = paramcf.c;
    this.d = paramcf.d;
    this.e = paramcf.e;
    this.f = paramcf.f;
    this.g = paramcf.g;
    this.h = paramcf.h;
    this.i = paramcf.i;
    this.j = paramcf.j;
  }
  
  public cf(JSONObject paramJSONObject)
    throws JSONException
  {
    try
    {
      if (paramJSONObject.has("admin_level_1"))
      {
        String str1 = paramJSONObject.getString("nation");
        String str2 = paramJSONObject.getString("admin_level_1");
        String str3 = paramJSONObject.getString("admin_level_2");
        String str4 = paramJSONObject.getString("admin_level_3");
        String str5 = paramJSONObject.getString("locality");
        String str6 = paramJSONObject.getString("sublocality");
        paramJSONObject = paramJSONObject.getString("route");
        this.k.putString("nation", str1);
        this.k.putString("admin_level_1", str2);
        this.k.putString("admin_level_2", str3);
        this.k.putString("admin_level_3", str4);
        this.k.putString("locality", str5);
        this.k.putString("sublocality", str6);
        this.k.putString("route", paramJSONObject);
        return;
      }
      this.l = paramJSONObject.getString("name");
      this.c = paramJSONObject.getString("code");
      this.b = paramJSONObject.getString("nation");
      this.d = paramJSONObject.getString("province");
      this.e = paramJSONObject.getString("city");
      this.f = paramJSONObject.getString("district");
      this.g = paramJSONObject.getString("town");
      this.h = paramJSONObject.getString("village");
      this.i = paramJSONObject.getString("street");
      this.j = paramJSONObject.getString("street_no");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      cj.a("TencentJson", "json error", paramJSONObject);
      throw paramJSONObject;
    }
  }
  
  public static cf a(cf paramcf)
  {
    if (paramcf == null) {
      return null;
    }
    return new cf(paramcf);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SubnationData{");
    localStringBuilder.append("name=").append(this.l).append(",");
    localStringBuilder.append("code=").append(this.c).append(",");
    localStringBuilder.append("nation=").append(this.b).append(",");
    localStringBuilder.append("province=").append(this.d).append(",");
    localStringBuilder.append("city=").append(this.e).append(",");
    localStringBuilder.append("district=").append(this.f).append(",");
    localStringBuilder.append("town=").append(this.g).append(",");
    localStringBuilder.append("village=").append(this.h).append(",");
    localStringBuilder.append("street=").append(this.i).append(",");
    localStringBuilder.append("street_no=").append(this.j).append(",");
    localStringBuilder.append("bundle").append(this.k).append(",");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.cf
 * JD-Core Version:    0.7.0.1
 */