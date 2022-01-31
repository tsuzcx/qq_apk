package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public final class SubscribeMiniProgramMsg
{
  public static class Req
    extends BaseReq
  {
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Req";
    public String miniProgramAppId;
    
    public Req() {}
    
    public Req(Bundle paramBundle)
    {
      AppMethodBeat.i(128238);
      fromBundle(paramBundle);
      AppMethodBeat.o(128238);
    }
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(128241);
      if ((this.miniProgramAppId == null) || (this.miniProgramAppId.length() == 0))
      {
        Log.e("MicroMsg.SDK.SubscribeMessage.Req", "checkArgs fail, miniProgramAppId is null");
        AppMethodBeat.o(128241);
        return false;
      }
      AppMethodBeat.o(128241);
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(128239);
      super.fromBundle(paramBundle);
      this.miniProgramAppId = paramBundle.getString("_wxapi_subscribeminiprogram_req_miniprogramappid");
      AppMethodBeat.o(128239);
    }
    
    public int getType()
    {
      return 23;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(128240);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_subscribeminiprogram_req_miniprogramappid", this.miniProgramAppId);
      AppMethodBeat.o(128240);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg
 * JD-Core Version:    0.7.0.1
 */