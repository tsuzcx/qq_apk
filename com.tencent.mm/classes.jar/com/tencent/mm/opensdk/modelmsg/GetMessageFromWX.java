package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public final class GetMessageFromWX
{
  public static class Req
    extends BaseReq
  {
    public String country;
    public String lang;
    public String username;
    
    public Req() {}
    
    public Req(Bundle paramBundle)
    {
      AppMethodBeat.i(4008);
      fromBundle(paramBundle);
      AppMethodBeat.o(4008);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(4010);
      super.fromBundle(paramBundle);
      this.lang = paramBundle.getString("_wxapi_getmessage_req_lang");
      this.country = paramBundle.getString("_wxapi_getmessage_req_country");
      AppMethodBeat.o(4010);
    }
    
    public int getType()
    {
      return 3;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(4009);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_getmessage_req_lang", this.lang);
      paramBundle.putString("_wxapi_getmessage_req_country", this.country);
      AppMethodBeat.o(4009);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    private static final String TAG = "MicroMsg.SDK.GetMessageFromWX.Resp";
    public WXMediaMessage message;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(4017);
      fromBundle(paramBundle);
      AppMethodBeat.o(4017);
    }
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(4020);
      WXMediaMessage localWXMediaMessage = this.message;
      if (localWXMediaMessage == null)
      {
        Log.e("MicroMsg.SDK.GetMessageFromWX.Resp", "checkArgs fail, message is null");
        AppMethodBeat.o(4020);
        return false;
      }
      boolean bool = localWXMediaMessage.checkArgs();
      AppMethodBeat.o(4020);
      return bool;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(4018);
      super.fromBundle(paramBundle);
      this.message = WXMediaMessage.Builder.fromBundle(paramBundle);
      AppMethodBeat.o(4018);
    }
    
    public int getType()
    {
      return 3;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(4019);
      super.toBundle(paramBundle);
      paramBundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
      AppMethodBeat.o(4019);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.GetMessageFromWX
 * JD-Core Version:    0.7.0.1
 */