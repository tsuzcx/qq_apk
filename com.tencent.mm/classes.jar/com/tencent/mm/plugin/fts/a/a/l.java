package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  public long hki = 0L;
  public String query = "";
  public long timestamp = 0L;
  public int tug = 0;
  public String tuh = "";
  public long tvm = 0L;
  public long tvn = 0L;
  public long tvo = 0L;
  public String tvp = "";
  public int type = 0;
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131710);
    this.tvm = paramCursor.getLong(0);
    this.query = paramCursor.getString(1);
    this.tvn = paramCursor.getLong(2);
    this.hki = paramCursor.getLong(3);
    this.tuh = paramCursor.getString(4);
    this.tvo = paramCursor.getLong(5);
    this.type = paramCursor.getInt(6);
    this.tug = paramCursor.getInt(7);
    this.timestamp = paramCursor.getLong(8);
    this.tvp = paramCursor.getString(9);
    AppMethodBeat.o(131710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.l
 * JD-Core Version:    0.7.0.1
 */