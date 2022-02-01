package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class j3
  extends e2
{
  public String A;
  
  public j3(String paramString)
  {
    this.A = paramString;
    a("https", String.format("/v1/r/%s/mobile_month_info", new Object[] { p4.p().e().b.offerId }), "442");
    G();
  }
  
  public void G()
  {
    super.G();
    b("offer_id", p4.p().c());
    Object localObject = c6.s0();
    o4 localo4 = p4.p().e();
    b("openid", localo4.b.openId);
    b("session_id", localo4.b.sessionId);
    b("session_type", localo4.b.sessionType);
    b("mb_recommend_flag", "1");
    b("pf", localo4.b.pf);
    b("pfkey", localo4.b.pfKey);
    b("service_code", this.A);
    b("buy_quantity", localo4.f.f);
    b("product_id", ((z4)localo4.c).k);
    b("reqtype", "cpay");
    b("zoneid", localo4.b.zoneId);
    b("format", "json");
    b("sdkversion", z5.c());
    if (APAppDataInterface.singleton().h().equals("dev")) {
      b("offer_id", p4.p().e().b.offerId);
    }
    if (!TextUtils.isEmpty(p4.p().e().b.mpInfo.drmInfo)) {
      b("drm_info", p4.p().e().b.mpInfo.drmInfo);
    }
    if (!TextUtils.isEmpty(p4.p().e().b.mpInfo.discoutId)) {
      b("discountid", p4.p().e().b.mpInfo.discoutId);
    }
    b("pay_id", localo4.f.a);
    b("auth_key", localo4.f.b);
    b("wx_pay_by_bindqq", "1");
    b("networkType", String.valueOf(APAppDataInterface.singleton().s()));
    b("user_uuid", APTools.b(((c6)localObject).Y(), 1));
    b("user_imei", APTools.b(((c6)localObject).W(), 1));
    b("user_androidid", APTools.b(((c6)localObject).V(), 1));
    b("user_mac", APTools.b(((c6)localObject).X(), 1));
    if (((c6)localObject).j().length() > 0) {
      b("appversion", ((c6)localObject).j());
    }
    b("xg_mid", APAppDataInterface.singleton().C());
    if (((z4)localo4.c).l == 3) {
      b("service_update", "1");
    }
    b("midasplugin_version", APAppDataInterface.singleton().r());
    b("midascore_version", APAppDataInterface.singleton().q());
    if (((z4)localo4.c).l == 4) {
      b("present", "1");
    }
    if ((a.r().e()) && (g6.k().c()))
    {
      b("is_show_otheruin", "1");
      b("pay_id", g6.k().b());
      b("auth_key", g6.k().a());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resultData=更换QQ号码继续充值走buypage");
      ((StringBuilder)localObject).append(g6.k().b());
      APLog.i("APTagAPMobileMonthInfoReq", ((StringBuilder)localObject).toString());
    }
    b("is_need_mbinfo", "1");
    a(localo4.e);
  }
  
  public final void a(c5 paramc5)
  {
    paramc5 = c6.s0();
    Object localObject = p4.p().e();
    int i;
    if (a.r().e())
    {
      i = ((o4)localObject).b.saveType;
      if ((i == 2) || (i == 3))
      {
        bool1 = ((o4)localObject).e.e;
        break label95;
      }
    }
    if (d.a())
    {
      i = ((o4)localObject).b.saveType;
      if ((i == 2) || (i == 3)) {}
    }
    else if (d.b())
    {
      i = ((o4)localObject).b.saveType;
    }
    label95:
    e("openid", ((o4)localObject).b.openId);
    e("openkey", ((o4)localObject).b.openKey);
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
    localObject = paramc5;
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
 * Qualified Name:     midas.x.j3
 * JD-Core Version:    0.7.0.1
 */