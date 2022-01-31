package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzv;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AccountTransferClient$zzd<T>
  extends zzv
{
  private AccountTransferClient.zze<T> zzbg;
  
  public AccountTransferClient$zzd(AccountTransferClient.zze<T> paramzze)
  {
    this.zzbg = paramzze;
  }
  
  public final void onFailure(Status paramStatus)
  {
    AppMethodBeat.i(76978);
    this.zzbg.zzd(paramStatus);
    AppMethodBeat.o(76978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.AccountTransferClient.zzd
 * JD-Core Version:    0.7.0.1
 */