package com.google.android.gms.internal.firebase_messaging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.lang.reflect.Field;

public final class zzh
{
  private static final zzi zze;
  private static final int zzf;
  
  static
  {
    AppMethodBeat.i(4116);
    for (localObject2 = null;; localObject2 = localObject3)
    {
      try
      {
        localObject3 = zza();
        if (localObject3 == null) {
          break label60;
        }
        localObject2 = localObject3;
        if (((Integer)localObject3).intValue() < 19) {
          break label60;
        }
        localObject2 = localObject3;
        localObject1 = new zzm();
        localObject2 = localObject3;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject1;
          label60:
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
      zze = (zzi)localObject1;
      if (localObject2 != null) {
        break label182;
      }
      i = 1;
      zzf = i;
      AppMethodBeat.o(4116);
      return;
      localObject2 = localObject3;
      if (Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
        break;
      }
      i = 1;
      if (i == 0) {
        break label167;
      }
      localObject2 = localObject3;
      localObject1 = new zzl();
    }
  }
  
  private static Integer zza()
  {
    AppMethodBeat.i(4115);
    try
    {
      Integer localInteger = (Integer)Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
      AppMethodBeat.o(4115);
      return localInteger;
    }
    catch (Exception localException)
    {
      System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
      localException.printStackTrace(System.err);
      AppMethodBeat.o(4115);
    }
    return null;
  }
  
  public static void zza(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(4114);
    zze.zza(paramThrowable1, paramThrowable2);
    AppMethodBeat.o(4114);
  }
  
  static final class zza
    extends zzi
  {
    public final void zza(Throwable paramThrowable1, Throwable paramThrowable2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.firebase_messaging.zzh
 * JD-Core Version:    0.7.0.1
 */