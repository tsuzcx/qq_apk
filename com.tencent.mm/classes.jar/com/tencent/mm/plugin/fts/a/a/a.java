package com.tencent.mm.plugin.fts.a.a;

import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements Comparable<a>
{
  public long BHK = 0L;
  public long BHL = 0L;
  public List<a> BHM;
  public Object BHN;
  public boolean mCancelled = false;
  public int mPriority = 2147483647;
  
  public abstract boolean aEv();
  
  protected final void aHR(String paramString)
  {
    if (this.BHM == null) {
      this.BHM = new ArrayList();
    }
    a locala = new a();
    locala.BHO = paramString;
    locala.timestamp = System.currentTimeMillis();
    this.BHM.add(locala);
  }
  
  public String bOl()
  {
    return "";
  }
  
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
    public String BHO;
    public long timestamp;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.a
 * JD-Core Version:    0.7.0.1
 */