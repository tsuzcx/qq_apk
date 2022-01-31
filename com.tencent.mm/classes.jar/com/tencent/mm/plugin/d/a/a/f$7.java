package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.UUID;

public final class f$7
  implements Runnable
{
  public f$7(f paramf, UUID paramUUID) {}
  
  public final void run()
  {
    AppMethodBeat.i(18340);
    if (!f.b(this.jNt, this.jNv)) {
      ab.e("MicroMsg.exdevice.IBeaconServer", "stopRanging failed!!!");
    }
    AppMethodBeat.o(18340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.f.7
 * JD-Core Version:    0.7.0.1
 */