package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APMPInfo;
import com.pay.api.request.APMonthRequest;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.paychannel.mcard.APMcardChannel;
import com.pay.paychannel.qdqb.APQDQBChannel;
import com.pay.paychannel.qqcard.APQQCardChannel;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class x3
  extends y1
{
  public String A;
  public String B;
  public o4 C;
  public a D;
  
  public x3(String paramString, a parama)
  {
    Object localObject = "";
    this.A = "";
    this.B = "";
    this.C = p4.p().e();
    APLog.d("SaveReq", "New save request instance!");
    this.A = paramString;
    this.D = parama;
    if ((!"wechat".equals(paramString)) && (!"cft".equals(paramString)) && (!"bank".equals(paramString)) && (!"qqwallet".equals(paramString)))
    {
      this.h = 0;
      this.o = 20000;
    }
    if (J())
    {
      this.h = 0;
      this.o = 20000;
    }
    if (e(paramString))
    {
      this.h = 0;
      this.o = 20000;
    }
    parama = p4.p().c();
    if (TextUtils.isEmpty(parama)) {
      APLog.e("SaveReq", "Cannot get offer id while creating save request instance!");
    }
    int i = p4.p().g();
    if (i == -1) {
      APLog.e("SaveReq", "Cannot get save type while creating save request instance!");
    }
    if ((r1.i()) && (r1.d(paramString)))
    {
      paramString = String.format("/v1/r/%s/cloud_save", new Object[] { parama });
      if (i == 1)
      {
        APLog.d("SaveReq", "cloud Save type = goods while creating save request instance!");
        paramString = ((y4)this.C.c).k;
        parama = new StringBuilder();
        parama.append("Goods save url = ");
        parama.append(paramString);
        parama.append(" while creating save request instance!");
        APLog.d("SaveReq", parama.toString());
        i = paramString.lastIndexOf("?");
        if (i > 0)
        {
          localObject = paramString.substring(0, i);
          paramString = paramString.substring(paramString.lastIndexOf("token_id=") + 9);
        }
        else
        {
          paramString = "";
        }
        this.C.f.l = paramString;
        parama = new StringBuilder();
        parama.append("cloud Save req token id = ");
        parama.append(paramString);
        APLog.d("SaveReq", parama.toString());
        paramString = "/v1/r/%s/cloud_save".substring(9);
        i = ((String)localObject).lastIndexOf("/");
        if (i == -1) {
          return;
        }
        paramString = ((String)localObject).replace(((String)localObject).substring(i + 1), paramString);
      }
    }
    else
    {
      if (i != 0) {
        if (i != 1)
        {
          if ((i != 2) && (i != 3))
          {
            if ((i != 4) && (i != 5))
            {
              paramString = (String)localObject;
              break label617;
            }
            paramString = String.format("/v1/r/%s/mobile_save_month", new Object[] { parama });
            APLog.d("SaveReq", "Save type = month or subscribe while creating save request instance!");
            break label617;
          }
        }
        else
        {
          APLog.d("SaveReq", "Save type = goods while creating save request instance!");
          parama = ((y4)this.C.c).k;
          paramString = new StringBuilder();
          paramString.append("Goods save url = ");
          paramString.append(parama);
          paramString.append(" while creating save request instance!");
          APLog.d("SaveReq", paramString.toString());
          i = parama.lastIndexOf("?");
          if (i > 0)
          {
            paramString = parama.substring(0, i);
            parama = parama.substring(parama.lastIndexOf("token_id=") + 9);
          }
          else
          {
            parama = "";
            paramString = (String)localObject;
          }
          this.C.f.l = parama;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Save req token id = ");
          ((StringBuilder)localObject).append(parama);
          APLog.d("SaveReq", ((StringBuilder)localObject).toString());
          break label617;
        }
      }
      paramString = String.format("/v1/r/%s/mobile_save", new Object[] { parama });
      APLog.d("SaveReq", "Save type = game or qb or qd while creating save request instance!");
    }
    label617:
    parama = new StringBuilder();
    parama.append("Final url = ");
    parama.append(paramString);
    parama.append(" while creating save request!");
    APLog.d("SaveReq", parama.toString());
    a("https", paramString, "442");
    H();
  }
  
  public final void G()
  {
    if (r1.i())
    {
      e("replace_pf_header", r1.f());
      if (r1.d(this.A))
      {
        e("cloud_save_token", r1.e());
        e("mobile_offer_id", r1.a());
        e("mobile_openid", r1.b());
        e("msg_encrypt_key", r1.c());
        int i = p4.p().e().b.saveType;
        if ((i != 4) && (i != 5))
        {
          if (i == 1) {
            e("cloud_save_type", "bg");
          } else {
            e("cloud_save_type", "save");
          }
        }
        else {
          e("cloud_save_type", "month");
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(String.format("%06d", new Object[] { Integer.valueOf((int)(Math.random() * 1000000.0D)) }));
        localObject = ((StringBuilder)localObject).toString();
        c6.s0().f((String)localObject);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("identify=");
        localStringBuilder.append((String)localObject);
        localObject = APTools.b(localStringBuilder.toString(), 1);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("cloudOthers = ");
        localStringBuilder.append((String)localObject);
        APLog.i("SaveReq", localStringBuilder.toString());
        e("cloud_others", (String)localObject);
      }
    }
  }
  
  public void H()
  {
    K();
    b("offer_id", p4.p().c());
    e("is_hfpay_autoflow", "1");
    G();
    a(this.D);
  }
  
  public boolean I()
  {
    return false;
  }
  
  public boolean J()
  {
    return (p.o().h()) && (p.o().f()) && (p.o().i()) && (p.o().j());
  }
  
  public final void K()
  {
    this.C = p4.p().e();
    Object localObject = this.C;
    int i = ((o4)localObject).b.saveType;
    localObject = ((o4)localObject).f.f;
    if ("qdqb".equals(this.A))
    {
      a(i, this.A, (String)localObject);
      return;
    }
    if ("qbqd".equals(this.A))
    {
      a(i, this.A, (String)localObject);
      return;
    }
    if ("wechat".equals(this.A))
    {
      j(i, (String)localObject);
      return;
    }
    if ("cft".equals(this.A))
    {
      b(i, (String)localObject, this.A);
      return;
    }
    if ("bank".equals(this.A))
    {
      b(i, (String)localObject, this.A);
      return;
    }
    if ("qqwallet".equals(this.A))
    {
      g(i, (String)localObject);
      return;
    }
    if ("wsjpay".equals(this.A))
    {
      i(i, (String)localObject);
      return;
    }
    if ("qqcard".equals(this.A))
    {
      f(i, (String)localObject);
      return;
    }
    if ("mcard".equals(this.A))
    {
      d(i, (String)localObject);
      return;
    }
    if ("hfpay".equals(this.A))
    {
      c(i, (String)localObject);
      return;
    }
    if ("yb".equals(this.A))
    {
      k(i, (String)localObject);
      return;
    }
    if ("goldcopon".equals(this.A))
    {
      a(i, (String)localObject);
      return;
    }
    if ("goldcouponsdeduct".equals(this.A))
    {
      b(i, (String)localObject);
      return;
    }
    if ("wechat_quickpass".equals(this.A))
    {
      h(i, (String)localObject);
      return;
    }
    if ("wechat_payscore".equals(this.A))
    {
      e(i, (String)localObject);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Error channel id = ");
    ((StringBuilder)localObject).append(this.A);
    ((StringBuilder)localObject).append(", cannot handle it!");
    APLog.e("SaveReq", ((StringBuilder)localObject).toString());
  }
  
  public final void a(int paramInt, String paramString)
  {
    a("gold_coupons", paramInt, i());
    e("pay_method", "gold_coupons");
    e("buy_quantity", paramString);
    e("auth_key", this.C.f.b);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mb_pwd:");
    localStringBuilder.append(APQDQBChannel.p);
    APLog.i("APSaveReq", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("sms_info:");
    localStringBuilder.append(APQDQBChannel.r);
    APLog.i("APSaveReq", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mb_type:");
    localStringBuilder.append(APQDQBChannel.q);
    APLog.i("APSaveReq", localStringBuilder.toString());
    if (!TextUtils.isEmpty(APQDQBChannel.p)) {
      e("mb_pwd", APQDQBChannel.p);
    }
    if (!TextUtils.isEmpty(APQDQBChannel.r)) {
      b("sms_info", APQDQBChannel.r);
    }
    if (!TextUtils.isEmpty(APQDQBChannel.q)) {
      b("mb_type", APQDQBChannel.q);
    }
    a(paramString1, paramInt, i());
    e("session_id", this.C.b.sessionId);
    e("session_type", this.C.b.sessionType);
    if ("qdqb".equals(paramString1)) {
      e("pay_method", "qdqb");
    } else {
      e("pay_method", "qbqd");
    }
    e("buy_quantity", paramString2);
    e("pay_id", this.C.f.a);
    e("auth_key", this.C.f.b);
    e("h5_mb_url", URLEncoder.encode("http://unipay.mibaocheck"));
    if ((c6.s0().v()) && (this.C.e.e) && (a.r().e()))
    {
      paramString1 = APQDQBChannel.o;
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        e("have_changed_uin", "1");
        APLog.i("APTag", "resultData=更换QQ号码");
      }
      if (g6.k().c())
      {
        b("pay_id", g6.k().b());
        b("auth_key", g6.k().a());
        e("have_changed_uin", "1");
        APLog.i("APTag", "resultData=更换QQ号码继续充值走saveCgi");
      }
    }
  }
  
  public final void a(String paramString, int paramInt, HashMap<String, String> paramHashMap)
  {
    c6 localc6 = c6.s0();
    e("wx_pay_by_bindqq", "1");
    e("fk_tips", "1");
    if (this.C == null)
    {
      APUICommonMethod.f();
      z5.a(-1, "maybe call multy");
      return;
    }
    if ((a.r().e()) && ((paramInt == 2) || (paramInt == 3)))
    {
      localObject1 = this.C;
      if (!((o4)localObject1).e.e)
      {
        paramHashMap.put("openid", ((o4)localObject1).f.a);
        e("openid", this.C.f.a);
        e("openkey", this.C.f.b);
        if (TextUtils.isEmpty(this.C.f.c))
        {
          e("session_id", "uin");
          e("session_type", "skey");
        }
        else
        {
          e("session_id", this.C.f.c);
          e("session_type", this.C.f.d);
        }
      }
      else if ((p4.p().e().e.f) && (!TextUtils.isEmpty(this.C.f.a)))
      {
        paramHashMap.put("openid", this.C.f.a);
        e("openid", this.C.f.a);
        e("openkey", this.C.f.b);
        if (TextUtils.isEmpty(this.C.f.c))
        {
          e("session_id", "uin");
          e("session_type", "skey");
        }
        else
        {
          e("session_id", this.C.f.c);
          e("session_type", this.C.f.d);
        }
      }
      else
      {
        paramHashMap.put("openid", this.C.b.openId);
        e("openid", this.C.b.openId);
        e("openkey", this.C.b.openKey);
        e("session_id", this.C.b.sessionId);
        e("session_type", this.C.b.sessionType);
      }
    }
    else if ((d.a()) && ((paramInt == 2) || (paramInt == 3)))
    {
      paramHashMap.put("openid", this.C.f.a);
      e("openid", this.C.f.a);
      e("openkey", this.C.f.b);
      if (TextUtils.isEmpty(this.C.f.c))
      {
        e("session_id", "uin");
        e("session_type", "skey");
      }
      else
      {
        e("session_id", this.C.f.c);
        e("session_type", this.C.f.d);
      }
    }
    else if ((d.b()) && ((paramInt == 2) || (paramInt == 3)))
    {
      paramHashMap.put("openid", this.C.f.a);
      e("openid", this.C.f.a);
      e("openkey", this.C.f.b);
      if (TextUtils.isEmpty(this.C.f.c))
      {
        e("session_id", "uin");
        e("session_type", "skey");
      }
      else
      {
        e("session_id", this.C.f.c);
        e("session_type", this.C.f.d);
      }
    }
    else
    {
      paramHashMap.put("openid", this.C.b.openId);
      e("openid", this.C.b.openId);
      e("openkey", this.C.b.openKey);
      e("session_id", this.C.b.sessionId);
      e("session_type", this.C.b.sessionType);
    }
    Object localObject1 = (String)paramHashMap.get("openid");
    if (!TextUtils.isEmpty(this.C.b.mpInfo.drmInfo)) {
      e("drm_info", this.C.b.mpInfo.drmInfo);
    }
    if (!TextUtils.isEmpty(this.C.b.mpInfo.discoutId)) {
      e("discountid", this.C.b.mpInfo.discoutId);
    }
    if (paramInt == 0)
    {
      paramHashMap.put("pre_uuid", j6.e().c());
      paramHashMap.put("drm_act_type", j6.e().a());
      paramHashMap.put("drm_resource", j6.e().b());
    }
    if (localc6.M()) {
      paramHashMap.put("check_receipt", "1");
    }
    if ((paramInt == 1) && (a.q()))
    {
      b("friends_pay_msg", this.C.f.l);
      b("friends_pay_source", "mobile");
      b("token_store_type", "1");
    }
    else
    {
      e("token_id", this.C.f.l);
    }
    if ((this.C != null) && (a.r().g != null))
    {
      int i = a.r().g.b.saveType;
      int j = this.C.b.saveType;
      Object localObject5;
      StringBuilder localStringBuilder;
      if ((i != j) && ((j == 3) || (j == 2)))
      {
        try
        {
          localObject1 = URLDecoder.decode(localc6.e(), "UTF-8");
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          localObject2 = "";
        }
        localObject5 = APTools.c((String)localObject2, "provide_uin");
        Object localObject2 = localObject5;
        try
        {
          if (p.o().h())
          {
            localObject2 = localObject5;
            if (p.o().f())
            {
              localObject2 = localObject5;
              if (p.o().i())
              {
                localObject2 = localObject5;
                if (p.o().j()) {
                  if (TextUtils.isEmpty((CharSequence)localObject5))
                  {
                    localObject2 = p.o().c();
                  }
                  else
                  {
                    localObject2 = URLEncoder.encode("&", "UTF-8");
                    localStringBuilder = new StringBuilder();
                    localStringBuilder.append((String)localObject5);
                    localStringBuilder.append((String)localObject2);
                    localStringBuilder.append(p.o().c());
                    localObject2 = localStringBuilder.toString();
                  }
                }
              }
            }
          }
          e("extend", URLEncoder.encode((String)localObject2, "UTF-8"));
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
      else
      {
        if (localc6.M()) {
          b("check_receipt", "1");
        }
        localObject5 = localc6.e();
        Object localObject3 = localObject5;
        if (p.o().h())
        {
          localObject3 = localObject5;
          if (p.o().f())
          {
            localObject3 = localObject5;
            if (p.o().i())
            {
              localObject3 = localObject5;
              if (p.o().j()) {
                if (TextUtils.isEmpty((CharSequence)localObject5)) {
                  localObject3 = p.o().c();
                } else {
                  try
                  {
                    localObject3 = URLEncoder.encode("&", "UTF-8");
                    localStringBuilder = new StringBuilder();
                    localStringBuilder.append((String)localObject5);
                    localStringBuilder.append((String)localObject3);
                    localStringBuilder.append(p.o().c());
                    localObject3 = localStringBuilder.toString();
                  }
                  catch (Exception localException3)
                  {
                    localException3.printStackTrace();
                    localObject4 = localObject5;
                  }
                }
              }
            }
          }
        }
        e("extend", (String)localObject4);
      }
      if (!APAppDataInterface.singleton().h().equals("release"))
      {
        if (APAppDataInterface.singleton().F()) {
          e("encrypt_rsp", "1");
        }
      }
      else {
        e("encrypt_rsp", "1");
      }
      e("old_accounttype", this.C.b.acctType);
      Object localObject4 = APAppDataInterface.singleton().h();
      e("env", (String)localObject4);
      if ((((String)localObject4).equals("dev")) || (((String)localObject4).equals("test"))) {
        paramHashMap.put("offer_id", p4.p().e().b.offerId);
      }
      paramHashMap.put("pf", this.C.b.pf);
      paramHashMap.put("pfkey", this.C.b.pfKey);
      if ((paramInt == 1) && (a.q()))
      {
        paramHashMap.put("friends_pay_msg", this.C.f.l);
        paramHashMap.put("friends_pay_source", "mobile");
        paramHashMap.put("token_store_type", "1");
      }
      else
      {
        paramHashMap.put("token_id", this.C.f.l);
      }
      paramHashMap.put("reqtype", "cpay");
      paramHashMap.put("sdkversion", z5.c());
      paramHashMap.put("session_token", this.C.f.k);
      paramHashMap.put("express_channel", this.C.f.i);
      paramHashMap.put("default_channel", r6.j().d());
      paramHashMap.put("pay_session_id", this.C.f.c);
      paramHashMap.put("pay_session_type", this.C.f.d);
      paramHashMap.put("uuid", localc6.Z());
      paramHashMap.put("pushtype", "NodeJS");
      APLog.i("uuid == ", localc6.Z());
      paramHashMap.put("user_uuid", APTools.b(localc6.Y(), 1));
      paramHashMap.put("user_imei", APTools.b(localc6.W(), 1));
      paramHashMap.put("user_mac", APTools.b(localc6.X(), 1));
      paramHashMap.put("xg_mid", APAppDataInterface.singleton().C());
      paramHashMap.put("midasplugin_version", APAppDataInterface.singleton().r());
      paramHashMap.put("midascore_version", APAppDataInterface.singleton().q());
      if (o.m().e(paramString))
      {
        paramHashMap.put("sp_info", o.m().c(paramString));
        paramHashMap.put("out_trade_no", this.C.b());
      }
      b("env", (String)localObject4);
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 4)
              {
                if (paramInt != 5) {
                  break label2581;
                }
              }
              else
              {
                if (c6.s0().f() != 0) {
                  paramHashMap.put("change_prepay", Integer.toString(c6.s0().f()));
                }
                localObject4 = this.C;
                localObject5 = ((o4)localObject4).c;
                if (((z4)localObject5).l == 4) {
                  if (((o4)localObject4).b.isCanChange)
                  {
                    localObject4 = g6.k().d();
                    if ((localObject4 != null) && (((String)localObject4).length() > 0)) {
                      paramHashMap.put("provide_uin", g6.k().d());
                    }
                  }
                  else
                  {
                    localObject4 = (z4)localObject5;
                    localObject4 = q7.a((z4)localObject4, ((z4)localObject4).m);
                    if ((localObject4 != null) && (((String)localObject4).length() > 0)) {
                      paramHashMap.put("provide_uin", localObject4);
                    }
                  }
                }
              }
              localObject4 = this.C;
              localObject5 = (z4)((o4)localObject4).c;
              paramHashMap.put("service_code", ((APMonthRequest)((o4)localObject4).b).serviceCode);
              paramHashMap.put("product_id", ((z4)localObject5).k);
              if ("1".equals(((z4)localObject5).n))
              {
                if (APTools.e(paramString)) {
                  paramHashMap.put("auto_cont", "1");
                } else {
                  paramHashMap.put("auto_cont", "0");
                }
              }
              else {
                paramHashMap.put("auto_cont", ((z4)localObject5).n);
              }
              e("zoneid", this.C.b.zoneId);
              if ("1".equals(((z4)localObject5).n))
              {
                b("client", "app");
                b("query_wx_sign_info", "1");
              }
              if ((paramInt == 4) && (((z4)this.C.c).l == 3)) {
                e("service_update", "1");
              }
              try
              {
                g6.k();
                if (g6.k().e() == g6.a.a) {
                  paramHashMap.put("service_name", URLEncoder.encode(this.C.c.b, "UTF-8").toString());
                } else {
                  paramHashMap.put("service_name", URLEncoder.encode(((APMonthRequest)this.C.b).serviceName, "UTF-8").toString());
                }
              }
              catch (Exception localException4)
              {
                localException4.printStackTrace();
              }
            }
            else
            {
              e("accounttype", "qb");
            }
          }
          else {
            e("accounttype", "qd");
          }
        }
        else
        {
          e("accounttype", this.C.b.acctType);
          e("zoneid", this.C.b.zoneId);
          APLog.d("BuyType: ", this.C.c.g);
          b("buy_type", this.C.c.g);
        }
      }
      else
      {
        e("accounttype", this.C.b.acctType);
        e("zoneid", this.C.b.zoneId);
      }
      try
      {
        label2581:
        paramHashMap.put("wcp", APTools.a(paramInt, paramString));
        paramHashMap.put("remark", URLEncoder.encode(this.C.b.remark, "UTF-8"));
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    APUICommonMethod.f();
    z5.a(-1, "maybe call multy");
  }
  
  public final void a(a parama)
  {
    e("cr_flex", "1");
    if (parama == null)
    {
      APLog.d("SaveReq", "has no riskControlSoftSaveParameter!");
      return;
    }
    e("fk_rc_token", parama.a);
    e("fk_mobile_no", parama.b);
    e("fk_veri_type", parama.c);
    e("fk_auth_type", parama.d);
    e("fk_veri_code", parama.e);
    e("fk_cap_type", parama.f);
    e("fk_disturb_level", parama.g);
    e("fk_veri_appid", parama.h);
    e("fk_sub_auth_type", parama.i);
  }
  
  public final void b(int paramInt, String paramString)
  {
    a("gold_balance", paramInt, i());
    e("pay_method", "gold_balance");
    e("buy_quantity", paramString);
  }
  
  public void b(int paramInt, String paramString1, String paramString2)
  {
    a(paramString2, paramInt, i());
    c6 localc6 = c6.s0();
    e("pay_method", paramString2);
    e("buy_quantity", paramString1);
    e("pay_id", this.C.f.a);
    e("auth_key", this.C.f.b);
    if ((!TextUtils.isEmpty(this.C.b.mpInfo.payChannel)) && (!TextUtils.isEmpty(this.C.b.mpInfo.discountType)) && (!TextUtils.isEmpty(this.C.b.mpInfo.discountUrl)))
    {
      b("discounttype", this.C.b.mpInfo.discountType);
      b("discountextras", localc6.l());
      APLog.i("discounttype == ", this.C.b.mpInfo.discountType);
    }
    b("cft_type", "tokenid");
    if (("bank".equals(paramString2)) && (a.r().e()) && (!p4.p().e().e.f) && (!p4.p().e().e.c))
    {
      e("pay_id", "");
      e("auth_key", "");
    }
  }
  
  public final void c(int paramInt, String paramString)
  {
    a("hfpay", paramInt, i());
    e("hf_ver", "v2");
    e("pay_method", "hfpay");
    if (paramInt == 4) {
      paramString = "1";
    }
    e("buy_quantity", paramString);
    e("mfrom", APHFChannel.r);
    e("mobile", APHFChannel.s);
    e("mobile_loc", APHFChannel.t);
    e("operator", APTools.o(a.r().a()));
    e("mccmnc", APTools.n(a.r().a()));
    e("success_return_url", "https://unipay.sdk.android?midasret=0");
    e("fail_return_url", "https://unipay.sdk.android?midasret=1");
    e("cancel_return_url", "https://unipay.sdk.android?midasret=2");
    e("pay_scene", "sdk");
    paramString = new StringBuilder();
    paramString.append("mode=1#");
    Object localObject = n5.c();
    paramString.append("supportchannels=");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString.append((String)localObject);
    }
    paramString.append("#");
    n5.d();
    localObject = n5.b().iterator();
    while (((Iterator)localObject).hasNext())
    {
      l5 locall5 = (l5)((Iterator)localObject).next();
      if ((!TextUtils.isEmpty(locall5.f)) && (!TextUtils.isEmpty(locall5.g)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("channel=");
        localStringBuilder.append(locall5.b);
        localStringBuilder.append("&");
        localStringBuilder.append(locall5.g);
        localStringBuilder.append("#");
        paramString.append(localStringBuilder.toString());
      }
    }
    if (paramString.length() > 0)
    {
      paramString = paramString.substring(0, paramString.length() - 1);
      if (!TextUtils.isEmpty(paramString)) {
        e("hf_base_prequery", APTools.b(paramString, 1));
      }
    }
  }
  
  public void d(int paramInt, String paramString)
  {
    a("mcard", paramInt, i());
    this.B = "mcard";
    if (c6.s0().U())
    {
      e("isusempaymode", "1");
      if ((TextUtils.isEmpty(APMcardChannel.o)) && (TextUtils.isEmpty(APMcardChannel.p))) {
        this.B = "mcard_balance";
      }
    }
    else
    {
      e("isusempaymode", "0");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mcardPayType:");
    localStringBuilder.append(this.B);
    APLog.i("save", localStringBuilder.toString());
    e("pay_method", this.B);
    e("buy_quantity", paramString);
    e("pay_id", APMcardChannel.o);
    e("auth_key", APMcardChannel.p);
    e("card_value", APMcardChannel.q);
    b("verify_code", APMcardChannel.r);
    b("verify_session", APMcardChannel.s);
  }
  
  public final void e(int paramInt, String paramString)
  {
    a("wechat_payscore", paramInt, i());
    e("pay_method", "wechat_payscore");
    e("buy_quantity", paramString);
    e("pay_id", this.C.f.a);
    e("auth_key", this.C.f.b);
  }
  
  public boolean e(String paramString)
  {
    return (o.m().e(paramString)) && (!TextUtils.isEmpty(o.m().c(paramString)));
  }
  
  public void f(int paramInt, String paramString)
  {
    a("qqcard", paramInt, i());
    e("pay_method", "qqcard");
    e("buy_quantity", paramString);
    e("pay_id", APQQCardChannel.p);
    e("auth_key", APQQCardChannel.q);
    b("verify_code", APQQCardChannel.r);
    b("verify_session", APQQCardChannel.s);
  }
  
  public final void g(int paramInt, String paramString)
  {
    a("qqwallet", paramInt, i());
    e("pay_method", "qqwallet");
    e("buy_quantity", paramString);
    e("pay_id", this.C.f.a);
    e("auth_key", this.C.f.b);
    b("cft_type", "tokenid");
  }
  
  public final void h(int paramInt, String paramString)
  {
    a("wechat_quickpass", paramInt, i());
    e("pay_method", "wechat_quickpass");
    e("buy_quantity", paramString);
    e("pay_id", this.C.f.a);
    e("auth_key", this.C.f.b);
  }
  
  public void i(int paramInt, String paramString)
  {
    a("wsjpay", paramInt, i());
    if (!I())
    {
      e("callback_url", "http://www.549it.com/pro/proxy_result.php");
      e("pay_method", "wsjpay:2");
    }
    else
    {
      e("pay_method", "wsjpay:2");
    }
    e("buy_quantity", paramString);
  }
  
  public void j(int paramInt, String paramString)
  {
    a("wechat", paramInt, i());
    c6 localc6 = c6.s0();
    e("pay_method", "wechat");
    e("buy_quantity", paramString);
    e("pay_id", this.C.f.a);
    e("auth_key", this.C.f.b);
    if (c6.s0().q0())
    {
      paramString = new StringBuilder();
      paramString.append("dataInterface.getWechatAppid()=");
      paramString.append(localc6.b0());
      APLog.d("SaveReq", paramString.toString());
      paramString = new StringBuilder();
      paramString.append("dataInterface.getWsjWxAppid()=");
      paramString.append(localc6.f0());
      APLog.d("SaveReq", paramString.toString());
      paramString = new StringBuilder();
      paramString.append("dataInterface.getUuid()=");
      paramString.append(localc6.Z());
      APLog.d("SaveReq", paramString.toString());
      e("biz_appid", localc6.b0());
      e("wx_direct_pay", "1");
      e("wx_publice_pay", "1");
      e("uuid", localc6.Z());
      e("pushtype", "NodeJS");
      e("wx_order_interface", "1");
    }
    if ((!TextUtils.isEmpty(this.C.b.mpInfo.payChannel)) && (!TextUtils.isEmpty(this.C.b.mpInfo.discountType)) && (!TextUtils.isEmpty(this.C.b.mpInfo.discountUrl)))
    {
      b("discounttype", this.C.b.mpInfo.discountType);
      b("discountextras", localc6.l());
      APLog.i("discounttype == ", this.C.b.mpInfo.discountType);
    }
    if ((c6.s0().e0() != null) && (c6.s0().e0().toLowerCase().equals("v2")))
    {
      e("pre_contract", "1");
      b("pre_contract", "1");
    }
    if (((paramInt == 0) || (paramInt == 1)) && ((1 == this.C.c.e()) || (this.C.c.e() == 0))) {
      e("wx_smallamount_autopay", i.a(this.C.c.f()));
    }
  }
  
  public final void k(int paramInt, String paramString)
  {
    a("yb", paramInt, i());
    e("pay_method", "yb");
    e("buy_quantity", paramString);
    e("auth_key", this.C.f.b);
  }
  
  public static class a
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    
    public static a a(String paramString)
    {
      a locala = new a();
      if (TextUtils.isEmpty(paramString))
      {
        APLog.e("SaveReq", "Cannot create APRiskControlSoftSaveParameter with empty json!");
        return locala;
      }
      Object localObject = null;
      try
      {
        paramString = new JSONObject(paramString);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramString = localObject;
      }
      if (paramString == null)
      {
        APLog.e("SaveReq", "Cannot create APRiskControlSoftSaveParameter with malformed json!");
        return locala;
      }
      locala.a = paramString.optString("token");
      locala.b = paramString.optString("mobile_no");
      locala.c = paramString.optString("veri_type");
      locala.d = paramString.optString("auth_type");
      locala.e = paramString.optString("veri_code");
      locala.f = paramString.optString("cap_type");
      locala.g = paramString.optString("disturb_level");
      locala.h = paramString.optString("veri_appid");
      locala.i = paramString.optString("sub_auth_type");
      paramString = new StringBuilder();
      paramString.append("Create APRiskControlSoftSaveParameter = ");
      paramString.append(locala.toString());
      APLog.d("SaveReq", paramString.toString());
      return locala;
    }
    
    public static boolean b(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      return TextUtils.isEmpty(a(paramString).a) ^ true;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("APRiskControlSoftSaveParameter{fk_rc_token='");
      localStringBuilder.append(this.a);
      localStringBuilder.append('\'');
      localStringBuilder.append(", fk_mobile_no='");
      localStringBuilder.append(this.b);
      localStringBuilder.append('\'');
      localStringBuilder.append(", fk_veri_type='");
      localStringBuilder.append(this.c);
      localStringBuilder.append('\'');
      localStringBuilder.append(", fk_auth_type='");
      localStringBuilder.append(this.d);
      localStringBuilder.append('\'');
      localStringBuilder.append(", fk_veri_code='");
      localStringBuilder.append(this.e);
      localStringBuilder.append('\'');
      localStringBuilder.append(", fk_cap_type='");
      localStringBuilder.append(this.f);
      localStringBuilder.append('\'');
      localStringBuilder.append(", fk_disturb_level='");
      localStringBuilder.append(this.g);
      localStringBuilder.append('\'');
      localStringBuilder.append(", fk_veri_appid='");
      localStringBuilder.append(this.h);
      localStringBuilder.append('\'');
      localStringBuilder.append(", fk_sub_auth_type='");
      localStringBuilder.append(this.i);
      localStringBuilder.append('\'');
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.x3
 * JD-Core Version:    0.7.0.1
 */