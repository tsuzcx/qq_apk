package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;

final class RemoteDebugMoveView$1
  implements Runnable
{
  RemoteDebugMoveView$1(RemoteDebugMoveView paramRemoteDebugMoveView) {}
  
  public final void run()
  {
    AppMethodBeat.i(101851);
    this.hmb.setX(RemoteDebugMoveView.a(this.hmb) - RemoteDebugMoveView.b(this.hmb));
    int i = (int)(a.getDensity(ah.getContext()) * 120.0F);
    this.hmb.setY(i);
    AppMethodBeat.o(101851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.1
 * JD-Core Version:    0.7.0.1
 */