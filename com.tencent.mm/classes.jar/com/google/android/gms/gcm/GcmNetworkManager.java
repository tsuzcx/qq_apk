package com.google.android.gms.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.support.v4.e.a;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public class GcmNetworkManager
{
  public static final int RESULT_FAILURE = 2;
  public static final int RESULT_RESCHEDULE = 1;
  public static final int RESULT_SUCCESS = 0;
  @GuardedBy("GcmNetworkManager.class")
  private static GcmNetworkManager zzg;
  private final Context zzh;
  @GuardedBy("this")
  private final Map<String, Map<String, Boolean>> zzi;
  
  private GcmNetworkManager(Context paramContext)
  {
    AppMethodBeat.i(3612);
    this.zzi = new a();
    this.zzh = paramContext;
    AppMethodBeat.o(3612);
  }
  
  public static GcmNetworkManager getInstance(Context paramContext)
  {
    AppMethodBeat.i(3611);
    try
    {
      if (zzg == null) {
        zzg = new GcmNetworkManager(paramContext.getApplicationContext());
      }
      paramContext = zzg;
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(3611);
    }
  }
  
  private final zzn zzd()
  {
    AppMethodBeat.i(3613);
    if (GoogleCloudMessaging.zzf(this.zzh) < 5000000)
    {
      localObject = new zzo();
      AppMethodBeat.o(3613);
      return localObject;
    }
    Object localObject = new zzm(this.zzh);
    AppMethodBeat.o(3613);
    return localObject;
  }
  
  static void zzd(String paramString)
  {
    AppMethodBeat.i(3617);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("Must provide a valid tag.");
      AppMethodBeat.o(3617);
      throw paramString;
    }
    if (100 < paramString.length())
    {
      paramString = new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
      AppMethodBeat.o(3617);
      throw paramString;
    }
    AppMethodBeat.o(3617);
  }
  
  private final boolean zze(String paramString)
  {
    AppMethodBeat.i(3618);
    Preconditions.checkNotNull(paramString, "GcmTaskService must not be null.");
    Object localObject2 = this.zzh.getPackageManager();
    if (localObject2 == null)
    {
      localObject1 = Collections.emptyList();
      if (CollectionUtils.isEmpty((Collection)localObject1))
      {
        String.valueOf(paramString).concat(" is not available. This may cause the task to be lost.");
        AppMethodBeat.o(3618);
        return true;
      }
    }
    else
    {
      if (paramString != null) {}
      for (localObject1 = new Intent("com.google.android.gms.gcm.ACTION_TASK_READY").setClassName(this.zzh, paramString);; localObject1 = new Intent("com.google.android.gms.gcm.ACTION_TASK_READY").setPackage(this.zzh.getPackageName()))
      {
        localObject1 = ((PackageManager)localObject2).queryIntentServices((Intent)localObject1, 0);
        break;
      }
    }
    Object localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ResolveInfo)((Iterator)localObject1).next();
      if ((((ResolveInfo)localObject2).serviceInfo != null) && (((ResolveInfo)localObject2).serviceInfo.enabled))
      {
        AppMethodBeat.o(3618);
        return true;
      }
    }
    paramString = new IllegalArgumentException(String.valueOf(paramString).length() + 118 + "The GcmTaskService class you provided " + paramString + " does not seem to support receiving com.google.android.gms.gcm.ACTION_TASK_READY");
    AppMethodBeat.o(3618);
    throw paramString;
  }
  
  public void cancelAllTasks(Class<? extends GcmTaskService> paramClass)
  {
    AppMethodBeat.i(3616);
    paramClass = new ComponentName(this.zzh, paramClass);
    zze(paramClass.getClassName());
    zzd().zzd(paramClass);
    AppMethodBeat.o(3616);
  }
  
  public void cancelTask(String paramString, Class<? extends GcmTaskService> paramClass)
  {
    AppMethodBeat.i(3615);
    paramClass = new ComponentName(this.zzh, paramClass);
    zzd(paramString);
    zze(paramClass.getClassName());
    zzd().zzd(paramClass, paramString);
    AppMethodBeat.o(3615);
  }
  
  public void schedule(Task paramTask)
  {
    try
    {
      AppMethodBeat.i(3614);
      zze(paramTask.getServiceName());
      if (zzd().zzd(paramTask))
      {
        Map localMap = (Map)this.zzi.get(paramTask.getServiceName());
        if ((localMap != null) && (localMap.containsKey(paramTask.getTag()))) {
          localMap.put(paramTask.getTag(), Boolean.TRUE);
        }
      }
      AppMethodBeat.o(3614);
      return;
    }
    finally {}
  }
  
  /* Error */
  final boolean zzd(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 3619
    //   5: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 38	com/google/android/gms/gcm/GcmNetworkManager:zzi	Ljava/util/Map;
    //   12: aload_2
    //   13: invokeinterface 238 2 0
    //   18: checkcast 234	java/util/Map
    //   21: astore 5
    //   23: aload 5
    //   25: astore 4
    //   27: aload 5
    //   29: ifnonnull +25 -> 54
    //   32: new 35	android/support/v4/e/a
    //   35: dup
    //   36: invokespecial 36	android/support/v4/e/a:<init>	()V
    //   39: astore 4
    //   41: aload_0
    //   42: getfield 38	com/google/android/gms/gcm/GcmNetworkManager:zzi	Ljava/util/Map;
    //   45: aload_2
    //   46: aload 4
    //   48: invokeinterface 254 3 0
    //   53: pop
    //   54: aload 4
    //   56: aload_1
    //   57: getstatic 258	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   60: invokeinterface 254 3 0
    //   65: ifnonnull +15 -> 80
    //   68: iconst_1
    //   69: istore_3
    //   70: sipush 3619
    //   73: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: monitorexit
    //   78: iload_3
    //   79: ireturn
    //   80: iconst_0
    //   81: istore_3
    //   82: sipush 3619
    //   85: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: goto -12 -> 76
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	GcmNetworkManager
    //   0	96	1	paramString1	String
    //   0	96	2	paramString2	String
    //   69	13	3	bool	boolean
    //   25	30	4	localObject	Object
    //   21	7	5	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   2	23	91	finally
    //   32	54	91	finally
    //   54	68	91	finally
    //   70	76	91	finally
    //   82	88	91	finally
  }
  
  /* Error */
  final void zze(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 3620
    //   5: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 38	com/google/android/gms/gcm/GcmNetworkManager:zzi	Ljava/util/Map;
    //   12: aload_2
    //   13: invokeinterface 238 2 0
    //   18: checkcast 234	java/util/Map
    //   21: astore 4
    //   23: aload 4
    //   25: ifnull +41 -> 66
    //   28: aload 4
    //   30: aload_1
    //   31: invokeinterface 262 2 0
    //   36: ifnull +39 -> 75
    //   39: iconst_1
    //   40: istore_3
    //   41: iload_3
    //   42: ifeq +24 -> 66
    //   45: aload 4
    //   47: invokeinterface 264 1 0
    //   52: ifeq +14 -> 66
    //   55: aload_0
    //   56: getfield 38	com/google/android/gms/gcm/GcmNetworkManager:zzi	Ljava/util/Map;
    //   59: aload_2
    //   60: invokeinterface 262 2 0
    //   65: pop
    //   66: sipush 3620
    //   69: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: iconst_0
    //   76: istore_3
    //   77: goto -36 -> 41
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	GcmNetworkManager
    //   0	85	1	paramString1	String
    //   0	85	2	paramString2	String
    //   40	37	3	i	int
    //   21	25	4	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   2	23	80	finally
    //   28	39	80	finally
    //   45	66	80	finally
    //   66	72	80	finally
  }
  
  final boolean zzf(String paramString)
  {
    try
    {
      AppMethodBeat.i(3622);
      boolean bool = this.zzi.containsKey(paramString);
      AppMethodBeat.o(3622);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  final boolean zzf(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(3621);
        paramString2 = (Map)this.zzi.get(paramString2);
        if (paramString2 != null)
        {
          paramString1 = (Boolean)paramString2.get(paramString1);
          if (paramString1 == null)
          {
            AppMethodBeat.o(3621);
            bool = false;
            return bool;
          }
          bool = paramString1.booleanValue();
          AppMethodBeat.o(3621);
          continue;
        }
        AppMethodBeat.o(3621);
      }
      finally {}
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmNetworkManager
 * JD-Core Version:    0.7.0.1
 */