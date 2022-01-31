package com.tencent.mm.plugin.ext.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

public final class d$a
  implements d.c
{
  public final d.b aM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(20412);
    if (!e.cN(paramString))
    {
      ab.w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: handle not exist");
      AppMethodBeat.o(20412);
      return null;
    }
    paramString = d.d(e.i(paramString, 0, -1), paramBoolean);
    AppMethodBeat.o(20412);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.c.d.a
 * JD-Core Version:    0.7.0.1
 */