package com.tencent.mm.compatible.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.reflect.Method;

public final class b
{
  private static Boolean gft = null;
  
  public static boolean abj()
  {
    AppMethodBeat.i(155848);
    if (!Build.MANUFACTURER.equalsIgnoreCase("meizu"))
    {
      AppMethodBeat.o(155848);
      return true;
    }
    int i = 0;
    if (Build.VERSION.SDK_INT == 17) {
      i = 36;
    }
    for (;;)
    {
      boolean bool = lz(i);
      AppMethodBeat.o(155848);
      return bool;
      if (Build.VERSION.SDK_INT >= 19) {
        i = 27;
      }
    }
  }
  
  public static boolean abk()
  {
    AppMethodBeat.i(155850);
    if (!Build.MANUFACTURER.equalsIgnoreCase("meizu"))
    {
      AppMethodBeat.o(155850);
      return true;
    }
    int i = 0;
    if (Build.VERSION.SDK_INT == 17) {
      i = 35;
    }
    for (;;)
    {
      boolean bool = lz(i);
      AppMethodBeat.o(155850);
      return bool;
      if (Build.VERSION.SDK_INT >= 19) {
        i = 26;
      }
    }
  }
  
  public static boolean ca(Context paramContext)
  {
    boolean bool = false;
    AppMethodBeat.i(155849);
    if ((gft != null) || (paramContext == null)) {}
    for (;;)
    {
      try
      {
        gft = Boolean.valueOf(bool);
        gft = Boolean.FALSE;
      }
      catch (Throwable paramContext)
      {
        ae.printErrStackTrace("MicroMsg.PermissionUtil", paramContext, "", new Object[0]);
        gft = Boolean.FALSE;
        continue;
      }
      finally
      {
        gft = Boolean.FALSE;
        AppMethodBeat.o(155849);
      }
      bool = gft.booleanValue();
      AppMethodBeat.o(155849);
      return bool;
      bool = paramContext.getPackageManager().hasSystemFeature("org.chromium.arc.device_management");
    }
  }
  
  public static void cb(Context paramContext)
  {
    AppMethodBeat.i(155851);
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      try
      {
        Object localObject1 = new Intent();
        ((Intent)localObject1).setClassName("com.android.settings", "com.android.settings.applications.AppsCheckReadPermission");
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/compatible/permission/PermissionUtil", "showPermissionSettingsOfMeizu", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/compatible/permission/PermissionUtil", "showPermissionSettingsOfMeizu", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(155851);
        return;
      }
      catch (Exception localException1)
      {
        ae.e("MicroMsg.PermissionUtil", "unable start activity AppsCheckReadPermission");
        try
        {
          Object localObject2 = new Intent("android.settings.APP_OPS_SETTINGS");
          ((Intent)localObject2).addCategory("android.intent.category.DEFAULT");
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/compatible/permission/PermissionUtil", "showPermissionSettingsOfMeizu", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/compatible/permission/PermissionUtil", "showPermissionSettingsOfMeizu", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(155851);
          return;
        }
        catch (Exception localException2)
        {
          ae.e("MicroMsg.PermissionUtil", "unable start activity APP_OPS_SETTINGS");
          try
          {
            Object localObject3 = new Intent();
            ((Intent)localObject3).setClassName("com.android.settings", "com.android.settings.Settings$AppControlSettingsActivity");
            localObject3 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject3);
            com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject3).ahE(), "com/tencent/mm/compatible/permission/PermissionUtil", "showPermissionSettingsOfMeizu", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/compatible/permission/PermissionUtil", "showPermissionSettingsOfMeizu", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(155851);
            return;
          }
          catch (Exception paramContext)
          {
            ae.e("MicroMsg.PermissionUtil", "unable start activity AppControlSettingsActivity");
          }
        }
      }
    }
    AppMethodBeat.o(155851);
  }
  
  @TargetApi(19)
  public static boolean cc(Context paramContext)
  {
    boolean bool2 = true;
    AppMethodBeat.i(155853);
    int i = Build.VERSION.SDK_INT;
    boolean bool1;
    if (i >= 23) {
      try
      {
        bool1 = ((Boolean)Settings.class.getDeclaredMethod("canDrawOverlays", new Class[] { Context.class }).invoke(null, new Object[] { paramContext })).booleanValue();
        ae.i("MicroMsg.PermissionUtil", "isFloatWindowOpAllowed allowed: ".concat(String.valueOf(bool1)));
        AppMethodBeat.o(155853);
        return bool1;
      }
      catch (Exception paramContext)
      {
        ae.e("MicroMsg.PermissionUtil", "getDeclaredMethod:canDrawOverlays! Error:%s, etype:%s", new Object[] { paramContext.getMessage(), paramContext.getClass().getCanonicalName() });
        AppMethodBeat.o(155853);
        return true;
      }
    }
    if (i >= 19)
    {
      Object localObject = ak.getContext().getSystemService("appops");
      try
      {
        paramContext = Class.forName("android.app.AppOpsManager").getMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
        bool1 = bool2;
        if (paramContext != null) {}
        try
        {
          i = ((Integer)paramContext.invoke(localObject, new Object[] { Integer.valueOf(24), Integer.valueOf(ak.getContext().getApplicationInfo().uid), ak.getPackageName() })).intValue();
          if (i != 0) {
            break label286;
          }
          bool1 = true;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            ae.e("MicroMsg.PermissionUtil", "call checkOp failed: %s etype:%s", new Object[] { paramContext.getMessage(), paramContext.getClass().getCanonicalName() });
            bool1 = bool2;
          }
        }
        ae.i("MicroMsg.PermissionUtil", "isFloatWindowOpAllowed allowed: ".concat(String.valueOf(bool1)));
        AppMethodBeat.o(155853);
        return bool1;
      }
      catch (NoSuchMethodException paramContext)
      {
        for (;;)
        {
          ae.e("MicroMsg.PermissionUtil", "NoSuchMethodException method:checkOp! Error:%s", new Object[] { paramContext.getMessage() });
          paramContext = null;
        }
      }
      catch (ClassNotFoundException paramContext)
      {
        for (;;)
        {
          ae.e("MicroMsg.PermissionUtil", "ClassNotFoundException class:android.app.AppOpsManager! Error:%s", new Object[] { paramContext.getMessage() });
          paramContext = null;
          continue;
          label286:
          bool1 = false;
        }
      }
    }
    AppMethodBeat.o(155853);
    return true;
  }
  
  /* Error */
  private static boolean lz(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 277
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_0
    //   7: ifne +11 -> 18
    //   10: ldc_w 277
    //   13: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_1
    //   17: ireturn
    //   18: invokestatic 225	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   21: ldc 227
    //   23: invokevirtual 231	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull +160 -> 188
    //   31: ldc 233
    //   33: invokestatic 237	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   36: ldc_w 279
    //   39: iconst_3
    //   40: anewarray 182	java/lang/Class
    //   43: dup
    //   44: iconst_0
    //   45: getstatic 245	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: getstatic 245	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   54: aastore
    //   55: dup
    //   56: iconst_2
    //   57: ldc 30
    //   59: aastore
    //   60: invokevirtual 248	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   63: astore_1
    //   64: aload_1
    //   65: ifnull +153 -> 218
    //   68: aload_1
    //   69: aload_2
    //   70: iconst_3
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: iload_0
    //   77: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: invokestatic 225	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   86: invokevirtual 255	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   89: getfield 260	android/content/pm/ApplicationInfo:uid	I
    //   92: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: aastore
    //   96: dup
    //   97: iconst_2
    //   98: invokestatic 263	com/tencent/mm/sdk/platformtools/ak:getPackageName	()Ljava/lang/String;
    //   101: aastore
    //   102: invokevirtual 192	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   105: checkcast 241	java/lang/Integer
    //   108: invokevirtual 267	java/lang/Integer:intValue	()I
    //   111: istore_0
    //   112: iload_0
    //   113: ifeq +105 -> 218
    //   116: ldc 81
    //   118: ldc_w 281
    //   121: iconst_1
    //   122: anewarray 4	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: iload_0
    //   128: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   131: aastore
    //   132: invokestatic 219	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: ldc_w 277
    //   138: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: iconst_0
    //   142: ireturn
    //   143: astore_1
    //   144: ldc 81
    //   146: ldc_w 283
    //   149: iconst_1
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: aload_1
    //   156: invokevirtual 270	java/lang/NoSuchMethodException:getMessage	()Ljava/lang/String;
    //   159: aastore
    //   160: invokestatic 219	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: aconst_null
    //   164: astore_1
    //   165: goto -101 -> 64
    //   168: astore_1
    //   169: ldc 81
    //   171: ldc_w 272
    //   174: iconst_1
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: aload_1
    //   181: invokevirtual 273	java/lang/ClassNotFoundException:getMessage	()Ljava/lang/String;
    //   184: aastore
    //   185: invokestatic 219	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aconst_null
    //   189: astore_1
    //   190: goto -126 -> 64
    //   193: astore_1
    //   194: ldc 81
    //   196: ldc_w 285
    //   199: iconst_1
    //   200: anewarray 4	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: aload_1
    //   206: invokevirtual 209	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   209: aastore
    //   210: invokestatic 219	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: iconst_m1
    //   214: istore_0
    //   215: goto -103 -> 112
    //   218: ldc_w 277
    //   221: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: iconst_1
    //   225: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramInt	int
    //   63	6	1	localMethod	Method
    //   143	13	1	localNoSuchMethodException	NoSuchMethodException
    //   164	1	1	localObject1	Object
    //   168	13	1	localClassNotFoundException	ClassNotFoundException
    //   189	1	1	localObject2	Object
    //   193	13	1	localException	Exception
    //   26	44	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   31	64	143	java/lang/NoSuchMethodException
    //   31	64	168	java/lang/ClassNotFoundException
    //   68	112	193	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.d.b
 * JD-Core Version:    0.7.0.1
 */