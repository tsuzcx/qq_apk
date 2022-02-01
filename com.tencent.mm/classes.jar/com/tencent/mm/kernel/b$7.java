package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.network.b.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class b$7
  implements b.a
{
  public b$7(b paramb) {}
  
  public final e aeW()
  {
    AppMethodBeat.i(132053);
    try
    {
      e locale = b.a(this.gcC).gVH;
      AppMethodBeat.o(132053);
      return locale;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MMKernel.CoreNetwork", "%s", new Object[] { bt.m(localThrowable) });
      AppMethodBeat.o(132053);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.kernel.b.7
 * JD-Core Version:    0.7.0.1
 */