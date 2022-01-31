package com.tencent.mm.plugin.facedetect.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

final class d$3
  implements Runnable
{
  d$3(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(312);
    for (;;)
    {
      synchronized (this.mkc.mjW)
      {
        if (this.mkc.mjJ >= this.mkc.mjI.length - 1)
        {
          ab.i("MicroMsg.NumberFaceMotion", "hy: already last. handle upper judge.");
          this.mkc.mjr = true;
          Object localObject3 = f.mhY;
          byte[] arrayOfByte = e.i(this.mkc.mjH.mji, -1, -1);
          localObject3 = ((f)localObject3).mhZ.mkf;
          if (((g)localObject3).mic == null)
          {
            ab.e("MicroMsg.FaceDetectNativeManager", "hy: set face data instance null!");
            AppMethodBeat.o(312);
            return;
          }
          ((g)localObject3).mic.engineSetVoiceData(arrayOfByte);
        }
      }
      ab.i("MicroMsg.NumberFaceMotion", "hy: startShowNext");
      d locald = this.mkc;
      locald.mjJ += 1;
      this.mkc.mjK = -1;
      this.mkc.hs(true);
      this.mkc.buV();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.d.3
 * JD-Core Version:    0.7.0.1
 */