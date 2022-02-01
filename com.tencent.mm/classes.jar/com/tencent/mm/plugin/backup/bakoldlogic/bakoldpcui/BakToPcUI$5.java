package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;

final class BakToPcUI$5
  implements Runnable
{
  BakToPcUI$5(BakToPcUI paramBakToPcUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(22027);
    ad.d("MicroMsg.BakToPcUI", "BakToPcUI onCloseSocket errType: %d", new Object[] { Integer.valueOf(this.val$errType) });
    if (this.val$errType == -1)
    {
      ad.d("MicroMsg.BakToPcUI", "BakToPcUI jump tips");
      Intent localIntent = new Intent();
      localIntent.putExtra("title", this.nCx.getString(2131756219));
      localIntent.putExtra("rawUrl", this.nCx.getString(2131756178, new Object[] { ac.fks() }));
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("neverGetA8Key", true);
      d.b(this.nCx, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(22027);
      return;
    }
    BakToPcUI.e(this.nCx);
    AppMethodBeat.o(22027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI.5
 * JD-Core Version:    0.7.0.1
 */