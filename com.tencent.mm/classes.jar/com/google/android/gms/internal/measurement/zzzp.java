package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzzp
  implements zzaak
{
  private static final zzzp zzbrx;
  
  static
  {
    AppMethodBeat.i(3584);
    zzbrx = new zzzp();
    AppMethodBeat.o(3584);
  }
  
  public static zzzp zztl()
  {
    return zzbrx;
  }
  
  public final boolean zzd(Class<?> paramClass)
  {
    AppMethodBeat.i(3582);
    boolean bool = zzzq.class.isAssignableFrom(paramClass);
    AppMethodBeat.o(3582);
    return bool;
  }
  
  public final zzaaj zze(Class<?> paramClass)
  {
    AppMethodBeat.i(3583);
    if (!zzzq.class.isAssignableFrom(paramClass))
    {
      paramClass = String.valueOf(paramClass.getName());
      if (paramClass.length() != 0) {}
      for (paramClass = "Unsupported message type: ".concat(paramClass);; paramClass = new String("Unsupported message type: "))
      {
        paramClass = new IllegalArgumentException(paramClass);
        AppMethodBeat.o(3583);
        throw paramClass;
      }
    }
    try
    {
      zzaaj localzzaaj = (zzaaj)zzzq.zzf(paramClass.asSubclass(zzzq.class)).zza(3, null, null);
      AppMethodBeat.o(3583);
      return localzzaaj;
    }
    catch (Exception localException)
    {
      paramClass = String.valueOf(paramClass.getName());
      if (paramClass.length() == 0) {}
    }
    for (paramClass = "Unable to get message info for ".concat(paramClass);; paramClass = new String("Unable to get message info for "))
    {
      paramClass = new RuntimeException(paramClass, localException);
      AppMethodBeat.o(3583);
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzzp
 * JD-Core Version:    0.7.0.1
 */