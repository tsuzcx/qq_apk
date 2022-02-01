package com.tencent.mm.plugin.fts.a.a;

import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements Comparable<a>
{
  public boolean mCancelled = false;
  public int mPriority = 2147483647;
  public long wVP = 0L;
  public long wVQ = 0L;
  public List<a> wVR;
  public Object wVS;
  
  protected final void ayx(String paramString)
  {
    if (this.wVR == null) {
      this.wVR = new ArrayList();
    }
    a locala = new a();
    locala.wVT = paramString;
    locala.timestamp = System.currentTimeMillis();
    this.wVR.add(locala);
  }
  
  public String bCQ()
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
    public long timestamp;
    public String wVT;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.a
 * JD-Core Version:    0.7.0.1
 */