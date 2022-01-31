package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public class SendMessageToWX$Req
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
  
  public SendMessageToWX$Req() {}
  
  public SendMessageToWX$Req(Bundle paramBundle)
  {
    AppMethodBeat.i(128300);
    fromBundle(paramBundle);
    AppMethodBeat.o(128300);
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128303);
    if (this.message == null)
    {
      Log.e("MicroMsg.SDK.SendMessageToWX.Req", "checkArgs fail ,message is null");
      AppMethodBeat.o(128303);
      return false;
    }
    if ((this.message.mediaObject.type() == 6) && (this.scene == 2)) {
      ((WXFileObject)this.message.mediaObject).setContentLengthLimit(26214400);
    }
    if ((this.scene == 3) && (this.userOpenId == null))
    {
      AppMethodBeat.o(128303);
      return false;
    }
    boolean bool = this.message.checkArgs();
    AppMethodBeat.o(128303);
    return bool;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128301);
    super.fromBundle(paramBundle);
    this.message = WXMediaMessage.Builder.fromBundle(paramBundle);
    this.scene = paramBundle.getInt("_wxapi_sendmessagetowx_req_scene");
    this.userOpenId = paramBundle.getString("_wxapi_sendmessagetowx_req_use_open_id");
    AppMethodBeat.o(128301);
  }
  
  public int getType()
  {
    return 2;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128302);
    super.toBundle(paramBundle);
    paramBundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
    paramBundle.putInt("_wxapi_sendmessagetowx_req_scene", this.scene);
    paramBundle.putInt("_wxapi_sendmessagetowx_req_media_type", this.message.getType());
    paramBundle.putString("_wxapi_sendmessagetowx_req_use_open_id", this.userOpenId);
    AppMethodBeat.o(128302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req
 * JD-Core Version:    0.7.0.1
 */