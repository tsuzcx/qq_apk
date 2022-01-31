package com.tencent.mm.plugin.facedetect.views;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class FaceDetectView$4
  implements c
{
  public FaceDetectView$4(FaceDetectView paramFaceDetectView, c paramc) {}
  
  public final void vO(int paramInt)
  {
    AppMethodBeat.i(623);
    ab.i("MicroMsg.FaceDetectView", "hy: camera preview init done : %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      FaceDetectView.a(this.mpb, false);
      FaceDetectView.h(this.mpb);
    }
    if (this.mpe != null) {
      this.mpe.vO(paramInt);
    }
    AppMethodBeat.o(623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectView.4
 * JD-Core Version:    0.7.0.1
 */