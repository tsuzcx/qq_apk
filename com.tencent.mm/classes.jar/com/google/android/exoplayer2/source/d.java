package com.google.android.exoplayer2.source;

public final class d
  implements j
{
  private final j[] aIk;
  
  public d(j[] paramArrayOfj)
  {
    this.aIk = paramArrayOfj;
  }
  
  public final boolean J(long paramLong)
  {
    boolean bool3 = false;
    boolean bool4;
    boolean bool1;
    do
    {
      long l = mC();
      bool4 = bool3;
      if (l == -9223372036854775808L) {
        break;
      }
      j[] arrayOfj = this.aIk;
      int j = arrayOfj.length;
      int i = 0;
      boolean bool2;
      for (bool1 = false; i < j; bool1 = bool2)
      {
        j localj = arrayOfj[i];
        bool2 = bool1;
        if (localj.mC() == l) {
          bool2 = bool1 | localj.J(paramLong);
        }
        i += 1;
      }
      bool4 = bool3 | bool1;
      bool3 = bool4;
    } while (bool1);
    return bool4;
  }
  
  public final long mB()
  {
    j[] arrayOfj = this.aIk;
    int j = arrayOfj.length;
    int i = 0;
    for (long l1 = 9223372036854775807L; i < j; l1 = l2)
    {
      long l3 = arrayOfj[i].mB();
      l2 = l1;
      if (l3 != -9223372036854775808L) {
        l2 = Math.min(l1, l3);
      }
      i += 1;
    }
    long l2 = l1;
    if (l1 == 9223372036854775807L) {
      l2 = -9223372036854775808L;
    }
    return l2;
  }
  
  public final long mC()
  {
    j[] arrayOfj = this.aIk;
    int j = arrayOfj.length;
    int i = 0;
    for (long l1 = 9223372036854775807L; i < j; l1 = l2)
    {
      long l3 = arrayOfj[i].mC();
      l2 = l1;
      if (l3 != -9223372036854775808L) {
        l2 = Math.min(l1, l3);
      }
      i += 1;
    }
    long l2 = l1;
    if (l1 == 9223372036854775807L) {
      l2 = -9223372036854775808L;
    }
    return l2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.d
 * JD-Core Version:    0.7.0.1
 */