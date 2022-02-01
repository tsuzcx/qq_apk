package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APGoodsRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;

public class q2
  extends y1
{
  public static HashMap<Integer, String> A = new HashMap();
  
  static
  {
    A.put(Integer.valueOf(0), "save");
    A.put(Integer.valueOf(2), "qd");
    A.put(Integer.valueOf(3), "qb");
    A.put(Integer.valueOf(4), "month");
    A.put(Integer.valueOf(5), "unimonth");
    A.put(Integer.valueOf(1), "bg");
  }
  
  public q2()
  {
    a("https", String.format("/v1/r/%s/mobile_get_token", new Object[] { p4.p().e().b.offerId }), "442");
    G();
  }
  
  public void G()
  {
    c6 localc6 = c6.s0();
    b("offer_id", p4.p().c());
    o4 localo4 = p4.p().e();
    b("openid", localo4.b.openId);
    e("openid", localo4.b.openId);
    e("openkey", localo4.b.openKey);
    e("session_id", localo4.b.sessionId);
    e("session_type", localo4.b.sessionType);
    e("extend", localc6.e());
    e("zoneid", localo4.b.zoneId);
    Object localObject1 = localo4.b;
    if (((APBaseRequest)localObject1).saveType == 4) {
      e("service_code", ((APMonthRequest)localObject1).serviceCode);
    }
    Object localObject2 = localo4.b;
    if (((APBaseRequest)localObject2).saveType == 5)
    {
      localObject1 = (z4)localo4.c;
      e("service_code", ((APMonthRequest)localObject2).serviceCode);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Service Code = ");
      ((StringBuilder)localObject2).append(((APMonthRequest)localo4.b).serviceCode);
      APLog.d("APGetTokenReq", ((StringBuilder)localObject2).toString());
      e("product_id", ((z4)localObject1).k);
      e("service_name", ((APMonthRequest)localo4.b).serviceName);
    }
    if ((a.r().m.equals("1")) || (a.r().m.equals("2")) || (14 == localo4.f.a()))
    {
      e("friends_pay", "1");
      localObject1 = localo4.b;
      if ((((APBaseRequest)localObject1).saveType == 1) && ((localObject1 instanceof APGoodsRequest)))
      {
        localObject1 = (APGoodsRequest)localObject1;
        if (1 == ((APGoodsRequest)localObject1).tokenType) {
          e("token_id", APTools.b(((APGoodsRequest)localObject1).goodsTokenUrl, "token_id"));
        } else {
          e("product_id", ((APGoodsRequest)localObject1).prodcutId);
        }
      }
    }
    localObject1 = (String)A.get(Integer.valueOf(localo4.b.saveType));
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      e("type", (String)localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Type = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      APLog.d("APGetTokenReq", ((StringBuilder)localObject2).toString());
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("type empty! save type = ");
      ((StringBuilder)localObject1).append(localo4.b.saveType);
      APLog.e("APGetTokenReq", ((StringBuilder)localObject1).toString());
    }
    if (APAppDataInterface.singleton().h().equals("dev")) {
      e("offer_id", p4.p().e().b.offerId);
    }
    b("openid", localo4.b.openId);
    b("pf", localo4.b.pf);
    b("pfkey", localo4.b.pfKey);
    b("buy_quantity", localo4.f.f);
    b("format", "json");
    b("sdkversion", z5.c());
    b("session_token", localo4.f.k);
    b("user_uuid", APTools.b(localc6.Y(), 1));
    b("user_imei", APTools.b(localc6.W(), 1));
    b("user_androidid", APTools.b(localc6.V(), 1));
    b("user_mac", APTools.b(localc6.X(), 1));
    b("xg_mid", APAppDataInterface.singleton().C());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.q2
 * JD-Core Version:    0.7.0.1
 */