package com.google.android.gms.internal;

import android.os.Bundle;

class zzabg$1
  implements Runnable
{
  zzabg$1(zzabg paramzzabg, zzabe paramzzabe, String paramString) {}
  
  public void run()
  {
    zzabe localzzabe;
    if (zzabg.zza(this.zzaCW) > 0)
    {
      localzzabe = this.zzaCV;
      if (zzabg.zzb(this.zzaCW) == null) {
        break label100;
      }
    }
    label100:
    for (Bundle localBundle = zzabg.zzb(this.zzaCW).getBundle(this.zzP);; localBundle = null)
    {
      localzzabe.onCreate(localBundle);
      if (zzabg.zza(this.zzaCW) >= 2) {
        this.zzaCV.onStart();
      }
      if (zzabg.zza(this.zzaCW) >= 3) {
        this.zzaCV.onStop();
      }
      if (zzabg.zza(this.zzaCW) >= 4) {
        this.zzaCV.onDestroy();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzabg.1
 * JD-Core Version:    0.7.0.1
 */