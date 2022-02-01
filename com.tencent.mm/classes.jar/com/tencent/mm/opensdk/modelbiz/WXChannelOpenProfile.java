package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXChannelOpenProfile
{
  public static class Req
    extends BaseReq
  {
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = "MicroMsg.SDK.WXChannelOpenProfile.Req";
    public String userName;
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(254726);
      if (b.b(this.userName))
      {
        Log.e("MicroMsg.SDK.WXChannelOpenProfile.Req", "userName is null");
        AppMethodBeat.o(254726);
        return false;
      }
      if (this.userName.length() > 1024)
      {
        Log.e("MicroMsg.SDK.WXChannelOpenProfile.Req", "userName.length too long");
        AppMethodBeat.o(254726);
        return false;
      }
      AppMethodBeat.o(254726);
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(254728);
      super.fromBundle(paramBundle);
      this.userName = paramBundle.getString("_wxapi_finder_userName");
      AppMethodBeat.o(254728);
    }
    
    public int getType()
    {
      return 34;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(254730);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_finder_userName", this.userName);
      AppMethodBeat.o(254730);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public String extMsg;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(255047);
      fromBundle(paramBundle);
      AppMethodBeat.o(255047);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(255050);
      super.fromBundle(paramBundle);
      this.extMsg = paramBundle.getString("_wxapi_finder_extMsg");
      AppMethodBeat.o(255050);
    }
    
    public int getType()
    {
      return 34;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(255052);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_finder_extMsg", this.extMsg);
      AppMethodBeat.o(255052);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXChannelOpenProfile
 * JD-Core Version:    0.7.0.1
 */