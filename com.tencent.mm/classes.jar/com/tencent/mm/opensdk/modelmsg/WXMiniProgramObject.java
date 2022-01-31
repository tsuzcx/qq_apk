package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXMiniProgramObject
  implements WXMediaMessage.IMediaObject
{
  public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
  public static final int MINIPROGRAM_TYPE_TEST = 1;
  public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
  private static final String TAG = "MicroMsg.SDK.WXMiniProgramObject";
  public int miniprogramType = 0;
  public String path;
  public String userName;
  public String webpageUrl;
  public boolean withShareTicket;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128248);
    if (d.b(this.webpageUrl))
    {
      Log.e("MicroMsg.SDK.WXMiniProgramObject", "webPageUrl is null");
      AppMethodBeat.o(128248);
      return false;
    }
    if (d.b(this.userName))
    {
      Log.e("MicroMsg.SDK.WXMiniProgramObject", "userName is null");
      AppMethodBeat.o(128248);
      return false;
    }
    if ((this.miniprogramType < 0) || (this.miniprogramType > 2))
    {
      Log.e("MicroMsg.SDK.WXMiniProgramObject", "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
      AppMethodBeat.o(128248);
      return false;
    }
    AppMethodBeat.o(128248);
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(128246);
    paramBundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
    paramBundle.putString("_wxminiprogram_username", this.userName);
    paramBundle.putString("_wxminiprogram_path", this.path);
    paramBundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
    paramBundle.putInt("_wxminiprogram_type", this.miniprogramType);
    AppMethodBeat.o(128246);
  }
  
  public int type()
  {
    return 36;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(128247);
    this.webpageUrl = paramBundle.getString("_wxminiprogram_webpageurl");
    this.userName = paramBundle.getString("_wxminiprogram_username");
    this.path = paramBundle.getString("_wxminiprogram_path");
    this.withShareTicket = paramBundle.getBoolean("_wxminiprogram_withsharetiket");
    this.miniprogramType = paramBundle.getInt("_wxminiprogram_type");
    AppMethodBeat.o(128247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject
 * JD-Core Version:    0.7.0.1
 */