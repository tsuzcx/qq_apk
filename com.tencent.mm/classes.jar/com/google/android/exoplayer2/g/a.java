package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends b
{
  private final d bDT;
  private final int bDU;
  private final long bDV;
  private final long bDW;
  private final long bDX;
  private final float bDY;
  private int bDZ;
  private int bxP;
  
  public a(q paramq, int[] paramArrayOfInt, d paramd, int paramInt, long paramLong1, long paramLong2, long paramLong3, float paramFloat)
  {
    super(paramq, paramArrayOfInt);
    AppMethodBeat.i(92926);
    this.bDT = paramd;
    this.bDU = paramInt;
    this.bDV = (1000L * paramLong1);
    this.bDW = (1000L * paramLong2);
    this.bDX = (1000L * paramLong3);
    this.bDY = paramFloat;
    this.bxP = ak(-9223372036854775808L);
    this.bDZ = 1;
    AppMethodBeat.o(92926);
  }
  
  private int ak(long paramLong)
  {
    AppMethodBeat.i(92928);
    long l = this.bDT.wE();
    if (l == -1L) {}
    int i;
    for (l = this.bDU;; l = ((float)l * this.bDY))
    {
      i = 0;
      j = 0;
      if (i >= this.length) {
        break label109;
      }
      if ((paramLong != -9223372036854775808L) && (l(i, paramLong))) {
        break label117;
      }
      if (this.bwD[i].bitrate > l) {
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
    int i = this.bxP;
    this.bxP = ak(l);
    if (this.bxP == i)
    {
      AppMethodBeat.o(92927);
      return;
    }
    Format localFormat1;
    Format localFormat2;
    if (!l(i, l))
    {
      localFormat1 = this.bwD[i];
      int j = this.bxP;
      localFormat2 = this.bwD[j];
      if ((localFormat2.bitrate <= localFormat1.bitrate) || (paramLong >= this.bDV)) {
        break label118;
      }
    }
    for (this.bxP = i;; this.bxP = i) {
      label118:
      do
      {
        if (this.bxP != i) {
          this.bDZ = 3;
        }
        AppMethodBeat.o(92927);
        return;
      } while ((localFormat2.bitrate >= localFormat1.bitrate) || (paramLong < this.bDW));
    }
  }
  
  public final int getSelectedIndex()
  {
    return this.bxP;
  }
  
  public final int vP()
  {
    return this.bDZ;
  }
  
  public final Object vQ()
  {
    return null;
  }
  
  public static final class a
    implements f.a
  {
    private final d bDT;
    private final int bDU;
    private final float bDY;
    private final int bEa;
    private final int bEb;
    private final int bEc;
    
    public a(d paramd)
    {
      this(paramd, (byte)0);
    }
    
    private a(d paramd, byte paramByte)
    {
      this.bDT = paramd;
      this.bDU = 800000;
      this.bEa = 10000;
      this.bEb = 25000;
      this.bEc = 25000;
      this.bDY = 0.75F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.g.a
 * JD-Core Version:    0.7.0.1
 */