package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.source.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends b
{
  private final d bDS;
  private final int bDT;
  private final long bDU;
  private final long bDV;
  private final long bDW;
  private final float bDX;
  private int bxN;
  private int reason;
  
  public a(o paramo, int[] paramArrayOfInt, d paramd, int paramInt, long paramLong1, long paramLong2, long paramLong3, float paramFloat)
  {
    super(paramo, paramArrayOfInt);
    AppMethodBeat.i(92926);
    this.bDS = paramd;
    this.bDT = paramInt;
    this.bDU = (1000L * paramLong1);
    this.bDV = (1000L * paramLong2);
    this.bDW = (1000L * paramLong3);
    this.bDX = paramFloat;
    this.bxN = ak(-9223372036854775808L);
    this.reason = 1;
    AppMethodBeat.o(92926);
  }
  
  private int ak(long paramLong)
  {
    AppMethodBeat.i(92928);
    long l = this.bDS.wz();
    if (l == -1L) {}
    int i;
    for (l = this.bDT;; l = ((float)l * this.bDX))
    {
      i = 0;
      j = 0;
      if (i >= this.length) {
        break label109;
      }
      if ((paramLong != -9223372036854775808L) && (k(i, paramLong))) {
        break label117;
      }
      if (this.bwC[i].bitrate > l) {
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
  
  public final void af(long paramLong)
  {
    AppMethodBeat.i(92927);
    long l = SystemClock.elapsedRealtime();
    int i = this.bxN;
    this.bxN = ak(l);
    if (this.bxN == i)
    {
      AppMethodBeat.o(92927);
      return;
    }
    Format localFormat1;
    Format localFormat2;
    if (!k(i, l))
    {
      localFormat1 = this.bwC[i];
      int j = this.bxN;
      localFormat2 = this.bwC[j];
      if ((localFormat2.bitrate <= localFormat1.bitrate) || (paramLong >= this.bDU)) {
        break label118;
      }
    }
    for (this.bxN = i;; this.bxN = i) {
      label118:
      do
      {
        if (this.bxN != i) {
          this.reason = 3;
        }
        AppMethodBeat.o(92927);
        return;
      } while ((localFormat2.bitrate >= localFormat1.bitrate) || (paramLong < this.bDV));
    }
  }
  
  public final int getSelectedIndex()
  {
    return this.bxN;
  }
  
  public final int vK()
  {
    return this.reason;
  }
  
  public final Object vL()
  {
    return null;
  }
  
  public static final class a
    implements f.a
  {
    private final d bDS;
    private final int bDT;
    private final float bDX;
    private final int bDY;
    private final int bDZ;
    private final int bEa;
    
    public a(d paramd)
    {
      this(paramd, (byte)0);
    }
    
    private a(d paramd, byte paramByte)
    {
      this.bDS = paramd;
      this.bDT = 800000;
      this.bDY = 10000;
      this.bDZ = 25000;
      this.bEa = 25000;
      this.bDX = 0.75F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.g.a
 * JD-Core Version:    0.7.0.1
 */