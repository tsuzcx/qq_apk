package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class o$11$1
  implements Runnable
{
  o$11$1(o.11 param11) {}
  
  public final void run()
  {
    AppMethodBeat.i(135527);
    ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: hy: phone broken. exit room if in room");
    o.a(this.kLS.kLI, o.a.kMg);
    AppMethodBeat.o(135527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.11.1
 * JD-Core Version:    0.7.0.1
 */