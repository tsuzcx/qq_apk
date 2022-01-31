package com.google.android.gms.gcm;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.concurrent.GuardedBy;

public abstract class GcmTaskService
  extends Service
{
  public static final String SERVICE_ACTION_EXECUTE_TASK = "com.google.android.gms.gcm.ACTION_TASK_READY";
  public static final String SERVICE_ACTION_INITIALIZE = "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE";
  public static final String SERVICE_PERMISSION = "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE";
  private ComponentName componentName;
  private final Object lock = new Object();
  @GuardedBy("lock")
  private int zzt;
  private ExecutorService zzu;
  private Messenger zzv;
  private GcmNetworkManager zzw;
  
  private final void zzd(int paramInt)
  {
    synchronized (this.lock)
    {
      this.zzt = paramInt;
      if (!this.zzw.zzf(this.componentName.getClassName())) {
        stopSelf(this.zzt);
      }
      return;
    }
  }
  
  private final void zzd(GcmTaskService.zze paramzze)
  {
    try
    {
      this.zzu.execute(paramzze);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      GcmTaskService.zze.zzd(paramzze, 1);
    }
  }
  
  private final boolean zzg(String paramString)
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        if (!this.zzw.zzd(paramString, this.componentName.getClassName()))
        {
          bool = true;
          if (bool)
          {
            String str = getPackageName();
            new StringBuilder(String.valueOf(str).length() + 44 + String.valueOf(paramString).length()).append(str).append(" ").append(paramString).append(": Task already running, won't start another");
          }
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if ((paramIntent == null) || (!PlatformVersion.isAtLeastLollipop()) || (!"com.google.android.gms.gcm.ACTION_TASK_READY".equals(paramIntent.getAction()))) {
      return null;
    }
    return this.zzv.getBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.zzw = GcmNetworkManager.getInstance(this);
    this.zzu = Executors.newFixedThreadPool(2, new zze(this));
    this.zzv = new Messenger(new GcmTaskService.zzd(this, Looper.getMainLooper()));
    this.componentName = new ComponentName(this, getClass());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    List localList = this.zzu.shutdownNow();
    if (!localList.isEmpty())
    {
      int i = localList.size();
      new StringBuilder(79).append("Shutting down, but not all tasks are finished executing. Remaining: ").append(i);
    }
  }
  
  public void onInitializeTasks() {}
  
  public abstract int onRunTask(TaskParams paramTaskParams);
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null)
    {
      zzd(paramInt2);
      return 2;
    }
    for (;;)
    {
      try
      {
        paramIntent.setExtrasClassLoader(PendingCallback.class.getClassLoader());
        String str = paramIntent.getAction();
        if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(str))
        {
          str = paramIntent.getStringExtra("tag");
          Parcelable localParcelable = paramIntent.getParcelableExtra("callback");
          Bundle localBundle = paramIntent.getBundleExtra("extras");
          paramIntent = paramIntent.getParcelableArrayListExtra("triggered_uris");
          if (!(localParcelable instanceof PendingCallback))
          {
            paramIntent = getPackageName();
            new StringBuilder(String.valueOf(paramIntent).length() + 47 + String.valueOf(str).length()).append(paramIntent).append(" ").append(str).append(": Could not process request, invalid callback.");
            return 2;
          }
          boolean bool = zzg(str);
          if (bool) {
            return 2;
          }
          zzd(new GcmTaskService.zze(this, str, ((PendingCallback)localParcelable).zzal, localBundle, paramIntent));
          return 2;
        }
        if ("com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(str)) {
          onInitializeTasks();
        } else {
          new StringBuilder(String.valueOf(str).length() + 37).append("Unknown action received ").append(str).append(", terminating");
        }
      }
      finally
      {
        zzd(paramInt2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmTaskService
 * JD-Core Version:    0.7.0.1
 */