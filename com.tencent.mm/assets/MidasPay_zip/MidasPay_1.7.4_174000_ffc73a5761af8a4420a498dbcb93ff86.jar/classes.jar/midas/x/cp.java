package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;

public class cp
  extends bx
{
  private static HashMap<Integer, String> a = new HashMap();
  
  static
  {
    a.put(Integer.valueOf(0), "save");
    a.put(Integer.valueOf(2), "qd");
    a.put(Integer.valueOf(3), "qb");
    a.put(Integer.valueOf(4), "month");
    a.put(Integer.valueOf(5), "unimonth");
  }
  
  public cp()
  {
    a("https", String.format("/v1/r/%s/mobile_get_token", new Object[] { em.b().n().a.offerId }), "442");
    c();
  }
  
  public void c()
  {
    fy localfy = fy.a();
    e("offer_id", em.b().f());
    el localel = em.b().n();
    e("openid", localel.a.openId);
    f("openid", localel.a.openId);
    f("openkey", localel.a.openKey);
    f("session_id", localel.a.sessionId);
    f("session_type", localel.a.sessionType);
    f("extend", localfy.y());
    f("zoneid", localel.a.zoneId);
    if (localel.a.saveType == 4) {
      f("service_code", ((APMonthRequest)localel.a).serviceCode);
    }
    StringBuilder localStringBuilder;
    if (localel.a.saveType == 5)
    {
      localObject = (ew)localel.b;
      f("service_code", ((APMonthRequest)localel.a).serviceCode);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Service Code = ");
      localStringBuilder.append(((APMonthRequest)localel.a).serviceCode);
      APLog.d("APGetTokenReq", localStringBuilder.toString());
      f("product_id", ((ew)localObject).k);
      f("service_name", ((APMonthRequest)localel.a).serviceName);
    }
    if ((a.a().i.equals("1")) || (a.a().i.equals("2")) || (14 == localel.e.a())) {
      f("friends_pay", "1");
    }
    Object localObject = (String)a.get(Integer.valueOf(localel.a.saveType));
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      f("type", (String)localObject);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Type = ");
      localStringBuilder.append((String)localObject);
      APLog.d("APGetTokenReq", localStringBuilder.toString());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("type empty! save type = ");
      ((StringBuilder)localObject).append(localel.a.saveType);
      APLog.e("APGetTokenReq", ((StringBuilder)localObject).toString());
    }
    if (APAppDataInterface.singleton().e().equals("dev")) {
      f("offer_id", em.b().n().a.offerId);
    }
    e("openid", localel.a.openId);
    e("pf", localel.a.pf);
    e("pfkey", localel.a.pfKey);
    e("buy_quantity", localel.e.g);
    e("format", "json");
    e("sdkversion", fv.c());
    e("session_token", localel.e.l);
    e("user_uuid", APTools.a(localfy.q(), 1));
    e("user_imei", APTools.a(localfy.r(), 1));
    e("user_androidid", APTools.a(localfy.s(), 1));
    e("user_mac", APTools.a(localfy.t(), 1));
    e("xg_mid", APAppDataInterface.singleton().l());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.cp
 * JD-Core Version:    0.7.0.1
 */