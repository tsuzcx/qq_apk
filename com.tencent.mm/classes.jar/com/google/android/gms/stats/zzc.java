package com.google.android.gms.stats;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class zzc
  implements Runnable
{
  zzc(WeakReference paramWeakReference) {}
  
  public final void run()
  {
    AppMethodBeat.i(73494);
    WakeLock.HeldLock localHeldLock = (WakeLock.HeldLock)this.zzaej.get();
    if (localHeldLock != null) {
      localHeldLock.release(0);
    }
    AppMethodBeat.o(73494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.stats.zzc
 * JD-Core Version:    0.7.0.1
 */