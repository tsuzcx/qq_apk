package com.tencent.mm.plugin.fts.a.a;

import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements Comparable<a>
{
  public boolean mCancelled = false;
  public int mPriority = 2147483647;
  public long roF = 0L;
  public long roG = 0L;
  public List<a> roH;
  public Object roI;
  
  public String aWs()
  {
    return "";
  }
  
  protected final void abf(String paramString)
  {
    if (this.roH == null) {
      this.roH = new ArrayList();
    }
    a locala = new a();
    locala.roJ = paramString;
    locala.timestamp = System.currentTimeMillis();
    this.roH.add(locala);
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
    public String roJ;
    public long timestamp;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.a
 * JD-Core Version:    0.7.0.1
 */