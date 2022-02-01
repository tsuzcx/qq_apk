package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class g
  implements h
{
  private int cNk;
  private final List<v.a> cUf;
  private final com.google.android.exoplayer2.c.m[] cUg;
  private boolean cUh;
  private int cUi;
  private long cUj;
  
  public g(List<v.a> paramList)
  {
    AppMethodBeat.i(92228);
    this.cUf = paramList;
    this.cUg = new com.google.android.exoplayer2.c.m[paramList.size()];
    AppMethodBeat.o(92228);
  }
  
  private boolean e(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    AppMethodBeat.i(92232);
    if (paramm.UF() == 0)
    {
      AppMethodBeat.o(92232);
      return false;
    }
    if (paramm.readUnsignedByte() != paramInt) {
      this.cUh = false;
    }
    this.cUi -= 1;
    boolean bool = this.cUh;
    AppMethodBeat.o(92232);
    return bool;
  }
  
  public final void Si()
  {
    this.cUh = false;
  }
  
  public final void Sj()
  {
    AppMethodBeat.i(92230);
    if (this.cUh)
    {
      com.google.android.exoplayer2.c.m[] arrayOfm = this.cUg;
      int j = arrayOfm.length;
      int i = 0;
      while (i < j)
      {
        arrayOfm[i].a(this.cUj, 1, this.cNk, 0, null);
        i += 1;
      }
      this.cUh = false;
    }
    AppMethodBeat.o(92230);
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg, v.d paramd)
  {
    AppMethodBeat.i(92229);
    int i = 0;
    while (i < this.cUg.length)
    {
      v.a locala = (v.a)this.cUf.get(i);
      paramd.Sv();
      com.google.android.exoplayer2.c.m localm = paramg.hz(paramd.getTrackId());
      localm.f(Format.a(paramd.Sw(), "application/dvbsubs", Collections.singletonList(locala.cWg), locala.language, null));
      this.cUg[i] = localm;
      i += 1;
    }
    AppMethodBeat.o(92229);
  }
  
  public final void h(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.cUh = true;
    this.cUj = paramLong;
    this.cNk = 0;
    this.cUi = 2;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    int i = 0;
    AppMethodBeat.i(92231);
    if (this.cUh)
    {
      if ((this.cUi == 2) && (!e(paramm, 32)))
      {
        AppMethodBeat.o(92231);
        return;
      }
      if ((this.cUi == 1) && (!e(paramm, 0)))
      {
        AppMethodBeat.o(92231);
        return;
      }
      int j = paramm.position;
      int k = paramm.UF();
      com.google.android.exoplayer2.c.m[] arrayOfm = this.cUg;
      int m = arrayOfm.length;
      while (i < m)
      {
        com.google.android.exoplayer2.c.m localm = arrayOfm[i];
        paramm.setPosition(j);
        localm.a(paramm, k);
        i += 1;
      }
      this.cNk += k;
    }
    AppMethodBeat.o(92231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.g
 * JD-Core Version:    0.7.0.1
 */