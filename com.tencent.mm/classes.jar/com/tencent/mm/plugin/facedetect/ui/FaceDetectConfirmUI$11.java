package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class FaceDetectConfirmUI$11
  implements View.OnClickListener
{
  FaceDetectConfirmUI$11(FaceDetectConfirmUI paramFaceDetectConfirmUI, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(103887);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    try
    {
      paramView = r.as(String.format("appid=%s;errcode=%d", new Object[] { FaceDetectConfirmUI.d(this.zVB), Integer.valueOf(this.val$errCode) }), "UTF-8");
      paramView = FaceDetectConfirmUI.e(this.zVB) + "?customInfo=" + paramView;
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramView);
      c.b(this.zVB.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectConfirmUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(103887);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FaceDetectConfirmUI", paramView, "face start feedback webview exception", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI.11
 * JD-Core Version:    0.7.0.1
 */