package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gd
{
  public static ArrayList<gc> a;
  private static volatile gd b;
  private ArrayList<gc> c;
  private ArrayList<gc> d;
  private ArrayList<gc> e;
  private String f = "";
  
  private gd()
  {
    c();
    this.e = new ArrayList();
    this.c = new ArrayList();
    this.d = new ArrayList();
    int i = 0;
    while (i < a.size())
    {
      gc localgc = new gc();
      localgc.a = ((gc)a.get(i)).a;
      localgc.b = ((gc)a.get(i)).b;
      localgc.c = ((gc)a.get(i)).c;
      localgc.h = ((gc)a.get(i)).h;
      this.e.add(localgc);
      i += 1;
    }
  }
  
  public static int a(String paramString)
  {
    ArrayList localArrayList = a;
    int j = -1;
    if (localArrayList == null) {
      return -1;
    }
    int i = 0;
    while (i < a.size())
    {
      if (((gc)a.get(i)).a.equals(paramString)) {
        j = ((gc)a.get(i)).l;
      }
      i += 1;
    }
    return j;
  }
  
  private String a(List<gc> paramList, String paramString)
  {
    String str = "100";
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = str;
      if (i >= paramList.size()) {
        break;
      }
      localObject = (gc)paramList.get(i);
      if (((gc)localObject).a.equals(paramString))
      {
        localObject = ((gc)localObject).f;
        break;
      }
      i += 1;
    }
    if (((String)localObject).length() < 3) {
      return localObject;
    }
    return "";
  }
  
  public static gd a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new gd();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void a(ArrayList<gc> paramArrayList1, ArrayList<gc> paramArrayList2)
  {
    int i = 0;
    while (i < paramArrayList2.size())
    {
      gc localgc = (gc)paramArrayList2.get(i);
      if (this.e.contains(localgc))
      {
        String str2 = localgc.b;
        String str1;
        if (str2 != null)
        {
          str1 = str2;
          if (!str2.equals("")) {}
        }
        else
        {
          str1 = b(this.e, localgc.a);
          localgc.b = str1;
        }
        localgc.c = c(this.e, localgc.a);
        if (((ed.b().n().a.saveType == 0) || (!"friends_pay".equals(localgc.a))) && (!paramArrayList1.contains(localgc)) && (str1.length() > 0)) {
          paramArrayList1.add(localgc);
        }
      }
      i += 1;
    }
  }
  
  private String b(List<gc> paramList, String paramString)
  {
    int i = 0;
    while (i < paramList.size())
    {
      gc localgc = (gc)paramList.get(i);
      if (paramString.equals(localgc.a)) {
        return localgc.b;
      }
      i += 1;
    }
    return "";
  }
  
  public static void b()
  {
    a = null;
    b = null;
  }
  
  private int c(List<gc> paramList, String paramString)
  {
    int i = 0;
    while (i < paramList.size())
    {
      gc localgc = (gc)paramList.get(i);
      if (paramString.equals(localgc.a)) {
        return localgc.c;
      }
      i += 1;
    }
    return 0;
  }
  
  private ArrayList<gc> c(ArrayList<gc> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = APDataReportManager.getInstance();
    int i = ed.b().g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("coupons=");
    localStringBuilder.append(o.a().m());
    ((APDataReportManager)localObject).insertData("sdk.channel.forbid", i, "", "", localStringBuilder.toString());
    i = 0;
    while (i < paramArrayList.size())
    {
      localObject = (gc)paramArrayList.get(i);
      if (o.a().c(((gc)localObject).a)) {
        if (("hfpay".equals(((gc)localObject).a)) && (APTools.g(ed.b().n().b.a()) % 100 != 0)) {
          APDataReportManager.getInstance().insertData("sdk.channel.forbid", ed.b().g(), "", "", "hfpay=decimals");
        } else {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(ArrayList<gc> paramArrayList)
  {
    this.d.clear();
    a(this.d, paramArrayList);
  }
  
  public void a(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = paramJSONObject.has("qqacct_save_channel");
    int j = 0;
    Object localObject3;
    Object localObject4;
    int k;
    int i;
    if (bool) {
      try
      {
        localObject3 = eb.a(paramJSONObject, "qqacct_save_channel", paramString);
        localObject4 = new ArrayList();
        k = ((JSONArray)localObject3).length();
        i = 0;
        if (i < k)
        {
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject3).get(i);
          if ((!fp.a().K()) && (("cft".equals(localJSONObject.getString("name"))) || ("bank".equals(localJSONObject.getString("name"))))) {
            break label737;
          }
          gc localgc = new gc();
          localgc.a = localJSONObject.getString("name");
          localgc.f = String.valueOf(localJSONObject.getInt("discount"));
          localgc.g = localJSONObject.optString("promotion");
          localgc.e = localJSONObject.getString("info");
          localgc.j = 2;
          Object localObject1 = "";
          try
          {
            String str = localJSONObject.getString("channelname");
            localObject1 = str;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          localgc.b = ((String)localObject1);
          if (localJSONObject.has("logo_url"))
          {
            localObject1 = localJSONObject.getString("logo_url");
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              localgc.d = ((String)localObject1);
            }
          }
          ((ArrayList)localObject4).add(localgc);
          break label737;
        }
        a().a((ArrayList)localObject4);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    } else if (!paramJSONObject.has("channel")) {}
    for (;;)
    {
      try
      {
        Object localObject2 = eb.a(paramJSONObject, "channel", paramString);
        k = ((JSONArray)localObject2).length();
        ArrayList localArrayList = new ArrayList();
        i = j;
        if (i < k)
        {
          localObject4 = (JSONObject)((JSONArray)localObject2).get(i);
          if ((!fp.a().K()) && (("cft".equals(((JSONObject)localObject4).getString("name"))) || ("bank".equals(((JSONObject)localObject4).getString("name"))))) {
            break label744;
          }
          localObject3 = new gc();
          ((gc)localObject3).a = ((JSONObject)localObject4).getString("name");
          ((gc)localObject3).f = String.valueOf(((JSONObject)localObject4).getInt("discount"));
          ((gc)localObject3).g = ((JSONObject)localObject4).optString("promotion");
          ((gc)localObject3).e = ((JSONObject)localObject4).getString("info");
          ((gc)localObject3).j = 2;
          paramJSONObject = "";
          try
          {
            paramString = ((JSONObject)localObject4).getString("channelname");
            paramJSONObject = paramString;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
          }
          ((gc)localObject3).b = paramJSONObject;
          if (((JSONObject)localObject4).has("logo_url"))
          {
            paramJSONObject = ((JSONObject)localObject4).getString("logo_url");
            if (!TextUtils.isEmpty(paramJSONObject)) {
              ((gc)localObject3).d = paramJSONObject;
            }
          }
          localArrayList.add(localObject3);
          break label744;
        }
        paramString = new gc();
        paramString.a = "hfpay";
        paramJSONObject = APTools.f(a.a().b());
        if (localArrayList.contains(paramString))
        {
          paramString = APDataReportManager.getInstance();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("hfpay=1&mccmnc=");
          ((StringBuilder)localObject2).append(paramJSONObject);
          paramString.a("sdk.channel.exist", ((StringBuilder)localObject2).toString());
          paramString = APDataReportManager.getInstance();
          i = ed.b().g();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("hfpay=1&mccmnc=");
          ((StringBuilder)localObject2).append(paramJSONObject);
          paramString.insertData("sdk.channel.exist", i, "", "", ((StringBuilder)localObject2).toString());
        }
        else
        {
          paramString = APDataReportManager.getInstance();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("hfpay=0&mccmnc=");
          ((StringBuilder)localObject2).append(paramJSONObject);
          paramString.a("sdk.channel.exist", ((StringBuilder)localObject2).toString());
          paramString = APDataReportManager.getInstance();
          i = ed.b().g();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("hfpay=0&mccmnc=");
          ((StringBuilder)localObject2).append(paramJSONObject);
          paramString.insertData("sdk.channel.exist", i, "", "", ((StringBuilder)localObject2).toString());
        }
        a().b(localArrayList);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      return;
      label737:
      i += 1;
      break;
      label744:
      i += 1;
    }
  }
  
  public String b(String paramString)
  {
    return a(this.d, paramString);
  }
  
  public void b(ArrayList<gc> paramArrayList)
  {
    this.c.clear();
    a(this.c, paramArrayList);
  }
  
  public String c(String paramString)
  {
    return a(this.c, paramString);
  }
  
  public void c()
  {
    a = new ArrayList();
    a.add(new gc("cft", "财付通余额", 2131034198, "", "", "100", "财付通支付", "", 1, false, 1, ""));
    a.add(new gc("qbqd", "Q币", 2131034202, "", "", "100", "Q币支付", "", 1, false, 11, ""));
    a.add(new gc("qdqb", "Q点", 2131034202, "", "", "100", "Q点支付", "", 1, false, 0, ""));
    a.add(new gc("bank", "银行卡快捷支付", 2131034196, "", "", "100", "银行卡支付", "", 1, false, 2, ""));
    a.add(new gc("mcard", "手机充值卡", 2131034201, "", "", "100", "立即支付", "", 1, false, 5, ""));
    a.add(new gc("hfpay", "手机话费", 2131034197, "", "", "100", "立即支付", "", 1, false, 9, ""));
    a.add(new gc("qqcard", "QQ卡", 2131034204, "", "", "100", "立即支付", "", 1, false, 4, ""));
    a.add(new gc("yb", "元宝", 2131034208, "", "", "100", "元宝支付", "", 1, false, 7, ""));
    a.add(new gc("gold_coupons", "金券", 2131034200, "", "", "100", "金券支付", "", 1, false, 10, ""));
    a.add(new gc("friends_pay", "好友代付", 2131034199, "", "", "100", "好友代付", "", 1, false, 14, ""));
    a.add(new gc("wechat", "微信支付", 2131034206, "", "", "100", "微信支付", "", 1, false, 8, ""));
    a.add(new gc("qqwallet", "QQ钱包支付", 2131034203, "", "", "100", "QQ钱包支付", "", 1, false, 13, ""));
    if ((fe.b()) && (fe.a()))
    {
      APDataReportManager.getInstance().insertData("sdk.qqwallet.support", ed.b().n().a.saveType);
      return;
    }
    APDataReportManager.getInstance().insertData("sdk.qqwallet.nosupport", ed.b().n().a.saveType);
  }
  
  public List<gc> d()
  {
    if ((o.a().b()) && (o.a().c()) && (o.a().d())) {
      return c(this.c);
    }
    return this.c;
  }
  
  public gc d(String paramString)
  {
    if ((this.c != null) && (this.c.size() > 0))
    {
      int i = 0;
      while (i < this.c.size())
      {
        gc localgc = (gc)this.c.get(i);
        if (paramString.equals(localgc.a)) {
          return localgc;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public String e(String paramString)
  {
    int i = 0;
    while (i < this.c.size())
    {
      if (((gc)this.c.get(i)).a.equals(paramString)) {
        return ((gc)this.c.get(i)).b;
      }
      i += 1;
    }
    return "";
  }
  
  public List<gc> e()
  {
    if ((o.a().b()) && (o.a().c()) && (o.a().d())) {
      return c(this.d);
    }
    return this.d;
  }
  
  public String f()
  {
    return b.f;
  }
  
  public int g()
  {
    int i = 0;
    while (i < this.c.size())
    {
      gc localgc = (gc)this.c.get(i);
      if (localgc.a.equals("qdqb")) {
        return 0;
      }
      if (localgc.a.equals("qbqd")) {
        return 11;
      }
      i += 1;
    }
    return 0;
  }
  
  public String h()
  {
    new ArrayList();
    int i = ed.b().n().a.saveType;
    List localList;
    if ((i != 2) && (i != 3)) {
      localList = a().d();
    } else {
      localList = a().e();
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
          gc localgc = (gc)localList.get(i);
          if ((localgc == null) || (TextUtils.isEmpty(localgc.a))) {
            break label174;
          }
          localStringBuffer.append(localgc.a);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.gd
 * JD-Core Version:    0.7.0.1
 */