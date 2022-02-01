package com.tencent.mm.ipcinvoker.wx_extension.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static com.tencent.mm.storage.c Fu(String paramString)
  {
    AppMethodBeat.i(153087);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.i("MicroMsg.IPCNewABTest", "get ABTestItem by layerId failed, id is null.", new Object[] { paramString });
      AppMethodBeat.o(153087);
      return null;
    }
    if (((com.tencent.mm.kernel.b.h)g.aAe().azG()).aBb())
    {
      if ((!g.aAi().hrh.hrB) || (!g.aAf().hpY))
      {
        Log.e("MicroMsg.IPCNewABTest", "kernel or account not ready.");
        AppMethodBeat.o(153087);
        return null;
      }
      paramString = com.tencent.mm.model.c.d.aXu().Fu(paramString);
      AppMethodBeat.o(153087);
      return paramString;
    }
    com.tencent.mm.model.c.c localc = com.tencent.mm.model.c.c.iHj;
    paramString = com.tencent.mm.model.c.c.Lg(paramString);
    AppMethodBeat.o(153087);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.a.a
 * JD-Core Version:    0.7.0.1
 */