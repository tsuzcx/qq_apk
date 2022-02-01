package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXLiteAppObject
  implements WXMediaMessage.IMediaObject
{
  private static final String TAG = "MicroMsg.SDK.WXLiteAppObject";
  public String path;
  public String query;
  public String userName;
  public String webpageUrl;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(255222);
    if (b.b(this.userName))
    {
      Log.e("MicroMsg.SDK.WXLiteAppObject", "userName is null");
      AppMethodBeat.o(255222);
      return false;
    }
    AppMethodBeat.o(255222);
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(255219);
    paramBundle.putString("_wxliteapp_webpageurl", this.webpageUrl);
    paramBundle.putString("_wxliteapp_username", this.userName);
    paramBundle.putString("_wxliteapp_path", this.path);
    paramBundle.putString("_wxliteapp_query", this.query);
    AppMethodBeat.o(255219);
  }
  
  public int type()
  {
    return 68;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(255221);
    this.webpageUrl = paramBundle.getString("_wxliteapp_webpageurl");
    this.userName = paramBundle.getString("_wxliteapp_username");
    this.path = paramBundle.getString("_wxliteapp_path");
    this.query = paramBundle.getString("_wxliteapp_query");
    AppMethodBeat.o(255221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXLiteAppObject
 * JD-Core Version:    0.7.0.1
 */