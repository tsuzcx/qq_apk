package com.tencent.mm.plugin.honey_pay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class b
  extends j<a>
{
  public static final String[] SQL_CREATE;
  private static final String[] goC;
  private e db;
  
  static
  {
    AppMethodBeat.i(41751);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "HoneyPayMsgRecord") };
    goC = new String[] { "*", "rowid" };
    AppMethodBeat.o(41751);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "HoneyPayMsgRecord", null);
    this.db = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.model.b
 * JD-Core Version:    0.7.0.1
 */