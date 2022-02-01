package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXGameVideoFileObject
  implements WXMediaMessage.IMediaObject
{
  private static final int FILE_SIZE_LIMIT = 104857600;
  private static final String TAG = "MicroMsg.SDK.WXGameVideoFileObject";
  private static final int URL_LENGTH_LIMIT = 10240;
  public String filePath;
  public String thumbUrl;
  public String videoUrl;
  
  public WXGameVideoFileObject()
  {
    AppMethodBeat.i(196950);
    this.filePath = null;
    this.videoUrl = null;
    this.thumbUrl = null;
    AppMethodBeat.o(196950);
  }
  
  public WXGameVideoFileObject(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(196951);
    this.filePath = paramString1;
    this.videoUrl = paramString2;
    this.thumbUrl = paramString3;
    AppMethodBeat.o(196951);
  }
  
  private int getFileSize(String paramString)
  {
    AppMethodBeat.i(4027);
    int i = b.a(paramString);
    AppMethodBeat.o(4027);
    return i;
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(4026);
    String str = this.filePath;
    if ((str != null) && (str.length() != 0))
    {
      if (getFileSize(this.filePath) > 104857600)
      {
        Log.e("MicroMsg.SDK.WXGameVideoFileObject", "checkArgs fail, video file size is too large");
        AppMethodBeat.o(4026);
        return false;
      }
      str = this.videoUrl;
      if ((str != null) && (str.length() > 10240))
      {
        Log.e("MicroMsg.SDK.WXGameVideoFileObject", "checkArgs fail, videoUrl is too long");
        AppMethodBeat.o(4026);
        return false;
      }
      str = this.thumbUrl;
      if ((str != null) && (str.length() > 10240))
      {
        Log.e("MicroMsg.SDK.WXGameVideoFileObject", "checkArgs fail, thumbUrl is too long");
        AppMethodBeat.o(4026);
        return false;
      }
      AppMethodBeat.o(4026);
      return true;
    }
    Log.e("MicroMsg.SDK.WXGameVideoFileObject", "checkArgs fail, filePath is null");
    AppMethodBeat.o(4026);
    return false;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(4024);
    paramBundle.putString("_wxvideofileobject_filePath", this.filePath);
    paramBundle.putString("_wxvideofileobject_cdnUrl", this.videoUrl);
    paramBundle.putString("_wxvideofileobject_thumbUrl", this.thumbUrl);
    AppMethodBeat.o(4024);
  }
  
  public int type()
  {
    return 39;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(4025);
    this.filePath = paramBundle.getString("_wxvideofileobject_filePath");
    this.videoUrl = paramBundle.getString("_wxvideofileobject_cdnUrl");
    this.thumbUrl = paramBundle.getString("_wxvideofileobject_thumbUrl");
    AppMethodBeat.o(4025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject
 * JD-Core Version:    0.7.0.1
 */