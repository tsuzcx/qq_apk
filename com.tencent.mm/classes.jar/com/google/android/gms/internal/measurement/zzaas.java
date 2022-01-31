package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

final class zzaas
{
  private static final zzaaq zzbto;
  private static final zzaaq zzbtp;
  
  static
  {
    AppMethodBeat.i(3353);
    zzbto = zzuc();
    zzbtp = new zzaar();
    AppMethodBeat.o(3353);
  }
  
  static zzaaq zzua()
  {
    return zzbto;
  }
  
  static zzaaq zzub()
  {
    return zzbtp;
  }
  
  private static zzaaq zzuc()
  {
    AppMethodBeat.i(3352);
    try
    {
      zzaaq localzzaaq = (zzaaq)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      AppMethodBeat.o(3352);
      return localzzaaq;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(3352);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzaas
 * JD-Core Version:    0.7.0.1
 */