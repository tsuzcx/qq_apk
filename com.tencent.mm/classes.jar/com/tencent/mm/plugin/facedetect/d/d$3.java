package com.tencent.mm.plugin.facedetect.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;

final class d$3
  implements Runnable
{
  d$3(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(103831);
    for (;;)
    {
      synchronized (this.pQN.pQH)
      {
        if (this.pQN.pQu >= this.pQN.pQt.length - 1)
        {
          ad.i("MicroMsg.NumberFaceMotion", "hy: already last. handle upper judge.");
          this.pQN.pQc = true;
          Object localObject3 = f.pOM;
          byte[] arrayOfByte = i.aR(this.pQN.pQs.pPT, -1, -1);
          localObject3 = ((f)localObject3).pON.pQQ;
          if (((g)localObject3).pOQ == null)
          {
            ad.e("MicroMsg.FaceDetectNativeManager", "hy: set face data instance null!");
            AppMethodBeat.o(103831);
            return;
          }
          ((g)localObject3).pOQ.engineSetVoiceData(arrayOfByte);
        }
      }
      ad.i("MicroMsg.NumberFaceMotion", "hy: startShowNext");
      d locald = this.pQN;
      locald.pQu += 1;
      this.pQN.pQv = -1;
      this.pQN.kv(true);
      this.pQN.cgp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.d.3
 * JD-Core Version:    0.7.0.1
 */