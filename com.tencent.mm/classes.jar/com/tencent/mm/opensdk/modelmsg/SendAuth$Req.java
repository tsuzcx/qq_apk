package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;

public class SendAuth$Req
  extends BaseReq
{
  private static final int LENGTH_LIMIT = 1024;
  private static final String TAG = "MicroMsg.SDK.SendAuth.Req";
  public String extData;
  public String scope;
  public String state;
  
  public SendAuth$Req() {}
  
  public SendAuth$Req(Bundle paramBundle)
  {
    AppMethodBeat.i(3949);
    fromBundle(paramBundle);
    AppMethodBeat.o(3949);
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(3952);
    String str = this.scope;
    if ((str != null) && (str.length() != 0) && (this.scope.length() <= 1024))
    {
      str = this.state;
      if ((str != null) && (str.length() > 1024))
      {
        Log.e("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, state is invalid");
        AppMethodBeat.o(3952);
        return false;
      }
      AppMethodBeat.o(3952);
      return true;
    }
    Log.e("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, scope is invalid");
    AppMethodBeat.o(3952);
    return false;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3950);
    super.fromBundle(paramBundle);
    this.scope = paramBundle.getString("_wxapi_sendauth_req_scope");
    this.state = paramBundle.getString("_wxapi_sendauth_req_state");
    this.extData = paramBundle.getString("_wxapi_sendauth_req_ext_data");
    AppMethodBeat.o(3950);
  }
  
  public int getType()
  {
    return 1;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3951);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_sendauth_req_scope", this.scope);
    paramBundle.putString("_wxapi_sendauth_req_state", this.state);
    paramBundle.putString("_wxapi_sendauth_req_ext_data", this.extData);
    AppMethodBeat.o(3951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.SendAuth.Req
 * JD-Core Version:    0.7.0.1
 */