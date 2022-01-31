package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  public long foo = 0L;
  public int mRU = 0;
  public String mRV = "";
  public long mSX = 0L;
  public long mSY = 0L;
  public long mSZ = 0L;
  public String mTa = "";
  public String query = "";
  public long timestamp = 0L;
  public int type = 0;
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(114274);
    this.mSX = paramCursor.getLong(0);
    this.query = paramCursor.getString(1);
    this.mSY = paramCursor.getLong(2);
    this.foo = paramCursor.getLong(3);
    this.mRV = paramCursor.getString(4);
    this.mSZ = paramCursor.getLong(5);
    this.type = paramCursor.getInt(6);
    this.mRU = paramCursor.getInt(7);
    this.timestamp = paramCursor.getLong(8);
    this.mTa = paramCursor.getString(9);
    AppMethodBeat.o(114274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.k
 * JD-Core Version:    0.7.0.1
 */