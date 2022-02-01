package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
{
  public String Hsz = "";
  public long HtG = 0L;
  public long HtH = 0L;
  public long HtI = 0L;
  public String HtJ = "";
  public long nAz = 0L;
  public String query = "";
  public int subtype = 0;
  public long timestamp = 0L;
  public int type = 0;
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131710);
    this.HtG = paramCursor.getLong(0);
    this.query = paramCursor.getString(1);
    this.HtH = paramCursor.getLong(2);
    this.nAz = paramCursor.getLong(3);
    this.Hsz = paramCursor.getString(4);
    this.HtI = paramCursor.getLong(5);
    this.type = paramCursor.getInt(6);
    this.subtype = paramCursor.getInt(7);
    this.timestamp = paramCursor.getLong(8);
    this.HtJ = paramCursor.getString(9);
    AppMethodBeat.o(131710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.n
 * JD-Core Version:    0.7.0.1
 */