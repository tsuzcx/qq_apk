package midas.x;

import java.util.HashMap;
import okhttp3.Call;
import org.json.JSONObject;

public class ju
{
  public static void a()
  {
    kb.a().c();
  }
  
  public static void a(jm paramjm, jt<jp> paramjt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("register() request = ");
    ((StringBuilder)localObject1).append(paramjm);
    jw.b("RegisterManager", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramjm.c);
    ((StringBuilder)localObject1).append(paramjm.d);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new HashMap();
    ((HashMap)localObject2).put("app_id", paramjm.g);
    ((HashMap)localObject2).put("openid", paramjm.h);
    ((HashMap)localObject2).put("openkey", paramjm.i);
    ((HashMap)localObject2).put("session_id", paramjm.j);
    ((HashMap)localObject2).put("session_type", paramjm.k);
    ((HashMap)localObject2).put("pf", paramjm.l);
    ((HashMap)localObject2).put("pfkey", paramjm.m);
    ((HashMap)localObject2).put("client_id", paramjm.p);
    String str1 = kf.a();
    localObject2 = kj.a((HashMap)localObject2);
    String str2 = kf.a((String)localObject2, str1);
    str1 = kg.a(ki.a(str1, ki.a()));
    paramjm = kb.a().a((String)localObject1).a("app_id", paramjm.g).a("openid", paramjm.h).a("client_id", paramjm.p).a("encrypt_msg", str2).a("msg_len", String.valueOf(((String)localObject2).length())).a("key_msg", str1).a("req_from", paramjm.o);
    if (paramjm != null) {
      paramjm.a(new ka()
      {
        public void a(Call paramAnonymousCall, Exception paramAnonymousException)
        {
          this.a.a(-1, paramAnonymousException);
        }
        
        public void a(JSONObject paramAnonymousJSONObject)
        {
          jp localjp = new jp();
          localjp.a = paramAnonymousJSONObject.optString("token");
          localjp.b = paramAnonymousJSONObject.optString("client_id");
          paramAnonymousJSONObject = paramAnonymousJSONObject.optJSONObject("cridential");
          if (paramAnonymousJSONObject != null)
          {
            localjp.c = paramAnonymousJSONObject.optString("user");
            localjp.d = paramAnonymousJSONObject.optString("password");
          }
          this.a.a(localjp);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ju
 * JD-Core Version:    0.7.0.1
 */