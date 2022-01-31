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
    AppMethodBeat.i(90330);
    zzabb = new Wrappers();
    AppMethodBeat.o(90330);
  }
  
  public static PackageManagerWrapper packageManager(Context paramContext)
  {
    AppMethodBeat.i(90329);
    paramContext = zzabb.getPackageManagerWrapper(paramContext);
    AppMethodBeat.o(90329);
    return paramContext;
  }
  
  @VisibleForTesting
  public static void resetForTests()
  {
    AppMethodBeat.i(90328);
    zzabb = new Wrappers();
    AppMethodBeat.o(90328);
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
    //   2: ldc 42
    //   4: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 29	com/google/android/gms/common/wrappers/Wrappers:zzaba	Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
    //   11: ifnonnull +22 -> 33
    //   14: aload_1
    //   15: invokevirtual 48	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   18: ifnonnull +29 -> 47
    //   21: aload_0
    //   22: new 50	com/google/android/gms/common/wrappers/PackageManagerWrapper
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 53	com/google/android/gms/common/wrappers/PackageManagerWrapper:<init>	(Landroid/content/Context;)V
    //   30: putfield 29	com/google/android/gms/common/wrappers/Wrappers:zzaba	Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
    //   33: aload_0
    //   34: getfield 29	com/google/android/gms/common/wrappers/Wrappers:zzaba	Lcom/google/android/gms/common/wrappers/PackageManagerWrapper;
    //   37: astore_1
    //   38: ldc 42
    //   40: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: areturn
    //   47: aload_1
    //   48: invokevirtual 48	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   51: astore_1
    //   52: goto -31 -> 21
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	Wrappers
    //   0	60	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	21	55	finally
    //   21	33	55	finally
    //   33	43	55	finally
    //   47	52	55	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.wrappers.Wrappers
 * JD-Core Version:    0.7.0.1
 */