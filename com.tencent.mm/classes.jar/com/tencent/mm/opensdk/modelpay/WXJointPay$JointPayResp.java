package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WXJointPay$JointPayResp
  extends PayResp
{
  public WXJointPay$JointPayResp() {}
  
  public WXJointPay$JointPayResp(Bundle paramBundle)
  {
    AppMethodBeat.i(3841);
    fromBundle(paramBundle);
    AppMethodBeat.o(3841);
  }
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(3844);
    boolean bool = super.checkArgs();
    AppMethodBeat.o(3844);
    return bool;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3843);
    super.fromBundle(paramBundle);
    AppMethodBeat.o(3843);
  }
  
  public int getType()
  {
    return 27;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(3842);
    super.toBundle(paramBundle);
    AppMethodBeat.o(3842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayResp
 * JD-Core Version:    0.7.0.1
 */