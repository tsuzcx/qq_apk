package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXWebpageObject
  implements WXMediaMessage.IMediaObject
{
  private static final int LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXWebpageObject";
  public String canvasPageXml;
  public String extInfo;
  public String webpageUrl;
  
  public WXWebpageObject() {}
  
  public WXWebpageObject(String paramString)
  {
    AppMethodBeat.i(194091);
    this.webpageUrl = paramString;
    AppMethodBeat.o(194091);
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(4023);
    String str = this.webpageUrl;
    if ((str != null) && (str.length() != 0) && (this.webpageUrl.length() <= 10240))
    {
      AppMethodBeat.o(4023);
      return true;
    }
    Log.e("MicroMsg.SDK.WXWebpageObject", "checkArgs fail, webpageUrl is invalid");
    AppMethodBeat.o(4023);
    return false;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(4021);
    paramBundle.putString("_wxwebpageobject_extInfo", this.extInfo);
    paramBundle.putString("_wxwebpageobject_webpageUrl", this.webpageUrl);
    paramBundle.putString("_wxwebpageobject_canvaspagexml", this.canvasPageXml);
    AppMethodBeat.o(4021);
  }
  
  public int type()
  {
    return 5;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(4022);
    this.extInfo = paramBundle.getString("_wxwebpageobject_extInfo");
    this.webpageUrl = paramBundle.getString("_wxwebpageobject_webpageUrl");
    this.canvasPageXml = paramBundle.getString("_wxwebpageobject_canvaspagexml");
    AppMethodBeat.o(4022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXWebpageObject
 * JD-Core Version:    0.7.0.1
 */