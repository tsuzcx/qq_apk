package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class JoinChatroom$Resp
  extends BaseResp
{
  public String extMsg;
  
  public JoinChatroom$Resp() {}
  
  public JoinChatroom$Resp(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.extMsg = paramBundle.getString("_wxapi_join_chatroom_ext_msg");
  }
  
  public int getType()
  {
    return 15;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.JoinChatroom.Resp
 * JD-Core Version:    0.7.0.1
 */