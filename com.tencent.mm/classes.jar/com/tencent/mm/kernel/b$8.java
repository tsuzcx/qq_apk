package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.b.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class b$8
  implements b.a
{
  public b$8(b paramb) {}
  
  public final e agm()
  {
    AppMethodBeat.i(132054);
    try
    {
      e locale = b.a(this.ghi).hwg;
      AppMethodBeat.o(132054);
      return locale;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MMKernel.CoreNetwork", "%s", new Object[] { bs.m(localThrowable) });
      AppMethodBeat.o(132054);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.b.8
 * JD-Core Version:    0.7.0.1
 */