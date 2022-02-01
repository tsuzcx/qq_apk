package com.google.android.gms.common.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zze
  extends GservicesValue<Float>
{
  zze(String paramString, Float paramFloat)
  {
    super(paramString, paramFloat);
  }
  
  private static Float zza(Context paramContext, String paramString, Float paramFloat)
  {
    AppMethodBeat.i(4570);
    paramContext = paramContext.getSharedPreferences("gservices-direboot-cache", 0).getString(paramString, null);
    if (paramContext != null) {
      try
      {
        float f = Float.parseFloat(paramContext);
        AppMethodBeat.o(4570);
        return Float.valueOf(f);
      }
      catch (NumberFormatException paramContext) {}
    }
    AppMethodBeat.o(4570);
    return paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.config.zze
 * JD-Core Version:    0.7.0.1
 */