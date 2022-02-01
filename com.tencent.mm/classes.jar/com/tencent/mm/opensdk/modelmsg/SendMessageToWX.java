package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public class SendMessageToWX
{
  public static class Req
    extends BaseReq
  {
    private static final int FAV_CONTENT_LENGTH_LIMIT = 26214400;
    private static final String TAG = "MicroMsg.SDK.SendMessageToWX.Req";
    public static final int WXSceneFavorite = 2;
    public static final int WXSceneSession = 0;
    public static final int WXSceneSpecifiedContact = 3;
    public static final int WXSceneTimeline = 1;
    public WXMediaMessage message;
    public int scene;
    public String userOpenId;
    
    public Req() {}
    
    public Req(Bundle paramBundle)
    {
      AppMethodBeat.i(4000);
      fromBundle(paramBundle);
      AppMethodBeat.o(4000);
    }
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(4003);
      WXMediaMessage localWXMediaMessage = this.message;
      if (localWXMediaMessage == null)
      {
        Log.e("MicroMsg.SDK.SendMessageToWX.Req", "checkArgs fail ,message is null");
        AppMethodBeat.o(4003);
        return false;
      }
      if ((localWXMediaMessage.mediaObject.type() == 6) && (this.scene == 2)) {
        ((WXFileObject)this.message.mediaObject).setContentLengthLimit(26214400);
      }
      if ((this.scene == 3) && (this.userOpenId == null))
      {
        Log.e("MicroMsg.SDK.SendMessageToWX.Req", "Send specifiedContact userOpenId can not be null.");
        AppMethodBeat.o(4003);
        return false;
      }
      if ((this.scene == 3) && (this.openId == null))
      {
        Log.e("MicroMsg.SDK.SendMessageToWX.Req", "Send specifiedContact openid can not be null.");
        AppMethodBeat.o(4003);
        return false;
      }
      boolean bool = this.message.checkArgs();
      AppMethodBeat.o(4003);
      return bool;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(4001);
      super.fromBundle(paramBundle);
      this.message = WXMediaMessage.Builder.fromBundle(paramBundle);
      this.scene = paramBundle.getInt("_wxapi_sendmessagetowx_req_scene");
      this.userOpenId = paramBundle.getString("_wxapi_sendmessagetowx_req_use_open_id");
      AppMethodBeat.o(4001);
    }
    
    public int getType()
    {
      return 2;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(4002);
      super.toBundle(paramBundle);
      paramBundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
      paramBundle.putInt("_wxapi_sendmessagetowx_req_scene", this.scene);
      paramBundle.putInt("_wxapi_sendmessagetowx_req_media_type", this.message.getType());
      paramBundle.putString("_wxapi_sendmessagetowx_req_use_open_id", this.userOpenId);
      AppMethodBeat.o(4002);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(4011);
      fromBundle(paramBundle);
      AppMethodBeat.o(4011);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(4012);
      super.fromBundle(paramBundle);
      AppMethodBeat.o(4012);
    }
    
    public int getType()
    {
      return 2;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(4013);
      super.toBundle(paramBundle);
      AppMethodBeat.o(4013);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.SendMessageToWX
 * JD-Core Version:    0.7.0.1
 */