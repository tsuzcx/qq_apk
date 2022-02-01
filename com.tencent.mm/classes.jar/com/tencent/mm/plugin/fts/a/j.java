package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.storage.ai;
import java.util.List;

public abstract interface j
{
  public abstract ai afJ(String paramString);
  
  public abstract boolean afK(String paramString);
  
  public abstract long afL(String paramString);
  
  public abstract List<String> afM(String paramString);
  
  public abstract Cursor i(String paramString, String[] paramArrayOfString);
  
  public abstract Cursor rawQuery(String paramString, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.j
 * JD-Core Version:    0.7.0.1
 */