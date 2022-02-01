package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.source.p;
import java.util.Arrays;
import java.util.Comparator;

public abstract class b
  implements f
{
  private int aFj;
  final Format[] blC;
  protected final p bvN;
  protected final int[] bvO;
  private final long[] bvP;
  protected final int length;
  
  public b(p paramp, int... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.bvN = ((p)a.checkNotNull(paramp));
      this.length = paramVarArgs.length;
      this.blC = new Format[this.length];
      i = 0;
      while (i < paramVarArgs.length)
      {
        Format[] arrayOfFormat = this.blC;
        int k = paramVarArgs[i];
        arrayOfFormat[i] = paramp.blC[k];
        i += 1;
      }
    }
    Arrays.sort(this.blC, new a((byte)0));
    this.bvO = new int[this.length];
    int i = j;
    while (i < this.length)
    {
      this.bvO[i] = paramp.j(this.blC[i]);
      i += 1;
    }
    this.bvP = new long[this.length];
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
    } while ((this.bvN == paramObject.bvN) && (Arrays.equals(this.bvO, paramObject.bvO)));
    return false;
  }
  
  public final Format fe(int paramInt)
  {
    return this.blC[paramInt];
  }
  
  public final int ff(int paramInt)
  {
    return this.bvO[paramInt];
  }
  
  public final boolean fg(int paramInt)
  {
    long l = SystemClock.elapsedRealtime();
    boolean bool = l(paramInt, l);
    int i = 0;
    if ((i < this.length) && (!bool))
    {
      if ((i != paramInt) && (!l(i, l))) {}
      for (bool = true;; bool = false)
      {
        i += 1;
        break;
      }
    }
    if (!bool) {
      return false;
    }
    long[] arrayOfLong = this.bvP;
    arrayOfLong[paramInt] = Math.max(arrayOfLong[paramInt], l + 60000L);
    return true;
  }
  
  public int hashCode()
  {
    if (this.aFj == 0) {
      this.aFj = (System.identityHashCode(this.bvN) * 31 + Arrays.hashCode(this.bvO));
    }
    return this.aFj;
  }
  
  public final int indexOf(int paramInt)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.bvO[i] == paramInt) {
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
      if (this.blC[i] == paramFormat) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected final boolean l(int paramInt, long paramLong)
  {
    return this.bvP[paramInt] > paramLong;
  }
  
  public final int length()
  {
    return this.bvO.length;
  }
  
  public final p va()
  {
    return this.bvN;
  }
  
  public final Format vb()
  {
    return this.blC[getSelectedIndex()];
  }
  
  public final int vc()
  {
    return this.bvO[getSelectedIndex()];
  }
  
  static final class a
    implements Comparator<Format>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.g.b
 * JD-Core Version:    0.7.0.1
 */