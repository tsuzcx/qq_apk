package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public class SendAuth$Resp
  extends BaseResp
{
  private static final int LENGTH_LIMIT = 1024;
  private static final String TAG = "MicroMsg.SDK.SendAuth.Resp";
  public String code;
  public String country;
  public String lang;
  public String state;
  public String url;
  
  public SendAuth$Resp() {}
  
  public SendAuth$Resp(Bundle paramBundle)
  {
    AppMethodBeat.i(128263);
    fromBundle(paramBundle);
    AppMethodBeat.o(128263);
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128266);
    if ((this.state != null) && (this.state.length() > 1024))
    {
      Log.e("MicroMsg.SDK.SendAuth.Resp", "checkArgs fail, state is invalid");
      AppMethodBeat.o(128266);
      return false;
    }
    AppMethodBeat.o(128266);
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128264);
    super.fromBundle(paramBundle);
    this.code = paramBundle.getString("_wxapi_sendauth_resp_token");
    this.state = paramBundle.getString("_wxapi_sendauth_resp_state");
    this.url = paramBundle.getString("_wxapi_sendauth_resp_url");
    this.lang = paramBundle.getString("_wxapi_sendauth_resp_lang");
    this.country = paramBundle.getString("_wxapi_sendauth_resp_country");
    AppMethodBeat.o(128264);
  }
  
  public int getType()
  {
    return 1;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128265);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_sendauth_resp_token", this.code);
    paramBundle.putString("_wxapi_sendauth_resp_state", this.state);
    paramBundle.putString("_wxapi_sendauth_resp_url", this.url);
    paramBundle.putString("_wxapi_sendauth_resp_lang", this.lang);
    paramBundle.putString("_wxapi_sendauth_resp_country", this.country);
    AppMethodBeat.o(128265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.SendAuth.Resp
 * JD-Core Version:    0.7.0.1
 */