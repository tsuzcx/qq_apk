package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXStateJumpChannelProfileInfo
  implements WXStateSceneDataObject.IWXStateJumpInfo
{
  private static final String TAG = "MicroMsg.SDK.WXStateJumpUrlInfo";
  private static final int USERNAME_LENGTH_LIMIT = 1024;
  public String username;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(242981);
    String str = this.username;
    if ((str != null) && (str.length() > 0))
    {
      if (this.username.length() >= 1024)
      {
        Log.e("MicroMsg.SDK.WXStateJumpUrlInfo", "checkArgs fail, username length exceed limit");
        AppMethodBeat.o(242981);
        return false;
      }
      AppMethodBeat.o(242981);
      return true;
    }
    Log.e("MicroMsg.SDK.WXStateJumpUrlInfo", "checkArgs fail, username is null");
    AppMethodBeat.o(242981);
    return false;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(242975);
    paramBundle.putString("wx_state_jump_channel_profile_username", this.username);
    AppMethodBeat.o(242975);
  }
  
  public int type()
  {
    return 3;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(242978);
    this.username = paramBundle.getString("wx_state_jump_channel_profile_username", "");
    AppMethodBeat.o(242978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXStateJumpChannelProfileInfo
 * JD-Core Version:    0.7.0.1
 */