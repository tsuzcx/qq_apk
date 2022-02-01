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
    AppMethodBeat.i(3969);
    String str = this.videoUrl;
    if ((str == null) || (str.length() == 0))
    {
      str = this.videoLowBandUrl;
      if ((str == null) || (str.length() == 0)) {}
    }
    else
    {
      str = this.videoUrl;
      if ((str != null) && (str.length() > 10240))
      {
        Log.e("MicroMsg.SDK.WXVideoObject", "checkArgs fail, videoUrl is too long");
        AppMethodBeat.o(3969);
        return false;
      }
      str = this.videoLowBandUrl;
      if ((str != null) && (str.length() > 10240))
      {
        Log.e("MicroMsg.SDK.WXVideoObject", "checkArgs fail, videoLowBandUrl is too long");
        AppMethodBeat.o(3969);
        return false;
      }
      AppMethodBeat.o(3969);
      return true;
    }
    Log.e("MicroMsg.SDK.WXVideoObject", "both arguments are null");
    AppMethodBeat.o(3969);
    return false;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3967);
    paramBundle.putString("_wxvideoobject_videoUrl", this.videoUrl);
    paramBundle.putString("_wxvideoobject_videoLowBandUrl", this.videoLowBandUrl);
    AppMethodBeat.o(3967);
  }
  
  public int type()
  {
    return 4;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3968);
    this.videoUrl = paramBundle.getString("_wxvideoobject_videoUrl");
    this.videoLowBandUrl = paramBundle.getString("_wxvideoobject_videoLowBandUrl");
    AppMethodBeat.o(3968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXVideoObject
 * JD-Core Version:    0.7.0.1
 */