package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;

final class g$a
  extends a
{
  private g$a(g paramg) {}
  
  public final boolean execute()
  {
    AppMethodBeat.i(136795);
    SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException = new SQLiteDatabaseCorruptException("For Test");
    AppMethodBeat.o(136795);
    throw localSQLiteDatabaseCorruptException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.g.a
 * JD-Core Version:    0.7.0.1
 */