package com.google.android.exoplayer2.c.g;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class g
  implements h
{
  private int aYG;
  private final List<v.a> bfM;
  private final com.google.android.exoplayer2.c.m[] bfN;
  private boolean bfO;
  private int bfP;
  private long bfQ;
  
  public g(List<v.a> paramList)
  {
    AppMethodBeat.i(92228);
    this.bfM = paramList;
    this.bfN = new com.google.android.exoplayer2.c.m[paramList.size()];
    AppMethodBeat.o(92228);
  }
  
  private boolean e(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    AppMethodBeat.i(92232);
    if (paramm.vJ() == 0)
    {
      AppMethodBeat.o(92232);
      return false;
    }
    if (paramm.readUnsignedByte() != paramInt) {
      this.bfO = false;
    }
    this.bfP -= 1;
    boolean bool = this.bfO;
    AppMethodBeat.o(92232);
    return bool;
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg, v.d paramd)
  {
    AppMethodBeat.i(92229);
    int i = 0;
    while (i < this.bfN.length)
    {
      v.a locala = (v.a)this.bfM.get(i);
      paramd.tj();
      com.google.android.exoplayer2.c.m localm = paramg.bh(paramd.getTrackId(), 3);
      localm.f(Format.a(paramd.tl(), "application/dvbsubs", Collections.singletonList(locala.bhO), locala.aSt, null));
      this.bfN[i] = localm;
      i += 1;
    }
    AppMethodBeat.o(92229);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.bfO = true;
    this.bfQ = paramLong;
    this.aYG = 0;
    this.bfP = 2;
  }
  
  public final void sX()
  {
    this.bfO = false;
  }
  
  public final void sY()
  {
    AppMethodBeat.i(92230);
    if (this.bfO)
    {
      com.google.android.exoplayer2.c.m[] arrayOfm = this.bfN;
      int j = arrayOfm.length;
      int i = 0;
      while (i < j)
      {
        arrayOfm[i].a(this.bfQ, 1, this.aYG, 0, null);
        i += 1;
      }
      this.bfO = false;
    }
    AppMethodBeat.o(92230);
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    int i = 0;
    AppMethodBeat.i(92231);
    if (this.bfO)
    {
      if ((this.bfP == 2) && (!e(paramm, 32)))
      {
        AppMethodBeat.o(92231);
        return;
      }
      if ((this.bfP == 1) && (!e(paramm, 0)))
      {
        AppMethodBeat.o(92231);
        return;
      }
      int j = paramm.position;
      int k = paramm.vJ();
      com.google.android.exoplayer2.c.m[] arrayOfm = this.bfN;
      int m = arrayOfm.length;
      while (i < m)
      {
        com.google.android.exoplayer2.c.m localm = arrayOfm[i];
        paramm.setPosition(j);
        localm.a(paramm, k);
        i += 1;
      }
      this.aYG += k;
    }
    AppMethodBeat.o(92231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.g
 * JD-Core Version:    0.7.0.1
 */