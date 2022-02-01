package android.support.v4.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public final class v
{
  private static final Object Ij = new Object();
  private static String Ik;
  private static Set<String> Il = new HashSet();
  private static v.d In;
  private static final Object sLock = new Object();
  public final NotificationManager Im;
  public final Context mContext;
  
  private v(Context paramContext)
  {
    this.mContext = paramContext;
    this.Im = ((NotificationManager)this.mContext.getSystemService("notification"));
  }
  
  public static v O(Context paramContext)
  {
    return new v(paramContext);
  }
  
  public static Set<String> P(Context paramContext)
  {
    Object localObject1 = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_notification_listeners");
    paramContext = Ij;
    if (localObject1 != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (!((String)localObject1).equals(Ik))
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
            Il = localHashSet;
            Ik = (String)localObject1;
          }
        }
        else
        {
          localObject1 = Il;
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
      if (In == null) {
        In = new v.d(this.mContext.getApplicationContext());
      }
      In.b(parame);
      return;
    }
  }
  
  public final boolean areNotificationsEnabled()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.Im.areNotificationsEnabled();
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
    this.Im.cancel(null, paramInt);
    if (Build.VERSION.SDK_INT <= 19) {
      a(new a(this.mContext.getPackageName(), paramInt));
    }
  }
  
  public final int getImportance()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.Im.getImportance();
    }
    return -1000;
  }
  
  static final class a
    implements v.e
  {
    final boolean Io;
    final int id;
    final String packageName;
    final String tag;
    
    a(String paramString, int paramInt)
    {
      this.packageName = paramString;
      this.id = paramInt;
      this.tag = null;
      this.Io = false;
    }
    
    public final void a(o paramo)
    {
      if (this.Io)
      {
        paramo.s(this.packageName);
        return;
      }
      paramo.b(this.packageName, this.id, this.tag);
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("CancelTask[");
      localStringBuilder.append("packageName:").append(this.packageName);
      localStringBuilder.append(", id:").append(this.id);
      localStringBuilder.append(", tag:").append(this.tag);
      localStringBuilder.append(", all:").append(this.Io);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static final class b
    implements v.e
  {
    final Notification Ip;
    final int id;
    final String packageName;
    final String tag;
    
    public b(String paramString, int paramInt, Notification paramNotification)
    {
      this.packageName = paramString;
      this.id = paramInt;
      this.tag = null;
      this.Ip = paramNotification;
    }
    
    public final void a(o paramo)
    {
      paramo.a(this.packageName, this.id, this.tag, this.Ip);
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
  
  static abstract interface e
  {
    public abstract void a(o paramo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.app.v
 * JD-Core Version:    0.7.0.1
 */