package com.tencent.mm.ipcinvoker.wx_extension.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.i;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static com.tencent.mm.storage.c Fd(String paramString)
  {
    AppMethodBeat.i(153087);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.i("MicroMsg.IPCNewABTest", "get ABTestItem by layerId failed, id is null.", new Object[] { paramString });
      AppMethodBeat.o(153087);
      return null;
    }
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      if ((!com.tencent.mm.kernel.h.baF().mDl.mDG) || (!com.tencent.mm.kernel.h.baC().mBZ))
      {
        Log.e("MicroMsg.IPCNewABTest", "kernel or account not ready.");
        AppMethodBeat.o(153087);
        return null;
      }
      paramString = com.tencent.mm.model.newabtest.d.bEt().Fd(paramString);
      AppMethodBeat.o(153087);
      return paramString;
    }
    com.tencent.mm.model.newabtest.c localc = com.tencent.mm.model.newabtest.c.ooH;
    paramString = com.tencent.mm.model.newabtest.c.KB(paramString);
    AppMethodBeat.o(153087);
    return paramString;
  }
  
  public static final class a
  {
    public static a mzH;
    
    static
    {
      AppMethodBeat.i(153086);
      mzH = new a();
      AppMethodBeat.o(153086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.a.a
 * JD-Core Version:    0.7.0.1
 */