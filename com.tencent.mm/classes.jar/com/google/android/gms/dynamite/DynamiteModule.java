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
    AppMethodBeat.i(5463);
    zzabv = new ThreadLocal();
    zzabw = new zza();
    PREFER_REMOTE = new zzb();
    PREFER_LOCAL = new zzc();
    PREFER_HIGHEST_OR_LOCAL_VERSION = new zzd();
    PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zze();
    PREFER_HIGHEST_OR_REMOTE_VERSION = new zzf();
    PREFER_HIGHEST_OR_REMOTE_VERSION_NO_FORCE_STAGING = new zzg();
    AppMethodBeat.o(5463);
  }
  
  private DynamiteModule(Context paramContext)
  {
    AppMethodBeat.i(5462);
    this.zzabx = ((Context)Preconditions.checkNotNull(paramContext));
    AppMethodBeat.o(5462);
  }
  
  public static int getLocalVersion(Context paramContext, String paramString)
  {
    AppMethodBeat.i(5447);
    try
    {
      Object localObject = paramContext.getApplicationContext().getClassLoader().loadClass(String.valueOf(paramString).length() + 61 + "com.google.android.gms.dynamite.descriptors." + paramString + ".ModuleDescriptor");
      paramContext = ((Class)localObject).getDeclaredField("MODULE_ID");
      localObject = ((Class)localObject).getDeclaredField("MODULE_VERSION");
      if (!paramContext.get(null).equals(paramString))
      {
        paramContext = String.valueOf(paramContext.get(null));
        new StringBuilder(String.valueOf(paramContext).length() + 51 + String.valueOf(paramString).length()).append("Module descriptor id '").append(paramContext).append("' didn't match expected id '").append(paramString).append("'");
        AppMethodBeat.o(5447);
        return 0;
      }
      int i = ((Field)localObject).getInt(null);
      AppMethodBeat.o(5447);
      return i;
    }
    catch (ClassNotFoundException paramContext)
    {
      new StringBuilder(String.valueOf(paramString).length() + 45).append("Local module descriptor class for ").append(paramString).append(" not found.");
      AppMethodBeat.o(5447);
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
    AppMethodBeat.i(5453);
    if (paramBoolean) {}
    for (String str = "api_force_staging";; str = "api")
    {
      paramString = Uri.parse(String.valueOf(str).length() + 42 + String.valueOf(paramString).length() + "content://com.google.android.gms.chimera/" + str + "/" + paramString);
      AppMethodBeat.o(5453);
      return paramString;
    }
  }
  
  public static int getRemoteVersion(Context paramContext, String paramString)
  {
    AppMethodBeat.i(5451);
    int i = getRemoteVersion(paramContext, paramString, false);
    AppMethodBeat.o(5451);
    return i;
  }
  
  /* Error */
  public static int getRemoteVersion(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 5448
    //   3: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 233	com/google/android/gms/dynamite/DynamiteModule:zzabr	Ljava/lang/Boolean;
    //   12: astore 6
    //   14: aload 6
    //   16: astore 5
    //   18: aload 6
    //   20: ifnonnull +69 -> 89
    //   23: aload_0
    //   24: invokevirtual 126	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   27: invokevirtual 130	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   30: ldc 6
    //   32: invokevirtual 236	java/lang/Class:getName	()Ljava/lang/String;
    //   35: invokevirtual 162	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   38: astore 6
    //   40: aload 6
    //   42: ldc 238
    //   44: invokevirtual 170	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   47: astore 5
    //   49: aload 6
    //   51: monitorenter
    //   52: aload 5
    //   54: aconst_null
    //   55: invokevirtual 177	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: checkcast 158	java/lang/ClassLoader
    //   61: astore 7
    //   63: aload 7
    //   65: ifnull +63 -> 128
    //   68: aload 7
    //   70: invokestatic 241	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   73: if_acmpne +42 -> 115
    //   76: getstatic 246	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   79: astore 5
    //   81: aload 6
    //   83: monitorexit
    //   84: aload 5
    //   86: putstatic 233	com/google/android/gms/dynamite/DynamiteModule:zzabr	Ljava/lang/Boolean;
    //   89: ldc 2
    //   91: monitorexit
    //   92: aload 5
    //   94: invokevirtual 250	java/lang/Boolean:booleanValue	()Z
    //   97: ifeq +290 -> 387
    //   100: aload_0
    //   101: aload_1
    //   102: iload_2
    //   103: invokestatic 252	com/google/android/gms/dynamite/DynamiteModule:zzb	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   106: istore_3
    //   107: sipush 5448
    //   110: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: iload_3
    //   114: ireturn
    //   115: aload 7
    //   117: invokestatic 255	com/google/android/gms/dynamite/DynamiteModule:zza	(Ljava/lang/ClassLoader;)V
    //   120: getstatic 258	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   123: astore 5
    //   125: goto -44 -> 81
    //   128: ldc_w 260
    //   131: aload_0
    //   132: invokevirtual 126	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   135: invokevirtual 263	android/content/Context:getPackageName	()Ljava/lang/String;
    //   138: invokevirtual 264	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   141: ifeq +20 -> 161
    //   144: aload 5
    //   146: aconst_null
    //   147: invokestatic 241	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   150: invokevirtual 268	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   153: getstatic 246	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   156: astore 5
    //   158: goto -77 -> 81
    //   161: aload_0
    //   162: aload_1
    //   163: iload_2
    //   164: invokestatic 252	com/google/android/gms/dynamite/DynamiteModule:zzb	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   167: istore_3
    //   168: getstatic 270	com/google/android/gms/dynamite/DynamiteModule:zzabu	Ljava/lang/String;
    //   171: ifnull +16 -> 187
    //   174: getstatic 270	com/google/android/gms/dynamite/DynamiteModule:zzabu	Ljava/lang/String;
    //   177: invokevirtual 273	java/lang/String:isEmpty	()Z
    //   180: istore 4
    //   182: iload 4
    //   184: ifeq +17 -> 201
    //   187: aload 6
    //   189: monitorexit
    //   190: ldc 2
    //   192: monitorexit
    //   193: sipush 5448
    //   196: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: iload_3
    //   200: ireturn
    //   201: new 275	com/google/android/gms/dynamite/zzh
    //   204: dup
    //   205: getstatic 270	com/google/android/gms/dynamite/DynamiteModule:zzabu	Ljava/lang/String;
    //   208: invokestatic 241	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   211: invokespecial 278	com/google/android/gms/dynamite/zzh:<init>	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   214: astore 7
    //   216: aload 7
    //   218: invokestatic 255	com/google/android/gms/dynamite/DynamiteModule:zza	(Ljava/lang/ClassLoader;)V
    //   221: aload 5
    //   223: aconst_null
    //   224: aload 7
    //   226: invokevirtual 268	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   229: getstatic 258	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   232: putstatic 233	com/google/android/gms/dynamite/DynamiteModule:zzabr	Ljava/lang/Boolean;
    //   235: aload 6
    //   237: monitorexit
    //   238: ldc 2
    //   240: monitorexit
    //   241: sipush 5448
    //   244: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: iload_3
    //   248: ireturn
    //   249: astore 7
    //   251: aload 5
    //   253: aconst_null
    //   254: invokestatic 241	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   257: invokevirtual 268	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   260: getstatic 246	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   263: astore 5
    //   265: goto -184 -> 81
    //   268: astore 5
    //   270: aload 6
    //   272: monitorexit
    //   273: sipush 5448
    //   276: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: aload 5
    //   281: athrow
    //   282: astore 5
    //   284: aload 5
    //   286: invokestatic 138	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   289: astore 5
    //   291: new 132	java/lang/StringBuilder
    //   294: dup
    //   295: aload 5
    //   297: invokestatic 138	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   300: invokevirtual 142	java/lang/String:length	()I
    //   303: bipush 30
    //   305: iadd
    //   306: invokespecial 144	java/lang/StringBuilder:<init>	(I)V
    //   309: ldc_w 280
    //   312: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 5
    //   317: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: getstatic 246	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   324: astore 5
    //   326: goto -242 -> 84
    //   329: astore_0
    //   330: ldc 2
    //   332: monitorexit
    //   333: sipush 5448
    //   336: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: aload_0
    //   340: athrow
    //   341: astore_0
    //   342: aload_0
    //   343: invokevirtual 281	com/google/android/gms/dynamite/DynamiteModule$LoadingException:getMessage	()Ljava/lang/String;
    //   346: invokestatic 138	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   349: astore_0
    //   350: aload_0
    //   351: invokevirtual 142	java/lang/String:length	()I
    //   354: ifeq +19 -> 373
    //   357: ldc_w 283
    //   360: aload_0
    //   361: invokevirtual 204	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   364: pop
    //   365: sipush 5448
    //   368: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   371: iconst_0
    //   372: ireturn
    //   373: new 134	java/lang/String
    //   376: dup
    //   377: ldc_w 283
    //   380: invokespecial 207	java/lang/String:<init>	(Ljava/lang/String;)V
    //   383: pop
    //   384: goto -19 -> 365
    //   387: aload_0
    //   388: aload_1
    //   389: iload_2
    //   390: invokestatic 285	com/google/android/gms/dynamite/DynamiteModule:zza	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   393: istore_3
    //   394: sipush 5448
    //   397: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   400: iload_3
    //   401: ireturn
    //   402: astore 5
    //   404: goto -284 -> 120
    //   407: astore 5
    //   409: goto -125 -> 284
    //   412: astore 5
    //   414: goto -130 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	paramContext	Context
    //   0	417	1	paramString	String
    //   0	417	2	paramBoolean	boolean
    //   106	295	3	i	int
    //   180	3	4	bool	boolean
    //   16	248	5	localObject1	Object
    //   268	12	5	localObject2	Object
    //   282	3	5	localClassNotFoundException	ClassNotFoundException
    //   289	36	5	localObject3	Object
    //   402	1	5	localLoadingException1	LoadingException
    //   407	1	5	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   412	1	5	localIllegalAccessException	IllegalAccessException
    //   12	259	6	localObject4	Object
    //   61	164	7	localObject5	Object
    //   249	1	7	localLoadingException2	LoadingException
    // Exception table:
    //   from	to	target	type
    //   161	182	249	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   201	235	249	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   52	63	268	finally
    //   68	81	268	finally
    //   81	84	268	finally
    //   115	120	268	finally
    //   120	125	268	finally
    //   128	158	268	finally
    //   161	182	268	finally
    //   187	190	268	finally
    //   201	235	268	finally
    //   235	238	268	finally
    //   251	265	268	finally
    //   270	273	268	finally
    //   23	52	282	java/lang/ClassNotFoundException
    //   273	282	282	java/lang/ClassNotFoundException
    //   9	14	329	finally
    //   23	52	329	finally
    //   84	89	329	finally
    //   89	92	329	finally
    //   190	193	329	finally
    //   238	241	329	finally
    //   273	282	329	finally
    //   284	326	329	finally
    //   330	333	329	finally
    //   100	107	341	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   115	120	402	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   23	52	407	java/lang/NoSuchFieldException
    //   273	282	407	java/lang/NoSuchFieldException
    //   23	52	412	java/lang/IllegalAccessException
    //   273	282	412	java/lang/IllegalAccessException
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
    AppMethodBeat.i(5446);
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
        AppMethodBeat.o(5446);
        throw paramContext;
      }
    }
    finally
    {
      if (localzza2.zzaby != null) {
        localzza2.zzaby.close();
      }
      zzabv.set(localzza1);
      AppMethodBeat.o(5446);
    }
    if (localSelectionResult.selection == -1)
    {
      paramContext = zzd(paramContext, paramString);
      if (localzza2.zzaby != null) {
        localzza2.zzaby.close();
      }
      zzabv.set(localzza1);
      AppMethodBeat.o(5446);
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
        AppMethodBeat.o(5446);
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
          AppMethodBeat.o(5446);
          return paramContext;
          new String("Failed to load remote module: ");
        }
        paramContext = new LoadingException("Remote load failed. No local fallback found.", localLoadingException, null);
        AppMethodBeat.o(5446);
        throw paramContext;
      }
    }
    i = localSelectionResult.selection;
    paramContext = new LoadingException(47 + "VersionPolicy returned invalid code:" + i, null);
    AppMethodBeat.o(5446);
    throw paramContext;
  }
  
  public static Cursor queryForDynamiteModule(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(5452);
    paramContext = paramContext.getContentResolver().query(getQueryUri(paramString, paramBoolean), null, null, null, null);
    AppMethodBeat.o(5452);
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
    //   4: putstatic 377	com/google/android/gms/dynamite/DynamiteModule:zzabs	Lcom/google/android/gms/dynamite/IDynamiteLoader;
    //   7: aconst_null
    //   8: putstatic 379	com/google/android/gms/dynamite/DynamiteModule:zzabt	Lcom/google/android/gms/dynamite/IDynamiteLoaderV2;
    //   11: aconst_null
    //   12: putstatic 270	com/google/android/gms/dynamite/DynamiteModule:zzabu	Ljava/lang/String;
    //   15: aconst_null
    //   16: putstatic 233	com/google/android/gms/dynamite/DynamiteModule:zzabr	Ljava/lang/Boolean;
    //   19: ldc 6
    //   21: monitorenter
    //   22: aconst_null
    //   23: putstatic 382	com/google/android/gms/dynamite/DynamiteModule$DynamiteLoaderClassLoader:sClassLoader	Ljava/lang/ClassLoader;
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
    AppMethodBeat.i(5449);
    IDynamiteLoader localIDynamiteLoader = zzg(paramContext);
    if (localIDynamiteLoader == null)
    {
      AppMethodBeat.o(5449);
      return 0;
    }
    try
    {
      int i = localIDynamiteLoader.getModuleVersion2(ObjectWrapper.wrap(paramContext), paramString, paramBoolean);
      AppMethodBeat.o(5449);
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
      AppMethodBeat.o(5449);
      return 0;
      label79:
      new String("Failed to retrieve remote module version: ");
    }
  }
  
  private static Context zza(Context paramContext, String paramString, int paramInt, Cursor paramCursor, IDynamiteLoaderV2 paramIDynamiteLoaderV2)
  {
    AppMethodBeat.i(5459);
    try
    {
      paramContext = (Context)ObjectWrapper.unwrap(paramIDynamiteLoaderV2.loadModule2(ObjectWrapper.wrap(paramContext), paramString, paramInt, ObjectWrapper.wrap(paramCursor)));
      AppMethodBeat.o(5459);
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
      AppMethodBeat.o(5459);
      return null;
      label70:
      new String("Failed to load DynamiteLoader: ");
    }
  }
  
  private static DynamiteModule zza(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(5455);
    Boolean localBoolean;
    try
    {
      localBoolean = zzabr;
      if (localBoolean == null)
      {
        paramContext = new LoadingException("Failed to determine which loading route to use.", null);
        AppMethodBeat.o(5455);
        throw paramContext;
      }
    }
    finally
    {
      AppMethodBeat.o(5455);
    }
    if (localBoolean.booleanValue())
    {
      paramContext = zzc(paramContext, paramString, paramInt);
      AppMethodBeat.o(5455);
      return paramContext;
    }
    paramContext = zzb(paramContext, paramString, paramInt);
    AppMethodBeat.o(5455);
    return paramContext;
  }
  
  @GuardedBy("DynamiteModule.class")
  private static void zza(ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(5460);
    try
    {
      zzabt = IDynamiteLoaderV2.Stub.asInterface((IBinder)paramClassLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]));
      AppMethodBeat.o(5460);
      return;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      paramClassLoader = new LoadingException("Failed to instantiate dynamite loader", paramClassLoader, null);
      AppMethodBeat.o(5460);
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
    //   0: sipush 5450
    //   3: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: iload_2
    //   9: invokestatic 454	com/google/android/gms/dynamite/DynamiteModule:queryForDynamiteModule	(Landroid/content/Context;Ljava/lang/String;Z)Landroid/database/Cursor;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnull +14 -> 28
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: invokeinterface 457 1 0
    //   25: ifne +75 -> 100
    //   28: aload_0
    //   29: astore_1
    //   30: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   33: dup
    //   34: ldc_w 459
    //   37: aconst_null
    //   38: invokespecial 332	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
    //   41: astore 4
    //   43: aload_0
    //   44: astore_1
    //   45: sipush 5450
    //   48: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   70: sipush 5450
    //   73: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: astore_1
    //   78: aload 4
    //   80: athrow
    //   81: astore_0
    //   82: aload_1
    //   83: ifnull +9 -> 92
    //   86: aload_1
    //   87: invokeinterface 341 1 0
    //   92: sipush 5450
    //   95: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_0
    //   99: athrow
    //   100: aload_0
    //   101: astore_1
    //   102: aload_0
    //   103: iconst_0
    //   104: invokeinterface 462 2 0
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
    //   124: invokeinterface 466 2 0
    //   129: putstatic 270	com/google/android/gms/dynamite/DynamiteModule:zzabu	Ljava/lang/String;
    //   132: ldc 2
    //   134: monitorexit
    //   135: aload_0
    //   136: astore_1
    //   137: getstatic 65	com/google/android/gms/dynamite/DynamiteModule:zzabv	Ljava/lang/ThreadLocal;
    //   140: invokevirtual 294	java/lang/ThreadLocal:get	()Ljava/lang/Object;
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
    //   163: getfield 336	com/google/android/gms/dynamite/DynamiteModule$zza:zzaby	Landroid/database/Cursor;
    //   166: ifnonnull +14 -> 180
    //   169: aload_0
    //   170: astore_1
    //   171: aload 5
    //   173: aload_0
    //   174: putfield 336	com/google/android/gms/dynamite/DynamiteModule$zza:zzaby	Landroid/database/Cursor;
    //   177: aconst_null
    //   178: astore 4
    //   180: aload 4
    //   182: ifnull +10 -> 192
    //   185: aload 4
    //   187: invokeinterface 341 1 0
    //   192: sipush 5450
    //   195: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: iload_3
    //   199: ireturn
    //   200: astore 4
    //   202: ldc 2
    //   204: monitorexit
    //   205: aload_0
    //   206: astore_1
    //   207: sipush 5450
    //   210: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: aload_0
    //   214: astore_1
    //   215: aload 4
    //   217: athrow
    //   218: aload_0
    //   219: astore_1
    //   220: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   223: dup
    //   224: ldc_w 468
    //   227: aload 4
    //   229: aconst_null
    //   230: invokespecial 358	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zza;)V
    //   233: astore 4
    //   235: aload_0
    //   236: astore_1
    //   237: sipush 5450
    //   240: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(5456);
    new StringBuilder(String.valueOf(paramString).length() + 51).append("Selected remote version of ").append(paramString).append(", version >= ").append(paramInt);
    IDynamiteLoader localIDynamiteLoader = zzg(paramContext);
    if (localIDynamiteLoader == null)
    {
      paramContext = new LoadingException("Failed to create IDynamiteLoader.", null);
      AppMethodBeat.o(5456);
      throw paramContext;
    }
    try
    {
      paramContext = localIDynamiteLoader.createModuleContext(ObjectWrapper.wrap(paramContext), paramString, paramInt);
      if (ObjectWrapper.unwrap(paramContext) == null)
      {
        paramContext = new LoadingException("Failed to load remote module.", null);
        AppMethodBeat.o(5456);
        throw paramContext;
      }
    }
    catch (RemoteException paramContext)
    {
      paramContext = new LoadingException("Failed to load remote module.", paramContext, null);
      AppMethodBeat.o(5456);
      throw paramContext;
    }
    paramContext = new DynamiteModule((Context)ObjectWrapper.unwrap(paramContext));
    AppMethodBeat.o(5456);
    return paramContext;
  }
  
  private static DynamiteModule zzc(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(5458);
    new StringBuilder(String.valueOf(paramString).length() + 51).append("Selected remote version of ").append(paramString).append(", version >= ").append(paramInt);
    IDynamiteLoaderV2 localIDynamiteLoaderV2;
    try
    {
      localIDynamiteLoaderV2 = zzabt;
      if (localIDynamiteLoaderV2 == null)
      {
        paramContext = new LoadingException("DynamiteLoaderV2 was not cached.", null);
        AppMethodBeat.o(5458);
        throw paramContext;
      }
    }
    finally
    {
      AppMethodBeat.o(5458);
    }
    zza localzza = (zza)zzabv.get();
    if ((localzza == null) || (localzza.zzaby == null))
    {
      paramContext = new LoadingException("No result cursor", null);
      AppMethodBeat.o(5458);
      throw paramContext;
    }
    paramContext = zza(paramContext.getApplicationContext(), paramString, paramInt, localzza.zzaby, localIDynamiteLoaderV2);
    if (paramContext == null)
    {
      paramContext = new LoadingException("Failed to get module context", null);
      AppMethodBeat.o(5458);
      throw paramContext;
    }
    paramContext = new DynamiteModule(paramContext);
    AppMethodBeat.o(5458);
    return paramContext;
  }
  
  private static DynamiteModule zzd(Context paramContext, String paramString)
  {
    AppMethodBeat.i(5454);
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      "Selected local version of ".concat(paramString);
    }
    for (;;)
    {
      paramContext = new DynamiteModule(paramContext.getApplicationContext());
      AppMethodBeat.o(5454);
      return paramContext;
      new String("Selected local version of ");
    }
  }
  
  /* Error */
  private static IDynamiteLoader zzg(Context paramContext)
  {
    // Byte code:
    //   0: sipush 5457
    //   3: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 377	com/google/android/gms/dynamite/DynamiteModule:zzabs	Lcom/google/android/gms/dynamite/IDynamiteLoader;
    //   12: ifnull +18 -> 30
    //   15: getstatic 377	com/google/android/gms/dynamite/DynamiteModule:zzabs	Lcom/google/android/gms/dynamite/IDynamiteLoader;
    //   18: astore_0
    //   19: ldc 2
    //   21: monitorexit
    //   22: sipush 5457
    //   25: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_0
    //   29: areturn
    //   30: invokestatic 498	com/google/android/gms/common/GoogleApiAvailabilityLight:getInstance	()Lcom/google/android/gms/common/GoogleApiAvailabilityLight;
    //   33: aload_0
    //   34: invokevirtual 502	com/google/android/gms/common/GoogleApiAvailabilityLight:isGooglePlayServicesAvailable	(Landroid/content/Context;)I
    //   37: ifeq +14 -> 51
    //   40: ldc 2
    //   42: monitorexit
    //   43: sipush 5457
    //   46: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aconst_null
    //   50: areturn
    //   51: aload_0
    //   52: ldc_w 260
    //   55: iconst_3
    //   56: invokevirtual 506	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   59: invokevirtual 130	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   62: ldc_w 508
    //   65: invokevirtual 162	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   68: invokevirtual 510	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   71: checkcast 444	android/os/IBinder
    //   74: invokestatic 515	com/google/android/gms/dynamite/IDynamiteLoader$Stub:asInterface	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamite/IDynamiteLoader;
    //   77: astore_0
    //   78: aload_0
    //   79: ifnull +42 -> 121
    //   82: aload_0
    //   83: putstatic 377	com/google/android/gms/dynamite/DynamiteModule:zzabs	Lcom/google/android/gms/dynamite/IDynamiteLoader;
    //   86: ldc 2
    //   88: monitorexit
    //   89: sipush 5457
    //   92: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_0
    //   96: areturn
    //   97: astore_0
    //   98: aload_0
    //   99: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   102: invokestatic 138	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 142	java/lang/String:length	()I
    //   110: ifeq +22 -> 132
    //   113: ldc_w 517
    //   116: aload_0
    //   117: invokevirtual 204	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   120: pop
    //   121: ldc 2
    //   123: monitorexit
    //   124: sipush 5457
    //   127: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aconst_null
    //   131: areturn
    //   132: new 134	java/lang/String
    //   135: dup
    //   136: ldc_w 517
    //   139: invokespecial 207	java/lang/String:<init>	(Ljava/lang/String;)V
    //   142: pop
    //   143: goto -22 -> 121
    //   146: astore_0
    //   147: ldc 2
    //   149: monitorexit
    //   150: sipush 5457
    //   153: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(5461);
    try
    {
      IBinder localIBinder = (IBinder)this.zzabx.getClassLoader().loadClass(paramString).newInstance();
      AppMethodBeat.o(5461);
      return localIBinder;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "Failed to instantiate module class: ".concat(paramString);; paramString = new String("Failed to instantiate module class: "))
      {
        paramString = new LoadingException(paramString, localClassNotFoundException, null);
        AppMethodBeat.o(5461);
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