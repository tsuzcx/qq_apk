package androidx.core.app;

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
import android.support.v4.app.a;
import android.support.v4.app.a.a;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
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

public final class h
{
  private static final Object Js;
  private static String Jt;
  private static Set<String> Ju;
  private static d Jw;
  private static final Object sLock;
  public final NotificationManager Jv;
  public final Context mContext;
  
  static
  {
    AppMethodBeat.i(250452);
    Js = new Object();
    Ju = new HashSet();
    sLock = new Object();
    AppMethodBeat.o(250452);
  }
  
  private h(Context paramContext)
  {
    AppMethodBeat.i(250443);
    this.mContext = paramContext;
    this.Jv = ((NotificationManager)this.mContext.getSystemService("notification"));
    AppMethodBeat.o(250443);
  }
  
  public static h M(Context paramContext)
  {
    AppMethodBeat.i(250442);
    paramContext = new h(paramContext);
    AppMethodBeat.o(250442);
    return paramContext;
  }
  
  public static Set<String> N(Context paramContext)
  {
    AppMethodBeat.i(250450);
    Object localObject1 = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_notification_listeners");
    paramContext = Js;
    if (localObject1 != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (!((String)localObject1).equals(Jt))
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
            Ju = localHashSet;
            Jt = (String)localObject1;
          }
        }
        else
        {
          localObject1 = Ju;
          return localObject1;
        }
      }
      finally
      {
        AppMethodBeat.o(250450);
      }
      i += 1;
    }
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(250451);
    synchronized (sLock)
    {
      if (Jw == null) {
        Jw = new d(this.mContext.getApplicationContext());
      }
      Jw.b(parame);
      AppMethodBeat.o(250451);
      return;
    }
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(250444);
    this.Jv.cancel(null, paramInt);
    if (Build.VERSION.SDK_INT <= 19) {
      a(new a(this.mContext.getPackageName(), paramInt));
    }
    AppMethodBeat.o(250444);
  }
  
  public final boolean gs()
  {
    AppMethodBeat.i(250446);
    if (Build.VERSION.SDK_INT >= 24)
    {
      boolean bool = this.Jv.areNotificationsEnabled();
      AppMethodBeat.o(250446);
      return bool;
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
      if (((Integer)((Class)localObject).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(((Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), str })).intValue() == 0)
      {
        AppMethodBeat.o(250446);
        return true;
      }
      AppMethodBeat.o(250446);
      return false;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      AppMethodBeat.o(250446);
      return true;
      AppMethodBeat.o(250446);
      return true;
    }
    catch (RuntimeException localRuntimeException)
    {
      break label182;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label182;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label182;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label182;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label182:
      break label182;
    }
  }
  
  public final int gt()
  {
    AppMethodBeat.i(250448);
    if (Build.VERSION.SDK_INT >= 24)
    {
      int i = this.Jv.getImportance();
      AppMethodBeat.o(250448);
      return i;
    }
    AppMethodBeat.o(250448);
    return -1000;
  }
  
  static final class a
    implements h.e
  {
    final boolean Jx;
    final int id;
    final String packageName;
    final String tag;
    
    a(String paramString, int paramInt)
    {
      this.packageName = paramString;
      this.id = paramInt;
      this.tag = null;
      this.Jx = false;
    }
    
    public final void a(a parama)
    {
      AppMethodBeat.i(250390);
      if (this.Jx)
      {
        parama.n(this.packageName);
        AppMethodBeat.o(250390);
        return;
      }
      parama.c(this.packageName, this.id, this.tag);
      AppMethodBeat.o(250390);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(250391);
      Object localObject = new StringBuilder("CancelTask[");
      ((StringBuilder)localObject).append("packageName:").append(this.packageName);
      ((StringBuilder)localObject).append(", id:").append(this.id);
      ((StringBuilder)localObject).append(", tag:").append(this.tag);
      ((StringBuilder)localObject).append(", all:").append(this.Jx);
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(250391);
      return localObject;
    }
  }
  
  public static final class b
    implements h.e
  {
    final Notification Jy;
    final int id;
    final String packageName;
    final String tag;
    
    public b(String paramString, int paramInt, Notification paramNotification)
    {
      this.packageName = paramString;
      this.id = paramInt;
      this.tag = null;
      this.Jy = paramNotification;
    }
    
    public final void a(a parama)
    {
      AppMethodBeat.i(250398);
      parama.a(this.packageName, this.id, this.tag, this.Jy);
      AppMethodBeat.o(250398);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(250400);
      Object localObject = new StringBuilder("NotifyTask[");
      ((StringBuilder)localObject).append("packageName:").append(this.packageName);
      ((StringBuilder)localObject).append(", id:").append(this.id);
      ((StringBuilder)localObject).append(", tag:").append(this.tag);
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(250400);
      return localObject;
    }
  }
  
  static final class c
  {
    final IBinder Jz;
    final ComponentName componentName;
    
    c(ComponentName paramComponentName, IBinder paramIBinder)
    {
      this.componentName = paramComponentName;
      this.Jz = paramIBinder;
    }
  }
  
  static final class d
    implements ServiceConnection, Handler.Callback
  {
    private final Map<ComponentName, a> JA;
    private Set<String> JB;
    private final Context mContext;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    
    d(Context paramContext)
    {
      AppMethodBeat.i(250432);
      this.JA = new HashMap();
      this.JB = new HashSet();
      this.mContext = paramContext;
      this.mHandlerThread = new HandlerThread("NotificationManagerCompat");
      this.mHandlerThread.start();
      this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
      AppMethodBeat.o(250432);
    }
    
    private void a(a parama)
    {
      AppMethodBeat.i(250437);
      if (parama.JC)
      {
        this.mContext.unbindService(this);
        parama.JC = false;
      }
      parama.JD = null;
      AppMethodBeat.o(250437);
    }
    
    private void b(a parama)
    {
      AppMethodBeat.i(250439);
      if (this.mHandler.hasMessages(3, parama.componentName))
      {
        AppMethodBeat.o(250439);
        return;
      }
      parama.retryCount += 1;
      if (parama.retryCount > 6)
      {
        new StringBuilder("Giving up on delivering ").append(parama.JE.size()).append(" tasks to ").append(parama.componentName).append(" after ").append(parama.retryCount).append(" retries");
        parama.JE.clear();
        AppMethodBeat.o(250439);
        return;
      }
      int i = (1 << parama.retryCount - 1) * 1000;
      if (Log.isLoggable("NotifManCompat", 3)) {
        new StringBuilder("Scheduling retry for ").append(i).append(" ms");
      }
      parama = this.mHandler.obtainMessage(3, parama.componentName);
      this.mHandler.sendMessageDelayed(parama, i);
      AppMethodBeat.o(250439);
    }
    
    private void c(a parama)
    {
      AppMethodBeat.i(250440);
      if (Log.isLoggable("NotifManCompat", 3)) {
        new StringBuilder("Processing component ").append(parama.componentName).append(", ").append(parama.JE.size()).append(" queued tasks");
      }
      if (parama.JE.isEmpty())
      {
        AppMethodBeat.o(250440);
        return;
      }
      boolean bool;
      Object localObject;
      if (parama.JC)
      {
        bool = true;
        if ((!bool) || (parama.JD == null))
        {
          b(parama);
          AppMethodBeat.o(250440);
        }
      }
      else
      {
        localObject = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(parama.componentName);
        parama.JC = this.mContext.bindService((Intent)localObject, this, 33);
        if (parama.JC) {
          parama.retryCount = 0;
        }
        for (;;)
        {
          bool = parama.JC;
          break;
          new StringBuilder("Unable to bind to listener ").append(parama.componentName);
          this.mContext.unbindService(this);
        }
      }
      for (;;)
      {
        localObject = (h.e)parama.JE.peek();
        if (localObject != null) {}
        try
        {
          if (Log.isLoggable("NotifManCompat", 3)) {
            new StringBuilder("Sending task ").append(localObject);
          }
          ((h.e)localObject).a(parama.JD);
          parama.JE.remove();
        }
        catch (DeadObjectException localDeadObjectException)
        {
          if (Log.isLoggable("NotifManCompat", 3)) {
            new StringBuilder("Remote service has died: ").append(parama.componentName);
          }
          if (!parama.JE.isEmpty()) {
            b(parama);
          }
          AppMethodBeat.o(250440);
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
    
    public final void b(h.e parame)
    {
      AppMethodBeat.i(250433);
      this.mHandler.obtainMessage(0, parame).sendToTarget();
      AppMethodBeat.o(250433);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(250434);
      Object localObject1;
      switch (paramMessage.what)
      {
      default: 
        AppMethodBeat.o(250434);
        return false;
      case 0: 
        paramMessage = (h.e)paramMessage.obj;
        Object localObject2 = h.N(this.mContext);
        if (!((Set)localObject2).equals(this.JB))
        {
          this.JB = ((Set)localObject2);
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
            if (!this.JA.containsKey(localObject3))
            {
              if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Adding listener record for ").append(localObject3);
              }
              this.JA.put(localObject3, new a((ComponentName)localObject3));
            }
          }
          localObject2 = this.JA.entrySet().iterator();
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
        localObject1 = this.JA.values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          ((a)localObject2).JE.add(paramMessage);
          c((a)localObject2);
        }
        AppMethodBeat.o(250434);
        return true;
      case 1: 
        localObject1 = (h.c)paramMessage.obj;
        paramMessage = ((h.c)localObject1).componentName;
        localObject1 = ((h.c)localObject1).Jz;
        paramMessage = (a)this.JA.get(paramMessage);
        if (paramMessage != null)
        {
          paramMessage.JD = a.a.b((IBinder)localObject1);
          paramMessage.retryCount = 0;
          c(paramMessage);
        }
        AppMethodBeat.o(250434);
        return true;
      case 2: 
        paramMessage = (ComponentName)paramMessage.obj;
        paramMessage = (a)this.JA.get(paramMessage);
        if (paramMessage != null) {
          a(paramMessage);
        }
        AppMethodBeat.o(250434);
        return true;
      }
      paramMessage = (ComponentName)paramMessage.obj;
      paramMessage = (a)this.JA.get(paramMessage);
      if (paramMessage != null) {
        c(paramMessage);
      }
      AppMethodBeat.o(250434);
      return true;
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(250435);
      if (Log.isLoggable("NotifManCompat", 3)) {
        new StringBuilder("Connected to service ").append(paramComponentName);
      }
      this.mHandler.obtainMessage(1, new h.c(paramComponentName, paramIBinder)).sendToTarget();
      AppMethodBeat.o(250435);
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      AppMethodBeat.i(250436);
      if (Log.isLoggable("NotifManCompat", 3)) {
        new StringBuilder("Disconnected from service ").append(paramComponentName);
      }
      this.mHandler.obtainMessage(2, paramComponentName).sendToTarget();
      AppMethodBeat.o(250436);
    }
    
    static final class a
    {
      boolean JC;
      a JD;
      ArrayDeque<h.e> JE;
      final ComponentName componentName;
      int retryCount;
      
      a(ComponentName paramComponentName)
      {
        AppMethodBeat.i(250411);
        this.JC = false;
        this.JE = new ArrayDeque();
        this.retryCount = 0;
        this.componentName = paramComponentName;
        AppMethodBeat.o(250411);
      }
    }
  }
  
  static abstract interface e
  {
    public abstract void a(a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.app.h
 * JD-Core Version:    0.7.0.1
 */