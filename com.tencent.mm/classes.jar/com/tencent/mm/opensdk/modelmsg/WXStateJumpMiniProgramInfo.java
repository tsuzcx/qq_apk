package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXStateJumpMiniProgramInfo
  implements WXStateSceneDataObject.IWXStateJumpInfo
{
  private static final String TAG = "MicroMsg.SDK.WXStateJumpUrlInfo";
  public int miniProgramType;
  public String path;
  public String username;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(243005);
    String str = this.username;
    if ((str != null) && (str.length() > 0))
    {
      AppMethodBeat.o(243005);
      return true;
    }
    Log.e("MicroMsg.SDK.WXStateJumpUrlInfo", "checkArgs fail, username is null");
    AppMethodBeat.o(243005);
    return false;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(242998);
    paramBundle.putString("wx_state_jump_mini_program_username", this.username);
    paramBundle.putString("wx_state_jump_mini_program_path", this.path);
    paramBundle.putInt("wx_state_jump_mini_program_type", this.miniProgramType);
    AppMethodBeat.o(242998);
  }
  
  public int type()
  {
    return 2;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(243004);
    this.username = paramBundle.getString("wx_state_jump_mini_program_username", "");
    this.path = paramBundle.getString("wx_state_jump_mini_program_path", "");
    this.miniProgramType = paramBundle.getInt("wx_state_jump_mini_program_type", 0);
    AppMethodBeat.o(243004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXStateJumpMiniProgramInfo
 * JD-Core Version:    0.7.0.1
 */