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
    AppMethodBeat.i(53030);
    try
    {
      paramContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      if (paramContext == null) {}
      for (paramContext = null;; paramContext = paramContext.getSharedPreferences("google_ads_flags", 0))
      {
        this.zzs = paramContext;
        AppMethodBeat.o(53030);
        return;
      }
      return;
    }
    finally
    {
      this.zzs = null;
      AppMethodBeat.o(53030);
    }
  }
  
  public final boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(53031);
    try
    {
      SharedPreferences localSharedPreferences = this.zzs;
      if (localSharedPreferences == null) {
        return false;
      }
      paramBoolean = this.zzs.getBoolean(paramString, false);
      return paramBoolean;
    }
    finally
    {
      AppMethodBeat.o(53031);
    }
    return false;
  }
  
  final float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(53032);
    try
    {
      SharedPreferences localSharedPreferences = this.zzs;
      if (localSharedPreferences == null) {
        return 0.0F;
      }
      paramFloat = this.zzs.getFloat(paramString, 0.0F);
      return paramFloat;
    }
    finally
    {
      AppMethodBeat.o(53032);
    }
    return 0.0F;
  }
  
  final String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(53033);
    try
    {
      SharedPreferences localSharedPreferences = this.zzs;
      if (localSharedPreferences == null) {
        return paramString2;
      }
      paramString1 = this.zzs.getString(paramString1, paramString2);
      return paramString1;
    }
    finally
    {
      AppMethodBeat.o(53033);
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.ads.identifier.zzb
 * JD-Core Version:    0.7.0.1
 */