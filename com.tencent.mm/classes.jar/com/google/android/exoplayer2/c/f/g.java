package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class g
  implements h
{
  private int aZs;
  private final List<v.a> bgt;
  private final com.google.android.exoplayer2.c.m[] bgu;
  private boolean bgv;
  private int bgw;
  private long bgx;
  
  public g(List<v.a> paramList)
  {
    AppMethodBeat.i(92228);
    this.bgt = paramList;
    this.bgu = new com.google.android.exoplayer2.c.m[paramList.size()];
    AppMethodBeat.o(92228);
  }
  
  private boolean e(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    AppMethodBeat.i(92232);
    if (paramm.vy() == 0)
    {
      AppMethodBeat.o(92232);
      return false;
    }
    if (paramm.readUnsignedByte() != paramInt) {
      this.bgv = false;
    }
    this.bgw -= 1;
    boolean bool = this.bgv;
    AppMethodBeat.o(92232);
    return bool;
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg, v.d paramd)
  {
    AppMethodBeat.i(92229);
    int i = 0;
    while (i < this.bgu.length)
    {
      v.a locala = (v.a)this.bgt.get(i);
      paramd.ts();
      com.google.android.exoplayer2.c.m localm = paramg.dW(paramd.getTrackId());
      localm.f(Format.a(paramd.tt(), "application/dvbsubs", Collections.singletonList(locala.biu), locala.aTm, null));
      this.bgu[i] = localm;
      i += 1;
    }
    AppMethodBeat.o(92229);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.bgv = true;
    this.bgx = paramLong;
    this.aZs = 0;
    this.bgw = 2;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    int i = 0;
    AppMethodBeat.i(92231);
    if (this.bgv)
    {
      if ((this.bgw == 2) && (!e(paramm, 32)))
      {
        AppMethodBeat.o(92231);
        return;
      }
      if ((this.bgw == 1) && (!e(paramm, 0)))
      {
        AppMethodBeat.o(92231);
        return;
      }
      int j = paramm.position;
      int k = paramm.vy();
      com.google.android.exoplayer2.c.m[] arrayOfm = this.bgu;
      int m = arrayOfm.length;
      while (i < m)
      {
        com.google.android.exoplayer2.c.m localm = arrayOfm[i];
        paramm.setPosition(j);
        localm.a(paramm, k);
        i += 1;
      }
      this.aZs += k;
    }
    AppMethodBeat.o(92231);
  }
  
  public final void tg()
  {
    this.bgv = false;
  }
  
  public final void th()
  {
    AppMethodBeat.i(92230);
    if (this.bgv)
    {
      com.google.android.exoplayer2.c.m[] arrayOfm = this.bgu;
      int j = arrayOfm.length;
      int i = 0;
      while (i < j)
      {
        arrayOfm[i].a(this.bgx, 1, this.aZs, 0, null);
        i += 1;
      }
      this.bgv = false;
    }
    AppMethodBeat.o(92230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.g
 * JD-Core Version:    0.7.0.1
 */