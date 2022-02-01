package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzau
  extends zzam
{
  private BaseImplementation.ResultHolder<Status> zzdu;
  
  zzau(BaseImplementation.ResultHolder<Status> paramResultHolder)
  {
    this.zzdu = paramResultHolder;
  }
  
  public final void zze(Status paramStatus)
  {
    AppMethodBeat.i(88379);
    this.zzdu.setResult(paramStatus);
    AppMethodBeat.o(88379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzau
 * JD-Core Version:    0.7.0.1
 */