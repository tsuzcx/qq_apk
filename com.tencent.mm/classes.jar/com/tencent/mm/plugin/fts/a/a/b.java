package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public long mRT;
  public int mRU;
  public String mRV;
  public int type;
  
  public final b f(Cursor paramCursor)
  {
    AppMethodBeat.i(114235);
    this.mRT = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.mRU = paramCursor.getInt(2);
    this.mRV = paramCursor.getString(3);
    AppMethodBeat.o(114235);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.b
 * JD-Core Version:    0.7.0.1
 */