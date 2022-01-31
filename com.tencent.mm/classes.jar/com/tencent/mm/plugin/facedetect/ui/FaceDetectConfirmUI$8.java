package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.ab;

final class FaceDetectConfirmUI$8
  implements View.OnClickListener
{
  FaceDetectConfirmUI$8(FaceDetectConfirmUI paramFaceDetectConfirmUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(370);
    try
    {
      if (FaceDetectConfirmUI.j(this.mkL) != null) {}
      for (paramView = FaceDetectConfirmUI.j(this.mkL);; paramView = "")
      {
        paramView = q.encode(String.format("appid=%s", new Object[] { paramView }), "UTF-8");
        paramView = FaceDetectConfirmUI.k(this.mkL) + "?customInfo=" + paramView;
        ab.i("MicroMsg.FaceDetectConfirmUI", "alvinluo jump realUrl: %s", new Object[] { paramView });
        FaceDetectConfirmUI.a(this.mkL, paramView);
        AppMethodBeat.o(370);
        return;
      }
      return;
    }
    catch (Exception paramView)
    {
      ab.printErrStackTrace("MicroMsg.FaceDetectConfirmUI", paramView, "alvinluo jumpToWebView exception", new Object[0]);
      AppMethodBeat.o(370);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.8
 * JD-Core Version:    0.7.0.1
 */