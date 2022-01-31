package com.tencent.mm.plugin.game.model.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public static a.a aZS()
  {
    Object localObject = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    Intent localIntent = ae.getContext().registerReceiver(null, (IntentFilter)localObject);
    localObject = new a.a();
    if (localIntent != null) {}
    label117:
    for (;;)
    {
      try
      {
        int i = localIntent.getIntExtra("status", -1);
        if (i != 2) {
          if (i == 5)
          {
            break label117;
            ((a.a)localObject).hlS = bool;
            i = localIntent.getIntExtra("level", -1);
            int j = localIntent.getIntExtra("scale", -1);
            ((a.a)localObject).kFN = (i / j);
            return localObject;
          }
          else
          {
            bool = false;
            continue;
          }
        }
        boolean bool = true;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.BatteryHelper", "err:%s", new Object[] { localException.getMessage() });
        return localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.a
 * JD-Core Version:    0.7.0.1
 */