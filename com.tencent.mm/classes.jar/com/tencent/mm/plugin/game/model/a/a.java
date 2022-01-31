package com.tencent.mm.plugin.game.model.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
{
  public static a.a bGY()
  {
    AppMethodBeat.i(111496);
    Object localObject = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    Intent localIntent = ah.getContext().registerReceiver(null, (IntentFilter)localObject);
    localObject = new a.a();
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
        ab.e("MicroMsg.BatteryHelper", "err:%s", new Object[] { localException.getMessage() });
        continue;
        boolean bool = true;
        continue;
      }
      ((a.a)localObject).iYt = bool;
      i = localIntent.getIntExtra("level", -1);
      j = localIntent.getIntExtra("scale", -1);
      ((a.a)localObject).npG = (i / j);
      AppMethodBeat.o(111496);
      return localObject;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.a
 * JD-Core Version:    0.7.0.1
 */