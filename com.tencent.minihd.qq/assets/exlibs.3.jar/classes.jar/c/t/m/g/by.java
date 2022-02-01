package c.t.m.g;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class by
{
  public final bz a;
  public final bw b;
  public final bx c;
  
  public by(bz parambz, bw parambw, bx parambx)
  {
    this.a = parambz;
    this.b = parambw;
    this.c = parambx;
  }
  
  public final String a(int paramInt, String paramString, bf parambf)
  {
    String str1 = b.a.a(this.a);
    String str2 = b.a.b(this.b);
    String str3 = b.a.a(this.c);
    Object localObject2 = parambf.d();
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put("imei", ((bg)localObject2).a());
    ((HashMap)localObject1).put("imsi", ((bg)localObject2).b());
    ((HashMap)localObject1).put("phonenum", b.a.a(((bg)localObject2).e));
    ((HashMap)localObject1).put("qq", b.a.a(((bg)localObject2).g));
    parambf = ((bg)localObject2).a.a();
    String str4;
    String str5;
    if (b.a.b(parambf))
    {
      parambf = Boolean.toString(parambf.isNetworkRoaming());
      ((HashMap)localObject1).put("roaming", parambf);
      localObject1 = new JSONObject((Map)localObject1).toString();
      str4 = ((bg)localObject2).a();
      str5 = ((bg)localObject2).b();
      if (!TextUtils.isEmpty(((bg)localObject2).f)) {
        break label327;
      }
    }
    label327:
    for (parambf = "0123456789ABCDEF";; parambf = ((bg)localObject2).f)
    {
      parambf = b.a.a(str4, str5, parambf);
      localObject2 = "{\"version\":\"0.3.1.10\",\"address\":" + paramInt;
      paramString = (String)localObject2 + ",\"source\":203,\"access_token\":\"" + parambf + "\",\"app_name\":\"" + paramString + "\",\"bearing\":1";
      paramString = paramString + ",\"control\":2";
      return paramString + ",\"attribute\":" + (String)localObject1 + ",\"location\":" + str3 + ",\"cells\":" + str2 + ",\"wifis\":" + str1 + "}";
      parambf = "false";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.by
 * JD-Core Version:    0.7.0.1
 */