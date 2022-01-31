package com.google.android.exoplayer2.f.g;

import com.google.android.exoplayer2.f.d;
import java.util.Collections;
import java.util.List;

final class c
  implements d
{
  private final List<com.google.android.exoplayer2.f.a> aMM;
  
  public c(List<com.google.android.exoplayer2.f.a> paramList)
  {
    this.aMM = Collections.unmodifiableList(paramList);
  }
  
  public final int S(long paramLong)
  {
    if (paramLong < 0L) {
      return 0;
    }
    return -1;
  }
  
  public final List<com.google.android.exoplayer2.f.a> T(long paramLong)
  {
    if (paramLong >= 0L) {
      return this.aMM;
    }
    return Collections.emptyList();
  }
  
  public final long dn(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.aB(bool);
      return 0L;
    }
  }
  
  public final int nk()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g.c
 * JD-Core Version:    0.7.0.1
 */