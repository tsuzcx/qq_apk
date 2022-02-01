package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

final class zzaas
{
  private static final zzaaq zzbto;
  private static final zzaaq zzbtp;
  
  static
  {
    AppMethodBeat.i(40143);
    zzbto = zzuc();
    zzbtp = new zzaar();
    AppMethodBeat.o(40143);
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
    AppMethodBeat.i(40142);
    try
    {
      zzaaq localzzaaq = (zzaaq)Class.forName("com.google.d.cn").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      AppMethodBeat.o(40142);
      return localzzaaq;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(40142);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzaas
 * JD-Core Version:    0.7.0.1
 */