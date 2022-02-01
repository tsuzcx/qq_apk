import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SSOAccountObserver;

public class lab
  extends SSOAccountObserver
{
  public lab(AuthorityActivity paramAuthorityActivity) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.a.j = true;
    String str = paramBundle.getString("error");
    paramInt1 = paramBundle.getInt("code");
    try
    {
      ReportManager.a().a("agent_login", this.a.e, 0L, 0L, paramInt1, Long.parseLong(paramString), "1000069", "ret: " + paramInt2 + " | error: " + str);
      OpenSdkStatic.a().a(1, "LOGIN_GETTICKT", paramString, AuthorityActivity.A, null, Long.valueOf(SystemClock.elapsedRealtime()), paramInt1, 1, str);
      QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : " + paramInt2 + " - error: " + str + " | code: " + paramInt1);
      if ((paramInt2 == -1000) || (paramInt2 == 154))
      {
        this.a.f = SystemClock.elapsedRealtime();
        LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.f - this.a.e));
        if ((paramInt1 == 1002) && (this.a.C < 2))
        {
          paramString = this.a;
          paramString.C += 1;
          this.a.f();
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        LogUtility.c("Authority_Report", "report login error : ", paramBundle);
      }
      this.a.a(3003, this.a.getResources().getString(2131368093));
      paramString = this.a.a.obtainMessage();
      paramString.what = 6;
      paramString.arg1 = 3003;
      paramString.obj = this.a.getResources().getString(2131368093);
      this.a.a.sendMessage(paramString);
      return;
    }
    this.a.d(paramString);
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    int i = paramBundle.getInt("code");
    QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : success | code: " + i);
    LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.f - this.a.e));
    try
    {
      ReportManager.a().a("agent_login", this.a.e, this.a.m.length(), paramArrayOfByte.length, 0, Long.parseLong(paramString), "1000069", null);
      OpenSdkStatic.a().a(0, "LOGIN_GETTICKT", paramString, AuthorityActivity.A, null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
      this.a.j = false;
      this.a.C = 0;
      String str = null;
      if (paramInt == 4096) {
        str = new String(paramArrayOfByte);
      }
      this.a.a(paramString, str, paramBundle);
      this.a.f = SystemClock.elapsedRealtime();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtility.c("Authority_Report", "report login error : ", localException);
      }
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    paramInt = paramBundle.getInt("code");
    this.a.C = 0;
    this.a.f = SystemClock.elapsedRealtime();
    LogUtility.c("Authority_TimeCost", "<TimeStamp> login cost : " + (this.a.f - this.a.e));
    QLog.d("AuthorityActivity", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : on_user_cancel | code: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lab
 * JD-Core Version:    0.7.0.1
 */