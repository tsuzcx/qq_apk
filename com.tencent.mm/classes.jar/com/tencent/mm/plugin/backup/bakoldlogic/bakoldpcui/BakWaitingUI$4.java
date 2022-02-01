package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMWizardActivity;

final class BakWaitingUI$4
  implements Runnable
{
  BakWaitingUI$4(BakWaitingUI paramBakWaitingUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(22043);
    Log.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", new Object[] { Integer.valueOf(this.val$errType) });
    if (this.val$errType == -1)
    {
      Log.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
      localIntent = new Intent();
      localIntent.putExtra("title", this.oSQ.getString(2131756353));
      localIntent.putExtra("rawUrl", this.oSQ.getString(2131756312, new Object[] { LocaleUtil.getApplicationLanguage() }));
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("neverGetA8Key", true);
      c.b(this.oSQ, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(22043);
      return;
    }
    Intent localIntent = new Intent(this.oSQ, BakConnErrorUI.class);
    MMWizardActivity.ay(this.oSQ, localIntent);
    AppMethodBeat.o(22043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakWaitingUI.4
 * JD-Core Version:    0.7.0.1
 */