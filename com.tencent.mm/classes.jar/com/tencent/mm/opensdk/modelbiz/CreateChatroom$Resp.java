package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class CreateChatroom$Resp
  extends BaseResp
{
  public String extMsg;
  
  public CreateChatroom$Resp() {}
  
  public CreateChatroom$Resp(Bundle paramBundle)
  {
    AppMethodBeat.i(3864);
    fromBundle(paramBundle);
    AppMethodBeat.o(3864);
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3865);
    super.fromBundle(paramBundle);
    this.extMsg = paramBundle.getString("_wxapi_create_chatroom_ext_msg");
    AppMethodBeat.o(3865);
  }
  
  public int getType()
  {
    return 14;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3866);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_create_chatroom_ext_msg", this.extMsg);
    AppMethodBeat.o(3866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.CreateChatroom.Resp
 * JD-Core Version:    0.7.0.1
 */