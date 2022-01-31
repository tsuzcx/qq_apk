package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzyv
{
  private static final Class<?> zzbqv;
  private static final boolean zzbqw;
  
  static
  {
    AppMethodBeat.i(3547);
    zzbqv = zzfh("libcore.io.Memory");
    if (zzfh("org.robolectric.Robolectric") != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzbqw = bool;
      AppMethodBeat.o(3547);
      return;
    }
  }
  
  private static <T> Class<T> zzfh(String paramString)
  {
    AppMethodBeat.i(3546);
    try
    {
      paramString = Class.forName(paramString);
      AppMethodBeat.o(3546);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(3546);
    }
    return null;
  }
  
  static boolean zzsv()
  {
    return (zzbqv != null) && (!zzbqw);
  }
  
  static Class<?> zzsw()
  {
    return zzbqv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzyv
 * JD-Core Version:    0.7.0.1
 */