package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.storage.au;
import java.util.List;

public abstract interface j
{
  public abstract au aEa(String paramString);
  
  public abstract boolean aEb(String paramString);
  
  public abstract long aEc(String paramString);
  
  public abstract List<String> aEd(String paramString);
  
  public abstract Cursor h(String paramString, String[] paramArrayOfString);
  
  public abstract Cursor rawQuery(String paramString, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.j
 * JD-Core Version:    0.7.0.1
 */