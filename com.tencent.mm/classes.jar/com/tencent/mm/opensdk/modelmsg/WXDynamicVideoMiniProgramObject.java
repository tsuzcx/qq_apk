package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class WXDynamicVideoMiniProgramObject
  extends WXMiniProgramObject
{
  private static final String TAG = "MicroMsg.SDK.WXDynamicVideoMiniProgramObject";
  public String appThumbUrl;
  public String videoSource;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128316);
    if (d.b(this.webpageUrl))
    {
      Log.e("MicroMsg.SDK.WXDynamicVideoMiniProgramObject", "webPageUrl is null");
      AppMethodBeat.o(128316);
      return false;
    }
    if (d.b(this.userName))
    {
      Log.e("MicroMsg.SDK.WXDynamicVideoMiniProgramObject", "userName is null");
      AppMethodBeat.o(128316);
      return false;
    }
    if ((this.miniprogramType < 0) || (this.miniprogramType > 2))
    {
      Log.e("MicroMsg.SDK.WXDynamicVideoMiniProgramObject", "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
      AppMethodBeat.o(128316);
      return false;
    }
    AppMethodBeat.o(128316);
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(128314);
    paramBundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
    paramBundle.putString("_wxminiprogram_username", this.userName);
    paramBundle.putString("_wxminiprogram_path", this.path);
    paramBundle.putString("_wxminiprogram_videoSource", this.videoSource);
    paramBundle.putString("_wxminiprogram_appThumbUrl", this.appThumbUrl);
    paramBundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
    paramBundle.putInt("_wxminiprogram_type", this.miniprogramType);
    AppMethodBeat.o(128314);
  }
  
  public int type()
  {
    return 46;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(128315);
    this.webpageUrl = paramBundle.getString("_wxminiprogram_webpageurl");
    this.userName = paramBundle.getString("_wxminiprogram_username");
    this.path = paramBundle.getString("_wxminiprogram_path");
    this.videoSource = paramBundle.getString("_wxminiprogram_videoSource");
    this.appThumbUrl = paramBundle.getString("_wxminiprogram_appThumbUrl");
    this.withShareTicket = paramBundle.getBoolean("_wxminiprogram_withsharetiket");
    this.miniprogramType = paramBundle.getInt("_wxminiprogram_type");
    AppMethodBeat.o(128315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXDynamicVideoMiniProgramObject
 * JD-Core Version:    0.7.0.1
 */