package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;

final class BackupMoveRecoverUI$1$16
  implements View.OnClickListener
{
  BackupMoveRecoverUI$1$16(BackupMoveRecoverUI.1 param1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(17378);
    ab.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click scan qrcode.");
    paramView = new Intent();
    paramView.putExtra("BaseScanUI_select_scan_mode", 1);
    paramView.setFlags(268435456);
    d.b(this.jDd.jDc.getContext(), "scanner", ".ui.BaseScanUI", paramView);
    AppMethodBeat.o(17378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.1.16
 * JD-Core Version:    0.7.0.1
 */