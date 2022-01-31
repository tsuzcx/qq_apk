package com.tencent.mm.plugin.facedetectaction.ui;

import android.os.Bundle;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FaceActionUI$2$3
  implements Runnable
{
  FaceActionUI$2$3(FaceActionUI.2 param2, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(712);
    FaceActionUI.f(this.mro.mrl).clearAnimation();
    FaceActionUI localFaceActionUI = this.mro.mrl;
    localFaceActionUI.mqU.setVisibility(8);
    localFaceActionUI.mmx.clearAnimation();
    localFaceActionUI.mmt.setVisibility(8);
    localFaceActionUI.mqY.setVisibility(0);
    localFaceActionUI.mmu.setVisibility(0);
    localFaceActionUI.mmy.setScaleX(0.0F);
    localFaceActionUI.mmy.setScaleY(0.0F);
    localFaceActionUI.mmy.animate().scaleX(1.0F).scaleY(1.0F).setDuration(800L);
    localFaceActionUI = this.mro.mrl;
    String str = this.mrp;
    ab.i("MicroMsg.FaceActionUI", "callbackDetectSuccess（）");
    Bundle localBundle = new Bundle();
    localBundle.putString("token", str);
    localFaceActionUI.cpX = 0;
    localFaceActionUI.a("ok", 0, localBundle, Boolean.valueOf(localFaceActionUI.mrf));
    AppMethodBeat.o(712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.2.3
 * JD-Core Version:    0.7.0.1
 */