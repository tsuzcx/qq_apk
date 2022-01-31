package com.tencent.mm.plugin.facedetect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class FaceDetectConfirmUI$1
  implements MenuItem.OnMenuItemClickListener
{
  FaceDetectConfirmUI$1(FaceDetectConfirmUI paramFaceDetectConfirmUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    y.i("MicroMsg.FaceDetectConfirmUI", "alvinluo cancel with back button");
    FaceDetectConfirmUI.a(this.jQq);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.1
 * JD-Core Version:    0.7.0.1
 */