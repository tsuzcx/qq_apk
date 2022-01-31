package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class m$1$1
  implements Runnable
{
  m$1$1(m.1 param1) {}
  
  public final void run()
  {
    m.b(this.ldc.ldb, this.ldc.lda);
    y.i("MicroMsg.GameListAdapter", "add size: %d", new Object[] { Integer.valueOf(this.ldc.lda.size()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.m.1.1
 * JD-Core Version:    0.7.0.1
 */