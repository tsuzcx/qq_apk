package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

final class f$1$1
  implements Runnable
{
  f$1$1(f.1 param1) {}
  
  public final void run()
  {
    f localf = this.fGj.fGi;
    Object localObject2 = (Activity)localf.fGd.get();
    Object localObject3;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject3 = ((Activity)localObject2).getPackageManager();
      localObject1 = (ActivityManager)((Activity)localObject2).getSystemService("activity");
      localObject2 = bk.al((Context)localObject2, ((Activity)localObject2).getTaskId());
      if (localObject2 == null) {}
    }
    try
    {
      localObject2 = ((ActivityManager.RunningTaskInfo)localObject2).topActivity;
      if ((localObject2 != null) && (localObject1 != null) && (localObject3 != null))
      {
        localObject3 = ((PackageManager)localObject3).getActivityInfo((ComponentName)localObject2, 128);
        if (localObject3 != null)
        {
          localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
            if (((localRunningAppProcessInfo.importance == 100) || (localRunningAppProcessInfo.importance == 150)) && ((((ComponentName)localObject2).equals(localRunningAppProcessInfo.importanceReasonComponent)) || (localRunningAppProcessInfo.importanceReasonCode == 0)) && (localRunningAppProcessInfo.processName.equals(((ActivityInfo)localObject3).processName))) {
              localf.acE();
            }
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "ScreenOff try confirm task top ui status, e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.f.1.1
 * JD-Core Version:    0.7.0.1
 */