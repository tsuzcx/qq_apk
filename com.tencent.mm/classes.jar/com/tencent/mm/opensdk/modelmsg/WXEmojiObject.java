package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXEmojiObject
  implements WXMediaMessage.IMediaObject
{
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  private static final String TAG = "MicroMsg.SDK.WXEmojiObject";
  public byte[] emojiData;
  public String emojiPath;
  
  public WXEmojiObject()
  {
    this.emojiData = null;
    this.emojiPath = null;
  }
  
  public WXEmojiObject(String paramString)
  {
    this.emojiPath = paramString;
  }
  
  public WXEmojiObject(byte[] paramArrayOfByte)
  {
    this.emojiData = paramArrayOfByte;
  }
  
  private int getFileSize(String paramString)
  {
    AppMethodBeat.i(3943);
    int i = d.getFileSize(paramString);
    AppMethodBeat.o(3943);
    return i;
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(3942);
    if (((this.emojiData == null) || (this.emojiData.length == 0)) && ((this.emojiPath == null) || (this.emojiPath.length() == 0)))
    {
      Log.e("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, both arguments is null");
      AppMethodBeat.o(3942);
      return false;
    }
    if ((this.emojiData != null) && (this.emojiData.length > 10485760))
    {
      Log.e("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiData is too large");
      AppMethodBeat.o(3942);
      return false;
    }
    if ((this.emojiPath != null) && (getFileSize(this.emojiPath) > 10485760))
    {
      Log.e("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiSize is too large");
      AppMethodBeat.o(3942);
      return false;
    }
    AppMethodBeat.o(3942);
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXEmojiObject
 * JD-Core Version:    0.7.0.1
 */