package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;

public class k2
  extends y1
{
  public int A;
  
  public k2()
  {
    String str = p4.p().e().b.offerId;
    if (p4.p().e().b.saveType == 1) {
      str = ((y4)p4.p().e().c).l.replace("mobile_goods_info", "mobile_get_channel");
    } else {
      str = String.format("/v1/r/%s/mobile_get_channel", new Object[] { str });
    }
    a("https", str, "442");
    G();
  }
  
  public void G()
  {
    c6 localc6 = c6.s0();
    b("offer_id", p4.p().c());
    o4 localo41 = p4.p().e();
    o4 localo42 = p4.p().e();
    e("openid", localo42.b.openId);
    e("openkey", localo42.b.openKey);
    e("session_id", localo42.b.sessionId);
    e("session_type", localo42.b.sessionType);
    e("mb_recommend_flag", "1");
    e("buy_quantity", localo41.f.f);
    e("pf", localo42.b.pf);
    e("pfkey", localo42.b.pfKey);
    e("reqtype", "cpay");
    e("extend", localc6.e());
    if (!APAppDataInterface.singleton().h().equals("release"))
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
    Object localObject2 = localo42.b;
    this.A = ((APBaseRequest)localObject2).saveType;
    int i = this.A;
    Object localObject1 = "unimonth";
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5)
              {
                localObject1 = "";
              }
              else
              {
                localObject2 = (z4)localo41.c;
                e("service_code", ((APSubscribeRequest)localo41.b).serviceCode);
                e("product_id", ((z4)localObject2).k);
              }
            }
            else
            {
              localObject2 = (z4)localo41.c;
              e("service_code", ((APMonthRequest)localo41.b).serviceCode);
              if (((z4)localo41.c).l == 3) {
                e("service_update", "1");
              }
              i = localo41.b.saveType;
              if (((i == 5) || (i == 4)) && (g6.k().e() == g6.a.a)) {
                e("product_id", ((z4)localObject2).k);
              }
              if (g6.k().e() != g6.a.a) {
                localObject1 = "month";
              }
            }
          }
          else {
            localObject1 = "qb";
          }
        }
        else {
          localObject1 = "qd";
        }
      }
      else
      {
        e("zoneid", ((APBaseRequest)localObject2).zoneId);
        localObject1 = "bg";
      }
    }
    else
    {
      e("zoneid", ((APBaseRequest)localObject2).zoneId);
      e("accounttype", localo42.b.acctType);
      localObject1 = "save";
    }
    e("type", (String)localObject1);
    b("token_id", localo41.f.l);
    b("openid", localo42.b.openId);
    b("format", "json");
    b("sdkversion", z5.c());
    b("session_token", localo41.f.k);
    localObject1 = APAppDataInterface.singleton().h();
    if ((((String)localObject1).equals("dev")) || (((String)localObject1).equals("test"))) {
      b("offer_id", p4.p().e().b.offerId);
    }
    b("pay_id", localo41.f.a);
    b("auth_key", localo42.f.b);
    b("wx_pay_by_bindqq", "1");
    b("user_uuid", APTools.b(localc6.Y(), 1));
    b("user_imei", APTools.b(localc6.W(), 1));
    b("user_androidid", APTools.b(localc6.V(), 1));
    b("user_mac", APTools.b(localc6.X(), 1));
    b("mobile", APTools.p(a.r().a()));
    b("operator", APTools.o(a.r().a()));
    b("mccmnc", APTools.n(a.r().a()));
    b("xg_mid", APAppDataInterface.singleton().C());
    if ((a.r().e()) && (g6.k().c()))
    {
      b("is_show_otheruin", "1");
      b("pay_id", g6.k().b());
      b("auth_key", g6.k().a());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("resultData=更换QQ号码继续充值走buypage");
      ((StringBuilder)localObject1).append(g6.k().b());
      APLog.i("APTagAPGetExpressPayReq", ((StringBuilder)localObject1).toString());
    }
    b("is_need_mbinfo", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.k2
 * JD-Core Version:    0.7.0.1
 */