package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXChannelJumpMiniProgramInfo
  extends WXChannelBaseJumpInfo
{
  private static final int LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXChannelJumpMiniProgramInfo";
  public String path;
  public String username;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(243038);
    String str = this.username;
    if ((str != null) && (str.length() > 0))
    {
      str = this.path;
      if ((str != null) && (str.length() >= 10240))
      {
        Log.e("MicroMsg.SDK.WXChannelJumpMiniProgramInfo", "checkArgs fail, path is invalid");
        AppMethodBeat.o(243038);
        return false;
      }
      boolean bool = super.checkArgs();
      AppMethodBeat.o(243038);
      return bool;
    }
    Log.e("MicroMsg.SDK.WXChannelJumpMiniProgramInfo", "checkArgs fail, username is null");
    AppMethodBeat.o(243038);
    return false;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(243032);
    super.serialize(paramBundle);
    paramBundle.putString("wx_channel_jump_mini_program_username", this.username);
    paramBundle.putString("wx_channel_jump_mini_program_path", this.path);
    AppMethodBeat.o(243032);
  }
  
  public int type()
  {
    return 1;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(243035);
    super.unserialize(paramBundle);
    this.username = paramBundle.getString("wx_channel_jump_mini_program_username");
    this.path = paramBundle.getString("wx_channel_jump_mini_program_path");
    AppMethodBeat.o(243035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXChannelJumpMiniProgramInfo
 * JD-Core Version:    0.7.0.1
 */