package com.tencent.mm.i;

import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends e
{
  public int cBY = 0;
  public String dRS;
  public CdnLogic.BatchSnsReqImageData[] gqo;
  public int gqv;
  public int gqw;
  public volatile boolean gqx = false;
  
  public final boolean alN()
  {
    return this.gqw == this.cBY;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(120677);
    String str = String.format("feedId: %s, count:%d", new Object[] { this.dRS, Integer.valueOf(this.gqw) });
    AppMethodBeat.o(120677);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.i.f
 * JD-Core Version:    0.7.0.1
 */