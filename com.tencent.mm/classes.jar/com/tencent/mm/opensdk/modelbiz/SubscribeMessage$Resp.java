package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class SubscribeMessage$Resp
  extends BaseResp
{
  private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Resp";
  public String action;
  public String reserved;
  public int scene;
  public String templateID;
  
  public SubscribeMessage$Resp() {}
  
  public SubscribeMessage$Resp(Bundle paramBundle)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.SubscribeMessage.Resp
 * JD-Core Version:    0.7.0.1
 */