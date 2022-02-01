package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzae;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm
  extends AccountTransferClient.zzf
{
  zzm(AccountTransferClient paramAccountTransferClient, zzae paramzzae)
  {
    super(null);
  }
  
  protected final void zzd(zzac paramzzac)
  {
    AppMethodBeat.i(10659);
    paramzzac.zzd(this.zzbi, this.zzbf);
    AppMethodBeat.o(10659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.zzm
 * JD-Core Version:    0.7.0.1
 */