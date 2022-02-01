package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;

public class cj
  extends br
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
  
  public cj()
  {
    a("https", String.format("/v1/r/%s/mobile_get_token", new Object[] { ed.b().n().a.offerId }), "442");
    c();
  }
  
  public void c()
  {
    fp localfp = fp.a();
    e("offer_id", ed.b().f());
    ec localec = ed.b().n();
    e("openid", localec.a.openId);
    f("openid", localec.a.openId);
    f("openkey", localec.a.openKey);
    f("session_id", localec.a.sessionId);
    f("session_type", localec.a.sessionType);
    f("extend", localfp.y());
    f("zoneid", localec.a.zoneId);
    if (localec.a.saveType == 4) {
      f("service_code", ((APMonthRequest)localec.a).serviceCode);
    }
    StringBuilder localStringBuilder;
    if (localec.a.saveType == 5)
    {
      localObject = (en)localec.b;
      f("service_code", ((APMonthRequest)localec.a).serviceCode);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Service Code = ");
      localStringBuilder.append(((APMonthRequest)localec.a).serviceCode);
      APLog.d("APGetTokenReq", localStringBuilder.toString());
      f("product_id", ((en)localObject).k);
      f("service_name", ((APMonthRequest)localec.a).serviceName);
    }
    if ((a.a().i.equals("1")) || (a.a().i.equals("2")) || (14 == localec.e.a())) {
      f("friends_pay", "1");
    }
    Object localObject = (String)a.get(Integer.valueOf(localec.a.saveType));
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
      ((StringBuilder)localObject).append(localec.a.saveType);
      APLog.e("APGetTokenReq", ((StringBuilder)localObject).toString());
    }
    if (APAppDataInterface.singleton().e().equals("dev")) {
      f("offer_id", ed.b().n().a.offerId);
    }
    e("openid", localec.a.openId);
    e("pf", localec.a.pf);
    e("pfkey", localec.a.pfKey);
    e("buy_quantity", localec.e.g);
    e("format", "json");
    e("sdkversion", fm.c());
    e("session_token", localec.e.l);
    e("user_uuid", APTools.a(localfp.q(), 1));
    e("user_imei", APTools.a(localfp.r(), 1));
    e("user_androidid", APTools.a(localfp.s(), 1));
    e("user_mac", APTools.a(localfp.t(), 1));
    e("xg_mid", APAppDataInterface.singleton().l());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.cj
 * JD-Core Version:    0.7.0.1
 */