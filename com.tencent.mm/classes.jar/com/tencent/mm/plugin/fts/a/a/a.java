package com.tencent.mm.plugin.fts.a.a;

import java.util.ArrayList;
import java.util.List;

public abstract class a
  implements Comparable<a>
{
  public boolean mCancelled = false;
  public int mPriority = 2147483647;
  public long ttZ = 0L;
  public long tua = 0L;
  public List<a> tub;
  public Object tuc;
  
  protected final void akv(String paramString)
  {
    if (this.tub == null) {
      this.tub = new ArrayList();
    }
    a locala = new a();
    locala.tud = paramString;
    locala.timestamp = System.currentTimeMillis();
    this.tub.add(locala);
  }
  
  public String bgU()
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
    public String tud;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.a
 * JD-Core Version:    0.7.0.1
 */