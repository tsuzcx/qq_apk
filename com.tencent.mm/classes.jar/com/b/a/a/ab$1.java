package com.b.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class ab$1
  extends BroadcastReceiver
{
  ab$1(ab paramab) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(55584);
    if (paramIntent.getAction().equals("android.net.wifi.SCAN_RESULTS"))
    {
      paramContext = this.bsM;
      try
      {
        paramIntent = paramContext.bmz.getScanResults();
        if ((paramIntent != null) && (!paramIntent.isEmpty())) {
          break label67;
        }
        paramContext = new Exception("WifiScanMsg: null or empty scan result list");
        AppMethodBeat.o(55584);
        throw paramContext;
      }
      catch (Exception paramContext) {}
    }
    else
    {
      AppMethodBeat.o(55584);
      return;
    }
    label67:
    paramContext.c(new ab.a(paramIntent));
    AppMethodBeat.o(55584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.b.a.a.ab.1
 * JD-Core Version:    0.7.0.1
 */