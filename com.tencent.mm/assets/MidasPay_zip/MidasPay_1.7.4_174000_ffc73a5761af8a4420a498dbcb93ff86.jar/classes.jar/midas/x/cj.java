package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class cj
  extends bx
{
  public int a;
  
  public cj()
  {
    String str = em.b().n().a.offerId;
    if (em.b().n().a.saveType == 1) {
      str = ((ev)em.b().n().b).m.replace("mobile_goods_info", "mobile_get_channel");
    } else {
      str = String.format("/v1/r/%s/mobile_get_channel", new Object[] { str });
    }
    a("https", str, "442");
    b();
  }
  
  public void b()
  {
    fy localfy = fy.a();
    e("offer_id", em.b().f());
    el localel1 = em.b().n();
    el localel2 = em.b().n();
    f("openid", localel2.a.openId);
    f("openkey", localel2.a.openKey);
    f("session_id", localel2.a.sessionId);
    f("session_type", localel2.a.sessionType);
    f("mb_recommend_flag", "1");
    f("buy_quantity", localel1.e.g);
    f("pf", localel2.a.pf);
    f("pfkey", localel2.a.pfKey);
    f("reqtype", "cpay");
    f("extend", localfy.y());
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
    Object localObject = "";
    this.a = localel2.a.saveType;
    switch (this.a)
    {
    default: 
      break;
    case 5: 
      localObject = (ew)localel1.b;
      f("service_code", ((APSubscribeRequest)localel1.a).serviceCode);
      f("product_id", ((ew)localObject).k);
      localObject = "unimonth";
      break;
    case 4: 
      localObject = (ew)localel1.b;
      f("service_code", ((APMonthRequest)localel1.a).serviceCode);
      if (((ew)localel1.b).l == 3) {
        f("service_update", "1");
      }
      if (((localel1.a.saveType == 5) || (localel1.a.saveType == 4)) && (gc.a().f() == gc.a.a)) {
        f("product_id", ((ew)localObject).k);
      }
      if (gc.a().f() == gc.a.a) {
        localObject = "unimonth";
      } else {
        localObject = "month";
      }
      break;
    case 3: 
      localObject = "qb";
      break;
    case 2: 
      localObject = "qd";
      break;
    case 1: 
      f("zoneid", localel2.a.zoneId);
      localObject = "bg";
      break;
    case 0: 
      f("zoneid", localel2.a.zoneId);
      f("accounttype", localel2.a.acctType);
      localObject = "save";
    }
    f("type", (String)localObject);
    e("token_id", localel1.e.m);
    e("openid", localel2.a.openId);
    e("format", "json");
    e("sdkversion", fv.c());
    e("session_token", localel1.e.l);
    localObject = APAppDataInterface.singleton().e();
    if ((((String)localObject).equals("dev")) || (((String)localObject).equals("test"))) {
      e("offer_id", em.b().n().a.offerId);
    }
    e("pay_id", localel1.e.a);
    e("auth_key", localel2.e.b);
    e("wx_pay_by_bindqq", "1");
    e("user_uuid", APTools.a(localfy.q(), 1));
    e("user_imei", APTools.a(localfy.r(), 1));
    e("user_androidid", APTools.a(localfy.s(), 1));
    e("user_mac", APTools.a(localfy.t(), 1));
    e("mobile", APTools.h(a.a().b()));
    e("operator", APTools.g(a.a().b()));
    e("mccmnc", APTools.f(a.a().b()));
    e("xg_mid", APAppDataInterface.singleton().l());
    if ((a.a().j()) && (gc.a().i()))
    {
      e("is_show_otheruin", "1");
      e("pay_id", gc.a().j());
      e("auth_key", gc.a().k());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resultData=更换QQ号码继续充值走buypage");
      ((StringBuilder)localObject).append(gc.a().j());
      APLog.i("APTagAPGetExpressPayReq", ((StringBuilder)localObject).toString());
    }
    e("is_need_mbinfo", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.cj
 * JD-Core Version:    0.7.0.1
 */