package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

final class CollectMainUI$3
  implements Runnable
{
  CollectMainUI$3(CollectMainUI paramCollectMainUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(41254);
    int i = a.fromDPToPix(this.kSz.getContext(), 37);
    ViewGroup.LayoutParams localLayoutParams = CollectMainUI.k(this.kSz).getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = i;
      CollectMainUI.k(this.kSz).setLayoutParams(localLayoutParams);
      CollectMainUI.k(this.kSz).requestLayout();
    }
    AppMethodBeat.o(41254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.3
 * JD-Core Version:    0.7.0.1
 */