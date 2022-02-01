package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.b.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class b$8
  implements b.a
{
  public b$8(b paramb) {}
  
  public final e ajn()
  {
    AppMethodBeat.i(132054);
    try
    {
      e locale = b.a(this.gDz).hRo;
      AppMethodBeat.o(132054);
      return locale;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MMKernel.CoreNetwork", "%s", new Object[] { bu.o(localThrowable) });
      AppMethodBeat.o(132054);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.b.8
 * JD-Core Version:    0.7.0.1
 */