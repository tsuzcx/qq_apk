package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;

abstract class zzvd<R extends Result>
  extends zzaad.zza<R, zzvf>
{
  zzvd(GoogleApiClient paramGoogleApiClient)
  {
    super(Auth.CREDENTIALS_API, paramGoogleApiClient);
  }
  
  protected abstract void zza(Context paramContext, zzvl paramzzvl);
  
  protected final void zza(zzvf paramzzvf)
  {
    zza(paramzzvf.getContext(), (zzvl)paramzzvf.zzxD());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzvd
 * JD-Core Version:    0.7.0.1
 */