package com.tencent.mm.plugin.facedetect.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FaceDetectConfirmUI$2
  implements CompoundButton.OnCheckedChangeListener
{
  FaceDetectConfirmUI$2(FaceDetectConfirmUI paramFaceDetectConfirmUI) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(364);
    if (paramBoolean)
    {
      FaceDetectConfirmUI.b(this.mkL).setEnabled(true);
      AppMethodBeat.o(364);
      return;
    }
    FaceDetectConfirmUI.b(this.mkL).setEnabled(false);
    AppMethodBeat.o(364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.2
 * JD-Core Version:    0.7.0.1
 */