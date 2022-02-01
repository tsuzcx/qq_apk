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
  private int aFZ;
  final Format[] bmh;
  protected final o btL;
  protected final int[] btM;
  private final long[] btN;
  protected final int length;
  
  public b(o paramo, int... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.btL = ((o)a.checkNotNull(paramo));
      this.length = paramVarArgs.length;
      this.bmh = new Format[this.length];
      i = 0;
      while (i < paramVarArgs.length)
      {
        Format[] arrayOfFormat = this.bmh;
        int k = paramVarArgs[i];
        arrayOfFormat[i] = paramo.bmh[k];
        i += 1;
      }
    }
    Arrays.sort(this.bmh, new a((byte)0));
    this.btM = new int[this.length];
    int i = j;
    while (i < this.length)
    {
      this.btM[i] = paramo.j(this.bmh[i]);
      i += 1;
    }
    this.btN = new long[this.length];
  }
  
  public final Format eR(int paramInt)
  {
    return this.bmh[paramInt];
  }
  
  public final int eS(int paramInt)
  {
    return this.btM[paramInt];
  }
  
  public final boolean eT(int paramInt)
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
    long[] arrayOfLong = this.btN;
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
    } while ((this.btL == paramObject.btL) && (Arrays.equals(this.btM, paramObject.btM)));
    return false;
  }
  
  public int hashCode()
  {
    if (this.aFZ == 0) {
      this.aFZ = (System.identityHashCode(this.btL) * 31 + Arrays.hashCode(this.btM));
    }
    return this.aFZ;
  }
  
  public final int indexOf(int paramInt)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.btM[i] == paramInt) {
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
      if (this.bmh[i] == paramFormat) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected final boolean k(int paramInt, long paramLong)
  {
    return this.btN[paramInt] > paramLong;
  }
  
  public final int length()
  {
    return this.btM.length;
  }
  
  public final o uU()
  {
    return this.btL;
  }
  
  public final Format uV()
  {
    return this.bmh[getSelectedIndex()];
  }
  
  public final int uW()
  {
    return this.btM[getSelectedIndex()];
  }
  
  static final class a
    implements Comparator<Format>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.g.b
 * JD-Core Version:    0.7.0.1
 */