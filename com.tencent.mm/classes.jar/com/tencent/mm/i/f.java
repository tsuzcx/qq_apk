package com.tencent.mm.i;

import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends e
{
  public int cCC = 0;
  public String fLp;
  public int iUD;
  public int iUE;
  public volatile boolean iUF = false;
  public CdnLogic.BatchSnsReqImageData[] iUw;
  
  public final boolean arM()
  {
    return this.iUE == this.cCC;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(120677);
    String str = String.format("feedId: %s, count:%d", new Object[] { this.fLp, Integer.valueOf(this.iUE) });
    AppMethodBeat.o(120677);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.i.f
 * JD-Core Version:    0.7.0.1
 */