package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class k
{
  public int bZU;
  public j tCm;
  public h tFe;
  public a tGb;
  public List<m> tGc;
  
  public k(j paramj)
  {
    AppMethodBeat.i(131708);
    this.tGc = new ArrayList();
    this.tCm = paramj;
    AppMethodBeat.o(131708);
  }
  
  public final String toString()
  {
    int i = 0;
    AppMethodBeat.i(131709);
    int j = this.bZU;
    if (this.tGc == null) {}
    for (;;)
    {
      String str = String.format("{resultCode: %d, resultSize: %d}", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      AppMethodBeat.o(131709);
      return str;
      i = this.tGc.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.k
 * JD-Core Version:    0.7.0.1
 */