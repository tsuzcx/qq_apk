package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXAppExtendObject
  implements WXMediaMessage.IMediaObject
{
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  private static final int EXTINFO_LENGTH_LIMIT = 2048;
  private static final int PATH_LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXAppExtendObject";
  public String extInfo;
  public byte[] fileData;
  public String filePath;
  
  public WXAppExtendObject() {}
  
  public WXAppExtendObject(String paramString1, String paramString2)
  {
    this.extInfo = paramString1;
    this.filePath = paramString2;
  }
  
  public WXAppExtendObject(String paramString, byte[] paramArrayOfByte)
  {
    this.extInfo = paramString;
    this.fileData = paramArrayOfByte;
  }
  
  private int getFileSize(String paramString)
  {
    AppMethodBeat.i(3956);
    int i = d.getFileSize(paramString);
    AppMethodBeat.o(3956);
    return i;
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(3955);
    if (((this.extInfo == null) || (this.extInfo.length() == 0)) && ((this.filePath == null) || (this.filePath.length() == 0)) && ((this.fileData == null) || (this.fileData.length == 0)))
    {
      Log.e("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, all arguments is null");
      AppMethodBeat.o(3955);
      return false;
    }
    if ((this.extInfo != null) && (this.extInfo.length() > 2048))
    {
      Log.e("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, extInfo is invalid");
      AppMethodBeat.o(3955);
      return false;
    }
    if ((this.filePath != null) && (this.filePath.length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, filePath is invalid");
      AppMethodBeat.o(3955);
      return false;
    }
    if ((this.filePath != null) && (getFileSize(this.filePath) > 10485760))
    {
      Log.e("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, fileSize is too large");
      AppMethodBeat.o(3955);
      return false;
    }
    if ((this.fileData != null) && (this.fileData.length > 10485760))
    {
      Log.e("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, fileData is too large");
      AppMethodBeat.o(3955);
      return false;
    }
    AppMethodBeat.o(3955);
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3953);
    paramBundle.putString("_wxappextendobject_extInfo", this.extInfo);
    paramBundle.putByteArray("_wxappextendobject_fileData", this.fileData);
    paramBundle.putString("_wxappextendobject_filePath", this.filePath);
    AppMethodBeat.o(3953);
  }
  
  public int type()
  {
    return 7;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3954);
    this.extInfo = paramBundle.getString("_wxappextendobject_extInfo");
    this.fileData = paramBundle.getByteArray("_wxappextendobject_fileData");
    this.filePath = paramBundle.getString("_wxappextendobject_filePath");
    AppMethodBeat.o(3954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXAppExtendObject
 * JD-Core Version:    0.7.0.1
 */