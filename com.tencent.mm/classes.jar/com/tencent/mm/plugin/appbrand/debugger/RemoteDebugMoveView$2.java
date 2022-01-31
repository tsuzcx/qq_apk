package com.tencent.mm.plugin.appbrand.debugger;

final class RemoteDebugMoveView$2
  implements Runnable
{
  RemoteDebugMoveView$2(RemoteDebugMoveView paramRemoteDebugMoveView) {}
  
  public final void run()
  {
    if (this.fSC.getY() + this.fSC.getHeight() > RemoteDebugMoveView.c(this.fSC)) {
      this.fSC.setY(RemoteDebugMoveView.c(this.fSC) - this.fSC.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.2
 * JD-Core Version:    0.7.0.1
 */