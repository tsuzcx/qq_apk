package com.tencent.mm.plugin.facedetect.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class FaceDetectProcessService$2
  implements Runnable
{
  FaceDetectProcessService$2(FaceDetectProcessService paramFaceDetectProcessService, q paramq) {}
  
  public final void run()
  {
    AppMethodBeat.i(339);
    ab.i("MicroMsg.FaceDetectProcessService", "alvinluo service do release out");
    al.d(new FaceDetectProcessService.2.1(this, this.mki.mkf.buy()));
    AppMethodBeat.o(339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService.2
 * JD-Core Version:    0.7.0.1
 */