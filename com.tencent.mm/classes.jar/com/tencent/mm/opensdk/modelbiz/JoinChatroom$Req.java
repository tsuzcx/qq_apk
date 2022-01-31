package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.d;

public class JoinChatroom$Req
  extends BaseReq
{
  public String chatroomNickName;
  public String extMsg;
  public String groupId = "";
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(128172);
    if (d.b(this.groupId))
    {
      AppMethodBeat.o(128172);
      return false;
    }
    AppMethodBeat.o(128172);
    return true;
  }
  
  public int getType()
  {
    return 15;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128173);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_join_chatroom_group_id", this.groupId);
    paramBundle.putString("_wxapi_join_chatroom_chatroom_nickname", this.chatroomNickName);
    paramBundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
    paramBundle.putString("_wxapi_basereq_openid", this.openId);
    AppMethodBeat.o(128173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.JoinChatroom.Req
 * JD-Core Version:    0.7.0.1
 */