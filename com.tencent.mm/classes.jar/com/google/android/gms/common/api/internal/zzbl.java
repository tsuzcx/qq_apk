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
    AppMethodBeat.i(60840);
    GoogleApiManager.zza(this.zzkk.zzjy).post(new zzbm(this));
    AppMethodBeat.o(60840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzbl
 * JD-Core Version:    0.7.0.1
 */