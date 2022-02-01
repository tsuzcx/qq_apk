package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

final class zzaad
  implements zzaaw
{
  private static final zzaak zzbte;
  private final zzaak zzbtd;
  
  static
  {
    AppMethodBeat.i(40124);
    zzbte = new zzaae();
    AppMethodBeat.o(40124);
  }
  
  public zzaad()
  {
    this(new zzaaf(new zzaak[] { zzzp.zztl(), zzts() }));
    AppMethodBeat.i(40119);
    AppMethodBeat.o(40119);
  }
  
  private zzaad(zzaak paramzzaak)
  {
    AppMethodBeat.i(40120);
    this.zzbtd = ((zzaak)zzzr.zza(paramzzaak, "messageInfoFactory"));
    AppMethodBeat.o(40120);
  }
  
  private static boolean zza(zzaaj paramzzaaj)
  {
    AppMethodBeat.i(40122);
    if (paramzzaaj.zztw() == zzzq.zzb.zzbsk)
    {
      AppMethodBeat.o(40122);
      return true;
    }
    AppMethodBeat.o(40122);
    return false;
  }
  
  private static zzaak zzts()
  {
    AppMethodBeat.i(40123);
    try
    {
      zzaak localzzaak1 = (zzaak)Class.forName("com.google.d.m").getDeclaredMethod("aaQ", new Class[0]).invoke(null, new Object[0]);
      AppMethodBeat.o(40123);
      return localzzaak1;
    }
    catch (Exception localException)
    {
      zzaak localzzaak2 = zzbte;
      AppMethodBeat.o(40123);
      return localzzaak2;
    }
  }
  
  public final <T> zzaav<T> zzg(Class<T> paramClass)
  {
    AppMethodBeat.i(40121);
    zzaax.zzh(paramClass);
    zzaaj localzzaaj = this.zzbtd.zze(paramClass);
    if (localzzaaj.zztx())
    {
      if (zzzq.class.isAssignableFrom(paramClass))
      {
        paramClass = zzaap.zza(zzaax.zzug(), zzzl.zztg(), localzzaaj.zzty());
        AppMethodBeat.o(40121);
        return paramClass;
      }
      paramClass = zzaap.zza(zzaax.zzue(), zzzl.zzth(), localzzaaj.zzty());
      AppMethodBeat.o(40121);
      return paramClass;
    }
    if (zzzq.class.isAssignableFrom(paramClass))
    {
      if (zza(localzzaaj))
      {
        paramClass = zzaao.zza(paramClass, localzzaaj, zzaas.zzub(), zzzz.zztr(), zzaax.zzug(), zzzl.zztg(), zzaai.zztu());
        AppMethodBeat.o(40121);
        return paramClass;
      }
      paramClass = zzaao.zza(paramClass, localzzaaj, zzaas.zzub(), zzzz.zztr(), zzaax.zzug(), null, zzaai.zztu());
      AppMethodBeat.o(40121);
      return paramClass;
    }
    if (zza(localzzaaj))
    {
      paramClass = zzaao.zza(paramClass, localzzaaj, zzaas.zzua(), zzzz.zztq(), zzaax.zzue(), zzzl.zzth(), zzaai.zztt());
      AppMethodBeat.o(40121);
      return paramClass;
    }
    paramClass = zzaao.zza(paramClass, localzzaaj, zzaas.zzua(), zzzz.zztq(), zzaax.zzuf(), null, zzaai.zztt());
    AppMethodBeat.o(40121);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzaad
 * JD-Core Version:    0.7.0.1
 */