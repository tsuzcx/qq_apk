package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.b.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class b$7
  implements b.a
{
  public b$7(b paramb) {}
  
  public final e agm()
  {
    AppMethodBeat.i(132053);
    try
    {
      e locale = b.a(this.ghi).hwg;
      AppMethodBeat.o(132053);
      return locale;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MMKernel.CoreNetwork", "%s", new Object[] { bs.m(localThrowable) });
      AppMethodBeat.o(132053);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.b.7
 * JD-Core Version:    0.7.0.1
 */