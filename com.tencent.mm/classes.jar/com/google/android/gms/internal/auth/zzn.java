package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzn
  extends zzq
{
  zzn(zzm paramzzm) {}
  
  public final void zzf(Account paramAccount)
  {
    AppMethodBeat.i(77139);
    zzm localzzm = this.zzah;
    if (paramAccount != null) {}
    for (Status localStatus = Status.RESULT_SUCCESS;; localStatus = zzk.zzf())
    {
      localzzm.setResult(new zzr(localStatus, paramAccount));
      AppMethodBeat.o(77139);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzn
 * JD-Core Version:    0.7.0.1
 */