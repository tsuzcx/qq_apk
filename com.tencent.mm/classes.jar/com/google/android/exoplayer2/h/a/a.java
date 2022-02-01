package com.google.android.exoplayer2.h.a;

import java.io.File;
import java.io.IOException;
import java.util.NavigableSet;

public abstract interface a
{
  public abstract NavigableSet<g> a(String paramString, b paramb);
  
  public abstract void a(g paramg);
  
  public abstract void b(g paramg);
  
  public abstract long bA(String paramString);
  
  public abstract g e(String paramString, long paramLong);
  
  public abstract File e(String paramString, long paramLong1, long paramLong2);
  
  public abstract long f(String paramString, long paramLong1, long paramLong2);
  
  public abstract g f(String paramString, long paramLong);
  
  public abstract void g(String paramString, long paramLong);
  
  public abstract void r(File paramFile);
  
  public abstract long uP();
  
  public static class a
    extends IOException
  {
    public a(IOException paramIOException)
    {
      super();
    }
    
    public a(String paramString)
    {
      super();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(a parama, g paramg);
    
    public abstract void a(a parama, g paramg1, g paramg2);
    
    public abstract void b(a parama, g paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.a
 * JD-Core Version:    0.7.0.1
 */