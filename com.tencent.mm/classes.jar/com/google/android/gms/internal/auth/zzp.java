package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzp
  extends zzq
{
  zzp(zzo paramzzo) {}
  
  public final void zzd(boolean paramBoolean)
  {
    AppMethodBeat.i(77142);
    zzo localzzo = this.zzai;
    if (paramBoolean) {}
    for (Status localStatus = Status.RESULT_SUCCESS;; localStatus = zzk.zzf())
    {
      localzzo.setResult(new zzt(localStatus));
      AppMethodBeat.o(77142);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzp
 * JD-Core Version:    0.7.0.1
 */