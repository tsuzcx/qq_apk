package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzai;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzg
  extends AccountTransferClient.zzf
{
  zzg(AccountTransferClient paramAccountTransferClient, zzai paramzzai)
  {
    super(null);
  }
  
  protected final void zzd(zzac paramzzac)
  {
    AppMethodBeat.i(10653);
    paramzzac.zzd(this.zzbi, this.zzaz);
    AppMethodBeat.o(10653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.zzg
 * JD-Core Version:    0.7.0.1
 */