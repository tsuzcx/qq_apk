package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;

public final class k
{
  public String bVk = "";
  public long dYk = 0L;
  public int kwf = 0;
  public String kwg = "";
  public long kxi = 0L;
  public long kxj = 0L;
  public long kxk = 0L;
  public String kxl = "";
  public long timestamp = 0L;
  public int type = 0;
  
  public final void d(Cursor paramCursor)
  {
    this.kxi = paramCursor.getLong(0);
    this.bVk = paramCursor.getString(1);
    this.kxj = paramCursor.getLong(2);
    this.dYk = paramCursor.getLong(3);
    this.kwg = paramCursor.getString(4);
    this.kxk = paramCursor.getLong(5);
    this.type = paramCursor.getInt(6);
    this.kwf = paramCursor.getInt(7);
    this.timestamp = paramCursor.getLong(8);
    this.kxl = paramCursor.getString(9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.k
 * JD-Core Version:    0.7.0.1
 */