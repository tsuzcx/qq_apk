package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class g
  implements h
{
  private int aDo;
  private final List<v.a> aKn;
  private final com.google.android.exoplayer2.c.m[] aKo;
  private boolean aKp;
  private int aKq;
  private long aKr;
  
  public g(List<v.a> paramList)
  {
    AppMethodBeat.i(95106);
    this.aKn = paramList;
    this.aKo = new com.google.android.exoplayer2.c.m[paramList.size()];
    AppMethodBeat.o(95106);
  }
  
  private boolean e(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    AppMethodBeat.i(95110);
    if (paramm.qM() == 0)
    {
      AppMethodBeat.o(95110);
      return false;
    }
    if (paramm.readUnsignedByte() != paramInt) {
      this.aKp = false;
    }
    this.aKq -= 1;
    boolean bool = this.aKp;
    AppMethodBeat.o(95110);
    return bool;
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg, v.d paramd)
  {
    AppMethodBeat.i(95107);
    int i = 0;
    while (i < this.aKo.length)
    {
      v.a locala = (v.a)this.aKn.get(i);
      paramd.ox();
      com.google.android.exoplayer2.c.m localm = paramg.dm(paramd.oy());
      localm.f(Format.a(paramd.oz(), "application/dvbsubs", Collections.singletonList(locala.aMp), locala.axa, null));
      this.aKo[i] = localm;
      i += 1;
    }
    AppMethodBeat.o(95107);
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.aKp = true;
    this.aKr = paramLong;
    this.aDo = 0;
    this.aKq = 2;
  }
  
  public final void ol()
  {
    this.aKp = false;
  }
  
  public final void om()
  {
    AppMethodBeat.i(95108);
    if (this.aKp)
    {
      com.google.android.exoplayer2.c.m[] arrayOfm = this.aKo;
      int j = arrayOfm.length;
      int i = 0;
      while (i < j)
      {
        arrayOfm[i].a(this.aKr, 1, this.aDo, 0, null);
        i += 1;
      }
      this.aKp = false;
    }
    AppMethodBeat.o(95108);
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    int i = 0;
    AppMethodBeat.i(95109);
    if (this.aKp)
    {
      if ((this.aKq == 2) && (!e(paramm, 32)))
      {
        AppMethodBeat.o(95109);
        return;
      }
      if ((this.aKq == 1) && (!e(paramm, 0)))
      {
        AppMethodBeat.o(95109);
        return;
      }
      int j = paramm.position;
      int k = paramm.qM();
      com.google.android.exoplayer2.c.m[] arrayOfm = this.aKo;
      int m = arrayOfm.length;
      while (i < m)
      {
        com.google.android.exoplayer2.c.m localm = arrayOfm[i];
        paramm.setPosition(j);
        localm.a(paramm, k);
        i += 1;
      }
      this.aDo += k;
    }
    AppMethodBeat.o(95109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.g
 * JD-Core Version:    0.7.0.1
 */