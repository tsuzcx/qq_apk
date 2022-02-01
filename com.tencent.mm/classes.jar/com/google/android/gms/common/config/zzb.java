package com.google.android.gms.common.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb
  extends GservicesValue<Long>
{
  zzb(String paramString, Long paramLong)
  {
    super(paramString, paramLong);
  }
  
  private static Long zza(Context paramContext, String paramString, Long paramLong)
  {
    AppMethodBeat.i(4561);
    paramContext = paramContext.getSharedPreferences("gservices-direboot-cache", 0).getString(paramString, null);
    if (paramContext != null) {
      try
      {
        long l = Long.parseLong(paramContext);
        AppMethodBeat.o(4561);
        return Long.valueOf(l);
      }
      catch (NumberFormatException paramContext) {}
    }
    AppMethodBeat.o(4561);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.config.zzb
 * JD-Core Version:    0.7.0.1
 */