package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.l;
import java.util.Arrays;

public abstract class a
  implements e
{
  public final Format[] aIs;
  protected final l aQg;
  protected final int[] aQh;
  private final long[] aQi;
  private int auK;
  public final int length;
  
  public a(l paraml, int... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.aC(bool);
      this.aQg = ((l)com.google.android.exoplayer2.i.a.E(paraml));
      this.length = paramVarArgs.length;
      this.aIs = new Format[this.length];
      i = 0;
      while (i < paramVarArgs.length)
      {
        Format[] arrayOfFormat = this.aIs;
        int k = paramVarArgs[i];
        arrayOfFormat[i] = paraml.aIs[k];
        i += 1;
      }
    }
    Arrays.sort(this.aIs, new a.a((byte)0));
    this.aQh = new int[this.length];
    int i = j;
    while (i < this.length)
    {
      this.aQh[i] = paraml.j(this.aIs[i]);
      i += 1;
    }
    this.aQi = new long[this.length];
  }
  
  public final Format dt(int paramInt)
  {
    return this.aIs[paramInt];
  }
  
  public final int du(int paramInt)
  {
    return this.aQh[paramInt];
  }
  
  public final boolean dv(int paramInt)
  {
    long l = SystemClock.elapsedRealtime();
    boolean bool = g(paramInt, l);
    int i = 0;
    if ((i < this.length) && (!bool))
    {
      if ((i != paramInt) && (!g(i, l))) {}
      for (bool = true;; bool = false)
      {
        i += 1;
        break;
      }
    }
    if (!bool) {
      return false;
    }
    this.aQi[paramInt] = Math.max(this.aQi[paramInt], l + 60000L);
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (a)paramObject;
    } while ((this.aQg == paramObject.aQg) && (Arrays.equals(this.aQh, paramObject.aQh)));
    return false;
  }
  
  public final boolean g(int paramInt, long paramLong)
  {
    return this.aQi[paramInt] > paramLong;
  }
  
  public int hashCode()
  {
    if (this.auK == 0) {
      this.auK = (System.identityHashCode(this.aQg) * 31 + Arrays.hashCode(this.aQh));
    }
    return this.auK;
  }
  
  public final int indexOf(int paramInt)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.aQh[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final int length()
  {
    return this.aQh.length;
  }
  
  public final l nH()
  {
    return this.aQg;
  }
  
  public final Format nI()
  {
    return this.aIs[mW()];
  }
  
  public final int nJ()
  {
    return this.aQh[mW()];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.g.a
 * JD-Core Version:    0.7.0.1
 */