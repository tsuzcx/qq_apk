package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.storage.af;
import java.util.List;

public abstract interface j
{
  public abstract af aaR(String paramString);
  
  public abstract boolean aaS(String paramString);
  
  public abstract long aaT(String paramString);
  
  public abstract List<String> aaU(String paramString);
  
  public abstract Cursor i(String paramString, String[] paramArrayOfString);
  
  public abstract Cursor rawQuery(String paramString, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.j
 * JD-Core Version:    0.7.0.1
 */