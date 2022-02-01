package com.tencent.mm.ch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class c
  extends BroadcastReceiver
{
  a<Boolean> IlD;
  a<Boolean> IlE;
  
  c(Context paramContext)
  {
    AppMethodBeat.i(133217);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
    ((IntentFilter)localObject).addAction("android.intent.action.ACTION_POWER_CONNECTED");
    ((IntentFilter)localObject).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
    paramContext.registerReceiver(this, (IntentFilter)localObject);
    localObject = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    boolean bool1 = bool2;
    if (localObject != null)
    {
      int i = ((Intent)localObject).getIntExtra("status", -1);
      if (i != 2)
      {
        bool1 = bool2;
        if (i != 5) {}
      }
      else
      {
        bool1 = true;
      }
    }
    this.IlD = new a("charging", Boolean.valueOf(bool1));
    this.IlE = new a("interactive", Boolean.valueOf(((PowerManager)paramContext.getSystemService("power")).isScreenOn()));
    AppMethodBeat.o(133217);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(133218);
    paramIntent = paramIntent.getAction();
    if (paramIntent == null)
    {
      AppMethodBeat.o(133218);
      return;
    }
    paramContext = null;
    int i = -1;
    switch (paramIntent.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      if (paramContext != null) {
        ad.i("MicroMsg.SystemStatus", "System status changed: %s = %s", new Object[] { paramContext.name(), paramContext.get().toString() });
      }
      AppMethodBeat.o(133218);
      return;
      if (!paramIntent.equals("android.intent.action.SCREEN_ON")) {
        break;
      }
      i = 0;
      break;
      if (!paramIntent.equals("android.intent.action.SCREEN_OFF")) {
        break;
      }
      i = 1;
      break;
      if (!paramIntent.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
        break;
      }
      i = 2;
      break;
      if (!paramIntent.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
        break;
      }
      i = 3;
      break;
      this.IlE.set(Boolean.TRUE);
      paramContext = this.IlE;
      continue;
      this.IlE.set(Boolean.FALSE);
      paramContext = this.IlE;
      continue;
      this.IlD.set(Boolean.TRUE);
      paramContext = this.IlD;
      continue;
      this.IlD.set(Boolean.FALSE);
      paramContext = this.IlD;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ch.c
 * JD-Core Version:    0.7.0.1
 */