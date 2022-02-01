package android.support.v4.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class v
{
  private static final Object It = new Object();
  private static String Iu;
  private static Set<String> Iv = new HashSet();
  private static d Ix;
  private static final Object sLock = new Object();
  public final NotificationManager Iw;
  public final Context mContext;
  
  private v(Context paramContext)
  {
    this.mContext = paramContext;
    this.Iw = ((NotificationManager)this.mContext.getSystemService("notification"));
  }
  
  public static v P(Context paramContext)
  {
    return new v(paramContext);
  }
  
  public static Set<String> Q(Context paramContext)
  {
    Object localObject1 = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_notification_listeners");
    paramContext = It;
    if (localObject1 != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (!((String)localObject1).equals(Iu))
        {
          String[] arrayOfString = ((String)localObject1).split(":", -1);
          HashSet localHashSet = new HashSet(arrayOfString.length);
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            ComponentName localComponentName = ComponentName.unflattenFromString(arrayOfString[i]);
            if (localComponentName != null) {
              localHashSet.add(localComponentName.getPackageName());
            }
          }
          else
          {
            Iv = localHashSet;
            Iu = (String)localObject1;
          }
        }
        else
        {
          localObject1 = Iv;
          return localObject1;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public final void a(e parame)
  {
    synchronized (sLock)
    {
      if (Ix == null) {
        Ix = new d(this.mContext.getApplicationContext());
      }
      Ix.b(parame);
      return;
    }
  }
  
  public final boolean areNotificationsEnabled()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.Iw.areNotificationsEnabled();
    }
    AppOpsManager localAppOpsManager;
    Object localObject;
    String str;
    int i;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAppOpsManager = (AppOpsManager)this.mContext.getSystemService("appops");
      localObject = this.mContext.getApplicationInfo();
      str = this.mContext.getApplicationContext().getPackageName();
      i = ((ApplicationInfo)localObject).uid;
    }
    try
    {
      localObject = Class.forName(AppOpsManager.class.getName());
      i = ((Integer)((Class)localObject).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(((Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), str })).intValue();
      return i == 0;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return true;
      return true;
    }
    catch (RuntimeException localRuntimeException)
    {
      break label160;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label160;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label160;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label160;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label160:
      break label160;
    }
  }
  
  public final void cancel(int paramInt)
  {
    this.Iw.cancel(null, paramInt);
    if (Build.VERSION.SDK_INT <= 19) {
      a(new a(this.mContext.getPackageName(), paramInt));
    }
  }
  
  public final int getImportance()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.Iw.getImportance();
    }
    return -1000;
  }
  
  static final class a
    implements v.e
  {
    final boolean Iy;
    final int id;
    final String packageName;
    final String tag;
    
    a(String paramString, int paramInt)
    {
      this.packageName = paramString;
      this.id = paramInt;
      this.tag = null;
      this.Iy = false;
    }
    
    public final void a(o paramo)
    {
      if (this.Iy)
      {
        paramo.t(this.packageName);
        return;
      }
      paramo.c(this.packageName, this.id, this.tag);
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("CancelTask[");
      localStringBuilder.append("packageName:").append(this.packageName);
      localStringBuilder.append(", id:").append(this.id);
      localStringBuilder.append(", tag:").append(this.tag);
      localStringBuilder.append(", all:").append(this.Iy);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static final class b
    implements v.e
  {
    final Notification Iz;
    final int id;
    final String packageName;
    final String tag;
    
    public b(String paramString, int paramInt, Notification paramNotification)
    {
      this.packageName = paramString;
      this.id = paramInt;
      this.tag = null;
      this.Iz = paramNotification;
    }
    
    public final void a(o paramo)
    {
      paramo.a(this.packageName, this.id, this.tag, this.Iz);
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("NotifyTask[");
      localStringBuilder.append("packageName:").append(this.packageName);
      localStringBuilder.append(", id:").append(this.id);
      localStringBuilder.append(", tag:").append(this.tag);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  static final class c
  {
    final IBinder IA;
    final ComponentName componentName;
    
    c(ComponentName paramComponentName, IBinder paramIBinder)
    {
      this.componentName = paramComponentName;
      this.IA = paramIBinder;
    }
  }
  
  static final class d
    implements ServiceConnection, Handler.Callback
  {
    private final Map<ComponentName, a> IB = new HashMap();
    private Set<String> IC = new HashSet();
    private final Context mContext;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    
    d(Context paramContext)
    {
      this.mContext = paramContext;
      this.mHandlerThread = new HandlerThread("NotificationManagerCompat");
      this.mHandlerThread.start();
      this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
    }
    
    private void a(a parama)
    {
      if (parama.IE)
      {
        this.mContext.unbindService(this);
        parama.IE = false;
      }
      parama.IF = null;
    }
    
    private void b(a parama)
    {
      if (this.mHandler.hasMessages(3, parama.componentName)) {
        return;
      }
      parama.retryCount += 1;
      if (parama.retryCount > 6)
      {
        new StringBuilder("Giving up on delivering ").append(parama.IG.size()).append(" tasks to ").append(parama.componentName).append(" after ").append(parama.retryCount).append(" retries");
        parama.IG.clear();
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
        new StringBuilder("Processing component ").append(parama.componentName).append(", ").append(parama.IG.size()).append(" queued tasks");
      }
      if (parama.IG.isEmpty()) {}
      for (;;)
      {
        return;
        boolean bool;
        if (parama.IE)
        {
          bool = true;
          if ((!bool) || (parama.IF == null)) {
            b(parama);
          }
        }
        else
        {
          localObject = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(parama.componentName);
          parama.IE = this.mContext.bindService((Intent)localObject, this, 33);
          if (parama.IE) {
            parama.retryCount = 0;
          }
          for (;;)
          {
            bool = parama.IE;
            break;
            new StringBuilder("Unable to bind to listener ").append(parama.componentName);
            this.mContext.unbindService(this);
          }
        }
        Object localObject = (v.e)parama.IG.peek();
        if (localObject != null) {}
        try
        {
          if (Log.isLoggable("NotifManCompat", 3)) {
            new StringBuilder("Sending task ").append(localObject);
          }
          ((v.e)localObject).a(parama.IF);
          parama.IG.remove();
        }
        catch (DeadObjectException localDeadObjectException)
        {
          if (Log.isLoggable("NotifManCompat", 3)) {
            new StringBuilder("Remote service has died: ").append(parama.componentName);
          }
          if (parama.IG.isEmpty()) {
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
        Object localObject2 = v.Q(this.mContext);
        if (!((Set)localObject2).equals(this.IC))
        {
          this.IC = ((Set)localObject2);
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
            if (!this.IB.containsKey(localObject3))
            {
              if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Adding listener record for ").append(localObject3);
              }
              this.IB.put(localObject3, new a((ComponentName)localObject3));
            }
          }
          localObject2 = this.IB.entrySet().iterator();
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
        localObject1 = this.IB.values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          ((a)localObject2).IG.add(paramMessage);
          c((a)localObject2);
        }
        return true;
      case 1: 
        localObject1 = (v.c)paramMessage.obj;
        paramMessage = ((v.c)localObject1).componentName;
        localObject1 = ((v.c)localObject1).IA;
        paramMessage = (a)this.IB.get(paramMessage);
        if (paramMessage != null)
        {
          paramMessage.IF = o.a.b((IBinder)localObject1);
          paramMessage.retryCount = 0;
          c(paramMessage);
        }
        return true;
      case 2: 
        paramMessage = (ComponentName)paramMessage.obj;
        paramMessage = (a)this.IB.get(paramMessage);
        if (paramMessage != null) {
          a(paramMessage);
        }
        return true;
      }
      paramMessage = (ComponentName)paramMessage.obj;
      paramMessage = (a)this.IB.get(paramMessage);
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
      boolean IE = false;
      o IF;
      ArrayDeque<v.e> IG = new ArrayDeque();
      final ComponentName componentName;
      int retryCount = 0;
      
      a(ComponentName paramComponentName)
      {
        this.componentName = paramComponentName;
      }
    }
  }
  
  static abstract interface e
  {
    public abstract void a(o paramo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.app.v
 * JD-Core Version:    0.7.0.1
 */