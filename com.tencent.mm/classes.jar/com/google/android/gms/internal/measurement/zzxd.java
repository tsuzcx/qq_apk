package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.lang.reflect.Field;

public final class zzxd
{
  private static final zzxe zzbnx;
  private static final int zzbny;
  
  static
  {
    AppMethodBeat.i(40328);
    for (localObject2 = null;; localObject2 = localObject3)
    {
      try
      {
        localObject3 = zzsd();
        if (localObject3 == null) {
          break label58;
        }
        localObject2 = localObject3;
        if (((Integer)localObject3).intValue() < 19) {
          break label58;
        }
        localObject2 = localObject3;
        localObject1 = new zzxi();
        localObject2 = localObject3;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject1;
          label58:
          Object localObject3 = System.err;
          String str = zza.class.getName();
          ((PrintStream)localObject3).println(String.valueOf(str).length() + 132 + "An error has occured when initializing the try-with-resources desuguring strategy. The default strategy " + str + "will be used. The error is: ");
          localThrowable.printStackTrace(System.err);
          zza localzza = new zza();
          continue;
          int i = 0;
          continue;
          localObject2 = localObject3;
          localzza = new zza();
          localObject2 = localObject3;
          continue;
          i = localObject2.intValue();
        }
      }
      zzbnx = (zzxe)localObject1;
      if (localObject2 != null) {
        break label180;
      }
      i = 1;
      zzbny = i;
      AppMethodBeat.o(40328);
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
      localObject1 = new zzxh();
    }
  }
  
  public static void zza(Throwable paramThrowable, PrintStream paramPrintStream)
  {
    AppMethodBeat.i(40326);
    zzbnx.zza(paramThrowable, paramPrintStream);
    AppMethodBeat.o(40326);
  }
  
  private static Integer zzsd()
  {
    AppMethodBeat.i(40327);
    try
    {
      Integer localInteger = (Integer)Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
      AppMethodBeat.o(40327);
      return localInteger;
    }
    catch (Exception localException)
    {
      System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
      localException.printStackTrace(System.err);
      AppMethodBeat.o(40327);
    }
    return null;
  }
  
  static final class zza
    extends zzxe
  {
    public final void zza(Throwable paramThrowable, PrintStream paramPrintStream)
    {
      AppMethodBeat.i(40325);
      paramThrowable.printStackTrace(paramPrintStream);
      AppMethodBeat.o(40325);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzxd
 * JD-Core Version:    0.7.0.1
 */