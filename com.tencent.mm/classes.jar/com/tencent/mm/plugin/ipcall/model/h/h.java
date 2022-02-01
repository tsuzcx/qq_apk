package com.tencent.mm.plugin.ipcall.model.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class h
  extends j<g>
{
  public static final String[] SQL_CREATE;
  private static final String[] sEc;
  public static int sEd;
  public e db;
  
  static
  {
    AppMethodBeat.i(25550);
    SQL_CREATE = new String[] { j.getCreateSQLs(g.info, "IPCallMsg") };
    sEc = new String[] { "*", "rowid" };
    sEd = 0;
    AppMethodBeat.o(25550);
  }
  
  public h(e parame)
  {
    super(parame, g.info, "IPCallMsg", null);
    this.db = parame;
  }
  
  public final Cursor Fn(int paramInt)
  {
    AppMethodBeat.i(25549);
    Cursor localCursor = this.db.query("IPCallMsg", sEc, null, null, null, null, "pushTime desc limit ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(25549);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.h
 * JD-Core Version:    0.7.0.1
 */