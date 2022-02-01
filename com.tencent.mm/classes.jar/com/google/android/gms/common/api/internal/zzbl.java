package com.google.android.gms.common.api.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbl
  implements BaseGmsClient.SignOutCallbacks
{
  zzbl(GoogleApiManager.zza paramzza) {}
  
  public final void onSignOutComplete()
  {
    AppMethodBeat.i(11332);
    GoogleApiManager.zza(this.zzkk.zzjy).post(new zzbm(this));
    AppMethodBeat.o(11332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzbl
 * JD-Core Version:    0.7.0.1
 */