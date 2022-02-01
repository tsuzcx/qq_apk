package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXChannelJumpUrlInfo
  extends WXChannelBaseJumpInfo
{
  private static final int LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXChannelJumpUrlInfo";
  public String url;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(243070);
    String str = this.url;
    if ((str != null) && (str.length() > 0))
    {
      if (this.url.length() >= 10240)
      {
        Log.e("MicroMsg.SDK.WXChannelJumpUrlInfo", "checkArgs fail, url is invalid");
        AppMethodBeat.o(243070);
        return false;
      }
      AppMethodBeat.o(243070);
      return true;
    }
    Log.e("MicroMsg.SDK.WXChannelJumpUrlInfo", "checkArgs fail, url is null");
    AppMethodBeat.o(243070);
    return false;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(243063);
    super.serialize(paramBundle);
    paramBundle.putString("wx_channel_jump_url", this.url);
    AppMethodBeat.o(243063);
  }
  
  public int type()
  {
    return 2;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(243067);
    super.unserialize(paramBundle);
    this.url = paramBundle.getString("wx_channel_jump_url");
    AppMethodBeat.o(243067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXChannelJumpUrlInfo
 * JD-Core Version:    0.7.0.1
 */