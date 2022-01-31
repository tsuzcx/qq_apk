package com.tencent.mm.plugin.appbrand.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;

final class e$1
  extends BroadcastReceiver
{
  final String fGe = "reason";
  final String fGf = "homekey";
  
  e$1(e parame) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!"android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramIntent.getAction()));
        paramContext = paramIntent.getStringExtra("reason");
      } while (paramContext == null);
      y.i("MicroMsg.BaseAppBrandUIHomePressReceiver", "[home_pressed] action: %s, reason: %s", new Object[] { paramIntent.getAction(), paramContext });
    } while (!paramContext.equals("homekey"));
    this.fGg.acD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.e.1
 * JD-Core Version:    0.7.0.1
 */