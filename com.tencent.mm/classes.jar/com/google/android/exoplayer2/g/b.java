package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.source.o;
import java.util.Arrays;

public abstract class b
  implements f
{
  final Format[] aQc;
  protected final o aXK;
  protected final int[] aXL;
  private final long[] aXM;
  private int axc;
  protected final int length;
  
  public b(o paramo, int... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.aXK = ((o)a.checkNotNull(paramo));
      this.length = paramVarArgs.length;
      this.aQc = new Format[this.length];
      i = 0;
      while (i < paramVarArgs.length)
      {
        Format[] arrayOfFormat = this.aQc;
        int k = paramVarArgs[i];
        arrayOfFormat[i] = paramo.aQc[k];
        i += 1;
      }
    }
    Arrays.sort(this.aQc, new b.a((byte)0));
    this.aXL = new int[this.length];
    int i = j;
    while (i < this.length)
    {
      this.aXL[i] = paramo.j(this.aQc[i]);
      i += 1;
    }
    this.aXM = new long[this.length];
  }
  
  public final Format eg(int paramInt)
  {
    return this.aQc[paramInt];
  }
  
  public final int eh(int paramInt)
  {
    return this.aXL[paramInt];
  }
  
  public final boolean ei(int paramInt)
  {
    long l = SystemClock.elapsedRealtime();
    boolean bool = k(paramInt, l);
    int i = 0;
    if ((i < this.length) && (!bool))
    {
      if ((i != paramInt) && (!k(i, l))) {}
      for (bool = true;; bool = false)
      {
        i += 1;
        break;
      }
    }
    if (!bool) {
      return false;
    }
    long[] arrayOfLong = this.aXM;
    arrayOfLong[paramInt] = Math.max(arrayOfLong[paramInt], l + 60000L);
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
      paramObject = (b)paramObject;
    } while ((this.aXK == paramObject.aXK) && (Arrays.equals(this.aXL, paramObject.aXL)));
    return false;
  }
  
  public int hashCode()
  {
    if (this.axc == 0) {
      this.axc = (System.identityHashCode(this.aXK) * 31 + Arrays.hashCode(this.aXL));
    }
    return this.axc;
  }
  
  public final int indexOf(int paramInt)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.aXL[i] == paramInt) {
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
      if (this.aQc[i] == paramFormat) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected final boolean k(int paramInt, long paramLong)
  {
    return this.aXM[paramInt] > paramLong;
  }
  
  public final int length()
  {
    return this.aXL.length;
  }
  
  public final o qg()
  {
    return this.aXK;
  }
  
  public final Format qh()
  {
    return this.aQc[pv()];
  }
  
  public final int qi()
  {
    return this.aXL[pv()];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.g.b
 * JD-Core Version:    0.7.0.1
 */