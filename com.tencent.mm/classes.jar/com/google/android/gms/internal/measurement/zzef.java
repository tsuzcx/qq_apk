package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzef
  extends zzhg
{
  private zzeh zzaet = zzeg.zzaeu;
  private Boolean zzxz;
  
  zzef(zzgl paramzzgl)
  {
    super(paramzzgl);
  }
  
  public static long zzhh()
  {
    AppMethodBeat.i(68604);
    long l = ((Long)zzew.zzahl.get()).longValue();
    AppMethodBeat.o(68604);
    return l;
  }
  
  public static long zzhi()
  {
    AppMethodBeat.i(68605);
    long l = ((Long)zzew.zzagl.get()).longValue();
    AppMethodBeat.o(68605);
    return l;
  }
  
  public static boolean zzhk()
  {
    AppMethodBeat.i(68607);
    boolean bool = ((Boolean)zzew.zzagh.get()).booleanValue();
    AppMethodBeat.o(68607);
    return bool;
  }
  
  public final long zza(String paramString, zzex<Long> paramzzex)
  {
    AppMethodBeat.i(68598);
    long l;
    if (paramString == null)
    {
      l = ((Long)paramzzex.get()).longValue();
      AppMethodBeat.o(68598);
      return l;
    }
    paramString = this.zzaet.zze(paramString, paramzzex.getKey());
    if (TextUtils.isEmpty(paramString))
    {
      l = ((Long)paramzzex.get()).longValue();
      AppMethodBeat.o(68598);
      return l;
    }
    try
    {
      l = ((Long)paramzzex.get(Long.valueOf(Long.parseLong(paramString)))).longValue();
      AppMethodBeat.o(68598);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      l = ((Long)paramzzex.get()).longValue();
      AppMethodBeat.o(68598);
    }
    return l;
  }
  
  final void zza(zzeh paramzzeh)
  {
    this.zzaet = paramzzeh;
  }
  
  public final int zzar(String paramString)
  {
    AppMethodBeat.i(68596);
    int i = zzb(paramString, zzew.zzagw);
    AppMethodBeat.o(68596);
    return i;
  }
  
  @VisibleForTesting
  final Boolean zzas(String paramString)
  {
    AppMethodBeat.i(68602);
    Preconditions.checkNotEmpty(paramString);
    try
    {
      if (getContext().getPackageManager() == null)
      {
        zzge().zzim().log("Failed to load metadata: PackageManager is null");
        AppMethodBeat.o(68602);
        return null;
      }
      ApplicationInfo localApplicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
      if (localApplicationInfo == null)
      {
        zzge().zzim().log("Failed to load metadata: ApplicationInfo is null");
        AppMethodBeat.o(68602);
        return null;
      }
      if (localApplicationInfo.metaData == null)
      {
        zzge().zzim().log("Failed to load metadata: Metadata bundle is null");
        AppMethodBeat.o(68602);
        return null;
      }
      boolean bool = localApplicationInfo.metaData.containsKey(paramString);
      if (!bool)
      {
        AppMethodBeat.o(68602);
        return null;
      }
      bool = localApplicationInfo.metaData.getBoolean(paramString);
      AppMethodBeat.o(68602);
      return Boolean.valueOf(bool);
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      zzge().zzim().zzg("Failed to load metadata: Package name not found", paramString);
      AppMethodBeat.o(68602);
    }
    return null;
  }
  
  public final boolean zzat(String paramString)
  {
    AppMethodBeat.i(68608);
    boolean bool = "1".equals(this.zzaet.zze(paramString, "gaia_collection_enabled"));
    AppMethodBeat.o(68608);
    return bool;
  }
  
  public final boolean zzau(String paramString)
  {
    AppMethodBeat.i(68609);
    boolean bool = "1".equals(this.zzaet.zze(paramString, "measurement.event_sampling_enabled"));
    AppMethodBeat.o(68609);
    return bool;
  }
  
  final boolean zzav(String paramString)
  {
    AppMethodBeat.i(68610);
    boolean bool = zzd(paramString, zzew.zzahu);
    AppMethodBeat.o(68610);
    return bool;
  }
  
  final boolean zzaw(String paramString)
  {
    AppMethodBeat.i(68611);
    boolean bool = zzd(paramString, zzew.zzahw);
    AppMethodBeat.o(68611);
    return bool;
  }
  
  final boolean zzax(String paramString)
  {
    AppMethodBeat.i(68612);
    boolean bool = zzd(paramString, zzew.zzahx);
    AppMethodBeat.o(68612);
    return bool;
  }
  
  final boolean zzay(String paramString)
  {
    AppMethodBeat.i(68615);
    boolean bool = zzd(paramString, zzew.zzahy);
    AppMethodBeat.o(68615);
    return bool;
  }
  
  final boolean zzaz(String paramString)
  {
    AppMethodBeat.i(68616);
    boolean bool = zzd(paramString, zzew.zzahz);
    AppMethodBeat.o(68616);
    return bool;
  }
  
  public final int zzb(String paramString, zzex<Integer> paramzzex)
  {
    AppMethodBeat.i(68599);
    int i;
    if (paramString == null)
    {
      i = ((Integer)paramzzex.get()).intValue();
      AppMethodBeat.o(68599);
      return i;
    }
    paramString = this.zzaet.zze(paramString, paramzzex.getKey());
    if (TextUtils.isEmpty(paramString))
    {
      i = ((Integer)paramzzex.get()).intValue();
      AppMethodBeat.o(68599);
      return i;
    }
    try
    {
      i = ((Integer)paramzzex.get(Integer.valueOf(Integer.parseInt(paramString)))).intValue();
      AppMethodBeat.o(68599);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      i = ((Integer)paramzzex.get()).intValue();
      AppMethodBeat.o(68599);
    }
    return i;
  }
  
  final boolean zzba(String paramString)
  {
    AppMethodBeat.i(68617);
    boolean bool = zzd(paramString, zzew.zzaic);
    AppMethodBeat.o(68617);
    return bool;
  }
  
  public final double zzc(String paramString, zzex<Double> paramzzex)
  {
    AppMethodBeat.i(68600);
    double d;
    if (paramString == null)
    {
      d = ((Double)paramzzex.get()).doubleValue();
      AppMethodBeat.o(68600);
      return d;
    }
    paramString = this.zzaet.zze(paramString, paramzzex.getKey());
    if (TextUtils.isEmpty(paramString))
    {
      d = ((Double)paramzzex.get()).doubleValue();
      AppMethodBeat.o(68600);
      return d;
    }
    try
    {
      d = ((Double)paramzzex.get(Double.valueOf(Double.parseDouble(paramString)))).doubleValue();
      AppMethodBeat.o(68600);
      return d;
    }
    catch (NumberFormatException paramString)
    {
      d = ((Double)paramzzex.get()).doubleValue();
      AppMethodBeat.o(68600);
    }
    return d;
  }
  
  public final boolean zzd(String paramString, zzex<Boolean> paramzzex)
  {
    AppMethodBeat.i(68601);
    if (paramString == null)
    {
      bool = ((Boolean)paramzzex.get()).booleanValue();
      AppMethodBeat.o(68601);
      return bool;
    }
    paramString = this.zzaet.zze(paramString, paramzzex.getKey());
    if (TextUtils.isEmpty(paramString))
    {
      bool = ((Boolean)paramzzex.get()).booleanValue();
      AppMethodBeat.o(68601);
      return bool;
    }
    boolean bool = ((Boolean)paramzzex.get(Boolean.valueOf(Boolean.parseBoolean(paramString)))).booleanValue();
    AppMethodBeat.o(68601);
    return bool;
  }
  
  /* Error */
  public final boolean zzds()
  {
    // Byte code:
    //   0: ldc_w 293
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 295	com/google/android/gms/internal/measurement/zzef:zzxz	Ljava/lang/Boolean;
    //   10: ifnonnull +84 -> 94
    //   13: aload_0
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 295	com/google/android/gms/internal/measurement/zzef:zzxz	Ljava/lang/Boolean;
    //   19: ifnonnull +73 -> 92
    //   22: aload_0
    //   23: invokevirtual 70	com/google/android/gms/internal/measurement/zzhg:getContext	()Landroid/content/Context;
    //   26: invokevirtual 298	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   29: astore_3
    //   30: invokestatic 303	com/google/android/gms/common/util/ProcessUtils:getMyProcessName	()Ljava/lang/String;
    //   33: astore_2
    //   34: aload_3
    //   35: ifnull +30 -> 65
    //   38: aload_3
    //   39: getfield 307	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull +66 -> 110
    //   47: aload_3
    //   48: aload_2
    //   49: invokevirtual 212	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifeq +58 -> 110
    //   55: iconst_1
    //   56: istore_1
    //   57: aload_0
    //   58: iload_1
    //   59: invokestatic 193	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   62: putfield 295	com/google/android/gms/internal/measurement/zzef:zzxz	Ljava/lang/Boolean;
    //   65: aload_0
    //   66: getfield 295	com/google/android/gms/internal/measurement/zzef:zzxz	Ljava/lang/Boolean;
    //   69: ifnonnull +23 -> 92
    //   72: aload_0
    //   73: getstatic 310	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   76: putfield 295	com/google/android/gms/internal/measurement/zzef:zzxz	Ljava/lang/Boolean;
    //   79: aload_0
    //   80: invokevirtual 142	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   83: invokevirtual 148	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   86: ldc_w 312
    //   89: invokevirtual 156	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_0
    //   95: getfield 295	com/google/android/gms/internal/measurement/zzef:zzxz	Ljava/lang/Boolean;
    //   98: invokevirtual 65	java/lang/Boolean:booleanValue	()Z
    //   101: istore_1
    //   102: ldc_w 293
    //   105: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: iload_1
    //   109: ireturn
    //   110: iconst_0
    //   111: istore_1
    //   112: goto -55 -> 57
    //   115: astore_2
    //   116: aload_0
    //   117: monitorexit
    //   118: ldc_w 293
    //   121: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload_2
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	zzef
    //   56	56	1	bool	boolean
    //   33	16	2	str	String
    //   115	10	2	localObject1	Object
    //   29	19	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	34	115	finally
    //   38	43	115	finally
    //   47	55	115	finally
    //   57	65	115	finally
    //   65	92	115	finally
    //   92	94	115	finally
    //   116	118	115	finally
  }
  
  public final boolean zzhg()
  {
    AppMethodBeat.i(68603);
    Boolean localBoolean = zzas("firebase_analytics_collection_deactivated");
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      AppMethodBeat.o(68603);
      return true;
    }
    AppMethodBeat.o(68603);
    return false;
  }
  
  public final String zzhj()
  {
    AppMethodBeat.i(68606);
    try
    {
      String str = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { "debug.firebase.analytics.app", "" });
      AppMethodBeat.o(68606);
      return str;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      zzge().zzim().zzg("Could not find SystemProperties class", localClassNotFoundException);
      AppMethodBeat.o(68606);
      return "";
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        zzge().zzim().zzg("Could not find SystemProperties.get() method", localNoSuchMethodException);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        zzge().zzim().zzg("Could not access SystemProperties.get()", localIllegalAccessException);
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        zzge().zzim().zzg("SystemProperties.get() threw an exception", localInvocationTargetException);
      }
    }
  }
  
  final boolean zzhl()
  {
    AppMethodBeat.i(68613);
    boolean bool = zzd(zzfv().zzah(), zzew.zzahp);
    AppMethodBeat.o(68613);
    return bool;
  }
  
  final String zzhm()
  {
    AppMethodBeat.i(68614);
    String str = zzfv().zzah();
    zzex localzzex = zzew.zzahq;
    if (str == null)
    {
      str = (String)localzzex.get();
      AppMethodBeat.o(68614);
      return str;
    }
    str = (String)localzzex.get(this.zzaet.zze(str, localzzex.getKey()));
    AppMethodBeat.o(68614);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzef
 * JD-Core Version:    0.7.0.1
 */