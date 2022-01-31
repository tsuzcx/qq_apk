package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class zzi$1
  extends zzi
{
  zzi$1(Intent paramIntent, Activity paramActivity, int paramInt) {}
  
  public final void zzxT()
  {
    if (this.val$intent != null) {
      this.val$activity.startActivityForResult(this.val$intent, this.val$requestCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzi.1
 * JD-Core Version:    0.7.0.1
 */