package com.google.android.gms.dynamite;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

public final class DynamiteModule
{
  public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION;
  public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING;
  public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION;
  public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION_NO_FORCE_STAGING;
  public static final VersionPolicy PREFER_LOCAL;
  public static final VersionPolicy PREFER_REMOTE;
  @GuardedBy("DynamiteModule.class")
  private static Boolean zzabr;
  @GuardedBy("DynamiteModule.class")
  private static IDynamiteLoader zzabs;
  @GuardedBy("DynamiteModule.class")
  private static IDynamiteLoaderV2 zzabt;
  @GuardedBy("DynamiteModule.class")
  private static String zzabu;
  private static final ThreadLocal<zza> zzabv;
  private static final DynamiteModule.VersionPolicy.IVersions zzabw;
  private final Context zzabx;
  
  static
  {
    AppMethodBeat.i(90442);
    zzabv = new ThreadLocal();
    zzabw = new zza();
    PREFER_REMOTE = new zzb();
    PREFER_LOCAL = new zzc();
    PREFER_HIGHEST_OR_LOCAL_VERSION = new zzd();
    PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zze();
    PREFER_HIGHEST_OR_REMOTE_VERSION = new zzf();
    PREFER_HIGHEST_OR_REMOTE_VERSION_NO_FORCE_STAGING = new zzg();
    AppMethodBeat.o(90442);
  }
  
  private DynamiteModule(Context paramContext)
  {
    AppMethodBeat.i(90441);
    this.zzabx = ((Context)Preconditions.checkNotNull(paramContext));
    AppMethodBeat.o(90441);
  }
  
  public static int getLocalVersion(Context paramContext, String paramString)
  {
    AppMethodBeat.i(90426);
    try
    {
      Object localObject = paramContext.getApplicationContext().getClassLoader().loadClass(String.valueOf(paramString).length() + 61 + "com.google.android.gms.dynamite.descriptors." + paramString + ".ModuleDescriptor");
      paramContext = ((Class)localObject).getDeclaredField("MODULE_ID");
      localObject = ((Class)localObject).getDeclaredField("MODULE_VERSION");
      if (!paramContext.get(null).equals(paramString))
      {
        paramContext = String.valueOf(paramContext.get(null));
        new StringBuilder(String.valueOf(paramContext).length() + 51 + String.valueOf(paramString).length()).append("Module descriptor id '").append(paramContext).append("' didn't match expected id '").append(paramString).append("'");
        AppMethodBeat.o(90426);
        return 0;
      }
      int i = ((Field)localObject).getInt(null);
      AppMethodBeat.o(90426);
      return i;
    }
    catch (ClassNotFoundException paramContext)
    {
      new StringBuilder(String.valueOf(paramString).length() + 45).append("Local module descriptor class for ").append(paramString).append(" not found.");
      AppMethodBeat.o(90426);
      return 0;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = String.valueOf(paramContext.getMessage());
        if (paramContext.length() != 0) {
          "Failed to load module descriptor class: ".concat(paramContext);
        } else {
          new String("Failed to load module descriptor class: ");
        }
      }
    }
  }
  
  public static Uri getQueryUri(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(90432);
    if (paramBoolean) {}
    for (String str = "api_force_staging";; str = "api")
    {
      paramString = Uri.parse(String.valueOf(str).length() + 42 + String.valueOf(paramString).length() + "content://com.google.android.gms.chimera/" + str + "/" + paramString);
      AppMethodBeat.o(90432);
      return paramString;
    }
  }
  
  public static int getRemoteVersion(Context paramContext, String paramString)
  {
    AppMethodBeat.i(90430);
    int i = getRemoteVersion(paramContext, paramString, false);
    AppMethodBeat.o(90430);
    return i;
  }
  
  /* Error */
  public static int getRemoteVersion(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 237
    //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 2
    //   7: monitorenter
    //   8: getstatic 239	com/google/android/gms/dynamite/DynamiteModule:zzabr	Ljava/lang/Boolean;
    //   11: astore 6
    //   13: aload 6
    //   15: astore 5
    //   17: aload 6
    //   19: ifnonnull +69 -> 88
    //   22: aload_0
    //   23: invokevirtual 129	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   26: invokevirtual 133	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   29: ldc 6
    //   31: invokevirtual 242	java/lang/Class:getName	()Ljava/lang/String;
    //   34: invokevirtual 165	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   37: astore 6
    //   39: aload 6
    //   41: ldc 244
    //   43: invokevirtual 173	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   46: astore 5
    //   48: aload 6
    //   50: monitorenter
    //   51: aload 5
    //   53: aconst_null
    //   54: invokevirtual 180	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 161	java/lang/ClassLoader
    //   60: astore 7
    //   62: aload 7
    //   64: ifnull +62 -> 126
    //   67: aload 7
    //   69: invokestatic 247	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   72: if_acmpne +41 -> 113
    //   75: getstatic 252	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   78: astore 5
    //   80: aload 6
    //   82: monitorexit
    //   83: aload 5
    //   85: putstatic 239	com/google/android/gms/dynamite/DynamiteModule:zzabr	Ljava/lang/Boolean;
    //   88: ldc 2
    //   90: monitorexit
    //   91: aload 5
    //   93: invokevirtual 256	java/lang/Boolean:booleanValue	()Z
    //   96: ifeq +284 -> 380
    //   99: aload_0
    //   100: aload_1
    //   101: iload_2
    //   102: invokestatic 258	com/google/android/gms/dynamite/DynamiteModule:zzb	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   105: istore_3
    //   106: ldc 237
    //   108: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: iload_3
    //   112: ireturn
    //   113: aload 7
    //   115: invokestatic 261	com/google/android/gms/dynamite/DynamiteModule:zza	(Ljava/lang/ClassLoader;)V
    //   118: getstatic 264	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   121: astore 5
    //   123: goto -43 -> 80
    //   126: ldc_w 266
    //   129: aload_0
    //   130: invokevirtual 129	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   133: invokevirtual 269	android/content/Context:getPackageName	()Ljava/lang/String;
    //   136: invokevirtual 270	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   139: ifeq +20 -> 159
    //   142: aload 5
    //   144: aconst_null
    //   145: invokestatic 247	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   148: invokevirtual 274	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   151: getstatic 252	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   154: astore 5
    //   156: goto -76 -> 80
    //   159: aload_0
    //   160: aload_1
    //   161: iload_2
    //   162: invokestatic 258	com/google/android/gms/dynamite/DynamiteModule:zzb	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   165: istore_3
    //   166: getstatic 276	com/google/android/gms/dynamite/DynamiteModule:zzabu	Ljava/lang/String;
    //   169: ifnull +16 -> 185
    //   172: getstatic 276	com/google/android/gms/dynamite/DynamiteModule:zzabu	Ljava/lang/String;
    //   175: invokevirtual 279	java/lang/String:isEmpty	()Z
    //   178: istore 4
    //   180: iload 4
    //   182: ifeq +16 -> 198
    //   185: aload 6
    //   187: monitorexit
    //   188: ldc 2
    //   190: monitorexit
    //   191: ldc 237
    //   193: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: iload_3
    //   197: ireturn
    //   198: new 281	com/google/android/gms/dynamite/zzh
    //   201: dup
    //   202: getstatic 276	com/google/android/gms/dynamite/DynamiteModule:zzabu	Ljava/lang/String;
    //   205: invokestatic 247	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   208: invokespecial 284	com/google/android/gms/dynamite/zzh:<init>	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   211: astore 7
    //   213: aload 7
    //   215: invokestatic 261	com/google/android/gms/dynamite/DynamiteModule:zza	(Ljava/lang/ClassLoader;)V
    //   218: aload 5
    //   220: aconst_null
    //   221: aload 7
    //   223: invokevirtual 274	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   226: getstatic 264	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   229: putstatic 239	com/google/android/gms/dynamite/DynamiteModule:zzabr	Ljava/lang/Boolean;
    //   232: aload 6
    //   234: monitorexit
    //   235: ldc 2
    //   237: monitorexit
    //   238: ldc 237
    //   240: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: iload_3
    //   244: ireturn
    //   245: astore 7
    //   247: aload 5
    //   249: aconst_null
    //   250: invokestatic 247	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   253: invokevirtual 274	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   256: getstatic 252	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   259: astore 5
    //   261: goto -181 -> 80
    //   264: astore 5
    //   266: aload 6
    //   268: monitorexit
    //   269: ldc 237
    //   271: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: aload 5
    //   276: athrow
    //   277: astore 5
    //   279: aload 5
    //   281: invokestatic 141	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   284: astore 5
    //   286: new 135	java/lang/StringBuilder
    //   289: dup
    //   290: aload 5
    //   292: invokestatic 141	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   295: invokevirtual 145	java/lang/String:length	()I
    //   298: bipush 30
    //   300: iadd
    //   301: invokespecial 147	java/lang/StringBuilder:<init>	(I)V
    //   304: ldc_w 286
    //   307: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload 5
    //   312: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: getstatic 252	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   319: astore 5
    //   321: goto -238 -> 83
    //   324: astore_0
    //   325: ldc 2
    //   327: monitorexit
    //   328: ldc 237
    //   330: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   333: aload_0
    //   334: athrow
    //   335: astore_0
    //   336: aload_0
    //   337: invokevirtual 287	com/google/android/gms/dynamite/DynamiteModule$LoadingException:getMessage	()Ljava/lang/String;
    //   340: invokestatic 141	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   343: astore_0
    //   344: aload_0
    //   345: invokevirtual 145	java/lang/String:length	()I
    //   348: ifeq +18 -> 366
    //   351: ldc_w 289
    //   354: aload_0
    //   355: invokevirtual 207	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   358: pop
    //   359: ldc 237
    //   361: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   364: iconst_0
    //   365: ireturn
    //   366: new 137	java/lang/String
    //   369: dup
    //   370: ldc_w 289
    //   373: invokespecial 210	java/lang/String:<init>	(Ljava/lang/String;)V
    //   376: pop
    //   377: goto -18 -> 359
    //   380: aload_0
    //   381: aload_1
    //   382: iload_2
    //   383: invokestatic 291	com/google/android/gms/dynamite/DynamiteModule:zza	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   386: istore_3
    //   387: ldc 237
    //   389: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   392: iload_3
    //   393: ireturn
    //   394: astore 5
    //   396: goto -278 -> 118
    //   399: astore 5
    //   401: goto -122 -> 279
    //   404: astore 5
    //   406: goto -127 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	paramContext	Context
    //   0	409	1	paramString	String
    //   0	409	2	paramBoolean	boolean
    //   105	288	3	i	int
    //   178	3	4	bool	boolean
    //   15	245	5	localObject1	Object
    //   264	11	5	localObject2	Object
    //   277	3	5	localClassNotFoundException	ClassNotFoundException
    //   284	36	5	localObject3	Object
    //   394	1	5	localLoadingException1	LoadingException
    //   399	1	5	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   404	1	5	localIllegalAccessException	IllegalAccessException
    //   11	256	6	localObject4	Object
    //   60	162	7	localObject5	Object
    //   245	1	7	localLoadingException2	LoadingException
    // Exception table:
    //   from	to	target	type
    //   159	180	245	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   198	232	245	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   51	62	264	finally
    //   67	80	264	finally
    //   80	83	264	finally
    //   113	118	264	finally
    //   118	123	264	finally
    //   126	156	264	finally
    //   159	180	264	finally
    //   185	188	264	finally
    //   198	232	264	finally
    //   232	235	264	finally
    //   247	261	264	finally
    //   266	269	264	finally
    //   22	51	277	java/lang/ClassNotFoundException
    //   269	277	277	java/lang/ClassNotFoundException
    //   8	13	324	finally
    //   22	51	324	finally
    //   83	88	324	finally
    //   88	91	324	finally
    //   188	191	324	finally
    //   235	238	324	finally
    //   269	277	324	finally
    //   279	321	324	finally
    //   325	328	324	finally
    //   99	106	335	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   113	118	394	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   22	51	399	java/lang/NoSuchFieldException
    //   269	277	399	java/lang/NoSuchFieldException
    //   22	51	404	java/lang/IllegalAccessException
    //   269	277	404	java/lang/IllegalAccessException
  }
  
  @VisibleForTesting
  public static Boolean getUseV2ForTesting()
  {
    try
    {
      Boolean localBoolean = zzabr;
      return localBoolean;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static DynamiteModule load(Context paramContext, VersionPolicy paramVersionPolicy, String paramString)
  {
    AppMethodBeat.i(90425);
    zza localzza1 = (zza)zzabv.get();
    zza localzza2 = new zza(null);
    zzabv.set(localzza2);
    DynamiteModule.VersionPolicy.SelectionResult localSelectionResult;
    try
    {
      localSelectionResult = paramVersionPolicy.selectModule(paramContext, paramString, zzabw);
      i = localSelectionResult.localVersion;
      int j = localSelectionResult.remoteVersion;
      new StringBuilder(String.valueOf(paramString).length() + 68 + String.valueOf(paramString).length()).append("Considering local module ").append(paramString).append(":").append(i).append(" and remote module ").append(paramString).append(":").append(j);
      if ((localSelectionResult.selection == 0) || ((localSelectionResult.selection == -1) && (localSelectionResult.localVersion == 0)) || ((localSelectionResult.selection == 1) && (localSelectionResult.remoteVersion == 0)))
      {
        i = localSelectionResult.localVersion;
        j = localSelectionResult.remoteVersion;
        paramContext = new LoadingException(91 + "No acceptable module found. Local version is " + i + " and remote version is " + j + ".", null);
        AppMethodBeat.o(90425);
        throw paramContext;
      }
    }
    finally
    {
      if (localzza2.zzaby != null) {
        localzza2.zzaby.close();
      }
      zzabv.set(localzza1);
      AppMethodBeat.o(90425);
    }
    if (localSelectionResult.selection == -1)
    {
      paramContext = zzd(paramContext, paramString);
      if (localzza2.zzaby != null) {
        localzza2.zzaby.close();
      }
      zzabv.set(localzza1);
      AppMethodBeat.o(90425);
      return paramContext;
    }
    int i = localSelectionResult.selection;
    if (i == 1) {
      try
      {
        DynamiteModule localDynamiteModule = zza(paramContext, paramString, localSelectionResult.remoteVersion);
        if (localzza2.zzaby != null) {
          localzza2.zzaby.close();
        }
        zzabv.set(localzza1);
        AppMethodBeat.o(90425);
        return localDynamiteModule;
      }
      catch (LoadingException localLoadingException)
      {
        String str = String.valueOf(localLoadingException.getMessage());
        if (str.length() != 0) {
          "Failed to load remote module: ".concat(str);
        }
        while ((localSelectionResult.localVersion != 0) && (paramVersionPolicy.selectModule(paramContext, paramString, new zzb(localSelectionResult.localVersion, 0)).selection == -1))
        {
          paramContext = zzd(paramContext, paramString);
          if (localzza2.zzaby != null) {
            localzza2.zzaby.close();
          }
          zzabv.set(localzza1);
          AppMethodBeat.o(90425);
          return paramContext;
          new String("Failed to load remote module: ");
        }
        paramContext = new LoadingException("Remote load failed. No local fallback found.", localLoadingException, null);
        AppMethodBeat.o(90425);
        throw paramContext;
      }
    }
    i = localSelectionResult.selection;
    paramContext = new LoadingException(47 + "VersionPolicy returned invalid code:" + i, null);
    AppMethodBeat.o(90425);
    throw paramContext;
  }
  
  public static Cursor queryForDynamiteModule(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(90431);
    paramContext = paramContext.getContentResolver().query(getQueryUri(paramString, paramBoolean), null, null, null, null);
    AppMethodBeat.o(90431);
    return paramContext;
  }
  
  /* Error */
  @VisibleForTesting
  public static void resetInternalStateForTesting()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: putstatic 385	com/google/android/gms/dynamite/DynamiteModule:zzabs	Lcom/google/android/gms/dynamite/IDynamiteLoader;
    //   7: aconst_null
    //   8: putstatic 387	com/google/android/gms/dynamite/DynamiteModule:zzabt	Lcom/google/android/gms/dynamite/IDynamiteLoaderV2;
    //   11: aconst_null
    //   12: putstatic 276	com/google/android/gms/dynamite/DynamiteModule:zzabu	Ljava/lang/String;
    //   15: aconst_null
    //   16: putstatic 239	com/google/android/gms/dynamite/DynamiteModule:zzabr	Ljava/lang/Boolean;
    //   19: ldc 6
    //   21: monitorenter
    //   22: aconst_null
    //   23: putstatic 390	com/google/android/gms/dynamite/DynamiteModule$DynamiteLoaderClassLoader:sClassLoader	Ljava/lang/ClassLoader;
    //   26: ldc 6
    //   28: monitorexit
    //   29: ldc 2
    //   31: monitorexit
    //   32: return
    //   33: astore_0
    //   34: ldc 6
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    //   39: astore_0
    //   40: ldc 2
    //   42: monitorexit
    //   43: aload_0
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   33	5	0	localObject1	Object
    //   39	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	29	33	finally
    //   34	37	33	finally
    //   3	22	39	finally
    //   37	39	39	finally
  }
  
  @VisibleForTesting
  public static void setUseV2ForTesting(Boolean paramBoolean)
  {
    try
    {
      zzabr = paramBoolean;
      return;
    }
    finally
    {
      paramBoolean = finally;
      throw paramBoolean;
    }
  }
  
  private static int zza(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(90428);
    IDynamiteLoader localIDynamiteLoader = zzg(paramContext);
    if (localIDynamiteLoader == null)
    {
      AppMethodBeat.o(90428);
      return 0;
    }
    try
    {
      int i = localIDynamiteLoader.getModuleVersion2(ObjectWrapper.wrap(paramContext), paramString, paramBoolean);
      AppMethodBeat.o(90428);
      return i;
    }
    catch (RemoteException paramContext)
    {
      paramContext = String.valueOf(paramContext.getMessage());
      if (paramContext.length() == 0) {
        break label79;
      }
    }
    "Failed to retrieve remote module version: ".concat(paramContext);
    for (;;)
    {
      AppMethodBeat.o(90428);
      return 0;
      label79:
      new String("Failed to retrieve remote module version: ");
    }
  }
  
  private static Context zza(Context paramContext, String paramString, int paramInt, Cursor paramCursor, IDynamiteLoaderV2 paramIDynamiteLoaderV2)
  {
    AppMethodBeat.i(90438);
    try
    {
      paramContext = (Context)ObjectWrapper.unwrap(paramIDynamiteLoaderV2.loadModule2(ObjectWrapper.wrap(paramContext), paramString, paramInt, ObjectWrapper.wrap(paramCursor)));
      AppMethodBeat.o(90438);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext = String.valueOf(paramContext.toString());
      if (paramContext.length() == 0) {
        break label70;
      }
    }
    "Failed to load DynamiteLoader: ".concat(paramContext);
    for (;;)
    {
      AppMethodBeat.o(90438);
      return null;
      label70:
      new String("Failed to load DynamiteLoader: ");
    }
  }
  
  private static DynamiteModule zza(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(90434);
    Boolean localBoolean;
    try
    {
      localBoolean = zzabr;
      if (localBoolean == null)
      {
        paramContext = new LoadingException("Failed to determine which loading route to use.", null);
        AppMethodBeat.o(90434);
        throw paramContext;
      }
    }
    finally
    {
      AppMethodBeat.o(90434);
    }
    if (localBoolean.booleanValue())
    {
      paramContext = zzc(paramContext, paramString, paramInt);
      AppMethodBeat.o(90434);
      return paramContext;
    }
    paramContext = zzb(paramContext, paramString, paramInt);
    AppMethodBeat.o(90434);
    return paramContext;
  }
  
  @GuardedBy("DynamiteModule.class")
  private static void zza(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(90439);
    try
    {
      zzabt = IDynamiteLoaderV2.Stub.asInterface((IBinder)paramClassLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]));
      AppMethodBeat.o(90439);
      return;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      paramClassLoader = new LoadingException("Failed to instantiate dynamite loader", paramClassLoader, null);
      AppMethodBeat.o(90439);
      throw paramClassLoader;
    }
    catch (InstantiationException paramClassLoader)
    {
      break label44;
    }
    catch (IllegalAccessException paramClassLoader)
    {
      break label44;
    }
    catch (NoSuchMethodException paramClassLoader)
    {
      break label44;
    }
    catch (InvocationTargetException paramClassLoader)
    {
      label44:
      break label44;
    }
  }
  
  /* Error */
  private static int zzb(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 465
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: iload_2
    //   9: invokestatic 467	com/google/android/gms/dynamite/DynamiteModule:queryForDynamiteModule	(Landroid/content/Context;Ljava/lang/String;Z)Landroid/database/Cursor;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnull +14 -> 28
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: invokeinterface 470 1 0
    //   25: ifne +75 -> 100
    //   28: aload_0
    //   29: astore_1
    //   30: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   33: dup
    //   34: ldc_w 472
    //   37: aconst_null
    //   38: invokespecial 339	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
    //   41: astore 4
    //   43: aload_0
    //   44: astore_1
    //   45: ldc_w 465
    //   48: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_0
    //   52: astore_1
    //   53: aload 4
    //   55: athrow
    //   56: astore 4
    //   58: aload_0
    //   59: astore_1
    //   60: aload 4
    //   62: instanceof 9
    //   65: ifeq +153 -> 218
    //   68: aload_0
    //   69: astore_1
    //   70: ldc_w 465
    //   73: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: astore_1
    //   78: aload 4
    //   80: athrow
    //   81: astore_0
    //   82: aload_1
    //   83: ifnull +9 -> 92
    //   86: aload_1
    //   87: invokeinterface 348 1 0
    //   92: ldc_w 465
    //   95: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_0
    //   99: athrow
    //   100: aload_0
    //   101: astore_1
    //   102: aload_0
    //   103: iconst_0
    //   104: invokeinterface 475 2 0
    //   109: istore_3
    //   110: aload_0
    //   111: astore 4
    //   113: iload_3
    //   114: ifle +66 -> 180
    //   117: aload_0
    //   118: astore_1
    //   119: ldc 2
    //   121: monitorenter
    //   122: aload_0
    //   123: iconst_2
    //   124: invokeinterface 479 2 0
    //   129: putstatic 276	com/google/android/gms/dynamite/DynamiteModule:zzabu	Ljava/lang/String;
    //   132: ldc 2
    //   134: monitorexit
    //   135: aload_0
    //   136: astore_1
    //   137: getstatic 66	com/google/android/gms/dynamite/DynamiteModule:zzabv	Ljava/lang/ThreadLocal;
    //   140: invokevirtual 301	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   143: checkcast 21	com/google/android/gms/dynamite/DynamiteModule$zza
    //   146: astore 5
    //   148: aload_0
    //   149: astore 4
    //   151: aload 5
    //   153: ifnull +27 -> 180
    //   156: aload_0
    //   157: astore_1
    //   158: aload_0
    //   159: astore 4
    //   161: aload 5
    //   163: getfield 343	com/google/android/gms/dynamite/DynamiteModule$zza:zzaby	Landroid/database/Cursor;
    //   166: ifnonnull +14 -> 180
    //   169: aload_0
    //   170: astore_1
    //   171: aload 5
    //   173: aload_0
    //   174: putfield 343	com/google/android/gms/dynamite/DynamiteModule$zza:zzaby	Landroid/database/Cursor;
    //   177: aconst_null
    //   178: astore 4
    //   180: aload 4
    //   182: ifnull +10 -> 192
    //   185: aload 4
    //   187: invokeinterface 348 1 0
    //   192: ldc_w 465
    //   195: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: iload_3
    //   199: ireturn
    //   200: astore 4
    //   202: ldc 2
    //   204: monitorexit
    //   205: aload_0
    //   206: astore_1
    //   207: ldc_w 465
    //   210: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: aload_0
    //   214: astore_1
    //   215: aload 4
    //   217: athrow
    //   218: aload_0
    //   219: astore_1
    //   220: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   223: dup
    //   224: ldc_w 481
    //   227: aload 4
    //   229: aconst_null
    //   230: invokespecial 365	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zza;)V
    //   233: astore 4
    //   235: aload_0
    //   236: astore_1
    //   237: ldc_w 465
    //   240: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: aload_0
    //   244: astore_1
    //   245: aload 4
    //   247: athrow
    //   248: astore_0
    //   249: aconst_null
    //   250: astore_1
    //   251: goto -169 -> 82
    //   254: astore 4
    //   256: aconst_null
    //   257: astore_0
    //   258: goto -200 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramContext	Context
    //   0	261	1	paramString	String
    //   0	261	2	paramBoolean	boolean
    //   109	90	3	i	int
    //   41	13	4	localLoadingException1	LoadingException
    //   56	23	4	localException1	Exception
    //   111	75	4	localContext	Context
    //   200	28	4	localThrowable	Throwable
    //   233	13	4	localLoadingException2	LoadingException
    //   254	1	4	localException2	Exception
    //   146	26	5	localzza	zza
    // Exception table:
    //   from	to	target	type
    //   19	28	56	java/lang/Exception
    //   30	43	56	java/lang/Exception
    //   45	51	56	java/lang/Exception
    //   53	56	56	java/lang/Exception
    //   102	110	56	java/lang/Exception
    //   119	122	56	java/lang/Exception
    //   137	148	56	java/lang/Exception
    //   161	169	56	java/lang/Exception
    //   171	177	56	java/lang/Exception
    //   207	213	56	java/lang/Exception
    //   215	218	56	java/lang/Exception
    //   19	28	81	finally
    //   30	43	81	finally
    //   45	51	81	finally
    //   53	56	81	finally
    //   60	68	81	finally
    //   70	76	81	finally
    //   78	81	81	finally
    //   102	110	81	finally
    //   119	122	81	finally
    //   137	148	81	finally
    //   161	169	81	finally
    //   171	177	81	finally
    //   207	213	81	finally
    //   215	218	81	finally
    //   220	235	81	finally
    //   237	243	81	finally
    //   245	248	81	finally
    //   122	135	200	finally
    //   202	205	200	finally
    //   6	13	248	finally
    //   6	13	254	java/lang/Exception
  }
  
  private static DynamiteModule zzb(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(90435);
    new StringBuilder(String.valueOf(paramString).length() + 51).append("Selected remote version of ").append(paramString).append(", version >= ").append(paramInt);
    IDynamiteLoader localIDynamiteLoader = zzg(paramContext);
    if (localIDynamiteLoader == null)
    {
      paramContext = new LoadingException("Failed to create IDynamiteLoader.", null);
      AppMethodBeat.o(90435);
      throw paramContext;
    }
    try
    {
      paramContext = localIDynamiteLoader.createModuleContext(ObjectWrapper.wrap(paramContext), paramString, paramInt);
      if (ObjectWrapper.unwrap(paramContext) == null)
      {
        paramContext = new LoadingException("Failed to load remote module.", null);
        AppMethodBeat.o(90435);
        throw paramContext;
      }
    }
    catch (RemoteException paramContext)
    {
      paramContext = new LoadingException("Failed to load remote module.", paramContext, null);
      AppMethodBeat.o(90435);
      throw paramContext;
    }
    paramContext = new DynamiteModule((Context)ObjectWrapper.unwrap(paramContext));
    AppMethodBeat.o(90435);
    return paramContext;
  }
  
  private static DynamiteModule zzc(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(90437);
    new StringBuilder(String.valueOf(paramString).length() + 51).append("Selected remote version of ").append(paramString).append(", version >= ").append(paramInt);
    IDynamiteLoaderV2 localIDynamiteLoaderV2;
    try
    {
      localIDynamiteLoaderV2 = zzabt;
      if (localIDynamiteLoaderV2 == null)
      {
        paramContext = new LoadingException("DynamiteLoaderV2 was not cached.", null);
        AppMethodBeat.o(90437);
        throw paramContext;
      }
    }
    finally
    {
      AppMethodBeat.o(90437);
    }
    zza localzza = (zza)zzabv.get();
    if ((localzza == null) || (localzza.zzaby == null))
    {
      paramContext = new LoadingException("No result cursor", null);
      AppMethodBeat.o(90437);
      throw paramContext;
    }
    paramContext = zza(paramContext.getApplicationContext(), paramString, paramInt, localzza.zzaby, localIDynamiteLoaderV2);
    if (paramContext == null)
    {
      paramContext = new LoadingException("Failed to get module context", null);
      AppMethodBeat.o(90437);
      throw paramContext;
    }
    paramContext = new DynamiteModule(paramContext);
    AppMethodBeat.o(90437);
    return paramContext;
  }
  
  private static DynamiteModule zzd(Context paramContext, String paramString)
  {
    AppMethodBeat.i(90433);
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      "Selected local version of ".concat(paramString);
    }
    for (;;)
    {
      paramContext = new DynamiteModule(paramContext.getApplicationContext());
      AppMethodBeat.o(90433);
      return paramContext;
      new String("Selected local version of ");
    }
  }
  
  /* Error */
  private static IDynamiteLoader zzg(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 509
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 385	com/google/android/gms/dynamite/DynamiteModule:zzabs	Lcom/google/android/gms/dynamite/IDynamiteLoader;
    //   12: ifnull +18 -> 30
    //   15: getstatic 385	com/google/android/gms/dynamite/DynamiteModule:zzabs	Lcom/google/android/gms/dynamite/IDynamiteLoader;
    //   18: astore_0
    //   19: ldc 2
    //   21: monitorexit
    //   22: ldc_w 509
    //   25: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_0
    //   29: areturn
    //   30: invokestatic 515	com/google/android/gms/common/GoogleApiAvailabilityLight:getInstance	()Lcom/google/android/gms/common/GoogleApiAvailabilityLight;
    //   33: aload_0
    //   34: invokevirtual 519	com/google/android/gms/common/GoogleApiAvailabilityLight:isGooglePlayServicesAvailable	(Landroid/content/Context;)I
    //   37: ifeq +14 -> 51
    //   40: ldc 2
    //   42: monitorexit
    //   43: ldc_w 509
    //   46: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aconst_null
    //   50: areturn
    //   51: aload_0
    //   52: ldc_w 266
    //   55: iconst_3
    //   56: invokevirtual 523	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   59: invokevirtual 133	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   62: ldc_w 525
    //   65: invokevirtual 165	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   68: invokevirtual 527	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   71: checkcast 456	android/os/IBinder
    //   74: invokestatic 532	com/google/android/gms/dynamite/IDynamiteLoader$Stub:asInterface	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamite/IDynamiteLoader;
    //   77: astore_0
    //   78: aload_0
    //   79: ifnull +42 -> 121
    //   82: aload_0
    //   83: putstatic 385	com/google/android/gms/dynamite/DynamiteModule:zzabs	Lcom/google/android/gms/dynamite/IDynamiteLoader;
    //   86: ldc 2
    //   88: monitorexit
    //   89: ldc_w 509
    //   92: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_0
    //   96: areturn
    //   97: astore_0
    //   98: aload_0
    //   99: invokevirtual 201	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   102: invokestatic 141	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 145	java/lang/String:length	()I
    //   110: ifeq +22 -> 132
    //   113: ldc_w 534
    //   116: aload_0
    //   117: invokevirtual 207	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   120: pop
    //   121: ldc 2
    //   123: monitorexit
    //   124: ldc_w 509
    //   127: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aconst_null
    //   131: areturn
    //   132: new 137	java/lang/String
    //   135: dup
    //   136: ldc_w 534
    //   139: invokespecial 210	java/lang/String:<init>	(Ljava/lang/String;)V
    //   142: pop
    //   143: goto -22 -> 121
    //   146: astore_0
    //   147: ldc 2
    //   149: monitorexit
    //   150: ldc_w 509
    //   153: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_0
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   51	78	97	java/lang/Exception
    //   82	86	97	java/lang/Exception
    //   9	22	146	finally
    //   30	43	146	finally
    //   51	78	146	finally
    //   82	86	146	finally
    //   86	89	146	finally
    //   98	121	146	finally
    //   121	124	146	finally
    //   132	143	146	finally
    //   147	150	146	finally
  }
  
  public final Context getModuleContext()
  {
    return this.zzabx;
  }
  
  public final IBinder instantiate(String paramString)
  {
    AppMethodBeat.i(90440);
    try
    {
      IBinder localIBinder = (IBinder)this.zzabx.getClassLoader().loadClass(paramString).newInstance();
      AppMethodBeat.o(90440);
      return localIBinder;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "Failed to instantiate module class: ".concat(paramString);; paramString = new String("Failed to instantiate module class: "))
      {
        paramString = new LoadingException(paramString, localClassNotFoundException, null);
        AppMethodBeat.o(90440);
        throw paramString;
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      break label33;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label33:
      break label33;
    }
  }
  
  @DynamiteApi
  public static class DynamiteLoaderClassLoader
  {
    @GuardedBy("DynamiteLoaderClassLoader.class")
    public static ClassLoader sClassLoader;
  }
  
  public static class LoadingException
    extends Exception
  {
    private LoadingException(String paramString)
    {
      super();
    }
    
    private LoadingException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  public static abstract interface VersionPolicy
  {
    public abstract SelectionResult selectModule(Context paramContext, String paramString, IVersions paramIVersions);
    
    public static abstract interface IVersions
    {
      public abstract int getLocalVersion(Context paramContext, String paramString);
      
      public abstract int getRemoteVersion(Context paramContext, String paramString, boolean paramBoolean);
    }
    
    public static class SelectionResult
    {
      public int localVersion = 0;
      public int remoteVersion = 0;
      public int selection = 0;
    }
  }
  
  static final class zza
  {
    public Cursor zzaby;
  }
  
  static final class zzb
    implements DynamiteModule.VersionPolicy.IVersions
  {
    private final int zzabz;
    private final int zzaca;
    
    public zzb(int paramInt1, int paramInt2)
    {
      this.zzabz = paramInt1;
      this.zzaca = 0;
    }
    
    public final int getLocalVersion(Context paramContext, String paramString)
    {
      return this.zzabz;
    }
    
    public final int getRemoteVersion(Context paramContext, String paramString, boolean paramBoolean)
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.dynamite.DynamiteModule
 * JD-Core Version:    0.7.0.1
 */