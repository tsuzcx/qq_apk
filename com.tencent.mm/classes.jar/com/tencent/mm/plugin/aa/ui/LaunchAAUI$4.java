package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.n;
import java.util.ArrayList;

final class LaunchAAUI$4
  implements Runnable
{
  LaunchAAUI$4(LaunchAAUI paramLaunchAAUI, a parama, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(213024);
    if (LaunchAAUI.k(this.jXQ))
    {
      if ((LaunchAAUI.i(this.jXQ) != null) && (LaunchAAUI.i(this.jXQ).isShowing())) {
        LaunchAAUI.i(this.jXQ).dismiss();
      }
      ((n)g.ah(n.class)).cancelSearchTask(this.jXT);
      LaunchAAUI.j(this.jXQ);
      this.jXR.clear();
      LaunchAAUI.a(this.jXQ, this.jXR);
    }
    AppMethodBeat.o(213024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.4
 * JD-Core Version:    0.7.0.1
 */