package com.tencent.mm.plugin.appbrand.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.k.a;
import com.tencent.mm.sdk.platformtools.ab;

final class e$a
{
  public String appId;
  public String bCZ;
  public int irE;
  public k.a irF;
  public long lastUpdateTime;
  
  private long aIc()
  {
    AppMethodBeat.i(132278);
    long l = System.currentTimeMillis() - this.lastUpdateTime;
    ab.d("MicroMsg.WxaUpdateableMsgService", "consumeTime:%d", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(132278);
    return l;
  }
  
  public final boolean aIb()
  {
    AppMethodBeat.i(132277);
    if (this.irE < 0)
    {
      AppMethodBeat.o(132277);
      return false;
    }
    if (this.irE == 0)
    {
      if (aIc() > 10000L)
      {
        AppMethodBeat.o(132277);
        return true;
      }
      AppMethodBeat.o(132277);
      return false;
    }
    if (aIc() > this.irE * 1000L)
    {
      AppMethodBeat.o(132277);
      return true;
    }
    AppMethodBeat.o(132277);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.e.a
 * JD-Core Version:    0.7.0.1
 */