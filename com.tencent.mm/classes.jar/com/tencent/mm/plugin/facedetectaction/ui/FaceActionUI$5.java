package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetectaction.b.d;

final class FaceActionUI$5
  implements View.OnClickListener
{
  FaceActionUI$5(FaceActionUI paramFaceActionUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(722);
    d.mqx.onBackPressed();
    this.mrl.finish();
    AppMethodBeat.o(722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.5
 * JD-Core Version:    0.7.0.1
 */