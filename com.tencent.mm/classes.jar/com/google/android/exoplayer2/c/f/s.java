package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class s
{
  private final List<Format> aKl;
  private final com.google.android.exoplayer2.c.m[] aKo;
  
  public s(List<Format> paramList)
  {
    AppMethodBeat.i(95160);
    this.aKl = paramList;
    this.aKo = new com.google.android.exoplayer2.c.m[paramList.size()];
    AppMethodBeat.o(95160);
  }
  
  public final void a(long paramLong, com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(95162);
    com.google.android.exoplayer2.f.a.g.a(paramLong, paramm, this.aKo);
    AppMethodBeat.o(95162);
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg, v.d paramd)
  {
    AppMethodBeat.i(95161);
    int i = 0;
    if (i < this.aKo.length)
    {
      paramd.ox();
      com.google.android.exoplayer2.c.m localm = paramg.dm(paramd.oy());
      Format localFormat = (Format)this.aKl.get(i);
      String str2 = localFormat.awK;
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
      for (String str1 = localFormat.id;; str1 = paramd.oz())
      {
        localm.f(Format.a(str1, str2, localFormat.awZ, localFormat.axa, localFormat.axb));
        this.aKo[i] = localm;
        i += 1;
        break;
        bool = false;
        break label77;
      }
    }
    AppMethodBeat.o(95161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.s
 * JD-Core Version:    0.7.0.1
 */