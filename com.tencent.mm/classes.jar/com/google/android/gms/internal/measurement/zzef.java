package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
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
    AppMethodBeat.i(1127);
    long l = ((Long)zzew.zzahl.get()).longValue();
    AppMethodBeat.o(1127);
    return l;
  }
  
  public static long zzhi()
  {
    AppMethodBeat.i(1128);
    long l = ((Long)zzew.zzagl.get()).longValue();
    AppMethodBeat.o(1128);
    return l;
  }
  
  public static boolean zzhk()
  {
    AppMethodBeat.i(1130);
    boolean bool = ((Boolean)zzew.zzagh.get()).booleanValue();
    AppMethodBeat.o(1130);
    return bool;
  }
  
  public final long zza(String paramString, zzex<Long> paramzzex)
  {
    AppMethodBeat.i(1121);
    long l;
    if (paramString == null)
    {
      l = ((Long)paramzzex.get()).longValue();
      AppMethodBeat.o(1121);
      return l;
    }
    paramString = this.zzaet.zze(paramString, paramzzex.getKey());
    if (TextUtils.isEmpty(paramString))
    {
      l = ((Long)paramzzex.get()).longValue();
      AppMethodBeat.o(1121);
      return l;
    }
    try
    {
      l = ((Long)paramzzex.get(Long.valueOf(Long.parseLong(paramString)))).longValue();
      AppMethodBeat.o(1121);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      l = ((Long)paramzzex.get()).longValue();
      AppMethodBeat.o(1121);
    }
    return l;
  }
  
  final void zza(zzeh paramzzeh)
  {
    this.zzaet = paramzzeh;
  }
  
  public final int zzar(String paramString)
  {
    AppMethodBeat.i(1119);
    int i = zzb(paramString, zzew.zzagw);
    AppMethodBeat.o(1119);
    return i;
  }
  
  final Boolean zzas(String paramString)
  {
    AppMethodBeat.i(1125);
    Preconditions.checkNotEmpty(paramString);
    try
    {
      if (getContext().getPackageManager() == null)
      {
        zzge().zzim().log("Failed to load metadata: PackageManager is null");
        AppMethodBeat.o(1125);
        return null;
      }
      ApplicationInfo localApplicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
      if (localApplicationInfo == null)
      {
        zzge().zzim().log("Failed to load metadata: ApplicationInfo is null");
        AppMethodBeat.o(1125);
        return null;
      }
      if (localApplicationInfo.metaData == null)
      {
        zzge().zzim().log("Failed to load metadata: Metadata bundle is null");
        AppMethodBeat.o(1125);
        return null;
      }
      boolean bool = localApplicationInfo.metaData.containsKey(paramString);
      if (!bool)
      {
        AppMethodBeat.o(1125);
        return null;
      }
      bool = localApplicationInfo.metaData.getBoolean(paramString);
      AppMethodBeat.o(1125);
      return Boolean.valueOf(bool);
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      zzge().zzim().zzg("Failed to load metadata: Package name not found", paramString);
      AppMethodBeat.o(1125);
    }
    return null;
  }
  
  public final boolean zzat(String paramString)
  {
    AppMethodBeat.i(1131);
    boolean bool = "1".equals(this.zzaet.zze(paramString, "gaia_collection_enabled"));
    AppMethodBeat.o(1131);
    return bool;
  }
  
  public final boolean zzau(String paramString)
  {
    AppMethodBeat.i(1132);
    boolean bool = "1".equals(this.zzaet.zze(paramString, "measurement.event_sampling_enabled"));
    AppMethodBeat.o(1132);
    return bool;
  }
  
  final boolean zzav(String paramString)
  {
    AppMethodBeat.i(1133);
    boolean bool = zzd(paramString, zzew.zzahu);
    AppMethodBeat.o(1133);
    return bool;
  }
  
  final boolean zzaw(String paramString)
  {
    AppMethodBeat.i(1134);
    boolean bool = zzd(paramString, zzew.zzahw);
    AppMethodBeat.o(1134);
    return bool;
  }
  
  final boolean zzax(String paramString)
  {
    AppMethodBeat.i(1135);
    boolean bool = zzd(paramString, zzew.zzahx);
    AppMethodBeat.o(1135);
    return bool;
  }
  
  final boolean zzay(String paramString)
  {
    AppMethodBeat.i(1138);
    boolean bool = zzd(paramString, zzew.zzahy);
    AppMethodBeat.o(1138);
    return bool;
  }
  
  final boolean zzaz(String paramString)
  {
    AppMethodBeat.i(1139);
    boolean bool = zzd(paramString, zzew.zzahz);
    AppMethodBeat.o(1139);
    return bool;
  }
  
  public final int zzb(String paramString, zzex<Integer> paramzzex)
  {
    AppMethodBeat.i(1122);
    int i;
    if (paramString == null)
    {
      i = ((Integer)paramzzex.get()).intValue();
      AppMethodBeat.o(1122);
      return i;
    }
    paramString = this.zzaet.zze(paramString, paramzzex.getKey());
    if (TextUtils.isEmpty(paramString))
    {
      i = ((Integer)paramzzex.get()).intValue();
      AppMethodBeat.o(1122);
      return i;
    }
    try
    {
      i = ((Integer)paramzzex.get(Integer.valueOf(Integer.parseInt(paramString)))).intValue();
      AppMethodBeat.o(1122);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      i = ((Integer)paramzzex.get()).intValue();
      AppMethodBeat.o(1122);
    }
    return i;
  }
  
  final boolean zzba(String paramString)
  {
    AppMethodBeat.i(1140);
    boolean bool = zzd(paramString, zzew.zzaic);
    AppMethodBeat.o(1140);
    return bool;
  }
  
  public final double zzc(String paramString, zzex<Double> paramzzex)
  {
    AppMethodBeat.i(1123);
    double d;
    if (paramString == null)
    {
      d = ((Double)paramzzex.get()).doubleValue();
      AppMethodBeat.o(1123);
      return d;
    }
    paramString = this.zzaet.zze(paramString, paramzzex.getKey());
    if (TextUtils.isEmpty(paramString))
    {
      d = ((Double)paramzzex.get()).doubleValue();
      AppMethodBeat.o(1123);
      return d;
    }
    try
    {
      d = ((Double)paramzzex.get(Double.valueOf(Double.parseDouble(paramString)))).doubleValue();
      AppMethodBeat.o(1123);
      return d;
    }
    catch (NumberFormatException paramString)
    {
      d = ((Double)paramzzex.get()).doubleValue();
      AppMethodBeat.o(1123);
    }
    return d;
  }
  
  public final boolean zzd(String paramString, zzex<Boolean> paramzzex)
  {
    AppMethodBeat.i(1124);
    if (paramString == null)
    {
      bool = ((Boolean)paramzzex.get()).booleanValue();
      AppMethodBeat.o(1124);
      return bool;
    }
    paramString = this.zzaet.zze(paramString, paramzzex.getKey());
    if (TextUtils.isEmpty(paramString))
    {
      bool = ((Boolean)paramzzex.get()).booleanValue();
      AppMethodBeat.o(1124);
      return bool;
    }
    boolean bool = ((Boolean)paramzzex.get(Boolean.valueOf(Boolean.parseBoolean(paramString)))).booleanValue();
    AppMethodBeat.o(1124);
    return bool;
  }
  
  /* Error */
  public final boolean zzds()
  {
    // Byte code:
    //   0: sipush 1120
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 272	com/google/android/gms/internal/measurement/zzef:zzxz	Ljava/lang/Boolean;
    //   10: ifnonnull +84 -> 94
    //   13: aload_0
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 272	com/google/android/gms/internal/measurement/zzef:zzxz	Ljava/lang/Boolean;
    //   19: ifnonnull +73 -> 92
    //   22: aload_0
    //   23: invokevirtual 66	com/google/android/gms/internal/measurement/zzhg:getContext	()Landroid/content/Context;
    //   26: invokevirtual 275	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   29: astore_3
    //   30: invokestatic 280	com/google/android/gms/common/util/ProcessUtils:getMyProcessName	()Ljava/lang/String;
    //   33: astore_2
    //   34: aload_3
    //   35: ifnull +30 -> 65
    //   38: aload_3
    //   39: getfield 284	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull +66 -> 110
    //   47: aload_3
    //   48: aload_2
    //   49: invokevirtual 201	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifeq +58 -> 110
    //   55: iconst_1
    //   56: istore_1
    //   57: aload_0
    //   58: iload_1
    //   59: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   62: putfield 272	com/google/android/gms/internal/measurement/zzef:zzxz	Ljava/lang/Boolean;
    //   65: aload_0
    //   66: getfield 272	com/google/android/gms/internal/measurement/zzef:zzxz	Ljava/lang/Boolean;
    //   69: ifnonnull +23 -> 92
    //   72: aload_0
    //   73: getstatic 287	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   76: putfield 272	com/google/android/gms/internal/measurement/zzef:zzxz	Ljava/lang/Boolean;
    //   79: aload_0
    //   80: invokevirtual 133	com/google/android/gms/internal/measurement/zzhg:zzge	()Lcom/google/android/gms/internal/measurement/zzfg;
    //   83: invokevirtual 139	com/google/android/gms/internal/measurement/zzfg:zzim	()Lcom/google/android/gms/internal/measurement/zzfi;
    //   86: ldc_w 289
    //   89: invokevirtual 147	com/google/android/gms/internal/measurement/zzfi:log	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_0
    //   95: getfield 272	com/google/android/gms/internal/measurement/zzef:zzxz	Ljava/lang/Boolean;
    //   98: invokevirtual 62	java/lang/Boolean:booleanValue	()Z
    //   101: istore_1
    //   102: sipush 1120
    //   105: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: iload_1
    //   109: ireturn
    //   110: iconst_0
    //   111: istore_1
    //   112: goto -55 -> 57
    //   115: astore_2
    //   116: aload_0
    //   117: monitorexit
    //   118: sipush 1120
    //   121: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  }
  
  public final boolean zzhg()
  {
    AppMethodBeat.i(1126);
    Boolean localBoolean = zzas("firebase_analytics_collection_deactivated");
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      AppMethodBeat.o(1126);
      return true;
    }
    AppMethodBeat.o(1126);
    return false;
  }
  
  public final String zzhj()
  {
    AppMethodBeat.i(1129);
    try
    {
      String str = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { "debug.firebase.analytics.app", "" });
      AppMethodBeat.o(1129);
      return str;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      zzge().zzim().zzg("Could not find SystemProperties class", localClassNotFoundException);
      AppMethodBeat.o(1129);
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
    AppMethodBeat.i(1136);
    boolean bool = zzd(zzfv().zzah(), zzew.zzahp);
    AppMethodBeat.o(1136);
    return bool;
  }
  
  final String zzhm()
  {
    AppMethodBeat.i(1137);
    String str = zzfv().zzah();
    zzex localzzex = zzew.zzahq;
    if (str == null)
    {
      str = (String)localzzex.get();
      AppMethodBeat.o(1137);
      return str;
    }
    str = (String)localzzex.get(this.zzaet.zze(str, localzzex.getKey()));
    AppMethodBeat.o(1137);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzef
 * JD-Core Version:    0.7.0.1
 */