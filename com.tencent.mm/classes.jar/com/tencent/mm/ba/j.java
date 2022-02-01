package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.storagebase.h;

public final class j
  extends com.tencent.mm.sdk.e.k
  implements com.tencent.mm.plugin.messenger.foundation.a.a.k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS oplog2 ( id INTEGER PRIMARY KEY , inserTime long , cmdId int , buffer blob , reserved1 int , reserved2 long , reserved3 text , reserved4 text ) " };
  h hKK;
  
  public j(h paramh)
  {
    this.hKK = paramh;
  }
  
  public final boolean c(k.b paramb)
  {
    AppMethodBeat.i(116842);
    if (paramb == null)
    {
      AppMethodBeat.o(116842);
      return true;
    }
    if (this.hKK.delete("oplog2", "id= ? AND inserTime= ?", new String[] { paramb.id, paramb.ibj }) >= 0)
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