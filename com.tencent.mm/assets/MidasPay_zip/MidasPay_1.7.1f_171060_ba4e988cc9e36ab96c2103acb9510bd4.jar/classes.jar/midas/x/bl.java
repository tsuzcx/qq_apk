package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.a;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;

public class bl
{
  private static volatile bl b;
  public String a = "";
  private boolean c = bm.a();
  private boolean d;
  private bm e;
  private bp f;
  
  public bl()
  {
    if (this.c) {
      this.e = new bm();
    }
    this.d = bp.a();
    if (this.d) {
      this.f = new bp();
    }
  }
  
  public static bl a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new bl();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void a(String paramString, Context paramContext)
  {
    paramContext = new APAlertDialog.a(paramContext);
    paramContext.b("提示");
    paramContext.a(paramString);
    paramContext.a("确定", new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        paramAnonymousAPAlertDialog.a();
        fm.d();
      }
    });
    paramContext.b(new gn()
    {
      public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0)) {
          fm.d();
        }
      }
    });
    try
    {
      paramContext.c();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ("1".equals(this.a))
    {
      if ((this.c) && (this.e != null)) {
        this.e.a(paramInt1, paramInt2, paramIntent);
      }
    }
    else if ((this.d) && (this.f != null)) {
      this.f.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Context paramContext, Activity paramActivity, String paramString, bk parambk)
  {
    int i = ed.b().n().a.saveType;
    String str1 = ed.b().n().e.f;
    if ((paramString == null) || (paramString.length() == 0)) {
      APDataReportManager.getInstance().insertData("sdk.login.no.appid", i, null, str1, "");
    }
    String str2 = fm.b();
    APLog.i("launchLogin login appId:", paramString);
    APLog.i("launchLogin login packageName:", str2);
    if (str2.equals("com.tencent.unipay"))
    {
      if (this.f != null)
      {
        this.a = "2";
        APDataReportManager.getInstance().insertData("sdk.login.wtlogin.launch", i, this.a, str1, "1600000052");
        APLog.i("launchLogin login TENCENT_UNIPAY_LOGIN_APPID:", "1600000052");
        this.f.a(paramActivity.getApplicationContext(), "1600000052");
        this.f.a(paramActivity, parambk);
      }
    }
    else if (fp.a().ac().equals("1"))
    {
      APLog.d("APLoginManager", "relogin type: RELOGIN_TYPE_OPENSDK");
      if (this.e != null)
      {
        this.a = "1";
        APDataReportManager.getInstance().insertData("sdk.login.opensdk.launch", i, this.a, str1, "");
        this.e.a(paramActivity.getApplicationContext(), paramString);
        this.e.a(paramActivity, parambk);
      }
      else if (this.f != null)
      {
        this.a = "2";
        APDataReportManager.getInstance().insertData("sdk.login.wtlogin.launch", i, this.a, str1, "");
        this.f.a(paramActivity.getApplicationContext(), paramString);
        this.f.a(paramActivity, parambk);
      }
    }
    else
    {
      APLog.d("APLoginManager", "relogin type: not RELOGIN_TYPE_OPENSDK");
      if (this.f != null)
      {
        this.a = "2";
        APDataReportManager.getInstance().insertData("sdk.login.wtlogin.launch", i, this.a, str1, "");
        this.f.a(paramActivity.getApplicationContext(), paramString);
        this.f.a(paramActivity, parambk);
      }
      else if (this.e != null)
      {
        this.a = "1";
        APDataReportManager.getInstance().insertData("sdk.login.opensdk.launch", i, this.a, str1, "");
        this.e.a(paramActivity.getApplicationContext(), paramString);
        this.e.a(paramActivity, parambk);
      }
    }
    if ((!this.c) && (!this.d))
    {
      APDataReportManager.getInstance().insertData("sdk.login.no.opensdk", i, null, str1, "");
      APUICommonMethod.a(paramContext, "登录失败");
      if (!fp.a().c().equals("release")) {
        a("尚未检测到OpenSDK或wtloinSDK，无法拉起手Q授权登录！", paramContext);
      }
      return;
    }
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public String d()
  {
    if ("1".equals(this.a)) {
      return bm.a;
    }
    return bp.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.bl
 * JD-Core Version:    0.7.0.1
 */