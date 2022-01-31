package com.tencent.mm.plugin.facedetect.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class FaceDetectConfirmUI$2
  implements CompoundButton.OnCheckedChangeListener
{
  FaceDetectConfirmUI$2(FaceDetectConfirmUI paramFaceDetectConfirmUI) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      FaceDetectConfirmUI.b(this.jQq).setEnabled(true);
      return;
    }
    FaceDetectConfirmUI.b(this.jQq).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.2
 * JD-Core Version:    0.7.0.1
 */