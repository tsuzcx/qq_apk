package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXEmojiObject
  implements WXMediaMessage.IMediaObject
{
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  private static final String TAG = "MicroMsg.SDK.WXEmojiObject";
  public byte[] emojiData;
  public String emojiPath;
  
  public WXEmojiObject()
  {
    AppMethodBeat.i(194064);
    this.emojiData = null;
    this.emojiPath = null;
    AppMethodBeat.o(194064);
  }
  
  public WXEmojiObject(String paramString)
  {
    AppMethodBeat.i(194066);
    this.emojiPath = paramString;
    AppMethodBeat.o(194066);
  }
  
  public WXEmojiObject(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(194065);
    this.emojiData = paramArrayOfByte;
    AppMethodBeat.o(194065);
  }
  
  private int getFileSize(String paramString)
  {
    AppMethodBeat.i(3943);
    int i = b.a(paramString);
    AppMethodBeat.o(3943);
    return i;
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(3942);
    Object localObject = this.emojiData;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = this.emojiPath;
      if ((localObject == null) || (((String)localObject).length() == 0)) {}
    }
    else
    {
      localObject = this.emojiData;
      if ((localObject != null) && (localObject.length > 10485760))
      {
        Log.e("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiData is too large");
        AppMethodBeat.o(3942);
        return false;
      }
      localObject = this.emojiPath;
      if ((localObject != null) && (getFileSize((String)localObject) > 10485760))
      {
        Log.e("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiSize is too large");
        AppMethodBeat.o(3942);
        return false;
      }
      AppMethodBeat.o(3942);
      return true;
    }
    Log.e("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, both arguments is null");
    AppMethodBeat.o(3942);
    return false;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3940);
    paramBundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
    paramBundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
    AppMethodBeat.o(3940);
  }
  
  public void setEmojiData(byte[] paramArrayOfByte)
  {
    this.emojiData = paramArrayOfByte;
  }
  
  public void setEmojiPath(String paramString)
  {
    this.emojiPath = paramString;
  }
  
  public int type()
  {
    return 8;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3941);
    this.emojiData = paramBundle.getByteArray("_wxemojiobject_emojiData");
    this.emojiPath = paramBundle.getString("_wxemojiobject_emojiPath");
    AppMethodBeat.o(3941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXEmojiObject
 * JD-Core Version:    0.7.0.1
 */