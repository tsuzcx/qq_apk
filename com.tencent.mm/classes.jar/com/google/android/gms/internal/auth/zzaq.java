package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaq
  extends zzam
{
  zzaq(zzap paramzzap) {}
  
  public final void zzd(Status paramStatus, Credential paramCredential)
  {
    AppMethodBeat.i(88374);
    this.zzds.setResult(new zzan(paramStatus, paramCredential));
    AppMethodBeat.o(88374);
  }
  
  public final void zze(Status paramStatus)
  {
    AppMethodBeat.i(88375);
    this.zzds.setResult(zzan.zzf(paramStatus));
    AppMethodBeat.o(88375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzaq
 * JD-Core Version:    0.7.0.1
 */