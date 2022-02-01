package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

final class zzzl
{
  private static final zzzj<?> zzbrq;
  private static final zzzj<?> zzbrr;
  
  static
  {
    AppMethodBeat.i(40361);
    zzbrq = new zzzk();
    zzbrr = zztf();
    AppMethodBeat.o(40361);
  }
  
  private static zzzj<?> zztf()
  {
    AppMethodBeat.i(40359);
    try
    {
      zzzj localzzzj = (zzzj)Class.forName("com.google.a.t").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      AppMethodBeat.o(40359);
      return localzzzj;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(40359);
    }
    return null;
  }
  
  static zzzj<?> zztg()
  {
    return zzbrq;
  }
  
  static zzzj<?> zzth()
  {
    AppMethodBeat.i(40360);
    if (zzbrr == null)
    {
      localObject = new IllegalStateException("Protobuf runtime is not correctly loaded.");
      AppMethodBeat.o(40360);
      throw ((Throwable)localObject);
    }
    Object localObject = zzbrr;
    AppMethodBeat.o(40360);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzzl
 * JD-Core Version:    0.7.0.1
 */