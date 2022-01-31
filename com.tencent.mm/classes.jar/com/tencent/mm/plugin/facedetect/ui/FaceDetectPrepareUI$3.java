package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FaceDetectPrepareUI$3
  implements View.OnClickListener
{
  FaceDetectPrepareUI$3(FaceDetectPrepareUI paramFaceDetectPrepareUI, int paramInt1, int paramInt2, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(402);
    this.mlC.a(this.val$errType, this.val$errCode, this.ftO, null);
    AppMethodBeat.o(402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.3
 * JD-Core Version:    0.7.0.1
 */