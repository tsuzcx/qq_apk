package com.google.android.exoplayer2.f.c;

import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.t;
import java.util.Collections;
import java.util.List;

final class b
  implements d
{
  private final com.google.android.exoplayer2.f.a[] aOM;
  private final long[] aON;
  
  public b(com.google.android.exoplayer2.f.a[] paramArrayOfa, long[] paramArrayOfLong)
  {
    this.aOM = paramArrayOfa;
    this.aON = paramArrayOfLong;
  }
  
  public final int S(long paramLong)
  {
    int i = t.a(this.aON, paramLong);
    if (i < this.aON.length) {
      return i;
    }
    return -1;
  }
  
  public final List<com.google.android.exoplayer2.f.a> T(long paramLong)
  {
    int i = t.a(this.aON, paramLong, false);
    if ((i == -1) || (this.aOM[i] == null)) {
      return Collections.emptyList();
    }
    return Collections.singletonList(this.aOM[i]);
  }
  
  public final long dn(int paramInt)
  {
    boolean bool2 = true;
    if (paramInt >= 0)
    {
      bool1 = true;
      com.google.android.exoplayer2.i.a.aB(bool1);
      if (paramInt >= this.aON.length) {
        break label39;
      }
    }
    label39:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.aB(bool1);
      return this.aON[paramInt];
      bool1 = false;
      break;
    }
  }
  
  public final int nk()
  {
    return this.aON.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.c.b
 * JD-Core Version:    0.7.0.1
 */