package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public class GetMessageFromWX$Req
  extends BaseReq
{
  public String country;
  public String lang;
  public String username;
  
  public GetMessageFromWX$Req() {}
  
  public GetMessageFromWX$Req(Bundle paramBundle)
  {
    AppMethodBeat.i(4008);
    fromBundle(paramBundle);
    AppMethodBeat.o(4008);
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(4010);
    super.fromBundle(paramBundle);
    this.lang = paramBundle.getString("_wxapi_getmessage_req_lang");
    this.country = paramBundle.getString("_wxapi_getmessage_req_country");
    AppMethodBeat.o(4010);
  }
  
  public int getType()
  {
    return 3;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(4009);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_getmessage_req_lang", this.lang);
    paramBundle.putString("_wxapi_getmessage_req_country", this.country);
    AppMethodBeat.o(4009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Req
 * JD-Core Version:    0.7.0.1
 */