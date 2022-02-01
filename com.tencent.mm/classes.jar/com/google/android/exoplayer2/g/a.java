package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.source.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends b
{
  private int bns;
  private final d btC;
  private final int btD;
  private final long btE;
  private final long btF;
  private final long btG;
  private final float btH;
  private int reason;
  
  public a(o paramo, int[] paramArrayOfInt, d paramd, int paramInt, long paramLong1, long paramLong2, long paramLong3, float paramFloat)
  {
    super(paramo, paramArrayOfInt);
    AppMethodBeat.i(92926);
    this.btC = paramd;
    this.btD = paramInt;
    this.btE = (1000L * paramLong1);
    this.btF = (1000L * paramLong2);
    this.btG = (1000L * paramLong3);
    this.btH = paramFloat;
    this.bns = ak(-9223372036854775808L);
    this.reason = 1;
    AppMethodBeat.o(92926);
  }
  
  private int ak(long paramLong)
  {
    AppMethodBeat.i(92928);
    long l = this.btC.va();
    if (l == -1L) {}
    int i;
    for (l = this.btD;; l = ((float)l * this.btH))
    {
      i = 0;
      j = 0;
      if (i >= this.length) {
        break label109;
      }
      if ((paramLong != -9223372036854775808L) && (k(i, paramLong))) {
        break label117;
      }
      if (this.bmh[i].bitrate > l) {
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
    int i = this.bns;
    this.bns = ak(l);
    if (this.bns == i)
    {
      AppMethodBeat.o(92927);
      return;
    }
    Format localFormat1;
    Format localFormat2;
    if (!k(i, l))
    {
      localFormat1 = this.bmh[i];
      int j = this.bns;
      localFormat2 = this.bmh[j];
      if ((localFormat2.bitrate <= localFormat1.bitrate) || (paramLong >= this.btE)) {
        break label118;
      }
    }
    for (this.bns = i;; this.bns = i) {
      label118:
      do
      {
        if (this.bns != i) {
          this.reason = 3;
        }
        AppMethodBeat.o(92927);
        return;
      } while ((localFormat2.bitrate >= localFormat1.bitrate) || (paramLong < this.btF));
    }
  }
  
  public final int getSelectedIndex()
  {
    return this.bns;
  }
  
  public final int ul()
  {
    return this.reason;
  }
  
  public final Object um()
  {
    return null;
  }
  
  public static final class a
    implements f.a
  {
    private final d btC;
    private final int btD;
    private final float btH;
    private final int btI;
    private final int btJ;
    private final int btK;
    
    public a(d paramd)
    {
      this(paramd, 800000, 10000, 25000, 0.75F);
    }
    
    public a(d paramd, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      this.btC = paramd;
      this.btD = paramInt1;
      this.btI = paramInt2;
      this.btJ = paramInt3;
      this.btK = 25000;
      this.btH = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.g.a
 * JD-Core Version:    0.7.0.1
 */