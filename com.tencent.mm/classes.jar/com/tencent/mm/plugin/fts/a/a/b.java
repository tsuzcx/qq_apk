package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public long sxE;
  public int sxF;
  public String sxG;
  public int type;
  
  public final b f(Cursor paramCursor)
  {
    AppMethodBeat.i(131670);
    this.sxE = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.sxF = paramCursor.getInt(2);
    this.sxG = paramCursor.getString(3);
    AppMethodBeat.o(131670);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.b
 * JD-Core Version:    0.7.0.1
 */