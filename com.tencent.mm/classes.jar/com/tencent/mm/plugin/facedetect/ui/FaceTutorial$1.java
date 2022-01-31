package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FaceTutorial$1
  implements View.OnClickListener
{
  FaceTutorial$1(FaceTutorial paramFaceTutorial) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(516);
    if (this.mmE.mmD != null) {
      this.mmE.mmD.onCancel();
    }
    this.mmE.dismiss();
    AppMethodBeat.o(516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceTutorial.1
 * JD-Core Version:    0.7.0.1
 */