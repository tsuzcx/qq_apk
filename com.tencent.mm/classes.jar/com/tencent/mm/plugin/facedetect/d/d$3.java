package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class d$3
  implements Runnable
{
  d$3(d paramd) {}
  
  public final void run()
  {
    for (;;)
    {
      synchronized (this.jPM.jPG)
      {
        if (this.jPM.jPt >= this.jPM.jPs.length - 1)
        {
          y.i("MicroMsg.NumberFaceMotion", "hy: already last. handle upper judge.");
          this.jPM.jPb = true;
          Object localObject3 = f.jNM;
          byte[] arrayOfByte = e.c(this.jPM.jPr.jOS, -1, -1);
          localObject3 = ((f)localObject3).jNN.jPP;
          if (((g)localObject3).jNQ == null)
          {
            y.e("MicroMsg.FaceDetectNativeManager", "hy: set face data instance null!");
            return;
          }
          ((g)localObject3).jNQ.engineSetVoiceData(arrayOfByte);
        }
      }
      y.i("MicroMsg.NumberFaceMotion", "hy: startShowNext");
      d locald = this.jPM;
      locald.jPt += 1;
      this.jPM.jPu = -1;
      this.jPM.fP(true);
      this.jPM.aOR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.d.3
 * JD-Core Version:    0.7.0.1
 */