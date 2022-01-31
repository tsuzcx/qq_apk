package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

final class zzaai
{
  private static final zzaag zzbtg;
  private static final zzaag zzbth;
  
  static
  {
    AppMethodBeat.i(3339);
    zzbtg = zztv();
    zzbth = new zzaah();
    AppMethodBeat.o(3339);
  }
  
  static zzaag zztt()
  {
    return zzbtg;
  }
  
  static zzaag zztu()
  {
    return zzbth;
  }
  
  private static zzaag zztv()
  {
    AppMethodBeat.i(3338);
    try
    {
      zzaag localzzaag = (zzaag)Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      AppMethodBeat.o(3338);
      return localzzaag;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(3338);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzaai
 * JD-Core Version:    0.7.0.1
 */