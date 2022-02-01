package com.tencent.mm.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h.b;

final class jo$3
  implements h.b
{
  public final String[] getSQLs()
  {
    AppMethodBeat.i(127413);
    String str = MAutoStorage.getCreateSQLs(ca.aJm(), "FavEditInfo");
    AppMethodBeat.o(127413);
    return new String[] { str };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.b.jo.3
 * JD-Core Version:    0.7.0.1
 */