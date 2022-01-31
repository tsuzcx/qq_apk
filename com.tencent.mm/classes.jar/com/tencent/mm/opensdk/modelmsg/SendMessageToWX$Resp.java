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
    AppMethodBeat.i(128311);
    fromBundle(paramBundle);
    AppMethodBeat.o(128311);
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128312);
    super.fromBundle(paramBundle);
    AppMethodBeat.o(128312);
  }
  
  public int getType()
  {
    return 2;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128313);
    super.toBundle(paramBundle);
    AppMethodBeat.o(128313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Resp
 * JD-Core Version:    0.7.0.1
 */