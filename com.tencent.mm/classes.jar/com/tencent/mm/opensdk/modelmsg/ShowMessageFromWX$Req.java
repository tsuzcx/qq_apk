package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public class ShowMessageFromWX$Req
  extends BaseReq
{
  public String country;
  public String lang;
  public WXMediaMessage message;
  
  public ShowMessageFromWX$Req() {}
  
  public ShowMessageFromWX$Req(Bundle paramBundle)
  {
    AppMethodBeat.i(3973);
    fromBundle(paramBundle);
    AppMethodBeat.o(3973);
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(3976);
    WXMediaMessage localWXMediaMessage = this.message;
    if (localWXMediaMessage == null)
    {
      AppMethodBeat.o(3976);
      return false;
    }
    boolean bool = localWXMediaMessage.checkArgs();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req
 * JD-Core Version:    0.7.0.1
 */