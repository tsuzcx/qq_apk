package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public long Hsy;
  public String Hsz;
  public int subtype;
  public int type;
  
  public final d i(Cursor paramCursor)
  {
    AppMethodBeat.i(131670);
    this.Hsy = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.subtype = paramCursor.getInt(2);
    this.Hsz = paramCursor.getString(3);
    AppMethodBeat.o(131670);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.d
 * JD-Core Version:    0.7.0.1
 */