package com.google.android.gms.common.internal;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzc
  extends DialogRedirect
{
  zzc(Intent paramIntent, Fragment paramFragment, int paramInt) {}
  
  public final void redirect()
  {
    AppMethodBeat.i(61402);
    if (this.zzsh != null) {
      this.val$fragment.startActivityForResult(this.zzsh, this.val$requestCode);
    }
    AppMethodBeat.o(61402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzc
 * JD-Core Version:    0.7.0.1
 */