package com.google.android.gms.common.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzd
  extends GservicesValue<Double>
{
  zzd(String paramString, Double paramDouble)
  {
    super(paramString, paramDouble);
  }
  
  private static Double zza(Context paramContext, String paramString, Double paramDouble)
  {
    AppMethodBeat.i(4567);
    paramContext = paramContext.getSharedPreferences("gservices-direboot-cache", 0).getString(paramString, null);
    if (paramContext != null) {
      try
      {
        double d = Double.parseDouble(paramContext);
        AppMethodBeat.o(4567);
        return Double.valueOf(d);
      }
      catch (NumberFormatException paramContext) {}
    }
    AppMethodBeat.o(4567);
    return paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.config.zzd
 * JD-Core Version:    0.7.0.1
 */