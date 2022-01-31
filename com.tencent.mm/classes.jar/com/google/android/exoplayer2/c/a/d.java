package com.google.android.exoplayer2.c.a;

abstract class d
{
  protected final com.google.android.exoplayer2.c.m aCe;
  
  protected d(com.google.android.exoplayer2.c.m paramm)
  {
    this.aCe = paramm;
  }
  
  protected abstract void a(com.google.android.exoplayer2.i.m paramm, long paramLong);
  
  protected abstract boolean a(com.google.android.exoplayer2.i.m paramm);
  
  public final void b(com.google.android.exoplayer2.i.m paramm, long paramLong)
  {
    if (a(paramm)) {
      a(paramm, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.d
 * JD-Core Version:    0.7.0.1
 */