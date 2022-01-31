package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzat
  extends zzav<Status>
{
  zzat(zzao paramzzao, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }
  
  protected final void zzd(Context paramContext, zzbc paramzzbc)
  {
    AppMethodBeat.i(50483);
    paramzzbc.zzd(new zzau(this));
    AppMethodBeat.o(50483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzat
 * JD-Core Version:    0.7.0.1
 */