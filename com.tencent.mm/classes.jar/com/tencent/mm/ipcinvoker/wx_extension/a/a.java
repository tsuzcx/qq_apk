package com.tencent.mm.ipcinvoker.wx_extension.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public static com.tencent.mm.storage.c wz(String paramString)
  {
    AppMethodBeat.i(153087);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.i("MicroMsg.IPCNewABTest", "get ABTestItem by layerId failed, id is null.", new Object[] { paramString });
      AppMethodBeat.o(153087);
      return null;
    }
    if (((com.tencent.mm.kernel.b.h)g.ajz().ajb()).akw())
    {
      if ((!g.ajD().gBM.gCg) || (!g.ajA().gAD))
      {
        ad.e("MicroMsg.IPCNewABTest", "kernel or account not ready.");
        AppMethodBeat.o(153087);
        return null;
      }
      paramString = com.tencent.mm.model.c.d.aDs().wz(paramString);
      AppMethodBeat.o(153087);
      return paramString;
    }
    com.tencent.mm.model.c.c localc = com.tencent.mm.model.c.c.hJn;
    paramString = com.tencent.mm.model.c.c.BT(paramString);
    AppMethodBeat.o(153087);
    return paramString;
  }
  
  public static final class a
  {
    public static a gyq;
    
    static
    {
      AppMethodBeat.i(153086);
      gyq = new a();
      AppMethodBeat.o(153086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.a.a
 * JD-Core Version:    0.7.0.1
 */