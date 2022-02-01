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
    AppMethodBeat.i(103883);
    if (paramBoolean)
    {
      FaceDetectConfirmUI.b(this.pRw).setEnabled(true);
      AppMethodBeat.o(103883);
      return;
    }
    FaceDetectConfirmUI.b(this.pRw).setEnabled(false);
    AppMethodBeat.o(103883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.2
 * JD-Core Version:    0.7.0.1
 */