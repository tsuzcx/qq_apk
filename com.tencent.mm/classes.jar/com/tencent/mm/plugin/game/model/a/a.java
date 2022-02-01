package com.tencent.mm.plugin.game.model.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  public static a dWb()
  {
    AppMethodBeat.i(41660);
    Object localObject = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    Intent localIntent = MMApplicationContext.getContext().registerReceiver(null, (IntentFilter)localObject);
    localObject = new a();
    if (localIntent != null) {}
    for (;;)
    {
      try
      {
        i = localIntent.getIntExtra("status", -1);
        if (i == 2) {
          continue;
        }
        if (i != 5) {
          continue;
        }
      }
      catch (Exception localException)
      {
        int i;
        int j;
        Log.e("MicroMsg.BatteryHelper", "err:%s", new Object[] { localException.getMessage() });
        continue;
        boolean bool = true;
        continue;
      }
      ((a)localObject).ohV = bool;
      i = localIntent.getIntExtra("level", -1);
      j = localIntent.getIntExtra("scale", -1);
      ((a)localObject).xIk = (i / j);
      AppMethodBeat.o(41660);
      return localObject;
      bool = false;
    }
  }
  
  public static final class a
  {
    boolean ohV = false;
    float xIk = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.a
 * JD-Core Version:    0.7.0.1
 */