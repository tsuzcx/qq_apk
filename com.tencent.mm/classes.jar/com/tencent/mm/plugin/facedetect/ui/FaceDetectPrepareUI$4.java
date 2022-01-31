package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class FaceDetectPrepareUI$4
  implements View.OnClickListener
{
  FaceDetectPrepareUI$4(FaceDetectPrepareUI paramFaceDetectPrepareUI, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (bk.bl(FaceDetectPrepareUI.e(this.jRg)))
    {
      y.e("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url is null");
      return;
    }
    FaceDetectPrepareUI.f(this.jRg);
    for (;;)
    {
      try
      {
        if (FaceDetectPrepareUI.g(this.jRg) != null)
        {
          paramView = FaceDetectPrepareUI.g(this.jRg);
          paramView = q.encode(String.format("appid=%s;errcode=%d;identifyid=%s", new Object[] { paramView, Integer.valueOf(this.bEg), "" }), "UTF-8");
          paramView = FaceDetectPrepareUI.e(this.jRg) + "?customInfo=" + paramView;
          y.i("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url: %s", new Object[] { paramView });
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramView);
          d.b(this.jRg, "webview", ".ui.tools.WebViewUI", localIntent);
          return;
        }
      }
      catch (Exception paramView)
      {
        y.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", paramView, "alvinluo start feedback webview exception", new Object[0]);
        return;
      }
      paramView = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.4
 * JD-Core Version:    0.7.0.1
 */