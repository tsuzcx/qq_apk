package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.o;

abstract class d
{
  protected final com.google.android.exoplayer2.c.m aYi;
  
  protected d(com.google.android.exoplayer2.c.m paramm)
  {
    this.aYi = paramm;
  }
  
  protected abstract void a(com.google.android.exoplayer2.i.m paramm, long paramLong);
  
  protected abstract boolean a(com.google.android.exoplayer2.i.m paramm);
  
  public final void b(com.google.android.exoplayer2.i.m paramm, long paramLong)
  {
    if (a(paramm)) {
      a(paramm, paramLong);
    }
  }
  
  public static final class a
    extends o
  {
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.d
 * JD-Core Version:    0.7.0.1
 */