package androidx.core.app;

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
import android.support.v4.app.a;
import android.support.v4.app.a.a;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class i$d
  implements ServiceConnection, Handler.Callback
{
  private final Map<ComponentName, a> bpD;
  private Set<String> bpE;
  private final Context mContext;
  private final Handler mHandler;
  private final HandlerThread mHandlerThread;
  
  i$d(Context paramContext)
  {
    AppMethodBeat.i(196322);
    this.bpD = new HashMap();
    this.bpE = new HashSet();
    this.mContext = paramContext;
    this.mHandlerThread = new HandlerThread("NotificationManagerCompat");
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
    AppMethodBeat.o(196322);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(196332);
    if (parama.bpF)
    {
      this.mContext.unbindService(this);
      parama.bpF = false;
    }
    parama.bpG = null;
    AppMethodBeat.o(196332);
  }
  
  private void b(a parama)
  {
    AppMethodBeat.i(196341);
    if (this.mHandler.hasMessages(3, parama.componentName))
    {
      AppMethodBeat.o(196341);
      return;
    }
    parama.retryCount += 1;
    if (parama.retryCount > 6)
    {
      new StringBuilder("Giving up on delivering ").append(parama.bpH.size()).append(" tasks to ").append(parama.componentName).append(" after ").append(parama.retryCount).append(" retries");
      parama.bpH.clear();
      AppMethodBeat.o(196341);
      return;
    }
    int i = (1 << parama.retryCount - 1) * 1000;
    if (Log.isLoggable("NotifManCompat", 3)) {
      new StringBuilder("Scheduling retry for ").append(i).append(" ms");
    }
    parama = this.mHandler.obtainMessage(3, parama.componentName);
    this.mHandler.sendMessageDelayed(parama, i);
    AppMethodBeat.o(196341);
  }
  
  private void c(a parama)
  {
    AppMethodBeat.i(196354);
    if (Log.isLoggable("NotifManCompat", 3)) {
      new StringBuilder("Processing component ").append(parama.componentName).append(", ").append(parama.bpH.size()).append(" queued tasks");
    }
    if (parama.bpH.isEmpty())
    {
      AppMethodBeat.o(196354);
      return;
    }
    boolean bool;
    Object localObject;
    if (parama.bpF)
    {
      bool = true;
      if ((!bool) || (parama.bpG == null))
      {
        b(parama);
        AppMethodBeat.o(196354);
      }
    }
    else
    {
      localObject = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(parama.componentName);
      parama.bpF = this.mContext.bindService((Intent)localObject, this, 33);
      if (parama.bpF) {
        parama.retryCount = 0;
      }
      for (;;)
      {
        bool = parama.bpF;
        break;
        new StringBuilder("Unable to bind to listener ").append(parama.componentName);
        this.mContext.unbindService(this);
      }
    }
    for (;;)
    {
      localObject = (i.e)parama.bpH.peek();
      if (localObject != null) {}
      try
      {
        if (Log.isLoggable("NotifManCompat", 3)) {
          new StringBuilder("Sending task ").append(localObject);
        }
        ((i.e)localObject).a(parama.bpG);
        parama.bpH.remove();
      }
      catch (DeadObjectException localDeadObjectException)
      {
        if (Log.isLoggable("NotifManCompat", 3)) {
          new StringBuilder("Remote service has died: ").append(parama.componentName);
        }
        if (!parama.bpH.isEmpty()) {
          b(parama);
        }
        AppMethodBeat.o(196354);
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
  
  public final void b(i.e parame)
  {
    AppMethodBeat.i(196363);
    this.mHandler.obtainMessage(0, parame).sendToTarget();
    AppMethodBeat.o(196363);
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(196385);
    Object localObject1;
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(196385);
      return false;
    case 0: 
      paramMessage = (i.e)paramMessage.obj;
      Object localObject2 = i.Y(this.mContext);
      if (!((Set)localObject2).equals(this.bpE))
      {
        this.bpE = ((Set)localObject2);
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
          if (!this.bpD.containsKey(localObject3))
          {
            if (Log.isLoggable("NotifManCompat", 3)) {
              new StringBuilder("Adding listener record for ").append(localObject3);
            }
            this.bpD.put(localObject3, new a((ComponentName)localObject3));
          }
        }
        localObject2 = this.bpD.entrySet().iterator();
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
      localObject1 = this.bpD.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        ((a)localObject2).bpH.add(paramMessage);
        c((a)localObject2);
      }
      AppMethodBeat.o(196385);
      return true;
    case 1: 
      localObject1 = (i.c)paramMessage.obj;
      paramMessage = ((i.c)localObject1).componentName;
      localObject1 = ((i.c)localObject1).bpC;
      paramMessage = (a)this.bpD.get(paramMessage);
      if (paramMessage != null)
      {
        paramMessage.bpG = a.a.b((IBinder)localObject1);
        paramMessage.retryCount = 0;
        c(paramMessage);
      }
      AppMethodBeat.o(196385);
      return true;
    case 2: 
      paramMessage = (ComponentName)paramMessage.obj;
      paramMessage = (a)this.bpD.get(paramMessage);
      if (paramMessage != null) {
        a(paramMessage);
      }
      AppMethodBeat.o(196385);
      return true;
    }
    paramMessage = (ComponentName)paramMessage.obj;
    paramMessage = (a)this.bpD.get(paramMessage);
    if (paramMessage != null) {
      c(paramMessage);
    }
    AppMethodBeat.o(196385);
    return true;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(196394);
    if (Log.isLoggable("NotifManCompat", 3)) {
      new StringBuilder("Connected to service ").append(paramComponentName);
    }
    this.mHandler.obtainMessage(1, new i.c(paramComponentName, paramIBinder)).sendToTarget();
    AppMethodBeat.o(196394);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(196406);
    if (Log.isLoggable("NotifManCompat", 3)) {
      new StringBuilder("Disconnected from service ").append(paramComponentName);
    }
    this.mHandler.obtainMessage(2, paramComponentName).sendToTarget();
    AppMethodBeat.o(196406);
  }
  
  static final class a
  {
    boolean bpF;
    a bpG;
    ArrayDeque<i.e> bpH;
    final ComponentName componentName;
    int retryCount;
    
    a(ComponentName paramComponentName)
    {
      AppMethodBeat.i(196429);
      this.bpF = false;
      this.bpH = new ArrayDeque();
      this.retryCount = 0;
      this.componentName = paramComponentName;
      AppMethodBeat.o(196429);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.app.i.d
 * JD-Core Version:    0.7.0.1
 */