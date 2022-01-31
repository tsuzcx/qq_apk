package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

final class o$5
  implements j.a
{
  o$5(o paramo) {}
  
  public final void v(ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(135521);
    ab.v("MicroMsg.OpenVoice.OpenVoiceService", "hy: current talking members are %s", new Object[] { paramArrayList });
    this.kLI.O(new o.5.1(this, paramArrayList));
    AppMethodBeat.o(135521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.5
 * JD-Core Version:    0.7.0.1
 */