package com.tencent.mm.ipcinvoker.wx_extension.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  public static com.tencent.mm.storage.c tJ(String paramString)
  {
    AppMethodBeat.i(153087);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.i("MicroMsg.IPCNewABTest", "get ABTestItem by layerId failed, id is null.", new Object[] { paramString });
      AppMethodBeat.o(153087);
      return null;
    }
    if (((com.tencent.mm.kernel.b.h)g.agO().agp()).ahL())
    {
      if ((!g.agS().gic.giw) || (!g.agP().ggT))
      {
        ac.e("MicroMsg.IPCNewABTest", "kernel or account not ready.");
        AppMethodBeat.o(153087);
        return null;
      }
      paramString = com.tencent.mm.model.c.d.aAp().tJ(paramString);
      AppMethodBeat.o(153087);
      return paramString;
    }
    com.tencent.mm.model.c.c localc = com.tencent.mm.model.c.c.hqV;
    paramString = com.tencent.mm.model.c.c.yU(paramString);
    AppMethodBeat.o(153087);
    return paramString;
  }
  
  public static final class a
  {
    public static a geG;
    
    static
    {
      AppMethodBeat.i(153086);
      geG = new a();
      AppMethodBeat.o(153086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.a.a
 * JD-Core Version:    0.7.0.1
 */