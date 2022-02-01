package midas.x;

import android.text.TextUtils;
import java.util.UUID;
import org.json.JSONObject;

public class x9
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
  
  public static x9 a(String paramString)
  {
    try
    {
      localObject = new x9();
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject = paramString.optJSONObject("metadata");
      ((x9)localObject).a = localJSONObject.optString("id");
      ((x9)localObject).b = localJSONObject.optString("from_app_id");
      ((x9)localObject).c = localJSONObject.optString("from_openid");
      ((x9)localObject).d = localJSONObject.optString("from_client_id");
      ((x9)localObject).e = localJSONObject.optString("to_app_id");
      ((x9)localObject).f = localJSONObject.optString("to_openid");
      ((x9)localObject).g = localJSONObject.optString("to_client_id");
      ((x9)localObject).h = localJSONObject.optString("source");
      ((x9)localObject).i = localJSONObject.optString("cmd");
      ((x9)localObject).j = localJSONObject.optLong("timestamp");
      ((x9)localObject).k = paramString.optString("data");
      if (TextUtils.isEmpty(((x9)localObject).i)) {
        ((x9)localObject).i = "msg";
      }
      return localObject;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("from() Exception00= ");
      ((StringBuilder)localObject).append(paramString);
      ca.a("WSText", ((StringBuilder)localObject).toString());
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static x9 a(String paramString1, String paramString2, String paramString3)
  {
    x9 localx9 = new x9();
    localx9.a = String.valueOf(UUID.randomUUID());
    localx9.e = paramString1;
    localx9.f = paramString2;
    localx9.g = paramString3;
    localx9.h = "client";
    localx9.j = System.currentTimeMillis();
    return localx9;
  }
  
  public boolean a()
  {
    return "msg".equals(this.i);
  }
  
  public boolean b()
  {
    return "reblance".equals(this.i);
  }
  
  public String c()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.x9
 * JD-Core Version:    0.7.0.1
 */