package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public class LaunchFromWX$Req
  extends BaseReq
{
  private static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
  private static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
  private static final String TAG = "MicroMsg.SDK.LaunchFromWX.Req";
  public String country;
  public String lang;
  public String messageAction;
  public String messageExt;
  
  public LaunchFromWX$Req() {}
  
  public LaunchFromWX$Req(Bundle paramBundle)
  {
    AppMethodBeat.i(128334);
    fromBundle(paramBundle);
    AppMethodBeat.o(128334);
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128337);
    if ((this.messageAction != null) && (this.messageAction.length() > 2048))
    {
      Log.e("MicroMsg.SDK.LaunchFromWX.Req", "checkArgs fail, messageAction is too long");
      AppMethodBeat.o(128337);
      return false;
    }
    if ((this.messageExt != null) && (this.messageExt.length() > 2048))
    {
      Log.e("MicroMsg.SDK.LaunchFromWX.Req", "checkArgs fail, messageExt is too long");
      AppMethodBeat.o(128337);
      return false;
    }
    AppMethodBeat.o(128337);
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128336);
    super.fromBundle(paramBundle);
    this.messageAction = paramBundle.getString("_wxobject_message_action");
    this.messageExt = paramBundle.getString("_wxobject_message_ext");
    this.lang = paramBundle.getString("_wxapi_launch_req_lang");
    this.country = paramBundle.getString("_wxapi_launch_req_country");
    AppMethodBeat.o(128336);
  }
  
  public int getType()
  {
    return 6;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128335);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxobject_message_action", this.messageAction);
    paramBundle.putString("_wxobject_message_ext", this.messageExt);
    paramBundle.putString("_wxapi_launch_req_lang", this.lang);
    paramBundle.putString("_wxapi_launch_req_country", this.country);
    AppMethodBeat.o(128335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.LaunchFromWX.Req
 * JD-Core Version:    0.7.0.1
 */