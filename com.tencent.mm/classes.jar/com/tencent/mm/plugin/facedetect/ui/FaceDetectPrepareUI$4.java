package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class FaceDetectPrepareUI$4
  implements View.OnClickListener
{
  FaceDetectPrepareUI$4(FaceDetectPrepareUI paramFaceDetectPrepareUI, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(103922);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/facedetect/ui/FaceDetectPrepareUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    if (bu.isNullOrNil(FaceDetectPrepareUI.e(this.rsP)))
    {
      ae.e("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url is null");
      a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectPrepareUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(103922);
      return;
    }
    FaceDetectPrepareUI.f(this.rsP);
    for (;;)
    {
      try
      {
        if (FaceDetectPrepareUI.g(this.rsP) == null) {
          continue;
        }
        paramView = FaceDetectPrepareUI.g(this.rsP);
        paramView = q.encode(String.format("appid=%s;errcode=%d;identifyid=%s", new Object[] { paramView, Integer.valueOf(this.val$errCode), "" }), "UTF-8");
        paramView = FaceDetectPrepareUI.e(this.rsP) + "?customInfo=" + paramView;
        ae.i("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url: %s", new Object[] { paramView });
        localObject = new Intent();
        ((Intent)localObject).putExtra("rawUrl", paramView);
        d.b(this.rsP, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      }
      catch (Exception paramView)
      {
        ae.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", paramView, "alvinluo start feedback webview exception", new Object[0]);
        continue;
      }
      a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceDetectPrepareUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(103922);
      return;
      paramView = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.4
 * JD-Core Version:    0.7.0.1
 */