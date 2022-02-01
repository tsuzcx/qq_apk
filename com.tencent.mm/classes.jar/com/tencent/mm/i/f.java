package com.tencent.mm.i;

import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends e
{
  public String dzb;
  public CdnLogic.BatchSnsReqImageData[] fIX;
  public int fJe;
  public int fJf;
  public int fJg = 0;
  public volatile boolean fJh = false;
  
  public final boolean XQ()
  {
    return this.fJf == this.fJg;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(120677);
    String str = String.format("feedId: %s, count:%d", new Object[] { this.dzb, Integer.valueOf(this.fJf) });
    AppMethodBeat.o(120677);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.i.f
 * JD-Core Version:    0.7.0.1
 */