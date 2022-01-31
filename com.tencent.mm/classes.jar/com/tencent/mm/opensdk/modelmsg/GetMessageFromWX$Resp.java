package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public class GetMessageFromWX$Resp
  extends BaseResp
{
  private static final String TAG = "MicroMsg.SDK.GetMessageFromWX.Resp";
  public WXMediaMessage message;
  
  public GetMessageFromWX$Resp() {}
  
  public GetMessageFromWX$Resp(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  public boolean checkArgs()
  {
    if (this.message == null)
    {
      Log.e("MicroMsg.SDK.GetMessageFromWX.Resp", "checkArgs fail, message is null");
      return false;
    }
    return this.message.checkArgs();
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.message = WXMediaMessage.Builder.fromBundle(paramBundle);
  }
  
  public int getType()
  {
    return 3;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Resp
 * JD-Core Version:    0.7.0.1
 */