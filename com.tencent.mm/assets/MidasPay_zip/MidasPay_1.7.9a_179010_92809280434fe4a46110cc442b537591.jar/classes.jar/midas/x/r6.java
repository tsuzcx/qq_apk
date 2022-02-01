package midas.x;

import android.text.TextUtils;
import android.util.Log;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class r6
{
  public static ArrayList<q6> e;
  public static volatile r6 f;
  public ArrayList<q6> a;
  public ArrayList<q6> b;
  public ArrayList<q6> c;
  public String d = "";
  
  public r6()
  {
    f();
    this.c = new ArrayList();
    this.a = new ArrayList();
    this.b = new ArrayList();
    int i = 0;
    while (i < e.size())
    {
      q6 localq6 = new q6();
      localq6.a = ((q6)e.get(i)).a;
      localq6.b = ((q6)e.get(i)).b;
      localq6.c = ((q6)e.get(i)).c;
      localq6.h = ((q6)e.get(i)).h;
      this.c.add(localq6);
      i += 1;
    }
  }
  
  public static int e(String paramString)
  {
    ArrayList localArrayList = e;
    int j = -1;
    if (localArrayList == null) {
      return -1;
    }
    int i = 0;
    while (i < e.size())
    {
      if (((q6)e.get(i)).a.equals(paramString)) {
        j = ((q6)e.get(i)).k;
      }
      i += 1;
    }
    return j;
  }
  
  public static void i()
  {
    e = null;
    f = null;
  }
  
  public static r6 j()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new r6();
        }
      }
      finally {}
    }
    return f;
  }
  
  public final int a(List<q6> paramList, String paramString)
  {
    int i = 0;
    while (i < paramList.size())
    {
      q6 localq6 = (q6)paramList.get(i);
      if (paramString.equals(localq6.a)) {
        return localq6.c;
      }
      i += 1;
    }
    return 0;
  }
  
  public String a(String paramString)
  {
    return c(this.b, paramString);
  }
  
  public final ArrayList<q6> a(ArrayList<q6> paramArrayList)
  {
    APLog.d("FilterHuafei", "Get filter channel!");
    if (paramArrayList == null)
    {
      APLog.d("FilterHuafei", "src channel null, skip");
      return paramArrayList;
    }
    int i = paramArrayList.size();
    if (i <= 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("src channel empty, skip ");
      ((StringBuilder)localObject).append(i);
      APLog.d("FilterHuafei", ((StringBuilder)localObject).toString());
      return paramArrayList;
    }
    boolean bool1 = h();
    boolean bool2 = g();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("is multi month = ");
    ((StringBuilder)localObject).append(bool1);
    APLog.d("FilterHuafei", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("is month upgrade = ");
    ((StringBuilder)localObject).append(bool2);
    APLog.d("FilterHuafei", ((StringBuilder)localObject).toString());
    if ((!bool2) && (!bool1))
    {
      APLog.d("FilterHuafei", "Not month upgrade nor multi month, skip");
      return paramArrayList;
    }
    localObject = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      q6 localq6 = (q6)paramArrayList.next();
      if ("hfpay".equals(localq6.a))
      {
        APLog.d("FilterHuafei", "Current channel is hf, drop!");
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Current channel is ");
        localStringBuilder.append(localq6.a);
        localStringBuilder.append(", add!");
        APLog.d("FilterHuafei", localStringBuilder.toString());
        ((ArrayList)localObject).add(localq6);
      }
    }
    return localObject;
  }
  
  public List<q6> a()
  {
    if ((p.o().h()) && (p.o().f()) && (p.o().i())) {
      return b(this.b);
    }
    return a(this.b);
  }
  
  public final void a(ArrayList<q6> paramArrayList1, ArrayList<q6> paramArrayList2)
  {
    int i = 0;
    while (i < paramArrayList2.size())
    {
      q6 localq6 = (q6)paramArrayList2.get(i);
      if (this.c.contains(localq6))
      {
        String str2 = localq6.b;
        String str1;
        if (str2 != null)
        {
          str1 = str2;
          if (!str2.equals("")) {}
        }
        else
        {
          str1 = b(this.c, localq6.a);
          localq6.b = str1;
        }
        localq6.c = a(this.c, localq6.a);
        if ((p4.p().e().b.saveType == 0) || (!"friendpay".equals(localq6.a)))
        {
          boolean bool = s5.a(a.r().a());
          if (((!c6.s0().n0()) || (bool) || (!"wechat_quickpass".equals(localq6.a))) && (!paramArrayList1.contains(localq6)) && (str1.length() > 0)) {
            paramArrayList1.add(localq6);
          }
        }
      }
      i += 1;
    }
  }
  
  public void a(JSONObject paramJSONObject, String paramString)
  {
    Object localObject1 = "hfpay=0&mccmnc=";
    Object localObject5;
    int i;
    int j;
    Object localObject3;
    if (paramJSONObject.has("qqacct_save_channel"))
    {
      Object localObject2 = localObject1;
      try
      {
        JSONArray localJSONArray = n4.b(paramJSONObject, "qqacct_save_channel", paramString);
        localObject2 = localObject1;
        localObject5 = new ArrayList();
        localObject2 = localObject1;
        i = localJSONArray.length();
        j = 0;
        JSONObject localJSONObject;
        q6 localq62;
        if (j < i)
        {
          localObject2 = localObject1;
          localJSONObject = (JSONObject)localJSONArray.get(j);
          localObject2 = localObject1;
          if (!c6.s0().h0())
          {
            localObject2 = localObject1;
            if ("cft".equals(localJSONObject.getString("name"))) {
              break label834;
            }
            localObject2 = localObject1;
            if ("bank".equals(localJSONObject.getString("name"))) {
              break label834;
            }
          }
          localObject2 = localObject1;
          localq62 = new q6();
          localObject2 = localObject1;
          localq62.a = localJSONObject.getString("name");
          localObject2 = localObject1;
          localq62.f = String.valueOf(localJSONObject.getInt("discount"));
          localObject2 = localObject1;
          localq62.g = localJSONObject.optString("promotion");
          localObject2 = localObject1;
          localq62.e = localJSONObject.getString("info");
        }
        try
        {
          localq62.i = 2;
          localObject2 = "";
          try
          {
            String str = localJSONObject.getString("channelname");
            localObject2 = str;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          localq62.b = ((String)localObject2);
          if (localJSONObject.has("logo_url"))
          {
            localObject2 = localJSONObject.getString("logo_url");
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              localq62.d = ((String)localObject2);
            }
          }
          ((ArrayList)localObject5).add(localq62);
        }
        catch (JSONException localJSONException1)
        {
          break label338;
        }
        localObject2 = localObject1;
        j().c((ArrayList)localObject5);
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException2)
      {
        localObject1 = localJSONException1;
        localObject3 = localJSONException2;
      }
      label338:
      ((JSONException)localObject3).printStackTrace();
    }
    else
    {
      localObject1 = "hfpay=0&mccmnc=";
    }
    if (paramJSONObject.has("channel")) {}
    for (;;)
    {
      try
      {
        Object localObject4 = n4.b(paramJSONObject, "channel", paramString);
        j = ((JSONArray)localObject4).length();
        localObject3 = new ArrayList();
        i = 0;
        if (i < j)
        {
          localObject5 = (JSONObject)((JSONArray)localObject4).get(i);
          if ((!c6.s0().h0()) && (("cft".equals(((JSONObject)localObject5).getString("name"))) || ("bank".equals(((JSONObject)localObject5).getString("name"))))) {
            break label843;
          }
          q6 localq61 = new q6();
          localq61.a = ((JSONObject)localObject5).getString("name");
          localq61.f = String.valueOf(((JSONObject)localObject5).getInt("discount"));
          localq61.g = ((JSONObject)localObject5).optString("promotion");
          localq61.e = ((JSONObject)localObject5).getString("info");
          localq61.i = 2;
          paramJSONObject = "";
          try
          {
            paramString = ((JSONObject)localObject5).getString("channelname");
            paramJSONObject = paramString;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
          }
          localq61.b = paramJSONObject;
          if (((JSONObject)localObject5).has("logo_url"))
          {
            paramJSONObject = ((JSONObject)localObject5).getString("logo_url");
            if (!TextUtils.isEmpty(paramJSONObject)) {
              localq61.d = paramJSONObject;
            }
          }
          ((ArrayList)localObject3).add(localq61);
          break label843;
        }
        paramString = new q6();
        paramString.a = "hfpay";
        paramJSONObject = APTools.n(a.r().a());
        boolean bool = ((ArrayList)localObject3).contains(paramString);
        if (bool)
        {
          paramString = APDataReportManager.getInstance();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("hfpay=1&mccmnc=");
          ((StringBuilder)localObject1).append(paramJSONObject);
          paramString.a("sdk.channel.exist", ((StringBuilder)localObject1).toString());
          paramString = APDataReportManager.getInstance();
          i = p4.p().g();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("hfpay=1&mccmnc=");
          ((StringBuilder)localObject1).append(paramJSONObject);
          paramString.insertData("sdk.channel.exist", i, "", "", ((StringBuilder)localObject1).toString());
        }
        else
        {
          paramString = APDataReportManager.getInstance();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject1);
          ((StringBuilder)localObject4).append(paramJSONObject);
          paramString.a("sdk.channel.exist", ((StringBuilder)localObject4).toString());
          paramString = APDataReportManager.getInstance();
          i = p4.p().g();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject1);
          ((StringBuilder)localObject4).append(paramJSONObject);
          paramString.insertData("sdk.channel.exist", i, "", "", ((StringBuilder)localObject4).toString());
        }
        j().d((ArrayList)localObject3);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      return;
      label834:
      j += 1;
      break;
      label843:
      i += 1;
    }
  }
  
  public final String b(List<q6> paramList, String paramString)
  {
    int i = 0;
    while (i < paramList.size())
    {
      q6 localq6 = (q6)paramList.get(i);
      if (paramString.equals(localq6.a)) {
        return localq6.b;
      }
      i += 1;
    }
    return "";
  }
  
  public final ArrayList<q6> b(ArrayList<q6> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = APDataReportManager.getInstance();
    int i = p4.p().g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("coupons=");
    localStringBuilder.append(p.o().e());
    ((APDataReportManager)localObject).insertData("sdk.channel.forbid", i, "", "", localStringBuilder.toString());
    i = 0;
    while (i < paramArrayList.size())
    {
      localObject = (q6)paramArrayList.get(i);
      if (p.o().a(((q6)localObject).a)) {
        if (("hfpay".equals(((q6)localObject).a)) && (APTools.p(p4.p().e().c.a()) % 100 != 0)) {
          APDataReportManager.getInstance().insertData("sdk.channel.forbid", p4.p().g(), "", "", "hfpay=decimals");
        } else {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public List<q6> b()
  {
    if ((p.o().h()) && (p.o().f()) && (p.o().i())) {
      return b(this.a);
    }
    return a(this.a);
  }
  
  public q6 b(String paramString)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      int i = 0;
      while (i < this.a.size())
      {
        localObject = (q6)this.a.get(i);
        if (paramString.equals(((q6)localObject).a)) {
          return localObject;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public int c()
  {
    int i = 0;
    while (i < this.a.size())
    {
      q6 localq6 = (q6)this.a.get(i);
      if (localq6.a.equals("qdqb")) {
        return 0;
      }
      if (localq6.a.equals("qbqd")) {
        return 11;
      }
      i += 1;
    }
    return 0;
  }
  
  public String c(String paramString)
  {
    int i = 0;
    while (i < this.a.size())
    {
      if (((q6)this.a.get(i)).a.equals(paramString)) {
        return ((q6)this.a.get(i)).b;
      }
      i += 1;
    }
    return "";
  }
  
  public final String c(List<q6> paramList, String paramString)
  {
    int i = 0;
    while (i < paramList.size())
    {
      q6 localq6 = (q6)paramList.get(i);
      if (localq6.a.equals(paramString))
      {
        paramList = localq6.f;
        break label56;
      }
      i += 1;
    }
    paramList = "100";
    label56:
    if (paramList.length() < 3) {
      return paramList;
    }
    return "";
  }
  
  public void c(ArrayList<q6> paramArrayList)
  {
    this.b.clear();
    a(this.b, paramArrayList);
  }
  
  public String d()
  {
    return f.d;
  }
  
  public String d(String paramString)
  {
    return c(this.a, paramString);
  }
  
  public void d(ArrayList<q6> paramArrayList)
  {
    this.a.clear();
    a(this.a, paramArrayList);
  }
  
  public String e()
  {
    new ArrayList();
    int i = p4.p().e().b.saveType;
    List localList;
    if ((i != 2) && (i != 3)) {
      localList = j().b();
    } else {
      localList = j().a();
    }
    StringBuffer localStringBuffer;
    if ((localList != null) && (localList.size() >= 1))
    {
      localStringBuffer = new StringBuffer();
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < localList.size())
        {
          q6 localq6 = (q6)localList.get(i);
          if ((localq6 == null) || (TextUtils.isEmpty(localq6.a))) {
            break label174;
          }
          localStringBuffer.append(localq6.a);
          localStringBuffer.append(",");
          break label174;
        }
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        APLog.i("getSupportChannelIdString", localException.toString());
      }
      return localStringBuffer.toString();
      return "";
      label174:
      i += 1;
    }
  }
  
  public void f()
  {
    e = new ArrayList();
    e.add(new q6("cft", "财付通余额", 2131034198, "", "", "100", "财付通支付", "", 1, false, 1, ""));
    e.add(new q6("qbqd", "Q币", 2131034202, "", "", "100", "Q币支付", "", 1, false, 11, ""));
    e.add(new q6("qdqb", "Q点", 2131034202, "", "", "100", "Q点支付", "", 1, false, 0, ""));
    e.add(new q6("bank", "银行卡快捷支付", 2131034196, "", "", "100", "银行卡支付", "", 1, false, 2, ""));
    e.add(new q6("mcard", "手机充值卡", 2131034201, "", "", "100", "立即支付", "", 1, false, 5, ""));
    e.add(new q6("hfpay", "手机话费", 2131034197, "", "", "100", "立即支付", "", 1, false, 9, ""));
    e.add(new q6("qqcard", "QQ卡", 2131034204, "", "", "100", "立即支付", "", 1, false, 4, ""));
    e.add(new q6("yb", "元宝", 2131034209, "", "", "100", "元宝支付", "", 1, false, 7, ""));
    e.add(new q6("gold_coupons", "金券", 2131034200, "", "", "100", "金券支付", "", 1, false, 10, ""));
    e.add(new q6("friendpay", "好友代付", 2131034199, "", "", "100", "好友代付", "", 1, false, 14, ""));
    e.add(new q6("wechat_quickpass", "云闪付", 2131034206, "", "", "100", "云闪付", "", 1, false, 20, ""));
    e.add(new q6("wechat", "微信支付", 2131034207, "", "", "100", "微信支付", "", 1, false, 8, ""));
    e.add(new q6("qqwallet", "QQ钱包支付", 2131034203, "", "", "100", "QQ钱包支付", "", 1, false, 13, ""));
    if ((q5.b()) && (q5.a()))
    {
      APDataReportManager.getInstance().insertData("sdk.qqwallet.support", p4.p().e().b.saveType);
      return;
    }
    APDataReportManager.getInstance().insertData("sdk.qqwallet.nosupport", p4.p().e().b.saveType);
  }
  
  public final boolean g()
  {
    if (p4.p().g() != 4)
    {
      APLog.d("FilterHuafei", "Is month upgrade, current not month request, skip");
      return false;
    }
    o4 localo4 = p4.p().e();
    try
    {
      int i = ((z4)localo4.c).l;
      if (i == 3) {
        return true;
      }
    }
    finally
    {
      localThrowable.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Is month upgrade, exception = ");
      localStringBuilder.append(Log.getStackTraceString(localThrowable));
      APLog.d("FilterHuafei", localStringBuilder.toString());
    }
    return false;
  }
  
  public final boolean h()
  {
    int i = p4.p().g();
    boolean bool = false;
    if ((i != 4) && (i != 5))
    {
      APLog.d("FilterHuafei", "Is multi month, current not month or subscribe, skip");
      return false;
    }
    Object localObject = p4.p().e();
    try
    {
      localObject = ((o4)localObject).f.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Is multi month, string save num  = ");
      localStringBuilder.append((String)localObject);
      APLog.d("FilterHuafei", localStringBuilder.toString());
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        APLog.d("FilterHuafei", "Is multi month, cannot get save num, skip");
        return false;
      }
      try
      {
        i = Integer.parseInt((String)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Is multi month, int save num  = ");
        ((StringBuilder)localObject).append(i);
        APLog.d("FilterHuafei", ((StringBuilder)localObject).toString());
        if (i > 1) {
          bool = true;
        }
        return bool;
      }
      finally
      {
        return false;
      }
      return false;
    }
    finally
    {
      localThrowable2.printStackTrace();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Is multi month, get save num exception = ");
      localStringBuilder.append(Log.getStackTraceString(localThrowable2));
      APLog.d("FilterHuafei", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.r6
 * JD-Core Version:    0.7.0.1
 */