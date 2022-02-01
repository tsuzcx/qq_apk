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
    AppMethodBeat.i(3904);
    fromBundle(paramBundle);
    AppMethodBeat.o(3904);
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3905);
    super.fromBundle(paramBundle);
    this.unionId = paramBundle.getString("_wxapi_subscribeminiprogram_resp_unionId");
    this.nickname = paramBundle.getString("_wxapi_subscribeminiprogram_resp_nickname");
    AppMethodBeat.o(3905);
  }
  
  public int getType()
  {
    return 23;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3906);
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_subscribeminiprogram_resp_unionId", this.unionId);
    paramBundle.putString("_wxapi_subscribeminiprogram_resp_nickname", this.nickname);
    AppMethodBeat.o(3906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg.Resp
 * JD-Core Version:    0.7.0.1
 */