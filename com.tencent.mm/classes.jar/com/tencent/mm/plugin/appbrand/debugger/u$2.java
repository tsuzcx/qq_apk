package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class u$2
  implements Runnable
{
  u$2(u paramu) {}
  
  public final void run()
  {
    AppMethodBeat.i(101917);
    if (u.b(this.hmM) == null)
    {
      ab.w("MicroMsg.RemoteDebugView", "showDebugView mContentView is null");
      AppMethodBeat.o(101917);
      return;
    }
    if (u.c(this.hmM))
    {
      this.hmM.setVisibility(0);
      if (u.b(this.hmM).indexOfChild(this.hmM) == -1) {
        u.b(this.hmM).addView(this.hmM);
      }
      u.b(this.hmM).bringChildToFront(this.hmM);
      this.hmM.setBackgroundColor(this.hmM.getContext().getResources().getColor(2131690159));
      AppMethodBeat.o(101917);
      return;
    }
    this.hmM.setBackgroundColor(this.hmM.getContext().getResources().getColor(2131690605));
    AppMethodBeat.o(101917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.u.2
 * JD-Core Version:    0.7.0.1
 */