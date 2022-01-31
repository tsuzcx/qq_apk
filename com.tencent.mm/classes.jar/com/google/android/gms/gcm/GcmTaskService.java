package com.google.android.gms.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class GcmTaskService
  extends Service
{
  public static final String SERVICE_ACTION_EXECUTE_TASK = "com.google.android.gms.gcm.ACTION_TASK_READY";
  public static final String SERVICE_ACTION_INITIALIZE = "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE";
  public static final String SERVICE_PERMISSION = "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE";
  private final Set<String> zzbgv = new HashSet();
  private int zzbgw;
  private ExecutorService zzqp;
  
  private void zzeD(String paramString)
  {
    synchronized (this.zzbgv)
    {
      this.zzbgv.remove(paramString);
      if (this.zzbgv.size() == 0) {
        stopSelf(this.zzbgw);
      }
      return;
    }
  }
  
  private void zzjB(int paramInt)
  {
    synchronized (this.zzbgv)
    {
      this.zzbgw = paramInt;
      if (this.zzbgv.size() == 0) {
        stopSelf(this.zzbgw);
      }
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.zzqp = zzGQ();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    List localList = this.zzqp.shutdownNow();
    if (!localList.isEmpty())
    {
      int i = localList.size();
      new StringBuilder(79).append("Shutting down, but not all tasks are finished executing. Remaining: ").append(i);
    }
  }
  
  public void onInitializeTasks() {}
  
  public abstract int onRunTask(TaskParams paramTaskParams);
  
  public int onStartCommand(Intent arg1, int paramInt1, int paramInt2)
  {
    if (??? == null)
    {
      zzjB(paramInt2);
      return 2;
    }
    for (;;)
    {
      try
      {
        ???.setExtrasClassLoader(PendingCallback.class.getClassLoader());
        String str = ???.getAction();
        if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(str))
        {
          str = ???.getStringExtra("tag");
          Object localObject2 = ???.getParcelableExtra("callback");
          Bundle localBundle = (Bundle)???.getParcelableExtra("extras");
          ArrayList localArrayList = ???.getParcelableArrayListExtra("triggered_uris");
          if ((localObject2 == null) || (!(localObject2 instanceof PendingCallback)))
          {
            ??? = String.valueOf(getPackageName());
            new StringBuilder(String.valueOf(???).length() + 47 + String.valueOf(str).length()).append(???).append(" ").append(str).append(": Could not process request, invalid callback.");
            return 2;
          }
          synchronized (this.zzbgv)
          {
            if (!this.zzbgv.add(str))
            {
              localObject2 = String.valueOf(getPackageName());
              new StringBuilder(String.valueOf(localObject2).length() + 44 + String.valueOf(str).length()).append((String)localObject2).append(" ").append(str).append(": Task already running, won't start another");
              return 2;
            }
            ??? = new GcmTaskService.zza(this, str, ((PendingCallback)localObject2).getIBinder(), localBundle, localArrayList);
            this.zzqp.execute(???);
            return 2;
          }
        }
        if (!"com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(localObject1)) {
          break label306;
        }
      }
      finally
      {
        zzjB(paramInt2);
      }
      onInitializeTasks();
      continue;
      label306:
      new StringBuilder(String.valueOf(localObject1).length() + 37).append("Unknown action received ").append(localObject1).append(", terminating");
    }
  }
  
  protected ExecutorService zzGQ()
  {
    return Executors.newFixedThreadPool(2, new GcmTaskService.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmTaskService
 * JD-Core Version:    0.7.0.1
 */