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

public class du
  extends bx
{
  public String a;
  public String b = "";
  String c = "";
  private el v = em.b().n();
  private a w;
  
  public du(String paramString, a parama)
  {
    APLog.d("SaveReq", "New save request instance!");
    this.b = paramString;
    this.w = parama;
    if ((!"wechat".equals(paramString)) && (!"cft".equals(paramString)) && (!"bank".equals(paramString)) && (!"qqwallet".equals(paramString)))
    {
      this.k = 0;
      this.n = 20000;
    }
    if (e())
    {
      this.k = 0;
      this.n = 20000;
    }
    if (a(paramString))
    {
      this.k = 0;
      this.n = 20000;
    }
    Object localObject = em.b().f();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      APLog.e("SaveReq", "Cannot get offer id while creating save request instance!");
    }
    parama = "";
    int i = em.b().g();
    if (i == -1) {
      APLog.e("SaveReq", "Cannot get save type while creating save request instance!");
    }
    if ((bq.c()) && (bq.b(paramString)))
    {
      paramString = String.format("/v1/r/%s/cloud_save", new Object[] { localObject });
      if (i == 1)
      {
        APLog.d("SaveReq", "cloud Save type = goods while creating save request instance!");
        localObject = ((ev)this.v.b).l;
        paramString = new StringBuilder();
        paramString.append("Goods save url = ");
        paramString.append((String)localObject);
        paramString.append(" while creating save request instance!");
        APLog.d("SaveReq", paramString.toString());
        paramString = "";
        parama = "";
        i = ((String)localObject).lastIndexOf("?");
        if (i > 0)
        {
          paramString = ((String)localObject).substring(0, i);
          parama = ((String)localObject).substring(((String)localObject).lastIndexOf("token_id=") + 9);
        }
        this.v.e.m = parama;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cloud Save req token id = ");
        ((StringBuilder)localObject).append(parama);
        APLog.d("SaveReq", ((StringBuilder)localObject).toString());
        i = "/v1/r/%s/cloud_save".lastIndexOf("/");
        if (i == -1) {
          return;
        }
        parama = "/v1/r/%s/cloud_save".substring(i + 1);
        i = paramString.lastIndexOf("/");
        if (i == -1) {
          return;
        }
        paramString = paramString.replace(paramString.substring(i + 1), parama);
      }
    }
    else
    {
      switch (i)
      {
      default: 
        paramString = parama;
        break;
      case 4: 
      case 5: 
        paramString = String.format("/v1/r/%s/mobile_save_month", new Object[] { localObject });
        APLog.d("SaveReq", "Save type = month or subscribe while creating save request instance!");
        break;
      case 1: 
        APLog.d("SaveReq", "Save type = goods while creating save request instance!");
        localObject = ((ev)this.v.b).l;
        paramString = new StringBuilder();
        paramString.append("Goods save url = ");
        paramString.append((String)localObject);
        paramString.append(" while creating save request instance!");
        APLog.d("SaveReq", paramString.toString());
        paramString = "";
        parama = "";
        i = ((String)localObject).lastIndexOf("?");
        if (i > 0)
        {
          paramString = ((String)localObject).substring(0, i);
          parama = ((String)localObject).substring(((String)localObject).lastIndexOf("token_id=") + 9);
        }
        this.v.e.m = parama;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Save req token id = ");
        ((StringBuilder)localObject).append(parama);
        APLog.d("SaveReq", ((StringBuilder)localObject).toString());
        break;
      case 0: 
      case 2: 
      case 3: 
        paramString = String.format("/v1/r/%s/mobile_save", new Object[] { localObject });
        APLog.d("SaveReq", "Save type = game or qb or qd while creating save request instance!");
      }
    }
    parama = new StringBuilder();
    parama.append("Final url = ");
    parama.append(paramString);
    parama.append(" while creating save request!");
    APLog.d("SaveReq", parama.toString());
    a("https", paramString, "442");
    c();
  }
  
  private void I()
  {
    if ((bq.c()) && (bq.b(this.b)))
    {
      f("cloud_save_token", bq.h());
      f("mobile_offer_id", bq.e());
      f("mobile_openid", bq.f());
      f("replace_pf_header", bq.g());
      f("msg_encrypt_key", bq.b());
      int i = em.b().n().a.saveType;
      if ((i != 4) && (i != 5))
      {
        if (i == 1) {
          f("cloud_save_type", "bg");
        } else {
          f("cloud_save_type", "save");
        }
      }
      else {
        f("cloud_save_type", "month");
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(String.format("%06d", new Object[] { Integer.valueOf((int)(Math.random() * 1000000.0D)) }));
      localObject = ((StringBuilder)localObject).toString();
      fy.a().N((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("identify=");
      localStringBuilder.append((String)localObject);
      localObject = APTools.a(localStringBuilder.toString(), 1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cloudOthers = ");
      localStringBuilder.append((String)localObject);
      APLog.i("SaveReq", localStringBuilder.toString());
      f("cloud_others", (String)localObject);
    }
  }
  
  private void J()
  {
    this.v = em.b().n();
    int i = this.v.a.saveType;
    Object localObject = this.v.e.g;
    if ("qdqb".equals(this.b))
    {
      b(i, this.b, (String)localObject);
      return;
    }
    if ("qbqd".equals(this.b))
    {
      b(i, this.b, (String)localObject);
      return;
    }
    if ("wechat".equals(this.b))
    {
      c(i, (String)localObject);
      return;
    }
    if ("cft".equals(this.b))
    {
      a(i, (String)localObject, this.b);
      return;
    }
    if ("bank".equals(this.b))
    {
      a(i, (String)localObject, this.b);
      return;
    }
    if ("qqwallet".equals(this.b))
    {
      e(i, (String)localObject);
      return;
    }
    if ("wsjpay".equals(this.b))
    {
      d(i, (String)localObject);
      return;
    }
    if ("qqcard".equals(this.b))
    {
      b(i, (String)localObject);
      return;
    }
    if ("mcard".equals(this.b))
    {
      a(i, (String)localObject);
      return;
    }
    if ("hfpay".equals(this.b))
    {
      f(i, (String)localObject);
      return;
    }
    if ("yb".equals(this.b))
    {
      g(i, (String)localObject);
      return;
    }
    if ("goldcopon".equals(this.b))
    {
      h(i, (String)localObject);
      return;
    }
    if ("goldcouponsdeduct".equals(this.b))
    {
      i(i, (String)localObject);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Error channel id = ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", cannot handle it!");
    APLog.e("SaveReq", ((StringBuilder)localObject).toString());
  }
  
  private void a(String paramString, int paramInt, HashMap<String, String> paramHashMap)
  {
    fy localfy = fy.a();
    f("wx_pay_by_bindqq", "1");
    f("fk_tips", "1");
    if (this.v == null)
    {
      APUICommonMethod.b();
      fv.a(-1, "maybe call multy");
      return;
    }
    if ((a.a().j()) && ((paramInt == 2) || (paramInt == 3)))
    {
      if (!this.v.d.e)
      {
        paramHashMap.put("openid", this.v.e.a);
        f("openid", this.v.e.a);
        f("openkey", this.v.e.b);
        if (TextUtils.isEmpty(this.v.e.c))
        {
          f("session_id", "uin");
          f("session_type", "skey");
        }
        else
        {
          f("session_id", this.v.e.c);
          f("session_type", this.v.e.d);
        }
      }
      else if ((em.b().n().d.f) && (!TextUtils.isEmpty(this.v.e.a)))
      {
        paramHashMap.put("openid", this.v.e.a);
        f("openid", this.v.e.a);
        f("openkey", this.v.e.b);
        if (TextUtils.isEmpty(this.v.e.c))
        {
          f("session_id", "uin");
          f("session_type", "skey");
        }
        else
        {
          f("session_id", this.v.e.c);
          f("session_type", this.v.e.d);
        }
      }
      else
      {
        paramHashMap.put("openid", this.v.a.openId);
        f("openid", this.v.a.openId);
        f("openkey", this.v.a.openKey);
        f("session_id", this.v.a.sessionId);
        f("session_type", this.v.a.sessionType);
      }
    }
    else if ((d.a()) && ((paramInt == 2) || (paramInt == 3)))
    {
      paramHashMap.put("openid", this.v.e.a);
      f("openid", this.v.e.a);
      f("openkey", this.v.e.b);
      if (TextUtils.isEmpty(this.v.e.c))
      {
        f("session_id", "uin");
        f("session_type", "skey");
      }
      else
      {
        f("session_id", this.v.e.c);
        f("session_type", this.v.e.d);
      }
    }
    else if ((d.b()) && ((paramInt == 2) || (paramInt == 3)))
    {
      paramHashMap.put("openid", this.v.e.a);
      f("openid", this.v.e.a);
      f("openkey", this.v.e.b);
      if (TextUtils.isEmpty(this.v.e.c))
      {
        f("session_id", "uin");
        f("session_type", "skey");
      }
      else
      {
        f("session_id", this.v.e.c);
        f("session_type", this.v.e.d);
      }
    }
    else
    {
      paramHashMap.put("openid", this.v.a.openId);
      f("openid", this.v.a.openId);
      f("openkey", this.v.a.openKey);
      f("session_id", this.v.a.sessionId);
      f("session_type", this.v.a.sessionType);
    }
    this.a = ((String)paramHashMap.get("openid"));
    if (!TextUtils.isEmpty(this.v.a.mpInfo.drmInfo)) {
      f("drm_info", this.v.a.mpInfo.drmInfo);
    }
    if (!TextUtils.isEmpty(this.v.a.mpInfo.discoutId)) {
      f("discountid", this.v.a.mpInfo.discoutId);
    }
    if (paramInt == 0)
    {
      paramHashMap.put("pre_uuid", gf.b().c());
      paramHashMap.put("drm_act_type", gf.b().d());
      paramHashMap.put("drm_resource", gf.b().e());
    }
    if (localfy.S()) {
      paramHashMap.put("check_receipt", "1");
    }
    if ((paramInt == 1) && (a.c()))
    {
      e("friends_pay_msg", this.v.e.m);
      e("friends_pay_source", "mobile");
      e("token_store_type", "1");
    }
    else
    {
      f("token_id", this.v.e.m);
    }
    if ((this.v != null) && (a.a().g != null))
    {
      String str2;
      StringBuilder localStringBuilder;
      if ((a.a().g.a.saveType != this.v.a.saveType) && ((this.v.a.saveType == 3) || (this.v.a.saveType == 2)))
      {
        Object localObject1 = "";
        try
        {
          String str1 = URLDecoder.decode(localfy.y(), "UTF-8");
          localObject1 = str1;
        }
        catch (Exception localException4)
        {
          localException4.printStackTrace();
        }
        str2 = APTools.d((String)localObject1, "provide_uin");
        localObject1 = str2;
        try
        {
          if (o.a().b())
          {
            localObject1 = str2;
            if (o.a().c())
            {
              localObject1 = str2;
              if (o.a().d())
              {
                localObject1 = str2;
                if (o.a().o()) {
                  if (TextUtils.isEmpty(str2))
                  {
                    localObject1 = o.a().l();
                  }
                  else
                  {
                    localObject1 = URLEncoder.encode("&", "UTF-8");
                    localStringBuilder = new StringBuilder();
                    localStringBuilder.append(str2);
                    localStringBuilder.append((String)localObject1);
                    localStringBuilder.append(o.a().l());
                    localObject1 = localStringBuilder.toString();
                  }
                }
              }
            }
          }
          f("extend", URLEncoder.encode((String)localObject1, "UTF-8"));
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
      }
      else
      {
        if (localfy.S()) {
          e("check_receipt", "1");
        }
        str2 = localfy.y();
        Object localObject2 = str2;
        if (o.a().b())
        {
          localObject2 = str2;
          if (o.a().c())
          {
            localObject2 = str2;
            if (o.a().d())
            {
              localObject2 = str2;
              if (o.a().o()) {
                if (TextUtils.isEmpty(str2)) {
                  localObject2 = o.a().l();
                } else {
                  try
                  {
                    localObject2 = URLEncoder.encode("&", "UTF-8");
                    localStringBuilder = new StringBuilder();
                    localStringBuilder.append(str2);
                    localStringBuilder.append((String)localObject2);
                    localStringBuilder.append(o.a().l());
                    localObject2 = localStringBuilder.toString();
                  }
                  catch (Exception localException2)
                  {
                    localException2.printStackTrace();
                    localObject3 = str2;
                  }
                }
              }
            }
          }
        }
        f("extend", (String)localObject3);
      }
      if (!APAppDataInterface.singleton().e().equals("release"))
      {
        if (APAppDataInterface.singleton().z()) {
          f("encrypt_rsp", "1");
        }
      }
      else {
        f("encrypt_rsp", "1");
      }
      f("old_accounttype", this.v.a.acctType);
      Object localObject3 = APAppDataInterface.singleton().e();
      f("env", (String)localObject3);
      if ((((String)localObject3).equals("dev")) || (((String)localObject3).equals("test"))) {
        paramHashMap.put("offer_id", em.b().n().a.offerId);
      }
      paramHashMap.put("pf", this.v.a.pf);
      paramHashMap.put("pfkey", this.v.a.pfKey);
      if ((paramInt == 1) && (a.c()))
      {
        paramHashMap.put("friends_pay_msg", this.v.e.m);
        paramHashMap.put("friends_pay_source", "mobile");
        paramHashMap.put("token_store_type", "1");
      }
      else
      {
        paramHashMap.put("token_id", this.v.e.m);
      }
      paramHashMap.put("reqtype", "cpay");
      paramHashMap.put("sdkversion", fv.c());
      paramHashMap.put("session_token", this.v.e.l);
      paramHashMap.put("express_channel", this.v.e.j);
      paramHashMap.put("default_channel", gn.a().f());
      paramHashMap.put("pay_session_id", this.v.e.c);
      paramHashMap.put("pay_session_type", this.v.e.d);
      paramHashMap.put("uuid", localfy.i());
      paramHashMap.put("pushtype", "NodeJS");
      APLog.i("uuid == ", localfy.i());
      paramHashMap.put("user_uuid", APTools.a(localfy.q(), 1));
      paramHashMap.put("user_imei", APTools.a(localfy.r(), 1));
      paramHashMap.put("user_mac", APTools.a(localfy.t(), 1));
      paramHashMap.put("xg_mid", APAppDataInterface.singleton().l());
      paramHashMap.put("midasplugin_version", APAppDataInterface.singleton().m());
      paramHashMap.put("midascore_version", APAppDataInterface.singleton().n());
      if (n.a().j(paramString))
      {
        paramHashMap.put("sp_info", n.a().i(paramString));
        paramHashMap.put("out_trade_no", this.v.b());
      }
      e("env", (String)localObject3);
      switch (paramInt)
      {
      default: 
        break;
      case 4: 
        if (fy.a().F() != 0) {
          paramHashMap.put("change_prepay", Integer.toString(fy.a().F()));
        }
        if (((ew)this.v.b).l == 4) {
          if (this.v.a.isCanChange)
          {
            localObject3 = gc.a().h();
            if ((localObject3 != null) && (((String)localObject3).length() > 0)) {
              paramHashMap.put("provide_uin", gc.a().h());
            }
          }
          else
          {
            localObject3 = (ew)this.v.b;
            localObject3 = hm.a((ew)localObject3, ((ew)localObject3).m);
            if ((localObject3 != null) && (((String)localObject3).length() > 0)) {
              paramHashMap.put("provide_uin", localObject3);
            }
          }
        }
      case 5: 
        localObject3 = (ew)this.v.b;
        paramHashMap.put("service_code", ((APMonthRequest)this.v.a).serviceCode);
        paramHashMap.put("product_id", ((ew)localObject3).k);
        if ("1".equals(((ew)localObject3).n))
        {
          if (APTools.o(paramString)) {
            paramHashMap.put("auto_cont", "1");
          } else {
            paramHashMap.put("auto_cont", "0");
          }
        }
        else {
          paramHashMap.put("auto_cont", ((ew)localObject3).n);
        }
        f("zoneid", this.v.a.zoneId);
        if ("1".equals(((ew)localObject3).n))
        {
          e("client", "app");
          e("query_wx_sign_info", "1");
        }
        if ((paramInt == 4) && (((ew)this.v.b).l == 3)) {
          f("service_update", "1");
        }
        try
        {
          gc.a();
          if (gc.a().f() == gc.a.a) {
            paramHashMap.put("service_name", URLEncoder.encode(this.v.b.b, "UTF-8").toString());
          } else {
            paramHashMap.put("service_name", URLEncoder.encode(((APMonthRequest)this.v.a).serviceName, "UTF-8").toString());
          }
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
        }
      case 3: 
        f("accounttype", "qb");
        break;
      case 2: 
        f("accounttype", "qd");
        break;
      case 1: 
        f("accounttype", this.v.a.acctType);
        f("zoneid", this.v.a.zoneId);
        APLog.d("BuyType: ", this.v.b.j);
        e("buy_type", this.v.b.j);
        break;
      }
      f("accounttype", this.v.a.acctType);
      f("zoneid", this.v.a.zoneId);
      try
      {
        paramHashMap.put("wcp", APTools.a(paramInt, paramString));
        paramHashMap.put("remark", URLEncoder.encode(this.v.a.remark, "UTF-8"));
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    APUICommonMethod.b();
    fv.a(-1, "maybe call multy");
  }
  
  private void a(a parama)
  {
    f("cr_flex", "1");
    if (parama == null)
    {
      APLog.d("SaveReq", "has no riskControlSoftSaveParameter!");
      return;
    }
    f("fk_rc_token", parama.a);
    f("fk_mobile_no", parama.b);
    f("fk_veri_type", parama.c);
    f("fk_auth_type", parama.d);
    f("fk_veri_code", parama.e);
    f("fk_cap_type", parama.f);
    f("fk_disturb_level", parama.g);
    f("fk_veri_appid", parama.h);
    f("fk_sub_auth_type", parama.i);
  }
  
  private void b(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mb_pwd:");
    localStringBuilder.append(APQDQBChannel.k);
    APLog.i("APSaveReq", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("sms_info:");
    localStringBuilder.append(APQDQBChannel.m);
    APLog.i("APSaveReq", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mb_type:");
    localStringBuilder.append(APQDQBChannel.l);
    APLog.i("APSaveReq", localStringBuilder.toString());
    if (!TextUtils.isEmpty(APQDQBChannel.k)) {
      f("mb_pwd", APQDQBChannel.k);
    }
    if (!TextUtils.isEmpty(APQDQBChannel.m)) {
      e("sms_info", APQDQBChannel.m);
    }
    if (!TextUtils.isEmpty(APQDQBChannel.l)) {
      e("mb_type", APQDQBChannel.l);
    }
    a(paramString1, paramInt, m());
    f("session_id", this.v.a.sessionId);
    f("session_type", this.v.a.sessionType);
    if ("qdqb".equals(paramString1)) {
      f("pay_method", "qdqb");
    } else {
      f("pay_method", "qbqd");
    }
    f("buy_quantity", paramString2);
    f("pay_id", this.v.e.a);
    f("auth_key", this.v.e.b);
    f("h5_mb_url", URLEncoder.encode("http://unipay.mibaocheck"));
    if ((fy.a().x()) && (this.v.d.e) && (a.a().j()))
    {
      if ((APQDQBChannel.j != null) && (APQDQBChannel.j.length() > 0))
      {
        f("have_changed_uin", "1");
        APLog.i("APTag", "resultData=更换QQ号码");
      }
      if (gc.a().i())
      {
        e("pay_id", gc.a().j());
        e("auth_key", gc.a().k());
        f("have_changed_uin", "1");
        APLog.i("APTag", "resultData=更换QQ号码继续充值走saveCgi");
      }
    }
  }
  
  private void e(int paramInt, String paramString)
  {
    a("qqwallet", paramInt, m());
    f("pay_method", "qqwallet");
    f("buy_quantity", paramString);
    f("pay_id", this.v.e.a);
    f("auth_key", this.v.e.b);
    e("cft_type", "tokenid");
  }
  
  private void f(int paramInt, String paramString)
  {
    a("hfpay", paramInt, m());
    f("hf_ver", "v2");
    f("pay_method", "hfpay");
    if (paramInt == 4) {
      paramString = "1";
    }
    f("buy_quantity", paramString);
    f("mfrom", APHFChannel.k);
    f("mobile", APHFChannel.l);
    f("mobile_loc", APHFChannel.m);
    f("operator", APTools.g(a.a().b()));
    f("mccmnc", APTools.f(a.a().b()));
    f("success_return_url", "https://unipay.sdk.android?midasret=0");
    f("fail_return_url", "https://unipay.sdk.android?midasret=1");
    f("cancel_return_url", "https://unipay.sdk.android?midasret=2");
    f("pay_scene", "sdk");
    paramString = new StringBuilder();
    paramString.append("mode=1#");
    Object localObject = fk.c();
    paramString.append("supportchannels=");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString.append((String)localObject);
    }
    paramString.append("#");
    fk.a();
    localObject = fk.b().iterator();
    while (((Iterator)localObject).hasNext())
    {
      fi localfi = (fi)((Iterator)localObject).next();
      if ((!TextUtils.isEmpty(localfi.g)) && (!TextUtils.isEmpty(localfi.h)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("channel=");
        localStringBuilder.append(localfi.c);
        localStringBuilder.append("&");
        localStringBuilder.append(localfi.h);
        localStringBuilder.append("#");
        paramString.append(localStringBuilder.toString());
      }
    }
    if (paramString.length() > 0)
    {
      paramString = paramString.substring(0, paramString.length() - 1);
      if (!TextUtils.isEmpty(paramString)) {
        f("hf_base_prequery", APTools.a(paramString, 1));
      }
    }
  }
  
  private void g(int paramInt, String paramString)
  {
    a("yb", paramInt, m());
    f("pay_method", "yb");
    f("buy_quantity", paramString);
    f("auth_key", this.v.e.b);
  }
  
  private void h(int paramInt, String paramString)
  {
    a("gold_coupons", paramInt, m());
    f("pay_method", "gold_coupons");
    f("buy_quantity", paramString);
    f("auth_key", this.v.e.b);
  }
  
  private void i(int paramInt, String paramString)
  {
    a("gold_balance", paramInt, m());
    f("pay_method", "gold_balance");
    f("buy_quantity", paramString);
  }
  
  public void a(int paramInt, String paramString)
  {
    a("mcard", paramInt, m());
    this.c = "mcard";
    if (fy.a().A())
    {
      f("isusempaymode", "1");
      if ((TextUtils.isEmpty(APMcardChannel.j)) && (TextUtils.isEmpty(APMcardChannel.k))) {
        this.c = "mcard_balance";
      }
    }
    else
    {
      f("isusempaymode", "0");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mcardPayType:");
    localStringBuilder.append(this.c);
    APLog.i("save", localStringBuilder.toString());
    f("pay_method", this.c);
    f("buy_quantity", paramString);
    f("pay_id", APMcardChannel.j);
    f("auth_key", APMcardChannel.k);
    f("card_value", APMcardChannel.l);
    e("verify_code", APMcardChannel.m);
    e("verify_session", APMcardChannel.n);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    a(paramString2, paramInt, m());
    fy localfy = fy.a();
    f("pay_method", paramString2);
    f("buy_quantity", paramString1);
    f("pay_id", this.v.e.a);
    f("auth_key", this.v.e.b);
    if ((!TextUtils.isEmpty(this.v.a.mpInfo.payChannel)) && (!TextUtils.isEmpty(this.v.a.mpInfo.discountType)) && (!TextUtils.isEmpty(this.v.a.mpInfo.discountUrl)))
    {
      e("discounttype", this.v.a.mpInfo.discountType);
      e("discountextras", localfy.m());
      APLog.i("discounttype == ", this.v.a.mpInfo.discountType);
    }
    e("cft_type", "tokenid");
    if (("bank".equals(paramString2)) && (a.a().j()) && (!em.b().n().d.f) && (!em.b().n().d.c))
    {
      f("pay_id", "");
      f("auth_key", "");
    }
  }
  
  public boolean a(String paramString)
  {
    return (n.a().j(paramString)) && (!TextUtils.isEmpty(n.a().i(paramString)));
  }
  
  public void b(int paramInt, String paramString)
  {
    a("qqcard", paramInt, m());
    f("pay_method", "qqcard");
    f("buy_quantity", paramString);
    f("pay_id", APQQCardChannel.j);
    f("auth_key", APQQCardChannel.k);
    e("verify_code", APQQCardChannel.l);
    e("verify_session", APQQCardChannel.m);
  }
  
  public void c()
  {
    J();
    e("offer_id", em.b().f());
    f("is_hfpay_autoflow", "1");
    I();
    a(this.w);
  }
  
  public void c(int paramInt, String paramString)
  {
    a("wechat", paramInt, m());
    fy localfy = fy.a();
    f("pay_method", "wechat");
    f("buy_quantity", paramString);
    f("pay_id", this.v.e.a);
    f("auth_key", this.v.e.b);
    if (fy.a().ai())
    {
      paramString = new StringBuilder();
      paramString.append("dataInterface.getWechatAppid()=");
      paramString.append(localfy.N());
      APLog.d("SaveReq", paramString.toString());
      paramString = new StringBuilder();
      paramString.append("dataInterface.getWsjWxAppid()=");
      paramString.append(localfy.z());
      APLog.d("SaveReq", paramString.toString());
      paramString = new StringBuilder();
      paramString.append("dataInterface.getUuid()=");
      paramString.append(localfy.i());
      APLog.d("SaveReq", paramString.toString());
      f("biz_appid", localfy.N());
      f("wx_direct_pay", "1");
      f("wx_publice_pay", "1");
      f("uuid", localfy.i());
      f("pushtype", "NodeJS");
      f("wx_order_interface", "1");
    }
    if ((!TextUtils.isEmpty(this.v.a.mpInfo.payChannel)) && (!TextUtils.isEmpty(this.v.a.mpInfo.discountType)) && (!TextUtils.isEmpty(this.v.a.mpInfo.discountUrl)))
    {
      e("discounttype", this.v.a.mpInfo.discountType);
      e("discountextras", localfy.m());
      APLog.i("discounttype == ", this.v.a.mpInfo.discountType);
    }
    if ((fy.a().M() != null) && (fy.a().M().toLowerCase().equals("v2")))
    {
      f("pre_contract", "1");
      e("pre_contract", "1");
    }
    if (((paramInt == 0) || (paramInt == 1)) && ((1 == this.v.b.e()) || (this.v.b.e() == 0))) {
      f("wx_smallamount_autopay", i.a(this.v.b.f()));
    }
  }
  
  public void d(int paramInt, String paramString)
  {
    a("wsjpay", paramInt, m());
    if (!d())
    {
      f("callback_url", "http://www.549it.com/pro/proxy_result.php");
      f("pay_method", "wsjpay:2");
    }
    else
    {
      f("pay_method", "wsjpay:2");
    }
    f("buy_quantity", paramString);
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    return (o.a().b()) && (o.a().c()) && (o.a().d()) && (o.a().o());
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
    
    public static boolean a(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      return TextUtils.isEmpty(b(paramString).a) ^ true;
    }
    
    public static a b(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.du
 * JD-Core Version:    0.7.0.1
 */