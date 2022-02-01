package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.storage.as;
import java.util.List;

public abstract interface j
{
  public abstract as aHC(String paramString);
  
  public abstract boolean aHD(String paramString);
  
  public abstract long aHE(String paramString);
  
  public abstract List<String> aHF(String paramString);
  
  public abstract Cursor h(String paramString, String[] paramArrayOfString);
  
  public abstract Cursor rawQuery(String paramString, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.j
 * JD-Core Version:    0.7.0.1
 */