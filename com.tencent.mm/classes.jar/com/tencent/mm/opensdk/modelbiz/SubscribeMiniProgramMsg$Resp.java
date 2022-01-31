package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class SubscribeMiniProgramMsg$Resp
  extends BaseResp
{
  private static final String TAG = "MicroMsg.SDK.SubscribeMessage.Resp";
  public String nickname;
  public String unionId;
  
  public SubscribeMiniProgramMsg$Resp() {}
  
  public SubscribeMiniProgramMsg$Resp(Bundle paramBundle)
  {
    AppMethodBeat.i(128212);
    fromBundle(paramBundle);
    AppMethodBeat.o(128212);
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128213);
    super.fromBundle(paramBundle);
    this.unionId = paramBundle.getString("_wxapi_subscribeminiprogram_resp_unionId");
    this.nickname = paramBundle.getString("_wxapi_subscribeminiprogram_resp_nickname");
    AppMethodBeat.o(128213);
  }
  
  public int getType()
  {
    return 23;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128214);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_subscribeminiprogram_resp_unionId", this.unionId);
    paramBundle.putString("_wxapi_subscribeminiprogram_resp_nickname", this.nickname);
    AppMethodBeat.o(128214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg.Resp
 * JD-Core Version:    0.7.0.1
 */