package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.ErrMsg;

class WtloginHelper$HelperThread$7
  implements Runnable
{
  WtloginHelper$HelperThread$7(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$600(this.this$1);
    if (this.val$cancel != 0) {}
    ErrMsg localErrMsg;
    do
    {
      return;
      async_context localasync_context = u.b(this.this$1.mUserSigInfo._seqence);
      localErrMsg = localasync_context._last_err_msg;
      u.c(this.this$1.mUserSigInfo._seqence);
      WtloginHelper.HelperThread.access$700(this.this$1, localasync_context);
      WtloginHelper.HelperThread.access$800(this.this$1, localasync_context, this.val$ret);
      if (this.this$1.mDwDstAppid == WtloginHelper.access$1500(this.this$1.this$0))
      {
        this.this$1.mDwDstAppid = this.this$1.mDwSubDstAppid;
        this.this$1.mDwSubDstAppid = 0L;
      }
      if (this.this$1.mPromise != null)
      {
        localErrMsg.setType(this.val$ret);
        if (this.val$ret == 0)
        {
          this.this$1.mPromise.Done(null);
          return;
        }
        if (this.val$ret == -1000)
        {
          this.this$1.mPromise.Timeout(localErrMsg);
          return;
        }
        this.this$1.mPromise.Failed(localErrMsg);
        return;
      }
    } while (WtloginHelper.access$200(this.this$1.mHelper) == null);
    if ((this.this$1.mDwDstSubAppidList == null) && (!WtloginHelper.access$300(this.this$1.this$0).e()))
    {
      WtloginHelper.access$200(this.this$1.mHelper).OnGetStWithoutPasswd(this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mDwDstAppid, this.this$1.mDwMainSigMap, this.this$1.mDwSubDstAppid, this.this$1.mUserSigInfo, this.val$ret, localErrMsg);
      return;
    }
    WtloginHelper.access$200(this.this$1.mHelper).OnGetStWithoutPasswd(this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mDwDstAppid, this.this$1.mDwMainSigMap, this.this$1.mDwSubDstAppid, this.this$1.mDwDstSubAppidList, this.this$1.mUserSigInfo, this.this$1.mST, this.val$ret, localErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread.7
 * JD-Core Version:    0.7.0.1
 */