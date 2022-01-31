package com.google.android.exoplayer2.h.a;

import java.io.File;
import java.io.IOException;
import java.util.NavigableSet;

public abstract interface a
{
  public abstract NavigableSet<e> a(String paramString, a.b paramb);
  
  public abstract void a(e parame);
  
  public abstract long ay(String paramString);
  
  public abstract void b(e parame);
  
  public abstract e d(String paramString, long paramLong);
  
  public abstract e e(String paramString, long paramLong);
  
  public abstract File e(String paramString, long paramLong1, long paramLong2);
  
  public abstract void f(String paramString, long paramLong);
  
  public abstract boolean f(String paramString, long paramLong1, long paramLong2);
  
  public abstract long g(String paramString, long paramLong1, long paramLong2);
  
  public abstract void k(File paramFile);
  
  public abstract long qw();
  
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.a
 * JD-Core Version:    0.7.0.1
 */