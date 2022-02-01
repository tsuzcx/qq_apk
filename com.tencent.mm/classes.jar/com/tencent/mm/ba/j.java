package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.storagebase.h;

public final class j
  extends k
  implements com.tencent.mm.plugin.messenger.foundation.a.a.j
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS oplog2 ( id INTEGER PRIMARY KEY , inserTime long , cmdId int , buffer blob , reserved1 int , reserved2 long , reserved3 text , reserved4 text ) " };
  h hpA;
  
  public j(h paramh)
  {
    this.hpA = paramh;
  }
  
  public final boolean b(j.b paramb)
  {
    AppMethodBeat.i(116842);
    if (paramb == null)
    {
      AppMethodBeat.o(116842);
      return true;
    }
    if (this.hpA.delete("oplog2", "id= ? AND inserTime= ?", new String[] { paramb.id, paramb.hFM }) >= 0)
    {
      AppMethodBeat.o(116842);
      return true;
    }
    AppMethodBeat.o(116842);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.j
 * JD-Core Version:    0.7.0.1
 */