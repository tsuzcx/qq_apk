package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class SendMessageToWX$Resp
  extends BaseResp
{
  public SendMessageToWX$Resp() {}
  
  public SendMessageToWX$Resp(Bundle paramBundle)
  {
    AppMethodBeat.i(4011);
    fromBundle(paramBundle);
    AppMethodBeat.o(4011);
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(4012);
    super.fromBundle(paramBundle);
    AppMethodBeat.o(4012);
  }
  
  public int getType()
  {
    return 2;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(4013);
    super.toBundle(paramBundle);
    AppMethodBeat.o(4013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Resp
 * JD-Core Version:    0.7.0.1
 */