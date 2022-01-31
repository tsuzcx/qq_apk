package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class FaceActionUI$6
  implements View.OnClickListener
{
  FaceActionUI$6(FaceActionUI paramFaceActionUI) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.FaceActionUI", "click mUploadFailedConfig");
    FaceActionUI.n(this.jWU);
    this.jWU.u("fail", FaceActionUI.o(this.jWU), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.6
 * JD-Core Version:    0.7.0.1
 */