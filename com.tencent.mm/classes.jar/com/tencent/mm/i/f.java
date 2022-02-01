package com.tencent.mm.i;

import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends e
{
  public String dnn;
  public CdnLogic.BatchSnsReqImageData[] fqQ;
  public int fqX;
  public int fqY;
  public int fqZ = 0;
  public volatile boolean fra = false;
  
  public final boolean Vz()
  {
    return this.fqY == this.fqZ;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(120677);
    String str = String.format("feedId: %s, count:%d", new Object[] { this.dnn, Integer.valueOf(this.fqY) });
    AppMethodBeat.o(120677);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.i.f
 * JD-Core Version:    0.7.0.1
 */