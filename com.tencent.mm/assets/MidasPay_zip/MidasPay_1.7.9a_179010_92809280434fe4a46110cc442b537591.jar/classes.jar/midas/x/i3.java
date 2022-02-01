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

public class i3
  extends d2
{
  public c5 p = null;
  
  public i3(fc paramfc)
  {
    super(paramfc);
  }
  
  public boolean d(gb paramgb)
  {
    Object localObject1 = paramgb.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("resultData=");
    ((StringBuilder)localObject2).append((String)localObject1);
    APLog.i("APMobileMonthInfoAns", ((StringBuilder)localObject2).toString());
    if ((p4.p().e() != null) && (((p4.p().e().b instanceof APMonthRequest)) || ((p4.p().e().b instanceof APSubscribeRequest))))
    {
      this.n = p4.p().e();
      this.p = this.n.e;
      try
      {
        localObject2 = new JSONObject((String)localObject1);
        this.a = Integer.parseInt(((JSONObject)localObject2).getString("ret"));
        this.b = ((JSONObject)localObject2).getString("msg");
        i = this.a;
        if (i == 0)
        {
          localObject3 = ((JSONObject)localObject2).getJSONObject("info");
          localObject1 = (z4)this.n.c;
          ((w4)localObject1).c = ((JSONObject)localObject3).getString("rate");
          ((w4)localObject1).a = ((JSONObject)localObject3).getString("offer_name");
        }
      }
      catch (JSONException localJSONException)
      {
        int i;
        Object localObject3;
        label199:
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
      break label199;
    }
    localObject1 = "";
    this.n.f.i = ((String)localObject1);
    this.n.f.j = ((String)localObject1);
    if (((JSONObject)localObject3).has("service_update")) {
      q((JSONObject)localObject3);
    }
    localObject1 = b();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      APLog.e("MonthInfo", "Cannot get decode key!");
    }
    j((JSONObject)localObject3);
    if (n4.d((JSONObject)localObject3, "is_cft_user", (String)localObject1).equals("1")) {
      this.p.d = true;
    } else {
      this.p.d = false;
    }
    if (n4.d((JSONObject)localObject3, "is_kj", (String)localObject1).equals("1")) {
      this.p.c = true;
    } else {
      this.p.c = false;
    }
    if (n4.d((JSONObject)localObject3, "wc_bind_qq", (String)localObject1).equals("1")) {
      this.p.e = true;
    } else {
      this.p.e = false;
    }
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("isBindQQ ");
    ((StringBuilder)localObject4).append(this.n.e.e);
    APLog.w("monthInfoAns", ((StringBuilder)localObject4).toString());
    localObject4 = n4.d((JSONObject)localObject3, "qq_acct_balance", (String)localObject1);
    try
    {
      i = Integer.parseInt((String)localObject4);
    }
    catch (Exception localException3)
    {
      label432:
      break label432;
    }
    i = 0;
    this.p.g = i;
    if (((JSONObject)localObject3).has("wx_bind_qquin")) {
      r((JSONObject)localObject3);
    }
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("wxBindQQUin ");
    ((StringBuilder)localObject4).append(this.n.e.k);
    APLog.w("monthInfoAns", ((StringBuilder)localObject4).toString());
    if (((JSONObject)localObject3).has("result_url")) {
      p((JSONObject)localObject3);
    }
    if (((JSONObject)localObject3).has("comm_config")) {
      b((JSONObject)localObject3);
    }
    d0.i().a("");
    if (((JSONObject)localObject3).has("month_type"))
    {
      localObject4 = ((JSONObject)localObject3).getString("month_type");
      try
      {
        i = Integer.parseInt((String)localObject4);
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i == 4)
              {
                this.n.b.saveType = 5;
                g6.k().a(g6.a.a);
                v((JSONObject)localObject3);
              }
            }
            else
            {
              this.n.b.saveType = 5;
              g6.k().a(g6.a.b);
              w((JSONObject)localObject3);
            }
          }
          else
          {
            this.n.b.saveType = 4;
            g6.k().a(g6.a.a);
            v((JSONObject)localObject3);
          }
        }
        else
        {
          this.n.b.saveType = 4;
          g6.k().a(g6.a.b);
          w((JSONObject)localObject3);
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    if ((((JSONObject)localObject3).has("is_use_newmpaymode")) && (((JSONObject)localObject3).getInt("is_use_newmpaymode") == 1)) {
      c6.s0().t(true);
    } else {
      c6.s0().t(false);
    }
    i = n4.a((JSONObject)localObject3, "mcard_balance", (String)localObject1);
    this.p.h = i;
    k((JSONObject)localObject3);
    e((JSONObject)localObject3);
    l((JSONObject)localObject3);
    m((JSONObject)localObject3);
    u((JSONObject)localObject3);
    h((JSONObject)localObject3);
    n((JSONObject)localObject3);
    break label879;
    localObject1 = ((JSONObject)localObject2).getString("err_code").toString();
    if (!((String)localObject1).equals(""))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("系统繁忙,请稍后再试 (");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(")");
      this.b = ((StringBuilder)localObject3).toString();
    }
    label879:
    if (((JSONObject)localObject2).has("info"))
    {
      localObject1 = ((JSONObject)localObject2).getJSONObject("info");
      g((JSONObject)localObject1);
      t((JSONObject)localObject1);
      x((JSONObject)localObject1);
      d((JSONObject)localObject1);
      f((JSONObject)localObject1);
      c((JSONObject)localObject1);
      a((JSONObject)localObject1);
    }
    return super.d(paramgb);
    return super.d(paramgb);
  }
  
  public String l()
  {
    return this.m;
  }
  
  public final void t(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("sp_forbid_channel_list")) {
        p.o().c(paramJSONObject.getString("sp_forbid_channel_list"));
      }
      int j = 0;
      int i = 0;
      boolean bool = paramJSONObject.has("mp_info");
      if (bool)
      {
        paramJSONObject = paramJSONObject.getJSONObject("mp_info");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mp_info = ");
        localStringBuilder.append(paramJSONObject.toString());
        APLog.d("FFAIP-C", localStringBuilder.toString());
        if (paramJSONObject.has("gold_mpinfo"))
        {
          d0.i().a(paramJSONObject.toString());
          i = 1;
        }
        else
        {
          p.o().a();
        }
        o(paramJSONObject);
      }
      else
      {
        APLog.i("mpInfo", "has not mp_info");
        APLog.d("FFAIP-C", "no mp_info");
        p.o().a();
        i = j;
      }
      bool = p.o().g();
      p.o().a(true);
      if (!p.o().h()) {
        p.o().c("");
      }
      p.o().a(bool);
      if (i == 0)
      {
        d0.i().a(null);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      APLog.e("APMobileMonthInfoAns mpInfo crash=", paramJSONObject.toString());
    }
  }
  
  public final void u(JSONObject paramJSONObject)
  {
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        Object localObject = b();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          APLog.e("MonthInfo", "Cannot get decode key!");
        }
        paramJSONObject = n4.b(paramJSONObject, "friends_list", (String)localObject);
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
          int m = ((JSONArray)localObject).length();
          try
          {
            ArrayList localArrayList3 = new ArrayList();
            int j = 0;
            if (j < m)
            {
              JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(j);
              p7 localp7 = new p7();
              localJSONObject.getString("qq");
              URLDecoder.decode(localJSONObject.getString("user_nick"), "utf-8");
              localArrayList3.add(localp7);
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
          g6.k().a(localArrayList1);
          g6.k().b(localArrayList2);
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
  
  public final void v(JSONObject paramJSONObject)
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
        float f = Float.valueOf(APTools.j((String)localObject)).floatValue() / 100.0F;
        localObject = new DecimalFormat();
        ((DecimalFormat)localObject).applyPattern("0.00");
        localObject = ((DecimalFormat)localObject).format(f);
        arrayOfString1[i] = str1;
        arrayOfString2[i] = localObject;
        arrayOfString3[i] = str2;
        arrayOfString4[i] = str3;
        i += 1;
      }
      r7.e().a(arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public final void w(JSONObject paramJSONObject)
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
      r7.e().c(arrayOfString);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public final void x(JSONObject paramJSONObject)
  {
    String str1 = "";
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("user_info");
      String str3 = paramJSONObject.getString("uin");
      String str2 = paramJSONObject.getString("uin_type");
      int i = paramJSONObject.getInt("uin_len");
      int j = paramJSONObject.getInt("codeindex");
      if ((!str3.equals("")) && (j < d2.o.length))
      {
        str3 = l6.a(str3, d2.o[j]);
        paramJSONObject = str1;
        if (str3.length() >= i) {
          paramJSONObject = str3.substring(0, i);
        }
        this.p.i = paramJSONObject;
      }
      this.p.j = str2;
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.i3
 * JD-Core Version:    0.7.0.1
 */