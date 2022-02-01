package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzig
  implements Runnable
{
  zzig(zzif paramzzif, boolean paramBoolean, zzie paramzzie1, zzie paramzzie2) {}
  
  public final void run()
  {
    AppMethodBeat.i(1797);
    if ((this.zzaos) && (this.zzaov.zzaol != null)) {
      zzif.zza(this.zzaov, this.zzaov.zzaol);
    }
    if ((this.zzaot == null) || (this.zzaot.zzaoj != this.zzaou.zzaoj) || (!zzka.zzs(this.zzaot.zzaoi, this.zzaou.zzaoi)) || (!zzka.zzs(this.zzaot.zzul, this.zzaou.zzul))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Bundle localBundle = new Bundle();
        zzif.zza(this.zzaou, localBundle, true);
        if (this.zzaot != null)
        {
          if (this.zzaot.zzul != null) {
            localBundle.putString("_pn", this.zzaot.zzul);
          }
          localBundle.putString("_pc", this.zzaot.zzaoi);
          localBundle.putLong("_pi", this.zzaot.zzaoj);
        }
        this.zzaov.zzfu().zza("auto", "_vs", localBundle);
      }
      this.zzaov.zzaol = this.zzaou;
      this.zzaov.zzfx().zzb(this.zzaou);
      AppMethodBeat.o(1797);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzig
 * JD-Core Version:    0.7.0.1
 */