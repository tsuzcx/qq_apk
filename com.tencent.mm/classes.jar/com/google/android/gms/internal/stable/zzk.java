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
    AppMethodBeat.i(5516);
    for (localObject3 = null;; localObject3 = localObject4)
    {
      try
      {
        localObject4 = zzdw();
        if (localObject4 == null) {
          break label60;
        }
        localObject3 = localObject4;
        if (((Integer)localObject4).intValue() < 19) {
          break label60;
        }
        localObject3 = localObject4;
        localObject1 = new zzp();
        localObject3 = localObject4;
      }
      finally
      {
        for (;;)
        {
          Object localObject1;
          label60:
          Object localObject4 = System.err;
          String str = zza.class.getName();
          ((PrintStream)localObject4).println(String.valueOf(str).length() + 132 + "An error has occured when initializing the try-with-resources desuguring strategy. The default strategy " + str + "will be used. The error is: ");
          localObject2.printStackTrace(System.err);
          zza localzza = new zza();
          continue;
          int i = 0;
          continue;
          localObject3 = localObject4;
          localzza = new zza();
          localObject3 = localObject4;
          continue;
          i = localObject3.intValue();
        }
      }
      zzahg = (zzl)localObject1;
      if (localObject3 != null) {
        break label182;
      }
      i = 1;
      zzahh = i;
      AppMethodBeat.o(5516);
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
      localObject1 = new zzo();
    }
  }
  
  public static void zza(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(5514);
    zzahg.zza(paramThrowable1, paramThrowable2);
    AppMethodBeat.o(5514);
  }
  
  private static Integer zzdw()
  {
    AppMethodBeat.i(5515);
    try
    {
      Integer localInteger = (Integer)Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
      AppMethodBeat.o(5515);
      return localInteger;
    }
    catch (Exception localException)
    {
      System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
      localException.printStackTrace(System.err);
      AppMethodBeat.o(5515);
    }
    return null;
  }
  
  static final class zza
    extends zzl
  {
    public final void zza(Throwable paramThrowable1, Throwable paramThrowable2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.stable.zzk
 * JD-Core Version:    0.7.0.1
 */