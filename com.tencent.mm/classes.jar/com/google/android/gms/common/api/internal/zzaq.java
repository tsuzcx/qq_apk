package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.BaseSignInCallbacks;
import com.google.android.gms.signin.internal.SignInResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class zzaq
  extends BaseSignInCallbacks
{
  private final WeakReference<zzaj> zzhw;
  
  zzaq(zzaj paramzzaj)
  {
    AppMethodBeat.i(60756);
    this.zzhw = new WeakReference(paramzzaj);
    AppMethodBeat.o(60756);
  }
  
  public final void onSignInComplete(SignInResponse paramSignInResponse)
  {
    AppMethodBeat.i(60757);
    zzaj localzzaj = (zzaj)this.zzhw.get();
    if (localzzaj == null)
    {
      AppMethodBeat.o(60757);
      return;
    }
    zzaj.zzd(localzzaj).zza(new zzar(this, localzzaj, localzzaj, paramSignInResponse));
    AppMethodBeat.o(60757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzaq
 * JD-Core Version:    0.7.0.1
 */