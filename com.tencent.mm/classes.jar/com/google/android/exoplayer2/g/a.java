package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends b
{
  private int bhr;
  private int bnA;
  private final d bnu;
  private final int bnv;
  private final long bnw;
  private final long bnx;
  private final long bny;
  private final float bnz;
  
  public a(q paramq, int[] paramArrayOfInt, d paramd, int paramInt, long paramLong1, long paramLong2, long paramLong3, float paramFloat)
  {
    super(paramq, paramArrayOfInt);
    AppMethodBeat.i(92926);
    this.bnu = paramd;
    this.bnv = paramInt;
    this.bnw = (1000L * paramLong1);
    this.bnx = (1000L * paramLong2);
    this.bny = (1000L * paramLong3);
    this.bnz = paramFloat;
    this.bhr = an(-9223372036854775808L);
    this.bnA = 1;
    AppMethodBeat.o(92926);
  }
  
  private int an(long paramLong)
  {
    AppMethodBeat.i(92928);
    long l = this.bnu.uF();
    if (l == -1L) {}
    int i;
    for (l = this.bnv;; l = ((float)l * this.bnz))
    {
      i = 0;
      j = 0;
      if (i >= this.length) {
        break label108;
      }
      if ((paramLong != -9223372036854775808L) && (l(i, paramLong))) {
        break label116;
      }
      if (fm(i).bitrate > l) {
        break;
      }
      AppMethodBeat.o(92928);
      return i;
    }
    int j = i;
    label108:
    label116:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(92928);
      return j;
    }
  }
  
  public final void ai(long paramLong)
  {
    AppMethodBeat.i(92927);
    long l = SystemClock.elapsedRealtime();
    int i = this.bhr;
    this.bhr = an(l);
    if (this.bhr == i)
    {
      AppMethodBeat.o(92927);
      return;
    }
    Format localFormat1;
    Format localFormat2;
    if (!l(i, l))
    {
      localFormat1 = fm(i);
      localFormat2 = fm(this.bhr);
      if ((localFormat2.bitrate <= localFormat1.bitrate) || (paramLong >= this.bnw)) {
        break label112;
      }
    }
    for (this.bhr = i;; this.bhr = i) {
      label112:
      do
      {
        if (this.bhr != i) {
          this.bnA = 3;
        }
        AppMethodBeat.o(92927);
        return;
      } while ((localFormat2.bitrate >= localFormat1.bitrate) || (paramLong < this.bnx));
    }
  }
  
  public final int getSelectedIndex()
  {
    return this.bhr;
  }
  
  public final int tN()
  {
    return this.bnA;
  }
  
  public final Object tO()
  {
    return null;
  }
  
  public static final class a
    implements f.a
  {
    private final int bnB;
    private final int bnC;
    private final int bnD;
    private final d bnu;
    private final int bnv;
    private final float bnz;
    
    public a(d paramd)
    {
      this(paramd, (byte)0);
    }
    
    private a(d paramd, byte paramByte)
    {
      this.bnu = paramd;
      this.bnv = 800000;
      this.bnB = 10000;
      this.bnC = 25000;
      this.bnD = 25000;
      this.bnz = 0.75F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.g.a
 * JD-Core Version:    0.7.0.1
 */