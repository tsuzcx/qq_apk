package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXMusicObject
  implements WXMediaMessage.IMediaObject
{
  private static final int LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXMusicObject";
  public String musicDataUrl;
  public String musicLowBandDataUrl;
  public String musicLowBandUrl;
  public String musicUrl;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128279);
    if (((this.musicUrl == null) || (this.musicUrl.length() == 0)) && ((this.musicLowBandUrl == null) || (this.musicLowBandUrl.length() == 0)))
    {
      Log.e("MicroMsg.SDK.WXMusicObject", "both arguments are null");
      AppMethodBeat.o(128279);
      return false;
    }
    if ((this.musicUrl != null) && (this.musicUrl.length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXMusicObject", "checkArgs fail, musicUrl is too long");
      AppMethodBeat.o(128279);
      return false;
    }
    if ((this.musicLowBandUrl != null) && (this.musicLowBandUrl.length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXMusicObject", "checkArgs fail, musicLowBandUrl is too long");
      AppMethodBeat.o(128279);
      return false;
    }
    AppMethodBeat.o(128279);
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(128277);
    paramBundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
    paramBundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
    paramBundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
    paramBundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
    AppMethodBeat.o(128277);
  }
  
  public int type()
  {
    return 3;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(128278);
    this.musicUrl = paramBundle.getString("_wxmusicobject_musicUrl");
    this.musicLowBandUrl = paramBundle.getString("_wxmusicobject_musicLowBandUrl");
    this.musicDataUrl = paramBundle.getString("_wxmusicobject_musicDataUrl");
    this.musicLowBandDataUrl = paramBundle.getString("_wxmusicobject_musicLowBandDataUrl");
    AppMethodBeat.o(128278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXMusicObject
 * JD-Core Version:    0.7.0.1
 */