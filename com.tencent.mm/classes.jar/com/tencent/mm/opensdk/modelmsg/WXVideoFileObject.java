package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXVideoFileObject
  implements WXMediaMessage.IMediaObject
{
  public static final int FILE_SIZE_LIMIT = 104857600;
  private static final String TAG = "MicroMsg.SDK.WXVideoFileObject";
  public static final int WXVideoFileShareSceneCommon = 0;
  public static final int WXVideoFileShareSceneFromWX = 1;
  public String filePath;
  public int shareScene = 0;
  public String shareTicket;
  
  public WXVideoFileObject()
  {
    this.filePath = null;
  }
  
  public WXVideoFileObject(String paramString)
  {
    this.filePath = paramString;
  }
  
  private int getFileSize(String paramString)
  {
    AppMethodBeat.i(3961);
    int i = d.getFileSize(paramString);
    AppMethodBeat.o(3961);
    return i;
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(3960);
    if ((this.filePath == null) || (this.filePath.length() == 0))
    {
      Log.e("MicroMsg.SDK.WXVideoFileObject", "checkArgs fail, filePath is null");
      AppMethodBeat.o(3960);
      return false;
    }
    if (getFileSize(this.filePath) > 104857600)
    {
      Log.e("MicroMsg.SDK.WXVideoFileObject", "checkArgs fail, video file size is too large");
      AppMethodBeat.o(3960);
      return false;
    }
    AppMethodBeat.o(3960);
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3958);
    paramBundle.putString("_wxvideofileobject_filePath", this.filePath);
    paramBundle.putInt("_wxvideofileobject_shareScene", this.shareScene);
    paramBundle.putString("_wxvideofileobject_shareTicketh", this.shareTicket);
    AppMethodBeat.o(3958);
  }
  
  public int type()
  {
    return 38;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3959);
    this.filePath = paramBundle.getString("_wxvideofileobject_filePath");
    this.shareScene = paramBundle.getInt("_wxvideofileobject_shareScene", 0);
    this.shareTicket = paramBundle.getString("_wxvideofileobject_shareTicketh");
    AppMethodBeat.o(3959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXVideoFileObject
 * JD-Core Version:    0.7.0.1
 */