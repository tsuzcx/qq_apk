package com.tencent.mm.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h.b;

final class jo$5
  implements h.b
{
  public final String[] getSQLs()
  {
    AppMethodBeat.i(127415);
    String str = MAutoStorage.getCreateSQLs(bz.aJm(), "FavConfigInfo");
    AppMethodBeat.o(127415);
    return new String[] { str };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.b.jo.5
 * JD-Core Version:    0.7.0.1
 */