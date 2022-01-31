package com.tencent.mm.plugin.game.model;

import com.tencent.mm.h.a.kp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class ax$b
  implements Runnable
{
  private final kp kRA;
  
  public ax$b(ax paramax, kp paramkp)
  {
    this.kRA = paramkp;
  }
  
  public final void run()
  {
    y.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "time out, turn page");
    ax.a(this.kRq, this.kRA, null);
    h.nFQ.h(939L, 2L, 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ax.b
 * JD-Core Version:    0.7.0.1
 */