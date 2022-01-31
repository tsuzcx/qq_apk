package com.google.android.gms.internal;

import android.os.Bundle;

class zzabu$1
  implements Runnable
{
  zzabu$1(zzabu paramzzabu, zzabe paramzzabe, String paramString) {}
  
  public void run()
  {
    zzabe localzzabe;
    if (zzabu.zza(this.zzaDk) > 0)
    {
      localzzabe = this.zzaCV;
      if (zzabu.zzb(this.zzaDk) == null) {
        break label100;
      }
    }
    label100:
    for (Bundle localBundle = zzabu.zzb(this.zzaDk).getBundle(this.zzP);; localBundle = null)
    {
      localzzabe.onCreate(localBundle);
      if (zzabu.zza(this.zzaDk) >= 2) {
        this.zzaCV.onStart();
      }
      if (zzabu.zza(this.zzaDk) >= 3) {
        this.zzaCV.onStop();
      }
      if (zzabu.zza(this.zzaDk) >= 4) {
        this.zzaCV.onDestroy();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzabu.1
 * JD-Core Version:    0.7.0.1
 */