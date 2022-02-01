package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class m
{
  public j FWt;
  public l HpM;
  public c HtE;
  public List<o> HtF;
  public int resultCode;
  
  public m(l paraml)
  {
    AppMethodBeat.i(131708);
    this.HtF = new ArrayList();
    this.HpM = paraml;
    AppMethodBeat.o(131708);
  }
  
  public final String toString()
  {
    int i = 0;
    AppMethodBeat.i(131709);
    int j = this.resultCode;
    if (this.HtF == null) {}
    for (;;)
    {
      String str = String.format("{resultCode: %d, resultSize: %d}", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      AppMethodBeat.o(131709);
      return str;
      i = this.HtF.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.m
 * JD-Core Version:    0.7.0.1
 */