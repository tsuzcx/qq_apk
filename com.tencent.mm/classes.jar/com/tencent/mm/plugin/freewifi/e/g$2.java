package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;

final class g$2
  implements a.a
{
  g$2(g paramg) {}
  
  public final void onFail(int paramInt)
  {
    AppMethodBeat.i(20814);
    g.c(this.mLn);
    AppMethodBeat.o(20814);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(20813);
    ab.i("MicroMsg.FreeWifi.ProtocolOne", "sessionKey=%s, step=%d, desc=Network. ", new Object[] { m.U(this.mLn.intent), Integer.valueOf(m.V(this.mLn.intent)) });
    g.b(this.mLn);
    AppMethodBeat.o(20813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.g.2
 * JD-Core Version:    0.7.0.1
 */