package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.liblockstep.LockStepNative;

final class a$4
  implements Runnable
{
  a$4(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(140700);
    if (this.bDZ.bDW != null) {
      synchronized (this.bDZ)
      {
        if (this.bDZ.bDW != null)
        {
          this.bDZ.bDW.destoryLockStep();
          this.bDZ.bDW = null;
        }
        AppMethodBeat.o(140700);
        return;
      }
    }
    AppMethodBeat.o(140700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.a.4
 * JD-Core Version:    0.7.0.1
 */