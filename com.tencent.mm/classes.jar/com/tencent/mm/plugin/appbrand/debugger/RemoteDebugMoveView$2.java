package com.tencent.mm.plugin.appbrand.debugger;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemoteDebugMoveView$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int counter = 0;
  
  RemoteDebugMoveView$2(RemoteDebugMoveView paramRemoteDebugMoveView) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(101853);
    int i = this.counter + 1;
    this.counter = i;
    if (i < 2)
    {
      AppMethodBeat.o(101853);
      return;
    }
    this.hmb.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    this.hmb.post(new RemoteDebugMoveView.2.1(this));
    AppMethodBeat.o(101853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.2
 * JD-Core Version:    0.7.0.1
 */