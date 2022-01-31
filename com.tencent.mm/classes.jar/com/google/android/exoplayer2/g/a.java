package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.source.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends b
{
  private int aRn;
  private final d aXA;
  private final int aXB;
  private final long aXC;
  private final long aXD;
  private final long aXE;
  private final float aXF;
  private int aXG;
  
  public a(o paramo, int[] paramArrayOfInt, d paramd, int paramInt, long paramLong1, long paramLong2, long paramLong3, float paramFloat)
  {
    super(paramo, paramArrayOfInt);
    AppMethodBeat.i(95758);
    this.aXA = paramd;
    this.aXB = paramInt;
    this.aXC = (1000L * paramLong1);
    this.aXD = (1000L * paramLong2);
    this.aXE = (1000L * paramLong3);
    this.aXF = paramFloat;
    this.aRn = ad(-9223372036854775808L);
    this.aXG = 1;
    AppMethodBeat.o(95758);
  }
  
  private int ad(long paramLong)
  {
    AppMethodBeat.i(95760);
    long l = this.aXA.qm();
    if (l == -1L) {}
    int i;
    for (l = this.aXB;; l = ((float)l * this.aXF))
    {
      i = 0;
      j = 0;
      if (i >= this.length) {
        break label109;
      }
      if ((paramLong != -9223372036854775808L) && (k(i, paramLong))) {
        break label117;
      }
      if (this.aQc[i].bitrate > l) {
        break;
      }
      AppMethodBeat.o(95760);
      return i;
    }
    int j = i;
    label109:
    label117:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(95760);
      return j;
    }
  }
  
  public final void Y(long paramLong)
  {
    AppMethodBeat.i(95759);
    long l = SystemClock.elapsedRealtime();
    int i = this.aRn;
    this.aRn = ad(l);
    if (this.aRn == i)
    {
      AppMethodBeat.o(95759);
      return;
    }
    Format localFormat1;
    Format localFormat2;
    if (!k(i, l))
    {
      localFormat1 = this.aQc[i];
      int j = this.aRn;
      localFormat2 = this.aQc[j];
      if ((localFormat2.bitrate <= localFormat1.bitrate) || (paramLong >= this.aXC)) {
        break label118;
      }
    }
    for (this.aRn = i;; this.aRn = i) {
      label118:
      do
      {
        if (this.aRn != i) {
          this.aXG = 3;
        }
        AppMethodBeat.o(95759);
        return;
      } while ((localFormat2.bitrate >= localFormat1.bitrate) || (paramLong < this.aXD));
    }
  }
  
  public final int pv()
  {
    return this.aRn;
  }
  
  public final int pw()
  {
    return this.aXG;
  }
  
  public final Object px()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.g.a
 * JD-Core Version:    0.7.0.1
 */