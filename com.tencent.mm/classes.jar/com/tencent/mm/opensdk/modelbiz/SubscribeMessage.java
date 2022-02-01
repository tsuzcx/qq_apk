package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
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
      if ((this.templateID == null) || (this.templateID.length() == 0))
      {
        Log.e("MicroMsg.SDK.SubscribeMessage.Req", "checkArgs fail, templateID is null");
        AppMethodBeat.o(3881);
        return false;
      }
      if (this.templateID.length() > 1024)
      {
        Log.e("MicroMsg.SDK.SubscribeMessage.Req", "checkArgs fail, templateID is too long");
        AppMethodBeat.o(3881);
        return false;
      }
      if ((this.reserved != null) && (this.reserved.length() > 1024))
      {
        Log.e("MicroMsg.SDK.SubscribeMessage.Req", "checkArgs fail, reserved is too long");
        AppMethodBeat.o(3881);
        return false;
      }
      AppMethodBeat.o(3881);
      return true;
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
  
  public static class Resp
    extends BaseResp
  {
    private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Resp";
    public String action;
    public String reserved;
    public int scene;
    public String templateID;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(3920);
      fromBundle(paramBundle);
      AppMethodBeat.o(3920);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3921);
      super.fromBundle(paramBundle);
      this.templateID = paramBundle.getString("_wxapi_subscribemessage_resp_templateid");
      this.scene = paramBundle.getInt("_wxapi_subscribemessage_resp_scene");
      this.action = paramBundle.getString("_wxapi_subscribemessage_resp_action");
      this.reserved = paramBundle.getString("_wxapi_subscribemessage_resp_reserved");
      AppMethodBeat.o(3921);
    }
    
    public int getType()
    {
      return 18;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3922);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_subscribemessage_resp_templateid", this.templateID);
      paramBundle.putInt("_wxapi_subscribemessage_resp_scene", this.scene);
      paramBundle.putString("_wxapi_subscribemessage_resp_action", this.action);
      paramBundle.putString("_wxapi_subscribemessage_resp_reserved", this.reserved);
      AppMethodBeat.o(3922);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.SubscribeMessage
 * JD-Core Version:    0.7.0.1
 */