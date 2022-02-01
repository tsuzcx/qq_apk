package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class s
{
  private final List<Format> bqL;
  private final com.google.android.exoplayer2.c.m[] bqO;
  
  public s(List<Format> paramList)
  {
    AppMethodBeat.i(92282);
    this.bqL = paramList;
    this.bqO = new com.google.android.exoplayer2.c.m[paramList.size()];
    AppMethodBeat.o(92282);
  }
  
  public final void a(long paramLong, com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92284);
    com.google.android.exoplayer2.f.a.g.a(paramLong, paramm, this.bqO);
    AppMethodBeat.o(92284);
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg, v.d paramd)
  {
    AppMethodBeat.i(92283);
    int i = 0;
    if (i < this.bqO.length)
    {
      paramd.uR();
      com.google.android.exoplayer2.c.m localm = paramg.eb(paramd.getTrackId());
      Format localFormat = (Format)this.bqL.get(i);
      String str2 = localFormat.bdt;
      boolean bool;
      if (("application/cea-608".equals(str2)) || ("application/cea-708".equals(str2)))
      {
        bool = true;
        label77:
        a.checkArgument(bool, "Invalid closed caption mime type provided: ".concat(String.valueOf(str2)));
        if (localFormat.id == null) {
          break label157;
        }
      }
      label157:
      for (String str1 = localFormat.id;; str1 = paramd.uS())
      {
        localm.f(Format.a(str1, str2, localFormat.bdG, localFormat.language, localFormat.bdH));
        this.bqO[i] = localm;
        i += 1;
        break;
        bool = false;
        break label77;
      }
    }
    AppMethodBeat.o(92283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.s
 * JD-Core Version:    0.7.0.1
 */