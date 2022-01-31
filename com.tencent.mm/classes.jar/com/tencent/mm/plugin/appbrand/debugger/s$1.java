package com.tencent.mm.plugin.appbrand.debugger;

import android.view.ViewGroup.LayoutParams;

final class s$1
  implements Runnable
{
  s$1(s params) {}
  
  public final void run()
  {
    RemoteDebugMoveView localRemoteDebugMoveView = s.a(this.fTl);
    int i = this.fTl.getWidth();
    int j = this.fTl.getHeight();
    localRemoteDebugMoveView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    localRemoteDebugMoveView.fSw = i;
    localRemoteDebugMoveView.fSx = j;
    localRemoteDebugMoveView.post(new RemoteDebugMoveView.1(localRemoteDebugMoveView));
    this.fTl.addView(s.a(this.fTl));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.s.1
 * JD-Core Version:    0.7.0.1
 */