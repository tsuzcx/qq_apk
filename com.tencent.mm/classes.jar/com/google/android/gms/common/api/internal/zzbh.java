package com.google.android.gms.common.api.internal;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbh
  implements BackgroundDetector.BackgroundStateChangeListener
{
  zzbh(GoogleApiManager paramGoogleApiManager) {}
  
  public final void onBackgroundStateChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(11328);
    GoogleApiManager.zza(this.zzjy).sendMessage(GoogleApiManager.zza(this.zzjy).obtainMessage(1, Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(11328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzbh
 * JD-Core Version:    0.7.0.1
 */