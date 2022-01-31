package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.x;

final class BackupMoveRecoverUI$9
  implements View.OnClickListener
{
  BackupMoveRecoverUI$9(BackupMoveRecoverUI paramBackupMoveRecoverUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("title", this.hJA.getString(R.l.backup_move_open_wifiap_title));
    paramView.putExtra("rawUrl", this.hJA.getString(R.l.backup_move_open_wifiap_doc, new Object[] { x.cqJ() }));
    paramView.putExtra("showShare", false);
    paramView.putExtra("neverGetA8Key", true);
    d.b(this.hJA, "webview", ".ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.9
 * JD-Core Version:    0.7.0.1
 */