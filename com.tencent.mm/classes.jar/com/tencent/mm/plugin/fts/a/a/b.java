package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public int type;
  public long wVV;
  public int wVW;
  public String wVX;
  
  public final b f(Cursor paramCursor)
  {
    AppMethodBeat.i(131670);
    this.wVV = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.wVW = paramCursor.getInt(2);
    this.wVX = paramCursor.getString(3);
    AppMethodBeat.o(131670);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.b
 * JD-Core Version:    0.7.0.1
 */