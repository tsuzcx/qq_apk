package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class FaceDetectConfirmUI$13
  implements View.OnClickListener
{
  FaceDetectConfirmUI$13(FaceDetectConfirmUI paramFaceDetectConfirmUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(271908);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    for (;;)
    {
      try
      {
        if (FaceDetectConfirmUI.d(this.zVB) == null) {
          continue;
        }
        paramView = FaceDetectConfirmUI.d(this.zVB);
        paramView = r.as(String.format("appid=%s", new Object[] { paramView }), "UTF-8");
        paramView = FaceDetectConfirmUI.k(this.zVB) + "?customInfo=" + paramView;
        Log.i("MicroMsg.FaceDetectConfirmUI", "alvinluo jump realUrl: %s", new Object[] { paramView });
        FaceDetectConfirmUI.a(this.zVB, paramView);
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("MicroMsg.FaceDetectConfirmUI", paramView, "alvinluo jumpToWebView exception", new Object[0]);
        continue;
      }
      a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(271908);
      return;
      paramView = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.13
 * JD-Core Version:    0.7.0.1
 */