package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

public abstract class WXChannelBaseJumpInfo
  implements IWXChannelJumpInfo
{
  private static final String TAG = "MicroMsg.SDK.WXChannelBaseJumpInfo";
  private static final int WORDING_LENGTH_LIMIT = 1024;
  public String extra;
  public String wording;
  
  public boolean checkArgs()
  {
    String str = this.wording;
    if ((str != null) && (str.length() >= 1024))
    {
      Log.e("MicroMsg.SDK.WXChannelBaseJumpInfo", "checkArgs fail, wording is invalid");
      return false;
    }
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("wx_channel_jump_base_wording", this.wording);
    paramBundle.putString("wx_channel_jump_base_extra", this.extra);
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.wording = paramBundle.getString("wx_channel_jump_base_wording");
    this.extra = paramBundle.getString("wx_channel_jump_base_extra");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXChannelBaseJumpInfo
 * JD-Core Version:    0.7.0.1
 */