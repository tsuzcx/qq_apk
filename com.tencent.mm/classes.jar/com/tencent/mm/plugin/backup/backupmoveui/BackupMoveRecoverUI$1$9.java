package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;

final class BackupMoveRecoverUI$1$9
  implements View.OnClickListener
{
  BackupMoveRecoverUI$1$9(BackupMoveRecoverUI.1 param1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21427);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = new Intent();
    paramView.putExtra("title", this.oNq.oNp.getString(2131756276));
    paramView.putExtra("rawUrl", this.oNq.oNp.getString(2131756275, new Object[] { LocaleUtil.getApplicationLanguage() }));
    paramView.putExtra("showShare", false);
    paramView.putExtra("neverGetA8Key", true);
    c.b(this.oNq.oNp, "webview", ".ui.tools.WebViewUI", paramView);
    a.a(this, "com/tencent/mm/plugin/backup/backupmoveui/BackupMoveRecoverUI$1$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(21427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.1.9
 * JD-Core Version:    0.7.0.1
 */