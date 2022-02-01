package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

final class zzzh
{
  private static final Class<?> zzbrl;
  
  static
  {
    AppMethodBeat.i(40353);
    zzbrl = zztb();
    AppMethodBeat.o(40353);
  }
  
  private static final zzzi zzfj(String paramString)
  {
    AppMethodBeat.i(40352);
    paramString = (zzzi)zzbrl.getDeclaredMethod(paramString, new Class[0]).invoke(null, new Object[0]);
    AppMethodBeat.o(40352);
    return paramString;
  }
  
  private static Class<?> zztb()
  {
    AppMethodBeat.i(40350);
    try
    {
      Class localClass = Class.forName("com.google.a.p");
      AppMethodBeat.o(40350);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      AppMethodBeat.o(40350);
    }
    return null;
  }
  
  public static zzzi zztc()
  {
    AppMethodBeat.i(40351);
    if (zzbrl != null) {
      try
      {
        zzzi localzzzi1 = zzfj("getEmptyRegistry");
        AppMethodBeat.o(40351);
        return localzzzi1;
      }
      catch (Exception localException) {}
    }
    zzzi localzzzi2 = zzzi.zzbro;
    AppMethodBeat.o(40351);
    return localzzzi2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzzh
 * JD-Core Version:    0.7.0.1
 */