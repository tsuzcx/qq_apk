package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

final class zzzh
{
  private static final Class<?> zzbrl;
  
  static
  {
    AppMethodBeat.i(3563);
    zzbrl = zztb();
    AppMethodBeat.o(3563);
  }
  
  private static final zzzi zzfj(String paramString)
  {
    AppMethodBeat.i(3562);
    paramString = (zzzi)zzbrl.getDeclaredMethod(paramString, new Class[0]).invoke(null, new Object[0]);
    AppMethodBeat.o(3562);
    return paramString;
  }
  
  private static Class<?> zztb()
  {
    AppMethodBeat.i(3560);
    try
    {
      Class localClass = Class.forName("com.google.protobuf.ExtensionRegistry");
      AppMethodBeat.o(3560);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      AppMethodBeat.o(3560);
    }
    return null;
  }
  
  public static zzzi zztc()
  {
    AppMethodBeat.i(3561);
    if (zzbrl != null) {
      try
      {
        zzzi localzzzi1 = zzfj("getEmptyRegistry");
        AppMethodBeat.o(3561);
        return localzzzi1;
      }
      catch (Exception localException) {}
    }
    zzzi localzzzi2 = zzzi.zzbro;
    AppMethodBeat.o(3561);
    return localzzzi2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzzh
 * JD-Core Version:    0.7.0.1
 */