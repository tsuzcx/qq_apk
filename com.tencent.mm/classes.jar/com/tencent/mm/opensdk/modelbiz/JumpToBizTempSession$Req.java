package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public class JumpToBizTempSession$Req
  extends BaseReq
{
  private static final int MAX_SESSION_FROM_LENGTH = 1024;
  private static final String TAG = "MicroMsg.SDK.JumpToBizTempSession.Req";
  public String sessionFrom;
  public int showType;
  public String toUserName;
  
  public boolean checkArgs()
  {
    if ((this.toUserName == null) || (this.toUserName.length() <= 0))
    {
      Log.e("MicroMsg.SDK.JumpToBizTempSession.Req", "checkArgs fail, toUserName is invalid");
      return false;
    }
    if ((this.sessionFrom == null) || (this.sessionFrom.length() > 1024))
    {
      Log.e("MicroMsg.SDK.JumpToBizTempSession.Req", "checkArgs fail, sessionFrom is invalid");
      return false;
    }
    return true;
  }
  
  public int getType()
  {
    return 10;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
    paramBundle.putString("_wxapi_jump_to_biz_webview_req_session_from", this.sessionFrom);
    paramBundle.putInt("_wxapi_jump_to_biz_webview_req_show_type", this.showType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.JumpToBizTempSession.Req
 * JD-Core Version:    0.7.0.1
 */