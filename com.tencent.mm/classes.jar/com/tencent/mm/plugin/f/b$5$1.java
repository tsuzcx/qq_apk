package com.tencent.mm.plugin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class b$5$1
  implements Runnable
{
  b$5$1(b.5 param5) {}
  
  public final void run()
  {
    AppMethodBeat.i(18581);
    g.RL().Ru().set(ac.a.yHF, Long.valueOf(-1L));
    g.RL().Ru().set(ac.a.yHE, Long.valueOf(0L));
    g.RL().Ru().dww();
    b.bak().bal().delete();
    b.d(this.kkx.kks, false);
    AppMethodBeat.o(18581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b.5.1
 * JD-Core Version:    0.7.0.1
 */