package com.tencent.mm.i;

import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends e
{
  public int counter = 0;
  public String czw;
  public CdnLogic.BatchSnsReqImageData[] ede;
  public int edm;
  public int edn;
  public volatile boolean edo = false;
  
  public final boolean Jo()
  {
    return this.edn == this.counter;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(128596);
    String str = String.format("feedId: %s, count:%d", new Object[] { this.czw, Integer.valueOf(this.edn) });
    AppMethodBeat.o(128596);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.i.f
 * JD-Core Version:    0.7.0.1
 */