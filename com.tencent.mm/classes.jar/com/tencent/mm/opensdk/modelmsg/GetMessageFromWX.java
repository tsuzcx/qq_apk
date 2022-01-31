package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
      AppMethodBeat.i(128308);
      fromBundle(paramBundle);
      AppMethodBeat.o(128308);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(128310);
      super.fromBundle(paramBundle);
      this.lang = paramBundle.getString("_wxapi_getmessage_req_lang");
      this.country = paramBundle.getString("_wxapi_getmessage_req_country");
      AppMethodBeat.o(128310);
    }
    
    public int getType()
    {
      return 3;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(128309);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_getmessage_req_lang", this.lang);
      paramBundle.putString("_wxapi_getmessage_req_country", this.country);
      AppMethodBeat.o(128309);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.GetMessageFromWX
 * JD-Core Version:    0.7.0.1
 */