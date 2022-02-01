package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class w3
  extends ob
{
  public String A = "";
  public String B = "";
  public String C = "";
  public String D = "";
  public String E = "";
  public String F = "";
  public String G = "";
  public String H = "";
  public String I = "";
  public String J = "";
  public String K = "";
  public String L = "";
  public String M = "";
  public String N = "1";
  public String O = "";
  public String P = "";
  public String Q = "";
  public int R = 0;
  public String S = "";
  public String T = "";
  public String U = "";
  public int V = 0;
  public String W = "";
  public String X = "";
  public String Y = "";
  public String Z = "";
  public String a0 = "账户异常，无法充值";
  public int b0 = -1;
  public String c0 = "";
  public String d0 = "";
  public String e0 = "";
  public r8 f0 = new r8();
  public c5 g = p4.p().e().e;
  public String g0;
  public String h = "";
  public String h0;
  public String i = "";
  public String i0 = null;
  public String j = "";
  public String j0 = null;
  public String k = "";
  public String k0 = null;
  public int l = -1;
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  public String q = "";
  public String r = "";
  public String s = "";
  public String t = "";
  public String u = "";
  public String v = "";
  public String w = "";
  public String x = "";
  public String y = "";
  public String z = "";
  
  public w3(fc paramfc)
  {
    super(paramfc);
  }
  
  public String A()
  {
    return this.g0;
  }
  
  public String B()
  {
    return this.r;
  }
  
  public String C()
  {
    return this.z;
  }
  
  public String D()
  {
    return this.B;
  }
  
  public String E()
  {
    return this.F;
  }
  
  public String F()
  {
    return this.G;
  }
  
  public String G()
  {
    return this.y;
  }
  
  public String H()
  {
    return this.D;
  }
  
  public String I()
  {
    return this.E;
  }
  
  public String J()
  {
    return this.A;
  }
  
  public String K()
  {
    return this.H;
  }
  
  public String L()
  {
    return this.a0;
  }
  
  public int M()
  {
    return this.b0;
  }
  
  public String N()
  {
    return this.k;
  }
  
  public String O()
  {
    return this.m;
  }
  
  public int P()
  {
    return this.l;
  }
  
  public String Q()
  {
    return this.k0;
  }
  
  public String R()
  {
    return this.i0;
  }
  
  public String S()
  {
    return this.j0;
  }
  
  public String T()
  {
    return this.p;
  }
  
  public String U()
  {
    return this.q;
  }
  
  public String V()
  {
    return this.s;
  }
  
  public String W()
  {
    return this.v;
  }
  
  public String X()
  {
    return this.x;
  }
  
  public String Y()
  {
    return this.t;
  }
  
  public String Z()
  {
    return this.w;
  }
  
  public String a(String paramString)
  {
    return n4.a(paramString, b());
  }
  
  public final void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has("sp_info")) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("sp_info");
        if (paramJSONObject != null)
        {
          if (paramJSONObject.has("channel_orderid"))
          {
            this.Y = paramJSONObject.getString("channel_orderid");
            this.Y = a(this.Y);
            c6.s0().e(this.Y);
          }
          if (paramJSONObject.has("drm_goldcoupons_acct"))
          {
            this.X = paramJSONObject.getString("drm_goldcoupons_acct");
            this.X = a(this.X);
            p.o().b(this.X);
          }
          if (paramJSONObject.has("out_trade_no"))
          {
            this.Z = paramJSONObject.getString("out_trade_no");
            p4.p().e().a(this.Z);
            return;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public boolean a(s1 params1)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(params1.c);
      if (!a(params1, localJSONObject)) {
        return false;
      }
      a(localJSONObject);
      return true;
    }
    catch (Exception params1)
    {
      params1.printStackTrace();
    }
    return false;
  }
  
  public final boolean a(s1 params1, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("cloud_save_info");
    if (paramJSONObject == null) {
      return false;
    }
    try
    {
      paramJSONObject = new JSONObject(paramJSONObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cloudInfo() ");
      localStringBuilder.append(paramJSONObject.toString());
      APLog.w("APSaveAns", localStringBuilder.toString());
      params1.a.b = paramJSONObject.optString("cloud_offer_id");
      params1.a.d = paramJSONObject.optString("cloud_client_id");
      params1.a.c = paramJSONObject.optString("cloud_openid");
      this.g0 = paramJSONObject.optString("pay_method");
      this.h0 = paramJSONObject.optString("cloud_others");
      return true;
    }
    catch (Exception params1)
    {
      params1.printStackTrace();
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("get decKey error222:");
      paramJSONObject.append(params1.toString());
      APLog.w("APSaveAns", paramJSONObject.toString());
      APLog.w("APSaveAns", "cloudInfo()  return False");
    }
    return false;
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    label1410:
    for (;;)
    {
      try
      {
        Object localObject1 = paramJSONObject.optJSONObject("info");
        if (localObject1 == null) {
          return false;
        }
        this.a = paramJSONObject.optInt("ret");
        this.b = paramJSONObject.optString("msg");
        this.i = ((JSONObject)localObject1).optString("count");
        this.j = ((JSONObject)localObject1).optString("mburl");
        Object localObject3 = b();
        this.n = a(((JSONObject)localObject1).optString("cfturl"));
        boolean bool = APAppDataInterface.singleton().h().equals("dev");
        if (!bool) {
          break label1410;
        }
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("cfturl=");
        localStringBuilder1.append(this.n);
        APLog.i("APSaveAns", localStringBuilder1.toString());
        bool = ((JSONObject)localObject1).has("success_url");
        if (bool)
        {
          this.h = ((JSONObject)localObject1).optString("success_url");
          if ((!TextUtils.isEmpty(this.h)) && (!this.h.equals("null"))) {
            c6.s0().B(this.h);
          }
        }
        try
        {
          this.o = ((JSONObject)localObject1).optString("mcardserialno");
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
        }
        try
        {
          this.p = ((JSONObject)localObject1).optString("verifycode");
          this.q = ((JSONObject)localObject1).optString("verifysession");
        }
        catch (Exception localException4)
        {
          localException4.printStackTrace();
        }
        try
        {
          String str1 = ((JSONObject)localObject1).optString("present_count");
          h6.b().a("");
          if ((!TextUtils.isEmpty(str1)) && (!str1.equals("null"))) {
            h6.b().a(str1);
          }
        }
        catch (Exception localException5)
        {
          localException5.printStackTrace();
        }
        if (((JSONObject)localObject1).has("sms_info")) {
          this.k = ((JSONObject)localObject1).optString("sms_info");
        }
        if ((this.k != null) && (!this.k.equals(""))) {
          com.pay.paychannel.qdqb.APQDQBChannel.r = this.k;
        }
        if (((JSONObject)localObject1).has("remain")) {
          this.l = ((JSONObject)localObject1).getInt("remain");
        } else {
          this.l = -1;
        }
        if (((JSONObject)localObject1).has("mb_only_sms")) {
          this.m = ((JSONObject)localObject1).optString("mb_only_sms");
        } else {
          this.m = "";
        }
        try
        {
          if (((JSONObject)localObject1).has("drm_resource"))
          {
            String str2 = ((JSONObject)localObject1).optString("drm_resource");
            if (!TextUtils.isEmpty(str2)) {
              j6.e().b(str2);
            }
          }
        }
        catch (Exception localException6)
        {
          APLog.e("saveAns", localException6.toString());
        }
        try
        {
          if (((JSONObject)localObject1).has("portal_serial_no"))
          {
            String str3 = ((JSONObject)localObject1).optString("portal_serial_no");
            p4.p().e().f.n = str3;
            c6.s0().s(str3);
          }
          else
          {
            c6.s0().s("");
          }
        }
        catch (Exception localException7)
        {
          localException7.printStackTrace();
        }
        try
        {
          if (((JSONObject)localObject1).has("PortalExtendField"))
          {
            String str4 = ((JSONObject)localObject1).optString("PortalExtendField");
            c6.s0().r(str4);
          }
          else
          {
            c6.s0().r("");
          }
        }
        catch (Exception localException8)
        {
          localException8.printStackTrace();
        }
        try
        {
          if (((JSONObject)localObject1).has("comm_config"))
          {
            Object localObject4 = ((JSONObject)localObject1).getJSONObject("comm_config");
            if (((JSONObject)localObject4).has("is_kj"))
            {
              localObject4 = ((JSONObject)localObject4).optString("is_kj");
              if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                if (((String)localObject4).equals("1")) {
                  this.g.c = true;
                } else {
                  this.g.c = false;
                }
              }
            }
          }
          if (((JSONObject)localObject1).has("mbkey")) {
            com.pay.paychannel.qdqb.APQDQBChannel.p = ((JSONObject)localObject1).optString("mbkey");
          }
        }
        catch (Exception localException9)
        {
          APLog.e("info", localException9.toString());
        }
        if (paramJSONObject.has("need_change_key")) {
          if (paramJSONObject.getInt("need_change_key") == 1) {
            APAppDataInterface.singleton().a(true);
          } else {
            APAppDataInterface.singleton().a(false);
          }
        }
        p4.p().e().f.g = this.i;
        h(paramJSONObject);
        c(paramJSONObject);
        a(paramJSONObject, (String)localObject3);
        b(paramJSONObject);
        d(paramJSONObject);
        e(paramJSONObject);
        StringBuilder localStringBuilder2;
        if (this.a != 0)
        {
          this.r = ((JSONObject)localObject1).optString("qkbalance");
          this.e0 = paramJSONObject.optString("err_code");
          f((JSONObject)localObject1);
          this.b = paramJSONObject.optString("msg");
          if ((this.a != 100008) && (this.a != 100009))
          {
            this.c = this.b;
            localObject3 = paramJSONObject.optString("err_code").toString();
            if (!((String)localObject3).equals(""))
            {
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("系统繁忙,请稍后再试 (");
              localStringBuilder2.append((String)localObject3);
              localStringBuilder2.append(")");
              this.b = localStringBuilder2.toString();
            }
          }
          if (this.a == 1004)
          {
            c6.s0().a(false);
            if ((((JSONObject)localObject1).has("is_allow_change")) && (((JSONObject)localObject1).optString("is_allow_change").equals("1"))) {
              c6.s0().a(true);
            }
          }
        }
        if (("mcard".equals(p4.p().e().f.e)) && (((JSONObject)localObject1).has("mcard_balance")) && (!TextUtils.isEmpty(((JSONObject)localObject1).optString("mcard_balance"))))
        {
          localObject3 = a(((JSONObject)localObject1).optString("mcard_balance"));
          this.g.h = i.b((String)localObject3);
        }
        if (((JSONObject)localObject1).has("user_msg"))
        {
          localObject1 = a(((JSONObject)localObject1).optString("user_msg"));
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            int i1 = this.a;
            if (i1 == 1004)
            {
              try
              {
                localObject1 = new JSONObject((String)localObject1);
                if (((JSONObject)localObject1).has("qqacct_balance"))
                {
                  localObject3 = ((JSONObject)localObject1).optString("qqacct_balance");
                  localStringBuilder2 = new StringBuilder();
                  localStringBuilder2.append("balance:");
                  localStringBuilder2.append((String)localObject3);
                  APLog.e("APSaveAns", localStringBuilder2.toString());
                  if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                    p4.p().e().e.g = i.b((String)localObject3);
                  }
                }
                if (!((JSONObject)localObject1).has("uin")) {
                  continue;
                }
                localObject1 = ((JSONObject)localObject1).optString("uin");
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("uin:");
                ((StringBuilder)localObject3).append((String)localObject1);
                APLog.e("APSaveAns", ((StringBuilder)localObject3).toString());
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  continue;
                }
                p4.p().e().e.l = ((String)localObject1);
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
              }
            }
            else
            {
              i1 = this.a;
              if (i1 != 0) {}
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("系统繁忙,请稍后再试 ");
        ((StringBuilder)localObject2).append(x1.a(20003));
        this.b = ((StringBuilder)localObject2).toString();
        paramJSONObject.printStackTrace();
      }
      try
      {
        localObject2 = new JSONObject(localException1);
        if (!((JSONObject)localObject2).has("receipt_transid")) {
          continue;
        }
        localObject2 = ((JSONObject)localObject2).optString("receipt_transid");
        c6.s0().D((String)localObject2);
      }
      catch (Exception localException2)
      {
        continue;
      }
      APLog.i("from usrmsg", "get transid");
      g(paramJSONObject);
      return true;
    }
  }
  
  public String a0()
  {
    return this.u;
  }
  
  public final void b(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("hf_info");
      this.I = paramJSONObject.optString("vtype");
      this.J = paramJSONObject.optString("province");
      this.M = paramJSONObject.optString("billno");
      p4.p().e().f.m = this.M;
      this.S = paramJSONObject.optString("channel");
      c6.s0().n(this.S);
      this.O = paramJSONObject.optString("price");
      this.P = paramJSONObject.optString("tips");
      c6.s0().l(paramJSONObject.optString("hf_extend"));
      this.R = i.b(paramJSONObject.optString("hf_interfacetype"));
      if ((p4.p().e().b.saveType == 4) || (p4.p().e().b.saveType == 5))
      {
        c6.s0().m(paramJSONObject.optString("real_servicecode"));
        this.Q = paramJSONObject.optString("fee_type");
        try
        {
          this.U = URLDecoder.decode(paramJSONObject.getString("hfpay_pay_tips"), "UTF-8");
          this.U = this.U.replace("\\n", "\n");
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      if (this.R == 1) {
        return;
      }
      int i1 = this.R;
      if (i1 == 2)
      {
        String str = paramJSONObject.optString("hfpay_url");
        c6.s0().o(str);
        paramJSONObject.optString("outOrderId");
        this.V = paramJSONObject.optInt("solutionType");
        return;
      }
      if (this.R == 4)
      {
        this.T = paramJSONObject.optString("hfpay_channelInfo");
        if (TextUtils.isEmpty(b())) {
          APLog.e("Save", "Cannot get decode key!");
        }
        this.T = a(this.T);
        return;
      }
      if (this.R == 8)
      {
        this.K = paramJSONObject.optString("accessnum");
        this.L = paramJSONObject.optString("accessmsg");
        this.N = paramJSONObject.optString("up_times", "1");
        paramJSONObject.optString("outOrderId");
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public boolean b(gb paramgb)
  {
    c6.s0().a(0);
    return super.b(paramgb);
  }
  
  public final void c(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("qqwallet_info"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("qqwallet_info");
        this.z = paramJSONObject.getString("qqwallet_appId");
        this.A = paramJSONObject.getString("qqwallet_timestamp");
        this.B = paramJSONObject.getString("qqwallet_nonce");
        this.H = paramJSONObject.getString("qqwallet_tokenId");
        this.C = paramJSONObject.getString("qqwallet_bargainorId");
        this.E = paramJSONObject.getString("qqwallet_sigType");
        this.D = paramJSONObject.getString("qqwallet_sig");
        if (paramJSONObject.has("qqwallet_seq")) {
          this.y = paramJSONObject.getString("qqwallet_seq");
        }
        if (paramJSONObject.has("qqwallet_pubAcc")) {
          this.F = paramJSONObject.getString("qqwallet_pubAcc");
        }
        if (paramJSONObject.has("qqwallet_pubAccHint")) {
          this.G = paramJSONObject.getString("qqwallet_pubAccHint");
        }
        try
        {
          if (paramJSONObject.has("qq_sign_url"))
          {
            if (!TextUtils.isEmpty(paramJSONObject.getString("qq_sign_url")))
            {
              c6.s0().t(paramJSONObject.getString("qq_sign_url"));
              return;
            }
            c6.s0().t("");
            return;
          }
        }
        catch (Exception paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          return;
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public boolean c(gb paramgb)
  {
    c6.s0().a(0);
    return super.c(paramgb);
  }
  
  public final void d(JSONObject paramJSONObject)
    throws JSONException
  {
    c6.s0().y("");
    if (paramJSONObject.has("rc_info"))
    {
      if (this.a != 1138) {
        return;
      }
      try
      {
        Object localObject = paramJSONObject.getJSONObject("rc_info");
        this.b0 = ((JSONObject)localObject).optInt("rc_type", -1);
        this.d0 = ((JSONObject)localObject).optString("rc_amt", "");
        this.c0 = ((JSONObject)localObject).optString("rc_policyid", "");
        localObject = c6.s0();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("rc_type=");
        localStringBuilder.append(this.b0);
        localStringBuilder.append("&rc_amt=");
        localStringBuilder.append(this.d0);
        localStringBuilder.append("&rc_policyid=");
        localStringBuilder.append(this.c0);
        ((c6)localObject).y(localStringBuilder.toString());
        this.a0 = paramJSONObject.optString("msg", "账户异常，无法充值");
        if (TextUtils.isEmpty(this.a0))
        {
          this.a0 = "账户异常，无法充值";
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public boolean d(gb paramgb)
  {
    c6.s0().a(0);
    String str = new String(paramgb.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append(str);
    APLog.i("APSaveAns", localStringBuilder.toString());
    try
    {
      a(new JSONObject(str));
      this.W = ((x3)paramgb.g()).B;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return super.d(paramgb);
  }
  
  public final void e(JSONObject paramJSONObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Get rcs info, info == ");
    ((StringBuilder)localObject).append(paramJSONObject);
    APLog.d("APSaveAns", ((StringBuilder)localObject).toString());
    if (paramJSONObject == null)
    {
      APLog.e("APSaveAns", "Cannot get rcs info, info is null!");
      return;
    }
    localObject = paramJSONObject.optJSONObject("flex_attack_info");
    if (localObject == null)
    {
      APLog.e("APSaveAns", "Cannot get rcs info, flex attack info is null!");
      return;
    }
    paramJSONObject = ((JSONObject)localObject).optString("verify_url");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vrfurl encode == ");
    localStringBuilder.append(paramJSONObject);
    APLog.d("APSaveAns", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = a(paramJSONObject);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("vrfurl2 decode == ");
      localStringBuilder.append(paramJSONObject);
      APLog.d("APSaveAns", localStringBuilder.toString());
    }
    else
    {
      APLog.e("APSaveAns", "empty vrfurl encode !");
    }
    if (!TextUtils.isEmpty(paramJSONObject)) {
      this.f0.b = paramJSONObject;
    } else {
      APLog.e("APSaveAns", "decode vrfurl2 empty!");
    }
    paramJSONObject = ((JSONObject)localObject).optString("fk_info");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("fkinfo encode == ");
    localStringBuilder.append(paramJSONObject);
    APLog.d("APSaveAns", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = a(paramJSONObject);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fkinfo2 decode == ");
      localStringBuilder.append(paramJSONObject);
      APLog.d("APSaveAns", localStringBuilder.toString());
    }
    else
    {
      APLog.e("APSaveAns", "encode fkinfo empty");
    }
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = APTools.b(paramJSONObject, 1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fkinfo3 urlencode == ");
      localStringBuilder.append(paramJSONObject);
      APLog.d("APSaveAns", localStringBuilder.toString());
      this.f0.a = paramJSONObject;
    }
    else
    {
      APLog.e("APSaveAns", "decode fkinfo2 empty");
    }
    paramJSONObject = ((JSONObject)localObject).optString("fk_amt");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fk_amt encode == ");
    ((StringBuilder)localObject).append(paramJSONObject);
    APLog.d("APSaveAns", ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = a(paramJSONObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fk_amt decode == ");
      ((StringBuilder)localObject).append(paramJSONObject);
      APLog.d("APSaveAns", ((StringBuilder)localObject).toString());
    }
    else
    {
      APLog.e("APSaveAns", "empty fk_amt encode !");
    }
    if (!TextUtils.isEmpty(paramJSONObject)) {
      this.f0.c = paramJSONObject;
    } else {
      APLog.e("APSaveAns", "decode vrfurl2 empty!");
    }
    paramJSONObject = a();
    if (paramJSONObject != null)
    {
      if ((paramJSONObject instanceof x3))
      {
        paramJSONObject = (x3)paramJSONObject;
        this.f0.d = paramJSONObject.d("pay_method");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fk pay method == ");
        ((StringBuilder)localObject).append(this.f0.d);
        APLog.d("APSaveAns", ((StringBuilder)localObject).toString());
        this.f0.f = paramJSONObject.d("extend");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fk extend == ");
        ((StringBuilder)localObject).append(this.f0.f);
        APLog.d("APSaveAns", ((StringBuilder)localObject).toString());
        this.f0.g = paramJSONObject.a("service_code");
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("fk service_code == ");
        paramJSONObject.append(this.f0.g);
        APLog.d("APSaveAns", paramJSONObject.toString());
        return;
      }
      APLog.e("APSaveAns", "request not save request for pay method!");
      return;
    }
    APLog.e("APSaveAns", "Cannot get request for pay method!");
  }
  
  public final void f(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("userInfo")) {
      return;
    }
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("user_info").getString("uin_type");
      this.g.j = paramJSONObject;
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public String g()
  {
    return this.n;
  }
  
  public final void g(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      if (paramJSONObject.has("wechat_quickpass_info"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("wechat_quickpass_info");
        this.k0 = paramJSONObject.optString("order_info");
        this.i0 = paramJSONObject.optString("sp_id");
        this.j0 = paramJSONObject.optString("sys_provider");
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public String h()
  {
    return this.h0;
  }
  
  public final void h(JSONObject paramJSONObject)
  {
    APLog.i("apsaveans wxInfo", paramJSONObject.toString());
    try
    {
      if (paramJSONObject.has("wx_info"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("wx_info");
        this.s = paramJSONObject.getString("wx_appid");
        this.t = paramJSONObject.getString("wx_partner");
        this.u = paramJSONObject.getString("wx_time");
        this.v = paramJSONObject.getString("wx_noncenum");
        this.w = paramJSONObject.getString("wx_sign");
        this.x = paramJSONObject.getString("wx_package");
        try
        {
          if (paramJSONObject.has("wx_sign_url"))
          {
            int i1 = p4.p().e().b.saveType;
            if ((i1 != 0) && (1 != i1))
            {
              if (!TextUtils.isEmpty(paramJSONObject.getString("wx_sign_url"))) {
                c6.s0().L(paramJSONObject.getString("wx_sign_url"));
              } else {
                c6.s0().L("");
              }
            }
            else if (!TextUtils.isEmpty(paramJSONObject.getString("wx_sign_url"))) {
              c6.s0().L(APTools.a(paramJSONObject.getString("wx_sign_url"), 1));
            } else {
              c6.s0().L("");
            }
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        try
        {
          if (paramJSONObject.has("wx_pre_entrustweb_id")) {
            if (!TextUtils.isEmpty(paramJSONObject.getString("wx_pre_entrustweb_id"))) {
              c6.s0().K(paramJSONObject.getString("wx_pre_entrustweb_id"));
            } else {
              c6.s0().K("");
            }
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        if (paramJSONObject.has("wx_serialno"))
        {
          paramJSONObject = paramJSONObject.getString("wx_serialno");
          p4.p().e().c.c(paramJSONObject);
          return;
        }
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public String i()
  {
    return this.e0;
  }
  
  public String j()
  {
    return this.Q;
  }
  
  public String k()
  {
    return this.P;
  }
  
  public String l()
  {
    return this.L;
  }
  
  public String m()
  {
    return this.K;
  }
  
  public String n()
  {
    return this.J;
  }
  
  public String o()
  {
    return this.S;
  }
  
  public int p()
  {
    return this.R;
  }
  
  public String q()
  {
    return this.I;
  }
  
  public String r()
  {
    return this.O;
  }
  
  public String s()
  {
    return this.N;
  }
  
  public String t()
  {
    return this.U;
  }
  
  public int u()
  {
    return this.V;
  }
  
  public String v()
  {
    return this.j;
  }
  
  public String w()
  {
    return this.W;
  }
  
  public String x()
  {
    return this.o;
  }
  
  public String y()
  {
    return this.T;
  }
  
  public String z()
  {
    return this.C;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.w3
 * JD-Core Version:    0.7.0.1
 */