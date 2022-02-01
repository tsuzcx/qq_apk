package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXChannelOpenLive
{
  public static class Req
    extends BaseReq
  {
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = "MicroMsg.SDK.WXChannelOpenLive.Req";
    public String feedID;
    public String nonceID;
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(254033);
      if (b.b(this.feedID))
      {
        Log.e("MicroMsg.SDK.WXChannelOpenLive.Req", "feedID is null");
        AppMethodBeat.o(254033);
        return false;
      }
      if (b.b(this.nonceID))
      {
        Log.e("MicroMsg.SDK.WXChannelOpenLive.Req", "nonceID is null");
        AppMethodBeat.o(254033);
        return false;
      }
      if (this.feedID.length() > 1024)
      {
        Log.e("MicroMsg.SDK.WXChannelOpenLive.Req", "feedID.length too long!");
        AppMethodBeat.o(254033);
        return false;
      }
      if (this.nonceID.length() > 1024)
      {
        Log.e("MicroMsg.SDK.WXChannelOpenLive.Req", "nonceID.length too long!");
        AppMethodBeat.o(254033);
        return false;
      }
      AppMethodBeat.o(254033);
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(254035);
      super.fromBundle(paramBundle);
      this.feedID = paramBundle.getString("_wxapi_finder_feedID");
      this.nonceID = paramBundle.getString("_wxapi_finder_nonceID");
      AppMethodBeat.o(254035);
    }
    
    public int getType()
    {
      return 35;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(254038);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_finder_feedID", this.feedID);
      paramBundle.putString("_wxapi_finder_nonceID", this.nonceID);
      AppMethodBeat.o(254038);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public String extMsg;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(254933);
      fromBundle(paramBundle);
      AppMethodBeat.o(254933);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(254934);
      super.fromBundle(paramBundle);
      this.extMsg = paramBundle.getString("_wxapi_finder_extMsg");
      AppMethodBeat.o(254934);
    }
    
    public int getType()
    {
      return 35;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(254936);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_finder_extMsg", this.extMsg);
      AppMethodBeat.o(254936);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXChannelOpenLive
 * JD-Core Version:    0.7.0.1
 */