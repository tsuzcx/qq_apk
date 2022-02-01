package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  public long igp = 0L;
  public String query = "";
  public long timestamp = 0L;
  public int type = 0;
  public int wVW = 0;
  public String wVX = "";
  public long wXc = 0L;
  public long wXd = 0L;
  public long wXe = 0L;
  public String wXf = "";
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131710);
    this.wXc = paramCursor.getLong(0);
    this.query = paramCursor.getString(1);
    this.wXd = paramCursor.getLong(2);
    this.igp = paramCursor.getLong(3);
    this.wVX = paramCursor.getString(4);
    this.wXe = paramCursor.getLong(5);
    this.type = paramCursor.getInt(6);
    this.wVW = paramCursor.getInt(7);
    this.timestamp = paramCursor.getLong(8);
    this.wXf = paramCursor.getString(9);
    AppMethodBeat.o(131710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.l
 * JD-Core Version:    0.7.0.1
 */