package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

final class BackupMoveRecoverUI$1$19
  implements View.OnClickListener
{
  BackupMoveRecoverUI$1$19(BackupMoveRecoverUI.1 param1, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(17382);
    ab.i("MicroMsg.BackupMoveRecoverUI", "backupmove pause click stop merge button.");
    h.a(this.jDd.jDc, 2131297239, 2131297238, 2131297285, 2131297220, false, new BackupMoveRecoverUI.1.19.1(this), null, 2131689740);
    AppMethodBeat.o(17382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI.1.19
 * JD-Core Version:    0.7.0.1
 */