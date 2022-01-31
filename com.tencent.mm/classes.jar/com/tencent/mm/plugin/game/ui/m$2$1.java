package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class m$2$1
  implements Runnable
{
  m$2$1(m.2 param2) {}
  
  public final void run()
  {
    m.c(this.ldd.ldb, this.ldd.lda);
    y.i("MicroMsg.GameListAdapter", "set size: %d", new Object[] { Integer.valueOf(this.ldd.lda.size()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.m.2.1
 * JD-Core Version:    0.7.0.1
 */