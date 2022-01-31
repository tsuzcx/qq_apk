package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class l
  extends j<k>
{
  public static final String[] SQL_CREATE;
  static final String[] nQk;
  public e db;
  
  static
  {
    AppMethodBeat.i(21947);
    SQL_CREATE = new String[] { j.getCreateSQLs(k.info, "IPCallRecord") };
    nQk = new String[] { "*", "rowid" };
    AppMethodBeat.o(21947);
  }
  
  public l(e parame)
  {
    super(parame, k.info, "IPCallRecord", null);
    this.db = parame;
  }
  
  public final Cursor Re(String paramString)
  {
    AppMethodBeat.i(21943);
    paramString = this.db.query("IPCallRecord", nQk, "phonenumber=?", new String[] { paramString }, null, null, "calltime desc limit 4");
    AppMethodBeat.o(21943);
    return paramString;
  }
  
  public final Cursor Rf(String paramString)
  {
    AppMethodBeat.i(21944);
    paramString = this.db.query("IPCallRecord", nQk, "phonenumber=?", new String[] { paramString }, null, null, "calltime desc");
    AppMethodBeat.o(21944);
    return paramString;
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(21946);
    if (paramk != null) {
      update(paramk.systemRowid, paramk);
    }
    AppMethodBeat.o(21946);
  }
  
  public final Cursor kt(long paramLong)
  {
    AppMethodBeat.i(21945);
    Cursor localCursor = this.db.query("IPCallRecord", nQk, "addressId=?", new String[] { String.valueOf(paramLong) }, null, null, "calltime desc");
    AppMethodBeat.o(21945);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.l
 * JD-Core Version:    0.7.0.1
 */