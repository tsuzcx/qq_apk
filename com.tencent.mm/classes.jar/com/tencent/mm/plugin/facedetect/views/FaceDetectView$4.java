package com.tencent.mm.plugin.facedetect.views;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class FaceDetectView$4
  implements c
{
  public FaceDetectView$4(FaceDetectView paramFaceDetectView, c paramc) {}
  
  public final void Cg(int paramInt)
  {
    AppMethodBeat.i(104143);
    ad.i("MicroMsg.FaceDetectView", "hy: camera preview init done : %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      FaceDetectView.a(this.pVK, false);
      FaceDetectView.h(this.pVK);
    }
    if (this.pVN != null) {
      this.pVN.Cg(paramInt);
    }
    AppMethodBeat.o(104143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectView.4
 * JD-Core Version:    0.7.0.1
 */