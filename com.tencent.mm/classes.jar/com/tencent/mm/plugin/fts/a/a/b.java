package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public long BHQ;
  public int BHR;
  public String BHS;
  public int type;
  
  public final b h(Cursor paramCursor)
  {
    AppMethodBeat.i(131670);
    this.BHQ = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.BHR = paramCursor.getInt(2);
    this.BHS = paramCursor.getString(3);
    AppMethodBeat.o(131670);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.b
 * JD-Core Version:    0.7.0.1
 */