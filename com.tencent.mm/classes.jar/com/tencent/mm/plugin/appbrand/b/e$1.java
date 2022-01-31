package com.tencent.mm.plugin.appbrand.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class e$1
  extends BroadcastReceiver
{
  final String gYK = "reason";
  final String gYL = "homekey";
  final String gYM = "recentapps";
  
  e$1(e parame) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(114317);
    if (paramIntent == null)
    {
      AppMethodBeat.o(114317);
      return;
    }
    if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if (paramContext != null)
      {
        ab.i("MicroMsg.BaseAppBrandUIHomePressReceiver", "[home_pressed] action: %s, reason: %s", new Object[] { paramIntent.getAction(), paramContext });
        if (paramContext.equals("homekey"))
        {
          this.gYN.awt();
          AppMethodBeat.o(114317);
          return;
        }
        if (paramContext.equals("recentapps")) {
          this.gYN.awu();
        }
      }
    }
    AppMethodBeat.o(114317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.e.1
 * JD-Core Version:    0.7.0.1
 */