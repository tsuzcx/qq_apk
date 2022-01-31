package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzb
{
  private SharedPreferences zzs;
  
  public zzb(Context paramContext)
  {
    AppMethodBeat.i(115340);
    try
    {
      paramContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      if (paramContext == null) {}
      for (paramContext = null;; paramContext = paramContext.getSharedPreferences("google_ads_flags", 0))
      {
        this.zzs = paramContext;
        AppMethodBeat.o(115340);
        return;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      this.zzs = null;
      AppMethodBeat.o(115340);
    }
  }
  
  public final boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(115341);
    try
    {
      SharedPreferences localSharedPreferences = this.zzs;
      if (localSharedPreferences == null)
      {
        AppMethodBeat.o(115341);
        return false;
      }
      paramBoolean = this.zzs.getBoolean(paramString, false);
      AppMethodBeat.o(115341);
      return paramBoolean;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(115341);
    }
    return false;
  }
  
  final float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(115342);
    try
    {
      SharedPreferences localSharedPreferences = this.zzs;
      if (localSharedPreferences == null)
      {
        AppMethodBeat.o(115342);
        return 0.0F;
      }
      paramFloat = this.zzs.getFloat(paramString, 0.0F);
      AppMethodBeat.o(115342);
      return paramFloat;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(115342);
    }
    return 0.0F;
  }
  
  final String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(115343);
    try
    {
      SharedPreferences localSharedPreferences = this.zzs;
      if (localSharedPreferences == null)
      {
        AppMethodBeat.o(115343);
        return paramString2;
      }
      paramString1 = this.zzs.getString(paramString1, paramString2);
      AppMethodBeat.o(115343);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(115343);
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.ads.identifier.zzb
 * JD-Core Version:    0.7.0.1
 */