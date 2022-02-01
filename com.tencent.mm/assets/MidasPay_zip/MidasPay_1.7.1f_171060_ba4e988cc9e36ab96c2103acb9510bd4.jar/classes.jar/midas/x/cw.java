package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class cw
  extends bx
{
  ec a = ed.b().n();
  private String b;
  
  public cw(String paramString)
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
    em localem = (em)ed.b().n().b;
    localem.m = str;
    localem.l = paramString;
    this.a.e.m = this.b;
    a("https", str, "442");
    b();
  }
  
  private void a(eq parameq)
  {
    parameq = fp.a();
    if ((a.a().j()) && ((this.a.a.saveType == 2) || (this.a.a.saveType == 3))) {
      bool1 = this.a.d.e;
    } else if (((!d.a()) || ((this.a.a.saveType != 2) && (this.a.a.saveType != 3))) && (d.b()) && (this.a.a.saveType != 2)) {
      int i = this.a.a.saveType;
    }
    f("openid", this.a.a.openId);
    f("openkey", this.a.a.openKey);
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
    parameq = "0";
    boolean bool1 = bl.a().b();
    boolean bool2 = bl.a().c();
    if (bool1) {
      parameq = "1";
    }
    if (bool2) {
      parameq = "2";
    }
    Object localObject = parameq;
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
    e("offer_id", ed.b().f());
    fp localfp = fp.a();
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
    e("sdkversion", fm.c());
    e("mb_recommend_flag", "1");
    if (!TextUtils.isEmpty(this.a.b.j)) {
      e("buy_type", this.a.b.j);
    }
    String str = APAppDataInterface.singleton().e();
    if ((str.equals("dev")) || (str.equals("test"))) {
      e("offer_id", ed.b().n().a.offerId);
    }
    if (!TextUtils.isEmpty(ed.b().n().a.mpInfo.drmInfo)) {
      e("drm_info", ed.b().n().a.mpInfo.drmInfo);
    }
    if (!TextUtils.isEmpty(ed.b().n().a.mpInfo.discoutId)) {
      e("discountid", ed.b().n().a.mpInfo.discoutId);
    }
    e("pay_id", this.a.e.a);
    e("auth_key", this.a.e.b);
    e("wx_pay_by_bindqq", "1");
    e("networkType", String.valueOf(APAppDataInterface.singleton().i()));
    e("user_uuid", APTools.a(localfp.q(), 1));
    e("user_imei", APTools.a(localfp.r(), 1));
    e("user_androidid", APTools.a(localfp.s(), 1));
    e("user_mac", APTools.a(localfp.t(), 1));
    if (localfp.w().length() > 0) {
      e("appversion", localfp.w());
    }
    e("xg_mid", APAppDataInterface.singleton().l());
    e("midasplugin_version", APAppDataInterface.singleton().m());
    e("midascore_version", APAppDataInterface.singleton().n());
    if ((a.a().j()) && (fs.a().i()))
    {
      e("is_show_otheruin", "1");
      e("pay_id", fs.a().j());
      e("auth_key", fs.a().k());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resultData=更换QQ号码继续充值走buypage");
      localStringBuilder.append(fs.a().j());
      APLog.i("APTagAPMobileBuyGoodsReq", localStringBuilder.toString());
    }
    e("is_need_mbinfo", "1");
    if (localfp.S()) {
      e("check_receipt", "1");
    }
    e("env", str);
    a(this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.cw
 * JD-Core Version:    0.7.0.1
 */