package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.source.o;
import java.util.Arrays;
import java.util.Comparator;

public abstract class b
  implements f
{
  private int aHQ;
  protected final o bEb;
  protected final int[] bEc;
  private final long[] bEd;
  final Format[] bwC;
  protected final int length;
  
  public b(o paramo, int... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.bEb = ((o)a.checkNotNull(paramo));
      this.length = paramVarArgs.length;
      this.bwC = new Format[this.length];
      i = 0;
      while (i < paramVarArgs.length)
      {
        Format[] arrayOfFormat = this.bwC;
        int k = paramVarArgs[i];
        arrayOfFormat[i] = paramo.bwC[k];
        i += 1;
      }
    }
    Arrays.sort(this.bwC, new a((byte)0));
    this.bEc = new int[this.length];
    int i = j;
    while (i < this.length)
    {
      this.bEc[i] = paramo.j(this.bwC[i]);
      i += 1;
    }
    this.bEd = new long[this.length];
  }
  
  public final Format eV(int paramInt)
  {
    return this.bwC[paramInt];
  }
  
  public final int eW(int paramInt)
  {
    return this.bEc[paramInt];
  }
  
  public final boolean eX(int paramInt)
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
    long[] arrayOfLong = this.bEd;
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
    } while ((this.bEb == paramObject.bEb) && (Arrays.equals(this.bEc, paramObject.bEc)));
    return false;
  }
  
  public int hashCode()
  {
    if (this.aHQ == 0) {
      this.aHQ = (System.identityHashCode(this.bEb) * 31 + Arrays.hashCode(this.bEc));
    }
    return this.aHQ;
  }
  
  public final int indexOf(int paramInt)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.bEc[i] == paramInt) {
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
      if (this.bwC[i] == paramFormat) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected final boolean k(int paramInt, long paramLong)
  {
    return this.bEd[paramInt] > paramLong;
  }
  
  public final int length()
  {
    return this.bEc.length;
  }
  
  public final o wt()
  {
    return this.bEb;
  }
  
  public final Format wu()
  {
    return this.bwC[getSelectedIndex()];
  }
  
  public final int wv()
  {
    return this.bEc[getSelectedIndex()];
  }
  
  static final class a
    implements Comparator<Format>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.g.b
 * JD-Core Version:    0.7.0.1
 */