package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class dc
  extends cd
{
  el a = em.b().n();
  private String b;
  
  public dc(String paramString)
  {
    int i = paramString.lastIndexOf("?");
    if (i <= 0) {
      return;
    }
    String str = paramString.substring(0, i);
    i = paramString.lastIndexOf("token_id=");
    if (i <= 0) {
      return;
    }
    this.b = paramString.substring(i + 9);
    paramString = paramString.replace("mobile_goods_info", "mobile_save_goods");
    ev localev = (ev)em.b().n().b;
    localev.m = str;
    localev.l = paramString;
    this.a.e.m = this.b;
    a("https", str, "442");
    b();
  }
  
  private void a(ez paramez)
  {
    paramez = fy.a();
    if ((a.a().j()) && ((this.a.a.saveType == 2) || (this.a.a.saveType == 3))) {
      bool1 = this.a.d.e;
    } else if (((!d.a()) || ((this.a.a.saveType != 2) && (this.a.a.saveType != 3))) && (d.b()) && (this.a.a.saveType != 2)) {
      int i = this.a.a.saveType;
    }
    f("openid", this.a.a.openId);
    f("openkey", this.a.a.openKey);
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
    Object localObject = paramez;
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
    fy localfy = fy.a();
    if (a.c())
    {
      e("friends_pay_msg", this.b);
      e("friends_pay_source", "mobile");
      e("token_store_type", "1");
    }
    else
    {
      e("token_id", this.b);
    }
    e("openid", this.a.a.openId);
    e("session_id", this.a.a.sessionId);
    e("session_type", this.a.a.sessionType);
    e("sdkversion", fv.c());
    e("mb_recommend_flag", "1");
    if (!TextUtils.isEmpty(this.a.b.j)) {
      e("buy_type", this.a.b.j);
    }
    String str = APAppDataInterface.singleton().e();
    if ((str.equals("dev")) || (str.equals("test"))) {
      e("offer_id", em.b().n().a.offerId);
    }
    if (!TextUtils.isEmpty(em.b().n().a.mpInfo.drmInfo)) {
      e("drm_info", em.b().n().a.mpInfo.drmInfo);
    }
    if (!TextUtils.isEmpty(em.b().n().a.mpInfo.discoutId)) {
      e("discountid", em.b().n().a.mpInfo.discoutId);
    }
    e("pay_id", this.a.e.a);
    e("auth_key", this.a.e.b);
    e("wx_pay_by_bindqq", "1");
    e("networkType", String.valueOf(APAppDataInterface.singleton().i()));
    e("user_uuid", APTools.a(localfy.q(), 1));
    e("user_imei", APTools.a(localfy.r(), 1));
    e("user_androidid", APTools.a(localfy.s(), 1));
    e("user_mac", APTools.a(localfy.t(), 1));
    if (localfy.w().length() > 0) {
      e("appversion", localfy.w());
    }
    e("xg_mid", APAppDataInterface.singleton().l());
    e("midasplugin_version", APAppDataInterface.singleton().m());
    e("midascore_version", APAppDataInterface.singleton().n());
    if ((a.a().j()) && (gc.a().i()))
    {
      e("is_show_otheruin", "1");
      e("pay_id", gc.a().j());
      e("auth_key", gc.a().k());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resultData=更换QQ号码继续充值走buypage");
      localStringBuilder.append(gc.a().j());
      APLog.i("APTagAPMobileBuyGoodsReq", localStringBuilder.toString());
    }
    e("is_need_mbinfo", "1");
    if (localfy.S()) {
      e("check_receipt", "1");
    }
    e("env", str);
    a(this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.dc
 * JD-Core Version:    0.7.0.1
 */