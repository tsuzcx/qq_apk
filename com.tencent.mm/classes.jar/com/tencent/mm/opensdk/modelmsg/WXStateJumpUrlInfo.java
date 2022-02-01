package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXStateJumpUrlInfo
  implements WXStateSceneDataObject.IWXStateJumpInfo
{
  private static final int LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXStateJumpUrlInfo";
  public String jumpUrl;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(242994);
    String str = this.jumpUrl;
    if ((str != null) && (str.length() > 0))
    {
      if (this.jumpUrl.length() >= 10240)
      {
        Log.e("MicroMsg.SDK.WXStateJumpUrlInfo", "checkArgs fail, jumpUrl is invalid");
        AppMethodBeat.o(242994);
        return false;
      }
      AppMethodBeat.o(242994);
      return true;
    }
    Log.e("MicroMsg.SDK.WXStateJumpUrlInfo", "checkArgs fail, jumpUrl is null");
    AppMethodBeat.o(242994);
    return false;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(242989);
    paramBundle.putString("wx_state_jump_url", this.jumpUrl);
    AppMethodBeat.o(242989);
  }
  
  public int type()
  {
    return 1;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(242991);
    this.jumpUrl = paramBundle.getString("wx_state_jump_url", "");
    AppMethodBeat.o(242991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXStateJumpUrlInfo
 * JD-Core Version:    0.7.0.1
 */