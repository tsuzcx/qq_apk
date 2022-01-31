package com.google.android.gms.internal.stable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.lang.reflect.Field;

public final class zzk
{
  private static final zzl zzahg;
  private static final int zzahh;
  
  static
  {
    AppMethodBeat.i(90495);
    for (localObject2 = null;; localObject2 = localObject3)
    {
      try
      {
        localObject3 = zzdw();
        if (localObject3 == null) {
          break label58;
        }
        localObject2 = localObject3;
        if (((Integer)localObject3).intValue() < 19) {
          break label58;
        }
        localObject2 = localObject3;
        localObject1 = new zzp();
        localObject2 = localObject3;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject1;
          label58:
          Object localObject3 = System.err;
          String str = zzk.zza.class.getName();
          ((PrintStream)localObject3).println(String.valueOf(str).length() + 132 + "An error has occured when initializing the try-with-resources desuguring strategy. The default strategy " + str + "will be used. The error is: ");
          localThrowable.printStackTrace(System.err);
          zzk.zza localzza = new zzk.zza();
          continue;
          int i = 0;
          continue;
          localObject2 = localObject3;
          localzza = new zzk.zza();
          localObject2 = localObject3;
          continue;
          i = localObject2.intValue();
        }
      }
      zzahg = (zzl)localObject1;
      if (localObject2 != null) {
        break label180;
      }
      i = 1;
      zzahh = i;
      AppMethodBeat.o(90495);
      return;
      localObject2 = localObject3;
      if (Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
        break;
      }
      i = 1;
      if (i == 0) {
        break label165;
      }
      localObject2 = localObject3;
      localObject1 = new zzo();
    }
  }
  
  public static void zza(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(90493);
    zzahg.zza(paramThrowable1, paramThrowable2);
    AppMethodBeat.o(90493);
  }
  
  private static Integer zzdw()
  {
    AppMethodBeat.i(90494);
    try
    {
      Integer localInteger = (Integer)Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
      AppMethodBeat.o(90494);
      return localInteger;
    }
    catch (Exception localException)
    {
      System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
      localException.printStackTrace(System.err);
      AppMethodBeat.o(90494);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.stable.zzk
 * JD-Core Version:    0.7.0.1
 */