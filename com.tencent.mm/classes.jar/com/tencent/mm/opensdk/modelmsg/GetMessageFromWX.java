package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public final class GetMessageFromWX
{
  public static class Req
    extends BaseReq
  {
    public String country;
    public String lang;
    public String username;
    
    public Req() {}
    
    public Req(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.lang = paramBundle.getString("_wxapi_getmessage_req_lang");
      this.country = paramBundle.getString("_wxapi_getmessage_req_country");
    }
    
    public int getType()
    {
      return 3;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_getmessage_req_lang", this.lang);
      paramBundle.putString("_wxapi_getmessage_req_country", this.country);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.GetMessageFromWX
 * JD-Core Version:    0.7.0.1
 */