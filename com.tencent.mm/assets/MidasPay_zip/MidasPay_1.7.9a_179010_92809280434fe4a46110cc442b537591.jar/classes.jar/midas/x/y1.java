package midas.x;

import android.text.TextUtils;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.List;

public class y1
  extends qb
{
  public ArrayList<String> z = new ArrayList();
  
  public y1()
  {
    b("amode", "1");
  }
  
  public final String E()
  {
    ArrayList localArrayList = a2.a(a.r().d);
    localArrayList.add(a2.c());
    localArrayList.addAll(a2.e());
    localArrayList.removeAll(this.z);
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public boolean F()
  {
    return true;
  }
  
  public void a(int paramInt1, int paramInt2, fb paramfb, gb paramgb)
  {
    super.a(paramInt1, paramInt2, paramfb, paramgb);
    Object localObject = paramfb.g();
    paramgb = new StringBuilder();
    paramgb.append("Set retry url, last fail = ");
    paramgb.append((String)localObject);
    APLog.d("NetRequestBase", paramgb.toString());
    this.z.add(localObject);
    int i;
    if (((paramfb instanceof y1)) && (!((y1)paramfb).a(paramInt1, paramInt2))) {
      i = 0;
    } else {
      i = 1;
    }
    paramgb = "";
    if (i == 0)
    {
      paramgb = new StringBuilder();
      paramgb.append("Set retry url, last try with same host: currentRetry = ");
      paramgb.append(paramInt1);
      APLog.d("NetRequestBase", paramgb.toString());
      paramgb = (gb)localObject;
    }
    else
    {
      if ((paramfb instanceof m2))
      {
        localObject = a2.a(a.r().d);
        ((List)localObject).addAll(a2.e());
        ((List)localObject).removeAll(this.z);
        if (((List)localObject).size() > 0) {
          paramgb = (String)((List)localObject).get(0);
        }
        localObject = paramgb;
        if (TextUtils.isEmpty(paramgb))
        {
          paramgb = a2.c();
          break label288;
        }
      }
      else
      {
        if (paramInt1 < paramInt2)
        {
          APLog.d("NetRequestBase", "Set retry url, not last try");
          localObject = E();
          paramgb = (gb)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break label288;
          }
          paramgb = a2.c();
          break label288;
        }
        localObject = paramgb;
        if (paramInt1 == paramInt2)
        {
          APLog.d("NetRequestBase", "Set retry url, last try");
          paramgb = a2.c();
          break label288;
        }
      }
      paramgb = (gb)localObject;
    }
    label288:
    if (TextUtils.isEmpty(paramgb))
    {
      APLog.e("NetRequestBase", "Set retry url, last try, Cannot get current env domain");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("midasHttpURL() onHttpRetry ip = ");
    ((StringBuilder)localObject).append(paramgb);
    APLog.d("NetRequestBase", ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramgb))
    {
      if (paramfb.m())
      {
        if (m6.a(paramgb))
        {
          APLog.d("NetRequestBase", "Set retry url, is https and ip, use 442");
          localObject = "442";
        }
        else
        {
          APLog.d("NetRequestBase", "Set retry url, is https and not ip, use 443");
          localObject = "443";
        }
      }
      else
      {
        APLog.d("NetRequestBase", "Set retry url, not https, use 80");
        localObject = "80";
      }
      paramfb.b(paramgb);
      paramfb.c((String)localObject);
      return;
    }
    APLog.e("NetRequestBase", "Set retry url, finally empty");
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    b(null, paramString1, paramString2, paramString3);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString3)) {
      APLog.e("NetRequestBase", "Setting a empty http url suffix!");
    }
    if (TextUtils.isEmpty(paramString2)) {
      APLog.e("NetRequestBase", "Setting a empty http url schema!");
    }
    if (TextUtils.isEmpty(paramString4)) {
      APLog.e("NetRequestBase", "Setting a empty http url port!");
    }
    paramString4 = paramString1;
    if (APAppDataInterface.singleton().h().equals("dev")) {
      paramString4 = a2.c();
    }
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4))
    {
      paramString1 = new StringBuilder();
      paramString1.append("midasHttpURL() isHoldSuccessHost before ip = ");
      paramString1.append(APAppDataInterface.singleton().w());
      APLog.w("NetRequestBase", paramString1.toString());
      paramString1 = a2.a(a.r().d);
      if ((F()) && (!TextUtils.isEmpty(APAppDataInterface.singleton().w())))
      {
        paramString1 = APAppDataInterface.singleton().w();
        paramString4 = new StringBuilder();
        paramString4.append("midasHttpURL() isHoldSuccessHost ip = ");
        paramString4.append(paramString1);
        APLog.d("NetRequestBase", paramString4.toString());
      }
      else
      {
        paramString1.add(a2.c());
        paramString1 = (String)paramString1.get(0);
        paramString4 = new StringBuilder();
        paramString4.append("midasHttpURL() getIPs ip = ");
        paramString4.append(paramString1);
        APLog.d("NetRequestBase", paramString4.toString());
      }
    }
    if ("https".equals(paramString2))
    {
      if (m6.a(paramString1))
      {
        APLog.d("NetRequestBase", "Set midas url, is https ip, use 442");
        paramString4 = "442";
      }
      else
      {
        APLog.d("NetRequestBase", "Set midas url, is https not ip, use 443");
        paramString4 = "443";
      }
    }
    else
    {
      APLog.d("NetRequestBase", "Set midas url, not https, use 80");
      paramString4 = "80";
    }
    paramString1 = new za(paramString2, paramString1);
    paramString1.c = paramString3;
    paramString1.b = paramString4;
    a(paramString1);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((!APAppDataInterface.singleton().h().equals("release")) && (APAppDataInterface.singleton().E()))
    {
      APLog.d("NetRequestBase", "Set midas url, use http & 80 for test");
      a(paramString1, "http", paramString3, "80");
      return;
    }
    a(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void f(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      APLog.e("NetRequestBase", "Setting a empty http url suffix!");
    }
    if (TextUtils.isEmpty(paramString1)) {
      APLog.e("NetRequestBase", "Setting a empty http url schema!");
    }
    if ("https".equals(paramString1))
    {
      a(paramString1, paramString2, "443");
      APLog.d("NetRequestBase", "Set midas url is https use 443");
      return;
    }
    a(paramString1, paramString2, "80");
    APLog.d("NetRequestBase", "Set midas url not https use 80");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.y1
 * JD-Core Version:    0.7.0.1
 */