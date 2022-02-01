package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public final class SendAuth
{
  public static class Req
    extends BaseReq
  {
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = "MicroMsg.SDK.SendAuth.Req";
    public String extData;
    public String scope;
    public String state;
    
    public Req() {}
    
    public Req(Bundle paramBundle)
    {
      AppMethodBeat.i(3949);
      fromBundle(paramBundle);
      AppMethodBeat.o(3949);
    }
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(3952);
      if ((this.scope == null) || (this.scope.length() == 0) || (this.scope.length() > 1024))
      {
        Log.e("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, scope is invalid");
        AppMethodBeat.o(3952);
        return false;
      }
      if ((this.state != null) && (this.state.length() > 1024))
      {
        Log.e("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, state is invalid");
        AppMethodBeat.o(3952);
        return false;
      }
      AppMethodBeat.o(3952);
      return true;
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
  
  public static class Resp
    extends BaseResp
  {
    public static final int ERR_SCOPE_SNSAPI_WXAAPP_INFO_CAN_ONLY_AUTHORIZED_SEPARATELY = -1000;
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = "MicroMsg.SDK.SendAuth.Resp";
    public boolean authResult;
    public String code;
    public String country;
    public String lang;
    public String state;
    public String url;
    
    public Resp()
    {
      this.authResult = false;
    }
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(3963);
      this.authResult = false;
      fromBundle(paramBundle);
      AppMethodBeat.o(3963);
    }
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(3966);
      if ((this.state != null) && (this.state.length() > 1024))
      {
        Log.e("MicroMsg.SDK.SendAuth.Resp", "checkArgs fail, state is invalid");
        AppMethodBeat.o(3966);
        return false;
      }
      AppMethodBeat.o(3966);
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3964);
      super.fromBundle(paramBundle);
      this.code = paramBundle.getString("_wxapi_sendauth_resp_token");
      this.state = paramBundle.getString("_wxapi_sendauth_resp_state");
      this.url = paramBundle.getString("_wxapi_sendauth_resp_url");
      this.lang = paramBundle.getString("_wxapi_sendauth_resp_lang");
      this.country = paramBundle.getString("_wxapi_sendauth_resp_country");
      this.authResult = paramBundle.getBoolean("_wxapi_sendauth_resp_auth_result");
      AppMethodBeat.o(3964);
    }
    
    public int getType()
    {
      return 1;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3965);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_sendauth_resp_token", this.code);
      paramBundle.putString("_wxapi_sendauth_resp_state", this.state);
      paramBundle.putString("_wxapi_sendauth_resp_url", this.url);
      paramBundle.putString("_wxapi_sendauth_resp_lang", this.lang);
      paramBundle.putString("_wxapi_sendauth_resp_country", this.country);
      paramBundle.putBoolean("_wxapi_sendauth_resp_auth_result", this.authResult);
      AppMethodBeat.o(3965);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.SendAuth
 * JD-Core Version:    0.7.0.1
 */