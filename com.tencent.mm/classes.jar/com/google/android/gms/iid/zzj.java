package com.google.android.gms.iid;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzj
  implements Runnable
{
  zzj(zzi paramzzi, zzg paramzzg) {}
  
  public final void run()
  {
    AppMethodBeat.i(2522);
    Log.isLoggable("EnhancedIntentService", 3);
    zzi.zzd(this.zzbk).handleIntent(this.zzbj.intent);
    this.zzbj.finish();
    AppMethodBeat.o(2522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.iid.zzj
 * JD-Core Version:    0.7.0.1
 */