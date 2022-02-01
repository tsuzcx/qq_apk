package midas.x;

import java.util.HashMap;
import okhttp3.Call;
import org.json.JSONObject;

public class aa
{
  public static void a()
  {
    ha.c().a();
  }
  
  public static void a(s9 params9, z9<v9> paramz9)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("register() request = ");
    ((StringBuilder)localObject1).append(params9);
    ca.a("RegisterManager", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(params9.a);
    ((StringBuilder)localObject1).append(params9.b);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new HashMap();
    ((HashMap)localObject2).put("app_id", params9.e);
    ((HashMap)localObject2).put("openid", params9.f);
    ((HashMap)localObject2).put("openkey", params9.g);
    ((HashMap)localObject2).put("session_id", params9.h);
    ((HashMap)localObject2).put("session_type", params9.i);
    ((HashMap)localObject2).put("pf", params9.j);
    ((HashMap)localObject2).put("pfkey", params9.k);
    ((HashMap)localObject2).put("client_id", params9.n);
    String str2 = la.a();
    localObject2 = pa.a((HashMap)localObject2);
    String str1 = la.a((String)localObject2, str2);
    str2 = ma.a(oa.a(str2, oa.a()));
    localObject1 = ha.c().a((String)localObject1);
    ((fa)localObject1).a("app_id", params9.e);
    ((fa)localObject1).a("openid", params9.f);
    ((fa)localObject1).a("client_id", params9.n);
    ((fa)localObject1).a("encrypt_msg", str1);
    ((fa)localObject1).a("msg_len", String.valueOf(((String)localObject2).length()));
    ((fa)localObject1).a("key_msg", str2);
    ((fa)localObject1).a("req_from", params9.m);
    if (localObject1 != null) {
      ((fa)localObject1).a(new a(paramz9));
    }
  }
  
  public static final class a
    extends ga
  {
    public a(z9 paramz9) {}
    
    public void a(Call paramCall, Exception paramException)
    {
      this.a.a(-1, paramException);
    }
    
    public void a(JSONObject paramJSONObject)
    {
      v9 localv9 = new v9();
      localv9.a = paramJSONObject.optString("token");
      localv9.b = paramJSONObject.optString("client_id");
      paramJSONObject = paramJSONObject.optJSONObject("cridential");
      if (paramJSONObject != null)
      {
        localv9.c = paramJSONObject.optString("user");
        localv9.d = paramJSONObject.optString("password");
      }
      this.a.a(localv9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.aa
 * JD-Core Version:    0.7.0.1
 */