package com.tencent.mm.plugin.facedetect.ui;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.protocal.c.bfr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class FaceDetectConfirmUI$6
  extends ClickableSpan
{
  FaceDetectConfirmUI$6(FaceDetectConfirmUI paramFaceDetectConfirmUI, bfr parambfr) {}
  
  public final void onClick(View paramView)
  {
    if (!bk.bl(this.jQr.url))
    {
      FaceDetectConfirmUI.a(this.jQq, this.jQr.url);
      return;
    }
    y.e("MicroMsg.FaceDetectConfirmUI", "alvinluo promptInfo url is null");
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.jQq.getResources().getColor(a.b.link_color));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.6
 * JD-Core Version:    0.7.0.1
 */