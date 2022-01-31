package com.google.android.exoplayer2.source.b;

import android.os.SystemClock;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.source.l;

final class c$c
  extends a
{
  private int aJH;
  
  public c$c(l paraml, int[] paramArrayOfInt)
  {
    super(paraml, paramArrayOfInt);
    paraml = paraml.aIs[0];
    if (i < this.length) {
      if (this.aIs[i] != paraml) {}
    }
    for (;;)
    {
      this.aJH = i;
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void mV()
  {
    long l = SystemClock.elapsedRealtime();
    if (!g(this.aJH, l)) {
      return;
    }
    int i = this.length - 1;
    while (i >= 0)
    {
      if (!g(i, l))
      {
        this.aJH = i;
        return;
      }
      i -= 1;
    }
    throw new IllegalStateException();
  }
  
  public final int mW()
  {
    return this.aJH;
  }
  
  public final int mX()
  {
    return 0;
  }
  
  public final Object mY()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.c.c
 * JD-Core Version:    0.7.0.1
 */