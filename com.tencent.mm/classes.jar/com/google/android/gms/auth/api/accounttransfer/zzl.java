package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzak;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzl
  extends AccountTransferClient.zzf
{
  zzl(AccountTransferClient paramAccountTransferClient, zzak paramzzak)
  {
    super(null);
  }
  
  protected final void zzd(zzac paramzzac)
  {
    AppMethodBeat.i(76999);
    paramzzac.zzd(this.zzbi, this.zzbe);
    AppMethodBeat.o(76999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.zzl
 * JD-Core Version:    0.7.0.1
 */