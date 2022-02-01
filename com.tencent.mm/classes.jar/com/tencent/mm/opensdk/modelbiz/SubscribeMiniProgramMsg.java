package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
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
      AppMethodBeat.i(3936);
      fromBundle(paramBundle);
      AppMethodBeat.o(3936);
    }
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(3939);
      String str = this.miniProgramAppId;
      if ((str != null) && (str.length() != 0))
      {
        AppMethodBeat.o(3939);
        return true;
      }
      Log.e("MicroMsg.SDK.SubscribeMessage.Req", "checkArgs fail, miniProgramAppId is null");
      AppMethodBeat.o(3939);
      return false;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3937);
      super.fromBundle(paramBundle);
      this.miniProgramAppId = paramBundle.getString("_wxapi_subscribeminiprogram_req_miniprogramappid");
      AppMethodBeat.o(3937);
    }
    
    public int getType()
    {
      return 23;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3938);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_subscribeminiprogram_req_miniprogramappid", this.miniProgramAppId);
      AppMethodBeat.o(3938);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Resp";
    public String nickname;
    public String unionId;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(3904);
      fromBundle(paramBundle);
      AppMethodBeat.o(3904);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3905);
      super.fromBundle(paramBundle);
      this.unionId = paramBundle.getString("_wxapi_subscribeminiprogram_resp_unionId");
      this.nickname = paramBundle.getString("_wxapi_subscribeminiprogram_resp_nickname");
      AppMethodBeat.o(3905);
    }
    
    public int getType()
    {
      return 23;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3906);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_subscribeminiprogram_resp_unionId", this.unionId);
      paramBundle.putString("_wxapi_subscribeminiprogram_resp_nickname", this.nickname);
      AppMethodBeat.o(3906);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg
 * JD-Core Version:    0.7.0.1
 */