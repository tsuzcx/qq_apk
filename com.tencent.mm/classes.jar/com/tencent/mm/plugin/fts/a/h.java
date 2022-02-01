package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.wcdb.database.SQLiteStatement;

public abstract interface h
{
  public abstract long T(long paramLong1, long paramLong2);
  
  public abstract void U(long paramLong1, long paramLong2);
  
  public abstract Cursor aaP(String paramString);
  
  public abstract boolean aaQ(String paramString);
  
  public abstract void beginTransaction();
  
  public abstract void commit();
  
  public abstract SQLiteStatement compileStatement(String paramString);
  
  public abstract void execSQL(String paramString);
  
  public abstract void execSQL(String paramString, Object[] paramArrayOfObject);
  
  public abstract boolean fH(int paramInt1, int paramInt2);
  
  public abstract boolean inTransaction();
  
  public abstract Cursor rawQuery(String paramString, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.h
 * JD-Core Version:    0.7.0.1
 */