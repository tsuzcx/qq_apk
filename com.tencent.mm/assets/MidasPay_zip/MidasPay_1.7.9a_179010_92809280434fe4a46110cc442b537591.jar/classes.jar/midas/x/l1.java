package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;

public abstract class l1
{
  public boolean a;
  
  public l1()
  {
    this(false);
  }
  
  public l1(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void a(int paramInt, String paramString)
  {
    int i = p4.p().e().b.saveType;
    String str = p4.p().e().f.e;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("code=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("&message=");
    ((StringBuilder)localObject).append(paramString);
    APLog.e("APLoginCallBack", ((StringBuilder)localObject).toString());
    localObject = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("version=");
    localStringBuilder.append(m1.d().a());
    localStringBuilder.append("&code=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("&message=");
    localStringBuilder.append(paramString);
    ((APDataReportManager)localObject).insertData("sdk.login.opensdk.fail", i, null, str, localStringBuilder.toString());
    if (paramInt == -6)
    {
      d();
      return;
    }
    c();
  }
  
  public abstract void a(String paramString1, String paramString2, String paramString3);
  
  public boolean a()
  {
    return this.a;
  }
  
  public void b()
  {
    int i = p4.p().e().b.saveType;
    String str = p4.p().e().f.e;
    APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("version=");
    localStringBuilder.append(m1.d().a());
    localAPDataReportManager.insertData("sdk.login.opensdk.cancel", i, null, str, localStringBuilder.toString());
    c();
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    int i = p4.p().e().b.saveType;
    String str = p4.p().e().f.e;
    APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("version=");
    localStringBuilder.append(m1.d().a());
    localAPDataReportManager.insertData("sdk.login.opensdk.success", i, paramString3, str, localStringBuilder.toString());
    c(paramString1, paramString2, paramString3);
    a(paramString1, paramString2, paramString3);
  }
  
  public abstract void c();
  
  public final void c(String paramString1, String paramString2, String paramString3)
  {
    if ((APAppDataInterface.singleton().u()) && (APAppDataInterface.singleton().m()))
    {
      p4.p().e().f.a = paramString1;
      p4.p().e().f.b = paramString2;
      if (paramString3.equals("1"))
      {
        p4.p().e().b.openId = paramString1;
        p4.p().e().b.openKey = paramString2;
        p4.p().e().b.sessionId = "openid";
        p4.p().e().b.sessionType = "kp_actoken";
        p4.p().e().f.c = "openid";
        p4.p().e().f.d = "kp_actoken";
        return;
      }
      p4.p().e().b.openId = paramString1;
      p4.p().e().b.openKey = paramString2;
      p4.p().e().b.sessionId = "uin";
      p4.p().e().b.sessionType = "skey";
      p4.p().e().f.c = "";
      p4.p().e().f.d = "";
      return;
    }
    if (paramString3.equals("1"))
    {
      p4.p().e().f.a = paramString1;
      p4.p().e().f.b = paramString2;
      p4.p().e().e.f = true;
      p4.p().e().f.c = "openid";
      p4.p().e().f.d = "kp_actoken";
      if (a())
      {
        g6.k().b(p4.p().e().f.a);
        g6.k().a(p4.p().e().f.b);
        APLog.i("APOpenSDKUiListener", "更换QQ号码成功登陆");
      }
    }
    else
    {
      p4.p().e().f.a = paramString1;
      p4.p().e().f.b = paramString2;
      p4.p().e().e.f = true;
      p4.p().e().f.c = "";
      p4.p().e().f.d = "";
      if (a())
      {
        g6.k().b(p4.p().e().f.a);
        g6.k().a(p4.p().e().f.b);
        APLog.i("APOpenSDKUiListener", "更换QQ号码成功登陆");
      }
    }
  }
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.l1
 * JD-Core Version:    0.7.0.1
 */