package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Wrappers
{
  private static Wrappers zzabb;
  private PackageManagerWrapper zzaba = null;
  
  static
  {
    AppMethodBeat.i(5351);
    zzabb = new Wrappers();
    AppMethodBeat.o(5351);
  }
  
  public static PackageManagerWrapper packageManager(Context paramContext)
  {
    AppMethodBeat.i(5350);
    paramContext = zzabb.getPackageManagerWrapper(paramContext);
    AppMethodBeat.o(5350);
    return paramContext;
  }
  
  @VisibleForTesting
  public static void resetForTests()
  {
    AppMethodBeat.i(5349);
    zzabb = new Wrappers();
    AppMethodBeat.o(5349);
  }
  
  public static void setWrappers(Wrappers paramWrappers)
  {
    zzabb = paramWrappers;
  }
  
  /* Error */
  @VisibleForTesting
  public PackageManagerWrapper getPackageManagerWrapper(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 5348
    //   5: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 28	com/google/android/gms/common/wrappers/Wrappers:zzaba	Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
    //   12: ifnonnull +22 -> 34
    //   15: aload_1
    //   16: invokevirtual 44	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: ifnonnull +30 -> 49
    //   22: aload_0
    //   23: new 46	com/google/android/gms/common/wrappers/PackageManagerWrapper
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 49	com/google/android/gms/common/wrappers/PackageManagerWrapper:<init>	(Landroid/content/Context;)V
    //   31: putfield 28	com/google/android/gms/common/wrappers/Wrappers:zzaba	Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
    //   34: aload_0
    //   35: getfield 28	com/google/android/gms/common/wrappers/Wrappers:zzaba	Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
    //   38: astore_1
    //   39: sipush 5348
    //   42: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: areturn
    //   49: aload_1
    //   50: invokevirtual 44	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   53: astore_1
    //   54: goto -32 -> 22
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	Wrappers
    //   0	62	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	22	57	finally
    //   22	34	57	finally
    //   34	45	57	finally
    //   49	54	57	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.wrappers.Wrappers
 * JD-Core Version:    0.7.0.1
 */