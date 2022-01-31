package com.tencent.mm.plugin.appbrand.task;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.e.k;
import java.util.Iterator;
import java.util.List;

final class c
  extends j
{
  protected final boolean a(g paramg)
  {
    return paramg != g.iKT;
  }
  
  final void aLF()
  {
    AppMethodBeat.i(132780);
    Object localObject = (ActivityManager)ah.getContext().getSystemService("activity");
    if (localObject == null)
    {
      AppMethodBeat.o(132780);
      return;
    }
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null)
    {
      AppMethodBeat.o(132780);
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((ah.getPackageName() + ":toolsmp").equals(localRunningAppProcessInfo.processName)) {
        if (localRunningAppProcessInfo.importance == 100)
        {
          AppMethodBeat.o(132780);
          return;
        }
      }
    }
    localObject = new Intent();
    ((Intent)localObject).setComponent(new ComponentName(e.k.iXz, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    ((Intent)localObject).putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    ah.getContext().sendBroadcast((Intent)localObject);
    AppMethodBeat.o(132780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.c
 * JD-Core Version:    0.7.0.1
 */