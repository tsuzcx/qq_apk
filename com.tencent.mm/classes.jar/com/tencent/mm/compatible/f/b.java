package com.tencent.mm.compatible.f;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.reflect.Method;

public final class b
{
  private static Boolean esc = null;
  
  public static boolean Md()
  {
    AppMethodBeat.i(93043);
    if (!Build.MANUFACTURER.equalsIgnoreCase("meizu"))
    {
      AppMethodBeat.o(93043);
      return true;
    }
    int i = 0;
    if (Build.VERSION.SDK_INT == 17) {
      i = 36;
    }
    for (;;)
    {
      boolean bool = iT(i);
      AppMethodBeat.o(93043);
      return bool;
      if (Build.VERSION.SDK_INT >= 19) {
        i = 27;
      }
    }
  }
  
  public static boolean Me()
  {
    AppMethodBeat.i(93045);
    if (!Build.MANUFACTURER.equalsIgnoreCase("meizu"))
    {
      AppMethodBeat.o(93045);
      return true;
    }
    int i = 0;
    if (Build.VERSION.SDK_INT == 17) {
      i = 35;
    }
    for (;;)
    {
      boolean bool = iT(i);
      AppMethodBeat.o(93045);
      return bool;
      if (Build.VERSION.SDK_INT >= 19) {
        i = 26;
      }
    }
  }
  
  public static boolean bI(Context paramContext)
  {
    AppMethodBeat.i(93044);
    if (esc == null) {
      if (paramContext != null) {
        break label38;
      }
    }
    label38:
    for (boolean bool = false;; bool = paramContext.getPackageManager().hasSystemFeature("org.chromium.arc.device_management"))
    {
      esc = Boolean.valueOf(bool);
      bool = esc.booleanValue();
      AppMethodBeat.o(93044);
      return bool;
    }
  }
  
  public static void bJ(Context paramContext)
  {
    AppMethodBeat.i(93046);
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      try
      {
        Intent localIntent1 = new Intent();
        localIntent1.setClassName("com.android.settings", "com.android.settings.applications.AppsCheckReadPermission");
        paramContext.startActivity(localIntent1);
        AppMethodBeat.o(93046);
        return;
      }
      catch (Exception localException1)
      {
        ab.e("MicroMsg.PermissionUtil", "unable start activity AppsCheckReadPermission");
        try
        {
          Intent localIntent2 = new Intent("android.settings.APP_OPS_SETTINGS");
          localIntent2.addCategory("android.intent.category.DEFAULT");
          paramContext.startActivity(localIntent2);
          AppMethodBeat.o(93046);
          return;
        }
        catch (Exception localException2)
        {
          ab.e("MicroMsg.PermissionUtil", "unable start activity APP_OPS_SETTINGS");
          try
          {
            Intent localIntent3 = new Intent();
            localIntent3.setClassName("com.android.settings", "com.android.settings.Settings$AppControlSettingsActivity");
            paramContext.startActivity(localIntent3);
            AppMethodBeat.o(93046);
            return;
          }
          catch (Exception paramContext)
          {
            ab.e("MicroMsg.PermissionUtil", "unable start activity AppControlSettingsActivity");
          }
        }
      }
    }
    AppMethodBeat.o(93046);
  }
  
  @TargetApi(19)
  public static boolean bK(Context paramContext)
  {
    boolean bool2 = true;
    AppMethodBeat.i(93048);
    int i = Build.VERSION.SDK_INT;
    boolean bool1;
    if (i >= 23) {
      try
      {
        bool1 = ((Boolean)Settings.class.getDeclaredMethod("canDrawOverlays", new Class[] { Context.class }).invoke(null, new Object[] { paramContext })).booleanValue();
        ab.i("MicroMsg.PermissionUtil", "isFloatWindowOpAllowed allowed: ".concat(String.valueOf(bool1)));
        AppMethodBeat.o(93048);
        return bool1;
      }
      catch (Exception paramContext)
      {
        ab.e("MicroMsg.PermissionUtil", "getDeclaredMethod:canDrawOverlays! Error:%s, etype:%s", new Object[] { paramContext.getMessage(), paramContext.getClass().getCanonicalName() });
        AppMethodBeat.o(93048);
        return true;
      }
    }
    if (i >= 19)
    {
      Object localObject = ah.getContext().getSystemService("appops");
      try
      {
        paramContext = Class.forName("android.app.AppOpsManager").getMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
        bool1 = bool2;
        if (paramContext != null) {}
        try
        {
          i = ((Integer)paramContext.invoke(localObject, new Object[] { Integer.valueOf(24), Integer.valueOf(ah.getContext().getApplicationInfo().uid), ah.getPackageName() })).intValue();
          if (i != 0) {
            break label284;
          }
          bool1 = true;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            ab.e("MicroMsg.PermissionUtil", "call checkOp failed: %s etype:%s", new Object[] { paramContext.getMessage(), paramContext.getClass().getCanonicalName() });
            bool1 = bool2;
          }
        }
        ab.i("MicroMsg.PermissionUtil", "isFloatWindowOpAllowed allowed: ".concat(String.valueOf(bool1)));
        AppMethodBeat.o(93048);
        return bool1;
      }
      catch (NoSuchMethodException paramContext)
      {
        for (;;)
        {
          ab.e("MicroMsg.PermissionUtil", "NoSuchMethodException method:checkOp! Error:%s", new Object[] { paramContext.getMessage() });
          paramContext = null;
        }
      }
      catch (ClassNotFoundException paramContext)
      {
        for (;;)
        {
          ab.e("MicroMsg.PermissionUtil", "ClassNotFoundException class:android.app.AppOpsManager! Error:%s", new Object[] { paramContext.getMessage() });
          paramContext = null;
          continue;
          label284:
          bool1 = false;
        }
      }
    }
    AppMethodBeat.o(93048);
    return true;
  }
  
  /* Error */
  private static boolean iT(int paramInt)
  {
    // Byte code:
    //   0: ldc 233
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iload_0
    //   6: ifne +10 -> 16
    //   9: ldc 233
    //   11: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: iconst_1
    //   15: ireturn
    //   16: invokestatic 181	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   19: ldc 183
    //   21: invokevirtual 187	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +155 -> 181
    //   29: ldc 189
    //   31: invokestatic 193	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   34: ldc 235
    //   36: iconst_3
    //   37: anewarray 138	java/lang/Class
    //   40: dup
    //   41: iconst_0
    //   42: getstatic 201	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: getstatic 201	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   51: aastore
    //   52: dup
    //   53: iconst_2
    //   54: ldc 30
    //   56: aastore
    //   57: invokevirtual 204	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   60: astore_1
    //   61: aload_1
    //   62: ifnull +148 -> 210
    //   65: aload_1
    //   66: aload_2
    //   67: iconst_3
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: iload_0
    //   74: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: invokestatic 181	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   83: invokevirtual 211	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   86: getfield 216	android/content/pm/ApplicationInfo:uid	I
    //   89: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   92: aastore
    //   93: dup
    //   94: iconst_2
    //   95: invokestatic 219	com/tencent/mm/sdk/platformtools/ah:getPackageName	()Ljava/lang/String;
    //   98: aastore
    //   99: invokevirtual 148	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast 197	java/lang/Integer
    //   105: invokevirtual 223	java/lang/Integer:intValue	()I
    //   108: istore_0
    //   109: iload_0
    //   110: ifeq +100 -> 210
    //   113: ldc 98
    //   115: ldc 237
    //   117: iconst_1
    //   118: anewarray 4	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: iload_0
    //   124: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: aastore
    //   128: invokestatic 175	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: ldc 233
    //   133: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_1
    //   139: ldc 98
    //   141: ldc 239
    //   143: iconst_1
    //   144: anewarray 4	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: aload_1
    //   150: invokevirtual 226	java/lang/NoSuchMethodException:getMessage	()Ljava/lang/String;
    //   153: aastore
    //   154: invokestatic 175	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aconst_null
    //   158: astore_1
    //   159: goto -98 -> 61
    //   162: astore_1
    //   163: ldc 98
    //   165: ldc 228
    //   167: iconst_1
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload_1
    //   174: invokevirtual 229	java/lang/ClassNotFoundException:getMessage	()Ljava/lang/String;
    //   177: aastore
    //   178: invokestatic 175	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   181: aconst_null
    //   182: astore_1
    //   183: goto -122 -> 61
    //   186: astore_1
    //   187: ldc 98
    //   189: ldc 241
    //   191: iconst_1
    //   192: anewarray 4	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload_1
    //   198: invokevirtual 165	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   201: aastore
    //   202: invokestatic 175	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: iconst_m1
    //   206: istore_0
    //   207: goto -98 -> 109
    //   210: ldc 233
    //   212: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: iconst_1
    //   216: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramInt	int
    //   60	6	1	localMethod	Method
    //   138	12	1	localNoSuchMethodException	NoSuchMethodException
    //   158	1	1	localObject1	Object
    //   162	12	1	localClassNotFoundException	ClassNotFoundException
    //   182	1	1	localObject2	Object
    //   186	12	1	localException	Exception
    //   24	43	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   29	61	138	java/lang/NoSuchMethodException
    //   29	61	162	java/lang/ClassNotFoundException
    //   65	109	186	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.f.b
 * JD-Core Version:    0.7.0.1
 */