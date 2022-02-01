package midas.x;

import android.content.Context;
import android.net.Proxy;
import android.os.Bundle;
import android.text.TextUtils;
import com.pay.api.ability.MidasActivityAbility;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APGameRequest;
import com.pay.api.request.APMonthRequest;
import com.pay.api.request.APSubscribeRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class by
{
  private static volatile by a;
  private HashMap<String, bx> b = new HashMap();
  private lq c;
  
  public by()
  {
    d();
  }
  
  public static by a()
  {
    if (a == null) {
      a = a.a();
    }
    return a;
  }
  
  private void a(int paramInt, String paramString, final ArrayList<ak> paramArrayList)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stemp == ");
      localStringBuilder.append(paramString);
      APLog.d("上报准备  dataReportDelete ", localStringBuilder.toString());
      if (paramArrayList != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("itemList == ");
        localStringBuilder.append(paramArrayList.toString());
        APLog.d("上报准备  dataReportDelete ", localStringBuilder.toString());
      }
      boolean bool = TextUtils.isEmpty(em.b().f());
      if (bool) {
        return;
      }
      paramArrayList = new lw()
      {
        public void a(lh paramAnonymouslh)
        {
          if (paramAnonymouslh.T() == 0) {
            ag.a(a.a().d).a(paramArrayList);
          }
        }
        
        public void b(lh paramAnonymouslh) {}
        
        public void c(lh paramAnonymouslh) {}
      };
      bool = fy.a().d();
      if (!bool) {
        return;
      }
      this.c.a(new cf(paramString), new ce(paramArrayList));
      return;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    bx localbx = (bx)a.b.get(paramString);
    if (localbx != null)
    {
      localbx.w();
      a.b.remove(paramString);
    }
  }
  
  private void a(ky paramky, int paramInt1, int paramInt2, String paramString, kz paramkz)
  {
    if (paramky == null)
    {
      APLog.e("Network-Manager", "Cannot send data report with null request!");
      return;
    }
    Object localObject = paramky.u();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      APLog.e("Network-Manager", "Suffix is empty while sending data report!");
    }
    else if (((String)localObject).endsWith("log_data"))
    {
      APLog.d("Network-Manager", "Current request is data report, no need to send data report!");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("name=");
    try
    {
      String str = paramky.u();
      ((StringBuilder)localObject).append(str.substring(str.lastIndexOf('/') + 1, str.length()));
    }
    catch (Exception localException)
    {
      label105:
      break label105;
    }
    ((StringBuilder)localObject).append(paramky.u());
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("reqip=");
    ((StringBuilder)localObject).append(paramky.t());
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("code=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("json=");
    try
    {
      if (TextUtils.isEmpty(paramkz.b))
      {
        ((StringBuilder)localObject).append("norsp");
      }
      else
      {
        paramkz = new JSONObject(paramkz.b);
        if (paramkz.has("ret")) {
          ((StringBuilder)localObject).append(paramkz.getString("ret"));
        } else {
          ((StringBuilder)localObject).append("ok");
        }
      }
    }
    catch (Exception paramkz)
    {
      ((StringBuilder)localObject).append(paramkz.toString());
    }
    catch (JSONException paramkz)
    {
      ((StringBuilder)localObject).append(paramkz.toString());
    }
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("times=");
    ((StringBuilder)localObject).append(paramky.f);
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("network=");
    ((StringBuilder)localObject).append(APAppDataInterface.singleton().i());
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("errorCode=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("retrytimes=");
    ((StringBuilder)localObject).append(paramky.i);
    if (paramInt2 == 200) {
      paramkz = "yes";
    } else if (paramky.j) {
      paramkz = "yes";
    } else {
      paramkz = "no";
    }
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("isresult=");
    ((StringBuilder)localObject).append(paramkz);
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("uuid=");
    ((StringBuilder)localObject).append(fy.a().i());
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("errorMsg=");
    ((StringBuilder)localObject).append(paramString);
    try
    {
      paramkz = Proxy.getDefaultHost();
      paramString = paramkz;
      if (TextUtils.isEmpty(paramkz)) {
        paramString = "";
      }
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append("proxyip=");
      ((StringBuilder)localObject).append(paramString);
      paramInt1 = Proxy.getDefaultPort();
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append("proxyport=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("&getInputStreamTime=");
      ((StringBuilder)localObject).append(paramky.h);
      ((StringBuilder)localObject).append("&getOutputStreamTime=");
      ((StringBuilder)localObject).append(paramky.g);
    }
    catch (Exception paramky)
    {
      paramky.printStackTrace();
    }
    try
    {
      APDataReportManager.getInstance().insertData("sdk.midas.networkrequest", em.b().n().a.saveType, null, null, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramky)
    {
      paramky.printStackTrace();
      return;
    }
  }
  
  private void d()
  {
    this.c = new lq(new ku()
    {
      public void a(String paramAnonymousString1, String paramAnonymousString2)
      {
        APLog.e(paramAnonymousString1, paramAnonymousString2);
      }
      
      public void b(String paramAnonymousString1, String paramAnonymousString2)
      {
        APLog.d(paramAnonymousString1, paramAnonymousString2);
      }
      
      public void c(String paramAnonymousString1, String paramAnonymousString2)
      {
        APLog.w(paramAnonymousString1, paramAnonymousString2);
      }
    });
    this.c.a(new lq.b()
    {
      public lj a()
      {
        return new cn();
      }
    });
    this.c.a(a.a().d);
    this.c.a(new lu()
    {
      public void a(kz paramAnonymouskz)
      {
        if (paramAnonymouskz == null)
        {
          APLog.e("Network-Manager", "Cannot handle get key success, response null!");
          return;
        }
        ky localky = paramAnonymouskz.a();
        if (localky == null)
        {
          APLog.e("Network-Manager", "Cannot handle get key success, no request in response!");
          return;
        }
        if (!(localky instanceof lj))
        {
          APLog.e("Network-Manager", "Cannot handle get key success, request type error!");
          return;
        }
        cm.a(paramAnonymouskz, ((lj)localky).z());
      }
    });
    this.c.b(APAppDataInterface.singleton().a());
    this.c.a(new lt()
    {
      public void a(ky paramAnonymousky, kz paramAnonymouskz)
      {
        if (paramAnonymousky != null)
        {
          if (paramAnonymouskz == null) {
            return;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("NetworkNode success: host=");
          localStringBuilder.append(paramAnonymousky.t());
          APLog.d("Network-Manager", localStringBuilder.toString());
          bz.a(paramAnonymousky.t(), System.currentTimeMillis(), paramAnonymousky.f, true);
          if (((paramAnonymousky instanceof bx)) && (((bx)paramAnonymousky).a())) {
            APAppDataInterface.singleton().p(paramAnonymousky.t());
          }
          by.a(by.this, paramAnonymousky, 0, 200, "", paramAnonymouskz);
          return;
        }
      }
      
      public void b(ky paramAnonymousky, kz paramAnonymouskz)
      {
        if (paramAnonymousky != null)
        {
          if (paramAnonymouskz == null) {
            return;
          }
          if (((paramAnonymousky instanceof bx)) && (((bx)paramAnonymousky).a())) {
            APAppDataInterface.singleton().p("");
          }
          String str = "";
          if (paramAnonymouskz.c != null) {
            str = paramAnonymouskz.c.toString();
          }
          bz.a(paramAnonymousky.t(), System.currentTimeMillis(), paramAnonymousky.f, false);
          by.a(by.this, paramAnonymousky, APTools.a(paramAnonymouskz.c), APTools.a(paramAnonymouskz), str, paramAnonymouskz);
          return;
        }
      }
    });
    this.c.a(new lq.c()
    {
      public void a(String paramAnonymousString) {}
    });
    lq locallq = this.c;
    String str;
    if (APAppDataInterface.singleton().e().equals("testing")) {
      str = "-----BEGIN CERTIFICATE-----\nMIIB+zCCAWQCCQDnbabaPRGSojANBgkqhkiG9w0BAQUFADBCMQswCQYDVQQGEwJY\nWDEVMBMGA1UEBwwMRGVmYXVsdCBDaXR5MRwwGgYDVQQKDBNEZWZhdWx0IENvbXBh\nbnkgTHRkMB4XDTE3MDYxMjA0NTgxM1oXDTE4MDYxMjA0NTgxM1owQjELMAkGA1UE\nBhMCWFgxFTATBgNVBAcMDERlZmF1bHQgQ2l0eTEcMBoGA1UECgwTRGVmYXVsdCBD\nb21wYW55IEx0ZDCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAtPIG5lntvILM\nKq5DGq6WelrdovgxgwmncBgCsvI/iSzpBrOIXOh/ut+d+/pSUYAN0AadZp2tdb3F\nNS4AZbRhKjBWOuJv+Oj2KpjCW98iymoBbW8CHRHYbdTY/cpbkxPLN7v4bBNA8K2T\nKeRSp+NMHoR3POKos6iiUtVdQw2LP1kCAwEAATANBgkqhkiG9w0BAQUFAAOBgQBt\n03Qe2CVPZqgAAixUw/K3eY1Su7MAsJpgNKH5L9lQ7F6Fop9D3MQ9ku6OGQSRzhZ9\nI85Sw6jnBgmze2vBC5z+OKDgVvCW3AsRdK1YAcNKwxrTjFOw4drtLhk/avv7Gj/8\nS2b6fi3l9JumOBWy3YHaTRzkhE9ejtczdmHjzXLnhQ==\n-----END CERTIFICATE-----\n";
    } else {
      str = "-----BEGIN CERTIFICATE-----\nMIIEDzCCAvegAwIBAgIJAJhHK18zh2o5MA0GCSqGSIb3DQEBBQUAMGIxCzAJBgNV\nBAYTAkNOMRIwEAYDVQQIEwlHdWFuZ2RvbmcxETAPBgNVBAcTCFNoZW56aGVuMRUw\nEwYDVQQKEwxDUGF5IFJvb3QgQ0ExFTATBgNVBAsTDENQYXkgUm9vdCBDQTAeFw0x\nMzEwMzEwNzE1NDVaFw0yMzEwMjkwNzE1NDVaMGIxCzAJBgNVBAYTAkNOMRIwEAYD\nVQQIEwlHdWFuZ2RvbmcxETAPBgNVBAcTCFNoZW56aGVuMRUwEwYDVQQKEwxDUGF5\nIFJvb3QgQ0ExFTATBgNVBAsTDENQYXkgUm9vdCBDQTCCASIwDQYJKoZIhvcNAQEB\nBQADggEPADCCAQoCggEBALKfVOTFtDzHXOl78oi+R1MvJ80GFN/i71zbxpZnLEdz\ny4KIyotmnmt1av8ONC17bYrmHCimwyiMTonme5gBNm83XWPxByAccQbqeBowx+7a\nXUojJQwdykDE1AafiZWdtmI2vq9HGXtmZJWatxda/G3vo1lUpqQeB1juvNVb1flq\n2IZFxGihmV8EDhtTt3gGlaLwmBsI40Et+vJX/XXrd158qF6wmhzztI+obmYEqjJT\nNxor/fOMWXSIZOtvLdAA1fbrH1cMon62v2v2Sx/69KCrV9CgmK3dYJiUaAiv3SYP\n4CB+r8odiulK42QPnVxFbPR0ID8al+fewDomREqt6RkCAwEAAaOBxzCBxDAdBgNV\nHQ4EFgQUFb1Jpcd4xDZYyNLV2D3iV44X9SMwgZQGA1UdIwSBjDCBiYAUFb1Jpcd4\nxDZYyNLV2D3iV44X9SOhZqRkMGIxCzAJBgNVBAYTAkNOMRIwEAYDVQQIEwlHdWFu\nZ2RvbmcxETAPBgNVBAcTCFNoZW56aGVuMRUwEwYDVQQKEwxDUGF5IFJvb3QgQ0Ex\nFTATBgNVBAsTDENQYXkgUm9vdCBDQYIJAJhHK18zh2o5MAwGA1UdEwQFMAMBAf8w\nDQYJKoZIhvcNAQEFBQADggEBAC+WGUZTncBGxgcEfWt3MFOuL1ht3hF03WFx+6wt\n9TyEySEPRrH/g+jNUL9wsdVFztzHcY3iFmtVHqAioGXwz+Kjd7E0iCV1ijNusMv6\nN2MQsZ70JC2mbMewcwK6c2eCGABMD6hV8crTVGe7OIvz4M7mk1hevly0SlxS7Lfc\nF3i2504uOQp9bVpzQMZ++6m7s7KTysostxMsQbuPLN2xTSx+SEzVZQN/oqemSh2F\nJpODYHOnU5wDf5b7UFcZ7jL4FSJWrIfcxlHVZse/kX7e38a9odrFHxmaNhsBWYn0\nLqZpfR9qWZSjihLXz0lPTnB4ZJNVAsP0DfI/veTyoSBkX2g=\n-----END CERTIFICATE-----\n";
    }
    locallq.a(str);
    this.c.a(new ln.c()
    {
      public boolean a(String paramAnonymousString)
      {
        return true;
      }
    });
    this.c.a(new lq.a()
    {
      public int a()
      {
        try
        {
          APAppDataInterface localAPAppDataInterface = APAppDataInterface.singleton();
          int i = gi.a(a.a().d);
          if (i != -1) {
            if (i == 1000) {}
          }
          switch (i)
          {
          case 3: 
            i = localAPAppDataInterface.v();
            break;
          case 4: 
            i = localAPAppDataInterface.u();
            break;
          case 1: 
          case 2: 
            i = localAPAppDataInterface.w();
            return i;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return 15000;
        }
        return 15000;
      }
    });
    this.c.a(new lq.d()
    {
      public int a()
      {
        try
        {
          APAppDataInterface localAPAppDataInterface = APAppDataInterface.singleton();
          int i = gi.a(a.a().d);
          if (i != -1) {
            if (i == 1000) {}
          }
          switch (i)
          {
          case 3: 
            i = localAPAppDataInterface.v();
            break;
          case 4: 
            i = localAPAppDataInterface.u();
            break;
          case 1: 
          case 2: 
            i = localAPAppDataInterface.w();
            return i;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return 15000;
        }
        return 15000;
      }
    });
    this.c.a(new lv()
    {
      public String a()
      {
        return "1.7.4";
      }
      
      public String b()
      {
        return bz.c();
      }
    });
    this.c.c();
  }
  
  public void a(int paramInt, lw paramlw)
  {
    do localdo = new do("normal", paramInt);
    paramlw = new dn(paramlw);
    this.c.a(localdo, paramlw);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.c.a(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(MidasActivityAbility paramMidasActivityAbility, lw paramlw)
  {
    paramMidasActivityAbility = new cb(paramMidasActivityAbility);
    paramlw = new ca(paramlw);
    this.c.a(paramMidasActivityAbility, paramlw);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.c.a(paramString1, paramString2, paramString3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, lw paramlw)
  {
    paramString1 = new ds(paramString1, paramString2, paramString3, paramString4, paramString5);
    paramString2 = new dr(paramlw);
    this.c.a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, lw paramlw)
  {
    paramString1 = new ec(paramString1, paramString2, paramString3);
    paramString2 = new eb(paramlw);
    this.c.a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, lw paramlw)
  {
    this.c.a(new dm(paramString1, paramString2), new dl(paramlw));
  }
  
  public void a(String paramString, lw paramlw)
  {
    if (paramlw == null)
    {
      APLog.e("Network-Manager", "Cannot call buy goods without callback!");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramlw.b(lh.a(22000, "系统繁忙,请稍后再试\n(订单获取失败)"));
      return;
    }
    if (paramString.lastIndexOf("?") <= 0)
    {
      paramlw.b(lh.a(22000, "订单参数错误"));
      return;
    }
    if (paramString.lastIndexOf("token_id=") <= 0)
    {
      paramlw.b(lh.a(22000, "订单参数错误"));
      return;
    }
    this.c.a(new dc(paramString), new db(paramlw));
  }
  
  public void a(String paramString, lw paramlw, du.a parama)
  {
    if ((em.b().n() != null) && (a.a().g != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("net mgr save, channel id = ");
      localStringBuilder.append(paramString);
      APLog.d("Network-Manager", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("net mgr save, risk control soft param = ");
      localStringBuilder.append(parama);
      APLog.d("Network-Manager", localStringBuilder.toString());
      paramString = new du(paramString, parama);
      this.c.a(paramString, new dt(paramlw));
      return;
    }
    APUICommonMethod.b();
    fv.a(-1, "maybe call multy");
  }
  
  public void a(lj paramlj, lh paramlh)
  {
    this.c.a(paramlj, paramlh);
  }
  
  public void a(lw paramlw)
  {
    if (!(em.b().n().a instanceof APGameRequest))
    {
      fv.a(12, "访问太频繁了");
      APUICommonMethod.b();
      return;
    }
    this.c.a(new de(), new dd(paramlw));
  }
  
  public void a(lw paramlw, String paramString)
  {
    paramString = new dq("query_pay_receipt", paramString);
    paramlw = new dp(paramlw);
    this.c.a(paramString, paramlw);
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return this.c.a(paramContext, paramString1, paramString2, paramString3);
  }
  
  public void b()
  {
    this.c.c(da.class.getSimpleName());
    this.c.c(de.class.getSimpleName());
    this.c.c(dc.class.getSimpleName());
    this.c.c(di.class.getSimpleName());
    this.c.c(cs.class.getSimpleName());
    this.c.c(cp.class.getSimpleName());
    this.c.c(du.class.getSimpleName());
    this.c.c(cn.class.getSimpleName());
    this.c.c(cj.class.getSimpleName());
    this.c.c(cu.class.getSimpleName());
  }
  
  public void b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.c.d(paramContext, paramString1, paramString2, paramString3);
  }
  
  public void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.c.b(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void b(String paramString)
  {
    this.c.c(paramString);
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      APLog.e("Network-Manager", "Try to set sec key to ram without open id!");
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      APLog.e("Network-Manager", "Try to set sec key to ram without offer id!");
      return;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      APLog.e("Network-Manager", "Try to set empty sec key to ram!");
      return;
    }
    this.c.b(paramString1, paramString2, paramString3);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, lw paramlw)
  {
    this.c.a(new cy(paramString1, paramString2, paramString3), new cx(paramlw));
  }
  
  public void b(String paramString1, String paramString2, lw paramlw)
  {
    this.c.a(new ch(paramString1, paramString2), new cg(paramlw, "querywxresult"));
  }
  
  public void b(String paramString, lw paramlw)
  {
    if ((!(em.b().n().a instanceof APMonthRequest)) && (!(em.b().n().a instanceof APSubscribeRequest)))
    {
      fv.a(12, "访问太频繁了");
      APUICommonMethod.b();
      return;
    }
    this.c.a(new di(paramString), new dh(paramlw));
  }
  
  public void b(lw paramlw)
  {
    cu localcu = new cu();
    this.c.a(localcu, new ct(paramlw));
  }
  
  public void b(lw paramlw, String paramString)
  {
    paramString = new dq("query_unfinish_receipt", paramString);
    paramlw = new dp(paramlw);
    this.c.a(paramString, paramlw);
  }
  
  public void c()
  {
    APDataReportManager.getInstance().a(new gk()
    {
      public void a(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject, Bundle paramAnonymousBundle)
      {
        if (paramAnonymousInt1 != 0)
        {
          APLog.e("Network-Manager", "Cannot get data report records, cannot data report!");
          return;
        }
        paramAnonymousObject = (ArrayList)paramAnonymousObject;
        if (paramAnonymousObject == null)
        {
          APLog.e("Network-Manager", "Cannot get data report records, cannot data report!");
          return;
        }
        paramAnonymousInt2 = paramAnonymousObject.size();
        if (paramAnonymousInt2 <= 0)
        {
          APLog.e("Network-Manager", "Got 0 report record, cannot data report!");
          return;
        }
        paramAnonymousBundle = new StringBuilder();
        paramAnonymousBundle.append("Report record num = ");
        paramAnonymousBundle.append(paramAnonymousInt2);
        APLog.d("Network-Manager", paramAnonymousBundle.toString());
        paramAnonymousInt1 = 0;
        while (paramAnonymousInt1 < paramAnonymousInt2)
        {
          Object localObject = (aj)paramAnonymousObject.get(paramAnonymousInt1);
          if (localObject == null)
          {
            APLog.e("Network-Manager", "Got null report record!");
          }
          else
          {
            paramAnonymousBundle = ((aj)localObject).a;
            localObject = ((aj)localObject).b;
            by.a(by.this, paramAnonymousInt1, paramAnonymousBundle, (ArrayList)localObject);
          }
          paramAnonymousInt1 += 1;
        }
      }
    });
  }
  
  public void c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.c.c(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void c(String paramString1, String paramString2, String paramString3)
  {
    this.c.c(paramString1, paramString2, paramString3);
  }
  
  public void c(String paramString1, String paramString2, lw paramlw)
  {
    paramString1 = new dw(paramString1, paramString2);
    paramString2 = new dv(paramlw);
    this.c.a(paramString1, paramString2);
  }
  
  public void c(String paramString, lw paramlw)
  {
    this.c.a(new ch(paramString, "0"), new cg(paramlw, "mcardstatus"));
  }
  
  public void c(lw paramlw)
  {
    this.c.a(new cp(), new co(paramlw));
  }
  
  public void c(lw paramlw, String paramString)
  {
    paramString = new dq("finish_receipt", paramString);
    paramlw = new dp(paramlw);
    this.c.a(paramString, paramlw);
  }
  
  public void d(String paramString, lw paramlw)
  {
    this.c.a(new ee(paramString), new ed(paramlw));
  }
  
  public void d(lw paramlw)
  {
    this.c.a(new ch("", "5"), new cg(paramlw, "towxsign"));
  }
  
  public void d(lw paramlw, String paramString)
  {
    paramString = new ej(paramString);
    paramlw = new ei(paramlw);
    this.c.a(paramString, paramlw);
  }
  
  public void e(String paramString, lw paramlw)
  {
    this.c.a(new cr(paramString), new cq(paramlw));
  }
  
  public void e(lw paramlw)
  {
    this.c.a(new ch("", "4"), new cg(paramlw, "towxunsign"));
  }
  
  public void f(String paramString, lw paramlw)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(em.b().n().a.offerId);
      if (bool) {
        return;
      }
      if (!fy.a().d()) {
        return;
      }
      this.c.a(new cf(paramString), new ce(paramlw));
      return;
    }
    catch (Exception paramString)
    {
      paramlw = new StringBuilder();
      paramlw.append("DataReport exception:");
      paramlw.append(paramString.toString());
      APLog.e("Network-Manager", paramlw.toString());
      return;
      APLog.e("Network-Manager", "DataReport request or offerid is null");
      return;
    }
    catch (NullPointerException paramString)
    {
      label91:
      break label91;
    }
  }
  
  public void f(lw paramlw)
  {
    this.c.a(new dy(), new dx(paramlw));
  }
  
  public void g(String paramString, lw paramlw)
  {
    paramString = new ea(paramString);
    paramlw = new dz(paramlw);
    this.c.a(paramString, paramlw);
  }
  
  public void g(lw paramlw)
  {
    do localdo = new do("normal");
    paramlw = new dn(paramlw);
    this.c.a(localdo, paramlw);
  }
  
  public void h(String paramString, lw paramlw)
  {
    paramString = new cw(paramString, "sp_rollback");
    paramlw = new cv("supercouponsrollback", paramlw);
    this.c.a(paramString, paramlw);
  }
  
  public void h(lw paramlw)
  {
    do localdo = new do("portal");
    paramlw = new dn(paramlw);
    this.c.a(localdo, paramlw);
  }
  
  public void i(lw paramlw)
  {
    this.c.a(new cj(), new ci(paramlw));
  }
  
  public void j(lw paramlw)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(em.b().n().a.offerId);
      if (bool) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Get ip list start!");
      localStringBuilder.append(APAppDataInterface.singleton().e());
      APLog.d("Network-Manager", localStringBuilder.toString());
      this.c.a(new cl(), new ck(paramlw));
      return;
    }
    catch (Exception paramlw)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIpList exception:");
      localStringBuilder.append(paramlw.toString());
      APLog.w("APNetworkManager", localStringBuilder.toString());
      return;
      APLog.w("APNetworkManager", "getIpList request or offerid is null");
      return;
    }
    catch (NullPointerException paramlw)
    {
      label117:
      break label117;
    }
  }
  
  public void k(lw paramlw)
  {
    this.c.a(new cw("", "rollback"), new cv("hfcouponsrollback", paramlw));
  }
  
  public void l(lw paramlw)
  {
    this.c.a(new cw("", "goldcoupons_rollback"), new cv("goldcouponsrollback", paramlw));
  }
  
  public void m(lw paramlw)
  {
    eh localeh = new eh();
    paramlw = new eg(paramlw);
    this.c.a(localeh, paramlw);
  }
  
  static class a
  {
    private static final by a = new by();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.by
 * JD-Core Version:    0.7.0.1
 */