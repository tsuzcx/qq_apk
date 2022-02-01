package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  public long gri = 0L;
  public String query = "";
  public int roM = 0;
  public String roN = "";
  public long rpR = 0L;
  public long rpS = 0L;
  public long rpT = 0L;
  public String rpU = "";
  public long timestamp = 0L;
  public int type = 0;
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131710);
    this.rpR = paramCursor.getLong(0);
    this.query = paramCursor.getString(1);
    this.rpS = paramCursor.getLong(2);
    this.gri = paramCursor.getLong(3);
    this.roN = paramCursor.getString(4);
    this.rpT = paramCursor.getLong(5);
    this.type = paramCursor.getInt(6);
    this.roM = paramCursor.getInt(7);
    this.timestamp = paramCursor.getLong(8);
    this.rpU = paramCursor.getString(9);
    AppMethodBeat.o(131710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.l
 * JD-Core Version:    0.7.0.1
 */