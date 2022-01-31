package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;

final class RemoteDebugMoveView$1
  implements Runnable
{
  RemoteDebugMoveView$1(RemoteDebugMoveView paramRemoteDebugMoveView) {}
  
  public final void run()
  {
    this.fSC.setX(RemoteDebugMoveView.a(this.fSC) - RemoteDebugMoveView.b(this.fSC));
    int i = (int)(a.getDensity(ae.getContext()) * 120.0F);
    this.fSC.setY(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.1
 * JD-Core Version:    0.7.0.1
 */