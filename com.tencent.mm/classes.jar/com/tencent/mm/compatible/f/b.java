package com.tencent.mm.compatible.f;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Method;

public final class b
{
  private static Boolean dzn = null;
  
  public static boolean be(Context paramContext)
  {
    if (dzn == null) {
      if (paramContext != null) {
        break label26;
      }
    }
    label26:
    for (boolean bool = false;; bool = paramContext.getPackageManager().hasSystemFeature("org.chromium.arc.device_management"))
    {
      dzn = Boolean.valueOf(bool);
      return dzn.booleanValue();
    }
  }
  
  public static void bf(Context paramContext)
  {
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {}
    try
    {
      Intent localIntent1 = new Intent();
      localIntent1.setClassName("com.android.settings", "com.android.settings.applications.AppsCheckReadPermission");
      paramContext.startActivity(localIntent1);
      return;
    }
    catch (Exception localException1)
    {
      y.e("MicroMsg.PermissionUtil", "unable start activity AppsCheckReadPermission");
      try
      {
        Intent localIntent2 = new Intent("android.settings.APP_OPS_SETTINGS");
        localIntent2.addCategory("android.intent.category.DEFAULT");
        paramContext.startActivity(localIntent2);
        return;
      }
      catch (Exception localException2)
      {
        y.e("MicroMsg.PermissionUtil", "unable start activity APP_OPS_SETTINGS");
        try
        {
          Intent localIntent3 = new Intent();
          localIntent3.setClassName("com.android.settings", "com.android.settings.Settings$AppControlSettingsActivity");
          paramContext.startActivity(localIntent3);
          return;
        }
        catch (Exception paramContext)
        {
          y.e("MicroMsg.PermissionUtil", "unable start activity AppControlSettingsActivity");
        }
      }
    }
  }
  
  @TargetApi(19)
  public static boolean bg(Context paramContext)
  {
    bool2 = true;
    bool1 = true;
    int i = Build.VERSION.SDK_INT;
    if (i >= 23) {}
    while (i < 19) {
      try
      {
        bool1 = ((Boolean)Settings.class.getDeclaredMethod("canDrawOverlays", new Class[] { Context.class }).invoke(null, new Object[] { paramContext })).booleanValue();
        y.i("MicroMsg.PermissionUtil", "isFloatWindowOpAllowed allowed: " + bool1);
        return bool1;
      }
      catch (Exception paramContext)
      {
        y.e("MicroMsg.PermissionUtil", "getDeclaredMethod:canDrawOverlays! Error:%s, etype:%s", new Object[] { paramContext.getMessage(), paramContext.getClass().getCanonicalName() });
        return true;
      }
    }
    Object localObject = ae.getContext().getSystemService("appops");
    try
    {
      paramContext = Class.forName("android.app.AppOpsManager").getMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
      bool1 = bool2;
      if (paramContext != null) {}
      try
      {
        i = ((Integer)paramContext.invoke(localObject, new Object[] { Integer.valueOf(24), Integer.valueOf(ae.getContext().getApplicationInfo().uid), ae.getPackageName() })).intValue();
        if (i != 0) {
          break label280;
        }
        bool1 = true;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          y.e("MicroMsg.PermissionUtil", "call checkOp failed: %s etype:%s", new Object[] { paramContext.getMessage(), paramContext.getClass().getCanonicalName() });
          bool1 = bool2;
        }
      }
      y.i("MicroMsg.PermissionUtil", "isFloatWindowOpAllowed allowed: " + bool1);
      return bool1;
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        y.e("MicroMsg.PermissionUtil", "NoSuchMethodException method:checkOp! Error:%s", new Object[] { paramContext.getMessage() });
        paramContext = null;
      }
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        y.e("MicroMsg.PermissionUtil", "ClassNotFoundException class:android.app.AppOpsManager! Error:%s", new Object[] { paramContext.getMessage() });
        paramContext = null;
        continue;
        label280:
        bool1 = false;
      }
    }
  }
  
  /* Error */
  private static boolean gE(int paramInt)
  {
    // Byte code:
    //   0: iload_0
    //   1: ifne +5 -> 6
    //   4: iconst_1
    //   5: ireturn
    //   6: invokestatic 165	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   9: ldc 167
    //   11: invokevirtual 171	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull +150 -> 166
    //   19: ldc 173
    //   21: invokestatic 177	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   24: ldc 220
    //   26: iconst_3
    //   27: anewarray 118	java/lang/Class
    //   30: dup
    //   31: iconst_0
    //   32: getstatic 185	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: getstatic 185	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   41: aastore
    //   42: dup
    //   43: iconst_2
    //   44: ldc 51
    //   46: aastore
    //   47: invokevirtual 188	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +143 -> 195
    //   55: aload_1
    //   56: aload_2
    //   57: iconst_3
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: iload_0
    //   64: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: invokestatic 165	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   73: invokevirtual 195	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   76: getfield 200	android/content/pm/ApplicationInfo:uid	I
    //   79: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: aastore
    //   83: dup
    //   84: iconst_2
    //   85: invokestatic 203	com/tencent/mm/sdk/platformtools/ae:getPackageName	()Ljava/lang/String;
    //   88: aastore
    //   89: invokevirtual 128	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   92: checkcast 181	java/lang/Integer
    //   95: invokevirtual 207	java/lang/Integer:intValue	()I
    //   98: istore_0
    //   99: iload_0
    //   100: ifeq +95 -> 195
    //   103: ldc 73
    //   105: ldc 222
    //   107: iconst_1
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: iload_0
    //   114: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: aastore
    //   118: invokestatic 159	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: iconst_0
    //   122: ireturn
    //   123: astore_1
    //   124: ldc 73
    //   126: ldc 224
    //   128: iconst_1
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_1
    //   135: invokevirtual 210	java/lang/NoSuchMethodException:getMessage	()Ljava/lang/String;
    //   138: aastore
    //   139: invokestatic 159	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aconst_null
    //   143: astore_1
    //   144: goto -93 -> 51
    //   147: astore_1
    //   148: ldc 73
    //   150: ldc 212
    //   152: iconst_1
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload_1
    //   159: invokevirtual 213	java/lang/ClassNotFoundException:getMessage	()Ljava/lang/String;
    //   162: aastore
    //   163: invokestatic 159	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: aconst_null
    //   167: astore_1
    //   168: goto -117 -> 51
    //   171: astore_1
    //   172: ldc 73
    //   174: ldc 226
    //   176: iconst_1
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload_1
    //   183: invokevirtual 149	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   186: aastore
    //   187: invokestatic 159	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: iconst_m1
    //   191: istore_0
    //   192: goto -93 -> 99
    //   195: iconst_1
    //   196: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramInt	int
    //   50	6	1	localMethod	Method
    //   123	12	1	localNoSuchMethodException	NoSuchMethodException
    //   143	1	1	localObject1	Object
    //   147	12	1	localClassNotFoundException	ClassNotFoundException
    //   167	1	1	localObject2	Object
    //   171	12	1	localException	Exception
    //   14	43	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   19	51	123	java/lang/NoSuchMethodException
    //   19	51	147	java/lang/ClassNotFoundException
    //   55	99	171	java/lang/Exception
  }
  
  public static boolean zA()
  {
    if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      return true;
    }
    int i = 0;
    if (Build.VERSION.SDK_INT == 17) {
      i = 36;
    }
    for (;;)
    {
      return gE(i);
      if (Build.VERSION.SDK_INT >= 19) {
        i = 27;
      }
    }
  }
  
  public static boolean zB()
  {
    if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      return true;
    }
    int i = 0;
    if (Build.VERSION.SDK_INT == 17) {
      i = 35;
    }
    for (;;)
    {
      return gE(i);
      if (Build.VERSION.SDK_INT >= 19) {
        i = 26;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.f.b
 * JD-Core Version:    0.7.0.1
 */