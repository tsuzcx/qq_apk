package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class JoinChatroom$Resp
  extends BaseResp
{
  public String extMsg;
  
  public JoinChatroom$Resp() {}
  
  public JoinChatroom$Resp(Bundle paramBundle)
  {
    AppMethodBeat.i(3901);
    fromBundle(paramBundle);
    AppMethodBeat.o(3901);
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3902);
    super.fromBundle(paramBundle);
    this.extMsg = paramBundle.getString("_wxapi_join_chatroom_ext_msg");
    AppMethodBeat.o(3902);
  }
  
  public int getType()
  {
    return 15;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3903);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
    AppMethodBeat.o(3903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.JoinChatroom.Resp
 * JD-Core Version:    0.7.0.1
 */