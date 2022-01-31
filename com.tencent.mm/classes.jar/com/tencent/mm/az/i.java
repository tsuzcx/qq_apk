package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.sdk.e.k;

public final class i
  extends k
  implements j
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS oplog2 ( id INTEGER PRIMARY KEY , inserTime long , cmdId int , buffer blob , reserved1 int , reserved2 long , reserved3 text , reserved4 text ) " };
  h fnw;
  
  public i(h paramh)
  {
    this.fnw = paramh;
  }
  
  public final boolean b(j.b paramb)
  {
    AppMethodBeat.i(990);
    if (paramb == null)
    {
      AppMethodBeat.o(990);
      return true;
    }
    if (this.fnw.delete("oplog2", "id= ? AND inserTime= ?", new String[] { paramb.id, paramb.fCI }) >= 0)
    {
      AppMethodBeat.o(990);
      return true;
    }
    AppMethodBeat.o(990);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.az.i
 * JD-Core Version:    0.7.0.1
 */