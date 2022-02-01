package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  public int BHR = 0;
  public String BHS = "";
  public long BIX = 0L;
  public long BIY = 0L;
  public long BIZ = 0L;
  public String BJa = "";
  public long kVd = 0L;
  public String query = "";
  public long timestamp = 0L;
  public int type = 0;
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131710);
    this.BIX = paramCursor.getLong(0);
    this.query = paramCursor.getString(1);
    this.BIY = paramCursor.getLong(2);
    this.kVd = paramCursor.getLong(3);
    this.BHS = paramCursor.getString(4);
    this.BIZ = paramCursor.getLong(5);
    this.type = paramCursor.getInt(6);
    this.BHR = paramCursor.getInt(7);
    this.timestamp = paramCursor.getLong(8);
    this.BJa = paramCursor.getString(9);
    AppMethodBeat.o(131710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.l
 * JD-Core Version:    0.7.0.1
 */