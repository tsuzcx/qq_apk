package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.wcdb.database.SQLiteStatement;

public abstract interface h
{
  public abstract void A(long paramLong1, long paramLong2);
  
  public abstract Cursor DI(String paramString);
  
  public abstract boolean DJ(String paramString);
  
  public abstract void beginTransaction();
  
  public abstract boolean cT(int paramInt1, int paramInt2);
  
  public abstract void commit();
  
  public abstract SQLiteStatement compileStatement(String paramString);
  
  public abstract void execSQL(String paramString);
  
  public abstract void execSQL(String paramString, Object[] paramArrayOfObject);
  
  public abstract boolean inTransaction();
  
  public abstract Cursor rawQuery(String paramString, String[] paramArrayOfString);
  
  public abstract long z(long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.h
 * JD-Core Version:    0.7.0.1
 */