package com.tencent.mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class WXImageObject
  implements WXMediaMessage.IMediaObject
{
  private static final int CONTENT_LENGTH_LIMIT = 26214400;
  private static final int PATH_LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXImageObject";
  public byte[] imageData;
  public String imagePath;
  
  public WXImageObject() {}
  
  public WXImageObject(Bitmap paramBitmap)
  {
    AppMethodBeat.i(128286);
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
      this.imageData = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      AppMethodBeat.o(128286);
      return;
    }
    catch (Exception paramBitmap)
    {
      Log.e("MicroMsg.SDK.WXImageObject", "WXImageObject <init>, exception:" + paramBitmap.getMessage());
      AppMethodBeat.o(128286);
    }
  }
  
  public WXImageObject(byte[] paramArrayOfByte)
  {
    this.imageData = paramArrayOfByte;
  }
  
  private int getFileSize(String paramString)
  {
    AppMethodBeat.i(128290);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(128290);
      return 0;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      AppMethodBeat.o(128290);
      return 0;
    }
    int i = (int)paramString.length();
    AppMethodBeat.o(128290);
    return i;
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128289);
    if (((this.imageData == null) || (this.imageData.length == 0)) && ((this.imagePath == null) || (this.imagePath.length() == 0)))
    {
      Log.e("MicroMsg.SDK.WXImageObject", "checkArgs fail, all arguments are null");
      AppMethodBeat.o(128289);
      return false;
    }
    if ((this.imageData != null) && (this.imageData.length > 26214400))
    {
      Log.e("MicroMsg.SDK.WXImageObject", "checkArgs fail, content is too large");
      AppMethodBeat.o(128289);
      return false;
    }
    if ((this.imagePath != null) && (this.imagePath.length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXImageObject", "checkArgs fail, path is invalid");
      AppMethodBeat.o(128289);
      return false;
    }
    if ((this.imagePath != null) && (getFileSize(this.imagePath) > 26214400))
    {
      Log.e("MicroMsg.SDK.WXImageObject", "checkArgs fail, image content is too large");
      AppMethodBeat.o(128289);
      return false;
    }
    AppMethodBeat.o(128289);
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(128287);
    paramBundle.putByteArray("_wximageobject_imageData", this.imageData);
    paramBundle.putString("_wximageobject_imagePath", this.imagePath);
    AppMethodBeat.o(128287);
  }
  
  public void setImagePath(String paramString)
  {
    this.imagePath = paramString;
  }
  
  public int type()
  {
    return 2;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(128288);
    this.imageData = paramBundle.getByteArray("_wximageobject_imageData");
    this.imagePath = paramBundle.getString("_wximageobject_imagePath");
    AppMethodBeat.o(128288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXImageObject
 * JD-Core Version:    0.7.0.1
 */