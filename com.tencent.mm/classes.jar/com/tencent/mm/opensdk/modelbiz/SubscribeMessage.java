package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public final class SubscribeMessage
{
  public static class Req
    extends BaseReq
  {
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Req";
    public String reserved;
    public int scene;
    public String templateID;
    
    public Req() {}
    
    public Req(Bundle paramBundle)
    {
      AppMethodBeat.i(3878);
      fromBundle(paramBundle);
      AppMethodBeat.o(3878);
    }
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(3881);
      String str = this.templateID;
      if ((str != null) && (str.length() != 0))
      {
        if (this.templateID.length() > 1024)
        {
          Log.e("MicroMsg.SDK.SubscribeMessage.Req", "checkArgs fail, templateID is too long");
          AppMethodBeat.o(3881);
          return false;
        }
        str = this.reserved;
        if ((str != null) && (str.length() > 1024))
        {
          Log.e("MicroMsg.SDK.SubscribeMessage.Req", "checkArgs fail, reserved is too long");
          AppMethodBeat.o(3881);
          return false;
        }
        AppMethodBeat.o(3881);
        return true;
      }
      Log.e("MicroMsg.SDK.SubscribeMessage.Req", "checkArgs fail, templateID is null");
      AppMethodBeat.o(3881);
      return false;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3879);
      super.fromBundle(paramBundle);
      this.scene = paramBundle.getInt("_wxapi_subscribemessage_req_scene");
      this.templateID = paramBundle.getString("_wxapi_subscribemessage_req_templateid");
      this.reserved = paramBundle.getString("_wxapi_subscribemessage_req_reserved");
      AppMethodBeat.o(3879);
    }
    
    public int getType()
    {
      return 18;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3880);
      super.toBundle(paramBundle);
      paramBundle.putInt("_wxapi_subscribemessage_req_scene", this.scene);
      paramBundle.putString("_wxapi_subscribemessage_req_templateid", this.templateID);
      paramBundle.putString("_wxapi_subscribemessage_req_reserved", this.reserved);
      AppMethodBeat.o(3880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.SubscribeMessage
 * JD-Core Version:    0.7.0.1
 */