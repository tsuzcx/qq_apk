package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.n;
import java.util.ArrayList;

final class LaunchAAUI$4
  implements Runnable
{
  LaunchAAUI$4(LaunchAAUI paramLaunchAAUI, a parama, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(272788);
    if (LaunchAAUI.l(this.mPg))
    {
      if ((LaunchAAUI.j(this.mPg) != null) && (LaunchAAUI.j(this.mPg).isShowing())) {
        LaunchAAUI.j(this.mPg).dismiss();
      }
      ((n)h.ag(n.class)).cancelSearchTask(this.mPj);
      LaunchAAUI.k(this.mPg);
      this.mPh.clear();
      LaunchAAUI.a(this.mPg, this.mPh);
    }
    AppMethodBeat.o(272788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.4
 * JD-Core Version:    0.7.0.1
 */