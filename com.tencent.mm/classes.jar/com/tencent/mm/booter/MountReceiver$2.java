package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class MountReceiver$2
  implements Runnable
{
  MountReceiver$2(MountReceiver paramMountReceiver) {}
  
  public final void run()
  {
    AppMethodBeat.i(15846);
    ab.d("MicroMsg.MountReceiver", "dkmount [MOUNT] action:%s hasuin:%b", new Object[] { MountReceiver.a(this.dYY), Boolean.valueOf(aw.RG()) });
    if (!aw.RG())
    {
      AppMethodBeat.o(15846);
      return;
    }
    g.RL().Ry();
    aw.aaz();
    c.Rw();
    MountReceiver.c(this.dYY).sendEmptyMessage(0);
    AppMethodBeat.o(15846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.MountReceiver.2
 * JD-Core Version:    0.7.0.1
 */