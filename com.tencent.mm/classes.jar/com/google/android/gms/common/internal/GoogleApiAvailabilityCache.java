package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api.Client;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleApiAvailabilityCache
{
  private final SparseIntArray zzug;
  private GoogleApiAvailabilityLight zzuh;
  
  public GoogleApiAvailabilityCache()
  {
    this(GoogleApiAvailability.getInstance());
    AppMethodBeat.i(11839);
    AppMethodBeat.o(11839);
  }
  
  public GoogleApiAvailabilityCache(GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight)
  {
    AppMethodBeat.i(11840);
    this.zzug = new SparseIntArray();
    Preconditions.checkNotNull(paramGoogleApiAvailabilityLight);
    this.zzuh = paramGoogleApiAvailabilityLight;
    AppMethodBeat.o(11840);
  }
  
  public void flush()
  {
    AppMethodBeat.i(11842);
    this.zzug.clear();
    AppMethodBeat.o(11842);
  }
  
  public int getClientAvailability(Context paramContext, Api.Client paramClient)
  {
    AppMethodBeat.i(11841);
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramClient);
    if (!paramClient.requiresGooglePlayServices())
    {
      AppMethodBeat.o(11841);
      return 0;
    }
    int k = paramClient.getMinApkVersion();
    int j = this.zzug.get(k, -1);
    if (j != -1)
    {
      AppMethodBeat.o(11841);
      return j;
    }
    int i = 0;
    if (i < this.zzug.size())
    {
      int m = this.zzug.keyAt(i);
      if ((m <= k) || (this.zzug.get(m) != 0)) {}
    }
    for (i = 0;; i = j)
    {
      j = i;
      if (i == -1) {
        j = this.zzuh.isGooglePlayServicesAvailable(paramContext, k);
      }
      this.zzug.put(k, j);
      AppMethodBeat.o(11841);
      return j;
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.GoogleApiAvailabilityCache
 * JD-Core Version:    0.7.0.1
 */