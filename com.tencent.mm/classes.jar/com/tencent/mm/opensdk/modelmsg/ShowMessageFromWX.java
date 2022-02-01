package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class ShowMessageFromWX
{
  public static class Req
    extends BaseReq
  {
    public String country;
    public String lang;
    public WXMediaMessage message;
    
    public Req() {}
    
    public Req(Bundle paramBundle)
    {
      AppMethodBeat.i(3973);
      fromBundle(paramBundle);
      AppMethodBeat.o(3973);
    }
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(3976);
      if (this.message == null)
      {
        AppMethodBeat.o(3976);
        return false;
      }
      boolean bool = this.message.checkArgs();
      AppMethodBeat.o(3976);
      return bool;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3975);
      super.fromBundle(paramBundle);
      this.lang = paramBundle.getString("_wxapi_showmessage_req_lang");
      this.country = paramBundle.getString("_wxapi_showmessage_req_country");
      this.message = WXMediaMessage.Builder.fromBundle(paramBundle);
      AppMethodBeat.o(3975);
    }
    
    public int getType()
    {
      return 4;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3974);
      Bundle localBundle = WXMediaMessage.Builder.toBundle(this.message);
      super.toBundle(localBundle);
      paramBundle.putString("_wxapi_showmessage_req_lang", this.lang);
      paramBundle.putString("_wxapi_showmessage_req_country", this.country);
      paramBundle.putAll(localBundle);
      AppMethodBeat.o(3974);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(3957);
      fromBundle(paramBundle);
      AppMethodBeat.o(3957);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public int getType()
    {
      return 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX
 * JD-Core Version:    0.7.0.1
 */