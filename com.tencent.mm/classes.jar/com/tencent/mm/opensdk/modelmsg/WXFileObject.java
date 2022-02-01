package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXFileObject
  implements WXMediaMessage.IMediaObject
{
  private static final int CONTENT_LENGTH_LIMIT = 1920991232;
  private static final String TAG = "MicroMsg.SDK.WXFileObject";
  private int contentLengthLimit;
  public byte[] fileData;
  public String filePath;
  
  public WXFileObject()
  {
    AppMethodBeat.i(254954);
    this.contentLengthLimit = 1920991232;
    this.fileData = null;
    this.filePath = null;
    AppMethodBeat.o(254954);
  }
  
  public WXFileObject(String paramString)
  {
    AppMethodBeat.i(254957);
    this.contentLengthLimit = 1920991232;
    this.filePath = paramString;
    AppMethodBeat.o(254957);
  }
  
  public WXFileObject(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(254956);
    this.contentLengthLimit = 1920991232;
    this.fileData = paramArrayOfByte;
    AppMethodBeat.o(254956);
  }
  
  private int getFileSize(String paramString)
  {
    AppMethodBeat.i(4007);
    int i = b.a(paramString);
    AppMethodBeat.o(4007);
    return i;
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(4006);
    Object localObject = this.fileData;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = this.filePath;
      if ((localObject == null) || (((String)localObject).length() == 0)) {}
    }
    else
    {
      localObject = this.fileData;
      if ((localObject != null) && (localObject.length > this.contentLengthLimit))
      {
        Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileData is too large");
        AppMethodBeat.o(4006);
        return false;
      }
      localObject = this.filePath;
      if ((localObject != null) && (getFileSize((String)localObject) > this.contentLengthLimit))
      {
        Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileSize is too large");
        AppMethodBeat.o(4006);
        return false;
      }
      AppMethodBeat.o(4006);
      return true;
    }
    Log.e("MicroMsg.SDK.WXFileObject", "checkArgs fail, both arguments is null");
    AppMethodBeat.o(4006);
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXFileObject
 * JD-Core Version:    0.7.0.1
 */