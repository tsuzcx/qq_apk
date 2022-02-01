package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class k
{
  public int bPH;
  public j suU;
  public h sxM;
  public a syJ;
  public List<m> syK;
  
  public k(j paramj)
  {
    AppMethodBeat.i(131708);
    this.syK = new ArrayList();
    this.suU = paramj;
    AppMethodBeat.o(131708);
  }
  
  public final String toString()
  {
    int i = 0;
    AppMethodBeat.i(131709);
    int j = this.bPH;
    if (this.syK == null) {}
    for (;;)
    {
      String str = String.format("{resultCode: %d, resultSize: %d}", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      AppMethodBeat.o(131709);
      return str;
      i = this.syK.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.k
 * JD-Core Version:    0.7.0.1
 */