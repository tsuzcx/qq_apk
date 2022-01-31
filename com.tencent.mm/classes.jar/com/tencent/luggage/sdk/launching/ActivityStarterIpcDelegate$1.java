package com.tencent.luggage.sdk.launching;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ActivityStarterIpcDelegate$1
  extends ResultReceiver
{
  ActivityStarterIpcDelegate$1(ActivityStarterIpcDelegate paramActivityStarterIpcDelegate, Handler paramHandler, Activity paramActivity)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(101662);
    super.onReceiveResult(paramInt, paramBundle);
    if ((4660 == paramInt) && (paramBundle != null))
    {
      paramBundle = (Intent)paramBundle.getParcelable("intent");
      if (paramBundle != null)
      {
        paramBundle.setFlags(paramBundle.getFlags() & 0xEFFFFFFF);
        this.bET.startActivity(paramBundle);
      }
    }
    AppMethodBeat.o(101662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate.1
 * JD-Core Version:    0.7.0.1
 */