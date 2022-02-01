package com.tencent.mm.plugin.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class a$b
  implements Runnable
{
  a$b(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(189225);
    ad.i("MicroMsg.BaseAudioManager", "dkbt post delay BLUETOOTH_SCO_CONNECTED ");
    com.tencent.mm.plugin.audio.d.a.a(this.mpi.audioManager);
    AppMethodBeat.o(189225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.b.a.b
 * JD-Core Version:    0.7.0.1
 */