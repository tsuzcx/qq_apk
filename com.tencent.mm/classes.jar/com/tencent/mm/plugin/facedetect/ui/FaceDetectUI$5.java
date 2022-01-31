package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.views.c;
import com.tencent.mm.sdk.platformtools.ab;

final class FaceDetectUI$5
  implements c
{
  FaceDetectUI$5(FaceDetectUI paramFaceDetectUI) {}
  
  public final void vO(int paramInt)
  {
    AppMethodBeat.i(463);
    ab.i("MicroMsg.FaceDetectUI", "alvinluo onPreviewInitDone: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      FaceDetectUI.f(this.mmb);
      AppMethodBeat.o(463);
      return;
    }
    if (paramInt == 1)
    {
      FaceDetectUI.g(this.mmb);
      AppMethodBeat.o(463);
      return;
    }
    if (paramInt == 2) {
      FaceDetectUI.a(this.mmb, "camera permission not granted", this.mmb.getString(2131302067));
    }
    AppMethodBeat.o(463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.5
 * JD-Core Version:    0.7.0.1
 */