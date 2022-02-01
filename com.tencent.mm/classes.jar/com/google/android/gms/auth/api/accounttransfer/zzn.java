package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzv;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzn
  extends zzv
{
  zzn(AccountTransferClient.zzf paramzzf) {}
  
  public final void onFailure(Status paramStatus)
  {
    AppMethodBeat.i(10661);
    this.zzbj.zzd(paramStatus);
    AppMethodBeat.o(10661);
  }
  
  public final void zzi()
  {
    AppMethodBeat.i(10660);
    this.zzbj.setResult(null);
    AppMethodBeat.o(10660);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.zzn
 * JD-Core Version:    0.7.0.1
 */