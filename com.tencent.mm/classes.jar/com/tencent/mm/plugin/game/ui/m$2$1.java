package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class m$2$1
  implements Runnable
{
  m$2$1(m.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(112058);
    m.c(this.nAY.nAW, this.nAY.nAV);
    ab.i("MicroMsg.GameListAdapter", "set size: %d", new Object[] { Integer.valueOf(this.nAY.nAV.size()) });
    AppMethodBeat.o(112058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.m.2.1
 * JD-Core Version:    0.7.0.1
 */