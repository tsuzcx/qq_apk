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
  private int aNf;
  private final Format[] bgf;
  protected final q bnE;
  protected final int[] bnF;
  private final long[] bnG;
  protected final int length;
  
  public b(q paramq, int... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.bnE = ((q)a.checkNotNull(paramq));
      this.length = paramVarArgs.length;
      this.bgf = new Format[this.length];
      i = 0;
      while (i < paramVarArgs.length)
      {
        Format[] arrayOfFormat = this.bgf;
        int k = paramVarArgs[i];
        arrayOfFormat[i] = paramq.bgf[k];
        i += 1;
      }
    }
    Arrays.sort(this.bgf, new a((byte)0));
    this.bnF = new int[this.length];
    int i = j;
    while (i < this.length)
    {
      this.bnF[i] = paramq.j(this.bgf[i]);
      i += 1;
    }
    this.bnG = new long[this.length];
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
    } while ((this.bnE == paramObject.bnE) && (Arrays.equals(this.bnF, paramObject.bnF)));
    return false;
  }
  
  public final Format fm(int paramInt)
  {
    return this.bgf[paramInt];
  }
  
  public final int fn(int paramInt)
  {
    return this.bnF[paramInt];
  }
  
  public final int fo(int paramInt)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.bnF[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int hashCode()
  {
    if (this.aNf == 0) {
      this.aNf = (System.identityHashCode(this.bnE) * 31 + Arrays.hashCode(this.bnF));
    }
    return this.aNf;
  }
  
  public final int j(Format paramFormat)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.bgf[i] == paramFormat) {
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
    long[] arrayOfLong = this.bnG;
    arrayOfLong[paramInt] = Math.max(arrayOfLong[paramInt], paramLong + 60000L);
    return true;
  }
  
  protected final boolean l(int paramInt, long paramLong)
  {
    return this.bnG[paramInt] > paramLong;
  }
  
  public final int length()
  {
    return this.bnF.length;
  }
  
  public final Format uA()
  {
    return this.bgf[getSelectedIndex()];
  }
  
  public final int uB()
  {
    return this.bnF[getSelectedIndex()];
  }
  
  public final q uz()
  {
    return this.bnE;
  }
  
  static final class a
    implements Comparator<Format>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.g.b
 * JD-Core Version:    0.7.0.1
 */