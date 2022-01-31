package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;

final class j$1
  extends n
{
  j$1(j paramj) {}
  
  public final boolean aqj()
  {
    AppMethodBeat.i(21937);
    if ((j.a(this.nQj) == null) || (j.a(this.nQj).dun()))
    {
      if (j.a(this.nQj) == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(j.a(this.nQj).dun()))
      {
        ab.w("MicroMsg.IPCallPopularCountryStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        AppMethodBeat.o(21937);
        return false;
      }
    }
    AppMethodBeat.o(21937);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.j.1
 * JD-Core Version:    0.7.0.1
 */