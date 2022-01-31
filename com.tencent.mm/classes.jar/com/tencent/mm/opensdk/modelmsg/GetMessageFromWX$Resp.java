package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public class GetMessageFromWX$Resp
  extends BaseResp
{
  private static final String TAG = "MicroMsg.SDK.GetMessageFromWX.Resp";
  public WXMediaMessage message;
  
  public GetMessageFromWX$Resp() {}
  
  public GetMessageFromWX$Resp(Bundle paramBundle)
  {
    AppMethodBeat.i(128317);
    fromBundle(paramBundle);
    AppMethodBeat.o(128317);
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128320);
    if (this.message == null)
    {
      Log.e("MicroMsg.SDK.GetMessageFromWX.Resp", "checkArgs fail, message is null");
      AppMethodBeat.o(128320);
      return false;
    }
    boolean bool = this.message.checkArgs();
    AppMethodBeat.o(128320);
    return bool;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128318);
    super.fromBundle(paramBundle);
    this.message = WXMediaMessage.Builder.fromBundle(paramBundle);
    AppMethodBeat.o(128318);
  }
  
  public int getType()
  {
    return 3;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128319);
    super.toBundle(paramBundle);
    paramBundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
    AppMethodBeat.o(128319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Resp
 * JD-Core Version:    0.7.0.1
 */