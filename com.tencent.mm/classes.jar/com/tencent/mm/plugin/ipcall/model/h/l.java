package com.tencent.mm.plugin.ipcall.model.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class l
  extends MAutoStorage<k>
{
  static final String[] JJZ;
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(25562);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(k.info, "IPCallRecord") };
    JJZ = new String[] { "*", "rowid" };
    AppMethodBeat.o(25562);
  }
  
  public l(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, k.info, "IPCallRecord", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(25561);
    if (paramk != null) {
      update(paramk.systemRowid, paramk);
    }
    AppMethodBeat.o(25561);
  }
  
  public final Cursor aJa(String paramString)
  {
    AppMethodBeat.i(25558);
    paramString = this.db.query("IPCallRecord", JJZ, "phonenumber=?", new String[] { paramString }, null, null, "calltime desc limit 4");
    AppMethodBeat.o(25558);
    return paramString;
  }
  
  public final Cursor aJb(String paramString)
  {
    AppMethodBeat.i(25559);
    paramString = this.db.query("IPCallRecord", JJZ, "phonenumber=?", new String[] { paramString }, null, null, "calltime desc");
    AppMethodBeat.o(25559);
    return paramString;
  }
  
  public final Cursor sd(long paramLong)
  {
    AppMethodBeat.i(25560);
    Cursor localCursor = this.db.query("IPCallRecord", JJZ, "addressId=?", new String[] { String.valueOf(paramLong) }, null, null, "calltime desc");
    AppMethodBeat.o(25560);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.l
 * JD-Core Version:    0.7.0.1
 */