package com.tencent.mm.plugin.facedetectaction.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;

final class FaceAgreementUI$6
  implements a.a
{
  FaceAgreementUI$6(FaceAgreementUI paramFaceAgreementUI, Context paramContext) {}
  
  public final void onClick(String paramString)
  {
    AppMethodBeat.i(262609);
    Log.i("MicroMsg.FaceAgreementUI", "click %s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    c.b(this.val$context, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(262609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI.6
 * JD-Core Version:    0.7.0.1
 */