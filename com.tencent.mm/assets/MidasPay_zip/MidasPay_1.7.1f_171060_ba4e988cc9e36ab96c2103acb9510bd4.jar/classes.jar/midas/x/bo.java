package midas.x;

import com.tencent.midas.comm.APLog;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class bo
  extends WtloginListener
{
  private final int a = -1;
  private final int b = -2;
  private bk c;
  
  public bo(bk parambk)
  {
    this.c = parambk;
  }
  
  public void OnException(ErrMsg paramErrMsg, int paramInt, WUserSigInfo paramWUserSigInfo) {}
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    paramErrMsg = new StringBuilder();
    paramErrMsg.append("OnGetStWithoutPasswd Result onQuickLogin ret:");
    paramErrMsg.append(paramInt2);
    APLog.i("APWtloginSDK", paramErrMsg.toString());
    if (paramInt2 != 0)
    {
      if (util.shouldKick(paramInt2))
      {
        paramString = this.c;
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append(" shouldKick ret:");
        paramWUserSigInfo.append(paramInt2);
        paramString.a(-1, paramWUserSigInfo.toString());
        return;
      }
      paramString = this.c;
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("  login failed, ret error cod ret:");
      paramWUserSigInfo.append(paramInt2);
      paramString.a(-2, paramWUserSigInfo.toString());
      return;
    }
    paramWUserSigInfo = a(paramWUserSigInfo, paramString);
    this.c.a(paramString, paramWUserSigInfo, "2");
  }
  
  public String a(WUserSigInfo paramWUserSigInfo, String paramString)
  {
    return new String(WtloginHelper.GetTicketSig(paramWUserSigInfo, 4096));
  }
  
  public void onQuickLogin(String paramString, WtloginHelper.QuickLoginParam paramQuickLoginParam, int paramInt, ErrMsg paramErrMsg)
  {
    APLog.i("APWtloginSDK", "onQuickLogin Result onQuickLogin");
    if (paramInt != 0)
    {
      if (util.shouldKick(paramInt))
      {
        paramString = this.c;
        paramQuickLoginParam = new StringBuilder();
        paramQuickLoginParam.append(" shouldKick ret:");
        paramQuickLoginParam.append(paramInt);
        paramString.a(-1, paramQuickLoginParam.toString());
        return;
      }
      paramString = this.c;
      paramQuickLoginParam = new StringBuilder();
      paramQuickLoginParam.append("  login failed, ret error cod ret:");
      paramQuickLoginParam.append(paramInt);
      paramString.a(-2, paramQuickLoginParam.toString());
      return;
    }
    paramQuickLoginParam = a(paramQuickLoginParam.userSigInfo, paramString);
    this.c.a(paramString, paramQuickLoginParam, "2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.bo
 * JD-Core Version:    0.7.0.1
 */