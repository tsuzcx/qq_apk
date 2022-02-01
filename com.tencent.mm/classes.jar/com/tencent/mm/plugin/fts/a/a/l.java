package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  public long hmW = 0L;
  public String query = "";
  public int tEX = 0;
  public String tEY = "";
  public long tGd = 0L;
  public long tGe = 0L;
  public long tGf = 0L;
  public String tGg = "";
  public long timestamp = 0L;
  public int type = 0;
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131710);
    this.tGd = paramCursor.getLong(0);
    this.query = paramCursor.getString(1);
    this.tGe = paramCursor.getLong(2);
    this.hmW = paramCursor.getLong(3);
    this.tEY = paramCursor.getString(4);
    this.tGf = paramCursor.getLong(5);
    this.type = paramCursor.getInt(6);
    this.tEX = paramCursor.getInt(7);
    this.timestamp = paramCursor.getLong(8);
    this.tGg = paramCursor.getString(9);
    AppMethodBeat.o(131710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.l
 * JD-Core Version:    0.7.0.1
 */