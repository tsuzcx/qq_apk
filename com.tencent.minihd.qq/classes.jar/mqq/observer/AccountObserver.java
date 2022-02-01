package mqq.observer;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.Action;

public abstract class AccountObserver
  implements BusinessObserver, Constants.Action
{
  public void onChangeToken(boolean paramBoolean, HashMap<String, Object> paramHashMap) {}
  
  public void onDeleteAccount(boolean paramBoolean) {}
  
  public void onExchangeUin(String paramString1, String paramString2, String paramString3) {}
  
  public void onGetKeyResp(String paramString) {}
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt, byte[] paramArrayOfByte) {}
  
  public void onLoginSuccess(String paramString1, String paramString2) {}
  
  protected void onLoginTimeout(String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      paramInt = paramBundle.getInt("code");
      String str2 = paramBundle.getString("alias");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("onRV  action login code = ").append(paramInt).append("; alias = ");
        if (str2 != null) {
          break label195;
        }
      }
      for (String str1 = "is null";; str1 = str2)
      {
        QLog.d("AccountObserver", 2, str1);
        if (!paramBoolean) {
          break;
        }
        onLoginSuccess(paramBundle.getString("uin"), str2);
        return;
      }
      if ((paramInt == 1002) || (paramInt == 1013))
      {
        onLoginTimeout(str2);
        return;
      }
      if (paramInt == 2006)
      {
        onUserCancel(str2);
        return;
      }
      str1 = paramBundle.getString("errorurl");
      paramInt = paramBundle.getInt("loginret");
      Object localObject = paramBundle.getByteArray("lhsig");
      onLoginFailed(str2, paramBundle.getString("error"), str1, paramInt, (byte[])localObject);
      return;
    case 1040: 
      onRegisterCmdCallback(paramBoolean);
      return;
    case 1002: 
      onlineStatusChanged(paramBoolean, (AppRuntime.Status)paramBundle.getSerializable("onlineStatus"), paramBundle.getBoolean("isChanged"), paramBundle.getLong("timeStamp"), paramBundle.getBoolean("isLargeChanged"));
      return;
    case 1041: 
      onRegQueryAccountResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo"));
      return;
    case 1003: 
      onRegisterCommitMobileResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo"), paramBundle.getByteArray("mobile"));
      return;
    case 1004: 
      onRegisterCommitSmsCodeResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo"));
      return;
    case 1020: 
      onRegisterSendResendSmsreqResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo"), paramBundle.getInt("next_chk_time"), paramBundle.getInt("total_time_over"));
      return;
    case 1022: 
      onRegisterQuerySmsStatResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getByteArray("promptInfo"), paramBundle.getInt("next_chk_time"), paramBundle.getInt("total_time_over"));
      return;
    case 1005: 
      onRegisterCommitPassResp(paramBoolean, paramBundle.getInt("code", -1), paramBundle.getString("uin"), paramBundle.getByteArray("promptInfo"), paramBundle.getByteArray("promptInfo_error"));
      return;
    case 1007: 
      onDeleteAccount(paramBoolean);
      return;
    case 1030: 
      label195:
      onGetKeyResp(paramBundle.getString("key"));
      return;
    }
    onChangeToken(paramBoolean, (HashMap)paramBundle.getSerializable("map"));
  }
  
  public void onRegQueryAccountResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte) {}
  
  public void onRegisterCmdCallback(boolean paramBoolean) {}
  
  public void onRegisterCommitMobileResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {}
  
  public void onRegisterCommitPassResp(boolean paramBoolean, int paramInt, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {}
  
  public void onRegisterCommitSmsCodeResp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte) {}
  
  public void onRegisterQuerySmsStatResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3) {}
  
  public void onRegisterSendResendSmsreqResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3) {}
  
  public void onUpdateSKey(String paramString1, String paramString2) {}
  
  public void onUpdateSTwxWeb(String paramString) {}
  
  public void onUpdateSid(String paramString) {}
  
  protected void onUserCancel(String paramString) {}
  
  protected void onlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, long paramLong, boolean paramBoolean3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mqq.observer.AccountObserver
 * JD-Core Version:    0.7.0.1
 */