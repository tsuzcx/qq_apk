package com.tencent.mm.plugin.fts.a.a;

import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements Comparable<a>
{
  public boolean mCancelled = false;
  public int mPriority = 2147483647;
  public List<a> sxA;
  public Object sxB;
  public long sxy = 0L;
  public long sxz = 0L;
  
  protected final void afX(String paramString)
  {
    if (this.sxA == null) {
      this.sxA = new ArrayList();
    }
    a locala = new a();
    locala.sxC = paramString;
    locala.timestamp = System.currentTimeMillis();
    this.sxA.add(locala);
  }
  
  public String bdq()
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
    public String sxC;
    public long timestamp;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.a
 * JD-Core Version:    0.7.0.1
 */