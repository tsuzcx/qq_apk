package com.tencent.mm.ipcinvoker.wx_extension.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.i;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static com.tencent.mm.storage.c Mu(String paramString)
  {
    AppMethodBeat.i(153087);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.i("MicroMsg.IPCNewABTest", "get ABTestItem by layerId failed, id is null.", new Object[] { paramString });
      AppMethodBeat.o(153087);
      return null;
    }
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      if ((!com.tencent.mm.kernel.h.aHH().kdc.kdw) || (!com.tencent.mm.kernel.h.aHE().kbT))
      {
        Log.e("MicroMsg.IPCNewABTest", "kernel or account not ready.");
        AppMethodBeat.o(153087);
        return null;
      }
      paramString = com.tencent.mm.model.c.d.bgB().Mu(paramString);
      AppMethodBeat.o(153087);
      return paramString;
    }
    com.tencent.mm.model.c.c localc = com.tencent.mm.model.c.c.lxl;
    paramString = com.tencent.mm.model.c.c.Sz(paramString);
    AppMethodBeat.o(153087);
    return paramString;
  }
  
  public static final class a
  {
    public static a jZD;
    
    static
    {
      AppMethodBeat.i(153086);
      jZD = new a();
      AppMethodBeat.o(153086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.a.a
 * JD-Core Version:    0.7.0.1
 */