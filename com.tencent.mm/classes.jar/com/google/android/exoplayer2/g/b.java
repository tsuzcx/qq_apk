package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.source.q;
import java.util.Arrays;
import java.util.Comparator;

public abstract class b
  implements f
{
  private int aHK;
  protected final q bEd;
  protected final int[] bEe;
  private final long[] bEf;
  final Format[] bwD;
  protected final int length;
  
  public b(q paramq, int... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.bEd = ((q)a.checkNotNull(paramq));
      this.length = paramVarArgs.length;
      this.bwD = new Format[this.length];
      i = 0;
      while (i < paramVarArgs.length)
      {
        Format[] arrayOfFormat = this.bwD;
        int k = paramVarArgs[i];
        arrayOfFormat[i] = paramq.bwD[k];
        i += 1;
      }
    }
    Arrays.sort(this.bwD, new a((byte)0));
    this.bEe = new int[this.length];
    int i = j;
    while (i < this.length)
    {
      this.bEe[i] = paramq.j(this.bwD[i]);
      i += 1;
    }
    this.bEf = new long[this.length];
  }
  
  public final Format eU(int paramInt)
  {
    return this.bwD[paramInt];
  }
  
  public final int eV(int paramInt)
  {
    return this.bEe[paramInt];
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
      paramObject = (b)paramObject;
    } while ((this.bEd == paramObject.bEd) && (Arrays.equals(this.bEe, paramObject.bEe)));
    return false;
  }
  
  public int hashCode()
  {
    if (this.aHK == 0) {
      this.aHK = (System.identityHashCode(this.bEd) * 31 + Arrays.hashCode(this.bEe));
    }
    return this.aHK;
  }
  
  public final int indexOf(int paramInt)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.bEe[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final int j(Format paramFormat)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.bwD[i] == paramFormat) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final boolean k(int paramInt, long paramLong)
  {
    paramLong = SystemClock.elapsedRealtime();
    boolean bool = l(paramInt, paramLong);
    int i = 0;
    if ((i < this.length) && (!bool))
    {
      if ((i != paramInt) && (!l(i, paramLong))) {}
      for (bool = true;; bool = false)
      {
        i += 1;
        break;
      }
    }
    if (!bool) {
      return false;
    }
    long[] arrayOfLong = this.bEf;
    arrayOfLong[paramInt] = Math.max(arrayOfLong[paramInt], paramLong + 60000L);
    return true;
  }
  
  protected final boolean l(int paramInt, long paramLong)
  {
    return this.bEf[paramInt] > paramLong;
  }
  
  public final int length()
  {
    return this.bEe.length;
  }
  
  public final int wA()
  {
    return this.bEe[getSelectedIndex()];
  }
  
  public final q wy()
  {
    return this.bEd;
  }
  
  public final Format wz()
  {
    return this.bwD[getSelectedIndex()];
  }
  
  static final class a
    implements Comparator<Format>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.g.b
 * JD-Core Version:    0.7.0.1
 */