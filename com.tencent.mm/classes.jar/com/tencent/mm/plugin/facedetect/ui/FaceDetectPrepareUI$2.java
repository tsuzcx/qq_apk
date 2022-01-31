package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.c.a;

final class FaceDetectPrepareUI$2
  implements View.OnClickListener
{
  FaceDetectPrepareUI$2(FaceDetectPrepareUI paramFaceDetectPrepareUI, boolean paramBoolean, FaceDetectPrepareUI.c paramc, int paramInt1, int paramInt2, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(401);
    if (this.mlD)
    {
      if (FaceDetectPrepareUI.b(this.mlC) != null)
      {
        FaceDetectPrepareUI.b(this.mlC).buc();
        AppMethodBeat.o(401);
      }
    }
    else
    {
      if (this.mlE != null) {
        this.mlE.s(this.val$errType, this.val$errCode, this.ftO);
      }
      this.mlC.a(this.val$errType, this.val$errCode, this.ftO, null);
    }
    AppMethodBeat.o(401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.2
 * JD-Core Version:    0.7.0.1
 */