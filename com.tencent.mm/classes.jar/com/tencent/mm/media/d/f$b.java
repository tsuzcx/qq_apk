package com.tencent.mm.media.d;

import a.l;
import android.media.MediaCodec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class f$b
  implements Runnable
{
  f$b(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(12957);
    try
    {
      ab.i(this.eUG.TAG, "finishEncode, isEnd:" + this.eUG.eRq);
      if (this.eUG.eRq)
      {
        AppMethodBeat.o(12957);
        return;
      }
      this.eUG.eRq = true;
      this.eUG.eUg.signalEndOfInputStream();
      AppMethodBeat.o(12957);
      return;
    }
    catch (Exception localException)
    {
      ab.e(this.eUG.TAG, "release encoder error " + localException.getMessage());
      AppMethodBeat.o(12957);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.d.f.b
 * JD-Core Version:    0.7.0.1
 */