package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;

public final class SendAuth
{
  public static class Req
    extends BaseReq
  {
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = "MicroMsg.SDK.SendAuth.Req";
    public String scope;
    public String state;
    
    public Req() {}
    
    public Req(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    public boolean checkArgs()
    {
      if ((this.scope == null) || (this.scope.length() == 0) || (this.scope.length() > 1024))
      {
        a.a("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, scope is invalid");
        return false;
      }
      if ((this.state != null) && (this.state.length() > 1024))
      {
        a.a("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, state is invalid");
        return false;
      }
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.scope = paramBundle.getString("_wxapi_sendauth_req_scope");
      this.state = paramBundle.getString("_wxapi_sendauth_req_state");
    }
    
    public int getType()
    {
      return 1;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_sendauth_req_scope", this.scope);
      paramBundle.putString("_wxapi_sendauth_req_state", this.state);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = "MicroMsg.SDK.SendAuth.Resp";
    public String code;
    public String state;
    public String url;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    public boolean checkArgs()
    {
      if ((this.state != null) && (this.state.length() > 1024))
      {
        a.a("MicroMsg.SDK.SendAuth.Resp", "checkArgs fail, state is invalid");
        return false;
      }
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.code = paramBundle.getString("_wxapi_sendauth_resp_token");
      this.state = paramBundle.getString("_wxapi_sendauth_resp_state");
      this.url = paramBundle.getString("_wxapi_sendauth_resp_url");
    }
    
    public int getType()
    {
      return 1;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_sendauth_resp_token", this.code);
      paramBundle.putString("_wxapi_sendauth_resp_state", this.state);
      paramBundle.putString("_wxapi_sendauth_resp_url", this.url);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.modelmsg.SendAuth
 * JD-Core Version:    0.7.0.1
 */