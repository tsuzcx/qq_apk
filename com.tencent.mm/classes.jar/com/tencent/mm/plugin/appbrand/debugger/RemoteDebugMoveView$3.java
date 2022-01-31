package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemoteDebugMoveView$3
  implements Runnable
{
  RemoteDebugMoveView$3(RemoteDebugMoveView paramRemoteDebugMoveView) {}
  
  public final void run()
  {
    AppMethodBeat.i(101854);
    if (this.hmb.getY() + this.hmb.getHeight() > RemoteDebugMoveView.c(this.hmb)) {
      this.hmb.setY(RemoteDebugMoveView.c(this.hmb) - this.hmb.getHeight());
    }
    AppMethodBeat.o(101854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.3
 * JD-Core Version:    0.7.0.1
 */