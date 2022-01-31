package com.tencent.mm.plugin.appbrand.debugger;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemoteDebugMoveView$2$1
  implements Runnable
{
  RemoteDebugMoveView$2$1(RemoteDebugMoveView.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(101852);
    if ((this.hmc.hmb.getParent() instanceof View))
    {
      View localView = (View)this.hmc.hmb.getParent();
      RemoteDebugMoveView.a(this.hmc.hmb, localView.getMeasuredWidth());
      RemoteDebugMoveView.b(this.hmc.hmb, localView.getMeasuredHeight());
      float f1 = Math.max(0.0F, Math.min(RemoteDebugMoveView.a(this.hmc.hmb) - this.hmc.hmb.getWidth(), this.hmc.hmb.getX()));
      float f2 = Math.max(0.0F, Math.min(RemoteDebugMoveView.c(this.hmc.hmb) - this.hmc.hmb.getHeight(), this.hmc.hmb.getY()));
      this.hmc.hmb.setX(f1);
      this.hmc.hmb.setY(f2);
      this.hmc.hmb.requestLayout();
    }
    AppMethodBeat.o(101852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.2.1
 * JD-Core Version:    0.7.0.1
 */