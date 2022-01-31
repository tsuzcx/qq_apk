package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;

final class ax$3
  implements Runnable
{
  ax$3(ax paramax, String paramString) {}
  
  public final void run()
  {
    if (ax.aon().contains(this.kRr))
    {
      y.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload webcore, time out");
      ax.aon().remove(this.kRr);
      h.nFQ.h(939L, 3L, 1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ax.3
 * JD-Core Version:    0.7.0.1
 */