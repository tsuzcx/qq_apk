package com.google.android.gms.internal.gcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.lang.reflect.Field;

public final class zzf
{
  private static final zzg zzdc;
  private static final int zzdd;
  
  static
  {
    AppMethodBeat.i(2579);
    for (localObject3 = null;; localObject3 = localObject4)
    {
      try
      {
        localObject4 = zzy();
        if (localObject4 == null) {
          break label60;
        }
        localObject3 = localObject4;
        if (((Integer)localObject4).intValue() < 19) {
          break label60;
        }
        localObject3 = localObject4;
        localObject1 = new zzk();
        localObject3 = localObject4;
      }
      finally
      {
        for (;;)
        {
          Object localObject1;
          label60:
          Object localObject4 = System.err;
          String str = zzd.class.getName();
          ((PrintStream)localObject4).println(String.valueOf(str).length() + 132 + "An error has occured when initializing the try-with-resources desuguring strategy. The default strategy " + str + "will be used. The error is: ");
          localObject2.printStackTrace(System.err);
          zzd localzzd = new zzd();
          continue;
          int i = 0;
          continue;
          localObject3 = localObject4;
          localzzd = new zzd();
          localObject3 = localObject4;
          continue;
          i = localObject3.intValue();
        }
      }
      zzdc = (zzg)localObject1;
      if (localObject3 != null) {
        break label182;
      }
      i = 1;
      zzdd = i;
      AppMethodBeat.o(2579);
      return;
      localObject3 = localObject4;
      if (Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
        break;
      }
      i = 1;
      if (i == 0) {
        break label167;
      }
      localObject3 = localObject4;
      localObject1 = new zzj();
    }
  }
  
  public static void zzd(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(2577);
    zzdc.zzd(paramThrowable1, paramThrowable2);
    AppMethodBeat.o(2577);
  }
  
  private static Integer zzy()
  {
    AppMethodBeat.i(2578);
    try
    {
      Integer localInteger = (Integer)Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
      AppMethodBeat.o(2578);
      return localInteger;
    }
    catch (Exception localException)
    {
      System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
      localException.printStackTrace(System.err);
      AppMethodBeat.o(2578);
    }
    return null;
  }
  
  static final class zzd
    extends zzg
  {
    public final void zzd(Throwable paramThrowable1, Throwable paramThrowable2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.gcm.zzf
 * JD-Core Version:    0.7.0.1
 */