package com.tencent.mm.bj;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

final class h$2
  implements Runnable
{
  h$2(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(50945);
    h localh = this.fZl;
    ab.i("MicroMsg.VideoTranscoder", "waitEncoderFinish: %s %s %s %s %s", new Object[] { localh.fYZ, localh.fZa, Boolean.valueOf(localh.fYP), localh.fZc, localh.fZd });
    if (localh.fYP)
    {
      if ((localh.fYZ == null) || (localh.fZa == null)) {
        break label200;
      }
      localh.fYZ.fZn = true;
      try
      {
        localh.fZa.join();
        d.ysm.remove(localh.fYZ);
        AppMethodBeat.o(50945);
        return;
      }
      catch (Exception localException1)
      {
        ab.printErrStackTrace("MicroMsg.VideoTranscoder", localException1, "waitEncoderFinish, join error: %s", new Object[] { localException1.getMessage() });
        AppMethodBeat.o(50945);
        return;
      }
    }
    if ((localException1.fZc != null) && (localException1.fZd != null)) {
      try
      {
        localException1.fZc.quitSafely();
        localException1.fZc.join();
        localException1.fZd = null;
        AppMethodBeat.o(50945);
        return;
      }
      catch (Exception localException2)
      {
        ab.printErrStackTrace("MicroMsg.VideoTranscoder", localException2, "waitEncoderFinish, join error: %s", new Object[] { localException2.getMessage() });
      }
    }
    label200:
    AppMethodBeat.o(50945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bj.h.2
 * JD-Core Version:    0.7.0.1
 */