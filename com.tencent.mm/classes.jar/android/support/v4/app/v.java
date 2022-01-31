package android.support.v4.app;

import android.app.AppOpsManager;
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
  private static final Object sLock = new Object();
  private static final Object yY = new Object();
  private static String yZ;
  private static Set<String> za = new HashSet();
  private static v.d zc;
  public final Context mContext;
  public final NotificationManager zb;
  
  private v(Context paramContext)
  {
    this.mContext = paramContext;
    this.zb = ((NotificationManager)this.mContext.getSystemService("notification"));
  }
  
  public static v K(Context paramContext)
  {
    return new v(paramContext);
  }
  
  public static Set<String> L(Context paramContext)
  {
    Object localObject1 = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_notification_listeners");
    paramContext = yY;
    if (localObject1 != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (!((String)localObject1).equals(yZ))
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
            za = localHashSet;
            yZ = (String)localObject1;
          }
        }
        else
        {
          localObject1 = za;
          return localObject1;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public final void a(v.e parame)
  {
    synchronized (sLock)
    {
      if (zc == null) {
        zc = new v.d(this.mContext.getApplicationContext());
      }
      zc.b(parame);
      return;
    }
  }
  
  public final boolean areNotificationsEnabled()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.zb.areNotificationsEnabled();
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
    this.zb.cancel(null, paramInt);
    if (Build.VERSION.SDK_INT <= 19) {
      a(new v.a(this.mContext.getPackageName(), paramInt));
    }
  }
  
  public final int getImportance()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.zb.getImportance();
    }
    return -1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.app.v
 * JD-Core Version:    0.7.0.1
 */