package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class FaceDetectPrepareUI$4
  implements View.OnClickListener
{
  FaceDetectPrepareUI$4(FaceDetectPrepareUI paramFaceDetectPrepareUI, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(403);
    if (bo.isNullOrNil(FaceDetectPrepareUI.e(this.mlC)))
    {
      ab.e("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url is null");
      AppMethodBeat.o(403);
      return;
    }
    FaceDetectPrepareUI.f(this.mlC);
    try
    {
      if (FaceDetectPrepareUI.g(this.mlC) != null) {}
      for (paramView = FaceDetectPrepareUI.g(this.mlC);; paramView = "")
      {
        paramView = q.encode(String.format("appid=%s;errcode=%d;identifyid=%s", new Object[] { paramView, Integer.valueOf(this.val$errCode), "" }), "UTF-8");
        paramView = FaceDetectPrepareUI.e(this.mlC) + "?customInfo=" + paramView;
        ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url: %s", new Object[] { paramView });
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramView);
        d.b(this.mlC, "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(403);
        return;
      }
      return;
    }
    catch (Exception paramView)
    {
      ab.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", paramView, "alvinluo start feedback webview exception", new Object[0]);
      AppMethodBeat.o(403);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.4
 * JD-Core Version:    0.7.0.1
 */