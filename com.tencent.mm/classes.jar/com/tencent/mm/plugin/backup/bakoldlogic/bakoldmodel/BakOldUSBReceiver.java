package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.h.a.aa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

public class BakOldUSBReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      String str = paramIntent.getAction();
      if ("MMBakchatServiceStart".equalsIgnoreCase(str))
      {
        paramContext.startService(new Intent().setClassName(paramContext, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService").putExtra("url", paramIntent.getStringExtra("url")));
        y.d("MicroMsg.BakOldUSBReceiver", "START_ACTION onReceive start end");
        return;
      }
      if ("MMBakchatServiceStop".equalsIgnoreCase(str))
      {
        paramIntent = new aa();
        paramIntent.bFZ.bGa = paramContext;
        a.udP.m(paramIntent);
        y.d("MicroMsg.BakOldUSBReceiver", "STOP_ACTION onReceive stop end");
        return;
      }
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.BakOldUSBReceiver", paramContext, "onReceive:", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBReceiver
 * JD-Core Version:    0.7.0.1
 */