package com.google.android.exoplayer2.f.f;

import com.google.android.exoplayer2.f.d;
import java.util.Collections;
import java.util.List;

final class b
  implements d
{
  public static final b aPD = new b();
  private final List<com.google.android.exoplayer2.f.a> aMM;
  
  private b()
  {
    this.aMM = Collections.emptyList();
  }
  
  public b(com.google.android.exoplayer2.f.a parama)
  {
    this.aMM = Collections.singletonList(parama);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.f.f.b
 * JD-Core Version:    0.7.0.1
 */