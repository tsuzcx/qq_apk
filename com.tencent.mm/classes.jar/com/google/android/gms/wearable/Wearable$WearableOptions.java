package com.google.android.gms.wearable;

import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi.Settings.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Wearable$WearableOptions
  implements Api.ApiOptions.Optional
{
  private final Looper zzac;
  
  private Wearable$WearableOptions(Wearable.WearableOptions.Builder paramBuilder)
  {
    AppMethodBeat.i(70890);
    this.zzac = Wearable.WearableOptions.Builder.zza(paramBuilder);
    AppMethodBeat.o(70890);
  }
  
  private final GoogleApi.Settings zza()
  {
    AppMethodBeat.i(70891);
    if (this.zzac != null)
    {
      localSettings = new GoogleApi.Settings.Builder().setLooper(this.zzac).build();
      AppMethodBeat.o(70891);
      return localSettings;
    }
    GoogleApi.Settings localSettings = GoogleApi.Settings.DEFAULT_SETTINGS;
    AppMethodBeat.o(70891);
    return localSettings;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.Wearable.WearableOptions
 * JD-Core Version:    0.7.0.1
 */