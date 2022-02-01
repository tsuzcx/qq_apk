package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WXJointPay$JointPayReq
  extends PayReq
{
  public boolean checkArgs()
  {
    AppMethodBeat.i(3830);
    boolean bool = super.checkArgs();
    AppMethodBeat.o(3830);
    return bool;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3832);
    super.fromBundle(paramBundle);
    AppMethodBeat.o(3832);
  }
  
  public int getType()
  {
    return 27;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3831);
    super.toBundle(paramBundle);
    AppMethodBeat.o(3831);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayReq
 * JD-Core Version:    0.7.0.1
 */