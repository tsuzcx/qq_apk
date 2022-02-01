package com.tencent.mm.plugin.fts.a.a;

import java.util.ArrayList;
import java.util.List;

public abstract class c
  implements Comparable<c>
{
  public long Hss = 0L;
  public long Hst = 0L;
  public List<a> Hsu;
  public Object Hsv;
  public boolean mCancelled = false;
  public int mPriority = 2147483647;
  
  protected final void aEp(String paramString)
  {
    if (this.Hsu == null) {
      this.Hsu = new ArrayList();
    }
    a locala = new a();
    locala.Hsw = paramString;
    locala.timestamp = System.currentTimeMillis();
    this.Hsu.add(locala);
  }
  
  public abstract boolean aXz();
  
  public String coz()
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
    public String Hsw;
    public long timestamp;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.c
 * JD-Core Version:    0.7.0.1
 */