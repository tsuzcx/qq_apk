package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXDynamicVideoMiniProgramObject
  extends WXMiniProgramObject
{
  private static final String TAG = "MicroMsg.SDK.WXDynamicVideoMiniProgramObject";
  public String appThumbUrl;
  public String videoSource;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(4016);
    if (b.b(this.webpageUrl))
    {
      Log.e("MicroMsg.SDK.WXDynamicVideoMiniProgramObject", "webPageUrl is null");
      AppMethodBeat.o(4016);
      return false;
    }
    if (b.b(this.userName))
    {
      Log.e("MicroMsg.SDK.WXDynamicVideoMiniProgramObject", "userName is null");
      AppMethodBeat.o(4016);
      return false;
    }
    int i = this.miniprogramType;
    if ((i >= 0) && (i <= 2))
    {
      AppMethodBeat.o(4016);
      return true;
    }
    Log.e("MicroMsg.SDK.WXDynamicVideoMiniProgramObject", "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
    AppMethodBeat.o(4016);
    return false;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(4014);
    paramBundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
    paramBundle.putString("_wxminiprogram_username", this.userName);
    paramBundle.putString("_wxminiprogram_path", this.path);
    paramBundle.putString("_wxminiprogram_videoSource", this.videoSource);
    paramBundle.putString("_wxminiprogram_appThumbUrl", this.appThumbUrl);
    paramBundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
    paramBundle.putInt("_wxminiprogram_type", this.miniprogramType);
    paramBundle.putInt("_wxminiprogram_disableforward", this.disableforward);
    AppMethodBeat.o(4014);
  }
  
  public int type()
  {
    return 46;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(4015);
    this.webpageUrl = paramBundle.getString("_wxminiprogram_webpageurl");
    this.userName = paramBundle.getString("_wxminiprogram_username");
    this.path = paramBundle.getString("_wxminiprogram_path");
    this.videoSource = paramBundle.getString("_wxminiprogram_videoSource");
    this.appThumbUrl = paramBundle.getString("_wxminiprogram_appThumbUrl");
    this.withShareTicket = paramBundle.getBoolean("_wxminiprogram_withsharetiket");
    this.miniprogramType = paramBundle.getInt("_wxminiprogram_type");
    this.disableforward = paramBundle.getInt("_wxminiprogram_disableforward");
    AppMethodBeat.o(4015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXDynamicVideoMiniProgramObject
 * JD-Core Version:    0.7.0.1
 */