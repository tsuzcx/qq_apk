package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXChannelOpenEvent
{
  public static class Req
    extends BaseReq
  {
    private static final String Key_EventId = "_wxapi_finder_open_event_eventId";
    private static final String Key_ExtInfo = "_wxapi_finder_open_event_extInfo";
    private static final String Key_Username = "_wxapi_finder_open_event_username";
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = "MicroMsg.SDK.WXChannelOpenEvent.Req";
    public String eventId;
    public String extInfo;
    public String username;
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(243055);
      if (b.b(this.username))
      {
        Log.e("MicroMsg.SDK.WXChannelOpenEvent.Req", "username is null");
        AppMethodBeat.o(243055);
        return false;
      }
      if (this.username.length() > 1024)
      {
        Log.e("MicroMsg.SDK.WXChannelOpenEvent.Req", "username exceeds the limit");
        AppMethodBeat.o(243055);
        return false;
      }
      if (b.b(this.eventId))
      {
        Log.e("MicroMsg.SDK.WXChannelOpenEvent.Req", "eventId is null");
        AppMethodBeat.o(243055);
        return false;
      }
      if (this.eventId.length() > 1024)
      {
        Log.e("MicroMsg.SDK.WXChannelOpenEvent.Req", "eventId exceeds the limit");
        AppMethodBeat.o(243055);
        return false;
      }
      AppMethodBeat.o(243055);
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243058);
      super.fromBundle(paramBundle);
      this.username = paramBundle.getString("_wxapi_finder_open_event_username");
      this.eventId = paramBundle.getString("_wxapi_finder_open_event_eventId");
      this.extInfo = paramBundle.getString("_wxapi_finder_open_event_extInfo");
      AppMethodBeat.o(243058);
    }
    
    public int getType()
    {
      return 41;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243060);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_finder_open_event_username", this.username);
      paramBundle.putString("_wxapi_finder_open_event_eventId", this.eventId);
      paramBundle.putString("_wxapi_finder_open_event_extInfo", this.extInfo);
      AppMethodBeat.o(243060);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    private static final String Key_ExtMsg = "_wxapi_finder_open_event_extMsg";
    public String extMsg;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(243086);
      fromBundle(paramBundle);
      AppMethodBeat.o(243086);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243091);
      super.fromBundle(paramBundle);
      this.extMsg = paramBundle.getString("_wxapi_finder_open_event_extMsg");
      AppMethodBeat.o(243091);
    }
    
    public int getType()
    {
      return 41;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243093);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_finder_open_event_extMsg", this.extMsg);
      AppMethodBeat.o(243093);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXChannelOpenEvent
 * JD-Core Version:    0.7.0.1
 */