package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXVideoObject
  implements WXMediaMessage.IMediaObject
{
  private static final int LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXVideoObject";
  public String videoLowBandUrl;
  public String videoUrl;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128269);
    if (((this.videoUrl == null) || (this.videoUrl.length() == 0)) && ((this.videoLowBandUrl == null) || (this.videoLowBandUrl.length() == 0)))
    {
      Log.e("MicroMsg.SDK.WXVideoObject", "both arguments are null");
      AppMethodBeat.o(128269);
      return false;
    }
    if ((this.videoUrl != null) && (this.videoUrl.length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXVideoObject", "checkArgs fail, videoUrl is too long");
      AppMethodBeat.o(128269);
      return false;
    }
    if ((this.videoLowBandUrl != null) && (this.videoLowBandUrl.length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXVideoObject", "checkArgs fail, videoLowBandUrl is too long");
      AppMethodBeat.o(128269);
      return false;
    }
    AppMethodBeat.o(128269);
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(128267);
    paramBundle.putString("_wxvideoobject_videoUrl", this.videoUrl);
    paramBundle.putString("_wxvideoobject_videoLowBandUrl", this.videoLowBandUrl);
    AppMethodBeat.o(128267);
  }
  
  public int type()
  {
    return 4;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(128268);
    this.videoUrl = paramBundle.getString("_wxvideoobject_videoUrl");
    this.videoLowBandUrl = paramBundle.getString("_wxvideoobject_videoLowBandUrl");
    AppMethodBeat.o(128268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXVideoObject
 * JD-Core Version:    0.7.0.1
 */