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

public class bs
{
  private static volatile bs a;
  private HashMap<String, br> b = new HashMap();
  private kf c;
  
  public bs()
  {
    d();
  }
  
  public static bs a()
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
      boolean bool = TextUtils.isEmpty(ed.b().f());
      if (bool) {
        return;
      }
      paramArrayList = new kl()
      {
        public void a(jw paramAnonymousjw)
        {
          if (paramAnonymousjw.R() == 0) {
            ag.a(a.a().d).a(paramArrayList);
          }
        }
        
        public void b(jw paramAnonymousjw) {}
        
        public void c(jw paramAnonymousjw) {}
      };
      bool = fp.a().d();
      if (!bool) {
        return;
      }
      this.c.a(new bz(paramString), new by(paramArrayList));
      return;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    br localbr = (br)a.b.get(paramString);
    if (localbr != null)
    {
      localbr.w();
      a.b.remove(paramString);
    }
  }
  
  private void a(jn paramjn, int paramInt1, int paramInt2, String paramString, jo paramjo)
  {
    if (paramjn == null)
    {
      APLog.e("Network-Manager", "Cannot send data report with null request!");
      return;
    }
    Object localObject = paramjn.u();
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
      String str = paramjn.u();
      ((StringBuilder)localObject).append(str.substring(str.lastIndexOf('/') + 1, str.length()));
    }
    catch (Exception localException)
    {
      label105:
      break label105;
    }
    ((StringBuilder)localObject).append(paramjn.u());
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("reqip=");
    ((StringBuilder)localObject).append(paramjn.t());
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("code=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("json=");
    try
    {
      if (TextUtils.isEmpty(paramjo.b))
      {
        ((StringBuilder)localObject).append("norsp");
      }
      else
      {
        paramjo = new JSONObject(paramjo.b);
        if (paramjo.has("ret")) {
          ((StringBuilder)localObject).append(paramjo.getString("ret"));
        } else {
          ((StringBuilder)localObject).append("ok");
        }
      }
    }
    catch (Exception paramjo)
    {
      ((StringBuilder)localObject).append(paramjo.toString());
    }
    catch (JSONException paramjo)
    {
      ((StringBuilder)localObject).append(paramjo.toString());
    }
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("times=");
    ((StringBuilder)localObject).append(paramjn.f);
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("network=");
    ((StringBuilder)localObject).append(APAppDataInterface.singleton().i());
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("errorCode=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("retrytimes=");
    ((StringBuilder)localObject).append(paramjn.i);
    if (paramInt2 == 200) {
      paramjo = "yes";
    } else if (paramjn.j) {
      paramjo = "yes";
    } else {
      paramjo = "no";
    }
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("isresult=");
    ((StringBuilder)localObject).append(paramjo);
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("uuid=");
    ((StringBuilder)localObject).append(fp.a().i());
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("errorMsg=");
    ((StringBuilder)localObject).append(paramString);
    try
    {
      paramjo = Proxy.getDefaultHost();
      paramString = paramjo;
      if (TextUtils.isEmpty(paramjo)) {
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
      ((StringBuilder)localObject).append(paramjn.h);
      ((StringBuilder)localObject).append("&getOutputStreamTime=");
      ((StringBuilder)localObject).append(paramjn.g);
    }
    catch (Exception paramjn)
    {
      paramjn.printStackTrace();
    }
    try
    {
      APDataReportManager.getInstance().insertData("sdk.midas.networkrequest", ed.b().n().a.saveType, null, null, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramjn)
    {
      paramjn.printStackTrace();
      return;
    }
  }
  
  private void d()
  {
    this.c = new kf(new jj()
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
    this.c.a(new kf.b()
    {
      public jy a()
      {
        return new ch();
      }
    });
    this.c.a(a.a().d);
    this.c.a(new kj()
    {
      public void a(jo paramAnonymousjo)
      {
        if (paramAnonymousjo == null)
        {
          APLog.e("Network-Manager", "Cannot handle get key success, response null!");
          return;
        }
        jn localjn = paramAnonymousjo.a();
        if (localjn == null)
        {
          APLog.e("Network-Manager", "Cannot handle get key success, no request in response!");
          return;
        }
        if (!(localjn instanceof jy))
        {
          APLog.e("Network-Manager", "Cannot handle get key success, request type error!");
          return;
        }
        cg.a(paramAnonymousjo, ((jy)localjn).z());
      }
    });
    this.c.b(APAppDataInterface.singleton().a());
    this.c.a(new ki()
    {
      public void a(jn paramAnonymousjn, jo paramAnonymousjo)
      {
        if (paramAnonymousjn != null)
        {
          if (paramAnonymousjo == null) {
            return;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("NetworkNode success: host=");
          localStringBuilder.append(paramAnonymousjn.t());
          APLog.d("Network-Manager", localStringBuilder.toString());
          bt.a(paramAnonymousjn.t(), System.currentTimeMillis(), paramAnonymousjn.f, true);
          if (((paramAnonymousjn instanceof br)) && (((br)paramAnonymousjn).a())) {
            APAppDataInterface.singleton().p(paramAnonymousjn.t());
          }
          bs.a(bs.this, paramAnonymousjn, 0, 200, "", paramAnonymousjo);
          return;
        }
      }
      
      public void b(jn paramAnonymousjn, jo paramAnonymousjo)
      {
        if (paramAnonymousjn != null)
        {
          if (paramAnonymousjo == null) {
            return;
          }
          if (((paramAnonymousjn instanceof br)) && (((br)paramAnonymousjn).a())) {
            APAppDataInterface.singleton().p("");
          }
          String str = "";
          if (paramAnonymousjo.c != null) {
            str = paramAnonymousjo.c.toString();
          }
          bt.a(paramAnonymousjn.t(), System.currentTimeMillis(), paramAnonymousjn.f, false);
          bs.a(bs.this, paramAnonymousjn, APTools.a(paramAnonymousjo.c), APTools.a(paramAnonymousjo), str, paramAnonymousjo);
          return;
        }
      }
    });
    this.c.a(new kf.c()
    {
      public void a(String paramAnonymousString) {}
    });
    kf localkf = this.c;
    String str;
    if (APAppDataInterface.singleton().e().equals("testing")) {
      str = "-----BEGIN CERTIFICATE-----\nMIIB+zCCAWQCCQDnbabaPRGSojANBgkqhkiG9w0BAQUFADBCMQswCQYDVQQGEwJY\nWDEVMBMGA1UEBwwMRGVmYXVsdCBDaXR5MRwwGgYDVQQKDBNEZWZhdWx0IENvbXBh\nbnkgTHRkMB4XDTE3MDYxMjA0NTgxM1oXDTE4MDYxMjA0NTgxM1owQjELMAkGA1UE\nBhMCWFgxFTATBgNVBAcMDERlZmF1bHQgQ2l0eTEcMBoGA1UECgwTRGVmYXVsdCBD\nb21wYW55IEx0ZDCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAtPIG5lntvILM\nKq5DGq6WelrdovgxgwmncBgCsvI/iSzpBrOIXOh/ut+d+/pSUYAN0AadZp2tdb3F\nNS4AZbRhKjBWOuJv+Oj2KpjCW98iymoBbW8CHRHYbdTY/cpbkxPLN7v4bBNA8K2T\nKeRSp+NMHoR3POKos6iiUtVdQw2LP1kCAwEAATANBgkqhkiG9w0BAQUFAAOBgQBt\n03Qe2CVPZqgAAixUw/K3eY1Su7MAsJpgNKH5L9lQ7F6Fop9D3MQ9ku6OGQSRzhZ9\nI85Sw6jnBgmze2vBC5z+OKDgVvCW3AsRdK1YAcNKwxrTjFOw4drtLhk/avv7Gj/8\nS2b6fi3l9JumOBWy3YHaTRzkhE9ejtczdmHjzXLnhQ==\n-----END CERTIFICATE-----\n";
    } else {
      str = "-----BEGIN CERTIFICATE-----\nMIIEDzCCAvegAwIBAgIJAJhHK18zh2o5MA0GCSqGSIb3DQEBBQUAMGIxCzAJBgNV\nBAYTAkNOMRIwEAYDVQQIEwlHdWFuZ2RvbmcxETAPBgNVBAcTCFNoZW56aGVuMRUw\nEwYDVQQKEwxDUGF5IFJvb3QgQ0ExFTATBgNVBAsTDENQYXkgUm9vdCBDQTAeFw0x\nMzEwMzEwNzE1NDVaFw0yMzEwMjkwNzE1NDVaMGIxCzAJBgNVBAYTAkNOMRIwEAYD\nVQQIEwlHdWFuZ2RvbmcxETAPBgNVBAcTCFNoZW56aGVuMRUwEwYDVQQKEwxDUGF5\nIFJvb3QgQ0ExFTATBgNVBAsTDENQYXkgUm9vdCBDQTCCASIwDQYJKoZIhvcNAQEB\nBQADggEPADCCAQoCggEBALKfVOTFtDzHXOl78oi+R1MvJ80GFN/i71zbxpZnLEdz\ny4KIyotmnmt1av8ONC17bYrmHCimwyiMTonme5gBNm83XWPxByAccQbqeBowx+7a\nXUojJQwdykDE1AafiZWdtmI2vq9HGXtmZJWatxda/G3vo1lUpqQeB1juvNVb1flq\n2IZFxGihmV8EDhtTt3gGlaLwmBsI40Et+vJX/XXrd158qF6wmhzztI+obmYEqjJT\nNxor/fOMWXSIZOtvLdAA1fbrH1cMon62v2v2Sx/69KCrV9CgmK3dYJiUaAiv3SYP\n4CB+r8odiulK42QPnVxFbPR0ID8al+fewDomREqt6RkCAwEAAaOBxzCBxDAdBgNV\nHQ4EFgQUFb1Jpcd4xDZYyNLV2D3iV44X9SMwgZQGA1UdIwSBjDCBiYAUFb1Jpcd4\nxDZYyNLV2D3iV44X9SOhZqRkMGIxCzAJBgNVBAYTAkNOMRIwEAYDVQQIEwlHdWFu\nZ2RvbmcxETAPBgNVBAcTCFNoZW56aGVuMRUwEwYDVQQKEwxDUGF5IFJvb3QgQ0Ex\nFTATBgNVBAsTDENQYXkgUm9vdCBDQYIJAJhHK18zh2o5MAwGA1UdEwQFMAMBAf8w\nDQYJKoZIhvcNAQEFBQADggEBAC+WGUZTncBGxgcEfWt3MFOuL1ht3hF03WFx+6wt\n9TyEySEPRrH/g+jNUL9wsdVFztzHcY3iFmtVHqAioGXwz+Kjd7E0iCV1ijNusMv6\nN2MQsZ70JC2mbMewcwK6c2eCGABMD6hV8crTVGe7OIvz4M7mk1hevly0SlxS7Lfc\nF3i2504uOQp9bVpzQMZ++6m7s7KTysostxMsQbuPLN2xTSx+SEzVZQN/oqemSh2F\nJpODYHOnU5wDf5b7UFcZ7jL4FSJWrIfcxlHVZse/kX7e38a9odrFHxmaNhsBWYn0\nLqZpfR9qWZSjihLXz0lPTnB4ZJNVAsP0DfI/veTyoSBkX2g=\n-----END CERTIFICATE-----\n";
    }
    localkf.a(str);
    this.c.a(new kc.c()
    {
      public boolean a(String paramAnonymousString)
      {
        return true;
      }
    });
    this.c.a(new kf.a()
    {
      public int a()
      {
        try
        {
          APAppDataInterface localAPAppDataInterface = APAppDataInterface.singleton();
          int i = fy.a(a.a().d);
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
    this.c.a(new kf.d()
    {
      public int a()
      {
        try
        {
          APAppDataInterface localAPAppDataInterface = APAppDataInterface.singleton();
          int i = fy.a(a.a().d);
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
    this.c.a(new kk()
    {
      public String a()
      {
        return "1.7.1f";
      }
      
      public String b()
      {
        return bt.c();
      }
    });
    this.c.c();
  }
  
  public void a(int paramInt, kl paramkl)
  {
    dg localdg = new dg("normal", paramInt);
    paramkl = new df(paramkl);
    this.c.a(localdg, paramkl);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.c.a(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(MidasActivityAbility paramMidasActivityAbility, kl paramkl)
  {
    paramMidasActivityAbility = new bv(paramMidasActivityAbility);
    paramkl = new bu(paramkl);
    this.c.a(paramMidasActivityAbility, paramkl);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.c.a(paramString1, paramString2, paramString3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, kl paramkl)
  {
    paramString1 = new dk(paramString1, paramString2, paramString3, paramString4, paramString5);
    paramString2 = new dj(paramkl);
    this.c.a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, kl paramkl)
  {
    paramString1 = new du(paramString1, paramString2, paramString3);
    paramString2 = new dt(paramkl);
    this.c.a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, kl paramkl)
  {
    this.c.a(new cb(paramString1, paramString2), new ca(paramkl, "querywxresult"));
  }
  
  public void a(String paramString, kl paramkl)
  {
    if (paramkl == null)
    {
      APLog.e("Network-Manager", "Cannot call buy goods without callback!");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramkl.b(jw.a(22000, "系统繁忙,请稍后再试\n(订单获取失败)"));
      return;
    }
    if (paramString.lastIndexOf("?") <= 0)
    {
      paramkl.b(jw.a(22000, "订单参数错误"));
      return;
    }
    if (paramString.lastIndexOf("token_id=") <= 0)
    {
      paramkl.b(jw.a(22000, "订单参数错误"));
      return;
    }
    this.c.a(new cw(paramString), new cv(paramkl));
  }
  
  public void a(String paramString, kl paramkl, dm.a parama)
  {
    if ((ed.b().n() != null) && (a.a().g != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("net mgr save, channel id = ");
      localStringBuilder.append(paramString);
      APLog.d("Network-Manager", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("net mgr save, risk control soft param = ");
      localStringBuilder.append(parama);
      APLog.d("Network-Manager", localStringBuilder.toString());
      paramString = new dm(paramString, parama);
      this.c.a(paramString, new dl(paramkl));
      return;
    }
    APUICommonMethod.b();
    fm.a(-1, "maybe call multy");
  }
  
  public void a(jy paramjy, jw paramjw)
  {
    this.c.a(paramjy, paramjw);
  }
  
  public void a(kl paramkl)
  {
    if (!(ed.b().n().a instanceof APGameRequest))
    {
      fm.a(12, "访问太频繁了");
      APUICommonMethod.b();
      return;
    }
    this.c.a(new cy(), new cx(paramkl));
  }
  
  public void a(kl paramkl, String paramString)
  {
    paramString = new di("query_pay_receipt", paramString);
    paramkl = new dh(paramkl);
    this.c.a(paramString, paramkl);
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return this.c.a(paramContext, paramString1, paramString2, paramString3);
  }
  
  public void b()
  {
    this.c.c(cu.class.getSimpleName());
    this.c.c(cy.class.getSimpleName());
    this.c.c(cw.class.getSimpleName());
    this.c.c(dc.class.getSimpleName());
    this.c.c(cm.class.getSimpleName());
    this.c.c(cj.class.getSimpleName());
    this.c.c(dm.class.getSimpleName());
    this.c.c(ch.class.getSimpleName());
    this.c.c(cd.class.getSimpleName());
    this.c.c(co.class.getSimpleName());
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
  
  public void b(String paramString1, String paramString2, String paramString3, kl paramkl)
  {
    this.c.a(new cs(paramString1, paramString2, paramString3), new cr(paramkl));
  }
  
  public void b(String paramString1, String paramString2, kl paramkl)
  {
    paramString1 = new do(paramString1, paramString2);
    paramString2 = new dn(paramkl);
    this.c.a(paramString1, paramString2);
  }
  
  public void b(String paramString, kl paramkl)
  {
    if ((!(ed.b().n().a instanceof APMonthRequest)) && (!(ed.b().n().a instanceof APSubscribeRequest)))
    {
      fm.a(12, "访问太频繁了");
      APUICommonMethod.b();
      return;
    }
    this.c.a(new dc(paramString), new db(paramkl));
  }
  
  public void b(kl paramkl)
  {
    co localco = new co();
    this.c.a(localco, new cn(paramkl));
  }
  
  public void b(kl paramkl, String paramString)
  {
    paramString = new di("query_unfinish_receipt", paramString);
    paramkl = new dh(paramkl);
    this.c.a(paramString, paramkl);
  }
  
  public void c()
  {
    APDataReportManager.getInstance().a(new ga()
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
            bs.a(bs.this, paramAnonymousInt1, paramAnonymousBundle, (ArrayList)localObject);
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
  
  public void c(String paramString, kl paramkl)
  {
    this.c.a(new cb(paramString, "0"), new ca(paramkl, "mcardstatus"));
  }
  
  public void c(kl paramkl)
  {
    this.c.a(new cj(), new ci(paramkl));
  }
  
  public void c(kl paramkl, String paramString)
  {
    paramString = new di("finish_receipt", paramString);
    paramkl = new dh(paramkl);
    this.c.a(paramString, paramkl);
  }
  
  public void d(String paramString, kl paramkl)
  {
    this.c.a(new dw(paramString), new dv(paramkl));
  }
  
  public void d(kl paramkl)
  {
    this.c.a(new cb("", "5"), new ca(paramkl, "towxsign"));
  }
  
  public void d(kl paramkl, String paramString)
  {
    paramString = new ea(paramString);
    paramkl = new dz(paramkl);
    this.c.a(paramString, paramkl);
  }
  
  public void e(String paramString, kl paramkl)
  {
    this.c.a(new cl(paramString), new ck(paramkl));
  }
  
  public void e(kl paramkl)
  {
    this.c.a(new cb("", "4"), new ca(paramkl, "towxunsign"));
  }
  
  public void f(String paramString, kl paramkl)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(ed.b().n().a.offerId);
      if (bool) {
        return;
      }
      if (!fp.a().d()) {
        return;
      }
      this.c.a(new bz(paramString), new by(paramkl));
      return;
    }
    catch (Exception paramString)
    {
      paramkl = new StringBuilder();
      paramkl.append("DataReport exception:");
      paramkl.append(paramString.toString());
      APLog.e("Network-Manager", paramkl.toString());
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
  
  public void f(kl paramkl)
  {
    this.c.a(new dq(), new dp(paramkl));
  }
  
  public void g(String paramString, kl paramkl)
  {
    paramString = new ds(paramString);
    paramkl = new dr(paramkl);
    this.c.a(paramString, paramkl);
  }
  
  public void g(kl paramkl)
  {
    dg localdg = new dg("normal");
    paramkl = new df(paramkl);
    this.c.a(localdg, paramkl);
  }
  
  public void h(String paramString, kl paramkl)
  {
    paramString = new cq(paramString, "sp_rollback");
    paramkl = new cp("supercouponsrollback", paramkl);
    this.c.a(paramString, paramkl);
  }
  
  public void h(kl paramkl)
  {
    dg localdg = new dg("portal");
    paramkl = new df(paramkl);
    this.c.a(localdg, paramkl);
  }
  
  public void i(kl paramkl)
  {
    this.c.a(new cd(), new cc(paramkl));
  }
  
  public void j(kl paramkl)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(ed.b().n().a.offerId);
      if (bool) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Get ip list start!");
      localStringBuilder.append(APAppDataInterface.singleton().e());
      APLog.d("Network-Manager", localStringBuilder.toString());
      this.c.a(new cf(), new ce(paramkl));
      return;
    }
    catch (Exception paramkl)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIpList exception:");
      localStringBuilder.append(paramkl.toString());
      APLog.w("APNetworkManager", localStringBuilder.toString());
      return;
      APLog.w("APNetworkManager", "getIpList request or offerid is null");
      return;
    }
    catch (NullPointerException paramkl)
    {
      label117:
      break label117;
    }
  }
  
  public void k(kl paramkl)
  {
    this.c.a(new cq("", "rollback"), new cp("hfcouponsrollback", paramkl));
  }
  
  public void l(kl paramkl)
  {
    this.c.a(new cq("", "goldcoupons_rollback"), new cp("goldcouponsrollback", paramkl));
  }
  
  public void m(kl paramkl)
  {
    dy localdy = new dy();
    paramkl = new dx(paramkl);
    this.c.a(localdy, paramkl);
  }
  
  static class a
  {
    private static final bs a = new bs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.bs
 * JD-Core Version:    0.7.0.1
 */