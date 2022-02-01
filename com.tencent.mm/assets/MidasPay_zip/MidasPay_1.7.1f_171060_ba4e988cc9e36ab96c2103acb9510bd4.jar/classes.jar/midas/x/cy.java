package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class cy
  extends bx
{
  public cy()
  {
    a("https", String.format("/v1/r/%s/mobile_buy_page", new Object[] { ed.b().n().a.offerId }), "442");
    b();
  }
  
  private void a(eq parameq)
  {
    parameq = fp.a();
    Object localObject = ed.b().n();
    f("openid", ((ec)localObject).a.openId);
    f("openkey", ((ec)localObject).a.openKey);
    f("jsversion", APAppDataInterface.singleton().p());
    f("extend", parameq.y());
    if (!APAppDataInterface.singleton().e().equals("release"))
    {
      if (APAppDataInterface.singleton().z()) {
        f("encrypt_rsp", "1");
      }
    }
    else {
      f("encrypt_rsp", "1");
    }
    f("installqq", APAppDataInterface.singleton().q());
    f("installwechat", APAppDataInterface.singleton().r());
    f("qqversion", APAppDataInterface.singleton().s());
    f("wechatversion", APAppDataInterface.singleton().t());
    f("isnewmpaymode", "1");
    if ((!TextUtils.isEmpty(fp.a().Q())) && (!TextUtils.isEmpty(fp.a().R())))
    {
      f("callpkname", fp.a().Q());
      f("callpksign", fp.a().R());
    }
    e("pre_uuid", fv.b().c());
    e("drm_act_type", fv.b().d());
    e("drm_resource", fv.b().e());
    parameq = "0";
    boolean bool1 = bl.a().b();
    boolean bool2 = bl.a().c();
    if (bool1) {
      parameq = "1";
    }
    if (bool2) {
      parameq = "2";
    }
    localObject = parameq;
    if (bool1)
    {
      localObject = parameq;
      if (bool2) {
        localObject = "3";
      }
    }
    e("ltype", (String)localObject);
  }
  
  public void b()
  {
    super.b();
    Object localObject = fp.a();
    e("offer_id", ed.b().f());
    ec localec = ed.b().n();
    e("openid", localec.a.openId);
    e("session_id", localec.a.sessionId);
    e("session_type", localec.a.sessionType);
    e("mb_recommend_flag", "1");
    e("pf", localec.a.pf);
    e("pfkey", localec.a.pfKey);
    e("buy_quantity", localec.e.g);
    e("reqtype", "cpay");
    e("zoneid", localec.a.zoneId);
    e("format", "json");
    e("sdkversion", fm.c());
    e("accounttype", localec.a.acctType);
    if (((fp)localObject).w().length() > 0) {
      e("appversion", ((fp)localObject).w());
    }
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", ed.b().n().a.offerId);
    }
    if (!TextUtils.isEmpty(ed.b().n().a.mpInfo.drmInfo)) {
      e("drm_info", ed.b().n().a.mpInfo.drmInfo);
    }
    if (!TextUtils.isEmpty(ed.b().n().a.mpInfo.discoutId)) {
      e("discountid", ed.b().n().a.mpInfo.discoutId);
    }
    e("pay_id", localec.e.a);
    e("auth_key", localec.e.b);
    e("wx_pay_by_bindqq", "1");
    e("networkType", String.valueOf(APAppDataInterface.singleton().i()));
    e("user_uuid", APTools.a(((fp)localObject).q(), 1));
    e("user_imei", APTools.a(((fp)localObject).r(), 1));
    e("user_androidid", APTools.a(((fp)localObject).s(), 1));
    e("user_mac", APTools.a(((fp)localObject).t(), 1));
    e("xg_mid", APAppDataInterface.singleton().l());
    e("midasplugin_version", APAppDataInterface.singleton().m());
    e("midascore_version", APAppDataInterface.singleton().n());
    if ((a.a().j()) && (fs.a().i()))
    {
      e("is_show_otheruin", "1");
      e("pay_id", fs.a().j());
      e("auth_key", fs.a().k());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resultData=更换QQ号码继续充值走buypage");
      ((StringBuilder)localObject).append(fs.a().j());
      APLog.i("APTagAPMobileBuyPageReq", ((StringBuilder)localObject).toString());
    }
    e("is_need_mbinfo", "1");
    a(localec.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.cy
 * JD-Core Version:    0.7.0.1
 */