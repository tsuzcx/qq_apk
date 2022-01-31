package com.google.android.gms.common.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

@Deprecated
final class GservicesValue$zzc
  implements GservicesValue.zza
{
  private final Map<String, ?> values;
  
  public GservicesValue$zzc(Map<String, ?> paramMap)
  {
    this.values = paramMap;
  }
  
  private final <T> T zza(String paramString, T paramT)
  {
    AppMethodBeat.i(89528);
    if (this.values.containsKey(paramString))
    {
      paramString = this.values.get(paramString);
      AppMethodBeat.o(89528);
      return paramString;
    }
    AppMethodBeat.o(89528);
    return paramT;
  }
  
  public final Long getLong(String paramString, Long paramLong)
  {
    AppMethodBeat.i(89525);
    paramString = (Long)zza(paramString, paramLong);
    AppMethodBeat.o(89525);
    return paramString;
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(89526);
    paramString1 = (String)zza(paramString1, paramString2);
    AppMethodBeat.o(89526);
    return paramString1;
  }
  
  public final Boolean zza(String paramString, Boolean paramBoolean)
  {
    AppMethodBeat.i(89521);
    paramString = (Boolean)zza(paramString, paramBoolean);
    AppMethodBeat.o(89521);
    return paramString;
  }
  
  public final Double zza(String paramString, Double paramDouble)
  {
    AppMethodBeat.i(89523);
    paramString = (Double)zza(paramString, paramDouble);
    AppMethodBeat.o(89523);
    return paramString;
  }
  
  public final Float zza(String paramString, Float paramFloat)
  {
    AppMethodBeat.i(89524);
    paramString = (Float)zza(paramString, paramFloat);
    AppMethodBeat.o(89524);
    return paramString;
  }
  
  public final Integer zza(String paramString, Integer paramInteger)
  {
    AppMethodBeat.i(89522);
    paramString = (Integer)zza(paramString, paramInteger);
    AppMethodBeat.o(89522);
    return paramString;
  }
  
  public final String zzb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(89527);
    paramString1 = (String)zza(paramString1, paramString2);
    AppMethodBeat.o(89527);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.config.GservicesValue.zzc
 * JD-Core Version:    0.7.0.1
 */