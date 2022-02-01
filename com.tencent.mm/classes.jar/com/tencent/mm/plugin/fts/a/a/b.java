package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public long tEW;
  public int tEX;
  public String tEY;
  public int type;
  
  public final b f(Cursor paramCursor)
  {
    AppMethodBeat.i(131670);
    this.tEW = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.tEX = paramCursor.getInt(2);
    this.tEY = paramCursor.getString(3);
    AppMethodBeat.o(131670);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.b
 * JD-Core Version:    0.7.0.1
 */