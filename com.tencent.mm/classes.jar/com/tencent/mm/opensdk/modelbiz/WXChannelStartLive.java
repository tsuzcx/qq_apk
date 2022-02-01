package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXChannelStartLive
{
  public static class Req
    extends BaseReq
  {
    private static final String TAG = "MicroMsg.SDK.WXChannelStartLive.Req";
    public String liveInfoData;
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(243039);
      if (b.b(this.liveInfoData))
      {
        Log.e("MicroMsg.SDK.WXChannelStartLive.Req", "liveInfoData is null");
        AppMethodBeat.o(243039);
        return false;
      }
      AppMethodBeat.o(243039);
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243043);
      super.fromBundle(paramBundle);
      this.liveInfoData = paramBundle.getString("_wxapi_finder_start_live_info_data");
      AppMethodBeat.o(243043);
    }
    
    public int getType()
    {
      return 39;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243045);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_finder_start_live_info_data", this.liveInfoData);
      AppMethodBeat.o(243045);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public String extMsg;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(243064);
      fromBundle(paramBundle);
      AppMethodBeat.o(243064);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243069);
      super.fromBundle(paramBundle);
      this.extMsg = paramBundle.getString("_wxapi_finder_extMsg");
      AppMethodBeat.o(243069);
    }
    
    public int getType()
    {
      return 39;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243074);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_finder_extMsg", this.extMsg);
      AppMethodBeat.o(243074);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXChannelStartLive
 * JD-Core Version:    0.7.0.1
 */