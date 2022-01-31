package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzy;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzj
  extends AccountTransferClient.zze<DeviceMetaData>
{
  zzj(AccountTransferClient paramAccountTransferClient, zzy paramzzy)
  {
    super(null);
  }
  
  protected final void zzd(zzac paramzzac)
  {
    AppMethodBeat.i(76997);
    paramzzac.zzd(new zzk(this, this), this.zzbc);
    AppMethodBeat.o(76997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.zzj
 * JD-Core Version:    0.7.0.1
 */