package com.tencent.mm.i;

import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends e
{
  public String dpC;
  public int fnD;
  public int fnE;
  public int fnF = 0;
  public volatile boolean fnG = false;
  public CdnLogic.BatchSnsReqImageData[] fnw;
  
  public final boolean UE()
  {
    return this.fnE == this.fnF;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(120677);
    String str = String.format("feedId: %s, count:%d", new Object[] { this.dpC, Integer.valueOf(this.fnE) });
    AppMethodBeat.o(120677);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.i.f
 * JD-Core Version:    0.7.0.1
 */