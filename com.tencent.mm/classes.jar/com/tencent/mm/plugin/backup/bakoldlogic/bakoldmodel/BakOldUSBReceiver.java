package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;

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
        d.aZ(new Intent().setClassName(paramContext, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService").putExtra("url", paramIntent.getStringExtra("url")));
        ac.d("MicroMsg.BakOldUSBReceiver", "START_ACTION onReceive start end");
        AppMethodBeat.o(21811);
        return;
      }
      if ("MMBakchatServiceStop".equalsIgnoreCase(str))
      {
        paramIntent = new ae();
        paramIntent.cZv.cZw = paramContext;
        a.GpY.l(paramIntent);
        ac.d("MicroMsg.BakOldUSBReceiver", "STOP_ACTION onReceive stop end");
      }
      AppMethodBeat.o(21811);
      return;
    }
    catch (Exception paramContext)
    {
      ac.printErrStackTrace("MicroMsg.BakOldUSBReceiver", paramContext, "onReceive:", new Object[0]);
      AppMethodBeat.o(21811);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBReceiver
 * JD-Core Version:    0.7.0.1
 */