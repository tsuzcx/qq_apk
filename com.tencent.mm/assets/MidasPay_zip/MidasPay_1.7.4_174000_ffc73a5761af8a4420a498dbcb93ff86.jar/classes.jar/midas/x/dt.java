package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class dt
  extends lh
{
  private String A = "";
  private String B = "";
  private String C = "";
  private String D = "";
  private String E = "";
  private String F = "";
  private String G = "";
  private String H = "";
  private String I = "";
  private String J = "";
  private String K = "";
  private String L = "";
  private String M = "";
  private String N = "1";
  private String O = "";
  private String P = "";
  private String Q = "";
  private int R = 0;
  private String S = "";
  private String T = "";
  private String U = "";
  private String V = "";
  private String W = "";
  private String X = "";
  private String Y = "";
  private int Z = 0;
  ez a = em.b().n().d;
  private String aa = "";
  private String ab = "";
  private String ac = "";
  private String ad = "";
  private String ae = "账户异常，无法充值";
  private int af = -1;
  private String ag = "";
  private String ah = "";
  private String ai = "";
  private String aj;
  private String ak;
  public in b = new in();
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private int g = -1;
  private String h = "";
  private String i = "";
  private String n = "";
  private String o = "";
  private String p = "";
  private String q = "";
  private String r = "";
  private String s = "";
  private String t = "";
  private String u = "";
  private String v = "";
  private String w = "";
  private String x = "";
  private String y = "";
  private String z = "";
  
  public dt(lw paramlw)
  {
    super(paramlw);
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has("sp_info")) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("sp_info");
        if (paramJSONObject != null)
        {
          if (paramJSONObject.has("channel_orderid"))
          {
            this.ac = paramJSONObject.getString("channel_orderid");
            this.ac = a(this.ac);
            fy.a().r(this.ac);
          }
          if (paramJSONObject.has("drm_goldcoupons_acct"))
          {
            this.ab = paramJSONObject.getString("drm_goldcoupons_acct");
            this.ab = a(this.ab);
            o.a().b(this.ab);
          }
          if (paramJSONObject.has("out_trade_no"))
          {
            this.ad = paramJSONObject.getString("out_trade_no");
            em.b().n().a(this.ad);
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
  
  private boolean a(br parambr, JSONObject paramJSONObject)
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
      parambr.a.b = paramJSONObject.optString("cloud_offer_id");
      parambr.a.d = paramJSONObject.optString("cloud_client_id");
      parambr.a.c = paramJSONObject.optString("cloud_openid");
      this.aj = paramJSONObject.optString("pay_method");
      this.ak = paramJSONObject.optString("cloud_others");
      return true;
    }
    catch (Exception parambr)
    {
      parambr.printStackTrace();
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("get decKey error222:");
      paramJSONObject.append(parambr.toString());
      APLog.w("APSaveAns", paramJSONObject.toString());
      APLog.w("APSaveAns", "cloudInfo()  return False");
    }
    return false;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    try
    {
      localObject1 = paramJSONObject.optJSONObject("info");
      if (localObject1 == null) {
        return false;
      }
      this.j = paramJSONObject.optInt("ret");
      this.k = paramJSONObject.optString("msg");
      this.d = ((JSONObject)localObject1).optString("count");
      this.e = ((JSONObject)localObject1).optString("mburl");
      Object localObject2 = X();
      this.i = a(((JSONObject)localObject1).optString("cfturl"));
      if (APAppDataInterface.singleton().e().equals("dev"))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cfturl=");
        localStringBuilder.append(this.i);
        APLog.i("APSaveAns", localStringBuilder.toString());
      }
      if (((JSONObject)localObject1).has("success_url"))
      {
        this.c = ((JSONObject)localObject1).optString("success_url");
        if ((!TextUtils.isEmpty(this.c)) && (!this.c.equals("null"))) {
          fy.a().c(this.c);
        }
      }
      try
      {
        this.n = ((JSONObject)localObject1).optString("mcardserialno");
        this.o = this.n;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      try
      {
        this.p = ((JSONObject)localObject1).optString("verifycode");
        this.q = ((JSONObject)localObject1).optString("verifysession");
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      try
      {
        String str1 = ((JSONObject)localObject1).optString("present_count");
        gd.a().a("");
        if ((!TextUtils.isEmpty(str1)) && (!str1.equals("null"))) {
          gd.a().a(str1);
        }
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
      }
      if (((JSONObject)localObject1).has("sms_info")) {
        this.f = ((JSONObject)localObject1).optString("sms_info");
      }
      if ((this.f != null) && (!this.f.equals(""))) {
        com.pay.paychannel.qdqb.APQDQBChannel.m = this.f;
      }
      if (((JSONObject)localObject1).has("remain")) {
        this.g = ((JSONObject)localObject1).getInt("remain");
      } else {
        this.g = -1;
      }
      if (((JSONObject)localObject1).has("mb_only_sms")) {
        this.h = ((JSONObject)localObject1).optString("mb_only_sms");
      } else {
        this.h = "";
      }
      try
      {
        if (((JSONObject)localObject1).has("drm_resource"))
        {
          String str2 = ((JSONObject)localObject1).optString("drm_resource");
          if (!TextUtils.isEmpty(str2)) {
            gf.b().c(str2);
          }
        }
      }
      catch (Exception localException4)
      {
        APLog.e("saveAns", localException4.toString());
      }
      try
      {
        if (((JSONObject)localObject1).has("portal_serial_no"))
        {
          String str3 = ((JSONObject)localObject1).optString("portal_serial_no");
          em.b().n().e.p = str3;
          fy.a().u(str3);
        }
        else
        {
          fy.a().u("");
        }
      }
      catch (Exception localException5)
      {
        localException5.printStackTrace();
      }
      try
      {
        if (((JSONObject)localObject1).has("PortalExtendField"))
        {
          String str4 = ((JSONObject)localObject1).optString("PortalExtendField");
          fy.a().v(str4);
        }
        else
        {
          fy.a().v("");
        }
      }
      catch (Exception localException6)
      {
        localException6.printStackTrace();
      }
      try
      {
        if (((JSONObject)localObject1).has("comm_config"))
        {
          Object localObject3 = ((JSONObject)localObject1).getJSONObject("comm_config");
          if (((JSONObject)localObject3).has("is_kj"))
          {
            localObject3 = ((JSONObject)localObject3).optString("is_kj");
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              if (((String)localObject3).equals("1")) {
                this.a.c = true;
              } else {
                this.a.c = false;
              }
            }
          }
        }
        if (((JSONObject)localObject1).has("mbkey")) {
          com.pay.paychannel.qdqb.APQDQBChannel.k = ((JSONObject)localObject1).optString("mbkey");
        }
      }
      catch (Exception localException7)
      {
        APLog.e("info", localException7.toString());
      }
      if (paramJSONObject.has("need_change_key")) {
        if (paramJSONObject.getInt("need_change_key") == 1) {
          APAppDataInterface.singleton().a(true);
        } else {
          APAppDataInterface.singleton().a(false);
        }
      }
      em.b().n().e.h = this.d;
      c(paramJSONObject);
      d(paramJSONObject);
      a(paramJSONObject, (String)localObject2);
      e(paramJSONObject);
      g(paramJSONObject);
      b(paramJSONObject);
      if (this.j != 0)
      {
        this.r = ((JSONObject)localObject1).optString("qkbalance");
        this.ai = paramJSONObject.optString("err_code");
        f((JSONObject)localObject1);
        this.k = paramJSONObject.optString("msg");
        if ((this.j != 100008) && (this.j != 100009))
        {
          this.l = this.k;
          paramJSONObject = paramJSONObject.optString("err_code").toString();
          if (!paramJSONObject.equals(""))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("系统繁忙,请稍后再试 (");
            ((StringBuilder)localObject2).append(paramJSONObject);
            ((StringBuilder)localObject2).append(")");
            this.k = ((StringBuilder)localObject2).toString();
          }
        }
        if (this.j == 1004)
        {
          fy.a().f(false);
          if ((((JSONObject)localObject1).has("is_allow_change")) && (((JSONObject)localObject1).optString("is_allow_change").equals("1"))) {
            fy.a().f(true);
          }
        }
      }
      if (("mcard".equals(em.b().n().e.f)) && (((JSONObject)localObject1).has("mcard_balance")) && (!TextUtils.isEmpty(((JSONObject)localObject1).optString("mcard_balance"))))
      {
        paramJSONObject = a(((JSONObject)localObject1).optString("mcard_balance"));
        this.a.h = i.a(paramJSONObject);
      }
      if (((JSONObject)localObject1).has("user_msg"))
      {
        paramJSONObject = a(((JSONObject)localObject1).optString("user_msg"));
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          int j = this.j;
          if (j == 1004)
          {
            try
            {
              paramJSONObject = new JSONObject(paramJSONObject);
              if (paramJSONObject.has("qqacct_balance"))
              {
                localObject1 = paramJSONObject.optString("qqacct_balance");
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("balance:");
                ((StringBuilder)localObject2).append((String)localObject1);
                APLog.e("APSaveAns", ((StringBuilder)localObject2).toString());
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  em.b().n().d.g = i.a((String)localObject1);
                }
              }
              if (!paramJSONObject.has("uin")) {
                break label1322;
              }
              paramJSONObject = paramJSONObject.optString("uin");
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("uin:");
              ((StringBuilder)localObject1).append(paramJSONObject);
              APLog.e("APSaveAns", ((StringBuilder)localObject1).toString());
              if (TextUtils.isEmpty(paramJSONObject)) {
                break label1322;
              }
              em.b().n().d.n = paramJSONObject;
              return true;
            }
            catch (Exception paramJSONObject)
            {
              paramJSONObject.printStackTrace();
              return true;
            }
          }
          else
          {
            j = this.j;
            if (j != 0) {}
          }
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      label1271:
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("系统繁忙,请稍后再试 ");
      ((StringBuilder)localObject1).append(bw.a(20003));
      this.k = ((StringBuilder)localObject1).toString();
      paramJSONObject.printStackTrace();
    }
    try
    {
      paramJSONObject = new JSONObject(paramJSONObject);
      if (!paramJSONObject.has("receipt_transid")) {
        break label1322;
      }
      paramJSONObject = paramJSONObject.optString("receipt_transid");
      fy.a().D(paramJSONObject);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      break label1271;
    }
    APLog.i("from usrmsg", "get transid");
    return true;
    label1322:
    return true;
  }
  
  private void b(JSONObject paramJSONObject)
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
      this.b.b = paramJSONObject;
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
      paramJSONObject = APTools.a(paramJSONObject, 1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fkinfo3 urlencode == ");
      localStringBuilder.append(paramJSONObject);
      APLog.d("APSaveAns", localStringBuilder.toString());
      this.b.a = paramJSONObject;
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
      this.b.c = paramJSONObject;
    } else {
      APLog.e("APSaveAns", "decode vrfurl2 empty!");
    }
    paramJSONObject = S();
    if (paramJSONObject != null)
    {
      if ((paramJSONObject instanceof du))
      {
        paramJSONObject = (du)paramJSONObject;
        this.b.d = paramJSONObject.e("pay_method");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fk pay method == ");
        ((StringBuilder)localObject).append(this.b.d);
        APLog.d("APSaveAns", ((StringBuilder)localObject).toString());
        this.b.f = paramJSONObject.e("extend");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fk extend == ");
        ((StringBuilder)localObject).append(this.b.f);
        APLog.d("APSaveAns", ((StringBuilder)localObject).toString());
        this.b.g = paramJSONObject.b("service_code");
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("fk service_code == ");
        paramJSONObject.append(this.b.g);
        APLog.d("APSaveAns", paramJSONObject.toString());
        return;
      }
      APLog.e("APSaveAns", "request not save request for pay method!");
      return;
    }
    APLog.e("APSaveAns", "Cannot get request for pay method!");
  }
  
  private void c(JSONObject paramJSONObject)
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
            int j = em.b().n().a.saveType;
            if ((j != 0) && (1 != j))
            {
              if (!TextUtils.isEmpty(paramJSONObject.getString("wx_sign_url"))) {
                fy.a().y(paramJSONObject.getString("wx_sign_url"));
              } else {
                fy.a().y("");
              }
            }
            else if (!TextUtils.isEmpty(paramJSONObject.getString("wx_sign_url"))) {
              fy.a().y(APTools.b(paramJSONObject.getString("wx_sign_url"), 1));
            } else {
              fy.a().y("");
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
              fy.a().z(paramJSONObject.getString("wx_pre_entrustweb_id"));
            } else {
              fy.a().z("");
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
          em.b().n().b.c(paramJSONObject);
          return;
        }
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void d(JSONObject paramJSONObject)
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
              fy.a().I(paramJSONObject.getString("qq_sign_url"));
              return;
            }
            fy.a().I("");
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
  
  private void e(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("hf_info");
      this.I = paramJSONObject.optString("vtype");
      this.J = paramJSONObject.optString("province");
      this.M = paramJSONObject.optString("billno");
      em.b().n().e.n = this.M;
      this.S = paramJSONObject.optString("channel");
      fy.a().L(this.S);
      this.O = paramJSONObject.optString("price");
      this.P = paramJSONObject.optString("tips");
      fy.a().M(paramJSONObject.optString("hf_extend"));
      this.R = i.a(paramJSONObject.optString("hf_interfacetype"));
      if ((em.b().n().a.saveType == 4) || (em.b().n().a.saveType == 5))
      {
        fy.a().a(paramJSONObject.optString("real_servicecode"));
        this.Q = paramJSONObject.optString("fee_type");
        try
        {
          this.Y = URLDecoder.decode(paramJSONObject.getString("hfpay_pay_tips"), "UTF-8");
          this.Y = this.Y.replace("\\n", "\n");
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      if (this.R == 1) {
        return;
      }
      if (this.R == 2)
      {
        String str = paramJSONObject.optString("hfpay_url");
        fy.a().H(str);
        paramJSONObject.optString("outOrderId");
        this.Z = paramJSONObject.optInt("solutionType");
        return;
      }
      if (this.R == 4)
      {
        this.X = paramJSONObject.optString("hfpay_channelInfo");
        if (TextUtils.isEmpty(X())) {
          APLog.e("Save", "Cannot get decode key!");
        }
        this.X = a(this.X);
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
  
  private void f(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("userInfo")) {
      return;
    }
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("user_info").getString("uin_type");
      this.a.l = paramJSONObject;
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void g(JSONObject paramJSONObject)
    throws JSONException
  {
    fy.a().E("");
    if (paramJSONObject.has("rc_info"))
    {
      if (this.j != 1138) {
        return;
      }
      try
      {
        Object localObject = paramJSONObject.getJSONObject("rc_info");
        this.af = ((JSONObject)localObject).optInt("rc_type", -1);
        this.ah = ((JSONObject)localObject).optString("rc_amt", "");
        this.ag = ((JSONObject)localObject).optString("rc_policyid", "");
        localObject = fy.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("rc_type=");
        localStringBuilder.append(this.af);
        localStringBuilder.append("&rc_amt=");
        localStringBuilder.append(this.ah);
        localStringBuilder.append("&rc_policyid=");
        localStringBuilder.append(this.ag);
        ((fy)localObject).E(localStringBuilder.toString());
        this.ae = paramJSONObject.optString("msg", "账户异常，无法充值");
        if (TextUtils.isEmpty(this.ae))
        {
          this.ae = "账户异常，无法充值";
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      return;
    }
  }
  
  public String A()
  {
    return this.J;
  }
  
  public String B()
  {
    return this.K;
  }
  
  public String C()
  {
    return this.L;
  }
  
  public String D()
  {
    return this.N;
  }
  
  public String E()
  {
    return this.O;
  }
  
  public String F()
  {
    return this.P;
  }
  
  public String G()
  {
    return this.Q;
  }
  
  public int H()
  {
    return this.g;
  }
  
  public String I()
  {
    return this.h;
  }
  
  public String J()
  {
    return this.S;
  }
  
  public String K()
  {
    return this.aa;
  }
  
  public String L()
  {
    return this.Y;
  }
  
  public String M()
  {
    return this.X;
  }
  
  public String N()
  {
    return this.ae;
  }
  
  public int O()
  {
    return this.af;
  }
  
  public String P()
  {
    return this.ai;
  }
  
  public int Q()
  {
    return this.R;
  }
  
  public int R()
  {
    return this.Z;
  }
  
  public String a()
  {
    return this.aj;
  }
  
  protected String a(String paramString)
  {
    return ek.a(paramString, X());
  }
  
  public boolean a(br parambr)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambr.c);
      if (!a(parambr, localJSONObject)) {
        return false;
      }
      a(localJSONObject);
      return true;
    }
    catch (Exception parambr)
    {
      parambr.printStackTrace();
    }
    return false;
  }
  
  protected boolean a(kz paramkz)
  {
    fy.a().b(0);
    String str = new String(paramkz.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultData=");
    localStringBuilder.append(str);
    APLog.i("APSaveAns", localStringBuilder.toString());
    try
    {
      a(new JSONObject(str));
      this.aa = ((du)paramkz.a()).c;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return super.a(paramkz);
  }
  
  public String b()
  {
    return this.ak;
  }
  
  protected boolean b(kz paramkz)
  {
    fy.a().b(0);
    return super.b(paramkz);
  }
  
  public String c()
  {
    return this.e;
  }
  
  protected boolean c(kz paramkz)
  {
    fy.a().b(0);
    return super.c(paramkz);
  }
  
  public String d()
  {
    return this.f;
  }
  
  public String e()
  {
    return this.i;
  }
  
  public String f()
  {
    return this.n;
  }
  
  public String g()
  {
    return this.p;
  }
  
  public String h()
  {
    return this.q;
  }
  
  public String i()
  {
    return this.s;
  }
  
  public String j()
  {
    return this.t;
  }
  
  public String k()
  {
    return this.u;
  }
  
  public String l()
  {
    return this.v;
  }
  
  public String m()
  {
    return this.w;
  }
  
  public String n()
  {
    return this.x;
  }
  
  public String o()
  {
    return this.z;
  }
  
  public String p()
  {
    return this.B;
  }
  
  public String q()
  {
    return this.A;
  }
  
  public String r()
  {
    return this.y;
  }
  
  public String s()
  {
    return this.C;
  }
  
  public String t()
  {
    return this.D;
  }
  
  public String u()
  {
    return this.E;
  }
  
  public String v()
  {
    return this.F;
  }
  
  public String w()
  {
    return this.G;
  }
  
  public String x()
  {
    return this.H;
  }
  
  public String y()
  {
    return this.r;
  }
  
  public String z()
  {
    return this.I;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.dt
 * JD-Core Version:    0.7.0.1
 */