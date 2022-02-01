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

public class cc
  extends lh
{
  static final String[] i = { "Td8qRx7IdbbSyw3K", "elddjmxNE2FK8cch", "n6QnJOTocDGX5dXR", "caUdsBbJ1oOxMbPy", "ehDFwSSDOFz3U1d3", "nmiFzdsTgUYGcMeg", "t3W6mdGCbIfFcwdR", "PLSeUfBBSgfDWAuA", "ayGzfJkNBZKE9UZf", "yVBtdRgAEx3EgG31" };
  public boolean a = false;
  public boolean b = false;
  protected String c = "";
  protected String d = "";
  protected int e = -1;
  protected String f = "";
  protected String g = "";
  el h = null;
  
  cc(lw paramlw)
  {
    super(paramlw);
  }
  
  public String a()
  {
    return this.c;
  }
  
  protected void a(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("comm_config");
    if ((localJSONObject.has("show_feedback")) && ("1".equals(localJSONObject.getString("show_feedback")))) {
      fy.a().h(true);
    }
    if ((localJSONObject.has("change_h5")) && ("1".equals(localJSONObject.getString("change_h5")))) {
      this.a = true;
    }
    if ((localJSONObject.has("graytest_cloud_conn")) && ("1".equals(localJSONObject.optString("graytest_cloud_conn")))) {
      this.b = true;
    }
    if ((localJSONObject.has("show_tranrecord")) && ("1".equals(localJSONObject.getString("show_tranrecord")))) {
      fy.a().g(true);
    }
    if (localJSONObject.has("wx_appid"))
    {
      paramJSONObject = localJSONObject.getString("wx_appid");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        fy.a().p(paramJSONObject);
      }
    }
    if (localJSONObject.has("show_continuebuy"))
    {
      paramJSONObject = localJSONObject.getString("show_continuebuy");
      if ((!TextUtils.isEmpty(paramJSONObject)) && (paramJSONObject.equals("0"))) {
        fy.a().j(false);
      }
    }
    if (localJSONObject.has("ip_strategy"))
    {
      localObject1 = localJSONObject.getString("ip_strategy");
      paramJSONObject = (JSONObject)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramJSONObject = "3";
      }
      bz.b(paramJSONObject);
    }
    if (localJSONObject.has("ip_mode"))
    {
      localObject1 = localJSONObject.getString("ip_mode");
      paramJSONObject = (JSONObject)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramJSONObject = "0";
      }
      bz.c(paramJSONObject);
    }
    if (localJSONObject.has("show_resultpage"))
    {
      paramJSONObject = localJSONObject.getString("show_resultpage");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        fy.a().t(paramJSONObject);
      } else {
        fy.a().t("1");
      }
    }
    int j;
    if (localJSONObject.has("resultpage_timeout"))
    {
      j = i.a(localJSONObject.getString("resultpage_timeout"));
      if (j != 0) {
        fy.a().d(j);
      }
    }
    fy.a().l(true);
    if ((localJSONObject.has("show_ensurepage")) && ("0".equals(localJSONObject.getString("show_ensurepage")))) {
      fy.a().l(false);
    }
    if (localJSONObject.has("t4")) {
      try
      {
        j = localJSONObject.getInt("t4");
        if (j != 0) {
          APAppDataInterface.singleton().d(j);
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
        j = localJSONObject.getInt("t3");
        if (j != 0) {
          APAppDataInterface.singleton().e(j);
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
        j = localJSONObject.getInt("t2");
        if (j != 0) {
          APAppDataInterface.singleton().f(j);
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
      j = i.a((String)localObject1);
      int k = i.a(str);
      paramJSONObject = new fz();
      paramJSONObject.a(a.a().d, "TencentUnipay", "log_keep_size", String.valueOf(j));
      paramJSONObject.a(a.a().d, "TencentUnipay", "log_keep_time", String.valueOf(k));
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
    jj.a = i.a(localJSONObject.optString("log_upload_max", "3"));
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
        jj.a(em.b().n().a.openId, str, paramJSONObject);
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
          fy.a().r(false);
        } else {
          fy.a().r(true);
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
        fy.a().a(l);
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
      j = i.a(localJSONObject.getString("game_max_buy_number"));
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("iMax:");
      paramJSONObject.append(j);
      APLog.i("comm_config", paramJSONObject.toString());
      fy.a().c(j);
    }
    catch (Exception paramJSONObject)
    {
      label1089:
      break label1089;
    }
    fy.a().c(0);
    break label1106;
    fy.a().c(0);
    label1106:
    fy.a().F(localJSONObject.optString("mqq_appid", ""));
    fy.a().G(localJSONObject.optString("mqq_ltype", "1"));
    if (localJSONObject.has("enable_X5")) {
      id.a(a.a().d, localJSONObject.getString("enable_X5"));
    }
  }
  
  public String b()
  {
    return this.d;
  }
  
  protected void b(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("real_session_id");
    String str = paramJSONObject.optString("real_session_type");
    fy localfy = fy.a();
    paramJSONObject = (JSONObject)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject = "";
    }
    localfy.J(paramJSONObject);
    localObject = fy.a();
    paramJSONObject = str;
    if (TextUtils.isEmpty(str)) {
      paramJSONObject = "";
    }
    ((fy)localObject).K(paramJSONObject);
  }
  
  public int c()
  {
    return this.e;
  }
  
  protected void c(JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.getJSONObject("service_update");
    if (paramJSONObject.has("update_months"))
    {
      String str = paramJSONObject.getString("update_months");
      gc.a().b(str);
    }
    if (paramJSONObject.has("update_price"))
    {
      paramJSONObject = paramJSONObject.getString("update_price");
      gc.a().a(paramJSONObject);
    }
  }
  
  public String d()
  {
    return this.f;
  }
  
  protected void d(JSONObject paramJSONObject)
  {
    try
    {
      if (!TextUtils.isEmpty(paramJSONObject.getString("result_url")))
      {
        fy.a().i(paramJSONObject.getString("result_url"));
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
    em.b().n().d.m = paramJSONObject;
  }
  
  protected boolean f(JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.getJSONObject("mp");
    int j = paramJSONObject.getInt("firstsave_present_count");
    String str = paramJSONObject.getString("present_level");
    if ((j <= 0) && (TextUtils.isEmpty(str))) {
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
        em.b().n().a(paramJSONObject.getString("out_trade_no"));
        return;
      }
      em.b().n().a("");
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
      this.h.e.l = paramJSONObject;
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
        fy.a().a(false);
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
            fy.a().o(true);
            return;
          }
          fy.a().o(false);
          return;
        }
        fy.a().o(true);
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
          this.g = paramJSONObject.getString("hfpay_channelInfo");
          paramJSONObject = X();
          if (TextUtils.isEmpty(paramJSONObject)) {
            APLog.e("MonthInfo", "Cannot get decode key!");
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
  
  protected void n(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("wx_info")) {}
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("wx_info");
      int j = paramJSONObject.optInt("wx_contract_signstate", -1);
      int k = paramJSONObject.optInt("wx_contract_buylimit");
      this.h.b.a(j);
      this.h.b.b(k);
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  protected void o(JSONObject paramJSONObject)
  {
    String str = X();
    if (TextUtils.isEmpty(str)) {
      APLog.e("BuyGoods", "Cannot get decode key!");
    }
    gn.a().a(paramJSONObject, str);
  }
  
  protected void p(JSONObject paramJSONObject)
  {
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("hf_amt_allow");
      int k = localJSONArray.length();
      go.a().b();
      int j = 0;
      while (j < k)
      {
        String str = localJSONArray.get(j).toString();
        go.a().a(str);
        j += 1;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      go.a().b();
      localJSONException.printStackTrace();
      try
      {
        paramJSONObject = paramJSONObject.optString("hf_amt_show_info");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          go.a().b(paramJSONObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.cc
 * JD-Core Version:    0.7.0.1
 */