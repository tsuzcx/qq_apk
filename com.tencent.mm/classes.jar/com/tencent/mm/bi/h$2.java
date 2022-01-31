package com.tencent.mm.bi;

import android.os.HandlerThread;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;

final class h$2
  implements Runnable
{
  h$2(h paramh) {}
  
  public final void run()
  {
    h localh = this.eJI;
    y.i("MicroMsg.VideoTranscoder", "waitEncoderFinish: %s %s %s %s %s", new Object[] { localh.eJv, localh.eJw, Boolean.valueOf(localh.eJu), localh.eJy, localh.eJz });
    if (localh.eJu) {
      if ((localh.eJv != null) && (localh.eJw != null)) {
        localh.eJv.eJM = true;
      }
    }
    while ((localException1.eJy == null) || (localException1.eJz == null)) {
      try
      {
        localh.eJw.join();
        e.remove(localh.eJv);
        return;
      }
      catch (Exception localException1)
      {
        y.printErrStackTrace("MicroMsg.VideoTranscoder", localException1, "waitEncoderFinish, join error: %s", new Object[] { localException1.getMessage() });
        return;
      }
    }
    try
    {
      localException1.eJy.quitSafely();
      localException1.eJy.join();
      localException1.eJz = null;
      return;
    }
    catch (Exception localException2)
    {
      y.printErrStackTrace("MicroMsg.VideoTranscoder", localException2, "waitEncoderFinish, join error: %s", new Object[] { localException2.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bi.h.2
 * JD-Core Version:    0.7.0.1
 */