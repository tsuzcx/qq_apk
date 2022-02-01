import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.SubAccountObserver;

public class ffb
  extends SubAccountObserver
{
  public ffb(SubLoginActivity paramSubLoginActivity) {}
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("SubLoginActivity.onGetKeyBack() start. subUin=").append(paramString2).append(" key=");
      if (paramString3 == null)
      {
        paramString1 = null;
        QLog.d("Q.subaccount.SubLoginActivity", 2, paramString1);
      }
    }
    else
    {
      if (!TextUtils.isEmpty(paramString3)) {
        break label164;
      }
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12005");
      paramString1.put("fail_step", "getKeyEmpty");
      paramString1.put("fail_location", "subLogin");
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.app.a(), "actSBGeykey", false, 0L, 0L, paramString1, "");
      this.a.a();
      this.a.a(this.a.getString(2131368699));
      this.a.runOnUiThread(new ffd(this));
    }
    for (;;)
    {
      return;
      paramString1 = "no null.";
      break;
      label164:
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12006");
      paramString1.put("fail_step", "getKeyNotEmpty");
      paramString1.put("fail_location", "subLogin");
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.app.a(), "actSBGeykey", true, 0L, 0L, paramString1, "");
      if (!SubLoginActivity.c(this.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "subaccount onGetKeyBack not need bind");
        }
        this.a.a();
        paramString1 = (SubAccountManager)this.a.app.getManager(59);
        if (paramString1 != null) {
          paramString1.a(paramString2, paramString3, true);
        }
        SubAccountControll.a(this.a.app, (byte)1, paramString2);
        SubAccountControll.a(this.a.app, paramString2, 7);
        SubAccountAssistantForward.b(this.a.app);
        SubAccountAssistantForward.a(this.a.app);
        this.a.setTitle("");
        SubAccountAssistantForward.a(this.a.app, this.a, paramString2);
        this.a.finish();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onGetKeyBack: sucess .........");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SubAccount", 2, "subaccount onGetKeyBack goto bind");
        }
        paramString1 = (SubAccountProtocManager)this.a.app.getManager(27);
        if (paramString1 != null) {
          paramString1.a(paramString2, paramString3, this.a.a);
        }
        SubLoginActivity.b(this.a, true);
      }
    }
  }
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onLoginFailed: subLogin ...onLoginTimeout  subuin =  uin .. .errorMsg = " + paramString4);
    }
    paramString2 = new HashMap();
    paramString2.put("param_FailCode", "12002");
    paramString2.put("fail_step", "loginFail");
    paramString3 = new StringBuilder().append("subLogin:");
    if (paramString4 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      paramString2.put("fail_location", paramString1);
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.app.a(), "actSBLogin", false, 0L, 0L, paramString2, "");
      if (!this.a.getActivity().isFinishing()) {}
      try
      {
        this.a.a();
        this.a.runOnUiThread(new ffc(this));
        if (TextUtils.isEmpty(paramString4))
        {
          this.a.a(this.a.getString(2131365941));
          return;
          paramString1 = paramString4;
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
        }
        this.a.a(paramString4);
      }
    }
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onLoginSuccess: start");
    }
    if (this.a.app == null) {}
    do
    {
      return;
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12001");
      paramString1.put("fail_step", "loginsucc");
      paramString1.put("fail_location", "subLogin");
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.app.a(), "actSBLogin", true, 0L, 0L, paramString1, "");
      SharedPreUtils.a(this.a.app.getApplication().getApplicationContext(), paramString2, true);
      this.a.getAppRuntime().getSubAccountKey(this.a.app.getAccount(), paramString2, SubLoginActivity.a(this.a));
      paramString1 = (SubAccountManager)this.a.app.getManager(59);
    } while (paramString1 == null);
    paramString1.a(paramString2, 0, "");
  }
  
  protected void onLoginTimeout(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onLoginTimeout:  subuin =  uin");
    }
    paramString1 = new HashMap();
    paramString1.put("param_FailCode", "12004");
    paramString1.put("fail_step", "loginTimeout");
    paramString1.put("fail_location", "subLogin");
    StatisticCollector.a(BaseApplication.getContext()).a(this.a.app.a(), "actSBLogin", false, 0L, 0L, paramString1, "");
    if (!this.a.getActivity().isFinishing()) {}
    try
    {
      this.a.a();
      this.a.a(this.a.getString(2131365941));
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  protected void onUserCancel(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new HashMap();
    paramString1.put("param_FailCode", "12003");
    paramString1.put("fail_step", "onUserCancel");
    paramString1.put("fail_location", "subLogin");
    StatisticCollector.a(BaseApplication.getContext()).a(this.a.app.a(), "actSBLogin", false, 0L, 0L, paramString1, "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubLoginActivity", 2, "onUserCancel: start");
    }
    if (!this.a.getActivity().isFinishing()) {}
    try
    {
      this.a.a();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ffb
 * JD-Core Version:    0.7.0.1
 */