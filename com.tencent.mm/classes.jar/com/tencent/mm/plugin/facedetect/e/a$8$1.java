package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

final class a$8$1
  implements Runnable
{
  a$8$1(a.8 param8) {}
  
  public final void run()
  {
    AppMethodBeat.i(552);
    synchronized (a.a(this.mnR.mnI))
    {
      ab.i("MicroMsg.FaceVideoRecorder", "carson: begin to stop" + a.g(this.mnR.mnI).getFilePath());
      a.a(this.mnR.mnI, a.a.mnW);
      e.deleteFile(a.h(this.mnR.mnI));
      if (a.r(this.mnR.mnI) != null) {
        a.r(this.mnR.mnI).Ns(a.g(this.mnR.mnI).getFilePath());
      }
      AppMethodBeat.o(552);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.8.1
 * JD-Core Version:    0.7.0.1
 */