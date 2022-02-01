package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FaceDetectConfirmUI$3
  implements View.OnClickListener
{
  FaceDetectConfirmUI$3(FaceDetectConfirmUI paramFaceDetectConfirmUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(103884);
    paramView = FaceDetectConfirmUI.c(this.pRw);
    if (!FaceDetectConfirmUI.c(this.pRw).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      AppMethodBeat.o(103884);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.3
 * JD-Core Version:    0.7.0.1
 */