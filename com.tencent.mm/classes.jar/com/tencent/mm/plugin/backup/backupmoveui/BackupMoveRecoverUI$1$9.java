package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ac;

final class BackupMoveRecoverUI$1$9
  implements View.OnClickListener
{
  BackupMoveRecoverUI$1$9(BackupMoveRecoverUI.1 param1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21427);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = new Intent();
    paramView.putExtra("title", this.nwW.nwV.getString(2131756142));
    paramView.putExtra("rawUrl", this.nwW.nwV.getString(2131756141, new Object[] { ac.fks() }));
    paramView.putExtra("showShare", false);
    paramView.putExtra("neverGetA8Key", true);
    d.b(this.nwW.nwV, "webview", ".ui.tools.WebViewUI", paramView);
    a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(21427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.1.9
 * JD-Core Version:    0.7.0.1
 */