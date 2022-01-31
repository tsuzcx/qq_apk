package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.c.a;

final class FaceDetectPrepareUI$12
  implements FaceDetectPrepareUI.c
{
  FaceDetectPrepareUI$12(FaceDetectPrepareUI paramFaceDetectPrepareUI) {}
  
  public final void s(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(415);
    if (FaceDetectPrepareUI.b(this.mlC) != null) {
      FaceDetectPrepareUI.b(this.mlC).c(paramInt1, paramInt2, paramString, null);
    }
    AppMethodBeat.o(415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.12
 * JD-Core Version:    0.7.0.1
 */