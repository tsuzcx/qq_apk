package midas.x;

import android.text.TextUtils;
import java.util.UUID;
import org.json.JSONObject;

public class jr
{
  public String a = null;
  public String b = null;
  public String c = null;
  public String d = null;
  public String e = null;
  public String f = null;
  public String g = null;
  public String h = null;
  public String i = null;
  public long j = 0L;
  public String k = null;
  
  public static jr a(String paramString)
  {
    try
    {
      localObject = new jr();
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject = paramString.optJSONObject("metadata");
      ((jr)localObject).a = localJSONObject.optString("id");
      ((jr)localObject).b = localJSONObject.optString("from_app_id");
      ((jr)localObject).c = localJSONObject.optString("from_openid");
      ((jr)localObject).d = localJSONObject.optString("from_client_id");
      ((jr)localObject).e = localJSONObject.optString("to_app_id");
      ((jr)localObject).f = localJSONObject.optString("to_openid");
      ((jr)localObject).g = localJSONObject.optString("to_client_id");
      ((jr)localObject).h = localJSONObject.optString("source");
      ((jr)localObject).i = localJSONObject.optString("cmd");
      ((jr)localObject).j = localJSONObject.optLong("timestamp");
      ((jr)localObject).k = paramString.optString("data");
      if (TextUtils.isEmpty(((jr)localObject).i)) {
        ((jr)localObject).i = "msg";
      }
      return localObject;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("from() Exception00= ");
      ((StringBuilder)localObject).append(paramString);
      jw.b("WSText", ((StringBuilder)localObject).toString());
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static jr a(String paramString1, String paramString2, String paramString3)
  {
    jr localjr = new jr();
    localjr.a = String.valueOf(UUID.randomUUID());
    localjr.e = paramString1;
    localjr.f = paramString2;
    localjr.g = paramString3;
    localjr.h = "client";
    localjr.j = System.currentTimeMillis();
    return localjr;
  }
  
  public String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("id", this.a);
      ((JSONObject)localObject).put("from_app_id", this.b);
      ((JSONObject)localObject).put("from_openid", this.c);
      ((JSONObject)localObject).put("from_client_id", this.d);
      ((JSONObject)localObject).put("to_app_id", this.e);
      ((JSONObject)localObject).put("to_openid", this.f);
      ((JSONObject)localObject).put("to_client_id", this.g);
      ((JSONObject)localObject).put("source", this.h);
      ((JSONObject)localObject).put("cmd", this.i);
      ((JSONObject)localObject).put("timestamp", this.j);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("metadata", localObject);
      localJSONObject.put("data", this.k);
      localObject = localJSONObject.toString();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return super.toString();
  }
  
  public boolean b()
  {
    return "msg".equals(this.i);
  }
  
  public boolean c()
  {
    return "reblance".equals(this.i);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSText{id='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fromAppId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fromOpenId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fromClientId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", toAppId='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", toOpenId='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", toClientId='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", source='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cmd='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", timestamp=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", data='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.jr
 * JD-Core Version:    0.7.0.1
 */