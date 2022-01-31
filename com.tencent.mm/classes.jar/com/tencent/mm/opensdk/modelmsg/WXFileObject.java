package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import java.io.File;

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
    AppMethodBeat.i(128307);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(128307);
      return 0;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      AppMethodBeat.o(128307);
      return 0;
    }
    int i = (int)paramString.length();
    AppMethodBeat.o(128307);
    return i;
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128306);
    if (((this.fileData == null) || (this.fileData.length == 0)) && ((this.filePath == null) || (this.filePath.length() == 0)))
    {
      Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, both arguments is null");
      AppMethodBeat.o(128306);
      return false;
    }
    if ((this.fileData != null) && (this.fileData.length > this.contentLengthLimit))
    {
      Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileData is too large");
      AppMethodBeat.o(128306);
      return false;
    }
    if ((this.filePath != null) && (getFileSize(this.filePath) > this.contentLengthLimit))
    {
      Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileSize is too large");
      AppMethodBeat.o(128306);
      return false;
    }
    AppMethodBeat.o(128306);
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(128304);
    paramBundle.putByteArray("_wxfileobject_fileData", this.fileData);
    paramBundle.putString("_wxfileobject_filePath", this.filePath);
    AppMethodBeat.o(128304);
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
    AppMethodBeat.i(128305);
    this.fileData = paramBundle.getByteArray("_wxfileobject_fileData");
    this.filePath = paramBundle.getString("_wxfileobject_filePath");
    AppMethodBeat.o(128305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXFileObject
 * JD-Core Version:    0.7.0.1
 */