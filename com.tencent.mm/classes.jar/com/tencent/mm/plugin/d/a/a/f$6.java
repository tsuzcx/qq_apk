package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.UUID;

public final class f$6
  implements Runnable
{
  public f$6(f paramf, UUID paramUUID) {}
  
  public final void run()
  {
    AppMethodBeat.i(18339);
    if (!f.a(this.jNt, this.jNv)) {
      ab.e("MicroMsg.exdevice.IBeaconServer", "startRanging failed!!!");
    }
    AppMethodBeat.o(18339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.f.6
 * JD-Core Version:    0.7.0.1
 */