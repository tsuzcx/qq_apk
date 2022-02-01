package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class h
  extends j<g>
{
  public static final String[] SQL_CREATE;
  public e db;
  
  static
  {
    AppMethodBeat.i(112780);
    SQL_CREATE = new String[] { j.getCreateSQLs(g.info, "CardMsgInfo") };
    AppMethodBeat.o(112780);
  }
  
  public h(e parame)
  {
    super(parame, g.info, "CardMsgInfo", null);
    this.db = parame;
  }
  
  public final int bIR()
  {
    int i = 0;
    AppMethodBeat.i(112778);
    Cursor localCursor = this.db.a(" select count(*) from CardMsgInfo where read_state = ? ", new String[] { "1" }, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(112778);
      return 0;
    }
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(112778);
    return i;
  }
  
  public final boolean bIS()
  {
    AppMethodBeat.i(112779);
    boolean bool = this.db.execSQL("CardMsgInfo", " update CardMsgInfo set read_state = 0  where read_state = 1");
    AppMethodBeat.o(112779);
    return bool;
  }
  
  public final Cursor getAll()
  {
    AppMethodBeat.i(112777);
    Cursor localCursor = this.db.rawQuery("select * from CardMsgInfo order by time desc", null);
    AppMethodBeat.o(112777);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.h
 * JD-Core Version:    0.7.0.1
 */