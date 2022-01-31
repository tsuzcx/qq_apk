package com.tencent.mm.plugin.appbrand.debugger;

import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$1
  implements Runnable
{
  u$1(u paramu) {}
  
  public final void run()
  {
    AppMethodBeat.i(101916);
    RemoteDebugMoveView localRemoteDebugMoveView = u.a(this.hmM);
    int i = this.hmM.getWidth();
    int j = this.hmM.getHeight();
    localRemoteDebugMoveView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    localRemoteDebugMoveView.hlX = i;
    localRemoteDebugMoveView.hlY = j;
    localRemoteDebugMoveView.post(new RemoteDebugMoveView.1(localRemoteDebugMoveView));
    this.hmM.addView(u.a(this.hmM));
    AppMethodBeat.o(101916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.u.1
 * JD-Core Version:    0.7.0.1
 */