package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class g
  implements h
{
  private int bjN;
  private final List<v.a> bqN;
  private final com.google.android.exoplayer2.c.m[] bqO;
  private boolean bqP;
  private int bqQ;
  private long bqR;
  
  public g(List<v.a> paramList)
  {
    AppMethodBeat.i(92228);
    this.bqN = paramList;
    this.bqO = new com.google.android.exoplayer2.c.m[paramList.size()];
    AppMethodBeat.o(92228);
  }
  
  private boolean e(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    AppMethodBeat.i(92232);
    if (paramm.wV() == 0)
    {
      AppMethodBeat.o(92232);
      return false;
    }
    if (paramm.readUnsignedByte() != paramInt) {
      this.bqP = false;
    }
    this.bqQ -= 1;
    boolean bool = this.bqP;
    AppMethodBeat.o(92232);
    return bool;
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg, v.d paramd)
  {
    AppMethodBeat.i(92229);
    int i = 0;
    while (i < this.bqO.length)
    {
      v.a locala = (v.a)this.bqN.get(i);
      paramd.uR();
      com.google.android.exoplayer2.c.m localm = paramg.eb(paramd.getTrackId());
      localm.f(Format.a(paramd.uS(), "application/dvbsubs", Collections.singletonList(locala.bsO), locala.language, null));
      this.bqO[i] = localm;
      i += 1;
    }
    AppMethodBeat.o(92229);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.bqP = true;
    this.bqR = paramLong;
    this.bjN = 0;
    this.bqQ = 2;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    int i = 0;
    AppMethodBeat.i(92231);
    if (this.bqP)
    {
      if ((this.bqQ == 2) && (!e(paramm, 32)))
      {
        AppMethodBeat.o(92231);
        return;
      }
      if ((this.bqQ == 1) && (!e(paramm, 0)))
      {
        AppMethodBeat.o(92231);
        return;
      }
      int j = paramm.position;
      int k = paramm.wV();
      com.google.android.exoplayer2.c.m[] arrayOfm = this.bqO;
      int m = arrayOfm.length;
      while (i < m)
      {
        com.google.android.exoplayer2.c.m localm = arrayOfm[i];
        paramm.setPosition(j);
        localm.a(paramm, k);
        i += 1;
      }
      this.bjN += k;
    }
    AppMethodBeat.o(92231);
  }
  
  public final void uF()
  {
    this.bqP = false;
  }
  
  public final void uG()
  {
    AppMethodBeat.i(92230);
    if (this.bqP)
    {
      com.google.android.exoplayer2.c.m[] arrayOfm = this.bqO;
      int j = arrayOfm.length;
      int i = 0;
      while (i < j)
      {
        arrayOfm[i].a(this.bqR, 1, this.bjN, 0, null);
        i += 1;
      }
      this.bqP = false;
    }
    AppMethodBeat.o(92230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.g
 * JD-Core Version:    0.7.0.1
 */