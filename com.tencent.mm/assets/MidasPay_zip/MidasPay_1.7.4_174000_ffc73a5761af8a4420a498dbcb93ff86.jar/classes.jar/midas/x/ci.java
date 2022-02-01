package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ci
  extends lh
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private int e = -1;
  private String f = "";
  private String g = "";
  private el h = em.b().n();
  private ez i = this.h.d;
  
  public ci(lw paramlw)
  {
    super(paramlw);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("wx_info"))
      {
        j = -1;
        paramJSONObject = paramJSONObject.getJSONObject("wx_info");
        try
        {
          k = paramJSONObject.getInt("wx_contract_signstate");
          j = k;
        }
        catch (Exception localException)
        {
          APLog.w("wx_contract_signstate", localException.toString());
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      int j;
      int k;
      label52:
      int m;
      return;
    }
    try
    {
      k = paramJSONObject.getInt("wx_contract_buylimit");
    }
    catch (Exception paramJSONObject)
    {
      break label52;
    }
    k = 0;
    m = this.h.a.saveType;
    if (m == 0)
    {
      paramJSONObject = (eu)this.h.b;
      paramJSONObject.a(j);
      paramJSONObject.b(k);
      return;
    }
    if (m == 1)
    {
      paramJSONObject = (ev)this.h.b;
      paramJSONObject.a(j);
      paramJSONObject.b(k);
    }
  }
  
  private void d(JSONObject paramJSONObject)
  {
    String str = X();
    if (TextUtils.isEmpty(str)) {
      APLog.e("GetExpress", "Cannot get decode key!");
    }
    gn.a().a(paramJSONObject, str);
  }
  
  private void e(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("mb_info"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("mb_info");
        this.d = "";
        if (paramJSONObject.has("sms_info"))
        {
          this.d = paramJSONObject.getString("sms_info");
          if ((this.d != null) && (!this.d.equals(""))) {
            com.pay.paychannel.qdqb.APQDQBChannel.m = this.d;
          }
        }
        this.e = -1;
        if (paramJSONObject.has("remain")) {
          this.e = paramJSONObject.getInt("remain");
        }
        this.f = "";
        if (paramJSONObject.has("mb_only_sms")) {
          this.f = paramJSONObject.getString("mb_only_sms");
        }
        this.c = "";
        if (paramJSONObject.has("mburl")) {
          this.c = paramJSONObject.getString("mburl");
        }
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  private void f(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("hf_info"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("hf_info");
        if (paramJSONObject.has("hfpay_channelInfo"))
        {
          this.g = paramJSONObject.getString("hfpay_channelInfo");
          paramJSONObject = X();
          if (TextUtils.isEmpty(paramJSONObject)) {
            APLog.e("GetExpress", "Cannot get decode key!");
          }
          this.g = ek.a(this.g, paramJSONObject);
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("OperatorBase = ");
        paramJSONObject.append(this.g);
        APLog.i("APGetExpressPayAns", paramJSONObject.toString());
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void g(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("mp_info")) {}
    try
    {
      a(paramJSONObject.getJSONObject("mp_info"));
      return;
    }
    catch (Exception paramJSONObject) {}
    APLog.i("mpInfo", "has not mp_info");
    return;
  }
  
  public String a()
  {
    return this.g;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("unicoupon_mpinfo"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("unicoupon_mpinfo");
        n.a().a(paramJSONObject);
        return;
      }
      APLog.i("resolveCouponMpInfo", "MpInfo has not unicoupon_mpinfo");
      n.a().j();
      return;
    }
    catch (Exception paramJSONObject)
    {
      APLog.i("resolveCouponMpInfo", paramJSONObject.toString());
      n.a().j();
    }
  }
  
  protected boolean a(kz paramkz)
  {
    Object localObject1 = new String(paramkz.b);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("resultData=");
    ((StringBuilder)localObject2).append((String)localObject1);
    APLog.i("APGetExpressPayAns", ((StringBuilder)localObject2).toString());
    try
    {
      localJSONObject = new JSONObject((String)localObject1);
      this.j = Integer.parseInt(localJSONObject.getString("ret").toString());
      if (this.j == 0)
      {
        this.a = localJSONObject.getString("express_channel");
        this.h.e.j = this.a;
        this.h.e.k = this.a;
        if (localJSONObject.has("need_change_key")) {
          if (localJSONObject.getInt("need_change_key") == 1) {
            APAppDataInterface.singleton().a(true);
          } else {
            APAppDataInterface.singleton().a(false);
          }
        }
        localObject1 = X();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          APLog.e("GetExpress", "Cannot get decode key!");
        }
        int j = ek.c(localJSONObject, "qq_acct_balance", (String)localObject1);
        this.i.g = j;
        if ((localJSONObject.has("is_use_newmpaymode")) && (localJSONObject.getInt("is_use_newmpaymode") == 1)) {
          fy.a().i(true);
        } else {
          fy.a().i(false);
        }
        j = ek.c(localJSONObject, "mcard_balance", (String)localObject1);
        this.i.h = j;
        d(localJSONObject);
        e(localJSONObject);
        f(localJSONObject);
        c(localJSONObject);
        if (localJSONObject.has("wx_bind_qquin")) {
          localObject1 = "";
        }
      }
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject;
      label303:
      localJSONException.printStackTrace();
    }
    try
    {
      localObject2 = localJSONObject.getString("wx_bind_qquin");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      break label303;
    }
    em.b().n().d.m = ((String)localObject1);
    g(localJSONObject);
    b(localJSONObject);
    break label415;
    this.k = localJSONObject.getString("msg");
    localObject1 = localJSONObject.getString("err_code").toString();
    if (!((String)localObject1).equals(""))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("系统繁忙,请稍后再试 (");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(")");
      this.k = ((StringBuilder)localObject2).toString();
    }
    label415:
    return super.a(paramkz);
  }
  
  protected void b(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("out_trade_no"))
      {
        em.b().n().a(paramJSONObject.getString("out_trade_no"));
        return;
      }
      em.b().n().a("");
      return;
    }
    catch (Exception paramJSONObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ci
 * JD-Core Version:    0.7.0.1
 */