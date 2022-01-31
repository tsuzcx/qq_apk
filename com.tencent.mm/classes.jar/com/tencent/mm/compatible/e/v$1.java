package com.tencent.mm.compatible.e;

import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class v$1
  implements Runnable
{
  v$1(Camera[] paramArrayOfCamera, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(93008);
    this.eqI[0] = Camera.open(this.eqJ);
    synchronized (v.access$000())
    {
      try
      {
        v.access$000().notifyAll();
        ab.i("MicroMsg.MMCamera", "openCamera notifyAll");
        AppMethodBeat.o(93008);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.MMCamera", localException, "MMCamera_openLooperNull notify error", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.e.v.1
 * JD-Core Version:    0.7.0.1
 */