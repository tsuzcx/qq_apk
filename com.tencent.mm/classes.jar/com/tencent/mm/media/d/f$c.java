package com.tencent.mm.media.d;

import a.l;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class f$c
  implements Runnable
{
  f$c(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(12958);
    try
    {
      this.eUG.eRb.quitSafely();
      AppMethodBeat.o(12958);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.eUG.TAG, (Throwable)localException, "release error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(12958);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.d.f.c
 * JD-Core Version:    0.7.0.1
 */