package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class db
  extends bw
{
  private eq m = null;
  
  public db(kl paramkl)
  {
    super(paramkl);
  }
  
  private void t(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("product")) {
      return;
    }
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("product");
      int j = paramJSONObject.length();
      String[] arrayOfString1 = new String[j];
      String[] arrayOfString2 = new String[j];
      String[] arrayOfString3 = new String[j];
      String[] arrayOfString4 = new String[j];
      int i = 0;
      while (i < j)
      {
        String str1 = ((JSONObject)paramJSONObject.get(i)).getString("open_days").toString();
        Object localObject = ((JSONObject)paramJSONObject.get(i)).getString("currency_amt").toString();
        String str2 = ((JSONObject)paramJSONObject.get(i)).getString("product_id").toString();
        String str3 = ((JSONObject)paramJSONObject.get(i)).getString("product_name").toString();
        float f = Float.valueOf(APTools.i((String)localObject)).floatValue() / 100.0F;
        localObject = new DecimalFormat();
        ((DecimalFormat)localObject).applyPattern("0.00");
        localObject = ((DecimalFormat)localObject).format(f);
        arrayOfString1[i] = str1;
        arrayOfString2[i] = localObject;
        arrayOfString3[i] = str2;
        arrayOfString4[i] = str3;
        i += 1;
      }
      hc.a().a(arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void u(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("recommend_list")) {
      return;
    }
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("recommend_list");
      int j = paramJSONObject.length();
      String[] arrayOfString = new String[j];
      int i = 0;
      while (i < j)
      {
        arrayOfString[i] = paramJSONObject.get(i).toString();
        i += 1;
      }
      hc.a().a(arrayOfString);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void v(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("sp_forbid_channel_list")) {
        o.a().a(paramJSONObject.getString("sp_forbid_channel_list"));
      }
      int j = 0;
      int i = 0;
      if (paramJSONObject.has("mp_info"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("mp_info");
        if (paramJSONObject.has("gold_mpinfo"))
        {
          ac.a().a(paramJSONObject.toString());
          i = 1;
        }
        else
        {
          o.a().i();
        }
        g(paramJSONObject);
      }
      else
      {
        APLog.i("mpInfo", "has not mp_info");
        o.a().i();
        i = j;
      }
      boolean bool = o.a().e();
      o.a().a(true);
      if (!o.a().b()) {
        o.a().a("");
      }
      o.a().a(bool);
      if (i == 0)
      {
        ac.a().a(null);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      APLog.e("APMobileMonthInfoAns mpInfo crash=", paramJSONObject.toString());
    }
  }
  
  private void w(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("user_info");
        String str2 = paramJSONObject.getString("uin");
        String str1 = paramJSONObject.getString("uin_type");
        int i = paramJSONObject.getInt("uin_len");
        int j = paramJSONObject.getInt("codeindex");
        if ((!str2.equals("")) && (j < h.length))
        {
          paramJSONObject = fx.b(str2, h[j]);
          if (paramJSONObject.length() >= i)
          {
            paramJSONObject = paramJSONObject.substring(0, i);
            this.m.k = paramJSONObject;
          }
        }
        else
        {
          this.m.l = str1;
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      paramJSONObject = "";
    }
  }
  
  private void x(JSONObject paramJSONObject)
  {
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        Object localObject = V();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          APLog.e("MonthInfo", "Cannot get decode key!");
        }
        paramJSONObject = eb.a(paramJSONObject, "friends_list", (String)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("totalHeight=");
        ((StringBuilder)localObject).append(paramJSONObject.toString());
        APLog.i("APPayGameListNum", ((StringBuilder)localObject).toString());
        int k = paramJSONObject.length();
        i = 0;
        if (i < k)
        {
          localObject = (JSONObject)paramJSONObject.get(i);
          localArrayList1.add(URLDecoder.decode(((JSONObject)localObject).getString("group_name"), "utf-8"));
          localObject = ((JSONObject)localObject).getJSONArray("list");
          int n = ((JSONArray)localObject).length();
          try
          {
            ArrayList localArrayList3 = new ArrayList();
            int j = 0;
            if (j < n)
            {
              JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(j);
              ha localha = new ha();
              localha.a = localJSONObject.getString("qq");
              localha.b = URLDecoder.decode(localJSONObject.getString("user_nick"), "utf-8");
              localArrayList3.add(localha);
              j += 1;
              continue;
            }
            localArrayList2.add(localArrayList3);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        else
        {
          fs.a().a(localArrayList1);
          fs.a().b(localArrayList2);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  protected boolean a(jo paramjo)
  {
    Object localObject1 = paramjo.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("resultData=");
    ((StringBuilder)localObject2).append((String)localObject1);
    APLog.i("APMobileMonthInfoAns", ((StringBuilder)localObject2).toString());
    if ((ed.b().n() != null) && (((ed.b().n().a instanceof APMonthRequest)) || ((ed.b().n().a instanceof APSubscribeRequest))))
    {
      this.g = ed.b().n();
      this.m = this.g.d;
      try
      {
        localObject2 = new JSONObject((String)localObject1);
        this.i = Integer.parseInt(((JSONObject)localObject2).getString("ret"));
        this.j = ((JSONObject)localObject2).getString("msg");
        if (this.i == 0)
        {
          localObject3 = ((JSONObject)localObject2).getJSONObject("info");
          localObject1 = (en)this.g.b;
          ((en)localObject1).e = ((JSONObject)localObject3).getString("rate");
          ((en)localObject1).a = ((JSONObject)localObject3).getString("offer_name");
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject3;
        label205:
        Object localObject4;
        localJSONException.printStackTrace();
        APLog.w("APMobileMonthInfoAns", localJSONException.getMessage());
      }
    }
    try
    {
      localObject1 = ((JSONObject)localObject3).getString("express_channel");
    }
    catch (Exception localException1)
    {
      break label205;
    }
    localObject1 = "";
    this.g.e.j = ((String)localObject1);
    this.g.e.k = ((String)localObject1);
    if (((JSONObject)localObject3).has("service_update")) {
      c((JSONObject)localObject3);
    }
    localObject1 = V();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      APLog.e("MonthInfo", "Cannot get decode key!");
    }
    b((JSONObject)localObject3);
    if (eb.d((JSONObject)localObject3, "is_cft_user", (String)localObject1).equals("1")) {
      this.m.d = true;
    } else {
      this.m.d = false;
    }
    if (eb.d((JSONObject)localObject3, "is_kj", (String)localObject1).equals("1")) {
      this.m.c = true;
    } else {
      this.m.c = false;
    }
    if (eb.d((JSONObject)localObject3, "wc_bind_qq", (String)localObject1).equals("1")) {
      this.m.e = true;
    } else {
      this.m.e = false;
    }
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("isBindQQ ");
    ((StringBuilder)localObject4).append(this.g.d.e);
    APLog.w("monthInfoAns", ((StringBuilder)localObject4).toString());
    localObject4 = eb.d((JSONObject)localObject3, "qq_acct_balance", (String)localObject1);
    try
    {
      i = Integer.parseInt((String)localObject4);
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        int i;
      }
    }
    i = 0;
    this.m.g = i;
    if (((JSONObject)localObject3).has("wx_bind_qquin")) {
      e((JSONObject)localObject3);
    }
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("wxBindQQUin ");
    ((StringBuilder)localObject4).append(this.g.d.m);
    APLog.w("monthInfoAns", ((StringBuilder)localObject4).toString());
    if (((JSONObject)localObject3).has("result_url")) {
      d((JSONObject)localObject3);
    }
    if (((JSONObject)localObject3).has("comm_config")) {
      a((JSONObject)localObject3);
    }
    ac.a().a("");
    if (((JSONObject)localObject3).has("month_type"))
    {
      localObject4 = ((JSONObject)localObject3).getString("month_type");
      try
      {
        switch (Integer.parseInt((String)localObject4))
        {
        case 4: 
          this.g.a.saveType = 5;
          fs.a().a(fs.a.a);
          t((JSONObject)localObject3);
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      this.g.a.saveType = 5;
      fs.a().a(fs.a.b);
      u((JSONObject)localObject3);
      break label743;
      this.g.a.saveType = 4;
      fs.a().a(fs.a.a);
      t((JSONObject)localObject3);
      break label743;
      this.g.a.saveType = 4;
      fs.a().a(fs.a.b);
      u((JSONObject)localObject3);
    }
    label743:
    if ((((JSONObject)localObject3).has("is_use_newmpaymode")) && (((JSONObject)localObject3).getInt("is_use_newmpaymode") == 1)) {
      fp.a().i(true);
    } else {
      fp.a().i(false);
    }
    i = eb.c((JSONObject)localObject3, "mcard_balance", (String)localObject1);
    this.m.h = i;
    o((JSONObject)localObject3);
    p((JSONObject)localObject3);
    r((JSONObject)localObject3);
    s((JSONObject)localObject3);
    x((JSONObject)localObject3);
    q((JSONObject)localObject3);
    h((JSONObject)localObject3);
    break label910;
    localObject1 = ((JSONObject)localObject2).getString("err_code").toString();
    if (!((String)localObject1).equals(""))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("系统繁忙,请稍后再试 (");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(")");
      this.j = ((StringBuilder)localObject3).toString();
    }
    label910:
    if (((JSONObject)localObject2).has("info"))
    {
      localObject1 = ((JSONObject)localObject2).getJSONObject("info");
      i((JSONObject)localObject1);
      v((JSONObject)localObject1);
      w((JSONObject)localObject1);
      j((JSONObject)localObject1);
      k((JSONObject)localObject1);
      l((JSONObject)localObject1);
      m((JSONObject)localObject1);
    }
    return super.a(paramjo);
    return super.a(paramjo);
  }
  
  public String e()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.db
 * JD-Core Version:    0.7.0.1
 */