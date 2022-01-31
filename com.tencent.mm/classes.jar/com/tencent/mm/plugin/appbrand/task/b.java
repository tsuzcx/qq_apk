package com.tencent.mm.plugin.appbrand.task;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveServiceInTools;
import com.tencent.mm.plugin.appbrand.ui.AppBrandInToolsUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.e.i;
import java.util.Iterator;
import java.util.List;

final class b
  extends i
{
  b()
  {
    super(AppBrandInToolsUI.class, null, AppBrandKeepAliveServiceInTools.class);
  }
  
  protected final boolean a(f paramf)
  {
    return paramf != f.hbV;
  }
  
  final void aoC()
  {
    Object localObject = (ActivityManager)ae.getContext().getSystemService("activity");
    if (localObject == null) {}
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      do
      {
        return;
        localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      } while (localObject == null);
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      } while (!(ae.getPackageName() + ":toolsmp").equals(localRunningAppProcessInfo.processName));
    } while (localRunningAppProcessInfo.importance == 100);
    localObject = new Intent();
    ((Intent)localObject).setComponent(new ComponentName(e.i.hle, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    ((Intent)localObject).putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    ae.getContext().sendBroadcast((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.b
 * JD-Core Version:    0.7.0.1
 */