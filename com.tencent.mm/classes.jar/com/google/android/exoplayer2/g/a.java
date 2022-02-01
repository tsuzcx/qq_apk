package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends b
{
  private int dbk;
  private final d dhp;
  private final int dhq;
  private final long dhr;
  private final long dhs;
  private final long dht;
  private final float dhu;
  private int reason;
  
  public a(q paramq, int[] paramArrayOfInt, d paramd, int paramInt, long paramLong1, long paramLong2, long paramLong3, float paramFloat)
  {
    super(paramq, paramArrayOfInt);
    AppMethodBeat.i(92926);
    this.dhp = paramd;
    this.dhq = paramInt;
    this.dhr = (1000L * paramLong1);
    this.dhs = (1000L * paramLong2);
    this.dht = (1000L * paramLong3);
    this.dhu = paramFloat;
    this.dbk = cB(-9223372036854775808L);
    this.reason = 1;
    AppMethodBeat.o(92926);
  }
  
  private int cB(long paramLong)
  {
    AppMethodBeat.i(92928);
    long l = this.dhp.Ui();
    if (l == -1L) {}
    int i;
    for (l = this.dhq;; l = ((float)l * this.dhu))
    {
      i = 0;
      j = 0;
      if (i >= this.length) {
        break label108;
      }
      if ((paramLong != -9223372036854775808L) && (l(i, paramLong))) {
        break label116;
      }
      if (iB(i).bitrate > l) {
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
  
  public final int Tq()
  {
    return this.reason;
  }
  
  public final Object Tr()
  {
    return null;
  }
  
  public final void cw(long paramLong)
  {
    AppMethodBeat.i(92927);
    long l = SystemClock.elapsedRealtime();
    int i = this.dbk;
    this.dbk = cB(l);
    if (this.dbk == i)
    {
      AppMethodBeat.o(92927);
      return;
    }
    Format localFormat1;
    Format localFormat2;
    if (!l(i, l))
    {
      localFormat1 = iB(i);
      localFormat2 = iB(this.dbk);
      if ((localFormat2.bitrate <= localFormat1.bitrate) || (paramLong >= this.dhr)) {
        break label112;
      }
    }
    for (this.dbk = i;; this.dbk = i) {
      label112:
      do
      {
        if (this.dbk != i) {
          this.reason = 3;
        }
        AppMethodBeat.o(92927);
        return;
      } while ((localFormat2.bitrate >= localFormat1.bitrate) || (paramLong < this.dhs));
    }
  }
  
  public final int getSelectedIndex()
  {
    return this.dbk;
  }
  
  public static final class a
    implements f.a
  {
    private final d dhp;
    private final int dhq;
    private final float dhu;
    private final int dhv;
    private final int dhw;
    private final int dhx;
    
    public a(d paramd)
    {
      this(paramd, (byte)0);
    }
    
    private a(d paramd, byte paramByte)
    {
      this.dhp = paramd;
      this.dhq = 800000;
      this.dhv = 10000;
      this.dhw = 25000;
      this.dhx = 25000;
      this.dhu = 0.75F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.g.a
 * JD-Core Version:    0.7.0.1
 */