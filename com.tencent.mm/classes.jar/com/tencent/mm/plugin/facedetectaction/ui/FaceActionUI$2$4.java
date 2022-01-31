package com.tencent.mm.plugin.facedetectaction.ui;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetectaction.b.d;
import com.tencent.mm.sdk.platformtools.bo;

final class FaceActionUI$2$4
  implements Runnable
{
  FaceActionUI$2$4(FaceActionUI.2 param2, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(715);
    if (!bo.isNullOrNil(this.mrq))
    {
      FaceActionUI.g(this.mro.mrl).setText(this.mrq);
      FaceActionUI.h(this.mro.mrl);
      if (this.mrr != 1) {
        break label212;
      }
      FaceActionUI.i(this.mro.mrl).setText(2131299604);
      FaceActionUI.i(this.mro.mrl).setOnClickListener(new FaceActionUI.2.4.1(this));
    }
    for (;;)
    {
      FaceActionUI.f(this.mro.mrl).clearAnimation();
      FaceActionUI localFaceActionUI = this.mro.mrl;
      localFaceActionUI.mqU.setVisibility(8);
      localFaceActionUI.mmv.setVisibility(0);
      localFaceActionUI.mmx.clearAnimation();
      localFaceActionUI.mqY.setVisibility(0);
      localFaceActionUI.mmt.setVisibility(8);
      d.mqx.mStatus = 3;
      if (bo.isNullOrNil(d.mqx.cFx)) {
        this.mro.mrl.t("fail", this.mrs, "");
      }
      AppMethodBeat.o(715);
      return;
      FaceActionUI.g(this.mro.mrl).setText(2131299523);
      break;
      label212:
      FaceActionUI.i(this.mro.mrl).setText(2131299603);
      FaceActionUI.i(this.mro.mrl).setOnClickListener(new FaceActionUI.2.4.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.2.4
 * JD-Core Version:    0.7.0.1
 */