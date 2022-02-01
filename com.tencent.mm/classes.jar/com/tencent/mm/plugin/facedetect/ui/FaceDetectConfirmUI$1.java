package com.tencent.mm.plugin.facedetect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class FaceDetectConfirmUI$1
  implements MenuItem.OnMenuItemClickListener
{
  FaceDetectConfirmUI$1(FaceDetectConfirmUI paramFaceDetectConfirmUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(103882);
    Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo cancel with back button");
    FaceDetectConfirmUI.a(this.zVB);
    AppMethodBeat.o(103882);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.1
 * JD-Core Version:    0.7.0.1
 */