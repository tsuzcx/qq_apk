package midas.x;

import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;

public abstract class bk
{
  private boolean a;
  
  public bk()
  {
    this(false);
  }
  
  public bk(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  private void c(String paramString1, String paramString2, String paramString3)
  {
    if ((APAppDataInterface.singleton().c()) && (APAppDataInterface.singleton().d()))
    {
      ed.b().n().e.a = paramString1;
      ed.b().n().e.b = paramString2;
      if (paramString3.equals("1"))
      {
        ed.b().n().a.openId = paramString1;
        ed.b().n().a.openKey = paramString2;
        ed.b().n().a.sessionId = "openid";
        ed.b().n().a.sessionType = "kp_actoken";
        ed.b().n().e.c = "openid";
        ed.b().n().e.d = "kp_actoken";
        return;
      }
      ed.b().n().a.openId = paramString1;
      ed.b().n().a.openKey = paramString2;
      ed.b().n().a.sessionId = "uin";
      ed.b().n().a.sessionType = "skey";
      ed.b().n().e.c = "";
      ed.b().n().e.d = "";
      return;
    }
    if (paramString3.equals("1"))
    {
      ed.b().n().e.a = paramString1;
      ed.b().n().e.b = paramString2;
      ed.b().n().d.f = true;
      ed.b().n().e.c = "openid";
      ed.b().n().e.d = "kp_actoken";
      if (a())
      {
        fs.a().e(ed.b().n().e.a);
        fs.a().f(ed.b().n().e.b);
        APLog.i("APOpenSDKUiListener", "更换QQ号码成功登陆");
      }
    }
    else
    {
      ed.b().n().e.a = paramString1;
      ed.b().n().e.b = paramString2;
      ed.b().n().d.f = true;
      ed.b().n().e.c = "";
      ed.b().n().e.d = "";
      if (a())
      {
        fs.a().e(ed.b().n().e.a);
        fs.a().f(ed.b().n().e.b);
        APLog.i("APOpenSDKUiListener", "更换QQ号码成功登陆");
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    int i = ed.b().n().a.saveType;
    String str = ed.b().n().e.f;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("code=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("&message=");
    ((StringBuilder)localObject).append(paramString);
    APLog.e("APLoginCallBack", ((StringBuilder)localObject).toString());
    localObject = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("version=");
    localStringBuilder.append(bl.a().d());
    localStringBuilder.append("&code=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("&message=");
    localStringBuilder.append(paramString);
    ((APDataReportManager)localObject).insertData("sdk.login.opensdk.fail", i, null, str, localStringBuilder.toString());
    c();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    int i = ed.b().n().a.saveType;
    String str = ed.b().n().e.f;
    APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("version=");
    localStringBuilder.append(bl.a().d());
    localAPDataReportManager.insertData("sdk.login.opensdk.success", i, paramString3, str, localStringBuilder.toString());
    c(paramString1, paramString2, paramString3);
    b(paramString1, paramString2, paramString3);
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public void b()
  {
    int i = ed.b().n().a.saveType;
    String str = ed.b().n().e.f;
    APDataReportManager localAPDataReportManager = APDataReportManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("version=");
    localStringBuilder.append(bl.a().d());
    localAPDataReportManager.insertData("sdk.login.opensdk.cancel", i, null, str, localStringBuilder.toString());
    c();
  }
  
  public abstract void b(String paramString1, String paramString2, String paramString3);
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.bk
 * JD-Core Version:    0.7.0.1
 */