package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.storagebase.h;

public final class i
  extends k
  implements j
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS oplog2 ( id INTEGER PRIMARY KEY , inserTime long , cmdId int , buffer blob , reserved1 int , reserved2 long , reserved3 text , reserved4 text ) " };
  h gPa;
  
  public i(h paramh)
  {
    this.gPa = paramh;
  }
  
  public final boolean b(j.b paramb)
  {
    AppMethodBeat.i(116842);
    if (paramb == null)
    {
      AppMethodBeat.o(116842);
      return true;
    }
    if (this.gPa.delete("oplog2", "id= ? AND inserTime= ?", new String[] { paramb.id, paramb.hfj }) >= 0)
    {
      AppMethodBeat.o(116842);
      return true;
    }
    AppMethodBeat.o(116842);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bb.i
 * JD-Core Version:    0.7.0.1
 */