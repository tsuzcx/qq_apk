package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzn
  extends GooglePlayServicesUpdatedReceiver.Callback
{
  zzn(zzm paramzzm, Dialog paramDialog) {}
  
  public final void zzv()
  {
    AppMethodBeat.i(11433);
    this.zzey.zzew.zzt();
    if (this.zzex.isShowing()) {
      this.zzex.dismiss();
    }
    AppMethodBeat.o(11433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzn
 * JD-Core Version:    0.7.0.1
 */