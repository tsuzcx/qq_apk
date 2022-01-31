package com.tencent.mm.plugin.facedetect.ui;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bnw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class FaceDetectConfirmUI$7
  extends ClickableSpan
{
  FaceDetectConfirmUI$7(FaceDetectConfirmUI paramFaceDetectConfirmUI, bnw parambnw) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(368);
    if (!bo.isNullOrNil(this.mkM.url))
    {
      FaceDetectConfirmUI.a(this.mkL, this.mkM.url);
      AppMethodBeat.o(368);
      return;
    }
    ab.e("MicroMsg.FaceDetectConfirmUI", "alvinluo promptInfo url is null");
    AppMethodBeat.o(368);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(369);
    paramTextPaint.setColor(this.mkL.getResources().getColor(2131690214));
    AppMethodBeat.o(369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.7
 * JD-Core Version:    0.7.0.1
 */