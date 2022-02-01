package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;

public class cu
  extends br
{
  public cu()
  {
    a("https", String.format("/v1/r/%s/mobile_standalong_proc", new Object[] { ed.b().n().a.offerId }), "442");
    c();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void c()
  {
    fp localfp = fp.a();
    ec localec = ed.b().n();
    e("offer_id", ed.b().f());
    f("openkey", localec.a.openKey);
    f("session_id", localec.a.sessionId);
    f("session_type", localec.a.sessionType);
    f("pf", localec.a.pf);
    f("pfkey", localec.a.pfKey);
    f("openid", localec.a.openId);
    f("offer_id", ed.b().n().a.offerId);
    f("xg_mid", APAppDataInterface.singleton().l());
    Object localObject2 = localfp.r();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = localfp.s();
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = localfp.q();
    }
    f("imei", (String)localObject2);
    f("androidid", localfp.s());
    f("mac", localfp.t());
    f("manufacturer", localfp.C());
    f("installqq", APAppDataInterface.singleton().q());
    f("installwechat", APAppDataInterface.singleton().r());
    f("sys_version", localfp.E());
    f("midascore_version", APAppDataInterface.singleton().n());
    if (localfp.w().length() > 0) {
      f("appversion", localfp.w());
    }
    e("format", "json");
    localObject1 = "";
    if (localec.e != null) {
      localObject1 = localec.e.l;
    }
    e("openid", localec.a.openId);
    e("session_token", (String)localObject1);
    e("sdkversion", fm.c());
    e("reqtype", "cpay");
    e("extend", fp.a().y());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", ed.b().n().a.offerId);
    }
    e("action", "android_report_record");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.cu
 * JD-Core Version:    0.7.0.1
 */