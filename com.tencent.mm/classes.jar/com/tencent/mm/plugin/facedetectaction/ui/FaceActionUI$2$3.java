package com.tencent.mm.plugin.facedetectaction.ui;

import android.os.Bundle;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.sdk.platformtools.y;

final class FaceActionUI$2$3
  implements Runnable
{
  FaceActionUI$2$3(FaceActionUI.2 param2, String paramString) {}
  
  public final void run()
  {
    FaceActionUI.f(this.jWX.jWU).clearAnimation();
    FaceActionUI localFaceActionUI = this.jWX.jWU;
    localFaceActionUI.jWD.setVisibility(8);
    localFaceActionUI.jSb.clearAnimation();
    localFaceActionUI.jRX.setVisibility(8);
    localFaceActionUI.jWH.setVisibility(0);
    localFaceActionUI.jRY.setVisibility(0);
    localFaceActionUI.jSc.setScaleX(0.0F);
    localFaceActionUI.jSc.setScaleY(0.0F);
    localFaceActionUI.jSc.animate().scaleX(1.0F).scaleY(1.0F).setDuration(800L);
    localFaceActionUI = this.jWX.jWU;
    String str = this.jWY;
    y.i("MicroMsg.FaceActionUI", "callbackDetectSuccess（）");
    Bundle localBundle = new Bundle();
    localBundle.putString("token", str);
    localFaceActionUI.bIC = 0;
    localFaceActionUI.a("ok", 0, localBundle, Boolean.valueOf(localFaceActionUI.jWO));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.2.3
 * JD-Core Version:    0.7.0.1
 */