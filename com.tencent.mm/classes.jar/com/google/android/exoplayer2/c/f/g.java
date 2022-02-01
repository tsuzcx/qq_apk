package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class g
  implements h
{
  private int bjK;
  private final List<v.a> bqI;
  private final com.google.android.exoplayer2.c.m[] bqJ;
  private boolean bqK;
  private int bqL;
  private long bqM;
  
  public g(List<v.a> paramList)
  {
    AppMethodBeat.i(92228);
    this.bqI = paramList;
    this.bqJ = new com.google.android.exoplayer2.c.m[paramList.size()];
    AppMethodBeat.o(92228);
  }
  
  private boolean e(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    AppMethodBeat.i(92232);
    if (paramm.xd() == 0)
    {
      AppMethodBeat.o(92232);
      return false;
    }
    if (paramm.readUnsignedByte() != paramInt) {
      this.bqK = false;
    }
    this.bqL -= 1;
    boolean bool = this.bqK;
    AppMethodBeat.o(92232);
    return bool;
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg, v.d paramd)
  {
    AppMethodBeat.i(92229);
    int i = 0;
    while (i < this.bqJ.length)
    {
      v.a locala = (v.a)this.bqI.get(i);
      paramd.uW();
      com.google.android.exoplayer2.c.m localm = paramg.dV(paramd.getTrackId());
      localm.f(Format.a(paramd.uX(), "application/dvbsubs", Collections.singletonList(locala.bsJ), locala.language, null));
      this.bqJ[i] = localm;
      i += 1;
    }
    AppMethodBeat.o(92229);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.bqK = true;
    this.bqM = paramLong;
    this.bjK = 0;
    this.bqL = 2;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    int i = 0;
    AppMethodBeat.i(92231);
    if (this.bqK)
    {
      if ((this.bqL == 2) && (!e(paramm, 32)))
      {
        AppMethodBeat.o(92231);
        return;
      }
      if ((this.bqL == 1) && (!e(paramm, 0)))
      {
        AppMethodBeat.o(92231);
        return;
      }
      int j = paramm.position;
      int k = paramm.xd();
      com.google.android.exoplayer2.c.m[] arrayOfm = this.bqJ;
      int m = arrayOfm.length;
      while (i < m)
      {
        com.google.android.exoplayer2.c.m localm = arrayOfm[i];
        paramm.setPosition(j);
        localm.a(paramm, k);
        i += 1;
      }
      this.bjK += k;
    }
    AppMethodBeat.o(92231);
  }
  
  public final void uK()
  {
    this.bqK = false;
  }
  
  public final void uL()
  {
    AppMethodBeat.i(92230);
    if (this.bqK)
    {
      com.google.android.exoplayer2.c.m[] arrayOfm = this.bqJ;
      int j = arrayOfm.length;
      int i = 0;
      while (i < j)
      {
        arrayOfm[i].a(this.bqM, 1, this.bjK, 0, null);
        i += 1;
      }
      this.bqK = false;
    }
    AppMethodBeat.o(92230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.g
 * JD-Core Version:    0.7.0.1
 */