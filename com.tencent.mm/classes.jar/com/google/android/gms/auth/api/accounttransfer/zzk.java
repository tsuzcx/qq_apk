package com.google.android.gms.auth.api.accounttransfer;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzk
  extends AccountTransferClient.zzd<DeviceMetaData>
{
  zzk(zzj paramzzj, AccountTransferClient.zze paramzze)
  {
    super(paramzze);
  }
  
  public final void zzd(DeviceMetaData paramDeviceMetaData)
  {
    AppMethodBeat.i(76998);
    this.zzbd.setResult(paramDeviceMetaData);
    AppMethodBeat.o(76998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.zzk
 * JD-Core Version:    0.7.0.1
 */