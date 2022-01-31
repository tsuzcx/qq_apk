package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.aa;

final class BackupMoveRecoverUI$1$9
  implements View.OnClickListener
{
  BackupMoveRecoverUI$1$9(BackupMoveRecoverUI.1 param1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(17369);
    paramView = new Intent();
    paramView.putExtra("title", this.jDd.jDc.getString(2131297269));
    paramView.putExtra("rawUrl", this.jDd.jDc.getString(2131306128, new Object[] { aa.dsG() }));
    paramView.putExtra("showShare", false);
    paramView.putExtra("neverGetA8Key", true);
    d.b(this.jDd.jDc, "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(17369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.1.9
 * JD-Core Version:    0.7.0.1
 */