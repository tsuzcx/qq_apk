package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXChannelOpenFeed
{
  public static class Req
    extends BaseReq
  {
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = "MicroMsg.SDK.WXChannelOpenFeed.Req";
    public String feedID;
    public String nonceID;
    public boolean notGetReleatedList;
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(243096);
      if (b.b(this.feedID))
      {
        Log.e("MicroMsg.SDK.WXChannelOpenFeed.Req", "feedID is null");
        AppMethodBeat.o(243096);
        return false;
      }
      if (b.b(this.nonceID))
      {
        Log.e("MicroMsg.SDK.WXChannelOpenFeed.Req", "nonceID is null");
        AppMethodBeat.o(243096);
        return false;
      }
      if (this.feedID.length() > 1024)
      {
        Log.e("MicroMsg.SDK.WXChannelOpenFeed.Req", "feedID.length too long!");
        AppMethodBeat.o(243096);
        return false;
      }
      if (this.nonceID.length() > 1024)
      {
        Log.e("MicroMsg.SDK.WXChannelOpenFeed.Req", "nonceID.length too long!");
        AppMethodBeat.o(243096);
        return false;
      }
      AppMethodBeat.o(243096);
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243099);
      super.fromBundle(paramBundle);
      this.feedID = paramBundle.getString("_wxapi_finder_feedID");
      this.nonceID = paramBundle.getString("_wxapi_finder_nonceID");
      this.notGetReleatedList = paramBundle.getBoolean("_wxapi_finder_notGetReleatedList");
      AppMethodBeat.o(243099);
    }
    
    public int getType()
    {
      return 36;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243101);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_finder_feedID", this.feedID);
      paramBundle.putString("_wxapi_finder_nonceID", this.nonceID);
      paramBundle.putBoolean("_wxapi_finder_notGetReleatedList", this.notGetReleatedList);
      AppMethodBeat.o(243101);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public String extMsg;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(243071);
      fromBundle(paramBundle);
      AppMethodBeat.o(243071);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243076);
      super.fromBundle(paramBundle);
      this.extMsg = paramBundle.getString("_wxapi_finder_extMsg");
      AppMethodBeat.o(243076);
    }
    
    public int getType()
    {
      return 36;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243078);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_finder_extMsg", this.extMsg);
      AppMethodBeat.o(243078);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXChannelOpenFeed
 * JD-Core Version:    0.7.0.1
 */