package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CollectMainUI$21
  implements Runnable
{
  CollectMainUI$21(CollectMainUI paramCollectMainUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(41279);
    int[] arrayOfInt = new int[2];
    CollectMainUI.j(this.kSz).getLocationInWindow(arrayOfInt);
    CollectMainUI.tQ(arrayOfInt[1]);
    AppMethodBeat.o(41279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.21
 * JD-Core Version:    0.7.0.1
 */