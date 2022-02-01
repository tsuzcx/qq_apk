package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  public long gRQ = 0L;
  public String query = "";
  public int sxF = 0;
  public String sxG = "";
  public long syL = 0L;
  public long syM = 0L;
  public long syN = 0L;
  public String syO = "";
  public long timestamp = 0L;
  public int type = 0;
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131710);
    this.syL = paramCursor.getLong(0);
    this.query = paramCursor.getString(1);
    this.syM = paramCursor.getLong(2);
    this.gRQ = paramCursor.getLong(3);
    this.sxG = paramCursor.getString(4);
    this.syN = paramCursor.getLong(5);
    this.type = paramCursor.getInt(6);
    this.sxF = paramCursor.getInt(7);
    this.timestamp = paramCursor.getLong(8);
    this.syO = paramCursor.getString(9);
    AppMethodBeat.o(131710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.l
 * JD-Core Version:    0.7.0.1
 */