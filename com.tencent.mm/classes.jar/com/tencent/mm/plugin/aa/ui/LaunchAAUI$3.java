package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.n;

final class LaunchAAUI$3
  implements DialogInterface.OnCancelListener
{
  LaunchAAUI$3(LaunchAAUI paramLaunchAAUI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(220087);
    if ((LaunchAAUI.j(this.mPg) != null) && (LaunchAAUI.j(this.mPg).isShowing())) {
      LaunchAAUI.j(this.mPg).dismiss();
    }
    ((n)h.ag(n.class)).cancelSearchTask(this.mPj);
    LaunchAAUI.k(this.mPg);
    AppMethodBeat.o(220087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.3
 * JD-Core Version:    0.7.0.1
 */