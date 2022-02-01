package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.b;

public class CreateChatroom$Req
  extends BaseReq
{
  public String chatroomName;
  public String chatroomNickName;
  public String extMsg;
  public String groupId;
  
  public CreateChatroom$Req()
  {
    AppMethodBeat.i(190368);
    this.groupId = "";
    AppMethodBeat.o(190368);
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(3857);
    if (b.b(this.groupId))
    {
      AppMethodBeat.o(3857);
      return false;
    }
    AppMethodBeat.o(3857);
    return true;
  }
  
  public int getType()
  {
    return 14;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3858);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_create_chatroom_group_id", this.groupId);
    paramBundle.putString("_wxapi_create_chatroom_chatroom_name", this.chatroomName);
    paramBundle.putString("_wxapi_create_chatroom_chatroom_nickname", this.chatroomNickName);
    paramBundle.putString("_wxapi_create_chatroom_ext_msg", this.extMsg);
    paramBundle.putString("_wxapi_basereq_openid", this.openId);
    AppMethodBeat.o(3858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.CreateChatroom.Req
 * JD-Core Version:    0.7.0.1
 */