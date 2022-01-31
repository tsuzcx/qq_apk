package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;

final class BakToPcUI$5
  implements Runnable
{
  BakToPcUI$5(BakToPcUI paramBakToPcUI, int paramInt) {}
  
  public final void run()
  {
    y.d("MicroMsg.BakToPcUI", "BakToPcUI onCloseSocket errType: %d", new Object[] { Integer.valueOf(this.bEf) });
    if (this.bEf == -1)
    {
      y.d("MicroMsg.BakToPcUI", "BakToPcUI jump tips");
      Intent localIntent = new Intent();
      localIntent.putExtra("title", this.hPh.getString(R.l.backup_pc_not_support_title));
      localIntent.putExtra("rawUrl", this.hPh.getString(R.l.backup_not_support_doc, new Object[] { x.cqJ() }));
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("neverGetA8Key", true);
      d.b(this.hPh, "webview", ".ui.tools.WebViewUI", localIntent);
      return;
    }
    BakToPcUI.e(this.hPh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI.5
 * JD-Core Version:    0.7.0.1
 */