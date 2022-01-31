package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;

public final class bv
  extends bq
{
  final ad a = new ad();
  
  public bv()
  {
    m.i().post(new bw(this));
  }
  
  static String d()
  {
    return "Halley_Cloud_Param_Content_" + m.b() + "_for_SettingsHandler";
  }
  
  public final void a(bm parambm)
  {
    String str = this.a.c();
    parambm.a.put("confVersion", str);
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("Setting");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optString("data");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          this.a.a(paramJSONObject);
          paramJSONObject = this.a.a();
          m.a().getSharedPreferences(d(), 0).edit().putString("halley_cloud_param_content", paramJSONObject).commit();
        }
      }
      return;
    }
    catch (Throwable paramJSONObject) {}finally
    {
      m.i().post(new bx(this));
    }
  }
  
  public final void b()
  {
    m.i().post(new bx(this));
  }
  
  public final String c()
  {
    return "settings";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     c.t.m.g.bv
 * JD-Core Version:    0.7.0.1
 */