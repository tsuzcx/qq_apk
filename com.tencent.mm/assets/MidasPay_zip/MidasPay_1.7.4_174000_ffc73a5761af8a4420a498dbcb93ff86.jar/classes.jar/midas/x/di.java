package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class di
  extends cd
{
  private String a;
  
  public di(String paramString)
  {
    this.a = paramString;
    a("https", String.format("/v1/r/%s/mobile_month_info", new Object[] { em.b().n().a.offerId }), "442");
    b();
  }
  
  private void a(ez paramez)
  {
    paramez = fy.a();
    Object localObject = em.b().n();
    if ((a.a().j()) && ((((el)localObject).a.saveType == 2) || (((el)localObject).a.saveType == 3))) {
      bool1 = ((el)localObject).d.e;
    } else if (((!d.a()) || ((((el)localObject).a.saveType != 2) && (((el)localObject).a.saveType != 3))) && (d.b()) && (((el)localObject).a.saveType != 2)) {
      int i = ((el)localObject).a.saveType;
    }
    f("openid", ((el)localObject).a.openId);
    f("openkey", ((el)localObject).a.openKey);
    f("jsversion", APAppDataInterface.singleton().p());
    f("extend", paramez.y());
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
    if ((!TextUtils.isEmpty(fy.a().Q())) && (!TextUtils.isEmpty(fy.a().R())))
    {
      f("callpkname", fy.a().Q());
      f("callpksign", fy.a().R());
    }
    paramez = "0";
    boolean bool1 = bl.a().b();
    boolean bool2 = bl.a().c();
    if (bool1) {
      paramez = "1";
    }
    if (bool2) {
      paramez = "2";
    }
    localObject = paramez;
    if (bool1)
    {
      localObject = paramez;
      if (bool2) {
        localObject = "3";
      }
    }
    e("ltype", (String)localObject);
  }
  
  public void b()
  {
    super.b();
    e("offer_id", em.b().f());
    Object localObject = fy.a();
    el localel = em.b().n();
    e("openid", localel.a.openId);
    e("session_id", localel.a.sessionId);
    e("session_type", localel.a.sessionType);
    e("mb_recommend_flag", "1");
    e("pf", localel.a.pf);
    e("pfkey", localel.a.pfKey);
    e("service_code", this.a);
    e("buy_quantity", localel.e.g);
    e("product_id", ((ew)localel.b).k);
    e("reqtype", "cpay");
    e("zoneid", localel.a.zoneId);
    e("format", "json");
    e("sdkversion", fv.c());
    if (APAppDataInterface.singleton().e().equals("dev")) {
      e("offer_id", em.b().n().a.offerId);
    }
    if (!TextUtils.isEmpty(em.b().n().a.mpInfo.drmInfo)) {
      e("drm_info", em.b().n().a.mpInfo.drmInfo);
    }
    if (!TextUtils.isEmpty(em.b().n().a.mpInfo.discoutId)) {
      e("discountid", em.b().n().a.mpInfo.discoutId);
    }
    e("pay_id", localel.e.a);
    e("auth_key", localel.e.b);
    e("wx_pay_by_bindqq", "1");
    e("networkType", String.valueOf(APAppDataInterface.singleton().i()));
    e("user_uuid", APTools.a(((fy)localObject).q(), 1));
    e("user_imei", APTools.a(((fy)localObject).r(), 1));
    e("user_androidid", APTools.a(((fy)localObject).s(), 1));
    e("user_mac", APTools.a(((fy)localObject).t(), 1));
    if (((fy)localObject).w().length() > 0) {
      e("appversion", ((fy)localObject).w());
    }
    e("xg_mid", APAppDataInterface.singleton().l());
    if (((ew)localel.b).l == 3) {
      e("service_update", "1");
    }
    e("midasplugin_version", APAppDataInterface.singleton().m());
    e("midascore_version", APAppDataInterface.singleton().n());
    if (((ew)localel.b).l == 4) {
      e("present", "1");
    }
    if ((a.a().j()) && (gc.a().i()))
    {
      e("is_show_otheruin", "1");
      e("pay_id", gc.a().j());
      e("auth_key", gc.a().k());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resultData=更换QQ号码继续充值走buypage");
      ((StringBuilder)localObject).append(gc.a().j());
      APLog.i("APTagAPMobileMonthInfoReq", ((StringBuilder)localObject).toString());
    }
    e("is_need_mbinfo", "1");
    a(localel.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.di
 * JD-Core Version:    0.7.0.1
 */