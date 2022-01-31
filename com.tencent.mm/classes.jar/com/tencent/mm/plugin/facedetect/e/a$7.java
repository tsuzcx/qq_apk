package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$7
  implements Runnable
{
  a$7(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(551);
    synchronized (a.a(this.mnI))
    {
      if (a.n(this.mnI) == a.a.mnS)
      {
        ab.e("MicroMsg.FaceVideoRecorder", "hy: not started when cancel. should not happen");
        a.d(this.mnI);
        AppMethodBeat.o(551);
        return;
      }
      ab.i("MicroMsg.FaceVideoRecorder", "hy: cancel record");
      a.g(this.mnI).cancel();
      a.d(this.mnI);
      com.tencent.mm.plugin.facedetect.model.d.bui().b(a.o(this.mnI));
      a.a(this.mnI, a.a.mnX);
      a.m(this.mnI).release();
      AppMethodBeat.o(551);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.7
 * JD-Core Version:    0.7.0.1
 */