package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class cd
  extends br
{
  public int a;
  
  public cd()
  {
    String str = ed.b().n().a.offerId;
    if (ed.b().n().a.saveType == 1) {
      str = ((em)ed.b().n().b).m.replace("mobile_goods_info", "mobile_get_channel");
    } else {
      str = String.format("/v1/r/%s/mobile_get_channel", new Object[] { str });
    }
    a("https", str, "442");
    b();
  }
  
  public void b()
  {
    fp localfp = fp.a();
    e("offer_id", ed.b().f());
    ec localec1 = ed.b().n();
    ec localec2 = ed.b().n();
    f("openid", localec2.a.openId);
    f("openkey", localec2.a.openKey);
    f("session_id", localec2.a.sessionId);
    f("session_type", localec2.a.sessionType);
    f("mb_recommend_flag", "1");
    f("buy_quantity", localec1.e.g);
    f("pf", localec2.a.pf);
    f("pfkey", localec2.a.pfKey);
    f("reqtype", "cpay");
    f("extend", localfp.y());
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
    this.a = localec2.a.saveType;
    switch (this.a)
    {
    default: 
      break;
    case 5: 
      localObject = (en)localec1.b;
      f("service_code", ((APSubscribeRequest)localec1.a).serviceCode);
      f("product_id", ((en)localObject).k);
      localObject = "unimonth";
      break;
    case 4: 
      localObject = (en)localec1.b;
      f("service_code", ((APMonthRequest)localec1.a).serviceCode);
      if (((en)localec1.b).l == 3) {
        f("service_update", "1");
      }
      if (((localec1.a.saveType == 5) || (localec1.a.saveType == 4)) && (fs.a().f() == fs.a.a)) {
        f("product_id", ((en)localObject).k);
      }
      if (fs.a().f() == fs.a.a) {
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
      f("zoneid", localec2.a.zoneId);
      localObject = "bg";
      break;
    case 0: 
      f("zoneid", localec2.a.zoneId);
      f("accounttype", localec2.a.acctType);
      localObject = "save";
    }
    f("type", (String)localObject);
    e("token_id", localec1.e.m);
    e("openid", localec2.a.openId);
    e("format", "json");
    e("sdkversion", fm.c());
    e("session_token", localec1.e.l);
    localObject = APAppDataInterface.singleton().e();
    if ((((String)localObject).equals("dev")) || (((String)localObject).equals("test"))) {
      e("offer_id", ed.b().n().a.offerId);
    }
    e("pay_id", localec1.e.a);
    e("auth_key", localec2.e.b);
    e("wx_pay_by_bindqq", "1");
    e("user_uuid", APTools.a(localfp.q(), 1));
    e("user_imei", APTools.a(localfp.r(), 1));
    e("user_androidid", APTools.a(localfp.s(), 1));
    e("user_mac", APTools.a(localfp.t(), 1));
    e("mobile", APTools.h(a.a().b()));
    e("operator", APTools.g(a.a().b()));
    e("mccmnc", APTools.f(a.a().b()));
    e("xg_mid", APAppDataInterface.singleton().l());
    if ((a.a().j()) && (fs.a().i()))
    {
      e("is_show_otheruin", "1");
      e("pay_id", fs.a().j());
      e("auth_key", fs.a().k());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resultData=更换QQ号码继续充值走buypage");
      ((StringBuilder)localObject).append(fs.a().j());
      APLog.i("APTagAPGetExpressPayReq", ((StringBuilder)localObject).toString());
    }
    e("is_need_mbinfo", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.cd
 * JD-Core Version:    0.7.0.1
 */