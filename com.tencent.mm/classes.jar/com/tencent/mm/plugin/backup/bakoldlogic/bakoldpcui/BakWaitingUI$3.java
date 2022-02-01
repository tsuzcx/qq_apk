package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

final class BakWaitingUI$3
  implements Runnable
{
  BakWaitingUI$3(BakWaitingUI paramBakWaitingUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(22042);
    Log.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", new Object[] { Integer.valueOf(this.val$errType) });
    if (this.val$errType == -1)
    {
      Log.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
      Intent localIntent = new Intent();
      localIntent.putExtra("title", this.oSQ.getString(2131756353));
      localIntent.putExtra("rawUrl", this.oSQ.getString(2131756312, new Object[] { LocaleUtil.getApplicationLanguage() }));
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("neverGetA8Key", true);
      c.b(this.oSQ, "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(22042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakWaitingUI.3
 * JD-Core Version:    0.7.0.1
 */