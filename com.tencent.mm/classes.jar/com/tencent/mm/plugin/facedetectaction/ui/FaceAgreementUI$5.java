package com.tencent.mm.plugin.facedetectaction.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;

final class FaceAgreementUI$5
  implements a.a
{
  FaceAgreementUI$5(FaceAgreementUI paramFaceAgreementUI, Context paramContext) {}
  
  public final void arG(String paramString)
  {
    AppMethodBeat.i(186402);
    Log.i("MicroMsg.FaceAgreementUI", "click %s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    c.b(this.val$context, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(186402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI.5
 * JD-Core Version:    0.7.0.1
 */