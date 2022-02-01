package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class k
{
  public int resultCode;
  public j wTn;
  public h wWd;
  public a wXa;
  public List<m> wXb;
  
  public k(j paramj)
  {
    AppMethodBeat.i(131708);
    this.wXb = new ArrayList();
    this.wTn = paramj;
    AppMethodBeat.o(131708);
  }
  
  public final String toString()
  {
    int i = 0;
    AppMethodBeat.i(131709);
    int j = this.resultCode;
    if (this.wXb == null) {}
    for (;;)
    {
      String str = String.format("{resultCode: %d, resultSize: %d}", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      AppMethodBeat.o(131709);
      return str;
      i = this.wXb.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.k
 * JD-Core Version:    0.7.0.1
 */