package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.sdk.b.a;

public class BakOldUSBReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(21811);
    try
    {
      String str = paramIntent.getAction();
      if ("MMBakchatServiceStart".equalsIgnoreCase(str))
      {
        d.aY(new Intent().setClassName(paramContext, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService").putExtra("url", paramIntent.getStringExtra("url")));
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.BakOldUSBReceiver", "START_ACTION onReceive start end");
        AppMethodBeat.o(21811);
        return;
      }
      if ("MMBakchatServiceStop".equalsIgnoreCase(str))
      {
        paramIntent = new com.tencent.mm.g.a.ad();
        paramIntent.dbW.dbX = paramContext;
        a.ESL.l(paramIntent);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.BakOldUSBReceiver", "STOP_ACTION onReceive stop end");
      }
      AppMethodBeat.o(21811);
      return;
    }
    catch (Exception paramContext)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.BakOldUSBReceiver", paramContext, "onReceive:", new Object[0]);
      AppMethodBeat.o(21811);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBReceiver
 * JD-Core Version:    0.7.0.1
 */