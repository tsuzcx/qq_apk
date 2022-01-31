package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;

final class MountReceiver$3
  implements Runnable
{
  MountReceiver$3(MountReceiver paramMountReceiver) {}
  
  public final void run()
  {
    AppMethodBeat.i(15847);
    ab.d("MicroMsg.MountReceiver", "dkmount [EJECT] action:%s hasuin:%b", new Object[] { MountReceiver.a(this.dYY), Boolean.valueOf(aw.RG()) });
    if (!aw.RG())
    {
      AppMethodBeat.o(15847);
      return;
    }
    g.RL().Ry();
    aw.aaz();
    c.Rw();
    AppMethodBeat.o(15847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.MountReceiver.3
 * JD-Core Version:    0.7.0.1
 */