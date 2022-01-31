package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.aa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public class BakOldUSBReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(17754);
    try
    {
      String str = paramIntent.getAction();
      if ("MMBakchatServiceStart".equalsIgnoreCase(str))
      {
        d.aG(new Intent().setClassName(paramContext, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService").putExtra("url", paramIntent.getStringExtra("url")));
        ab.d("MicroMsg.BakOldUSBReceiver", "START_ACTION onReceive start end");
        AppMethodBeat.o(17754);
        return;
      }
      if ("MMBakchatServiceStop".equalsIgnoreCase(str))
      {
        paramIntent = new aa();
        paramIntent.cng.cnh = paramContext;
        a.ymk.l(paramIntent);
        ab.d("MicroMsg.BakOldUSBReceiver", "STOP_ACTION onReceive stop end");
      }
      AppMethodBeat.o(17754);
      return;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.BakOldUSBReceiver", paramContext, "onReceive:", new Object[0]);
      AppMethodBeat.o(17754);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBReceiver
 * JD-Core Version:    0.7.0.1
 */