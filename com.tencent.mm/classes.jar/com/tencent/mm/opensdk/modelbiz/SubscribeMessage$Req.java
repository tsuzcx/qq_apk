package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public class SubscribeMessage$Req
  extends BaseReq
{
  private static final int LENGTH_LIMIT = 1024;
  private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Req";
  public String reserved;
  public int scene;
  public String templateID;
  
  public SubscribeMessage$Req() {}
  
  public SubscribeMessage$Req(Bundle paramBundle)
  {
    AppMethodBeat.i(128181);
    fromBundle(paramBundle);
    AppMethodBeat.o(128181);
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128184);
    if ((this.templateID == null) || (this.templateID.length() == 0))
    {
      Log.e("MicroMsg.SDK.SubscribeMessage.Req", "checkArgs fail, templateID is null");
      AppMethodBeat.o(128184);
      return false;
    }
    if (this.templateID.length() > 1024)
    {
      Log.e("MicroMsg.SDK.SubscribeMessage.Req", "checkArgs fail, templateID is too long");
      AppMethodBeat.o(128184);
      return false;
    }
    if ((this.reserved != null) && (this.reserved.length() > 1024))
    {
      Log.e("MicroMsg.SDK.SubscribeMessage.Req", "checkArgs fail, reserved is too long");
      AppMethodBeat.o(128184);
      return false;
    }
    AppMethodBeat.o(128184);
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128182);
    super.fromBundle(paramBundle);
    this.scene = paramBundle.getInt("_wxapi_subscribemessage_req_scene");
    this.templateID = paramBundle.getString("_wxapi_subscribemessage_req_templateid");
    this.reserved = paramBundle.getString("_wxapi_subscribemessage_req_reserved");
    AppMethodBeat.o(128182);
  }
  
  public int getType()
  {
    return 18;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128183);
    super.toBundle(paramBundle);
    paramBundle.putInt("_wxapi_subscribemessage_req_scene", this.scene);
    paramBundle.putString("_wxapi_subscribemessage_req_templateid", this.templateID);
    paramBundle.putString("_wxapi_subscribemessage_req_reserved", this.reserved);
    AppMethodBeat.o(128183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.SubscribeMessage.Req
 * JD-Core Version:    0.7.0.1
 */