package com.google.android.gms.common.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzc
  extends GservicesValue<Integer>
{
  zzc(String paramString, Integer paramInteger)
  {
    super(paramString, paramInteger);
  }
  
  private static Integer zza(Context paramContext, String paramString, Integer paramInteger)
  {
    AppMethodBeat.i(4564);
    paramContext = paramContext.getSharedPreferences("gservices-direboot-cache", 0).getString(paramString, null);
    if (paramContext != null) {
      try
      {
        int i = Integer.parseInt(paramContext);
        AppMethodBeat.o(4564);
        return Integer.valueOf(i);
      }
      catch (NumberFormatException paramContext) {}
    }
    AppMethodBeat.o(4564);
    return paramInteger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.config.zzc
 * JD-Core Version:    0.7.0.1
 */