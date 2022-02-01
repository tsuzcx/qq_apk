package com.google.android.gms.common.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza
  extends GservicesValue<Boolean>
{
  zza(String paramString, Boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  private static Boolean zza(Context paramContext, String paramString, Boolean paramBoolean)
  {
    AppMethodBeat.i(4558);
    paramContext = paramContext.getSharedPreferences("gservices-direboot-cache", 0).getString(paramString, null);
    if (paramContext != null) {
      try
      {
        boolean bool = Boolean.parseBoolean(paramContext);
        AppMethodBeat.o(4558);
        return Boolean.valueOf(bool);
      }
      catch (NumberFormatException paramContext) {}
    }
    AppMethodBeat.o(4558);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.config.zza
 * JD-Core Version:    0.7.0.1
 */