package com.tencent.mm.g;

import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends e
{
  public int evg = 0;
  public String hQX;
  public CdnLogic.BatchSnsReqImageData[] lwB;
  public int lwI;
  public int lwJ;
  public volatile boolean lwK = false;
  
  public final boolean aLI()
  {
    return this.lwJ == this.evg;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(120677);
    String str = String.format("feedId: %s, count:%d", new Object[] { this.hQX, Integer.valueOf(this.lwJ) });
    AppMethodBeat.o(120677);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.f
 * JD-Core Version:    0.7.0.1
 */