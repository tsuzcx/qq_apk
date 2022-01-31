package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class m$1$1
  implements Runnable
{
  m$1$1(m.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(112056);
    m.b(this.nAX.nAW, this.nAX.nAV);
    ab.i("MicroMsg.GameListAdapter", "add size: %d", new Object[] { Integer.valueOf(this.nAX.nAV.size()) });
    AppMethodBeat.o(112056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.m.1.1
 * JD-Core Version:    0.7.0.1
 */