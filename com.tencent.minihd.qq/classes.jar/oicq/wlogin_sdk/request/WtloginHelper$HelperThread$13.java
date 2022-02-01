package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.ErrMsg;

class WtloginHelper$HelperThread$13
  implements Runnable
{
  WtloginHelper$HelperThread$13(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$600(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    async_context localasync_context = u.b(this.this$1.mUserSigInfo._seqence);
    ErrMsg localErrMsg = localasync_context._last_err_msg;
    WtloginHelper.access$200(this.this$1.mHelper).OnRefreshSMSVerifyLoginCode(this.this$1.mUserAccount, localasync_context._smslogin_msg, localasync_context._smslogin_msgcnt, localasync_context._smslogin_timelimit, this.this$1.mUserSigInfo, this.val$ret, localErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.13
 * JD-Core Version:    0.7.0.1
 */