package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class JumpToOfflinePay
{
  public static class Resp
    extends BaseResp
  {
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(128145);
      fromBundle(paramBundle);
      AppMethodBeat.o(128145);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(128147);
      super.fromBundle(paramBundle);
      AppMethodBeat.o(128147);
    }
    
    public int getType()
    {
      return 24;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(128146);
      super.toBundle(paramBundle);
      AppMethodBeat.o(128146);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelpay.JumpToOfflinePay
 * JD-Core Version:    0.7.0.1
 */