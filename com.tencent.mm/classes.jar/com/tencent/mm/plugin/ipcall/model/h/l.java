package com.tencent.mm.plugin.ipcall.model.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class l
  extends j<k>
{
  public static final String[] SQL_CREATE;
  static final String[] sEf;
  public e db;
  
  static
  {
    AppMethodBeat.i(25562);
    SQL_CREATE = new String[] { j.getCreateSQLs(k.info, "IPCallRecord") };
    sEf = new String[] { "*", "rowid" };
    AppMethodBeat.o(25562);
  }
  
  public l(e parame)
  {
    super(parame, k.info, "IPCallRecord", null);
    this.db = parame;
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(25561);
    if (paramk != null) {
      update(paramk.systemRowid, paramk);
    }
    AppMethodBeat.o(25561);
  }
  
  public final Cursor adY(String paramString)
  {
    AppMethodBeat.i(25558);
    paramString = this.db.query("IPCallRecord", sEf, "phonenumber=?", new String[] { paramString }, null, null, "calltime desc limit 4");
    AppMethodBeat.o(25558);
    return paramString;
  }
  
  public final Cursor adZ(String paramString)
  {
    AppMethodBeat.i(25559);
    paramString = this.db.query("IPCallRecord", sEf, "phonenumber=?", new String[] { paramString }, null, null, "calltime desc");
    AppMethodBeat.o(25559);
    return paramString;
  }
  
  public final Cursor rd(long paramLong)
  {
    AppMethodBeat.i(25560);
    Cursor localCursor = this.db.query("IPCallRecord", sEf, "addressId=?", new String[] { String.valueOf(paramLong) }, null, null, "calltime desc");
    AppMethodBeat.o(25560);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.l
 * JD-Core Version:    0.7.0.1
 */