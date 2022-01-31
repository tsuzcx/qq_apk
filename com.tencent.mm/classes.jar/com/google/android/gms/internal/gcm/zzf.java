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
    AppMethodBeat.i(57625);
    for (localObject2 = null;; localObject2 = localObject3)
    {
      try
      {
        localObject3 = zzy();
        if (localObject3 == null) {
          break label58;
        }
        localObject2 = localObject3;
        if (((Integer)localObject3).intValue() < 19) {
          break label58;
        }
        localObject2 = localObject3;
        localObject1 = new zzk();
        localObject2 = localObject3;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject1;
          label58:
          Object localObject3 = System.err;
          String str = zzf.zzd.class.getName();
          ((PrintStream)localObject3).println(String.valueOf(str).length() + 132 + "An error has occured when initializing the try-with-resources desuguring strategy. The default strategy " + str + "will be used. The error is: ");
          localThrowable.printStackTrace(System.err);
          zzf.zzd localzzd = new zzf.zzd();
          continue;
          int i = 0;
          continue;
          localObject2 = localObject3;
          localzzd = new zzf.zzd();
          localObject2 = localObject3;
          continue;
          i = localObject2.intValue();
        }
      }
      zzdc = (zzg)localObject1;
      if (localObject2 != null) {
        break label180;
      }
      i = 1;
      zzdd = i;
      AppMethodBeat.o(57625);
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
      localObject1 = new zzj();
    }
  }
  
  public static void zzd(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(57623);
    zzdc.zzd(paramThrowable1, paramThrowable2);
    AppMethodBeat.o(57623);
  }
  
  private static Integer zzy()
  {
    AppMethodBeat.i(57624);
    try
    {
      Integer localInteger = (Integer)Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
      AppMethodBeat.o(57624);
      return localInteger;
    }
    catch (Exception localException)
    {
      System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
      localException.printStackTrace(System.err);
      AppMethodBeat.o(57624);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.gcm.zzf
 * JD-Core Version:    0.7.0.1
 */