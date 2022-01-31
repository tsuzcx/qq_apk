package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.facedetect.c.a;

final class FaceDetectPrepareUI$2
  implements View.OnClickListener
{
  FaceDetectPrepareUI$2(FaceDetectPrepareUI paramFaceDetectPrepareUI, boolean paramBoolean, FaceDetectPrepareUI.c paramc, int paramInt1, int paramInt2, String paramString) {}
  
  public final void onClick(View paramView)
  {
    if (this.jRh)
    {
      if (FaceDetectPrepareUI.b(this.jRg) != null) {
        FaceDetectPrepareUI.b(this.jRg).aNZ();
      }
      return;
    }
    if (this.jRi != null) {
      this.jRi.n(this.bEf, this.bEg, this.edL);
    }
    this.jRg.a(this.bEf, this.bEg, this.edL, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.2
 * JD-Core Version:    0.7.0.1
 */