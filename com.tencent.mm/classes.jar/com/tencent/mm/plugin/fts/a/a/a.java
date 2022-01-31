package com.tencent.mm.plugin.fts.a.a;

import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements Comparable<a>
{
  public boolean mCancelled = false;
  public int mPriority = 2147483647;
  public long mRN = 0L;
  public long mRO = 0L;
  public List<a.a> mRP;
  public Object mRQ;
  
  protected final void Pg(String paramString)
  {
    if (this.mRP == null) {
      this.mRP = new ArrayList();
    }
    a.a locala = new a.a(this);
    locala.mRR = paramString;
    locala.timestamp = System.currentTimeMillis();
    this.mRP.add(locala);
  }
  
  public String aAn()
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