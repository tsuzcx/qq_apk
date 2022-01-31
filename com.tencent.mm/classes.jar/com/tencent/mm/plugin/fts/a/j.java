package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.storage.ad;
import java.util.List;

public abstract interface j
{
  public abstract ad DK(String paramString);
  
  public abstract boolean DL(String paramString);
  
  public abstract long DM(String paramString);
  
  public abstract List<String> DN(String paramString);
  
  public abstract Cursor g(String paramString, String[] paramArrayOfString);
  
  public abstract Cursor rawQuery(String paramString, String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.j
 * JD-Core Version:    0.7.0.1
 */