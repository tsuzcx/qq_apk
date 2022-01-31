package com.tencent.mm.plugin.fts.a.a;

import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements Comparable<a>
{
  public long kvY = 0L;
  public long kvZ = 0L;
  public List<a.a> kwa;
  public Object kwb;
  public boolean mCancelled = false;
  public int mPriority = 2147483647;
  
  public final void DW(String paramString)
  {
    if (this.kwa == null) {
      this.kwa = new ArrayList();
    }
    a.a locala = new a.a(this);
    locala.kwc = paramString;
    locala.timestamp = System.currentTimeMillis();
    this.kwa.add(locala);
  }
  
  public String afJ()
  {
    return "";
  }
  
  public abstract boolean execute();
  
  public int getId()
  {
    return -1;
  }
  
  public String getName()
  {
    return "";
  }
  
  public int getPriority()
  {
    return this.mPriority;
  }
  
  public boolean isCancelled()
  {
    return this.mCancelled;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.a
 * JD-Core Version:    0.7.0.1
 */