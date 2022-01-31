package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FaceActionUI$8
  implements View.OnClickListener
{
  FaceActionUI$8(FaceActionUI paramFaceActionUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(726);
    ab.i("MicroMsg.FaceActionUI", "click finish");
    this.mrl.t("fail", 90010, "");
    AppMethodBeat.o(726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.8
 * JD-Core Version:    0.7.0.1
 */