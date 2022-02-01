package midas.x;

import android.os.Environment;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bw
  extends jw
{
  static final String[] h = { "Td8qRx7IdbbSyw3K", "elddjmxNE2FK8cch", "n6QnJOTocDGX5dXR", "caUdsBbJ1oOxMbPy", "ehDFwSSDOFz3U1d3", "nmiFzdsTgUYGcMeg", "t3W6mdGCbIfFcwdR", "PLSeUfBBSgfDWAuA", "ayGzfJkNBZKE9UZf", "yVBtdRgAEx3EgG31" };
  public boolean a = false;
  protected String b = "";
  protected String c = "";
  protected int d = -1;
  protected String e = "";
  protected String f = "";
  ec g = null;
  
  bw(kl paramkl)
  {
    super(paramkl);
  }
  
  public String a()
  {
    return this.b;
  }
  
  protected void a(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("comm_config");
    if ((localJSONObject.has("show_feedback")) && ("1".equals(localJSONObject.getString("show_feedback")))) {
      fp.a().h(true);
    }
    if ((localJSONObject.has("change_h5")) && ("1".equals(localJSONObject.getString("change_h5")))) {
      this.a = true;
    }
    if ((localJSONObject.has("show_tranrecord")) && ("1".equals(localJSONObject.getString("show_tranrecord")))) {
      fp.a().g(true);
    }
    if (localJSONObject.has("wx_appid"))
    {
      paramJSONObject = localJSONObject.getString("wx_appid");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        fp.a().p(paramJSONObject);
      }
    }
    if (localJSONObject.has("show_continuebuy"))
    {
      paramJSONObject = localJSONObject.getString("show_continuebuy");
      if ((!TextUtils.isEmpty(paramJSONObject)) && (paramJSONObject.equals("0"))) {
        fp.a().j(false);
      }
    }
    if (localJSONObject.has("ip_strategy"))
    {
      localObject1 = localJSONObject.getString("ip_strategy");
      paramJSONObject = (JSONObject)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramJSONObject = "3";
      }
      bt.b(paramJSONObject);
    }
    if (localJSONObject.has("ip_mode"))
    {
      localObject1 = localJSONObject.getString("ip_mode");
      paramJSONObject = (JSONObject)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramJSONObject = "0";
      }
      bt.c(paramJSONObject);
    }
    if (localJSONObject.has("show_resultpage"))
    {
      paramJSONObject = localJSONObject.getString("show_resultpage");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        fp.a().t(paramJSONObject);
      } else {
        fp.a().t("1");
      }
    }
    int i;
    if (localJSONObject.has("resultpage_timeout"))
    {
      i = i.a(localJSONObject.getString("resultpage_timeout"));
      if (i != 0) {
        fp.a().d(i);
      }
    }
    fp.a().l(true);
    if ((localJSONObject.has("show_ensurepage")) && ("0".equals(localJSONObject.getString("show_ensurepage")))) {
      fp.a().l(false);
    }
    if (localJSONObject.has("t4")) {
      try
      {
        i = localJSONObject.getInt("t4");
        if (i != 0) {
          APAppDataInterface.singleton().d(i);
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    if (localJSONObject.has("t3")) {
      try
      {
        i = localJSONObject.getInt("t3");
        if (i != 0) {
          APAppDataInterface.singleton().e(i);
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    if (localJSONObject.has("t2")) {
      try
      {
        i = localJSONObject.getInt("t2");
        if (i != 0) {
          APAppDataInterface.singleton().f(i);
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    paramJSONObject = localJSONObject.optString("log_write", "-1");
    Object localObject1 = localJSONObject.optString("log_keep_size", "1");
    String str = localJSONObject.optString("log_keep_time", "10");
    try
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("catch log keep config: ");
      ((StringBuilder)localObject2).append(paramJSONObject);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(str);
      APLog.d("BaseBuyPageAns", ((StringBuilder)localObject2).toString());
      if (!paramJSONObject.equals("-1")) {
        APLog.getLogInfo().setLogParamFromServer(paramJSONObject);
      }
      i = i.a((String)localObject1);
      int j = i.a(str);
      paramJSONObject = new fq();
      paramJSONObject.a(a.a().d, "TencentUnipay", "log_keep_size", String.valueOf(i));
      paramJSONObject.a(a.a().d, "TencentUnipay", "log_keep_time", String.valueOf(j));
    }
    catch (Throwable paramJSONObject)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("configure log error: ");
      ((StringBuilder)localObject1).append(paramJSONObject.getMessage());
      APLog.e("common_config", ((StringBuilder)localObject1).toString());
    }
    str = localJSONObject.optString("log_date", "");
    Object localObject2 = localJSONObject.optString("log_upload", "0");
    localObject1 = localJSONObject.optString("log_file", "");
    iy.a = i.a(localJSONObject.optString("log_upload_max", "3"));
    paramJSONObject = (JSONObject)localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append(Environment.getExternalStorageDirectory().getPath());
      paramJSONObject.append("/");
      paramJSONObject.append((String)localObject1);
      paramJSONObject = paramJSONObject.toString();
    }
    try
    {
      if ("1".equals(localObject2))
      {
        APLog.d("BaseBuyPageAns", String.format("catch upload log command, ready to upload: %s %s", new Object[] { str, paramJSONObject }));
        iy.a(ed.b().n().a.openId, str, paramJSONObject);
      }
    }
    catch (Throwable paramJSONObject)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("upload log execute failed: ");
      ((StringBuilder)localObject1).append(paramJSONObject.getMessage());
      APLog.e("common_config", ((StringBuilder)localObject1).toString());
    }
    if (localJSONObject.has("need_hf_prequery")) {
      try
      {
        if ("0".equals(localJSONObject.getString("need_hf_prequery"))) {
          fp.a().r(false);
        } else {
          fp.a().r(true);
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    if (localJSONObject.has("hf_prequery_timeout")) {
      try
      {
        long l = Long.valueOf(localJSONObject.getString("hf_prequery_timeout")).longValue();
        fp.a().a(l);
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    APLog.i("comm_config", "game_max_buy_number before");
    if (localJSONObject.has("game_max_buy_number")) {}
    try
    {
      APLog.i("comm_config", "game_max_buy_number has");
      i = i.a(localJSONObject.getString("game_max_buy_number"));
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("iMax:");
      paramJSONObject.append(i);
      APLog.i("comm_config", paramJSONObject.toString());
      fp.a().c(i);
    }
    catch (Exception paramJSONObject)
    {
      label1058:
      break label1058;
    }
    fp.a().c(0);
    break label1075;
    fp.a().c(0);
    label1075:
    fp.a().F(localJSONObject.optString("mqq_appid", ""));
    fp.a().G(localJSONObject.optString("mqq_ltype", "1"));
    if (localJSONObject.has("enable_X5")) {
      hs.a(a.a().d, localJSONObject.getString("enable_X5"));
    }
  }
  
  public String b()
  {
    return this.c;
  }
  
  protected void b(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("real_session_id");
    String str = paramJSONObject.optString("real_session_type");
    fp localfp = fp.a();
    paramJSONObject = (JSONObject)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject = "";
    }
    localfp.J(paramJSONObject);
    localObject = fp.a();
    paramJSONObject = str;
    if (TextUtils.isEmpty(str)) {
      paramJSONObject = "";
    }
    ((fp)localObject).K(paramJSONObject);
  }
  
  public int c()
  {
    return this.d;
  }
  
  protected void c(JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.getJSONObject("service_update");
    if (paramJSONObject.has("update_months"))
    {
      String str = paramJSONObject.getString("update_months");
      fs.a().b(str);
    }
    if (paramJSONObject.has("update_price"))
    {
      paramJSONObject = paramJSONObject.getString("update_price");
      fs.a().a(paramJSONObject);
    }
  }
  
  public String d()
  {
    return this.e;
  }
  
  protected void d(JSONObject paramJSONObject)
  {
    try
    {
      if (!TextUtils.isEmpty(paramJSONObject.getString("result_url")))
      {
        fp.a().i(paramJSONObject.getString("result_url"));
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  protected void e(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("wx_bind_qquin");
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      paramJSONObject = "";
    }
    ed.b().n().d.m = paramJSONObject;
  }
  
  protected boolean f(JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.getJSONObject("mp");
    int i = paramJSONObject.getInt("firstsave_present_count");
    String str = paramJSONObject.getString("present_level");
    if ((i <= 0) && (TextUtils.isEmpty(str))) {
      return false;
    }
    ac.a().b(paramJSONObject);
    return true;
  }
  
  protected void g(JSONObject paramJSONObject)
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
  
  protected void h(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("out_trade_no"))
      {
        ed.b().n().a(paramJSONObject.getString("out_trade_no"));
        return;
      }
      ed.b().n().a("");
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  protected void i(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.getInt("is_zy") == 1) {
        APAppDataInterface.singleton().b(true);
      } else {
        APAppDataInterface.singleton().b(false);
      }
      APAppDataInterface.singleton().b(true);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  protected void j(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.getString("session_token");
      this.g.e.l = paramJSONObject;
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  protected void k(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.getString("is_report").equals("0"))
      {
        fp.a().a(false);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  protected void l(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("goldcoupons_info"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("goldcoupons_info");
        if (paramJSONObject.has("is_dedute_bymon"))
        {
          if (paramJSONObject.getInt("is_dedute_bymon") == 0)
          {
            fp.a().o(true);
            return;
          }
          fp.a().o(false);
          return;
        }
        fp.a().o(true);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  protected void m(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("hf_info"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("hf_info");
        if (paramJSONObject.has("hfpay_channelInfo"))
        {
          this.f = paramJSONObject.getString("hfpay_channelInfo");
          paramJSONObject = V();
          if (TextUtils.isEmpty(paramJSONObject)) {
            APLog.e("MonthInfo", "Cannot get decode key!");
          }
          this.f = eb.a(this.f, paramJSONObject);
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("OperatorBase = ");
        paramJSONObject.append(this.f);
        APLog.i("APGetExpressPayAns", paramJSONObject.toString());
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  protected void n(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("wx_info")) {}
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("wx_info");
      int i = paramJSONObject.optInt("wx_contract_signstate", -1);
      int j = paramJSONObject.optInt("wx_contract_buylimit");
      this.g.b.a(i);
      this.g.b.b(j);
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  protected void o(JSONObject paramJSONObject)
  {
    String str = V();
    if (TextUtils.isEmpty(str)) {
      APLog.e("BuyGoods", "Cannot get decode key!");
    }
    gd.a().a(paramJSONObject, str);
  }
  
  protected void p(JSONObject paramJSONObject)
  {
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("hf_amt_allow");
      int j = localJSONArray.length();
      ge.a().b();
      int i = 0;
      while (i < j)
      {
        String str = localJSONArray.get(i).toString();
        ge.a().a(str);
        i += 1;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      ge.a().b();
      localJSONException.printStackTrace();
      try
      {
        paramJSONObject = paramJSONObject.optString("hf_amt_show_info");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          ge.a().b(paramJSONObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  protected void q(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("mb_info"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("mb_info");
        APLog.i("mb_info", paramJSONObject.toString());
        this.c = "";
        if (paramJSONObject.has("sms_info"))
        {
          this.c = paramJSONObject.getString("sms_info");
          if ((this.c != null) && (!this.c.equals(""))) {
            com.pay.paychannel.qdqb.APQDQBChannel.l = this.c;
          }
        }
        this.d = -1;
        if (paramJSONObject.has("remain")) {
          this.d = paramJSONObject.getInt("remain");
        }
        this.e = "";
        if (paramJSONObject.has("mb_only_sms")) {
          this.e = paramJSONObject.getString("mb_only_sms");
        }
        this.b = "";
        if (paramJSONObject.has("mburl")) {
          this.b = paramJSONObject.getString("mburl");
        }
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  protected void r(JSONObject paramJSONObject)
  {
    ap localap = new ap();
    localap.b(paramJSONObject);
    localap.a(paramJSONObject);
  }
  
  protected void s(JSONObject paramJSONObject)
  {
    l.a().a(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.bw
 * JD-Core Version:    0.7.0.1
 */