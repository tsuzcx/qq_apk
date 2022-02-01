package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXTextObject
  implements WXMediaMessage.IMediaObject
{
  private static final int LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXTextObject";
  public String text;
  
  public WXTextObject()
  {
    this(null);
  }
  
  public WXTextObject(String paramString)
  {
    AppMethodBeat.i(190425);
    this.text = paramString;
    AppMethodBeat.o(190425);
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(3982);
    String str = this.text;
    if ((str != null) && (str.length() != 0) && (this.text.length() <= 10240))
    {
      AppMethodBeat.o(3982);
      return true;
    }
    Log.e("MicroMsg.SDK.WXTextObject", "checkArgs fail, text is invalid");
    AppMethodBeat.o(3982);
    return false;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3980);
    paramBundle.putString("_wxtextobject_text", this.text);
    AppMethodBeat.o(3980);
  }
  
  public int type()
  {
    return 1;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(3981);
    this.text = paramBundle.getString("_wxtextobject_text");
    AppMethodBeat.o(3981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXTextObject
 * JD-Core Version:    0.7.0.1
 */