package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;

final class CollectMainUI$3
  implements Runnable
{
  CollectMainUI$3(CollectMainUI paramCollectMainUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(64115);
    int i = a.fromDPToPix(this.uaM.getContext(), 37);
    ViewGroup.LayoutParams localLayoutParams = CollectMainUI.m(this.uaM).getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = i;
      CollectMainUI.m(this.uaM).setLayoutParams(localLayoutParams);
      CollectMainUI.m(this.uaM).requestLayout();
    }
    AppMethodBeat.o(64115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.3
 * JD-Core Version:    0.7.0.1
 */