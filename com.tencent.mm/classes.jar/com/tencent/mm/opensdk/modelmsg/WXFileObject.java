package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXFileObject
  implements WXMediaMessage.IMediaObject
{
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  private static final String TAG = "MicroMsg.SDK.WXFileObject";
  private int contentLengthLimit = 10485760;
  public byte[] fileData;
  public String filePath;
  
  public WXFileObject()
  {
    this.fileData = null;
    this.filePath = null;
  }
  
  public WXFileObject(String paramString)
  {
    this.filePath = paramString;
  }
  
  public WXFileObject(byte[] paramArrayOfByte)
  {
    this.fileData = paramArrayOfByte;
  }
  
  private int getFileSize(String paramString)
  {
    AppMethodBeat.i(4007);
    int i = d.getFileSize(paramString);
    AppMethodBeat.o(4007);
    return i;
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(4006);
    if (((this.fileData == null) || (this.fileData.length == 0)) && ((this.filePath == null) || (this.filePath.length() == 0)))
    {
      Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, both arguments is null");
      AppMethodBeat.o(4006);
      return false;
    }
    if ((this.fileData != null) && (this.fileData.length > this.contentLengthLimit))
    {
      Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileData is too large");
      AppMethodBeat.o(4006);
      return false;
    }
    if ((this.filePath != null) && (getFileSize(this.filePath) > this.contentLengthLimit))
    {
      Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileSize is too large");
      AppMethodBeat.o(4006);
      return false;
    }
    AppMethodBeat.o(4006);
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(4004);
    paramBundle.putByteArray("_wxfileobject_fileData", this.fileData);
    paramBundle.putString("_wxfileobject_filePath", this.filePath);
    AppMethodBeat.o(4004);
  }
  
  public void setContentLengthLimit(int paramInt)
  {
    this.contentLengthLimit = paramInt;
  }
  
  public void setFileData(byte[] paramArrayOfByte)
  {
    this.fileData = paramArrayOfByte;
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public int type()
  {
    return 6;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(4005);
    this.fileData = paramBundle.getByteArray("_wxfileobject_fileData");
    this.filePath = paramBundle.getString("_wxfileobject_filePath");
    AppMethodBeat.o(4005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXFileObject
 * JD-Core Version:    0.7.0.1
 */