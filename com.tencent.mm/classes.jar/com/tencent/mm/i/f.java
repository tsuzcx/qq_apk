package com.tencent.mm.i;

import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends e
{
  public int cpF = 0;
  public String dAg;
  public CdnLogic.BatchSnsReqImageData[] fLb;
  public int fLi;
  public int fLj;
  public volatile boolean fLk = false;
  
  public final boolean Ya()
  {
    return this.fLj == this.cpF;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(120677);
    String str = String.format("feedId: %s, count:%d", new Object[] { this.dAg, Integer.valueOf(this.fLj) });
    AppMethodBeat.o(120677);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.i.f
 * JD-Core Version:    0.7.0.1
 */