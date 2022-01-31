package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class h
  extends j<g>
{
  public static final String[] SQL_CREATE;
  private static final String[] nQh;
  public static int nQi;
  public e db;
  
  static
  {
    AppMethodBeat.i(21935);
    SQL_CREATE = new String[] { j.getCreateSQLs(g.info, "IPCallMsg") };
    nQh = new String[] { "*", "rowid" };
    nQi = 0;
    AppMethodBeat.o(21935);
  }
  
  public h(e parame)
  {
    super(parame, g.info, "IPCallMsg", null);
    this.db = parame;
  }
  
  public final Cursor xL(int paramInt)
  {
    AppMethodBeat.i(21934);
    Cursor localCursor = this.db.query("IPCallMsg", nQh, null, null, null, null, "pushTime desc limit ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(21934);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.h
 * JD-Core Version:    0.7.0.1
 */