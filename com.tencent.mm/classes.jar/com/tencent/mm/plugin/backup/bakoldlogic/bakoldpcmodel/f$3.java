package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.backup.bakoldlogic.c.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;

final class f$3
  implements com.tencent.mm.ai.f
{
  f$3(f paramf) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, m paramm)
  {
    AppMethodBeat.i(17864);
    paramm = (d)paramm;
    ab.i("MicroMsg.RecoverPCServer", "onSceneEnd %s, %d, %d", new Object[] { paramm.id, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    synchronized (this.jHZ.lock)
    {
      this.jHZ.jHr.remove(paramm.id);
      ab.i("MicroMsg.RecoverPCServer", "onSceneEnd left: size:%d", new Object[] { Integer.valueOf(this.jHZ.jHr.size()) });
      if (this.jHZ.jHr.size() <= 10) {
        this.jHZ.lock.notifyAll();
      }
      ??? = this.jHZ;
      ???.jHy += 1;
      if (this.jHZ.jHy % 300 == 0) {
        this.jHZ.aVm();
      }
      this.jHZ.aVl();
      AppMethodBeat.o(17864);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.3
 * JD-Core Version:    0.7.0.1
 */