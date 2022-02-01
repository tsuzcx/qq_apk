package midas.x;

import android.text.TextUtils;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.List;

public class br
  extends jy
{
  private ArrayList<String> a = new ArrayList();
  
  public br()
  {
    e("amode", "1");
  }
  
  private void b(String paramString1, String paramString2, String paramString3, String paramString4)
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
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = new StringBuilder();
      paramString1.append("midasHttpURL() isHoldSuccessHost before ip = ");
      paramString1.append(APAppDataInterface.singleton().E());
      APLog.w("NetRequestBase", paramString1.toString());
      paramString1 = bt.b(a.a().d);
      if ((a()) && (!TextUtils.isEmpty(APAppDataInterface.singleton().E())))
      {
        paramString4 = APAppDataInterface.singleton().E();
        paramString1 = new StringBuilder();
        paramString1.append("midasHttpURL() isHoldSuccessHost ip = ");
        paramString1.append(paramString4);
        APLog.d("NetRequestBase", paramString1.toString());
      }
      else
      {
        paramString1.add(bt.c());
        paramString4 = (String)paramString1.get(0);
        paramString1 = new StringBuilder();
        paramString1.append("midasHttpURL() getIPs ip = ");
        paramString1.append(paramString4);
        APLog.d("NetRequestBase", paramString1.toString());
      }
    }
    if ("https".equals(paramString2))
    {
      if (fy.b(paramString4))
      {
        paramString1 = "442";
        APLog.d("NetRequestBase", "Set midas url, is https ip, use 442");
      }
      else
      {
        APLog.d("NetRequestBase", "Set midas url, is https not ip, use 443");
        paramString1 = "443";
      }
    }
    else
    {
      APLog.d("NetRequestBase", "Set midas url, not https, use 80");
      paramString1 = "80";
    }
    paramString2 = new ji(paramString2, paramString4);
    paramString2.c = paramString3;
    paramString2.b = paramString1;
    a(paramString2);
  }
  
  private String c()
  {
    ArrayList localArrayList = bt.b(a.a().d);
    localArrayList.add(bt.c());
    localArrayList.addAll(bt.b());
    localArrayList.removeAll(this.a);
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public void a(int paramInt1, int paramInt2, jn paramjn, jo paramjo)
  {
    super.a(paramInt1, paramInt2, paramjn, paramjo);
    Object localObject = paramjn.t();
    paramjo = new StringBuilder();
    paramjo.append("Set retry url, last fail = ");
    paramjo.append((String)localObject);
    APLog.d("NetRequestBase", paramjo.toString());
    this.a.add(localObject);
    int i;
    if (((paramjn instanceof br)) && (!((br)paramjn).a(paramInt1, paramInt2))) {
      i = 0;
    } else {
      i = 1;
    }
    paramjo = "";
    if (i == 0)
    {
      paramjo = new StringBuilder();
      paramjo.append("Set retry url, last try with same host: currentRetry = ");
      paramjo.append(paramInt1);
      APLog.d("NetRequestBase", paramjo.toString());
      paramjo = (jo)localObject;
    }
    else
    {
      if ((paramjn instanceof cf))
      {
        localObject = bt.b(a.a().d);
        ((List)localObject).addAll(bt.b());
        ((List)localObject).removeAll(this.a);
        if (((List)localObject).size() > 0) {
          paramjo = (String)((List)localObject).get(0);
        }
        localObject = paramjo;
        if (TextUtils.isEmpty(paramjo))
        {
          paramjo = bt.c();
          break label288;
        }
      }
      else
      {
        if (paramInt1 < paramInt2)
        {
          APLog.d("NetRequestBase", "Set retry url, not last try");
          localObject = c();
          paramjo = (jo)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break label288;
          }
          paramjo = bt.c();
          break label288;
        }
        localObject = paramjo;
        if (paramInt1 == paramInt2)
        {
          APLog.d("NetRequestBase", "Set retry url, last try");
          paramjo = bt.c();
          break label288;
        }
      }
      paramjo = (jo)localObject;
    }
    label288:
    if (TextUtils.isEmpty(paramjo))
    {
      APLog.e("NetRequestBase", "Set retry url, last try, Cannot get current env domain");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("midasHttpURL() onHttpRetry ip = ");
    ((StringBuilder)localObject).append(paramjo);
    APLog.d("NetRequestBase", ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramjo))
    {
      if (paramjn.n())
      {
        if (fy.b(paramjo))
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
      paramjn.c(paramjo);
      paramjn.d((String)localObject);
      return;
    }
    APLog.e("NetRequestBase", "Set retry url, finally empty");
  }
  
  protected void a(String paramString1, String paramString2)
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
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    a(null, paramString1, paramString2, paramString3);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((!APAppDataInterface.singleton().e().equals("release")) && (APAppDataInterface.singleton().y()))
    {
      APLog.d("NetRequestBase", "Set midas url, use http & 80 for test");
      b(paramString1, "http", paramString3, "80");
      return;
    }
    b(paramString1, paramString2, paramString3, paramString4);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.br
 * JD-Core Version:    0.7.0.1
 */