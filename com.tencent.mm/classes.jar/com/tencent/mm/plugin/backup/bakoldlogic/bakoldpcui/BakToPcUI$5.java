package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

final class BakToPcUI$5
  implements Runnable
{
  BakToPcUI$5(BakToPcUI paramBakToPcUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(22027);
    Log.d("MicroMsg.BakToPcUI", "BakToPcUI onCloseSocket errType: %d", new Object[] { Integer.valueOf(this.val$errType) });
    if (this.val$errType == -1)
    {
      Log.d("MicroMsg.BakToPcUI", "BakToPcUI jump tips");
      Intent localIntent = new Intent();
      localIntent.putExtra("title", this.oSO.getString(2131756353));
      localIntent.putExtra("rawUrl", this.oSO.getString(2131756312, new Object[] { LocaleUtil.getApplicationLanguage() }));
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("neverGetA8Key", true);
      c.b(this.oSO, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(22027);
      return;
    }
    BakToPcUI.e(this.oSO);
    AppMethodBeat.o(22027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI.5
 * JD-Core Version:    0.7.0.1
 */