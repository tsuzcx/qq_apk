package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class da
  extends bx
{
  public da()
  {
    a("https", String.format("/v1/r/%s/mobile_standalong_proc", new Object[] { em.b().n().a.offerId }), "442");
    c();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void c()
  {
    fy localfy = fy.a();
    el localel = em.b().n();
    e("offer_id", em.b().f());
    f("openkey", localel.a.openKey);
    f("session_id", localel.a.sessionId);
    f("session_type", localel.a.sessionType);
    f("pf", localel.a.pf);
    f("pfkey", localel.a.pfKey);
    f("openid", localel.a.openId);
    f("offer_id", em.b().n().a.offerId);
    f("xg_mid", APAppDataInterface.singleton().l());
    Object localObject2 = localfy.r();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = localfy.s();
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = localfy.q();
    }
    f("imei", (String)localObject2);
    f("androidid", localfy.s());
    f("mac", localfy.t());
    f("manufacturer", localfy.C());
    f("installqq", APAppDataInterface.singleton().q());
    f("installwechat", APAppDataInterface.singleton().r());
    f("sys_version", localfy.E());
    f("midascore_version", APAppDataInterface.singleton().n());
    if (localfy.w().length() > 0) {
      f("appversion", localfy.w());
    }
    e("format", "json");
    localObject1 = "";
    if (localel.e != null) {
      localObject1 = localel.e.l;
    }
    e("openid", localel.a.openId);
    e("session_token", (String)localObject1);
    e("sdkversion", fv.c());
    e("reqtype", "cpay");
    e("extend", fy.a().y());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", em.b().n().a.offerId);
    }
    e("action", "android_report_record");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.da
 * JD-Core Version:    0.7.0.1
 */