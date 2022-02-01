package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class MMReceivers$BootReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(131889);
    if (paramContext == null)
    {
      AppMethodBeat.o(131889);
      return;
    }
    new StringBuilder("system booted, pid=").append(Process.myPid());
    if (!b.c(paramContext, "auto", true))
    {
      MMReceivers.AlarmReceiver.cS(paramContext);
      Log.appenderFlush();
    }
    AppMethodBeat.o(131889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.BootReceiver
 * JD-Core Version:    0.7.0.1
 */