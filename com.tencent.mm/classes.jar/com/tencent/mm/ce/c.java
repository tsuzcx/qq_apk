package com.tencent.mm.ce;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.mm.sdk.platformtools.y;

final class c
  extends BroadcastReceiver
{
  a<Boolean> umM;
  a<Boolean> umN;
  
  c(Context paramContext)
  {
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
    this.umM = new a("charging", Boolean.valueOf(bool1));
    this.umN = new a("interactive", Boolean.valueOf(((PowerManager)paramContext.getSystemService("power")).isScreenOn()));
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (paramIntent == null) {
      return;
    }
    paramContext = null;
    int i = -1;
    switch (paramIntent.hashCode())
    {
    default: 
      label60:
      switch (i)
      {
      }
      break;
    }
    while (paramContext != null)
    {
      y.i("MicroMsg.SystemStatus", "System status changed: %s = %s", new Object[] { paramContext.name(), paramContext.get().toString() });
      return;
      if (!paramIntent.equals("android.intent.action.SCREEN_ON")) {
        break label60;
      }
      i = 0;
      break label60;
      if (!paramIntent.equals("android.intent.action.SCREEN_OFF")) {
        break label60;
      }
      i = 1;
      break label60;
      if (!paramIntent.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
        break label60;
      }
      i = 2;
      break label60;
      if (!paramIntent.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
        break label60;
      }
      i = 3;
      break label60;
      this.umN.set(Boolean.valueOf(true));
      paramContext = this.umN;
      continue;
      this.umN.set(Boolean.valueOf(false));
      paramContext = this.umN;
      continue;
      this.umM.set(Boolean.valueOf(true));
      paramContext = this.umM;
      continue;
      this.umM.set(Boolean.valueOf(false));
      paramContext = this.umM;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ce.c
 * JD-Core Version:    0.7.0.1
 */