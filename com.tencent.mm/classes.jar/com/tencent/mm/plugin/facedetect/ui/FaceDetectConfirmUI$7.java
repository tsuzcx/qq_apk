package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.y;

final class FaceDetectConfirmUI$7
  implements View.OnClickListener
{
  FaceDetectConfirmUI$7(FaceDetectConfirmUI paramFaceDetectConfirmUI) {}
  
  public final void onClick(View paramView)
  {
    try
    {
      if (FaceDetectConfirmUI.h(this.jQq) != null) {}
      for (paramView = FaceDetectConfirmUI.h(this.jQq);; paramView = "")
      {
        paramView = q.encode(String.format("appid=%s", new Object[] { paramView }), "UTF-8");
        paramView = FaceDetectConfirmUI.i(this.jQq) + "?customInfo=" + paramView;
        y.i("MicroMsg.FaceDetectConfirmUI", "alvinluo jump realUrl: %s", new Object[] { paramView });
        FaceDetectConfirmUI.a(this.jQq, paramView);
        return;
      }
      return;
    }
    catch (Exception paramView)
    {
      y.printErrStackTrace("MicroMsg.FaceDetectConfirmUI", paramView, "alvinluo jumpToWebView exception", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.7
 * JD-Core Version:    0.7.0.1
 */