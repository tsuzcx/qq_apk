package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.n;

final class LaunchAAUI$3
  implements DialogInterface.OnCancelListener
{
  LaunchAAUI$3(LaunchAAUI paramLaunchAAUI, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(213023);
    if ((LaunchAAUI.i(this.jXQ) != null) && (LaunchAAUI.i(this.jXQ).isShowing())) {
      LaunchAAUI.i(this.jXQ).dismiss();
    }
    ((n)g.ah(n.class)).cancelSearchTask(this.jXT);
    LaunchAAUI.j(this.jXQ);
    AppMethodBeat.o(213023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.3
 * JD-Core Version:    0.7.0.1
 */