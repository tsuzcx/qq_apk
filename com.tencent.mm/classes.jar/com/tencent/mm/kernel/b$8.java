package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.network.d.a;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b$8
  implements d.a
{
  public b$8(b paramb) {}
  
  public final g azD()
  {
    AppMethodBeat.i(132054);
    try
    {
      g localg = b.a(this.hqm).iMw;
      AppMethodBeat.o(132054);
      return localg;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MMKernel.CoreNetwork", "%s", new Object[] { Util.stackTraceToString(localThrowable) });
      AppMethodBeat.o(132054);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kernel.b.8
 * JD-Core Version:    0.7.0.1
 */