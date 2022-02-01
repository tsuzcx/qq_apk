package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.source.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends b
{
  private int boX;
  private final d bvD;
  private final int bvE;
  private final long bvF;
  private final long bvG;
  private final long bvH;
  private final float bvI;
  private int bvJ;
  
  public a(p paramp, int[] paramArrayOfInt, d paramd, int paramInt, long paramLong1, long paramLong2, long paramLong3, float paramFloat)
  {
    super(paramp, paramArrayOfInt);
    AppMethodBeat.i(92926);
    this.bvD = paramd;
    this.bvE = paramInt;
    this.bvF = (1000L * paramLong1);
    this.bvG = (1000L * paramLong2);
    this.bvH = (1000L * paramLong3);
    this.bvI = paramFloat;
    this.boX = ao(-9223372036854775808L);
    this.bvJ = 1;
    AppMethodBeat.o(92926);
  }
  
  private int ao(long paramLong)
  {
    AppMethodBeat.i(92928);
    long l = this.bvD.vg();
    if (l == -1L) {}
    int i;
    for (l = this.bvE;; l = ((float)l * this.bvI))
    {
      i = 0;
      j = 0;
      if (i >= this.length) {
        break label109;
      }
      if ((paramLong != -9223372036854775808L) && (l(i, paramLong))) {
        break label117;
      }
      if (this.blC[i].bitrate > l) {
        break;
      }
      AppMethodBeat.o(92928);
      return i;
    }
    int j = i;
    label109:
    label117:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(92928);
      return j;
    }
  }
  
  public final void aj(long paramLong)
  {
    AppMethodBeat.i(92927);
    long l = SystemClock.elapsedRealtime();
    int i = this.boX;
    this.boX = ao(l);
    if (this.boX == i)
    {
      AppMethodBeat.o(92927);
      return;
    }
    Format localFormat1;
    Format localFormat2;
    if (!l(i, l))
    {
      localFormat1 = this.blC[i];
      int j = this.boX;
      localFormat2 = this.blC[j];
      if ((localFormat2.bitrate <= localFormat1.bitrate) || (paramLong >= this.bvF)) {
        break label118;
      }
    }
    for (this.boX = i;; this.boX = i) {
      label118:
      do
      {
        if (this.boX != i) {
          this.bvJ = 3;
        }
        AppMethodBeat.o(92927);
        return;
      } while ((localFormat2.bitrate >= localFormat1.bitrate) || (paramLong < this.bvG));
    }
  }
  
  public final int getSelectedIndex()
  {
    return this.boX;
  }
  
  public final int up()
  {
    return this.bvJ;
  }
  
  public final Object uq()
  {
    return null;
  }
  
  public static final class a
    implements f.a
  {
    private final d bvD;
    private final int bvE;
    private final float bvI;
    private final int bvK;
    private final int bvL;
    private final int bvM;
    
    public a(d paramd)
    {
      this(paramd, 800000, 10000, 25000, 0.75F);
    }
    
    public a(d paramd, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      this.bvD = paramd;
      this.bvE = paramInt1;
      this.bvK = paramInt2;
      this.bvL = paramInt3;
      this.bvM = 25000;
      this.bvI = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.g.a
 * JD-Core Version:    0.7.0.1
 */