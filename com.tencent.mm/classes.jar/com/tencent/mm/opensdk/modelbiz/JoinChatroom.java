package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.b;

public class JoinChatroom
{
  public static class Req
    extends BaseReq
  {
    public String chatroomNickName;
    public String extMsg;
    public String groupId;
    
    public Req()
    {
      AppMethodBeat.i(254778);
      this.groupId = "";
      AppMethodBeat.o(254778);
    }
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(3867);
      if (b.b(this.groupId))
      {
        AppMethodBeat.o(3867);
        return false;
      }
      AppMethodBeat.o(3867);
      return true;
    }
    
    public int getType()
    {
      return 15;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3868);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_join_chatroom_group_id", this.groupId);
      paramBundle.putString("_wxapi_join_chatroom_chatroom_nickname", this.chatroomNickName);
      paramBundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
      paramBundle.putString("_wxapi_basereq_openid", this.openId);
      AppMethodBeat.o(3868);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public String extMsg;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.JoinChatroom
 * JD-Core Version:    0.7.0.1
 */