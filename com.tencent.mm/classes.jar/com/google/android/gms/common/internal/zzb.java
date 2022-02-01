package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;

final class zzb
  extends DialogRedirect
{
  zzb(Intent paramIntent, Activity paramActivity, int paramInt) {}
  
  public final void redirect()
  {
    AppMethodBeat.i(11893);
    if (this.zzsh != null)
    {
      Activity localActivity = this.val$activity;
      Intent localIntent = this.zzsh;
      com.tencent.mm.hellhoundlib.a.a.a(localActivity, c.a(this.val$requestCode, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/google/android/gms/common/internal/zzb", "redirect", "()V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    }
    AppMethodBeat.o(11893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzb
 * JD-Core Version:    0.7.0.1
 */