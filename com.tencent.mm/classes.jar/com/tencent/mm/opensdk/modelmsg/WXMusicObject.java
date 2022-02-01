package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXMusicObject
  implements WXMediaMessage.IMediaObject
{
  private static final int LENGTH_LIMIT = 10240;
  private static final int LYRIC_LENGTH_LIMIT = 32768;
  private static final String TAG = "MicroMsg.SDK.WXMusicObject";
  public String musicDataUrl;
  public String musicLowBandDataUrl;
  public String musicLowBandUrl;
  public String musicUrl;
  public String songAlbumUrl;
  public String songLyric;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(3979);
    String str = this.musicUrl;
    if ((str == null) || (str.length() == 0))
    {
      str = this.musicLowBandUrl;
      if ((str == null) || (str.length() == 0)) {}
    }
    else
    {
      str = this.musicUrl;
      if ((str != null) && (str.length() > 10240))
      {
        Log.e("MicroMsg.SDK.WXMusicObject", "checkArgs fail, musicUrl is too long");
        AppMethodBeat.o(3979);
        return false;
      }
      str = this.musicLowBandUrl;
      if ((str != null) && (str.length() > 10240))
      {
        Log.e("MicroMsg.SDK.WXMusicObject", "checkArgs fail, musicLowBandUrl is too long");
        AppMethodBeat.o(3979);
        return false;
      }
      str = this.songAlbumUrl;
      if ((str != null) && (str.length() > 10240))
      {
        Log.e("MicroMsg.SDK.WXMusicObject", "checkArgs fail, songAlbumUrl is too long");
        AppMethodBeat.o(3979);
        return false;
      }
      str = this.songLyric;
      if ((str != null) && (str.length() > 32768))
      {
        Log.e("MicroMsg.SDK.WXMusicObject", "checkArgs fail, songLyric is too long");
        AppMethodBeat.o(3979);
        return false;
      }
      AppMethodBeat.o(3979);
      return true;
    }
    Log.e("MicroMsg.SDK.WXMusicObject", "both arguments are null");
    AppMethodBeat.o(3979);
    return false;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3977);
    paramBundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
    paramBundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
    paramBundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
    paramBundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
    paramBundle.putString("_wxmusicobject_musicAlbumUrl", this.songAlbumUrl);
    paramBundle.putString("_wxmusicobject_musicLyric", this.songLyric);
    AppMethodBeat.o(3977);
  }
  
  public int type()
  {
    return 3;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3978);
    this.musicUrl = paramBundle.getString("_wxmusicobject_musicUrl");
    this.musicLowBandUrl = paramBundle.getString("_wxmusicobject_musicLowBandUrl");
    this.musicDataUrl = paramBundle.getString("_wxmusicobject_musicDataUrl");
    this.musicLowBandDataUrl = paramBundle.getString("_wxmusicobject_musicLowBandDataUrl");
    this.songAlbumUrl = paramBundle.getString("_wxmusicobject_musicAlbumUrl");
    this.songLyric = paramBundle.getString("_wxmusicobject_musicLyric");
    AppMethodBeat.o(3978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXMusicObject
 * JD-Core Version:    0.7.0.1
 */