package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;

final class BakToPcUI$5
  implements Runnable
{
  BakToPcUI$5(BakToPcUI paramBakToPcUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(17971);
    ab.d("MicroMsg.BakToPcUI", "BakToPcUI onCloseSocket errType: %d", new Object[] { Integer.valueOf(this.val$errType) });
    if (this.val$errType == -1)
    {
      ab.d("MicroMsg.BakToPcUI", "BakToPcUI jump tips");
      Intent localIntent = new Intent();
      localIntent.putExtra("title", this.jIJ.getString(2131297344));
      localIntent.putExtra("rawUrl", this.jIJ.getString(2131306129, new Object[] { aa.dsG() }));
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("neverGetA8Key", true);
      d.b(this.jIJ, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(17971);
      return;
    }
    BakToPcUI.e(this.jIJ);
    AppMethodBeat.o(17971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI.5
 * JD-Core Version:    0.7.0.1
 */