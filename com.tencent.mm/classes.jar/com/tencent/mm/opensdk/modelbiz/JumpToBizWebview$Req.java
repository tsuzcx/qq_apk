package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public class JumpToBizWebview$Req
  extends BaseReq
{
  private static final int EXT_MSG_LENGTH = 1024;
  private static final String TAG = "MicroMsg.SDK.JumpToBizWebview.Req";
  public String extMsg;
  public int scene = 1;
  public String toUserName;
  public int webType;
  
  public boolean checkArgs()
  {
    if ((this.toUserName == null) || (this.toUserName.length() <= 0))
    {
      Log.e("MicroMsg.SDK.JumpToBizWebview.Req", "checkArgs fail, toUserName is invalid");
      return false;
    }
    if ((this.extMsg != null) && (this.extMsg.length() > 1024))
    {
      Log.e("MicroMsg.SDK.JumpToBizWebview.Req", "ext msg is not null, while the length exceed 1024 bytes");
      return false;
    }
    return true;
  }
  
  public int getType()
  {
    return 8;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
    paramBundle.putString("_wxapi_jump_to_biz_webview_req_ext_msg", this.extMsg);
    paramBundle.putInt("_wxapi_jump_to_biz_webview_req_web_type", this.webType);
    paramBundle.putInt("_wxapi_jump_to_biz_webview_req_scene", this.scene);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.JumpToBizWebview.Req
 * JD-Core Version:    0.7.0.1
 */