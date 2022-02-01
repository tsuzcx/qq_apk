package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzag;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzh
  extends AccountTransferClient.zze<byte[]>
{
  zzh(AccountTransferClient paramAccountTransferClient, zzag paramzzag)
  {
    super(null);
  }
  
  protected final void zzd(zzac paramzzac)
  {
    AppMethodBeat.i(10654);
    paramzzac.zzd(new zzi(this, this), this.zzba);
    AppMethodBeat.o(10654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.zzh
 * JD-Core Version:    0.7.0.1
 */