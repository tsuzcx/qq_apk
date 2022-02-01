package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public class LaunchFromWX
{
  public static class Req
    extends BaseReq
  {
    private static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
    private static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
    private static final String TAG = "MicroMsg.SDK.LaunchFromWX.Req";
    public String country;
    public String lang;
    public String messageAction;
    public String messageExt;
    
    public Req() {}
    
    public Req(Bundle paramBundle)
    {
      AppMethodBeat.i(4034);
      fromBundle(paramBundle);
      AppMethodBeat.o(4034);
    }
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(4037);
      String str = this.messageAction;
      if ((str != null) && (str.length() > 2048))
      {
        Log.e("MicroMsg.SDK.LaunchFromWX.Req", "checkArgs fail, messageAction is too long");
        AppMethodBeat.o(4037);
        return false;
      }
      str = this.messageExt;
      if ((str != null) && (str.length() > 2048))
      {
        Log.e("MicroMsg.SDK.LaunchFromWX.Req", "checkArgs fail, messageExt is too long");
        AppMethodBeat.o(4037);
        return false;
      }
      AppMethodBeat.o(4037);
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(4036);
      super.fromBundle(paramBundle);
      this.messageAction = paramBundle.getString("_wxobject_message_action");
      this.messageExt = paramBundle.getString("_wxobject_message_ext");
      this.lang = paramBundle.getString("_wxapi_launch_req_lang");
      this.country = paramBundle.getString("_wxapi_launch_req_country");
      AppMethodBeat.o(4036);
    }
    
    public int getType()
    {
      return 6;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(4035);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxobject_message_action", this.messageAction);
      paramBundle.putString("_wxobject_message_ext", this.messageExt);
      paramBundle.putString("_wxapi_launch_req_lang", this.lang);
      paramBundle.putString("_wxapi_launch_req_country", this.country);
      AppMethodBeat.o(4035);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(3962);
      fromBundle(paramBundle);
      AppMethodBeat.o(3962);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public int getType()
    {
      return 6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.LaunchFromWX
 * JD-Core Version:    0.7.0.1
 */