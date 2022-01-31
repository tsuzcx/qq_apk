package com.google.android.gms.dynamite;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Base64;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.zzd;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public final class DynamiteModule
{
  private static Boolean zzaRO;
  private static zza zzaRP;
  private static zzb zzaRQ;
  private static final HashMap<String, byte[]> zzaRR = new HashMap();
  private static String zzaRS;
  private static final DynamiteModule.zzb.zza zzaRT = new DynamiteModule.1();
  public static final DynamiteModule.zzb zzaRU = new DynamiteModule.2();
  public static final DynamiteModule.zzb zzaRV = new DynamiteModule.3();
  public static final DynamiteModule.zzb zzaRW = new DynamiteModule.4();
  public static final DynamiteModule.zzb zzaRX = new DynamiteModule.zzb()
  {
    public final DynamiteModule.zzb.zzb zza(Context paramAnonymousContext, String paramAnonymousString, DynamiteModule.zzb.zza paramAnonymouszza)
    {
      DynamiteModule.zzb.zzb localzzb = new DynamiteModule.zzb.zzb();
      localzzb.zzaSb = paramAnonymouszza.zzH(paramAnonymousContext, paramAnonymousString);
      localzzb.zzaSc = paramAnonymouszza.zzb(paramAnonymousContext, paramAnonymousString, true);
      if ((localzzb.zzaSb == 0) && (localzzb.zzaSc == 0))
      {
        localzzb.zzaSd = 0;
        return localzzb;
      }
      if (localzzb.zzaSc >= localzzb.zzaSb)
      {
        localzzb.zzaSd = 1;
        return localzzb;
      }
      localzzb.zzaSd = -1;
      return localzzb;
    }
  };
  public static final DynamiteModule.zzb zzaRY = new DynamiteModule.6();
  private final Context zzaRZ;
  
  private DynamiteModule(Context paramContext)
  {
    this.zzaRZ = ((Context)zzac.zzw(paramContext));
  }
  
  private static ClassLoader zzBS()
  {
    return new DynamiteModule.8(zzaRS, ClassLoader.getSystemClassLoader());
  }
  
  public static int zzH(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getApplicationContext().getClassLoader();
      Object localObject = String.valueOf("com.google.android.gms.dynamite.descriptors.");
      String str = String.valueOf("ModuleDescriptor");
      localObject = paramContext.loadClass(String.valueOf(localObject).length() + 1 + String.valueOf(paramString).length() + String.valueOf(str).length() + (String)localObject + paramString + "." + str);
      paramContext = ((Class)localObject).getDeclaredField("MODULE_ID");
      localObject = ((Class)localObject).getDeclaredField("MODULE_VERSION");
      if (!paramContext.get(null).equals(paramString))
      {
        paramContext = String.valueOf(paramContext.get(null));
        new StringBuilder(String.valueOf(paramContext).length() + 51 + String.valueOf(paramString).length()).append("Module descriptor id '").append(paramContext).append("' didn't match expected id '").append(paramString).append("'");
        return 0;
      }
      int i = ((Field)localObject).getInt(null);
      return i;
    }
    catch (ClassNotFoundException paramContext)
    {
      new StringBuilder(String.valueOf(paramString).length() + 45).append("Local module descriptor class for ").append(paramString).append(" not found.");
      return 0;
    }
    catch (Exception paramContext)
    {
      paramContext = String.valueOf(paramContext.getMessage());
      if (paramContext.length() != 0)
      {
        "Failed to load module descriptor class: ".concat(paramContext);
        return 0;
      }
      new String("Failed to load module descriptor class: ");
    }
    return 0;
  }
  
  public static int zzI(Context paramContext, String paramString)
  {
    return zzb(paramContext, paramString, false);
  }
  
  private static DynamiteModule zzJ(Context paramContext, String paramString)
  {
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      "Selected local version of ".concat(paramString);
    }
    for (;;)
    {
      return new DynamiteModule(paramContext.getApplicationContext());
      new String("Selected local version of ");
    }
  }
  
  private static Context zza(Context paramContext, String paramString, byte[] paramArrayOfByte, zzb paramzzb)
  {
    try
    {
      paramContext = (Context)zzd.zzF(paramzzb.zza(zzd.zzA(paramContext), paramString, paramArrayOfByte));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext = String.valueOf(paramContext.toString());
      if (paramContext.length() == 0) {
        break label46;
      }
    }
    "Failed to load DynamiteLoader: ".concat(paramContext);
    for (;;)
    {
      return null;
      label46:
      new String("Failed to load DynamiteLoader: ");
    }
  }
  
  public static DynamiteModule zza(Context paramContext, DynamiteModule.zzb paramzzb, String paramString)
  {
    DynamiteModule.zzb.zzb localzzb = paramzzb.zza(paramContext, paramString, zzaRT);
    int i = localzzb.zzaSb;
    int j = localzzb.zzaSc;
    new StringBuilder(String.valueOf(paramString).length() + 68 + String.valueOf(paramString).length()).append("Considering local module ").append(paramString).append(":").append(i).append(" and remote module ").append(paramString).append(":").append(j);
    if ((localzzb.zzaSd == 0) || ((localzzb.zzaSd == -1) && (localzzb.zzaSb == 0)) || ((localzzb.zzaSd == 1) && (localzzb.zzaSc == 0)))
    {
      i = localzzb.zzaSb;
      j = localzzb.zzaSc;
      throw new zza(91 + "No acceptable module found. Local version is " + i + " and remote version is " + j + ".", null);
    }
    if (localzzb.zzaSd == -1) {
      return zzJ(paramContext, paramString);
    }
    if (localzzb.zzaSd == 1) {
      try
      {
        DynamiteModule localDynamiteModule = zza(paramContext, paramString, localzzb.zzaSc);
        return localDynamiteModule;
      }
      catch (zza localzza)
      {
        String str = String.valueOf(localzza.getMessage());
        if (str.length() != 0) {
          "Failed to load remote module: ".concat(str);
        }
        while ((localzzb.zzaSb != 0) && (
        {
          public final int zzH(Context paramAnonymousContext, String paramAnonymousString)
          {
            return this.zzaSa;
          }
          
          public final int zzb(Context paramAnonymousContext, String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            return 0;
          }
        } == -1))
        {
          return zzJ(paramContext, paramString);
          new String("Failed to load remote module: ");
        }
        throw new zza("Remote load failed. No local fallback found.", localzza, null);
      }
    }
    i = localzzb.zzaSd;
    throw new zza(47 + "VersionPolicy returned invalid code:" + i, null);
  }
  
  private static DynamiteModule zza(Context paramContext, String paramString, int paramInt)
  {
    Boolean localBoolean;
    try
    {
      localBoolean = zzaRO;
      if (localBoolean == null) {
        throw new zza("Failed to determine which loading route to use.", null);
      }
    }
    finally {}
    if (localBoolean.booleanValue()) {
      return zzc(paramContext, paramString, paramInt);
    }
    return zzb(paramContext, paramString, paramInt);
  }
  
  private static void zza(ClassLoader paramClassLoader)
  {
    try
    {
      zzaRQ = zzb.zza.zzcf((IBinder)paramClassLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]));
      return;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      throw new zza("Failed to instantiate dynamite loader", paramClassLoader, null);
    }
    catch (InstantiationException paramClassLoader)
    {
      break label32;
    }
    catch (IllegalAccessException paramClassLoader)
    {
      break label32;
    }
    catch (NoSuchMethodException paramClassLoader)
    {
      break label32;
    }
    catch (InvocationTargetException paramClassLoader)
    {
      label32:
      break label32;
    }
  }
  
  /* Error */
  public static int zzb(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 272	com/google/android/gms/dynamite/DynamiteModule:zzaRO	Ljava/lang/Boolean;
    //   6: astore 6
    //   8: aload 6
    //   10: astore 5
    //   12: aload 6
    //   14: ifnonnull +70 -> 84
    //   17: aload_0
    //   18: invokevirtual 111	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   21: invokevirtual 114	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   24: ldc 10
    //   26: invokevirtual 323	java/lang/Class:getName	()Ljava/lang/String;
    //   29: invokevirtual 147	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   32: astore 6
    //   34: aload 6
    //   36: ldc_w 325
    //   39: invokevirtual 155	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   42: astore 5
    //   44: aload 6
    //   46: monitorenter
    //   47: aload 5
    //   49: aconst_null
    //   50: invokevirtual 162	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: checkcast 95	java/lang/ClassLoader
    //   56: astore 7
    //   58: aload 7
    //   60: ifnull +57 -> 117
    //   63: aload 7
    //   65: invokestatic 98	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   68: if_acmpne +36 -> 104
    //   71: getstatic 328	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   74: astore 5
    //   76: aload 6
    //   78: monitorexit
    //   79: aload 5
    //   81: putstatic 272	com/google/android/gms/dynamite/DynamiteModule:zzaRO	Ljava/lang/Boolean;
    //   84: ldc 2
    //   86: monitorexit
    //   87: aload 5
    //   89: invokevirtual 280	java/lang/Boolean:booleanValue	()Z
    //   92: ifeq +244 -> 336
    //   95: aload_0
    //   96: aload_1
    //   97: iload_2
    //   98: invokestatic 331	com/google/android/gms/dynamite/DynamiteModule:zzd	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   101: istore_3
    //   102: iload_3
    //   103: ireturn
    //   104: aload 7
    //   106: invokestatic 333	com/google/android/gms/dynamite/DynamiteModule:zza	(Ljava/lang/ClassLoader;)V
    //   109: getstatic 336	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   112: astore 5
    //   114: goto -38 -> 76
    //   117: ldc_w 338
    //   120: aload_0
    //   121: invokevirtual 111	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   124: invokevirtual 341	android/content/Context:getPackageName	()Ljava/lang/String;
    //   127: invokevirtual 342	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   130: ifeq +20 -> 150
    //   133: aload 5
    //   135: aconst_null
    //   136: invokestatic 98	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   139: invokevirtual 346	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   142: getstatic 328	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   145: astore 5
    //   147: goto -71 -> 76
    //   150: aload_0
    //   151: aload_1
    //   152: iload_2
    //   153: invokestatic 331	com/google/android/gms/dynamite/DynamiteModule:zzd	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   156: istore_3
    //   157: getstatic 93	com/google/android/gms/dynamite/DynamiteModule:zzaRS	Ljava/lang/String;
    //   160: ifnull +16 -> 176
    //   163: getstatic 93	com/google/android/gms/dynamite/DynamiteModule:zzaRS	Ljava/lang/String;
    //   166: invokevirtual 349	java/lang/String:isEmpty	()Z
    //   169: istore 4
    //   171: iload 4
    //   173: ifeq +17 -> 190
    //   176: aload 6
    //   178: monitorexit
    //   179: ldc 2
    //   181: monitorexit
    //   182: iload_3
    //   183: ireturn
    //   184: astore_0
    //   185: ldc 2
    //   187: monitorexit
    //   188: aload_0
    //   189: athrow
    //   190: invokestatic 351	com/google/android/gms/dynamite/DynamiteModule:zzBS	()Ljava/lang/ClassLoader;
    //   193: astore 7
    //   195: aload 7
    //   197: invokestatic 333	com/google/android/gms/dynamite/DynamiteModule:zza	(Ljava/lang/ClassLoader;)V
    //   200: aload 5
    //   202: aconst_null
    //   203: aload 7
    //   205: invokevirtual 346	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   208: getstatic 336	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   211: putstatic 272	com/google/android/gms/dynamite/DynamiteModule:zzaRO	Ljava/lang/Boolean;
    //   214: aload 6
    //   216: monitorexit
    //   217: ldc 2
    //   219: monitorexit
    //   220: iload_3
    //   221: ireturn
    //   222: astore 7
    //   224: aload 5
    //   226: aconst_null
    //   227: invokestatic 98	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   230: invokevirtual 346	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   233: getstatic 328	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   236: astore 5
    //   238: goto -162 -> 76
    //   241: astore 5
    //   243: aload 6
    //   245: monitorexit
    //   246: aload 5
    //   248: athrow
    //   249: astore 5
    //   251: aload 5
    //   253: invokestatic 122	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   256: astore 5
    //   258: new 126	java/lang/StringBuilder
    //   261: dup
    //   262: aload 5
    //   264: invokestatic 122	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   267: invokevirtual 130	java/lang/String:length	()I
    //   270: bipush 30
    //   272: iadd
    //   273: invokespecial 133	java/lang/StringBuilder:<init>	(I)V
    //   276: ldc_w 353
    //   279: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload 5
    //   284: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: getstatic 328	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   291: astore 5
    //   293: goto -214 -> 79
    //   296: astore_0
    //   297: aload_0
    //   298: invokevirtual 260	com/google/android/gms/dynamite/DynamiteModule$zza:getMessage	()Ljava/lang/String;
    //   301: invokestatic 122	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   304: astore_0
    //   305: aload_0
    //   306: invokevirtual 130	java/lang/String:length	()I
    //   309: ifeq +13 -> 322
    //   312: ldc_w 355
    //   315: aload_0
    //   316: invokevirtual 189	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   319: pop
    //   320: iconst_0
    //   321: ireturn
    //   322: new 118	java/lang/String
    //   325: dup
    //   326: ldc_w 355
    //   329: invokespecial 192	java/lang/String:<init>	(Ljava/lang/String;)V
    //   332: pop
    //   333: goto -13 -> 320
    //   336: aload_0
    //   337: aload_1
    //   338: iload_2
    //   339: invokestatic 357	com/google/android/gms/dynamite/DynamiteModule:zzc	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   342: ireturn
    //   343: astore 5
    //   345: goto -236 -> 109
    //   348: astore 5
    //   350: goto -99 -> 251
    //   353: astore 5
    //   355: goto -104 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	paramContext	Context
    //   0	358	1	paramString	String
    //   0	358	2	paramBoolean	boolean
    //   101	120	3	i	int
    //   169	3	4	bool	boolean
    //   10	227	5	localObject1	Object
    //   241	6	5	localObject2	Object
    //   249	3	5	localClassNotFoundException	ClassNotFoundException
    //   256	36	5	localObject3	Object
    //   343	1	5	localzza1	zza
    //   348	1	5	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   353	1	5	localIllegalAccessException	IllegalAccessException
    //   6	238	6	localObject4	Object
    //   56	148	7	localClassLoader	ClassLoader
    //   222	1	7	localzza2	zza
    // Exception table:
    //   from	to	target	type
    //   3	8	184	finally
    //   17	47	184	finally
    //   79	84	184	finally
    //   84	87	184	finally
    //   179	182	184	finally
    //   185	188	184	finally
    //   217	220	184	finally
    //   246	249	184	finally
    //   251	293	184	finally
    //   150	171	222	com/google/android/gms/dynamite/DynamiteModule$zza
    //   190	214	222	com/google/android/gms/dynamite/DynamiteModule$zza
    //   47	58	241	finally
    //   63	76	241	finally
    //   76	79	241	finally
    //   104	109	241	finally
    //   109	114	241	finally
    //   117	147	241	finally
    //   150	171	241	finally
    //   176	179	241	finally
    //   190	214	241	finally
    //   214	217	241	finally
    //   224	238	241	finally
    //   243	246	241	finally
    //   17	47	249	java/lang/ClassNotFoundException
    //   246	249	249	java/lang/ClassNotFoundException
    //   95	102	296	com/google/android/gms/dynamite/DynamiteModule$zza
    //   104	109	343	com/google/android/gms/dynamite/DynamiteModule$zza
    //   17	47	348	java/lang/NoSuchFieldException
    //   246	249	348	java/lang/NoSuchFieldException
    //   17	47	353	java/lang/IllegalAccessException
    //   246	249	353	java/lang/IllegalAccessException
  }
  
  private static DynamiteModule zzb(Context paramContext, String paramString, int paramInt)
  {
    new StringBuilder(String.valueOf(paramString).length() + 51).append("Selected remote version of ").append(paramString).append(", version >= ").append(paramInt);
    zza localzza = zzbm(paramContext);
    if (localzza == null) {
      throw new zza("Failed to create IDynamiteLoader.", null);
    }
    try
    {
      paramContext = localzza.zza(zzd.zzA(paramContext), paramString, paramInt);
      if (zzd.zzF(paramContext) == null) {
        throw new zza("Failed to load remote module.", null);
      }
    }
    catch (RemoteException paramContext)
    {
      throw new zza("Failed to load remote module.", paramContext, null);
    }
    return new DynamiteModule((Context)zzd.zzF(paramContext));
  }
  
  /* Error */
  private static zza zzbm(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 378	com/google/android/gms/dynamite/DynamiteModule:zzaRP	Lcom/google/android/gms/dynamite/zza;
    //   6: ifnull +12 -> 18
    //   9: getstatic 378	com/google/android/gms/dynamite/DynamiteModule:zzaRP	Lcom/google/android/gms/dynamite/zza;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: invokestatic 384	com/google/android/gms/common/zze:zzuY	()Lcom/google/android/gms/common/zze;
    //   21: aload_0
    //   22: invokevirtual 388	com/google/android/gms/common/zze:isGooglePlayServicesAvailable	(Landroid/content/Context;)I
    //   25: ifeq +8 -> 33
    //   28: ldc 2
    //   30: monitorexit
    //   31: aconst_null
    //   32: areturn
    //   33: aload_0
    //   34: ldc_w 338
    //   37: iconst_3
    //   38: invokevirtual 392	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   41: invokevirtual 114	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   44: ldc_w 394
    //   47: invokevirtual 147	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   50: invokevirtual 397	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   53: checkcast 308	android/os/IBinder
    //   56: invokestatic 403	com/google/android/gms/dynamite/zza$zza:zzce	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamite/zza;
    //   59: astore_0
    //   60: aload_0
    //   61: ifnull +42 -> 103
    //   64: aload_0
    //   65: putstatic 378	com/google/android/gms/dynamite/DynamiteModule:zzaRP	Lcom/google/android/gms/dynamite/zza;
    //   68: ldc 2
    //   70: monitorexit
    //   71: aload_0
    //   72: areturn
    //   73: astore_0
    //   74: ldc 2
    //   76: monitorexit
    //   77: aload_0
    //   78: athrow
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   84: invokestatic 122	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   87: astore_0
    //   88: aload_0
    //   89: invokevirtual 130	java/lang/String:length	()I
    //   92: ifeq +16 -> 108
    //   95: ldc_w 405
    //   98: aload_0
    //   99: invokevirtual 189	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   102: pop
    //   103: ldc 2
    //   105: monitorexit
    //   106: aconst_null
    //   107: areturn
    //   108: new 118	java/lang/String
    //   111: dup
    //   112: ldc_w 405
    //   115: invokespecial 192	java/lang/String:<init>	(Ljava/lang/String;)V
    //   118: pop
    //   119: goto -16 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	16	73	finally
    //   18	31	73	finally
    //   33	60	73	finally
    //   64	68	73	finally
    //   68	71	73	finally
    //   74	77	73	finally
    //   80	103	73	finally
    //   103	106	73	finally
    //   108	119	73	finally
    //   33	60	79	java/lang/Exception
    //   64	68	79	java/lang/Exception
  }
  
  private static int zzc(Context paramContext, String paramString, boolean paramBoolean)
  {
    zza localzza = zzbm(paramContext);
    if (localzza == null) {
      return 0;
    }
    try
    {
      int i = localzza.zza(zzd.zzA(paramContext), paramString, paramBoolean);
      return i;
    }
    catch (RemoteException paramContext)
    {
      paramContext = String.valueOf(paramContext.getMessage());
      if (paramContext.length() != 0)
      {
        "Failed to retrieve remote module version: ".concat(paramContext);
        return 0;
      }
      new String("Failed to retrieve remote module version: ");
    }
    return 0;
  }
  
  private static DynamiteModule zzc(Context paramContext, String paramString, int paramInt)
  {
    new StringBuilder(String.valueOf(paramString).length() + 51).append("Selected remote version of ").append(paramString).append(", version >= ").append(paramInt);
    byte[] arrayOfByte;
    zzb localzzb;
    try
    {
      arrayOfByte = (byte[])zzaRR.get(String.valueOf(paramString).length() + 12 + paramString + ":" + paramInt);
      localzzb = zzaRQ;
      if (arrayOfByte == null) {
        throw new zza("Module implementation could not be found.", null);
      }
    }
    finally {}
    if (localzzb == null) {
      throw new zza("DynamiteLoaderV2 was not cached.", null);
    }
    paramContext = zza(paramContext.getApplicationContext(), paramString, arrayOfByte, localzzb);
    if (paramContext == null) {
      throw new zza("Failed to get module context", null);
    }
    return new DynamiteModule(paramContext);
  }
  
  private static int zzd(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      paramContext = zze(paramContext, paramString, paramBoolean);
      if (paramContext != null)
      {
        localObject1 = paramContext;
        localObject2 = paramContext;
        if (paramContext.moveToFirst()) {}
      }
      else
      {
        localObject1 = paramContext;
        localObject2 = paramContext;
        throw new zza("Failed to connect to dynamite module ContentResolver.", null);
      }
    }
    catch (Exception paramContext)
    {
      localObject2 = localObject1;
      if (!(paramContext instanceof zza)) {
        break label202;
      }
      localObject2 = localObject1;
      throw paramContext;
    }
    finally
    {
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
    }
    localObject1 = paramContext;
    localObject2 = paramContext;
    int i = paramContext.getInt(0);
    if (i > 0)
    {
      localObject1 = paramContext;
      localObject2 = paramContext;
    }
    try
    {
      localObject1 = Base64.decode(paramContext.getString(3), 0);
      zzaRR.put(String.valueOf(paramString).length() + 12 + paramString + ":" + i, localObject1);
      zzaRS = paramContext.getString(2);
      if (paramContext != null) {
        paramContext.close();
      }
      return i;
    }
    finally
    {
      localObject1 = paramContext;
      localObject2 = paramContext;
    }
    label202:
    localObject2 = localObject1;
    throw new zza("V2 version check failed", paramContext, null);
  }
  
  public static Cursor zze(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str1 = "api_force_staging";; str1 = "api")
    {
      String str2 = String.valueOf("content://com.google.android.gms.chimera/");
      paramString = Uri.parse(String.valueOf(str2).length() + 1 + String.valueOf(str1).length() + String.valueOf(paramString).length() + str2 + str1 + "/" + paramString);
      return paramContext.getContentResolver().query(paramString, null, null, null, null);
    }
  }
  
  public final Context zzBR()
  {
    return this.zzaRZ;
  }
  
  public final IBinder zzdT(String paramString)
  {
    try
    {
      IBinder localIBinder = (IBinder)this.zzaRZ.getClassLoader().loadClass(paramString).newInstance();
      return localIBinder;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "Failed to instantiate module class: ".concat(paramString);; paramString = new String("Failed to instantiate module class: ")) {
        throw new zza(paramString, localClassNotFoundException, null);
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      break label21;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label21:
      break label21;
    }
  }
  
  @DynamiteApi
  public static class DynamiteLoaderClassLoader
  {
    public static ClassLoader sClassLoader;
  }
  
  public static class zza
    extends Exception
  {
    private zza(String paramString)
    {
      super();
    }
    
    private zza(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.dynamite.DynamiteModule
 * JD-Core Version:    0.7.0.1
 */