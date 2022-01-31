package com.tencent.mm.plugin.facedetect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FaceDetectConfirmUI$1
  implements MenuItem.OnMenuItemClickListener
{
  FaceDetectConfirmUI$1(FaceDetectConfirmUI paramFaceDetectConfirmUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(363);
    ab.i("MicroMsg.FaceDetectConfirmUI", "alvinluo cancel with back button");
    FaceDetectConfirmUI.a(this.mkL);
    AppMethodBeat.o(363);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.1
 * JD-Core Version:    0.7.0.1
 */