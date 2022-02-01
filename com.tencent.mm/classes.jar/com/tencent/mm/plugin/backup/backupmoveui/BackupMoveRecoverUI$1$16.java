package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class BackupMoveRecoverUI$1$16
  implements View.OnClickListener
{
  BackupMoveRecoverUI$1$16(BackupMoveRecoverUI.1 param1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21436);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click scan qrcode.");
    paramView = new Intent();
    paramView.putExtra("BaseScanUI_select_scan_mode", 1);
    paramView.setFlags(268435456);
    d.b(this.nCr.nCq.getContext(), "scanner", ".ui.BaseScanUI", paramView);
    a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(21436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.1.16
 * JD-Core Version:    0.7.0.1
 */