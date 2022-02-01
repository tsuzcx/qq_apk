package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class g
  implements h
{
  private int aTo;
  private final List<v.a> bak;
  private final com.google.android.exoplayer2.c.m[] bal;
  private boolean bam;
  private int ban;
  private long bao;
  
  public g(List<v.a> paramList)
  {
    AppMethodBeat.i(92228);
    this.bak = paramList;
    this.bal = new com.google.android.exoplayer2.c.m[paramList.size()];
    AppMethodBeat.o(92228);
  }
  
  private boolean e(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    AppMethodBeat.i(92232);
    if (paramm.vg() == 0)
    {
      AppMethodBeat.o(92232);
      return false;
    }
    if (paramm.readUnsignedByte() != paramInt) {
      this.bam = false;
    }
    this.ban -= 1;
    boolean bool = this.bam;
    AppMethodBeat.o(92232);
    return bool;
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg, v.d paramd)
  {
    AppMethodBeat.i(92229);
    int i = 0;
    while (i < this.bal.length)
    {
      v.a locala = (v.a)this.bak.get(i);
      paramd.sR();
      com.google.android.exoplayer2.c.m localm = paramg.ej(paramd.getTrackId());
      localm.f(Format.a(paramd.sS(), "application/dvbsubs", Collections.singletonList(locala.bcl), locala.language, null));
      this.bal[i] = localm;
      i += 1;
    }
    AppMethodBeat.o(92229);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.bam = true;
    this.bao = paramLong;
    this.aTo = 0;
    this.ban = 2;
  }
  
  public final void sF()
  {
    this.bam = false;
  }
  
  public final void sG()
  {
    AppMethodBeat.i(92230);
    if (this.bam)
    {
      com.google.android.exoplayer2.c.m[] arrayOfm = this.bal;
      int j = arrayOfm.length;
      int i = 0;
      while (i < j)
      {
        arrayOfm[i].a(this.bao, 1, this.aTo, 0, null);
        i += 1;
      }
      this.bam = false;
    }
    AppMethodBeat.o(92230);
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    int i = 0;
    AppMethodBeat.i(92231);
    if (this.bam)
    {
      if ((this.ban == 2) && (!e(paramm, 32)))
      {
        AppMethodBeat.o(92231);
        return;
      }
      if ((this.ban == 1) && (!e(paramm, 0)))
      {
        AppMethodBeat.o(92231);
        return;
      }
      int j = paramm.position;
      int k = paramm.vg();
      com.google.android.exoplayer2.c.m[] arrayOfm = this.bal;
      int m = arrayOfm.length;
      while (i < m)
      {
        com.google.android.exoplayer2.c.m localm = arrayOfm[i];
        paramm.setPosition(j);
        localm.a(paramm, k);
        i += 1;
      }
      this.aTo += k;
    }
    AppMethodBeat.o(92231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.g
 * JD-Core Version:    0.7.0.1
 */