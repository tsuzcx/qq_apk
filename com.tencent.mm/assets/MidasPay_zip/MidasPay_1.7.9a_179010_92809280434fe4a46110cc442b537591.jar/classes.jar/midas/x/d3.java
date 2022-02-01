package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class d3
  extends e2
{
  public o4 A = p4.p().e();
  public String B;
  
  public d3(String paramString)
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
    this.B = paramString.substring(i + 9);
    paramString = paramString.replace("mobile_goods_info", "mobile_save_goods");
    y4 localy4 = (y4)p4.p().e().c;
    localy4.l = str;
    localy4.k = paramString;
    this.A.f.l = this.B;
    a("https", str, "442");
    G();
  }
  
  public void G()
  {
    super.G();
    b("offer_id", p4.p().c());
    c6 localc6 = c6.s0();
    if (a.q())
    {
      b("friends_pay_msg", this.B);
      b("friends_pay_source", "mobile");
      b("token_store_type", "1");
    }
    else
    {
      b("token_id", this.B);
    }
    b("openid", this.A.b.openId);
    b("session_id", this.A.b.sessionId);
    b("session_type", this.A.b.sessionType);
    b("sdkversion", z5.c());
    b("mb_recommend_flag", "1");
    if (!TextUtils.isEmpty(this.A.c.g)) {
      b("buy_type", this.A.c.g);
    }
    String str = APAppDataInterface.singleton().h();
    if ((str.equals("dev")) || (str.equals("test"))) {
      b("offer_id", p4.p().e().b.offerId);
    }
    if (!TextUtils.isEmpty(p4.p().e().b.mpInfo.drmInfo)) {
      b("drm_info", p4.p().e().b.mpInfo.drmInfo);
    }
    if (!TextUtils.isEmpty(p4.p().e().b.mpInfo.discoutId)) {
      b("discountid", p4.p().e().b.mpInfo.discoutId);
    }
    b("pay_id", this.A.f.a);
    b("auth_key", this.A.f.b);
    b("wx_pay_by_bindqq", "1");
    b("networkType", String.valueOf(APAppDataInterface.singleton().s()));
    b("user_uuid", APTools.b(localc6.Y(), 1));
    b("user_imei", APTools.b(localc6.W(), 1));
    b("user_androidid", APTools.b(localc6.V(), 1));
    b("user_mac", APTools.b(localc6.X(), 1));
    if (localc6.j().length() > 0) {
      b("appversion", localc6.j());
    }
    b("xg_mid", APAppDataInterface.singleton().C());
    b("midasplugin_version", APAppDataInterface.singleton().r());
    b("midascore_version", APAppDataInterface.singleton().q());
    if ((a.r().e()) && (g6.k().c()))
    {
      b("is_show_otheruin", "1");
      b("pay_id", g6.k().b());
      b("auth_key", g6.k().a());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resultData=更换QQ号码继续充值走buypage");
      localStringBuilder.append(g6.k().b());
      APLog.i("APTagAPMobileBuyGoodsReq", localStringBuilder.toString());
    }
    b("is_need_mbinfo", "1");
    if (localc6.M()) {
      b("check_receipt", "1");
    }
    b("env", str);
    a(this.A.e);
  }
  
  public final void a(c5 paramc5)
  {
    paramc5 = c6.s0();
    int i;
    if (a.r().e())
    {
      i = this.A.b.saveType;
      if ((i == 2) || (i == 3))
      {
        bool1 = this.A.e.e;
        break label95;
      }
    }
    if (d.a())
    {
      i = this.A.b.saveType;
      if ((i == 2) || (i == 3)) {}
    }
    else if (d.b())
    {
      i = this.A.b.saveType;
    }
    label95:
    e("openid", this.A.b.openId);
    e("openkey", this.A.b.openKey);
    e("jsversion", APAppDataInterface.singleton().o());
    e("extend", paramc5.e());
    boolean bool1 = APAppDataInterface.singleton().h().equals("release");
    paramc5 = "1";
    if (!bool1)
    {
      if (APAppDataInterface.singleton().F()) {
        e("encrypt_rsp", "1");
      }
    }
    else {
      e("encrypt_rsp", "1");
    }
    e("installqq", APAppDataInterface.singleton().i());
    e("installwechat", APAppDataInterface.singleton().j());
    e("qqversion", APAppDataInterface.singleton().t());
    e("wechatversion", APAppDataInterface.singleton().B());
    e("installunionpay", APAppDataInterface.singleton().k());
    e("isnewmpaymode", "1");
    if ((!TextUtils.isEmpty(c6.s0().c())) && (!TextUtils.isEmpty(c6.s0().d())))
    {
      e("callpkname", c6.s0().c());
      e("callpksign", c6.s0().d());
    }
    bool1 = m1.d().b();
    boolean bool2 = m1.d().c();
    if (!bool1) {
      paramc5 = "0";
    }
    if (bool2) {
      paramc5 = "2";
    }
    Object localObject = paramc5;
    if (bool1)
    {
      localObject = paramc5;
      if (bool2) {
        localObject = "3";
      }
    }
    b("ltype", (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.d3
 * JD-Core Version:    0.7.0.1
 */