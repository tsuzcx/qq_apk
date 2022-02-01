package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class v$d
  implements ServiceConnection, Handler.Callback
{
  private final Map<ComponentName, a> Ir = new HashMap();
  private Set<String> Is = new HashSet();
  private final Context mContext;
  private final Handler mHandler;
  private final HandlerThread mHandlerThread;
  
  v$d(Context paramContext)
  {
    this.mContext = paramContext;
    this.mHandlerThread = new HandlerThread("NotificationManagerCompat");
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
  }
  
  private void a(a parama)
  {
    if (parama.It)
    {
      this.mContext.unbindService(this);
      parama.It = false;
    }
    parama.Iu = null;
  }
  
  private void b(a parama)
  {
    if (this.mHandler.hasMessages(3, parama.componentName)) {
      return;
    }
    parama.retryCount += 1;
    if (parama.retryCount > 6)
    {
      new StringBuilder("Giving up on delivering ").append(parama.Iv.size()).append(" tasks to ").append(parama.componentName).append(" after ").append(parama.retryCount).append(" retries");
      parama.Iv.clear();
      return;
    }
    int i = (1 << parama.retryCount - 1) * 1000;
    if (Log.isLoggable("NotifManCompat", 3)) {
      new StringBuilder("Scheduling retry for ").append(i).append(" ms");
    }
    parama = this.mHandler.obtainMessage(3, parama.componentName);
    this.mHandler.sendMessageDelayed(parama, i);
  }
  
  private void c(a parama)
  {
    if (Log.isLoggable("NotifManCompat", 3)) {
      new StringBuilder("Processing component ").append(parama.componentName).append(", ").append(parama.Iv.size()).append(" queued tasks");
    }
    if (parama.Iv.isEmpty()) {}
    for (;;)
    {
      return;
      boolean bool;
      if (parama.It)
      {
        bool = true;
        if ((!bool) || (parama.Iu == null)) {
          b(parama);
        }
      }
      else
      {
        localObject = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(parama.componentName);
        parama.It = this.mContext.bindService((Intent)localObject, this, 33);
        if (parama.It) {
          parama.retryCount = 0;
        }
        for (;;)
        {
          bool = parama.It;
          break;
          new StringBuilder("Unable to bind to listener ").append(parama.componentName);
          this.mContext.unbindService(this);
        }
      }
      Object localObject = (v.e)parama.Iv.peek();
      if (localObject != null) {}
      try
      {
        if (Log.isLoggable("NotifManCompat", 3)) {
          new StringBuilder("Sending task ").append(localObject);
        }
        ((v.e)localObject).a(parama.Iu);
        parama.Iv.remove();
      }
      catch (DeadObjectException localDeadObjectException)
      {
        if (Log.isLoggable("NotifManCompat", 3)) {
          new StringBuilder("Remote service has died: ").append(parama.componentName);
        }
        if (parama.Iv.isEmpty()) {
          continue;
        }
        b(parama);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          new StringBuilder("RemoteException communicating with ").append(parama.componentName);
        }
      }
    }
  }
  
  public final void b(v.e parame)
  {
    this.mHandler.obtainMessage(0, parame).sendToTarget();
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      paramMessage = (v.e)paramMessage.obj;
      Object localObject2 = v.P(this.mContext);
      if (!((Set)localObject2).equals(this.Is))
      {
        this.Is = ((Set)localObject2);
        Object localObject3 = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
        localObject1 = new HashSet();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject3).next();
          if (((Set)localObject2).contains(localResolveInfo.serviceInfo.packageName))
          {
            ComponentName localComponentName = new ComponentName(localResolveInfo.serviceInfo.packageName, localResolveInfo.serviceInfo.name);
            if (localResolveInfo.serviceInfo.permission != null) {
              new StringBuilder("Permission present on component ").append(localComponentName).append(", not adding listener record.");
            } else {
              ((Set)localObject1).add(localComponentName);
            }
          }
        }
        localObject2 = ((Set)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ComponentName)((Iterator)localObject2).next();
          if (!this.Ir.containsKey(localObject3))
          {
            if (Log.isLoggable("NotifManCompat", 3)) {
              new StringBuilder("Adding listener record for ").append(localObject3);
            }
            this.Ir.put(localObject3, new a((ComponentName)localObject3));
          }
        }
        localObject2 = this.Ir.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          if (!((Set)localObject1).contains(((Map.Entry)localObject3).getKey()))
          {
            if (Log.isLoggable("NotifManCompat", 3)) {
              new StringBuilder("Removing listener record for ").append(((Map.Entry)localObject3).getKey());
            }
            a((a)((Map.Entry)localObject3).getValue());
            ((Iterator)localObject2).remove();
          }
        }
      }
      localObject1 = this.Ir.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        ((a)localObject2).Iv.add(paramMessage);
        c((a)localObject2);
      }
      return true;
    case 1: 
      localObject1 = (v.c)paramMessage.obj;
      paramMessage = ((v.c)localObject1).componentName;
      localObject1 = ((v.c)localObject1).Iq;
      paramMessage = (a)this.Ir.get(paramMessage);
      if (paramMessage != null)
      {
        paramMessage.Iu = o.a.b((IBinder)localObject1);
        paramMessage.retryCount = 0;
        c(paramMessage);
      }
      return true;
    case 2: 
      paramMessage = (ComponentName)paramMessage.obj;
      paramMessage = (a)this.Ir.get(paramMessage);
      if (paramMessage != null) {
        a(paramMessage);
      }
      return true;
    }
    paramMessage = (ComponentName)paramMessage.obj;
    paramMessage = (a)this.Ir.get(paramMessage);
    if (paramMessage != null) {
      c(paramMessage);
    }
    return true;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (Log.isLoggable("NotifManCompat", 3)) {
      new StringBuilder("Connected to service ").append(paramComponentName);
    }
    this.mHandler.obtainMessage(1, new v.c(paramComponentName, paramIBinder)).sendToTarget();
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (Log.isLoggable("NotifManCompat", 3)) {
      new StringBuilder("Disconnected from service ").append(paramComponentName);
    }
    this.mHandler.obtainMessage(2, paramComponentName).sendToTarget();
  }
  
  static final class a
  {
    boolean It = false;
    o Iu;
    ArrayDeque<v.e> Iv = new ArrayDeque();
    final ComponentName componentName;
    int retryCount = 0;
    
    a(ComponentName paramComponentName)
    {
      this.componentName = paramComponentName;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.app.v.d
 * JD-Core Version:    0.7.0.1
 */