package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class j2
  extends ob
{
  public String g = "";
  public String h = "";
  public String i = "";
  public o4 j = p4.p().e();
  public c5 k = this.j.e;
  
  public j2(fc paramfc)
  {
    super(paramfc);
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("hf_info"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("hf_info");
        if (paramJSONObject.has("hfpay_channelInfo"))
        {
          this.i = paramJSONObject.getString("hfpay_channelInfo");
          paramJSONObject = b();
          if (TextUtils.isEmpty(paramJSONObject)) {
            APLog.e("GetExpress", "Cannot get decode key!");
          }
          this.i = n4.a(this.i, paramJSONObject);
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("OperatorBase = ");
        paramJSONObject.append(this.i);
        APLog.i("APGetExpressPayAns", paramJSONObject.toString());
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public final void b(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("mb_info"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("mb_info");
        this.h = "";
        if (paramJSONObject.has("sms_info"))
        {
          this.h = paramJSONObject.getString("sms_info");
          if ((this.h != null) && (!this.h.equals(""))) {
            com.pay.paychannel.qdqb.APQDQBChannel.r = this.h;
          }
        }
        if (paramJSONObject.has("remain")) {
          paramJSONObject.getInt("remain");
        }
        if (paramJSONObject.has("mb_only_sms")) {
          paramJSONObject.getString("mb_only_sms");
        }
        if (paramJSONObject.has("mburl")) {
          paramJSONObject.getString("mburl");
        }
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public final void c(JSONObject paramJSONObject)
  {
    String str = b();
    if (TextUtils.isEmpty(str)) {
      APLog.e("GetExpress", "Cannot get decode key!");
    }
    r6.j().a(paramJSONObject, str);
  }
  
  public void d(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("out_trade_no"))
      {
        p4.p().e().a(paramJSONObject.getString("out_trade_no"));
        return;
      }
      p4.p().e().a("");
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public boolean d(gb paramgb)
  {
    Object localObject1 = new String(paramgb.b);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("resultData=");
    ((StringBuilder)localObject2).append((String)localObject1);
    APLog.i("APGetExpressPayAns", ((StringBuilder)localObject2).toString());
    try
    {
      localJSONObject = new JSONObject((String)localObject1);
      this.a = Integer.parseInt(localJSONObject.getString("ret").toString());
      int m = this.a;
      localObject1 = "";
      if (m == 0)
      {
        this.g = localJSONObject.getString("express_channel");
        this.j.f.i = this.g;
        this.j.f.j = this.g;
        if (localJSONObject.has("need_change_key")) {
          if (localJSONObject.getInt("need_change_key") == 1) {
            APAppDataInterface.singleton().a(true);
          } else {
            APAppDataInterface.singleton().a(false);
          }
        }
        localObject2 = b();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          APLog.e("GetExpress", "Cannot get decode key!");
        }
        m = n4.a(localJSONObject, "qq_acct_balance", (String)localObject2);
        this.k.g = m;
        if ((localJSONObject.has("is_use_newmpaymode")) && (localJSONObject.getInt("is_use_newmpaymode") == 1)) {
          c6.s0().t(true);
        } else {
          c6.s0().t(false);
        }
        m = n4.a(localJSONObject, "mcard_balance", (String)localObject2);
        this.k.h = m;
        c(localJSONObject);
        b(localJSONObject);
        a(localJSONObject);
        g(localJSONObject);
        boolean bool = localJSONObject.has("wx_bind_qquin");
        if (!bool) {}
      }
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject;
      label310:
      localJSONException.printStackTrace();
    }
    try
    {
      localObject2 = localJSONObject.getString("wx_bind_qquin");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      break label310;
    }
    p4.p().e().e.k = ((String)localObject1);
    f(localJSONObject);
    d(localJSONObject);
    break label424;
    this.b = localJSONObject.getString("msg");
    localObject1 = localJSONObject.getString("err_code").toString();
    if (!((String)localObject1).equals(""))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("系统繁忙,请稍后再试 (");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(")");
      this.b = ((StringBuilder)localObject2).toString();
    }
    label424:
    return super.d(paramgb);
  }
  
  public void e(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("unicoupon_mpinfo"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("unicoupon_mpinfo");
        o.m().a(paramJSONObject);
        return;
      }
      APLog.i("resolveCouponMpInfo", "MpInfo has not unicoupon_mpinfo");
      o.m().b();
      return;
    }
    catch (Exception paramJSONObject)
    {
      APLog.i("resolveCouponMpInfo", paramJSONObject.toString());
      o.m().b();
    }
  }
  
  public final void f(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("mp_info")) {}
    try
    {
      e(paramJSONObject.getJSONObject("mp_info"));
      return;
    }
    catch (Exception paramJSONObject) {}
    APLog.i("mpInfo", "has not mp_info");
    return;
  }
  
  public String g()
  {
    return this.i;
  }
  
  public final void g(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("wx_info"))
      {
        m = -1;
        paramJSONObject = paramJSONObject.getJSONObject("wx_info");
        try
        {
          n = paramJSONObject.getInt("wx_contract_signstate");
          m = n;
        }
        catch (Exception localException)
        {
          APLog.w("wx_contract_signstate", localException.toString());
        }
        n = 0;
      }
    }
    catch (Exception paramJSONObject)
    {
      int m;
      int n;
      int i1;
      label60:
      return;
    }
    try
    {
      i1 = paramJSONObject.getInt("wx_contract_buylimit");
      n = i1;
    }
    catch (Exception paramJSONObject)
    {
      break label60;
    }
    i1 = this.j.b.saveType;
    if (i1 == 0)
    {
      paramJSONObject = (x4)this.j.c;
      paramJSONObject.b(m);
      paramJSONObject.a(n);
      return;
    }
    if (i1 == 1)
    {
      paramJSONObject = (y4)this.j.c;
      paramJSONObject.b(m);
      paramJSONObject.a(n);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.j2
 * JD-Core Version:    0.7.0.1
 */