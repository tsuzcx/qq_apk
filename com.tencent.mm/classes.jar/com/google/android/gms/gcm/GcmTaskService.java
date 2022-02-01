package com.google.android.gms.gcm;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
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
  
  private final void zzd(zze paramzze)
  {
    try
    {
      this.zzu.execute(paramzze);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      zze.zzd(paramzze, 1);
    }
  }
  
  private final boolean zzg(String paramString)
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
    this.zzv = new Messenger(new zzd(Looper.getMainLooper()));
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
          zzd(new zze(str, ((PendingCallback)localParcelable).zzal, localBundle, paramIntent));
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
  
  @TargetApi(21)
  @VisibleForTesting
  final class zzd
    extends Handler
  {
    zzd(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(3631);
      if (!UidVerifier.uidHasPackageName(GcmTaskService.this, paramMessage.sendingUid, "com.google.android.gms"))
      {
        AppMethodBeat.o(3631);
        return;
      }
      switch (paramMessage.what)
      {
      case 3: 
      default: 
        paramMessage = String.valueOf(paramMessage);
        new StringBuilder(String.valueOf(paramMessage).length() + 31).append("Unrecognized message received: ").append(paramMessage);
        AppMethodBeat.o(3631);
        return;
      case 1: 
        Bundle localBundle = paramMessage.getData();
        if (!localBundle.isEmpty())
        {
          paramMessage = paramMessage.replyTo;
          if (paramMessage != null)
          {
            String str = localBundle.getString("tag");
            ArrayList localArrayList = localBundle.getParcelableArrayList("triggered_uris");
            if (!GcmTaskService.zzd(GcmTaskService.this, str))
            {
              localBundle = localBundle.getBundle("extras");
              paramMessage = new GcmTaskService.zze(GcmTaskService.this, str, paramMessage, localBundle, localArrayList);
              GcmTaskService.zzd(GcmTaskService.this, paramMessage);
            }
          }
        }
        AppMethodBeat.o(3631);
        return;
      case 2: 
        if (Log.isLoggable("GcmTaskService", 3))
        {
          paramMessage = String.valueOf(paramMessage);
          new StringBuilder(String.valueOf(paramMessage).length() + 45).append("ignoring unimplemented stop message for now: ").append(paramMessage);
        }
        AppMethodBeat.o(3631);
        return;
      }
      GcmTaskService.this.onInitializeTasks();
      AppMethodBeat.o(3631);
    }
  }
  
  final class zze
    implements Runnable
  {
    private final Bundle extras;
    private final String tag;
    private final zzg zzaa;
    private final Messenger zzab;
    private final List<Uri> zzz;
    
    zze(IBinder paramIBinder, Bundle paramBundle, List<Uri> paramList)
    {
      AppMethodBeat.i(3632);
      this.tag = paramIBinder;
      if (paramBundle == null) {
        this$1 = null;
      }
      for (;;)
      {
        this.zzaa = GcmTaskService.this;
        this.extras = paramList;
        Object localObject;
        this.zzz = localObject;
        this.zzab = null;
        AppMethodBeat.o(3632);
        return;
        this$1 = paramBundle.queryLocalInterface("com.google.android.gms.gcm.INetworkTaskCallback");
        if ((GcmTaskService.this instanceof zzg)) {
          this$1 = (zzg)GcmTaskService.this;
        } else {
          this$1 = new zzh(paramBundle);
        }
      }
    }
    
    zze(Messenger paramMessenger, Bundle paramBundle, List<Uri> paramList)
    {
      this.tag = paramMessenger;
      this.zzab = paramBundle;
      this.extras = paramList;
      Object localObject;
      this.zzz = localObject;
      this.zzaa = null;
    }
    
    private final void zze(int paramInt)
    {
      AppMethodBeat.i(3634);
      localObject1 = GcmTaskService.zzd(GcmTaskService.this);
      for (;;)
      {
        try
        {
          boolean bool = GcmTaskService.zzf(GcmTaskService.this).zzf(this.tag, GcmTaskService.zze(GcmTaskService.this).getClassName());
          if (!bool) {}
        }
        catch (RemoteException localRemoteException)
        {
          Messenger localMessenger;
          Message localMessage;
          Bundle localBundle;
          String str = String.valueOf(this.tag);
          if (str.length() == 0) {
            continue;
          }
          "Error reporting result of operation to scheduler for ".concat(str);
          GcmTaskService.zzf(GcmTaskService.this).zze(this.tag, GcmTaskService.zze(GcmTaskService.this).getClassName());
          if ((zzf()) || (GcmTaskService.zzf(GcmTaskService.this).zzf(GcmTaskService.zze(GcmTaskService.this).getClassName()))) {
            continue;
          }
          GcmTaskService.this.stopSelf(GcmTaskService.zzg(GcmTaskService.this));
          continue;
          new String("Error reporting result of operation to scheduler for ");
          continue;
        }
        finally
        {
          GcmTaskService.zzf(GcmTaskService.this).zze(this.tag, GcmTaskService.zze(GcmTaskService.this).getClassName());
          if ((zzf()) || (GcmTaskService.zzf(GcmTaskService.this).zzf(GcmTaskService.zze(GcmTaskService.this).getClassName()))) {
            continue;
          }
          GcmTaskService.this.stopSelf(GcmTaskService.zzg(GcmTaskService.this));
          AppMethodBeat.o(3634);
        }
        try
        {
          GcmTaskService.zzf(GcmTaskService.this).zze(this.tag, GcmTaskService.zze(GcmTaskService.this).getClassName());
          if ((!zzf()) && (!GcmTaskService.zzf(GcmTaskService.this).zzf(GcmTaskService.zze(GcmTaskService.this).getClassName()))) {
            GcmTaskService.this.stopSelf(GcmTaskService.zzg(GcmTaskService.this));
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(3634);
        }
      }
      if (zzf())
      {
        localMessenger = this.zzab;
        localMessage = Message.obtain();
        localMessage.what = 3;
        localMessage.arg1 = paramInt;
        localBundle = new Bundle();
        localBundle.putParcelable("component", GcmTaskService.zze(GcmTaskService.this));
        localBundle.putString("tag", this.tag);
        localMessage.setData(localBundle);
        localMessenger.send(localMessage);
      }
      for (;;)
      {
        GcmTaskService.zzf(GcmTaskService.this).zze(this.tag, GcmTaskService.zze(GcmTaskService.this).getClassName());
        if ((!zzf()) && (!GcmTaskService.zzf(GcmTaskService.this).zzf(GcmTaskService.zze(GcmTaskService.this).getClassName()))) {
          GcmTaskService.this.stopSelf(GcmTaskService.zzg(GcmTaskService.this));
        }
        AppMethodBeat.o(3634);
        return;
        this.zzaa.zzf(paramInt);
      }
    }
    
    private final boolean zzf()
    {
      return this.zzab != null;
    }
    
    public final void run()
    {
      AppMethodBeat.i(3633);
      TaskParams localTaskParams = new TaskParams(this.tag, this.extras, this.zzz);
      zze(GcmTaskService.this.onRunTask(localTaskParams));
      AppMethodBeat.o(3633);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmTaskService
 * JD-Core Version:    0.7.0.1
 */