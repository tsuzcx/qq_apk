package com.google.android.exoplayer2.c.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$a
  implements q
{
  private final l aMk;
  
  public u$a(u paramu)
  {
    AppMethodBeat.i(95166);
    this.aMk = new l(new byte[4]);
    AppMethodBeat.o(95166);
  }
  
  public final void a(com.google.android.exoplayer2.i.u paramu, g paramg, v.d paramd) {}
  
  public final void t(m paramm)
  {
    AppMethodBeat.i(95167);
    if (paramm.readUnsignedByte() != 0)
    {
      AppMethodBeat.o(95167);
      return;
    }
    paramm.en(7);
    int j = paramm.qM() / 4;
    int i = 0;
    if (i < j)
    {
      paramm.c(this.aMk, 4);
      int k = this.aMk.dD(16);
      this.aMk.dE(3);
      if (k == 0) {
        this.aMk.dE(13);
      }
      for (;;)
      {
        i += 1;
        break;
        k = this.aMk.dD(13);
        u.a(this.aMl).put(k, new r(new u.b(this.aMl, k)));
        u.b(this.aMl);
      }
    }
    if (u.c(this.aMl) != 2) {
      u.a(this.aMl).remove(0);
    }
    AppMethodBeat.o(95167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.u.a
 * JD-Core Version:    0.7.0.1
 */