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
  private int cHb;
  private final Format[] cZY;
  private final long[] dhA;
  protected final q dhy;
  protected final int[] dhz;
  protected final int length;
  
  public b(q paramq, int... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.dhy = ((q)a.checkNotNull(paramq));
      this.length = paramVarArgs.length;
      this.cZY = new Format[this.length];
      i = 0;
      while (i < paramVarArgs.length)
      {
        Format[] arrayOfFormat = this.cZY;
        int k = paramVarArgs[i];
        arrayOfFormat[i] = paramq.cZY[k];
        i += 1;
      }
    }
    Arrays.sort(this.cZY, new a((byte)0));
    this.dhz = new int[this.length];
    int i = j;
    while (i < this.length)
    {
      this.dhz[i] = paramq.j(this.cZY[i]);
      i += 1;
    }
    this.dhA = new long[this.length];
  }
  
  public final q Uc()
  {
    return this.dhy;
  }
  
  public final Format Ud()
  {
    return this.cZY[getSelectedIndex()];
  }
  
  public final int Ue()
  {
    return this.dhz[getSelectedIndex()];
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
    } while ((this.dhy == paramObject.dhy) && (Arrays.equals(this.dhz, paramObject.dhz)));
    return false;
  }
  
  public final int es(int paramInt)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.dhz[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int hashCode()
  {
    if (this.cHb == 0) {
      this.cHb = (System.identityHashCode(this.dhy) * 31 + Arrays.hashCode(this.dhz));
    }
    return this.cHb;
  }
  
  public final Format iB(int paramInt)
  {
    return this.cZY[paramInt];
  }
  
  public final int iC(int paramInt)
  {
    return this.dhz[paramInt];
  }
  
  public final int j(Format paramFormat)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.cZY[i] == paramFormat) {
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
    long[] arrayOfLong = this.dhA;
    arrayOfLong[paramInt] = Math.max(arrayOfLong[paramInt], paramLong + 60000L);
    return true;
  }
  
  protected final boolean l(int paramInt, long paramLong)
  {
    return this.dhA[paramInt] > paramLong;
  }
  
  public final int length()
  {
    return this.dhz.length;
  }
  
  static final class a
    implements Comparator<Format>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.g.b
 * JD-Core Version:    0.7.0.1
 */