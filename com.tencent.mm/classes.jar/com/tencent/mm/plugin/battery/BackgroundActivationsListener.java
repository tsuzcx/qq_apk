package com.tencent.mm.plugin.battery;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Application;
import android.app.Notification;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import com.tencent.matrix.report.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;

public final class BackgroundActivationsListener
  extends NotificationListenerService
{
  public final void onCreate()
  {
    AppMethodBeat.i(200993);
    super.onCreate();
    Log.i("MicroMsg.battery.BackgroundActivationsListener", "#onCreate");
    ComponentName localComponentName = new ComponentName(this, BackgroundActivationsListener.class);
    if (Build.VERSION.SDK_INT >= 24)
    {
      Log.i("MicroMsg.battery.BackgroundActivationsListener", "requestRebind");
      requestRebind(localComponentName);
      AppMethodBeat.o(200993);
      return;
    }
    Log.i("MicroMsg.battery.BackgroundActivationsListener", "requestRebind Legacy");
    Object localObject = (ActivityManager)getSystemService("activity");
    if (localObject == null)
    {
      Log.w("MicroMsg.battery.BackgroundActivationsListener", "am is null");
      AppMethodBeat.o(200993);
      return;
    }
    localObject = ((ActivityManager)localObject).getRunningServices(2147483647);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      Log.w("MicroMsg.battery.BackgroundActivationsListener", "runningServices is empty");
      AppMethodBeat.o(200993);
      return;
    }
    localObject = ((List)localObject).iterator();
    ActivityManager.RunningServiceInfo localRunningServiceInfo;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localRunningServiceInfo = (ActivityManager.RunningServiceInfo)((Iterator)localObject).next();
    } while ((!localRunningServiceInfo.service.equals(localComponentName)) || (localRunningServiceInfo.pid != Process.myPid()));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.battery.BackgroundActivationsListener", "service is running, skip");
        AppMethodBeat.o(200993);
        return;
      }
      Log.i("MicroMsg.battery.BackgroundActivationsListener", "try manually rebind service");
      localComponentName = new ComponentName(this, BackgroundActivationsListener.class);
      localObject = getPackageManager();
      ((PackageManager)localObject).setComponentEnabledSetting(localComponentName, 2, 1);
      ((PackageManager)localObject).setComponentEnabledSetting(localComponentName, 1, 1);
      AppMethodBeat.o(200993);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(200994);
    Log.i("MicroMsg.battery.BackgroundActivationsListener", "#onDestroy");
    super.onDestroy();
    AppMethodBeat.o(200994);
  }
  
  public final void onListenerConnected()
  {
    AppMethodBeat.i(200997);
    super.onListenerConnected();
    Log.i("MicroMsg.battery.BackgroundActivationsListener", "#onListenerConnected");
    AppMethodBeat.o(200997);
  }
  
  public final void onListenerDisconnected()
  {
    AppMethodBeat.i(200998);
    super.onListenerDisconnected();
    Log.i("MicroMsg.battery.BackgroundActivationsListener", "#onListenerDisconnected");
    AppMethodBeat.o(200998);
  }
  
  public final void onNotificationPosted(StatusBarNotification paramStatusBarNotification)
  {
    AppMethodBeat.i(200995);
    super.onNotificationPosted(paramStatusBarNotification);
    Log.i("MicroMsg.battery.BackgroundActivationsListener", "#onNotificationPosted");
    Notification localNotification = paramStatusBarNotification.getNotification();
    String str;
    int i;
    label101:
    Object localObject;
    if (Build.VERSION.SDK_INT >= 26)
    {
      str = localNotification.getChannelId();
      if (!"FOREGROUND_SERVICE".equals(str)) {
        break label185;
      }
      Log.d("MicroMsg.battery.BackgroundActivationsListener", "sbn = " + paramStatusBarNotification.toString());
      paramStatusBarNotification = localNotification.extras.getStringArray("android.foregroundApps");
      str = getApplication().getPackageName();
      if (paramStatusBarNotification == null) {
        break label185;
      }
      int j = paramStatusBarNotification.length;
      i = 0;
      if (i >= j) {
        break label185;
      }
      localObject = paramStatusBarNotification[i];
      if (!str.equals(localObject)) {
        break label163;
      }
      Log.w("MicroMsg.battery.BackgroundActivationsListener", "AMS on updateForegroundApps, notification = " + localNotification.toString());
      a.a.cB(false);
    }
    for (;;)
    {
      i += 1;
      break label101;
      str = null;
      break;
      label163:
      Log.w("MicroMsg.battery.BackgroundActivationsListener", "AMS on updateForegroundApps for others, pkg = ".concat(String.valueOf(localObject)));
      a.a.cB(true);
    }
    label185:
    AppMethodBeat.o(200995);
  }
  
  public final void onNotificationRemoved(StatusBarNotification paramStatusBarNotification)
  {
    AppMethodBeat.i(200996);
    super.onNotificationRemoved(paramStatusBarNotification);
    Log.i("MicroMsg.battery.BackgroundActivationsListener", "#onNotificationRemoved");
    AppMethodBeat.o(200996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.battery.BackgroundActivationsListener
 * JD-Core Version:    0.7.0.1
 */