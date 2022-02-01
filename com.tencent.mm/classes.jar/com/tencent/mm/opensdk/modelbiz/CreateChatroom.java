package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.d;

public class CreateChatroom
{
  public static class Req
    extends BaseReq
  {
    public String chatroomName;
    public String chatroomNickName;
    public String extMsg;
    public String groupId = "";
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(3857);
      if (d.b(this.groupId))
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
  
  public static class Resp
    extends BaseResp
  {
    public String extMsg;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.CreateChatroom
 * JD-Core Version:    0.7.0.1
 */