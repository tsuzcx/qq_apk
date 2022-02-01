package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXMusicVipInfo
  implements SendMessageToWX.IWXMusicVipObject
{
  private static final int LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXMusicVipInfo";
  public String musicId;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(242976);
    String str = this.musicId;
    if ((str != null) && (str.length() > 0))
    {
      if (this.musicId.length() > 10240)
      {
        Log.e("MicroMsg.SDK.WXMusicVipInfo", "checkArgs fail, musicId length is larger than 1024");
        AppMethodBeat.o(242976);
        return false;
      }
      AppMethodBeat.o(242976);
      return true;
    }
    Log.e("MicroMsg.SDK.WXMusicVipInfo", "checkArgs fail, musicId is null");
    AppMethodBeat.o(242976);
    return false;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(242970);
    paramBundle.putString("wx_music_vip_id", this.musicId);
    AppMethodBeat.o(242970);
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(242973);
    this.musicId = paramBundle.getString("wx_music_vip_id", "");
    AppMethodBeat.o(242973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXMusicVipInfo
 * JD-Core Version:    0.7.0.1
 */