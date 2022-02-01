package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class JumpToOfflinePay$Resp
  extends BaseResp
{
  public JumpToOfflinePay$Resp() {}
  
  public JumpToOfflinePay$Resp(Bundle paramBundle)
  {
    AppMethodBeat.i(3836);
    fromBundle(paramBundle);
    AppMethodBeat.o(3836);
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3838);
    super.fromBundle(paramBundle);
    AppMethodBeat.o(3838);
  }
  
  public int getType()
  {
    return 24;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3837);
    super.toBundle(paramBundle);
    AppMethodBeat.o(3837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelpay.JumpToOfflinePay.Resp
 * JD-Core Version:    0.7.0.1
 */