package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public final class i
{
  private static final Object bpv;
  private static String bpw;
  private static Set<String> bpx;
  private static i.d bpz;
  private static final Object sLock;
  public final NotificationManager bpy;
  public final Context mContext;
  
  static
  {
    AppMethodBeat.i(196389);
    bpv = new Object();
    bpx = new HashSet();
    sLock = new Object();
    AppMethodBeat.o(196389);
  }
  
  private i(Context paramContext)
  {
    AppMethodBeat.i(196366);
    this.mContext = paramContext;
    this.bpy = ((NotificationManager)this.mContext.getSystemService("notification"));
    AppMethodBeat.o(196366);
  }
  
  public static i X(Context paramContext)
  {
    AppMethodBeat.i(196356);
    paramContext = new i(paramContext);
    AppMethodBeat.o(196356);
    return paramContext;
  }
  
  public static Set<String> Y(Context paramContext)
  {
    AppMethodBeat.i(196378);
    paramContext = paramContext.getContentResolver();
    paramContext = new com.tencent.mm.hellhoundlib.b.a().cG("enabled_notification_listeners").cG(paramContext);
    Object localObject1 = (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), paramContext.aYi(), "androidx/core/app/NotificationManagerCompat", "getEnabledListenerPackages", "(Landroid/content/Context;)Ljava/util/Set;", "android/provider/Settings$Secure", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
    paramContext = bpv;
    if (localObject1 != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (!((String)localObject1).equals(bpw))
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
            bpx = localHashSet;
            bpw = (String)localObject1;
          }
        }
        else
        {
          localObject1 = bpx;
          return localObject1;
        }
      }
      finally
      {
        AppMethodBeat.o(196378);
      }
      i += 1;
    }
  }
  
  public final boolean DB()
  {
    AppMethodBeat.i(196416);
    if (Build.VERSION.SDK_INT >= 24)
    {
      boolean bool = this.bpy.areNotificationsEnabled();
      AppMethodBeat.o(196416);
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
        AppMethodBeat.o(196416);
        return true;
      }
      AppMethodBeat.o(196416);
      return false;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      AppMethodBeat.o(196416);
      return true;
      AppMethodBeat.o(196416);
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
  
  public final int DC()
  {
    AppMethodBeat.i(196420);
    if (Build.VERSION.SDK_INT >= 24)
    {
      int i = this.bpy.getImportance();
      AppMethodBeat.o(196420);
      return i;
    }
    AppMethodBeat.o(196420);
    return -1000;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(196426);
    synchronized (sLock)
    {
      if (bpz == null) {
        bpz = new i.d(this.mContext.getApplicationContext());
      }
      bpz.b(parame);
      AppMethodBeat.o(196426);
      return;
    }
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(196401);
    this.bpy.cancel(null, paramInt);
    if (Build.VERSION.SDK_INT <= 19) {
      a(new a(this.mContext.getPackageName(), paramInt));
    }
    AppMethodBeat.o(196401);
  }
  
  static final class a
    implements i.e
  {
    final boolean bpA;
    final int id;
    final String packageName;
    final String tag;
    
    a(String paramString, int paramInt)
    {
      this.packageName = paramString;
      this.id = paramInt;
      this.tag = null;
      this.bpA = false;
    }
    
    public final void a(android.support.v4.app.a parama)
    {
      AppMethodBeat.i(196311);
      if (this.bpA)
      {
        parama.n(this.packageName);
        AppMethodBeat.o(196311);
        return;
      }
      parama.c(this.packageName, this.id, this.tag);
      AppMethodBeat.o(196311);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(196319);
      Object localObject = new StringBuilder("CancelTask[");
      ((StringBuilder)localObject).append("packageName:").append(this.packageName);
      ((StringBuilder)localObject).append(", id:").append(this.id);
      ((StringBuilder)localObject).append(", tag:").append(this.tag);
      ((StringBuilder)localObject).append(", all:").append(this.bpA);
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(196319);
      return localObject;
    }
  }
  
  public static final class b
    implements i.e
  {
    final Notification bpB;
    final int id;
    final String packageName;
    final String tag;
    
    public b(String paramString, int paramInt, Notification paramNotification)
    {
      this.packageName = paramString;
      this.id = paramInt;
      this.tag = null;
      this.bpB = paramNotification;
    }
    
    public final void a(android.support.v4.app.a parama)
    {
      AppMethodBeat.i(196312);
      parama.a(this.packageName, this.id, this.tag, this.bpB);
      AppMethodBeat.o(196312);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(196320);
      Object localObject = new StringBuilder("NotifyTask[");
      ((StringBuilder)localObject).append("packageName:").append(this.packageName);
      ((StringBuilder)localObject).append(", id:").append(this.id);
      ((StringBuilder)localObject).append(", tag:").append(this.tag);
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(196320);
      return localObject;
    }
  }
  
  static abstract interface e
  {
    public abstract void a(android.support.v4.app.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     androidx.core.app.i
 * JD-Core Version:    0.7.0.1
 */