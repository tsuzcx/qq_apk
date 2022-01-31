package com.tencent.mm.plugin.appbrand.task;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

class i
{
  final Class gIM;
  final String hce;
  final Class hcf;
  private final Class hcg;
  final LinkedHashMap<String, Integer> hch = new LinkedHashMap();
  final LinkedHashMap<String, AppBrandRemoteTaskController> hci = new LinkedHashMap();
  f hcj = f.hbW;
  
  i(Class paramClass1, Class paramClass2, Class paramClass3)
  {
    this.hce = paramClass1.getName();
    this.hcf = paramClass1;
    this.hcg = paramClass2;
    this.gIM = paramClass3;
  }
  
  final void EV()
  {
    if (this.hcg == null) {
      return;
    }
    Intent localIntent = new Intent();
    AppBrandPreloadProfiler localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
    localAppBrandPreloadProfiler.hbd = SystemClock.elapsedRealtime();
    localIntent.putExtra("preloadProfiler", localAppBrandPreloadProfiler);
    localIntent.setClass(ae.getContext(), this.hcg);
    localIntent.putExtra("AppBrandServiceType", this.hcj.code);
    ae.getContext().sendBroadcast(localIntent);
  }
  
  void a(String paramString, int paramInt, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    this.hch.put(paramString, Integer.valueOf(paramInt));
    this.hci.put(paramString, paramAppBrandRemoteTaskController);
  }
  
  protected boolean a(f paramf)
  {
    return true;
  }
  
  void aoC()
  {
    if (!this.hch.isEmpty()) {}
    for (;;)
    {
      return;
      Object localObject2 = (ActivityManager)ae.getContext().getSystemService("activity");
      Object localObject1 = ae.getContext().getPackageManager();
      if ((localObject2 != null) && (localObject1 != null)) {
        try
        {
          localObject1 = ((PackageManager)localObject1).getActivityInfo(new ComponentName(ae.getContext(), this.hcf), 128).processName;
          localObject2 = ((ActivityManager)localObject2).getRunningAppProcesses();
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
            } while (!localRunningAppProcessInfo.processName.equals(localObject1));
            Process.killProcess(localRunningAppProcessInfo.pid);
            return;
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  final void f(f paramf)
  {
    if (!a(paramf)) {
      throw new IllegalStateException("AppBrandUITask not support this type. [" + paramf.name() + "]");
    }
    this.hcj = paramf;
  }
  
  void wi(String paramString)
  {
    this.hch.remove(paramString);
    this.hci.remove(paramString);
    if (this.hch.isEmpty()) {
      this.hcj = f.hbW;
    }
  }
  
  final Integer ws(String paramString)
  {
    return (Integer)this.hch.get(paramString);
  }
  
  final AppBrandRemoteTaskController wt(String paramString)
  {
    return (AppBrandRemoteTaskController)this.hci.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.i
 * JD-Core Version:    0.7.0.1
 */