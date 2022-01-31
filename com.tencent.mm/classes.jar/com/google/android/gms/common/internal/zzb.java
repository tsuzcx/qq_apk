package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb
  extends DialogRedirect
{
  zzb(Intent paramIntent, Activity paramActivity, int paramInt) {}
  
  public final void redirect()
  {
    AppMethodBeat.i(61401);
    if (this.zzsh != null) {
      this.val$activity.startActivityForResult(this.zzsh, this.val$requestCode);
    }
    AppMethodBeat.o(61401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzb
 * JD-Core Version:    0.7.0.1
 */