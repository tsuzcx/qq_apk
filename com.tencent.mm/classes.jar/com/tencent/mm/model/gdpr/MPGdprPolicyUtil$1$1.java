package com.tencent.mm.model.gdpr;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;

class MPGdprPolicyUtil$1$1
  extends ResultReceiver
{
  MPGdprPolicyUtil$1$1(c.1 param1, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(1488);
    paramBundle = this.foG.foE;
    if (paramInt > 0) {}
    for (paramInt = 0;; paramInt = 1)
    {
      paramBundle.kK(paramInt);
      AppMethodBeat.o(1488);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.MPGdprPolicyUtil.1.1
 * JD-Core Version:    0.7.0.1
 */