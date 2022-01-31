package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.luggage.c;
import com.tencent.mm.plugin.game.luggage.h;

final class ax$6
  implements Runnable
{
  ax$6(h paramh) {}
  
  public final void run()
  {
    ((c)this.kRt.qp()).onResume();
    ((c)this.kRt.qp()).setBlockNetworkImage(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ax.6
 * JD-Core Version:    0.7.0.1
 */