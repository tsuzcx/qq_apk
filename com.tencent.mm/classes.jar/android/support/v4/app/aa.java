package android.support.v4.app;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.Secure;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public final class aa
{
  private static final Object sLock = new Object();
  private static aa.d yA;
  private static final Object yw = new Object();
  private static String yx;
  private static Set<String> yy = new HashSet();
  public final Context mContext;
  public final NotificationManager yz;
  
  private aa(Context paramContext)
  {
    this.mContext = paramContext;
    this.yz = ((NotificationManager)this.mContext.getSystemService("notification"));
  }
  
  public static aa L(Context paramContext)
  {
    return new aa(paramContext);
  }
  
  public static Set<String> M(Context paramContext)
  {
    Object localObject1 = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_notification_listeners");
    paramContext = yw;
    if (localObject1 != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (!((String)localObject1).equals(yx))
        {
          String[] arrayOfString = ((String)localObject1).split(":");
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
            yy = localHashSet;
            yx = (String)localObject1;
          }
        }
        else
        {
          localObject1 = yy;
          return localObject1;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public final void a(aa.e parame)
  {
    synchronized (sLock)
    {
      if (yA == null) {
        yA = new aa.d(this.mContext.getApplicationContext());
      }
      yA.mHandler.obtainMessage(0, parame).sendToTarget();
      return;
    }
  }
  
  public final boolean areNotificationsEnabled()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.yz.areNotificationsEnabled();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.app.aa
 * JD-Core Version:    0.7.0.1
 */