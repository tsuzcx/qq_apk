package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.c;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
  extends c
{
  private volatile long tNP = 0L;
  private volatile boolean tNQ = false;
  public volatile String tNR;
  
  public i(int paramInt)
  {
    super(paramInt);
  }
  
  public final void afL(String paramString)
  {
    AppMethodBeat.i(321368);
    super.onForeground();
    this.tNP = 0L;
    if (paramString.startsWith("__wx__"))
    {
      this.tNQ = false;
      this.tNR = null;
    }
    AppMethodBeat.o(321368);
  }
  
  public final void afM(String paramString)
  {
    AppMethodBeat.i(321375);
    this.tNP = (Util.nowMilliSecond() - this.tPf.tOH.getStartTime());
    this.tNR = paramString;
    this.tNQ = true;
    AppMethodBeat.o(321375);
  }
  
  public final long cIw()
  {
    if (this.tNQ) {
      return this.tPf.tOL - this.tNP;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.i
 * JD-Core Version:    0.7.0.1
 */