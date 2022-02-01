package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzd
  extends DialogRedirect
{
  zzd(Intent paramIntent, LifecycleFragment paramLifecycleFragment, int paramInt) {}
  
  public final void redirect()
  {
    AppMethodBeat.i(11895);
    if (this.zzsh != null) {
      this.zzsi.startActivityForResult(this.zzsh, this.val$requestCode);
    }
    AppMethodBeat.o(11895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzd
 * JD-Core Version:    0.7.0.1
 */