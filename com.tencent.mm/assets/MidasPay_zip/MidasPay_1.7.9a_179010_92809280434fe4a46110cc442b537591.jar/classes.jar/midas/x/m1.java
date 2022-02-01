package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.f;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;

public class m1
{
  public static volatile m1 f;
  public boolean a = n1.a();
  public boolean b;
  public n1 c;
  public q1 d;
  public String e = "";
  
  public m1()
  {
    if (this.a) {
      this.c = new n1();
    }
    this.b = q1.b();
    if (this.b) {
      this.d = new q1();
    }
  }
  
  public static m1 d()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new m1();
        }
      }
      finally {}
    }
    return f;
  }
  
  public String a()
  {
    if ("1".equals(this.e)) {
      return n1.c;
    }
    return q1.d;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if ("1".equals(this.e))
    {
      if (this.a)
      {
        localObject = this.c;
        if (localObject != null) {
          ((n1)localObject).a(paramInt1, paramInt2, paramIntent);
        }
      }
    }
    else if (this.b)
    {
      localObject = this.d;
      if (localObject != null) {
        ((q1)localObject).a(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void a(Context paramContext, Activity paramActivity, String paramString, l1 paraml1)
  {
    int i = p4.p().e().b.saveType;
    String str1 = p4.p().e().f.e;
    if ((paramString == null) || (paramString.length() == 0)) {
      APDataReportManager.getInstance().insertData("sdk.login.no.appid", i, null, str1, "");
    }
    String str2 = z5.a();
    APLog.i("launchLogin login appId:", paramString);
    APLog.i("launchLogin login packageName:", str2);
    if (str2.equals("com.tencent.unipay"))
    {
      if (this.d != null)
      {
        this.e = "2";
        APDataReportManager.getInstance().insertData("sdk.login.wtlogin.launch", i, this.e, str1, "1600000052");
        APLog.i("launchLogin login TENCENT_UNIPAY_LOGIN_APPID:", "1600000052");
        this.d.a(paramActivity.getApplicationContext(), "1600000052");
        this.d.a(paramActivity, paraml1);
      }
    }
    else if (c6.s0().J().equals("1"))
    {
      APLog.d("APLoginManager", "relogin type: RELOGIN_TYPE_OPENSDK");
      if (this.c != null)
      {
        this.e = "1";
        APDataReportManager.getInstance().insertData("sdk.login.opensdk.launch", i, this.e, str1, "");
        this.c.a(paramActivity.getApplicationContext(), paramString);
        this.c.a(paramActivity, paraml1);
      }
      else if (this.d != null)
      {
        this.e = "2";
        APDataReportManager.getInstance().insertData("sdk.login.wtlogin.launch", i, this.e, str1, "");
        this.d.a(paramActivity.getApplicationContext(), paramString);
        this.d.a(paramActivity, paraml1);
      }
    }
    else
    {
      APLog.d("APLoginManager", "relogin type: not RELOGIN_TYPE_OPENSDK");
      if (this.d != null)
      {
        this.e = "2";
        APDataReportManager.getInstance().insertData("sdk.login.wtlogin.launch", i, this.e, str1, "");
        this.d.a(paramActivity.getApplicationContext(), paramString);
        this.d.a(paramActivity, paraml1);
      }
      else if (this.c != null)
      {
        this.e = "1";
        APDataReportManager.getInstance().insertData("sdk.login.opensdk.launch", i, this.e, str1, "");
        this.c.a(paramActivity.getApplicationContext(), paramString);
        this.c.a(paramActivity, paraml1);
      }
    }
    if ((!this.a) && (!this.b))
    {
      APDataReportManager.getInstance().insertData("sdk.login.no.opensdk", i, null, str1, "");
      APUICommonMethod.a(paramContext, "登录失败");
      if (!c6.s0().m().equals("release")) {
        a("尚未检测到OpenSDK或wtloinSDK，无法拉起手Q授权登录！", paramContext);
      }
    }
  }
  
  public final void a(String paramString, Context paramContext)
  {
    paramContext = new APAlertDialog.f(paramContext);
    paramContext.b("提示");
    paramContext.a(paramString);
    paramContext.b("确定", new a());
    paramContext.b(new b());
    try
    {
      paramContext.b();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public class a
    implements c7
  {
    public a() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      paramAPAlertDialog.f();
      z5.f();
    }
  }
  
  public class b
    implements c7
  {
    public b() {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0)) {
        z5.f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.m1
 * JD-Core Version:    0.7.0.1
 */