package com.tencent.mm.plugin.fts.a.a;

import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements Comparable<a>
{
  public boolean mCancelled = false;
  public int mPriority = 2147483647;
  public long tEQ = 0L;
  public long tER = 0L;
  public List<a> tES;
  public Object tET;
  
  protected final void alt(String paramString)
  {
    if (this.tES == null) {
      this.tES = new ArrayList();
    }
    a locala = new a();
    locala.tEU = paramString;
    locala.timestamp = System.currentTimeMillis();
    this.tES.add(locala);
  }
  
  public String bhC()
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
  
  public final class a
  {
    public String tEU;
    public long timestamp;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.a
 * JD-Core Version:    0.7.0.1
 */