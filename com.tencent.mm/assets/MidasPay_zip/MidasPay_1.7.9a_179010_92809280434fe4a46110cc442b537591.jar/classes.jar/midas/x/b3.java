package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class b3
  extends y1
{
  public b3()
  {
    a("https", String.format("/v1/r/%s/mobile_standalong_proc", new Object[] { p4.p().e().b.offerId }), "442");
    G();
  }
  
  public boolean F()
  {
    return false;
  }
  
  public void G()
  {
    c6 localc6 = c6.s0();
    o4 localo4 = p4.p().e();
    b("offer_id", p4.p().c());
    e("openkey", localo4.b.openKey);
    e("session_id", localo4.b.sessionId);
    e("session_type", localo4.b.sessionType);
    e("pf", localo4.b.pf);
    e("pfkey", localo4.b.pfKey);
    e("openid", localo4.b.openId);
    e("offer_id", p4.p().e().b.offerId);
    e("xg_mid", APAppDataInterface.singleton().C());
    Object localObject2 = localc6.W();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = localc6.V();
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = localc6.Y();
    }
    e("imei", (String)localObject2);
    e("androidid", localc6.V());
    e("mac", localc6.X());
    e("manufacturer", localc6.C());
    e("installqq", APAppDataInterface.singleton().i());
    e("installwechat", APAppDataInterface.singleton().j());
    e("sys_version", localc6.S());
    e("midascore_version", APAppDataInterface.singleton().q());
    e("installunionpay", APAppDataInterface.singleton().k());
    if (localc6.j().length() > 0) {
      e("appversion", localc6.j());
    }
    b("format", "json");
    localObject1 = localo4.f;
    if (localObject1 != null) {
      localObject1 = ((d5)localObject1).k;
    } else {
      localObject1 = "";
    }
    b("openid", localo4.b.openId);
    b("session_token", (String)localObject1);
    b("sdkversion", z5.c());
    b("reqtype", "cpay");
    b("extend", c6.s0().e());
    if (APAppDataInterface.singleton().h().equals("dev")) {
      b("offer_id", p4.p().e().b.offerId);
    }
    b("action", "android_report_record");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.b3
 * JD-Core Version:    0.7.0.1
 */