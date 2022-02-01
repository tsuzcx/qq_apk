package com.tencent.mm.plugin.ipcall.model.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class h
  extends MAutoStorage<g>
{
  public static final String[] SQL_CREATE;
  private static final String[] ysI;
  public static int ysJ;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(25550);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(g.info, "IPCallMsg") };
    ysI = new String[] { "*", "rowid" };
    ysJ = 0;
    AppMethodBeat.o(25550);
  }
  
  public h(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, g.info, "IPCallMsg", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final Cursor Pf(int paramInt)
  {
    AppMethodBeat.i(25549);
    Cursor localCursor = this.db.query("IPCallMsg", ysI, null, null, null, null, "pushTime desc limit ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(25549);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.h
 * JD-Core Version:    0.7.0.1
 */