package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

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
    AppMethodBeat.i(190394);
    this.extInfo = paramString1;
    this.filePath = paramString2;
    AppMethodBeat.o(190394);
  }
  
  public WXAppExtendObject(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(190393);
    this.extInfo = paramString;
    this.fileData = paramArrayOfByte;
    AppMethodBeat.o(190393);
  }
  
  private int getFileSize(String paramString)
  {
    AppMethodBeat.i(3956);
    int i = b.a(paramString);
    AppMethodBeat.o(3956);
    return i;
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(3955);
    Object localObject = this.extInfo;
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      localObject = this.filePath;
      if ((localObject == null) || (((String)localObject).length() == 0))
      {
        localObject = this.fileData;
        if ((localObject == null) || (localObject.length == 0)) {
          break label193;
        }
      }
    }
    localObject = this.extInfo;
    if ((localObject != null) && (((String)localObject).length() > 2048))
    {
      Log.e("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, extInfo is invalid");
      AppMethodBeat.o(3955);
      return false;
    }
    localObject = this.filePath;
    if ((localObject != null) && (((String)localObject).length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, filePath is invalid");
      AppMethodBeat.o(3955);
      return false;
    }
    localObject = this.filePath;
    if ((localObject != null) && (getFileSize((String)localObject) > 10485760))
    {
      Log.e("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, fileSize is too large");
      AppMethodBeat.o(3955);
      return false;
    }
    localObject = this.fileData;
    if ((localObject != null) && (localObject.length > 10485760))
    {
      Log.e("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, fileData is too large");
      AppMethodBeat.o(3955);
      return false;
    }
    AppMethodBeat.o(3955);
    return true;
    label193:
    Log.e("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, all arguments is null");
    AppMethodBeat.o(3955);
    return false;
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