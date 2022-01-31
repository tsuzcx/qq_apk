package com.tencent.mm.plugin.facedetect.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class d$7
  implements Runnable
{
  d$7(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(317);
    synchronized (this.mkc.mjW)
    {
      if (!this.mkc.mjQ)
      {
        ab.w("MicroMsg.NumberFaceMotion", "hy: not triggered symbol. auto start");
        this.mkc.mjQ = true;
        d.b(this.mkc);
        AppMethodBeat.o(317);
        return;
      }
      ab.i("MicroMsg.NumberFaceMotion", "hy: user already start. do nothing");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.d.7
 * JD-Core Version:    0.7.0.1
 */