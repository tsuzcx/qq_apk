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

public class z1
{
  public static volatile z1 c;
  public HashMap<String, y1> a = new HashMap();
  public zb b;
  
  public z1()
  {
    c();
  }
  
  public static void b(String paramString)
  {
    y1 localy1 = (y1)c.a.get(paramString);
    if (localy1 != null)
    {
      localy1.s();
      c.a.remove(paramString);
    }
  }
  
  public static z1 d()
  {
    if (c == null) {
      c = l.a();
    }
    return c;
  }
  
  public void a()
  {
    this.b.a(b3.class.getSimpleName());
    this.b.a(f3.class.getSimpleName());
    this.b.a(d3.class.getSimpleName());
    this.b.a(j3.class.getSimpleName());
    this.b.a(t2.class.getSimpleName());
    this.b.a(q2.class.getSimpleName());
    this.b.a(x3.class.getSimpleName());
    this.b.a(o2.class.getSimpleName());
    this.b.a(k2.class.getSimpleName());
    this.b.a(v2.class.getSimpleName());
  }
  
  public final void a(int paramInt, String paramString, final ArrayList<l0> paramArrayList)
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
      boolean bool = TextUtils.isEmpty(p4.p().c());
      if (bool) {
        return;
      }
      paramArrayList = new b(paramArrayList);
      bool = c6.s0().y();
      if (!bool) {
        return;
      }
      this.b.a(new g2(paramString), new f2(paramArrayList));
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, fc paramfc)
  {
    r3 localr3 = new r3("normal", paramInt);
    paramfc = new q3(paramfc);
    this.b.a(localr3, paramfc);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.b.c(paramContext, paramString1, paramString2, paramString3);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b.a(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(MidasActivityAbility paramMidasActivityAbility, fc paramfc)
  {
    paramMidasActivityAbility = new c2(paramMidasActivityAbility);
    paramfc = new b2(paramfc);
    this.b.a(paramMidasActivityAbility, paramfc);
  }
  
  public void a(String paramString)
  {
    this.b.a(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.b.a(paramString1, paramString2, paramString3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, fc paramfc)
  {
    paramString1 = new v3(paramString1, paramString2, paramString3, paramString4, paramString5);
    paramString2 = new u3(paramfc);
    this.b.a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, fc paramfc)
  {
    this.b.a(new z2(paramString1, paramString2, paramString3), new y2(paramfc));
  }
  
  public void a(String paramString1, String paramString2, fc paramfc)
  {
    paramString1 = new z3(paramString1, paramString2);
    paramString2 = new y3(paramfc);
    this.b.a(paramString1, paramString2);
  }
  
  public void a(String paramString, fc paramfc)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(p4.p().e().b.offerId);
      if (bool) {
        return;
      }
      if (!c6.s0().y()) {
        return;
      }
      this.b.a(new g2(paramString), new f2(paramfc));
      return;
    }
    catch (Exception paramString)
    {
      paramfc = new StringBuilder();
      paramfc.append("DataReport exception:");
      paramfc.append(paramString.toString());
      APLog.e("Network-Manager", paramfc.toString());
      return;
      APLog.e("Network-Manager", "DataReport request or offerid is null");
      return;
    }
    catch (NullPointerException paramString)
    {
      label90:
      break label90;
    }
  }
  
  public void a(String paramString, fc paramfc, x3.a parama)
  {
    if ((p4.p().e() != null) && (a.r().g != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("net mgr save, channel id = ");
      localStringBuilder.append(paramString);
      APLog.d("Network-Manager", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("net mgr save, risk control soft param = ");
      localStringBuilder.append(parama);
      APLog.d("Network-Manager", localStringBuilder.toString());
      paramString = new x3(paramString, parama);
      this.b.a(paramString, new w3(paramfc));
      return;
    }
    APUICommonMethod.f();
    z5.a(-1, "maybe call multy");
  }
  
  public final void a(fb paramfb, int paramInt1, int paramInt2, String paramString, gb paramgb)
  {
    if (paramfb == null)
    {
      APLog.e("Network-Manager", "Cannot send data report with null request!");
      return;
    }
    Object localObject = paramfb.j();
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
      String str = paramfb.j();
      ((StringBuilder)localObject).append(str.substring(str.lastIndexOf('/') + 1, str.length()));
    }
    catch (Exception localException)
    {
      label110:
      break label110;
    }
    ((StringBuilder)localObject).append(paramfb.j());
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("reqip=");
    ((StringBuilder)localObject).append(paramfb.g());
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("code=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("json=");
    try
    {
      if (TextUtils.isEmpty(paramgb.b))
      {
        ((StringBuilder)localObject).append("norsp");
      }
      else
      {
        paramgb = new JSONObject(paramgb.b);
        if (paramgb.has("ret")) {
          ((StringBuilder)localObject).append(paramgb.getString("ret"));
        } else {
          ((StringBuilder)localObject).append("ok");
        }
      }
    }
    catch (Exception paramgb)
    {
      ((StringBuilder)localObject).append(paramgb.toString());
    }
    catch (JSONException paramgb)
    {
      ((StringBuilder)localObject).append(paramgb.toString());
    }
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("times=");
    ((StringBuilder)localObject).append(paramfb.c);
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("network=");
    ((StringBuilder)localObject).append(APAppDataInterface.singleton().s());
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("errorCode=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("retrytimes=");
    ((StringBuilder)localObject).append(paramfb.f);
    paramgb = "yes";
    if ((paramInt2 != 200) && (!paramfb.g)) {
      paramgb = "no";
    }
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("isresult=");
    ((StringBuilder)localObject).append(paramgb);
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("uuid=");
    ((StringBuilder)localObject).append(c6.s0().Z());
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append("errorMsg=");
    ((StringBuilder)localObject).append(paramString);
    try
    {
      paramgb = Proxy.getDefaultHost();
      paramString = paramgb;
      if (TextUtils.isEmpty(paramgb)) {
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
      ((StringBuilder)localObject).append(paramfb.e);
      ((StringBuilder)localObject).append("&getOutputStreamTime=");
      ((StringBuilder)localObject).append(paramfb.d);
    }
    catch (Exception paramfb)
    {
      paramfb.printStackTrace();
    }
    try
    {
      APDataReportManager.getInstance().insertData("sdk.midas.networkrequest", p4.p().e().b.saveType, null, null, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramfb)
    {
      paramfb.printStackTrace();
      return;
    }
  }
  
  public void a(fc paramfc)
  {
    this.b.a(new k2(), new j2(paramfc));
  }
  
  public void a(fc paramfc, String paramString)
  {
    paramString = new t3("finish_receipt", paramString);
    paramfc = new s3(paramfc);
    this.b.a(paramString, paramfc);
  }
  
  public void a(qb paramqb, ob paramob)
  {
    this.b.a(paramqb, paramob);
  }
  
  public void b()
  {
    APDataReportManager.getInstance().a(new a());
  }
  
  public void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b.b(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    this.b.b(paramString1, paramString2, paramString3);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, fc paramfc)
  {
    paramString1 = new f4(paramString1, paramString2, paramString3);
    paramString2 = new e4(paramfc);
    this.b.a(paramString1, paramString2);
  }
  
  public void b(String paramString1, String paramString2, fc paramfc)
  {
    this.b.a(new n3(paramString1, paramString2), new m3(paramfc));
  }
  
  public void b(String paramString, fc paramfc)
  {
    paramString = new d4(paramString);
    paramfc = new c4(paramfc);
    this.b.a(paramString, paramfc);
  }
  
  public void b(fc paramfc)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(p4.p().e().b.offerId);
      if (bool) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Get ip list start!");
      localStringBuilder.append(APAppDataInterface.singleton().h());
      APLog.d("Network-Manager", localStringBuilder.toString());
      this.b.a(new m2(), new l2(paramfc));
      return;
    }
    catch (Exception paramfc)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIpList exception:");
      localStringBuilder.append(paramfc.toString());
      APLog.w("APNetworkManager", localStringBuilder.toString());
      return;
      APLog.w("APNetworkManager", "getIpList request or offerid is null");
      return;
    }
    catch (NullPointerException paramfc)
    {
      label117:
      break label117;
    }
  }
  
  public void b(fc paramfc, String paramString)
  {
    paramString = new m4(paramString);
    paramfc = new l4(paramfc);
    this.b.a(paramString, paramfc);
  }
  
  public boolean b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return this.b.d(paramContext, paramString1, paramString2, paramString3);
  }
  
  public final void c()
  {
    this.b = new zb(new c());
    this.b.a(new d());
    this.b.a(a.r().d);
    this.b.a(new e());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Network manager set base key = ");
    ((StringBuilder)localObject).append(APAppDataInterface.singleton().e());
    APLog.d("Faip===", ((StringBuilder)localObject).toString());
    this.b.b(APAppDataInterface.singleton().e());
    this.b.a(new f());
    this.b.a(new g());
    zb localzb = this.b;
    if (APAppDataInterface.singleton().h().equals("testing")) {
      localObject = "-----BEGIN CERTIFICATE-----\nMIIB+zCCAWQCCQDnbabaPRGSojANBgkqhkiG9w0BAQUFADBCMQswCQYDVQQGEwJY\nWDEVMBMGA1UEBwwMRGVmYXVsdCBDaXR5MRwwGgYDVQQKDBNEZWZhdWx0IENvbXBh\nbnkgTHRkMB4XDTE3MDYxMjA0NTgxM1oXDTE4MDYxMjA0NTgxM1owQjELMAkGA1UE\nBhMCWFgxFTATBgNVBAcMDERlZmF1bHQgQ2l0eTEcMBoGA1UECgwTRGVmYXVsdCBD\nb21wYW55IEx0ZDCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAtPIG5lntvILM\nKq5DGq6WelrdovgxgwmncBgCsvI/iSzpBrOIXOh/ut+d+/pSUYAN0AadZp2tdb3F\nNS4AZbRhKjBWOuJv+Oj2KpjCW98iymoBbW8CHRHYbdTY/cpbkxPLN7v4bBNA8K2T\nKeRSp+NMHoR3POKos6iiUtVdQw2LP1kCAwEAATANBgkqhkiG9w0BAQUFAAOBgQBt\n03Qe2CVPZqgAAixUw/K3eY1Su7MAsJpgNKH5L9lQ7F6Fop9D3MQ9ku6OGQSRzhZ9\nI85Sw6jnBgmze2vBC5z+OKDgVvCW3AsRdK1YAcNKwxrTjFOw4drtLhk/avv7Gj/8\nS2b6fi3l9JumOBWy3YHaTRzkhE9ejtczdmHjzXLnhQ==\n-----END CERTIFICATE-----\n";
    } else {
      localObject = "-----BEGIN CERTIFICATE-----\nMIIEDzCCAvegAwIBAgIJAJhHK18zh2o5MA0GCSqGSIb3DQEBBQUAMGIxCzAJBgNV\nBAYTAkNOMRIwEAYDVQQIEwlHdWFuZ2RvbmcxETAPBgNVBAcTCFNoZW56aGVuMRUw\nEwYDVQQKEwxDUGF5IFJvb3QgQ0ExFTATBgNVBAsTDENQYXkgUm9vdCBDQTAeFw0x\nMzEwMzEwNzE1NDVaFw0yMzEwMjkwNzE1NDVaMGIxCzAJBgNVBAYTAkNOMRIwEAYD\nVQQIEwlHdWFuZ2RvbmcxETAPBgNVBAcTCFNoZW56aGVuMRUwEwYDVQQKEwxDUGF5\nIFJvb3QgQ0ExFTATBgNVBAsTDENQYXkgUm9vdCBDQTCCASIwDQYJKoZIhvcNAQEB\nBQADggEPADCCAQoCggEBALKfVOTFtDzHXOl78oi+R1MvJ80GFN/i71zbxpZnLEdz\ny4KIyotmnmt1av8ONC17bYrmHCimwyiMTonme5gBNm83XWPxByAccQbqeBowx+7a\nXUojJQwdykDE1AafiZWdtmI2vq9HGXtmZJWatxda/G3vo1lUpqQeB1juvNVb1flq\n2IZFxGihmV8EDhtTt3gGlaLwmBsI40Et+vJX/XXrd158qF6wmhzztI+obmYEqjJT\nNxor/fOMWXSIZOtvLdAA1fbrH1cMon62v2v2Sx/69KCrV9CgmK3dYJiUaAiv3SYP\n4CB+r8odiulK42QPnVxFbPR0ID8al+fewDomREqt6RkCAwEAAaOBxzCBxDAdBgNV\nHQ4EFgQUFb1Jpcd4xDZYyNLV2D3iV44X9SMwgZQGA1UdIwSBjDCBiYAUFb1Jpcd4\nxDZYyNLV2D3iV44X9SOhZqRkMGIxCzAJBgNVBAYTAkNOMRIwEAYDVQQIEwlHdWFu\nZ2RvbmcxETAPBgNVBAcTCFNoZW56aGVuMRUwEwYDVQQKEwxDUGF5IFJvb3QgQ0Ex\nFTATBgNVBAsTDENQYXkgUm9vdCBDQYIJAJhHK18zh2o5MAwGA1UdEwQFMAMBAf8w\nDQYJKoZIhvcNAQEFBQADggEBAC+WGUZTncBGxgcEfWt3MFOuL1ht3hF03WFx+6wt\n9TyEySEPRrH/g+jNUL9wsdVFztzHcY3iFmtVHqAioGXwz+Kjd7E0iCV1ijNusMv6\nN2MQsZ70JC2mbMewcwK6c2eCGABMD6hV8crTVGe7OIvz4M7mk1hevly0SlxS7Lfc\nF3i2504uOQp9bVpzQMZ++6m7s7KTysostxMsQbuPLN2xTSx+SEzVZQN/oqemSh2F\nJpODYHOnU5wDf5b7UFcZ7jL4FSJWrIfcxlHVZse/kX7e38a9odrFHxmaNhsBWYn0\nLqZpfR9qWZSjihLXz0lPTnB4ZJNVAsP0DfI/veTyoSBkX2g=\n-----END CERTIFICATE-----\n";
    }
    localzb.c((String)localObject);
    this.b.a(new h());
    this.b.a(new i());
    this.b.a(new j());
    this.b.a(new k());
    this.b.f();
  }
  
  public void c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b.c(paramContext, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void c(String paramString1, String paramString2, String paramString3)
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
    this.b.c(paramString1, paramString2, paramString3);
  }
  
  public void c(String paramString1, String paramString2, fc paramfc)
  {
    this.b.a(new i2(paramString1, paramString2), new h2(paramfc, "querywxresult"));
  }
  
  public void c(String paramString, fc paramfc)
  {
    this.b.a(new s2(paramString), new r2(paramfc));
  }
  
  public void c(fc paramfc)
  {
    k4 localk4 = new k4();
    paramfc = new j4(paramfc);
    this.b.a(localk4, paramfc);
  }
  
  public void c(fc paramfc, String paramString)
  {
    paramString = new t3("query_pay_receipt", paramString);
    paramfc = new s3(paramfc);
    this.b.a(paramString, paramfc);
  }
  
  public void d(String paramString, fc paramfc)
  {
    if (paramfc == null)
    {
      APLog.e("Network-Manager", "Cannot call buy goods without callback!");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramfc.b(ob.a(22000, "系统繁忙,请稍后再试\n(订单获取失败)"));
      return;
    }
    if (paramString.lastIndexOf("?") <= 0)
    {
      paramfc.b(ob.a(22000, "订单参数错误"));
      return;
    }
    if (paramString.lastIndexOf("token_id=") <= 0)
    {
      paramfc.b(ob.a(22000, "订单参数错误"));
      return;
    }
    this.b.a(new d3(paramString), new c3(paramfc));
  }
  
  public void d(fc paramfc)
  {
    this.b.a(new q2(), new p2(paramfc));
  }
  
  public void d(fc paramfc, String paramString)
  {
    paramString = new t3("query_unfinish_receipt", paramString);
    paramfc = new s3(paramfc);
    this.b.a(paramString, paramfc);
  }
  
  public void e(String paramString, fc paramfc)
  {
    if ((!(p4.p().e().b instanceof APMonthRequest)) && (!(p4.p().e().b instanceof APSubscribeRequest)))
    {
      z5.a(12, "访问太频繁了");
      APUICommonMethod.f();
      return;
    }
    this.b.a(new j3(paramString), new i3(paramfc));
  }
  
  public void e(fc paramfc)
  {
    this.b.a(new x2("", "goldcoupons_rollback"), new w2("goldcouponsrollback", paramfc));
  }
  
  public void f(String paramString, fc paramfc)
  {
    this.b.a(new h4(paramString), new g4(paramfc));
  }
  
  public void f(fc paramfc)
  {
    v2 localv2 = new v2();
    this.b.a(localv2, new u2(paramfc));
  }
  
  public void g(String paramString, fc paramfc)
  {
    this.b.a(new i2(paramString, "0"), new h2(paramfc, "mcardstatus"));
  }
  
  public void g(fc paramfc)
  {
    this.b.a(new x2("", "rollback"), new w2("hfcouponsrollback", paramfc));
  }
  
  public void h(String paramString, fc paramfc)
  {
    paramString = new x2(paramString, "sp_rollback");
    paramfc = new w2("supercouponsrollback", paramfc);
    this.b.a(paramString, paramfc);
  }
  
  public void h(fc paramfc)
  {
    if (!(p4.p().e().b instanceof APGameRequest))
    {
      z5.a(12, "访问太频繁了");
      APUICommonMethod.f();
      return;
    }
    this.b.a(new f3(), new e3(paramfc));
  }
  
  public void i(fc paramfc)
  {
    r3 localr3 = new r3("normal");
    paramfc = new q3(paramfc);
    this.b.a(localr3, paramfc);
  }
  
  public void j(fc paramfc)
  {
    r3 localr3 = new r3("portal");
    paramfc = new q3(paramfc);
    this.b.a(localr3, paramfc);
  }
  
  public void k(fc paramfc)
  {
    this.b.a(new b4(), new a4(paramfc));
  }
  
  public void l(fc paramfc)
  {
    this.b.a(new p3(), new o3(paramfc));
  }
  
  public void m(fc paramfc)
  {
    this.b.a(new i2("", "5"), new h2(paramfc, "towxsign"));
  }
  
  public void n(fc paramfc)
  {
    this.b.a(new i2("", "4"), new h2(paramfc, "towxunsign"));
  }
  
  public class a
    implements o6
  {
    public a() {}
    
    public void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, Bundle paramBundle)
    {
      if (paramInt1 != 0)
      {
        APLog.e("Network-Manager", "Cannot get data report records, cannot data report!");
        return;
      }
      paramObject = (ArrayList)paramObject;
      if (paramObject == null)
      {
        APLog.e("Network-Manager", "Cannot get data report records, cannot data report!");
        return;
      }
      paramInt2 = paramObject.size();
      if (paramInt2 <= 0)
      {
        APLog.e("Network-Manager", "Got 0 report record, cannot data report!");
        return;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("Report record num = ");
      paramBundle.append(paramInt2);
      APLog.d("Network-Manager", paramBundle.toString());
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = (k0)paramObject.get(paramInt1);
        if (localObject == null)
        {
          APLog.e("Network-Manager", "Got null report record!");
        }
        else
        {
          paramBundle = ((k0)localObject).a;
          localObject = ((k0)localObject).b;
          z1.a(z1.this, paramInt1, paramBundle, (ArrayList)localObject);
        }
        paramInt1 += 1;
      }
    }
  }
  
  public class b
    implements fc
  {
    public b(ArrayList paramArrayList) {}
    
    public void a(ob paramob)
    {
      if (paramob.d() == 0) {
        h0.a(a.r().d).a(paramArrayList);
      }
    }
    
    public void b(ob paramob) {}
    
    public void c(ob paramob) {}
  }
  
  public class c
    implements ab
  {
    public c() {}
    
    public void a(String paramString1, String paramString2)
    {
      APLog.w(paramString1, paramString2);
    }
    
    public void b(String paramString1, String paramString2)
    {
      APLog.d(paramString1, paramString2);
    }
    
    public void d(String paramString1, String paramString2)
    {
      APLog.e(paramString1, paramString2);
    }
  }
  
  public class d
    implements zb.b
  {
    public d() {}
    
    public qb a()
    {
      return new o2();
    }
  }
  
  public class e
    implements dc
  {
    public e() {}
    
    public void a(gb paramgb)
    {
      if (paramgb == null)
      {
        APLog.e("Network-Manager", "Cannot handle get key success, response null!");
        return;
      }
      fb localfb = paramgb.g();
      if (localfb == null)
      {
        APLog.e("Network-Manager", "Cannot handle get key success, no request in response!");
        return;
      }
      if (!(localfb instanceof qb))
      {
        APLog.e("Network-Manager", "Cannot handle get key success, request type error!");
        return;
      }
      n2.a(paramgb, ((qb)localfb).v());
    }
  }
  
  public class f
    implements cc
  {
    public f() {}
    
    public void a(fb paramfb, gb paramgb)
    {
      if (paramfb != null)
      {
        if (paramgb == null) {
          return;
        }
        boolean bool = paramfb instanceof y1;
        String str = "";
        if ((bool) && (((y1)paramfb).F())) {
          APAppDataInterface.singleton().n("");
        }
        Exception localException = paramgb.c;
        if (localException != null) {
          str = localException.toString();
        }
        a2.a(paramfb.g(), System.currentTimeMillis(), paramfb.c, false);
        z1.a(z1.this, paramfb, APTools.a(paramgb.c), APTools.a(paramgb), str, paramgb);
      }
    }
    
    public void b(fb paramfb, gb paramgb)
    {
      if (paramfb != null)
      {
        if (paramgb == null) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("NetworkNode success: host=");
        localStringBuilder.append(paramfb.g());
        APLog.d("Network-Manager", localStringBuilder.toString());
        a2.a(paramfb.g(), System.currentTimeMillis(), paramfb.c, true);
        if (((paramfb instanceof y1)) && (((y1)paramfb).F())) {
          APAppDataInterface.singleton().n(paramfb.g());
        }
        z1.a(z1.this, paramfb, 0, 200, "", paramgb);
      }
    }
  }
  
  public class g
    implements zb.c
  {
    public g() {}
    
    public void a(String paramString) {}
  }
  
  public class h
    implements ub.e
  {
    public h() {}
    
    public boolean a(String paramString)
    {
      return true;
    }
  }
  
  public class i
    implements zb.a
  {
    public i() {}
    
    public int a()
    {
      try
      {
        APAppDataInterface localAPAppDataInterface = APAppDataInterface.singleton();
        int i = m6.a(a.r().d);
        if (i != -1)
        {
          if (i != 1000)
          {
            if ((i == 1) || (i == 2)) {
              break label60;
            }
            if (i != 3)
            {
              if (i != 4) {
                return 15000;
              }
            }
            else {
              return localAPAppDataInterface.y();
            }
          }
          return localAPAppDataInterface.z();
        }
        label60:
        i = localAPAppDataInterface.x();
        return i;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return 15000;
    }
  }
  
  public class j
    implements zb.d
  {
    public j() {}
    
    public int a()
    {
      try
      {
        APAppDataInterface localAPAppDataInterface = APAppDataInterface.singleton();
        int i = m6.a(a.r().d);
        if (i != -1)
        {
          if (i != 1000)
          {
            if ((i == 1) || (i == 2)) {
              break label60;
            }
            if (i != 3)
            {
              if (i != 4) {
                return 15000;
              }
            }
            else {
              return localAPAppDataInterface.y();
            }
          }
          return localAPAppDataInterface.z();
        }
        label60:
        i = localAPAppDataInterface.x();
        return i;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return 15000;
    }
  }
  
  public class k
    implements ec
  {
    public k() {}
    
    public String a()
    {
      return a2.c();
    }
    
    public String b()
    {
      return "1.7.9a";
    }
  }
  
  public static class l
  {
    public static final z1 a = new z1();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.z1
 * JD-Core Version:    0.7.0.1
 */