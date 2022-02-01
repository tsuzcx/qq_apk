package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;

public final class j
  extends MStorage
  implements k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS oplog2 ( id INTEGER PRIMARY KEY , inserTime long , cmdId int , buffer blob , reserved1 int , reserved2 long , reserved3 text , reserved4 text ) " };
  h omV;
  
  public j(h paramh)
  {
    this.omV = paramh;
  }
  
  public final boolean c(k.b paramb)
  {
    AppMethodBeat.i(116842);
    if (paramb == null)
    {
      AppMethodBeat.o(116842);
      return true;
    }
    if (this.omV.delete("oplog2", "id= ? AND inserTime= ?", new String[] { paramb.id, paramb.oFj }) >= 0)
    {
      AppMethodBeat.o(116842);
      return true;
    }
    AppMethodBeat.o(116842);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.j
 * JD-Core Version:    0.7.0.1
 */